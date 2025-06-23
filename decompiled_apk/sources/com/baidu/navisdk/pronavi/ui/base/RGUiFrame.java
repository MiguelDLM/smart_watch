package com.baidu.navisdk.pronavi.ui.base;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.pronavi.state.RGUiStateFrame;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.uiframe.UiModuleGroup;

/* loaded from: classes7.dex */
public abstract class RGUiFrame<C extends b> extends RGUiStateFrame<C> {
    public RGUiFrame(@NonNull C c, View view) {
        super("RGUI", c, view);
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public UiModuleGroup<C> a(View view) {
        return new RGUiModuleGroup<C>(this, (b) this.f, view) { // from class: com.baidu.navisdk.pronavi.ui.base.RGUiFrame.1
            @Override // com.baidu.navisdk.framework.func.Func
            public String o() {
                return "RGUiModular";
            }
        };
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateFrame, com.baidu.navisdk.uiframe.ModularUiFrame
    public void e() {
        super.e();
        ((b) this.f).a(this);
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateFrame, com.baidu.navisdk.uiframe.ModularUiFrame
    public void f() {
        super.f();
        C c = this.f;
        if (c != 0) {
            ((b) c).d();
        }
    }
}
