package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes13.dex */
public final class ay {
    public static ay f;
    public final ActivityManager b;
    final aa c;
    final ak d;
    String e;
    private final Context g;
    private final ac h;
    private final as i;
    private FileObserver k;
    private bg m;
    private int n;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f26582a = new AtomicBoolean(false);
    private final Object j = new Object();
    private boolean l = true;
    private long o = 0;

    /* loaded from: classes13.dex */
    public class I0Io extends FileObserver {
        public I0Io(String str) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (str == null) {
                return;
            }
            al.d("observe file, dir:%s fileName:%s", ay.this.e, str);
            if (str.startsWith("manual_bugly_trace_") && str.endsWith(".txt")) {
                if (!ay.this.f26582a.get()) {
                    al.c("proc is not in anr, just ignore", new Object[0]);
                    return;
                }
                if (ay.this.c.a()) {
                    al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                    NativeCrashHandler.getInstance().resendSigquit();
                    long a2 = am.a(str, "manual_bugly_trace_", ".txt");
                    ay.this.a(a2, ay.this.e + "/" + str);
                    al.c("Finish handling one anr.", new Object[0]);
                    return;
                }
                al.c("Found background anr, resend sigquit later.", new Object[0]);
                long a3 = am.a(str, "manual_bugly_trace_", ".txt");
                ay.this.a(a3, ay.this.e + "/" + str);
                al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                NativeCrashHandler.getInstance().resendSigquit();
                return;
            }
            al.c("not manual trace file, ignore.", new Object[0]);
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ay.a(ay.this);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends FileObserver {

        /* renamed from: com.tencent.bugly.proguard.ay$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC1084oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ String f26587XO;

            public RunnableC1084oIX0oI(String str) {
                this.f26587XO = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                long j;
                ay ayVar = ay.this;
                String str = this.f26587XO;
                if (ayVar.a(true)) {
                    try {
                        al.c("read trace first dump for create time!", new Object[0]);
                        TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                        if (readFirstDumpInfo != null) {
                            j = readFirstDumpInfo.c;
                        } else {
                            j = -1;
                        }
                        if (j == -1) {
                            al.d("trace dump fail could not get time!", new Object[0]);
                            j = System.currentTimeMillis();
                        }
                        if (ayVar.a(j)) {
                            return;
                        }
                        ayVar.a(j, str);
                    } catch (Throwable th) {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        al.e("handle anr error %s", th.getClass().toString());
                    }
                }
            }
        }

        public oIX0oI(String str) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (str == null) {
                return;
            }
            String concat = "/data/anr/".concat(str);
            al.d("watching file %s", concat);
            if (!concat.contains(MqttServiceConstants.TRACE_ACTION)) {
                al.d("not anr file %s", concat);
            } else {
                ay.this.d.a(new RunnableC1084oIX0oI(concat));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ay.a(ay.this);
        }
    }

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a2 = ap.a(context);
        this.g = a2;
        this.b = (ActivityManager) a2.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (ap.b(NativeCrashHandler.getDumpFilePath())) {
            this.e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.e = NativeCrashHandler.getDumpFilePath();
        }
        this.c = aaVar;
        this.d = akVar;
        this.h = acVar;
        this.i = asVar;
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        oIX0oI oix0oi = new oIX0oI("/data/anr/");
        this.k = oix0oi;
        try {
            oix0oi.startWatching();
            al.a("start anr monitor!", new Object[0]);
            this.d.a(new II0xO0());
        } catch (Throwable th) {
            this.k = null;
            al.d("start anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean e() {
        if (this.k != null) {
            return true;
        }
        return false;
    }

    private synchronized boolean f() {
        return this.l;
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        synchronized (this.j) {
            try {
                bg bgVar = this.m;
                if (bgVar != null) {
                    if (!bgVar.isAlive()) {
                    }
                }
                bg bgVar2 = new bg();
                this.m = bgVar2;
                boolean z = this.c.S;
                bgVar2.b = z;
                al.c("set record stack trace enable:".concat(String.valueOf(z)), new Object[0]);
                bg bgVar3 = this.m;
                StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                int i = this.n;
                this.n = i + 1;
                sb.append(i);
                bgVar3.setName(sb.toString());
                this.m.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        I0Io i0Io = new I0Io(this.e);
        this.k = i0Io;
        try {
            i0Io.startWatching();
            al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.e);
            this.d.a(new oxoX());
        } catch (Throwable th2) {
            this.k = null;
            al.d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!al.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.j) {
            try {
                bg bgVar = this.m;
                if (bgVar != null) {
                    bgVar.a();
                    this.m = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (!al.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public final void b(boolean z) {
        d(z);
        boolean f2 = f();
        ac a2 = ac.a();
        if (a2 != null) {
            f2 = f2 && a2.c().f;
        }
        if (f2 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(f2));
            c(f2);
        }
    }

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f;
        }
        return ayVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.c.k();
            crashDetailBean.G = this.c.j();
            crashDetailBean.H = this.c.l();
            crashDetailBean.I = ab.b(this.g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = 3;
            crashDetailBean.e = this.c.g();
            aa aaVar = this.c;
            crashDetailBean.f = aaVar.o;
            crashDetailBean.g = aaVar.q();
            crashDetailBean.m = this.c.f();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = axVar.f;
            crashDetailBean.q = axVar.g;
            HashMap hashMap = new HashMap();
            crashDetailBean.T = hashMap;
            hashMap.put("BUGLY_CR_01", axVar.e);
            String str = crashDetailBean.q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = axVar.c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.u = ap.c(str2.getBytes());
            }
            crashDetailBean.z = axVar.b;
            crashDetailBean.A = axVar.f26581a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.c.s();
            crashDetailBean.h = this.c.p();
            crashDetailBean.i = this.c.A();
            crashDetailBean.v = axVar.d;
            aa aaVar2 = this.c;
            crashDetailBean.P = aaVar2.u;
            crashDetailBean.Q = aaVar2.f26524a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = this.c.z();
            aa aaVar3 = this.c;
            crashDetailBean.V = aaVar3.x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.c.y();
            crashDetailBean.y = ao.a();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    private synchronized void d(boolean z) {
        if (this.l != z) {
            al.a("user change anr %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    private synchronized void c(boolean z) {
        if (z) {
            g();
        } else {
            h();
        }
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append("\n");
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append("\n");
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return am.a(str2, sb.toString(), sb.length() * 2);
        }
        al.e("not found trace dump for %s", str3);
        return false;
    }

    private static String a(List<ba> list, long j) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder(4096);
            sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
            sb.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
            for (int i = 0; i < list.size(); i++) {
                ba baVar = list.get(i);
                sb.append("Thread name:");
                sb.append(baVar.f26589a);
                sb.append("\n");
                long j2 = baVar.b - j;
                String str = j2 <= 0 ? "before " : "after ";
                sb.append("Got ");
                sb.append(str);
                sb.append("anr:");
                sb.append(Math.abs(j2));
                sb.append("ms\n");
                sb.append(baVar.c);
                sb.append("\n");
                if (sb.length() * 2 >= 101376) {
                    break;
                }
            }
            sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
            return sb.toString();
        }
        return "main thread stack not enable";
    }

    public final boolean a(boolean z) {
        boolean compareAndSet = this.f26582a.compareAndSet(!z, z);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ad A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01de A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:3:0x0008, B:4:0x0017, B:10:0x002d, B:12:0x004d, B:14:0x0053, B:18:0x0060, B:21:0x0070, B:23:0x0081, B:27:0x008c, B:29:0x00a9, B:30:0x00ad, B:33:0x00c9, B:35:0x00fd, B:38:0x010a, B:40:0x0134, B:41:0x0163, B:42:0x0165, B:49:0x0177, B:50:0x0189, B:51:0x019a, B:53:0x01ad, B:54:0x01bc, B:56:0x01de, B:57:0x01e3, B:58:0x01ea, B:70:0x0204, B:71:0x01b5, B:77:0x0191, B:78:0x014c, B:79:0x0192, B:80:0x00c5, B:82:0x0079, B:87:0x0206, B:44:0x0166, B:46:0x016a, B:47:0x0174, B:6:0x0018, B:8:0x001c, B:9:0x002c, B:60:0x01eb, B:62:0x01ef, B:63:0x01fe), top: B:2:0x0008, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r23, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ay.a(long, java.lang.String):void");
    }

    public final boolean a(long j) {
        if (Math.abs(j - this.o) < 10000) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.o = j;
        return false;
    }

    public static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (at.j + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }
}
