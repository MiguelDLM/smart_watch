package com.alimm.tanx.core.net;

import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;

/* loaded from: classes.dex */
public interface INetWork<T> {
    void cancelOkHttpTag(String str);

    void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, boolean z, boolean z2, NetWorkCallBack netWorkCallBack);

    void sendHttpPost(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    void sendHttpPost(RequestBean requestBean, Class<T> cls, boolean z, NetWorkCallBack netWorkCallBack);

    T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls);
}
