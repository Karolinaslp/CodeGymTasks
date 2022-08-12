package big_task3608_mvc_design_pattern.model;


import big_task3608_mvc_design_pattern.bean.User;
import big_task3608_mvc_design_pattern.model.service.UserService;
import big_task3608_mvc_design_pattern.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    //use helpful service
    private UserService userService = new UserServiceImpl();
    //use special object to keep data for view rendering
    private DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        //refresh model data
        dataModel.setUsers(usersBetweenLevels);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        //refresh model data
        dataModel.setUsers(users);
    }
}
