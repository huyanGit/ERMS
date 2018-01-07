package controller;


import com.google.gson.Gson;
import entity.User;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.IJsonHelper;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class UserController {
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllUser(@RequestParam("token") String token) {
        ArrayList<User> users = new ArrayList<User>();

        JSONArray jsonArray = JSONArray.fromObject(users);
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }

    @RequestMapping(value = "/gson", method = RequestMethod.GET)
    @ResponseBody
    public Object getUseByGson(@RequestParam("id") int id) {
        ArrayList<User> users = new ArrayList<User>();
        System.out.println("get id");
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("zhangsan");
            users.add(user);
        }
        HashMap<String, Object>item = new HashMap<String, Object>();
        item.put("totolNum",users.size());
        item.put("item",users);
        Gson gson = IJsonHelper.getGsonSerizeNull();
        return gson.toJson(item);
    }

}
