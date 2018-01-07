package Emums;

public class DictEnum {
    public static class UserSQL {
        public static final String insertUser = "INSERT into userinfo(jobNum,name,phoneNumber,email,address,IDNum," +
                "entryTime,workstatus,sex,birthday,ptlStatus,nation,photos,department,job," +
                "gradSchool,eduDegree,specialty,marital,contractStart,contractEnd,password,role,depart_id) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //        SELECT  *FROM userinfo WHERE jobNum  = 20180105012
        public static final String selectUserByID = "SELECT * from userinfo WHERE jobNum =?";

    }

    public static class MapField {
        public static String status = "Status"; //状态
        public static String Describe = "describe"; //描述
        public static String token = "token"; //token
    }

    public static class ErrorCode {
        public static String ERROR_404NOTFOUND_ERROR = "404";   //404错误
        public static String ERROR_ATTRIBUTE_NULL = "502";      //字段为空错误
        public static String ERROR_TOKEN_ERROR = "503";         //令牌过期
        public static String ERROR_UNKNOWN = "501";             //未知错误
        public static String ERROR_METHOD_ERROR = "504";        //请求方式错
        public static String ERROR_NOACCOUNT_ERROR = "505";     //没有此用户
        public static String ERROR_PASSWORD_ERROR = "506";      //密码错误
        public static String ERROR_UPTATE_ERROR = "507";        //修改出错
        public static String ERROR_DELETE_ERROR = "508";        //删除错误
    }

}
