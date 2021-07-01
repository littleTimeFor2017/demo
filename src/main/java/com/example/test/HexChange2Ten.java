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
        long i = hexToDecimal("0x83000000".toUpperCase());
        System.out.println(i);

    }

    /**
     * @param: [hex]
     * @return: int
     * @description: 按位计算，位值乘权重
     */
    public static long hexToDecimal(String hex) {
        long outcome = 0l;
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
