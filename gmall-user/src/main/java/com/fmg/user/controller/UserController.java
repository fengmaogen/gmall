package com.fmg.user.controller;/**
 * @className UserController
 * @description TODO
 * @author fmg
 * @date 2019-11-24 22:58
 * @version 1.0.0
 **/

import com.fmg.gmall.bean.UmsMember;
import com.fmg.gmall.bean.UmsMemberLevel;
import com.fmg.gmall.bean.UmsMemberReceiveAddress;
import com.fmg.gmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@ClassName UserController
 *@Description TODO
 *@Author fmg
 *@Date 2019-11-24 22:58
 *@Version 1.0.0
 **/
@Api("用户")
@Controller
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("index")
    public String index(){
        return "hello user";
    }

    @ApiOperation(value = "获取所有用户",httpMethod = "GET")
    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> userList = userService.getAllUser();

        return userList;
    }

    @RequestMapping("getUserLevelByUserId")
    public List getUserLevelByUserId(String levelId){
        List<UmsMemberLevel> addressInfo = userService.getUserLevelByLevelId(levelId);
        return addressInfo;
    }

    @RequestMapping("modifyUserLevel")
    public int modifyUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.modifyUserLevel(umsMemberLevel);

    }

    @RequestMapping("addUserLevel")
    public int addUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.addUserLevel(umsMemberLevel);

    }

    @RequestMapping("removeUserLevel")
    public int removeUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.removeUserLevel(umsMemberLevel);

    }


    @RequestMapping("getAddressByUserId")
    public List getAddressByUserId(String userId){
        List<UmsMemberReceiveAddress> addressInfo = userService.getAddressByUserId(userId);
        return addressInfo;
    }

    @RequestMapping("modifyReceiveAddress")
    public int modifyReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.modifyReceiveAddress(umsMemberReceiveAddress);

    }

    @RequestMapping("addReceiveAddress")
    public int addReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.addReceiveAddress(umsMemberReceiveAddress);

    }

    @RequestMapping("removeReceiveAddress")
    public int removeReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.removeReceiveAddress(umsMemberReceiveAddress);

    }
}
