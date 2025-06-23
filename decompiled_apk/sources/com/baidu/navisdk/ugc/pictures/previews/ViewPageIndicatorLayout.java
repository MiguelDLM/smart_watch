package com.baidu.navisdk.ugc.pictures.previews;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class ViewPageIndicatorLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f8207a;
    private int b;
    private int c;
    private ArrayList<View> d;
    private int e;

    public ViewPageIndicatorLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        Resources resources = context.getResources();
        this.f8207a = resources.getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.navi_dimens_8dp);
        this.b = dimensionPixelSize;
        this.c = dimensionPixelSize;
    }

    private View c(int i) {
        View view = new View(getContext());
        view.setBackgroundResource(R.drawable.bnav_ugc_preview_pic_indicator_unselected);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.b, this.c);
        if (i != 0) {
            marginLayoutParams.leftMargin = this.f8207a;
        }
        addView(view, marginLayoutParams);
        return view;
    }

    @Nullable
    private View d(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("ViewPageIndicatorLayout", "getIndicatorView(), index = " + i);
        }
        ArrayList<View> arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (gVar.d()) {
                gVar.e("ViewPageIndicatorLayout", "getIndicatorView size: " + this.d.size());
            }
            if (i >= 0 && i < this.d.size()) {
                return this.d.get(i);
            }
        }
        return null;
    }

    public void b(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("ViewPageIndicatorLayout", "deleteIndicator index: " + i);
        }
        View d = d(i);
        if (d != null) {
            removeView(d);
            this.d.remove(i);
        }
        this.e = -1;
    }

    public ViewPageIndicatorLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPageIndicatorLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        a(context);
    }

    public void a(int i, int i2) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("ViewPageIndicatorLayout", "showIndicator(), indicatorSize = " + i + " currentIndex = " + i2);
        }
        ArrayList<View> arrayList = this.d;
        if (arrayList == null) {
            this.d = new ArrayList<>(i);
        } else {
            arrayList.clear();
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.d.add(c(i3));
        }
        a(i2);
    }

    public void a(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("ViewPageIndicatorLayout", "changeIndicatorState(), selectedIndex = " + i + ", mCurrentIndex:" + this.e);
        }
        if (i == this.e) {
            return;
        }
        View d = d(i);
        if (d != null) {
            d.setBackgroundResource(R.drawable.bnav_ugc_preview_pic_indicator_selected);
        }
        View d2 = d(this.e);
        if (d2 != null) {
            d2.setBackgroundResource(R.drawable.bnav_ugc_preview_pic_indicator_unselected);
        }
        this.e = i;
    }

    public void a() {
        ArrayList<View> arrayList = this.d;
        if (arrayList != null) {
            arrayList.clear();
            this.d = null;
        }
        removeAllViews();
    }
}
