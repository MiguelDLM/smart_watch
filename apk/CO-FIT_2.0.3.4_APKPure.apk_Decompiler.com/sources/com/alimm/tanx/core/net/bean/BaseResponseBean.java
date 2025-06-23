package com.alimm.tanx.core.net.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;

public class BaseResponseBean<T> extends BaseBean {
    @JSONField(name = "seat")
    private T data;
    @JSONField(name = "id")
    private int id;
    private int status;

    public T getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
