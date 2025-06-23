package com.baidu.navisdk.module.cloudconfig;

import OXOo.oOoXoXO;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.ar.baidumap.bean.NavigationLuaField;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.module.cloudconfig.config.b;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.garmin.fit.xOxOoo;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlinx.coroutines.XOxIOxOx;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7100a = "e";
    static HashMap<String, com.baidu.navisdk.module.cloudconfig.i> b = new LinkedHashMap();
    static HashMap<String, com.baidu.navisdk.module.cloudconfig.j> c = new HashMap<>();

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
            if (gVar.b()) {
                gVar.b(e.f7100a, "truck_route_communicate,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().F.f7129a = jSONObject.optBoolean("isShown", false);
                com.baidu.navisdk.module.cloudconfig.f.c().F.b = jSONObject.optString("button_text", "路线互助");
                com.baidu.navisdk.module.cloudconfig.f.c().F.c = jSONObject.optString("url", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "new_navi_config: " + jSONObject + ", fromOnline:" + z);
            }
            if (jSONObject == null) {
                return;
            }
            f.h0 h0Var = com.baidu.navisdk.module.cloudconfig.f.c().r;
            JSONObject optJSONObject = jSONObject.optJSONObject("new_navi_setting_config");
            if (optJSONObject != null) {
                h0Var.f7116a = optJSONObject.optBoolean("support_new_btn", true);
                h0Var.b = optJSONObject.optBoolean("support_default_arc_condition", true);
                com.baidu.navisdk.module.cloudconfig.a.b().c("NAVI_SUPPORT_NEW_BTN", h0Var.f7116a);
                com.baidu.navisdk.module.cloudconfig.a.b().c("NAVI_SUPPORT_DEFAULT_ARC_CONDITION", h0Var.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (jSONObject.optInt("switch", 1) != 1) {
                z2 = false;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.L = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "surface_texture_view_config: " + jSONObject + ", fromOnline:" + z);
            }
            if (jSONObject == null) {
                return;
            }
            boolean z3 = false;
            int optInt = jSONObject.optInt("minimap_use_gltextureview", 0);
            int optInt2 = jSONObject.optInt("enlarge_use_gltextureview", 0);
            f.c0 c0Var = com.baidu.navisdk.module.cloudconfig.f.c().q;
            if (optInt2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            c0Var.c = z2;
            if (optInt == 1) {
                z3 = true;
            }
            c0Var.f7107a = z3;
            c0Var.b = jSONObject.optString("mini_map_use_texture_sdk_range", "29");
            c0Var.d = jSONObject.optString("enlarge_use_texture_sdk_range", "29");
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (!z) {
                return;
            }
            boolean z2 = true;
            if (jSONObject != null) {
                if (jSONObject.optInt("normal_quit", 1) <= 0) {
                    z2 = false;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("normal_quit", z2);
            } else if (com.baidu.navisdk.module.cloudconfig.a.b().a("normal_quit")) {
                com.baidu.navisdk.module.cloudconfig.a.b().c("normal_quit", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "navi_file_download_setting,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().G.f7133a = "1.0.0";
                String optString = jSONObject.optString("1.0.0");
                if (!TextUtils.isEmpty(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            com.baidu.navisdk.module.cloudconfig.f.c().G.b.add(String.valueOf(jSONArray.opt(i)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.a.b().c("open_bei_dou_tag", jSONObject.optBoolean(bn.b.V, true));
            } else {
                com.baidu.navisdk.module.cloudconfig.a.b().b("open_bei_dou_tag");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (jSONObject.optInt("open", 1) == 0) {
                z2 = false;
            }
            com.baidu.navisdk.framework.interfaces.o m = com.baidu.navisdk.framework.interfaces.c.p().m();
            if (m != null) {
                m.c(z2);
            } else if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "isetting null");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parse3DCarLogoDataJSON 3d_car_logo_config: " + jSONObject);
            }
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("bubble_show_text", "点击车标即可切换3D车标");
            com.baidu.navisdk.module.cloudconfig.f.c().s.b = jSONObject.optInt("bubble_text_show_times", 3);
            com.baidu.navisdk.module.cloudconfig.f.c().s.c = jSONObject.optInt("bubble_text_show_interval", 24);
            if (!TextUtils.isEmpty(optString) && optString.length() > 20) {
                optString = optString.substring(0, 20);
            }
            com.baidu.navisdk.module.cloudconfig.f.c().s.f7132a = optString;
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
            if (gVar.b()) {
                gVar.b(e.f7100a, "truck_navi_result_page,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                boolean optBoolean = jSONObject.optBoolean("truckEnd2H5ResultPage", false);
                String optString = jSONObject.optString("truckH5ResultPage", "");
                com.baidu.navisdk.module.cloudconfig.f.c().w.k = optBoolean;
                com.baidu.navisdk.module.cloudconfig.f.c().w.l = optString;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("heat_monitor_data", jSONObject.toString());
            } else {
                com.baidu.navisdk.module.cloudconfig.a.b().b("heat_monitor_data");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().c.f7119a = jSONObject.optString("combine_id", null);
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            JSONObject optJSONObject = jSONObject.optJSONObject("location_share_config");
            if (optJSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().i.f7144a = optJSONObject.optInt("fixedSendLocationInterval", 10);
                com.baidu.navisdk.module.cloudconfig.f.c().i.b = optJSONObject.optInt("offlineThreshold", 60);
                com.baidu.navisdk.module.cloudconfig.f.c().i.c = optJSONObject.optInt("naviSendLocationDistance", 300);
                com.baidu.navisdk.module.cloudconfig.f.c().i.d = optJSONObject.optInt("naviSendLocationInterval", 10);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            boolean z3 = false;
            if (jSONObject.getInt("collada_component_download") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            jVar.f = z2;
            f.j jVar2 = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (jSONObject.getInt("collada_component_init") == 1) {
                z3 = true;
            }
            jVar2.g = z3;
            com.baidu.navisdk.framework.b.H();
        }
    }

    /* loaded from: classes7.dex */
    public class c3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
            if (gVar.b()) {
                gVar.b(e.f7100a, "truck_challenge_mode,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().w.h = jSONObject.optBoolean("enable", true);
                com.baidu.navisdk.module.cloudconfig.f.c().w.i = jSONObject.optString("icon_url", "https://lbsnavi.cdn.bcebos.com/base/online/20210621155856/nsdk_drawable_route_result_drive_suggest.png");
                JSONArray optJSONArray = jSONObject.optJSONArray("guide_panel_desc");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        arrayList.add(new f.g(optJSONObject.optString("title"), optJSONObject.optString("sub_title"), 0, optJSONObject.optString("img_url")));
                    }
                    com.baidu.navisdk.module.cloudconfig.f.c().w.f7136a.clear();
                    com.baidu.navisdk.module.cloudconfig.f.c().w.f7136a.addAll(arrayList);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("truck_home_card");
                if (optJSONObject2 != null) {
                    com.baidu.navisdk.module.cloudconfig.f.c().w.j = optJSONObject2.optBoolean("show_bubble", true);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("invalid_rank_desc");
                if (optJSONObject3 != null) {
                    com.baidu.navisdk.module.cloudconfig.f.c().w.f.a(optJSONObject3.optString("help_title", ""), optJSONObject3.optString("help_sub_title", ""));
                    com.baidu.navisdk.module.cloudconfig.f.c().w.g.a(optJSONObject3.optString("contribute_title", ""), optJSONObject3.optString("contribute_sub_title", ""));
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("h5_config");
                if (optJSONObject4 != null) {
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("contribute_list");
                    if (optJSONObject5 != null) {
                        com.baidu.navisdk.module.cloudconfig.f.c().w.c.a(optJSONObject5.optBoolean("enable", true), optJSONObject5.optString("url"), optJSONObject5.optString("debug_url"));
                    }
                    JSONObject optJSONObject6 = optJSONObject4.optJSONObject("help_list");
                    if (optJSONObject5 != null) {
                        com.baidu.navisdk.module.cloudconfig.f.c().w.b.a(optJSONObject6.optBoolean("enable", true), optJSONObject6.optString("url"), optJSONObject6.optString("debug_url"));
                    }
                    JSONObject optJSONObject7 = optJSONObject4.optJSONObject("route_list");
                    if (optJSONObject7 != null) {
                        com.baidu.navisdk.module.cloudconfig.f.c().w.d.a(optJSONObject7.optBoolean("enable", true), optJSONObject7.optString("url"), optJSONObject7.optString("debug_url"));
                    }
                    JSONObject optJSONObject8 = optJSONObject4.optJSONObject("user_guide");
                    if (optJSONObject8 != null) {
                        com.baidu.navisdk.module.cloudconfig.f.c().w.e.a(optJSONObject8.optBoolean("enable", true), optJSONObject8.optString("url"), optJSONObject8.optString("debug_url"));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("heat_monitor_heat_level_data", jSONObject.toString());
            } else {
                com.baidu.navisdk.module.cloudconfig.a.b().b("heat_monitor_heat_level_data");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            boolean z2 = true;
            if (jSONObject.getInt("open") != 1) {
                z2 = false;
            }
            jVar.j = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3 = false;
            int optInt = jSONObject.optInt("open", 0);
            int optInt2 = jSONObject.optInt("cityopen", 0);
            if (optInt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            if (optJSONArray != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().f = new f.o();
                com.baidu.navisdk.module.cloudconfig.f.c().f.f7128a = z2;
                f.o oVar = com.baidu.navisdk.module.cloudconfig.f.c().f;
                if (optInt2 == 1) {
                    z3 = true;
                }
                oVar.b = z3;
                com.baidu.navisdk.module.cloudconfig.f.c().f.c = optJSONArray;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.V = jSONObject.optString("tts_taskid");
            com.baidu.navisdk.module.cloudconfig.f.c().c.W = jSONObject.optInt("max_level", -1);
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.i0 = jSONObject.optBoolean("enable", true);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.cloudconfig.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0237e implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "energyNaviCarBrandingConfig,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().H.f7124a = jSONObject.optString("route_h5_icon", "");
                com.baidu.navisdk.module.cloudconfig.f.c().H.c = jSONObject.optString("route_h5_title", "");
                com.baidu.navisdk.module.cloudconfig.f.c().H.b = jSONObject.optString("route_h5_url", "");
                com.baidu.navisdk.module.cloudconfig.f.c().H.d = jSONObject.optString("route_title", "");
                com.baidu.navisdk.module.cloudconfig.f.c().H.e = jSONObject.optString("navi_title", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject.has(com.huawei.openalliance.ad.constant.x.cD)) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.t = jSONObject.getString(com.huawei.openalliance.ad.constant.x.cD);
            }
            if (jSONObject.has("text")) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.u = jSONObject.getString("text");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().g = new f.m();
            f.m mVar = com.baidu.navisdk.module.cloudconfig.f.c().g;
            boolean z2 = false;
            if (jSONObject.optInt("value", 0) == 1) {
                z2 = true;
            }
            mVar.a(z2);
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.X = jSONObject.optInt("closeFunction");
        }
    }

    /* loaded from: classes7.dex */
    public class e3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.j0 = jSONObject.optBoolean("open", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject == null) {
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(e.f7100a, "hd_navi_config: " + jSONObject);
            }
            com.baidu.navisdk.module.cloudconfig.f.c().I.f7140a = jSONObject.optInt("user_close_times", 2);
            com.baidu.navisdk.module.cloudconfig.f.c().I.c = jSONObject.optBoolean("is_close_hd", false);
            com.baidu.navisdk.module.cloudconfig.f.c().I.d = jSONObject.optBoolean("hd_hot_alert", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("default_is_open");
            if (optJSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().I.b = optJSONObject.optBoolean("is_open", true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("is_need_hd_animation");
            if (optJSONObject2 != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().I.e = optJSONObject2.optBoolean("is_need_animation", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.s = jSONObject.optString("entts_taskid");
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().h = new f.d();
            com.baidu.navisdk.module.cloudconfig.f.c().h.h(jSONObject.optInt("time"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.a(jSONObject.optInt(xOxOoo.f15470o00));
            com.baidu.navisdk.module.cloudconfig.f.c().h.b(jSONObject.optInt("gps2gps_first_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.c(jSONObject.optInt("gps2gps_second_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.i(jSONObject.optInt("wifi2gps_first_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.j(jSONObject.optInt("wifi2gps_second_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.d(jSONObject.optInt("station2gps_first_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.e(jSONObject.optInt("station2gps_second_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.f(jSONObject.optInt("station2wifi_first_accuracy"));
            com.baidu.navisdk.module.cloudconfig.f.c().h.g(jSONObject.optInt("station2wifi_second_accuracy"));
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.a0 = jSONObject.optInt("sdk_normalall_log");
        }
    }

    /* loaded from: classes7.dex */
    public class f3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            if (jSONObject != null) {
                boolean z3 = true;
                if (jSONObject.optInt("open", 1) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("rg_is_switch_new_guide", z2);
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (jSONObject.optInt("isShowExitGuide", 1) != 1) {
                    z3 = false;
                }
                jVar.k0 = z3;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                f.v0 v0Var = com.baidu.navisdk.module.cloudconfig.f.c().J;
                JSONArray optJSONArray = jSONObject.optJSONArray("q_input");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String string = jSONObject2.getString("type");
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject2.getJSONArray("text");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.getString(i2));
                        }
                        linkedHashMap.put(string, arrayList);
                    }
                }
                if (linkedHashMap.size() != 0) {
                    v0Var.b = linkedHashMap;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_chat_enable", jSONObject.optBoolean("enable", true));
                com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_free_input", jSONObject.optBoolean("free_input", true));
                com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_chat_audio_enable", jSONObject.optBoolean("audio_enable", true));
                v0Var.f7141a = jSONObject.optString("notify_text", "请遵守\"路况信息分享规范\"，共同维护和谐、健康的网络环境");
                v0Var.d = jSONObject.optInt("barrage_interval", 60);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("rule");
                if (optJSONArray2 != null) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("section");
                        linkedHashMap2.put(new Pair(Integer.valueOf(jSONArray2.getInt(0)), Integer.valueOf(jSONArray2.getInt(1))), Integer.valueOf(jSONObject3.optInt("factor", 1)));
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("emoticons");
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        try {
                            JSONObject jSONObject4 = optJSONArray3.getJSONObject(i4);
                            f.p pVar = new f.p();
                            jSONObject4.getString("id");
                            jSONObject4.getString("text");
                            jSONObject4.getString(com.huawei.openalliance.ad.constant.x.cD);
                            v0Var.e.add(pVar);
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_chat_enable", true);
            com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_free_input", true);
            com.baidu.navisdk.module.cloudconfig.a.b().c("ugc_chat_audio_enable", true);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            String optString = jSONObject.optString("latest_id");
            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
            if (o != null) {
                o.setNewGlobalVoiceTaskId(optString);
            } else if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "isetting null");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                String str = com.baidu.navisdk.module.cloudconfig.f.c().c.k;
                if (!TextUtils.isEmpty(str) && str.length() > 1) {
                    String substring = str.substring(0, str.length() - 1);
                    com.baidu.navisdk.module.cloudconfig.f.c().c.k = substring + ",\"engine_highprecision\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
                    return;
                }
                com.baidu.navisdk.module.cloudconfig.f.c().c.k = "{\"engine_highprecision\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.Z = jSONObject.optInt("sdk_caricon_offset");
        }
    }

    /* loaded from: classes7.dex */
    public class g3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("open_recommend", -1);
                com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
                boolean z2 = true;
                if (optInt != 1) {
                    z2 = false;
                }
                b.c("open_recommend_mode", z2);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().b("open_recommend_mode");
        }
    }

    /* loaded from: classes7.dex */
    public class h implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                f.i iVar = com.baidu.navisdk.module.cloudconfig.f.c().K;
                JSONArray optJSONArray = jSONObject.optJSONArray("q_input");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String string = jSONObject2.getString("type");
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject2.getJSONArray("text");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.getString(i2));
                        }
                        linkedHashMap.put(string, arrayList);
                    }
                }
                if (linkedHashMap.size() != 0) {
                    iVar.b = linkedHashMap;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("common_chat_enable", jSONObject.optBoolean("enable", true));
                com.baidu.navisdk.module.cloudconfig.a.b().c("common_free_input", jSONObject.optBoolean("free_input", true));
                com.baidu.navisdk.module.cloudconfig.a.b().c("common_chat_audio_enable", jSONObject.optBoolean("audio_enable", true));
                iVar.f7117a = jSONObject.optString("notify_text", "请遵守\"信息分享规范\"，共同维护和谐、健康的网络环境");
                iVar.d = jSONObject.optInt("barrage_interval", 60);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("rule");
                if (optJSONArray2 != null) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("section");
                        linkedHashMap2.put(new Pair(Integer.valueOf(jSONArray2.getInt(0)), Integer.valueOf(jSONArray2.getInt(1))), Integer.valueOf(jSONObject3.optInt("factor", 1)));
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("emoticons");
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        try {
                            JSONObject jSONObject4 = optJSONArray3.getJSONObject(i4);
                            f.p pVar = new f.p();
                            jSONObject4.getString("id");
                            jSONObject4.getString("text");
                            jSONObject4.getString(com.huawei.openalliance.ad.constant.x.cD);
                            iVar.e.add(pVar);
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().c("common_chat_enable", true);
            com.baidu.navisdk.module.cloudconfig.a.b().c("common_free_input", true);
            com.baidu.navisdk.module.cloudconfig.a.b().c("common_chat_audio_enable", true);
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            int optInt = jSONObject.optInt("cuid_of_percentage", -1);
            int hashCode = com.baidu.navisdk.util.common.a0.e().hashCode();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("voice_page-clound_normal_voice", "匹配百分比：cuidHash= " + hashCode + "， percentage= " + optInt);
            }
            if (Math.abs(hashCode) % 100 < optInt) {
                String optString = jSONObject.optString("id");
                VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                if (o != null) {
                    o.setNewCloundNormalVoiceId(optString);
                } else {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
                    if (gVar.c()) {
                        gVar.c(e.f7100a, "clound_normal_voice setting null");
                    }
                }
            }
            boolean z2 = false;
            int optInt2 = jSONObject.optInt("close_switch", 0);
            VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
            if (o2 != null) {
                if (optInt2 == 1) {
                    z2 = true;
                }
                o2.setCloseMutliStyle(z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON trafficLightJson: " + jSONObject.toString());
            }
            int optInt = jSONObject.optInt("min_queue_dis", 0);
            if (optInt > 0) {
                f.r0.f7134a = optInt;
            }
            f.r0.b = jSONObject.optString("statement_content", null);
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.Y = jSONObject.optInt("close");
        }
    }

    /* loaded from: classes7.dex */
    public class h3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "history_out_count,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().x.f7112a = jSONObject.optInt("count", 4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            Iterator<String> keys;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
            if (gVar.b()) {
                gVar.b(e.f7100a, "dest_rec_config,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                f.n nVar = com.baidu.navisdk.module.cloudconfig.f.c().L;
                JSONObject optJSONObject = jSONObject.optJSONObject("poi_icons");
                if (optJSONObject == null) {
                    keys = null;
                } else {
                    keys = optJSONObject.keys();
                }
                while (optJSONObject != null && keys != null && keys.hasNext()) {
                    String next = keys.next();
                    String optString = optJSONObject.optString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                        nVar.f7127a.put(next, optString);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            boolean z2 = false;
            com.baidu.navisdk.module.cloudconfig.f.c().c.v = jSONObject.optInt("value", 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (jSONObject.optInt("futureTripValue", 0) == 0) {
                z2 = true;
            }
            jVar.d0 = z2;
            com.baidu.navisdk.framework.interfaces.o m = com.baidu.navisdk.framework.interfaces.c.p().m();
            if (m != null) {
                m.l(jSONObject.optBoolean("dynaPreload", true));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON extremeEventJson: " + jSONObject.toString());
            }
            boolean z2 = true;
            if (jSONObject.optInt("isOpen", 1) != 1) {
                z2 = false;
            }
            f.q.a(z2);
            f.q.a(jSONObject.optString("weatherSource"));
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.b0 = jSONObject.optJSONObject("tab_tip");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "car_to_new_energy,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().z.f7135a = !jSONObject.optBoolean("disable", false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(e.f7100a, "ar_navi_resource: " + jSONObject);
            }
            if (jSONObject == null) {
                return;
            }
            f.a aVar = com.baidu.navisdk.module.cloudconfig.f.c().O;
            String[] strArr = {"detector", "detector_night", "lanesegment", "lanesegment_night", "traffic", "traffic_night", "engine_resource"};
            for (int i = 0; i < 7; i++) {
                String str = strArr[i];
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null) {
                    f.b bVar = new f.b();
                    bVar.c = optJSONObject.optString("md5", null);
                    bVar.b = optJSONObject.optString("url", null);
                    bVar.d = optJSONObject.optInt("ver", 1);
                    bVar.f7104a = str;
                    bVar.e = optJSONObject.optBoolean(TTDownloadField.TT_FORCE, false);
                    if (bVar.a()) {
                        aVar.f7102a.put(bVar.f7104a, bVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            boolean z2 = false;
            int optInt = jSONObject.optInt("open", 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            }
            jVar.x = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON recyclerMapMemoryJson: " + jSONObject.toString());
            }
            boolean z4 = true;
            if (jSONObject.optInt("enableMemOpitimizationForEngTTS", 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (jSONObject.optInt("releaseCarRoutePage", 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (jSONObject.optInt("recyclerMapMemory", 1) != 1) {
                z4 = false;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.R = z2;
            com.baidu.navisdk.module.cloudconfig.f.c().c.P = z3;
            com.baidu.navisdk.module.cloudconfig.f.c().c.Q = z4;
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.a.b().b("device_perf_level", jSONObject.optInt("level", 100));
        }
    }

    /* loaded from: classes7.dex */
    public class j3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().c.w = jSONObject.getInt("open");
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().c.d = jSONObject.getInt("collada");
            com.baidu.navisdk.module.cloudconfig.f.c().c.e = jSONObject.getInt("guidecase");
            com.baidu.navisdk.module.cloudconfig.f.c().c.k = jSONObject.toString();
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().j = new f.u();
            com.baidu.navisdk.module.cloudconfig.f.c().j.a(jSONObject.optJSONObject("future_trip"));
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseCarOperateBtnConfig() --> carOperateBtnConfig =  " + jSONObject + ", fromOnline = " + z);
            }
            if (z) {
                com.baidu.navisdk.module.cloudconfig.f.c().l = new f.k0();
                com.baidu.navisdk.module.cloudconfig.f.c().l.c = true;
                com.baidu.navisdk.module.cloudconfig.f.c().l.f7123a = SystemClock.elapsedRealtime();
                com.baidu.navisdk.module.cloudconfig.f.c().l.b = jSONObject;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "truck_family_mode,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.a.b().c("open_truck_family_mode", jSONObject.optBoolean("enable", true));
            } else {
                com.baidu.navisdk.module.cloudconfig.a.b().b("open_truck_family_mode");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "navi_quest_info,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().M.b = jSONObject.optString("audit_type", "0");
                com.baidu.navisdk.module.cloudconfig.f.c().M.f7126a = jSONObject.optString("banner");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            com.baidu.navisdk.module.cloudconfig.f.c().c.y = jSONObject.optInt("bit_switch", -1);
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt != 1) {
                z2 = false;
            }
            jVar.M = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseTruckOperateBtnConfig() --> truckOperateBtnConfig =  " + jSONObject + ", fromOnline = " + z);
            }
            if (z) {
                com.baidu.navisdk.module.cloudconfig.f.c().m = new f.k0();
                com.baidu.navisdk.module.cloudconfig.f.c().m.c = true;
                com.baidu.navisdk.module.cloudconfig.f.c().m.f7123a = SystemClock.elapsedRealtime();
                com.baidu.navisdk.module.cloudconfig.f.c().m.b = jSONObject;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                boolean z2 = true;
                if (jSONObject.optInt("isShowJamLabel", 1) != 1) {
                    z2 = false;
                }
                f.p0.f7130a = z2;
                f.p0.b = jSONObject.optString("labelContentColor", null);
                f.p0.c = jSONObject.optString("labelContentAvoidJamColor", "#3377FF");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "navi_quest_info,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().N.f7114a = jSONObject.optInt("charge_station_limit", 2);
                com.baidu.navisdk.module.cloudconfig.f.c().N.b = jSONObject.optInt("charge_map_jump_type", 0);
                com.baidu.navisdk.module.cloudconfig.f.c().N.c = jSONObject.optString("charge_map_jump_url");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            int optInt = jSONObject.optInt("value", 1);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt != 1) {
                z2 = false;
            }
            jVar.z = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (jSONObject.optInt("open", com.baidu.navisdk.framework.b.f() ? 1 : 0) != 1) {
                z2 = false;
            }
            com.baidu.navisdk.framework.b.c(z2);
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseMotorOperateBtnConfig() --> motorOperateBtnConfig =  " + jSONObject + ", fromOnline = " + z);
            }
            if (z) {
                com.baidu.navisdk.module.cloudconfig.f.c().n = new f.k0();
                com.baidu.navisdk.module.cloudconfig.f.c().n.c = true;
                com.baidu.navisdk.module.cloudconfig.f.c().n.f7123a = SystemClock.elapsedRealtime();
                com.baidu.navisdk.module.cloudconfig.f.c().n.b = jSONObject;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().B.f7125a = jSONObject.optBoolean("open");
                com.baidu.navisdk.module.cloudconfig.f.c().B.e = jSONObject.optInt("minSupportApi", 26);
                com.baidu.navisdk.module.cloudconfig.f.c().B.f = jSONObject.optInt("maxSupportApi", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.getString(i));
                    }
                    com.baidu.navisdk.module.cloudconfig.f.c().B.b = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("blackBrandList");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(optJSONArray2.getString(i2));
                    }
                    com.baidu.navisdk.module.cloudconfig.f.c().B.c = arrayList2;
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("adjustList");
                if (optJSONArray3 != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        arrayList3.add(optJSONArray3.getString(i3));
                    }
                    com.baidu.navisdk.module.cloudconfig.f.c().B.d = arrayList3;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("emui");
                if (optJSONObject != null) {
                    com.baidu.navisdk.module.cloudconfig.f.c().B.h = optJSONObject.optString("max");
                    com.baidu.navisdk.module.cloudconfig.f.c().B.g = optJSONObject.optString("min");
                    com.baidu.navisdk.module.cloudconfig.f.c().B.i = optJSONObject.optInt("strategy");
                }
            }
            com.baidu.navisdk.module.cloudconfig.f.c().B.a();
        }
    }

    /* loaded from: classes7.dex */
    public class n implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.l0 = jSONObject.optBoolean("open", false);
                com.baidu.navisdk.module.cloudconfig.f.c().c.m0 = jSONObject.optInt("fps", 60);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                boolean z2 = true;
                int optInt = jSONObject.optInt("open", 1);
                com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
                if (optInt != 1) {
                    z2 = false;
                }
                b.c("enable_hms_location", z2);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().b("enable_hms_location");
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON dayNightModeJson: " + jSONObject.toString());
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.O = jSONObject.optInt("type", 1);
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3 = false;
            if (jSONObject.has("is_open")) {
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (jSONObject.getInt("is_open") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                jVar.l = z2;
            }
            if (jSONObject.has("in_navi_open")) {
                f.j jVar2 = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (jSONObject.getInt("in_navi_open") == 1) {
                    z3 = true;
                }
                jVar2.q = z3;
            }
            if (jSONObject.has("title")) {
                String string = jSONObject.getString("title");
                if (!com.baidu.navisdk.util.common.l0.c(string)) {
                    com.baidu.navisdk.module.cloudconfig.f.c().c.m = string;
                }
            }
            if (jSONObject.has("light_navi_pic")) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.n = jSONObject.getString("light_navi_pic");
            }
            if (jSONObject.has("navi_pic")) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.o = jSONObject.getString("navi_pic");
            }
            if (jSONObject.has("navi_night_icon")) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.p = jSONObject.getString("navi_night_icon");
            }
            if (jSONObject.has("in_navi_icon")) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.r = jSONObject.getString("in_navi_icon");
            }
            LogUtil.e("safeJSONObject", " safety safeJSONObject " + jSONObject);
        }
    }

    /* loaded from: classes7.dex */
    public class n3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            JSONArray optJSONArray;
            int length;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("plates")) != null && (length = optJSONArray.length()) > 0) {
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
                com.baidu.navisdk.module.cloudconfig.f.c().C.f7106a = strArr;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().P.f7109a = jSONObject.optBoolean("enable", false);
                com.baidu.navisdk.module.cloudconfig.f.c().P.b = jSONObject.optBoolean("block_monitor_enable", false);
            }
            com.baidu.navisdk.module.cloudconfig.a.b().c("is_open_perform_monitor", com.baidu.navisdk.module.cloudconfig.f.c().P.f7109a);
            com.baidu.navisdk.module.cloudconfig.a.b().c("is_open_block_monitor", com.baidu.navisdk.module.cloudconfig.f.c().P.b);
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                boolean z2 = true;
                int optInt = jSONObject.optInt("open", 1);
                com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
                if (optInt != 1) {
                    z2 = false;
                }
                b.c("enable_hms_navi_control", z2);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().b("enable_hms_navi_control");
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON voiceRecommendJson: " + jSONObject.toString());
            }
            com.baidu.navisdk.module.cloudconfig.f.c().a(jSONObject);
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (z) {
                if (jSONObject == null) {
                    if (com.baidu.navisdk.module.cloudconfig.a.b().a("show_low_perf_voice_tips")) {
                        com.baidu.navisdk.module.cloudconfig.a.b().b("show_low_perf_voice_tips");
                    }
                } else {
                    boolean z2 = true;
                    int optInt = jSONObject.optInt("start", 1);
                    com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
                    if (optInt != 1) {
                        z2 = false;
                    }
                    b.c("show_low_perf_voice_tips", z2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3;
            if (jSONObject != null) {
                boolean z4 = true;
                if (jSONObject.optInt("enable", 1) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (jSONObject.optInt("sub_nav", 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (jSONObject.optInt("sub_route", 1) != 1) {
                    z4 = false;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("vehicle_dispatch_openapi", z2);
                com.baidu.navisdk.module.cloudconfig.a.b().c("vehicle_dispatch_nav", z3);
                com.baidu.navisdk.module.cloudconfig.a.b().c("vehicle_dispatch_route", z4);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.a.b().b("vehicle_dispatch_openapi");
            com.baidu.navisdk.module.cloudconfig.a.b().b("vehicle_dispatch_nav");
            com.baidu.navisdk.module.cloudconfig.a.b().b("vehicle_dispatch_route");
        }
    }

    /* loaded from: classes7.dex */
    public class p implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.n0 = jSONObject.optBoolean("enable", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = false;
            int optInt = jSONObject.optInt("support", 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            }
            jVar.A = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON vdrWifiSwitchStatusTipConfig: " + jSONObject.toString());
            }
            boolean z2 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt != 1) {
                z2 = false;
            }
            jVar.N = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            if (jSONObject == null) {
                if (com.baidu.navisdk.module.cloudconfig.a.b().a("fps_switch")) {
                    com.baidu.navisdk.module.cloudconfig.a.b().b("fps_switch");
                }
                if (com.baidu.navisdk.module.cloudconfig.a.b().a("fps")) {
                    com.baidu.navisdk.module.cloudconfig.a.b().b("fps");
                }
                if (com.baidu.navisdk.module.cloudconfig.a.b().a("disable_animation")) {
                    com.baidu.navisdk.module.cloudconfig.a.b().b("disable_animation");
                    return;
                }
                return;
            }
            boolean z3 = false;
            int optInt = jSONObject.optInt("fps_switch", 0);
            int optInt2 = jSONObject.optInt("fps", 0);
            int optInt3 = jSONObject.optInt("disable_animation", 0);
            com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            b.d("fps_switch", z2);
            com.baidu.navisdk.module.cloudconfig.a b2 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt3 == 1) {
                z3 = true;
            }
            b2.d("disable_animation", z3);
            com.baidu.navisdk.module.cloudconfig.a.b().c("fps", optInt2);
            com.baidu.navisdk.module.cloudconfig.a.b().a();
        }
    }

    /* loaded from: classes7.dex */
    public class p3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                SparseArray<String> sparseArray = com.baidu.navisdk.module.cloudconfig.f.c().I.f;
                sparseArray.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next, null);
                    if (!TextUtils.isEmpty(optString)) {
                        sparseArray.put(Integer.parseInt(next), optString);
                    }
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(e.f7100a, "hd_lane_resource: " + sparseArray);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "winter_olympics_tag, jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.f7120o0 = jSONObject.optBoolean("open", false);
                com.baidu.navisdk.module.cloudconfig.f.c().c.q0 = jSONObject.optBoolean("gray_test_enable", false);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.f7120o0 = false;
            com.baidu.navisdk.module.cloudconfig.f.c().c.q0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = false;
            int optInt = jSONObject.optInt(bn.b.V, 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            }
            jVar.B = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON showWhenLockedJson: " + jSONObject.toString() + ", Build.MANUFACTURER:" + Build.MANUFACTURER);
            }
            String string = jSONObject.getString("devices");
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (string != null && string.contains(Build.MANUFACTURER)) {
                z2 = true;
            } else {
                z2 = false;
            }
            jVar.T = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject == null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.c0 = null;
            } else {
                com.baidu.navisdk.module.cloudconfig.f.c().c.c0 = jSONObject.toString();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "no_space_text_view_config,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().A.f7118a = jSONObject.optBoolean("enable", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "remain_stall_card_control, jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.p0 = jSONObject.optInt("autoHideTime", 120);
            } else {
                com.baidu.navisdk.module.cloudconfig.f.c().c.p0 = 120;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = false;
            int optInt = jSONObject.optInt(XOxIOxOx.f29771X0o0xo, 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            }
            jVar.C = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                String str = com.baidu.navisdk.module.cloudconfig.f.c().c.k;
                if (!TextUtils.isEmpty(str) && str.length() > 1) {
                    String substring = str.substring(0, str.length() - 1);
                    com.baidu.navisdk.module.cloudconfig.f.c().c.k = substring + ",\"engine_multiStyle\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
                    return;
                }
                com.baidu.navisdk.module.cloudconfig.f.c().c.k = "{\"engine_multiStyle\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "mossConfig : " + jSONObject);
            }
            if (jSONObject != null) {
                f.k.e = jSONObject.optBoolean("isShowH5EndPage", f.k.e);
                f.k.f = jSONObject.optString("h5PageUrl", f.k.f);
                JSONObject optJSONObject = jSONObject.optJSONObject("commuteReportBtnConfig");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("imgUrl");
                    boolean optBoolean = optJSONObject.optBoolean("enable");
                    String optString2 = optJSONObject.optString("h5Url");
                    f.k.b = optString;
                    f.k.c = optString2;
                    f.k.d = optBoolean;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.a.b().c("perf_sm", jSONObject.optBoolean("enable", true));
            } else {
                com.baidu.navisdk.module.cloudconfig.a.b().b("perf_sm");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().P.f7109a = jSONObject.optBoolean("enable", false);
                com.baidu.navisdk.module.cloudconfig.f.c().P.b = jSONObject.optBoolean("block_monitor_enable", false);
            }
            com.baidu.navisdk.module.cloudconfig.a.b().c("is_open_perform_monitor", com.baidu.navisdk.module.cloudconfig.f.c().P.f7109a);
            com.baidu.navisdk.module.cloudconfig.a.b().c("is_open_block_monitor", com.baidu.navisdk.module.cloudconfig.f.c().P.b);
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (z && jSONObject != null) {
                int optInt = jSONObject.optInt("close", 0);
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (optInt == 1) {
                    z2 = false;
                }
                jVar.D = z2;
                com.baidu.navisdk.module.cloudconfig.f.c().c.E = jSONObject.optDouble("percent", 0.8d);
                com.baidu.navisdk.module.cloudconfig.f.c().c.F = jSONObject.optInt("ss_interval", 3000);
                com.baidu.navisdk.module.cloudconfig.f.c().c.G = jSONObject.optInt("min_total_count", 6);
                return;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.D = true;
            com.baidu.navisdk.module.cloudconfig.f.c().c.E = 0.8d;
            com.baidu.navisdk.module.cloudconfig.f.c().c.F = 3000;
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON isRecycleBitmapJson: " + jSONObject.toString());
            }
            boolean z2 = true;
            if (jSONObject.getInt("isRecycleBitmap") != 1) {
                z2 = false;
            }
            com.baidu.navisdk.k.f6861a = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "intelli_drive cloud config data  =  " + jSONObject);
            }
            List<com.baidu.navisdk.module.cloudconfig.k> a2 = com.baidu.navisdk.module.cloudconfig.f.c().u.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.baidu.navisdk.module.cloudconfig.f.c().u.f7092a = jSONObject;
            com.baidu.navisdk.module.cloudconfig.f.c().u.b = elapsedRealtime;
            com.baidu.navisdk.module.cloudconfig.f.c().u.c = z;
            Iterator<com.baidu.navisdk.module.cloudconfig.k> it = a2.iterator();
            while (it.hasNext()) {
                it.next().a(jSONObject, elapsedRealtime, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "energyNaviEndConfig,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().D.f7111a = jSONObject.optBoolean("isShowH5EndPage", false);
                com.baidu.navisdk.module.cloudconfig.f.c().D.b = jSONObject.optString("h5PageUrl", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable @oOoXoXO JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().Q.f7143a = jSONObject.optBoolean("enable", true);
                com.baidu.navisdk.module.cloudconfig.f.c().Q.b = Float.parseFloat(jSONObject.optString("wideScale", "0.8"));
                com.baidu.navisdk.module.cloudconfig.a.b().c("is_open_wide_screen", com.baidu.navisdk.module.cloudconfig.f.c().Q.f7143a);
                com.baidu.navisdk.module.cloudconfig.a.b().b("wide_screen_scale", com.baidu.navisdk.module.cloudconfig.f.c().Q.b);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(e.f7100a, "wide screen: enable = " + com.baidu.navisdk.module.cloudconfig.a.b().a("is_open_wide_screen", true) + "scale = " + com.baidu.navisdk.module.cloudconfig.a.b().a("wide_screen_scale", 0.8f));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            try {
                int optInt = jSONObject.optInt("open", 1);
                JSONArray optJSONArray = jSONObject.optJSONArray("day");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(NavigationLuaField.NAVI_LUA_NPC_LAUNCH_NIGHT);
                if (optJSONArray != null && optJSONArray.length() == 3 && optJSONArray2 != null && optJSONArray2.length() == 3) {
                    com.baidu.navisdk.module.cloudconfig.f.c().d = new f.e(optInt, optJSONArray, optJSONArray2);
                } else {
                    com.baidu.navisdk.module.cloudconfig.f.c().d = new f.e(optInt, null, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON isRecycleBitmapJson: " + jSONObject.toString());
            }
            f.k.f7122a = jSONObject.getString("name");
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "trajectoryRestore cloud config data  =  " + jSONObject);
            }
            if (jSONObject != null) {
                boolean z2 = false;
                int optInt = jSONObject.optInt("hideButton", 0);
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (optInt == 1) {
                    z2 = true;
                }
                jVar.e0 = z2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_HOME;
            if (gVar.b()) {
                gVar.b(e.f7100a, "energyNaviCarBrandingConfig,jsonObject:" + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().E.f7113a = jSONObject.optInt("jump_type", -1);
                com.baidu.navisdk.module.cloudconfig.f.c().E.b = jSONObject.optInt("version", -1);
                com.baidu.navisdk.module.cloudconfig.f.c().E.c = jSONObject.optString("jump_url", "");
                com.baidu.navisdk.module.cloudconfig.f.c().E.d = jSONObject.optString("image_url", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
            if (gVar.d()) {
                gVar.e(e.f7100a, "parse new_energy_charge_route_prefer_config jsonObject = " + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.config.a aVar = com.baidu.navisdk.module.cloudconfig.f.c().R;
                LinkedHashMap<Integer, com.baidu.navisdk.model.datastruct.e> linkedHashMap = new LinkedHashMap<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("charge_route_prefer_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            com.baidu.navisdk.model.datastruct.e eVar = new com.baidu.navisdk.model.datastruct.e(optJSONObject.optInt("prefer", -1), optJSONObject.optString("prefer_name", ""), optJSONObject.optString("prefer_abbr_name", ""), optJSONObject.optString("icon_selected", ""), optJSONObject.optString("icon_unselected", ""));
                            if (eVar.a() >= 0) {
                                linkedHashMap.put(Integer.valueOf(eVar.a()), eVar);
                            }
                        }
                    }
                }
                aVar.a(linkedHashMap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            int i = jSONObject.getInt("open");
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            jVar.S = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON oppo_dest_park: " + jSONObject.toString());
            }
            boolean z3 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            jVar.U = z2;
            com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt != 1) {
                z3 = false;
            }
            b.c("oppo_dest_park_open", z3);
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = false;
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("open", 0);
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                if (optInt == 1) {
                    z2 = true;
                }
                jVar.f0 = z2;
                return;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.f0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class u3 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (jSONObject.getInt("value") != 1) {
                z2 = false;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.i = z2;
            if (z2 != com.baidu.navisdk.util.http.b.d().c()) {
                com.baidu.navisdk.util.http.b.d().a(com.baidu.navisdk.module.cloudconfig.f.c().c.i);
                com.baidu.navisdk.util.http.b.d().b();
                com.baidu.navisdk.framework.b.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = false;
            int optInt = jSONObject.optInt("recordopen", 0);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt == 1) {
                z2 = true;
            }
            jVar.b = z2;
            com.baidu.navisdk.module.cloudconfig.f.c().c.c = true;
            LogUtil.e("CarNaviTrajectoryModel", "carnavicloud recordopen = " + optInt);
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                String str = com.baidu.navisdk.module.cloudconfig.f.c().c.k;
                if (!TextUtils.isEmpty(str) && str.length() > 1) {
                    String substring = str.substring(0, str.length() - 1);
                    com.baidu.navisdk.module.cloudconfig.f.c().c.k = substring + ",\"geoyawconfig\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
                    return;
                }
                com.baidu.navisdk.module.cloudconfig.f.c().c.k = "{\"geoyawconfig\":" + jSONObject2 + ooOOo0oXI.f33074oOoXoXO;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13 = true;
            int optInt = jSONObject.optInt("open", 1);
            int optInt2 = jSONObject.optInt("local_show", 1);
            int optInt3 = jSONObject.optInt("tts_log_upload", 1);
            int optInt4 = jSONObject.optInt("children_mode", 1);
            int optInt5 = jSONObject.optInt("support_image_edit", 1);
            int optInt6 = jSONObject.optInt("support_rerecord", 1);
            int optInt7 = jSONObject.optInt("personalize_open", 1);
            int optInt8 = jSONObject.optInt("to_personalize_tag", 1);
            int optInt9 = jSONObject.optInt("is_persist_page", 1);
            int optInt10 = jSONObject.optInt("refresh_data_async", 1);
            String optString = jSONObject.optString("voice_share_text", "");
            f.z a2 = com.baidu.navisdk.module.cloudconfig.f.c().a();
            if (optInt5 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a2.d = z2;
            f.z a3 = com.baidu.navisdk.module.cloudconfig.f.c().a();
            if (optInt6 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            a3.e = z3;
            f.z a4 = com.baidu.navisdk.module.cloudconfig.f.c().a();
            if (optInt7 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            a4.g = z4;
            f.z a5 = com.baidu.navisdk.module.cloudconfig.f.c().a();
            if (optInt8 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            a5.h = z5;
            com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            b.c("lyrebird_open", z6);
            com.baidu.navisdk.module.cloudconfig.a b2 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt2 == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            b2.c("lyrebird_local_show", z7);
            com.baidu.navisdk.module.cloudconfig.a b3 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt3 == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            b3.c("lyrebird_log_upload", z8);
            com.baidu.navisdk.module.cloudconfig.a b4 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt4 == 1) {
                z9 = true;
            } else {
                z9 = false;
            }
            b4.c("lyrebird_children_mode", z9);
            com.baidu.navisdk.module.cloudconfig.a b5 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt7 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            b5.c("lyrebird_personazlie_open", z10);
            com.baidu.navisdk.module.cloudconfig.a b6 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt8 == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            b6.c("lyrebird_to_spec_tag_open", z11);
            com.baidu.navisdk.module.cloudconfig.a b7 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt9 == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            b7.c("voice_page_persist", z12);
            com.baidu.navisdk.module.cloudconfig.a.b().b("lyrebird_share_text", optString);
            com.baidu.navisdk.module.cloudconfig.a b8 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt10 != 1) {
                z13 = false;
            }
            b8.c("refresh_data_async", z13);
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "car_home_page_white_banner cloud config data  =  " + jSONObject);
            }
            List<com.baidu.navisdk.module.cloudconfig.k> a2 = com.baidu.navisdk.module.cloudconfig.f.c().v.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.baidu.navisdk.module.cloudconfig.f.c().v.f7092a = jSONObject;
            com.baidu.navisdk.module.cloudconfig.f.c().v.b = elapsedRealtime;
            com.baidu.navisdk.module.cloudconfig.f.c().v.c = z;
            Iterator<com.baidu.navisdk.module.cloudconfig.k> it = a2.iterator();
            while (it.hasNext()) {
                it.next().a(jSONObject, elapsedRealtime, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
            if (gVar.d()) {
                gVar.e(e.f7100a, "parse new_energy_result_page_brand_icon_config jsonObject = " + jSONObject);
            }
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.config.b bVar = com.baidu.navisdk.module.cloudconfig.f.c().S;
                SparseArray<b.a> sparseArray = new SparseArray<>();
                Object opt = jSONObject.opt("brand_icons");
                if (opt == null) {
                    return;
                }
                if (opt instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) opt;
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            e.b(Integer.parseInt(next), jSONObject2.optJSONObject(next), sparseArray);
                        } catch (Exception unused) {
                            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.COMMON;
                            if (gVar2.d()) {
                                gVar2.e(e.f7100a, "parse new_energy_result_page_brand_icon_config exception, key = " + next);
                            }
                        }
                    }
                }
                if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        e.b(i, jSONArray.optJSONObject(i), sparseArray);
                    }
                }
                bVar.a(sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3;
            com.baidu.navisdk.module.cloudconfig.f.c().e = new f.w0();
            boolean z4 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.w0 w0Var = com.baidu.navisdk.module.cloudconfig.f.c().e;
            if (optInt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            w0Var.f7142a = z2;
            int optInt2 = jSONObject.optInt("openSimpleModel", 1);
            f.w0 w0Var2 = com.baidu.navisdk.module.cloudconfig.f.c().e;
            if (optInt2 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            w0Var2.b = z3;
            int optInt3 = jSONObject.optInt("useGPSAdjust", 0);
            f.w0 w0Var3 = com.baidu.navisdk.module.cloudconfig.f.c().e;
            if (optInt3 != 1) {
                z4 = false;
            }
            w0Var3.c = z4;
            com.baidu.navisdk.module.cloudconfig.f.c().e.d = jSONObject.optInt("maxModelCnt", 5);
            com.baidu.navisdk.module.cloudconfig.f.c().e.e = (float) jSONObject.optDouble("maxInferPoseDiff", 30.0d);
            com.baidu.navisdk.module.cloudconfig.f.c().e.f = (float) jSONObject.optDouble("maxValidatePoseDiff", 15.0d);
            com.baidu.navisdk.module.cloudconfig.f.c().e.g = (float) jSONObject.optDouble("complex_min_stop_value", 0.001500000013038516d);
            com.baidu.navisdk.module.cloudconfig.f.c().e.h = (float) jSONObject.optDouble("simple_min_stop_value", 0.001500000013038516d);
            String optString = jSONObject.optString("blacklist", null);
            if (!TextUtils.isEmpty(optString)) {
                com.baidu.navisdk.module.cloudconfig.f.c().e.i = optString.split(",");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().a().c = jSONObject.optDouble("noise_threshold", -50.0d);
            f.z.a aVar = new f.z.a();
            int i = 0;
            jSONObject.optInt("h_wer_distance", 0);
            String str = "h_speech_speed_min";
            jSONObject.optDouble("h_speech_speed_min", 150.0d);
            jSONObject.optDouble("h_speech_speed_max", 250.0d);
            jSONObject.optDouble("h_speech_snr", 35.0d);
            jSONObject.optDouble("h_speech_level_min", -24.0d);
            jSONObject.optDouble("h_speech_level_max", -3.0d);
            com.baidu.navisdk.module.cloudconfig.f.c().a().f7145a = aVar;
            JSONObject optJSONObject = jSONObject.optJSONObject("sub_version");
            if (optJSONObject == null) {
                return;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = optJSONObject.getJSONObject(next);
                f.z.a aVar2 = new f.z.a();
                jSONObject2.optInt("h_wer_distance", i);
                jSONObject2.optDouble(str, 150.0d);
                jSONObject2.optDouble("h_speech_speed_max", 250.0d);
                jSONObject2.optDouble("h_speech_snr", 35.0d);
                jSONObject2.optDouble("h_speech_level_min", -24.0d);
                jSONObject2.optDouble("h_speech_level_max", -3.0d);
                com.baidu.navisdk.module.cloudconfig.f.c().a().a(next, aVar2);
                str = str;
                i = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().c.g0 = jSONObject.optString("url", null);
            } else {
                com.baidu.navisdk.module.cloudconfig.f.c().c.g0 = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject == null) {
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(e.f7100a, "normal_hd_navi_config: " + jSONObject);
            }
            com.baidu.navisdk.module.cloudconfig.f.c().U.b = jSONObject.optBoolean("is_close_normal_hd", false);
            com.baidu.navisdk.module.cloudconfig.f.c().U.d = jSONObject.optString("hd_car_logo_url", com.baidu.navisdk.module.cloudconfig.f.c().U.d);
            JSONObject optJSONObject = jSONObject.optJSONObject("normal_hd_switch_defaule_state");
            if (optJSONObject != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().U.f7121a = optJSONObject.optBoolean("is_open", true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("is_need_normal_hdmap_animation");
            if (optJSONObject2 != null) {
                com.baidu.navisdk.module.cloudconfig.f.c().U.c = optJSONObject2.optBoolean("is_need_animation", true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
            if (optInt != 1) {
                z2 = false;
            }
            jVar.H = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.z a2 = com.baidu.navisdk.module.cloudconfig.f.c().a();
            if (optInt != 1) {
                z2 = false;
            }
            a2.f = z2;
            com.baidu.navisdk.module.cloudconfig.f.c().a().i = jSONObject.optString("close_msg", "今日录制名额已满，明日10点将开启录制通道，先到先得");
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                boolean z2 = false;
                if (jSONObject.optInt("isFinishHaoQiYe2020", 0) == 1) {
                    z2 = true;
                }
                com.baidu.navisdk.module.cloudconfig.a.b().c("bn_is_finish_haoqiye_2020", z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "enlarge_minimap_config: " + jSONObject + ", fromOnline:" + z);
            }
            if (jSONObject == null) {
                return;
            }
            f.c0 c0Var = com.baidu.navisdk.module.cloudconfig.f.c().q;
            c0Var.e = jSONObject.optBoolean("enlargeUseBaseView", true);
            c0Var.f = jSONObject.optBoolean("miniMapUseBaseView", true);
            c0Var.g = jSONObject.optBoolean("isSupportEnlargeMSAA", true);
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            com.baidu.navisdk.module.cloudconfig.f.c().c.I = jSONObject.optString("display_cutout_devices", "");
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(e.f7100a, "parseUgcDataJSON is3DCarIconEnable: " + jSONObject.toString());
            }
            boolean z2 = true;
            int optInt = jSONObject.optInt("open", 1);
            f.q0 q0Var = com.baidu.navisdk.module.cloudconfig.f.c().s;
            if (optInt != 1) {
                z2 = false;
            }
            q0Var.d = z2;
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = true;
            if (jSONObject.getInt("core_log_record") != 1) {
                z2 = false;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.h = z2;
            SDKDebugFileUtil.getInstance().setCoreLogRecordEnable(z2);
            com.baidu.navisdk.debug.b.k().a(z2);
        }
    }

    /* loaded from: classes7.dex */
    public class z implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                JSONObject jSONObject2 = jSONObject.getJSONObject(obj);
                f.u0 u0Var = new f.u0();
                jSONObject2.getString("title");
                u0Var.f7139a = new ArrayList();
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    f.t0 t0Var = new f.t0();
                    String optString = jSONObject3.optString("title");
                    t0Var.f7138a = optString;
                    if (!TextUtils.isEmpty(optString)) {
                        u0Var.f7139a.add(t0Var);
                    }
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("content");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                        f.t0 t0Var2 = new f.t0();
                        jSONObject4.optInt("type", 0);
                        t0Var2.f7138a = jSONObject4.optString("text");
                        jSONObject4.optString("url");
                        jSONObject4.optString("preview");
                        u0Var.f7139a.add(t0Var2);
                    }
                }
                com.baidu.navisdk.module.cloudconfig.f.c().T.put(Integer.valueOf(Integer.parseInt(obj)), u0Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2;
            boolean z3 = false;
            if (jSONObject.optInt("three_second_control_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.J = z2;
            if (jSONObject.optInt("locsdk_type_control_switch", 0) == 1) {
                z3 = true;
            }
            com.baidu.navisdk.module.cloudconfig.f.c().c.K = z3;
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            if (jSONObject == null) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("use_nav_sensor_on");
                com.baidu.navisdk.module.cloudconfig.a.b().b("use_map_gps_state");
                com.baidu.navisdk.module.cloudconfig.a.b().b("set_rgc_cen_freq");
                com.baidu.navisdk.module.cloudconfig.a.b().b("preload_nav_view");
                com.baidu.navisdk.module.cloudconfig.a.b().b("need_app_init_ok");
                return;
            }
            boolean z11 = false;
            int optInt = jSONObject.optInt("fullstate_call_onconfig_change", 0);
            f.t tVar = com.baidu.navisdk.module.cloudconfig.f.c().p;
            if (optInt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            tVar.f7137a = z2;
            if (jSONObject.optInt("fix_wifi_state_chang_freq", 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            tVar.d = z3;
            if (jSONObject.optInt("enlarge_surface_view_on_top", 1) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            tVar.c = z4;
            if (jSONObject.optInt("use_nav_sensor", 1) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            tVar.b = z5;
            com.baidu.navisdk.module.cloudconfig.a.b().d("use_nav_sensor_on", tVar.b);
            int optInt2 = jSONObject.optInt("use_map_gps_state", 0);
            com.baidu.navisdk.module.cloudconfig.a b = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt2 == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            b.d("use_map_gps_state", z6);
            int optInt3 = jSONObject.optInt("set_rgc_cen_freq", 1);
            com.baidu.navisdk.module.cloudconfig.a b2 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt3 == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            b2.d("set_rgc_cen_freq", z7);
            int optInt4 = jSONObject.optInt("preload_nav_view", -1);
            if (optInt4 == -1) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("preload_nav_view");
            } else {
                com.baidu.navisdk.module.cloudconfig.a b3 = com.baidu.navisdk.module.cloudconfig.a.b();
                if (optInt4 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                b3.d("preload_nav_view", z8);
            }
            int optInt5 = jSONObject.optInt("need_app_init_ok", -1);
            if (optInt5 == -1) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("need_app_init_ok");
            } else {
                com.baidu.navisdk.module.cloudconfig.a b4 = com.baidu.navisdk.module.cloudconfig.a.b();
                if (optInt5 == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                b4.d("need_app_init_ok", z9);
            }
            int optInt6 = jSONObject.optInt("isInterceptMapFlashRoutePlane", 1);
            com.baidu.navisdk.module.cloudconfig.a b5 = com.baidu.navisdk.module.cloudconfig.a.b();
            if (optInt6 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            b5.d("isInterceptMapFlashRoutePlane", z10);
            int optInt7 = jSONObject.optInt("setting_opt_perf", -1);
            if (optInt7 == -1) {
                com.baidu.navisdk.module.cloudconfig.a.b().b("setting_opt_perf");
            } else {
                com.baidu.navisdk.module.cloudconfig.a b6 = com.baidu.navisdk.module.cloudconfig.a.b();
                if (optInt7 == 1) {
                    z11 = true;
                }
                b6.d("setting_opt_perf", z11);
            }
            com.baidu.navisdk.module.cloudconfig.a.b().a();
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            if (jSONObject != null) {
                f.j jVar = com.baidu.navisdk.module.cloudconfig.f.c().c;
                boolean z2 = false;
                if (jSONObject.optInt("closeFunction", 0) == 1) {
                    z2 = true;
                }
                jVar.h0 = z2;
            }
        }
    }

    static {
        b.put("engine", new k0());
        b.put("geoyawconfig", new v0());
        b.put("engine_highprecision", new g1());
        b.put("engine_multiStyle", new r1());
        b.put("navi_common", new c2());
        b.put("reunion", new n2());
        b.put("core_log_record", new y2());
        b.put("eta_history", new j3());
        b.put("https_enable", new u3());
        b.put("multi_road", new k());
        b.put("carnavitrajectory", new v());
        b.put("tts_control", new c0());
        b.put("android_foreground_service", new d0());
        b.put("castrol_yellow_tips", new e0());
        b.put("abroad_voice", new f0());
        b.put("international_tts", new g0());
        b.put("clound_normal_voice", new h0());
        b.put("XDVoiceEnable", new i0());
        b.put("skyeye", new j0());
        b.put("skyeye_switch", new l0());
        b.put("open_hw_mm", new m0());
        b.put("hms_location_config", new n0());
        b.put("hms_navi_control", new o0());
        b.put("parkService", new p0());
        b.put("parkShow", new q0());
        b.put("daynight_off", new r0());
        b.put("anti_open", new s0());
        b.put("power_control", new t0());
        b.put("HeteromorphismScreenEnabled", new u0());
        b.put("DrivingDetector", new w0());
        b.put("scenic_broadcast", new x0());
        b.put("AndroidPControl", new y0());
        b.put("nagpscontrol", new z0());
        b.put("factorymode", new a1());
        b.put("location_share", new b1());
        b.put("location_share_config", new c1());
        b.put("diy_speak_mode", new d1());
        b.put("enable_aoi_src_rec", new e1());
        b.put("car_secne_gps_refresh_android", new f1());
        b.put("trafficLight", new h1());
        b.put("NaviExteremRouteEvent", new i1());
        b.put("memoryOptimization", new j1());
        b.put("future_trip", new k1());
        b.put("hw_power_saver", new l1());
        b.put("bluetooth_blank_voice_switch", new m1());
        b.put("dayNightMode", new n1());
        b.put("voice_recommend", new o1());
        b.put("vdr_wifi_switch_status_tip", new p1());
        b.put("showWhenLocked", new q1());
        b.put("isRecycleBitmap", new s1());
        b.put("mossButtonName", new t1());
        b.put("oppo_dest_park", new u1());
        b.put("lyrebird_config", new v1());
        b.put("lyrebird_standard", new w1());
        b.put("lyrebird_entry", new x1());
        b.put("is3DCarIconEnable", new y1());
        b.put("function_switch", new z1());
        b.put("surface_texture_view_config", new a2());
        b.put("3d_car_logo_config", new b2());
        b.put("low_perf_voice", new d2());
        b.put("policeRecord", new e2());
        b.put("sdk_log_skyeye", new f2());
        b.put("sdk_view_controller", new g2());
        b.put("lane_line_animation", new h2());
        b.put("nimble_function", new i2());
        b.put("brand_mb_level", new j2());
        b.put("car_result_operate_btn", new k2());
        b.put("truck_result_operate_btn", new l2());
        b.put("motor_result_operate_btn", new m2());
        b.put("show_low_perf_voice_tips", new o2());
        b.put("low_perf_config", new p2());
        b.put("eye_spy_v2", new q2());
        b.put("mossConfig", new r2());
        b.put("intelli_drive", new s2());
        b.put("trajectoryRestore", new t2());
        b.put("gps_weak_stat", new u2());
        b.put("car_home_page_tip", new v2());
        b.put("speedy_end_page_config", new w2());
        b.put("operation_activities", new x2());
        b.put("truckOperationActivity", new z2());
        b.put("recovery_navi", new a3());
        b.put("truck_navi_result_page", new b3());
        b.put("truck_challenge_mode", new c3());
        b.put("edog_compensate", new d3());
        b.put("pre_yawing", new e3());
        b.put("pro_navi_upgrade", new f3());
        b.put("openapi_direction_mode", new g3());
        b.put("history_out_count", new h3());
        b.put("car_to_new_energy", new i3());
        b.put("truck_family_mode", new k3());
        b.put("smart_road_condition", new l3());
        b.put("pip_config", new m3());
        b.put("car_area_plates", new n3());
        b.put("open_vehicle_dispatch", new o3());
        b.put("hd_lane_resource", new p3());
        b.put("no_space_text_view_config", new q3());
        b.put("perf_sm", new r3());
        b.put("energyNaviEndConfig", new s3());
        b.put("ne_result_page_car_brand_dialog", new t3());
        b.put("truck_route_communicate", new a());
        b.put("navi_file_download_setting", new b());
        b.put("hot_state_config", new c());
        b.put("hot_state_config_hot_level", new d());
        b.put("moss_operation_config", new C0237e());
        b.put("hd_navi_config", new f());
        b.put("ugc_chat", new g());
        b.put("social_chat", new h());
        b.put("dest_rec_config", new i());
        b.put("ar_navi_resource", new j());
        b.put("navi_quest_info", new l());
        b.put("new_eng_home_charge_map", new m());
        b.put("vector_map_dirty_mode", new n());
        b.put("navi_performance_statistics_switch", new o());
        b.put("future_page_open_api", new p());
        b.put("winter_olympics_tag", new q());
        b.put("remain_stall_card_control", new r());
        b.put("navi_performance_statistics_switch", new s());
        b.put("wide_screen_control", new t());
        b.put("new_energy_charge_route_prefer_config", new u());
        b.put("new_energy_result_page_brand_icon_config", new w());
        b.put("normal_hd_navi_config", new x());
        b.put("enlarge_minimap_config", new y());
        b.put("scenario_based_tutorial", new z());
        b.put("new_navi_config", new a0());
        b.put("beidou_loc", new b0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i4, JSONObject jSONObject, SparseArray<b.a> sparseArray) {
        if (jSONObject == null) {
            return;
        }
        b.a aVar = new b.a();
        aVar.a(jSONObject.optString("icon_tab_label", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("icon_tip");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    aVar.a(Integer.parseInt(next), optJSONObject.optString(next, ""));
                } catch (Exception unused) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
                    if (gVar.d()) {
                        gVar.e(f7100a, "parseResultBrandIconConfig exception, iconType = " + i4 + ", pattern = " + next);
                    }
                }
            }
        }
        sparseArray.put(i4, aVar);
    }

    /* loaded from: classes7.dex */
    public class k implements com.baidu.navisdk.module.cloudconfig.i {
        @Override // com.baidu.navisdk.module.cloudconfig.i
        public void a(@Nullable JSONObject jSONObject, boolean z) throws Exception {
            boolean z2 = jSONObject.getInt("open") != 0;
            com.baidu.navisdk.module.cloudconfig.f.c().f7101a = new f.a0(z2, a(jSONObject.getString("tag_dis")), jSONObject.optInt("card_show_time", 20), jSONObject.optInt("lastmile", -1));
        }

        private int[] a(String str) {
            if (str.startsWith("[") && str.endsWith("]")) {
                str = str.substring(1, str.length() - 1);
            }
            String[] split = str.split(",");
            int length = split.length;
            if (length < 1) {
                return null;
            }
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                try {
                    iArr[i] = Integer.parseInt(split[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return iArr;
        }
    }
}
