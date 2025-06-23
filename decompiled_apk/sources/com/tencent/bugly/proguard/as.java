package com.tencent.bugly.proguard;

import XXO0.oIX0oI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.sma.smartv3.ble.ProductManager;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes13.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    public static int f26561a;
    private static final Map<Integer, Pair<String, String>> h = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.proguard.as.1
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };
    private static final ArrayList<II0xO0> i = new ArrayList<II0xO0>() { // from class: com.tencent.bugly.proguard.as.2
        {
            byte b = 0;
            add(new I0Io(b));
            add(new oxoX(b));
            add(new X0o0xo(b));
            add(new XO(b));
            add(new xxIXOIIO(b));
            add(new xoIox(b));
            add(new Oxx0IOOO(b));
            add(new II0XooXoX(b));
        }
    };
    private static final Map<Integer, Integer> j = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.proguard.as.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };
    private static final Map<Integer, String> k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };
    private static final Map<Integer, String> l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };
    protected final Context b;
    protected final ai c;
    protected final w d;
    protected final ac e;
    protected aw f;
    protected BuglyStrategy.a g;

    /* loaded from: classes13.dex */
    public static class I0Io extends II0xO0 {
        public /* synthetic */ I0Io(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            return at.a().k();
        }

        public I0Io() {
            super(3, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static class II0XooXoX extends II0xO0 {
        public /* synthetic */ II0XooXoX(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            if ((at.a().B & 1) > 0) {
                return true;
            }
            return false;
        }

        public II0XooXoX() {
            super(6, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static abstract class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f26562oIX0oI;

        public /* synthetic */ II0xO0(int i, byte b) {
            this(i);
        }

        public abstract boolean oIX0oI();

        public II0xO0(int i) {
            this.f26562oIX0oI = i;
        }
    }

    /* loaded from: classes13.dex */
    public static class Oxx0IOOO extends II0xO0 {
        public /* synthetic */ Oxx0IOOO(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            if ((at.a().B & 2) > 0) {
                return true;
            }
            return false;
        }

        public Oxx0IOOO() {
            super(5, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static class X0o0xo extends II0xO0 {
        public /* synthetic */ X0o0xo(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            return true;
        }

        public X0o0xo() {
            super(2, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static class XO extends II0xO0 {
        public /* synthetic */ XO(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            return at.a().j();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public XO() {
            /*
                r1 = this;
                r0 = 0
                r1.<init>(r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.XO.<init>():void");
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements ah {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ boolean f26563I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ List f26564II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ long f26565oIX0oI;

        public oIX0oI(long j, List list, boolean z) {
            this.f26565oIX0oI = j;
            this.f26564II0xO0 = list;
            this.f26563I0Io = z;
        }

        @Override // com.tencent.bugly.proguard.ah
        public final void a(boolean z, String str) {
            String str2;
            long currentTimeMillis = System.currentTimeMillis() - this.f26565oIX0oI;
            List list = this.f26564II0xO0;
            if (this.f26563I0Io) {
                str2 = "realtime";
            } else {
                str2 = "cache";
            }
            as.a(list, z, currentTimeMillis, str2, str);
            as.a(z, (List<CrashDetailBean>) this.f26564II0xO0);
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX extends II0xO0 {
        public /* synthetic */ oxoX(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            return true;
        }

        public oxoX() {
            super(7, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static class xoIox extends II0xO0 {
        public /* synthetic */ xoIox(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            if ((at.a().B & 4) > 0) {
                return true;
            }
            return false;
        }

        public xoIox() {
            super(4, (byte) 0);
        }
    }

    /* loaded from: classes13.dex */
    public static class xxIXOIIO extends II0xO0 {
        public /* synthetic */ xxIXOIIO(byte b) {
            this();
        }

        @Override // com.tencent.bugly.proguard.as.II0xO0
        public final boolean oIX0oI() {
            return at.a().j();
        }

        public xxIXOIIO() {
            super(1, (byte) 0);
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f26561a = 1004;
        this.b = context;
        this.c = aiVar;
        this.d = wVar;
        this.e = acVar;
        this.g = aVar;
        this.f = null;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.d && arVar.b <= currentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.e && !arVar.d) {
                String str = crashDetailBean.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arVar.b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.t++;
                    sb.append(arVar.b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.f26513a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        Iterator<ar> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f26560a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(oIX0oI.I0Io.f4095I0Io);
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f26513a);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c = c(list);
        if (c == null || c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c) {
            String str = l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.c, str);
                arrayList.add(new ag.c(crashDetailBean.c, str, crashDetailBean.r, false, 0L, "expired", null));
            }
        }
        ag.a.a().a(arrayList);
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> c;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.e) {
                arrayList.add(arVar);
            }
        }
        if (arrayList.isEmpty() || (c = c(arrayList)) == null || c.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(c);
            crashDetailBean2 = c.get(0);
            a(crashDetailBean2, c);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str = crashDetailBean2.s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in (");
        Iterator<ar> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f26560a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(oIX0oI.I0Io.f4095I0Io);
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = w.a().a("t_cr", (String[]) null, sb2);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in (");
                int i2 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                            sb.append(",");
                            i2++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(oIX0oI.I0Io.f4095I0Io);
                String sb3 = sb.toString();
                if (i2 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
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

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = h.get(Integer.valueOf(crashDetailBean.b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                return "";
            }
            if (crashDetailBean.j) {
                return (String) pair.first;
            }
            return (String) pair.second;
        } catch (Exception e) {
            al.a(e);
            return "";
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            al.c("save eup logs", new Object[0]);
            aa b = aa.b();
            String str = "#--------\npackage:" + b.e() + "\nversion:" + b.o + "\nsdk:" + b.h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.r)) + "\ntype:" + crashDetailBean.n + "\nmessage:" + crashDetailBean.o + "\nstack:\n" + crashDetailBean.q + "\neupID:" + crashDetailBean.c + "\n";
            if (at.m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.b.getPackageName();
                } else {
                    absolutePath = null;
                }
            } else {
                File file = new File(at.m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            }
            am.a(absolutePath + "/euplog.txt", str, at.n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z) {
        if (at.o) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z, crashDetailBean.b == 7, z);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues c = c(crashDetailBean);
        if (c != null) {
            long a2 = w.a().a("t_cr", c, (v) null);
            if (a2 >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f26513a = a2;
            }
        }
        if (at.l) {
            d(crashDetailBean);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i2 = 1; i2 < list.size(); i2++) {
            String str = list.get(i2).s;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.s.contains(str2)) {
                        crashDetailBean.t++;
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f26560a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            arVar.e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            arVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                }
                return null;
            }
            try {
                if (a2.getCount() <= 0) {
                    a2.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i2 = 0;
                while (a2.moveToNext()) {
                    ar b = b(a2);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        try {
                            sb.append(a2.getLong(a2.getColumnIndex("_id")));
                            sb.append(",");
                            i2++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(oIX0oI.I0Io.f4095I0Io);
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i2 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
                }
                a2.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e) {
            e.printStackTrace();
            al.a(e);
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                al.a(e);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.b == 1 && (str = crashDetailBean.v) != null) {
            try {
                bn a2 = a("tomb.zip", context, str);
                if (a2 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e) {
                al.a(e);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e) {
            al.a(e);
        }
    }

    private boolean b(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z;
        int i2 = crashDetailBean.b;
        boolean z2 = i2 == 0 || i2 == 1;
        boolean z3 = i2 == 3;
        if (p.c) {
            z = false;
        } else {
            z = (z3 || z2) ? at.e : true;
        }
        if (!z) {
            return false;
        }
        ArrayList<ar> arrayList = new ArrayList(10);
        if (!a(crashDetailBean, list, arrayList)) {
            try {
                if (arrayList.size() >= at.d) {
                }
            } catch (Exception e) {
                al.a(e);
                al.d("Failed to merge crash.", new Object[0]);
            }
            return false;
        }
        al.a("same crash occur too much do merged!", new Object[0]);
        CrashDetailBean a2 = a((List<ar>) arrayList, crashDetailBean);
        for (ar arVar : arrayList) {
            if (arVar.f26560a != a2.f26513a) {
                list2.add(arVar);
            }
        }
        b(a2);
        d(list2);
        al.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
    }

    private static boolean a(String str) {
        String str2 = at.r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.r);
                if (Pattern.compile(at.r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e) {
                al.a(e);
                al.d("Failed to compile " + at.r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z = false;
        for (ar arVar : list) {
            if (crashDetailBean.u.equals(arVar.c)) {
                if (arVar.e) {
                    z = true;
                }
                list2.add(arVar);
            }
        }
        return z;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c = ac.a().c();
        if (c == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c.f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b = ap.b();
        List<ar> b2 = b();
        al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
        if (b2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(a(b2));
        b2.removeAll(arrayList);
        Iterator<ar> it = b2.iterator();
        while (it.hasNext()) {
            ar next = it.next();
            long j2 = next.b;
            if (j2 < b - at.j) {
                arrayList2.add(next);
                it.remove();
                arrayList.add(next);
            } else if (next.d) {
                if (j2 >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f >= 3 && j2 < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        b(arrayList2);
        if (arrayList.size() > 0) {
            d(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> c2 = c(b2);
        if (c2 != null && c2.size() > 0) {
            String str = aa.b().o;
            Iterator<CrashDetailBean> it2 = c2.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f)) {
                    it2.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            e(arrayList3);
        }
        return c2;
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        if (!aa.a(this.b).f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z3 && !aiVar.b(at.f26567a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean c = this.e.c();
        if (!c.f) {
            al.d("remote report is disable!", new Object[0]);
            al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = c.r;
                String str2 = StrategyBean.b;
                bp a2 = a(this.b, list, aa.b());
                if (a2 == null) {
                    al.d("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] a3 = ae.a((m) a2);
                if (a3 == null) {
                    al.d("send encode fail!", new Object[0]);
                    return;
                }
                bq a4 = ae.a(this.b, 830, a3);
                if (a4 == null) {
                    al.d("request package is null.", new Object[0]);
                    return;
                }
                oIX0oI oix0oi = new oIX0oI(System.currentTimeMillis(), list, z);
                if (z) {
                    this.c.a(f26561a, a4, str, str2, oix0oi, j2, z2);
                    return;
                } else {
                    this.c.a(f26561a, a4, str, str2, oix0oi, false);
                    return;
                }
            } catch (Throwable th) {
                al.e("req cr error %s", th.toString());
                if (al.b(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        al.d("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                int i2 = crashDetailBean.l + 1;
                crashDetailBean.l = i2;
                crashDetailBean.d = z;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(i2), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                at.a().a(it.next());
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f26513a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        ArrayList<bl> arrayList = null;
        if (context != null && crashDetailBean != null && aaVar != null) {
            bo boVar = new bo();
            boVar.f26600a = e(crashDetailBean);
            boVar.b = crashDetailBean.r;
            boVar.c = crashDetailBean.n;
            boVar.d = crashDetailBean.o;
            boVar.e = crashDetailBean.p;
            boVar.g = crashDetailBean.q;
            boVar.h = crashDetailBean.z;
            boVar.i = crashDetailBean.c;
            boVar.j = null;
            boVar.l = crashDetailBean.m;
            boVar.m = crashDetailBean.e;
            boVar.f = crashDetailBean.B;
            boVar.n = null;
            Map<String, PlugInBean> map = crashDetailBean.h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.h.entrySet()) {
                    bl blVar = new bl();
                    blVar.f26597a = entry.getValue().f26511a;
                    blVar.c = entry.getValue().c;
                    blVar.e = entry.getValue().b;
                    arrayList.add(blVar);
                }
            }
            boVar.p = arrayList;
            al.c("libInfo %s", boVar.o);
            ArrayList<bn> arrayList2 = new ArrayList<>(20);
            a(arrayList2, crashDetailBean);
            a(arrayList2, crashDetailBean.w);
            b(arrayList2, crashDetailBean.x);
            c(arrayList2, crashDetailBean.Z);
            a(arrayList2, crashDetailBean.aa, context);
            a(arrayList2, crashDetailBean.y);
            a(arrayList2, crashDetailBean, context);
            b(arrayList2, crashDetailBean, context);
            a(arrayList2, aaVar.L);
            b(arrayList2, crashDetailBean.Y);
            boVar.q = arrayList2;
            if (crashDetailBean.j) {
                boVar.k = crashDetailBean.t;
            }
            boVar.r = a(crashDetailBean, aaVar);
            boVar.s = new HashMap();
            Map<String, String> map2 = crashDetailBean.S;
            if (map2 != null && map2.size() > 0) {
                boVar.s.putAll(crashDetailBean.S);
                al.a("setted message size %d", Integer.valueOf(boVar.s.size()));
            }
            Map<String, String> map3 = boVar.s;
            al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.I);
            map3.put("SDK_UPLOAD_U1", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.J);
            map3.put("SDK_UPLOAD_U2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.K);
            map3.put("SDK_UPLOAD_U3", sb3.toString());
            al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.n, crashDetailBean.c, aaVar.d(), Long.valueOf((crashDetailBean.r - crashDetailBean.Q) / 1000), Boolean.valueOf(crashDetailBean.k), Boolean.valueOf(crashDetailBean.R), Boolean.valueOf(crashDetailBean.j), Boolean.valueOf(crashDetailBean.b == 1), Integer.valueOf(crashDetailBean.t), crashDetailBean.s, Boolean.valueOf(crashDetailBean.d), Integer.valueOf(boVar.r.size()));
            return boVar;
        }
        al.d("enExp args == null", new Object[0]);
        return null;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context != null && list != null && list.size() != 0 && aaVar != null) {
            bp bpVar = new bp();
            bpVar.f26601a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                bpVar.f26601a.add(a(context, it.next(), aaVar));
            }
            return bpVar;
        }
        al.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            al.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ap.a(file, file2)) {
                al.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                al.c("read bytes :%d", Integer.valueOf(byteArray.length));
                bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return bnVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            if (!al.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!al.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b = aa.b();
        if (b == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", b.c);
        al.e("# APP VER: %s", b.o);
        al.e("# SDK VER: %s", b.h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f26524a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.c);
            al.e("# CRASH DEVICE: %s %s", b.h(), b.r().booleanValue() ? "ROOTED" : "UNROOT");
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.b == 3) {
                if (crashDetailBean.T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ap.b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        al.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ap.b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - 100000);
                        al.d("setted %s value length is over limit %d substring", key, 100000);
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.S.put(key, value);
                    al.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.j && (str = crashDetailBean.s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                al.a(e);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e) {
                e.printStackTrace();
                al.a(e);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a2 = a("backupRecord.zip", context, str);
                if (a2 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e) {
                al.a(e);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e) {
            al.a(e);
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a2;
        if (crashDetailBean.b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            Map<String, String> map = crashDetailBean.T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.v;
            if (str == null || (a2 = a("trace.zip", context, str)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(a2);
        } catch (Exception e) {
            e.printStackTrace();
            al.a(e);
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put(ProductManager.XxOOO0, sb3.toString());
            hashMap.put("A23", crashDetailBean.f);
            StringBuilder sb4 = new StringBuilder();
            aaVar.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put(ProductManager.xXIO, aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", aaVar.k);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(aaVar.r());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.Q);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(true ^ crashDetailBean.R);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aaVar.z);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.A);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.B);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", aaVar.y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.C);
            hashMap.put(ProductManager.f20444Oox, sb15.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e) {
            e.printStackTrace();
            al.a(e);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static /* synthetic */ void a(List list, boolean z, long j2, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.c, str3, crashDetailBean.r, z, j2, str, str2));
            }
        }
        ag.a.a().a(arrayList);
    }
}
