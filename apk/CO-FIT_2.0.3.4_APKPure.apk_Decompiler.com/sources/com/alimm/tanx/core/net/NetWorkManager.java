package com.alimm.tanx.core.net;

import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

public class NetWorkManager<T> implements INetWork<T>, NotConfused {
    private static final String TAG = "NetWorkManager";
    private static INetWork iNetWork;
    private static NetWorkManager instance;

    public NetWorkManager() {
    }

    public static NetWorkManager getInstance() {
        if (instance == null) {
            synchronized (NetWorkManager.class) {
                try {
                    if (instance == null) {
                        instance = new NetWorkManager(TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getNetWork());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public void cancelOkHttpTag(String str) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.cancelOkHttpTag(str);
            return;
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "cancelOkHttpTag ->iNetWork == null,清设置请求网络库实例", "");
    }

    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpDownload(requestBean, onDownloadListener);
            return;
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpDownload->iNetWork == null,清设置请求网络库实例", "");
    }

    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, netWorkCallBack);
            return;
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
    }

    public void sendHttpPost(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpPost(requestBean, cls, true, netWorkCallBack);
    }

    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            return iNetWork2.sendSyncHttpPost2Gzip(requestBean, cls);
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendSyncHttpPost2Gzip->iNetWork == null,清设置请求网络库实例", "");
        return null;
    }

    public void setINetWork(INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }

    public NetWorkManager(INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }

    public void sendHttpPost(RequestBean requestBean, Class<T> cls, boolean z, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpPost(requestBean, cls, z, netWorkCallBack);
            return;
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpPost->iNetWork == null,清设置请求网络库实例", "");
    }

    public void sendHttpGet(RequestBean requestBean, Class cls, boolean z, boolean z2, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, z, z2, netWorkCallBack);
            return;
        }
        LogUtils.e(TAG, "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TAG, "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
    }
}
