package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f26615a = new HashMap<>();
    protected HashMap<String, Object> b = new HashMap<>();
    private HashMap<String, Object> e = new HashMap<>();
    protected String c = "GBK";
    k d = new k();

    public static void oIX0oI(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (obj.getClass().getComponentType().toString().equals("byte")) {
                    if (Array.getLength(obj) > 0) {
                        arrayList.add("java.util.List");
                        obj = Array.get(obj, 0);
                    } else {
                        arrayList.add("Array");
                        arrayList.add(LocationInfo.NA);
                        return;
                    }
                } else {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
            } else if (!(obj instanceof Array)) {
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() > 0) {
                        obj = list.get(0);
                    } else {
                        arrayList.add(LocationInfo.NA);
                        return;
                    }
                } else if (obj instanceof Map) {
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() > 0) {
                        Object next = map.keySet().iterator().next();
                        obj = map.get(next);
                        arrayList.add(next.getClass().getName());
                    } else {
                        arrayList.add(LocationInfo.NA);
                        arrayList.add(LocationInfo.NA);
                        return;
                    }
                } else {
                    arrayList.add(obj.getClass().getName());
                    return;
                }
            } else {
                throw new IllegalArgumentException("can not support Array, please use List");
            }
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                l lVar = new l();
                lVar.a(this.c);
                lVar.a(t, 0);
                byte[] a2 = n.a(lVar.f26613a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList arrayList = new ArrayList(1);
                oIX0oI(arrayList, t);
                hashMap.put(a.a(arrayList), a2);
                this.e.remove(str);
                this.f26615a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.c);
        lVar.a((Map) this.f26615a, 0);
        return n.a(lVar.f26613a);
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
        this.d.a(this.c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f26615a = this.d.a((Map) hashMap, 0, false);
    }
}
