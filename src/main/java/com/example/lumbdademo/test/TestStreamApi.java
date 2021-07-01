package com.example.lumbdademo.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/15
 * @Description:
 */
public class TestStreamApi {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        IntStream nums1 = IntStream.of(nums);
        String name = "my name is 007";
        Stream.of(name.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);
        /**
         * filter:接收Lambda,从流中排除某些对象/操作；
         * limit:截断流，使其元素不能超过指定对象
         * skip(n)，跳过前n个元素，如果流中的元素不足n个，则返回一个空的流
         * distinct:筛选，通过流生成的元素的hashCode()和equals()方法去除重复元素
         *
         *
         *
         *  map：接收lumbda，将元素转换成其他类型，接收一个函数作为参数，该函数会被应用到每个元素上面，并将其映射成一个新的元素
         *  flatMap: 接收一个函数作为参数，将流中的每个值都换成一个另外一个流，然后把所有的流连接成一个流
         *
         *
         *  sorted() 自然排序
         *  sorted(Comparator com)定制排序
         *
         *
         *  终止操作：
         *  allMatch()  检查是否匹配所有元素
         *  anyMatch() 检查是否至少匹配一个元素
         *  noneMatch() 检查是否没有匹配所有元素
         *  findFirst() 返回第一个元素
         *  findAny() 返回当前流中的任意元素
         *  count() 返回流中元素的总个数
         *  max() 返回流中元素的最大值
         *  min() 返回流中元素的最小值
         *
         *  reduce() 归集 类似于地柜调用？
         *  collect()  收集
         */
    }
}
