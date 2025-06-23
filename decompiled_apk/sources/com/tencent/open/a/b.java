package com.tencent.open.a;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes13.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f26942a = new HashMap<>();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f26942a.put(str, bundle.getString(str));
            }
        }
    }
}
