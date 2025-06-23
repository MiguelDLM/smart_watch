package com.baidu.navisdk.uiframe;

import android.content.Intent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.uiframe.framework.a;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class UiModuleGroup<C extends com.baidu.navisdk.uiframe.framework.a> extends UiModule<C> {
    protected final Map<String, UiModule<C>> o;

    public UiModuleGroup(C c) {
        this(c, null);
    }

    public void a(UiModule<C> uiModule) {
        if (uiModule == null) {
            return;
        }
        this.o.put(uiModule.o(), uiModule);
    }

    @Nullable
    public <M extends UiModule<C>> M d(String str) {
        return this.o.get(str);
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        this.o.clear();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public boolean u() {
        for (UiModule<C> uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) && uiModule.u()) {
                return true;
            }
        }
        return false;
    }

    public UiModuleGroup(C c, View view) {
        super(c);
        this.o = new LinkedHashMap();
        this.k = view;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void a(int i, int i2, Intent intent) {
        for (UiModule<C> uiModule : this.o.values()) {
            if (uiModule != null && uiModule.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                uiModule.a(i, i2, intent);
            }
        }
    }
}
