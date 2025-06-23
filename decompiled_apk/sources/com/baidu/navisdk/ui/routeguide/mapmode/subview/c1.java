package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private ViewGroup i;
    private View j;
    private TextView k;

    public c1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        o0();
        a(com.baidu.navisdk.ui.util.b.b());
        n0();
    }

    private void n0() {
    }

    private void o0() {
        ViewGroup viewGroup;
        if (this.b == null || (viewGroup = this.i) == null) {
            return;
        }
        viewGroup.removeAllViews();
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_common_card, null);
        this.j = inflate;
        if (this.i != null) {
            this.k = (TextView) inflate.findViewById(R.id.common_card_text);
        }
        if (this.k != null) {
            this.i.addView(this.j, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e("RGMMUgcOfficialEventView", "hide()");
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        LogUtil.e("RGMMUgcOfficialEventView", "show()");
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(JNIGuidanceControl.getInstance().GetRoadEventText());
            return true;
        }
        return true;
    }
}
