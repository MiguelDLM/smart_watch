package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.bf;

/* loaded from: classes10.dex */
public class a {
    private static final int Code = 60000;
    private static final String I = "Monitor";
    private static final String V = "unbindTask";
    private final String B = V + hashCode();
    private int C = 0;
    private Context F;
    private String S;
    private InterfaceC0665a Z;

    /* renamed from: com.huawei.openalliance.ad.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0665a {
        void Code();
    }

    public a(Context context, String str, InterfaceC0665a interfaceC0665a) {
        this.F = context.getApplicationContext();
        this.S = str;
        this.Z = interfaceC0665a;
    }

    private int B() {
        return TextUtils.equals(x.cu, this.F.getPackageName()) ? 0 : 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        fb.V(Z(), "unbindService");
        try {
            this.Z.Code();
        } catch (Throwable th) {
            fb.I(I, "unbindService err: %s", th.getClass().getSimpleName());
        }
    }

    private String Z() {
        return "Monitor_" + this.S;
    }

    public Context Code() {
        return this.F;
    }

    public synchronized void I() {
        try {
            int i = this.C - 1;
            this.C = i;
            if (i < 0) {
                this.C = 0;
            }
            fb.Code(Z(), "dec count: %d", Integer.valueOf(this.C));
            if (this.C <= 0) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.C();
                    }
                }, this.B, B());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void V() {
        this.C++;
        bf.Code(this.B);
        fb.V(Z(), "inc count: " + this.C);
    }
}
