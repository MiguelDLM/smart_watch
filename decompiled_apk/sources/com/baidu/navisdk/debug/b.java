package com.baidu.navisdk.debug;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.debug.e;
import com.baidu.navisdk.util.common.g;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipOutputStream;

/* loaded from: classes7.dex */
public class b {
    private static String p;
    private static String q;
    private static volatile b r;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6771a = true;
    private File b = null;
    private File c = null;
    private File d = null;
    private BufferedWriter e = null;
    private File f = null;
    private BufferedWriter g = null;
    private boolean h = true;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private Set<String> l = new HashSet();
    private Set<String> m = new HashSet();
    private com.baidu.navisdk.debug.e n = new com.baidu.navisdk.debug.e("BNCoreLogFileUtil");
    private e.b o;

    /* renamed from: com.baidu.navisdk.debug.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0191b implements FilenameFilter {
        public C0191b(b bVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.startsWith("nav_core");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FilenameFilter {
        public c(b bVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.startsWith("nav_all");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements FilenameFilter {
        public d(b bVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.endsWith(OTAManager.OTA_ZIP_SUFFIX);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements FilenameFilter {
        public e(b bVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(OTAManager.OTA_ZIP_SUFFIX);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements FilenameFilter {
        public f(b bVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(OTAManager.OTA_ZIP_SUFFIX);
        }
    }

    private b() {
        a aVar = new a();
        this.o = aVar;
        this.n.a(aVar);
    }

    private void g() {
        File[] listFiles = new File(c()).listFiles(new C0191b(this));
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    file.delete();
                } catch (Exception e2) {
                    if (g.EYE_SPY.c()) {
                        g.EYE_SPY.c("del core err " + e2.toString());
                    }
                }
            }
        }
        File[] listFiles2 = new File(b()).listFiles(new c(this));
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                try {
                    file2.delete();
                } catch (Exception e3) {
                    if (g.EYE_SPY.c()) {
                        g.EYE_SPY.c("del all err " + e3.toString());
                    }
                }
            }
        }
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        String[] a2 = com.baidu.navisdk.debug.c.a(new File(c()).list(), 0L, currentTimeMillis);
        if (a2 != null) {
            for (String str : a2) {
                new File(c(), str).delete();
            }
        }
        String[] a3 = com.baidu.navisdk.debug.c.a(new File(b()).list(), 0L, currentTimeMillis);
        if (a3 != null) {
            for (String str2 : a3) {
                new File(b(), str2).delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        for (File file : new File(b).listFiles()) {
            if (this.f == null || !TextUtils.equals(file.getName(), this.f.getName())) {
                file.delete();
            }
        }
    }

    private void j() {
        try {
            int length = new File(c()).listFiles().length;
            g gVar = g.EYE_SPY;
            if (gVar.d()) {
                gVar.e("ensureFileNum CoreLog file num = " + length);
            }
            if (length > 30) {
                a(c());
            }
            long a2 = a(new File(c()));
            if (gVar.d()) {
                gVar.e("ensureFileNum CoreLog file size = " + ((a2 / 1024) / 1024));
            }
            if (a2 > 15728640) {
                a(c());
            }
        } catch (Exception e2) {
            g gVar2 = g.EYE_SPY;
            if (gVar2.d()) {
                gVar2.e("ensureFileNum err " + e2.toString());
            }
        }
        try {
            int length2 = new File(b()).listFiles().length;
            g gVar3 = g.EYE_SPY;
            if (gVar3.d()) {
                gVar3.e("ensureFileNum allLog file num = " + length2);
            }
            if (length2 > 30) {
                a(b());
            }
            long a3 = a(new File(b()));
            if (gVar3.d()) {
                gVar3.e("ensureFileNum allLog file size = " + ((a3 / 1024) / 1024));
            }
            if (a3 > Math.max(314572800, this.k)) {
                a(b());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static b k() {
        if (r == null) {
            synchronized (b.class) {
                try {
                    if (r == null) {
                        r = new b();
                    }
                } finally {
                }
            }
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        h();
        g();
        m();
    }

    private void m() {
        File[] fileArr;
        ZipOutputStream zipOutputStream;
        File file = new File(k().b());
        ZipOutputStream zipOutputStream2 = null;
        if (file.exists()) {
            fileArr = file.listFiles(new d(this));
        } else {
            fileArr = null;
        }
        if (fileArr == null) {
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (!name.startsWith("nav_all")) {
                file2.delete();
            } else {
                File file3 = this.f;
                if (file3 == null || !name.equals(file3.getName())) {
                    try {
                        zipOutputStream = com.baidu.navisdk.debug.f.a(new File(b(), file2.getName() + OTAManager.OTA_ZIP_SUFFIX));
                        try {
                            try {
                                com.baidu.navisdk.debug.f.a(file2, zipOutputStream, file.getName());
                                file2.delete();
                                com.baidu.navisdk.debug.f.a(zipOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                zipOutputStream2 = zipOutputStream;
                                com.baidu.navisdk.debug.f.a(zipOutputStream2);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            g gVar = g.COMMON;
                            if (gVar.c()) {
                                gVar.c("backupAllLogFile err" + e.toString());
                            }
                            com.baidu.navisdk.debug.f.a(zipOutputStream);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        zipOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
    }

    public String c() {
        try {
            File file = this.b;
            if (file != null && file.exists() && this.b.isDirectory()) {
                return this.b.getAbsolutePath();
            }
            if (!TextUtils.isEmpty(q)) {
                StringBuilder sb = new StringBuilder();
                sb.append(q);
                String str = File.separator;
                sb.append(str);
                sb.append("NavCoreLog");
                sb.append(str);
                sb.append("core");
                File file2 = new File(sb.toString());
                this.b = file2;
                if (!file2.exists()) {
                    this.b.mkdirs();
                }
            }
            File file3 = this.b;
            if (file3 != null) {
                return file3.getAbsolutePath();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String d() {
        if (!TextUtils.isEmpty(q) && !TextUtils.isEmpty(p)) {
            return q + File.separator + "NavCoreLog";
        }
        return null;
    }

    public File e() {
        return this.d;
    }

    public void f() {
        a(this.f, true);
    }

    public String b() {
        try {
            File file = this.c;
            if (file != null && file.exists() && this.c.isDirectory()) {
                return this.c.getAbsolutePath();
            }
            if (!TextUtils.isEmpty(p)) {
                StringBuilder sb = new StringBuilder();
                sb.append(p);
                String str = File.separator;
                sb.append(str);
                sb.append("NavCoreLog");
                sb.append(str);
                sb.append(TtmlNode.COMBINE_ALL);
                File file2 = new File(sb.toString());
                this.c = file2;
                if (!file2.exists()) {
                    this.c.mkdirs();
                }
            }
            File file3 = this.c;
            if (file3 != null) {
                return file3.getAbsolutePath();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(g gVar, int i, String str) {
        int i2;
        if (this.h) {
            if (i == 1 && gVar == g.GPS) {
                i2 = 2;
            } else {
                i2 = (i == 1 && gVar == g.TTS) ? 3 : (i == 1 || i == 6) ? 1 : 4;
            }
            this.n.a(304, hashCode(), i2, str, 0L);
        }
    }

    /* loaded from: classes7.dex */
    public class a extends e.b {
        public a() {
        }

        @Override // com.baidu.navisdk.debug.e.b
        public void a(Message message) {
            if (message.arg1 != b.this.hashCode()) {
                return;
            }
            switch (message.what) {
                case 304:
                    b.this.a(message.arg2, (String) message.obj);
                    return;
                case 305:
                    b.this.l();
                    return;
                case 306:
                    b.this.i();
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.navisdk.debug.e.b
        public void a() {
            a(304);
            a(305);
            a(306);
        }
    }

    private boolean a(File file, boolean z) {
        Exception e2;
        File file2;
        if (this.g == null || file == null) {
            return false;
        }
        if (!z && (this.i < 10000 || file.length() < 26214400)) {
            return true;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            this.g.flush();
            this.g.close();
            this.g = null;
            this.f = null;
            this.i = 0;
        } catch (IOException e3) {
            this.g = null;
            g gVar = g.EYE_SPY;
            if (gVar.c()) {
                gVar.c("checkAllLogFile err" + e3.toString());
            }
        }
        try {
            try {
                file2 = new File(b(), file.getName() + OTAManager.OTA_ZIP_SUFFIX);
                try {
                    zipOutputStream = com.baidu.navisdk.debug.f.a(file2);
                    com.baidu.navisdk.debug.f.a(file, zipOutputStream, file.getName());
                    g gVar2 = g.EYE_SPY;
                    if (gVar2.e()) {
                        gVar2.g("checkLogAllFile zip " + file.getName());
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    g gVar3 = g.EYE_SPY;
                    if (gVar3.c()) {
                        gVar3.c("checkLogAllFile err" + e2.toString());
                    }
                    file.delete();
                    if (file2 != null) {
                        this.m.add(file2.getPath());
                    }
                    return false;
                }
            } catch (Exception e5) {
                e2 = e5;
                file2 = null;
            }
            try {
                file.delete();
            } catch (Exception e6) {
                if (g.EYE_SPY.c()) {
                    g.EYE_SPY.c("coreLogAllFile del err " + e6.toString());
                }
            }
            if (file2 != null && file2.exists()) {
                this.m.add(file2.getPath());
            }
            return false;
        } finally {
            com.baidu.navisdk.debug.f.a(zipOutputStream);
        }
    }

    private boolean c(File file) {
        if (this.e != null && file != null) {
            if (this.j < 10000 || file.length() < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                return true;
            }
            this.j = 0;
            try {
                File file2 = this.d;
                if (file2 != null) {
                    this.l.add(file2.getPath());
                }
                this.e.flush();
                this.e.close();
                this.e = null;
                this.d = null;
            } catch (IOException e2) {
                this.e = null;
                g gVar = g.COMMON;
                if (gVar.c()) {
                    gVar.c("coreLogFile close err " + e2.toString());
                }
            }
        }
        return false;
    }

    private boolean b(File file) {
        return a(file, false);
    }

    public String[] b(long j, long j2) {
        String[] a2 = com.baidu.navisdk.debug.c.a(new File(c()).list(), j, j2);
        if (a2 == null) {
            return null;
        }
        int length = a2.length;
        for (int i = 0; i < length; i++) {
            a2[i] = c() + File.separator + a2[i];
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        File file;
        boolean z;
        BufferedWriter bufferedWriter;
        if (d() == null) {
            return;
        }
        if (4 == i) {
            if (!b(this.f)) {
                this.f = new File(b() + File.separator + "nav_all_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            }
            file = this.f;
        } else {
            if (!c(this.d)) {
                this.d = new File(c() + File.separator + "nav_core_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            }
            file = this.d;
        }
        if (file != null && !file.exists()) {
            try {
                j();
                if (!file.createNewFile()) {
                    file = null;
                }
                z = true;
            } catch (Exception e2) {
                g gVar = g.EYE_SPY;
                if (gVar.c()) {
                    gVar.c("doAddCoreLog", e2.getLocalizedMessage());
                }
                file = null;
            }
            if (file == null && file.exists()) {
                if (4 == i) {
                    if (this.g == null) {
                        try {
                            this.i = 0;
                            this.g = new BufferedWriter(new FileWriter(file));
                        } catch (IOException e3) {
                            this.g = null;
                            g gVar2 = g.EYE_SPY;
                            if (gVar2.c()) {
                                gVar2.c("doAddCoreLog", e3.getLocalizedMessage());
                            }
                        }
                    }
                    BufferedWriter bufferedWriter2 = this.g;
                    if (bufferedWriter2 != null) {
                        try {
                            this.i++;
                            bufferedWriter2.append((CharSequence) (com.baidu.navisdk.debug.a.f6770a.format(new Date()) + " " + str + "\n"));
                            this.g.flush();
                        } catch (IOException e4) {
                            try {
                                this.g.close();
                                this.g = null;
                            } catch (Exception unused) {
                            }
                            g gVar3 = g.EYE_SPY;
                            if (gVar3.c()) {
                                gVar3.c("doAddCoreLog", e4.getLocalizedMessage());
                            }
                        }
                    }
                } else {
                    if (this.e == null || z) {
                        try {
                            this.j = 0;
                            this.e = new BufferedWriter(new FileWriter(file));
                        } catch (IOException e5) {
                            this.e = null;
                            g gVar4 = g.EYE_SPY;
                            if (gVar4.c()) {
                                gVar4.c("doAddCoreLog", e5.getLocalizedMessage());
                            }
                        }
                    }
                    SimpleDateFormat simpleDateFormat = com.baidu.navisdk.debug.a.f6770a;
                    if (simpleDateFormat != null && (bufferedWriter = this.e) != null) {
                        try {
                            bufferedWriter.append((CharSequence) (simpleDateFormat.format(new Date()) + " " + str + "\n"));
                            this.j = this.j + 1;
                            this.e.flush();
                        } catch (IOException e6) {
                            try {
                                this.e.close();
                                this.e = null;
                            } catch (Exception unused2) {
                            }
                            g gVar5 = g.EYE_SPY;
                            if (gVar5.c()) {
                                gVar5.c("doAddCoreLog", e6.getLocalizedMessage());
                            }
                        }
                    }
                }
                if (this.f6771a) {
                    this.f6771a = false;
                    this.n.a(305, hashCode(), 0, null, 0L);
                    return;
                }
                return;
            }
        }
        z = false;
        if (file == null) {
        }
    }

    public long a(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                length = a(listFiles[i]);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
    }

    private void a(String str) {
        String[] list = new File(str).list(new e(this));
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        int length = list.length / 3;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(list[i]);
            new File(sb.toString()).delete();
            g gVar = g.EYE_SPY;
            if (gVar.b()) {
                gVar.b("delOldestFile = " + str + str2 + list[i]);
            }
        }
    }

    public void a() {
        this.n.a(306, hashCode(), 0, null, 0L);
    }

    public String[] a(long j, long j2) {
        String[] a2 = com.baidu.navisdk.debug.c.a(new File(b()).list(new f(this)), j, j2);
        if (a2 == null) {
            return null;
        }
        int length = a2.length;
        for (int i = 0; i < length; i++) {
            a2[i] = b() + File.separator + a2[i];
        }
        return a2;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public static void a(Context context) {
        if (TextUtils.isEmpty(q) || TextUtils.isEmpty(p)) {
            q = context.getFilesDir().getAbsolutePath();
            try {
                p = context.getExternalCacheDir().getAbsolutePath();
            } catch (Exception unused) {
                p = context.getCacheDir().getAbsolutePath();
            }
        }
    }
}
