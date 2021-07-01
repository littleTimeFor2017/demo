package com.example.juc.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/8
 * @Description:
 */
public class AtomicIntegerStampReferenceTest {
    //initialRef 初始值   initialStamp  初始版本号
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(1, 0);


}
