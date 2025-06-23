package com.baidu.navisdk.module.cloudconfig;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.widget.debug.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.x;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements h {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.c();
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.module.cloudconfig.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0236b extends com.baidu.navisdk.util.worker.f<String, String> {
        public C0236b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.b();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        n nVar;
        com.baidu.navisdk.ugc.utils.g.c();
        if (!f.c().c.L) {
            f.c().c.x = false;
        }
        com.baidu.navisdk.skyeye.a.n().b();
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            nVar = h.b0();
        } else {
            nVar = null;
        }
        if (nVar != null) {
            nVar.b(f.c().c.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!f.c().c.L) {
            BNDebugModelDialog.resetDebugStatus();
        }
        com.baidu.navisdk.module.pronavi.model.i.f().e();
        com.baidu.navisdk.ugc.report.data.datarepository.d.i().h();
        com.baidu.navisdk.yellowtipdata.model.a.c().b();
        com.baidu.navisdk.module.powersavemode.f.o().a();
        LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "informModulesAftUpdate-> mCommonConfig.engineStr= " + f.c().c.k);
        if (!TextUtils.isEmpty(f.c().c.k)) {
            JNIGuidanceControl.getInstance().setCloudControlCommand(f.c().c.k);
        }
        if (!BNSettingManager.hasDestParkClicked()) {
            BNSettingManager.setPrefParkSearch(f.c().c.B);
        }
        f.o oVar = f.c().f;
        if (oVar != null) {
            com.baidu.navisdk.framework.interfaces.diyspeak.b c = x.c();
            if (c != null) {
                c.a(oVar.c);
            } else {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c("diySpeakManager", " cloud result diySpeakManager == null");
                }
                if (gVar.d()) {
                    gVar.a("diySpeakManager null", new Exception());
                }
            }
        }
        com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
        if (j != null && BNSettingManager.isLocationShareUsing() && !j.f()) {
            j.k();
        }
        com.baidu.navisdk.comapi.commontool.a.getInstance().b(f.c().c.O);
        com.baidu.navisdk.ui.voice.a.f9208a.a(f.c().c.V);
        com.baidu.navisdk.skyeye.b.a().a(new com.baidu.navisdk.skyeye.event.a());
    }

    @Override // com.baidu.navisdk.module.cloudconfig.h
    public void a(JSONObject jSONObject) {
        com.baidu.navisdk.yellowtipdata.model.a.c().a(jSONObject);
        com.baidu.navisdk.poisearch.e.a(jSONObject);
        try {
            com.baidu.navisdk.ugc.report.data.datarepository.d.i().a(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (com.baidu.navisdk.module.routepreference.i.j().a(jSONObject)) {
            com.baidu.navisdk.module.routepreference.i.j().a();
        }
        try {
            com.baidu.navisdk.module.routepreference.i.j().b(jSONObject);
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "driving habit," + e2);
                e2.printStackTrace();
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("statistics_config");
        if (LogUtil.LOGGABLE) {
            LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseUgcDataJSON statisticsConfigJson: " + optJSONObject.toString());
        }
        com.baidu.navisdk.comapi.statistics.b.f().a(optJSONObject);
    }

    @Override // com.baidu.navisdk.module.cloudconfig.h
    public void a() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("onCloudConfigUpdate main", null), new com.baidu.navisdk.util.worker.e(99, 1));
        com.baidu.navisdk.util.worker.c.a().c(new C0236b("onCloudConfigUpdate thread", null), new com.baidu.navisdk.util.worker.e(99, 1));
    }
}
