package com.alimm.tanx.core.ad;

import android.content.Context;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;

public interface ITanxCoreManager {
    ITanxRequestLoader createRequestLoader(Context context);

    String getSDKVersion();
}
