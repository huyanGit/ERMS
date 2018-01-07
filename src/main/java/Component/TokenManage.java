package Component;

import entity.TokenModel;

interface TokenManage{
    /**
     * 创建一个token关联用户
     * @param userID
     * @return
     */
    TokenModel createToken(String userID);

    /**
     * 检查token是否可用
     * @param token
     * @return
     */
    boolean checkToken(TokenModel token);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param userID
     */
    void deleteToken(String userID);
}