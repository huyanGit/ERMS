package service;
public interface LoginService {

    /**
     * 验证用户的身份信息
     * @param userId
     * @param password
     * @return
     */
    int ConfineUser(String userId, String password);
}
