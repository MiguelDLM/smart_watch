package com.baidu.navisdk.util.drivertool;

import android.content.Intent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes8.dex */
public class a {
    private static a c = new a();

    /* renamed from: a, reason: collision with root package name */
    public List<String> f9263a = new ArrayList();
    public String b = null;

    private a() {
    }

    public static a c() {
        return c;
    }

    public void a(int i) {
        Iterator<String> it = this.f9263a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            this.b = it.next();
            b.n().b(i);
            if (i2 == 0) {
                b.n().h().f = "";
            }
            i2++;
        }
    }

    public void b() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.PICK");
        if (com.baidu.navisdk.framework.a.c().b() != null) {
            com.baidu.navisdk.framework.a.c().b().startActivityForResult(Intent.createChooser(intent, "Select Picture"), 257);
        }
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LP");
        stringBuffer.append("_");
        stringBuffer.append(UUID.randomUUID().toString());
        return d.d() + File.separator + stringBuffer.toString() + ".lpdex";
    }
}
