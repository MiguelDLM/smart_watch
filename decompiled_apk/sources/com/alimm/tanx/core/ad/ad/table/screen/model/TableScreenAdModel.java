package com.alimm.tanx.core.ad.ad.table.screen.model;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.table.screen.tanxc_do;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TableScreenAdModel extends BaseModel {
    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return TanxAdType.TABLE_SCREEN_STRING;
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
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_TABLE_SCREEN);
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener() { // from class: com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenAdModel.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_TABLE_SCREEN, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_TABLE_SCREEN, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onSuccess(list);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_TABLE_SCREEN, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onTimeOut();
                }
            }
        }, j);
    }
}
