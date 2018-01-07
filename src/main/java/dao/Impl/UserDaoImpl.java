package dao.Impl;

import Emums.DictEnum;
import dao.UserDao;
import entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utils.dbHelper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbc = dbHelper.getJdbInstince();

    public void addUsers(final ArrayList<User> users) {
        String sql = DictEnum.UserSQL.insertUser;
        jdbc.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getJobNum());
                ps.setString(2, users.get(i).getName());
                ps.setString(3, users.get(i).getPhoneNumber());
                ps.setString(4, users.get(i).getEmail());
                ps.setString(5, users.get(i).getAddress());
                ps.setString(6, users.get(i).getIDNum());
                ps.setDate(7, new java.sql.Date(users.get(i).getEntryTime().getTime()));
                ps.setString(8, String.valueOf(users.get(i).getWorkStatus()));
                ps.setString(9, String.valueOf(users.get(i).getSex()));
                ps.setDate(10, new java.sql.Date(users.get(i).getBirthday().getTime()));
                ps.setString(11, String.valueOf(users.get(i).getPltStatus()));
                ps.setString(12, String.valueOf(users.get(i).getNation()));
                ps.setString(13, String.valueOf(users.get(i).getPhotos()));
                ps.setString(14, String.valueOf(users.get(i).getDepartment()));
                ps.setString(15, String.valueOf(users.get(i).getJob()));
                ps.setString(16, String.valueOf(users.get(i).getGradSchool()));
                ps.setString(17, String.valueOf(users.get(i).getEduDegree()));
                ps.setString(18, String.valueOf(users.get(i).getSpecialty()));
                ps.setString(19, String.valueOf(users.get(i).getMarital()));
                ps.setDate(20, new java.sql.Date(users.get(i).getContractStart().getTime()));
                ps.setDate(21, new java.sql.Date(users.get(i).getContractEnd().getTime()));
                ps.setString(22, String.valueOf(users.get(i).getPassword()));
                ps.setString(23,    String.valueOf(users.get(i).getRole()));
                ps.setString(24, String.valueOf(users.get(i).getDepart_id()));
            }

            public int getBatchSize() {
                return users.size();
            }
        });
    }


    public User getUserById(String jobNum) {
        User user = jdbc.queryForObject(DictEnum.UserSQL.selectUserByID, new Object[]{jobNum}, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(user.toString());
        return user;
    }

    public boolean addUser(User user) {
        return false;
    }

    public ArrayList getUsersByDepart(String dpart_id) {
        return null;
    }

    public ArrayList<User> getUsersBySize(int size) {
        return null;
    }

    public boolean deleteUser(String filter, Object filterValue, User preUser) {
        return false;
    }

    public boolean UpdateUser(String filter, Object filterValue, User preUser) {
        return false;
    }
}
