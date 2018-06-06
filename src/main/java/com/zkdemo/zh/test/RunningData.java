package com.zkdemo.zh.test;

import java.io.Serializable;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 * 
 * @author zhouhao
 * @version 2018年6月6日 下午3:22:30
 */
public class RunningData implements Serializable {

    private static final long serialVersionUID = 4260577459043203630L;

    // 服务器id
    private long cid;
    // 服务器名称
    private String name;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
