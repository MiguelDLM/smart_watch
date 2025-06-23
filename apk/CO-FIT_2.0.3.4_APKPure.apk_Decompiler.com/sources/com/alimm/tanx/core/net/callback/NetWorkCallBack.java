package com.alimm.tanx.core.net.callback;

public interface NetWorkCallBack<T> {
    void error(int i, String str, String str2);

    void succ(T t);
}
