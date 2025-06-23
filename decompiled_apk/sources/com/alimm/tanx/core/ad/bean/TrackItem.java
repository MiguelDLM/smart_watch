package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import java.util.List;

/* loaded from: classes.dex */
public class TrackItem extends BaseBean implements ITrackItem {

    @JSONField(name = "time")
    private int time;

    @JSONField(name = "type")
    private int type;

    @JSONField(name = "url")
    private List<String> url;

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getTime() {
        return this.time;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public int getType() {
        return this.type;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.ITrackItem
    public List<String> getUrl() {
        return this.url;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(List<String> list) {
        this.url = list;
    }
}
