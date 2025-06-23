package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class LightNaviTabsBar extends LightNaviTabBar {

    /* renamed from: a, reason: collision with root package name */
    private a[] f6892a;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f6893a;
        TextView b;
        ImageView c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;
        ImageView h;
    }

    public LightNaviTabsBar(Context context) {
        super(context);
        this.f6892a = new a[3];
        a();
    }

    private void a() {
        JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
        JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_11dp);
        JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
        JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_2dp);
    }

    private Drawable b(int i) {
        if (i == 0) {
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_light_navi_label_1_selector);
        }
        if (i == 1) {
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_light_navi_label_2_selector);
        }
        if (i == 2) {
            return JarUtils.getResources().getDrawable(R.drawable.nsdk_light_navi_label_3_selector);
        }
        return null;
    }

    private void c(int i) {
        boolean z;
        LogUtil.e("RouteCarTabBarLand", "updateColorOnItemSelected currentIndex = " + i);
        for (int i2 = 0; i2 < 3; i2++) {
            int a2 = a(i2);
            if (a2 == i) {
                z = true;
            } else {
                z = false;
            }
            a(i2, a2, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setCurrentIndex(int i) {
        LogUtil.e("RouteCarTabBarLand", "setCurrentIndex index = " + i);
        c(i);
    }

    public void setTabClickListener(View.OnClickListener onClickListener) {
        this.f6892a[0].f6893a.setOnClickListener(onClickListener);
        this.f6892a[0].f6893a.setTag(0);
        this.f6892a[1].f6893a.setOnClickListener(onClickListener);
        this.f6892a[1].f6893a.setTag(1);
        this.f6892a[2].f6893a.setOnClickListener(onClickListener);
        this.f6892a[2].f6893a.setTag(2);
    }

    public LightNaviTabsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6892a = new a[3];
        a();
    }

    private void a(int i, int i2, boolean z) {
        a aVar = this.f6892a[i];
        TextView textView = aVar.d;
        TextView textView2 = aVar.e;
        TextView textView3 = aVar.b;
        ImageView imageView = aVar.h;
        TextView textView4 = aVar.f;
        TextView textView5 = aVar.g;
        ImageView imageView2 = aVar.c;
        RelativeLayout relativeLayout = aVar.f6893a;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteCarTabBarLand", "updateColorOnItemSelected i = " + i + ",left2Right=" + i2 + ",sel=" + z);
        }
        textView3.setSelected(z);
        a(imageView2, i2, z);
        a(z, textView, textView2, textView3, textView4, textView5);
        a(z, relativeLayout);
        a(z, imageView);
        textView4.setSelected(z);
        textView5.setSelected(z);
        if (z) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
    }

    public LightNaviTabsBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6892a = new a[3];
        a();
    }

    private void a(boolean z, ImageView imageView) {
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private int a(boolean z) {
        if (z) {
            return getResources().getColor(R.color.nsdk_light_navi_tab_text_selected);
        }
        return getResources().getColor(R.color.nsdk_light_navi_tab_text_unselected);
    }

    private void a(boolean z, View view) {
        int color;
        if (z) {
            color = getResources().getColor(R.color.nsdk_light_navi_tab_bg_selected);
        } else {
            color = getResources().getColor(R.color.nsdk_light_navi_tab_bg_unselected);
        }
        view.setBackgroundColor(color);
    }

    private void a(boolean z, TextView... textViewArr) {
        int a2 = a(z);
        for (TextView textView : textViewArr) {
            textView.setTextColor(a2);
        }
    }

    private void a(ImageView imageView, int i, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteCarTabBarLand", "setLabelIcon,left2Right = " + i + ",sel=" + z);
        }
        if (i < 0 || i >= 3) {
            return;
        }
        imageView.setImageDrawable(b(i));
        imageView.setSelected(z);
    }

    public int a(int i) {
        a[] aVarArr = this.f6892a;
        a aVar = aVarArr[0];
        a aVar2 = aVarArr[1];
        a aVar3 = aVarArr[2];
        boolean z = aVar.f6893a.getVisibility() == 0;
        boolean z2 = aVar2.f6893a.getVisibility() == 0;
        boolean z3 = aVar3.f6893a.getVisibility() == 0;
        if (i == 0) {
            if (z) {
                return 0;
            }
        } else if (i == 1) {
            if (!z) {
                i--;
            }
            if (z2) {
                return i;
            }
        } else {
            if (i != 2) {
                return i;
            }
            if (!z) {
                i--;
            }
            if (!z2) {
                i--;
            }
            if (z3) {
                return i;
            }
        }
        return -1;
    }
}
