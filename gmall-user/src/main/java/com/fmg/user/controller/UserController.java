package com.fmg.user.controller;/**
 * @className UserController
 * @description TODO
 * @author fmg
 * @date 2019-11-24 22:58
 * @version 1.0.0
 **/

import com.fmg.user.bean.UmsMember;
import com.fmg.user.bean.UmsMemberLevel;
import com.fmg.user.bean.UmsMemberReceiveAddress;
import com.fmg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@ClassName UserController
 *@Description TODO
 *@Author fmg
 *@Date 2019-11-24 22:58
 *@Version 1.0.0
 **/
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> userList = userService.getAllUser();

        return userList;
    }

    @RequestMapping("getUserLevelByUserId")
    @ResponseBody
    public List getUserLevelByUserId(String levelId){
        List<UmsMemberLevel> addressInfo = userService.getUserLevelByLevelId(levelId);
        return addressInfo;
    }

    @RequestMapping("modifyUserLevel")
    @ResponseBody
    public int modifyUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.modifyUserLevel(umsMemberLevel);

    }

    @RequestMapping("addUserLevel")
    @ResponseBody
    public int addUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.addUserLevel(umsMemberLevel);

    }

    @RequestMapping("removeUserLevel")
    @ResponseBody
    public int removeUserLevel(@RequestBody UmsMemberLevel umsMemberLevel){

        return userService.removeUserLevel(umsMemberLevel);

    }


    @RequestMapping("getAddressByUserId")
    @ResponseBody
    public List getAddressByUserId(String userId){
        List<UmsMemberReceiveAddress> addressInfo = userService.getAddressByUserId(userId);
        return addressInfo;
    }

    @RequestMapping("modifyReceiveAddress")
    @ResponseBody
    public int modifyReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.modifyReceiveAddress(umsMemberReceiveAddress);

    }

    @RequestMapping("addReceiveAddress")
    @ResponseBody
    public int addReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.addReceiveAddress(umsMemberReceiveAddress);

    }

    @RequestMapping("removeReceiveAddress")
    @ResponseBody
    public int removeReceiveAddress(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){

        return userService.removeReceiveAddress(umsMemberReceiveAddress);

    }
}
