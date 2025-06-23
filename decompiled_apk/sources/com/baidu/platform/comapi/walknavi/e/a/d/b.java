package com.baidu.platform.comapi.walknavi.e.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.npc.ArBridge;
import com.baidu.platform.comapi.walknavi.e.a.g.j;
import java.io.File;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9724a;
    private C0536b b;
    private a c;
    private g d;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i);

        void a(boolean z, boolean z2);
    }

    public b(Context context) {
        this.f9724a = context;
        this.d = new g(context);
    }

    private void d(String str) {
        b();
        C0536b c0536b = new C0536b(this.f9724a, str);
        this.b = c0536b;
        c0536b.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            return str.substring(lastIndexOf, lastIndexOf2);
        }
        return str.substring(lastIndexOf);
    }

    public void b(String str) {
        if (com.baidu.platform.comapi.walknavi.e.a.d.a.a(this.c)) {
            return;
        }
        if (c()) {
            a(true, false);
            return;
        }
        if (!TextUtils.equals(this.d.b(), com.baidu.platform.comapi.walknavi.e.a.g.b.b())) {
            d(str);
            return;
        }
        String a2 = this.d.a();
        String e = e(str);
        if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, e)) {
            File file = new File(b(this.f9724a), a2);
            if (file.exists()) {
                File[] a3 = a(new File(file, "res"));
                if (a3 != null && a3.length > 0) {
                    a(a(a3), false);
                    return;
                }
                this.d.a("");
            }
        }
        d(str);
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.e.a.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0536b extends Thread {
        private Context b;
        private String c;
        private volatile boolean d = false;

        public C0536b(Context context, String str) {
            this.b = context;
            this.c = str;
        }

        private boolean a(String str, File file) {
            return com.baidu.platform.comapi.walknavi.e.a.d.a.b.a(str, file, new d(this));
        }

        public boolean b() {
            return this.d;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            h hVar = new h();
            String str = this.c;
            hVar.b = str;
            hVar.f9731a = b.e(str);
            String str2 = hVar.b;
            File file = new File(b.b(this.b), hVar.f9731a);
            File file2 = new File(file, "res.zip");
            com.baidu.platform.comapi.walknavi.e.a.d.a.a.a(file2);
            boolean a2 = a(str2, file2);
            if (b()) {
                com.baidu.platform.comapi.walknavi.e.a.d.a.a.b(file);
            } else if (a2 && com.baidu.platform.comapi.walknavi.e.a.d.a.e.a(file2, file) && b.this.b(new File(file, "res"))) {
                a(true, hVar);
            } else {
                a(false, (h) null);
            }
        }

        public void a() {
            this.d = true;
        }

        private void a(boolean z, h hVar) {
            j.a(new f(this, z, hVar));
        }
    }

    private boolean c(File file) {
        try {
            if (!file.exists()) {
                return false;
            }
            String absolutePath = file.getAbsolutePath();
            if (!com.baidu.platform.comapi.walknavi.e.a.d.a.a(absolutePath)) {
                return true;
            }
            System.load(absolutePath);
            return true;
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("loadSoFile error: " + th.getMessage());
            return false;
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    private static boolean c() {
        try {
            return ArBridge.libraryHasLoaded();
        } catch (Throwable th) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("hasLoad() error: " + th.getMessage());
            return false;
        }
    }

    public boolean a() {
        File[] a2;
        if (c()) {
            return true;
        }
        String a3 = this.d.a();
        if (TextUtils.isEmpty(a3)) {
            return false;
        }
        File file = new File(b(this.f9724a), a3);
        if (!file.exists() || (a2 = a(new File(file, "res"))) == null || a2.length <= 0) {
            return false;
        }
        return a(a2);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str) || c()) {
            return false;
        }
        if (!TextUtils.equals(this.d.b(), com.baidu.platform.comapi.walknavi.e.a.g.b.b())) {
            return true;
        }
        String a2 = this.d.a();
        return TextUtils.isEmpty(a2) || !TextUtils.equals(a2, e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file) {
        return a(a(file));
    }

    public void b() {
        C0536b c0536b = this.b;
        if (c0536b != null) {
            c0536b.a();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File b(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        com.baidu.platform.comapi.walknavi.e.a.d.a.a.a(file);
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private static boolean b(File[] fileArr) {
        if (fileArr != null && fileArr.length == 1) {
            boolean z = false;
            for (File file : fileArr) {
                if ("libbaiduar.so".equals(file.getName())) {
                    z = true;
                }
            }
            if (z) {
                return true;
            }
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("SoDownloader, Can not found libbaiduar.so");
            return false;
        }
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("SoDownloader, The number of files is not 1");
        return false;
    }

    private File[] a(File file) {
        return file.listFiles(new c(this));
    }

    private boolean a(File[] fileArr) {
        if (!b(fileArr)) {
            return false;
        }
        if (fileArr != null) {
            for (File file : fileArr) {
                if (!c(file)) {
                    return false;
                }
            }
        }
        return c();
    }
}
