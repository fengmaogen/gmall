package com.fmg.gmall.bean;/**
 * @className UmsMemberLevel
 * @description TODO
 * @author fmg
 * @date 2019-11-25 19:50
 * @version 1.0.0
 **/

import lombok.Data;

import javax.persistence.Id;

/**
 * @ClassName UmsMemberLevel
 * @Description TODO
 * @Author fmg
 * @Date 2019-11-25 19:50
 * @Version 1.0.0
 **/
@Data
public class UmsMemberLevel {

    @Id
    private String id;
    private String name;
    private int growthPoint;
    private int defaultStatus;
    private String freeFreightPoint;
    private int commentGrowthPoint;
    private int priviledgeFreeFreight;
    private int priviledgeSignIn;
    private int priviledgeComment;
    private int priviledgePromotion;
    private int priviledgeMemberPrice;
    private int priviledgeBirthday;
    private String note;

}
