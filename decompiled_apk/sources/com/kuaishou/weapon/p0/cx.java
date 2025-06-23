package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes11.dex */
public class cx {
    private static volatile cx b;

    /* renamed from: a, reason: collision with root package name */
    private Context f18370a;

    private cx(Context context) {
        this.f18370a = context;
    }

    public static cx a(Context context) {
        if (b == null) {
            synchronized (cx.class) {
                try {
                    if (b == null) {
                        b = new cx(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    h a2 = h.a(cx.this.f18370a, "re_po_rt");
                    if (a2.b(df.y, 0) == 1) {
                        long a3 = df.a(cx.this.f18370a).a(df.bh);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(df.z, 8) * 3600000;
                        int b3 = a2.b(df.q, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a3 >= b2 || (i2 = i) == 106 || (i2 == 100 && b3 == 1)) {
                            cp.a(cx.this.f18370a, new ch(cx.this.f18370a, i).a(ck.i), ck.i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
