package com.baidu.location.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class r {
    private static r d;
    private static Object c = new Object();
    private static final String e = com.baidu.location.e.o.g() + "/hst.db";
    private SQLiteDatabase f = null;
    private boolean g = false;

    /* renamed from: a, reason: collision with root package name */
    a f5657a = null;
    a b = null;
    private String h = null;
    private int i = -2;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.location.e.g {
        private String b = null;
        private String c = null;
        private boolean d = true;
        private boolean e = false;

        public a() {
            this.dB = new HashMap();
        }

        @Override // com.baidu.location.e.g
        public void a() {
            this.dz = 1;
            String q = com.baidu.location.c.h.a().q();
            if (q != null) {
                this.dH = Jni.encodeTp4(q);
            }
            String encodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.dB.put("bloc", encodeTp4);
        }

        public void a(String str, String str2) {
            if (r.this.g) {
                return;
            }
            r.this.g = true;
            this.b = str;
            if (t.a().b()) {
                this.c = str2 + "&enc=2";
            } else {
                this.c = str2;
            }
            ExecutorService c = aj.a().c();
            if (c != null) {
                a(c, com.baidu.location.e.e.c);
            } else {
                b(com.baidu.location.e.e.c);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
        
            r11 = r10.dA;
         */
        @Override // com.baidu.location.e.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r11) {
            /*
                r10 = this;
                java.lang.String r0 = "hstdata"
                java.lang.String r1 = "mac"
                java.lang.String r2 = "content"
                java.lang.String r3 = "imo"
                java.lang.String r4 = "enc"
                if (r11 == 0) goto Lef
                java.lang.String r11 = r10.dA
                if (r11 == 0) goto Lef
                boolean r5 = r11.contains(r4)     // Catch: java.lang.Exception -> L3d
                if (r5 == 0) goto L40
                com.baidu.location.b.t r5 = com.baidu.location.b.t.a()     // Catch: java.lang.Exception -> L3d
                boolean r5 = r5.b()     // Catch: java.lang.Exception -> L3d
                if (r5 == 0) goto L40
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L38
                r5.<init>(r11)     // Catch: java.lang.Exception -> L38
                boolean r6 = r5.has(r4)     // Catch: java.lang.Exception -> L38
                if (r6 == 0) goto L40
                java.lang.String r4 = r5.getString(r4)     // Catch: java.lang.Exception -> L38
                com.baidu.location.b.t r5 = com.baidu.location.b.t.a()     // Catch: java.lang.Exception -> L38
                java.lang.String r11 = r5.b(r4)     // Catch: java.lang.Exception -> L38
                goto L40
            L38:
                r4 = move-exception
                r4.printStackTrace()     // Catch: java.lang.Exception -> L3d
                goto L40
            L3d:
                goto Lf8
            L40:
                boolean r4 = r10.d     // Catch: java.lang.Exception -> L3d
                if (r4 == 0) goto Lf8
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3d
                r4.<init>(r11)     // Catch: java.lang.Exception -> L3d
                boolean r11 = r4.has(r2)     // Catch: java.lang.Exception -> L3d
                r5 = 0
                if (r11 == 0) goto L55
                org.json.JSONObject r11 = r4.getJSONObject(r2)     // Catch: java.lang.Exception -> L3d
                goto L56
            L55:
                r11 = r5
            L56:
                if (r11 == 0) goto Lf8
                boolean r2 = r11.has(r3)     // Catch: java.lang.Exception -> L3d
                if (r2 == 0) goto Lf8
                org.json.JSONObject r2 = r11.getJSONObject(r3)     // Catch: java.lang.Exception -> L3d
                java.lang.String r2 = r2.getString(r1)     // Catch: java.lang.Exception -> L3d
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L3d
                org.json.JSONObject r11 = r11.getJSONObject(r3)     // Catch: java.lang.Exception -> L3d
                java.lang.String r3 = "mv"
                int r11 = r11.getInt(r3)     // Catch: java.lang.Exception -> L3d
                java.lang.String r3 = r10.b     // Catch: java.lang.Exception -> L3d
                java.lang.Long r3 = com.baidu.location.Jni.encode3(r3)     // Catch: java.lang.Exception -> L3d
                long r3 = r3.longValue()     // Catch: java.lang.Exception -> L3d
                long r6 = r2.longValue()     // Catch: java.lang.Exception -> L3d
                int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r8 != 0) goto Lf8
                android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Exception -> L3d
                r3.<init>()     // Catch: java.lang.Exception -> L3d
                java.lang.String r4 = "tt"
                long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L3d
                r8 = 1000(0x3e8, double:4.94E-321)
                long r6 = r6 / r8
                int r7 = (int) r6     // Catch: java.lang.Exception -> L3d
                java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L3d
                r3.put(r4, r6)     // Catch: java.lang.Exception -> L3d
                java.lang.String r4 = "hst"
                java.lang.Integer r6 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Exception -> L3d
                r3.put(r4, r6)     // Catch: java.lang.Exception -> L3d
                com.baidu.location.b.r r4 = com.baidu.location.b.r.this     // Catch: java.lang.Exception -> Ld6
                android.database.sqlite.SQLiteDatabase r4 = com.baidu.location.b.r.a(r4)     // Catch: java.lang.Exception -> Ld6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld6
                r6.<init>()     // Catch: java.lang.Exception -> Ld6
                java.lang.String r7 = "id = \""
                r6.append(r7)     // Catch: java.lang.Exception -> Ld6
                r6.append(r2)     // Catch: java.lang.Exception -> Ld6
                java.lang.String r7 = "\""
                r6.append(r7)     // Catch: java.lang.Exception -> Ld6
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> Ld6
                int r4 = r4.update(r0, r3, r6, r5)     // Catch: java.lang.Exception -> Ld6
                if (r4 > 0) goto Ld6
                java.lang.String r4 = "id"
                r3.put(r4, r2)     // Catch: java.lang.Exception -> Ld6
                com.baidu.location.b.r r2 = com.baidu.location.b.r.this     // Catch: java.lang.Exception -> Ld6
                android.database.sqlite.SQLiteDatabase r2 = com.baidu.location.b.r.a(r2)     // Catch: java.lang.Exception -> Ld6
                r2.insert(r0, r5, r3)     // Catch: java.lang.Exception -> Ld6
            Ld6:
                android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Exception -> L3d
                r0.<init>()     // Catch: java.lang.Exception -> L3d
                java.lang.String r2 = r10.b     // Catch: java.lang.Exception -> L3d
                byte[] r2 = r2.getBytes()     // Catch: java.lang.Exception -> L3d
                r0.putByteArray(r1, r2)     // Catch: java.lang.Exception -> L3d
                java.lang.String r1 = "hotspot"
                r0.putInt(r1, r11)     // Catch: java.lang.Exception -> L3d
                com.baidu.location.b.r r11 = com.baidu.location.b.r.this     // Catch: java.lang.Exception -> L3d
                com.baidu.location.b.r.a(r11, r0)     // Catch: java.lang.Exception -> L3d
                goto Lf8
            Lef:
                boolean r11 = r10.d
                if (r11 == 0) goto Lf8
                com.baidu.location.b.r r11 = com.baidu.location.b.r.this
                com.baidu.location.b.r.b(r11)
            Lf8:
                java.util.Map<java.lang.String, java.lang.Object> r11 = r10.dB
                if (r11 == 0) goto Lff
                r11.clear()
            Lff:
                com.baidu.location.b.r r11 = com.baidu.location.b.r.this
                r0 = 0
                com.baidu.location.b.r.a(r11, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.r.a.a(boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void b() {
        try {
            File file = new File(e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f = openOrCreateDatabase;
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f = null;
                throw th;
            }
            this.f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (r3 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
    
        if (r3 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int d() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.g     // Catch: java.lang.Throwable -> L48
            r1 = -3
            if (r0 == 0) goto L8
            monitor-exit(r7)
            return r1
        L8:
            com.baidu.location.c.h r0 = com.baidu.location.c.h.a()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            if (r0 == 0) goto L80
            android.database.sqlite.SQLiteDatabase r0 = r7.f     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            if (r0 == 0) goto L80
            com.baidu.location.c.h r0 = com.baidu.location.c.h.a()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            android.net.wifi.WifiInfo r0 = r0.p()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            com.baidu.location.c.h r2 = com.baidu.location.c.h.a()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            r3 = 0
            java.lang.String r2 = r2.a(r0, r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            if (r0 == 0) goto L80
            if (r2 == 0) goto L80
            java.lang.String r0 = ":"
            java.lang.String r4 = ""
            java.lang.String r0 = r2.replace(r0, r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            java.lang.Long r2 = com.baidu.location.Jni.encode3(r0)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            java.lang.String r4 = r7.h     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            r5 = -2
            if (r4 == 0) goto L4a
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            if (r4 == 0) goto L4a
            int r4 = r7.i     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            if (r4 <= r5) goto L4a
            r1 = r4
            goto L80
        L48:
            r0 = move-exception
            goto L84
        L4a:
            android.database.sqlite.SQLiteDatabase r4 = r7.f     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            java.lang.String r6 = "select * from hstdata where id = ?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            android.database.Cursor r3 = r4.rawQuery(r6, r2)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            if (r3 == 0) goto L70
            boolean r2 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            if (r2 == 0) goto L70
            r2 = 1
            int r1 = r3.getInt(r2)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r7.h = r0     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r7.i = r1     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            goto L71
        L6c:
            r0 = move-exception
            goto L77
        L6e:
            goto L7d
        L70:
            r1 = -2
        L71:
            if (r3 == 0) goto L80
        L73:
            r3.close()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
            goto L80
        L77:
            if (r3 == 0) goto L7c
            r3.close()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L7c
        L7c:
            throw r0     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L80
        L7d:
            if (r3 == 0) goto L80
            goto L73
        L80:
            r7.i = r1     // Catch: java.lang.Throwable -> L48
            monitor-exit(r7)
            return r1
        L84:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L48
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.r.d():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
    
        if (r3 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() {
        /*
            r10 = this;
            boolean r0 = r10.g
            if (r0 == 0) goto L5
            return
        L5:
            com.baidu.location.c.h r0 = com.baidu.location.c.h.a()     // Catch: java.lang.Exception -> Lb1
            boolean r0 = r0.l()     // Catch: java.lang.Exception -> Lb1
            if (r0 == 0) goto Lae
            android.database.sqlite.SQLiteDatabase r0 = r10.f     // Catch: java.lang.Exception -> Lb1
            if (r0 == 0) goto Lae
            com.baidu.location.c.h r0 = com.baidu.location.c.h.a()     // Catch: java.lang.Exception -> Lb1
            android.net.wifi.WifiInfo r0 = r0.p()     // Catch: java.lang.Exception -> Lb1
            if (r0 == 0) goto Lae
            java.lang.String r1 = r0.getBSSID()     // Catch: java.lang.Exception -> Lb1
            if (r1 == 0) goto Lae
            java.lang.String r0 = r0.getBSSID()     // Catch: java.lang.Exception -> Lb1
            java.lang.String r1 = ":"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Exception -> Lb1
            java.lang.Long r1 = com.baidu.location.Jni.encode3(r0)     // Catch: java.lang.Exception -> Lb1
            r2 = 1
            r3 = 0
            r4 = 0
            android.database.sqlite.SQLiteDatabase r5 = r10.f     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r6 = "select * from hstdata where id = ?"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.database.Cursor r3 = r5.rawQuery(r6, r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r3 == 0) goto L83
            boolean r1 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r1 == 0) goto L83
            int r1 = r3.getInt(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r5 = 2
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            long r8 = (long) r5     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            long r6 = r6 - r8
            r8 = 259200(0x3f480, double:1.28062E-318)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 <= 0) goto L68
            goto L83
        L68:
            android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r5.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r6 = "mac"
            byte[] r7 = r0.getBytes()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r5.putByteArray(r6, r7)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r6 = "hotspot"
            r5.putInt(r6, r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r10.a(r5)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            goto L84
        L7f:
            r0 = move-exception
            goto L8c
        L81:
            goto L92
        L83:
            r4 = 1
        L84:
            if (r3 == 0) goto L95
        L86:
            r3.close()     // Catch: java.lang.Exception -> L8a
            goto L95
        L8a:
            goto L95
        L8c:
            if (r3 == 0) goto L91
            r3.close()     // Catch: java.lang.Exception -> L91
        L91:
            throw r0     // Catch: java.lang.Exception -> Lb1
        L92:
            if (r3 == 0) goto L95
            goto L86
        L95:
            if (r4 == 0) goto Lb1
            com.baidu.location.b.r$a r1 = r10.f5657a     // Catch: java.lang.Exception -> Lb1
            if (r1 != 0) goto La2
            com.baidu.location.b.r$a r1 = new com.baidu.location.b.r$a     // Catch: java.lang.Exception -> Lb1
            r1.<init>()     // Catch: java.lang.Exception -> Lb1
            r10.f5657a = r1     // Catch: java.lang.Exception -> Lb1
        La2:
            com.baidu.location.b.r$a r1 = r10.f5657a     // Catch: java.lang.Exception -> Lb1
            if (r1 == 0) goto Lb1
            java.lang.String r2 = r10.a(r2)     // Catch: java.lang.Exception -> Lb1
            r1.a(r0, r2)     // Catch: java.lang.Exception -> Lb1
            goto Lb1
        Lae:
            r10.f()     // Catch: java.lang.Exception -> Lb1
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.r.e():void");
    }

    public static r a() {
        r rVar;
        synchronized (c) {
            try {
                if (d == null) {
                    d = new r();
                }
                rVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v3 java.lang.String, still in use, count: 2, list:
          (r1v3 java.lang.String) from 0x004c: IF  (r1v3 java.lang.String) != (null java.lang.String)  -> B:11:0x0040 A[HIDDEN]
          (r1v3 java.lang.String) from 0x0040: PHI (r1v10 java.lang.String) = (r1v3 java.lang.String), (r1v11 java.lang.String) binds: [B:31:0x004c, B:10:0x0034] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    private java.lang.String a(boolean r8) {
        /*
            r7 = this;
            com.baidu.location.c.h r0 = com.baidu.location.c.h.a()
            com.baidu.location.c.a r0 = r0.f()
            com.baidu.location.c.h r1 = com.baidu.location.c.h.a()
            com.baidu.location.c.p r1 = r1.r()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)
            if (r0 == 0) goto L2a
            boolean r3 = r0.b()
            if (r3 == 0) goto L2a
            com.baidu.location.c.h r3 = com.baidu.location.c.h.a()
            java.lang.String r0 = r3.b(r0)
            r2.append(r0)
        L2a:
            r0 = 1
            r3 = 0
            if (r1 == 0) goto L44
            int r4 = r1.a()
            if (r4 <= r0) goto L44
            com.baidu.location.c.h r4 = com.baidu.location.c.h.a()
            r5 = 15
            int r6 = com.baidu.location.e.o.ay
            java.lang.String r1 = r4.a(r5, r3, r1, r6)
        L40:
            r2.append(r1)
            goto L4f
        L44:
            com.baidu.location.c.h r1 = com.baidu.location.c.h.a()
            java.lang.String r1 = r1.o()
            if (r1 == 0) goto L4f
            goto L40
        L4f:
            if (r8 == 0) goto L56
            java.lang.String r8 = "&imo=1"
            r2.append(r8)
        L56:
            com.baidu.location.c.e r8 = com.baidu.location.c.e.a()
            java.lang.String r8 = r8.m()
            r2.append(r8)
            com.baidu.location.e.b r8 = com.baidu.location.e.b.a()
            java.lang.String r8 = r8.a(r3)
            r2.append(r8)
            com.baidu.location.b.c r8 = com.baidu.location.b.c.a()
            java.lang.String r8 = r8.c()
            r2.append(r8)
            com.baidu.location.b.h r8 = com.baidu.location.b.h.a()
            java.lang.String r8 = r8.c()
            r2.append(r8)
            android.content.Context r8 = com.baidu.location.f.getServiceContext()
            java.lang.String r8 = com.baidu.location.e.o.d(r8)
            r2.append(r8)
            android.content.Context r8 = com.baidu.location.f.getServiceContext()
            int r8 = com.baidu.location.e.o.b(r8)
            if (r8 < 0) goto L9f
            java.lang.String r1 = "&lmd="
            r2.append(r1)
            r2.append(r8)
        L9f:
            java.lang.String r8 = r2.toString()
            int r1 = r8.length()
            int r2 = com.baidu.location.e.o.aN
            if (r1 <= r2) goto Lec
            java.lang.String r1 = "&cl_list="
            java.lang.String[] r1 = r8.split(r1)
            int r2 = r1.length
            r4 = 2
            if (r2 != r4) goto Lec
            r8 = r1[r0]
            java.lang.String r2 = "&"
            java.lang.String[] r8 = r8.split(r2, r4)
            int r2 = r8.length
            if (r2 != r4) goto Ld9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r1 = r1[r3]
            r2.append(r1)
            java.lang.String r1 = "&cl_list=null&"
            r2.append(r1)
            r8 = r8[r0]
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            goto Lec
        Ld9:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r0 = r1[r3]
            r8.append(r0)
            java.lang.String r0 = "&cl_list=null"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
        Lec:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.r.a(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        c.a().a(bundle, 406);
    }

    public void a(String str) {
        if (this.g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put(TtmlNode.TAG_TT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i));
            if (this.f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }
}
