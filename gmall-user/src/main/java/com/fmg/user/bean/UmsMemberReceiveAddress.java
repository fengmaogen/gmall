package com.fmg.user.bean;/**
 * @className UmsMemberReceiveAddress
 * @description TODO
 * @author fmg
 * @date 2019-11-25 19:04
 * @version 1.0.0
 **/

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName UmsMemberReceiveAddress
 * @Description TODO
 * @Author fmg
 * @Date 2019-11-25 19:04
 * @Version 1.0.0
 **/
@Data
public class UmsMemberReceiveAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String memberId;
    private String name;
    private String phoneNumber;
    private int defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;


}
