package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static a b;

    /* renamed from: a, reason: collision with root package name */
    private NAFavorite f6165a = null;
    private boolean c = false;
    private boolean d = false;
    private Vector<String> e = null;
    private Vector<String> f = null;
    private boolean g = false;
    private c h;
    private b i;

    /* renamed from: com.baidu.mapsdkplatform.comapi.favrite.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0141a implements Comparator<String> {
        public C0141a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        private long b;
        private long c;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.c = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.c - this.b > 1000;
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        private String b;
        private long c;
        private long d;

        private c() {
            this.c = 5000L;
            this.d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return TextUtils.isEmpty(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.b = str;
            this.d = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.b;
        }
    }

    private a() {
        this.h = new c();
        this.i = new b();
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        a aVar = new a();
                        b = aVar;
                        aVar.h();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static boolean g() {
        NAFavorite nAFavorite;
        a aVar = b;
        if (aVar != null && (nAFavorite = aVar.f6165a) != null && nAFavorite.d()) {
            return true;
        }
        return false;
    }

    private boolean h() {
        if (this.f6165a == null) {
            NAFavorite nAFavorite = new NAFavorite();
            this.f6165a = nAFavorite;
            if (nAFavorite.a() == 0) {
                this.f6165a = null;
                return false;
            }
            j();
            i();
        }
        return true;
    }

    private boolean i() {
        if (this.f6165a == null) {
            return false;
        }
        String str = SysOSUtil.getModuleFileName() + "/";
        this.f6165a.a(1);
        return this.f6165a.a(str, "fav_poi", "fifo", 10, 501, -1);
    }

    private void j() {
        this.c = false;
        this.d = false;
    }

    public void b() {
        a aVar = b;
        if (aVar != null) {
            NAFavorite nAFavorite = aVar.f6165a;
            if (nAFavorite != null) {
                nAFavorite.b();
                b.f6165a = null;
            }
            b = null;
        }
    }

    public synchronized boolean c() {
        if (this.f6165a == null) {
            return false;
        }
        j();
        boolean c2 = this.f6165a.c();
        g();
        return c2;
    }

    public ArrayList<String> d() {
        String b2;
        if (this.f6165a == null) {
            return null;
        }
        if (this.d && this.f != null) {
            return new ArrayList<>(this.f);
        }
        try {
            Bundle bundle = new Bundle();
            this.f6165a.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.f;
                if (vector == null) {
                    this.f = new Vector<>();
                } else {
                    vector.clear();
                }
                for (int i = 0; i < stringArray.length; i++) {
                    if (!stringArray[i].equals("data_version") && (b2 = this.f6165a.b(stringArray[i])) != null && !b2.equals("")) {
                        this.f.add(stringArray[i]);
                    }
                }
                if (this.f.size() > 0) {
                    try {
                        Collections.sort(this.f, new C0141a());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.d = true;
                }
            } else {
                Vector<String> vector2 = this.f;
                if (vector2 != null) {
                    vector2.clear();
                    this.f = null;
                }
            }
            Vector<String> vector3 = this.f;
            if (vector3 != null && !vector3.isEmpty()) {
                return new ArrayList<>(this.f);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<String> e() {
        if (this.f6165a == null) {
            return null;
        }
        if (this.c && this.e != null) {
            return new ArrayList<>(this.e);
        }
        try {
            Bundle bundle = new Bundle();
            this.f6165a.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.e;
                if (vector == null) {
                    this.e = new Vector<>();
                } else {
                    vector.clear();
                }
                for (String str : stringArray) {
                    if (!str.equals("data_version")) {
                        this.e.add(str);
                    }
                }
                if (this.e.size() > 0) {
                    try {
                        Collections.sort(this.e, new C0141a());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.c = true;
                }
            } else {
                Vector<String> vector2 = this.e;
                if (vector2 != null) {
                    vector2.clear();
                    this.e = null;
                }
            }
            Vector<String> vector3 = this.e;
            if (vector3 == null || vector3.size() == 0) {
                return null;
            }
            return new ArrayList<>(this.e);
        } catch (Exception unused) {
            return null;
        }
    }

    public String f() {
        String b2;
        if (!this.i.c() || this.h.c() || this.h.b()) {
            this.i.a();
            if (this.f6165a == null) {
                return null;
            }
            ArrayList<String> d = d();
            JSONObject jSONObject = new JSONObject();
            if (d != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = d.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next != null && !next.equals("data_version") && (b2 = this.f6165a.b(next)) != null && !b2.equals("")) {
                            JSONObject optJSONObject = new JSONObject(b2).optJSONObject("Fav_Sync");
                            optJSONObject.put("key", next);
                            jSONArray.put(i, optJSONObject);
                            i++;
                        }
                    }
                    if (i > 0) {
                        jSONObject.put("favcontents", jSONArray);
                        jSONObject.put("favpoinum", i);
                    }
                } catch (JSONException unused) {
                    return null;
                }
            }
            this.i.b();
            this.h.a(jSONObject.toString());
            return this.h.a();
        }
        return this.h.a();
    }

    public FavSyncPoi b(String str) {
        if (this.f6165a != null && str != null && !str.equals("")) {
            try {
                if (!c(str)) {
                    return null;
                }
                FavSyncPoi favSyncPoi = new FavSyncPoi();
                String b2 = this.f6165a.b(str);
                if (b2 != null && !b2.equals("")) {
                    JSONObject jSONObject = new JSONObject(b2);
                    JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
                    String optString = jSONObject.optString("Fav_Content");
                    favSyncPoi.b = optJSONObject.optString("uspoiname");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pt");
                    favSyncPoi.c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
                    favSyncPoi.e = optJSONObject.optString("ncityid");
                    favSyncPoi.f = optJSONObject.optString("uspoiuid");
                    favSyncPoi.g = optJSONObject.optInt("npoitype");
                    favSyncPoi.d = optJSONObject.optString("addr");
                    favSyncPoi.h = optJSONObject.optString("addtimesec");
                    favSyncPoi.i = optJSONObject.optBoolean("bdetail");
                    favSyncPoi.j = optString;
                    favSyncPoi.f6164a = str;
                    return favSyncPoi;
                }
                return null;
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public boolean c(String str) {
        return (this.f6165a == null || str == null || str.equals("") || !this.f6165a.c(str)) ? false : true;
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        if (this.f6165a == null) {
            return 0;
        }
        if (str != null && !str.equals("") && favSyncPoi != null) {
            j();
            ArrayList<String> e = e();
            if ((e != null ? e.size() : 0) + 1 > 500) {
                return -2;
            }
            if (e != null && e.size() > 0) {
                Iterator<String> it = e.iterator();
                while (it.hasNext()) {
                    FavSyncPoi b2 = b(it.next());
                    if (b2 != null && str.equals(b2.b)) {
                        return -1;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                favSyncPoi.b = str;
                String valueOf = String.valueOf(System.currentTimeMillis());
                String str2 = valueOf + "_" + favSyncPoi.hashCode();
                favSyncPoi.h = valueOf;
                favSyncPoi.f6164a = str2;
                jSONObject.put("bdetail", favSyncPoi.i);
                jSONObject.put("uspoiname", favSyncPoi.b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                jSONObject.put("pt", jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.e);
                jSONObject.put("npoitype", favSyncPoi.g);
                jSONObject.put("uspoiuid", favSyncPoi.f);
                jSONObject.put("addr", favSyncPoi.d);
                jSONObject.put("addtimesec", favSyncPoi.h);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.j);
                if (!this.f6165a.a(str2, jSONObject3.toString())) {
                    return 0;
                }
                j();
                return 1;
            } catch (JSONException unused) {
                return 0;
            } finally {
                g();
            }
        }
        return -1;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        boolean z = false;
        if (this.f6165a != null && str != null && !str.equals("") && favSyncPoi != null) {
            if (!c(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uspoiname", favSyncPoi.b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                jSONObject.put("pt", jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.e);
                jSONObject.put("npoitype", favSyncPoi.g);
                jSONObject.put("uspoiuid", favSyncPoi.f);
                jSONObject.put("addr", favSyncPoi.d);
                String valueOf = String.valueOf(System.currentTimeMillis());
                favSyncPoi.h = valueOf;
                jSONObject.put("addtimesec", valueOf);
                jSONObject.put("bdetail", false);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.j);
                j();
                NAFavorite nAFavorite = this.f6165a;
                if (nAFavorite != null) {
                    if (nAFavorite.b(str, jSONObject3.toString())) {
                        z = true;
                    }
                }
                return z;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    public synchronized boolean a(String str) {
        if (this.f6165a == null) {
            return false;
        }
        if (str != null && !str.equals("")) {
            if (!c(str)) {
                return false;
            }
            j();
            return this.f6165a.a(str);
        }
        return false;
    }
}
