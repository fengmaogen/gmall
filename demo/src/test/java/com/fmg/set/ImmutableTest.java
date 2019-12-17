package com.fmg.set;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @classs: ImmutableTest
 * @author: fengmg
 * @date: 2019/12/17 16:41
 * @description:
 * @version: 1.0
 */
public class ImmutableTest {

    public void list(List<Integer> list){
        list.remove(0);
    }
    @Test
    public void test(){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(4);
        objects.add(6);
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(objects);
        list(objects);
        System.out.println(JSON.toJSONString(integers.asList(), true));
        System.out.println(JSON.toJSONString(objects, true));
    }

}
