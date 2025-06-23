package com.baidu.navisdk.ugc.report.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public abstract class c extends a {
    private FrameLayout b;
    private Context c;

    private int g() {
        return R.layout.nsdk_layout_ugc_report_item_view;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public View a(Context context) {
        this.b = (FrameLayout) JarUtils.inflate(context, g(), null);
        this.c = context;
        View b = b(context);
        FrameLayout frameLayout = this.b;
        if (frameLayout != null && b != null) {
            frameLayout.addView(b);
        }
        return this.b;
    }

    public abstract void a(View view);

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void b() {
        FrameLayout frameLayout;
        if (this.c == null || (frameLayout = this.b) == null) {
            return;
        }
        frameLayout.removeAllViews();
        View b = b(this.c);
        if (b != null) {
            this.b.addView(b);
        }
    }

    public abstract int f();

    private View b(Context context) {
        View inflate = JarUtils.inflate(context, f(), null);
        inflate.setPadding(0, 0, 0, 0);
        a(inflate);
        return inflate;
    }
}
