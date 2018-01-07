package service.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserService implements service.UserService {
    @Autowired
    UserDao userDao;

    public ArrayList<User> getUsers(int size, String userId) {
        return null;
    }

    public User getDesignatedUser(String userId) {
        return null;
    }
}
