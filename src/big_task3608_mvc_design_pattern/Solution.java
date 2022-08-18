package big_task3608_mvc_design_pattern;

import big_task3608_mvc_design_pattern.controller.Controller;
import big_task3608_mvc_design_pattern.model.MainModel;
import big_task3608_mvc_design_pattern.model.Model;
import big_task3608_mvc_design_pattern.view.EditUserView;
import big_task3608_mvc_design_pattern.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        //emulate user events
        usersView.fireShowAllUsersEvent();
        usersView.fireOpenUserEditFormEvent(126);
        editUserView.fireUserDeletedEvent(124L);
        editUserView.fireUserDataChangedEvent("NewName", 124L, 76);
        usersView.fireShowDeletedUsersEvent();
    }
}