package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes11.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String aBd;
    public String aBe;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g FP() {
        return new g();
    }

    public final g ey(String str) {
        this.aBd = str;
        return this;
    }
}
