package com.fmg.stream;

import com.alibaba.fastjson.JSON;
import com.fmg.cart.CartService;
import com.fmg.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @classs: StreamCollect
 * @author: fengmg
 * @date: 2019/12/16 15:35
 * @description:
 * @version: 1.0
 */
public class StreamCollect {

    /**
     *转成list
     */
    @Test
    public void toList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        cartSkuList.stream().filter(sku -> sku.getSkuPrice() < 300).forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));


        List<Sku> collect = cartSkuList.stream().filter(sku -> sku.getSkuPrice() < 300).collect(Collectors.toList());
        System.out.println();
        collect
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * 分组
     */
    @Test
    public void group(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Integer, List<Sku>> collect = cartSkuList.stream().collect(Collectors.groupingBy(Sku::getSkuTotalNum));

        System.out.println(JSON.toJSONString(collect, true));
    }

    /**
     * 分区
     */
    @Test
    public void partition(){
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Boolean, List<Sku>> collect = cartSkuList.stream().collect(Collectors.partitioningBy(sku->sku.getSkuTotalPrice() > 5_00));

        System.out.println(JSON.toJSONString(collect, true));
    }
}
