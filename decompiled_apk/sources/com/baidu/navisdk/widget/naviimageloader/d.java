package com.baidu.navisdk.widget.naviimageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, b> f9415a = new HashMap();
    private final Object b = new Object();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.b<String, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f9416a;

        /* renamed from: com.baidu.navisdk.widget.naviimageloader.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0515a extends com.baidu.navisdk.util.worker.f<Bitmap, String> {
            public C0515a(String str, Bitmap bitmap) {
                super(str, bitmap);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                ArrayList arrayList;
                b bVar;
                synchronized (d.this.b) {
                    try {
                        arrayList = (d.this.f9415a == null || (bVar = (b) d.this.f9415a.get(a.this.f9416a.c)) == null) ? null : bVar.f9418a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                K k = this.inData;
                int i = 0;
                if (k == 0 || ((Bitmap) k).isRecycled()) {
                    if (arrayList != null) {
                        while (i < arrayList.size()) {
                            d.this.b((c) arrayList.get(i));
                            i++;
                        }
                    } else {
                        a aVar = a.this;
                        d.this.b(aVar.f9416a);
                    }
                } else if (arrayList != null) {
                    while (i < arrayList.size()) {
                        d.this.a((Bitmap) this.inData, (c) arrayList.get(i));
                        i++;
                    }
                } else {
                    a aVar2 = a.this;
                    d.this.a((Bitmap) this.inData, aVar2.f9416a);
                }
                a aVar3 = a.this;
                d.this.a(aVar3.f9416a.c);
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, c cVar) {
            super(str, str2);
            this.f9416a = cVar;
        }

        @Override // com.baidu.navisdk.util.worker.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void callback(Bitmap bitmap) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new C0515a("BNImageLoaderEngine-submit-2", bitmap), new com.baidu.navisdk.util.worker.e(99, 0));
        }

        @Override // com.baidu.navisdk.util.worker.g
        public Bitmap execute() {
            this.f9416a.run();
            return this.f9416a.a();
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<c> f9418a;

        public b(c cVar) {
            ArrayList<c> arrayList = new ArrayList<>();
            this.f9418a = arrayList;
            arrayList.add(cVar);
        }

        public void a(c cVar) {
            this.f9418a.add(cVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f9419a;
        String b;
        String c;
        ImageView d;
        com.baidu.navisdk.widget.naviimageloader.b e;
        e f;
        i g;
        Bitmap h;
        int i;

        public c(String str, String str2, String str3, ImageView imageView, com.baidu.navisdk.widget.naviimageloader.b bVar, e eVar, i iVar) {
            this.f9419a = str2;
            this.c = str3;
            this.d = imageView;
            this.e = bVar;
            this.f = eVar;
            this.g = iVar;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            if (this.c != null && this.g != null && this.e != null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b()) {
                return;
            }
            Bitmap a2 = j.a(this.f9419a);
            this.h = a2;
            if (a2 != null) {
                this.i = 1;
                return;
            }
            try {
                new f().a(this.c, new a());
            } catch (Exception unused) {
                this.h = null;
            }
        }

        public Bitmap a() {
            return this.h;
        }

        /* loaded from: classes8.dex */
        public class a extends h {
            public a() {
            }

            @Override // com.baidu.navisdk.widget.naviimageloader.h
            public void a(Bitmap bitmap) {
                c cVar = c.this;
                cVar.h = bitmap;
                if (bitmap == null || !cVar.e.e()) {
                    return;
                }
                c cVar2 = c.this;
                cVar2.g.a(cVar2.f9419a, cVar2.h);
            }

            @Override // com.baidu.navisdk.widget.naviimageloader.g
            public void a(Throwable th) {
                c.this.h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar.b()) {
            cVar.e.a().a(cVar.c, cVar.e.b(), cVar.d);
            e eVar = cVar.f;
            if (eVar != null) {
                eVar.a(cVar.c, cVar.d, null, cVar.i);
            }
        }
    }

    public boolean a(String str, c cVar) {
        synchronized (this.b) {
            try {
                if (cVar == null) {
                    return false;
                }
                if (this.f9415a == null) {
                    this.f9415a = new HashMap();
                }
                if (this.f9415a.containsKey(str)) {
                    b bVar = this.f9415a.get(str);
                    if (bVar != null) {
                        bVar.a(cVar);
                    }
                    return false;
                }
                this.f9415a.put(str, new b(cVar));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        synchronized (this.b) {
            try {
                Map<String, b> map = this.f9415a;
                if (map != null) {
                    map.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.b) new a("BNImageLoaderEngine-submit", null, cVar), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, c cVar) {
        if (!cVar.b() || bitmap == null) {
            return;
        }
        cVar.e.a().a(cVar.c, bitmap, cVar.d);
        if (cVar.e.f()) {
            if (!com.baidu.navisdk.widget.naviimageloader.c.h.containsKey(cVar.b)) {
                com.baidu.navisdk.widget.naviimageloader.c.h.put(cVar.b, bitmap);
            }
        } else if (cVar.e.d() && !cVar.g.containsKey(cVar.b)) {
            cVar.g.put(cVar.b, bitmap);
        }
        e eVar = cVar.f;
        if (eVar != null) {
            eVar.a(cVar.c, cVar.d, bitmap, cVar.i);
        }
    }
}
