package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private String jobNum; //主键
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String IDNum;
    private Date entryTime; //入职时间
    private char workStatus;
    private String sex;
    private Date birthday;
    private String pltStatus; //政治面貌
    private String nation;
    private String photos;
    private String department;
    private String job; //岗位
    private String gradSchool;
    private String eduDegree;//教育程度
    private String specialty; //专业 对应major
    private String marital; //婚姻
    private Date contractStart; //婚姻
    private Date contractEnd; //婚姻
    private String password;
    private String role;
    private String depart_id;

    public User() {
        super();
    }


}
