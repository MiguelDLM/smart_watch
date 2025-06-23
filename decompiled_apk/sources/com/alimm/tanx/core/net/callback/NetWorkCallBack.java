package com.alimm.tanx.core.net.callback;

/* loaded from: classes.dex */
public interface NetWorkCallBack<T> {
    void error(int i, String str, String str2);

    void succ(T t);
}
