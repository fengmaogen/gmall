package com.fmg.cart;

/**
 * @description  商品谓词
 * @author fmg
 * @date 2019/12/15 9:05
 * @throws
 **/
public interface SkuPredicate {

    boolean test(Sku sku);
}
