package com.baidu.navisdk.module.brule.business;

import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f7043a;

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.B().a(b.this.a());
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.module.brule.business.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0227b {
    }

    public static b b() {
        if (f7043a == null) {
            f7043a = new b();
        }
        return f7043a;
    }

    public void a(InterfaceC0227b interfaceC0227b) {
    }

    public void a(com.baidu.navisdk.behavrules.a aVar) {
        if (!com.baidu.navisdk.module.brule.business.util.b.f7047a && com.baidu.navisdk.function.b.FUNC_XIAODU_SCENEAID.a()) {
            c.a().c(new a("behavRulesBNBRuleConfigRequest", null), new e(100, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        RoutePlanNode o = fVar.o();
        RoutePlanNode g = fVar.g();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", o.getName());
            jSONObject2.put("lat", o.getLatitudeE6() / 100000.0d);
            jSONObject2.put("lng", o.getLongitudeE6() / 100000.0d);
            jSONObject2.put("uid", o.getUID());
            jSONObject.put("startnode", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", g.getName());
            jSONObject3.put("uid", g.getUID());
            jSONObject3.put("lat", g.getLatitudeE6() / 100000.0d);
            jSONObject3.put("lng", g.getLongitudeE6() / 100000.0d);
            jSONObject.put("endnode", jSONObject3);
            jSONObject.put("longdistance", com.baidu.navisdk.module.brule.a.l().j());
            jSONObject.put("iselectric", com.baidu.navisdk.module.brule.a.l().i());
            jSONObject.put("eta", com.baidu.navisdk.module.brule.a.l().b());
            jSONObject.put("carplate", com.baidu.navisdk.module.brule.a.l().c());
            hashMap.put("navinfo", URLEncoder.encode(jSONObject.toString(), "utf-8"));
            VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
            hashMap.put("voice_pkgid", o2 == null ? "" : o2.getCurrentVoice());
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
