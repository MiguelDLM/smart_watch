package com.jieli.jl_rcsp.model.device;

import java.util.List;

/* loaded from: classes10.dex */
public class AlarmListInfo {
    private List<AlarmBean> alarmBeans;
    private int version;

    public AlarmListInfo(List<AlarmBean> list) {
        setAlarmBeans(list);
    }

    public List<AlarmBean> getAlarmBeans() {
        return this.alarmBeans;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAlarmBeans(List<AlarmBean> list) {
        this.alarmBeans = list;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public AlarmListInfo(int i, List<AlarmBean> list) {
        this.version = i;
        this.alarmBeans = list;
    }
}
