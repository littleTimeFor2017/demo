package com.example.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bruce Lee
 * @date 2021/7/26
 * @description
 **/
public class RegexTest {
    public static Pattern pattern = Pattern.compile("([^#=]*)=([^#])*(#)?.*");
    public static Pattern pattern1 = Pattern.compile("([^#=]*)=([^#]*(#)?.*)");
    static String str = "password=Sul#216A#123##邮箱配置";

    public static void test1() {
//        String str = "host=127.0.0.1";
        Matcher matcher = pattern.matcher(str);
        //先用标准的匹配
        if (matcher.matches()) {
            //价格判断，如果是邮件的password 进行下面的判断
            Matcher matcher1 = pattern1.matcher(str);
            if (matcher1.matches()) {
                System.out.println(matcher1.group(1));
                String value = matcher1.group(2);
                if (value.split("# ").length > 2) {
                    value = value.substring(0, value.lastIndexOf("#"));
                }
                System.out.println(value);
            }

        } else {
            System.out.println("没有匹配");
        }
    }

    public static void test2() {
//        String str = "host=127.0.0.1";
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));

        } else {
            System.out.println("没有匹配");
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
