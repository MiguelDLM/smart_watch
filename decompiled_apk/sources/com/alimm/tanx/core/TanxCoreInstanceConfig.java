package com.alimm.tanx.core;

import com.alimm.tanx.core.ad.listener.bean.IAdInfo;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;
import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.ISeatInfo;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.listener.request.IAdRequest;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.image.IImageLoader;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import x0oxIIIX.oIX0oI;

/* loaded from: classes.dex */
public class TanxCoreInstanceConfig implements NotConfused {
    private static volatile TanxCoreInstanceConfig instance;
    private volatile IAdInfo iAdInfo;
    private volatile IAdRequest iAdRequest;
    private volatile IBidInfo iBidInfo;
    private volatile IImageLoader iImageLoader;
    private volatile INetWork iNetWork;
    private volatile ISeatInfo iSeatInfo;
    private volatile IModel iSplashModel;
    private volatile ITanxPlayer iTanxPlayer;
    private volatile ITanxUserTracker iTanxUserTracker;
    private volatile oIX0oI iUserTracker;

    public static TanxCoreInstanceConfig getInstance() {
        if (instance == null) {
            synchronized (TanxCoreInstanceConfig.class) {
                try {
                    if (instance == null) {
                        instance = new TanxCoreInstanceConfig();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public IAdInfo getAdInfo() {
        return this.iAdInfo;
    }

    public IAdRequest getAdRequest() {
        return this.iAdRequest;
    }

    public IBidInfo getBidInfo() {
        return this.iBidInfo;
    }

    public IClickBean getClickBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getClickBean();
        }
        return null;
    }

    public IImageLoader getImageLoader() {
        return this.iImageLoader;
    }

    public IMaterialBean getMaterialBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getMaterialBean();
        }
        return null;
    }

    public IMonitorBean getMonitorBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getMonitorBean();
        }
        return null;
    }

    public INetWork getNetWork() {
        return this.iNetWork;
    }

    public ISeatInfo getSeatInfo() {
        return this.iSeatInfo;
    }

    public IModel getSplashModel() {
        return this.iSplashModel;
    }

    public ITanxPlayer getTanxPlayer() {
        return this.iTanxPlayer;
    }

    public ITanxUserTracker getTanxUserTracker() {
        return this.iTanxUserTracker;
    }

    public oIX0oI getUserTracker() {
        return this.iUserTracker;
    }

    public void setAdInfo(IAdInfo iAdInfo) {
        this.iAdInfo = iAdInfo;
    }

    public void setAdRequest(IAdRequest iAdRequest) {
        this.iAdRequest = iAdRequest;
    }

    public void setBidInfo(IBidInfo iBidInfo) {
        this.iBidInfo = iBidInfo;
    }

    public void setImageLoader(IImageLoader iImageLoader) {
        this.iImageLoader = iImageLoader;
    }

    public void setNetWork(INetWork iNetWork) {
        this.iNetWork = iNetWork;
    }

    public void setSeatInfo(ISeatInfo iSeatInfo) {
        this.iSeatInfo = iSeatInfo;
    }

    public void setSplashModel(IModel iModel) {
        this.iSplashModel = iModel;
    }

    public void setTanxPlayer(ITanxPlayer iTanxPlayer) {
        this.iTanxPlayer = iTanxPlayer;
    }

    public void setTanxUserTracker(ITanxUserTracker iTanxUserTracker) {
        this.iTanxUserTracker = iTanxUserTracker;
    }

    public void setUserTracker(oIX0oI oix0oi) {
        this.iUserTracker = oix0oi;
    }
}
