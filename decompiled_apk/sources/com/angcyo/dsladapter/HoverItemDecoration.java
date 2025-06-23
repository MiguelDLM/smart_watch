package com.angcyo.dsladapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.HoverItemDecoration;
import java.util.ArrayList;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nHoverItemDecoration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HoverItemDecoration.kt\ncom/angcyo/dsladapter/HoverItemDecoration\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,722:1\n1855#2,2:723\n*S KotlinDebug\n*F\n+ 1 HoverItemDecoration.kt\ncom/angcyo/dsladapter/HoverItemDecoration\n*L\n185#1:723,2\n*E\n"})
/* loaded from: classes7.dex */
public class HoverItemDecoration extends RecyclerView.ItemDecoration {

    @OXOo.oOoXoXO
    private HoverCallback hoverCallback;
    private boolean isDownInHoverItem;

    @OXOo.oOoXoXO
    private RecyclerView.ViewHolder overViewHolder;

    @OXOo.oOoXoXO
    private RecyclerView recyclerView;

    @OXOo.oOoXoXO
    private ViewGroup windowContent;

    @OXOo.OOXIXo
    private final ArrayList<View> removeViews = new ArrayList<>();

    @OXOo.OOXIXo
    private final Runnable cancelEvent = new Runnable() { // from class: com.angcyo.dsladapter.xXxxox0I
        @Override // java.lang.Runnable
        public final void run() {
            HoverItemDecoration.cancelEvent$lambda$1(HoverItemDecoration.this);
        }
    };

    @OXOo.OOXIXo
    private final kotlin.X0IIOO paint$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Paint>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$paint$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final Paint invoke() {
            return new Paint(1);
        }
    });

    @OXOo.OOXIXo
    private final HoverItemDecoration$itemTouchListener$1 itemTouchListener = new RecyclerView.SimpleOnItemTouchListener() { // from class: com.angcyo.dsladapter.HoverItemDecoration$itemTouchListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo MotionEvent event) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
            int actionMasked = event.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    HoverItemDecoration.this.setDownInHoverItem$Adapter_release(false);
                }
            } else {
                HoverItemDecoration hoverItemDecoration = HoverItemDecoration.this;
                hoverItemDecoration.setDownInHoverItem$Adapter_release(hoverItemDecoration.getOverDecorationRect().contains((int) event.getX(), (int) event.getY()));
            }
            if (HoverItemDecoration.this.isDownInHoverItem$Adapter_release()) {
                onTouchEvent(recyclerView, event);
            }
            return HoverItemDecoration.this.isDownInHoverItem$Adapter_release();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo MotionEvent event) {
            RecyclerView.ViewHolder overViewHolder$Adapter_release;
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
            if (HoverItemDecoration.this.isDownInHoverItem$Adapter_release() && (overViewHolder$Adapter_release = HoverItemDecoration.this.getOverViewHolder$Adapter_release()) != null) {
                HoverItemDecoration hoverItemDecoration = HoverItemDecoration.this;
                HoverItemDecoration.HoverCallback hoverCallback$Adapter_release = hoverItemDecoration.getHoverCallback$Adapter_release();
                if (hoverCallback$Adapter_release != null && hoverCallback$Adapter_release.Oxx0IOOO()) {
                    if (event.getActionMasked() == 0) {
                        recyclerView.postDelayed(hoverItemDecoration.getCancelEvent(), 160L);
                    } else {
                        recyclerView.removeCallbacks(hoverItemDecoration.getCancelEvent());
                    }
                    overViewHolder$Adapter_release.itemView.dispatchTouchEvent(event);
                    View view = overViewHolder$Adapter_release.itemView;
                    if (view instanceof ViewGroup) {
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(view, "null cannot be cast to non-null type android.view.ViewGroup");
                        if (((ViewGroup) view).onInterceptTouchEvent(event)) {
                            overViewHolder$Adapter_release.itemView.onTouchEvent(event);
                            return;
                        }
                        return;
                    }
                    view.onTouchEvent(event);
                    return;
                }
                if (event.getActionMasked() == 1) {
                    overViewHolder$Adapter_release.itemView.performClick();
                }
            }
        }
    };

    @OXOo.OOXIXo
    private final oIX0oI attachStateChangeListener = new oIX0oI();

    @OXOo.OOXIXo
    private final HoverItemDecoration$scrollListener$1 scrollListener = new RecyclerView.OnScrollListener() { // from class: com.angcyo.dsladapter.HoverItemDecoration$scrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@OXOo.OOXIXo RecyclerView recyclerView, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                HoverItemDecoration.this.removeAllHoverView();
            }
        }
    };

    @OXOo.OOXIXo
    private final Rect overDecorationRect = new Rect();

    @OXOo.OOXIXo
    private final Rect nextDecorationRect = new Rect();
    private int overAdapterPosition = -1;

    @OXOo.OOXIXo
    private Rect tempRect = new Rect();

    /* loaded from: classes7.dex */
    public static final class HoverCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public boolean f5223oIX0oI = true;

        /* renamed from: II0xO0, reason: collision with root package name */
        public boolean f5218II0xO0 = true;

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.x0xO0oo<? super RecyclerView.Adapter<?>, ? super Integer, Boolean> f5216I0Io = new Oox.x0xO0oo<RecyclerView.Adapter<?>, Integer, Boolean>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$haveOverDecoration$1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(RecyclerView.Adapter<?> adapter, Integer num) {
                return invoke(adapter, num.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo RecyclerView.Adapter<?> adapter, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
                boolean z = false;
                if (adapter instanceof DslAdapter) {
                    DslAdapterItem itemData$default = DslAdapter.getItemData$default((DslAdapter) adapter, i, false, 2, null);
                    if (itemData$default != null) {
                        z = itemData$default.getItemIsHover();
                    }
                } else if (HoverItemDecoration.HoverCallback.this.I0Io().invoke(adapter, Integer.valueOf(i)).intValue() > 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        };

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.x0xO0oo<? super RecyclerView.Adapter<?>, ? super Integer, Integer> f5224oxoX = new Oox.x0xO0oo<RecyclerView.Adapter<?>, Integer, Integer>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$decorationOverLayoutType$1
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Integer invoke(RecyclerView.Adapter<?> adapter, Integer num) {
                return invoke(adapter, num.intValue());
            }

            @OXOo.OOXIXo
            public final Integer invoke(@OXOo.OOXIXo RecyclerView.Adapter<?> adapter, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
                return Integer.valueOf(adapter instanceof DslAdapter ? adapter.getItemViewType(i) : -1);
            }
        };

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.IXxxXO<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super Integer, ? super Integer, Boolean> f5221X0o0xo = new Oox.IXxxXO<RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, Integer, Boolean>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$isOverDecorationSame$1
            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ Boolean invoke(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Integer num, Integer num2) {
                return invoke(adapter, num.intValue(), num2.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i, int i2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "<anonymous parameter 0>");
                return Boolean.FALSE;
            }
        };

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.IXxxXO<? super RecyclerView, ? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super Integer, ? extends RecyclerView.ViewHolder> f5222XO = new Oox.IXxxXO<RecyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, RecyclerView.ViewHolder>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$createDecorationOverView$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ RecyclerView.ViewHolder invoke(RecyclerView recyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Integer num) {
                return invoke(recyclerView, adapter, num.intValue());
            }

            @OXOo.OOXIXo
            public final RecyclerView.ViewHolder invoke(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
                kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
                RecyclerView.ViewHolder createViewHolder = adapter.createViewHolder(recyclerView, HoverItemDecoration.HoverCallback.this.I0Io().invoke(adapter, Integer.valueOf(i)).intValue());
                kotlin.jvm.internal.IIX0o.oO(createViewHolder, "adapter.createViewHolder(recyclerView, layoutType)");
                adapter.bindViewHolder(createViewHolder, i);
                Oox.x0xO0oo<RecyclerView, View, oXIO0o0XI> xoIox2 = HoverItemDecoration.HoverCallback.this.xoIox();
                View view = createViewHolder.itemView;
                kotlin.jvm.internal.IIX0o.oO(view, "holder.itemView");
                xoIox2.invoke(recyclerView, view);
                return createViewHolder;
            }
        };

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Oox.IXxxXO<RecyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, RecyclerView.ViewHolder> f5220Oxx0IOOO = new Oox.IXxxXO<RecyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, DslViewHolder>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$customDecorationOverView$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ DslViewHolder invoke(RecyclerView recyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Integer num) {
                return invoke(recyclerView, adapter, num.intValue());
            }

            @OXOo.OOXIXo
            public final DslViewHolder invoke(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
                kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
                View itemView = LayoutInflater.from(recyclerView.getContext()).inflate(HoverItemDecoration.HoverCallback.this.I0Io().invoke(adapter, Integer.valueOf(i)).intValue(), (ViewGroup) recyclerView, false);
                kotlin.jvm.internal.IIX0o.oO(itemView, "itemView");
                DslViewHolder dslViewHolder = new DslViewHolder(itemView, 0, 2, null);
                adapter.bindViewHolder(dslViewHolder, i);
                Oox.x0xO0oo<RecyclerView, View, oXIO0o0XI> xoIox2 = HoverItemDecoration.HoverCallback.this.xoIox();
                View view = dslViewHolder.itemView;
                kotlin.jvm.internal.IIX0o.oO(view, "holder.itemView");
                xoIox2.invoke(recyclerView, view);
                return dslViewHolder;
            }
        };

        /* renamed from: II0XooXoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.x0xO0oo<? super RecyclerView, ? super View, oXIO0o0XI> f5217II0XooXoX = new Oox.x0xO0oo<RecyclerView, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$measureHoverView$1
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(RecyclerView recyclerView, View view) {
                invoke2(recyclerView, view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo View hoverView) {
                int measuredWidth;
                int i;
                int measuredWidth2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
                kotlin.jvm.internal.IIX0o.x0xO0oo(hoverView, "hoverView");
                ViewGroup.LayoutParams layoutParams = hoverView.getLayoutParams();
                int i2 = Integer.MIN_VALUE;
                if (layoutParams.width == -1) {
                    measuredWidth = parent.getMeasuredWidth();
                    i = 1073741824;
                } else {
                    measuredWidth = parent.getMeasuredWidth();
                    i = Integer.MIN_VALUE;
                }
                if (layoutParams.height == -1) {
                    measuredWidth2 = parent.getMeasuredWidth();
                    i2 = 1073741824;
                } else {
                    measuredWidth2 = parent.getMeasuredWidth();
                }
                hoverView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, i), View.MeasureSpec.makeMeasureSpec(measuredWidth2, i2));
                hoverView.layout(0, 0, hoverView.getMeasuredWidth(), hoverView.getMeasuredHeight());
            }
        };

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.Oxx0xo<? super Canvas, ? super Paint, ? super RecyclerView.ViewHolder, ? super Rect, oXIO0o0XI> f5226xxIXOIIO = new Oox.Oxx0xo<Canvas, Paint, RecyclerView.ViewHolder, Rect, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$drawOverDecoration$1
            {
                super(4);
            }

            @Override // Oox.Oxx0xo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Canvas canvas, Paint paint, RecyclerView.ViewHolder viewHolder, Rect rect) {
                invoke2(canvas, paint, viewHolder, rect);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Paint paint, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, @OXOo.OOXIXo Rect overRect) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
                kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "paint");
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(overRect, "overRect");
                canvas.save();
                canvas.translate(overRect.left, overRect.top);
                viewHolder.itemView.draw(canvas);
                if (HoverItemDecoration.HoverCallback.this.XO()) {
                    HoverItemDecoration.HoverCallback.this.X0o0xo().invoke(canvas, paint, viewHolder, overRect);
                }
                canvas.restore();
            }
        };

        /* renamed from: xoIox, reason: collision with root package name */
        public boolean f5225xoIox = true;

        /* renamed from: OOXIXo, reason: collision with root package name */
        @OXOo.OOXIXo
        public Oox.Oxx0xo<? super Canvas, ? super Paint, ? super RecyclerView.ViewHolder, ? super Rect, oXIO0o0XI> f5219OOXIXo = new Oox.Oxx0xo<Canvas, Paint, RecyclerView.ViewHolder, Rect, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$HoverCallback$drawOverShadowDecoration$1
            {
                super(4);
            }

            @Override // Oox.Oxx0xo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Canvas canvas, Paint paint, RecyclerView.ViewHolder viewHolder, Rect rect) {
                invoke2(canvas, paint, viewHolder, rect);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Paint paint, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, @OXOo.OOXIXo Rect overRect) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
                kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "paint");
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(overRect, "overRect");
                if (overRect.top == 0) {
                    float f = overRect.bottom;
                    float oOXoIIIo2 = f + (4 * LibExKt.oOXoIIIo(HoverItemDecoration.HoverCallback.this));
                    paint.setShader(new LinearGradient(0.0f, f, 0.0f, oOXoIIIo2, new int[]{Color.parseColor("#40000000"), 0}, (float[]) null, Shader.TileMode.CLAMP));
                    canvas.drawRect(overRect.left, f, overRect.right, oOXoIIIo2, paint);
                }
            }
        };

        @OXOo.OOXIXo
        public final Oox.x0xO0oo<RecyclerView.Adapter<?>, Integer, Integer> I0Io() {
            return this.f5224oxoX;
        }

        public final boolean II0XooXoX() {
            return this.f5223oIX0oI;
        }

        @OXOo.OOXIXo
        public final Oox.IXxxXO<RecyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, RecyclerView.ViewHolder> II0xO0() {
            return this.f5220Oxx0IOOO;
        }

        public final void IXxxXO(boolean z) {
            this.f5223oIX0oI = z;
        }

        @OXOo.OOXIXo
        public final Oox.IXxxXO<RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, Integer, Boolean> OOXIXo() {
            return this.f5221X0o0xo;
        }

        public final void Oo(boolean z) {
            this.f5218II0xO0 = z;
        }

        public final boolean Oxx0IOOO() {
            return this.f5218II0xO0;
        }

        public final void Oxx0xo(@OXOo.OOXIXo Oox.x0xO0oo<? super RecyclerView.Adapter<?>, ? super Integer, Boolean> x0xo0oo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
            this.f5216I0Io = x0xo0oo;
        }

        public final void OxxIIOOXO(@OXOo.OOXIXo Oox.IXxxXO<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super Integer, ? super Integer, Boolean> iXxxXO) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(iXxxXO, "<set-?>");
            this.f5221X0o0xo = iXxxXO;
        }

        @OXOo.OOXIXo
        public final Oox.Oxx0xo<Canvas, Paint, RecyclerView.ViewHolder, Rect, oXIO0o0XI> X0o0xo() {
            return this.f5219OOXIXo;
        }

        public final boolean XO() {
            return this.f5225xoIox;
        }

        public final void oI0IIXIo(@OXOo.OOXIXo Oox.x0xO0oo<? super RecyclerView, ? super View, oXIO0o0XI> x0xo0oo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
            this.f5217II0XooXoX = x0xo0oo;
        }

        @OXOo.OOXIXo
        public final Oox.IXxxXO<RecyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder>, Integer, RecyclerView.ViewHolder> oIX0oI() {
            return this.f5222XO;
        }

        public final void oO(@OXOo.OOXIXo Oox.Oxx0xo<? super Canvas, ? super Paint, ? super RecyclerView.ViewHolder, ? super Rect, oXIO0o0XI> oxx0xo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
            this.f5219OOXIXo = oxx0xo;
        }

        public final void oOoXoXO(@OXOo.OOXIXo Oox.IXxxXO<? super RecyclerView, ? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super Integer, ? extends RecyclerView.ViewHolder> iXxxXO) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(iXxxXO, "<set-?>");
            this.f5222XO = iXxxXO;
        }

        public final void ooOOo0oXI(@OXOo.OOXIXo Oox.x0xO0oo<? super RecyclerView.Adapter<?>, ? super Integer, Integer> x0xo0oo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
            this.f5224oxoX = x0xo0oo;
        }

        @OXOo.OOXIXo
        public final Oox.Oxx0xo<Canvas, Paint, RecyclerView.ViewHolder, Rect, oXIO0o0XI> oxoX() {
            return this.f5226xxIXOIIO;
        }

        public final void x0XOIxOo(@OXOo.OOXIXo Oox.Oxx0xo<? super Canvas, ? super Paint, ? super RecyclerView.ViewHolder, ? super Rect, oXIO0o0XI> oxx0xo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
            this.f5226xxIXOIIO = oxx0xo;
        }

        public final void x0xO0oo(boolean z) {
            this.f5225xoIox = z;
        }

        @OXOo.OOXIXo
        public final Oox.x0xO0oo<RecyclerView, View, oXIO0o0XI> xoIox() {
            return this.f5217II0XooXoX;
        }

        @OXOo.OOXIXo
        public final Oox.x0xO0oo<RecyclerView.Adapter<?>, Integer, Boolean> xxIXOIIO() {
            return this.f5216I0Io;
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI implements View.OnAttachStateChangeListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            HoverItemDecoration.this.removeAllHoverView();
        }
    }

    private final void addHoverView(View view) {
        ViewGroup viewGroup;
        int i;
        int i2;
        if (view.getParent() == null && (viewGroup = this.windowContent) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.overDecorationRect.width(), this.overDecorationRect.height());
            RecyclerView recyclerView = this.recyclerView;
            Rect rect = null;
            if (recyclerView != null) {
                rect = LibExKt.OI0(recyclerView, null, 1, null);
            }
            Rect rect2 = this.overDecorationRect;
            int i3 = rect2.left;
            if (rect != null) {
                i = rect.left;
            } else {
                i = 0;
            }
            layoutParams.leftMargin = i3 + i;
            int i4 = rect2.top;
            if (rect != null) {
                i2 = rect.top;
            } else {
                i2 = 0;
            }
            layoutParams.topMargin = i4 + i2;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            viewGroup.addView(view, 0, layoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void attachToRecyclerView$default(HoverItemDecoration hoverItemDecoration, RecyclerView recyclerView, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                oooxoxo = new Oox.oOoXoXO<HoverCallback, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.HoverItemDecoration$attachToRecyclerView$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo HoverItemDecoration.HoverCallback hoverCallback) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(hoverCallback, "$this$null");
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(HoverItemDecoration.HoverCallback hoverCallback) {
                        invoke2(hoverCallback);
                        return oXIO0o0XI.f29392oIX0oI;
                    }
                };
            }
            hoverItemDecoration.attachToRecyclerView(recyclerView, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToRecyclerView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelEvent$lambda$1(HoverItemDecoration this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        RecyclerView.ViewHolder viewHolder = this$0.overViewHolder;
        if (viewHolder != null) {
            viewHolder.itemView.dispatchTouchEvent(MotionEvent.obtain(LibExKt.o0xxxXXxX(), LibExKt.o0xxxXXxX(), 1, 0.0f, 0.0f, 0));
        }
    }

    private final RecyclerView.ViewHolder childViewHolder(RecyclerView recyclerView, int i) {
        if (recyclerView.getChildCount() > i) {
            return recyclerView.findContainingViewHolder(recyclerView.getChildAt(i));
        }
        return null;
    }

    private final void destroyCallbacks() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.removeItemDecoration(this);
            recyclerView.removeOnItemTouchListener(this.itemTouchListener);
            recyclerView.removeOnAttachStateChangeListener(this.attachStateChangeListener);
            recyclerView.removeOnScrollListener(this.scrollListener);
        }
        removeAllHoverView();
    }

    public static /* synthetic */ int findNextChildIndex$default(HoverItemDecoration hoverItemDecoration, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return hoverItemDecoration.findNextChildIndex(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNextChildIndex");
    }

    public static /* synthetic */ RecyclerView.ViewHolder findNextDecoration$default(HoverItemDecoration hoverItemDecoration, RecyclerView recyclerView, RecyclerView.Adapter adapter, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return hoverItemDecoration.findNextDecoration(recyclerView, adapter, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNextDecoration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAllHoverView() {
        ViewGroup viewGroup;
        for (View view : this.removeViews) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.removeViews.clear();
    }

    private final void removeHoverView() {
        View view;
        RecyclerView.ViewHolder viewHolder = this.overViewHolder;
        if (viewHolder != null && (view = viewHolder.itemView) != null) {
            view.dispatchTouchEvent(MotionEvent.obtain(LibExKt.o0xxxXXxX(), LibExKt.o0xxxXXxX(), 3, 0.0f, 0.0f, 0));
            this.removeViews.add(view);
        }
    }

    private final void setupCallbacks() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
            HoverCallback hoverCallback = this.hoverCallback;
            if (hoverCallback != null && hoverCallback.II0XooXoX()) {
                recyclerView.addOnItemTouchListener(this.itemTouchListener);
            }
            recyclerView.addOnAttachStateChangeListener(this.attachStateChangeListener);
            recyclerView.addOnScrollListener(this.scrollListener);
        }
    }

    public final void attachToRecyclerView(@OXOo.oOoXoXO RecyclerView recyclerView, @OXOo.OOXIXo Oox.oOoXoXO<? super HoverCallback, oXIO0o0XI> init) {
        Context context;
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        HoverCallback hoverCallback = new HoverCallback();
        this.hoverCallback = hoverCallback;
        init.invoke(hoverCallback);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.recyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
            }
            Activity activity = null;
            if (recyclerView != null) {
                context = recyclerView.getContext();
            } else {
                context = null;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                this.windowContent = (ViewGroup) activity.getWindow().findViewById(android.R.id.content);
            }
        }
    }

    public final void checkOverDecoration$Adapter_release(@OXOo.OOXIXo RecyclerView parent) {
        int adapterPosition;
        RecyclerView.Adapter<?> adapter;
        HoverCallback hoverCallback;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        RecyclerView.ViewHolder childViewHolder = childViewHolder(parent, 0);
        if (childViewHolder != null && (adapterPosition = childViewHolder.getAdapterPosition()) != -1 && (adapter = parent.getAdapter()) != null && (hoverCallback = this.hoverCallback) != null) {
            Oox.x0xO0oo<RecyclerView.Adapter<?>, Integer, Boolean> xxIXOIIO2 = hoverCallback.xxIXOIIO();
            kotlin.jvm.internal.IIX0o.oO(adapter, "adapter");
            boolean booleanValue = xxIXOIIO2.invoke(adapter, Integer.valueOf(adapterPosition)).booleanValue();
            if (!booleanValue && (i = findOverPrePosition$Adapter_release(adapter, adapterPosition)) != -1) {
                booleanValue = true;
            } else {
                i = adapterPosition;
            }
            if (booleanValue) {
                int findOverStartPosition$Adapter_release = findOverStartPosition$Adapter_release(adapter, i);
                if (findOverStartPosition$Adapter_release == -1) {
                    clearOverDecoration();
                    return;
                }
                RecyclerView.ViewHolder invoke = hoverCallback.oIX0oI().invoke(parent, adapter, Integer.valueOf(findOverStartPosition$Adapter_release));
                View view = invoke.itemView;
                kotlin.jvm.internal.IIX0o.oO(view, "firstViewHolder.itemView");
                this.tempRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                RecyclerView.ViewHolder findNextDecoration$default = findNextDecoration$default(this, parent, adapter, this.tempRect.height(), 0, 8, null);
                if (findNextDecoration$default != null && hoverCallback.xxIXOIIO().invoke(adapter, Integer.valueOf(findNextDecoration$default.getAdapterPosition())).booleanValue() && !hoverCallback.OOXIXo().invoke(adapter, Integer.valueOf(adapterPosition), Integer.valueOf(findNextDecoration$default.getAdapterPosition())).booleanValue() && findNextDecoration$default.itemView.getTop() < this.tempRect.height()) {
                    this.tempRect.offsetTo(0, findNextDecoration$default.itemView.getTop() - this.tempRect.height());
                }
                if (findOverStartPosition$Adapter_release == adapterPosition && childViewHolder.itemView.getTop() >= 0) {
                    clearOverDecoration();
                    return;
                }
                if (this.overAdapterPosition != findOverStartPosition$Adapter_release) {
                    clearOverDecoration();
                    this.overViewHolder = invoke;
                    this.overDecorationRect.set(this.tempRect);
                    this.overAdapterPosition = findOverStartPosition$Adapter_release;
                    return;
                }
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.overDecorationRect, this.tempRect)) {
                    this.overDecorationRect.set(this.tempRect);
                    return;
                }
                return;
            }
            clearOverDecoration();
        }
    }

    public final void clearOverDecoration() {
        LibExKt.Oo(this.overDecorationRect);
        LibExKt.Oo(this.nextDecorationRect);
        removeHoverView();
        this.overViewHolder = null;
        this.overAdapterPosition = -1;
    }

    public final void detachedFromRecyclerView() {
        this.hoverCallback = null;
        if (this.recyclerView != null) {
            destroyCallbacks();
        }
        this.isDownInHoverItem = false;
        this.windowContent = null;
        this.recyclerView = null;
    }

    public final int findGridNextChildIndex(int i) {
        RecyclerView.LayoutManager layoutManager;
        GridLayoutManager gridLayoutManager;
        GridLayoutManager.SpanSizeLookup spanSizeLookup;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (layoutManager instanceof GridLayoutManager)) {
            RecyclerView recyclerView2 = this.recyclerView;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView2);
            int childCount = recyclerView2.getChildCount();
            for (int i2 = i; i2 < childCount; i2++) {
                RecyclerView recyclerView3 = this.recyclerView;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView3);
                RecyclerView.ViewHolder childViewHolder = childViewHolder(recyclerView3, i2);
                if (childViewHolder != null && childViewHolder.getAdapterPosition() != -1 && (spanSizeLookup = (gridLayoutManager = (GridLayoutManager) layoutManager).getSpanSizeLookup()) != null && spanSizeLookup.getSpanSize(childViewHolder.getAdapterPosition()) == gridLayoutManager.getSpanCount()) {
                    return i2;
                }
            }
        }
        return i;
    }

    public final int findNextChildIndex(int i) {
        return findGridNextChildIndex(i);
    }

    @OXOo.oOoXoXO
    public final RecyclerView.ViewHolder findNextDecoration(@OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo RecyclerView.Adapter<?> adapter, int i, int i2) {
        RecyclerView.ViewHolder childViewHolder;
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        HoverCallback hoverCallback = this.hoverCallback;
        if (hoverCallback != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(hoverCallback);
            int findNextChildIndex = findNextChildIndex(i2);
            if (findNextChildIndex != -1 && (childViewHolder = childViewHolder(parent, findNextChildIndex)) != null) {
                if (!hoverCallback.xxIXOIIO().invoke(adapter, Integer.valueOf(childViewHolder.getAdapterPosition())).booleanValue()) {
                    if (childViewHolder.itemView.getBottom() < i) {
                        return findNextDecoration(parent, adapter, i, i2 + 1);
                    }
                } else {
                    return childViewHolder;
                }
            }
        }
        return null;
    }

    public final int findOverPrePosition$Adapter_release(@OXOo.OOXIXo RecyclerView.Adapter<?> adapter, int i) {
        HoverCallback hoverCallback;
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        do {
            i--;
            if (-1 < i) {
                hoverCallback = this.hoverCallback;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(hoverCallback);
            } else {
                return -1;
            }
        } while (!hoverCallback.xxIXOIIO().invoke(adapter, Integer.valueOf(i)).booleanValue());
        return i;
    }

    public final int findOverStartPosition$Adapter_release(@OXOo.OOXIXo RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i) {
        int i2;
        HoverCallback hoverCallback;
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        int i3 = i - 1;
        while (true) {
            i2 = -1;
            if (-1 >= i3) {
                break;
            }
            if (i3 == 0) {
                HoverCallback hoverCallback2 = this.hoverCallback;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(hoverCallback2);
                if (hoverCallback2.OOXIXo().invoke(adapter, Integer.valueOf(i), Integer.valueOf(i3)).booleanValue()) {
                    i = i3;
                }
            } else {
                HoverCallback hoverCallback3 = this.hoverCallback;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(hoverCallback3);
                if (!hoverCallback3.OOXIXo().invoke(adapter, Integer.valueOf(i), Integer.valueOf(i3)).booleanValue()) {
                    i = i3 + 1;
                    break;
                }
                i3--;
            }
        }
        if (i == 0 && (hoverCallback = this.hoverCallback) != null) {
            if (hoverCallback.xxIXOIIO().invoke(adapter, Integer.valueOf(i)).booleanValue()) {
                i2 = i;
            }
            return i2;
        }
        return i;
    }

    @OXOo.OOXIXo
    public final Runnable getCancelEvent() {
        return this.cancelEvent;
    }

    @OXOo.oOoXoXO
    public final HoverCallback getHoverCallback$Adapter_release() {
        return this.hoverCallback;
    }

    @OXOo.OOXIXo
    public final Rect getNextDecorationRect$Adapter_release() {
        return this.nextDecorationRect;
    }

    public final int getOverAdapterPosition() {
        return this.overAdapterPosition;
    }

    @OXOo.OOXIXo
    public final Rect getOverDecorationRect() {
        return this.overDecorationRect;
    }

    @OXOo.oOoXoXO
    public final RecyclerView.ViewHolder getOverViewHolder$Adapter_release() {
        return this.overViewHolder;
    }

    @OXOo.OOXIXo
    public final Paint getPaint$Adapter_release() {
        return (Paint) this.paint$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final RecyclerView getRecyclerView$Adapter_release() {
        return this.recyclerView;
    }

    @OXOo.OOXIXo
    public final ArrayList<View> getRemoveViews$Adapter_release() {
        return this.removeViews;
    }

    @OXOo.oOoXoXO
    public final ViewGroup getWindowContent$Adapter_release() {
        return this.windowContent;
    }

    public final boolean isDownInHoverItem$Adapter_release() {
        return this.isDownInHoverItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo RecyclerView.State state) {
        HoverCallback hoverCallback;
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
        if (!state.isPreLayout() && !state.willRunSimpleAnimations()) {
            checkOverDecoration$Adapter_release(parent);
            RecyclerView.ViewHolder viewHolder = this.overViewHolder;
            if (viewHolder != null && !this.overDecorationRect.isEmpty() && (hoverCallback = this.hoverCallback) != null) {
                if (hoverCallback.II0XooXoX() && hoverCallback.Oxx0IOOO()) {
                    View view = viewHolder.itemView;
                    kotlin.jvm.internal.IIX0o.oO(view, "it.itemView");
                    addHoverView(view);
                }
                hoverCallback.oxoX().invoke(canvas, getPaint$Adapter_release(), viewHolder, this.overDecorationRect);
            }
        }
    }

    public final void refreshItemDecoration() {
        this.overAdapterPosition = -1;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.postInvalidate();
        }
    }

    public final void setDownInHoverItem$Adapter_release(boolean z) {
        this.isDownInHoverItem = z;
    }

    public final void setHoverCallback$Adapter_release(@OXOo.oOoXoXO HoverCallback hoverCallback) {
        this.hoverCallback = hoverCallback;
    }

    public final void setOverAdapterPosition(int i) {
        this.overAdapterPosition = i;
    }

    public final void setOverViewHolder$Adapter_release(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder) {
        this.overViewHolder = viewHolder;
    }

    public final void setRecyclerView$Adapter_release(@OXOo.oOoXoXO RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final void setWindowContent$Adapter_release(@OXOo.oOoXoXO ViewGroup viewGroup) {
        this.windowContent = viewGroup;
    }
}
