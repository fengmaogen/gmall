package com.fmg.lombok;

import lombok.Cleanup;
import org.junit.Test;

import java.io.*;

/**
 * @classs: CleanUpTest
 * @author: fengmg
 * @date: 2019/12/26 17:22
 * @description:
 * @version: 1.0
 */
public class CleanupTest {

    @Test
    public void test() throws IOException {
        @Cleanup FileInputStream fileInputStream = new FileInputStream(new File(""));
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(new File(""));

        int b;
        if((b = fileInputStream.read()) != -1){
            fileOutputStream.write(b);
        }
    }

    @Test
    public void test1() throws IOException {
        try(
            FileInputStream fileInputStream = new FileInputStream(new File(""));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
            ) {

            int b;
            if((b = fileInputStream.read()) != -1){
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
