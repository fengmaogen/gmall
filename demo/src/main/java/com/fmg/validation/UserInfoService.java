package com.fmg.validation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

import static com.fmg.validation.ValidationGroup.*;

/**
 * @classs: UserInfoService
 * @author: fengmg
 * @date: 2019/12/27 17:12
 * @description:
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoService {

    private UserInfo userInfo;

    @Valid
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(@Valid UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
