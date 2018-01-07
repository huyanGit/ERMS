package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 负责对dao 层的调用
 */
@Service("userService")
public interface UserService {

    public ArrayList<User> getUsers(int size,String userId);

    /**
     * 获取指定id的用户
     * @param userId
     * @return
     */
    public User getDesignatedUser(String userId);

}
