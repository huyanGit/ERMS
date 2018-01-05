package Emums;

public class DictEnum {
    public static class UserSQL{
        public static final  String insertUser = "INSERT into userinfo(jobNum,name,phoneNumber,email,address,IDNum," +
                "entryTime,workstatus,sex,birthday,ptlStutus,nation,faceUrl,department,post," +
                "gradSchool,eduDegree,specialty) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

//        SELECT  *FROM userinfo WHERE jobNum  = 20180105012
        public static final String selectUserByID = "SELECT * from userinfo WHERE jobNum =?";

    }

}
