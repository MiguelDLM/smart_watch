package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class cj extends i {
    final /* synthetic */ cb.c b;
    final /* synthetic */ Handler c;
    final /* synthetic */ cb d;

    public cj(cb cbVar, cb.c cVar, Handler handler) {
        this.d = cbVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    public Object i() {
        bv bvVar;
        SharedPreferences m;
        bv bvVar2;
        SharedPreferences m2;
        bv bvVar3;
        SharedPreferences m3;
        try {
            try {
                synchronized (cb.class) {
                    this.d.b(this.b, this.c);
                }
                m3 = this.d.m();
                SharedPreferences.Editor edit = m3.edit();
                edit.putString(cb.d, this.d.a());
                edit.apply();
                return null;
            } catch (Throwable th) {
                try {
                    String str = "Load APK Failed: " + th.toString();
                    bvVar2 = this.d.z;
                    bvVar2.a(cb.f6267a, str);
                    this.d.b(false);
                    m2 = this.d.m();
                    SharedPreferences.Editor edit2 = m2.edit();
                    edit2.putString(cb.d, this.d.a());
                    edit2.apply();
                    return null;
                } catch (Throwable th2) {
                    try {
                        m = this.d.m();
                        SharedPreferences.Editor edit3 = m.edit();
                        edit3.putString(cb.d, this.d.a());
                        edit3.apply();
                    } catch (Throwable th3) {
                        bvVar = this.d.z;
                        bvVar.a(cb.f6267a, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            bvVar3 = this.d.z;
            bvVar3.a(cb.f6267a, th4);
            return null;
        }
    }
}
