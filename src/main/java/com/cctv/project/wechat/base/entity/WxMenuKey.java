package com.cctv.project.wechat.base.entity;

import java.io.Serializable;

/**
 * wx_menu
 * @author 
 */
public class WxMenuKey implements Serializable {
    /**
     * 菜单ID
     */
    private Long menu_id;

    /**
     * 菜单名称
     */
    private String menu_name;

    private static final long serialVersionUID = 1L;

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
}