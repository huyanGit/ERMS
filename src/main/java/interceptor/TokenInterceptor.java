package interceptor;

import Emums.DictEnum;
import entity.Login;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.IJsonHelper;
import utils.JWT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

// TODO: 2018/1/6 添加错误状态
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setCharacterEncoding("utf-8");
        String token = httpServletRequest.getParameter("token");
        System.out.println(httpServletRequest.getMethod());
        if (null != token) {
            Login login = JWT.unsign(token, Login.class);
            if (null!= login) {
                return true;
            } else {
                responseMessage(httpServletRequest,httpServletResponse, httpServletResponse.getWriter());
                return false;
            }
        } else {
            responseMessage(httpServletRequest,httpServletResponse, httpServletResponse.getWriter());
            return false;
        }
    }

    // TODO: 2018/1/6 更改对应的语句
    private void responseMessage(HttpServletRequest request,HttpServletResponse response, PrintWriter out) {
        response.setContentType("application/json; charset=utf-8");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(DictEnum.MapField.status, DictEnum.ErrorCode.ERROR_404NOTFOUND_ERROR);
        map.put(DictEnum.MapField.Describe,"please login first!");
        String json = IJsonHelper.getGsonSerizeNull().toJson(map).toString();
        out.print(json);
        out.flush();
        out.close();
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
