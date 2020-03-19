package com.xmall.user.repository.mapper;

import com.xmall.user.repository.po.UserAccount;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhouxufu
 */
@Component
public interface UserAccountMapper extends Mapper<UserAccount> {
    /**
     * @param userAccount
     * @return
     */
    int countUserAccount(UserAccount userAccount);


}