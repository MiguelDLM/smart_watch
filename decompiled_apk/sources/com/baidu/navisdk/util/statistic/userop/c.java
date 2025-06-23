package com.baidu.navisdk.util.statistic.userop;

import android.os.Bundle;
import java.util.Map;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.module.statistics.b {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f9386a;

    public c(Map<String, String> map) {
        this.f9386a = null;
        this.f9386a = new Bundle();
        for (String str : map.keySet()) {
            this.f9386a.putString(str, map.get(str));
        }
    }

    public void a() {
        com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
    }
}
