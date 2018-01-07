package controller;

import Emums.DictEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.IJsonHelper;

import java.util.HashMap;

@Controller
public class ResourceNotFoundController {

    @RequestMapping(value = "/**")
    @ResponseBody
    public Object handleNotFound() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_404NOTFOUND_ERROR);
        jsonMap.put(DictEnum.MapField.Describe, "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.");
        return IJsonHelper.getGsonSerizeNull().toJson(jsonMap).toString();
    }

}
