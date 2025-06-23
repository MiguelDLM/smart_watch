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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes.dex */
public class FeedAdModel extends BaseModel {
    private void preload(List<tanxc_do> list, boolean z) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    final tanxc_do tanxc_doVar = list.get(i2);
                    VideoCacheManager.getInstance().preload(tanxc_doVar, z, new PreloadListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedAdModel.2
                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                        public void onCached(String str) {
                            TanxCommonUt.cacheCheck(tanxc_doVar, str, 0, null);
                        }

                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                        public void onError(String str, Exception exc) {
                            TanxCommonUt.cacheCheck(tanxc_doVar, str, 1, exc);
                        }

                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
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
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        sb.append(str);
                        sb.append("=");
                        sb.append(str2);
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

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(AdInfo adInfo) {
        String str;
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            boolean z = false;
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                    List<BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        Iterator<BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new tanxc_do(this.adSlot, updateData(it.next()), adInfo.getRequestId(), getScene()));
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

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(AdInfo adInfo, boolean z, int i) {
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(final TanxAdSlot tanxAdSlot, final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_FEED);
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxFeedAd>() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedAdModel.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List<ITanxFeedAd> list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onSuccess(list);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onTimeOut();
                }
            }
        }, j);
    }
}
