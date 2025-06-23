package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h f6208a;
    private boolean b = false;
    private boolean c = true;
    private final List<g> d = new ArrayList();
    private g e = null;

    private h() {
    }

    public static h a() {
        if (f6208a == null) {
            synchronized (h.class) {
                try {
                    if (f6208a == null) {
                        f6208a = new h();
                    }
                } finally {
                }
            }
        }
        return f6208a;
    }

    public g b() {
        return this.e;
    }

    public g b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        for (g gVar : this.d) {
            if (gVar.a().equals(string)) {
                return gVar;
            }
        }
        return null;
    }

    public void a(Context context) {
        if (this.b) {
            return;
        }
        this.b = true;
        try {
            this.c = false;
            this.e = new g(context);
            this.d.clear();
            this.d.add(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d.size() > 0) {
                g gVar = null;
                int i = 0;
                for (g gVar2 : this.d) {
                    if (new File(gVar2.b()).exists()) {
                        i++;
                        gVar = gVar2;
                    }
                }
                if (i == 0) {
                    g b = b(context);
                    this.e = b;
                    if (b == null) {
                        Iterator<g> it = this.d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            g next = it.next();
                            if (a(context, next)) {
                                this.e = next;
                                break;
                            }
                        }
                    }
                } else if (i == 1) {
                    if (a(context, gVar)) {
                        this.e = gVar;
                    }
                } else {
                    this.e = b(context);
                }
                if (this.e == null) {
                    this.e = this.d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.e == null) {
                this.c = false;
                this.e = new g(context);
                this.d.clear();
                this.d.add(this.e);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, g gVar) {
        String a2 = gVar.a();
        SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
        edit.putString("PREFFERED_SD_CARD", a2);
        return edit.commit();
    }
}
