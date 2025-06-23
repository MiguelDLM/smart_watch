package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class f extends j {
    public f(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ABFutureTripData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 2;
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ABFutureTripData", "plan:" + super.o());
        }
        return super.o();
    }
}
