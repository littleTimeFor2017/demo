package com.example.test.datasource;

/**
 * @author Bruce Lee
 * @date 2021/7/20
 * @description
 **/
public class MultiDataSourceHolder {

    private static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<>();
    private static final ThreadLocal<String> TABLE_INDEX_HOLDER = new ThreadLocal<>();


    public static void setDataSourceKey(String dsKey) {
        DATA_SOURCE_HOLDER.set(dsKey);
    }

    public static void setTableIndexKey(String tableIndexKey) {
        DATA_SOURCE_HOLDER.set(tableIndexKey);
    }

    public static Object getDataSourceKey() {
        return DATA_SOURCE_HOLDER.get();
    }

    public static String geyTableIndexKey() {
        return TABLE_INDEX_HOLDER.get();
    }

    public static void clearDataSourceKey() {
        DATA_SOURCE_HOLDER.remove();
    }

    public static void tableIndexKey() {
        TABLE_INDEX_HOLDER.remove();
    }
}
