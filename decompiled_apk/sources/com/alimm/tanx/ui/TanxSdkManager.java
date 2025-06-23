package com.alimm.tanx.ui;

import android.content.Context;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest;
import com.alimm.tanx.core.ad.listener.reward.TanxRewardRequest;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.loader.NewTanxAdLoader;
import com.alimm.tanx.core.ad.loader.TanxRequestLoader;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.ui.ad.ITanxSdkManager;

/* loaded from: classes.dex */
public class TanxSdkManager extends TanxCoreManager implements ITanxSdkManager, NotConfused {

    /* loaded from: classes.dex */
    public static class SingletonHolder implements NotConfused {
        static final TanxSdkManager INSTANCE = new TanxSdkManager();

        private SingletonHolder() {
        }
    }

    public static TanxSdkManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public ITanxAdLoader createAdLoader(Context context) {
        return new NewTanxAdLoader(context);
    }

    @Override // com.alimm.tanx.core.TanxCoreManager, com.alimm.tanx.core.ad.ITanxCoreManager
    public ITanxRequestLoader createRequestLoader(Context context) {
        return new TanxRequestLoader();
    }

    @Override // com.alimm.tanx.ui.ad.ITanxSdkManager
    public ITanxRewardRequest createRewardRequest(Context context) {
        return new TanxRewardRequest();
    }
}
