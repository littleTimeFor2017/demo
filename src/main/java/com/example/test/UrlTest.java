package com.example.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/28
 * @Description:
 */
public class UrlTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://wwww.baidu.com");
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) >= 0) {
            System.out.println(new String(bytes));
        }
    }
}
