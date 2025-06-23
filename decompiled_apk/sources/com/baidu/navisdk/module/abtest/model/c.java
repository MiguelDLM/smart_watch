package com.baidu.navisdk.module.abtest.model;

import android.os.Bundle;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class c extends j {
    private int p;

    public c(int i, com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        this.p = i;
        try {
            a(aVar.e(i));
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException(h(), e);
            }
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "ABCommonData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return this.p;
    }
}
