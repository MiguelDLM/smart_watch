package com.baidu.navisdk.module.asr;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alimm.tanx.core.constant.TanxAdType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public enum e implements com.baidu.navisdk.asr.i.g {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    private boolean f7034a = false;
    private String b = null;
    private boolean c = false;
    private com.baidu.navisdk.asr.model.a d = null;
    private boolean e = false;
    private String f = null;
    private List<String> g;

    e() {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add("sel_via_node");
        this.g.add("list_search");
        this.g.add("lbs_search");
        this.g.add("list_search_general");
    }

    private String b(String str) {
        try {
            return new JSONObject(str).getJSONObject("client").getString("intention");
        } catch (JSONException unused) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.c()) {
                gVar.c("RGAsrStatistics", "parseIntention() error, desc = " + str);
                return "";
            }
            return "";
        }
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void a(com.baidu.navisdk.asr.model.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.z0) && !TextUtils.isEmpty(aVar.T)) {
            com.baidu.navisdk.asr.sceneguide.a a2 = com.baidu.navisdk.asr.sceneguide.c.a().a(aVar.z0);
            if (a2 == null) {
                return;
            }
            String str2 = a2.b().D;
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String str3 = aVar.z0;
            if (TextUtils.equals(aVar.T, "yes")) {
                str = "1" + this.f;
            } else {
                str = "2" + this.f;
            }
            r.a("3.c.o.2", str3, str2, str);
            Bundle bundle = new Bundle();
            bundle.putString("scene_id", aVar.z0);
            bundle.putString("order", str2);
            bundle.putString("confirm", aVar.T);
            com.baidu.navisdk.asr.model.a aVar2 = this.d;
            if (aVar2 != null) {
                bundle.putString("voice_recinfo", aVar2.C0.d);
            }
            a("voiceRobotScene.confirm", bundle);
            return;
        }
        if (aVar.D0 && !TextUtils.isEmpty(aVar.z0)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.3", aVar.z0, aVar.D, this.f);
            Bundle bundle2 = new Bundle();
            bundle2.putString("scene_id", aVar.z0);
            com.baidu.navisdk.asr.model.a aVar3 = this.d;
            if (aVar3 != null) {
                bundle2.putString("voice_recinfo", aVar3.C0.d);
            }
            bundle2.putString("order", aVar.D);
            a("voiceRobotScene.ask", bundle2);
            return;
        }
        if (!TextUtils.isEmpty(aVar.T) && this.f7034a) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.6.1", aVar.k0, TextUtils.equals(aVar.T, "yes") ? "1" : "2", "");
            Bundle bundle3 = new Bundle();
            bundle3.putString("intention", this.b);
            bundle3.putString("confirm", aVar.T);
            a("voiceRobot.confirm", bundle3);
            return;
        }
        if (!TextUtils.isEmpty(aVar.z0)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.1", aVar.z0, aVar.C0.c, this.f);
            Bundle bundle4 = new Bundle();
            bundle4.putString("scene_id", aVar.z0);
            bundle4.putString("voice_recinfo", aVar.C0.d);
            bundle4.putString("order", aVar.C0.c);
            a("voiceRobotScene.show", bundle4);
            this.c = true;
            this.d = aVar;
            return;
        }
        if (TextUtils.equals(aVar.D, "common_speak_ask")) {
            this.e = true;
            this.d = aVar;
            return;
        }
        if (this.g.contains(aVar.D)) {
            int i2 = aVar.W;
            if (TextUtils.equals(aVar.D, "list_search") || TextUtils.equals(aVar.D, "lbs_search")) {
                i2 = aVar.f6553o0 - 1;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.7.1", aVar.k0, i2 + "", "0");
        }
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void onStop() {
        com.baidu.navisdk.asr.i.a h = com.baidu.navisdk.asr.d.B().h();
        if (h != null && this.f7034a && !h.a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.6.1", this.b, "3", "");
        }
        com.baidu.navisdk.asr.i.b i2 = com.baidu.navisdk.asr.d.B().i();
        if (i2 != null && this.f7034a && !i2.b()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.7.1", this.b, "", "1");
        }
        this.f7034a = false;
        this.b = null;
        this.c = false;
        this.d = null;
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void a(String str, String str2, com.baidu.navisdk.asr.i.a aVar, boolean z) {
        if (z) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.c.z.6", str2);
        Bundle bundle = new Bundle();
        bundle.putString("type", "business");
        bundle.putString("intention", str2);
        a("voiceRobot.Show", bundle);
        this.f7034a = true;
        this.b = str2;
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void a(String str, String str2, com.baidu.navisdk.asr.i.b bVar, boolean z) {
        String b = b(str2);
        if (!z) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.c.z.7", b);
        }
        this.f7034a = true;
        this.b = b;
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void a(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f7034a && !TextUtils.isEmpty(this.b)) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "business");
            bundle.putString("intention", this.b);
            bundle.putString("playText", aVar.d);
            a("voiceRobot.playText", bundle);
            return;
        }
        if ((this.c || this.e) && this.d != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("type", "scene");
            bundle2.putString("scene_id", this.d.z0);
            bundle2.putString("playText", aVar.d);
            bundle2.putString("voice_recinfo", this.d.C0.d);
            a("voiceRobot.playText", bundle2);
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("playText", aVar.d);
        a("voiceRobot.playText", bundle3);
    }

    @Override // com.baidu.navisdk.asr.i.g
    public void a() {
        Bundle bundle = new Bundle();
        bundle.putString("type", "click");
        a("voiceRobot.Show", bundle);
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(String str, Bundle bundle) {
        boolean z;
        boolean z2;
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                if (gVar.d()) {
                    gVar.e("RGAsrStatistics", "addBaseLineStatics(), e = " + e);
                    return;
                }
                return;
            }
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            z = h.y0();
            z2 = h.x0();
        } else {
            z = true;
            z2 = false;
        }
        bundle.putString(TanxAdType.SPLASH_STRING, z ? "portrait" : "landscape");
        if (z2) {
            bundle.putString(TypedValues.TransitionType.S_FROM, "fromNaviPage");
            bundle.putString("vehicle", com.baidu.navisdk.module.vehiclemanager.b.i().c());
        } else if (com.baidu.navisdk.framework.interfaces.c.p().e().a()) {
            bundle.putString(TypedValues.TransitionType.S_FROM, "fromCommuteScene");
        }
        com.baidu.navisdk.asr.d.B().a(str, bundle);
    }

    public void a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("intention", "route_recommend_passively");
        bundle.putString("confirm", z ? "yes" : "no");
        a("multiReply", bundle);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        com.baidu.navisdk.asr.model.a aVar = this.d;
        if (aVar != null && this.c) {
            bundle.putString("scene_id", aVar.z0);
            bundle.putString("voice_recinfo", this.d.C0.d);
            bundle.putString("order", this.d.C0.c);
        }
        a("voiceRobotScene.disappear", bundle);
    }
}
