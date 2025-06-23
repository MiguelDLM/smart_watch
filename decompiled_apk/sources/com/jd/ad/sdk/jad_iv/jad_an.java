package com.jd.ad.sdk.jad_iv;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class jad_an {
    public final ConcurrentHashMap<String, jad_dq> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, WeakReference<View>> jad_bo = new ConcurrentHashMap<>();

    /* renamed from: com.jd.ad.sdk.jad_iv.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0687jad_an {
        public static final jad_an jad_an = new jad_an();
    }
}
