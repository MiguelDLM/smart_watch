package com.alimm.tanx.core.net.okhttp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.bean.DownLoadRequestBean;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.bean.UtErrorBean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.EncryptUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import okhttp3.Response;

public class OkHttpNetWorkImpl<T> implements INetWork<T>, NotConfused {
    private static final String TAG = "OkHttpNetWorkImpl";
    long netTime = 0;

    private String getTag(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        if (!TextUtils.isEmpty(requestBean.getTag())) {
            return requestBean.getTag();
        }
        if (netWorkCallBack != null) {
            return netWorkCallBack.getClass().toString();
        }
        return "";
    }

    private boolean isNull(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        if (requestBean != null) {
            return false;
        }
        if (netWorkCallBack == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$succCallBack$14(NetWorkCallBack netWorkCallBack, Object obj, String str) {
        LogUtils.d(TAG, "当前线程post succCallBack：" + Thread.currentThread().getName());
        if (netWorkCallBack instanceof AdNetWorkCallBack) {
            ((AdNetWorkCallBack) netWorkCallBack).succ(obj, str);
        } else {
            netWorkCallBack.succ(obj);
        }
    }

    /* access modifiers changed from: private */
    public void succCallBack(Class<T> cls, String str, NetWorkCallBack netWorkCallBack) {
        tanxc_do.tanxc_do().tanxc_for().post(new oIX0oI(netWorkCallBack, JSON.parseObject(str, cls), str));
    }

    public void cancelOkHttpTag(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.e("OkHttp ", "tag为空，无法cancelOkHttpTag");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "OkHttp ", "tag为空，无法cancelOkHttpTag", "");
            return;
        }
        tanxc_do.tanxc_do().tanxc_do(str);
    }

    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        try {
            if (!isNull(requestBean, onDownloadListener)) {
                DownLoadRequestBean downLoadRequestBean = (DownLoadRequestBean) requestBean;
                tanxc_do.tanxc_try().tanxc_for(downLoadRequestBean.getUrl()).tanxc_int(getTag((RequestBean) downLoadRequestBean, onDownloadListener)).tanxc_do(downLoadRequestBean.getPath()).tanxc_if(downLoadRequestBean.getFileName()).tanxc_do(downLoadRequestBean.isResume()).tanxc_do().tanxc_do(onDownloadListener);
            }
        } catch (Exception e) {
            LogUtils.e("sendHttpDownload", e);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            int intCode = utErrorCode.getIntCode();
            onDownloadListener.onDownloadFailed(intCode, utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e));
        }
    }

    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpGet(requestBean, cls, true, true, netWorkCallBack);
    }

    public void sendHttpPost(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpPost(requestBean, cls, true, netWorkCallBack);
    }

    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        if (requestBean == null) {
            return null;
        }
        try {
            Response tanxc_do = tanxc_do.tanxc_if(true).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(EncryptUtils.encrypt(requestBean.getJson(), false)).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(false);
            if (tanxc_do != null) {
                String str = "";
                if (tanxc_do.body() != null) {
                    String string = tanxc_do.body().string();
                    if (string != null) {
                        str = string;
                    }
                }
                LogUtils.d(TAG, "result:->" + str);
                String decrypt = EncryptUtils.decrypt(str, false);
                if (!TextUtils.isEmpty(decrypt)) {
                    return JSON.parseObject(decrypt, cls);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("sendSyncHttpPost2Gzip", e);
        }
        return null;
    }

    private boolean isNull(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (requestBean != null) {
            return false;
        }
        if (onDownloadListener == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        int intCode = utErrorCode.getIntCode();
        onDownloadListener.onDownloadFailed(intCode, "downLoad接口请求参数判空:" + utErrorCode.getMsg());
        return true;
    }

    public void sendHttpGet(RequestBean requestBean, final Class cls, boolean z, final boolean z2, final NetWorkCallBack netWorkCallBack) {
        try {
            if (!isNull(requestBean, netWorkCallBack)) {
                tanxc_do.tanxc_new().tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_if(requestBean.getCacheOfflineTime()).tanxc_do(requestBean.getCacheOnlineTime()).tanxc_do(requestBean.isOnlyOneNet()).tanxc_for(requestBean.getTryAgainCount()).tanxc_do().tanxc_do((ResultCall) new ResultCall() {
                    public void inProgress(float f) {
                    }

                    public void onAfter() {
                    }

                    public void onBefore() {
                    }

                    public void onError(int i, String str) {
                        NetWorkCallBack netWorkCallBack = netWorkCallBack;
                        if (netWorkCallBack != null) {
                            netWorkCallBack.error(i, "", str);
                        }
                        LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                        TanxBaseUt.utError(i, OkHttpNetWorkImpl.TAG, str, "OkHttp");
                    }

                    public void onSuccess(String str) {
                        NetWorkCallBack netWorkCallBack = netWorkCallBack;
                        if (netWorkCallBack != null) {
                            try {
                                if (z2) {
                                    netWorkCallBack.succ(JSON.parseObject(str, cls));
                                } else {
                                    netWorkCallBack.succ(str);
                                }
                            } catch (Exception e) {
                                onError(UtErrorCode.NETWORK_ERROR.getIntCode(), e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            LogUtils.e("sendHttpGet", e);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            int intCode = utErrorCode.getIntCode();
            netWorkCallBack.error(intCode, "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e));
        }
    }

    public void sendHttpPost(RequestBean requestBean, Class<T> cls, boolean z, NetWorkCallBack netWorkCallBack) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.netTime = 0;
        try {
            if (!isNull(requestBean, netWorkCallBack)) {
                LogUtils.d(TAG, "当前线程post：" + Thread.currentThread().getName());
                final NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                final RequestBean requestBean2 = requestBean;
                final boolean z2 = z;
                final Class<T> cls2 = cls;
                tanxc_do.tanxc_if(false).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(z ? EncryptUtils.encrypt(requestBean.getJson()) : requestBean.getJson()).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do((ResultCall) new ResultCall() {
                    public void inProgress(float f) {
                    }

                    public void onAfter() {
                    }

                    public void onBefore() {
                    }

                    public void onError(int i, String str) {
                        OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                        LogUtils.d("splashTimeConsuming", "netTimeAll onError->" + OkHttpNetWorkImpl.this.netTime);
                        NetWorkCallBack netWorkCallBack = netWorkCallBack2;
                        if (netWorkCallBack != null) {
                            netWorkCallBack.error(i, "", str);
                        }
                        LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                        TanxBaseUt.utNetError(i, OkHttpNetWorkImpl.TAG, new UtErrorBean(requestBean2, i, str), "OkHttp");
                    }

                    public void onSuccess(String str) {
                        LogUtils.d(OkHttpNetWorkImpl.TAG, "当前线程post onSuccess：" + Thread.currentThread().getName());
                        OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                        LogUtils.d("splashTimeConsuming", "netTimeAll onSuccess->" + OkHttpNetWorkImpl.this.netTime);
                        LogUtils.d(OkHttpNetWorkImpl.TAG, str);
                        if (netWorkCallBack2 != null) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    int intCode = UtErrorCode.DATA_PARSE_ERROR.getIntCode();
                                    onError(intCode, "response:" + str);
                                } else if (z2) {
                                    LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt before-> " + str);
                                    String decrypt = EncryptUtils.decrypt(str);
                                    LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt -> " + decrypt);
                                    if (TextUtils.isEmpty(decrypt)) {
                                        int intCode2 = UtErrorCode.DECRYPT_ERROR.getIntCode();
                                        onError(intCode2, "decrypt error:" + str);
                                        return;
                                    }
                                    OkHttpNetWorkImpl.this.succCallBack(cls2, decrypt, netWorkCallBack2);
                                } else {
                                    OkHttpNetWorkImpl.this.succCallBack(cls2, str, netWorkCallBack2);
                                    LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp noDecrypt-> " + str);
                                }
                            } catch (Exception e) {
                                onError(UtErrorCode.NETWORK_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e));
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            LogUtils.e("sendHttpPost", e);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            int intCode = utErrorCode.getIntCode();
            netWorkCallBack.error(intCode, "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e));
        }
    }

    private String getTag(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (!TextUtils.isEmpty(requestBean.getTag())) {
            return requestBean.getTag();
        }
        if (onDownloadListener != null) {
            return onDownloadListener.getClass().toString();
        }
        return "";
    }

    private String getTag(RequestBean requestBean) {
        if (!TextUtils.isEmpty(requestBean.getTag())) {
            return requestBean.getTag();
        }
        return System.currentTimeMillis() + "";
    }
}
