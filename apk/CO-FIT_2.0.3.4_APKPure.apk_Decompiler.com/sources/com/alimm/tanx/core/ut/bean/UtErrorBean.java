package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.net.bean.RequestBean;

public class UtErrorBean extends BaseBean {
    public int errorCode;
    public String msg;
    public RequestBean requestBean;

    public UtErrorBean() {
    }

    public String toString() {
        return "UtErrorBean{requestBean=" + this.requestBean + ", errorCode='" + this.errorCode + '\'' + ", msg='" + this.msg + '\'' + "} ";
    }

    public UtErrorBean(RequestBean requestBean2, int i, String str) {
        this.requestBean = requestBean2;
        this.errorCode = i;
        this.msg = str;
    }
}
