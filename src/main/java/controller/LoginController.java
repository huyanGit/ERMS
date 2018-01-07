package controller;


import Emums.DictEnum;
import entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.Impl.LoginService;
import utils.IJsonHelper;
import utils.JWT;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/employee/authorization")
    @ResponseBody
    public Object login(HttpServletRequest request,
                            @RequestParam(value = "jobNum", required = false) String jobNum,
                        @RequestParam(value = "password", required = false) String password) {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        if (!request.getMethod().equals("POST")) {
            jsonMap.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_METHOD_ERROR);
            jsonMap.put(DictEnum.MapField.Describe,"method error");
        } else {
            if (jobNum == null || password == null) {
                jsonMap.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_ATTRIBUTE_NULL);
                jsonMap.put(DictEnum.MapField.Describe,"filed can not be empty");
            }else{
                int status = loginService.ConfineUser(jobNum, password);
                if (status==0) {
                    Login login = new Login();
                    login.setPassword(password);
                    login.setUserID(jobNum);
                    String token = JWT.sign(login, 60L * 1000L * 30L);
                    jsonMap.put(DictEnum.MapField.token, token);
                } else if(status==1){
                    jsonMap.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_NOACCOUNT_ERROR);
                    jsonMap.put(DictEnum.MapField.Describe,"User does not exist");
                }else{
                    jsonMap.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_PASSWORD_ERROR);
                    jsonMap.put(DictEnum.MapField.Describe,"password error");
                }
            }
        }
        return IJsonHelper.getGsonSerizeNull().toJson(jsonMap).toString();
    }



    // TODO: 2018/1/6 测试完成后删除
    @RequestMapping(value = "/token")
    @ResponseBody
    public Object checkToken(HttpServletRequest request,
                             @RequestParam(value = "token") String token) {
        Login login = JWT.unsign(token, Login.class);
//        String loginId = request.getParameter("loginId");
        HashMap<String, Object> responseMap = new HashMap<String, Object>();
        if (login != null) {
            responseMap.put("login", login.getUserID());
            responseMap.put("loginID", login.getPassword());
        } else {
            responseMap.put("login", 1);
            responseMap.put("loginID", 2);
        }
        return IJsonHelper.getGsonSerizeNull().toJson(responseMap).toString();
    }

}
