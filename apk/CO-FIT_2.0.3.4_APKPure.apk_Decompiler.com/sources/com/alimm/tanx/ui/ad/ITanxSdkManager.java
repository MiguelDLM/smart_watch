package com.alimm.tanx.ui.ad;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.reward.ITanxRewardRequest;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;

public interface ITanxSdkManager extends ITanxCoreManager {
    ITanxAdLoader createAdLoader(Context context);

    ITanxRequestLoader createRequestLoader(Context context);

    ITanxRewardRequest createRewardRequest(Context context);
}
