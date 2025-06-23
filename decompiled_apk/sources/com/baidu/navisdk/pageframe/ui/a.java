package com.baidu.navisdk.pageframe.ui;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.pageframe.logic.BNLogicFrame;
import com.baidu.navisdk.pageframe.store.data.c;
import com.baidu.navisdk.pageframe.store.i.b;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.uiframe.framework.a {
    private b h;
    private BNLogicFrame i;

    public a(@NonNull Activity activity, String str, @NonNull com.baidu.navisdk.framework.data.a aVar, b bVar, BNLogicFrame bNLogicFrame) {
        super(activity, str, aVar);
        this.i = bNLogicFrame;
        this.h = bVar;
        if (bVar != null) {
            bVar.a((b) this);
        }
    }

    @Nullable
    public <T extends com.baidu.navisdk.pageframe.store.data.b> T b(Class<T> cls) {
        BNLogicFrame bNLogicFrame = this.i;
        if (bNLogicFrame != null) {
            return (T) bNLogicFrame.a(cls);
        }
        return null;
    }

    @Nullable
    public <T extends c> T c(Class<T> cls) {
        b bVar = this.h;
        if (bVar != null) {
            return (T) bVar.a(cls);
        }
        return null;
    }
}
