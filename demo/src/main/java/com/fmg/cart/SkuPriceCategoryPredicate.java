package com.fmg.cart;

/**
 * @ClassName SkuPriceCategoryPredicateImpl
 * @Description TODO
 * @Author fmg
 * @Date 2019-12-15 9:08
 * @Version 1.0.0
 **/
public class SkuPriceCategoryPredicate implements SkuPredicate {

    @Override
    public boolean test(Sku sku) {
        return sku.getSkuTotalPrice() > 200;
    }
}
