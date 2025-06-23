package com.baidu.navisdk.asr.query;

import android.content.Context;
import com.baidu.navisdk.asr.f;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a {
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.asr.query.sp.b f6557a;
    private final b b = new b();

    private a(Context context) {
        this.f6557a = new com.baidu.navisdk.asr.query.sp.b(context);
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    public boolean b(String str) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("BNAsrQuery", "query ,start type =" + str);
        }
        if (str == null) {
            if (gVar.c()) {
                gVar.c("BNAsrQuery", "query , model = null");
            }
            return false;
        }
        if (!f.a()) {
            if (gVar.d()) {
                gVar.e("BNAsrQuery", "query , asr can't work");
            }
            return false;
        }
        if (b(str, this.b.a(str))) {
            return true;
        }
        if (gVar.d()) {
            gVar.e("BNAsrQuery", "query , freq not match");
        }
        return false;
    }

    public void a(String str) {
        this.f6557a.a(str);
    }

    public void a(String str, c cVar) {
        this.b.a(str, cVar);
    }

    public void a() {
        this.f6557a.a();
    }

    private boolean b(String str, c cVar) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("BNAsrQuery", "matchFreq ,naviCount = " + this.f6557a.c(str) + " dayCount = " + this.f6557a.b(str) + " weekCount = " + this.f6557a.d(str) + " type = " + str + " model = " + cVar);
        }
        return cVar != null && this.f6557a.c(str) < cVar.b() && this.f6557a.b(str) < cVar.a() && this.f6557a.d(str) < cVar.c();
    }
}
