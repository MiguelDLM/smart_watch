package com.baidu.navcore.http;

import XXO0.oIX0oI;
import com.baidu.navisdk.util.http.center.g;
import com.baidu.navisdk.util.http.center.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    protected final ConcurrentHashMap<String, String> f6459a = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, List<a>> c = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, Object> d = new ConcurrentHashMap<>();

    /* loaded from: classes7.dex */
    public static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final File f6460a;

        public a(File file, String str, String str2) {
            this.f6460a = file;
        }
    }

    public d(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f6459a.put(str, str2);
    }

    public String b() {
        return g.a(c());
    }

    public List<i> c() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.f6459a.entrySet()) {
            linkedList.add(new i(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(a((String) null, this.d));
        return linkedList;
    }

    public ConcurrentHashMap<String, String> d() {
        return this.f6459a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f6459a.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, a> entry2 : this.b.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, List<a>> entry3 : this.c.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILES(SIZE=");
            sb.append(entry3.getValue().size());
            sb.append(oIX0oI.I0Io.f4095I0Io);
        }
        for (i iVar : a((String) null, this.d)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(iVar.a());
            sb.append("=");
            sb.append(iVar.b());
        }
        return sb.toString();
    }

    public void a(String str, File file) throws FileNotFoundException {
        a(str, file, null, null);
    }

    public void a(String str, File file, String str2, String str3) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        }
        if (str != null) {
            this.b.put(str, new a(file, str2, str3));
        }
    }

    private List<i> a(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(a(str == null ? (String) obj3 : String.format(Locale.US, "%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.addAll(a(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i)), list.get(i)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.addAll(a(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i2)), objArr[i2]));
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedList.addAll(a(str, it.next()));
            }
        } else {
            linkedList.add(new i(str, obj.toString()));
        }
        return linkedList;
    }

    public ConcurrentHashMap<String, a> a() {
        return this.b;
    }
}
