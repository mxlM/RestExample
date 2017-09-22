package com.panodata.conf.response;

/**
 * 错误码的枚举
 * Created by wp_sp on 2017/3/24.
 */
public enum ResponseErrorEnum {
    /**
     * 参数错误
     */
    ERROR_A01("参数错误", "A01"),
    /**
     * token不存在
     */
    ERROR_A02("token不存在", "A02"),
    /**
     * 商户不存在或数据异常
     */
    ERROR_A03("商户不存在或数据异常", "A03"),
    /**
     * 商户已被拉黑
     */
    ERROR_A04("商户已被拉黑", "A04"),
    /**
     * 商户无权限访问该接口
     */
    ERROR_A05("商户无权限访问该接口", "A05"),
    /**
     * 获取token服务异常
     */
    ERROR_A06("获取token服务异常", "A06"),
    /**
     * 未传递必填参数
     */
    ERROR_A07("未传递必填参数", "A07"),
    /**
     * 查询结果异常
     */
    ERROR_A08("未查询到结果", "A08"),
    /**
     *限制查询数
     */
    ERROR_A09("一分钟内限制查询200次", "A09"),
    /**
     *查询次数不足
     */
    ERROR_A10("查询次数不足", "A10"),
    /**
     * 服务端异常
     */
    ERROR_B01("服务异常", "B01"),
    /**
     * 系统异常
     */
    ERROR_C01("系统异常", "C01"),
    /**
     * 代理关闭
     */
    ERROR_D01("代理关闭", "D01");

    // 成员变量
    private String name;
    private String index;

    // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
    ResponseErrorEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(String index) {
        for (ResponseErrorEnum c : ResponseErrorEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }

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
