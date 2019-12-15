package com.fmg.cart;

/**
 * @author fmg
 * @version 1.0.0
 * @className SkuCategoryEnum
 * @description TODO
 * @date 2019-12-13 22:26
 **/
public enum SkuCategoryEnum {
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    private Integer code;
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
