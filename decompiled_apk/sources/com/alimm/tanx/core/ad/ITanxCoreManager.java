package com.alimm.tanx.core.ad;

import android.content.Context;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;

/* loaded from: classes.dex */
public interface ITanxCoreManager {
    ITanxRequestLoader createRequestLoader(Context context);

    String getSDKVersion();
}
