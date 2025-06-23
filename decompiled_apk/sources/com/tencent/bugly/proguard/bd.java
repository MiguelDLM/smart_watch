package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class bd implements NativeExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Context f26592a;
    private final as b;
    private final aa c;
    private final ac d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f26592a = context;
        this.b = asVar;
        this.c = aaVar;
        this.d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        int length;
        if (strArr == null) {
            length = 1;
        } else {
            length = strArr.length;
        }
        HashMap hashMap = new HashMap(length);
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a2 = ay.a();
        if (a2.f26582a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a2.b;
        if (!z.a(activityManager) && az.a(activityManager, 0L) != null) {
            if (a2.a(System.currentTimeMillis())) {
                return false;
            }
            return a2.a(true);
        }
        al.c("proc is not in anr, wait next check", new Object[0]);
        return false;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:77:0x0017, B:4:0x003b, B:6:0x004d, B:8:0x0056, B:9:0x0062, B:11:0x006e, B:14:0x0075, B:16:0x0084, B:18:0x00a2, B:19:0x00d5, B:21:0x00f8, B:22:0x00ff, B:25:0x010b, B:27:0x0113, B:35:0x015b, B:36:0x015f, B:38:0x0169, B:73:0x00c0, B:74:0x0081), top: B:76:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f8 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:77:0x0017, B:4:0x003b, B:6:0x004d, B:8:0x0056, B:9:0x0062, B:11:0x006e, B:14:0x0075, B:16:0x0084, B:18:0x00a2, B:19:0x00d5, B:21:0x00f8, B:22:0x00ff, B:25:0x010b, B:27:0x0113, B:35:0x015b, B:36:0x015f, B:38:0x0169, B:73:0x00c0, B:74:0x0081), top: B:76:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ac A[Catch: all -> 0x01b5, TryCatch #1 {all -> 0x01b5, blocks: (B:42:0x01a6, B:44:0x01ac, B:46:0x01ba), top: B:41:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ba A[Catch: all -> 0x01b5, TRY_LEAVE, TryCatch #1 {all -> 0x01b5, blocks: (B:42:0x01a6, B:44:0x01ac, B:46:0x01ba), top: B:41:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c0 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:77:0x0017, B:4:0x003b, B:6:0x004d, B:8:0x0056, B:9:0x0062, B:11:0x006e, B:14:0x0075, B:16:0x0084, B:18:0x00a2, B:19:0x00d5, B:21:0x00f8, B:22:0x00ff, B:25:0x010b, B:27:0x0113, B:35:0x015b, B:36:0x015f, B:38:0x0169, B:73:0x00c0, B:74:0x0081), top: B:76:0x0017 }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean i2 = at.a().i();
        if (i2) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.g();
        aa aaVar = this.c;
        crashDetailBean.f = aaVar.o;
        crashDetailBean.g = aaVar.q();
        crashDetailBean.m = this.c.f();
        crashDetailBean.n = str3;
        crashDetailBean.o = i2 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.r = j;
        crashDetailBean.u = ap.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.c.s();
        crashDetailBean.h = this.c.p();
        crashDetailBean.i = this.c.A();
        crashDetailBean.v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a2 = be.a(dumpFilePath, str8);
        if (!ap.b(a2)) {
            crashDetailBean.Z = a2;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.w = be.a(str9, at.f, at.k, at.p);
        crashDetailBean.x = be.a(str10, at.f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        crashDetailBean.I = ab.b(this.f26592a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.y = ao.a();
            aa aaVar2 = this.c;
            crashDetailBean.Q = aaVar2.f26524a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.z = ap.a(this.c.Q, at.h);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str14 = crashDetailBean.q;
                String substring = str14.substring(i, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.c.d;
            }
            crashDetailBean.U = this.c.z();
            aa aaVar3 = this.c;
            crashDetailBean.V = aaVar3.x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.c.y();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
