package com.atguigu.shardingjdbcdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Program Name: shardingjdbcdemo
 * Created by yanlp on 2022-03-11
 *
 * @author yanlp
 * @version 1.0
 */
@Data
public class Course implements Serializable {

    private static final long serialVersionUID = 1155122234786751028L;

    private Long cid;

    private String cname;

    private Long userId;

    private String cstatus;
}
