package com.angcyo.dsladapter;

import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nRecyclerEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclerEx.kt\ncom/angcyo/dsladapter/RecyclerExKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,257:1\n1#2:258\n1855#3,2:259\n1855#3,2:261\n*S KotlinDebug\n*F\n+ 1 RecyclerEx.kt\ncom/angcyo/dsladapter/RecyclerExKt\n*L\n228#1:259,2\n247#1:261,2\n*E\n"})
/* loaded from: classes7.dex */
public final class RecyclerExKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.angcyo.dsladapter.DslAdapter, java.lang.Object] */
    @OXOo.OOXIXo
    public static final DslAdapter I0Io(@OXOo.OOXIXo RecyclerView recyclerView, boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (z2) {
            X0o0xo(objectRef, recyclerView, init);
        } else if (recyclerView.getAdapter() instanceof DslAdapter) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.angcyo.dsladapter.DslAdapter");
            ?? r1 = (DslAdapter) adapter;
            objectRef.element = r1;
            if (!z) {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1);
                r1.clearItems();
            }
            Object obj = objectRef.element;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(obj);
            init.invoke(obj);
        } else {
            X0o0xo(objectRef, recyclerView, init);
        }
        T t = objectRef.element;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(t);
        return (DslAdapter) t;
    }

    public static final void II0XooXoX(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        int itemDecorationCount = recyclerView.getItemDecorationCount();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < itemDecorationCount; i++) {
            RecyclerView.ItemDecoration itemDecorationAt = recyclerView.getItemDecorationAt(i);
            kotlin.jvm.internal.IIX0o.oO(itemDecorationAt, "getItemDecorationAt(i)");
            if (itemDecorationAt instanceof DslItemDecoration) {
                z = true;
            } else if (itemDecorationAt instanceof HoverItemDecoration) {
                z2 = true;
            }
        }
        if (!z) {
            new DslItemDecoration(null, null, null, null, 15, null).attachToRecyclerView(recyclerView);
        }
        if (!z2) {
            HoverItemDecoration.attachToRecyclerView$default(new HoverItemDecoration(), recyclerView, null, 2, null);
        }
    }

    public static final void II0xO0(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        int itemDecorationCount = recyclerView.getItemDecorationCount();
        while (true) {
            itemDecorationCount--;
            if (-1 < itemDecorationCount) {
                recyclerView.removeItemDecorationAt(itemDecorationCount);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void IXxxXO(@OXOo.OOXIXo androidx.recyclerview.widget.RecyclerView r8, @OXOo.OOXIXo java.lang.String r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "match"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L95
            java.lang.String r0 = "V"
            boolean r0 = kotlin.text.OxI.oX0I0O(r0, r9, r2)
            if (r0 == 0) goto L1c
            goto L95
        L1c:
            java.lang.String r0 = "H"
            boolean r3 = kotlin.text.OxI.oX0I0O(r0, r9, r2)
            if (r3 == 0) goto L2f
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r0 = r8.getContext()
            r9.<init>(r0, r1, r1)
            goto L9e
        L2f:
            java.lang.String r3 = r9.substring(r1, r2)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.IIX0o.oO(r3, r4)
            int r5 = r9.length()
            r6 = 3
            r7 = 2
            if (r5 < r6) goto L5b
            java.lang.String r5 = r9.substring(r7)     // Catch: java.lang.Exception -> L5a
            java.lang.String r6 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.IIX0o.oO(r5, r6)     // Catch: java.lang.Exception -> L5a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L5a
            java.lang.String r6 = "valueOf(match.substring(2))"
            kotlin.jvm.internal.IIX0o.oO(r5, r6)     // Catch: java.lang.Exception -> L5a
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L5a
            goto L5c
        L5a:
        L5b:
            r5 = 1
        L5c:
            int r6 = r9.length()
            if (r6 < r7) goto L71
            java.lang.String r9 = r9.substring(r2, r7)
            kotlin.jvm.internal.IIX0o.oO(r9, r4)
            boolean r9 = kotlin.text.OxI.oX0I0O(r0, r9, r2)
            if (r9 == 0) goto L71
            r9 = 0
            goto L72
        L71:
            r9 = 1
        L72:
            java.lang.String r0 = "S"
            boolean r0 = kotlin.text.OxI.oX0I0O(r0, r3, r2)
            if (r0 == 0) goto L81
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = new androidx.recyclerview.widget.StaggeredGridLayoutManager
            r0.<init>(r5, r9)
        L7f:
            r9 = r0
            goto L9e
        L81:
            java.lang.String r0 = "G"
            boolean r0 = kotlin.text.OxI.oX0I0O(r0, r3, r2)
            if (r0 == 0) goto L93
            androidx.recyclerview.widget.GridLayoutManager r0 = new androidx.recyclerview.widget.GridLayoutManager
            android.content.Context r3 = r8.getContext()
            r0.<init>(r3, r5, r9, r1)
            goto L7f
        L93:
            r9 = 0
            goto L9e
        L95:
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r0 = r8.getContext()
            r9.<init>(r0, r2, r1)
        L9e:
            boolean r0 = r9 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r0 == 0) goto La9
            r0 = r9
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            com.angcyo.dsladapter.LibExKt.oI0IIXIo(r0, r8)
            goto Lb3
        La9:
            boolean r0 = r9 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto Lb3
            r0 = r9
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            r0.setRecycleChildrenOnDetach(r2)
        Lb3:
            r8.setLayoutManager(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.dsladapter.RecyclerExKt.IXxxXO(androidx.recyclerview.widget.RecyclerView, java.lang.String):void");
    }

    public static final void OOXIXo(@OXOo.OOXIXo RecyclerView recyclerView, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        if (!(recyclerView.getAdapter() instanceof DslAdapter)) {
            return;
        }
        for (DslViewHolder dslViewHolder : oIX0oI(recyclerView)) {
            int adapterPosition = dslViewHolder.getAdapterPosition();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.angcyo.dsladapter.DslAdapter");
            DslAdapterItem itemData$default = DslAdapter.getItemData$default((DslAdapter) adapter, adapterPosition, false, 2, null);
            if (itemData$default != null) {
                if (i >= 0) {
                    if (i == adapterPosition) {
                        itemData$default.getItemBind().invoke(dslViewHolder, Integer.valueOf(adapterPosition), itemData$default, payloads);
                    }
                } else {
                    itemData$default.getItemBind().invoke(dslViewHolder, Integer.valueOf(adapterPosition), itemData$default, payloads);
                }
            }
        }
    }

    public static /* synthetic */ void Oo(RecyclerView recyclerView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        x0xO0oo(recyclerView, z);
    }

    public static /* synthetic */ DslViewHolder Oxx0IOOO(RecyclerView recyclerView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return XO(recyclerView, i, z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.angcyo.dsladapter.DslAdapter] */
    public static final void X0o0xo(Ref.ObjectRef<DslAdapter> objectRef, RecyclerView recyclerView, Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> oooxoxo) {
        ?? dslAdapter = new DslAdapter(null, 1, null);
        objectRef.element = dslAdapter;
        recyclerView.setAdapter((RecyclerView.Adapter) dslAdapter);
        DslAdapter dslAdapter2 = objectRef.element;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(dslAdapter2);
        oooxoxo.invoke(dslAdapter2);
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder XO(@OXOo.OOXIXo RecyclerView recyclerView, int i, boolean z) {
        RecyclerView.Adapter adapter;
        DslViewHolder dslViewHolder;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        DslViewHolder dslViewHolder2 = null;
        if (z) {
            if (i < 0) {
                i += recyclerView.getChildCount();
            }
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(i);
            if (findViewHolderForLayoutPosition instanceof DslViewHolder) {
                dslViewHolder = (DslViewHolder) findViewHolderForLayoutPosition;
            } else {
                dslViewHolder = null;
            }
            if (dslViewHolder == null) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                    if (childViewHolder instanceof DslViewHolder) {
                        dslViewHolder2 = (DslViewHolder) childViewHolder;
                    }
                }
            } else {
                return dslViewHolder;
            }
        } else {
            if (i < 0 && (adapter = recyclerView.getAdapter()) != null) {
                i = adapter.getItemCount();
            }
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition instanceof DslViewHolder) {
                dslViewHolder2 = (DslViewHolder) findViewHolderForAdapterPosition;
            }
        }
        return dslViewHolder2;
    }

    @OXOo.OOXIXo
    public static final List<DslViewHolder> oIX0oI(@OXOo.OOXIXo RecyclerView recyclerView) {
        DslViewHolder dslViewHolder;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        ArrayList arrayList = new ArrayList();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if (childViewHolder instanceof DslViewHolder) {
                dslViewHolder = (DslViewHolder) childViewHolder;
            } else {
                dslViewHolder = null;
            }
            if (dslViewHolder != null) {
                arrayList.add(dslViewHolder);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void oO(RecyclerView recyclerView, RecyclerView.ItemAnimator itemAnimator, int i, Object obj) {
        if ((i & 1) != 0) {
            itemAnimator = null;
        }
        x0XOIxOo(recyclerView, itemAnimator);
    }

    public static final void oOoXoXO(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo Oox.IXxxXO<? super DslAdapterItem, ? super DslViewHolder, ? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        if (!(recyclerView.getAdapter() instanceof DslAdapter)) {
            return;
        }
        for (DslViewHolder dslViewHolder : oIX0oI(recyclerView)) {
            int adapterPosition = dslViewHolder.getAdapterPosition();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.angcyo.dsladapter.DslAdapter");
            DslAdapterItem itemData$default = DslAdapter.getItemData$default((DslAdapter) adapter, adapterPosition, false, 2, null);
            if (itemData$default != null && adapterPosition >= 0) {
                action.invoke(itemData$default, dslViewHolder, Integer.valueOf(adapterPosition));
            }
        }
    }

    public static /* synthetic */ void ooOOo0oXI(RecyclerView recyclerView, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        OOXIXo(recyclerView, i, list);
    }

    public static /* synthetic */ DslAdapter oxoX(RecyclerView recyclerView, boolean z, boolean z2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return I0Io(recyclerView, z, z2, oooxoxo);
    }

    public static final void x0XOIxOo(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.oOoXoXO RecyclerView.ItemAnimator itemAnimator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        recyclerView.setItemAnimator(itemAnimator);
    }

    public static final void x0xO0oo(@OXOo.OOXIXo RecyclerView recyclerView, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        if (recyclerView.getItemAnimator() == null) {
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(!z);
            recyclerView.setItemAnimator(defaultItemAnimator);
        } else if (recyclerView.getItemAnimator() instanceof SimpleItemAnimator) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(!z);
        }
    }

    public static /* synthetic */ DslAdapter xoIox(RecyclerView recyclerView, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.RecyclerExKt$initDslAdapter$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter dslAdapter) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return xxIXOIIO(recyclerView, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final DslAdapter xxIXOIIO(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        II0XooXoX(recyclerView);
        if (recyclerView.getLayoutManager() == null) {
            IXxxXO(recyclerView, t.c);
        }
        DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        action.invoke(dslAdapter);
        recyclerView.setAdapter(dslAdapter);
        return dslAdapter;
    }
}
