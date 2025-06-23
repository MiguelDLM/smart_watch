package com.baidu.nplatform.comapi.map;

import android.view.ViewParent;

/* loaded from: classes8.dex */
public interface g {

    /* loaded from: classes8.dex */
    public interface a {
        void a(g gVar);
    }

    void awakeDrawWaitEvent();

    ViewParent getParent();

    int getVisibility();

    void setDetachWindowListener(a aVar);

    void setVisibility(int i);
}
