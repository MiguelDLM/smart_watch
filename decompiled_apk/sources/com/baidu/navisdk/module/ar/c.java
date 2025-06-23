package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.z;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XoX;

/* loaded from: classes7.dex */
public final class c {

    @OOXIXo
    public static final b h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f6977a;
    private final List<a> b;
    private WeakReference<InterfaceC0214c> c;
    private final com.baidu.navisdk.module.ar.b d;
    private final String[] e;
    private final HashMap<String, String> f;
    private final X0IIOO g;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private String f6978a;

        @oOoXoXO
        private String b;

        @oOoXoXO
        private String c;
        private boolean e;

        @oOoXoXO
        private String f;
        private int d = 1;
        private int g = -1;

        public final void a(boolean z) {
            this.e = z;
        }

        public final void b(@oOoXoXO String str) {
            this.c = str;
        }

        public final void c(@oOoXoXO String str) {
            this.f6978a = str;
        }

        public final void d(@oOoXoXO String str) {
            this.b = str;
        }

        @oOoXoXO
        public final String e() {
            return this.f6978a;
        }

        @oOoXoXO
        public final String f() {
            return this.b;
        }

        public final int g() {
            return this.d;
        }

        public final boolean h() {
            return !TextUtils.isEmpty(this.f);
        }

        public final boolean i() {
            return !TextUtils.isEmpty(this.b);
        }

        @OOXIXo
        public String toString() {
            return "BNARResourceModel(name=" + this.f6978a + ", url=" + this.b + ", md5=" + this.c + ", filePath=" + this.f + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final void a(@oOoXoXO String str) {
            this.f = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.g = 2;
        }

        public final void b(int i) {
            this.d = i;
        }

        public final boolean c() {
            return this.e;
        }

        @oOoXoXO
        public final String d() {
            return this.c;
        }

        @oOoXoXO
        public final String b() {
            return this.f;
        }

        public final int a() {
            return this.g;
        }

        public final void a(int i) {
            this.g = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        @OOXIXo
        public final c a() {
            return d.b.a();
        }

        public /* synthetic */ b(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.module.ar.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0214c {
        void a(int i);
    }

    /* loaded from: classes7.dex */
    public static final class d {

        @OOXIXo
        public static final d b = new d();

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private static final c f6979a = new c(null);

        private d() {
        }

        @OOXIXo
        public final c a() {
            return f6979a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends com.baidu.navisdk.util.worker.lite.b {
        final /* synthetic */ boolean b;
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z, Context context, String str) {
            super(str);
            this.b = z;
            this.c = context;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            WeakReference weakReference;
            InterfaceC0214c interfaceC0214c;
            InterfaceC0214c interfaceC0214c2;
            InterfaceC0214c interfaceC0214c3;
            InterfaceC0214c interfaceC0214c4;
            boolean z = false;
            if (c.this.j()) {
                c.this.a(false);
                if (this.b) {
                    c.this.e();
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "startDownloadResource :" + c.this.b);
            }
            if (c.this.b.isEmpty()) {
                WeakReference weakReference2 = c.this.c;
                if (weakReference2 != null && (interfaceC0214c4 = (InterfaceC0214c) weakReference2.get()) != null) {
                    interfaceC0214c4.a(3);
                    return;
                }
                return;
            }
            if (!z.b(this.c)) {
                WeakReference weakReference3 = c.this.c;
                if (weakReference3 != null && (interfaceC0214c3 = (InterfaceC0214c) weakReference3.get()) != null) {
                    interfaceC0214c3.a(3);
                    return;
                }
                return;
            }
            WeakReference weakReference4 = c.this.c;
            if (weakReference4 != null && (interfaceC0214c2 = (InterfaceC0214c) weakReference4.get()) != null) {
                interfaceC0214c2.a(0);
            }
            for (a aVar : c.this.b) {
                if (!aVar.h() && aVar.i()) {
                    c.this.a(aVar);
                    z = true;
                }
            }
            if (!z && (weakReference = c.this.c) != null && (interfaceC0214c = (InterfaceC0214c) weakReference.get()) != null) {
                interfaceC0214c.a(3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends Lambda implements oIX0oI<com.baidu.navisdk.filedownload.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f6981a = new f();

        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.filedownload.b invoke() {
            return new com.baidu.navisdk.filedownload.b();
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends Lambda implements oIX0oI<a> {

        /* loaded from: classes7.dex */
        public static final class a implements com.baidu.navisdk.filedownload.c {
            public a() {
            }

            @Override // com.baidu.navisdk.filedownload.c
            public void a(@oOoXoXO String str, long j, long j2) {
            }

            @Override // com.baidu.navisdk.filedownload.c
            public void a(@oOoXoXO String str, @oOoXoXO File file, @oOoXoXO String str2) {
                InterfaceC0214c interfaceC0214c;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNARResourceManager", "onDownloadFailed: " + str);
                }
                c.this.a(str, (String) null);
                if (c.this.k()) {
                    if (c.this.c != null) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.10.3", "1", "0");
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.10.3", "1", "1");
                    }
                    WeakReference weakReference = c.this.c;
                    if (weakReference == null || (interfaceC0214c = (InterfaceC0214c) weakReference.get()) == null) {
                        return;
                    }
                    interfaceC0214c.a(3);
                }
            }

            @Override // com.baidu.navisdk.filedownload.c
            public void a(@oOoXoXO String str, @oOoXoXO String str2) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNARResourceManager", "onDownloadSuccess: " + str);
                }
                c.this.a(str, str2);
                if (c.this.j()) {
                    c.this.a(true);
                }
            }
        }

        public g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    private c() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f6977a = XIxXXX0x0.I0Io(lazyThreadSafetyMode, f.f6981a);
        this.b = Collections.synchronizedList(new ArrayList(4));
        this.d = com.baidu.navisdk.module.ar.b.c.a();
        String[] strArr = {"detector", "detector_night", "lanesegment", "lanesegment_night", "engine_resource", "traffic", "traffic_night"};
        this.e = strArr;
        this.f = new HashMap<>(strArr.length, 1.0f);
        this.g = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new g());
    }

    private final com.baidu.navisdk.filedownload.b f() {
        return (com.baidu.navisdk.filedownload.b) this.f6977a.getValue();
    }

    private final com.baidu.navisdk.filedownload.c g() {
        return (com.baidu.navisdk.filedownload.c) this.g.getValue();
    }

    private final void h() {
        int i;
        String str;
        int i2;
        HashMap<String, f.b> hashMap = com.baidu.navisdk.module.cloudconfig.f.c().O.f7102a;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "initResourceModel: " + hashMap);
        }
        if (this.b.isEmpty()) {
            if (!hashMap.isEmpty()) {
                for (Map.Entry<String, f.b> entry : hashMap.entrySet()) {
                    a aVar = new a();
                    f.b value = entry.getValue();
                    if (value != null) {
                        str = value.c;
                    } else {
                        str = null;
                    }
                    aVar.b(str);
                    aVar.c(entry.getValue().f7104a);
                    aVar.d(entry.getValue().b);
                    aVar.b(entry.getValue().d);
                    aVar.a(entry.getValue().e);
                    if (aVar.i()) {
                        com.baidu.navisdk.filedownload.b f2 = f();
                        String f3 = aVar.f();
                        IIX0o.ooOOo0oXI(f3);
                        aVar.a(a(f2.a(f3, aVar.d(), "navi_ar_resource")));
                        if (aVar.h()) {
                            i2 = 2;
                        } else {
                            i2 = -1;
                        }
                        aVar.a(i2);
                        this.b.add(aVar);
                    }
                }
                return;
            }
            return;
        }
        for (a aVar2 : this.b) {
            if (aVar2.i()) {
                com.baidu.navisdk.filedownload.b f4 = f();
                String f5 = aVar2.f();
                IIX0o.ooOOo0oXI(f5);
                aVar2.a(a(f4.a(f5, aVar2.d(), "navi_ar_resource")));
                if (aVar2.h()) {
                    i = 2;
                } else {
                    i = -1;
                }
                aVar2.a(i);
            }
        }
    }

    private final boolean i() {
        for (String str : this.e) {
            if (!this.f.containsKey(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (this.b.isEmpty()) {
            return false;
        }
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k() {
        boolean z = true;
        boolean z2 = false;
        for (a aVar : this.b) {
            if (aVar.a() != 1 && aVar.a() != -1) {
                if (aVar.a() == 3) {
                    z2 = true;
                }
            } else {
                z = false;
            }
        }
        if (z && z2) {
            return true;
        }
        return false;
    }

    private final boolean l() {
        return f().a();
    }

    private final void m() {
        HashMap<String, String> hashMap = this.f;
        if (hashMap != null) {
            hashMap.clear();
        }
        for (String str : this.e) {
            String a2 = this.d.a(str, (String) null);
            if (a2 != null && a2.length() != 0 && s.d(a2)) {
                HashMap<String, String> hashMap2 = this.f;
                IIX0o.ooOOo0oXI(a2);
                hashMap2.put(str, a2);
            }
        }
    }

    private final void n() {
        for (a aVar : this.b) {
            if (aVar != null && !aVar.h() && aVar.c()) {
                HashMap<String, String> hashMap = this.f;
                String e2 = aVar.e();
                if (hashMap != null) {
                    XoX.OOXIXo(hashMap).remove(e2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                }
            }
        }
    }

    private final boolean b(String str) {
        Iterator<Map.Entry<String, String>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            if (IIX0o.Oxx0IOOO(str, it.next().getValue())) {
                return true;
            }
        }
        return false;
    }

    private final boolean c(String str) {
        for (a aVar : this.b) {
            if (aVar != null && IIX0o.Oxx0IOOO(str, aVar.b())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        String a2 = f().a("navi_ar_resource");
        if (a2 == null || a2.length() == 0) {
            return;
        }
        try {
            File file = new File(a2);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNARResourceManager", "deleteOldRes all file:" + listFiles + TokenParser.SP);
                }
                if (listFiles != null && listFiles.length != 0 && listFiles.length > this.f.size()) {
                    for (File file2 : listFiles) {
                        String a3 = a(file2.getAbsolutePath());
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e("BNARResourceManager", "deleteOldRes: " + file2 + "-----" + a3);
                        }
                        if (a3 != null && a3.length() != 0) {
                            IIX0o.ooOOo0oXI(a3);
                            if (!b(a3)) {
                                IIX0o.ooOOo0oXI(a3);
                                if (!c(a3)) {
                                    if (gVar2.d()) {
                                        gVar2.e("BNARResourceManager", "deleteOldRes need delete: " + file2);
                                    }
                                    s.a(file2);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final int d() {
        for (a aVar : this.b) {
            if (IIX0o.Oxx0IOOO("traffic", aVar.e())) {
                return aVar.g();
            }
        }
        return 1;
    }

    public final int b() {
        for (a aVar : this.b) {
            if (IIX0o.Oxx0IOOO("lanesegment", aVar.e())) {
                return aVar.g();
            }
        }
        return 1;
    }

    public final int c() {
        for (a aVar : this.b) {
            if (IIX0o.Oxx0IOOO("detector", aVar.e())) {
                return aVar.g();
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        String b2;
        InterfaceC0214c interfaceC0214c;
        InterfaceC0214c interfaceC0214c2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "handleAllResDownloadSuccess: " + z);
        }
        boolean i = i();
        if (!i) {
            for (a aVar : this.b) {
                HashMap<String, String> hashMap = this.f;
                String e2 = aVar.e();
                IIX0o.ooOOo0oXI(e2);
                String b3 = aVar.b();
                IIX0o.ooOOo0oXI(b3);
                hashMap.put(e2, b3);
            }
        }
        if (z || !i) {
            for (a aVar2 : this.b) {
                String e3 = aVar2.e();
                if (e3 != null && e3.length() != 0 && (b2 = aVar2.b()) != null && b2.length() != 0) {
                    this.d.b(aVar2.e(), aVar2.b());
                }
            }
            this.d.a();
        }
        if (z) {
            if (this.c != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.10.3", "0", "0");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.10.3", "0", "1");
            }
        }
        if (i()) {
            WeakReference<InterfaceC0214c> weakReference = this.c;
            if (weakReference == null || (interfaceC0214c2 = weakReference.get()) == null) {
                return;
            }
            interfaceC0214c2.a(2);
            return;
        }
        WeakReference<InterfaceC0214c> weakReference2 = this.c;
        if (weakReference2 == null || (interfaceC0214c = weakReference2.get()) == null) {
            return;
        }
        interfaceC0214c.a(3);
    }

    public /* synthetic */ c(IIXOooo iIXOooo) {
        this();
    }

    private final String a(String str) {
        if (str != null && str.length() != 0) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                if (file.isFile()) {
                    return file.getAbsolutePath();
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0 && listFiles.length != 0) {
                    String str2 = null;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            str2 = file2.getAbsolutePath();
                        }
                    }
                    return str2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "updateFileDownloadInfo: " + str + ", " + str2);
        }
        if (str == null || str.length() == 0) {
            return;
        }
        for (a aVar : this.b) {
            if (IIX0o.Oxx0IOOO(str, aVar.f())) {
                String a2 = (str2 == null || str2.length() == 0) ? null : a(str2);
                if (a2 != null && a2.length() != 0) {
                    aVar.a(a2);
                    aVar.a(2);
                } else {
                    aVar.a((String) null);
                    aVar.a(3);
                }
            }
        }
    }

    public final void a(@oOoXoXO Context context, @oOoXoXO InterfaceC0214c interfaceC0214c) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "startDownloadResource ");
        }
        this.c = new WeakReference<>(interfaceC0214c);
        m();
        h();
        n();
        if (i()) {
            this.c = null;
            a(context, true);
            if (interfaceC0214c != null) {
                interfaceC0214c.a(2);
                return;
            }
            return;
        }
        if (!l()) {
            a(context, false);
        } else if (interfaceC0214c != null) {
            interfaceC0214c.a(1);
        }
    }

    private final void a(Context context, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "asyncDownloadRes: " + z);
        }
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new e(z, context, "BNWorkerCenter::DownloadRes"), 10003);
    }

    @OOXIXo
    public final HashMap<String, String> a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARResourceManager", "downloadUnzipFile: " + aVar + TokenParser.SP);
        }
        String f2 = aVar.f();
        IIX0o.ooOOo0oXI(f2);
        com.baidu.navisdk.filedownload.a aVar2 = new com.baidu.navisdk.filedownload.a(f2);
        aVar2.a(false).e("navi_ar_resource").c(aVar.d()).a(g()).d(aVar.d());
        aVar.a(1);
        com.baidu.navisdk.filedownload.b.a(f(), aVar2, false, false, 6, null);
    }
}
