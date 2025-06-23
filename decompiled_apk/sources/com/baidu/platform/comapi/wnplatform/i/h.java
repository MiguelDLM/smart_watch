package com.baidu.platform.comapi.wnplatform.i;

import XIXIX.OOXIXo;
import com.baidu.platform.comapi.walknavi.e.l;
import java.text.DecimalFormat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements com.baidu.platform.comapi.wnplatform.k.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f9921a;

    public h(f fVar) {
        this.f9921a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.k.b
    public void a(com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar) {
        int i;
        f.a();
        new DecimalFormat("######0.00");
        double d = aVar.d;
        double g = com.baidu.platform.comapi.walknavi.b.a().N().g();
        com.baidu.platform.comapi.walknavi.b.a().K().a(aVar.f9939a, aVar.b, aVar.c, d, aVar.e, aVar.f);
        if (com.baidu.platform.comapi.walknavi.b.a().N().i() != null) {
            double d2 = aVar.d - g;
            com.baidu.platform.comapi.walknavi.e.e c = com.baidu.platform.comapi.walknavi.e.e.c();
            double a2 = l.a(r3.overlook);
            if (d2 < OOXIXo.f3760XO) {
                d2 += 360.0d;
            }
            c.a(a2, l.a(d2) - 3.141592653589793d, OOXIXo.f3760XO);
        }
        i = f.d;
        if (i % 5 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("s:");
            sb.append((int) d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("g:");
            sb2.append((int) OOXIXo.f3760XO);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("r:");
            sb3.append((int) g);
        }
    }
}
