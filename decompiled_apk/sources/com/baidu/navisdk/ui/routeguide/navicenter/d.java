package com.baidu.navisdk.ui.routeguide.navicenter;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.s0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Object, q> f9065a = new HashMap<>();
    private HashMap<String, Object> b;

    /* loaded from: classes8.dex */
    public class a implements q {
        public a(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(a0.I().D());
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q {
        public b(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().z2());
        }
    }

    /* loaded from: classes8.dex */
    public class c implements q {
        public c(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.util.logic.j.r().g());
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.navicenter.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0472d implements q {
        public C0472d(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.ui.routeguide.asr.c.n().h());
        }
    }

    /* loaded from: classes8.dex */
    public class e implements q {
        public e(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            boolean z;
            if (com.baidu.navisdk.module.international.a.a() != 0) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements q {
        public f(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(BNRoutePlaner.getInstance().B());
        }
    }

    /* loaded from: classes8.dex */
    public class g implements q {
        public g(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.module.cloudconfig.f.c().c.N);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends r {
        public h(d dVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.r
        public boolean b(Object obj) {
            String str = (String) obj;
            if (!RGFSMTable.FsmState.HUD.equalsIgnoreCase(str) && !RGFSMTable.FsmState.HUDMirror.equalsIgnoreCase(str) && !RGFSMTable.FsmState.Voice.equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class i implements q {
        public i(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            boolean z;
            if (!com.baidu.navisdk.ui.routeguide.mapmode.a.o5().K2() && !com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J2() && !com.baidu.navisdk.ui.routeguide.mapmode.a.o5().L2()) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements q {
        public j(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            boolean z;
            if (s0.a(com.baidu.navisdk.framework.a.c().a()) == 3) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements q {
        public k(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.module.powersavemode.f.o().k());
        }
    }

    /* loaded from: classes8.dex */
    public class l implements q {
        public l(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q2());
        }
    }

    /* loaded from: classes8.dex */
    public class m implements q {
        public m(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return RouteGuideFSM.getInstance().getCurrentState();
        }
    }

    /* loaded from: classes8.dex */
    public class n implements q {
        public n(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            boolean z;
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes8.dex */
    public class o implements q {
        public o(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().O2());
        }
    }

    /* loaded from: classes8.dex */
    public class p implements q {
        public p(d dVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.q
        public Object a() {
            return Boolean.valueOf(com.baidu.navisdk.ui.routeguide.b.V().C());
        }
    }

    /* loaded from: classes8.dex */
    public interface q {
        Object a();
    }

    /* loaded from: classes8.dex */
    public static abstract class r implements u {

        /* renamed from: a, reason: collision with root package name */
        private String f9066a;

        public r(String str) {
            this.f9066a = str;
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.u
        public final boolean a(Object obj) {
            boolean b = b(obj);
            LogUtil.e("RGStateWatcher", "expectInner,stateName:" + this.f9066a + ",ret:" + b + ",arg:" + obj);
            return b;
        }

        public abstract boolean b(Object obj);
    }

    /* loaded from: classes8.dex */
    public static class s extends r {
        public s(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.r
        public boolean b(Object obj) {
            LogUtil.e("RGStateWatcher", "BooleanFalseExpect,expect,arg:" + obj);
            return !((Boolean) obj).booleanValue();
        }
    }

    /* loaded from: classes8.dex */
    public static class t extends r {
        public t(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.d.r
        public boolean b(Object obj) {
            return ((Boolean) obj).booleanValue();
        }
    }

    /* loaded from: classes8.dex */
    public interface u {
        boolean a(Object obj);
    }

    /* loaded from: classes8.dex */
    public static class v {

        /* renamed from: a, reason: collision with root package name */
        public static final d f9067a = new d();
    }

    public d() {
        HashMap<String, Object> hashMap = new HashMap<>();
        this.b = hashMap;
        hashMap.put("ugc_1", new s("ugc_1"));
        this.b.put("save_power_3", new s("save_power_3"));
        this.b.put("wifi_5", new s("wifi_5"));
        this.b.put("pro_navi_page_4", new t("pro_navi_page_4"));
        this.b.put("anolog_navi_7", new s("anolog_navi_7"));
        this.b.put("pro_more_setting_6", new s("anolog_navi_7"));
        this.b.put("yaw_ing_9", new s("yaw_ing_9"));
        this.b.put("share_travel_10", new s("share_travel_10"));
        this.b.put("gps_enabled_11", new t("gps_enabled_11"));
        this.b.put("Int_l_navi_14", new s("Int_l_navi_14"));
        this.b.put("offline_navi_13", new s("offline_navi_13"));
        this.b.put("vdr_wifi_switch_cloud_15", new t("vdr_wifi_switch_cloud_15"));
        this.b.put("FSM_2", new h(this, "FSM_2"));
        this.f9065a.put("ugc_1", new i(this));
        this.f9065a.put("wifi_5", new j(this));
        this.f9065a.put("save_power_3", new k(this));
        this.f9065a.put("pro_more_setting_6", new l(this));
        this.f9065a.put("FSM_2", new m(this));
        this.f9065a.put("anolog_navi_7", new n(this));
        this.f9065a.put("vdr_guide_8", new o(this));
        this.f9065a.put("pro_navi_page_4", new p(this));
        this.f9065a.put("yaw_ing_9", new a(this));
        this.f9065a.put("share_travel_10", new b(this));
        this.f9065a.put("gps_enabled_11", new c(this));
        this.f9065a.put("xd_showing_12", new C0472d(this));
        this.f9065a.put("Int_l_navi_14", new e(this));
        this.f9065a.put("offline_navi_13", new f(this));
        this.f9065a.put("vdr_wifi_switch_cloud_15", new g(this));
    }

    public static d b() {
        return v.f9067a;
    }

    public int a() {
        Iterator<Map.Entry<String, Object>> it = this.b.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                Object value = next.getValue();
                q qVar = this.f9065a.get(key);
                StringBuilder sb = new StringBuilder();
                sb.append("key:");
                sb.append((Object) key);
                sb.append(",value:");
                sb.append(value);
                sb.append(",action is null:");
                sb.append(qVar == null);
                LogUtil.e("RGStateWatcher", sb.toString());
                if (qVar != null && !((u) value).a(qVar.a())) {
                    LogUtil.e("RGStateWatcher", "checkWifiSwitchStateSettingDialogConfig,false");
                    com.baidu.navisdk.util.statistic.userop.b r2 = com.baidu.navisdk.util.statistic.userop.b.r();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    String str = key;
                    sb2.append(a(str));
                    r2.a("3.x.a", "1", "2", sb2.toString());
                    return a(str);
                }
            } else {
                LogUtil.e("RGStateWatcher", "checkWifiSwitchStateSettingDialogConfig,true");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.a", "1", "1", null);
                return 0;
            }
        }
    }

    private int a(String str) {
        try {
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGStateWatcher", "getStateIntFlag,e:" + e2);
            }
        }
        if (!TextUtils.isEmpty(str) && str.contains("_")) {
            String[] split = str.split("_");
            if (split.length > 0) {
                return Integer.parseInt(split[split.length - 1]);
            }
            return -1;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGStateWatcher", "getStateIntFlag,state:" + str);
        }
        return -1;
    }
}
