package com.fmg.cart;

/**
 * @ClassName SkuBooksCategoryPredicate
 * @Description TODO
 * @Author fmg
 * @Date 2019-12-15 9:10
 * @Version 1.0.0
 **/
public class SkuBooksCategoryPredicate implements SkuPredicate {

    @Override
    public boolean test(Sku sku) {
        return sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS);
    }
}
