package com.example.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: GetSignatureIdTest
 * @description: TODO
 * @Author: Wilson
 * @createTime 2020/10/20 11:22
 */
public class GetSignatureIdTest {


    static String name = "德清滨海燃气有限公司";
    static String json = "{\n" +
            "  \"message\": \"Operation OK.\",\n" +
            "  \"contract\": {\n" +
            "    \"invitations\": [\n" +
            "      \n" +
            "    ],\n" +
            "    \"docType\": \"pdf\",\n" +
            "    \"status\": 1,\n" +
            "    \"docHash\": \"419e99eed1edfe4e640c2935c7fe26b2\",\n" +
            "    \"pages\": 4,\n" +
            "    \"lastUpdated\": \"2020-12-30T14:57:51+0800\",\n" +
            "    \"signatures\": [\n" +
            "      {\n" +
            "        \"signatureId\": \"a3426b89-3665-4813-946e-511c60be38a4\",\n" +
            "        \"page\": 1,\n" +
            "        \"positionX\": 0,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 80,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": false,\n" +
            "        \"sealId\": \"1d6f5003-882f-492b-b583-f69691af5b68\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"signatureId\": \"778f07f2-d6e4-40a5-b13c-2e5c8d71088f\",\n" +
            "        \"page\": 2,\n" +
            "        \"positionX\": 0,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 80,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": false,\n" +
            "        \"sealId\": \"1d6f5003-882f-492b-b583-f69691af5b68\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"signatureId\": \"d025b9f4-3cd2-4e19-9b19-6478a5cb20cf\",\n" +
            "        \"page\": 3,\n" +
            "        \"positionX\": 0,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 80,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": false,\n" +
            "        \"sealId\": \"1d6f5003-882f-492b-b583-f69691af5b68\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"signatureId\": \"30137218-61dc-4a4e-a48a-f43ec124b0e8\",\n" +
            "        \"page\": 4,\n" +
            "        \"positionX\": 0,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 80,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": false,\n" +
            "        \"sealId\": \"1d6f5003-882f-492b-b583-f69691af5b68\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"signingTime\": \"2020-12-30T14:57:51+0800\",\n" +
            "        \"signatureId\": \"55c3bf56-1594-48ae-bba9-ee2d1cba9dd4\",\n" +
            "        \"certId\": \"21c866fb-2feb-40f3-88a9-f86324966a91\",\n" +
            "        \"page\": 4,\n" +
            "        \"positionX\": 219,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 255,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": true,\n" +
            "        \"sealId\": \"65b9aac3-e837-4722-8d2b-376465e2fa95\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"signatureId\": \"939a6b77-a767-4c5a-a4e3-5a27f731efff\",\n" +
            "        \"page\": 4,\n" +
            "        \"positionX\": 392,\n" +
            "        \"userId\": \"3f585d7a-5026-4498-8f23-b41a77ff20cf\",\n" +
            "        \"positionY\": 257,\n" +
            "        \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "        \"isSigned\": false,\n" +
            "        \"sealId\": \"041491ec-5ecd-438d-a798-27714bebf92c\",\n" +
            "        \"fullname\": \"德清滨海燃气有限公司\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"docNum\": \"20201230145545701\",\n" +
            "    \"title\": \"2020123014524608037954475_encryfile\",\n" +
            "    \"signatureData\": null,\n" +
            "    \"dateCreated\": \"2020-12-30T14:55:47+0800\",\n" +
            "    \"contractId\": \"faf24f18-2e34-4ae6-a86b-310f084c8e6f\",\n" +
            "    \"docData\": null\n" +
            "  },\n" +
            "  \"isOk\": true,\n" +
            "  \"code\": 0\n" +
            "}";


    /**
     * 根据传入的名称获取对应的普通章signatureId
     * 返回结果可能会有多个
     *
     * @param name 要查询的用户名
     * @param json 签章结果json
     * @param flag 大小标志，true，排除最大的，false 排除最小的
     * @return
     */
    public static List<String> getSignatureIds(String name, String json, boolean flag) {
        List<String> result = new ArrayList<>();
        List<Integer> xList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        try {
            JSONObject object = JSONObject.parseObject(json);
            JSONArray jsonArray = object.getJSONObject("contract").getJSONArray("signatures");
            Integer pages = object.getJSONObject("contract").getInteger("pages");
            System.out.println("当前和同总页数：" + pages);
            if (jsonArray.size() > 0) {
                for (Object obj : jsonArray) {
                    JSONObject jsonObject1 = (JSONObject) obj;
                    String fullName = jsonObject1.getString("fullname");
                    if (name.equalsIgnoreCase(fullName)) {
                        Integer x = jsonObject1.getInteger("positionX");
                        if (x != null) {
                            xList.add(x);
                            idList.add(x + "&" + jsonObject1.getString("signatureId"));
                        }
                    }
                }
            }
            int xMax = -1;
            int xMin = Integer.MAX_VALUE;
            if (xList.size() > 0) {
                for (Integer x : xList) {
                    xMax = x > xMax ? x : xMax;
                    xMin = x < xMin ? x : xMin;
                }
                for (String x_id : idList) {
                    String xStr = x_id.split("&")[0];
                    if (flag) {
                        if (Integer.parseInt(xStr) < xMax) {
                            result.add(x_id.split("&")[1]);
                        }
                    } else {
                        if (Integer.parseInt(xStr) > xMin) {
                            result.add(x_id.split("&")[1]);
                        }
                    }

                }
            }
            for (String signatureID : result) {
                System.out.println(signatureID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        getSignatureIds(name, json, false);
    }
}
