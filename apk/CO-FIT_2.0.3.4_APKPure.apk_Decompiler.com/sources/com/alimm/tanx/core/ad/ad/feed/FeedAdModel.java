package com.alimm.tanx.core.ad.ad.feed;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

public class FeedAdModel extends BaseModel {
    private void preload(List<tanxc_do> list, boolean z) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    final ITanxAd iTanxAd = list.get(i2);
                    VideoCacheManager.getInstance().preload(iTanxAd, z, (PreloadListener) new PreloadListener() {
                        public void onCached(String str) {
                            TanxCommonUt.cacheCheck(iTanxAd, str, 0, (Exception) null);
                        }

                        public void onError(String str, Exception exc) {
                            TanxCommonUt.cacheCheck(iTanxAd, str, 1, exc);
                        }

                        public void onStartCached(ITanxAd iTanxAd) {
                        }
                    });
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    private BidInfo updateData(BidInfo bidInfo) {
        try {
            if (bidInfo.getTemplateConf() != null && !TextUtils.isEmpty(bidInfo.getTemplateConf().getRenderUrl()) && !TextUtils.isEmpty(bidInfo.getSubMaterials())) {
                String renderUrl = bidInfo.getTemplateConf().getRenderUrl();
                StringBuilder sb = new StringBuilder(LocationInfo.NA);
                Map map = (Map) JSON.parse(bidInfo.getSubMaterials());
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        sb.append((String) entry.getKey());
                        sb.append("=");
                        sb.append((String) entry.getValue());
                        sb.append("&");
                    }
                    if (sb.toString().length() >= 2) {
                        String sb2 = sb.toString();
                        if (sb2.substring(sb2.length() - 1, sb2.length()).equals("&")) {
                            sb2 = sb2.substring(0, sb2.length() - 1);
                        }
                        bidInfo.getTemplateConf().setRenderUrl(renderUrl + sb2);
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return bidInfo;
    }

    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    public void onSuccess(AdInfo adInfo) {
        String str;
        if (this.requestListener != null) {
            if (!(adInfo == null || adInfo.getSeatList() == null || adInfo.getSeatList().size() <= 0)) {
                boolean z = false;
                if (!(adInfo.getSeatList().get(0) == null || adInfo.getSeatList().get(0).getBidList() == null || adInfo.getSeatList().get(0).getBidList().size() <= 0)) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                        List<BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                        if (bidList != null && bidList.size() > 0) {
                            for (BidInfo updateData : bidList) {
                                arrayList.add(new tanxc_do(this.adSlot, updateData(updateData), adInfo.getRequestId(), getScene()));
                            }
                        }
                    }
                    TanxAdSlot tanxAdSlot = this.adSlot;
                    if (tanxAdSlot != null && tanxAdSlot.isCacheUnderWifi()) {
                        z = true;
                    }
                    preload(arrayList, z);
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
    }

    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0);
    }

    public void timerCancelNotify(AdInfo adInfo, boolean z, int i) {
    }

    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_FEED);
        final TanxAdSlot tanxAdSlot2 = tanxAdSlot;
        final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxFeedAd>() {
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot2, TanxInterfaceUt.REQUEST_FEED, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener2;
                if (iTanxRequestListener != null) {
                    iTanxRequestListener.onError(tanxError);
                }
            }

            public void onSuccess(List<ITanxFeedAd> list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot2, TanxInterfaceUt.REQUEST_FEED, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener2;
                if (iTanxRequestListener != null) {
                    iTanxRequestListener.onSuccess(list);
                }
            }

            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot2, TanxInterfaceUt.REQUEST_FEED, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener2;
                if (iTanxRequestListener != null) {
                    iTanxRequestListener.onTimeOut();
                }
            }
        }, j);
    }
}
