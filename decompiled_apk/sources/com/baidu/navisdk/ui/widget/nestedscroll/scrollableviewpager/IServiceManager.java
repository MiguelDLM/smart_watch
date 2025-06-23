package com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager;

/* loaded from: classes8.dex */
public interface IServiceManager {
    <T> T getService(Class<T> cls);

    <T> void register(Class<T> cls, T t);
}
