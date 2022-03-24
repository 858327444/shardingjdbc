package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Program Name: shardingjdbcdemo
 * Created by yanlp on 2022-03-12
 *
 * @author yanlp
 * @version 1.0
 */
@Data
@TableName("t_user")//指定对应表
public class User implements Serializable {
    private static final long serialVersionUID = -1614858179761502503L;


    private Long userId;

    private String username;

    private String ustatus;
}
