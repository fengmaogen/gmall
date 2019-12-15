package com.fmg.stream;

import com.alibaba.fastjson.JSON;
import com.fmg.cart.CartService;
import com.fmg.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StreamOperatorTest
 * @Description TODO
 * @Author fmg
 * @Date 2019-12-15 21:06
 * @Version 1.0.0
 **/
public class StreamOperatorTest {

    List<Sku> list;

    @Before
    public void init(){
        list = CartService.getCartSkuList();
    }

    @Test
    public void filkterTest(){
        list.stream()
                .filter(sku -> sku.getSkuPrice() > 100)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void mapTest(){
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void flatMapTest(){
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void skipTest(){
        list.stream()
                .skip(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void limitTest(){
        list.stream()
                .skip(1*2)
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void peekTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void sortTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getSkuPrice))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void distinctTest(){
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }
}
