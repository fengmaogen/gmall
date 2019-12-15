package com.fmg.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class CartServiceTest {

    @Test
    public void getCartSkuList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }

    @Test
    public void filterElectronics() {
        List<Sku> cartSkuList = CartService.filterElectronics(CartService.getCartSkuList());
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }


    @Test
    public void filterSkuByCategory() {
        List<Sku> cartSkuList = CartService.filterSkuByCategory(CartService.getCartSkuList(), SkuCategoryEnum.BOOKS);
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }

    @Test
    public void filterSkuByPredicate() {

        List<Sku> cartSkuList = CartService.filterSkuByPredicate(CartService.getCartSkuList(), new SkuPriceCategoryPredicate());
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }

    @Test
    public void filterSkuByPredicate1() {

        List<Sku> cartSkuList = CartService.filterSkuByPredicate(CartService.getCartSkuList(), new SkuBooksCategoryPredicate());
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }

    @Test
    public void filterSkuByPredicate2() {

        List<Sku> cartSkuList = CartService.filterSkuByPredicate(CartService.getCartSkuList(), new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuTotalPrice() < 1000;
            }
        });
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }

    @Test
    public void filterSkuByPredicate3() {

        List<Sku> cartSkuList = CartService.filterSkuByPredicate(CartService.getCartSkuList(),
                sku -> sku.getSkuTotalPrice() < 100);
        System.out.println(JSON.toJSONString(cartSkuList, true));
    }
}