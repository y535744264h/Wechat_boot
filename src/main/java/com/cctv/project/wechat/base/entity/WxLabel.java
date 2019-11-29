package com.cctv.project.wechat.base.entity;

import java.io.Serializable;

/**
 * wx_label
 * @author 
 */
public class WxLabel implements Serializable {
    /**
     * 标签ID
     */
    private Long labelId;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 此标签下粉丝数
     */
    private Integer labelCount;

    private static final long serialVersionUID = 1L;

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getLabelCount() {
        return labelCount;
    }

    public void setLabelCount(Integer labelCount) {
        this.labelCount = labelCount;
    }
}