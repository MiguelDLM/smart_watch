package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes13.dex */
public class l extends a {
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c = this.b.c("s");
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ag"), c);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ah"), c);
        String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ai"), c);
        String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("aj"), c);
        Intent intent = new Intent();
        intent.putExtra(a2, this.c);
        intent.putExtra(a3, "*/*");
        intent.putExtra(a4, true);
        intent.setAction(a5);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
