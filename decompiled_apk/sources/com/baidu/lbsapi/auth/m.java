package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.Hashtable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5594a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    public m(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f5594a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        Context context;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        boolean b2;
        p pVar;
        p pVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("status = ");
        sb.append(this.f5594a);
        sb.append("; forced = ");
        sb.append(this.b);
        sb.append("checkAK = ");
        b = this.f.b(this.c);
        sb.append(b);
        b.a(sb.toString());
        int i3 = this.f5594a;
        if (i3 != 601 && !this.b && i3 != -1) {
            b2 = this.f.b(this.c);
            if (!b2) {
                if (602 == this.f5594a) {
                    b.a("authenticate wait ");
                    pVar = LBSAuthManager.h;
                    if (pVar != null) {
                        pVar2 = LBSAuthManager.h;
                        pVar2.b();
                    }
                } else {
                    b.a("authenticate else");
                }
                this.f.a((String) null, this.c);
                return;
            }
        }
        b.a("authenticate sendAuthRequest");
        context = LBSAuthManager.f5583a;
        String[] b3 = d.b(context);
        if (b3 == null || b3.length <= 1) {
            LBSAuthManager lBSAuthManager = this.f;
            boolean z = this.b;
            String str7 = this.d;
            Hashtable hashtable = this.e;
            String str8 = this.c;
            str = LBSAuthManager.b;
            i = LBSAuthManager.c;
            str2 = LBSAuthManager.d;
            str3 = LBSAuthManager.e;
            lBSAuthManager.a(z, str7, hashtable, str8, str, i, str2, str3);
            return;
        }
        b.a("authStrings.length:" + b3.length);
        b.a("more sha1 auth");
        LBSAuthManager lBSAuthManager2 = this.f;
        boolean z2 = this.b;
        String str9 = this.d;
        Hashtable hashtable2 = this.e;
        String str10 = this.c;
        str4 = LBSAuthManager.b;
        i2 = LBSAuthManager.c;
        str5 = LBSAuthManager.d;
        str6 = LBSAuthManager.e;
        lBSAuthManager2.a(z2, str9, (Hashtable<String, String>) hashtable2, b3, str10, str4, i2, str5, str6);
    }
}
