package big_task3608_mvc_design_pattern.model;

import big_task3608_mvc_design_pattern.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {
    private DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        dataModel.setUsers(new ArrayList<>());
        dataModel.getUsers().add(new User("A", 1, 1));
        dataModel.getUsers().add(new User("B", 2, 1));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }
}

