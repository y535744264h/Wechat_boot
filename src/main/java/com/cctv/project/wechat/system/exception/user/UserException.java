package com.cctv.project.wechat.system.exception.user;

import com.cctv.project.wechat.system.exception.base.BaseException;

/**
 * 用户信息异常类
 * @author by yanhao
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
