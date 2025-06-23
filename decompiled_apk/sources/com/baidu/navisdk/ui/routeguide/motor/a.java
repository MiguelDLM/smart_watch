package com.baidu.navisdk.ui.routeguide.motor;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.l1;
import com.baidu.navisdk.ui.routeguide.navidiff.b;
import com.baidu.navisdk.ui.routeguide.toolbox.d;
import com.baidu.navisdk.ui.routeguide.toolbox.f;
import com.baidu.navisdk.ui.routeguide.widget.g;

/* loaded from: classes8.dex */
public final class a implements b {
    @Override // com.baidu.navisdk.ui.routeguide.navidiff.b
    public g a(Activity activity, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        return new com.baidu.navisdk.ui.routeguide.motor.setting.a(activity, viewGroup, aVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.navidiff.b
    public f a(Context context, d dVar) {
        return new com.baidu.navisdk.ui.routeguide.motor.toolbox.b(context, dVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.navidiff.b
    public com.baidu.navisdk.ui.routeguide.mapmode.iview.a a() {
        return new l1();
    }
}
