package com.example.test;

import java.math.BigInteger;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/28
 * @Description: 十进制和十六进制的数字转换
 */
public class HexChange2Ten {
    private static final long CKM_SM2_ENC = 0x83000000;// sm2证书解密机制


    public static void main(String[] args) {
        long i = hexToDecimal("0a00001b".toUpperCase());
        System.out.println(i);
        System.out.println(tenToHex(i));

    }

    public static String tenToHex(long value) {
        BigInteger bigInteger = new BigInteger(String.valueOf(value));
        return bigInteger.toString(16);
    }


    /**
     * 十六进制转十进制(long 类型防止超出范围)
     *
     * @param: 十六进制字符串
     * @return: int
     * @description: 按位计算，位值乘权重
     */
    public static long hexToDecimal(String hex) {
        long outcome = 0L;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            outcome = outcome * 16 + charToDecimal(hexChar);
        }
        return outcome;
    }

    /**
     * @param: [c]
     * @return: int
     * @description:将字符转化为数字
     */
    public static int charToDecimal(char c) {
        if (c >= 'A' && c <= 'F')
            return 10 + c - 'A';
        else
            return c - '0';
    }
}
