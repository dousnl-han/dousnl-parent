package com.dousnl.autho.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/26 19:16
 */
@Data
public class OAuth2Token {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;
}
