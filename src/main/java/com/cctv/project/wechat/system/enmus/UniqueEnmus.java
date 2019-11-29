package com.cctv.project.wechat.system.enmus;

/**
 * 错误码
 * @author by yanhao
 */
public enum UniqueEnmus {
    OK("0"),ERROR ("1");

    UniqueEnmus(String code){
        this.code = code;
    }
    private String code;


    public String getCode() {
        return code;
    }
}
