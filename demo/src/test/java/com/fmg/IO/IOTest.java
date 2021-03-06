package com.fmg.IO;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @classs: IOTest
 * @author: fengmg
 * @date: 2019/12/19 11:07
 * @description:
 * @version: 1.0
 */
public class IOTest {

    @Test
    public void test() throws IOException {
        CharSource charSource = Files.asCharSource(new File("src/test/java/com/fmg/IO/IOTest.java"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("src/test/java/com/fmg/IO/IOTest.txt"), Charsets.UTF_8);

        charSource.copyTo(charSink);
    }
}
