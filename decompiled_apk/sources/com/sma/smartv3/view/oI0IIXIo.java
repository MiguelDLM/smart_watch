package com.sma.smartv3.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes12.dex */
public class oI0IIXIo {

    /* loaded from: classes12.dex */
    public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ View f25472IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f25473Oo;

        /* renamed from: XO, reason: collision with root package name */
        public int f25474XO;

        public oIX0oI(final View val$parent) {
            this.f25472IXxxXO = val$parent;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            this.f25473Oo = ((Integer) animation.getAnimatedValue()).intValue() - this.f25474XO;
            this.f25474XO = ((Integer) animation.getAnimatedValue()).intValue();
            this.f25472IXxxXO.scrollBy(0, this.f25473Oo);
        }
    }

    public static x0XOIxOo II0xO0(ViewGroup child) {
        int i = 0;
        for (ViewParent parent = child.getParent(); parent != null; parent = parent.getParent()) {
            if (!(parent instanceof RecyclerView) && !(parent instanceof AbsListView)) {
                i++;
            } else {
                x0XOIxOo x0xoixoo = new x0XOIxOo();
                x0xoixoo.f25772oIX0oI = (ViewGroup) parent;
                x0xoixoo.f25771II0xO0 = i;
                return x0xoixoo;
            }
        }
        return null;
    }

    public static ValueAnimator oIX0oI(final View parent, int distance, long duration) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, distance);
        ofInt.addUpdateListener(new oIX0oI(parent));
        ofInt.setDuration(duration);
        return ofInt;
    }
}
