package com.baidu.navisdk.routetab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/* loaded from: classes7.dex */
public class MultiTabHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private a f7975a;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public MultiTabHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f7975a != null) {
            if (getScrollX() == 0) {
                this.f7975a.c();
                return;
            }
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getMeasuredWidth() == getScrollX() + getWidth()) {
                this.f7975a.b();
            } else {
                this.f7975a.a();
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f7975a = aVar;
    }

    public MultiTabHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
