package com.qq.e.comm.pi;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: classes11.dex */
public interface UBVI extends LADI {
    void destroy();

    void fetchAd();

    String getAdNetWorkName();

    void onWindowFocusChanged(boolean z);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
