package com.example.demo.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int i = 0, j = arr.length - 1;
        String temp = null;
        while (i < j) {
            if (!" ".equalsIgnoreCase(arr[i]) || !" ".equalsIgnoreCase(arr[j])) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        temp = "";
        for (int k = 0; k < arr.length; k++) {
            //记录一下数组中最后一个不为0的位置，
            if (arr[k] != "") {
                temp += (arr[k] + " ");
            }
        }
        return temp.substring(0, temp.length() - 1);
    }


    public String reverseWordsExt(String s) {
        String[] arr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        int j = arr.length - 1;
        while (j >= 0) {
            if (arr[j] != "") {
                sb.append(" " + arr[j]);
            }
            j--;
        }
        return sb.toString().substring(1);
    }


    @Test
    public void reverseWordsTest() {
        String s = "the sky is blue";
        s = "  hello world  ";
//        s = "a good   example";
        String s1 = reverseWordsExt(s);
        System.out.println(s1);
    }


    @Test
    public void testSplit() {
        String s = "  hello world  ";
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
        System.out.println(s1.length);

    }
}
