package com.xmall.user.repository.persistence;

import com.xmall.user.repository.facade.UserAccountRepository;
import com.xmall.user.repository.mapper.UserAccountMapper;
import com.xmall.user.repository.po.UserAccount;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户账户仓储实现类
 *
 * @author zhouxufu
 */
@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    private final UserAccountMapper userAccountMapper;

    public UserAccountRepositoryImpl(UserAccountMapper userAccountMapper) {
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public UserAccount registerByPhone(UserAccount userAccount) {
        return null;
    }

    @Override
    public boolean phoneExists(String phone) {
        UserAccount userAccount = new UserAccount();
        userAccount.setPhone(phone);
        return userAccountMapper.countUserAccount(userAccount) > 0;
    }

    @Override
    public boolean emailExists(String email) {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(email);
        return userAccountMapper.countUserAccount(userAccount) > 0;
    }

    @Override
    public boolean usernameExists(String username) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        return userAccountMapper.countUserAccount(userAccount) > 0;
    }

}
