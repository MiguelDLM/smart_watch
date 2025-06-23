package com.kwad.sdk.core.f.a;

import android.content.Context;
import com.kwad.sdk.utils.s;

/* loaded from: classes11.dex */
public final class i {
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            return (String) s.callMethod(s.h("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
        } catch (Exception unused) {
            return "";
        }
    }
}
