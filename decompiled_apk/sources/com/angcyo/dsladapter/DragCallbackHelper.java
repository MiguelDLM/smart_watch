package com.angcyo.dsladapter;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class DragCallbackHelper extends ItemTouchHelper.Callback {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int FLAG_ALL = 15;
    public static final int FLAG_HORIZONTAL = 12;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_NO_INIT = -1;
    public static final int FLAG_VERTICAL = 3;
    public static final int PAYLOAD_UPDATE_PART_SWIPED = 4096;
    private boolean _dragHappened;

    @OXOo.OOXIXo
    private com.angcyo.dsladapter.internal.XO _drawText;

    @OXOo.oOoXoXO
    private ItemTouchHelper _itemTouchHelper;

    @OXOo.oOoXoXO
    private RecyclerView _recyclerView;
    private boolean _swipeHappened;
    private int itemSwipeFlag;

    @OXOo.oOoXoXO
    private Oox.Oxx0xo<? super List<? extends DslAdapterItem>, ? super List<? extends DslAdapterItem>, ? super Integer, ? super Integer, oXIO0o0XI> onItemMoveChanged;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> onItemSwipeDeleted;
    private int itemDragFlag = 15;
    private boolean enableLongPressDrag = true;
    private boolean _shouldReactToLongPress = true;

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super RecyclerView, ? super RecyclerView.ViewHolder, oXIO0o0XI> onClearView = new Oox.x0xO0oo<RecyclerView, RecyclerView.ViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DragCallbackHelper$onClearView$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 0>");
            kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "<anonymous parameter 1>");
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            invoke2(recyclerView, viewHolder);
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super RecyclerView.ViewHolder, ? super Integer, oXIO0o0XI> onSelectedChanged = new Oox.x0xO0oo<RecyclerView.ViewHolder, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DragCallbackHelper$onSelectedChanged$1
        public final void invoke(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder, int i) {
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(RecyclerView.ViewHolder viewHolder, Integer num) {
            invoke(viewHolder, num.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }
    };
    private boolean enableSwipeTip = true;

    @OXOo.OOXIXo
    private CharSequence swipeTipText = "滑动可删除";

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ DragCallbackHelper II0xO0(oIX0oI oix0oi, RecyclerView recyclerView, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 15;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return oix0oi.oIX0oI(recyclerView, i, i2);
        }

        public final void I0Io(@OXOo.oOoXoXO DragCallbackHelper dragCallbackHelper) {
            if (dragCallbackHelper != null) {
                dragCallbackHelper.detachFromRecyclerView();
            }
        }

        @OXOo.OOXIXo
        public final DragCallbackHelper oIX0oI(@OXOo.OOXIXo RecyclerView recyclerView, int i, int i2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
            DragCallbackHelper dragCallbackHelper = new DragCallbackHelper();
            dragCallbackHelper.setItemDragFlag(i);
            dragCallbackHelper.setItemSwipeFlag(i2);
            dragCallbackHelper.attachToRecyclerView(recyclerView);
            return dragCallbackHelper;
        }

        public oIX0oI() {
        }
    }

    public DragCallbackHelper() {
        com.angcyo.dsladapter.internal.XO xo2 = new com.angcyo.dsladapter.internal.XO();
        xo2.xxIXOIIO().setColor(SupportMenu.CATEGORY_MASK);
        xo2.xxIXOIIO().setTextSize(14 * LibExKt.oOXoIIIo(xo2));
        this._drawText = xo2;
    }

    public final void attachToRecyclerView(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        this._recyclerView = recyclerView;
        ItemTouchHelper itemTouchHelper = this._itemTouchHelper;
        if (itemTouchHelper == null) {
            itemTouchHelper = new ItemTouchHelper(this);
        }
        this._itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder current, @OXOo.OOXIXo RecyclerView.ViewHolder target) {
        DslAdapterItem dslAdapterItem;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(current, "current");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        DslAdapter dslAdapter = get_dslAdapter();
        DslAdapterItem dslAdapterItem2 = null;
        if (dslAdapter != null) {
            dslAdapterItem = DslAdapter.getItemData$default(dslAdapter, current.getAdapterPosition(), false, 2, null);
        } else {
            dslAdapterItem = null;
        }
        DslAdapter dslAdapter2 = get_dslAdapter();
        if (dslAdapter2 != null) {
            dslAdapterItem2 = DslAdapter.getItemData$default(dslAdapter2, target.getAdapterPosition(), false, 2, null);
        }
        if (dslAdapterItem != null && dslAdapterItem2 != null) {
            return dslAdapterItem2.isItemCanDropOver().invoke(dslAdapterItem).booleanValue();
        }
        return super.canDropOver(recyclerView, current, target);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        this.onClearView.invoke(recyclerView, viewHolder);
    }

    public final void detachFromRecyclerView() {
        this._recyclerView = null;
        ItemTouchHelper itemTouchHelper = this._itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(null);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@OXOo.OOXIXo RecyclerView recyclerView, int i, float f, float f2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        return super.getAnimationDuration(recyclerView, i, f, f2);
    }

    public final boolean getEnableLongPressDrag() {
        return this.enableLongPressDrag;
    }

    public final boolean getEnableSwipeTip() {
        return this.enableSwipeTip;
    }

    public final int getItemDragFlag() {
        return this.itemDragFlag;
    }

    public final int getItemSwipeFlag() {
        return this.itemSwipeFlag;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        int i;
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        DslAdapter dslAdapter = get_dslAdapter();
        DslAdapterItem dslAdapterItem = null;
        int i3 = 0;
        if (dslAdapter != null) {
            dslAdapterItem = DslAdapter.getItemData$default(dslAdapter, viewHolder.getAdapterPosition(), false, 2, null);
        }
        if (dslAdapterItem == null) {
            return 0;
        }
        if (dslAdapterItem.getItemDragFlag() >= 0) {
            i = dslAdapterItem.getItemDragFlag();
        } else {
            i = this.itemDragFlag;
        }
        if (dslAdapterItem.getItemSwipeFlag() >= 0) {
            i2 = dslAdapterItem.getItemSwipeFlag();
        } else {
            i2 = this.itemSwipeFlag;
        }
        if (!dslAdapterItem.getItemDragEnable()) {
            i = 0;
        }
        if (dslAdapterItem.getItemSwipeEnable()) {
            i3 = i2;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i, i3);
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<RecyclerView, RecyclerView.ViewHolder, oXIO0o0XI> getOnClearView() {
        return this.onClearView;
    }

    @OXOo.oOoXoXO
    public final Oox.Oxx0xo<List<? extends DslAdapterItem>, List<? extends DslAdapterItem>, Integer, Integer, oXIO0o0XI> getOnItemMoveChanged() {
        return this.onItemMoveChanged;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> getOnItemSwipeDeleted() {
        return this.onItemSwipeDeleted;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<RecyclerView.ViewHolder, Integer, oXIO0o0XI> getOnSelectedChanged() {
        return this.onSelectedChanged;
    }

    @OXOo.OOXIXo
    public final CharSequence getSwipeTipText() {
        return this.swipeTipText;
    }

    public final boolean get_dragHappened() {
        return this._dragHappened;
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.internal.XO get_drawText() {
        return this._drawText;
    }

    @OXOo.oOoXoXO
    public final DslAdapter get_dslAdapter() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (!(adapter instanceof DslAdapter)) {
            return null;
        }
        return (DslAdapter) adapter;
    }

    @OXOo.oOoXoXO
    public final ItemTouchHelper get_itemTouchHelper() {
        return this._itemTouchHelper;
    }

    @OXOo.oOoXoXO
    public final RecyclerView get_recyclerView() {
        return this._recyclerView;
    }

    public final boolean get_shouldReactToLongPress() {
        return this._shouldReactToLongPress;
    }

    public final boolean get_swipeHappened() {
        return this._swipeHappened;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        if (this.itemSwipeFlag > 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        if (this.enableLongPressDrag && this._shouldReactToLongPress) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        float right;
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (this.enableSwipeTip && z && i == 1) {
            View view = viewHolder.itemView;
            kotlin.jvm.internal.IIX0o.oO(view, "viewHolder.itemView");
            if (f > 0.0f) {
                right = view.getLeft();
            } else {
                right = view.getRight() - this._drawText.xxIXOIIO().measureText(this.swipeTipText.toString());
            }
            float top = (view.getTop() + (view.getMeasuredHeight() / 2)) - (LibExKt.xI0oxI00(this._drawText.xxIXOIIO()) / 2);
            canvas.save();
            canvas.translate(right, top);
            this._drawText.x0xO0oo(this.swipeTipText);
            this._drawText.x0XOIxOo(canvas);
            canvas.restore();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RecyclerView recyclerView, @OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, @OXOo.OOXIXo RecyclerView.ViewHolder target) {
        List<DslAdapterItem> list;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = target.getAdapterPosition();
        DslAdapter dslAdapter = get_dslAdapter();
        boolean z = false;
        if (dslAdapter != null) {
            List<DslAdapterItem> validFilterDataList = dslAdapter.getValidFilterDataList();
            DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(validFilterDataList, adapterPosition);
            DslAdapterItem dslAdapterItem2 = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(validFilterDataList, adapterPosition2);
            if (dslAdapterItem != null && dslAdapterItem2 != null) {
                Pair<List<DslAdapterItem>, Integer> XX02 = DslAdapterExKt.XX0(dslAdapter, dslAdapterItem);
                Pair<List<DslAdapterItem>, Integer> XX03 = DslAdapterExKt.XX0(dslAdapter, dslAdapterItem2);
                List<DslAdapterItem> first = XX02.getFirst();
                List<DslAdapterItem> first2 = XX03.getFirst();
                List<DslAdapterItem> list2 = first;
                if ((list2 != null && !list2.isEmpty()) || ((list = first2) != null && !list.isEmpty())) {
                    Collections.swap(validFilterDataList, adapterPosition, adapterPosition2);
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(first, first2)) {
                        Collections.swap(first, XX02.getSecond().intValue(), XX03.getSecond().intValue());
                    } else {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(first);
                        DslAdapterItem dslAdapterItem3 = first.get(XX02.getSecond().intValue());
                        int intValue = XX02.getSecond().intValue();
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(first2);
                        first.set(intValue, first2.get(XX03.getSecond().intValue()));
                        first2.set(XX03.getSecond().intValue(), dslAdapterItem3);
                    }
                    dslAdapter._updateAdapterItems();
                    dslAdapter.notifyItemMoved(adapterPosition, adapterPosition2);
                    z = true;
                    this._dragHappened = true;
                    Oox.Oxx0xo<? super List<? extends DslAdapterItem>, ? super List<? extends DslAdapterItem>, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo = this.onItemMoveChanged;
                    if (oxx0xo != null) {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(first);
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(first2);
                        oxx0xo.invoke(first, first2, XX02.getSecond(), XX03.getSecond());
                    }
                }
            }
        }
        return z;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
        this.onSelectedChanged.invoke(viewHolder, Integer.valueOf(i));
        if (viewHolder != null) {
            this._dragHappened = false;
            this._swipeHappened = false;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@OXOo.OOXIXo RecyclerView.ViewHolder viewHolder, int i) {
        DslAdapterItem itemData$default;
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        this._swipeHappened = true;
        DslAdapter dslAdapter = get_dslAdapter();
        if (dslAdapter != null && (itemData$default = DslAdapter.getItemData$default(dslAdapter, viewHolder.getAdapterPosition(), false, 2, null)) != null) {
            DslAdapter.removeItemFromAll$default(dslAdapter, itemData$default, false, 2, null);
            itemData$default.updateItemDepend(new XxX0x0xxx(itemData$default, false, false, false, false, false, CollectionsKt__CollectionsKt.X00IoxXI(1, 4096), null, 0L, 0L, null, 1950, null));
            Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> oooxoxo = this.onItemSwipeDeleted;
            if (oooxoxo != null) {
                oooxoxo.invoke(itemData$default);
            }
        }
    }

    public final void setEnableLongPressDrag(boolean z) {
        this.enableLongPressDrag = z;
    }

    public final void setEnableSwipeTip(boolean z) {
        this.enableSwipeTip = z;
    }

    public final void setItemDragFlag(int i) {
        this.itemDragFlag = i;
    }

    public final void setItemSwipeFlag(int i) {
        this.itemSwipeFlag = i;
    }

    public final void setOnClearView(@OXOo.OOXIXo Oox.x0xO0oo<? super RecyclerView, ? super RecyclerView.ViewHolder, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.onClearView = x0xo0oo;
    }

    public final void setOnItemMoveChanged(@OXOo.oOoXoXO Oox.Oxx0xo<? super List<? extends DslAdapterItem>, ? super List<? extends DslAdapterItem>, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        this.onItemMoveChanged = oxx0xo;
    }

    public final void setOnItemSwipeDeleted(@OXOo.oOoXoXO Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> oooxoxo) {
        this.onItemSwipeDeleted = oooxoxo;
    }

    public final void setOnSelectedChanged(@OXOo.OOXIXo Oox.x0xO0oo<? super RecyclerView.ViewHolder, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.onSelectedChanged = x0xo0oo;
    }

    public final void setSwipeTipText(@OXOo.OOXIXo CharSequence value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        CharSequence charSequence = this.swipeTipText;
        this.swipeTipText = value;
        if (!TextUtils.equals(charSequence, value)) {
            this._drawText.IIXOooo(null);
        }
    }

    public final void set_dragHappened(boolean z) {
        this._dragHappened = z;
    }

    public final void set_drawText(@OXOo.OOXIXo com.angcyo.dsladapter.internal.XO xo2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xo2, "<set-?>");
        this._drawText = xo2;
    }

    public final void set_itemTouchHelper(@OXOo.oOoXoXO ItemTouchHelper itemTouchHelper) {
        this._itemTouchHelper = itemTouchHelper;
    }

    public final void set_recyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        this._recyclerView = recyclerView;
    }

    public final void set_shouldReactToLongPress(boolean z) {
        this._shouldReactToLongPress = z;
    }

    public final void set_swipeHappened(boolean z) {
        this._swipeHappened = z;
    }

    public final void startDrag(@OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        ItemTouchHelper itemTouchHelper = this._itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.startDrag(viewHolder);
        }
    }

    public final void startSwipe(@OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        ItemTouchHelper itemTouchHelper = this._itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.startSwipe(viewHolder);
        }
    }
}
