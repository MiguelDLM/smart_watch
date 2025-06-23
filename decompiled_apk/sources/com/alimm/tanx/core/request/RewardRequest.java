package com.alimm.tanx.core.request;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.bean.RewardResponse;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class RewardRequest extends tanxc_if<RewardRequestBean, RewardResponse> implements NotConfused {
    private static final String TAG = "RewardRequest";

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getTriggerEvent(RewardRequestBean rewardRequestBean) {
        if (rewardRequestBean != null) {
            return rewardRequestBean.trigger_event;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void suc(RewardResponse rewardResponse, Integer num, String str, long j, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (rewardResponse != null) {
                if (rewardResponse.getStatus() == 1) {
                    LogUtils.d(TAG, "loopReward过程状态码为1");
                    if (num != null) {
                        if (num.intValue() == 1 || num.intValue() == 3) {
                            UtErrorCode utErrorCode = UtErrorCode.REWARD_QUERY_NULL;
                            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + ",server_code:1");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (rewardResponse.getStatus() == 0) {
                    netWorkCallBack.succ(rewardResponse);
                    TanxCommonUt.sendRewardRqSuc(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, rewardResponse);
                    return;
                } else {
                    int status = rewardResponse.getStatus();
                    netWorkCallBack.error(status, rewardResponse.getRequestId(), "查询服务端错误码信息");
                    TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, status, "查询服务端错误码信息", str);
                    return;
                }
            }
            UtErrorCode utErrorCode2 = UtErrorCode.DATA_PARSE_ERROR;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, utErrorCode2.getIntCode(), "RewardResponse解析为空", str);
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkRequestBefore(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean useDeviceIdCache() {
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public RequestBean buildRequestBean(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getRewardUrl());
        String jSONString = JSON.toJSONString(super.buildBaseRequestBeanData(rewardRequestBean));
        LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkDeviceId(RewardRequestBean rewardRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (rewardRequestBean == null || (adDeviceBean = rewardRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(rewardRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public boolean checkInitData(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RewardRequestBean.RewardUserBean rewardUserBean;
        if (rewardRequestBean != null && (rewardUserBean = rewardRequestBean.user) != null && !checkStrNull(rewardUserBean.media_uid)) {
            List<RewardRequestBean.PidVerifications> list = rewardRequestBean.task_check;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < rewardRequestBean.task_check.size(); i++) {
                    if (rewardRequestBean.task_check.get(i) == null || TextUtils.isEmpty(rewardRequestBean.task_check.get(i).pid)) {
                        UtErrorCode utErrorCode = UtErrorCode.PID_NULL;
                        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                        return false;
                    }
                }
                return true;
            }
            UtErrorCode utErrorCode2 = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        UtErrorCode utErrorCode3 = UtErrorCode.MEDIA_UID_NULL;
        netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void request(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        super.request((RewardRequest) rewardRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_if
    public void sendRequest(final RewardRequestBean rewardRequestBean, final RequestBean requestBean, final NetWorkCallBack<RewardResponse> netWorkCallBack) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        NetWorkManager.getInstance().sendHttpPost(requestBean, RewardResponse.class, new NetWorkCallBack<RewardResponse>() { // from class: com.alimm.tanx.core.request.RewardRequest.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i, String str, String str2) {
                String json;
                NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i, str, str2);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    RequestBean requestBean2 = requestBean;
                    if (requestBean2 == null) {
                        json = "";
                    } else {
                        json = requestBean2.getJson();
                    }
                    TanxCommonUt.sendRewardRqFail(str, elapsedRealtime2, i, str2, json);
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(RewardResponse rewardResponse) {
                String json;
                Integer triggerEvent = RewardRequest.this.getTriggerEvent(rewardRequestBean);
                RequestBean requestBean2 = requestBean;
                if (requestBean2 == null) {
                    json = "";
                } else {
                    json = requestBean2.getJson();
                }
                RewardRequest.suc(rewardResponse, triggerEvent, json, elapsedRealtime, netWorkCallBack);
            }
        });
    }
}
