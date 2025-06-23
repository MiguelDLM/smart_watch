package com.adp.sdk.utils;

import android.content.Context;
import java.io.IOException;
import okhttp3.Call;

/* loaded from: classes.dex */
public abstract class f {
    public f(Context context) {
    }

    public abstract void a(Call call, Exception exc);

    public abstract void a(Call call, String str) throws IOException;
}
