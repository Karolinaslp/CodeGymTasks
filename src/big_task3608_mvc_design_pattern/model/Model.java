package big_task3608_mvc_design_pattern.model;

public interface Model {
    DataModel getDataModel();
    void loadUsers();
    public void loadDeletedUsers();
    public void loadUserById(long userId);
}