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
        List<User> users = getAllUsers();
        //refresh model data
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        //refresh model data
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = this.userService.getUsersById(userId);
        dataModel.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        List<User> users = getAllUsers();
        //refresh model data
        dataModel.setUsers(users);
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        List<User> users = getAllUsers();
        dataModel.setUsers(users);
    }

    private List<User> getAllUsers() {
        //model should contain all business logic in the methods
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }
}
