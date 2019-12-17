package com.fmg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @classs: OptionalTeset
 * @author: fengmg
 * @date: 2019/12/17 09:31
 * @description:
 * @version: 1.0
 */
public class OptionalTeset {

    @Test
    public void test(){
        Optional.empty();
        Optional<String> integer = Optional.of("str");

        String nullValue = null;
        String optionalStr = Optional.ofNullable(nullValue).orElse("引用缺失");
        System.out.println(optionalStr);

        Optional<String> nullValue1 = Optional.ofNullable(nullValue);
        nullValue1.orElse("引用缺失");
        nullValue1.orElseGet(()->"引用缺失");
        integer.ifPresent(System.out::println);
        nullValue1.ifPresent(System.out::println);

    }

    public void list(List list){
        list.stream().forEach(System.out::println);
    }

    public void list1(List list) {

        Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty).forEach(System.out::println);
    }

    @Test
    public void listTest(){
//        list(null);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list1(list);
    }
}
