package big_task3608_mvc_design_pattern.dao.mock;

import big_task3608_mvc_design_pattern.bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance() {
        return ourInstance;
    }

    private DataSource() {
    }

    private List<User> users = new LinkedList<User>() {{
        add(new User("Franklin", 123l, 1));
        add(new User("Sanchez", 124l, 2));
        add(new User("Sanchez", 125l, 1));
        add(new User("Smith", 126l, 2));
    }};

    private long maxUserId = 126l;

    public List<User> getUsers() {
        return users;
    }

    public User createOrUpdate(User newUser) {
        if (newUser == User.NULL_USER)
            return User.NULL_USER;

        // new User
        if (newUser.getId() == 0)
            return createNewUser(newUser);
        else
            return updateUser(newUser);
    }

    private User createNewUser(User newUser) {
        User clone = newUser.clone(++maxUserId);
        users.add(clone);
        return clone;
    }

    private User updateUser(User newUser) {
        for (User user : users) {
            if (user.getId() == newUser.getId()) {
                user.setName(newUser.getName());
                user.setLevel(newUser.getLevel());
                return user;
            }
        }
        // If we didn't find such a user
        return User.NULL_USER;
    }
}