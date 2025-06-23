package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_if implements IMonitorBean {
    private List<String> tanxc_do;
    private List<? extends ITrackItem> tanxc_for;
    private List<String> tanxc_if;
    private String tanxc_int;

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<String> getClickTrackUrl() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<? extends ITrackItem> getEventTrack() {
        return this.tanxc_for;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public List<String> getImpTrackUrl() {
        return this.tanxc_do;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMonitorBean
    public String getWinNoticeUrl() {
        return this.tanxc_int;
    }

    public void tanxc_do(List<String> list) {
        this.tanxc_do = list;
    }

    public void tanxc_for(List<? extends ITrackItem> list) {
        this.tanxc_for = list;
    }

    public void tanxc_if(List<String> list) {
        this.tanxc_if = list;
    }

    public void tanxc_do(String str) {
        this.tanxc_int = str;
    }
}
