package com.baidu.platform.comapi.logstatistics;

import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private NALogStatistics f9595a;
    private ArrayList<c> b;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f9596a = new d();
    }

    public static d a() {
        return a.f9596a;
    }

    private boolean b() {
        if (this.f9595a == null) {
            this.f9595a = new NALogStatistics();
            return true;
        }
        return true;
    }

    private d() {
        this.f9595a = null;
        this.b = new ArrayList<>();
        b();
    }

    public void a(int i, int i2, String str, Map<String, Object> map) {
        String str2;
        if (map == null || map.size() <= 0) {
            str2 = null;
        } else {
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            for (String str3 : map.keySet()) {
                Object obj = map.get(str3);
                if (obj != null) {
                    jsonBuilder.key(str3).value(obj);
                }
            }
            jsonBuilder.endObject();
            str2 = jsonBuilder.getJson();
        }
        a(i, i2, str, str2);
    }

    public boolean a(int i, int i2, String str, String str2) {
        if (this.f9595a == null) {
            return false;
        }
        if (JNIInitializer.isDebug() || JNIInitializer.isBaseLineRelease()) {
            a(new b(i, i2, str, str2));
        }
        return this.f9595a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
    }

    public boolean a(b bVar) {
        ArrayList<c> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<c> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        return false;
    }
}
