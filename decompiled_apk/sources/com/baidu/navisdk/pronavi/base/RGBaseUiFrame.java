package com.baidu.navisdk.pronavi.base;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.navisdk.framework.interfaces.y;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.pronavi.ui.base.RGUiFrame;
import com.baidu.navisdk.pronavi.ui.base.b;

/* loaded from: classes7.dex */
public class RGBaseUiFrame<C extends com.baidu.navisdk.pronavi.ui.base.b> extends RGUiFrame<C> {
    public RGBaseUiFrame(@NonNull C c, View view) {
        super(c, view);
        n();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiFrame, com.baidu.navisdk.pronavi.state.RGUiStateFrame, com.baidu.navisdk.uiframe.ModularUiFrame
    public void e() {
        super.e();
        a(h.f7469a, "onCreate", PrerollVideoResponse.NORMAL);
    }

    public y[] m() {
        RGUiComponent rGUiComponent = (RGUiComponent) a("RGLeftBucketComponent");
        RGUiComponent rGUiComponent2 = (RGUiComponent) a("RGRightBucketComponent");
        y[] yVarArr = new y[2];
        if (rGUiComponent != null) {
            yVarArr[0] = rGUiComponent;
        }
        if (rGUiComponent2 != null) {
            yVarArr[1] = rGUiComponent2;
        }
        return yVarArr;
    }

    public void n() {
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public C b() {
        return (C) super.b();
    }
}
