package com.example.structure.queue;

/**
 * @author Bruce Lee
 * @date 2021/6/7
 * @description 利用数组来实现队列的基本功能
 **/
public class ArrayQueueDemo {
}

class ArrayQueue {
    private int maxSize;
    private int putIndex;
    private int takeIndex;
    private int[] data;


    /**
     * 判断队列是否已满，如果已满不允许添加元素
     * @return
     */
    public boolean isFull(){
            return false;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * insert into queue
     */
    public void add(){

    }

    /**
     * take a member from the queue
     * @return
     */
    public int take(){
        return -1;
    }

    /**
     * show all the members of the queue
     */
    public void list(){

    }
}
