package big_task3608_mvc_design_pattern;

import big_task3608_mvc_design_pattern.controller.Controller;
import big_task3608_mvc_design_pattern.model.FakeModel;
import big_task3608_mvc_design_pattern.model.Model;
import big_task3608_mvc_design_pattern.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new FakeModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireShowAllUsersEvent();
    }
}
