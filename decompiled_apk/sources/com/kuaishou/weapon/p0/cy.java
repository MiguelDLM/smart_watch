package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes11.dex */
public class cy {
    private static volatile cy b;

    /* renamed from: a, reason: collision with root package name */
    private Context f18372a;

    private cy(Context context) {
        this.f18372a = context;
    }

    public static cy a(Context context) {
        if (b == null) {
            synchronized (cy.class) {
                try {
                    if (b == null) {
                        b = new cy(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        try {
            h a2 = h.a(this.f18372a, "re_po_rt");
            final boolean e = a2.e("a1_p_s_p_s");
            final boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if ((e || e2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            h a3 = h.a(cy.this.f18372a, "re_po_rt");
                            if (a3.b(df.o, 0) == 1) {
                                if (e || e2) {
                                    long a4 = df.a(cy.this.f18372a).a(df.bi);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b2 = a3.b(df.p, 8) * 3600000;
                                    int b3 = a3.b(df.q, 0);
                                    if (a4 > 0 && currentTimeMillis - a4 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - a4 >= b2 || (((i2 = i) == 100 && b3 == 1) || i2 == 106)) {
                                        cp.a(cy.this.f18372a, new ci(cy.this.f18372a, i).a(ck.d), ck.d, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
