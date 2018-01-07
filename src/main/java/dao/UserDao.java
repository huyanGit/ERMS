package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /**
     * 加入员工
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 加入多个员工
     * @param users
     */
    void addUsers(ArrayList<User> users);

    User getUserById(String id);

    /**
     * 获取指定部门的员工
     * @param dpart_id
     * @return
     */
    ArrayList getUsersByDepart(String dpart_id);

    /**
     * 获取指定数量的员工
     * @param size
     * @return
     */
    ArrayList<User> getUsersBySize(int size);

    /**
     * 删除指定条件的员工
     * @param filter
     * @param filterValue
     * @param preUser
     * @return
     */
    boolean deleteUser(String filter, Object filterValue, User preUser);

    /**
     * 根据指定条件更新员工
     * @param filter
     * @param filterValue
     * @param preUser
     * @return
     */
    boolean UpdateUser(String filter,Object filterValue,User preUser);
}
