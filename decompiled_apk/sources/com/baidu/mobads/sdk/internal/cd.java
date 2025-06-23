package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class cd extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f6270a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(cb cbVar, Looper looper) {
        super(looper);
        this.f6270a = cbVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bv bvVar;
        boolean z;
        Context context;
        bv bvVar2;
        boolean z2;
        boolean p;
        String string = message.getData().getString(cb.n);
        bz bzVar = (bz) message.getData().getParcelable(cb.m);
        if (!"OK".equals(string)) {
            bvVar = this.f6270a.z;
            bvVar.a(cb.f6267a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f6270a.a(false);
            z = this.f6270a.A;
            if (z) {
                this.f6270a.A = false;
                this.f6270a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e = bzVar.e();
        context = this.f6270a.y;
        bu buVar = new bu(e, context, bzVar);
        try {
            try {
                cb cbVar = this.f6270a;
                if (cbVar.u != cb.t) {
                    cbVar.a(buVar);
                    buVar.a(cb.f());
                    this.f6270a.a(true);
                } else {
                    buVar.a();
                    buVar.a(cb.f());
                    if (cb.p != null) {
                        cb.p.b = bzVar.b();
                    }
                    this.f6270a.l();
                    z2 = this.f6270a.A;
                    if (z2) {
                        this.f6270a.A = false;
                        cb cbVar2 = this.f6270a;
                        p = cbVar2.p();
                        cbVar2.a(p, "load remote file just downloaded");
                    }
                }
            } catch (cb.a e2) {
                String str = "download apk file failed: " + e2.toString();
                this.f6270a.a(false);
                bvVar2 = this.f6270a.z;
                bvVar2.a(cb.f6267a, str);
            }
            buVar.delete();
        } catch (Throwable th) {
            buVar.delete();
            throw th;
        }
    }
}
