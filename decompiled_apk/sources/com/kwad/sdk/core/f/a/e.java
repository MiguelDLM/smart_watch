package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes11.dex */
public final class e {
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                if (call.getInt("code", -1) == 0) {
                    str = call.getString("id");
                }
                call.getString("message");
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
