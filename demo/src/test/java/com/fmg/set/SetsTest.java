package com.fmg.set;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SetsTest
 * @Description TODO
 * @Author fmg
 * @Date 2019-12-18 20:44
 * @Version 1.0.0
 **/
public class SetsTest {

    @Test
    public void test(){
        Set set1 = Sets.newHashSet(1,2,3,4);
        Set set2 = Sets.newHashSet(4,5,6);

        System.out.println(Sets.union(set1, set2));

        System.out.println(Sets.intersection(set1, set2));

        System.out.println(Sets.difference(set1, set2));

        System.out.println(Sets.symmetricDifference(set1, set2));

        System.out.println(Sets.powerSet(set1));
        System.out.println(JSON.toJSONString(Sets.powerSet(set1)));

        System.out.println(JSON.toJSONString(Sets.cartesianProduct(set1,set2)));
    }

    @Test
    public void listTest(){
        List list = Lists.newArrayList(1,2,3,4,4,5,6,7);

        System.out.println(Lists.partition(list, 3));

        System.out.println(Lists.reverse(list));
    }
}
