package com.angcyo.dsladapter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class DslItemDecoration extends RecyclerView.ItemDecoration {

    @OXOo.OOXIXo
    private final Rect _tempDrawRect;

    @OXOo.OOXIXo
    private final Rect _tempRect;

    @OXOo.OOXIXo
    private Oox.xoXoI<? super Canvas, ? super RecyclerView, ? super RecyclerView.State, ? super Rect, ? super DslViewHolder, ? super DslViewHolder, ? super DslViewHolder, ? super Boolean, oXIO0o0XI> eachItemDoIt;

    @OXOo.OOXIXo
    private final Oox.oI0IIXIo<DslItemDecoration, Rect, View, RecyclerView, RecyclerView.State, oXIO0o0XI> getItemOffsets;

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<DslItemDecoration, oXIO0o0XI> init;

    @OXOo.OOXIXo
    private final Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI> onDraw;

    @OXOo.OOXIXo
    private final Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI> onDrawOver;

    @OXOo.OOXIXo
    private final Paint paint;

    public DslItemDecoration() {
        this(null, null, null, null, 15, null);
    }

    public final void attachToRecyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
        }
    }

    public final void detachedFromRecyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.removeItemDecoration(this);
        }
    }

    @OXOo.OOXIXo
    public Oox.xoXoI<Canvas, RecyclerView, RecyclerView.State, Rect, DslViewHolder, DslViewHolder, DslViewHolder, Boolean, oXIO0o0XI> getEachItemDoIt() {
        return this.eachItemDoIt;
    }

    @OXOo.OOXIXo
    public final Oox.oI0IIXIo<DslItemDecoration, Rect, View, RecyclerView, RecyclerView.State, oXIO0o0XI> getGetItemOffsets() {
        return this.getItemOffsets;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslItemDecoration, oXIO0o0XI> getInit() {
        return this.init;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@OXOo.OOXIXo final Rect outRect, @OXOo.OOXIXo View view, @OXOo.OOXIXo final RecyclerView parent, @OXOo.OOXIXo final RecyclerView.State state) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(outRect, "outRect");
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
        this.getItemOffsets.invoke(this, outRect, view, parent, state);
        LibExKt.X0IIOO(parent, view, new Oox.IXxxXO<DslViewHolder, DslViewHolder, DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration$getItemOffsets$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, DslViewHolder dslViewHolder2, DslViewHolder dslViewHolder3) {
                invoke2(dslViewHolder, dslViewHolder2, dslViewHolder3);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO DslViewHolder dslViewHolder, @OXOo.OOXIXo DslViewHolder viewHolder, @OXOo.oOoXoXO DslViewHolder dslViewHolder2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                DslItemDecoration.this.getEachItemDoIt().invoke(null, parent, state, outRect, dslViewHolder, viewHolder, dslViewHolder2, Boolean.FALSE);
            }
        });
    }

    @OXOo.OOXIXo
    public final Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI> getOnDraw() {
        return this.onDraw;
    }

    @OXOo.OOXIXo
    public final Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI> getOnDrawOver() {
        return this.onDrawOver;
    }

    @OXOo.OOXIXo
    public final Paint getPaint() {
        return this.paint;
    }

    @OXOo.OOXIXo
    public final Rect get_tempDrawRect() {
        return this._tempDrawRect;
    }

    @OXOo.OOXIXo
    public final Rect get_tempRect() {
        return this._tempRect;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@OXOo.OOXIXo final Canvas canvas, @OXOo.OOXIXo final RecyclerView parent, @OXOo.OOXIXo final RecyclerView.State state) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
        this.onDraw.invoke(this, canvas, parent, state, this.paint);
        LibExKt.XI0IXoo(parent, null, new Oox.IXxxXO<DslViewHolder, DslViewHolder, DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration$onDraw$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, DslViewHolder dslViewHolder2, DslViewHolder dslViewHolder3) {
                invoke2(dslViewHolder, dslViewHolder2, dslViewHolder3);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO DslViewHolder dslViewHolder, @OXOo.OOXIXo DslViewHolder viewHolder, @OXOo.oOoXoXO DslViewHolder dslViewHolder2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                DslItemDecoration.this.getEachItemDoIt().invoke(canvas, parent, state, null, dslViewHolder, viewHolder, dslViewHolder2, Boolean.FALSE);
            }
        }, 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@OXOo.OOXIXo final Canvas canvas, @OXOo.OOXIXo final RecyclerView parent, @OXOo.OOXIXo final RecyclerView.State state) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
        this.onDrawOver.invoke(this, canvas, parent, state, this.paint);
        LibExKt.XI0IXoo(parent, null, new Oox.IXxxXO<DslViewHolder, DslViewHolder, DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration$onDrawOver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, DslViewHolder dslViewHolder2, DslViewHolder dslViewHolder3) {
                invoke2(dslViewHolder, dslViewHolder2, dslViewHolder3);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO DslViewHolder dslViewHolder, @OXOo.OOXIXo DslViewHolder viewHolder, @OXOo.oOoXoXO DslViewHolder dslViewHolder2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                DslItemDecoration.this.getEachItemDoIt().invoke(canvas, parent, state, null, dslViewHolder, viewHolder, dslViewHolder2, Boolean.TRUE);
            }
        }, 1, null);
    }

    public void onEachItemDoIt(@OXOo.oOoXoXO Canvas canvas, @OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo RecyclerView.State state, @OXOo.oOoXoXO Rect rect, @OXOo.oOoXoXO DslViewHolder dslViewHolder, @OXOo.OOXIXo DslViewHolder viewHolder, @OXOo.oOoXoXO DslViewHolder dslViewHolder2, boolean z) {
        DslAdapter dslAdapter;
        DslAdapterItem itemData$default;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        int adapterPosition = viewHolder.getAdapterPosition();
        if ((parent.getAdapter() instanceof DslAdapter) && adapterPosition != -1) {
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter instanceof DslAdapter) {
                dslAdapter = (DslAdapter) adapter;
            } else {
                dslAdapter = null;
            }
            if (dslAdapter != null && (itemData$default = DslAdapter.getItemData$default(dslAdapter, adapterPosition, false, 2, null)) != null) {
                if (rect != null) {
                    itemData$default.setItemOffsets(rect);
                }
                if (!state.isPreLayout() && !state.willRunSimpleAnimations() && canvas != null && !z) {
                    LibExKt.Oo(this._tempRect);
                    itemData$default.setItemOffsets(this._tempRect);
                    Paint paint = this.paint;
                    View view = viewHolder.itemView;
                    kotlin.jvm.internal.IIX0o.oO(view, "viewHolder.itemView");
                    Rect rect2 = this._tempRect;
                    RecyclerView.Adapter adapter2 = parent.getAdapter();
                    if (adapter2 != null) {
                        i = adapter2.getItemCount();
                    } else {
                        i = 0;
                    }
                    itemData$default.draw(canvas, paint, view, rect2, i, adapterPosition, this._tempDrawRect);
                }
            }
        }
    }

    public void setEachItemDoIt(@OXOo.OOXIXo Oox.xoXoI<? super Canvas, ? super RecyclerView, ? super RecyclerView.State, ? super Rect, ? super DslViewHolder, ? super DslViewHolder, ? super DslViewHolder, ? super Boolean, oXIO0o0XI> xoxoi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxoi, "<set-?>");
        this.eachItemDoIt = xoxoi;
    }

    public /* synthetic */ DslItemDecoration(Oox.oOoXoXO oooxoxo, Oox.oI0IIXIo oi0iixio, Oox.oI0IIXIo oi0iixio2, Oox.oI0IIXIo oi0iixio3, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new Oox.oOoXoXO<DslItemDecoration, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslItemDecoration dslItemDecoration) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItemDecoration, "<anonymous parameter 0>");
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslItemDecoration dslItemDecoration) {
                invoke2(dslItemDecoration);
                return oXIO0o0XI.f29392oIX0oI;
            }
        } : oooxoxo, (i & 2) != 0 ? new Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslItemDecoration dslItemDecoration, @OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.State state, @OXOo.OOXIXo Paint paint) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItemDecoration, "<anonymous parameter 0>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "<anonymous parameter 1>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 2>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(state, "<anonymous parameter 3>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "<anonymous parameter 4>");
            }

            @Override // Oox.oI0IIXIo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslItemDecoration dslItemDecoration, Canvas canvas, RecyclerView recyclerView, RecyclerView.State state, Paint paint) {
                invoke2(dslItemDecoration, canvas, recyclerView, state, paint);
                return oXIO0o0XI.f29392oIX0oI;
            }
        } : oi0iixio, (i & 4) != 0 ? new Oox.oI0IIXIo<DslItemDecoration, Canvas, RecyclerView, RecyclerView.State, Paint, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslItemDecoration dslItemDecoration, @OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.State state, @OXOo.OOXIXo Paint paint) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItemDecoration, "<anonymous parameter 0>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "<anonymous parameter 1>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 2>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(state, "<anonymous parameter 3>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "<anonymous parameter 4>");
            }

            @Override // Oox.oI0IIXIo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslItemDecoration dslItemDecoration, Canvas canvas, RecyclerView recyclerView, RecyclerView.State state, Paint paint) {
                invoke2(dslItemDecoration, canvas, recyclerView, state, paint);
                return oXIO0o0XI.f29392oIX0oI;
            }
        } : oi0iixio2, (i & 8) != 0 ? new Oox.oI0IIXIo<DslItemDecoration, Rect, View, RecyclerView, RecyclerView.State, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration.4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslItemDecoration dslItemDecoration, @OXOo.OOXIXo Rect rect, @OXOo.OOXIXo View view, @OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.State state) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItemDecoration, "<anonymous parameter 0>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(rect, "<anonymous parameter 1>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<anonymous parameter 2>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 3>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(state, "<anonymous parameter 4>");
            }

            @Override // Oox.oI0IIXIo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslItemDecoration dslItemDecoration, Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                invoke2(dslItemDecoration, rect, view, recyclerView, state);
                return oXIO0o0XI.f29392oIX0oI;
            }
        } : oi0iixio3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DslItemDecoration(@OXOo.OOXIXo Oox.oOoXoXO<? super DslItemDecoration, oXIO0o0XI> init, @OXOo.OOXIXo Oox.oI0IIXIo<? super DslItemDecoration, ? super Canvas, ? super RecyclerView, ? super RecyclerView.State, ? super Paint, oXIO0o0XI> onDrawOver, @OXOo.OOXIXo Oox.oI0IIXIo<? super DslItemDecoration, ? super Canvas, ? super RecyclerView, ? super RecyclerView.State, ? super Paint, oXIO0o0XI> onDraw, @OXOo.OOXIXo Oox.oI0IIXIo<? super DslItemDecoration, ? super Rect, ? super View, ? super RecyclerView, ? super RecyclerView.State, oXIO0o0XI> getItemOffsets) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onDrawOver, "onDrawOver");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onDraw, "onDraw");
        kotlin.jvm.internal.IIX0o.x0xO0oo(getItemOffsets, "getItemOffsets");
        this.init = init;
        this.onDrawOver = onDrawOver;
        this.onDraw = onDraw;
        this.getItemOffsets = getItemOffsets;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(12 * LibExKt.oOXoIIIo(paint));
        this.paint = paint;
        this._tempDrawRect = new Rect();
        this._tempRect = new Rect();
        this.eachItemDoIt = new Oox.xoXoI<Canvas, RecyclerView, RecyclerView.State, Rect, DslViewHolder, DslViewHolder, DslViewHolder, Boolean, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslItemDecoration$eachItemDoIt$1
            {
                super(8);
            }

            @Override // Oox.xoXoI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state, Rect rect, DslViewHolder dslViewHolder, DslViewHolder dslViewHolder2, DslViewHolder dslViewHolder3, Boolean bool) {
                invoke(canvas, recyclerView, state, rect, dslViewHolder, dslViewHolder2, dslViewHolder3, bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(@OXOo.oOoXoXO Canvas canvas, @OXOo.OOXIXo RecyclerView parent, @OXOo.OOXIXo RecyclerView.State state, @OXOo.oOoXoXO Rect rect, @OXOo.oOoXoXO DslViewHolder dslViewHolder, @OXOo.OOXIXo DslViewHolder viewHolder, @OXOo.oOoXoXO DslViewHolder dslViewHolder2, boolean z) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
                kotlin.jvm.internal.IIX0o.x0xO0oo(state, "state");
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                DslItemDecoration.this.onEachItemDoIt(canvas, parent, state, rect, dslViewHolder, viewHolder, dslViewHolder2, z);
            }
        };
        init.invoke(this);
    }
}
