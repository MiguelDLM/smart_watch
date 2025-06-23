package com.alimm.tanx.core.request;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.AdRequestBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.ArrayList;

public class AdRequest extends tanxc_if<AdRequestBean, AdInfo> implements NotConfused {
    private static final String TAG = "AdRequest";

    /* access modifiers changed from: private */
    public TanxAdSlot getAdSlot(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            return null;
        }
        return tanxAdSlot;
    }

    /* access modifiers changed from: private */
    public String getPid(AdRequestBean adRequestBean) {
        if (getAdSlot(adRequestBean) != null) {
            return getAdSlot(adRequestBean).getPid();
        }
        return "";
    }

    /* access modifiers changed from: private */
    public String getReqId(AdRequestBean adRequestBean) {
        if (adRequestBean != null) {
            return adRequestBean.id;
        }
        return "";
    }

    /* access modifiers changed from: private */
    public String getReqJson(RequestBean requestBean) {
        if (requestBean == null || requestBean.getJson() == null) {
            return "";
        }
        return requestBean.getJson();
    }

    /* access modifiers changed from: private */
    public String getScene(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            return "未知";
        }
        return TanxAdType.getAdTypeStr(tanxAdSlot.getAdType());
    }

    /* access modifiers changed from: private */
    public void suc(AdInfo adInfo, String str, String str2, long j, TanxAdSlot tanxAdSlot, String str3, String str4, NetWorkCallBack<AdInfo> netWorkCallBack) {
        String msg;
        NetWorkCallBack<AdInfo> netWorkCallBack2 = netWorkCallBack;
        if (netWorkCallBack2 == null) {
            return;
        }
        if (adInfo == null) {
            UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
            netWorkCallBack2.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), utErrorCode.getMsg(), str2);
        } else if (adInfo.getStatus() == 0) {
            adInfo.setDecrypt(str);
            netWorkCallBack2.succ(tanxc_do.tanxc_do(adInfo));
            TanxCommonUt.sendAdRqSuc(str3, tanxAdSlot, adInfo.getRequestId(), SystemClock.elapsedRealtime() - j, adInfo.getAdCount(), adInfo);
        } else {
            int status = adInfo.getStatus();
            if (status == 1) {
                msg = UtErrorCode.SERVER_RETURN_1.getMsg();
            } else {
                msg = UtErrorCode.SERVER_RETURN_ERROR.getMsg();
            }
            String str5 = msg;
            netWorkCallBack2.error(status, adInfo.getRequestId(), str5);
            TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j, status, str5, str2);
        }
    }

    public boolean checkRequestBefore(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        return true;
    }

    public boolean useDeviceIdCache() {
        return false;
    }

    public RequestBean buildRequestBean(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        try {
            RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getAdUrl());
            AdRequestBean adRequestBean2 = (AdRequestBean) super.buildBaseRequestBeanData(adRequestBean);
            adRequestBean2.imp = new ArrayList();
            int i = 1;
            int max = Math.max(adRequestBean2.tanxAdSlot.getAdCount(), 1);
            if (adRequestBean2.tanxAdSlot.getAdCount() > 10) {
                max = 10;
            }
            for (int i2 = 0; i2 < max; i2++) {
                AdRequestBean.AdImpBean adImpBean = new AdRequestBean.AdImpBean();
                adImpBean.pid = adRequestBean2.tanxAdSlot.getPid();
                adImpBean.native_template_id = adRequestBean2.tanxAdSlot.getNativeTemplateId();
                adImpBean.slot_num = 1;
                adImpBean.id = String.valueOf(i2);
                adRequestBean2.imp.add(adImpBean);
            }
            if (adRequestBean2.user == null) {
                adRequestBean2.user = new AdRequestBean.AdUserBean();
            }
            adRequestBean2.user.user_tag = TanxCoreSdk.getConfig().getUserTag();
            adRequestBean2.user.media_uid = adRequestBean2.tanxAdSlot.getMediaUid();
            adRequestBean2.ext = adRequestBean2.tanxAdSlot.getExt();
            adRequestBean2.https_required = true;
            adRequestBean2.version = 1;
            if (!adRequestBean2.tanxAdSlot.isExpressRender()) {
                i = 2;
            }
            adRequestBean2.render_type = i;
            String jSONString = JSON.toJSONString(adRequestBean2);
            LogUtils.d(TAG, jSONString);
            buildBaseRequestBeanUrl.setJson(jSONString);
            return buildBaseRequestBeanUrl;
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            return null;
        }
    }

    public boolean checkDeviceId(AdRequestBean adRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (adRequestBean == null || (adDeviceBean = adRequestBean.device) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(adDeviceBean.imei) || !TextUtils.isEmpty(adRequestBean.device.oaid)) {
            return true;
        }
        return false;
    }

    public boolean checkInitData(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            UtErrorCode utErrorCode = UtErrorCode.REQUEST_BEAN_ERROR;
            int intCode = utErrorCode.getIntCode();
            netWorkCallBack.error(intCode, "", utErrorCode.getMsg() + " :adRequestBean");
            return false;
        } else if (TextUtils.isEmpty(tanxAdSlot.getPid())) {
            UtErrorCode utErrorCode2 = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        } else if (!TextUtils.isEmpty(adRequestBean.tanxAdSlot.getMediaUid())) {
            return true;
        } else {
            if (adRequestBean.tanxAdSlot.getAdType() != 4 && adRequestBean.tanxAdSlot.getAdType() != 3) {
                return true;
            }
            UtErrorCode utErrorCode3 = UtErrorCode.MEDIA_UID_NULL;
            netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
            return false;
        }
    }

    public void request(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        super.request(adRequestBean, netWorkCallBack);
    }

    public void sendRequest(AdRequestBean adRequestBean, RequestBean requestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final NetWorkCallBack<AdInfo> netWorkCallBack2 = netWorkCallBack;
        final AdRequestBean adRequestBean2 = adRequestBean;
        final RequestBean requestBean2 = requestBean;
        NetWorkManager.getInstance().sendHttpPost(requestBean, AdInfo.class, new AdNetWorkCallBack<AdInfo>() {
            public void error(int i, String str, String str2) {
                NetWorkCallBack netWorkCallBack = netWorkCallBack2;
                if (netWorkCallBack != null) {
                    netWorkCallBack.error(i, str, str2);
                    TanxCommonUt.sendAdRqFail(AdRequest.this.getScene(adRequestBean2), AdRequest.this.getPid(adRequestBean2), AdRequest.this.getReqId(adRequestBean2), SystemClock.elapsedRealtime() - elapsedRealtime, i, str2, AdRequest.this.getReqJson(requestBean2));
                }
            }

            /* renamed from: tanxc_do */
            public void succ(AdInfo adInfo) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, "", adRequest.getReqJson(requestBean2), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean2), AdRequest.this.getScene(adRequestBean2), AdRequest.this.getReqId(adRequestBean2), netWorkCallBack2);
            }

            /* renamed from: tanxc_do */
            public void succ(AdInfo adInfo, String str) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, str, adRequest.getReqJson(requestBean2), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean2), AdRequest.this.getScene(adRequestBean2), AdRequest.this.getReqId(adRequestBean2), netWorkCallBack2);
            }
        });
    }
}
