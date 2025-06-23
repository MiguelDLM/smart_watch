package com.baidu.navisdk.ugc.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

/* loaded from: classes8.dex */
public class k {

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8343a;
        final /* synthetic */ int b;

        public a(View view, int i) {
            this.f8343a = view;
            this.b = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable drawable;
            View view2 = this.f8343a;
            if (view2 instanceof ImageView) {
                drawable = ((ImageView) view2).getDrawable();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = this.f8343a.getBackground();
            }
            if (drawable == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                drawable.setColorFilter(this.b, PorterDuff.Mode.MULTIPLY);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                drawable.clearColorFilter();
            }
            return false;
        }
    }

    public static void a(View view, @ColorInt int i) {
        a(view, view, i);
    }

    public static void a(View view, View view2, @ColorInt int i) {
        if (view2 == null || view == null) {
            return;
        }
        view.setOnTouchListener(new a(view2, i));
    }
}
