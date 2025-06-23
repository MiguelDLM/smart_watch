package com.alimm.tanx.core.ad.loader;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.FeedAdModel;
import com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TanxRequestLoader implements ITanxRequestLoader, NotConfused {
    private boolean requestFilter() {
        return false;
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void biddingResult(List<T> list, ITanxRequestLoader.OnBiddingListener<T> onBiddingListener) {
        if (onBiddingListener != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (T t : list) {
                    if (t.getBiddingInfo() != null && t.getBiddingInfo().isBidResult()) {
                        arrayList.add(t);
                    }
                }
            }
            onBiddingListener.onResult(arrayList);
            TanxBaseUt.biddingResult(list);
            tanxc_do.tanxc_do().tanxc_do(arrayList);
        }
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public void request(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        request(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void request(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener, long j) {
        if (requestFilter()) {
            return;
        }
        tanxAdSlot.addAdSlot(2);
        new FeedAdModel().sendRequest(tanxAdSlot, iTanxRequestListener, j);
    }
}
