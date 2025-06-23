package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.o;

/* loaded from: classes13.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;
    private static int c;
    private static CrashModule e = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f26507a;
    private BuglyStrategy.a b;
    private boolean d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        try {
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                aa.a(context).t = libBuglySOFilePath;
                al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.b = buglyStrategy.getCrashHandleCallback();
                al.a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f26507a = appReportDelay;
                al.a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0069, B:17:0x007b, B:19:0x0082, B:22:0x0089, B:24:0x0099, B:27:0x00a0, B:29:0x00b0, B:31:0x00b8, B:32:0x00bf, B:37:0x00ab, B:38:0x0094, B:39:0x005e, B:40:0x0064), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8 A[Catch: all -> 0x005b, TryCatch #0 {all -> 0x005b, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0069, B:17:0x007b, B:19:0x0082, B:22:0x0089, B:24:0x0099, B:27:0x00a0, B:29:0x00b0, B:31:0x00b8, B:32:0x00bf, B:37:0x00ab, B:38:0x0094, B:39:0x005e, B:40:0x0064), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    @Override // com.tencent.bugly.proguard.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.BuglyStrategy r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto Le6
            boolean r0 = r4.d     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L9
            goto Le6
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.u r0 = com.tencent.bugly.proguard.u.a()     // Catch: java.lang.Throwable -> L5b
            int r2 = com.tencent.bugly.CrashModule.c     // Catch: java.lang.Throwable -> L5b
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.c = r2     // Catch: java.lang.Throwable -> L5b
            r0.a(r2)     // Catch: java.lang.Throwable -> L5b
            r4.d = r3     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.crashreport.CrashReport.setContext(r5)     // Catch: java.lang.Throwable -> L5b
            r4.a(r5, r7)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.BuglyStrategy$a r0 = r4.b     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.at r6 = com.tencent.bugly.proguard.at.a(r5, r6, r0)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.av r0 = r6.t     // Catch: java.lang.Throwable -> L5b
            r0.a()     // Catch: java.lang.Throwable -> L5b
            if (r7 == 0) goto L64
            int r0 = r7.getCallBackType()     // Catch: java.lang.Throwable -> L5b
            r6.B = r0     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r7.getCloseErrorCallback()     // Catch: java.lang.Throwable -> L5b
            r6.C = r0     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r7.isUploadSpotCrash()     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.at.o = r0     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a(r5)     // Catch: java.lang.Throwable -> L5b
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch: java.lang.Throwable -> L5b
            r0.S = r2     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L5e
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch: java.lang.Throwable -> L5b
            r0.disableCatchAnrTrace()     // Catch: java.lang.Throwable -> L5b
            goto L69
        L5b:
            r5 = move-exception
            goto Le4
        L5e:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch: java.lang.Throwable -> L5b
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> L5b
            goto L69
        L64:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch: java.lang.Throwable -> L5b
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> L5b
        L69:
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.b()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L5b
            android.content.Context r2 = r6.c     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = com.tencent.bugly.proguard.z.a(r2)     // Catch: java.lang.Throwable -> L5b
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L80
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.u     // Catch: java.lang.Throwable -> L5b
            r0.removeEmptyNativeRecordFiles()     // Catch: java.lang.Throwable -> L5b
        L80:
            if (r7 == 0) goto L94
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L89
            goto L94
        L89:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> L5b
            r6.d()     // Catch: java.lang.Throwable -> L5b
            goto L97
        L94:
            r6.e()     // Catch: java.lang.Throwable -> L5b
        L97:
            if (r7 == 0) goto Lab
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto La0
            goto Lab
        La0:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.al.a(r0, r1)     // Catch: java.lang.Throwable -> L5b
            r6.g()     // Catch: java.lang.Throwable -> L5b
            goto Lae
        Lab:
            r6.f()     // Catch: java.lang.Throwable -> L5b
        Lae:
            if (r7 == 0) goto Lb6
            boolean r0 = r7.isMerged()     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.at.e = r0     // Catch: java.lang.Throwable -> L5b
        Lb6:
            if (r7 == 0) goto Lbd
            long r0 = r7.getAppReportDelay()     // Catch: java.lang.Throwable -> L5b
            goto Lbf
        Lbd:
            r0 = 0
        Lbf:
            r6.a(r0)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r6 = r6.u     // Catch: java.lang.Throwable -> L5b
            r6.checkUploadRecordCrash()     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.au.a(r5)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.aq r6 = com.tencent.bugly.proguard.aq.a()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.a(r7)     // Catch: java.lang.Throwable -> L5b
            r6.a(r5)     // Catch: java.lang.Throwable -> L5b
            com.tencent.bugly.proguard.u r5 = com.tencent.bugly.proguard.u.a()     // Catch: java.lang.Throwable -> L5b
            int r6 = com.tencent.bugly.CrashModule.c     // Catch: java.lang.Throwable -> L5b
            int r6 = r6 - r3
            com.tencent.bugly.CrashModule.c = r6     // Catch: java.lang.Throwable -> L5b
            r5.a(r6)     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r4)
            return
        Le4:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L5b
            throw r5
        Le6:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a2;
        if (strategyBean != null && (a2 = at.a()) != null) {
            a2.t.a(strategyBean);
            a2.u.onStrategyChanged(strategyBean);
            a2.x.b();
        }
    }
}
