package com.baidu.navisdk.module.routeresultbase.view.support.module.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class BNBlankView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f7522a;

    public BNBlankView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f7522a = i;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(-1, i2);
        if (this.f7522a <= 0) {
            this.f7522a = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rr_bottom_footer_height);
        }
        setMeasuredDimension(getMeasuredWidth(), this.f7522a);
    }
}
