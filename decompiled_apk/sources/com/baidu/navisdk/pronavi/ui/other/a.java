package com.baidu.navisdk.pronavi.ui.other;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7949a = false;
    private View b;

    public void a(ViewGroup viewGroup) {
        if (this.f7949a) {
            b(viewGroup);
        }
    }

    public void b(ViewGroup viewGroup) {
        ViewStub viewStub;
        if (viewGroup == null) {
            return;
        }
        this.f7949a = true;
        View findViewById = viewGroup.findViewById(R.id.navi_rg_safety_guide);
        this.b = findViewById;
        if (findViewById == null && (viewStub = (ViewStub) viewGroup.findViewById(R.id.navi_rg_safety_guide_stub)) != null) {
            this.b = viewStub.inflate();
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public boolean a() {
        View view = this.b;
        return view != null && view.getVisibility() == 0;
    }
}
