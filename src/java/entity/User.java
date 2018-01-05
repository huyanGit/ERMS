package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private String jobNumber; //主键
    private String username;
    private String phoneNumber;
    private String email;
    private String address;
    private String IDNum;
    private Date entryTime; //入职时间
    private char workStatus;
    private String sex;
    private Date birthday;
    private char pltStatus; //政治面貌
    private String nation;
    private String faceUrl;
    private String gradSchool;
    private String department;
    private String post; //岗位
    private String eduDegree;//教育程度
    private String major; //专业 对应major
    private String marital; //婚姻
    private Date contractStart; //婚姻
    private Date contractend; //婚姻
    private String password;
    private String role;

    public User() {
        super();
    }


}
