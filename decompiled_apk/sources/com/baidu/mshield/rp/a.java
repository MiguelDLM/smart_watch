package com.baidu.mshield.rp;

import android.content.Context;

/* loaded from: classes7.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6377a;

    public a(Receiver receiver, Context context) {
        this.f6377a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(this.f6377a);
        com.baidu.mshield.utility.a.a(this.f6377a, a2.v() * 3600000);
        a2.a(System.currentTimeMillis());
    }
}
