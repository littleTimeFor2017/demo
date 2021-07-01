package com.example.file;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Base64;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/16
 * @Description:
 */
public class ReadFileTest {


    @Test
    public void readFileToB64() throws IOException {
        String path = "C:\\Users\\李宪春\\Desktop\\QQ图片20201214140530.png";
        File file = new File(path);
        InputStream ins = new FileInputStream(file);
        byte[] bytes = new byte[ins.available()];
        ins.read(bytes);
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
        byte[] bytes1 = s.getBytes();
        OutputStream ous = new FileOutputStream("C:\\Users\\李宪春\\Desktop\\1.png");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(ous);
        objectOutputStream.writeObject(s);
        objectOutputStream.flush();
        objectOutputStream.close();
        //将内容写入输出瑞
    }

    @Test
    public void readBytes() {
        String path = "C:\\Users\\李宪春\\Desktop\\1.txt";
        File file = new File(path);
        System.out.println(file.length());
//        try {
//            InputStream ins = new FileInputStream(path);
//            byte[] bytes = new byte[1024];
//            int len = 0;
//            // 定义一个StringBuffer用来存放字符串
//            StringBuffer sb = new StringBuffer();
//            while((len = ins.read(bytes))!= -1){
//                sb.append(new String(bytes, 0, len, "utf-8"));
//            }
//
//            System.out.println(sb.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public static void main(String[] args) {
        String OS_User = System.getProperty("os.name");
        if (OS_User != null && OS_User.toLowerCase().contains("windows")) {
            System.out.println("is windows");
        } else {
            System.out.println("no");
        }
//        System.out.println(System.getenv());
    }
}
