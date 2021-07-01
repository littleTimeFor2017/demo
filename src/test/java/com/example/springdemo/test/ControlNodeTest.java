package com.example.springdemo.test;

import com.alibaba.fastjson.util.TypeUtils;

import java.util.*;

public class ControlNodeTest {
    public static void main(String[] args) {
        ControlNodeTest nodeTest = new ControlNodeTest();
        Map map = nodeTest.list2Map(nodeTest.getParams2());
        System.out.println(map);
    }

    //四级节点测试
    private List getParams2() {
        //父节点 001
        Map<String, Object> map = new HashMap<>();
        map.put("level_num", "1");
        map.put("level_code", "001");
        map.put("control_type", "SUB");
        map.put("fill_amount", "");
        //二级子节点 001001
        Map<String, Object> map1 = new HashMap<>();
        map1.put("level_num", "2");
        map1.put("level_code", "001001");
        map1.put("control_type", "SELF");
        map1.put("fill_amount", "1");
        //二级子节点 001002
        Map<String, Object> map11 = new HashMap<>();
        map11.put("level_num", "2");
        map11.put("level_code", "001002");
        map11.put("control_type", "SUB");
        map11.put("fill_amount", "");
        //三级子节点 001002001
        Map<String, Object> map111 = new HashMap<>();
        map111.put("level_num", "3");
        map111.put("level_code", "001002001");
        map111.put("control_type", "SELF");
        map111.put("fill_amount", "1");
        //三级子节点 001002002
        Map<String, Object> map1111 = new HashMap<>();
        map1111.put("level_num", "3");
        map1111.put("level_code", "001002002");
        map1111.put("control_type", "SUB");
        map1111.put("fill_amount", "");
        //四级子节点 001002002001
        Map<String, Object> map11111 = new HashMap<>();
        map11111.put("level_num", "4");
        map11111.put("level_code", "001002002001");
        map11111.put("control_type", "SELF");
        map11111.put("fill_amount", "1");
        //四级子节点 001002002002
        Map<String, Object> map111111 = new HashMap<>();
        map111111.put("level_num", "4");
        map111111.put("level_code", "001002002002");
        map111111.put("control_type", "SELF");
        map111111.put("fill_amount", "1");
        // 父节点 002
        Map<String, Object> map2 = new HashMap<>();
        map2.put("level_num", "1");
        map2.put("level_code", "002");
        map2.put("control_type", "SELF");
        map2.put("fill_amount", "3");
        //二级子节点 002001
        Map<String, Object> map3 = new HashMap<>();
        map3.put("level_num", "2");
        map3.put("level_code", "002001");
        map3.put("control_type", "SUPER");
        map3.put("fill_amount", "");
        //二级子节点 002002
        Map<String, Object> map33 = new HashMap<>();
        map33.put("level_num", "2");
        map33.put("level_code", "002002");
        map33.put("control_type", "SUPER");
        map33.put("fill_amount", "");

        List<Map> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map111);
        list.add(map11);
        list.add(map1111);
        list.add(map11111);
        list.add(map111111);
        return list;
    }

    private Map<String, Object> list2Map(List<Map> sectionList) {
        int len = 3;
        Map<String, Object> resultMap = new HashMap<>(); //所有节点
        Map<String, Object> leafMap = new HashMap<>();  //下级控制节点
        //把所有节点放到map里
        for (Map map : sectionList) {
            resultMap.put(map.get("level_code").toString(), (map.get("fill_amount") != null && !"".equals(map.get("fill_amount"))) ? map.get("fill_amount") : 0);
        }
        Collections.reverse(sectionList); //倒序
        for (Map map : sectionList) {
            String control_type = map.get("control_type").toString(); // 项目控制类型
            int levelNum = TypeUtils.castToInt(map.get("level_num"));
            String parentLevelCode = map.get("level_code").toString();
            if ("SUB".equals(control_type)) {//如果是下级控制
                List<Map<String, Object>> childList = getChildListByParentLevelCode(sectionList, parentLevelCode, levelNum);

                for (Map<String, Object> map1 : childList) {
                    String childLevelCode = map1.get("level_code").toString();
                    resultMap.put(parentLevelCode, TypeUtils.castToBigDecimal(resultMap.get(parentLevelCode)).add(TypeUtils.castToBigDecimal(resultMap.get(childLevelCode))));
                }

            }
        }

        return resultMap;
    }

    private List getChildListByParentLevelCode(List<Map> sectionList, String parentLevelCode, int parentLevelNum) {
        List<Map<String, Object>> childList = new ArrayList();
        for (Map map : sectionList) {
            String levelCode = map.get("level_code").toString();
            int levelNum = TypeUtils.castToInt(map.get("level_num"));
            int boolNum = parentLevelNum + 1;
            if (levelCode.startsWith(parentLevelCode) && (boolNum == levelNum)) {
                childList.add(map);
            }
        }
        return childList;
    }

}
