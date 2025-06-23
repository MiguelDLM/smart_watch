package com.baidu.ar.filter;

import java.util.List;

/* loaded from: classes7.dex */
public class FilterModel {
    private String kd;
    private String rs;
    private List<Object> rt;

    public String getFilterName() {
        return this.kd;
    }

    public String getFilterType() {
        return this.rs;
    }

    public List<Object> getUniformList() {
        return this.rt;
    }

    public void setFilterName(String str) {
        this.kd = str;
    }

    public void setFilterType(String str) {
        this.rs = str;
    }

    public void setUniformList(List<Object> list) {
        this.rt = list;
    }
}
