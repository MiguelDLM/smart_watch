package androidx.fragment.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    @oOoXoXO
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;

    @OOXIXo
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;

    @OOXIXo
    private final List<View> transitioningFragmentViews;

    @RequiresApi(20)
    /* loaded from: classes.dex */
    public static final class Api20Impl {

        @OOXIXo
        public static final Api20Impl INSTANCE = new Api20Impl();

        private Api20Impl() {
        }

        @OOXIXo
        public final WindowInsets onApplyWindowInsets(@OOXIXo View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, @OOXIXo View v, @OOXIXo WindowInsets insets) {
            IIX0o.x0xO0oo(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            IIX0o.x0xO0oo(v, "v");
            IIX0o.x0xO0oo(insets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v, insets);
            IIX0o.oO(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FragmentContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@OOXIXo View child, int i, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        IIX0o.x0xO0oo(child, "child");
        if (FragmentManager.getViewFragment(child) != null) {
            super.addView(child, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    @OOXIXo
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(@OOXIXo WindowInsets insets) {
        WindowInsetsCompat onApplyWindowInsets;
        IIX0o.x0xO0oo(insets, "insets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets);
        IIX0o.oO(windowInsetsCompat, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            Api20Impl api20Impl = Api20Impl.INSTANCE;
            IIX0o.ooOOo0oXI(onApplyWindowInsetsListener);
            onApplyWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(api20Impl.onApplyWindowInsets(onApplyWindowInsetsListener, this, insets));
        } else {
            onApplyWindowInsets = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        }
        IIX0o.oO(onApplyWindowInsets, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!onApplyWindowInsets.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i), onApplyWindowInsets);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        if (this.drawDisappearingViewsFirst) {
            Iterator<T> it = this.disappearingFragmentChildren.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@OOXIXo Canvas canvas, @OOXIXo View child, long j) {
        IIX0o.x0xO0oo(canvas, "canvas");
        IIX0o.x0xO0oo(child, "child");
        if (this.drawDisappearingViewsFirst && !this.disappearingFragmentChildren.isEmpty() && this.disappearingFragmentChildren.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @Override // android.view.View
    @OOXIXo
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(@OOXIXo WindowInsets insets) {
        IIX0o.x0xO0oo(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View view = getChildAt(childCount);
                IIX0o.oO(view, "view");
                addDisappearingFragmentView(view);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        View view = getChildAt(i);
        IIX0o.oO(view, "view");
        addDisappearingFragmentView(view);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View view = getChildAt(i4);
            IIX0o.oO(view, "view");
            addDisappearingFragmentView(view);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View view = getChildAt(i4);
            IIX0o.oO(view, "view");
            addDisappearingFragmentView(view);
        }
        super.removeViewsInLayout(i, i2);
    }

    @XO0OX.xxIXOIIO(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean z) {
        this.drawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@oOoXoXO LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@OOXIXo View.OnApplyWindowInsetsListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.applyWindowInsetsListener = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@OOXIXo Context context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public FragmentContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String str;
        IIX0o.x0xO0oo(context, "context");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] FragmentContainerView = R.styleable.FragmentContainerView;
            IIX0o.oO(FragmentContainerView, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = O0IoXXOx.XO.f1157IXxxXO;
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@OOXIXo Context context, @OOXIXo AttributeSet attrs, @OOXIXo FragmentManager fm) {
        super(context, attrs);
        String str;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        IIX0o.x0xO0oo(fm, "fm");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = R.styleable.FragmentContainerView;
        IIX0o.oO(FragmentContainerView, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fm.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fm.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            IIX0o.oO(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.onInflate(context, attrs, (Bundle) null);
            fm.beginTransaction().setReorderingAllowed(true).add(this, instantiate, string).commitNowAllowingStateLoss();
        }
        fm.onContainerAvailable(this);
    }
}
