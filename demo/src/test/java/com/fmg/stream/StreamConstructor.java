package com.fmg.stream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @classs: StreamConstructor
 * @author: fengmg
 * @date: 2019/12/16 14:21
 * @description:
 * @version: 1.0
 */
public class StreamConstructor {

    @Test
    public void StreamFromValue(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void StreamFromArray(){
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4});
        stream.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void StreamFromFile(){
        try {
            Stream<String> lines = Files.lines(Paths.get("src/test/java/com/fmg/stream/StreamConstructor.java"));
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void StreamFromFunction(){
//        Stream.iterate(0, n -> n + 2).limit(100).forEach(p-> System.out.println(p));
        Stream.generate(Math::random).limit(100).forEach(p-> System.out.println(p));

        Stream.generate(Math::random).limit(100).forEach(System.out::println);

        System.out.println((int)((Math.random()*9+1)*100000));
    }
}
