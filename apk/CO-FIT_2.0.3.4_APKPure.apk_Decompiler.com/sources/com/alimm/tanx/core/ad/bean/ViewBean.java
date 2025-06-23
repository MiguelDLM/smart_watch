package com.alimm.tanx.core.ad.bean;

import android.view.View;

public class ViewBean extends BaseBean {
    private int id;
    private String msg;
    private View view;

    public ViewBean(int i, View view2, String str) {
        this.id = i;
        this.view = view2;
        this.msg = str;
    }

    public int getId() {
        return this.id;
    }

    public String getMsg() {
        return this.msg;
    }

    public View getView() {
        return this.view;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setView(View view2) {
        this.view = view2;
    }
}
