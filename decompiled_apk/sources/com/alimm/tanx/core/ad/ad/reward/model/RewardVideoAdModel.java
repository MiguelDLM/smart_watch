package com.alimm.tanx.core.ad.ad.reward.model;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener;
import com.alimm.tanx.core.ad.ad.reward.tanxc_do;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.bean.RewardResponse;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.RewardRequest;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RewardVideoAdModel extends BaseModel {
    /* JADX INFO: Access modifiers changed from: private */
    public void loopReward(RewardResponse rewardResponse, IRewardRequestListener iRewardRequestListener) {
        String str;
        int i;
        if (iRewardRequestListener != null) {
            try {
                if (rewardResponse != null) {
                    if (rewardResponse.getPidRewards() != null && rewardResponse.getPidRewards().size() > 0) {
                        for (int i2 = 0; i2 < rewardResponse.getPidRewards().size(); i2++) {
                            RewardResponse.PidRewards pidRewards = rewardResponse.getPidRewards().get(i2);
                            if (pidRewards.getTaskType() == 3) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("pid", pidRewards.getPid());
                            hashMap.put("taskType", Integer.valueOf(pidRewards.getTaskType()));
                            hashMap.put("sessionId", pidRewards.getSessionId());
                            hashMap.put("completeTime", pidRewards.getCompleteTime());
                            hashMap.put("rewardName", pidRewards.getRewardName());
                            hashMap.put("rewardCount", Integer.valueOf(pidRewards.getRewardCount()));
                            iRewardRequestListener.onRewardArrived(true, i, hashMap);
                        }
                        return;
                    }
                    String requestId = rewardResponse.getRequestId();
                    UtErrorCode utErrorCode = UtErrorCode.REWARD_QUERY_NULL;
                    iRewardRequestListener.onError(new TanxError(requestId, utErrorCode.getIntCode(), utErrorCode.getMsg()));
                    return;
                }
                if (rewardResponse != null) {
                    str = rewardResponse.getRequestId();
                } else {
                    str = "";
                }
                UtErrorCode utErrorCode2 = UtErrorCode.ERROR_QUERY_REWARD;
                iRewardRequestListener.onError(new TanxError(str, utErrorCode2.getIntCode(), utErrorCode2.getMsg()));
            } catch (Exception e) {
                LogUtils.e("loopReward", e);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return "rewardVideo";
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(AdInfo adInfo) {
        String str;
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && !TextUtils.isEmpty(adInfo.getRequestId()) && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                    List<BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        Iterator<BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new tanxc_do(this.adSlot, it.next(), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
                this.requestListener.onSuccess(arrayList);
                return;
            }
        }
        ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
        if (adInfo != null) {
            str = adInfo.getRequestId();
        } else {
            str = "";
        }
        iTanxRequestListener.onError(new TanxError(str, TanxError.ERROR_ADINFO_ADCOUNT_NULL));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    public void sendRewardRequest(RewardRequestBean rewardRequestBean, final IRewardRequestListener iRewardRequestListener) {
        new RewardRequest().request(rewardRequestBean, new NetWorkCallBack<RewardResponse>() { // from class: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.2
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i, String str, String str2) {
                iRewardRequestListener.onError(new TanxError(str, i, str2));
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(RewardResponse rewardResponse) {
                RewardVideoAdModel.this.loopReward(rewardResponse, iRewardRequestListener);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(AdInfo adInfo, boolean z, int i) {
        tanxc_do tanxc_doVar = null;
        r0 = null;
        BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxc_doVar = new tanxc_do(this.adSlot, bidInfo, adInfo.getRequestId(), getScene());
        }
        TanxCommonUt.utTimer(tanxc_doVar, z, i);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(final TanxAdSlot tanxAdSlot, final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_REWARD_VIDEO);
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener() { // from class: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onSuccess(list);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onTimeOut();
                }
            }
        }, j);
    }
}
