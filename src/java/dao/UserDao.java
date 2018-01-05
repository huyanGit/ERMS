package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {


    void addUsers(ArrayList<User> users);
    User getUserById(String id);
    User getUserByDepart(String usernmae, String password);
    List<User> getUsers();
    boolean deleteUserById(String id);
    boolean UpdateUser(User preUser);
}
