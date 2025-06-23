package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.smartv3.ble.ProductManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18413a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 0;
    public static final int e = 8;
    public static final int f = 1;
    public static final int g = 3;
    public static final int h = 4;
    private static long o;
    private Context j;
    private q k;
    private t l;
    private File m;
    private dp n;
    private int p;
    private boolean r;
    private int q = 0;
    List<Integer> i = new ArrayList();
    private Map<Integer, a> s = new HashMap();

    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f18414a;

        public a(int i) {
            this.f18414a = i;
        }
    }

    public u(Context context, int i, boolean z) {
        this.p = 0;
        this.r = false;
        this.j = context;
        this.k = q.a(context);
        this.l = t.a(context);
        this.n = dp.a(context);
        this.m = new File(context.getFilesDir(), ".tmp");
        this.p = i;
        this.r = z;
    }

    public JSONObject a() {
        try {
            String str = cu.f18366a + cu.g;
            String a2 = cv.a(this.j);
            if (!TextUtils.isEmpty(a2)) {
                str = str + LocationInfo.NA + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c2 = cv.c(this.j);
            if (c2 != null) {
                jSONObject.put("data", new bn(this.j).c(c2.toString()));
            }
            l a3 = l.a(this.j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a3.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt != -7) {
                    return null;
                }
                dp.a(this.j).a(dp.f18393a, 1, false);
                return null;
            }
            String a4 = new bn(this.j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a4)) {
                if (this.q == 0) {
                    this.q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a4);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dp dpVar = this.n;
            if (dpVar == null) {
                return null;
            }
            dpVar.a(dp.b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z;
        try {
            synchronized (u.class) {
                try {
                    int i = this.p;
                    if (i != 1 && i != 2 && i != 4 && !this.r && System.currentTimeMillis() - o < 300000) {
                        return;
                    }
                    this.l.d();
                    o = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.n.a(dp.b)) - (this.n.a(dp.c, 6) * 3600000) > 0) {
                        List<s> a2 = this.l.a();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<s> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject a3 = a();
                        if (a3 != null) {
                            boolean z2 = false;
                            try {
                                boolean b2 = dm.b(this.j);
                                Iterator<String> keys = a3.keys();
                                HashSet hashSet = new HashSet();
                                boolean z3 = false;
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (b2 && next.endsWith("64")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                    } else if (!b2 && next.endsWith("32")) {
                                        if (next.length() <= 3) {
                                            z3 = true;
                                        } else {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                            z3 = true;
                                        }
                                    } else {
                                        if (b2 && next.endsWith(ProductManager.OxIX)) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                z3 = true;
                                            }
                                        } else if (!b2 && next.endsWith("v7")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                            }
                                        }
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    Iterator it2 = hashSet.iterator();
                                    while (it2.hasNext()) {
                                        a3.remove((String) it2.next());
                                    }
                                }
                                z2 = z3;
                            } catch (Throwable unused) {
                            }
                            Iterator<String> keys2 = a3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                s a4 = o.a(a3.optJSONObject(next2));
                                if (a4 != null) {
                                    if (z2 && !a4.y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith(ProductManager.OxIX))) {
                                        a4.y = true;
                                    }
                                    if (a4.v) {
                                        arrayList4.add(next2);
                                    }
                                    if (!a4.y) {
                                        arrayList3.add(a4);
                                    }
                                    int indexOf = a2.indexOf(a4);
                                    if (indexOf >= 0 && a4.y) {
                                        s sVar = a2.get(indexOf);
                                        if (dn.b(a4.d, sVar.d)) {
                                            int i2 = a4.x;
                                            if (i2 != sVar.x) {
                                                this.l.c(a4.f18410a, i2);
                                            }
                                            if (!this.l.d(a4.f18410a)) {
                                                arrayList2.add(a4);
                                            }
                                            it = keys2;
                                            jSONObject = a3;
                                            z = z2;
                                        } else {
                                            jSONObject = a3;
                                            z = z2;
                                            it = keys2;
                                            this.n.a(dp.b, System.currentTimeMillis(), true);
                                            int i3 = a4.x;
                                            if (i3 != sVar.x) {
                                                this.l.c(a4.f18410a, i3);
                                            }
                                            arrayList.add(a4);
                                        }
                                        a2.remove(indexOf);
                                    } else {
                                        it = keys2;
                                        jSONObject = a3;
                                        z = z2;
                                        if (a4.y) {
                                            arrayList2.add(a4);
                                        }
                                    }
                                    a3 = jSONObject;
                                    z2 = z;
                                    keys2 = it;
                                }
                            }
                            for (s sVar2 : a2) {
                                if (!arrayList4.contains(sVar2.c)) {
                                    List<Integer> list = this.i;
                                    if (list != null) {
                                        list.add(Integer.valueOf(sVar2.f18410a));
                                    }
                                    this.k.a(sVar2.c);
                                }
                            }
                            for (s sVar3 : arrayList3) {
                                if (!arrayList4.contains(sVar3.c)) {
                                    List<Integer> list2 = this.i;
                                    if (list2 != null) {
                                        list2.add(Integer.valueOf(sVar3.f18410a));
                                    }
                                    this.k.a(sVar3.c);
                                }
                            }
                            ArrayList<s> arrayList5 = new ArrayList();
                            if (arrayList2.size() != 0) {
                                arrayList5.addAll(arrayList2);
                            }
                            if (arrayList.size() != 0) {
                                arrayList5.addAll(arrayList);
                            }
                            for (s sVar4 : arrayList5) {
                                if (sVar4 != null) {
                                    if (arrayList.contains(sVar4)) {
                                        this.k.a(sVar4.f18410a, sVar4.d, (PackageInfo) null);
                                    } else if (arrayList2.contains(sVar4)) {
                                        a(sVar4);
                                    }
                                }
                            }
                        } else {
                            throw new Exception("pluginJsonObject is null ");
                        }
                    } else {
                        this.k.c();
                        this.l.b();
                    }
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.k.c();
            this.l.b();
        }
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.j) && sVar.j.length() >= 10) {
                if (!this.m.exists()) {
                    this.m.mkdir();
                }
                File file = new File(this.m, sVar.f18410a + HelpFormatter.DEFAULT_OPT_PREFIX + sVar.d + ".tmp");
                File file2 = new File(this.m, sVar.f18410a + HelpFormatter.DEFAULT_OPT_PREFIX + sVar.d + OTAManager.OTA_ZIP_SUFFIX);
                boolean a2 = l.a(this.j).a(sVar.i, file);
                if (!a2) {
                    a2 = l.a(this.j).a(sVar.i, file);
                }
                if (a2) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int c2 = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c2 != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        a2 = false;
                    }
                    if (c2 == 0 && file.exists()) {
                        file.delete();
                    }
                } else {
                    this.s.put(Integer.valueOf(sVar.f18410a), new a(3));
                }
                String a3 = f.a(file2);
                if (a2 && sVar.j.equals(a3)) {
                    dn.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.e = file2.getAbsolutePath();
                    if (this.k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f18410a))) {
                            this.s.put(Integer.valueOf(sVar.f18410a), new a(1));
                        }
                        this.n.a(dp.b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f18410a))) {
                        this.s.put(Integer.valueOf(sVar.f18410a), new a(4));
                    }
                    this.k.a(sVar.f18410a, sVar.d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    file.length();
                    file.delete();
                }
                this.k.a(sVar.f18410a, sVar.d, (PackageInfo) null);
                return;
            }
            this.k.a(sVar.f18410a, sVar.d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.k.a(sVar.f18410a, sVar.d, (PackageInfo) null);
        }
    }
}
