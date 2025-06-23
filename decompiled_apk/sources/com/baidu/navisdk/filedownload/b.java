package com.baidu.navisdk.filedownload;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.f;
import com.baidu.navisdk.util.common.g;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XoX;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f6793a = XIxXXX0x0.oIX0oI(d.f6796a);
    private final X0IIOO b = XIxXXX0x0.oIX0oI(e.f6797a);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.filedownload.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0195b extends com.baidu.navisdk.util.worker.lite.b {
        final /* synthetic */ com.baidu.navisdk.filedownload.a b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0195b(com.baidu.navisdk.filedownload.a aVar, boolean z, String str) {
            super(str);
            this.b = aVar;
            this.c = z;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            b.this.a(this.b.d(), this.b.c(), this.b.b(), this.c);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<ConcurrentHashMap<String, com.baidu.navisdk.filedownload.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f6796a = new d();

        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final ConcurrentHashMap<String, com.baidu.navisdk.filedownload.a> invoke() {
            return new ConcurrentHashMap<>(8);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends Lambda implements oIX0oI<com.baidu.navisdk.util.http.custom.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f6797a = new e();

        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.util.http.custom.a invoke() {
            return new com.baidu.navisdk.util.http.custom.a();
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, com.baidu.navisdk.filedownload.a> b() {
        return (ConcurrentHashMap) this.f6793a.getValue();
    }

    private final com.baidu.navisdk.util.http.custom.b c() {
        return (com.baidu.navisdk.util.http.custom.b) this.b.getValue();
    }

    private final boolean d() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        IIX0o.oO(mainLooper, "Looper.getMainLooper()");
        return IIX0o.Oxx0IOOO(currentThread, mainLooper.getThread());
    }

    /* loaded from: classes7.dex */
    public static final class c implements com.baidu.navisdk.util.http.custom.listeners.a {
        final /* synthetic */ boolean b;

        public c(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.navisdk.util.http.custom.listeners.a
        public void a(@oOoXoXO String str, @oOoXoXO File file, @oOoXoXO String str2) {
            com.baidu.navisdk.filedownload.c a2;
            if (file != null) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap b = b.this.b();
            if (b == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            com.baidu.navisdk.filedownload.a aVar = (com.baidu.navisdk.filedownload.a) XoX.OOXIXo(b).remove(str);
            if (aVar == null || (a2 = aVar.a()) == null) {
                return;
            }
            a2.a(str, (File) null, str2);
        }

        @Override // com.baidu.navisdk.util.http.custom.listeners.a
        public void a(@oOoXoXO String str, @oOoXoXO File file) {
            b.this.a(str, file, this.b);
        }

        @Override // com.baidu.navisdk.util.http.custom.listeners.a
        public void a(@OOXIXo String url, long j, long j2) {
            com.baidu.navisdk.filedownload.c a2;
            IIX0o.x0xO0oo(url, "url");
            com.baidu.navisdk.filedownload.a aVar = (com.baidu.navisdk.filedownload.a) b.this.b().get(url);
            if (aVar == null || !aVar.e() || (a2 = aVar.a()) == null) {
                return;
            }
            a2.a(url, j, j2);
        }
    }

    @oOoXoXO
    public final String a(@OOXIXo String url, @oOoXoXO String str, @OOXIXo String dirName) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(dirName, "dirName");
        return f.b.b(url, str, dirName);
    }

    @oOoXoXO
    public final String a(@OOXIXo String dirName) {
        IIX0o.x0xO0oo(dirName, "dirName");
        return f.b.a(dirName);
    }

    public static /* synthetic */ void a(b bVar, com.baidu.navisdk.filedownload.a aVar, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        bVar.a(aVar, z, z2);
    }

    public final void a(@oOoXoXO com.baidu.navisdk.filedownload.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.f()) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("BNFileDownloadWrapper", "downloadAndUnzipFile: " + aVar + ", " + z + ", " + z2);
            }
            com.baidu.navisdk.filedownload.a aVar2 = b().get(aVar.d());
            if (aVar2 != null) {
                g gVar2 = g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("BNFileDownloadWrapper", "tempDownloadRequest: " + aVar2);
                }
                aVar2.a(aVar.a());
                return;
            }
            b().put(aVar.d(), aVar);
            if (!z && !d()) {
                a(aVar.d(), aVar.c(), aVar.b(), z2);
                return;
            } else {
                com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new C0195b(aVar, z2, "BNWorkerCenter-downloadAndUnzipFile"), 10003);
                return;
            }
        }
        g gVar3 = g.COMMON;
        if (gVar3.c()) {
            gVar3.e("BNFileDownloadWrapper", "downloadAndUnzipFile:fileDownloadRequest is not valid ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2, String str3, boolean z) {
        com.baidu.navisdk.filedownload.c a2;
        String a3 = f.b.a(str, str2, str3);
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("BNFileDownloadWrapper", "downloadAndUnzipFile: url-" + str + ", parentDirName-" + str2 + ',' + a3 + ", " + z);
        }
        if (TextUtils.isEmpty(a3)) {
            com.baidu.navisdk.filedownload.a remove = b().remove(str);
            if (remove == null || (a2 = remove.a()) == null) {
                return;
            }
            a2.a(str, (File) null, "createCacheFilePath error");
            return;
        }
        com.baidu.navisdk.util.http.custom.b c2 = c();
        c cVar = new c(z);
        IIX0o.ooOOo0oXI(a3);
        c2.a(str, cVar, new File(a3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0109 A[Catch: all -> 0x010d, TRY_LEAVE, TryCatch #6 {all -> 0x010d, blocks: (B:67:0x0103, B:69:0x0109), top: B:66:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r12, java.io.File r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.filedownload.b.a(java.lang.String, java.io.File, boolean):void");
    }

    public final boolean a() {
        return !b().isEmpty();
    }
}
