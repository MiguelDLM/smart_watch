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

/* loaded from: classes.dex */
public class AdRequest extends tanxc_if<AdRequestBean, AdInfo> implements NotConfused {
    private static final String TAG = "AdRequest";

    /* JADX INFO: Access modifiers changed from: private */
    public TanxAdSlot getAdSlot(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean != null && (tanxAdSlot = adRequestBean.tanxAdSlot) != null) {
            return tanxAdSlot;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPid(AdRequestBean adRequestBean) {
        if (getAdSlot(adRequestBean) != null) {
            return getAdSlot(adRequestBean).getPid();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReqId(AdRequestBean adRequestBean) {
        if (adRequestBean != null) {
            return adRequestBean.id;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReqJson(RequestBean requestBean) {
        if (requestBean != null && requestBean.getJson() != null) {
            return requestBean.getJson();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getScene(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean != null && (tanxAdSlot = adRequestBean.tanxAdSlot) != null) {
            return TanxAdType.getAdTypeStr(tanxAdSlot.getAdType());
        }
        return "未知";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suc(AdInfo adInfo, String str, String str2, long j, TanxAdSlot tanxAdSlot, String str3, String str4, NetWorkCallBack<AdInfo> netWorkCallBack) {
        String msg;
        if (netWorkCallBack != null) {
            if (adInfo != null) {
                if (adInfo.getStatus() == 0) {
                    adInfo.setDecrypt(str);
                    netWorkCallBack.succ(tanxc_do.tanxc_do(adInfo));
                    TanxCommonUt.sendAdRqSuc(str3, tanxAdSlot, adInfo.getRequestId(), SystemClock.elapsedRealtime() - j, adInfo.getAdCount(), adInfo);
                    return;
                }
                int status = adInfo.getStatus();
                if (status == 1) {
                    msg = UtErrorCode.SERVER_RETURN_1.getMsg();
                } else {
                    msg = UtErrorCode.SERVER_RETURN_ERROR.getMsg();
                }
                String str5 = msg;
                netWorkCallBack.error(status, adInfo.getRequestId(), str5);
                TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j, status, str5, str2);
                return;
            }
            UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), utErrorCode.getMsg(), str2);
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkRequestBefore(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean useDeviceIdCache() {
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
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

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkDeviceId(AdRequestBean adRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (adRequestBean == null || (adDeviceBean = adRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(adRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkInitData(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean != null && (tanxAdSlot = adRequestBean.tanxAdSlot) != null) {
            if (TextUtils.isEmpty(tanxAdSlot.getPid())) {
                UtErrorCode utErrorCode = UtErrorCode.PID_NULL;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                return false;
            }
            if (!TextUtils.isEmpty(adRequestBean.tanxAdSlot.getMediaUid())) {
                return true;
            }
            if (adRequestBean.tanxAdSlot.getAdType() != 4 && adRequestBean.tanxAdSlot.getAdType() != 3) {
                return true;
            }
            UtErrorCode utErrorCode2 = UtErrorCode.MEDIA_UID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        UtErrorCode utErrorCode3 = UtErrorCode.REQUEST_BEAN_ERROR;
        netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg() + " :adRequestBean");
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void request(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        super.request((AdRequest) adRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void sendRequest(final AdRequestBean adRequestBean, final RequestBean requestBean, final NetWorkCallBack<AdInfo> netWorkCallBack) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        NetWorkManager.getInstance().sendHttpPost(requestBean, AdInfo.class, new AdNetWorkCallBack<AdInfo>() { // from class: com.alimm.tanx.core.request.AdRequest.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i, String str, String str2) {
                NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i, str, str2);
                    TanxCommonUt.sendAdRqFail(AdRequest.this.getScene(adRequestBean), AdRequest.this.getPid(adRequestBean), AdRequest.this.getReqId(adRequestBean), SystemClock.elapsedRealtime() - elapsedRealtime, i, str2, AdRequest.this.getReqJson(requestBean));
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(AdInfo adInfo) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, "", adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
            }

            @Override // com.alimm.tanx.core.net.callback.AdNetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(AdInfo adInfo, String str) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, str, adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
            }
        });
    }
}
