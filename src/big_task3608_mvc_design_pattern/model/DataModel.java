package big_task3608_mvc_design_pattern.model;

import big_task3608_mvc_design_pattern.bean.User;

import java.util.List;

public class DataModel {
    private User activeUser;
    private List<User> users;
    private boolean displayDeletedUserList;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}