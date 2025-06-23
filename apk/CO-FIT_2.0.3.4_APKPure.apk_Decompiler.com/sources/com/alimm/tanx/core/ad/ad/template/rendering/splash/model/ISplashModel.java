package com.alimm.tanx.core.ad.ad.template.rendering.splash.model;

import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;

public interface ISplashModel extends IModel {
    void sendRequest(boolean z, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener);

    void sendRequest(boolean z, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j);
}
