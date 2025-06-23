package com.baidu.navisdk.pronavi.othervehicle.ui;

import android.content.res.Configuration;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.pronavi.car.a;
import com.baidu.navisdk.ui.routeguide.control.x;

/* loaded from: classes7.dex */
public class RGOldSettingCarUiFrame extends RGBaseUiFrame<a> {
    public RGOldSettingCarUiFrame(@NonNull a aVar, View view) {
        super(aVar, view);
    }

    @Override // com.baidu.navisdk.uiframe.ModularUiFrame
    public void a(Configuration configuration, View view) {
        super.a(configuration, view);
        x.b().b(configuration);
    }

    @Override // com.baidu.navisdk.pronavi.base.RGBaseUiFrame
    public void n() {
        super.n();
    }
}
