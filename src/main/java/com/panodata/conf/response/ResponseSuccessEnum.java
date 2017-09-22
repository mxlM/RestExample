package com.panodata.conf.response;

/**
 * Created by wp_sp on 2017/3/28.
 */
public enum ResponseSuccessEnum  {
    SUCCESS("请求正常", "200");

    // 成员变量
    private String name;
    private String index;

    // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
    ResponseSuccessEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(String index) {
        for (ResponseSuccessEnum c : ResponseSuccessEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
