package com.fmg.user.bean;/**
 * @className UmsMember
 * @description TODO
 * @author fmg
 * @date 2019-11-25 12:54
 * @version 1.0.0
 **/

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName UmsMember
 * @Description TODO
 * @Author fmg
 * @Date 2019-11-25 12:54
 * @Version 1.0.0
 **/
@Data
public class UmsMember {

    @Id
    private String id;
    private String memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int status;
    private Date createTime;
    private String icon;
    private int gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private int sourceType;
    private int integration;
    private int growth;
    private int luckeyCount;
    private int historyIntegration;

}
