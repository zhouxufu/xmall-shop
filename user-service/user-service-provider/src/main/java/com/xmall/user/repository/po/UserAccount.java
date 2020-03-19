package com.xmall.user.repository.po;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author zhouxufu
 */
@Data
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String username;

    private String phone;

    private String email;

    private String password;

    private Byte status;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;
}