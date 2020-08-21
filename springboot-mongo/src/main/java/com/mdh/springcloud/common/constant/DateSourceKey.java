package com.mdh.springcloud.common.constant;

/**
 * @author madonghao
 * @create 2020-08-20 19:49
 **/
public enum DateSourceKey {

    MALL_DATA_SOURCE("mall", true),

    MASTER_DATA_SOURCE("master", false),

    COMMON_DATA_SOURCE("common", false),

    PASSPORT_DATA_SOURCE("auth", false),

    IK_EXTRA_DATA_SOURCE("ikextra", false),
    ;


    /**
     * 全局数据源名称 对应application.yml中的数据源名称
     */
    private String key;
    /**
     * 是否默认数据源，有且只能有一个默认数据源
     */
    private Boolean defaultDs;

    DateSourceKey(String key, Boolean defaultDs) {
        this.key = key;
        this.defaultDs = defaultDs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean isDefaultDs() {
        return defaultDs;
    }

    public void setDefaultDs(Boolean defaultDs) {
        this.defaultDs = defaultDs;
    }
}
