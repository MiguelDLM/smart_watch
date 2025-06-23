package com.baidu.mshield.x6.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x6.EngineImpl;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f6430a;
    public com.baidu.mshield.x6.a.b b;

    public b(Context context) {
        this.f6430a = context;
        this.b = new com.baidu.mshield.x6.a.b(context);
    }

    public void a() {
        try {
            String n = this.b.n();
            String propertyByType = EngineImpl.getInstance(this.f6430a).getPropertyByType("arid");
            TextUtils.isEmpty("");
            if (TextUtils.isEmpty(propertyByType)) {
                propertyByType = "";
            }
            if (TextUtils.isEmpty(n)) {
                String a2 = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.isEmpty(a2)) {
                    this.b.l(a2);
                }
            } else {
                String a3 = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.equals(n, a3)) {
                    this.b.l(a3);
                    i.a(this.f6430a).a(3, true);
                }
            }
            this.b.f(true);
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }
}
