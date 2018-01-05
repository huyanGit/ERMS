package controller;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.IJsonHelper;

import java.util.HashMap;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Object login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        HashMap<String, Object> responseMap = new HashMap<String, Object>();
        if (loginCheck(username, password) == true) {
            responseMap.put("token", "this is token");
            responseMap.put("code", "1");
        } else {
            responseMap.put("code", "error:404");
            responseMap.put("token", "");
        }
        return IJsonHelper.getGsonSerizeNull().toJson(responseMap);
    }

    // TODO: 2018/1/5 判断登录信息合理性 判断密码（）密码需要进行哈希编码
    private boolean loginCheck(String username, String password) {
        if (username != null && password != null) return false;
        return true;
    }
}
