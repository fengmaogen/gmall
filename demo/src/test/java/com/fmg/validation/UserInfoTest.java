package com.fmg.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @classs: UserInfoTest
 * @author: fengmg
 * @date: 2019/12/27 12:40
 * @description:
 * @version: 1.0
 */
public class UserInfoTest {

    private UserInfo userInfo;

    private Validator validator;

    private Set<ConstraintViolation<UserInfo>> validate;

    private Set<ConstraintViolation<UserInfoService>> violationSet;

    @Before
    public void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        userInfo = new UserInfo();
//        userInfo.setUserId(1);
//        userInfo.setUserName("123");
        userInfo.setPassWord("12345");
        userInfo.setEmail("280575876@qq.com");
        userInfo.setPhone("18811435520");
        userInfo.setBirthday(new Date());
        userInfo.setAge("12");

        UserInfo friend = new UserInfo();
        friend.setUserName("朋友");
        friend.setUserId(666);
        userInfo.setFriends(new ArrayList<UserInfo>(){{add(friend);}});
    }

    @After
    public void print(){
//        validate.forEach(item -> System.out.println(item.getMessage()));
        violationSet.forEach(item -> System.out.println(item.getMessage()));
    }


    @Test
    public void test(){
        validate = validator.validate(userInfo);
    }

    @Test
    public void cascadeTest(){
         validate = validator.validate(userInfo);
    }

    @Test
    public void groupTest(){
//        validate = validator.validate(userInfo, ValidationGroup.Login.class);
//        validate = validator.validate(userInfo, ValidationGroup.Register.class);
//        validate = validator.validate(userInfo, ValidationGroup.Register.class, ValidationGroup.Login.class);
        validate = validator.validate(userInfo, ValidationGroup.Group.class);
    }

    @Test
    public void validateParametersTest() throws NoSuchMethodException {
        //获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService userInfoService = new UserInfoService();
        Method setMethod = userInfoService.getClass().getMethod("setUserInfo", UserInfo.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setPassWord("123142");
        Object[] parameterValues = new Object[]{userInfo};

        violationSet = executableValidator.validateParameters(
                userInfoService,
                setMethod,
                parameterValues);
    }

    @Test
    public void returnTest() throws NoSuchMethodException {
        ExecutableValidator executableValidator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();

        UserInfoService userInfoService = new UserInfoService();

        Method getUserInfo = userInfoService.getClass().getMethod("getUserInfo");

        Object[] objects = {new UserInfo()};

        violationSet = executableValidator.validateReturnValue(userInfoService, getUserInfo, objects);
    }

}