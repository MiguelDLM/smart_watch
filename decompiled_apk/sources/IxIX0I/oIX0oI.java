package IxIX0I;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f1089I0Io = 800;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f1090II0xO0 = 400;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static int f1091oIX0oI = 150;

    /* loaded from: classes11.dex */
    public interface oxoX {
        boolean onAnimationCancel(View view);

        boolean onAnimationEnd(View view);

        boolean onAnimationStart(View view);
    }

    public static void I0Io(View view) {
        oxoX(view, f1091oIX0oI);
    }

    public static void II0XooXoX(View view, int i, oxoX oxox) {
        ViewCompat.animate(view).alpha(0.0f).setDuration(i).setListener(new I0Io(oxox));
    }

    public static void II0xO0(View view, View view2, int i) {
        oxoX(view, i);
        Oxx0IOOO(view2, i);
    }

    public static void Oxx0IOOO(View view, int i) {
        II0XooXoX(view, i, null);
    }

    public static void X0o0xo(View view, int i, oxoX oxox) {
        C0028oIX0oI c0028oIX0oI;
        view.setVisibility(0);
        view.setAlpha(0.0f);
        if (oxox != null) {
            c0028oIX0oI = new C0028oIX0oI(oxox);
        } else {
            c0028oIX0oI = null;
        }
        ViewCompat.animate(view).alpha(1.0f).setDuration(i).setListener(c0028oIX0oI);
    }

    public static void XO(View view) {
        Oxx0IOOO(view, f1091oIX0oI);
    }

    public static void oIX0oI(View view, View view2) {
        II0xO0(view, view2, f1091oIX0oI);
    }

    public static void oxoX(View view, int i) {
        X0o0xo(view, i, null);
    }

    @TargetApi(21)
    public static void xxIXOIIO(View view, oxoX oxox) {
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getWidth() - ((int) TypedValue.applyDimension(1, 24.0f, view.getResources().getDisplayMetrics())), view.getHeight() / 2, 0.0f, Math.max(view.getWidth(), view.getHeight()));
        view.setVisibility(0);
        createCircularReveal.addListener(new II0xO0(oxox, view));
        createCircularReveal.start();
    }

    /* loaded from: classes11.dex */
    public static class I0Io implements ViewPropertyAnimatorListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ oxoX f1092oIX0oI;

        public I0Io(oxoX oxox) {
            this.f1092oIX0oI = oxox;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            oxoX oxox = this.f1092oIX0oI;
            if (oxox == null || !oxox.onAnimationEnd(view)) {
                view.setVisibility(8);
                view.setDrawingCacheEnabled(false);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            oxoX oxox = this.f1092oIX0oI;
            if (oxox == null || !oxox.onAnimationStart(view)) {
                view.setDrawingCacheEnabled(true);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }
    }

    /* loaded from: classes11.dex */
    public static class II0xO0 extends AnimatorListenerAdapter {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ View f1093Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oxoX f1094XO;

        public II0xO0(oxoX oxox, View view) {
            this.f1094XO = oxox;
            this.f1093Oo = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1094XO.onAnimationCancel(this.f1093Oo);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1094XO.onAnimationEnd(this.f1093Oo);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1094XO.onAnimationStart(this.f1093Oo);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: IxIX0I.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0028oIX0oI implements ViewPropertyAnimatorListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ oxoX f1095oIX0oI;

        public C0028oIX0oI(oxoX oxox) {
            this.f1095oIX0oI = oxox;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (!this.f1095oIX0oI.onAnimationEnd(view)) {
                view.setDrawingCacheEnabled(false);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (!this.f1095oIX0oI.onAnimationStart(view)) {
                view.setDrawingCacheEnabled(true);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }
    }
}
