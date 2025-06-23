package com.angcyo.dsladapter;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.math.MathUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.internal.RecyclerBottomLayout;
import com.angcyo.dsladapter.internal.ThrottleClickListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslAdapterItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslAdapterItem.kt\ncom/angcyo/dsladapter/DslAdapterItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1742:1\n1855#2,2:1743\n1855#2,2:1745\n1855#2,2:1747\n1#3:1749\n*S KotlinDebug\n*F\n+ 1 DslAdapterItem.kt\ncom/angcyo/dsladapter/DslAdapterItem\n*L\n677#1:1743,2\n1308#1:1745,2\n1463#1:1747,2\n*E\n"})
/* loaded from: classes7.dex */
public class DslAdapterItem implements LifecycleOwner {
    static final /* synthetic */ kotlin.reflect.x0XOIxOo<Object>[] $$delegatedProperties = {kotlin.jvm.internal.IO.OOXIXo(new MutablePropertyReference1Impl(DslAdapterItem.class, "itemGroupExtend", "getItemGroupExtend()Z", 0)), kotlin.jvm.internal.IO.OOXIXo(new MutablePropertyReference1Impl(DslAdapterItem.class, "itemHidden", "getItemHidden()Z", 0))};

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static long DEFAULT_THROTTLE_INTERVAL = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
    public static final int FULL_ITEM = -1;
    public static final int PAYLOAD_UPDATE_EXTEND = 4;
    public static final int PAYLOAD_UPDATE_HIDDEN = 8;
    public static final int PAYLOAD_UPDATE_LAST = 32;
    public static final int PAYLOAD_UPDATE_MEDIA = 2;
    public static final int PAYLOAD_UPDATE_PART = 1;
    public static final int PAYLOAD_UPDATE_SELECT = 16;

    @OXOo.oOoXoXO
    private ooXIXxIX _itemGroupParamsCache;

    @OXOo.oOoXoXO
    private SwipeMenuHelper _itemSwipeMenuHelper;

    @AnimRes
    @AnimatorRes
    private int itemAnimateRes;
    private int itemBottomInsert;
    private int itemBottomOffset;
    private boolean itemChanged;
    private boolean itemChanging;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super View, oXIO0o0XI> itemClick;

    @OXOo.oOoXoXO
    private Object itemData;
    private int itemDecorationColor;

    @OXOo.oOoXoXO
    private Drawable itemDecorationDrawable;

    @OXOo.oOoXoXO
    private DslAdapter itemDslAdapter;

    @OXOo.oOoXoXO
    private Integer itemFirstPaddingTop;
    private int itemFlag;
    private boolean itemIsSelected;

    @OXOo.oOoXoXO
    private Integer itemLastPaddingBottom;
    private int itemLeftInsert;
    private int itemLeftOffset;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super View, Boolean> itemLongClick;

    @OXOo.oOoXoXO
    private WeakReference<DslAdapterItem> itemParentRef;
    private boolean itemRemoveFlag;
    private int itemRightInsert;
    private int itemRightOffset;

    @OXOo.oOoXoXO
    private DslAdapterItem itemSelectMutexFromItem;

    @OXOo.oOoXoXO
    private Boolean itemShowLastLineView;
    private boolean itemSingleSelectMutex;

    @OXOo.oOoXoXO
    private String itemTag;

    @OXOo.oOoXoXO
    private SparseArray<Object> itemTags;

    @OXOo.oOoXoXO
    private Throwable itemThrowable;
    private int itemTopInsert;
    private int itemTopOffset;

    @OXOo.oOoXoXO
    private Integer itemViewType;

    @OXOo.oOoXoXO
    private Oox.IIXOooo<? super Canvas, ? super Paint, ? super View, ? super Rect, ? super Integer, ? super Integer, ? super Rect, oXIO0o0XI> onDraw;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super Rect, oXIO0o0XI> onSetItemOffset;
    private boolean onlyDrawOffsetArea;

    @OXOo.OOXIXo
    private Oox.oOoXoXO<Object, oXIO0o0XI> itemUpdateAction = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemUpdateAction$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.oOoXoXO Object obj) {
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj) {
            invoke2(obj);
            return oXIO0o0XI.f29392oIX0oI;
        }
    };
    private int itemSpanCount = 1;
    private int itemLayoutId = -1;
    private int itemWidth = LibExKt.IO();
    private int itemMinWidth = LibExKt.IO();
    private int itemHeight = LibExKt.IO();
    private int itemMinHeight = LibExKt.IO();
    private int itemPaddingLeft = LibExKt.IO();
    private int itemPaddingRight = LibExKt.IO();
    private int itemPaddingTop = LibExKt.IO();
    private int itemPaddingBottom = LibExKt.IO();

    @OXOo.oOoXoXO
    private Drawable itemBackgroundDrawable = new OI0();
    private boolean itemEnable = true;

    @OXOo.OOXIXo
    private Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> itemBind = new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemBind$1
        {
            super(4);
        }

        @Override // Oox.Oxx0xo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
            return oXIO0o0XI.f29392oIX0oI;
        }

        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
            kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
            kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
            DslAdapterItem.this.onItemBind(itemHolder, i, adapterItem, payloads);
            DslAdapterItem.this.getItemBindOverride().invoke(itemHolder, Integer.valueOf(i), adapterItem, payloads);
            DslAdapterItem.this.onItemBindAfter(itemHolder, i, adapterItem, payloads);
        }
    };
    private long itemClickThrottleInterval = DEFAULT_THROTTLE_INTERVAL;

    @OXOo.oOoXoXO
    private View.OnClickListener _clickListener = new ThrottleClickListener(0, null, new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$_clickListener$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
            invoke2(view);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo final View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            Object[] objArr = {DslAdapterItem.this.getItemClick(), view};
            final DslAdapterItem dslAdapterItem = DslAdapterItem.this;
            LibExKt.XX0xXo(objArr, new Oox.oOoXoXO<Object[], oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$_clickListener$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object[] objArr2) {
                    invoke2(objArr2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Object[] it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    Oox.oOoXoXO<View, oXIO0o0XI> itemClick = DslAdapterItem.this.getItemClick();
                    if (itemClick != null) {
                        itemClick.invoke(view);
                    }
                }
            });
        }
    }, 3, null);

    @OXOo.oOoXoXO
    private View.OnLongClickListener _longClickListener = new View.OnLongClickListener() { // from class: com.angcyo.dsladapter.I0Io
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            boolean _longClickListener$lambda$4;
            _longClickListener$lambda$4 = DslAdapterItem._longClickListener$lambda$4(DslAdapterItem.this, view);
            return _longClickListener$lambda$4;
        }
    };
    private long _itemAnimateDelay = -1;

    @OXOo.OOXIXo
    private Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> itemBindOverride = new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemBindOverride$1
        public final void invoke(@OXOo.OOXIXo DslViewHolder dslViewHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslViewHolder, "<anonymous parameter 0>");
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
            kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
        }

        @Override // Oox.Oxx0xo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> itemViewAttachedToWindow = new Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemViewAttachedToWindow$1
        {
            super(2);
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
            invoke(dslViewHolder, num.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
            DslAdapterItem.this.onItemViewAttachedToWindow(itemHolder, i);
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> itemViewDetachedToWindow = new Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemViewDetachedToWindow$1
        {
            super(2);
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
            invoke(dslViewHolder, num.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
            DslAdapterItem.this.onItemViewDetachedToWindow(itemHolder, i);
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> itemViewRecycled = new Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemViewRecycled$1
        {
            super(2);
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num) {
            invoke(dslViewHolder, num.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
            DslAdapterItem.this.onItemViewRecycled(itemHolder, i);
        }
    };

    @OXOo.OOXIXo
    private final UpdateDependProperty itemGroupExtend$delegate = new UpdateDependProperty(Boolean.TRUE, CollectionsKt__CollectionsKt.X00IoxXI(1, 4), new DslAdapterItem$itemGroupExtend$2(this));

    @OXOo.OOXIXo
    private final UpdateDependProperty itemHidden$delegate = new UpdateDependProperty(Boolean.FALSE, CollectionsKt__CollectionsKt.X00IoxXI(1, 8), null, 4, null);

    @OXOo.OOXIXo
    private final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> itemGroupExtendChangeListenerList = new LinkedHashSet();
    private boolean itemIsGroupHead;
    private boolean itemIsHover = this.itemIsGroupHead;
    private boolean itemAutoHideLastLineView = true;
    private boolean itemAutoPaddingFirstOrLast = true;
    private boolean itemDrawLeft = true;
    private boolean itemDrawTop = true;
    private boolean itemDrawRight = true;
    private boolean itemDrawBottom = true;
    private boolean noDrawLastItemDecoration = true;

    @OXOo.OOXIXo
    private Oox.Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> eachDrawItemDecoration = new Oox.Oxx0xo<Integer, Integer, Integer, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$eachDrawItemDecoration$1
        public final void invoke(int i, int i2, int i3, int i4) {
        }

        @Override // Oox.Oxx0xo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2, Integer num3, Integer num4) {
            invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super Canvas, ? super Rect, oXIO0o0XI> onDrawItemDecorationDrawable = new Oox.x0xO0oo<Canvas, Rect, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$onDrawItemDecorationDrawable$1
        {
            super(2);
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Canvas canvas, Rect rect) {
            invoke2(canvas, rect);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Rect rect) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
            kotlin.jvm.internal.IIX0o.x0xO0oo(rect, "rect");
            Drawable itemDecorationDrawable = DslAdapterItem.this.getItemDecorationDrawable();
            if (itemDecorationDrawable != null) {
                itemDecorationDrawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
                itemDecorationDrawable.draw(canvas);
            }
        }
    };
    private boolean itemUpdateFlag = true;

    @OXOo.OOXIXo
    private Oox.Oxx0xo<? super DslAdapterItem, ? super DslAdapterItem, ? super Integer, ? super Integer, Boolean> thisAreItemsTheSame = new Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$thisAreItemsTheSame$1
        {
            super(4);
        }

        @Override // Oox.Oxx0xo
        public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, Integer num, Integer num2) {
            return invoke(dslAdapterItem, dslAdapterItem2, num.intValue(), num2.intValue());
        }

        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapterItem newItem, int i, int i2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
            boolean Oxx0IOOO2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(DslAdapterItem.this, newItem);
            if (!DslAdapterItem.this.getItemRemoveFlag()) {
                if (!Oxx0IOOO2) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(DslAdapterItem.this), LibExKt.x0xO0oo(newItem))) {
                        Integer itemViewType = DslAdapterItem.this.getItemViewType();
                        int intValue = itemViewType != null ? itemViewType.intValue() : DslAdapterItem.this.getItemLayoutId();
                        Integer itemViewType2 = newItem.getItemViewType();
                        if (intValue == (itemViewType2 != null ? itemViewType2.intValue() : newItem.getItemLayoutId())) {
                            Oxx0IOOO2 = (DslAdapterItem.this.getItemData() == null && newItem.getItemData() == null) ? true : kotlin.jvm.internal.IIX0o.Oxx0IOOO(DslAdapterItem.this.getItemData(), newItem.getItemData());
                        }
                    }
                }
                return Boolean.valueOf(Oxx0IOOO2);
            }
            Oxx0IOOO2 = false;
            return Boolean.valueOf(Oxx0IOOO2);
        }
    };

    @OXOo.OOXIXo
    private Oox.Oxx0xo<? super DslAdapterItem, ? super DslAdapterItem, ? super Integer, ? super Integer, Boolean> thisAreContentsTheSame = new Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$thisAreContentsTheSame$1
        {
            super(4);
        }

        @Override // Oox.Oxx0xo
        public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, Integer num, Integer num2) {
            return invoke(dslAdapterItem, dslAdapterItem2, num.intValue(), num2.intValue());
        }

        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapterItem newItem, int i, int i2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
            boolean z = false;
            if (!DslAdapterItem.this.getItemUpdateFlag() && !newItem.getItemUpdateFlag() && !DslAdapterItem.this.getItemChanging() && !newItem.getItemChanging()) {
                if (DslAdapterItem.this.getItemData() == null && newItem.getItemData() == null) {
                    z = kotlin.jvm.internal.IIX0o.Oxx0IOOO(DslAdapterItem.this, newItem);
                } else {
                    z = kotlin.jvm.internal.IIX0o.Oxx0IOOO(DslAdapterItem.this.getItemData(), newItem.getItemData());
                }
            }
            return Boolean.valueOf(z);
        }
    };

    @OXOo.OOXIXo
    private Oox.oI0IIXIo<? super DslAdapterItem, Object, ? super DslAdapterItem, ? super Integer, ? super Integer, ? extends Object> thisGetChangePayload = new Oox.oI0IIXIo<DslAdapterItem, Object, DslAdapterItem, Integer, Integer, Object>() { // from class: com.angcyo.dsladapter.DslAdapterItem$thisGetChangePayload$1
        @Override // Oox.oI0IIXIo
        public /* bridge */ /* synthetic */ Object invoke(DslAdapterItem dslAdapterItem, Object obj, DslAdapterItem dslAdapterItem2, Integer num, Integer num2) {
            return invoke(dslAdapterItem, obj, dslAdapterItem2, num.intValue(), num2.intValue());
        }

        @OXOo.OOXIXo
        public final Object invoke(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo DslAdapterItem dslAdapterItem2, int i, int i2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem2, "<anonymous parameter 2>");
            if (obj == null) {
                return 1;
            }
            return obj;
        }
    };

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> itemChangeListener = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemChangeListener$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
            invoke2(dslAdapterItem);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo DslAdapterItem it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            DslAdapterItem.this.onItemChangeListener(it);
        }
    };

    @OXOo.OOXIXo
    private final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> itemChangeListenerList = new LinkedHashSet();

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> isItemInHiddenList = new Oox.x0xO0oo<DslAdapterItem, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$isItemInHiddenList$1
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 0>");
            return Boolean.FALSE;
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem, Integer num) {
            return invoke(dslAdapterItem, num.intValue());
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> isItemInUpdateList = new Oox.x0xO0oo<DslAdapterItem, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$isItemInUpdateList$1
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 0>");
            return Boolean.FALSE;
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem, Integer num) {
            return invoke(dslAdapterItem, num.intValue());
        }
    };

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslAdapterItem, Boolean> itemUpdateFrom = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemUpdateFrom$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            return Boolean.valueOf(DslAdapterItem.this.onItemUpdateFrom(it));
        }
    };

    @OXOo.OOXIXo
    private final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> itemUpdateFromListenerList = new LinkedHashSet();

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslAdapterItem, Boolean> itemIsSelectMutexAction = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemIsSelectMutexAction$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(it), LibExKt.x0xO0oo(DslAdapterItem.this)));
        }
    };

    @OXOo.OOXIXo
    private Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> isItemCanSelected = new Oox.x0xO0oo<Boolean, Boolean, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$isItemCanSelected$1
        @OXOo.OOXIXo
        public final Boolean invoke(boolean z, boolean z2) {
            return Boolean.valueOf(z != z2);
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, Boolean bool2) {
            return invoke(bool.booleanValue(), bool2.booleanValue());
        }
    };

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super IO, oXIO0o0XI> onItemSelectorChange = new Oox.oOoXoXO<IO, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$onItemSelectorChange$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(IO io2) {
            invoke2(io2);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo IO it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            if (it.OxxIIOOXO()) {
                DslAdapterItem.updateItemOnHaveDepend$default(DslAdapterItem.this, false, null, 3, null);
            }
        }
    };

    @OXOo.OOXIXo
    private final Set<Oox.oOoXoXO<IO, oXIO0o0XI>> itemSelectListener = new LinkedHashSet();

    @OXOo.OOXIXo
    private List<String> itemGroups = CollectionsKt__CollectionsKt.ooXIXxIX();

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslAdapterItem, Boolean> isItemInGroups = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$isItemInGroups$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem targetItem) {
            DslAdapterItem dslAdapterItem;
            kotlin.jvm.internal.IIX0o.x0xO0oo(targetItem, "targetItem");
            boolean z = DslAdapterItem.this.getItemGroups().isEmpty() && kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(DslAdapterItem.this), LibExKt.x0xO0oo(targetItem)) && DslAdapterItem.this.getItemLayoutId() == targetItem.getItemLayoutId();
            if (!z) {
                z = DslAdapterItem.this.getItemSubList().contains(targetItem);
            }
            if (!z && (dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.xX0ox(DslAdapterItem.this.getItemParentList())) != null) {
                z = dslAdapterItem.isItemInGroups().invoke(targetItem).booleanValue();
            }
            if (!z) {
                Iterator<String> it = targetItem.getItemGroups().iterator();
                while (it.hasNext()) {
                    z = z || DslAdapterItem.this.getItemGroups().contains(it.next());
                    if (z) {
                        break;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    };
    private boolean itemDragEnable = true;
    private boolean itemSwipeEnable = true;
    private int itemDragFlag = -1;
    private int itemSwipeFlag = -1;

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslAdapterItem, Boolean> isItemCanDropOver = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItem$isItemCanDropOver$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            return Boolean.valueOf(DslAdapterItem.this.getItemDragEnable());
        }
    };
    private boolean itemSwipeMenuEnable = true;
    private int itemSwipeMenuFlag = 4;
    private int itemSwipeMenuType = 1;

    @OXOo.OOXIXo
    private Oox.IXxxXO<? super DslViewHolder, ? super Float, ? super Float, oXIO0o0XI> itemSwipeMenuTo = new Oox.IXxxXO<DslViewHolder, Float, Float, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemSwipeMenuTo$1
        {
            super(3);
        }

        @Override // Oox.IXxxXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Float f, Float f2) {
            invoke(dslViewHolder, f.floatValue(), f2.floatValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, float f, float f2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
            DslAdapterItem.this.onItemSwipeMenuTo(itemHolder, f, f2);
        }
    };

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslViewHolder, Integer> itemSwipeWidth = new Oox.oOoXoXO<DslViewHolder, Integer>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemSwipeWidth$1
        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Integer invoke(@OXOo.OOXIXo DslViewHolder it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            View view = it.itemView;
            kotlin.jvm.internal.IIX0o.oO(view, "it.itemView");
            return Integer.valueOf(LibExKt.x0xO(LibExKt.oo(view, 0), 0, 1, null));
        }
    };

    @OXOo.OOXIXo
    private Oox.oOoXoXO<? super DslViewHolder, Integer> itemSwipeHeight = new Oox.oOoXoXO<DslViewHolder, Integer>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemSwipeHeight$1
        @Override // Oox.oOoXoXO
        @OXOo.OOXIXo
        public final Integer invoke(@OXOo.OOXIXo DslViewHolder it) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            View view = it.itemView;
            kotlin.jvm.internal.IIX0o.oO(view, "it.itemView");
            return Integer.valueOf(LibExKt.IoOoo(LibExKt.oo(view, 0), 0, 1, null));
        }
    };

    @OXOo.OOXIXo
    private List<DslAdapterItem> itemSubList = new ArrayList();

    @OXOo.OOXIXo
    private Oox.oIX0oI<oXIO0o0XI> itemLoadSubList = new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$itemLoadSubList$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
            invoke2();
            return oXIO0o0XI.f29392oIX0oI;
        }
    };

    @OXOo.OOXIXo
    private List<DslAdapterItem> itemParentList = new ArrayList();

    @OXOo.OOXIXo
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(long j) {
            DslAdapterItem.DEFAULT_THROTTLE_INTERVAL = j;
        }

        public final long oIX0oI() {
            return DslAdapterItem.DEFAULT_THROTTLE_INTERVAL;
        }

        public oIX0oI() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _longClickListener$lambda$4(DslAdapterItem this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super View, Boolean> oooxoxo = this$0.itemLongClick;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.oO(view, "view");
            return oooxoxo.invoke(view).booleanValue();
        }
        return false;
    }

    public static /* synthetic */ ooXIXxIX findItemGroupParams$default(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, RecyclerView.LayoutManager layoutManager, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                layoutManager = null;
            }
            return dslAdapterItem.findItemGroupParams(dslAdapter, z, layoutManager);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findItemGroupParams");
    }

    public static /* synthetic */ void getItemBind$annotations() {
    }

    public static /* synthetic */ void getItemChanged$annotations() {
    }

    public static /* synthetic */ void getItemChanging$annotations() {
    }

    public static /* synthetic */ void getItemEnable$annotations() {
    }

    public static /* synthetic */ void getItemGroupExtend$annotations() {
    }

    public static /* synthetic */ void getItemHidden$annotations() {
    }

    public static /* synthetic */ void getOnItemSelectorChange$annotations() {
    }

    public static /* synthetic */ boolean isFirstPositionInGroup$default(DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return dslAdapterItem.isFirstPositionInGroup(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isFirstPositionInGroup");
    }

    public static /* synthetic */ boolean isLastPositionInGroup$default(DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return dslAdapterItem.isLastPositionInGroup(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isLastPositionInGroup");
    }

    public static /* synthetic */ void updateAdapterItem$default(DslAdapterItem dslAdapterItem, Object obj, boolean z, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = 1;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            dslAdapterItem.updateAdapterItem(obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAdapterItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAdapterItem$lambda$0(DslAdapterItem this$0, Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.updateAdapterItem(obj, z);
    }

    public static /* synthetic */ void updateItemDepend$default(DslAdapterItem dslAdapterItem, XxX0x0xxx xxX0x0xxx, int i, Object obj) {
        DslAdapterItem dslAdapterItem2;
        XxX0x0xxx xxX0x0xxx2;
        if (obj == null) {
            if ((i & 1) != 0) {
                xxX0x0xxx2 = new XxX0x0xxx(dslAdapterItem, false, false, false, false, false, 1, null, 0L, 0L, null, 1950, null);
                dslAdapterItem2 = dslAdapterItem;
            } else {
                dslAdapterItem2 = dslAdapterItem;
                xxX0x0xxx2 = xxX0x0xxx;
            }
            dslAdapterItem2.updateItemDepend(xxX0x0xxx2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemDepend");
    }

    public static /* synthetic */ void updateItemDependPayload$default(DslAdapterItem dslAdapterItem, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = DslAdapterExKt.Ioxxx();
            }
            dslAdapterItem.updateItemDependPayload(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemDependPayload");
    }

    public static /* synthetic */ void updateItemOnHaveDepend$default(DslAdapterItem dslAdapterItem, boolean z, XxX0x0xxx xxX0x0xxx, int i, Object obj) {
        boolean z2;
        DslAdapterItem dslAdapterItem2;
        XxX0x0xxx xxX0x0xxx2;
        if (obj == null) {
            if ((i & 1) != 0) {
                z2 = true;
            } else {
                z2 = z;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx2 = new XxX0x0xxx(dslAdapterItem, false, false, false, false, false, 1, null, 0L, 0L, null, 1950, null);
                dslAdapterItem2 = dslAdapterItem;
            } else {
                dslAdapterItem2 = dslAdapterItem;
                xxX0x0xxx2 = xxX0x0xxx;
            }
            dslAdapterItem2.updateItemOnHaveDepend(z2, xxX0x0xxx2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemOnHaveDepend");
    }

    public static /* synthetic */ void updateItemSelect$default(DslAdapterItem dslAdapterItem, boolean z, IO io2, int i, Object obj) {
        IO io3;
        if (obj == null) {
            if ((i & 2) != 0) {
                io3 = new IO(dslAdapterItem, ItemSelectorHelperKt.xoXoI(z), false, false, false, null, false, false, false, null, 956, null);
            } else {
                io3 = io2;
            }
            dslAdapterItem.updateItemSelect(z, io3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemSelect");
    }

    public static /* synthetic */ void updateItemSelector$default(DslAdapterItem dslAdapterItem, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            dslAdapterItem.updateItemSelector(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemSelector");
    }

    public void _initItemAnimate(@OXOo.OOXIXo DslViewHolder itemHolder) {
        long j;
        com.angcyo.dsladapter.internal.II0xO0 adapterItemAnimateDelayHandler;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        if (this.itemAnimateRes != 0) {
            DslAdapter dslAdapter = this.itemDslAdapter;
            if (dslAdapter != null && (adapterItemAnimateDelayHandler = dslAdapter.getAdapterItemAnimateDelayHandler()) != null) {
                j = adapterItemAnimateDelayHandler.oIX0oI(this);
            } else {
                j = this._itemAnimateDelay;
            }
            this._itemAnimateDelay = j;
            if (j >= 0) {
                Context context = itemHolder.getContext();
                kotlin.jvm.internal.IIX0o.oO(context, "itemHolder.context");
                Animation Oxx0IOOO2 = LibExKt.Oxx0IOOO(context, this.itemAnimateRes);
                if (Oxx0IOOO2 != null) {
                    Oxx0IOOO2.setStartOffset(this._itemAnimateDelay);
                    itemHolder.itemView.startAnimation(Oxx0IOOO2);
                    this._itemAnimateDelay = -2L;
                    return;
                }
                Context context2 = itemHolder.getContext();
                kotlin.jvm.internal.IIX0o.oO(context2, "itemHolder.context");
                Animator II0XooXoX2 = LibExKt.II0XooXoX(context2, this.itemAnimateRes);
                if (II0XooXoX2 != null) {
                    II0XooXoX2.setTarget(itemHolder.itemView);
                    II0XooXoX2.setStartDelay(this._itemAnimateDelay);
                    View view = itemHolder.itemView;
                    kotlin.jvm.internal.IIX0o.oO(view, "itemHolder.itemView");
                    LibExKt.OX00O0xII(view, II0XooXoX2);
                    View view2 = itemHolder.itemView;
                    kotlin.jvm.internal.IIX0o.oO(view2, "itemHolder.itemView");
                    LibExKt.Oxx0xo(view2, false, false, false, 7, null);
                    II0XooXoX2.start();
                    this._itemAnimateDelay = -2L;
                }
            }
        }
    }

    public void _initItemBackground(@OXOo.OOXIXo DslViewHolder itemHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        itemHolder.itemView.setSelected(this.itemIsSelected);
        if (!(this.itemBackgroundDrawable instanceof OI0)) {
            View _initItemBackground$lambda$5 = itemHolder.itemView;
            kotlin.jvm.internal.IIX0o.oO(_initItemBackground$lambda$5, "_initItemBackground$lambda$5");
            LibExKt.xX0IIXIx0(_initItemBackground$lambda$5, this.itemBackgroundDrawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void _initItemConfig(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        if (this instanceof com.angcyo.dsladapter.item.oIX0oI) {
            ((com.angcyo.dsladapter.item.oIX0oI) this).oIX0oI(itemHolder, i, adapterItem, payloads);
        }
    }

    public void _initItemEnable(@OXOo.OOXIXo DslViewHolder itemHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        itemHolder.enable(itemHolder.itemView, Boolean.valueOf(this.itemEnable), true);
    }

    public void _initItemListener(@OXOo.OOXIXo DslViewHolder itemHolder) {
        View.OnLongClickListener onLongClickListener;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View.OnClickListener onClickListener = this._clickListener;
        if (this.itemClick != null && onClickListener != null) {
            if (onClickListener instanceof ThrottleClickListener) {
                ((ThrottleClickListener) onClickListener).xxIXOIIO(this.itemClickThrottleInterval);
            }
            itemHolder.clickItem(onClickListener);
        } else if (!this.itemEnable) {
            itemHolder.itemView.setOnClickListener(null);
        }
        if (this.itemLongClick != null && (onLongClickListener = this._longClickListener) != null && this.itemEnable) {
            itemHolder.itemView.setOnLongClickListener(onLongClickListener);
        } else {
            itemHolder.itemView.setLongClickable(false);
        }
    }

    public void _initItemPadding(@OXOo.OOXIXo DslViewHolder itemHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        if (this.itemPaddingLeft == LibExKt.IO()) {
            this.itemPaddingLeft = itemHolder.itemView.getPaddingLeft();
        }
        if (this.itemPaddingRight == LibExKt.IO()) {
            this.itemPaddingRight = itemHolder.itemView.getPaddingRight();
        }
        if (this.itemPaddingTop == LibExKt.IO()) {
            this.itemPaddingTop = itemHolder.itemView.getPaddingTop();
        }
        if (this.itemPaddingBottom == LibExKt.IO()) {
            this.itemPaddingBottom = itemHolder.itemView.getPaddingBottom();
        }
        itemHolder.itemView.setPadding(this.itemPaddingLeft, this.itemPaddingTop, this.itemPaddingRight, this.itemPaddingBottom);
    }

    public void _initItemSize(@OXOo.OOXIXo DslViewHolder itemHolder) {
        int i;
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View view = itemHolder.itemView;
        kotlin.jvm.internal.IIX0o.oO(view, "itemHolder.itemView");
        if (view instanceof RecyclerBottomLayout) {
            return;
        }
        if (this.itemMinWidth == LibExKt.IO()) {
            this.itemMinWidth = view.getMinimumWidth();
        }
        if (this.itemMinHeight == LibExKt.IO()) {
            this.itemMinHeight = view.getMinimumHeight();
        }
        if (this.itemMinWidth != LibExKt.IO()) {
            view.setMinimumWidth(this.itemMinWidth);
            try {
                if (view instanceof ConstraintLayout) {
                    ((ConstraintLayout) view).setMinWidth(this.itemMinWidth);
                }
            } catch (Exception unused) {
            }
        }
        if (this.itemMinHeight != LibExKt.IO()) {
            view.setMinimumHeight(this.itemMinHeight);
            try {
                if (view instanceof ConstraintLayout) {
                    ((ConstraintLayout) view).setMinHeight(this.itemMinHeight);
                }
            } catch (Exception unused2) {
            }
        }
        if (this.itemWidth == LibExKt.IO()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                i2 = layoutParams.width;
            } else {
                i2 = this.itemWidth;
            }
            this.itemWidth = i2;
        }
        if (this.itemHeight == LibExKt.IO()) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                i = layoutParams2.height;
            } else {
                i = this.itemHeight;
            }
            this.itemHeight = i;
        }
        LibExKt.IIX0(view, this.itemWidth, this.itemHeight);
    }

    public void _initItemStyle(@OXOo.OOXIXo DslViewHolder itemHolder) {
        Integer num;
        Integer num2;
        int intValue;
        int intValue2;
        Integer num3;
        Integer num4;
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        boolean isLastPositionInGroup$default = isLastPositionInGroup$default(this, false, 1, null);
        View view = itemHolder.view(R.id.lib_item_line_view);
        if (view != null) {
            Boolean bool = this.itemShowLastLineView;
            if (bool == null) {
                if (this.itemAutoHideLastLineView) {
                    LibExKt.oxxXoxO(view, isLastPositionInGroup$default);
                }
            } else {
                LibExKt.x0OIX00oO(view, bool.booleanValue());
            }
        }
        if (this.itemAutoPaddingFirstOrLast) {
            if (this.itemFirstPaddingTop != null || this.itemLastPaddingBottom != null) {
                View view2 = itemHolder.itemView;
                int i = R.id.lib_tag_padding_top;
                Object tag = view2.getTag(i);
                if (tag instanceof Integer) {
                    num = (Integer) tag;
                } else {
                    num = null;
                }
                if (num == null) {
                    view2.setTag(i, Integer.valueOf(view2.getPaddingTop()));
                    num = Integer.valueOf(view2.getPaddingTop());
                }
                int i2 = R.id.lib_tag_padding_bottom;
                Object tag2 = view2.getTag(i2);
                if (tag2 instanceof Integer) {
                    num2 = (Integer) tag2;
                } else {
                    num2 = null;
                }
                if (num2 == null) {
                    view2.setTag(i2, Integer.valueOf(view2.getPaddingBottom()));
                    num2 = Integer.valueOf(view2.getPaddingBottom());
                }
                int paddingLeft = view2.getPaddingLeft();
                if (isFirstPositionInGroup$default(this, false, 1, null) && (num4 = this.itemFirstPaddingTop) != null) {
                    intValue = num4.intValue();
                } else {
                    intValue = num.intValue();
                }
                int paddingRight = view2.getPaddingRight();
                if (isLastPositionInGroup$default && (num3 = this.itemLastPaddingBottom) != null) {
                    intValue2 = num3.intValue();
                } else {
                    intValue2 = num2.intValue();
                }
                view2.setPadding(paddingLeft, intValue, paddingRight, intValue2);
            }
        }
    }

    public void _itemSelectorChange(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        this.onItemSelectorChange.invoke(selectorParams);
        Iterator<T> it = this.itemSelectListener.iterator();
        while (it.hasNext()) {
            ((Oox.oOoXoXO) it.next()).invoke(selectorParams);
        }
    }

    public void clearItemGroupParamsCache() {
        this._itemGroupParamsCache = null;
    }

    public void diffResult(@OXOo.oOoXoXO XxX0x0xxx xxX0x0xxx, @OXOo.oOoXoXO DiffUtil.DiffResult diffResult) {
        setItemChanging(false);
        this.itemUpdateFlag = false;
    }

    public void draw(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Paint paint, @OXOo.OOXIXo View itemView, @OXOo.OOXIXo Rect offsetRect, int i, int i2, @OXOo.OOXIXo Rect drawRect) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(canvas, "canvas");
        kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "paint");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemView, "itemView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(offsetRect, "offsetRect");
        kotlin.jvm.internal.IIX0o.x0xO0oo(drawRect, "drawRect");
        Oox.IIXOooo<? super Canvas, ? super Paint, ? super View, ? super Rect, ? super Integer, ? super Integer, ? super Rect, oXIO0o0XI> iIXOooo = this.onDraw;
        if (iIXOooo != null) {
            iIXOooo.invoke(canvas, paint, itemView, offsetRect, Integer.valueOf(i), Integer.valueOf(i2), drawRect);
            return;
        }
        this.eachDrawItemDecoration.invoke(0, Integer.valueOf(this.itemTopInsert), 0, 0);
        paint.setColor(this.itemDecorationColor);
        boolean z = this.onlyDrawOffsetArea;
        if (this.itemTopInsert > 0 && this.itemDrawTop) {
            if (z) {
                if (this.itemLeftOffset > 0) {
                    drawRect.set(itemView.getLeft(), itemView.getTop() - offsetRect.top, itemView.getLeft() + this.itemLeftOffset, itemView.getTop());
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
                if (this.itemRightOffset > 0) {
                    drawRect.set(itemView.getRight() - this.itemRightOffset, itemView.getTop() - offsetRect.top, itemView.getRight(), itemView.getTop());
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
            } else {
                drawRect.set(itemView.getLeft() + this.itemLeftOffset, itemView.getTop() - offsetRect.top, itemView.getRight() - this.itemRightOffset, itemView.getTop());
                canvas.drawRect(drawRect, paint);
                this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
            }
        }
        this.onlyDrawOffsetArea = z;
        this.eachDrawItemDecoration.invoke(0, 0, 0, Integer.valueOf(this.itemBottomInsert));
        paint.setColor(this.itemDecorationColor);
        if (this.itemBottomInsert > 0 && this.itemDrawBottom && (!this.noDrawLastItemDecoration || !isLastPositionInGroup$default(this, false, 1, null))) {
            if (this.onlyDrawOffsetArea) {
                if (this.itemLeftOffset > 0) {
                    drawRect.set(itemView.getLeft(), itemView.getBottom(), itemView.getLeft() + this.itemLeftOffset, itemView.getBottom() + offsetRect.bottom);
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
                if (this.itemRightOffset > 0) {
                    drawRect.set(itemView.getRight() - this.itemRightOffset, itemView.getBottom(), itemView.getRight(), itemView.getBottom() + offsetRect.bottom);
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
            } else {
                drawRect.set(itemView.getLeft() + this.itemLeftOffset, itemView.getBottom(), itemView.getRight() - this.itemRightOffset, itemView.getBottom() + offsetRect.bottom);
                canvas.drawRect(drawRect, paint);
                this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
            }
        }
        this.onlyDrawOffsetArea = z;
        this.eachDrawItemDecoration.invoke(Integer.valueOf(this.itemLeftInsert), 0, 0, 0);
        paint.setColor(this.itemDecorationColor);
        if (this.itemLeftInsert > 0 && this.itemDrawLeft) {
            if (this.onlyDrawOffsetArea) {
                if (this.itemTopOffset > 0) {
                    drawRect.set(itemView.getLeft() - offsetRect.left, itemView.getTop(), itemView.getLeft(), this.itemTopOffset);
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
                if (this.itemBottomOffset < 0) {
                    drawRect.set(itemView.getLeft() - offsetRect.left, itemView.getBottom() - this.itemBottomOffset, itemView.getLeft(), itemView.getBottom());
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
            } else {
                drawRect.set(itemView.getLeft() - offsetRect.left, itemView.getTop() + this.itemTopOffset, itemView.getLeft(), itemView.getBottom() - this.itemBottomOffset);
                canvas.drawRect(drawRect, paint);
                this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
            }
        }
        this.onlyDrawOffsetArea = z;
        this.eachDrawItemDecoration.invoke(0, 0, Integer.valueOf(this.itemRightInsert), 0);
        paint.setColor(this.itemDecorationColor);
        if (this.itemRightInsert > 0 && this.itemDrawRight) {
            if (this.onlyDrawOffsetArea) {
                if (this.itemTopOffset > 0) {
                    drawRect.set(itemView.getRight(), itemView.getTop(), itemView.getRight() + offsetRect.right, this.itemTopOffset);
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
                if (this.itemBottomOffset < 0) {
                    drawRect.set(itemView.getRight(), itemView.getBottom() - this.itemBottomOffset, itemView.getRight() + offsetRect.right, itemView.getBottom());
                    canvas.drawRect(drawRect, paint);
                    this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
                }
            } else {
                drawRect.set(itemView.getRight(), itemView.getTop() + this.itemTopOffset, itemView.getRight() + offsetRect.right, itemView.getBottom() - this.itemBottomOffset);
                canvas.drawRect(drawRect, paint);
                this.onDrawItemDecorationDrawable.invoke(canvas, drawRect);
            }
        }
        this.onlyDrawOffsetArea = z;
    }

    @OXOo.OOXIXo
    public ooXIXxIX findItemGroupParams(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.oOoXoXO RecyclerView.LayoutManager layoutManager) {
        RecyclerView.LayoutManager layoutManager2;
        x0o x0oVar;
        x0o II0xO02;
        x0o II0xO03;
        x0o II0xO04;
        x0o II0xO05;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        List<ooXIXxIX> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int size = dataList.size();
        ooXIXxIX ooxixxix = null;
        DslAdapterItem dslAdapterItem = null;
        ooXIXxIX ooxixxix2 = null;
        for (int i = 0; i < size; i++) {
            DslAdapterItem dslAdapterItem2 = dataList.get(i);
            if (i == 0 || kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, dslAdapterItem2)) {
                if (ooxixxix2 != null) {
                    ooxixxix2.oI0IIXIo(arrayList2.indexOf(this));
                    ooxixxix2.Oo(arrayList.indexOf(ooxixxix2));
                }
                ooxixxix2 = new ooXIXxIX(null, 0, 0, null, null, null, 63, null);
                arrayList2 = new ArrayList();
                arrayList2.add(dslAdapterItem2);
                arrayList.add(ooxixxix2);
                ooxixxix2.Oxx0xo(arrayList);
                ooxixxix2.IXxxXO(arrayList2);
                ooxixxix2.oO(dslAdapterItem2);
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem2, this)) {
                    ooxixxix = ooxixxix2;
                }
                int i2 = i + 1;
                int size2 = dataList.size();
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    DslAdapterItem dslAdapterItem3 = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(dataList, i2);
                    if (dslAdapterItem3 != null) {
                        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem3, this)) {
                            ooxixxix = ooxixxix2;
                        }
                        if (!DslAdapterItemExKt.XIxXXX0x0(dslAdapterItem2, dslAdapterItem3)) {
                            dslAdapterItem = dslAdapterItem3;
                            break;
                        }
                        arrayList2.add(dslAdapterItem3);
                    }
                    i2++;
                }
            }
        }
        if (ooxixxix != null) {
            ooxixxix.oO(this);
        }
        if (ooxixxix2 != null) {
            DslAdapterItem xxIXOIIO2 = ooxixxix2.xxIXOIIO();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxIXOIIO2);
            ooxixxix2.oI0IIXIo(arrayList2.indexOf(xxIXOIIO2));
            ooxixxix2.Oo(arrayList.indexOf(ooxixxix2));
        }
        if (layoutManager == null) {
            RecyclerView recyclerView = dslAdapter.get_recyclerView();
            layoutManager2 = recyclerView != null ? recyclerView.getLayoutManager() : null;
        } else {
            layoutManager2 = layoutManager;
        }
        if (ooxixxix != null && (layoutManager2 instanceof GridLayoutManager)) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager2;
            int indexOf = dataList.indexOf(this);
            List<DslAdapterItem> oOoXoXO2 = ooxixxix.oOoXoXO();
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            if (spanSizeLookup == null) {
                spanSizeLookup = new GridLayoutManager.DefaultSpanSizeLookup();
            } else {
                kotlin.jvm.internal.IIX0o.oO(spanSizeLookup, "spanSizeLookup ?: GridLa…r.DefaultSpanSizeLookup()");
            }
            x0o II0xO06 = IIX0o.II0xO0(spanSizeLookup, indexOf, gridLayoutManager.getSpanCount(), ooxixxix.x0XOIxOo());
            int i3 = indexOf + 1;
            if (dataList.size() > i3) {
                x0oVar = IIX0o.II0xO0(spanSizeLookup, i3, gridLayoutManager.getSpanCount(), oOoXoXO2.indexOf(dataList.get(i3)));
            } else {
                x0oVar = new x0o(0, 0, 0, 0, 0, 0, 63, null);
            }
            int ox0I2 = CollectionsKt___CollectionsKt.ox0I(dataList, CollectionsKt___CollectionsKt.XxXX(oOoXoXO2));
            if (ox0I2 == -1) {
                II0xO02 = new x0o(0, 0, 0, 0, 0, 0, 63, null);
            } else {
                II0xO02 = IIX0o.II0xO0(spanSizeLookup, ox0I2, gridLayoutManager.getSpanCount(), oOoXoXO2.indexOf(dataList.get(ox0I2)));
            }
            int ox0I3 = CollectionsKt___CollectionsKt.ox0I(dataList, CollectionsKt___CollectionsKt.xX0ox(oOoXoXO2));
            if (ox0I3 == -1) {
                II0xO03 = new x0o(0, 0, 0, 0, 0, 0, 63, null);
            } else {
                II0xO03 = IIX0o.II0xO0(spanSizeLookup, ox0I3, gridLayoutManager.getSpanCount(), oOoXoXO2.indexOf(dataList.get(ox0I3)));
            }
            if (dataList.isEmpty()) {
                II0xO04 = new x0o(0, 0, 0, 0, 0, 0, 63, null);
            } else {
                II0xO04 = IIX0o.II0xO0(spanSizeLookup, 0, gridLayoutManager.getSpanCount(), oOoXoXO2.indexOf(dataList.get(0)));
            }
            int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(dataList);
            if (dataList.isEmpty()) {
                II0xO05 = new x0o(0, 0, 0, 0, 0, 0, 63, null);
            } else {
                II0xO05 = IIX0o.II0xO0(spanSizeLookup, oo0xXOI0I2, gridLayoutManager.getSpanCount(), oOoXoXO2.indexOf(dataList.get(oo0xXOI0I2)));
            }
            ooxixxix.x0xO0oo(new xxX(II0xO06, x0oVar, II0xO02, II0xO03, II0xO04, II0xO05));
        } else if (!(layoutManager2 instanceof LinearLayoutManager) && layoutManager2 == null) {
            L.f5267oIX0oI.oo0xXOI0I("layoutManager is null");
        }
        return ooxixxix == null ? IIX0o.oIX0oI(this) : ooxixxix;
    }

    @OXOo.OOXIXo
    public final Oox.Oxx0xo<Integer, Integer, Integer, Integer, oXIO0o0XI> getEachDrawItemDecoration() {
        return this.eachDrawItemDecoration;
    }

    public final int getItemAnimateRes() {
        return this.itemAnimateRes;
    }

    public final boolean getItemAutoHideLastLineView() {
        return this.itemAutoHideLastLineView;
    }

    public final boolean getItemAutoPaddingFirstOrLast() {
        return this.itemAutoPaddingFirstOrLast;
    }

    @OXOo.oOoXoXO
    public final Drawable getItemBackgroundDrawable() {
        return this.itemBackgroundDrawable;
    }

    @OXOo.OOXIXo
    public final Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> getItemBind() {
        return this.itemBind;
    }

    @OXOo.OOXIXo
    public final Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> getItemBindOverride() {
        return this.itemBindOverride;
    }

    public final int getItemBottomInsert() {
        return this.itemBottomInsert;
    }

    public final int getItemBottomOffset() {
        return this.itemBottomOffset;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> getItemChangeListener() {
        return this.itemChangeListener;
    }

    @OXOo.OOXIXo
    public final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> getItemChangeListenerList() {
        return this.itemChangeListenerList;
    }

    public final boolean getItemChanged() {
        return this.itemChanged;
    }

    public final boolean getItemChanging() {
        return this.itemChanging;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<View, oXIO0o0XI> getItemClick() {
        return this.itemClick;
    }

    public final long getItemClickThrottleInterval() {
        return this.itemClickThrottleInterval;
    }

    @OXOo.oOoXoXO
    public final Object getItemData() {
        return this.itemData;
    }

    public final int getItemDecorationColor() {
        return this.itemDecorationColor;
    }

    @OXOo.oOoXoXO
    public final Drawable getItemDecorationDrawable() {
        return this.itemDecorationDrawable;
    }

    public final boolean getItemDragEnable() {
        return this.itemDragEnable;
    }

    public final int getItemDragFlag() {
        return this.itemDragFlag;
    }

    public final boolean getItemDrawBottom() {
        return this.itemDrawBottom;
    }

    public final boolean getItemDrawLeft() {
        return this.itemDrawLeft;
    }

    public final boolean getItemDrawRight() {
        return this.itemDrawRight;
    }

    public final boolean getItemDrawTop() {
        return this.itemDrawTop;
    }

    @OXOo.oOoXoXO
    public final DslAdapter getItemDslAdapter() {
        return this.itemDslAdapter;
    }

    public final boolean getItemEnable() {
        return this.itemEnable;
    }

    @OXOo.oOoXoXO
    public final Integer getItemFirstPaddingTop() {
        return this.itemFirstPaddingTop;
    }

    public final int getItemFlag() {
        return this.itemFlag;
    }

    public final boolean getItemGroupExtend() {
        return ((Boolean) this.itemGroupExtend$delegate.oIX0oI(this, $$delegatedProperties[0])).booleanValue();
    }

    @OXOo.OOXIXo
    public final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> getItemGroupExtendChangeListenerList() {
        return this.itemGroupExtendChangeListenerList;
    }

    @OXOo.OOXIXo
    public final ooXIXxIX getItemGroupParams() {
        ooXIXxIX ooxixxix;
        ooXIXxIX ooxixxix2 = this._itemGroupParamsCache;
        if (ooxixxix2 == null) {
            DslAdapter dslAdapter = this.itemDslAdapter;
            if (dslAdapter != null && (ooxixxix = findItemGroupParams$default(this, dslAdapter, false, null, 6, null)) != null) {
                this._itemGroupParamsCache = ooxixxix;
            } else {
                ooxixxix = null;
            }
            if (ooxixxix == null) {
                ooXIXxIX oIX0oI2 = IIX0o.oIX0oI(this);
                L.f5267oIX0oI.oo0xXOI0I("注意获取[itemGroupParams]时[itemDslAdapter]为null");
                return oIX0oI2;
            }
            return ooxixxix;
        }
        return ooxixxix2;
    }

    @OXOo.OOXIXo
    public final List<String> getItemGroups() {
        return this.itemGroups;
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final boolean getItemHidden() {
        return ((Boolean) this.itemHidden$delegate.oIX0oI(this, $$delegatedProperties[1])).booleanValue();
    }

    public final boolean getItemIsGroupHead() {
        return this.itemIsGroupHead;
    }

    public final boolean getItemIsHover() {
        return this.itemIsHover;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, Boolean> getItemIsSelectMutexAction() {
        return this.itemIsSelectMutexAction;
    }

    public final boolean getItemIsSelected() {
        return this.itemIsSelected;
    }

    @OXOo.oOoXoXO
    public final Integer getItemLastPaddingBottom() {
        return this.itemLastPaddingBottom;
    }

    public int getItemLayoutId() {
        return this.itemLayoutId;
    }

    public final int getItemLeftInsert() {
        return this.itemLeftInsert;
    }

    public final int getItemLeftOffset() {
        return this.itemLeftOffset;
    }

    @OXOo.OOXIXo
    public final Oox.oIX0oI<oXIO0o0XI> getItemLoadSubList() {
        return this.itemLoadSubList;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<View, Boolean> getItemLongClick() {
        return this.itemLongClick;
    }

    public final int getItemMinHeight() {
        return this.itemMinHeight;
    }

    public final int getItemMinWidth() {
        return this.itemMinWidth;
    }

    public final int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    public final int getItemPaddingLeft() {
        return this.itemPaddingLeft;
    }

    public final int getItemPaddingRight() {
        return this.itemPaddingRight;
    }

    public final int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getItemParentList() {
        return this.itemParentList;
    }

    @OXOo.oOoXoXO
    public final WeakReference<DslAdapterItem> getItemParentRef() {
        return this.itemParentRef;
    }

    public final boolean getItemRemoveFlag() {
        return this.itemRemoveFlag;
    }

    public final int getItemRightInsert() {
        return this.itemRightInsert;
    }

    public final int getItemRightOffset() {
        return this.itemRightOffset;
    }

    @OXOo.OOXIXo
    public final Set<Oox.oOoXoXO<IO, oXIO0o0XI>> getItemSelectListener() {
        return this.itemSelectListener;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem getItemSelectMutexFromItem() {
        return this.itemSelectMutexFromItem;
    }

    @OXOo.oOoXoXO
    public final Boolean getItemShowLastLineView() {
        return this.itemShowLastLineView;
    }

    public final boolean getItemSingleSelectMutex() {
        return this.itemSingleSelectMutex;
    }

    public final int getItemSpanCount() {
        return this.itemSpanCount;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getItemSubList() {
        return this.itemSubList;
    }

    public final boolean getItemSwipeEnable() {
        return this.itemSwipeEnable;
    }

    public final int getItemSwipeFlag() {
        return this.itemSwipeFlag;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslViewHolder, Integer> getItemSwipeHeight() {
        return this.itemSwipeHeight;
    }

    public final boolean getItemSwipeMenuEnable() {
        return this.itemSwipeMenuEnable;
    }

    public final int getItemSwipeMenuFlag() {
        return this.itemSwipeMenuFlag;
    }

    @OXOo.OOXIXo
    public final Oox.IXxxXO<DslViewHolder, Float, Float, oXIO0o0XI> getItemSwipeMenuTo() {
        return this.itemSwipeMenuTo;
    }

    public final int getItemSwipeMenuType() {
        return this.itemSwipeMenuType;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslViewHolder, Integer> getItemSwipeWidth() {
        return this.itemSwipeWidth;
    }

    @OXOo.oOoXoXO
    public final String getItemTag() {
        return this.itemTag;
    }

    @OXOo.oOoXoXO
    public final SparseArray<Object> getItemTags() {
        return this.itemTags;
    }

    @OXOo.oOoXoXO
    public final Throwable getItemThrowable() {
        return this.itemThrowable;
    }

    public final int getItemTopInsert() {
        return this.itemTopInsert;
    }

    public final int getItemTopOffset() {
        return this.itemTopOffset;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Object, oXIO0o0XI> getItemUpdateAction() {
        return this.itemUpdateAction;
    }

    public final boolean getItemUpdateFlag() {
        return this.itemUpdateFlag;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, Boolean> getItemUpdateFrom() {
        return this.itemUpdateFrom;
    }

    @OXOo.OOXIXo
    public final Set<Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>> getItemUpdateFromListenerList() {
        return this.itemUpdateFromListenerList;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI> getItemViewAttachedToWindow() {
        return this.itemViewAttachedToWindow;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI> getItemViewDetachedToWindow() {
        return this.itemViewDetachedToWindow;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslViewHolder, Integer, oXIO0o0XI> getItemViewRecycled() {
        return this.itemViewRecycled;
    }

    @OXOo.oOoXoXO
    public Integer getItemViewType() {
        return this.itemViewType;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @OXOo.OOXIXo
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @OXOo.OOXIXo
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    public final boolean getNoDrawLastItemDecoration() {
        return this.noDrawLastItemDecoration;
    }

    @OXOo.oOoXoXO
    public final Oox.IIXOooo<Canvas, Paint, View, Rect, Integer, Integer, Rect, oXIO0o0XI> getOnDraw() {
        return this.onDraw;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<Canvas, Rect, oXIO0o0XI> getOnDrawItemDecorationDrawable() {
        return this.onDrawItemDecorationDrawable;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<IO, oXIO0o0XI> getOnItemSelectorChange() {
        return this.onItemSelectorChange;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Rect, oXIO0o0XI> getOnSetItemOffset() {
        return this.onSetItemOffset;
    }

    public final boolean getOnlyDrawOffsetArea() {
        return this.onlyDrawOffsetArea;
    }

    @OXOo.OOXIXo
    public final Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean> getThisAreContentsTheSame() {
        return this.thisAreContentsTheSame;
    }

    @OXOo.OOXIXo
    public final Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean> getThisAreItemsTheSame() {
        return this.thisAreItemsTheSame;
    }

    @OXOo.OOXIXo
    public final Oox.oI0IIXIo<DslAdapterItem, Object, DslAdapterItem, Integer, Integer, Object> getThisGetChangePayload() {
        return this.thisGetChangePayload;
    }

    @OXOo.oOoXoXO
    public final View.OnClickListener get_clickListener() {
        return this._clickListener;
    }

    public final long get_itemAnimateDelay() {
        return this._itemAnimateDelay;
    }

    @OXOo.oOoXoXO
    public final ooXIXxIX get_itemGroupParamsCache() {
        return this._itemGroupParamsCache;
    }

    @OXOo.oOoXoXO
    public final SwipeMenuHelper get_itemSwipeMenuHelper() {
        return this._itemSwipeMenuHelper;
    }

    @OXOo.oOoXoXO
    public final View.OnLongClickListener get_longClickListener() {
        return this._longClickListener;
    }

    public boolean isFirstPositionInGroup(boolean z) {
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter == null) {
            return false;
        }
        if (this.itemGroups.isEmpty()) {
            if (dslAdapter.getDataList(z).indexOf(this) != 0) {
                return false;
            }
            return true;
        }
        return IIX0o.Oxx0xo(getItemGroupParams());
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, Boolean> isItemCanDropOver() {
        return this.isItemCanDropOver;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<Boolean, Boolean, Boolean> isItemCanSelected() {
        return this.isItemCanSelected;
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, Boolean> isItemInGroups() {
        return this.isItemInGroups;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslAdapterItem, Integer, Boolean> isItemInHiddenList() {
        return this.isItemInHiddenList;
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<DslAdapterItem, Integer, Boolean> isItemInUpdateList() {
        return this.isItemInUpdateList;
    }

    public boolean isLastPositionInGroup(boolean z) {
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter == null) {
            return false;
        }
        if (this.itemGroups.isEmpty()) {
            List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
            if (dataList.size() - 1 != dataList.indexOf(this)) {
                return false;
            }
            return true;
        }
        return IIX0o.X0IIOO(getItemGroupParams());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> observeItemChange(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemChangeListenerList.add(action);
        return action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> observeItemGroupExtendChange(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemGroupExtendChangeListenerList.add(action);
        return action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<IO, oXIO0o0XI> observeItemSelect(@OXOo.OOXIXo Oox.oOoXoXO<? super IO, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemSelectListener.add(action);
        return action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> observeItemUpdateFrom(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemUpdateFromListenerList.add(action);
        return action;
    }

    @kotlin.OOXIXo(message = "请使用4个参数的方法[onItemBind]")
    public void onItemBind(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
    }

    public void onItemBindAfter(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        _initItemAnimate(itemHolder);
    }

    public void onItemChangeListener(@OXOo.OOXIXo DslAdapterItem item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        updateItemOnHaveDepend$default(this, false, null, 3, null);
    }

    public void onItemSwipeMenuTo(@OXOo.OOXIXo DslViewHolder itemHolder, final float f, float f2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        final View view = itemHolder.itemView;
        kotlin.jvm.internal.IIX0o.oO(view, "itemHolder.itemView");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 1) {
                final int intValue = this.itemSwipeWidth.invoke(itemHolder).intValue();
                float f3 = intValue;
                final float clamp = MathUtils.clamp(f, -f3, f3);
                LibExKt.ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$onItemSwipeMenuTo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // Oox.x0xO0oo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view2) {
                        invoke(num.intValue(), view2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(int i, @OXOo.OOXIXo View child) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                        if (i == 0) {
                            if (DslAdapterItem.this.getItemSwipeMenuType() == 2) {
                                if (f > 0.0f) {
                                    child.setTranslationX((-intValue) + clamp);
                                    return;
                                } else {
                                    child.setTranslationX(LibExKt.x0xO(view, 0, 1, null) + clamp);
                                    return;
                                }
                            }
                            if (f > 0.0f) {
                                child.setTranslationX(0.0f);
                                return;
                            } else {
                                child.setTranslationX(LibExKt.x0xO(view, 0, 1, null) - intValue);
                                return;
                            }
                        }
                        child.setTranslationX(clamp);
                    }
                }, 1, null);
            }
        }
    }

    public boolean onItemUpdateFrom(@OXOo.OOXIXo DslAdapterItem fromItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fromItem, "fromItem");
        return true;
    }

    @CallSuper
    public void onItemViewAttachedToWindow(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    @CallSuper
    public void onItemViewDetachedToWindow(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    @CallSuper
    public void onItemViewRecycled(@OXOo.OOXIXo DslViewHolder itemHolder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        if (this.lifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        }
        if (this.itemAnimateRes != 0) {
            View view = itemHolder.itemView;
            kotlin.jvm.internal.IIX0o.oO(view, "itemHolder.itemView");
            LibExKt.oO(view);
            itemHolder.itemView.clearAnimation();
        }
        itemHolder.clear();
    }

    public void onSelfItemGroupExtendChanged(boolean z, boolean z2) {
        Iterator<T> it = this.itemGroupExtendChangeListenerList.iterator();
        while (it.hasNext()) {
            ((Oox.oOoXoXO) it.next()).invoke(this);
        }
    }

    public void onSelfSetItemData(@OXOo.oOoXoXO Object obj) {
    }

    public void onSetItemEnable(boolean z) {
        DslViewHolder Xx000oIo2 = DslAdapterItemExKt.Xx000oIo(this, null, 1, null);
        if (Xx000oIo2 != null) {
            Xx000oIo2.enable(Xx000oIo2.itemView, Boolean.valueOf(z), true);
            _initItemListener(Xx000oIo2);
        }
    }

    public void onSetItemSelected(boolean z) {
        DslAdapter dslAdapter;
        if (z && this.itemSingleSelectMutex && (dslAdapter = this.itemDslAdapter) != null) {
            DslAdapterExKt.oI0IIXIo(dslAdapter, false, new Oox.x0xO0oo<Integer, DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$onSetItemSelected$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, DslAdapterItem dslAdapterItem) {
                    invoke(num.intValue(), dslAdapterItem);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, DslAdapterItem.this) && DslAdapterItem.this.getItemIsSelectMutexAction().invoke(dslAdapterItem).booleanValue() && dslAdapterItem.getItemIsSelected()) {
                        dslAdapterItem.setItemSelectMutexFromItem(this);
                        dslAdapterItem.setItemIsSelected(false);
                        DslAdapterItem.updateAdapterItem$default(dslAdapterItem, null, false, 3, null);
                        dslAdapterItem.setItemSelectMutexFromItem(null);
                    }
                }
            }, 1, null);
        }
    }

    public void removeAdapterItem() {
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null) {
            DslAdapter.removeItemFromAll$default(dslAdapter, this, false, 2, null);
        } else {
            dslAdapter = null;
        }
        LibExKt.XIxXXX0x0(dslAdapter, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$removeAdapterItem$2
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateAdapterItem需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public void removeAdapterItemJust() {
        oXIO0o0XI oxio0o0xi;
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null) {
            DslAdapter.render$default(dslAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$removeAdapterItemJust$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                    invoke2(dslAdapter2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(render, "$this$render");
                    DslAdapterItem.this.removeAdapterItem();
                }
            }, 3, null);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        LibExKt.XIxXXX0x0(oxio0o0xi, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$removeAdapterItemJust$2
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateAdapterItem需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public final boolean removeItemChangeObserver(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        return this.itemChangeListenerList.remove(action);
    }

    public final boolean removeItemGroupExtendChangeObserver(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        return this.itemGroupExtendChangeListenerList.remove(action);
    }

    public final boolean removeItemSelectObserver(@OXOo.OOXIXo Oox.oOoXoXO<? super IO, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        return this.itemSelectListener.remove(action);
    }

    public final boolean removeItemUpdateFromObserver(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        return this.itemUpdateFromListenerList.remove(action);
    }

    public final void setEachDrawItemDecoration(@OXOo.OOXIXo Oox.Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
        this.eachDrawItemDecoration = oxx0xo;
    }

    public final void setItemAnimateRes(int i) {
        this.itemAnimateRes = i;
    }

    public final void setItemAutoHideLastLineView(boolean z) {
        this.itemAutoHideLastLineView = z;
    }

    public final void setItemAutoPaddingFirstOrLast(boolean z) {
        this.itemAutoPaddingFirstOrLast = z;
    }

    public final void setItemBackgroundDrawable(@OXOo.oOoXoXO Drawable drawable) {
        this.itemBackgroundDrawable = drawable;
    }

    public final void setItemBind(@OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
        this.itemBind = oxx0xo;
    }

    public final void setItemBindOverride(@OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
        this.itemBindOverride = oxx0xo;
    }

    public final void setItemBottomInsert(int i) {
        this.itemBottomInsert = i;
    }

    public final void setItemBottomOffset(int i) {
        this.itemBottomOffset = i;
    }

    public final void setItemCanDropOver(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.isItemCanDropOver = oooxoxo;
    }

    public final void setItemCanSelected(@OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.isItemCanSelected = x0xo0oo;
    }

    public final void setItemChangeListener(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemChangeListener = oooxoxo;
    }

    public final void setItemChanged(boolean z) {
        this.itemChanged = z;
        if (z) {
            this.itemChangeListener.invoke(this);
            Iterator<T> it = this.itemChangeListenerList.iterator();
            while (it.hasNext()) {
                ((Oox.oOoXoXO) it.next()).invoke(this);
            }
        }
    }

    public final void setItemChanging(boolean z) {
        this.itemChanging = z;
        if (z) {
            setItemChanged(true);
        }
    }

    public final void setItemClick(@OXOo.oOoXoXO Oox.oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        this.itemClick = oooxoxo;
    }

    public final void setItemClickThrottleInterval(long j) {
        this.itemClickThrottleInterval = j;
    }

    public final void setItemData(@OXOo.oOoXoXO Object obj) {
        this.itemData = obj;
        onSelfSetItemData(obj);
    }

    public final void setItemDecorationColor(int i) {
        this.itemDecorationColor = i;
    }

    public final void setItemDecorationDrawable(@OXOo.oOoXoXO Drawable drawable) {
        this.itemDecorationDrawable = drawable;
    }

    public final void setItemDragEnable(boolean z) {
        this.itemDragEnable = z;
    }

    public final void setItemDragFlag(int i) {
        this.itemDragFlag = i;
    }

    public final void setItemDrawBottom(boolean z) {
        this.itemDrawBottom = z;
    }

    public final void setItemDrawLeft(boolean z) {
        this.itemDrawLeft = z;
    }

    public final void setItemDrawRight(boolean z) {
        this.itemDrawRight = z;
    }

    public final void setItemDrawTop(boolean z) {
        this.itemDrawTop = z;
    }

    public final void setItemDslAdapter(@OXOo.oOoXoXO DslAdapter dslAdapter) {
        this.itemDslAdapter = dslAdapter;
    }

    public final void setItemEnable(boolean z) {
        this.itemEnable = z;
        onSetItemEnable(z);
    }

    public final void setItemFirstPaddingTop(@OXOo.oOoXoXO Integer num) {
        this.itemFirstPaddingTop = num;
    }

    public final void setItemFlag(int i) {
        this.itemFlag = i;
    }

    public final void setItemGroupExtend(boolean z) {
        this.itemGroupExtend$delegate.II0xO0(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final void setItemGroups(@OXOo.OOXIXo List<String> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.itemGroups = list;
    }

    public final void setItemHeight(int i) {
        this.itemHeight = i;
    }

    public final void setItemHidden(boolean z) {
        this.itemHidden$delegate.II0xO0(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    public final void setItemInGroups(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.isItemInGroups = oooxoxo;
    }

    public final void setItemInHiddenList(@OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.isItemInHiddenList = x0xo0oo;
    }

    public final void setItemInUpdateList(@OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.isItemInUpdateList = x0xo0oo;
    }

    public final void setItemIsGroupHead(boolean z) {
        this.itemIsGroupHead = z;
        if (z) {
            this.itemIsHover = true;
            this.itemDragEnable = false;
            this.itemSpanCount = -1;
        }
    }

    public final void setItemIsHover(boolean z) {
        this.itemIsHover = z;
    }

    public final void setItemIsSelectMutexAction(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemIsSelectMutexAction = oooxoxo;
    }

    public final void setItemIsSelected(boolean z) {
        boolean z2 = this.itemIsSelected;
        this.itemIsSelected = z;
        if (z2 != z) {
            this.itemSelectMutexFromItem = this;
            onSetItemSelected(z);
            this.itemSelectMutexFromItem = null;
        }
    }

    public final void setItemLastPaddingBottom(@OXOo.oOoXoXO Integer num) {
        this.itemLastPaddingBottom = num;
    }

    public void setItemLayoutId(int i) {
        this.itemLayoutId = i;
    }

    public final void setItemLeftInsert(int i) {
        this.itemLeftInsert = i;
    }

    public final void setItemLeftOffset(int i) {
        this.itemLeftOffset = i;
    }

    public final void setItemLoadSubList(@OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "<set-?>");
        this.itemLoadSubList = oix0oi;
    }

    public final void setItemLongClick(@OXOo.oOoXoXO Oox.oOoXoXO<? super View, Boolean> oooxoxo) {
        this.itemLongClick = oooxoxo;
    }

    public final void setItemMinHeight(int i) {
        this.itemMinHeight = i;
    }

    public final void setItemMinWidth(int i) {
        this.itemMinWidth = i;
    }

    public final void setItemOffsets(@OXOo.OOXIXo Rect outRect) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(outRect, "outRect");
        outRect.set(this.itemLeftInsert, this.itemTopInsert, this.itemRightInsert, this.itemBottomInsert);
        Oox.oOoXoXO<? super Rect, oXIO0o0XI> oooxoxo = this.onSetItemOffset;
        if (oooxoxo != null) {
            oooxoxo.invoke(outRect);
        }
    }

    public final void setItemPaddingBottom(int i) {
        this.itemPaddingBottom = i;
    }

    public final void setItemPaddingLeft(int i) {
        this.itemPaddingLeft = i;
    }

    public final void setItemPaddingRight(int i) {
        this.itemPaddingRight = i;
    }

    public final void setItemPaddingTop(int i) {
        this.itemPaddingTop = i;
    }

    public final void setItemParentList(@OXOo.OOXIXo List<DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.itemParentList = list;
    }

    public final void setItemParentRef(@OXOo.oOoXoXO WeakReference<DslAdapterItem> weakReference) {
        this.itemParentRef = weakReference;
    }

    public final void setItemRemoveFlag(boolean z) {
        this.itemRemoveFlag = z;
    }

    public final void setItemRightInsert(int i) {
        this.itemRightInsert = i;
    }

    public final void setItemRightOffset(int i) {
        this.itemRightOffset = i;
    }

    public final void setItemSelectMutexFromItem(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        this.itemSelectMutexFromItem = dslAdapterItem;
    }

    public final void setItemShowLastLineView(@OXOo.oOoXoXO Boolean bool) {
        this.itemShowLastLineView = bool;
    }

    public final void setItemSingleSelectMutex(boolean z) {
        this.itemSingleSelectMutex = z;
    }

    public final void setItemSpanCount(int i) {
        this.itemSpanCount = i;
    }

    public final void setItemSubList(@OXOo.OOXIXo List<DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.itemSubList = list;
    }

    public final void setItemSwipeEnable(boolean z) {
        this.itemSwipeEnable = z;
    }

    public final void setItemSwipeFlag(int i) {
        this.itemSwipeFlag = i;
    }

    public final void setItemSwipeHeight(@OXOo.OOXIXo Oox.oOoXoXO<? super DslViewHolder, Integer> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemSwipeHeight = oooxoxo;
    }

    public final void setItemSwipeMenuEnable(boolean z) {
        this.itemSwipeMenuEnable = z;
    }

    public final void setItemSwipeMenuFlag(int i) {
        this.itemSwipeMenuFlag = i;
    }

    public final void setItemSwipeMenuTo(@OXOo.OOXIXo Oox.IXxxXO<? super DslViewHolder, ? super Float, ? super Float, oXIO0o0XI> iXxxXO) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iXxxXO, "<set-?>");
        this.itemSwipeMenuTo = iXxxXO;
    }

    public final void setItemSwipeMenuType(int i) {
        this.itemSwipeMenuType = i;
    }

    public final void setItemSwipeWidth(@OXOo.OOXIXo Oox.oOoXoXO<? super DslViewHolder, Integer> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemSwipeWidth = oooxoxo;
    }

    public final void setItemTag(@OXOo.oOoXoXO String str) {
        this.itemTag = str;
    }

    public final void setItemTags(@OXOo.oOoXoXO SparseArray<Object> sparseArray) {
        this.itemTags = sparseArray;
    }

    public final void setItemThrowable(@OXOo.oOoXoXO Throwable th) {
        this.itemThrowable = th;
    }

    public final void setItemTopInsert(int i) {
        this.itemTopInsert = i;
    }

    public final void setItemTopOffset(int i) {
        this.itemTopOffset = i;
    }

    public final void setItemUpdateAction(@OXOo.OOXIXo Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemUpdateAction = oooxoxo;
    }

    public final void setItemUpdateFlag(boolean z) {
        this.itemUpdateFlag = z;
    }

    public final void setItemUpdateFrom(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.itemUpdateFrom = oooxoxo;
    }

    public final void setItemViewAttachedToWindow(@OXOo.OOXIXo Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.itemViewAttachedToWindow = x0xo0oo;
    }

    public final void setItemViewDetachedToWindow(@OXOo.OOXIXo Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.itemViewDetachedToWindow = x0xo0oo;
    }

    public final void setItemViewRecycled(@OXOo.OOXIXo Oox.x0xO0oo<? super DslViewHolder, ? super Integer, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.itemViewRecycled = x0xo0oo;
    }

    public void setItemViewType(@OXOo.oOoXoXO Integer num) {
        this.itemViewType = num;
    }

    public final void setItemWidth(int i) {
        this.itemWidth = i;
    }

    public final void setNoDrawLastItemDecoration(boolean z) {
        this.noDrawLastItemDecoration = z;
    }

    public final void setOnDraw(@OXOo.oOoXoXO Oox.IIXOooo<? super Canvas, ? super Paint, ? super View, ? super Rect, ? super Integer, ? super Integer, ? super Rect, oXIO0o0XI> iIXOooo) {
        this.onDraw = iIXOooo;
    }

    public final void setOnDrawItemDecorationDrawable(@OXOo.OOXIXo Oox.x0xO0oo<? super Canvas, ? super Rect, oXIO0o0XI> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.onDrawItemDecorationDrawable = x0xo0oo;
    }

    public final void setOnItemSelectorChange(@OXOo.OOXIXo Oox.oOoXoXO<? super IO, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.onItemSelectorChange = oooxoxo;
    }

    public final void setOnSetItemOffset(@OXOo.oOoXoXO Oox.oOoXoXO<? super Rect, oXIO0o0XI> oooxoxo) {
        this.onSetItemOffset = oooxoxo;
    }

    public final void setOnlyDrawOffsetArea(boolean z) {
        this.onlyDrawOffsetArea = z;
    }

    public final void setThisAreContentsTheSame(@OXOo.OOXIXo Oox.Oxx0xo<? super DslAdapterItem, ? super DslAdapterItem, ? super Integer, ? super Integer, Boolean> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
        this.thisAreContentsTheSame = oxx0xo;
    }

    public final void setThisAreItemsTheSame(@OXOo.OOXIXo Oox.Oxx0xo<? super DslAdapterItem, ? super DslAdapterItem, ? super Integer, ? super Integer, Boolean> oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<set-?>");
        this.thisAreItemsTheSame = oxx0xo;
    }

    public final void setThisGetChangePayload(@OXOo.OOXIXo Oox.oI0IIXIo<? super DslAdapterItem, Object, ? super DslAdapterItem, ? super Integer, ? super Integer, ? extends Object> oi0iixio) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oi0iixio, "<set-?>");
        this.thisGetChangePayload = oi0iixio;
    }

    public final void set_clickListener(@OXOo.oOoXoXO View.OnClickListener onClickListener) {
        this._clickListener = onClickListener;
    }

    public final void set_itemAnimateDelay(long j) {
        this._itemAnimateDelay = j;
    }

    public final void set_itemGroupParamsCache(@OXOo.oOoXoXO ooXIXxIX ooxixxix) {
        this._itemGroupParamsCache = ooxixxix;
    }

    public final void set_itemSwipeMenuHelper(@OXOo.oOoXoXO SwipeMenuHelper swipeMenuHelper) {
        this._itemSwipeMenuHelper = swipeMenuHelper;
    }

    public final void set_longClickListener(@OXOo.oOoXoXO View.OnLongClickListener onLongClickListener) {
        this._longClickListener = onLongClickListener;
    }

    @AnyThread
    public void updateAdapterItem(@OXOo.oOoXoXO final Object obj, final boolean z) {
        oXIO0o0XI oxio0o0xi;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.itemUpdateAction.invoke(obj);
        DslAdapter dslAdapter = this.itemDslAdapter;
        if ((dslAdapter != null && (recyclerView2 = dslAdapter.get_recyclerView()) != null && recyclerView2.isComputingLayout()) || !LibExKt.I0oOIX()) {
            DslAdapter dslAdapter2 = this.itemDslAdapter;
            if (dslAdapter2 != null && (recyclerView = dslAdapter2.get_recyclerView()) != null) {
                recyclerView.post(new Runnable() { // from class: com.angcyo.dsladapter.oxoX
                    @Override // java.lang.Runnable
                    public final void run() {
                        DslAdapterItem.updateAdapterItem$lambda$0(DslAdapterItem.this, obj, z);
                    }
                });
                return;
            }
            return;
        }
        DslAdapter dslAdapter3 = this.itemDslAdapter;
        if (dslAdapter3 != null) {
            dslAdapter3.notifyItemChanged(this, obj, z);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        LibExKt.XIxXXX0x0(oxio0o0xi, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$updateAdapterItem$2
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateAdapterItem需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public void updateItemDepend(@OXOo.OOXIXo XxX0x0xxx filterParams) {
        oXIO0o0XI oxio0o0xi;
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        this.itemUpdateAction.invoke(filterParams.OxxIIOOXO());
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null) {
            dslAdapter.updateItemDepend(filterParams);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        LibExKt.XIxXXX0x0(oxio0o0xi, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$updateItemDepend$1
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateItemDepend需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public void updateItemDependPayload(@OXOo.oOoXoXO Object obj) {
        this.itemUpdateAction.invoke(obj);
        updateItemDepend(new XxX0x0xxx(this, false, false, false, false, false, obj, null, 0L, 0L, null, 1950, null));
    }

    public void updateItemOnHaveDepend(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams) {
        List<DslAdapterItem> updateDependItemListFrom;
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        ArrayList arrayList = new ArrayList();
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null && (updateDependItemListFrom = dslAdapter.getUpdateDependItemListFrom(this)) != null) {
            arrayList.addAll(updateDependItemListFrom);
        }
        if (!arrayList.isEmpty()) {
            updateItemDepend(filterParams);
        } else if (z) {
            updateAdapterItem$default(this, filterParams.OxxIIOOXO(), false, 2, null);
        }
    }

    public void updateItemSelect(boolean z, @OXOo.OOXIXo IO selectorParams) {
        oXIO0o0XI oxio0o0xi;
        ItemSelectorHelper itemSelectorHelper;
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null && (itemSelectorHelper = dslAdapter.getItemSelectorHelper()) != null) {
            itemSelectorHelper.X0IIOO(selectorParams);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        LibExKt.XIxXXX0x0(oxio0o0xi, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$updateItemSelect$1
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateItemSelector需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public void updateItemSelector(boolean z, boolean z2) {
        oXIO0o0XI oxio0o0xi;
        ItemSelectorHelper itemSelectorHelper;
        DslAdapter dslAdapter = this.itemDslAdapter;
        if (dslAdapter != null && (itemSelectorHelper = dslAdapter.getItemSelectorHelper()) != null) {
            itemSelectorHelper.X0IIOO(new IO(this, ItemSelectorHelperKt.xoXoI(z), true, true, z2, null, false, false, false, null, 992, null));
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        LibExKt.XIxXXX0x0(oxio0o0xi, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItem$updateItemSelector$1
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("跳过操作! updateItemSelector需要[itemDslAdapter],请赋值.");
            }
        });
    }

    public void onItemBind(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        _initItemEnable(itemHolder);
        _initItemBackground(itemHolder);
        _initItemSize(itemHolder);
        _initItemPadding(itemHolder);
        _initItemListener(itemHolder);
        _initItemConfig(itemHolder, i, adapterItem, payloads);
        _initItemStyle(itemHolder);
        onItemBind(itemHolder, i, adapterItem);
    }
}
