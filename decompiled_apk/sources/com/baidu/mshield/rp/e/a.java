package com.baidu.mshield.rp.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mshield.utility.b;
import com.baidu.mshield.utility.e;
import com.tencent.connect.common.II0xO0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f6383a;
    public HandlerC0146a b = new HandlerC0146a(e.a());
    public com.baidu.mshield.sharedpreferences.a c;
    public Context d;
    public com.baidu.mshield.rp.d.a.a e;

    /* renamed from: com.baidu.mshield.rp.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0146a extends Handler {
        public HandlerC0146a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.f();
                        return;
                    case 1:
                        com.baidu.mshield.rp.b.a.a(a.this.d).a((com.baidu.mshield.rp.c.a) message.obj);
                        com.baidu.mshield.b.c.a.b("sj-trigger report f ACTION_REPORT_RECORD");
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        com.baidu.mshield.b.c.a.b("sj-trigger reportACTION_REPORT_DATA");
                        a.this.c();
                        a.this.f();
                        a.this.a(0, com.baidu.mshield.utility.a.f(a.this.d));
                        return;
                    case 3:
                        com.baidu.mshield.rp.a.a aVar = (com.baidu.mshield.rp.a.a) message.obj;
                        if (aVar != null) {
                            a.this.b(aVar);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        com.baidu.mshield.rp.b.a.a(a.this.d).a(com.baidu.mshield.b.f.e.a(valueOf));
                        return;
                    case 5:
                        a.this.c();
                        a.this.d();
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        return;
                    case 6:
                        a aVar2 = a.this;
                        aVar2.a(1, com.baidu.mshield.utility.a.f(aVar2.d));
                        return;
                    case 7:
                        a.this.f();
                        a aVar3 = a.this;
                        aVar3.a(1, com.baidu.mshield.utility.a.f(aVar3.d));
                        return;
                    case 8:
                        a aVar4 = a.this;
                        aVar4.a(3, com.baidu.mshield.utility.a.f(aVar4.d));
                        return;
                    case 9:
                        a.this.a(0, 2);
                        return;
                    case 10:
                        int f = com.baidu.mshield.utility.a.f(a.this.d);
                        if (2 == f) {
                            com.baidu.mshield.b.c.a.b("sj-trigger report wifi ");
                            if (com.baidu.mshield.rp.b.a.a(a.this.d).b() >= com.baidu.mshield.sharedpreferences.a.a(a.this.d).A()) {
                                com.baidu.mshield.b.c.a.b("sj-trigger reportrc condi");
                                a.this.a(0, f);
                                return;
                            }
                            List<com.baidu.mshield.rp.c.a> a2 = com.baidu.mshield.rp.b.a.a(a.this.d).a(true, f);
                            com.baidu.mshield.b.c.a.b("sj-trigger report Dela " + a2.size());
                            if (a2.size() > 0) {
                                com.baidu.mshield.b.c.a.b("sj-trigger reportde condi");
                                a.this.a(0, f);
                                return;
                            }
                            return;
                        }
                        if (1 == f) {
                            com.baidu.mshield.b.c.a.b("sj-trigger reportde re");
                            a.this.a(4, f);
                            return;
                        }
                        return;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.e.a(new JSONArray().put(com.baidu.mshield.utility.a.a(a.this.d, new JSONObject(valueOf2))).toString(), a.this.a(new JSONObject(valueOf2)), "3")) {
                            com.baidu.mshield.utility.a.a(a.this.d, valueOf2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
    }

    public a(Context context) {
        this.d = context.getApplicationContext();
        this.c = com.baidu.mshield.sharedpreferences.a.a(context);
        this.e = new com.baidu.mshield.rp.d.a.a(this.d);
    }

    public final void f() {
        try {
            List<com.baidu.mshield.rp.a.a> u = this.c.u();
            if (u == null) {
                return;
            }
            Iterator<com.baidu.mshield.rp.a.a> it = u.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void a() {
        Message message = new Message();
        message.what = 7;
        a(message);
    }

    public final void b() {
        this.e.a();
        this.c.b(System.currentTimeMillis());
    }

    public final void c() {
        if (System.currentTimeMillis() - this.c.E() < 86400000) {
            return;
        }
        b();
    }

    public final void d() {
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(this.d);
            int v = a2.v();
            com.baidu.mshield.b.c.a.b(" 2" + Integer.toString(v));
            long currentTimeMillis = System.currentTimeMillis() - a2.w();
            long j = (long) (v * 3600000);
            if (currentTimeMillis >= j) {
                b.a(this.d).b();
                com.baidu.mshield.utility.a.a(this.d, j);
                a2.a(System.currentTimeMillis());
            } else {
                com.baidu.mshield.utility.a.a(this.d, j - currentTimeMillis);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public final boolean e() {
        com.baidu.mshield.b.c.a.b("checkReportFail,sFailTime=" + f6383a);
        if (f6383a > 0) {
            if (System.currentTimeMillis() - f6383a < 300000) {
                com.baidu.mshield.b.c.a.b("checkReportFail:false");
                return false;
            }
            f6383a = 0L;
        }
        com.baidu.mshield.b.c.a.b("checkReportFail:true");
        return true;
    }

    public final List<com.baidu.mshield.rp.c.a> b(int i, int i2) {
        if (i == 0 && i2 == 2) {
            return com.baidu.mshield.rp.b.a.a(this.d).b(i2);
        }
        return null;
    }

    public final void a(int i, int i2) {
        List<com.baidu.mshield.rp.c.a> b;
        try {
            if (i2 == 0) {
                com.baidu.mshield.b.c.a.b("sj-trigger EVENT_NETWORK_NONE ");
                return;
            }
            if (i == 1) {
                b = com.baidu.mshield.rp.b.a.a(this.d).a();
                if (1 == i2) {
                    com.baidu.mshield.b.c.a.b("sj-trigger report 3g " + b.size());
                }
            } else if (i == 3) {
                b = com.baidu.mshield.rp.b.a.a(this.d).a(false, i2);
            } else if (i == 4) {
                b = com.baidu.mshield.rp.b.a.a(this.d).a(true, i2);
                com.baidu.mshield.b.c.a.b("sj-trigger report 3g to report " + b.size());
            } else {
                b = com.baidu.mshield.rp.b.a.a(this.d).b(i2);
            }
            if (b != null && b.size() > 0) {
                long F = this.c.F();
                long currentTimeMillis = System.currentTimeMillis();
                long G = this.c.G();
                int C = this.c.C();
                if (G == 0) {
                    this.c.d(currentTimeMillis);
                    G = currentTimeMillis;
                }
                com.baidu.mshield.b.c.a.b("begintime : " + currentTimeMillis);
                com.baidu.mshield.b.c.a.b("last rp len : " + F);
                if (currentTimeMillis - G < 86400000) {
                    if (i == 3) {
                        int J = this.c.J();
                        if (J >= 5) {
                            return;
                        } else {
                            this.c.o(J + 1);
                        }
                    }
                    if (F > C * 1048576) {
                        com.baidu.mshield.b.c.a.b("rp over limit : maxday :  : " + F);
                        return;
                    }
                } else {
                    this.c.c(0L);
                    this.c.d(currentTimeMillis);
                    if (i == 3) {
                        this.c.o(0);
                    }
                }
                a(b, i2, F);
                List<com.baidu.mshield.rp.c.a> b2 = b(i, i2);
                while (b2 != null && b2.size() != 0) {
                    a(b2, i2, F);
                    if (!e()) {
                        com.baidu.mshield.b.c.a.b("324 checkReportFail");
                        return;
                    }
                    b2 = b(i, i2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(com.baidu.mshield.rp.a.a aVar) {
        try {
            String m = this.c.m(aVar.e);
            com.baidu.mshield.rp.c.a aVar2 = new com.baidu.mshield.rp.c.a();
            aVar2.b = aVar.e;
            aVar2.g = 0;
            aVar2.c = 1;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.d = com.baidu.mshield.utility.a.a(this.d, aVar, m, false).toString();
            com.baidu.mshield.rp.b.a.a(this.d).a(aVar2);
            this.c.a(aVar.e, true);
            String a2 = com.baidu.mshield.b.f.e.a(com.baidu.mshield.utility.a.e(this.d).toString());
            if (com.baidu.mshield.rp.b.a.a(this.d).b(a2)) {
                aVar2.b = "1067001";
                Context context = this.d;
                aVar2.d = com.baidu.mshield.utility.a.a(context, aVar.f6378a, aVar.c, "1067001", com.baidu.mshield.utility.a.e(context).toString()).toString();
                com.baidu.mshield.rp.b.a.a(this.d).a(aVar2);
                com.baidu.mshield.rp.b.a.a(this.d).a(a2);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void a(boolean z) {
        Message message = new Message();
        message.what = 5;
        a(message);
    }

    public void a(Message message) {
        this.b.sendMessage(message);
    }

    public final String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 != null && jSONObject2.has(II0xO0.f26834o0IXXIx)) {
                return jSONObject2.optString(II0xO0.f26834o0IXXIx, "");
            }
            return null;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    public final void a(List<com.baidu.mshield.rp.c.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        try {
            int B = this.c.B();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.mshield.rp.c.a> it = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.mshield.rp.c.a next = it.next();
                try {
                    String jSONObject2 = com.baidu.mshield.utility.a.a(this.d, new JSONObject(next.d)).toString();
                    try {
                        jSONObject = new JSONObject(jSONObject2);
                        length = jSONObject2.length() + i2;
                    } catch (Throwable th) {
                        com.baidu.mshield.utility.a.a(th);
                    }
                } catch (Throwable th2) {
                    com.baidu.mshield.utility.a.a(th2);
                }
                if (length >= 1048576 * B) {
                    com.baidu.mshield.b.c.a.b("rp once over limit : maxOnece : " + B + " : " + length);
                    break;
                }
                arrayList.add(Integer.valueOf(next.f6380a));
                arrayList2.add(new com.baidu.mshield.rp.c.b(jSONObject, next.j, next.f6380a));
                i2 = length;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                com.baidu.mshield.rp.c.b bVar = (com.baidu.mshield.rp.c.b) arrayList2.get(i3);
                if (bVar != null) {
                    String b = bVar.b();
                    if (TextUtils.isEmpty(b)) {
                        jSONArray.put(bVar.a());
                        arrayList3.add(Integer.valueOf(bVar.c()));
                    } else {
                        if (hashMap.containsKey(b)) {
                            JSONArray jSONArray2 = (JSONArray) hashMap.get(b);
                            if (jSONArray2 == null) {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(bVar.a());
                            hashMap.put(b, jSONArray2);
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(bVar.a());
                            hashMap.put(b, jSONArray3);
                        }
                        ArrayList arrayList4 = (ArrayList) hashMap2.get(b);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(Integer.valueOf(bVar.c()));
                        hashMap2.put(b, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.e.a(jSONArray.toString(), null, "1")) {
                    com.baidu.mshield.rp.b.a.a(this.d).a(arrayList3);
                } else {
                    f6383a = System.currentTimeMillis();
                    com.baidu.mshield.b.c.a.b("427 report fail,sFailTime = " + f6383a);
                }
            }
            if (hashMap.size() > 0) {
                for (String str : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.e.a(jSONArray4.toString(), str, "2")) {
                            com.baidu.mshield.rp.b.a.a(this.d).a((List<Integer>) hashMap2.get(str));
                        } else {
                            f6383a = System.currentTimeMillis();
                            com.baidu.mshield.b.c.a.b("441 report fail,sFailTime = " + f6383a);
                        }
                    }
                }
            }
            com.baidu.mshield.rp.b.a.a(this.d).c();
            if (2 != i) {
                this.c.c(i2 + j);
            }
        } catch (Throwable th3) {
            com.baidu.mshield.utility.a.a(th3);
        }
    }

    public final void a(com.baidu.mshield.rp.a.a aVar) {
        try {
            String a2 = com.baidu.mshield.utility.a.a();
            if ("4.2.2".equals(this.c.D())) {
                com.baidu.mshield.b.c.a.b("same version=4.2.2");
                if (this.c.j(aVar.d).equals(a2)) {
                    com.baidu.mshield.b.c.a.b("same version has reported!");
                    return;
                }
                com.baidu.mshield.b.c.a.b("same version new report");
            } else {
                com.baidu.mshield.b.c.a.b("new version set=4.2.2");
                this.c.k("4.2.2");
            }
            String m = this.c.m(aVar.d);
            com.baidu.mshield.rp.c.a aVar2 = new com.baidu.mshield.rp.c.a();
            aVar2.b = aVar.d;
            aVar2.g = 0;
            aVar2.c = 2;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.i = 5;
            aVar2.d = com.baidu.mshield.utility.a.a(this.d, aVar, m, true).toString();
            com.baidu.mshield.rp.b.a.a(this.d).a(aVar2);
            String a3 = com.baidu.mshield.b.f.e.a(com.baidu.mshield.utility.a.e(this.d).toString());
            if (com.baidu.mshield.rp.b.a.a(this.d).b(a3)) {
                aVar2.b = "1067001";
                aVar2.i = 0;
                Context context = this.d;
                aVar2.d = com.baidu.mshield.utility.a.a(context, aVar.f6378a, aVar.c, "1067001", com.baidu.mshield.utility.a.e(context).toString()).toString();
                com.baidu.mshield.rp.b.a.a(this.d).a(aVar2);
                com.baidu.mshield.rp.b.a.a(this.d).a(a3);
            }
            this.c.b(aVar.d, a2);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
