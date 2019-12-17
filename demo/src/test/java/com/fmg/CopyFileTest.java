package com.fmg;

import org.junit.Test;

import java.io.*;

/**
 * @classs: CopyFileTest
 * @author: fengmg
 * @date: 2019/12/16 16:50
 * @description:
 * @version: 1.0
 */
public class CopyFileTest {

    @Test
    public void oldFile(){
        String orginalUrl = "";
        String targetUrl = "";

        FileInputStream fileInputStream = null;
        FileOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(orginalUrl);
            outputStream = new FileOutputStream(targetUrl);

            int line;
            while ((line =  fileInputStream.read()) != -1){
                outputStream.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void newFile(){
        String orginalUrl = "src/test/java/com/fmg/original/CopyFileTest.java";
        String targetUrl = "src/test/java/com/fmg/targetFile/CopyFileTest1.text";

        try (FileInputStream fileInputStream = new FileInputStream(orginalUrl);
             FileOutputStream outputStream = new FileOutputStream(targetUrl);
             ){

            int line;
            while ((line =  fileInputStream.read()) != -1){
                outputStream.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
