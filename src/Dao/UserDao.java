package Dao;

import DoMain.User;

public interface UserDao {
    public void saveUser(User user);
    public User findUserById(int id);
    public User findUserByName(String name);
    public void updateuser(User user);
    public void remove(User user);
}
