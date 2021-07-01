package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/5
 * @Description:
 */
public class JSONTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        jsonArray.set(0, "1");
        jsonArray.set(1, "2");
//        List<String> strings = JSONObject.parseArray(JSONObject.toJSONString(map), String.class);
//        System.out.println(strings.get(0));
        List<String> strings = JSONObject.parseArray(JSONObject.toJSONString(jsonArray), String.class);
        System.out.println(strings.get(1));
    }
}
