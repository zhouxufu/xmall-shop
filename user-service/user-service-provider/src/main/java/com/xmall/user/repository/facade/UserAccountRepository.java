package com.xmall.user.repository.facade;

import com.xmall.user.repository.po.UserAccount;

/**
 * 用户仓储门面模式
 *
 * @author zhouxufu
 */
public interface UserAccountRepository {

    /**
     * 注册用户通过手机号
     *
     * @param
     * @return
     */
    UserAccount registerByPhone(UserAccount userAccount);

    /**
     * 检查手机号是否注册
     *
     * @param phone
     * @return
     */
    boolean phoneExists(String phone);

    /**
     * email 是否已存在
     *
     * @param email
     * @return
     */
    boolean emailExists(String email);

    /**
     * 查询username 是否已存在
     *
     * @param username
     * @return
     */
    boolean usernameExists(String username);
}
