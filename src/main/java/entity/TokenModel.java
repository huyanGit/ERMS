package entity;

import lombok.Data;

@Data
public class TokenModel {
    private String userID;
    private String token;

    public TokenModel(String userID, String token) {
    }

    public TokenModel() {

    }
}
