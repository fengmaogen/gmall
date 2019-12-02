package com.fmg.user.mapper;


import com.fmg.gmall.bean.UmsMember;

import java.util.List;

/**
 * @author fmg
 * @version 1.0.0
 * @className UserMapper
 * @description TODO
 * @date 2019-11-24 23:00
 **/
public interface UserMapper {

    List<UmsMember> selectAllUser();
}
