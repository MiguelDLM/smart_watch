package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.g;
import java.io.File;
import java.util.Objects;

/* loaded from: classes11.dex */
final class n {

    /* loaded from: classes11.dex */
    public static abstract class a<T> implements c<T> {
        c<T> aod;

        public a(c<T> cVar) {
            this.aod = cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements f<a.C0838a> {
        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0838a> cVar) {
            try {
                new com.kwad.sdk.api.loader.g(vVar).a(new g.a() { // from class: com.kwad.sdk.api.loader.n.b.1
                    @Override // com.kwad.sdk.api.loader.g.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.AK()) {
                            cVar.i(bVar.anc);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.e.aL(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c<T> {
        void i(T t);
    }

    /* loaded from: classes11.dex */
    public static class d implements f<a.C0838a> {
        f<a.C0838a> aoh;

        public d(f<a.C0838a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0838a> cVar) {
            this.aoh.a(vVar, new a<a.C0838a>(cVar) { // from class: com.kwad.sdk.api.loader.n.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                @WorkerThread
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void i(@NonNull a.C0838a c0838a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        k.a(c0838a);
                        file = i.r(vVar.getContext(), c0838a.sdkVersion);
                        j.c(c0838a.amZ, file);
                        k.a(c0838a, System.currentTimeMillis() - currentTimeMillis);
                        c0838a.ana = file;
                        cVar.i(c0838a);
                    } catch (Throwable th) {
                        k.a(c0838a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        i.j(file);
                    }
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static class e implements f<Boolean> {
        f<a.C0838a> aoh;

        public e(f<a.C0838a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.aoh.a(vVar, new c<a.C0838a>() { // from class: com.kwad.sdk.api.loader.n.e.1
                private void a(a.C0838a c0838a, int i, Throwable th) {
                    i.j(c0838a.ana);
                    k.b(c0838a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void i(@NonNull a.C0838a c0838a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        k.b(c0838a);
                        if (!com.kwad.sdk.api.loader.c.a(vVar.getContext(), AnonymousClass1.class.getClassLoader(), c0838a.ana.getPath(), c0838a.sdkVersion)) {
                            a(c0838a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.h.p(vVar.getContext(), c0838a.sdkVersion);
                        i.j(c0838a.ana);
                        k.b(c0838a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.i(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0838a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* loaded from: classes11.dex */
    public static class g implements f<a.C0838a> {
        f<a.C0838a> aoh;

        public g(f<a.C0838a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(v vVar, final c<a.C0838a> cVar) {
            this.aoh.a(vVar, new a<a.C0838a>(cVar) { // from class: com.kwad.sdk.api.loader.n.g.1
                private void a(a.C0838a c0838a, int i, Throwable th) {
                    i.j(c0838a.ana);
                    k.a(c0838a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void i(@NonNull a.C0838a c0838a) {
                    try {
                        File file = c0838a.ana;
                        if (!s.k(file)) {
                            a(c0838a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!s.a(file, c0838a.md5)) {
                            a(c0838a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.i(c0838a);
                        }
                    } catch (Throwable th) {
                        a(c0838a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public static class h implements f<a.C0838a> {
        f<a.C0838a> aoh;

        public h(f<a.C0838a> fVar) {
            this.aoh = fVar;
        }

        @Override // com.kwad.sdk.api.loader.n.f
        public final void a(final v vVar, final c<a.C0838a> cVar) {
            this.aoh.a(vVar, new c<a.C0838a>() { // from class: com.kwad.sdk.api.loader.n.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.n.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void i(a.C0838a c0838a) {
                    String aM = com.kwad.sdk.api.loader.h.aM(vVar.getContext());
                    if (TextUtils.isEmpty(aM)) {
                        aM = com.kwad.sdk.api.c.AD().getSDKVersion();
                    }
                    String str = c0838a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(vVar.getContext(), "interval", c0838a.interval);
                    com.kwad.sdk.api.loader.b.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0838a.AJ()) {
                        u.aS(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + aM);
                        return;
                    }
                    if (com.kwad.sdk.api.loader.h.K(c0838a.sdkVersion, aM) && c0838a.AI()) {
                        cVar.i(c0838a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0838a.sdkVersion + " currentDynamicVersion:" + aM + " dynamicType:" + c0838a.amY);
                }
            });
        }
    }

    public static f<Boolean> AS() {
        return new e(new g(new d(new h(new b()))));
    }
}
