package com.example.demo.other;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * <p>
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 10*10*10*10
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class AddStrings {

    public String addStringsFailed(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        long n1 = 0;
        //todo 如果用int  会超出int的长度， 用long也会超出long的长度 所以还是得用字符串拼接的方式
        long n2 = 0;
        long tmp = 1;
        for (int i = l1 - 1; i >= 0; i--) {
            int i1 = num1.charAt(i) - 48;
            n1 += i1 * tmp;
            tmp = 10 * tmp;
        }
        tmp = 1;
        for (int i = l2 - 1; i >= 0; i--) {
            int i1 = num2.charAt(i) - 48;
            n2 += i1 * tmp;
            tmp = 10 * tmp;
        }
        return n1 + n2 + "";
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1,j = num2.length() -1;
        StringBuffer sb = new StringBuffer();
        int add = 0;
        while(i>=0 || j>=0 || add != 0 ){
            int x = i>=0 ? num1.charAt(i)-'0':0;
            int y = j>=0 ?num2.charAt(j)-'0':0;
            int result = x+y +add;
            add = result  /  10;
            sb.append(result %10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    @Test
    public void testAddStrings() {
        String num1 = "1";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }


    @Test
    public void testChar2Int() {
        String a = "0123456789";
        char c = a.charAt(0);
        System.out.println(a.substring(4, 9));
    }
}
