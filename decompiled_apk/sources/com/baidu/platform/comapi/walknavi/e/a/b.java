package com.baidu.platform.comapi.walknavi.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.e.a.f.f;
import com.baidu.platform.comapi.walknavi.e.a.g.g;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9716a = true;
    private Context b;
    private com.baidu.platform.comapi.walknavi.e.a.a c;
    private com.baidu.platform.comapi.walknavi.e.a.f.b d;
    private C0534b f;
    private a g;
    private com.baidu.platform.comapi.walknavi.e.a.a.b i;
    private com.baidu.platform.comapi.walknavi.e.a.d.b l;
    private f m;
    private com.baidu.platform.comapi.walknavi.e.a.f.c e = null;
    private com.baidu.platform.comapi.walknavi.e.a.a.a h = new com.baidu.platform.comapi.walknavi.e.a.a.a();
    private c j = c.INITIAL_STATE;
    private boolean k = false;

    /* loaded from: classes8.dex */
    public static class a implements com.baidu.platform.comapi.walknavi.e.a.f.a<String> {

        /* renamed from: a, reason: collision with root package name */
        private SoftReference<b> f9717a;

        public a(b bVar) {
            this.f9717a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.f.a
        public void b(String str) {
            try {
                if (this.f9717a.get() != null) {
                    this.f9717a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9717a.get().c != null) {
                        this.f9717a.get().c.a(6, str);
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download onErrorResponse exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.f.a
        public void a(String str) {
            try {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download res finished");
                if (this.f9717a.get() != null) {
                    this.f9717a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9717a.get().c != null) {
                        this.f9717a.get().c.a(0, str);
                        if (this.f9717a.get().i != null) {
                            this.f9717a.get().m.a(this.f9717a.get().i.c(), str);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download onResponse exception: " + e.getMessage());
            }
        }

        private int b(int i) {
            return (this.f9717a.get() == null || !this.f9717a.get().k) ? i : (i / 2) + 50;
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.a
        public void a(int i) {
            try {
                if (this.f9717a.get() == null || this.f9717a.get().c == null) {
                    return;
                }
                this.f9717a.get().c.a(b(i));
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download onProgress exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.a
        public void a(boolean z, float f) {
            try {
                if (this.f9717a.get() != null) {
                    this.f9717a.get().j = c.DOWNLOAD_FINISHED;
                    if (this.f9717a.get().c != null) {
                        com.baidu.platform.comapi.walknavi.e.a.g.a.a("isUpdate=" + z + ", size=" + f);
                        if (this.f9717a.get().l != null && this.f9717a.get().i != null && this.f9717a.get().l.a(this.f9717a.get().i.h())) {
                            z = true;
                        }
                        this.f9717a.get().c.a(z, f);
                    }
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download onUpdate exception: " + e.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9717a.get() != null) {
                    this.f9717a.get().j = c.INITIAL_STATE;
                }
                this.f9717a.clear();
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("download destroy exception: " + e.getMessage());
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.e.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0534b implements f.a<JSONObject> {

        /* renamed from: a, reason: collision with root package name */
        private SoftReference<b> f9718a;

        public C0534b(b bVar) {
            this.f9718a = new SoftReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.f.a
        public void b(String str) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("http error msg = " + str);
            try {
                if (this.f9718a.get() != null) {
                    this.f9718a.get().j = c.INITIAL_STATE;
                    if (this.f9718a.get().c != null) {
                        this.f9718a.get().c.a(5, str);
                    }
                    this.f9718a.get().e = null;
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("query onErrorResponse exception: " + e.getMessage());
            }
        }

        @Override // com.baidu.platform.comapi.walknavi.e.a.f.f.a
        public void a(JSONObject jSONObject) {
            try {
                if (this.f9718a.get() != null) {
                    this.f9718a.get().a(jSONObject);
                }
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("query onResponse exception: " + e.getMessage());
            }
        }

        public void a() {
            try {
                if (this.f9718a.get() != null) {
                    this.f9718a.get().j = c.INITIAL_STATE;
                }
                this.f9718a.clear();
            } catch (Exception e) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("query destroy exception: " + e.getMessage());
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum c {
        INITIAL_STATE,
        QUERYING,
        DOWNLOADING,
        DOWNLOAD_FINISHED
    }

    public b(Context context) {
        this.b = context;
        this.l = new com.baidu.platform.comapi.walknavi.e.a.d.b(context);
        this.m = new f(this.b);
        com.baidu.platform.comapi.walknavi.e.a.g.f.a(this.b.getPackageName());
    }

    private void h() {
        com.baidu.platform.comapi.walknavi.e.a.f.b bVar = this.d;
        if (bVar != null) {
            bVar.cancel(true);
            this.d = null;
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        com.baidu.platform.comapi.walknavi.e.a.d.b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    private void c() {
        com.baidu.platform.comapi.walknavi.e.a.a aVar;
        c cVar = this.j;
        if (cVar != c.INITIAL_STATE && cVar != c.DOWNLOAD_FINISHED) {
            if (cVar == c.QUERYING) {
                com.baidu.platform.comapi.walknavi.e.a.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.a(7, "query in progress");
                    return;
                }
                return;
            }
            if (cVar != c.DOWNLOADING || (aVar = this.c) == null) {
                return;
            }
            aVar.a(8, "download in progress");
            return;
        }
        a(this.h);
    }

    private void d() {
        com.baidu.platform.comapi.walknavi.e.a.a.b bVar = this.i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("ERROR!! mARResource is null");
        } else {
            if (TextUtils.isEmpty(bVar.d())) {
                return;
            }
            this.j = c.DOWNLOADING;
            this.g = new a(this);
            e();
        }
    }

    private void e() {
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("download start");
        com.baidu.platform.comapi.walknavi.e.a.a.b bVar = this.i;
        if (bVar == null) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("ERROR!! bundle data is null");
        } else if (TextUtils.isEmpty(bVar.h())) {
            this.g.b("so url is null");
        } else {
            this.l.a(new com.baidu.platform.comapi.walknavi.e.a.c(this));
            this.l.b(bVar.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d = com.baidu.platform.comapi.walknavi.e.a.f.e.a(this.i.c(), this.i.e(), this.i.d(), com.baidu.platform.comapi.walknavi.e.a.g.d.d, this.g);
    }

    private void g() {
        com.baidu.platform.comapi.walknavi.e.a.f.c cVar = this.e;
        if (cVar != null) {
            cVar.a();
            this.e = null;
        }
        C0534b c0534b = this.f;
        if (c0534b != null) {
            c0534b.a();
        }
    }

    public void b(String str, com.baidu.platform.comapi.walknavi.e.a.a aVar) {
        b();
        f9716a = false;
        this.h.a(str);
        this.h.a(4);
        this.c = aVar;
        if (g.a(this.b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.e.a.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(1, "no network");
        }
    }

    public void a(String str, com.baidu.platform.comapi.walknavi.e.a.a aVar) {
        b();
        f9716a = true;
        this.h.a(str);
        this.h.a(4);
        this.c = aVar;
        if (g.a(this.b) != null) {
            c();
            return;
        }
        com.baidu.platform.comapi.walknavi.e.a.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(1, "no network");
        }
    }

    public void b() {
        g();
        h();
    }

    public String a(String str) {
        if (this.l.a()) {
            return this.m.a(str);
        }
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("so not loaded");
        return "";
    }

    public boolean a(String str, boolean z) {
        File[] listFiles;
        if (z) {
            File file = new File(com.baidu.platform.comapi.walknavi.e.a.g.f.a(str, 4));
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                String a2 = a(str);
                for (int i = 0; i < listFiles.length; i++) {
                    File file2 = listFiles[i];
                    if (file2 != null && !file2.getAbsolutePath().contains(a2)) {
                        com.baidu.platform.comapi.walknavi.e.a.g.f.a(new File(listFiles[i].getAbsolutePath()));
                    }
                }
            }
            return true;
        }
        return com.baidu.platform.comapi.walknavi.e.a.g.f.a(new File(com.baidu.platform.comapi.walknavi.e.a.g.f.a(str, 4)));
    }

    public boolean a() {
        return this.l.a();
    }

    private void a(com.baidu.platform.comapi.walknavi.e.a.a.a aVar) {
        this.j = c.QUERYING;
        C0534b c0534b = new C0534b(this);
        this.f = c0534b;
        com.baidu.platform.comapi.walknavi.e.a.f.c a2 = com.baidu.platform.comapi.walknavi.e.a.f.e.a(this.b, aVar, c0534b);
        this.e = a2;
        if (a2 == null) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("Http Request Occur Error! Please Check");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        com.baidu.platform.comapi.walknavi.e.a.a aVar;
        if (jSONObject != null) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("AR query response: " + jSONObject.toString());
        } else {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("AR query response is null");
        }
        com.baidu.platform.comapi.walknavi.e.a.a.b a2 = com.baidu.platform.comapi.walknavi.e.a.c.a.a(jSONObject);
        this.i = a2;
        if (a2 == null && (aVar = this.c) != null) {
            aVar.a(-1, "ar resource is null");
        }
        if (this.i.a() != 0) {
            this.j = c.INITIAL_STATE;
            int a3 = this.i.a();
            if (a3 == 1051) {
                com.baidu.platform.comapi.walknavi.e.a.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.a(3, this.i.b());
                }
            } else if (a3 != 1052) {
                com.baidu.platform.comapi.walknavi.e.a.a aVar3 = this.c;
                if (aVar3 != null) {
                    aVar3.a(-1, this.i.b());
                }
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("error code = " + this.i.a() + ", error msg = " + this.i.b());
            } else {
                com.baidu.platform.comapi.walknavi.e.a.a aVar4 = this.c;
                if (aVar4 != null) {
                    aVar4.a(4, this.i.b());
                }
            }
            this.e = null;
            return;
        }
        if (!this.i.f() && this.i.g()) {
            this.e = null;
            d();
            return;
        }
        this.j = c.INITIAL_STATE;
        com.baidu.platform.comapi.walknavi.e.a.a aVar5 = this.c;
        if (aVar5 != null) {
            aVar5.a(2, "not support AR");
        }
        this.e = null;
    }
}
