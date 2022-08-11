package big_task3608_mvc_design_pattern.controller;

import big_task3608_mvc_design_pattern.model.Model;
import big_task3608_mvc_design_pattern.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getDataModel());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }
}
