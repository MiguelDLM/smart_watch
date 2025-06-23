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

public class RewardRequest extends tanxc_if<RewardRequestBean, RewardResponse> implements NotConfused {
    private static final String TAG = "RewardRequest";

    /* access modifiers changed from: private */
    public Integer getTriggerEvent(RewardRequestBean rewardRequestBean) {
        if (rewardRequestBean != null) {
            return rewardRequestBean.trigger_event;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void suc(RewardResponse rewardResponse, Integer num, String str, long j, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        if (netWorkCallBack == null) {
            return;
        }
        if (rewardResponse == null) {
            UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, utErrorCode.getIntCode(), "RewardResponse解析为空", str);
        } else if (rewardResponse.getStatus() == 1) {
            LogUtils.d(TAG, "loopReward过程状态码为1");
            if (num == null) {
                return;
            }
            if (num.intValue() == 1 || num.intValue() == 3) {
                UtErrorCode utErrorCode2 = UtErrorCode.REWARD_QUERY_NULL;
                int intCode = utErrorCode2.getIntCode();
                netWorkCallBack.error(intCode, "", utErrorCode2.getMsg() + ",server_code:1");
            }
        } else if (rewardResponse.getStatus() == 0) {
            netWorkCallBack.succ(rewardResponse);
            TanxCommonUt.sendRewardRqSuc(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, rewardResponse);
        } else {
            int status = rewardResponse.getStatus();
            netWorkCallBack.error(status, rewardResponse.getRequestId(), "查询服务端错误码信息");
            TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j, status, "查询服务端错误码信息", str);
        }
    }

    public boolean checkRequestBefore(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        return true;
    }

    public boolean useDeviceIdCache() {
        return false;
    }

    public RequestBean buildRequestBean(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getRewardUrl());
        String jSONString = JSON.toJSONString(super.buildBaseRequestBeanData(rewardRequestBean));
        LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    public boolean checkDeviceId(RewardRequestBean rewardRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (rewardRequestBean == null || (adDeviceBean = rewardRequestBean.device) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(adDeviceBean.imei) || !TextUtils.isEmpty(rewardRequestBean.device.oaid)) {
            return true;
        }
        return false;
    }

    public boolean checkInitData(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RewardRequestBean.RewardUserBean rewardUserBean;
        if (rewardRequestBean == null || (rewardUserBean = rewardRequestBean.user) == null || checkStrNull(rewardUserBean.media_uid)) {
            UtErrorCode utErrorCode = UtErrorCode.MEDIA_UID_NULL;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            return true;
        }
        List<RewardRequestBean.PidVerifications> list = rewardRequestBean.task_check;
        if (list == null || list.size() <= 0) {
            UtErrorCode utErrorCode2 = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        for (int i = 0; i < rewardRequestBean.task_check.size(); i++) {
            if (rewardRequestBean.task_check.get(i) == null || TextUtils.isEmpty(rewardRequestBean.task_check.get(i).pid)) {
                UtErrorCode utErrorCode3 = UtErrorCode.PID_NULL;
                netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
                return false;
            }
        }
        return true;
    }

    public void request(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        super.request(rewardRequestBean, netWorkCallBack);
    }

    public void sendRequest(RewardRequestBean rewardRequestBean, RequestBean requestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final NetWorkCallBack<RewardResponse> netWorkCallBack2 = netWorkCallBack;
        final RequestBean requestBean2 = requestBean;
        final RewardRequestBean rewardRequestBean2 = rewardRequestBean;
        NetWorkManager.getInstance().sendHttpPost(requestBean, RewardResponse.class, new NetWorkCallBack<RewardResponse>() {
            public void error(int i, String str, String str2) {
                String json;
                NetWorkCallBack netWorkCallBack = netWorkCallBack2;
                if (netWorkCallBack != null) {
                    netWorkCallBack.error(i, str, str2);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                    RequestBean requestBean = requestBean2;
                    if (requestBean == null) {
                        json = "";
                    } else {
                        json = requestBean.getJson();
                    }
                    TanxCommonUt.sendRewardRqFail(str, elapsedRealtime, i, str2, json);
                }
            }

            /* renamed from: tanxc_do */
            public void succ(RewardResponse rewardResponse) {
                String json;
                Integer access$000 = RewardRequest.this.getTriggerEvent(rewardRequestBean2);
                RequestBean requestBean = requestBean2;
                if (requestBean == null) {
                    json = "";
                } else {
                    json = requestBean.getJson();
                }
                RewardRequest.suc(rewardResponse, access$000, json, elapsedRealtime, netWorkCallBack2);
            }
        });
    }
}
