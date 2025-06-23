package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.baidu.nplatform.comapi.MapItem;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public final class c extends com.kwad.sdk.core.network.b {

    @NonNull
    public final Map<String, String> aID;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aID = hashMap;
        hashMap.put("did", str);
        hashMap.put(MapItem.KEY_ITEM_SID, str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aID;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return BNWebViewClient.URL_HTTPS_PREFIX + com.kwad.sdk.core.network.idc.a.EE().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
