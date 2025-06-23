package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sma.smartv3.ble.ProductManager;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public final class r {
    private static boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private Context f26617a;
    private long b;
    private int c;
    private boolean d;

    /* loaded from: classes13.dex */
    public class I0Io implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public UserInfoBean f26619Oo;

        /* renamed from: XO, reason: collision with root package name */
        public boolean f26620XO;

        public I0Io(UserInfoBean userInfoBean, boolean z) {
            this.f26619Oo = userInfoBean;
            this.f26620XO = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!r.this.d) {
                return;
            }
            try {
                UserInfoBean userInfoBean = this.f26619Oo;
                if (userInfoBean != null) {
                    r.a(userInfoBean);
                    al.c("[UserInfo] Record user info.", new Object[0]);
                    r.this.a(this.f26619Oo, false);
                }
                if (this.f26620XO) {
                    r.this.b();
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ boolean f26622XO = false;

        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                r.this.a(this.f26622XO);
            } catch (Throwable th) {
                al.a(th);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public long f26624XO;

        public X0o0xo(long j) {
            this.f26624XO = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.b();
            r.this.a(this.f26624XO);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements ah {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ List f26626oIX0oI;

        public oIX0oI(List list) {
            this.f26626oIX0oI = list;
        }

        @Override // com.tencent.bugly.proguard.ah
        public final void a(boolean z, String str) {
            if (z) {
                al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                for (UserInfoBean userInfoBean : this.f26626oIX0oI) {
                    userInfoBean.f = currentTimeMillis;
                    r.this.a(userInfoBean, true);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.b) {
                ak.a().a(new oxoX(), (r.this.b - currentTimeMillis) + 5000);
            } else {
                r.this.a(3, false);
                r.this.a();
            }
        }
    }

    public r(Context context, boolean z) {
        this.f26617a = context;
        this.d = z;
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f != -1) {
                it.remove();
                if (next.e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void a(int i, boolean z) {
        ac a2 = ac.a();
        if (a2 != null && !a2.c().g && i != 1 && i != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.c++;
        }
        aa a3 = aa.a(this.f26617a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i;
        userInfoBean.c = a3.d;
        userInfoBean.d = a3.f();
        userInfoBean.e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = a3.o;
        userInfoBean.o = i == 1 ? 1 : 0;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.y;
        userInfoBean.g = a3.z;
        userInfoBean.h = a3.A;
        userInfoBean.i = a3.B;
        userInfoBean.k = a3.C;
        userInfoBean.r = a3.t();
        userInfoBean.s = a3.y();
        userInfoBean.p = a3.z();
        userInfoBean.q = a3.x;
        ak.a().a(new I0Io(userInfoBean, z), 0L);
    }

    public final void b() {
        ak a2 = ak.a();
        if (a2 != null) {
            a2.a(new II0xO0());
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            UserInfoBean userInfoBean = list.get(i);
            sb.append(" or _id = ");
            sb.append(userInfoBean.f26510a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = userInfoBean.f26510a;
            if (j > 0) {
                contentValues.put("_id", Long.valueOf(j));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(long j) {
        ak.a().a(new X0o0xo(j), j);
    }

    public final void a() {
        this.b = ap.b() + 86400000;
        ak.a().a(new oxoX(), (this.b - System.currentTimeMillis()) + 5000);
    }

    private boolean b(boolean z) {
        boolean z2 = true;
        if (!e) {
            return true;
        }
        File file = new File(this.f26617a.getFilesDir(), "bugly_last_us_up_tm");
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            return true;
        }
        if (!file.exists()) {
            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
        } else {
            BufferedReader a2 = ap.a(file);
            try {
                if (a2 != null) {
                    try {
                        long longValue = Long.valueOf(a2.readLine().trim()).longValue();
                        if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000 && currentTimeMillis - longValue < 300000) {
                            z2 = false;
                        }
                        am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    } catch (Throwable th) {
                        try {
                            al.b(th);
                            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            a2.close();
                        } catch (Throwable th2) {
                            try {
                                a2.close();
                            } catch (Exception e2) {
                                al.a(e2);
                            }
                            throw th2;
                        }
                    }
                }
                if (a2 != null) {
                    a2.close();
                }
            } catch (Exception e3) {
                al.a(e3);
            }
        }
        return z2;
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < list.size(); i3++) {
                    if (list.get(i).e > list.get(i3).e) {
                        UserInfoBean userInfoBean = list.get(i);
                        list.set(i, list.get(i3));
                        list.set(i3, userInfoBean);
                    }
                }
                i = i2;
            }
            for (int i4 = 0; i4 < size; i4++) {
                list2.add(list.get(i4));
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.e > currentTimeMillis - 600000 && ((i = userInfoBean.b) == 1 || i == 4 || i == 3)) {
                i2++;
            }
        }
        return i2;
    }

    private void a(List<UserInfoBean> list, boolean z) {
        aa b;
        if (!b(z)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f = currentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i = this.c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (b = aa.b()) != null) {
            b.o();
            bv bvVar2 = new bv();
            bvVar2.b = b.d;
            bvVar2.c = b.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                bu a2 = ae.a(it.next());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            bvVar2.d = arrayList;
            HashMap hashMap = new HashMap();
            bvVar2.e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            bvVar2.e.put(ProductManager.xXIO, aa.n());
            bvVar2.e.put("A5", b.m());
            Map<String, String> map = bvVar2.e;
            StringBuilder sb = new StringBuilder();
            sb.append(b.k());
            map.put("A2", sb.toString());
            Map<String, String> map2 = bvVar2.e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.k());
            map2.put("A1", sb2.toString());
            bvVar2.e.put("A24", b.k);
            Map<String, String> map3 = bvVar2.e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b.l());
            map3.put("A17", sb3.toString());
            bvVar2.e.put("A15", b.q());
            Map<String, String> map4 = bvVar2.e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b.r());
            map4.put("A13", sb4.toString());
            bvVar2.e.put("F08", b.E);
            bvVar2.e.put("F09", b.F);
            Map<String, String> y = b.y();
            if (y != null && y.size() > 0) {
                for (Map.Entry<String, String> entry : y.entrySet()) {
                    bvVar2.e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i == 1) {
                bvVar2.f26607a = (byte) 1;
            } else if (i != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i));
            } else {
                bvVar2.f26607a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a3 = ae.a((m) bvVar);
        if (a3 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a4 = ae.a(this.f26617a, 840, a3);
        if (a4 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ai.a().a(1001, a4, ac.a().c().q, StrategyBean.f26512a, new oIX0oI(list), this.c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.b != 1 && (a2 = a(aa.a(this.f26617a).d)) != null && a2.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
            return;
        }
        long a3 = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (a3 >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
            userInfoBean.f26510a = a3;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = w.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            long j = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb.append(" or _id = ");
                            sb.append(j);
                        } catch (Throwable unused) {
                            al.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2.substring(4))));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f26510a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[Catch: all -> 0x0026, TryCatch #0 {, blocks: (B:4:0x0003, B:10:0x0008, B:13:0x000f, B:16:0x0016, B:18:0x001c, B:20:0x0028, B:22:0x003b, B:24:0x0049, B:25:0x005e, B:27:0x0064, B:29:0x0069, B:32:0x0070, B:35:0x0086, B:39:0x0058), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(boolean r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            monitor-enter(r7)
            boolean r2 = r7.d     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L8
            goto L24
        L8:
            com.tencent.bugly.proguard.ai r2 = com.tencent.bugly.proguard.ai.a()     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto Lf
            goto L24
        Lf:
            com.tencent.bugly.proguard.ac r3 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L16
            goto L24
        L16:
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L28
            r3 = 1001(0x3e9, float:1.403E-42)
            boolean r2 = r2.b(r3)     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L28
        L24:
            monitor-exit(r7)
            return
        L26:
            r8 = move-exception
            goto L8f
        L28:
            android.content.Context r2 = r7.f26617a     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.aa r2 = com.tencent.bugly.proguard.aa.a(r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = r2.d     // Catch: java.lang.Throwable -> L26
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L26
            r3.<init>()     // Catch: java.lang.Throwable -> L26
            java.util.List r2 = a(r2)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L58
            a(r2, r3)     // Catch: java.lang.Throwable -> L26
            b(r2, r3)     // Catch: java.lang.Throwable -> L26
            int r4 = a(r2)     // Catch: java.lang.Throwable -> L26
            r5 = 15
            if (r4 <= r5) goto L5d
            java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L26
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r6[r1] = r4     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch: java.lang.Throwable -> L26
            r4 = 0
            goto L5e
        L58:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L26
            r2.<init>()     // Catch: java.lang.Throwable -> L26
        L5d:
            r4 = 1
        L5e:
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L26
            if (r5 <= 0) goto L67
            b(r3)     // Catch: java.lang.Throwable -> L26
        L67:
            if (r4 == 0) goto L86
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L70
            goto L86
        L70:
            java.lang.String r3 = "[UserInfo] Upload user info(size: %d)"
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L26
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L26
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r0[r1] = r4     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.c(r3, r0)     // Catch: java.lang.Throwable -> L26
            r7.a(r2, r8)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r7)
            return
        L86:
            java.lang.String r8 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.c(r8, r0)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r7)
            return
        L8f:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L26
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(boolean):void");
    }

    public static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b;
        if (userInfoBean == null || (b = aa.b()) == null) {
            return;
        }
        userInfoBean.j = b.d();
    }
}
