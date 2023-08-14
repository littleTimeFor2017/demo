package com.example.lixc.day;

import org.junit.Test;

/**
 * @author:lixc
 * @date:2023/8/11
 * @name:Day1
 * @description: 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Day1 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return sb.toString().equals(s);
    }


    public boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }
        //x % 10  能取到最后一位的数组
        // x / 10 取到x的总长度
        //对于x 既然决定了不用字符串的方式去处理，那么我们就不能按照下标的方式进行处理了。
        //可以获取到x反转后的值，
        int result  = 0;
        int tmp = 1;
        int origin = x;
        while (origin != 0) {
            //这里只是将x重新拼接了一遍，怎么做到反转呢
            //正装int
//            cur += (origin % 10) * tmp;
//            tmp *= 10;
            //反转int
            result =result * 10 +  origin % 10;
            origin /= 10;
        }
        return x == result;
    }


    @Test
    public void testIsPalindrome() {
        System.out.println(isPalindrome3(121));
    }


}
