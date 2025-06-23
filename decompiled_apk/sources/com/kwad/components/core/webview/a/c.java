package com.kwad.components.core.webview.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;

@KsJson
/* loaded from: classes11.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String JK;
    public String Ww;
    public String Wx;
    public int Wy;

    public final AdInfo.SmallAppJumpInfo aJ(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.Ww;
        smallAppJumpInfo.smallAppJumpUrl = this.Wx;
        return smallAppJumpInfo;
    }
}
