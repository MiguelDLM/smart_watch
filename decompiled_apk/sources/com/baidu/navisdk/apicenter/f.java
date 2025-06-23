package com.baidu.navisdk.apicenter;

import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
class f implements d {
    @Override // com.baidu.navisdk.apicenter.d
    public h a(@NonNull e eVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DefaultApiScheduler", "ApiScheduler::call --> task = " + eVar);
        }
        return eVar.a();
    }
}
