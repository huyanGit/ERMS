package service.Impl;


import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



@Service
public class LoginService implements service.LoginService {

    @Autowired
    UserDao userDao;

    public void loginCheck(String username, String password) {

    }

    public int ConfineUser(String userId, String password) {
        User user = userDao.getUserById(userId);
        if (user == null) return 1;
        else if (!user.getPassword().equals(password)) return 2;
        return 0;
    }
}
