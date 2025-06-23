package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class UtBean extends BaseBean {
    public BaseUtBean device;
    public List<UtItemBean> events;
    public String reqId;

    public UtBean() {
        this.reqId = uuid();
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "") + HelpFormatter.DEFAULT_OPT_PREFIX + (System.currentTimeMillis() / 1000);
    }

    public String toString() {
        return "UtBean{device=" + this.device + ", events=" + this.events + "} " + super.toString();
    }

    public UtBean(UtItemBean utItemBean) {
        this.reqId = uuid();
        this.device = new BaseUtBean();
        ArrayList arrayList = new ArrayList();
        arrayList.add(utItemBean);
        this.events = arrayList;
    }

    public UtBean(List<UtItemBean> list) {
        this.reqId = uuid();
        this.device = new BaseUtBean();
        this.events = list;
    }

    public UtBean(BaseUtBean baseUtBean, List<UtItemBean> list) {
        this.reqId = uuid();
        this.device = baseUtBean;
        this.events = list;
    }
}
