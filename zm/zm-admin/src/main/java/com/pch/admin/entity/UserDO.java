package com.pch.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class UserDO implements Serializable {
    private static final long serialVersionUID = -3738608720624167303L;
    private Long id;
    private String userName;
    private Integer age;
    private Integer sex;
}
