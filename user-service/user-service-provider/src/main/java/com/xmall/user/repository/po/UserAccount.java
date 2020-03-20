package com.xmall.user.repository.po;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

/**
 * @author zhouxufu
 */
@Data
@Table(name = "user_account")
public class UserAccount {

    /**
     * 用户账号状态
     * -1：已删除；
     * 0：禁用 （禁止在注册）
     * 1：启用
     */
    public static final Byte DELETE_STATUS = Byte.valueOf("-1");
    public static final Byte DISABLE_STATUS = Byte.valueOf("0");
    public static final Byte ENABLE_STATUS = Byte.valueOf("1");

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String username;

    private String phone;

    private String email;

    private String password;

    private Byte status;

    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;
}