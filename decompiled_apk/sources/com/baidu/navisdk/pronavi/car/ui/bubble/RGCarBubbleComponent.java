package com.baidu.navisdk.pronavi.car.ui.bubble;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.pronavi.ui.bubble.RGBubbleBaseComponent;
import com.baidu.navisdk.ui.bubble.a;
import com.baidu.navisdk.ui.bubble.b;
import com.baidu.navisdk.ui.bubble.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class RGCarBubbleComponent extends RGBubbleBaseComponent<b> {
    private boolean q;

    /* loaded from: classes7.dex */
    public class a implements e {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public void a(com.baidu.navisdk.ui.bubble.b bVar) {
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public void b(com.baidu.navisdk.ui.bubble.b bVar) {
            RGCarBubbleComponent.this.q = true;
            BNCommSettingManager.getInstance().putRGSettingBubbleShowTimes(BNCommSettingManager.getInstance().getRGSettingBubbleShowTimes() + 1);
        }

        @Override // com.baidu.navisdk.ui.bubble.e
        public boolean a() {
            return true;
        }
    }

    public RGCarBubbleComponent(@NonNull b bVar) {
        super(bVar);
    }

    private com.baidu.navisdk.ui.bubble.b E() {
        com.baidu.navisdk.ui.bubble.b bVar = new com.baidu.navisdk.ui.bubble.b();
        bVar.d(2);
        bVar.b(0);
        bVar.c(100);
        bVar.a(JarUtils.getResources().getString(R.string.nsdk_rg_setting_bubble_tips));
        bVar.a(F());
        bVar.a(5000);
        b.a aVar = new b.a(bVar);
        aVar.b(0);
        bVar.a(aVar);
        bVar.a(new a());
        return bVar;
    }

    private View F() {
        return x.b().c0();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bubble.RGBubbleBaseComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void c(String str, String str2, Bundle bundle) {
        super.c(str, str2, bundle);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bubble.RGBubbleBaseComponent
    public void c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showBubble: " + i);
        }
        com.baidu.navisdk.ui.bubble.a aVar = this.p;
        if (aVar == null || !aVar.a(i)) {
            D();
            a.C0403a c0403a = new a.C0403a(((com.baidu.navisdk.pronavi.ui.base.b) this.i).a(), (FrameLayout) this.k);
            if (i == 1) {
                c0403a.a(C());
            } else if (i != 2) {
                c0403a = null;
            } else {
                c0403a.a(E());
            }
            if (c0403a != null) {
                this.p = c0403a.b();
            }
        }
    }
}
