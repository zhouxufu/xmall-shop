package com.xmall.user.repository.persistence;

import com.xmall.user.repository.facade.UserAccountRepository;
import com.xmall.user.repository.mapper.UserAccountMapper;
import com.xmall.user.repository.po.UserAccount;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendSqls;

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
        Example example = new Example.Builder(UserAccount.class).where(WeekendSqls.<UserAccount>custom()
                .andEqualTo(UserAccount::getPhone, phone)
                .andNotEqualTo(UserAccount::getStatus, UserAccount.DELETE_STATUS)
        ).build();
        return userAccountMapper.selectCountByExample(example) > 0;
    }

    @Override
    public boolean emailExists(String email) {
        Example example = new Example.Builder(UserAccount.class).where(WeekendSqls.<UserAccount>custom()
                .andEqualTo(UserAccount::getEmail, email)
                .andNotEqualTo(UserAccount::getStatus, UserAccount.DELETE_STATUS)
        ).build();
        return userAccountMapper.selectCountByExample(example) > 0;
    }

    @Override
    public boolean usernameExists(String username) {
        Example example = new Example.Builder(UserAccount.class).where(WeekendSqls.<UserAccount>custom()
                .andEqualTo(UserAccount::getUsername, username)
                .andNotEqualTo(UserAccount::getStatus, UserAccount.DELETE_STATUS)
        ).build();
        return userAccountMapper.selectCountByExample(example) > 0;
    }

}
