package com.baidu.navisdk.apm.cpu;

import android.os.Process;
import com.baidu.navisdk.util.common.g;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6536a;

    /* renamed from: com.baidu.navisdk.apm.cpu.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0166a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    static {
        new C0166a();
        f6536a = null;
    }

    public static List<com.baidu.navisdk.module.cpu.a> a() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc/" + b() + "/task").listFiles();
        for (int i = 0; listFiles != null && i < listFiles.length; i++) {
            com.baidu.navisdk.module.cpu.a a2 = a(listFiles[i].getAbsolutePath() + "/stat");
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        g gVar = g.APM;
        if (gVar.d()) {
            gVar.e("BNDeviceTools", "getAllThreadJiffies() cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    private static int b() {
        return Process.myPid();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long c() {
        /*
            java.lang.String r0 = "BNDeviceTools"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = com.baidu.navisdk.apm.cpu.a.f6536a
            if (r3 != 0) goto L10
            java.lang.String r3 = d()
            com.baidu.navisdk.apm.cpu.a.f6536a = r3
        L10:
            r3 = 0
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r5 = com.baidu.navisdk.apm.cpu.a.f6536a     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r6 = "r"
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.String r5 = "\\s+"
            java.lang.String[] r5 = r3.split(r5)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r6 = 13
            r6 = r5[r6]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r8 = 14
            r8 = r5[r8]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r8 = java.lang.Long.parseLong(r8)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r6 = r6 + r8
            r8 = 15
            r8 = r5[r8]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r8 = java.lang.Long.parseLong(r8)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r6 = r6 + r8
            r8 = 16
            r5 = r5[r8]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r8 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r6 = r6 + r8
            com.baidu.navisdk.util.common.g r5 = com.baidu.navisdk.util.common.g.APM     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            boolean r8 = r5.d()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            if (r8 == 0) goto L6e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r8.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.String r9 = "getAppJiffies() cost = "
            r8.append(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            long r9 = r9 - r1
            r8.append(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.String r1 = r8.toString()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.e(r0, r1)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            goto L6e
        L69:
            r0 = move-exception
            r3 = r4
            goto La7
        L6c:
            r1 = move-exception
            goto L7b
        L6e:
            r4.close()     // Catch: java.lang.Exception -> L72
            goto L76
        L72:
            r0 = move-exception
            r0.printStackTrace()
        L76:
            return r6
        L77:
            r0 = move-exception
            goto La7
        L79:
            r1 = move-exception
            r4 = r3
        L7b:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L69
            com.baidu.navisdk.util.common.g r1 = com.baidu.navisdk.util.common.g.APM     // Catch: java.lang.Throwable -> L69
            boolean r2 = r1.d()     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L9a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r2.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r5 = "RandomAccessFile(App Stat) reader fail, error: "
            r2.append(r5)     // Catch: java.lang.Throwable -> L69
            r2.append(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L69
            r1.e(r0, r2)     // Catch: java.lang.Throwable -> L69
        L9a:
            if (r4 == 0) goto La4
            r4.close()     // Catch: java.lang.Exception -> La0
            goto La4
        La0:
            r0 = move-exception
            r0.printStackTrace()
        La4:
            r0 = -1
            return r0
        La7:
            if (r3 == 0) goto Lb1
            r3.close()     // Catch: java.lang.Exception -> Lad
            goto Lb1
        Lad:
            r1 = move-exception
            r1.printStackTrace()
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.apm.cpu.a.c():long");
    }

    private static String d() {
        return "/proc/" + b() + "/stat";
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:56:0x003e */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073 A[Catch: all -> 0x003d, Exception -> 0x0041, TryCatch #4 {all -> 0x003d, blocks: (B:5:0x0008, B:10:0x0020, B:12:0x002c, B:14:0x0038, B:15:0x0045, B:17:0x0073, B:20:0x008a, B:28:0x0087, B:29:0x0097, B:32:0x00a4, B:39:0x00a2, B:43:0x00b4, B:46:0x00c1), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097 A[Catch: all -> 0x003d, Exception -> 0x0041, TRY_ENTER, TryCatch #4 {all -> 0x003d, blocks: (B:5:0x0008, B:10:0x0020, B:12:0x002c, B:14:0x0038, B:15:0x0045, B:17:0x0073, B:20:0x008a, B:28:0x0087, B:29:0x0097, B:32:0x00a4, B:39:0x00a2, B:43:0x00b4, B:46:0x00c1), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.baidu.navisdk.module.cpu.a a(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.apm.cpu.a.a(java.lang.String):com.baidu.navisdk.module.cpu.a");
    }
}
