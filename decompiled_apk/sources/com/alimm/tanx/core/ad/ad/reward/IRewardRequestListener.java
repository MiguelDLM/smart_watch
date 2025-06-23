package com.alimm.tanx.core.ad.ad.reward;

import com.alimm.tanx.core.request.TanxError;
import java.util.Map;

/* loaded from: classes.dex */
public interface IRewardRequestListener {
    void onError(TanxError tanxError);

    void onRewardArrived(boolean z, int i, Map<String, Object> map);
}
