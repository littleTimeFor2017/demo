package com.example.springdemo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Bruce Lee
 * @Date: 2020/12/20
 * @Description:
 */
public class LyTest {

    public static void main(String[] args) {
        String parentLevelCode = "001";

    }


    /**
     * 查询当前节点下的直属子节点
     *
     * @param list
     * @param parentLevelCode
     * @return
     */
    private List<Map<String, Object>> getListByParentLevelCode(List<Map<String, Object>> list, String parentLevelCode) {
        List<Map<String, Object>> childList = new ArrayList<>();
        for (Map<String, Object> map : list) { //遍历list，如果集合中的元素符合 startWith 条件，表示是所有的子节点
            if (((String) map.get("levelCode")).startsWith(parentLevelCode)
                    //直属子节点
                    || ((String) map.get("levelCode")).length() == parentLevelCode.length() + 3) {
                childList.add(map);
            }
        }
        return childList;
    }

}
