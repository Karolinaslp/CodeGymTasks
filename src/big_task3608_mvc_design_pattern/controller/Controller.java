package big_task3608_mvc_design_pattern.controller;

import big_task3608_mvc_design_pattern.model.Model;
import big_task3608_mvc_design_pattern.view.EditUserView;
import big_task3608_mvc_design_pattern.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getDataModel());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getDataModel());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getDataModel());
    }

    public void onDeleteUser(long id) {
        model.deleteUserById(id);
        usersView.refresh(model.getDataModel());
    }

    public void onChangeUserData(String name, long id, int level) {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getDataModel());
    }
}

