package big_task3608_mvc_design_pattern.view;

import big_task3608_mvc_design_pattern.bean.User;
import big_task3608_mvc_design_pattern.controller.Controller;
import big_task3608_mvc_design_pattern.model.DataModel;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {
        if (dataModel.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
        }
        for (User user : dataModel.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();
    }

    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }
}
