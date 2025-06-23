package com.tencent.bugly.proguard;

import XXO0.oIX0oI;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.nplatform.comapi.MapItem;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes13.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f26529a;
    private final ad b;

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ag f26530a = new ag(0);

        public static /* synthetic */ ag a() {
            return f26530a;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f26531a;
        public long b;
        public String c;

        public final String toString() {
            return "SLAData{uuid='" + this.f26531a + "', time=" + this.b + ", data='" + this.c + "'}";
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ List f26534XO;

        public oIX0oI(List list) {
            this.f26534XO = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ag.c(this.f26534XO);
        }
    }

    public /* synthetic */ ag(byte b2) {
        this();
    }

    public static void c(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().c);
            }
            Pair<Integer, String> a2 = ad.a(arrayList);
            al.c("sla batch report result, rspCode:%s rspMsg:%s", a2.first, a2.second);
            if (((Integer) a2.first).intValue() == 200) {
                d(list);
                return;
            }
            return;
        }
        al.c("sla batch report data is empty", new Object[0]);
    }

    public static void d(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + a(",", list) + oIX0oI.I0Io.f4095I0Io;
                al.c("sla batch delete where:%s", str);
                w.a().a("t_sla", str);
                return;
            } catch (Throwable th) {
                al.b(th);
                return;
            }
        }
        al.c("sla batch delete list is null", new Object[0]);
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f26531a, Long.valueOf(bVar.b), bVar.c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f26531a);
                contentValues.put("_tm", Long.valueOf(bVar.b));
                contentValues.put("_dt", bVar.c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public final void a(List<c> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                b b2 = b(it.next());
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            e(arrayList);
            b(arrayList);
            return;
        }
        al.d("sla batch report event is null", new Object[0]);
    }

    public final void b(List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new oIX0oI(list));
        } else {
            c(list);
        }
    }

    private ag() {
        this.f26529a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.b = new ad();
    }

    private b b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.b)) {
            aa b2 = aa.b();
            if (b2 == null) {
                al.d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb = new StringBuilder("&app_version=");
            sb.append(b2.o);
            sb.append("&app_name=");
            sb.append(b2.q);
            sb.append("&app_bundle_id=");
            sb.append(b2.c);
            sb.append("&client_type=android&user_id=");
            sb.append(b2.f());
            sb.append("&sdk_version=");
            sb.append(b2.h);
            sb.append("&event_code=");
            sb.append(cVar.b);
            sb.append("&event_result=");
            sb.append(cVar.d ? 1 : 0);
            sb.append("&event_time=");
            sb.append(this.f26529a.format(new Date(cVar.c)));
            sb.append("&event_cost=");
            sb.append(cVar.e);
            sb.append("&device_id=");
            sb.append(b2.g());
            sb.append("&debug=");
            sb.append(b2.D ? 1 : 0);
            sb.append("&param_0=");
            sb.append(cVar.f);
            sb.append("&param_1=");
            sb.append(cVar.f26532a);
            sb.append("&param_2=");
            sb.append(b2.M ? "rqd" : MapItem.KEY_EXT);
            sb.append("&param_4=");
            sb.append(b2.e());
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(cVar.g)) {
                sb2 = sb2 + "&param_3=" + cVar.g;
            }
            al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f26532a, cVar.b, Long.valueOf(cVar.c), Boolean.valueOf(cVar.d), Long.valueOf(cVar.e), cVar.f, cVar.g);
            String str = cVar.f26532a + HelpFormatter.DEFAULT_OPT_PREFIX + cVar.b;
            b bVar = new b();
            bVar.f26531a = str;
            bVar.b = cVar.c;
            bVar.c = sb2;
            return bVar;
        }
        al.d("sla convert event is null", new Object[0]);
        return null;
    }

    /* loaded from: classes13.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f26532a;
        String b;
        long c;
        boolean d;
        long e;
        String f;
        String g;

        public c(String str, String str2, long j, boolean z, long j2, String str3, String str4) {
            this.f26532a = str;
            this.b = str2;
            this.c = j;
            this.d = z;
            this.e = j2;
            this.f = str3;
            this.g = str4;
        }

        public c() {
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        sb.append(it.next().f26531a);
        sb.append("'");
        while (it.hasNext()) {
            sb.append(str);
            sb.append("'");
            sb.append(it.next().f26531a);
            sb.append("'");
        }
        return sb.toString();
    }

    public static List<b> a() {
        Cursor a2 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (a2 == null) {
            return null;
        }
        if (a2.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a2.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f26531a = a2.getString(a2.getColumnIndex("_id"));
                bVar.b = a2.getLong(a2.getColumnIndex("_tm"));
                bVar.c = a2.getString(a2.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } catch (Throwable th) {
                try {
                    al.b(th);
                } finally {
                    a2.close();
                }
            }
        }
        return arrayList;
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.b)) {
            al.d("sla report event is null", new Object[0]);
        } else {
            al.c("sla report single event", new Object[0]);
            a(Collections.singletonList(cVar));
        }
    }
}
