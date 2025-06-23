package com.baidu.mshield.x6.recv;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes7.dex */
public class a extends com.baidu.mshield.x6.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6451a;
    public final /* synthetic */ Intent b;

    public a(MyReceiver myReceiver, Context context, Intent intent) {
        this.f6451a = context;
        this.b = intent;
    }

    @Override // com.baidu.mshield.x6.e.a.a
    public void a() {
        MyReceiver.d(this.f6451a, this.b);
    }
}
