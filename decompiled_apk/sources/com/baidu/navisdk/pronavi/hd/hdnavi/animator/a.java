package com.baidu.navisdk.pronavi.hd.hdnavi.animator;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.c;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.ui.routeguide.utils.b;
import com.baidu.navisdk.ui.routeguide.widget.d;
import com.baidu.navisdk.util.common.g;
import java.util.List;

/* loaded from: classes7.dex */
public class a extends d implements c {
    private View i;

    public a(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        n0();
    }

    private void n0() {
        this.i = this.b.findViewById(R.id.bnav_rg_notification_container);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        n0();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationViewAnimator", "orientationChanged: " + i);
        }
        int i2 = 0;
        boolean z = i != 2;
        f h0 = h0();
        int i3 = h0.f6817a;
        if (i3 == 2) {
            i2 = z ? h0.b : h0.c;
        }
        a(i3, z, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationViewAnimator", "getEnterNormal: " + i);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, 0);
        }
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, b.j(), 0);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationViewAnimator", "getEnterFullHD: " + i);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, 0);
        }
        int k = b.k();
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, b.q() + k, k);
    }

    private void a(int i, boolean z, int i2) {
        int j;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationViewAnimator", "setContainerMargin: " + i + ", " + z + ", " + i2);
        }
        if (z) {
            if (i == 2) {
                com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, i2);
                return;
            } else {
                com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, 0);
                return;
            }
        }
        if (i == 2) {
            j = b.q();
        } else if (i == 3) {
            i2 = b.k();
            j = b.q() + i2;
        } else {
            j = b.j();
            i2 = 0;
        }
        com.baidu.navisdk.pronavi.hd.d.f7723a.e(this.i, j, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationViewAnimator", "getEnterDoubleMap: " + i);
        }
        if (z) {
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, i2);
        }
        return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.i, b.q(), i2);
    }
}
