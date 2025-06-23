package com.kuaishou.weapon.p0;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class z {
    private Set<String> e = new HashSet();
    private Set<String> f = new HashSet();
    private Set<String> g = new HashSet();
    private Set<String> h = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private String f18431a = i.a("f118f1f9431de3a626df48d7302911", "0820");
    private String b = i.a("f118f1ef4616f3fc27d1", "0820");
    private String c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");
    private String d = i.a("fc03e7a44510", "0820");

    /* JADX WARN: Code restructure failed: missing block: B:183:0x01f2, code lost:
    
        if (r1 == null) goto L121;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONArray a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.z.a(android.content.Context):org.json.JSONArray");
    }

    public Set<String> b() {
        try {
            Set<String> set = this.g;
            if (set != null && set.size() > 0) {
                return this.g;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            Set<String> set = this.h;
            if (set != null && set.size() > 0) {
                return this.h;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            Set<String> set = this.e;
            if (set != null && set.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (String str : this.e) {
                    if (str.contains(this.f18431a)) {
                        jSONObject.put("0", 1);
                    } else if (str.contains(this.b)) {
                        jSONObject.put("1", 1);
                    } else if (str.contains(this.c)) {
                        jSONObject.put("2", 1);
                    }
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            Set<String> set = this.e;
            if (set != null && set.size() > 0) {
                for (String str : this.e) {
                    if (str.endsWith("dex")) {
                        hashSet.add(str);
                    }
                    if (hashSet.size() > 5) {
                        break;
                    }
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int a() {
        try {
            Set<String> set = this.f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f.size();
        } catch (Exception unused) {
            return 0;
        }
    }
}
