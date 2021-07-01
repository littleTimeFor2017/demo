package com.example.test;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/5
 * @Description:
 */
public class TokenTest {
    private String token;
    private long startTime = 0;
    private long endTime = 0;


    public String getToken() {
        //系统的起始时间
        long start = System.currentTimeMillis();
        if (endTime == 0) {
            //第一次进入
            initToken(start);
        } else {
            //判断当前时间是否超时，
            if (start > endTime) {
                //重新获取
                initToken(start);
            }
        }
        return token;
    }


    private void initToken(long start) {
        //调用 获取token的接口
        String token_get = "1sdfasdfa";
        if (token_get != null) {
            startTime = start;
            endTime = start + 60 * 60 * 12;
            token = token_get;
        }
    }


    public void setToken(String token) {
        this.token = token;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
