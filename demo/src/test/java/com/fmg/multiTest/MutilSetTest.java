package com.fmg.multiTest;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.io.*;
import java.util.stream.IntStream;

/**
 * @classs: MutilSetTest
 * @author: fengmg
 * @date: 2019/12/18 14:26
 * @description:
 * @version: 1.0
 */
public class MutilSetTest {

    @Test
    public void test(){

        String orginalPath = "src/test/java/com/fmg/original/test.txt";
        try (FileInputStream fileInputStream = new FileInputStream(orginalPath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ){
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null){
                stringBuilder = stringBuilder.append(str);
            }
            System.out.println(stringBuilder);

            Multiset<Character> multiset = HashMultiset.create();

            Chars.asList(String.valueOf(stringBuilder)
                    .toCharArray())
                    .stream()
                    .forEach(character -> {
                        multiset.add(character);
                    });
            System.out.println(multiset.size());
            System.out.println("count:" + multiset.count('一'));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
