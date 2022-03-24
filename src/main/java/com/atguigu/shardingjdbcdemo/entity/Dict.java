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
@TableName("t_udict")//指定对应表
public class Dict implements Serializable {


    private static final long serialVersionUID = 1661275080450946027L;
    private Long dictid;

    private String ustatus;

    private String uvalue;
}
