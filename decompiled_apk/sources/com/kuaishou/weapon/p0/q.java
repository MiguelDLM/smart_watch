package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes11.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18406a = 3;
    private static q b = null;
    private static final String g = "1";
    private volatile boolean c = false;
    private dp d;
    private Context e;
    private t f;

    private q(Context context) {
        this.e = context;
        this.d = dp.a(context);
        this.f = t.a(context);
    }

    private static void d() {
        try {
            dp a2 = dp.a();
            if (a2 != null) {
                a2.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        s sVar;
        for (s sVar2 : this.f.a()) {
            r a2 = r.a();
            if (a2 != null) {
                sVar = a2.d(sVar2.c);
            } else {
                sVar = null;
            }
            if (sVar == null) {
                a(sVar2.f18410a, sVar2.d, (PackageInfo) null);
            }
        }
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (b == null) {
                    b = new q(context);
                }
                qVar = b;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    public synchronized void b() {
        String str;
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            for (s sVar : this.f.a()) {
                try {
                    str = this.e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                    str = null;
                }
                if (str != null) {
                    sVar.m = str + bi.j + sVar.f18410a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.m);
                    sb.append("/lib");
                    dn.c(sb.toString());
                    dn.c(sVar.m);
                }
            }
            this.f.b();
            if (!this.d.b(dp.d)) {
                this.d.a(dp.d, Boolean.TRUE, true);
            } else {
                this.f.c();
            }
            n.a().a(new u(this.e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        if (z) {
            if (this.f.c(i) != 1) {
                return false;
            }
        }
        s a2 = this.f.a(i);
        if (a2 == null) {
            this.f.b(i, -1);
            return false;
        }
        if (!dn.a(new File(a2.e))) {
            this.f.b(i, -1);
            return false;
        }
        if (packageInfo != null) {
            a2.r = packageInfo;
        }
        r a3 = r.a(this.e.getApplicationContext(), true);
        if (!a3.a(a2, false)) {
            this.f.b(i, -1);
            a3.a(a2.e);
            return false;
        }
        s c = a3.c(a2.e);
        c.b = 1;
        c.p = 1;
        this.f.a(c);
        return true;
    }

    public void b(String str) {
        r a2;
        try {
            if (TextUtils.isEmpty(str) || (a2 = r.a()) == null) {
                return;
            }
            a2.b(str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r a2;
                    try {
                        if (TextUtils.isEmpty(str) || (a2 = r.a(q.this.e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        final s d = a2.d(str);
                        if (d == null) {
                            s b2 = q.this.f.b(str);
                            if (b2 != null) {
                                q.this.a(str, b2.e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a2.b(str);
                                q.this.f.a(str);
                                File file = new File(d.e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, 600000L);
                        a2.b(str);
                        q.this.f.a(str);
                        File file = new File(d.e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean a(s sVar, String str, String str2) {
        r a2;
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.e);
        if (!dn.a(file)) {
            return false;
        }
        try {
            if (!this.f.b(sVar.f18410a)) {
                this.f.a(sVar);
            }
            a2 = r.a(this.e.getApplicationContext(), true);
            this.f.a(sVar.f18410a, 1);
            b(sVar.c);
        } catch (Throwable unused) {
        }
        if (!a2.a(sVar, true)) {
            file.delete();
            a(sVar.f18410a, sVar.d, null, true, null);
            this.f.a(sVar.f18410a, 0);
            return false;
        }
        sVar = a2.c(sVar.e);
        if (sVar == null) {
            this.f.a(sVar.f18410a, 0);
            return false;
        }
        try {
            s a3 = this.f.a(sVar.f18410a);
            File file2 = (a3 == null || a3.d.equals(sVar.d)) ? null : new File(a3.e);
            sVar.b = 1;
            sVar.p = 1;
            if (this.f.a(sVar) > 0 && file2 != null && file2.exists()) {
                file2.delete();
            }
            this.f.a(sVar.f18410a, 0);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
