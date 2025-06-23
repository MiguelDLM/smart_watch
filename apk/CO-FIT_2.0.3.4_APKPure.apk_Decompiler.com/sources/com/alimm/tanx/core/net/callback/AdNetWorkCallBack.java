package com.alimm.tanx.core.net.callback;

public interface AdNetWorkCallBack<T> extends NetWorkCallBack<T> {
    void succ(T t, String str);
}
