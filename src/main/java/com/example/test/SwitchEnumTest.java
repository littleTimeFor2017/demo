package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/26
 * @Description: switch  case中case后面的值必须为编译期间就已知的结果值，使用ContractTempletEnum.getById(1).getKey()方法 运行期间才能得到值，因此不能判断
 * 比较枚举类型的switch case  应使用枚举类型整体进行比较
 */
enum ContractTempletEnum {

    PPT(1, "普通模板"),
    SIGNT(2, "签约模板");
    private Integer id;
    private String name;

    private ContractTempletEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 转换list
     *
     * @return
     */
    public static List<Map<String, Object>> toList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        ContractTempletEnum[] contractTempletEnum = ContractTempletEnum.values();
        for (ContractTempletEnum e : contractTempletEnum) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", e.getId());
            map.put("name", e.getName());
            list.add(map);
        }
        return list;
    }


    public static ContractTempletEnum getById(Integer id) {
        for (ContractTempletEnum transactType : values()) {
            if (transactType.getId() == id) {
                //获取指定的枚举
                return transactType;
            }
        }
        return null;
    }

}


public class SwitchEnumTest {

    public static void main(String[] args) {
        switch (ContractTempletEnum.getById(1)) {
            case PPT:
                break;
            case SIGNT:
                break;
        }


    }

}