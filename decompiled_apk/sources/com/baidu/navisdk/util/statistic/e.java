package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class e extends com.baidu.navisdk.comapi.statistics.f {
    private static e j;

    public e(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
    }

    public static e n() {
        if (j == null) {
            j = new e(com.baidu.navisdk.comapi.statistics.b.f());
        }
        return j;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        new ArrayList();
        Bundle bundle = new Bundle();
        JNINaviManager.sInstance.getConfigParamFromEngine(3, bundle);
        a(bundle.getString("engine_statistic"));
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50016";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-EngineStatItem";
    }
}
