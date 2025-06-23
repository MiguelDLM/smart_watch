package com.baidu.navisdk.ui.routeguide.model;

import android.os.Handler;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.LogUtil;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static volatile a g;
    public boolean c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<com.baidu.navisdk.model.datastruct.r> f8926a = new ArrayList<>();
    public int b = 0;
    public boolean d = false;
    private Handler e = new com.baidu.navisdk.util.worker.loop.a(RGFSMTable.FsmState.ArriveDest);
    private Runnable f = new RunnableC0465a();

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0465a implements Runnable {
        public RunnableC0465a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.c = true;
            aVar.a(-2, "请求超时10s");
        }
    }

    private a() {
    }

    public static a c() {
        if (g == null) {
            synchronized (a.class) {
                try {
                    if (g == null) {
                        g = new a();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public void b() {
        this.b = -1;
        this.d = false;
        this.f8926a.clear();
    }

    public void a(int i) {
        this.b = i;
    }

    public void a() {
        this.f8926a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.e.removeCallbacks(this.f);
        if (i == 200) {
            try {
                if (a(str)) {
                    com.baidu.navisdk.ui.routeguide.control.f.k().f();
                } else {
                    com.baidu.navisdk.ui.routeguide.control.f.k().b(-3);
                }
                return;
            } catch (Exception e) {
                LogUtil.printException("handleParkResponse exception", e);
                com.baidu.navisdk.ui.routeguide.control.f.k().f();
                return;
            }
        }
        com.baidu.navisdk.ui.routeguide.control.f.k().b(i);
    }

    private boolean a(String str) throws JSONException {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkModel", "parseParkData() --> jsData = " + str);
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("errno") > 0) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        int min = Math.min(optJSONArray.length(), 3);
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= min) {
                break;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            com.baidu.navisdk.model.datastruct.r rVar = new com.baidu.navisdk.model.datastruct.r();
            rVar.m = optJSONObject.optString("poi_uid", "");
            rVar.j = optJSONObject.optString("name", "");
            rVar.c = com.baidu.navisdk.util.common.o.a(Double.valueOf(optJSONObject.optString("lng", "0")).doubleValue(), Double.valueOf(optJSONObject.optString("lat", "0")).doubleValue());
            rVar.g = optJSONObject.optInt(xOxOoo.f15470o00, -1);
            rVar.e = optJSONObject.optInt("parktotal", -1);
            rVar.i = optJSONObject.optString("busine_hours", null);
            rVar.n = optJSONObject.optString("price", "");
            rVar.f = optJSONObject.optInt("parkleft", -1);
            rVar.p = optJSONObject.optInt("parktype", -1);
            rVar.o = optJSONObject.optInt("score", 1);
            rVar.q = optJSONObject.optString("park_des", "");
            if (optJSONObject.optInt("is_reservable", 0) != 1) {
                z = false;
            }
            rVar.r = z;
            this.f8926a.add(rVar);
            i++;
        }
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.printList("RGArriveDestParkModel", "parseParkData", "mDestParkPoiList", this.f8926a);
        }
        return true;
    }
}
