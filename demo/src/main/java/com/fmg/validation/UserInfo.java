package com.fmg.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @classs: UserInfo
 * @author: fengmg
 * @date: 2019/12/27 10:43
 * @description:
 * @version: 1.0
 */
@Data
public class UserInfo {

    @NotBlank(groups = ValidationGroup.Login.class,message = "用户姓名不可为空")
    private String userName;
    @NotNull(groups = ValidationGroup.Register.class,message = "用户编号不可为空")
    private Integer userId;
    @NotEmpty(message = "用户密码不可为空")
    @Length(min = 5,max = 12,message = "密码长度不能小于5或大于12")
    private String passWord;
    @Email(message = "邮箱格式不正确")
    private String email;
    @Length(max = 11,min = 11,message = "手机号长度不对")
    private String phone;
    @NotNull(message = "年龄不可为空")
    @Range(min=5, max=100,message = "年龄输入错误")
    private String age;
    @Past
    private Date birthday;

    @Size(min = 1,message = "不能少于一个好友")
    private List<@Valid UserInfo> friends;
}
