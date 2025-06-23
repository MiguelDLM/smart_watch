package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e extends j {
    public e(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void a(JSONObject jSONObject, int i) {
        super.a(jSONObject, i);
        if (jSONObject != null && jSONObject.has("route_tab_btn")) {
            jSONObject.optString("route_tab_btn", "");
        }
        if (jSONObject != null && jSONObject.has("type")) {
            jSONObject.optInt("type", -1);
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABCommuteEntranceData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 7;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteEntranceData", "plan:" + super.o());
        }
        return super.o();
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ABCommuteEntranceData", "onEvent");
        }
        super.b(i);
    }
}
