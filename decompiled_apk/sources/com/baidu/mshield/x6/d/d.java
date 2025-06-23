package com.baidu.mshield.x6.d;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Context f6432a;

    public d(Context context) {
        this.f6432a = context;
    }

    public void a() {
        try {
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(this.f6432a);
            String a2 = com.baidu.mshield.x6.b.a.a(this.f6432a);
            String b = com.baidu.mshield.x6.b.a.b(this.f6432a);
            String d = bVar.d();
            String e = bVar.e();
            if (!TextUtils.isEmpty(d)) {
                d = com.baidu.mshield.b.f.e.a(d);
                bVar.d(d);
            }
            if (!TextUtils.isEmpty(e)) {
                e = com.baidu.mshield.b.f.e.a(e);
                bVar.e(e);
            }
            if (!TextUtils.isEmpty(a2)) {
                if (!TextUtils.isEmpty(b)) {
                    if (!d.equals(com.baidu.mshield.b.f.e.a(a2)) || !e.equals(com.baidu.mshield.b.f.e.a(b))) {
                        bVar.a(true);
                        bVar.d(com.baidu.mshield.b.f.e.a(a2));
                        bVar.e(com.baidu.mshield.b.f.e.a(b));
                        return;
                    }
                    return;
                }
                if (!d.equals(com.baidu.mshield.b.f.e.a(a2))) {
                    bVar.a(true);
                    bVar.d(com.baidu.mshield.b.f.e.a(a2));
                    bVar.e("");
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(b)) {
                if (!e.equals(com.baidu.mshield.b.f.e.a(b))) {
                    bVar.a(true);
                    bVar.d("");
                    bVar.e(com.baidu.mshield.b.f.e.a(b));
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(d)) {
                bVar.a(true);
                bVar.d("");
                bVar.e("");
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }
}
