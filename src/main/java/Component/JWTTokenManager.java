package Component;

import entity.TokenModel;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JWTTokenManager implements TokenManage {


    private RedisTemplate redis;
    private long TOKEN_EXPIRES_HOUR = 10;


    public void setRedis(RedisTemplate redis) {
        this.redis = redis;
    }

    public TokenModel createToken(String userID) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userID, token);
        redis.boundValueOps(userID).set(token, TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return null;
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) return false;
        String token = (String) redis.boundValueOps(model.getToken()).get();
        if (token == null || !token.equals(model.getToken())) return false;
        redis.boundValueOps(model.getUserID()).expire(TOKEN_EXPIRES_HOUR, TimeUnit.MINUTES);
        return true;
    }

    /**
     * todo 可以更改获取方式
     *
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) return null;
        String[] param = authentication.split("_");
        if (param.length != 2) return null;
        String userId = param[0];
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public void deleteToken(String userID) {
        redis.delete(userID);
    }
}
