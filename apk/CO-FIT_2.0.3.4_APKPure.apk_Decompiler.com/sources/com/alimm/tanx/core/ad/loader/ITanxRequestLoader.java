package com.alimm.tanx.core.ad.loader;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import java.util.List;

public interface ITanxRequestLoader {

    public interface ITanxRequestListener<T extends ITanxAd> {
        void onError(TanxError tanxError);

        void onSuccess(List<T> list);

        void onTimeOut();
    }

    public interface OnBiddingListener<T extends ITanxAd> {
        void onResult(List<T> list);
    }

    <T extends ITanxAd> void biddingResult(List<T> list, OnBiddingListener<T> onBiddingListener);

    <T extends ITanxAd> void request(TanxAdSlot tanxAdSlot, ITanxRequestListener<T> iTanxRequestListener);

    <T extends ITanxAd> void request(TanxAdSlot tanxAdSlot, ITanxRequestListener<T> iTanxRequestListener, long j);
}
