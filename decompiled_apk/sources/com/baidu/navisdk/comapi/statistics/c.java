package com.baidu.navisdk.comapi.statistics;

import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o0oIxXOx.oO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {
    private long e;

    /* renamed from: a, reason: collision with root package name */
    private List<l> f6734a = new ArrayList();
    private List<l> b = new ArrayList();
    private boolean c = false;
    private int d = 0;
    private UUID f = UUID.randomUUID();

    private void d(String str) {
        try {
            s.a(str);
        } catch (IOException e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("Statistics_NaviStatHelper", e);
                e.printStackTrace();
            }
        }
    }

    private boolean e(List<l> list) {
        boolean z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_NaviStatHelper", "pushStatisticsToService->");
        }
        if (list != null && list.size() != 0) {
            this.d = 0;
            ArrayList<l> arrayList = new ArrayList();
            if (this.f6734a.isEmpty()) {
                b(this.f6734a);
                this.f6734a.add(new i("isSession", "0"));
            }
            a(this.b);
            List<l> list2 = this.b;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            arrayList.addAll(this.f6734a);
            arrayList.addAll(list);
            com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
            eVar.f9300a = false;
            HashMap<String, String> a2 = com.baidu.navisdk.util.http.center.c.a(arrayList);
            LogUtil.e("Statistics_NaviStatHelper", "STAT_URL = " + com.baidu.navisdk.util.http.b.d().b("NaviStat"));
            com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("NaviStat"), a2, new a(), eVar);
            int i = this.d;
            if ((i == 200 || i == -1) && (z = LogUtil.LOGGABLE) && z) {
                StringBuilder sb = new StringBuilder("重要统计项上传成功");
                for (l lVar : arrayList) {
                    sb.append(lVar.a());
                    sb.append(":");
                    sb.append(lVar.b());
                    sb.append(" ");
                }
                LogUtil.e("Statistics_NaviStatHelper", sb.toString());
            }
            int i2 = this.d;
            if (i2 == 200 || i2 == -1) {
                f(list);
            }
            int i3 = this.d;
            if (i3 != 200 && i3 != -1) {
                return false;
            }
            return true;
        }
        LogUtil.e("Statistics_NaviStatHelper", "push params is null");
        return false;
    }

    private void f(List<l> list) {
        boolean z = LogUtil.LOGGABLE;
    }

    public void b(List<l> list) {
        LogUtil.e("Statistics_NaviStatHelper", "initStatParamsPrefix start");
        list.add(new i("sv", a0.k() + com.baidu.navisdk.framework.b.d()));
        list.add(new i(oO.f31192XO, "Android"));
        list.add(new i("ov", a0.b));
        list.add(new i(t.r, a0.g()));
        list.add(new i("ch", a0.d()));
        list.add(new i("mb", a0.f9218a));
        list.add(new i("cuid", a0.e()));
        list.add(new i("brand", a0.b()));
        list.add(new i("traceid", this.f.toString()));
        if (!j.d()) {
            list.add(new i("sdkver", j.b()));
        }
        LogUtil.e("Statistics_NaviStatHelper", "initStatParamsPrefix end " + list.size());
    }

    public boolean c(List<String> list) {
        if (!this.c) {
            b();
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(new i("item" + String.valueOf(i), (String) arrayList.get(i)));
        }
        return e(arrayList2);
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {
        public a() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("Statistics_NaviStatHelper", "onSuccess().statusCode=" + i);
            c.this.d = i;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("Statistics_NaviStatHelper", "onFailure().statusCode=" + i);
            c.this.d = i;
        }
    }

    public void a(List<l> list) {
        if (list == null) {
            return;
        }
        list.clear();
        list.add(new i("area", d() + ""));
        list.add(new i("cityid", c() + ""));
    }

    private int d() {
        com.baidu.navisdk.framework.interfaces.g d = com.baidu.navisdk.framework.interfaces.c.p().d();
        return (d == null || !d.i()) ? 0 : 1;
    }

    public HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Statistics_NaviStatHelper", "getHistoryStateListFromLocal->files == null");
                }
                return hashMap;
            }
            for (File file2 : listFiles) {
                long lastModified = file2.lastModified();
                if (!file2.isDirectory() && lastModified <= this.e) {
                    long length = file2.length();
                    if (length > 0 && length <= 512000) {
                        String e = s.e(file2.getAbsolutePath());
                        if (!l0.c(e)) {
                            hashMap.put(file2.getAbsolutePath(), e);
                        }
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        d(absolutePath);
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("Statistics_NaviStatHelper", "getHistoryStateListFromLocal->删除异常文件:" + absolutePath);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private void d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                s.a(list.get(i));
            } catch (IOException e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                    LogUtil.printException("Statistics_NaviStatHelper", e);
                }
            }
        }
    }

    private int c() {
        return com.baidu.navisdk.framework.b.A();
    }

    public void c(String str) {
        HashMap<String, String> a2 = a(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics_NaviStatHelper", "uploadHistoryStatistics ,上报" + str + "文件，共" + a2.size() + "条历史统计");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (a2.size() > 0) {
            int d = b.f().a().d();
            int i = 0;
            for (Map.Entry<String, String> entry : a2.entrySet()) {
                String value = entry.getValue();
                String key = entry.getKey();
                try {
                    new JSONObject(value);
                    int a3 = l0.a(value);
                    if (i + a3 >= d) {
                        boolean c = c(arrayList);
                        LogUtil.e("Statistics_NaviStatHelper", "uploadHistoryStatistics ,上报内容超过最大限制" + d + "KB,立即上报！result :" + c);
                        if (c) {
                            d(arrayList2);
                        }
                        arrayList.clear();
                        arrayList2.clear();
                        i = 0;
                    }
                    arrayList.add(value);
                    arrayList2.add(key);
                    i += a3;
                } catch (JSONException unused) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Statistics_NaviStatHelper", "uploadHistoryStatistics->" + key + "不是json格式，删除！, statStr=" + value);
                    }
                    try {
                        s.a(key);
                    } catch (IOException e) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.printException("Statistics_NaviStatHelper", e);
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean c2 = c(arrayList);
            LogUtil.e("Statistics_NaviStatHelper", "uploadHistoryStatistics，上报剩余历史统计 result :" + c2);
            if (c2) {
                d(arrayList2);
            }
            arrayList.clear();
            arrayList2.clear();
        }
    }

    public void b() {
        if (this.c) {
            return;
        }
        this.e = System.currentTimeMillis();
        this.c = true;
    }

    public boolean b(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return c(arrayList);
    }

    public String a() {
        return m0.j().b() + "/Statistics";
    }

    public void a(e eVar) {
        if (eVar.d() > 0) {
            if (y.d(com.baidu.navisdk.framework.a.c().a())) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                for (g gVar : eVar.c()) {
                    int a2 = l0.a(gVar.c());
                    int d = b.f().a().d();
                    if (i + a2 >= d) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("Statistics_NaviStatHelper", "pushSession ,上报内容超过最大限制" + d + "KB,立即上报");
                        }
                        if (c(arrayList2)) {
                            d(arrayList);
                        }
                        arrayList.clear();
                        arrayList2.clear();
                        i = 0;
                    }
                    arrayList.add(gVar.a());
                    arrayList2.add(gVar.c());
                    i += a2;
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                boolean c = c(arrayList2);
                LogUtil.e("Statistics_NaviStatHelper", "pushSession，上报剩余历史统计 result :" + c);
                if (c) {
                    d(arrayList);
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Statistics_NaviStatHelper", "pushSession->无网，统计上报失败!");
            }
        }
    }
}
