package com.alimm.tanx.core.ad.ad.splash.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.alimm.tanx.core.ad.ad.splash.TanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.model.ISplashModel;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.common.AdTask;
import com.alimm.tanx.core.common.tanxc_do;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplashAdModel extends BaseModel implements ISplashModel {
    private static final String DEVICE_HEIGHT = "device_height";
    private static final int ERROR_NO_CACHE_LIST = -1000;
    private static final String TAG = "SplashAdModel";
    /* access modifiers changed from: private */
    public int fromType;
    /* access modifiers changed from: private */
    public boolean isSyncReq;
    /* access modifiers changed from: private */
    public final Context mContext = TanxCoreSdk.getApplication();
    private int mLoadDataCode;
    private String mRequestId = "";

    /* access modifiers changed from: private */
    public void cacheAdInfo(String str) {
        TanxAdSlot tanxAdSlot;
        try {
            if (!TextUtils.isEmpty(str) && (tanxAdSlot = this.adSlot) != null) {
                if (!TextUtils.isEmpty(tanxAdSlot.getPid())) {
                    String splashAdResponseFile = SplashAdCacheManager.getSplashAdResponseFile(this.mContext, this.adSlot.getPid());
                    LogUtils.d(TAG, "cacheAdInfo fileName= " + splashAdResponseFile);
                    FileUtils.saveStr2File(splashAdResponseFile, str);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "cacheAdInfo error", (Throwable) e);
            int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
            TanxBaseUt.utError(intCode, TAG, "cacheAdInfo error" + LogUtils.getStackTraceMessage(e), "");
        }
    }

    private void cacheAndManageAsset(final AdInfo adInfo) {
        if (adInfo != null) {
            tanxc_do.tanxc_do(new AdTask(new Runnable() {
                public void run() {
                    if (!SplashAdModel.this.isSyncReq) {
                        SplashAdModel.this.cacheAdInfo(JSON.toJSONString(adInfo));
                        SplashAdCacheManager.getInstance().clearCachedAdvIds();
                        if (adInfo != null) {
                            SplashAdCacheManager.getInstance().setPreRequestId(adInfo.getRequestId());
                        }
                    }
                    com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(SplashAdModel.this.mContext);
                    AdInfo adInfo = adInfo;
                    if (!(adInfo == null || adInfo.getBidInfoList() == null || adInfo.getBidInfoList().size() <= 0)) {
                        for (BidInfo creativeName : adInfo.getBidInfoList()) {
                            com.alimm.tanx.core.ad.ad.splash.tanxc_do.tanxc_do().tanxc_do(SplashAdModel.this.mContext, creativeName.getCreativeName(), 0);
                        }
                    }
                    SplashAdCacheManager.getInstance().trimLocalCache();
                    SplashAdCacheManager.getInstance().downloadAdAsset(adInfo.getBidInfoList());
                }
            }, "handleRequestResponse"));
        }
    }

    /* access modifiers changed from: private */
    public BidInfo chooseAd(boolean z) {
        String str;
        boolean z2;
        SplashAdCacheManager.getInstance().trimLocalCache2Json();
        TanxAdSlot tanxAdSlot = this.adSlot;
        if (tanxAdSlot != null) {
            str = tanxAdSlot.getPid();
        } else {
            str = "";
        }
        AdInfo adInfoFromCache = getAdInfoFromCache(str);
        StringBuilder sb = new StringBuilder();
        sb.append("chooseAd: cold = ");
        sb.append(z);
        sb.append(", hasAdInfo = ");
        if (adInfoFromCache != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        LogUtils.d(TAG, sb.toString());
        if (adInfoFromCache == null || adInfoFromCache.getAdCount() <= 0) {
            this.mLoadDataCode = UtErrorCode.ERROR_NO_AD_ITEM.getIntCode();
            LogUtils.e("chooseAd", "预请求无广告节点");
            return null;
        }
        this.mRequestId = adInfoFromCache.getRequestId();
        boolean z3 = false;
        for (BidInfo next : adInfoFromCache.getBidInfoList()) {
            TanxSplashAd tanxSplashAd = new TanxSplashAd(this.adSlot, next, adInfoFromCache.getRequestId(), 0, getScene());
            if (isDuringRelease(next)) {
                TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, true, 0);
                if (isAssetExists(next)) {
                    LogUtils.d(TAG, "chooseAd: isAssetExists bidInfo = " + next);
                    if (!this.hasTimeOut) {
                        cancel();
                        TanxSplashUt.utSplashTimer(tanxSplashAd, 0, true, 0);
                        ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
                        if (iTanxRequestListener != null) {
                            iTanxRequestListener.onSuccess(Arrays.asList(new TanxSplashAd[]{tanxSplashAd}));
                        }
                        TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, true, 0);
                    } else {
                        int intCode = UtErrorCode.ERROR_AD_TIME_OUT.getIntCode();
                        this.mLoadDataCode = intCode;
                        TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, false, intCode);
                    }
                    return next;
                }
                z3 = true;
            } else {
                LogUtils.d(TAG, "chooseAd: 不在投放期 bidInfo = " + next);
                int intCode2 = UtErrorCode.ERROR_AD_NOT_IN_DURING_RELEASE.getIntCode();
                this.mLoadDataCode = intCode2;
                TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, false, intCode2);
            }
        }
        if (z3) {
            this.mLoadDataCode = UtErrorCode.ERROR_NO_CACHED_ASSET.getIntCode();
        } else {
            this.mLoadDataCode = UtErrorCode.ERROR_NO_AD_DURING_RELEASE.getIntCode();
        }
        TanxSplashUt.utSplashCacheExist(new TanxSplashAd(this.adSlot, (BidInfo) null, adInfoFromCache.getRequestId(), 0, getScene()), 0, false, this.mLoadDataCode);
        return null;
    }

    private void deleteCachedAdInBackground() {
        tanxc_do.tanxc_do(new AdTask(new Runnable() {
            public void run() {
                SplashAdCacheManager.getInstance().deleteCachedResponseJson();
            }
        }, "deleteCachedAdInBackground"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alimm.tanx.core.ad.bean.AdInfo getAdInfoFromCache(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "SplashAdModel"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 0
            android.content.Context r5 = r10.mContext     // Catch:{ Exception -> 0x002f }
            java.lang.String r11 = com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashAdResponseFile(r5, r11)     // Catch:{ Exception -> 0x002f }
            java.lang.String r11 = com.alimm.tanx.core.utils.FileUtils.getStrFromFile((java.lang.String) r11)     // Catch:{ Exception -> 0x002f }
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x002f }
            if (r5 != 0) goto L_0x002d
            r5 = 1
            java.lang.Class<com.alimm.tanx.core.ad.bean.AdInfo> r6 = com.alimm.tanx.core.ad.bean.AdInfo.class
            java.lang.Object r11 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r11, r6)     // Catch:{ Exception -> 0x0028 }
            com.alimm.tanx.core.ad.bean.AdInfo r11 = (com.alimm.tanx.core.ad.bean.AdInfo) r11     // Catch:{ Exception -> 0x0028 }
            com.alimm.tanx.core.ad.bean.AdInfo r3 = com.alimm.tanx.core.request.tanxc_do.tanxc_do((com.alimm.tanx.core.ad.bean.AdInfo) r11)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0056
        L_0x0026:
            r3 = move-exception
            goto L_0x0032
        L_0x0028:
            r11 = move-exception
        L_0x0029:
            r9 = r3
            r3 = r11
            r11 = r9
            goto L_0x0032
        L_0x002d:
            r5 = 0
            goto L_0x0056
        L_0x002f:
            r11 = move-exception
            r5 = 0
            goto L_0x0029
        L_0x0032:
            java.lang.String r6 = "getAdInfoFromCache exception."
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r0, (java.lang.String) r6, (java.lang.Throwable) r3)
            com.alimm.tanx.core.ut.UtErrorCode r7 = com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR
            int r7 = r7.getIntCode()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r3 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r3)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            java.lang.String r6 = ""
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError((int) r7, (java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r6)
            r3 = r11
        L_0x0056:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r6 = "getAdInfoFromCache: time = "
            r11.append(r6)
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r1
            r11.append(r6)
            java.lang.String r1 = ",hasContent = "
            r11.append(r1)
            r11.append(r5)
            java.lang.String r1 = ", count = "
            r11.append(r1)
            if (r3 == 0) goto L_0x007b
            int r4 = r3.getAdCount()
        L_0x007b:
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.getAdInfoFromCache(java.lang.String):com.alimm.tanx.core.ad.bean.AdInfo");
    }

    private void handleRequestResponse(AdInfo adInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleRequestCallback: adInfo = ");
        sb.append(adInfo);
        String str = "";
        sb.append(str);
        LogUtils.d(TAG, sb.toString());
        if (this.isSyncReq && !this.hasTimeOut) {
            if (!(adInfo == null || adInfo.getSeatList() == null || adInfo.getSeatList().size() <= 0)) {
                if (!(adInfo.getSeatList().get(0) == null || adInfo.getSeatList().get(0).getBidList() == null || adInfo.getSeatList().get(0).getBidList().size() <= 0)) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                        List<BidInfo> bidList = adInfo.getSeatList().get(i).getBidList();
                        if (bidList != null && bidList.size() > 0) {
                            for (BidInfo next : bidList) {
                                LogUtils.d(TAG, "handleRequestCallback: bidInfo = " + next + str);
                                if (next != null) {
                                    LogUtils.d(TAG, "handleRequestCallback: 素材地址 = " + next.getCreativePath() + str);
                                }
                                arrayList.add(new TanxSplashAd(this.adSlot, next, adInfo.getRequestId(), 1, getScene()));
                            }
                        }
                    }
                    this.requestListener.onSuccess(arrayList);
                }
            }
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
            if (adInfo != null) {
                str = adInfo.getRequestId();
            }
            iTanxRequestListener.onError(new TanxError(str, TanxError.ERROR_ADINFO_ADCOUNT_NULL));
        }
        cacheAndManageAsset(adInfo);
    }

    private boolean isAssetExists(@NonNull BidInfo bidInfo) {
        return SplashAdCacheManager.getInstance().isAssetCached(bidInfo, true);
    }

    private boolean isDuringRelease(@NonNull BidInfo bidInfo) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (bidInfo.getReleaseStartTime() > currentTimeMillis || bidInfo.getReleaseEndTime() < currentTimeMillis) {
            return false;
        }
        return true;
    }

    public String getScene() {
        return TanxAdType.SPLASH_STRING;
    }

    public void onSuccess(AdInfo adInfo) {
        handleRequestResponse(adInfo);
    }

    public void requestSucc(AdInfo adInfo) {
        if (!this.isCancel) {
            checkSuccess(adInfo);
            cancel();
            timerCancelNotify(adInfo, true, 0);
        }
    }

    public void sendRequest(boolean z, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(z, tanxAdSlot, iTanxRequestListener, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.alimm.tanx.core.ad.bean.BidInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd} */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.alimm.tanx.core.ad.bean.BidInfo] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo r8, boolean r9, int r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0030
            java.util.List r1 = r8.getBidInfoList()
            if (r1 == 0) goto L_0x001e
            java.util.List r1 = r8.getBidInfoList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x001e
            java.util.List r0 = r8.getBidInfoList()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.alimm.tanx.core.ad.bean.BidInfo r0 = (com.alimm.tanx.core.ad.bean.BidInfo) r0
        L_0x001e:
            r3 = r0
            com.alimm.tanx.core.ad.ad.splash.TanxSplashAd r0 = new com.alimm.tanx.core.ad.ad.splash.TanxSplashAd
            com.alimm.tanx.core.request.TanxAdSlot r2 = r7.adSlot
            java.lang.String r4 = r8.getRequestId()
            r5 = 0
            java.lang.String r6 = r7.getScene()
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0030:
            int r8 = r7.fromType
            com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashTimer(r0, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.timerCancelNotify(com.alimm.tanx.core.ad.bean.AdInfo, boolean, int):void");
    }

    public void sendRequest(boolean z, final TanxAdSlot tanxAdSlot, final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j) {
        this.adSlot = tanxAdSlot;
        this.isSyncReq = z;
        this.requestListener = iTanxRequestListener;
        if (!z) {
            super.sendRequest(tanxAdSlot, iTanxRequestListener, j);
            LogUtils.d(TAG, "发起预请求 timeOut=" + j);
            return;
        }
        startTimer(j);
        tanxc_do.tanxc_do(new AdTask(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                LogUtils.d(SplashAdModel.TAG, "开始获取本地缓存数据 ---" + currentTimeMillis);
                BidInfo access$000 = SplashAdModel.this.chooseAd(false);
                LogUtils.d(SplashAdModel.TAG, "获取本地缓存数据结束 --- bidInfo= " + access$000 + "------" + (System.currentTimeMillis() - currentTimeMillis) + "  hasTimeOut=" + SplashAdModel.this.hasTimeOut);
                if (access$000 != null) {
                    return;
                }
                if (SplashAdModel.this.hasTimeOut) {
                    ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener;
                    if (iTanxRequestListener != null) {
                        iTanxRequestListener.onError(new TanxError("timeout"));
                        return;
                    }
                    return;
                }
                int unused = SplashAdModel.this.fromType = 1;
                LogUtils.d(SplashAdModel.TAG, "获取本地缓存无缓存 开始走实时请求逻辑---------" + System.currentTimeMillis());
                SplashAdModel.super.sendRequest(tanxAdSlot, iTanxRequestListener, 0);
            }
        }, "sendRequest", new AdTask.onErrorListener() {
            public void onError(String str) {
                iTanxRequestListener.onError(new TanxError(str));
            }
        }));
    }
}
