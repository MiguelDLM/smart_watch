package com.baidu.navisdk.adapter.impl;

import com.baidu.navisdk.framework.interfaces.s;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.framework.interfaces.opendatasturct.a f6507a;
    private JSONObject b;
    private final com.baidu.navisdk.util.worker.f c;
    private final com.baidu.navisdk.util.worker.f d;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f {
        public a(String str, Object obj) {
            super(str, obj);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public Object execute() {
            JSONObject jSONObject = g.this.b;
            if (jSONObject != null) {
                try {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(jSONObject.toString());
                    s l = com.baidu.navisdk.framework.interfaces.c.p().l();
                    if (l != null) {
                        l.a(arrayList);
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f {
        public b(String str, Object obj) {
            super(str, obj);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public Object execute() {
            com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar = g.this.f6507a;
            if (aVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("gpsType", aVar.f6815a);
                    jSONObject.put("lat", aVar.m);
                    jSONObject.put("lon", aVar.l);
                    jSONObject.put("lat_mm", aVar.o);
                    jSONObject.put("lon_mm", aVar.n);
                    jSONObject.put("matchAreaType", aVar.f);
                    jSONObject.put("isViaduct", aVar.d);
                    jSONObject.put("isTunnel", aVar.e);
                    jSONObject.put("isFree", aVar.q);
                    jSONObject.put("dis_cross", aVar.b);
                    jSONObject.put("is_yaw_state", aVar.r);
                    jSONObject.put("cur_viaduct_state", aVar.k);
                    jSONObject.put("is_ori_in_poi", aVar.h);
                    jSONObject.put("is_match_in_poi", aVar.i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("navi_mm_result", jSONObject);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(jSONObject2.toString());
                    s l = com.baidu.navisdk.framework.interfaces.c.p().l();
                    if (l != null) {
                        l.a(arrayList);
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final g f6510a = new g(null);
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    private g() {
        this.c = new a("sendNaviExtraInfoToLoc", null);
        this.d = new b("sendNaviMMResultToLoc", null);
    }

    public static g a() {
        return c.f6510a;
    }

    public void a(com.baidu.navisdk.framework.interfaces.opendatasturct.b bVar) {
        if (bVar == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.d("BNTransferNaviInfoToLoc", "received motion state = " + bVar.f6816a);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("navi_motion_state", bVar.f6816a);
            this.b = jSONObject;
        } catch (Exception unused) {
            this.b = null;
        }
        if (this.b != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.c, true);
            com.baidu.navisdk.util.worker.c.a().c(this.c, new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.d("BNTransferNaviInfoToLoc", "received navi extrainfo  = " + jSONObject.toString());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("navi_extra_info", jSONObject);
            this.b = jSONObject2;
        } catch (Exception unused) {
            this.b = null;
        }
        if (this.b != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.c, true);
            com.baidu.navisdk.util.worker.c.a().c(this.c, new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    public void a(com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar) {
        if (aVar == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.d("BNTransferNaviInfoToLoc", "received mmresult , type = " + aVar.f6815a);
        }
        this.f6507a = aVar;
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.d, true);
        com.baidu.navisdk.util.worker.c.a().c(this.d, new com.baidu.navisdk.util.worker.e(200, 0));
    }
}
