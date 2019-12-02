package com.fmg.user.service.impl;


/**
 * @className UserServiceImpl
 * @description TODO
 * @author fmg
 * @date 2019-11-24 23:01
 * @version 1.0.0
 **/

import com.fmg.gmall.bean.UmsMember;
import com.fmg.gmall.bean.UmsMemberLevel;
import com.fmg.gmall.bean.UmsMemberReceiveAddress;
import com.fmg.gmall.service.UserService;
import com.fmg.user.mapper.UmsMemberReceiveAddressMapper;
import com.fmg.user.mapper.UserLevelMapper;
import com.fmg.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author fmg
 * @Date 2019-11-24 23:01
 * @Version 1.0.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Autowired
    UserLevelMapper userLevelMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList = userMapper.selectAllUser();
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getAddressByUserId(String userId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(userId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddressList;
    }

    @Override
    public int modifyReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        Example example = new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("id", umsMemberReceiveAddress.getId());
        int i = umsMemberReceiveAddressMapper.updateByExampleSelective(umsMemberReceiveAddress, example);
        return i;
    }

    @Override
    public int addReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int i = umsMemberReceiveAddressMapper.insertSelective(umsMemberReceiveAddress);
        return i;
    }

    @Override
    public int removeReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int delete = umsMemberReceiveAddressMapper.delete(umsMemberReceiveAddress);
        return delete;
    }

    @Override
    public List<UmsMemberLevel> getUserLevelByLevelId(String levelId) {
        UmsMemberLevel umsMemberLevel = new UmsMemberLevel();
        umsMemberLevel.setId(levelId);
        userLevelMapper.select(umsMemberLevel);
        return null;
    }

    @Override
    public int modifyUserLevel(UmsMemberLevel umsMemberLevel) {

        Example example = new Example(UmsMemberLevel.class);
        example.createCriteria().andEqualTo(umsMemberLevel.getId());
        int i = userLevelMapper.updateByExampleSelective(umsMemberLevel, example);
        return i;
    }

    @Override
    public int addUserLevel(UmsMemberLevel umsMemberLevel) {
        int i = userLevelMapper.insertSelective(umsMemberLevel);
        return i;
    }

    @Override
    public int removeUserLevel(UmsMemberLevel umsMemberLevel) {
        int delete = userLevelMapper.delete(umsMemberLevel);
        return delete;
    }
}
