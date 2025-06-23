package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: classes11.dex */
public class dc {
    private static volatile dc b;

    /* renamed from: a, reason: collision with root package name */
    private Context f18383a;

    private dc(Context context) {
        this.f18383a = context;
    }

    public static dc a(Context context) {
        if (b == null) {
            synchronized (dc.class) {
                try {
                    if (b == null) {
                        b = new dc(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(dc.this.f18383a, "re_po_rt");
                    if (a2.b(df.ap, 1) == 1) {
                        long a3 = df.a(dc.this.f18383a).a(df.bl);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b2 = a2.b(df.as, 0);
                        long j = currentTimeMillis - a3;
                        if (j >= a2.b(df.ar, 6) * 3600000 || (i == 100 && b2 == 1 && j >= 14400000)) {
                            cg.a(dc.this.f18383a, new bw(dc.this.f18383a, i, false).a(ck.e), ck.e, true);
                            df.a(dc.this.f18383a).a(df.bl, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
