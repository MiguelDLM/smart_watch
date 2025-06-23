package com.kwad.components.core.n.b.a;

import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.components.offline.api.core.network.IIdc;

/* loaded from: classes11.dex */
public final class m implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.h.yA();
        }
        return BNWebViewClient.URL_HTTPS_PREFIX + com.kwad.sdk.core.network.idc.a.EE().W(str, null);
    }
}
