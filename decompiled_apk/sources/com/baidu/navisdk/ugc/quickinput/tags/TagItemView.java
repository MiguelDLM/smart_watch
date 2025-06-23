package com.baidu.navisdk.ugc.quickinput.tags;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class TagItemView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f8229a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public TagItemView(Context context) {
        super(context);
        this.f8229a = -1;
        this.b = ScreenUtil.getInstance().dip2px(0.5f);
        this.c = ScreenUtil.getInstance().dip2px(3);
        this.d = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_ugc_quick_input_tag_unselected, true);
        this.e = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true);
        this.f = com.baidu.navisdk.ui.util.b.a(R.color.ugc_rg_transparent, true);
        a();
    }

    private void a() {
        setTextSize(0, ScreenUtil.getInstance().dip2px(14));
        setGravity(17);
    }

    public int getType() {
        return this.f8229a;
    }

    public void a(String str, int i, boolean z) {
        setText(str);
        this.f8229a = i;
        a(z);
    }

    public void a(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.c);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(this.f);
        if (z) {
            gradientDrawable.setStroke(this.b, this.e);
            setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_link_ugc_a));
        } else {
            gradientDrawable.setStroke(this.b, this.d);
            setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_ugc_a));
        }
        setBackgroundDrawable(gradientDrawable);
    }

    public TagItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8229a = -1;
        this.b = ScreenUtil.getInstance().dip2px(0.5f);
        this.c = ScreenUtil.getInstance().dip2px(3);
        this.d = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_ugc_quick_input_tag_unselected, true);
        this.e = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true);
        this.f = com.baidu.navisdk.ui.util.b.a(R.color.ugc_rg_transparent, true);
        a();
    }

    public TagItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8229a = -1;
        this.b = ScreenUtil.getInstance().dip2px(0.5f);
        this.c = ScreenUtil.getInstance().dip2px(3);
        this.d = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_ugc_quick_input_tag_unselected, true);
        this.e = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true);
        this.f = com.baidu.navisdk.ui.util.b.a(R.color.ugc_rg_transparent, true);
        a();
    }
}
