package com.baidu.mshield.x0.receiver;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.b.a.b;

/* loaded from: classes7.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6425a;
    public final /* synthetic */ Intent c;

    public a(ReceiverWork receiverWork, Context context, Intent intent) {
        this.f6425a = context;
        this.c = intent;
    }

    @Override // com.baidu.mshield.x0.b.a.b
    public void a() {
        ReceiverWork.b(this.f6425a, this.c);
        ReceiverWork.a(this.f6425a, this.c);
    }
}
