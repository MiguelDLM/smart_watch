package com.baidu.location.c.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.baidu.location.c.g;
import com.baidu.location.c.k;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class a implements com.baidu.location.c.b.a {
    public static int b;
    private static Class<?> v;
    private C0127a s;
    private b t;
    private c u;
    private Context w;
    private int e = 30;
    private int f = 100;
    private float g = 0.2f;
    private boolean h = true;
    private boolean i = false;
    private TelephonyManager j = null;
    private TelephonyManager k = null;
    private TelephonyManager l = null;
    private SubscriptionManager m = null;
    private com.baidu.location.c.a n = new com.baidu.location.c.a();
    private com.baidu.location.c.a o = null;
    private List<com.baidu.location.c.a> p = null;
    private Executor q = null;
    private d r = null;
    private boolean x = false;

    /* renamed from: a, reason: collision with root package name */
    public int f5680a = 0;
    private boolean y = false;
    private long z = 0;
    private long A = 0;
    private boolean B = false;
    private boolean C = true;
    private boolean D = false;
    private Handler E = null;
    private int F = -1;
    private int G = -1;
    private final Object H = new Object();

    /* renamed from: com.baidu.location.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0127a extends TelephonyManager.CellInfoCallback {
        private C0127a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (!com.baidu.location.c.b.a.d || k.h().a(list)) {
                a.this.i();
            }
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("cell onError = " + i);
            }
        }

        public /* synthetic */ C0127a(a aVar, com.baidu.location.c.a.b bVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends TelephonyManager.CellInfoCallback {
        private b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                k.h().a("onCellInfo");
            }
            if (list == null) {
                return;
            }
            boolean z2 = com.baidu.location.c.b.a.d;
            if (z2 && !k.h().a(list)) {
                return;
            }
            if (z && z2) {
                k.h().a("request sim1 cellInfo");
            }
            if (a.this.B) {
                a.this.C = !r4.C;
            }
            if (!a.this.B || a.this.C) {
                a.this.i();
            }
        }

        public /* synthetic */ b(a aVar, com.baidu.location.c.a.b bVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            boolean z = com.baidu.location.c.b.a.d;
            if (z && !k.h().a(list)) {
                return;
            }
            if (com.baidu.location.c.b.a.c && z) {
                k.h().a("request sim2 cellInfo");
            }
            if (a.this.B) {
                a.this.C = !r3.C;
            }
            if (!a.this.B || a.this.C) {
                a.this.i();
            }
        }

        public /* synthetic */ c(a aVar, com.baidu.location.c.a.b bVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            a.this.E.post(new com.baidu.location.c.a.c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (a.this.n != null) {
                if (a.this.n.i == 'g') {
                    a.this.n.h = signalStrength.getGsmSignalStrength();
                } else if (a.this.n.i == 'c') {
                    a.this.n.h = signalStrength.getCdmaDbm();
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    k.h().a("cell strength===== cell singal strength changed : " + a.this.n.h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static a f5685a = new a();
    }

    private static int d(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    private void h() {
        List<com.baidu.location.c.a> list = this.p;
        if (list == null && this.o == null) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("cellbuffer mTrackList == null");
                return;
            }
            return;
        }
        if (list == null && this.o != null) {
            LinkedList linkedList = new LinkedList();
            this.p = linkedList;
            linkedList.add(this.o);
        }
        String a2 = com.baidu.location.c.b.b.a(this.w);
        if (a2 != null && this.p != null) {
            File file = new File(a2 + File.separator + "lcvif2.dat");
            int size = this.p.size();
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(this.p.get(size - 1).g);
                randomAccessFile.writeInt(size);
                for (int i = 0; i < 3 - size; i++) {
                    randomAccessFile.writeLong(0L);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeInt(-1);
                    randomAccessFile.writeLong(-1L);
                    randomAccessFile.writeInt(2);
                }
                for (int i2 = 0; i2 < size; i2++) {
                    randomAccessFile.writeLong(this.p.get(i2).g);
                    randomAccessFile.writeInt(this.p.get(i2).c);
                    randomAccessFile.writeInt(this.p.get(i2).d);
                    randomAccessFile.writeInt(this.p.get(i2).f5679a);
                    randomAccessFile.writeLong(this.p.get(i2).b);
                    if (this.p.get(i2).i == 'g') {
                        randomAccessFile.writeInt(1);
                    } else if (this.p.get(i2).i == 'c') {
                        randomAccessFile.writeInt(2);
                    } else {
                        randomAccessFile.writeInt(3);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.E.post(new com.baidu.location.c.a.b(this));
    }

    private String e(com.baidu.location.c.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f5679a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h), Integer.valueOf(aVar.k), Long.valueOf(aVar.g)));
        if (aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(aVar.j);
        }
        if (aVar.o != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(aVar.o);
        }
        return stringBuffer.toString();
    }

    private String f(com.baidu.location.c.a aVar) {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f5679a), Long.valueOf(aVar.b));
    }

    private void g(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVar2;
        com.baidu.location.c.a aVar3 = this.n;
        if (aVar.b() && ((aVar2 = this.n) == null || !aVar2.a(aVar) || a(this.n, aVar))) {
            this.n = aVar;
        }
        if (aVar.b()) {
            if (aVar3 == null || !aVar3.a(aVar)) {
                if (aVar.b()) {
                    int size = this.p.size();
                    com.baidu.location.c.a aVar4 = size == 0 ? null : this.p.get(size - 1);
                    if (aVar4 != null) {
                        long j = aVar4.b;
                        com.baidu.location.c.a aVar5 = this.n;
                        if (j == aVar5.b && aVar4.f5679a == aVar5.f5679a) {
                            return;
                        }
                    }
                    this.p.add(this.n);
                    if (this.p.size() > 3) {
                        this.p.remove(0);
                    }
                    if (this.i) {
                        h();
                    }
                    this.D = false;
                    return;
                }
                List<com.baidu.location.c.a> list = this.p;
                if (list != null) {
                    list.clear();
                }
            }
        }
    }

    public void b() {
        TelephonyManager telephonyManager;
        if (this.x) {
            try {
                d dVar = this.r;
                if (dVar != null && (telephonyManager = this.j) != null) {
                    telephonyManager.listen(dVar, 0);
                }
                this.r = null;
                this.j = null;
                this.k = null;
                this.l = null;
                List<com.baidu.location.c.a> list = this.p;
                if (list != null) {
                    list.clear();
                    this.p = null;
                }
                if (this.i) {
                    h();
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("cell manager stop ...");
            }
            this.x = false;
        }
    }

    public boolean c() {
        return this.D;
    }

    public static a a() {
        return e.f5685a;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0099 A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:31:0x0010, B:33:0x0014, B:34:0x0027, B:36:0x0037, B:38:0x003a, B:40:0x0040, B:42:0x0043, B:43:0x0045, B:45:0x004b, B:47:0x0051, B:48:0x0056, B:50:0x005a, B:52:0x005e, B:53:0x0092, B:55:0x0099, B:57:0x009d, B:58:0x00b4, B:60:0x00b8, B:61:0x00bf, B:63:0x00c3, B:65:0x00c7, B:66:0x00d0, B:68:0x00d6, B:70:0x00da, B:71:0x00f1, B:73:0x00f5, B:74:0x00fc, B:76:0x0100, B:78:0x0104, B:79:0x010d, B:83:0x00e3, B:85:0x00e7, B:86:0x010b, B:87:0x00a6, B:89:0x00aa, B:90:0x00ce, B:91:0x0054), top: B:30:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6 A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:31:0x0010, B:33:0x0014, B:34:0x0027, B:36:0x0037, B:38:0x003a, B:40:0x0040, B:42:0x0043, B:43:0x0045, B:45:0x004b, B:47:0x0051, B:48:0x0056, B:50:0x005a, B:52:0x005e, B:53:0x0092, B:55:0x0099, B:57:0x009d, B:58:0x00b4, B:60:0x00b8, B:61:0x00bf, B:63:0x00c3, B:65:0x00c7, B:66:0x00d0, B:68:0x00d6, B:70:0x00da, B:71:0x00f1, B:73:0x00f5, B:74:0x00fc, B:76:0x0100, B:78:0x0104, B:79:0x010d, B:83:0x00e3, B:85:0x00e7, B:86:0x010b, B:87:0x00a6, B:89:0x00aa, B:90:0x00ce, B:91:0x0054), top: B:30:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010b A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:31:0x0010, B:33:0x0014, B:34:0x0027, B:36:0x0037, B:38:0x003a, B:40:0x0040, B:42:0x0043, B:43:0x0045, B:45:0x004b, B:47:0x0051, B:48:0x0056, B:50:0x005a, B:52:0x005e, B:53:0x0092, B:55:0x0099, B:57:0x009d, B:58:0x00b4, B:60:0x00b8, B:61:0x00bf, B:63:0x00c3, B:65:0x00c7, B:66:0x00d0, B:68:0x00d6, B:70:0x00da, B:71:0x00f1, B:73:0x00f5, B:74:0x00fc, B:76:0x0100, B:78:0x0104, B:79:0x010d, B:83:0x00e3, B:85:0x00e7, B:86:0x010b, B:87:0x00a6, B:89:0x00aa, B:90:0x00ce, B:91:0x0054), top: B:30:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ce A[Catch: Exception -> 0x0024, TryCatch #2 {Exception -> 0x0024, blocks: (B:31:0x0010, B:33:0x0014, B:34:0x0027, B:36:0x0037, B:38:0x003a, B:40:0x0040, B:42:0x0043, B:43:0x0045, B:45:0x004b, B:47:0x0051, B:48:0x0056, B:50:0x005a, B:52:0x005e, B:53:0x0092, B:55:0x0099, B:57:0x009d, B:58:0x00b4, B:60:0x00b8, B:61:0x00bf, B:63:0x00c3, B:65:0x00c7, B:66:0x00d0, B:68:0x00d6, B:70:0x00da, B:71:0x00f1, B:73:0x00f5, B:74:0x00fc, B:76:0x0100, B:78:0x0104, B:79:0x010d, B:83:0x00e3, B:85:0x00e7, B:86:0x010b, B:87:0x00a6, B:89:0x00aa, B:90:0x00ce, B:91:0x0054), top: B:30:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        CellLocation cellLocation;
        try {
            com.baidu.location.c.a a2 = a(this.n, this.j);
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && a2 != null) {
                k.h().a("new cell api = " + f(a2));
            }
            if (a2 != null) {
                g(a2);
            }
            if (Build.VERSION.SDK_INT <= 28 && (a2 == null || !a2.b())) {
                try {
                    cellLocation = this.j.getCellLocation();
                } catch (Throwable unused) {
                    cellLocation = null;
                }
                com.baidu.location.c.a a3 = cellLocation != null ? a(cellLocation) : null;
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && a3 != null) {
                    k.h().a(" old cell api = " + f(a3));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public com.baidu.location.c.a c(int i) {
        com.baidu.location.c.a aVar;
        if (this.j != null) {
            try {
                f();
                boolean z = com.baidu.location.c.b.a.c;
                if (z && com.baidu.location.c.b.a.d) {
                    k.h().a(" lastDiffTime = " + this.A + ", diffTime = " + i);
                }
                if (Build.VERSION.SDK_INT >= 29 && this.y) {
                    if (i < Integer.MAX_VALUE) {
                        long j = i;
                        if (j != this.A) {
                            if (z && com.baidu.location.c.b.a.d) {
                                k.h().a("diff time is changed");
                            }
                            d();
                        } else if (System.currentTimeMillis() - this.z > j) {
                            if (z && com.baidu.location.c.b.a.d) {
                                k.h().a(" over diff time");
                            }
                            d();
                        }
                    }
                    this.A = i;
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
        }
        com.baidu.location.c.a aVar2 = this.n;
        if (aVar2 != null && aVar2.e()) {
            this.o = null;
            this.o = new com.baidu.location.c.a(this.n);
        }
        com.baidu.location.c.a aVar3 = this.n;
        if (aVar3 != null && aVar3.d() && (aVar = this.o) != null) {
            com.baidu.location.c.a aVar4 = this.n;
            if (aVar4.i == 'g') {
                aVar4.d = aVar.d;
                aVar4.c = aVar.c;
            }
        }
        return this.n;
    }

    public void a(Context context) {
        d dVar;
        Executor mainExecutor;
        if (this.x) {
            return;
        }
        this.w = context;
        this.j = (TelephonyManager) context.getSystemService("phone");
        this.p = new LinkedList();
        if (Looper.myLooper() != null) {
            this.r = new d();
        }
        if (this.E == null) {
            this.E = new Handler(Looper.getMainLooper());
        }
        if (this.i) {
            g();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= this.e) {
            if (this.q == null) {
                mainExecutor = this.w.getMainExecutor();
                this.q = mainExecutor;
            }
            this.y = com.baidu.location.c.b.b.a("android.telephony.TelephonyManager$CellInfoCallback");
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("isCellinfoCallbackExist = " + this.y);
            }
        }
        TelephonyManager telephonyManager = this.j;
        if (telephonyManager == null || (dVar = this.r) == null) {
            return;
        }
        if (i < this.e || !this.y) {
            try {
                telephonyManager.listen(dVar, 1280);
            } catch (Exception unused) {
            }
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            k.h().a("cell manager start...");
        }
        this.x = true;
    }

    private void e() {
        if (this.s == null) {
            this.s = new C0127a(this, null);
        }
        Executor executor = this.q;
        if (executor != null) {
            this.j.requestCellInfoUpdate(executor, this.s);
        }
    }

    private void g() {
        char c2;
        long j;
        String a2 = com.baidu.location.c.b.b.a(this.w);
        if (a2 == null) {
            return;
        }
        File file = new File(a2 + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                long readLong = randomAccessFile.readLong();
                if (System.currentTimeMillis() - readLong > 60000) {
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        k.h().a("cellbuffer System.currentTimeMillis() - time > 1 *60 *1000" + readLong);
                    }
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                for (int i = 0; i < 3; i++) {
                    long readLong2 = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    long readLong3 = randomAccessFile.readLong();
                    int readInt4 = randomAccessFile.readInt();
                    boolean z = com.baidu.location.c.b.a.c;
                    if (z && com.baidu.location.c.b.a.d) {
                        k.h().a("cellbuffer cell info = " + readLong2 + " " + readInt + " " + readInt2 + " " + readInt3 + " " + readLong3 + " " + readInt4);
                    }
                    char c3 = readInt4 == 1 ? 'g' : (char) 0;
                    if (readInt4 == 2) {
                        j = 0;
                        c2 = 'c';
                    } else {
                        c2 = c3;
                        j = 0;
                    }
                    if (readLong2 == j) {
                        if (z && com.baidu.location.c.b.a.d) {
                            k.h().a("loc cell time1 == 0");
                        }
                    } else {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(readInt3, readLong3, readInt, readInt2, 0, c2, -1);
                        aVar.g = readLong2;
                        if (aVar.b()) {
                            this.D = true;
                            this.p.add(aVar);
                        }
                        if (z && com.baidu.location.c.b.a.d) {
                            k.h().a("loc cell " + b(aVar));
                        }
                    }
                }
                randomAccessFile.close();
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
                file.delete();
            }
        }
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public com.baidu.location.c.a b(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        CellLocation cellLocation;
        com.baidu.location.c.a a2 = a(aVar, telephonyManager);
        if (Build.VERSION.SDK_INT <= 28 && (a2 == null || !a2.b())) {
            try {
                cellLocation = telephonyManager.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                a2 = a(cellLocation);
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && a2 != null) {
                k.h().a("main process: old cell api = " + f(a2));
            }
        }
        return a2;
    }

    public void a(int i) {
        this.f = i;
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a a2;
        HashSet<String> hashSet = new HashSet<>();
        try {
            List<CellInfo> allCellInfo = this.j.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (!cellInfo.isRegistered() && (a2 = a(cellInfo, this.n, this.j)) != null) {
                        int i = a2.f5679a;
                        String str = "";
                        if (i != -1 && a2.b != -1) {
                            str = aVar.f5679a != i ? a2.f5679a + "|" + a2.b : a2.b + "";
                        }
                        hashSet.add(str);
                    }
                }
            } else if (com.baidu.location.c.b.a.c) {
                Log.d("getAllCellInfo", "=null");
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return hashSet;
        } catch (NoSuchMethodError e3) {
            e = e3;
            e.printStackTrace();
            return hashSet;
        }
        return hashSet;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public String b(com.baidu.location.c.a aVar) {
        int i;
        if (aVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        Locale locale = Locale.CHINA;
        stringBuffer.append(String.format(locale, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f5679a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && (i = aVar.f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(i / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(aVar.l);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.k);
        if (aVar.o != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.o);
        }
        if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.j);
        }
        try {
            List<com.baidu.location.c.a> list = this.p;
            if (list != null && list.size() > 0) {
                int size = this.p.size();
                stringBuffer.append("&clt=");
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.location.c.a aVar2 = this.p.get(i2);
                    if (aVar2 != null) {
                        int i3 = aVar2.c;
                        if (i3 != aVar.c) {
                            stringBuffer.append(i3);
                        }
                        stringBuffer.append("|");
                        int i4 = aVar2.d;
                        if (i4 != aVar.d) {
                            stringBuffer.append(i4);
                        }
                        stringBuffer.append("|");
                        int i5 = aVar2.f5679a;
                        if (i5 != aVar.f5679a) {
                            stringBuffer.append(i5);
                        }
                        stringBuffer.append("|");
                        long j = aVar2.b;
                        if (j != aVar.b) {
                            stringBuffer.append(j);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(x.aL);
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
        if (this.f5680a > 100) {
            this.f5680a = 0;
        }
        int i6 = this.f5680a + (b << 8);
        boolean z = com.baidu.location.c.b.a.c;
        if (z && com.baidu.location.c.b.a.d) {
            k.h().a("sim state:" + this.f5680a + "," + i6);
        }
        stringBuffer.append("&cs=" + i6);
        String str = aVar.m;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (z && com.baidu.location.c.b.a.d) {
            k.h().a("cell sb.toString() = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        try {
            this.f5680a = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                com.baidu.location.c.a aVar2 = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        boolean z = aVar2 != null;
                        com.baidu.location.c.a a2 = a(cellInfo, aVar, telephonyManager);
                        if (a2 != null) {
                            if (!a2.b()) {
                                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                    k.h().a("res.isValid()");
                                }
                                a2 = null;
                            } else {
                                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                    k.h().a(" cell res.isValid() = " + f(a2));
                                }
                                if (z && aVar2 != null) {
                                    aVar2.m = e(a2);
                                    aVar2.n = f(a2);
                                }
                            }
                            if (aVar2 == null) {
                                aVar2 = a2;
                            }
                        }
                    }
                }
                return aVar2;
            }
            if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                return null;
            }
            k.h().a("getAllCellInfo=null");
            return null;
        } catch (Throwable th) {
            if (!com.baidu.location.c.b.a.c) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        try {
            String d2 = d(aVar);
            if (d2 == null || "".equals(d2)) {
                return d2;
            }
            "&nc=".equals(d2);
            return d2;
        } catch (Throwable th) {
            th.printStackTrace();
            if ("&nc=".equals("")) {
                return null;
            }
            return "";
        }
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        boolean z;
        if (aVar == null && aVar2 == null) {
            return false;
        }
        if (aVar == null || aVar2 == null) {
            return true;
        }
        float abs = Math.abs(aVar.h - aVar2.h);
        int i = aVar.h;
        if (i == 0) {
            i = -1;
        }
        float f = abs / i;
        boolean z2 = com.baidu.location.c.b.a.c;
        if (z2 && com.baidu.location.c.b.a.d) {
            k.h().a("cl-cache, str, old:" + aVar.h + " new:" + aVar2.h);
            g h = k.h();
            StringBuilder sb = new StringBuilder();
            sb.append("cl-cache, str, diffRate:");
            sb.append(f);
            h.a(sb.toString());
        }
        String str = aVar.m;
        if (str != null && aVar2.m != null) {
            if (Math.abs(Math.abs(r9 - a(aVar2.m)) / (a(str) != 0 ? r9 : -1)) > this.g) {
                z = true;
                if (z2 && com.baidu.location.c.b.a.d) {
                    k.h().a("cl-cache, isStrengthChange2:" + z);
                }
                return f <= this.g || z;
            }
        }
        z = false;
        if (z2) {
            k.h().a("cl-cache, isStrengthChange2:" + z);
        }
        if (f <= this.g) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String d(com.baidu.location.c.a r11) {
        /*
            r10 = this;
            java.lang.String r11 = "|"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.telephony.TelephonyManager r2 = r10.j     // Catch: java.lang.Throwable -> L76
            java.util.List r2 = r2.getAllCellInfo()     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto Lb4
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L76
            if (r3 <= 0) goto Lb4
            java.lang.String r3 = "&nc="
            r0.append(r3)     // Catch: java.lang.Throwable -> L76
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L76
        L20:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto Lcd
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L76
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch: java.lang.Throwable -> L76
            boolean r4 = r3.isRegistered()     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L33
            goto L20
        L33:
            com.baidu.location.c.a r4 = r10.n     // Catch: java.lang.Throwable -> L76
            android.telephony.TelephonyManager r5 = r10.j     // Catch: java.lang.Throwable -> L76
            com.baidu.location.c.a r3 = r10.a(r3, r4, r5)     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L3e
            goto L20
        L3e:
            int r4 = r3.f5679a     // Catch: java.lang.Throwable -> L76
            r5 = -1
            java.lang.String r6 = ";"
            if (r4 == r5) goto L78
            long r4 = r3.b     // Catch: java.lang.Throwable -> L76
            r7 = -1
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 == 0) goto L78
            int r4 = r3.c     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            r0.append(r11)     // Catch: java.lang.Throwable -> L76
            int r4 = r3.d     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            r0.append(r11)     // Catch: java.lang.Throwable -> L76
            int r4 = r3.f5679a     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            r0.append(r11)     // Catch: java.lang.Throwable -> L76
            long r4 = r3.b     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            r0.append(r11)     // Catch: java.lang.Throwable -> L76
            int r4 = r3.h     // Catch: java.lang.Throwable -> L76
            r0.append(r4)     // Catch: java.lang.Throwable -> L76
            r0.append(r6)     // Catch: java.lang.Throwable -> L76
            goto L78
        L76:
            r11 = move-exception
            goto Lc6
        L78:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L76
            r5 = 28
            if (r4 <= r5) goto L20
            int r4 = r3.k     // Catch: java.lang.Throwable -> L76
            r5 = 6
            if (r4 != r5) goto L20
            java.lang.String r4 = r3.o     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L20
            boolean r4 = r3.b()     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L20
            if (r1 != 0) goto L9e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r4.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "&ncnr="
            r4.append(r1)     // Catch: java.lang.Throwable -> L9b
            r1 = r4
            goto L9e
        L9b:
            r11 = move-exception
            r1 = r4
            goto Lc6
        L9e:
            java.lang.String r4 = r10.f(r3)     // Catch: java.lang.Throwable -> L76
            r1.append(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "_"
            r1.append(r4)     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = r3.o     // Catch: java.lang.Throwable -> L76
            r1.append(r3)     // Catch: java.lang.Throwable -> L76
            r1.append(r6)     // Catch: java.lang.Throwable -> L76
            goto L20
        Lb4:
            boolean r11 = com.baidu.location.c.b.a.c     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto Lcd
            boolean r11 = com.baidu.location.c.b.a.d     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto Lcd
            com.baidu.location.c.g r11 = com.baidu.location.c.k.h()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "getAllCellInfo = null"
            r11.a(r2)     // Catch: java.lang.Throwable -> L76
            goto Lcd
        Lc6:
            boolean r2 = com.baidu.location.c.b.a.c
            if (r2 == 0) goto Lcd
            r11.printStackTrace()
        Lcd:
            if (r1 == 0) goto Le7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = r0.toString()
            r11.append(r0)
            java.lang.String r0 = r1.toString()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            return r11
        Le7:
            java.lang.String r11 = r0.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.d(com.baidu.location.c.a):java.lang.String");
    }

    private int a(String str) {
        if (str == null || !str.contains("cl_s2")) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            String group = matcher.group();
            return Integer.parseInt(group.substring(group.indexOf("cl_s2=") + 6, group.length()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(4:3|(1:7)|8|(1:10))(2:173|(5:175|(1:179)|180|(1:182)|(5:191|192|(1:198)|207|(2:201|(1:205)))(2:186|(1:190)))(2:212|(4:214|(1:218)|219|(1:221))(8:222|(3:47|48|(4:50|(1:54)|55|(1:57))(2:58|(6:60|(8:62|(1:66)|67|(2:81|82)|69|(2:74|75)|71|(1:73))(2:88|(7:90|91|(1:95)|97|98|(1:102)|(18:104|(2:159|160)|106|(2:152|153)|108|109|(4:139|140|(1:144)|145)|111|112|(4:126|127|(1:131)|132)|114|(1:116)|117|(1:119)|120|(1:122)|123|(1:125))))|168|169|170|(1:172))))|13|14|(4:16|(1:20)|21|(1:23))(4:31|(1:35)|36|(1:40))|24|(1:28)|29)))|11|(0)|13|14|(0)(0)|24|(2:26|28)|29) */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0150, code lost:
    
        if (r0 < 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0509, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x05be, code lost:
    
        if (com.baidu.location.c.b.a.c != false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x05c0, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x05c3, code lost:
    
        r10.g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x04a9 A[Catch: Error -> 0x0509, TRY_ENTER, TryCatch #3 {Error -> 0x0509, blocks: (B:16:0x04a9, B:18:0x04b6, B:20:0x04ba, B:21:0x050c, B:23:0x0515, B:31:0x0531, B:33:0x0542, B:35:0x0546, B:36:0x0594, B:38:0x059d, B:40:0x05a1), top: B:14:0x04a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0531 A[Catch: Error -> 0x0509, TryCatch #3 {Error -> 0x0509, blocks: (B:16:0x04a9, B:18:0x04b6, B:20:0x04ba, B:21:0x050c, B:23:0x0515, B:31:0x0531, B:33:0x0542, B:35:0x0546, B:36:0x0594, B:38:0x059d, B:40:0x05a1), top: B:14:0x04a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.baidu.location.c.a a(android.telephony.CellInfo r19, com.baidu.location.c.a r20, android.telephony.TelephonyManager r21) {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a.a(android.telephony.CellInfo, com.baidu.location.c.a, android.telephony.TelephonyManager):com.baidu.location.c.a");
    }

    private static int b(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    String group = matcher.group(1);
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        k.h().a(" pasrse mnrtac = " + group);
                    }
                    try {
                        i = Integer.parseInt(group);
                    } catch (Throwable th) {
                        if (com.baidu.location.c.b.a.c) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            return i;
        }
    }

    private static int a(CellIdentityNr cellIdentityNr) {
        try {
            int a2 = com.baidu.location.c.b.b.a(cellIdentityNr, "getHwTac");
            if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                return a2;
            }
            k.h().a(" get hw tac = " + a2);
            return a2;
        } catch (Throwable th) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a(" get hw tac exception !" + th);
            }
            return -1;
        }
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        int i;
        if (cellLocation == null || this.j == null) {
            return null;
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            k.h().a("set cell info..");
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        aVar.l = 1;
        if (z) {
            aVar.p = true;
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.j.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i < 0 ? this.n.c : i;
                } else {
                    i = -1;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    i = Integer.valueOf(substring.substring(0, i2)).intValue();
                }
                if (i < 0) {
                    i = this.n.d;
                }
                aVar.d = i;
            }
            this.f5680a = this.j.getSimState();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("sim state:" + this.f5680a);
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f5679a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = r10.getCid();
            aVar.i = 'g';
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("bslocation mNetworkType = 'g'");
            }
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            boolean z2 = com.baidu.location.c.b.a.c;
            if (z2 && com.baidu.location.c.b.a.d) {
                k.h().a("bslocation mNetworkType = 'c'");
            }
            if (v == null) {
                try {
                    v = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused) {
                    v = null;
                    return aVar;
                }
            }
            Class<?> cls = v;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.n.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f5679a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        k.h().a("bslocation lat " + (baseStationLatitude / 14400.0d));
                    }
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        k.h().a("bslocation lon" + (baseStationLongitude / 14400.0d));
                    }
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception e3) {
                    if (com.baidu.location.c.b.a.c) {
                        e3.printStackTrace();
                    }
                    b = 3;
                    return aVar;
                }
            }
        }
        g(aVar);
        return aVar;
    }
}
