package com.baidu.mapapi.map;

/* loaded from: classes7.dex */
public interface CustomMapStyleCallBack {
    boolean onCustomMapStyleLoadFailed(int i, String str, String str2);

    boolean onCustomMapStyleLoadSuccess(boolean z, String str);

    boolean onPreLoadLastCustomMapStyle(String str);
}
