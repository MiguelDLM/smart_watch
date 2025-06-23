package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    private View f8758a;
    private TextView b;
    private boolean c = false;
    private boolean d = false;

    private boolean b(ViewGroup viewGroup, @IdRes int i) {
        if (viewGroup == null) {
            return false;
        }
        if (this.f8758a == null) {
            try {
                this.f8758a = ((ViewStub) viewGroup.findViewById(i)).inflate();
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("VdrModeGuideView", "loadGuideView exception: " + e.toString());
                }
            }
            View view = this.f8758a;
            if (view != null) {
                this.b = (TextView) view.findViewById(R.id.bnav_rg_vdr_go_where_multi_tv);
            }
        }
        return this.f8758a != null;
    }

    public boolean a(ViewGroup viewGroup, @IdRes int i) {
        View view;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuideView", "intoVdrLowPrecisionGuideView: ");
        }
        boolean b = b(viewGroup, i);
        if (b && (view = this.f8758a) != null && view.getVisibility() != 0) {
            this.f8758a.setVisibility(0);
        }
        this.c = b;
        return b;
    }

    public boolean c() {
        return this.c;
    }

    public void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateGuideView: ");
            sb.append(str);
            sb.append(", mGuideRootView isVisible:");
            View view = this.f8758a;
            sb.append(view != null && view.getVisibility() == 0);
            gVar.e("VdrModeGuideView", sb.toString());
        }
        this.c = true;
        View view2 = this.f8758a;
        if (view2 != null && view2.getVisibility() != 0) {
            this.f8758a.setVisibility(0);
        }
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setText(str);
        this.d = true;
    }

    public boolean b() {
        return this.d;
    }

    public void a() {
        View view = this.f8758a;
        if (view != null && view.getVisibility() != 8) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("VdrModeGuideView", "exitVdrLowPrecisionGuideView: ");
            }
            this.f8758a.setVisibility(8);
        }
        this.c = false;
        this.d = false;
    }

    public void a(boolean z) {
        View view = this.f8758a;
        if (view != null) {
            int i = z ? 0 : 8;
            if (view.getVisibility() != i) {
                this.f8758a.setVisibility(i);
            }
        }
    }
}
