package com.baidu.location.c;

import android.location.OnNmeaMessageListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements OnNmeaMessageListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f5705a;

    public f(e eVar) {
        this.f5705a = eVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f5705a.S != null) {
            this.f5705a.S.sendMessage(this.f5705a.S.obtainMessage(5, str));
        }
    }
}
