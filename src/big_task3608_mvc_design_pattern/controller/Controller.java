package big_task3608_mvc_design_pattern.controller;

import big_task3608_mvc_design_pattern.model.Model;

public class Controller {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers() {
        model.loadUsers();
    }
}
