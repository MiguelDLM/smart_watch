package com.angcyo.dsladapter;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.SlidingSelectorHelper;
import com.angcyo.dsladapter.SlidingSelectorHelper$_onGestureListener$2;

/* loaded from: classes7.dex */
public final class SlidingSelectorHelper extends RecyclerView.SimpleOnItemTouchListener {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private int _firstSelectorItemAdapterPosition;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO _gestureDetector$delegate;
    private boolean _isLongPress;
    private int _lastSelectorItemAdapterPosition;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO _onGestureListener$delegate;

    @OXOo.oOoXoXO
    private RecyclerView _recyclerView;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO _slidingRunnable$delegate;
    private float _touchX;
    private float _touchY;

    @OXOo.OOXIXo
    private final Context context;

    @OXOo.OOXIXo
    private final DslAdapter dslAdapter;
    private boolean enableSliding;
    private int scrollStepValue;

    @OXOo.OOXIXo
    private TimeInterpolator scrollStepValueInterpolator;
    private float scrollThresholdValue;

    /* loaded from: classes7.dex */
    public final class II0xO0 implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public int f5299Oo;

        /* renamed from: XO, reason: collision with root package name */
        public int f5300XO;

        public II0xO0() {
            this.f5299Oo = SlidingSelectorHelper.this.getScrollStepValue();
        }

        public final void I0Io(int i) {
            this.f5299Oo = i;
        }

        public final int II0xO0() {
            return this.f5300XO;
        }

        public final int oIX0oI() {
            return this.f5299Oo;
        }

        public final void oxoX(int i) {
            int i2 = this.f5300XO;
            this.f5300XO = i;
            if (i == 0) {
                RecyclerView recyclerView = SlidingSelectorHelper.this.get_recyclerView();
                if (recyclerView != null) {
                    recyclerView.removeCallbacks(this);
                    return;
                }
                return;
            }
            if (i2 != i) {
                RecyclerView recyclerView2 = SlidingSelectorHelper.this.get_recyclerView();
                if (recyclerView2 != null) {
                    recyclerView2.removeCallbacks(this);
                }
                RecyclerView recyclerView3 = SlidingSelectorHelper.this.get_recyclerView();
                if (recyclerView3 != null) {
                    recyclerView3.post(this);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SlidingSelectorHelper.this.get_recyclerView() != null && this.f5300XO != 0) {
                SlidingSelectorHelper.this._selectorItem();
                if (this.f5300XO > 0) {
                    RecyclerView recyclerView = SlidingSelectorHelper.this.get_recyclerView();
                    if (recyclerView != null) {
                        recyclerView.scrollBy(0, this.f5299Oo);
                    }
                } else {
                    RecyclerView recyclerView2 = SlidingSelectorHelper.this.get_recyclerView();
                    if (recyclerView2 != null) {
                        recyclerView2.scrollBy(0, -this.f5299Oo);
                    }
                }
                RecyclerView recyclerView3 = SlidingSelectorHelper.this.get_recyclerView();
                if (recyclerView3 != null) {
                    recyclerView3.post(this);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.OnItemTouchListener helper) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            kotlin.jvm.internal.IIX0o.x0xO0oo(helper, "helper");
            recyclerView.removeOnItemTouchListener(helper);
        }

        @OXOo.OOXIXo
        public final SlidingSelectorHelper oIX0oI(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo DslAdapter dslAdapter) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
            Context applicationContext = recyclerView.getContext().getApplicationContext();
            kotlin.jvm.internal.IIX0o.oO(applicationContext, "recyclerView.context.applicationContext");
            SlidingSelectorHelper slidingSelectorHelper = new SlidingSelectorHelper(applicationContext, dslAdapter);
            recyclerView.addOnItemTouchListener(slidingSelectorHelper);
            return slidingSelectorHelper;
        }

        public oIX0oI() {
        }
    }

    public SlidingSelectorHelper(@OXOo.OOXIXo Context context, @OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        this.context = context;
        this.dslAdapter = dslAdapter;
        this.enableSliding = true;
        this.scrollThresholdValue = 80 * LibExKt.oOXoIIIo(this);
        this.scrollStepValue = LibExKt.Xx000oIo(this) * 3;
        this.scrollStepValueInterpolator = new TimeInterpolator() { // from class: com.angcyo.dsladapter.xII
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                float scrollStepValueInterpolator$lambda$0;
                scrollStepValueInterpolator$lambda$0 = SlidingSelectorHelper.scrollStepValueInterpolator$lambda$0(SlidingSelectorHelper.this, f);
                return scrollStepValueInterpolator$lambda$0;
            }
        };
        this._gestureDetector$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GestureDetectorCompat>() { // from class: com.angcyo.dsladapter.SlidingSelectorHelper$_gestureDetector$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final GestureDetectorCompat invoke() {
                GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(SlidingSelectorHelper.this.getContext(), SlidingSelectorHelper.this.get_onGestureListener());
                gestureDetectorCompat.setIsLongpressEnabled(true);
                return gestureDetectorCompat;
            }
        });
        this._onGestureListener$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SlidingSelectorHelper$_onGestureListener$2.oIX0oI>() { // from class: com.angcyo.dsladapter.SlidingSelectorHelper$_onGestureListener$2

            /* loaded from: classes7.dex */
            public static final class oIX0oI extends GestureDetector.SimpleOnGestureListener {

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ SlidingSelectorHelper f5301XO;

                public oIX0oI(SlidingSelectorHelper slidingSelectorHelper) {
                    this.f5301XO = slidingSelectorHelper;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(@OXOo.OOXIXo MotionEvent event) {
                    ViewParent parent;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
                    this.f5301XO.set_isLongPress(true);
                    RecyclerView recyclerView = this.f5301XO.get_recyclerView();
                    if (recyclerView != null && (parent = recyclerView.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    event.setAction(2);
                    this.f5301XO._handleEvent(event);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final oIX0oI invoke() {
                return new oIX0oI(SlidingSelectorHelper.this);
            }
        });
        this._slidingRunnable$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<II0xO0>() { // from class: com.angcyo.dsladapter.SlidingSelectorHelper$_slidingRunnable$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final SlidingSelectorHelper.II0xO0 invoke() {
                return new SlidingSelectorHelper.II0xO0();
            }
        });
        this._firstSelectorItemAdapterPosition = -1;
        this._lastSelectorItemAdapterPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scrollStepValueInterpolator$lambda$0(SlidingSelectorHelper this$0, float f) {
        float f2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        int i = this$0.scrollStepValue;
        float f3 = i;
        if (f > 0.9f) {
            f2 = 5.0f;
        } else if (f > 0.8f) {
            f2 = 3.0f;
        } else if (f > 0.5f) {
            f2 = 2.0f;
        } else if (f > 0.3f) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        return f3 + (f2 * i);
    }

    public final void _handleEvent(@OXOo.OOXIXo MotionEvent event) {
        ViewParent parent;
        float f;
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        if (event.getActionMasked() == 3 || event.getActionMasked() == 1) {
            this._isLongPress = false;
            get_slidingRunnable().oxoX(0);
            RecyclerView recyclerView = this._recyclerView;
            if (recyclerView != null && (parent = recyclerView.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
        if (event.getActionMasked() != 2) {
            this._firstSelectorItemAdapterPosition = -1;
            this._lastSelectorItemAdapterPosition = -1;
        }
        if (this._recyclerView != null && this.enableSliding && this._isLongPress && event.getActionMasked() == 2) {
            this._touchX = event.getX();
            this._touchY = event.getY();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(this._recyclerView);
            int i = this.scrollStepValue;
            if (r0.getMeasuredHeight() - event.getY() < this.scrollThresholdValue) {
                get_slidingRunnable().oxoX(1);
                f = Math.max(r0.getMeasuredHeight() - event.getY(), 0.0f);
            } else if (event.getY() < this.scrollThresholdValue) {
                get_slidingRunnable().oxoX(-1);
                f = Math.max(event.getY(), 0.0f);
            } else {
                get_slidingRunnable().oxoX(0);
                _selectorItem();
                f = -1.0f;
            }
            if (f >= 0.0f) {
                i = (int) this.scrollStepValueInterpolator.getInterpolation(1 - (f / this.scrollThresholdValue));
            }
            get_slidingRunnable().I0Io(i);
        }
    }

    public final void _selectorItem() {
        View findChildViewUnder;
        RecyclerView.ViewHolder findContainingViewHolder;
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null && (findChildViewUnder = recyclerView.findChildViewUnder(this._touchX, this._touchY)) != null && (findContainingViewHolder = recyclerView.findContainingViewHolder(findChildViewUnder)) != null) {
            int adapterPosition = findContainingViewHolder.getAdapterPosition();
            IO io2 = new IO(DslAdapter.getItemData$default(this.dslAdapter, findContainingViewHolder.getAdapterPosition(), false, 2, null), 0, false, false, true, null, false, false, false, null, 878, null);
            if (this._firstSelectorItemAdapterPosition == -1) {
                this._firstSelectorItemAdapterPosition = adapterPosition;
            }
            if (this._lastSelectorItemAdapterPosition == -1) {
                this._lastSelectorItemAdapterPosition = adapterPosition;
            }
            if (this._lastSelectorItemAdapterPosition != adapterPosition) {
                io2.xxX(2);
                io2.X0IIOO(false);
                this.dslAdapter.getItemSelectorHelper().xoXoI(new X0.oOoXoXO(this._lastSelectorItemAdapterPosition, adapterPosition), io2);
            }
            io2.xxX(1);
            io2.X0IIOO(true);
            this.dslAdapter.getItemSelectorHelper().xoXoI(new X0.oOoXoXO(this._firstSelectorItemAdapterPosition, adapterPosition), io2);
            this._lastSelectorItemAdapterPosition = adapterPosition;
        }
    }

    @OXOo.OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @OXOo.OOXIXo
    public final DslAdapter getDslAdapter() {
        return this.dslAdapter;
    }

    public final boolean getEnableSliding() {
        return this.enableSliding;
    }

    public final int getScrollStepValue() {
        return this.scrollStepValue;
    }

    @OXOo.OOXIXo
    public final TimeInterpolator getScrollStepValueInterpolator() {
        return this.scrollStepValueInterpolator;
    }

    public final float getScrollThresholdValue() {
        return this.scrollThresholdValue;
    }

    public final int get_firstSelectorItemAdapterPosition() {
        return this._firstSelectorItemAdapterPosition;
    }

    @OXOo.OOXIXo
    public final GestureDetectorCompat get_gestureDetector() {
        return (GestureDetectorCompat) this._gestureDetector$delegate.getValue();
    }

    public final boolean get_isLongPress() {
        return this._isLongPress;
    }

    public final int get_lastSelectorItemAdapterPosition() {
        return this._lastSelectorItemAdapterPosition;
    }

    @OXOo.OOXIXo
    public final GestureDetector.OnGestureListener get_onGestureListener() {
        return (GestureDetector.OnGestureListener) this._onGestureListener$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final RecyclerView get_recyclerView() {
        return this._recyclerView;
    }

    @OXOo.OOXIXo
    public final II0xO0 get_slidingRunnable() {
        return (II0xO0) this._slidingRunnable$delegate.getValue();
    }

    public final float get_touchX() {
        return this._touchX;
    }

    public final float get_touchY() {
        return this._touchY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo MotionEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        this._recyclerView = recyclerView;
        _handleEvent(event);
        if (this.enableSliding) {
            if (this._isLongPress || get_gestureDetector().onTouchEvent(event)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo MotionEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        this._recyclerView = recyclerView;
        _handleEvent(event);
        if (this.enableSliding) {
            get_gestureDetector().onTouchEvent(event);
        }
    }

    public final void setEnableSliding(boolean z) {
        this.enableSliding = z;
    }

    public final void setScrollStepValue(int i) {
        this.scrollStepValue = i;
    }

    public final void setScrollStepValueInterpolator(@OXOo.OOXIXo TimeInterpolator timeInterpolator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeInterpolator, "<set-?>");
        this.scrollStepValueInterpolator = timeInterpolator;
    }

    public final void setScrollThresholdValue(float f) {
        this.scrollThresholdValue = f;
    }

    public final void set_firstSelectorItemAdapterPosition(int i) {
        this._firstSelectorItemAdapterPosition = i;
    }

    public final void set_isLongPress(boolean z) {
        this._isLongPress = z;
    }

    public final void set_lastSelectorItemAdapterPosition(int i) {
        this._lastSelectorItemAdapterPosition = i;
    }

    public final void set_recyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        this._recyclerView = recyclerView;
    }

    public final void set_touchX(float f) {
        this._touchX = f;
    }

    public final void set_touchY(float f) {
        this._touchY = f;
    }
}
