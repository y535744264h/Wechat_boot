package com.cctv.project.wechat.system.enmus;

/**
 * 用户状态
 * @author by yanhao
 * @Classname UserStatus
 * @Date 2019/11/1 11:22 上午
 */
public enum UserStatus {
    OK("0","正常"),DISABLE("1","停用"),

    DELETED("2","删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
