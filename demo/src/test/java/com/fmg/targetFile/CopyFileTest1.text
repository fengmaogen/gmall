package com.fmg.original;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        String orginalUrl = "src/test/java/com/fmg/original/CopyFileTest.java";
        String targetUrl = "src/test/java/com/fmg/targetFile/CopyFileTest.text";

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


}
