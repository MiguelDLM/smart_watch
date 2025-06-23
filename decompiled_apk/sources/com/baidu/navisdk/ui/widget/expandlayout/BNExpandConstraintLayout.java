package com.baidu.navisdk.ui.widget.expandlayout;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.f;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$simpleOnGestureListener$2;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.b;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNExpandConstraintLayout extends ConstraintLayout implements IExpandConstraintLayout {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int MIN_DISTANCE = 150;

    @OOXIXo
    public static final String TAG = "ExpandConstraintLayout";
    private Adapter adapter;
    private final LinearLayout bottomFixedItemLy;
    private Rect bottomFixedLyBgPaddingRect;
    private final X0IIOO detector$delegate;
    private int dynamicLayoutMoveDownMargin;
    private Rect dynamicLyBgPaddingRect;
    private boolean isFixationOpenStatus;
    private View mBottomItemView;
    private ValueAnimator mCloseAnimator;
    private int mCurOrientation;
    private State mCurState;
    private final HashMap<Integer, ArrayList<AddedViewWrapper>> mDynamicAddedItemList;
    private final ArrayList<View> mDynamicItemAddedDividerList;
    private final ArrayList<View> mDynamicItemRemovedDividerList;
    private final X0IIOO mDynamicLayoutChangeListener$delegate;
    private final HashMap<Integer, ArrayList<View>> mDynamicRemovedItemList;
    private int mDynamicScrollHeight;
    private View mFixedHeadView;
    private boolean mHasScroll;
    private ArrayList<WeakReference<IExpandLayoutChangeListener>> mLayoutChangeListenerList;
    private IExpandItemOnClickListener mOnClickItemListener;
    private ValueAnimator mOpenAnimator;
    private ArrayList<WeakReference<IExpandLayoutStatusCallback>> mStatusChangeListenerList;
    private final View mTopDynamicParentLayout;
    private final X0IIOO simpleOnGestureListener$delegate;
    private final Space space;
    private boolean supportNightMode;
    private final LinearLayout topDynamicLayout;

    /* loaded from: classes8.dex */
    public static abstract class Adapter implements IExpandConstraintLayout {
        private WeakReference<IExpandConstraintLayout> iExpandConstraintLayout;

        public long getAnimationDuration() {
            return 500L;
        }

        public abstract int getDynamicItemSize();

        public int getItemViewType(int i) {
            return 0;
        }

        @oOoXoXO
        public abstract View onCreateBottomFixedView(@OOXIXo Context context, @OOXIXo ViewGroup viewGroup, @oOoXoXO View view, boolean z, int i);

        @oOoXoXO
        public abstract View onCreateDynamicHeadView(@OOXIXo Context context, @OOXIXo ViewGroup viewGroup, @oOoXoXO View view, boolean z, int i);

        @OOXIXo
        public abstract View onCreateDynamicItemDivider(@OOXIXo Context context, @OOXIXo ViewGroup viewGroup, @oOoXoXO View view, boolean z, int i);

        @oOoXoXO
        public abstract View onCreateDynamicView(@OOXIXo Context context, @OOXIXo ViewGroup viewGroup, int i, @oOoXoXO View view, boolean z, int i2, int i3);

        public void onOrientationBottomFixedView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(parentView, "parentView");
        }

        public void onOrientationDynamicDivider(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(parentView, "parentView");
        }

        public void onOrientationDynamicHeadView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(parentView, "parentView");
        }

        public void onOrientationDynamicView(@OOXIXo Context context, @OOXIXo ViewGroup parentView, @oOoXoXO View view, int i, int i2) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(parentView, "parentView");
        }

        @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
        public void onUpdateAllDynamicItem() {
            IExpandConstraintLayout iExpandConstraintLayout;
            WeakReference<IExpandConstraintLayout> weakReference = this.iExpandConstraintLayout;
            if (weakReference != null && (iExpandConstraintLayout = weakReference.get()) != null) {
                iExpandConstraintLayout.onUpdateAllDynamicItem();
            }
        }

        @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
        public void onUpdateBottomFixedView() {
            IExpandConstraintLayout iExpandConstraintLayout;
            WeakReference<IExpandConstraintLayout> weakReference = this.iExpandConstraintLayout;
            if (weakReference != null && (iExpandConstraintLayout = weakReference.get()) != null) {
                iExpandConstraintLayout.onUpdateBottomFixedView();
            }
        }

        @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
        public void onUpdateDynamicItem(@oOoXoXO String str, int i) {
            IExpandConstraintLayout iExpandConstraintLayout;
            WeakReference<IExpandConstraintLayout> weakReference = this.iExpandConstraintLayout;
            if (weakReference != null && (iExpandConstraintLayout = weakReference.get()) != null) {
                iExpandConstraintLayout.onUpdateDynamicItem(str, i);
            }
        }

        public final void setExpandConstraintLayout(@oOoXoXO IExpandConstraintLayout iExpandConstraintLayout) {
            if (iExpandConstraintLayout == null) {
                this.iExpandConstraintLayout = null;
            } else {
                this.iExpandConstraintLayout = new WeakReference<>(iExpandConstraintLayout);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class AddedViewWrapper {
        private int index;

        @oOoXoXO
        private View view;

        public AddedViewWrapper(@oOoXoXO View view, int i) {
            this.view = view;
            this.index = i;
        }

        public static /* synthetic */ AddedViewWrapper copy$default(AddedViewWrapper addedViewWrapper, View view, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                view = addedViewWrapper.view;
            }
            if ((i2 & 2) != 0) {
                i = addedViewWrapper.index;
            }
            return addedViewWrapper.copy(view, i);
        }

        @oOoXoXO
        public final View component1() {
            return this.view;
        }

        public final int component2() {
            return this.index;
        }

        @OOXIXo
        public final AddedViewWrapper copy(@oOoXoXO View view, int i) {
            return new AddedViewWrapper(view, i);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddedViewWrapper)) {
                return false;
            }
            AddedViewWrapper addedViewWrapper = (AddedViewWrapper) obj;
            return IIX0o.Oxx0IOOO(this.view, addedViewWrapper.view) && this.index == addedViewWrapper.index;
        }

        public final int getIndex() {
            return this.index;
        }

        @oOoXoXO
        public final View getView() {
            return this.view;
        }

        public int hashCode() {
            View view = this.view;
            return ((view != null ? view.hashCode() : 0) * 31) + this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final void setView(@oOoXoXO View view) {
            this.view = view;
        }

        @OOXIXo
        public String toString() {
            return "AddedViewWrapper(view=" + this.view + ", index=" + this.index + oIX0oI.I0Io.f4095I0Io;
        }

        public /* synthetic */ AddedViewWrapper(View view, int i, int i2, IIXOooo iIXOooo) {
            this(view, (i2 & 2) != 0 ? -1 : i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public enum State {
        OPEN,
        CLOSE
    }

    @xoIox
    public BNExpandConstraintLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    private final void addDynamicItemDividerIfNeed(int i, int i2) {
        View view;
        if (i != i2 - 1) {
            View view2 = (View) OxI.xI0oxI00(this.mDynamicItemRemovedDividerList);
            Adapter adapter = this.adapter;
            if (adapter != null) {
                Context context = getContext();
                IIX0o.oO(context, "context");
                view = adapter.onCreateDynamicItemDivider(context, this, view2, this.supportNightMode, this.mCurOrientation);
            } else {
                view = null;
            }
            if (view != null) {
                this.mDynamicItemAddedDividerList.add(view);
                this.topDynamicLayout.addView(view);
            }
        }
    }

    private final boolean addDynamicItemView(int i) {
        int i2;
        View view;
        Adapter adapter = this.adapter;
        if (adapter != null) {
            i2 = adapter.getItemViewType(i);
        } else {
            i2 = 0;
        }
        View removeLastOrNullFromRemovedItemList = removeLastOrNullFromRemovedItemList(i2);
        Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            Context context = getContext();
            IIX0o.oO(context, "context");
            view = adapter2.onCreateDynamicView(context, this, i, removeLastOrNullFromRemovedItemList, this.supportNightMode, this.mCurOrientation, i2);
        } else {
            view = null;
        }
        if (view == null) {
            return false;
        }
        addViewToDynamicAddedItemList(view, i2, i);
        this.topDynamicLayout.addView(view);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$addDynamicItemView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IExpandItemOnClickListener iExpandItemOnClickListener = BNExpandConstraintLayout.this.mOnClickItemListener;
                if (iExpandItemOnClickListener != null) {
                    IIX0o.oO(it, "it");
                    Object tag = it.getTag();
                    if (!(tag instanceof String)) {
                        tag = null;
                    }
                    iExpandItemOnClickListener.onClickDynamicItem((String) tag, it);
                }
            }
        });
        return true;
    }

    private final void addViewToDynamicAddedItemList(View view, int i, int i2) {
        ArrayList<AddedViewWrapper> arrayList = this.mDynamicAddedItemList.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList<>(4);
            this.mDynamicAddedItemList.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(new AddedViewWrapper(view, i2));
    }

    private final void cancelAnimation() {
        ValueAnimator valueAnimator = this.mCloseAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mOpenAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        updateSpaceMarginByState();
    }

    public static /* synthetic */ void close$default(BNExpandConstraintLayout bNExpandConstraintLayout, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        bNExpandConstraintLayout.close(z);
    }

    private final View createDynamicItemDividerIfNeed(int i, int i2) {
        if (i == i2 - 1) {
            return null;
        }
        View view = (View) OxI.xI0oxI00(this.mDynamicItemRemovedDividerList);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            return null;
        }
        Context context = getContext();
        IIX0o.oO(context, "context");
        return adapter.onCreateDynamicItemDivider(context, this, view, this.supportNightMode, this.mCurOrientation);
    }

    private final long getAnimatorDuration() {
        Adapter adapter = this.adapter;
        if (adapter != null) {
            return adapter.getAnimationDuration();
        }
        return 500L;
    }

    private final GestureDetector getDetector() {
        return (GestureDetector) this.detector$delegate.getValue();
    }

    private final View.OnLayoutChangeListener getMDynamicLayoutChangeListener() {
        return (View.OnLayoutChangeListener) this.mDynamicLayoutChangeListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BNExpandConstraintLayout$simpleOnGestureListener$2.AnonymousClass1 getSimpleOnGestureListener() {
        return (BNExpandConstraintLayout$simpleOnGestureListener$2.AnonymousClass1) this.simpleOnGestureListener$delegate.getValue();
    }

    private final View getViewFromAddedItemList(int i, String str, int i2) {
        ArrayList<AddedViewWrapper> arrayList;
        if (str != null && str.length() != 0 && (arrayList = this.mDynamicAddedItemList.get(Integer.valueOf(i))) != null) {
            Iterator<AddedViewWrapper> it = arrayList.iterator();
            while (it.hasNext()) {
                AddedViewWrapper next = it.next();
                if (next.getIndex() == i2) {
                    return next.getView();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAnimating() {
        ValueAnimator valueAnimator = this.mOpenAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        ValueAnimator valueAnimator2 = this.mCloseAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDynamicLayoutChange() {
        ArrayList<WeakReference<IExpandLayoutChangeListener>> arrayList = this.mLayoutChangeListenerList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                IExpandLayoutChangeListener iExpandLayoutChangeListener = (IExpandLayoutChangeListener) ((WeakReference) it.next()).get();
                if (iExpandLayoutChangeListener != null) {
                    iExpandLayoutChangeListener.onDynamicLayoutChange();
                }
            }
        }
    }

    private final void notifyOnAnimStart4StatusChange(State state) {
        ArrayList<WeakReference<IExpandLayoutStatusCallback>> arrayList = this.mStatusChangeListenerList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                IExpandLayoutStatusCallback iExpandLayoutStatusCallback = (IExpandLayoutStatusCallback) ((WeakReference) it.next()).get();
                if (iExpandLayoutStatusCallback != null) {
                    iExpandLayoutStatusCallback.onAnimStart4StatusChange(state);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyOnFlingStatusChange(State state) {
        ArrayList<WeakReference<IExpandLayoutStatusCallback>> arrayList = this.mStatusChangeListenerList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                IExpandLayoutStatusCallback iExpandLayoutStatusCallback = (IExpandLayoutStatusCallback) ((WeakReference) it.next()).get();
                if (iExpandLayoutStatusCallback != null) {
                    iExpandLayoutStatusCallback.onFlingStatusChange(state);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyStatusChange(State state) {
        ArrayList<WeakReference<IExpandLayoutStatusCallback>> arrayList = this.mStatusChangeListenerList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                IExpandLayoutStatusCallback iExpandLayoutStatusCallback = (IExpandLayoutStatusCallback) ((WeakReference) it.next()).get();
                if (iExpandLayoutStatusCallback != null) {
                    iExpandLayoutStatusCallback.onStatusChange(state);
                }
            }
        }
    }

    public static /* synthetic */ void open$default(BNExpandConstraintLayout bNExpandConstraintLayout, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        bNExpandConstraintLayout.open(z);
    }

    private final void recycleDynamicItemDividerView(View view) {
        if (view != null) {
            b.a(view);
            this.mDynamicItemRemovedDividerList.add(view);
        }
    }

    private final void recycleDynamicItemView(View view, int i) {
        if (view != null) {
            b.a(view);
            view.setTag(null);
            view.setOnClickListener(null);
            ArrayList<View> arrayList = this.mDynamicRemovedItemList.get(Integer.valueOf(i));
            if (arrayList == null) {
                arrayList = new ArrayList<>(4);
                this.mDynamicRemovedItemList.put(Integer.valueOf(i), arrayList);
            }
            arrayList.add(view);
        }
    }

    private final View removeLastOrNullFromRemovedItemList(int i) {
        ArrayList<View> arrayList = this.mDynamicRemovedItemList.get(Integer.valueOf(i));
        if (arrayList != null) {
            return (View) OxI.xI0oxI00(arrayList);
        }
        return null;
    }

    private final void updateAnimation() {
        ValueAnimator valueAnimator = this.mCloseAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.mOpenAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            valueAnimator2.removeAllUpdateListeners();
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.mDynamicScrollHeight);
        this.mCloseAnimator = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(getAnimatorDuration());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$updateAnimation$$inlined$run$lambda$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    BNExpandConstraintLayout.State state;
                    state = BNExpandConstraintLayout.this.mCurState;
                    if (state == BNExpandConstraintLayout.State.CLOSE) {
                        IIX0o.oO(it, "it");
                        Object animatedValue = it.getAnimatedValue();
                        if (animatedValue != null) {
                            BNExpandConstraintLayout.this.updateSpaceTopMargin(((Integer) animatedValue).intValue());
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$updateAnimation$$inlined$run$lambda$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    super.onAnimationCancel(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mCloseAnimator: onAnimationCancel:");
                        state = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    BNExpandConstraintLayout.State state2;
                    BNExpandConstraintLayout.State state3;
                    super.onAnimationEnd(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mCloseAnimator: onAnimationEnd:");
                        state3 = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state3);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                    state = BNExpandConstraintLayout.this.mCurState;
                    if (state == BNExpandConstraintLayout.State.CLOSE) {
                        BNExpandConstraintLayout bNExpandConstraintLayout = BNExpandConstraintLayout.this;
                        state2 = bNExpandConstraintLayout.mCurState;
                        bNExpandConstraintLayout.notifyStatusChange(state2);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    super.onAnimationStart(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mCloseAnimator: onAnimationStart:");
                        state = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                }
            });
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(-this.mDynamicScrollHeight, 0);
        this.mOpenAnimator = ofInt2;
        if (ofInt2 != null) {
            ofInt2.setDuration(getAnimatorDuration());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$updateAnimation$$inlined$run$lambda$3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    BNExpandConstraintLayout.State state;
                    state = BNExpandConstraintLayout.this.mCurState;
                    if (state == BNExpandConstraintLayout.State.OPEN) {
                        IIX0o.oO(it, "it");
                        Object animatedValue = it.getAnimatedValue();
                        if (animatedValue != null) {
                            BNExpandConstraintLayout.this.updateSpaceTopMargin(((Integer) animatedValue).intValue());
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            });
            ofInt2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$updateAnimation$$inlined$run$lambda$4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    super.onAnimationCancel(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mOpenAnimator: onAnimationCancel:");
                        state = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    super.onAnimationEnd(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mOpenAnimator: onAnimationEnd:");
                        state = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(@oOoXoXO Animator animator) {
                    BNExpandConstraintLayout.State state;
                    super.onAnimationStart(animator);
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mOpenAnimator: onAnimationStart:");
                        state = BNExpandConstraintLayout.this.mCurState;
                        sb.append(state);
                        gVar.e(BNExpandConstraintLayout.TAG, sb.toString());
                    }
                }
            });
        }
    }

    private final void updateDynamicScrollHeight() {
        if (this.isFixationOpenStatus) {
            return;
        }
        Iterator<Map.Entry<Integer, ArrayList<AddedViewWrapper>>> it = this.mDynamicAddedItemList.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<T> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                i += viewHeight(((AddedViewWrapper) it2.next()).getView());
            }
        }
        Iterator<T> it3 = this.mDynamicItemAddedDividerList.iterator();
        while (it3.hasNext()) {
            i += viewHeight((View) it3.next());
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onUpdateAllDynamicItem: " + this.mDynamicScrollHeight + ", " + i);
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateAllDynamicItem: ");
            sb.append(this.mCurState);
            gVar.e(TAG, sb.toString());
        }
        if (i != this.mDynamicScrollHeight) {
            this.mDynamicScrollHeight = i;
            cancelAnimation();
            updateSpaceMarginByState();
            updateAnimation();
        }
    }

    private final void updateSpaceMarginByState() {
        int i;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "updateSpaceMarginByState: ");
        }
        if (this.mCurState == State.CLOSE) {
            i = -this.mDynamicScrollHeight;
        } else {
            i = 0;
        }
        updateSpaceTopMargin(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSpaceTopMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.topDynamicLayout.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                this.topDynamicLayout.requestLayout();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final int viewHeight(View view) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams2 = layoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (marginLayoutParams != null) {
            return marginLayoutParams.height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public final void attachAdapter(@oOoXoXO Adapter adapter, int i) {
        View view;
        if (IIX0o.Oxx0IOOO(this.adapter, adapter)) {
            return;
        }
        this.mCurOrientation = i;
        this.adapter = adapter;
        if (adapter != null) {
            adapter.setExpandConstraintLayout(this);
        }
        if (this.topDynamicLayout.getChildCount() > 0) {
            this.topDynamicLayout.removeAllViews();
        }
        if (this.bottomFixedItemLy.getChildCount() > 0) {
            this.bottomFixedItemLy.removeAllViews();
        }
        for (Map.Entry<Integer, ArrayList<AddedViewWrapper>> entry : this.mDynamicAddedItemList.entrySet()) {
            int intValue = entry.getKey().intValue();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                recycleDynamicItemView(((AddedViewWrapper) it.next()).getView(), intValue);
            }
        }
        Iterator<T> it2 = this.mDynamicItemAddedDividerList.iterator();
        while (it2.hasNext()) {
            recycleDynamicItemDividerView((View) it2.next());
        }
        this.mDynamicAddedItemList.clear();
        this.mDynamicItemAddedDividerList.clear();
        if (adapter != null) {
            Context context = getContext();
            IIX0o.oO(context, "context");
            view = adapter.onCreateDynamicHeadView(context, this, null, this.supportNightMode, this.mCurOrientation);
        } else {
            view = null;
        }
        this.mFixedHeadView = view;
        if (view != null) {
            b.a(view);
            this.topDynamicLayout.addView(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$attachAdapter$$inlined$run$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it3) {
                    BNExpandConstraintLayout.State state;
                    if (!f.a(BNExpandConstraintLayout.TAG)) {
                        IExpandItemOnClickListener iExpandItemOnClickListener = BNExpandConstraintLayout.this.mOnClickItemListener;
                        if (iExpandItemOnClickListener != null) {
                            IIX0o.oO(it3, "it");
                            if (iExpandItemOnClickListener.onClickTopFixedItem(it3)) {
                                return;
                            }
                        }
                        state = BNExpandConstraintLayout.this.mCurState;
                        if (state == BNExpandConstraintLayout.State.CLOSE) {
                            BNExpandConstraintLayout.open$default(BNExpandConstraintLayout.this, false, 1, null);
                        } else {
                            BNExpandConstraintLayout.close$default(BNExpandConstraintLayout.this, false, 1, null);
                        }
                    }
                }
            });
        }
    }

    public final void close(boolean z) {
        ValueAnimator valueAnimator;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "close: " + this.mCurState + ", " + z + ',' + this.isFixationOpenStatus);
        }
        if (this.isFixationOpenStatus) {
            return;
        }
        State state = this.mCurState;
        State state2 = State.CLOSE;
        if (state == state2) {
            return;
        }
        this.mCurState = state2;
        ValueAnimator valueAnimator2 = this.mOpenAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        notifyOnAnimStart4StatusChange(this.mCurState);
        if (z && (valueAnimator = this.mCloseAnimator) != null) {
            valueAnimator.start();
        } else {
            updateSpaceMarginByState();
            notifyStatusChange(this.mCurState);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@oOoXoXO MotionEvent motionEvent) {
        if (!this.isFixationOpenStatus) {
            getDetector().onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final int getViewYForParentView(@OOXIXo String tag) {
        Object obj;
        IIX0o.x0xO0oo(tag, "tag");
        Iterator<Map.Entry<Integer, ArrayList<AddedViewWrapper>>> it = this.mDynamicAddedItemList.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<AddedViewWrapper> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                AddedViewWrapper next = it2.next();
                View view = next.getView();
                Object obj2 = null;
                if (view != null) {
                    obj = view.getTag();
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    obj2 = obj;
                }
                if (IIX0o.Oxx0IOOO(tag, (String) obj2)) {
                    View view2 = next.getView();
                    if (view2 == null) {
                        return 0;
                    }
                    return view2.getTop();
                }
            }
        }
        return 0;
    }

    public final boolean isOpen() {
        if (this.mCurState == State.OPEN) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.topDynamicLayout.addOnLayoutChangeListener(getMDynamicLayoutChangeListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.topDynamicLayout.removeOnLayoutChangeListener(getMDynamicLayoutChangeListener());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@oOoXoXO MotionEvent motionEvent) {
        if (!this.isFixationOpenStatus) {
            if (motionEvent != null && motionEvent.getAction() == 0) {
                this.mHasScroll = false;
            } else if (motionEvent != null && this.mHasScroll && motionEvent.getAction() == 1) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onOrientationChange(int i) {
        Adapter adapter;
        Adapter adapter2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onOrientation:" + this.mCurOrientation + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        this.mCurOrientation = i;
        cancelAnimation();
        if (this.mFixedHeadView != null && (adapter2 = this.adapter) != null) {
            Context context = getContext();
            IIX0o.oO(context, "context");
            adapter2.onOrientationDynamicHeadView(context, this, this.mFixedHeadView, i);
        }
        for (Map.Entry<Integer, ArrayList<AddedViewWrapper>> entry : this.mDynamicAddedItemList.entrySet()) {
            int intValue = entry.getKey().intValue();
            for (AddedViewWrapper addedViewWrapper : entry.getValue()) {
                Adapter adapter3 = this.adapter;
                if (adapter3 != null) {
                    Context context2 = getContext();
                    IIX0o.oO(context2, "context");
                    adapter3.onOrientationDynamicView(context2, this, addedViewWrapper.getView(), i, intValue);
                }
            }
        }
        for (View view : this.mDynamicItemAddedDividerList) {
            Adapter adapter4 = this.adapter;
            if (adapter4 != null) {
                Context context3 = getContext();
                IIX0o.oO(context3, "context");
                adapter4.onOrientationDynamicDivider(context3, this, view, i);
            }
        }
        if (this.mBottomItemView != null && (adapter = this.adapter) != null) {
            Context context4 = getContext();
            IIX0o.oO(context4, "context");
            adapter.onOrientationBottomFixedView(context4, this, this.mBottomItemView, i);
        }
        for (Map.Entry<Integer, ArrayList<View>> entry2 : this.mDynamicRemovedItemList.entrySet()) {
            int intValue2 = entry2.getKey().intValue();
            for (View view2 : entry2.getValue()) {
                Adapter adapter5 = this.adapter;
                if (adapter5 != null) {
                    Context context5 = getContext();
                    IIX0o.oO(context5, "context");
                    adapter5.onOrientationDynamicView(context5, this, view2, i, intValue2);
                }
            }
        }
        for (View view3 : this.mDynamicItemRemovedDividerList) {
            Adapter adapter6 = this.adapter;
            if (adapter6 != null) {
                Context context6 = getContext();
                IIX0o.oO(context6, "context");
                adapter6.onOrientationDynamicDivider(context6, this, view3, i);
            }
        }
        requestLayout();
        updateDynamicScrollHeight();
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
    public void onUpdateAllDynamicItem() {
        int i;
        int i2;
        int i3;
        View view;
        cancelAnimation();
        Adapter adapter = this.adapter;
        if (adapter != null) {
            i = adapter.getDynamicItemSize();
        } else {
            i = 0;
        }
        int size = this.mDynamicAddedItemList.size();
        View view2 = this.mTopDynamicParentLayout;
        if (i == 0) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view2.setVisibility(i2);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "refreshAllItem: " + i + ',' + size);
        }
        for (Map.Entry<Integer, ArrayList<AddedViewWrapper>> entry : this.mDynamicAddedItemList.entrySet()) {
            int intValue = entry.getKey().intValue();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                recycleDynamicItemView(((AddedViewWrapper) it.next()).getView(), intValue);
            }
        }
        Iterator<T> it2 = this.mDynamicItemAddedDividerList.iterator();
        while (it2.hasNext()) {
            recycleDynamicItemDividerView((View) it2.next());
        }
        this.mDynamicAddedItemList.clear();
        this.mDynamicItemAddedDividerList.clear();
        for (int i4 = 0; i4 < i; i4++) {
            Adapter adapter2 = this.adapter;
            if (adapter2 != null) {
                i3 = adapter2.getItemViewType(i4);
            } else {
                i3 = 0;
            }
            View removeLastOrNullFromRemovedItemList = removeLastOrNullFromRemovedItemList(i3);
            Adapter adapter3 = this.adapter;
            if (adapter3 != null) {
                Context context = getContext();
                IIX0o.oO(context, "context");
                view = adapter3.onCreateDynamicView(context, this, i4, removeLastOrNullFromRemovedItemList, this.supportNightMode, this.mCurOrientation, i3);
            } else {
                view = null;
            }
            if (view != null) {
                addViewToDynamicAddedItemList(view, i3, i4);
                this.topDynamicLayout.addView(view);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$onUpdateAllDynamicItem$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it3) {
                        boolean isAnimating;
                        ValueAnimator valueAnimator;
                        Boolean bool;
                        ValueAnimator valueAnimator2;
                        isAnimating = BNExpandConstraintLayout.this.isAnimating();
                        Object obj = null;
                        if (!isAnimating) {
                            IExpandItemOnClickListener iExpandItemOnClickListener = BNExpandConstraintLayout.this.mOnClickItemListener;
                            if (iExpandItemOnClickListener != null) {
                                IIX0o.oO(it3, "it");
                                Object tag = it3.getTag();
                                if (tag instanceof String) {
                                    obj = tag;
                                }
                                iExpandItemOnClickListener.onClickDynamicItem((String) obj, it3);
                                return;
                            }
                            return;
                        }
                        g gVar2 = g.COMMON_UI;
                        if (gVar2.d()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onClick isAnimating:");
                            valueAnimator = BNExpandConstraintLayout.this.mOpenAnimator;
                            if (valueAnimator != null) {
                                bool = Boolean.valueOf(valueAnimator.isRunning());
                            } else {
                                bool = null;
                            }
                            sb.append(bool);
                            sb.append(", ");
                            valueAnimator2 = BNExpandConstraintLayout.this.mCloseAnimator;
                            if (valueAnimator2 != null) {
                                obj = Boolean.valueOf(valueAnimator2.isRunning());
                            }
                            sb.append(obj);
                            gVar2.e(BNExpandConstraintLayout.TAG, sb.toString());
                        }
                    }
                });
                addDynamicItemDividerIfNeed(i4, i);
            }
        }
        updateDynamicScrollHeight();
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
    public void onUpdateBottomFixedView() {
        View view;
        cancelAnimation();
        if (this.mBottomItemView == null) {
            Adapter adapter = this.adapter;
            if (adapter != null) {
                Context context = getContext();
                IIX0o.oO(context, "context");
                view = adapter.onCreateBottomFixedView(context, this, null, this.supportNightMode, this.mCurOrientation);
            } else {
                view = null;
            }
            this.mBottomItemView = view;
            if (view != null) {
                b.a(view);
                this.bottomFixedItemLy.addView(view);
                return;
            }
            return;
        }
        Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            Context context2 = getContext();
            IIX0o.oO(context2, "context");
            adapter2.onCreateBottomFixedView(context2, this, this.mBottomItemView, this.supportNightMode, this.mCurOrientation);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.expandlayout.IExpandConstraintLayout
    public void onUpdateDynamicItem(@oOoXoXO String str, int i) {
        int i2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "refreshDynamicItem:" + str + ',' + i + TokenParser.SP);
        }
        Adapter adapter = this.adapter;
        if (adapter != null) {
            i2 = adapter.getItemViewType(i);
        } else {
            i2 = 0;
        }
        View viewFromAddedItemList = getViewFromAddedItemList(i2, str, i);
        if (viewFromAddedItemList != null) {
            Adapter adapter2 = this.adapter;
            if (adapter2 != null) {
                Context context = getContext();
                IIX0o.oO(context, "context");
                adapter2.onCreateDynamicView(context, this, i, viewFromAddedItemList, this.supportNightMode, this.mCurOrientation, i2);
                return;
            }
            return;
        }
        if (gVar.c()) {
            gVar.a("refreshDynamicItem, viewTag:tag:" + str + ',' + i, new Exception());
        }
    }

    public final void open(boolean z) {
        ValueAnimator valueAnimator;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "open: " + this.mCurState + ", " + z + ',' + this.isFixationOpenStatus);
        }
        if (this.isFixationOpenStatus) {
            return;
        }
        State state = this.mCurState;
        State state2 = State.OPEN;
        if (state == state2) {
            return;
        }
        this.mCurState = state2;
        ValueAnimator valueAnimator2 = this.mCloseAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        notifyOnAnimStart4StatusChange(this.mCurState);
        if (z && (valueAnimator = this.mOpenAnimator) != null) {
            valueAnimator.start();
        } else {
            updateSpaceMarginByState();
        }
        notifyStatusChange(this.mCurState);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void setBottomFixedLayoutBg(@DrawableRes int i) {
        if (this.supportNightMode) {
            com.baidu.navisdk.ui.util.b.a(this.bottomFixedItemLy, i);
        } else {
            this.bottomFixedItemLy.setBackgroundResource(i);
        }
    }

    public final void setDynamicLayoutBg(@DrawableRes int i) {
        if (this.supportNightMode) {
            com.baidu.navisdk.ui.util.b.a(this.mTopDynamicParentLayout, i);
        } else {
            this.mTopDynamicParentLayout.setBackgroundResource(i);
        }
    }

    public final void setFixedViewIcon(int i) {
        if (i != 0) {
            View view = this.mFixedHeadView;
            if (view instanceof ImageView) {
                if (this.supportNightMode) {
                    if (view != null) {
                        com.baidu.navisdk.ui.util.b.a((ImageView) view, i);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                if (view != null) {
                    ((ImageView) view).setImageResource(i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
        }
    }

    public final void setLayoutChangeCallback(@oOoXoXO IExpandLayoutChangeListener iExpandLayoutChangeListener) {
        if (iExpandLayoutChangeListener != null) {
            if (this.mLayoutChangeListenerList == null) {
                this.mLayoutChangeListenerList = new ArrayList<>(2);
            }
            ArrayList<WeakReference<IExpandLayoutChangeListener>> arrayList = this.mLayoutChangeListenerList;
            if (arrayList != null) {
                arrayList.add(new WeakReference<>(iExpandLayoutChangeListener));
            }
        }
    }

    public final void setOnClickItemListener(@OOXIXo IExpandItemOnClickListener clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
        this.mOnClickItemListener = clickListener;
    }

    public final void setStatusChangeCallback(@oOoXoXO IExpandLayoutStatusCallback iExpandLayoutStatusCallback) {
        if (iExpandLayoutStatusCallback != null) {
            if (this.mStatusChangeListenerList == null) {
                this.mStatusChangeListenerList = new ArrayList<>(2);
            }
            ArrayList<WeakReference<IExpandLayoutStatusCallback>> arrayList = this.mStatusChangeListenerList;
            if (arrayList != null) {
                arrayList.add(new WeakReference<>(iExpandLayoutStatusCallback));
            }
            iExpandLayoutStatusCallback.onStatusChange(this.mCurState);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (!this.isFixationOpenStatus && i != 0) {
            close(false);
        }
    }

    @xoIox
    public BNExpandConstraintLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    public /* synthetic */ BNExpandConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNExpandConstraintLayout(@OOXIXo final Context context, @oOoXoXO AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IIX0o.x0xO0oo(context, "context");
        this.mCurState = State.CLOSE;
        this.mDynamicAddedItemList = new HashMap<>(4);
        this.mDynamicItemAddedDividerList = new ArrayList<>(4);
        this.mDynamicRemovedItemList = new HashMap<>(4);
        this.mDynamicItemRemovedDividerList = new ArrayList<>(4);
        this.bottomFixedLyBgPaddingRect = new Rect();
        this.dynamicLyBgPaddingRect = new Rect();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.mDynamicLayoutChangeListener$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<View.OnLayoutChangeListener>() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$mDynamicLayoutChangeListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final View.OnLayoutChangeListener invoke() {
                return new View.OnLayoutChangeListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$mDynamicLayoutChangeListener$2.1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                        if (i6 - i4 != i10 - i8) {
                            BNExpandConstraintLayout.this.notifyDynamicLayoutChange();
                        }
                    }
                };
            }
        });
        this.simpleOnGestureListener$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<BNExpandConstraintLayout$simpleOnGestureListener$2.AnonymousClass1>() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$simpleOnGestureListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$simpleOnGestureListener$2$1] */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final AnonymousClass1 invoke() {
                return new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$simpleOnGestureListener$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onFling(@oOoXoXO MotionEvent motionEvent, @oOoXoXO MotionEvent motionEvent2, float f, float f2) {
                        float f3;
                        float f4 = 0.0f;
                        if (motionEvent != null) {
                            f3 = motionEvent.getY();
                        } else {
                            f3 = 0.0f;
                        }
                        if (motionEvent2 != null) {
                            f4 = motionEvent2.getY();
                        }
                        float f5 = 120;
                        if (f3 - f4 > f5 && Math.abs(f2) > 0) {
                            BNExpandConstraintLayout.this.open(true);
                            BNExpandConstraintLayout.this.notifyOnFlingStatusChange(BNExpandConstraintLayout.State.OPEN);
                            return true;
                        }
                        if (f4 - f3 <= f5 || Math.abs(f2) <= 0) {
                            return false;
                        }
                        BNExpandConstraintLayout.this.close(true);
                        BNExpandConstraintLayout.this.notifyOnFlingStatusChange(BNExpandConstraintLayout.State.CLOSE);
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onScroll(@oOoXoXO MotionEvent motionEvent, @oOoXoXO MotionEvent motionEvent2, float f, float f2) {
                        if (Math.abs(f) >= 150) {
                            BNExpandConstraintLayout.this.mHasScroll = true;
                            return true;
                        }
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(@oOoXoXO MotionEvent motionEvent) {
                        return super.onSingleTapUp(motionEvent);
                    }
                };
            }
        });
        this.detector$delegate = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new Oox.oIX0oI<GestureDetector>() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout$detector$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final GestureDetector invoke() {
                BNExpandConstraintLayout$simpleOnGestureListener$2.AnonymousClass1 simpleOnGestureListener;
                Context context2 = context;
                simpleOnGestureListener = BNExpandConstraintLayout.this.getSimpleOnGestureListener();
                return new GestureDetector(context2, simpleOnGestureListener);
            }
        });
        LayoutInflater.from(context).inflate(R.layout.bn_layout_expand_constraint_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.bn_expand_bottom_fix_item_ly);
        IIX0o.oO(findViewById, "findViewById(R.id.bn_expand_bottom_fix_item_ly)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.bottomFixedItemLy = linearLayout;
        View findViewById2 = findViewById(R.id.bn_expand_bottom_fix_item_ly_space);
        IIX0o.oO(findViewById2, "findViewById(R.id.bn_exp…bottom_fix_item_ly_space)");
        Space space = (Space) findViewById2;
        this.space = space;
        View findViewById3 = findViewById(R.id.bn_expend_top_dynamic_ly);
        IIX0o.oO(findViewById3, "findViewById(R.id.bn_expend_top_dynamic_ly)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById3;
        this.topDynamicLayout = linearLayout2;
        View findViewById4 = findViewById(R.id.bn_expend_top_dynamic_parent);
        IIX0o.oO(findViewById4, "findViewById(R.id.bn_expend_top_dynamic_parent)");
        this.mTopDynamicParentLayout = findViewById4;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNExpandConstraintLayout);
            IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr…BNExpandConstraintLayout)");
            int i3 = R.styleable.BNExpandConstraintLayout_nsdk_expand_dynamic_layout_support_night;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.supportNightMode = obtainStyledAttributes.getBoolean(i3, false);
            }
            int i4 = R.styleable.BNExpandConstraintLayout_nsdk_expand_dynamic_layout_bg;
            if (obtainStyledAttributes.hasValue(i4)) {
                int resourceId = obtainStyledAttributes.getResourceId(i4, 0);
                if (this.supportNightMode) {
                    com.baidu.navisdk.ui.util.b.a(findViewById4, resourceId);
                } else {
                    findViewById4.setBackgroundResource(resourceId);
                }
                JarUtils.getResources().getDrawable(resourceId).getPadding(this.dynamicLyBgPaddingRect);
            }
            int i5 = R.styleable.BNExpandConstraintLayout_nsdk_expand_bottom_fix_item_bg;
            if (obtainStyledAttributes.hasValue(i5)) {
                int resourceId2 = obtainStyledAttributes.getResourceId(i5, 0);
                if (this.supportNightMode) {
                    com.baidu.navisdk.ui.util.b.a(linearLayout, resourceId2);
                } else {
                    linearLayout.setBackgroundResource(resourceId2);
                }
                JarUtils.getResources().getDrawable(resourceId2).getPadding(this.bottomFixedLyBgPaddingRect);
            }
            int i6 = R.styleable.BNExpandConstraintLayout_nsdk_expand_fixation_open_status;
            if (obtainStyledAttributes.hasValue(i6)) {
                this.isFixationOpenStatus = obtainStyledAttributes.getBoolean(i6, false);
            }
            int i7 = R.styleable.BNExpandConstraintLayout_nsdk_expand_dynamic_layout_move_down_margin;
            int dimensionPixelSize = obtainStyledAttributes.hasValue(i7) ? obtainStyledAttributes.getDimensionPixelSize(i7, 0) : 0;
            int i8 = this.dynamicLyBgPaddingRect.bottom + dimensionPixelSize + this.bottomFixedLyBgPaddingRect.top;
            this.dynamicLayoutMoveDownMargin = i8;
            if (i8 > 0 && !this.isFixationOpenStatus) {
                ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
                if (layoutParams != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.dynamicLayoutMoveDownMargin;
                    linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), dimensionPixelSize);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
            int i9 = R.styleable.BNExpandConstraintLayout_nsdk_expand_default_is_open;
            if (obtainStyledAttributes.hasValue(i9) && obtainStyledAttributes.getBoolean(i9, false)) {
                this.mCurState = State.OPEN;
            }
            obtainStyledAttributes.recycle();
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IExpandItemOnClickListener iExpandItemOnClickListener;
                if (!f.a(BNExpandConstraintLayout.TAG) && BNExpandConstraintLayout.this.bottomFixedItemLy.getChildCount() > 0 && BNExpandConstraintLayout.this.mBottomItemView != null && (iExpandItemOnClickListener = BNExpandConstraintLayout.this.mOnClickItemListener) != null) {
                    View view = BNExpandConstraintLayout.this.mBottomItemView;
                    IIX0o.ooOOo0oXI(view);
                    Object tag = view.getTag();
                    if (!(tag instanceof String)) {
                        tag = null;
                    }
                    IIX0o.oO(it, "it");
                    iExpandItemOnClickListener.onClickBottomFixedItem((String) tag, it);
                }
            }
        });
    }
}
