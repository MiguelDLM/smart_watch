package androidx.fragment.app;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huawei.openalliance.ad.constant.bn;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class FragmentContainerView extends FrameLayout {
    @oOoXoXO
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    @OOXIXo
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    @OOXIXo
    private final List<View> transitioningFragmentViews;

    @RequiresApi(20)
    public static final class Api20Impl {
        @OOXIXo
        public static final Api20Impl INSTANCE = new Api20Impl();

        private Api20Impl() {
        }

        @OOXIXo
        public final WindowInsets onApplyWindowInsets(@OOXIXo View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, @OOXIXo View view, @OOXIXo WindowInsets windowInsets) {
            IIX0o.x0xO0oo(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            IIX0o.x0xO0oo(view, t.c);
            IIX0o.x0xO0oo(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            IIX0o.oO(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public FragmentContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (IIXOooo) null);
        IIX0o.x0xO0oo(context, bn.f.o);
    }

    private final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    public void addView(@OOXIXo View view, int i, @oOoXoXO ViewGroup.LayoutParams layoutParams) {
        IIX0o.x0xO0oo(view, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (FragmentManager.getViewFragment(view) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @RequiresApi(20)
    @OOXIXo
    public WindowInsets dispatchApplyWindowInsets(@OOXIXo WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        IIX0o.x0xO0oo(windowInsets, "insets");
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        IIX0o.oO(windowInsetsCompat2, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            Api20Impl api20Impl = Api20Impl.INSTANCE;
            IIX0o.ooOOo0oXI(onApplyWindowInsetsListener);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(api20Impl.onApplyWindowInsets(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            windowInsetsCompat = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat2);
        }
        IIX0o.oO(windowInsetsCompat, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!windowInsetsCompat.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(@OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        if (this.drawDisappearingViewsFirst) {
            for (View drawChild : this.disappearingFragmentChildren) {
                super.drawChild(canvas, drawChild, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(@OOXIXo Canvas canvas, @OOXIXo View view, long j) {
        IIX0o.x0xO0oo(canvas, "canvas");
        IIX0o.x0xO0oo(view, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (!this.drawDisappearingViewsFirst || this.disappearingFragmentChildren.isEmpty() || !this.disappearingFragmentChildren.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    public void endViewTransition(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @RequiresApi(20)
    @OOXIXo
    public WindowInsets onApplyWindowInsets(@OOXIXo WindowInsets windowInsets) {
        IIX0o.x0xO0oo(windowInsets, "insets");
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                IIX0o.oO(childAt, ViewHierarchyConstants.VIEW_KEY);
                addDisappearingFragmentView(childAt);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    public void removeView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        View childAt = getChildAt(i);
        IIX0o.oO(childAt, ViewHierarchyConstants.VIEW_KEY);
        addDisappearingFragmentView(childAt);
        super.removeViewAt(i);
    }

    public void removeViewInLayout(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            IIX0o.oO(childAt, ViewHierarchyConstants.VIEW_KEY);
            addDisappearingFragmentView(childAt);
        }
        super.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            IIX0o.oO(childAt, ViewHierarchyConstants.VIEW_KEY);
            addDisappearingFragmentView(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    @xxIXOIIO(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean z) {
        this.drawDisappearingViewsFirst = z;
    }

    public void setLayoutTransition(@oOoXoXO LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(@OOXIXo View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IIX0o.x0xO0oo(onApplyWindowInsetsListener, "listener");
        this.applyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void startViewTransition(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@OOXIXo Context context) {
        super(context);
        IIX0o.x0xO0oo(context, bn.f.o);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @xoIox
    public FragmentContainerView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String str;
        IIX0o.x0xO0oo(context, bn.f.o);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R.styleable.FragmentContainerView;
            IIX0o.oO(iArr, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = XO.f15413IXxxXO;
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@OOXIXo Context context, @OOXIXo AttributeSet attributeSet, @OOXIXo FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(attributeSet, "attrs");
        IIX0o.x0xO0oo(fragmentManager, "fm");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R.styleable.FragmentContainerView;
        IIX0o.oO(iArr, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            IIX0o.oO(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add((ViewGroup) this, instantiate, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }
}
