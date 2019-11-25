package com.fmg.user.service;/**
 * @className UserService
 * @description TODO
 * @author fmg
 * @date 2019-11-24 23:00
 * @version 1.0.0
 **/

import com.fmg.user.bean.UmsMember;
import com.fmg.user.bean.UmsMemberLevel;
import com.fmg.user.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 *@ClassName UserService
 *@Description TODO
 *@Author fmg
 *@Date 2019-11-24 23:00
 *@Version 1.0.0
 **/
public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getAddressByUserId(String userId);

    int modifyReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    int addReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    int removeReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    List<UmsMemberLevel> getUserLevelByLevelId(String levelId);

    int modifyUserLevel(UmsMemberLevel umsMemberLevel);

    int addUserLevel(UmsMemberLevel umsMemberLevel);

    int removeUserLevel(UmsMemberLevel umsMemberLevel);
}
