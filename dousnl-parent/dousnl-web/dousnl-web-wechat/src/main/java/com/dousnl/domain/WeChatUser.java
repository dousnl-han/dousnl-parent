package com.dousnl.domain;

import lombok.Data;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/24 18:34
 */
@Data
public class WeChatUser {

    private Long id;
    private String username;
    private String wechatOpenid;
    private Long phone;
    private String nickName;
    private String avatarUrl;
    private Gender gender;
    private String email;
    private Long lastLoginTime;
    private Boolean deleted;
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;
}
