package com.sma.smartv3.ui.status;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DragCallbackHelper;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.SPUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nEditCardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditCardActivity.kt\ncom/sma/smartv3/ui/status/EditCardActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,169:1\n37#2,2:170\n*S KotlinDebug\n*F\n+ 1 EditCardActivity.kt\ncom/sma/smartv3/ui/status/EditCardActivity\n*L\n54#1:170,2\n*E\n"})
/* loaded from: classes12.dex */
public final class EditCardActivity extends BaseDSLRecyclerActivity {
    private String[] cardArray;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.EditCardActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) EditCardActivity.this.findViewById(R.id.root_view);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final void addArray(int i, String str) {
        String[] strArr = null;
        if (i == 0) {
            String[] strArr2 = this.cardArray;
            if (strArr2 == null) {
                IIX0o.XOxIOxOx("cardArray");
                strArr2 = null;
            }
            int length = strArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                String[] strArr3 = this.cardArray;
                if (strArr3 == null) {
                    IIX0o.XOxIOxOx("cardArray");
                    strArr3 = null;
                }
                strArr3[i2] = "";
            }
        }
        String[] strArr4 = this.cardArray;
        if (strArr4 == null) {
            IIX0o.XOxIOxOx("cardArray");
        } else {
            strArr = strArr4;
        }
        strArr[i] = str;
    }

    private final LinearLayout getRootView() {
        return (LinearLayout) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.edit_card);
        String string = Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24475x0xO0oo);
        IIX0o.ooOOo0oXI(string);
        if (string.length() == 0) {
            string = ProductManager.f20544oIX0oI.OIOoIIOIx();
        }
        String str = string;
        IIX0o.ooOOo0oXI(str);
        this.cardArray = (String[]) StringsKt__StringsKt.XXoO0oX(str, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_edit_card;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LinearLayout rootView = getRootView();
        IIX0o.oO(rootView, "<get-rootView>(...)");
        onTitleLeftClick(rootView);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        final DragCallbackHelper dragCallbackHelper = new DragCallbackHelper();
        dragCallbackHelper.attachToRecyclerView(getRecyclerView());
        dragCallbackHelper.setOnClearView(new Oox.x0xO0oo<RecyclerView, RecyclerView.ViewHolder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity$onInitBaseLayoutAfter$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                invoke2(recyclerView, viewHolder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
                IIX0o.x0xO0oo(recyclerView, "<anonymous parameter 0>");
                IIX0o.x0xO0oo(viewHolder, "<anonymous parameter 1>");
                if (DragCallbackHelper.this.get_dragHappened()) {
                    DslAdapter.updateAllItem$default(this.getDslAdapter(), null, 1, null);
                }
            }
        });
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity$onInitBaseLayoutAfter$2
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslViewHolder dslViewHolder = EditCardActivity.this.getDslViewHolder();
                final EditCardActivity editCardActivity = EditCardActivity.this;
                dslViewHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity$onInitBaseLayoutAfter$2.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        final EditCardActivity editCardActivity2 = EditCardActivity.this;
                        editCardActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                String[] strArr;
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                strArr = EditCardActivity.this.cardArray;
                                if (strArr == null) {
                                    IIX0o.XOxIOxOx("cardArray");
                                    strArr = null;
                                }
                                for (String str : strArr) {
                                    switch (str.hashCode()) {
                                        case -2030863703:
                                            if (str.equals(ProductManager.ooIIx)) {
                                                final EditCardActivity editCardActivity3 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.9
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity4 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.9.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.blood_glucose);
                                                                }
                                                                EditCardActivity.this.addArray(i, ProductManager.ooIIx);
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case -1276242363:
                                            if (str.equals(ProductManager.oXoxo0x)) {
                                                final EditCardActivity editCardActivity4 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.8
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity5 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.8.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.pressure);
                                                                }
                                                                EditCardActivity.this.addArray(i, ProductManager.oXoxo0x);
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case -791592328:
                                            if (str.equals("weight")) {
                                                final EditCardActivity editCardActivity5 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.7
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity6 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.7.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.weight);
                                                                }
                                                                EditCardActivity.this.addArray(i, "weight");
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case -240915579:
                                            if (str.equals(ProductManager.IO0xO)) {
                                                final EditCardActivity editCardActivity6 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity7 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.4.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.blood_oxygen);
                                                                }
                                                                EditCardActivity.this.addArray(i, ProductManager.IO0xO);
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 103596:
                                            if (str.equals(ProductManager.oIIX)) {
                                                final EditCardActivity editCardActivity7 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity8 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.2.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.hrv);
                                                                }
                                                                EditCardActivity.this.addArray(i, ProductManager.oIIX);
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 109522647:
                                            if (str.equals("sleep")) {
                                                final EditCardActivity editCardActivity8 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity9 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.5.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.sleep);
                                                                }
                                                                EditCardActivity.this.addArray(i, "sleep");
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 321701236:
                                            if (str.equals("temperature")) {
                                                final EditCardActivity editCardActivity9 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.6
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity10 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.6.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.temperature);
                                                                }
                                                                EditCardActivity.this.addArray(i, "temperature");
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 560044778:
                                            if (str.equals(ProductManager.xxI0XIO)) {
                                                final EditCardActivity editCardActivity10 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity11 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.3.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.blood_pressure);
                                                                }
                                                                EditCardActivity.this.addArray(i, ProductManager.xxI0XIO);
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 1930449209:
                                            if (str.equals("heart_rate")) {
                                                final EditCardActivity editCardActivity11 = EditCardActivity.this;
                                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_edit_card_content, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                                        invoke2(dslAdapterItem);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                                        final EditCardActivity editCardActivity12 = EditCardActivity.this;
                                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.EditCardActivity.onInitBaseLayoutAfter.2.1.1.1.1
                                                            {
                                                                super(4);
                                                            }

                                                            @Override // Oox.Oxx0xo
                                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                                return oXIO0o0XI.f29392oIX0oI;
                                                            }

                                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                                TextView tv = itemHolder.tv(R.id.tvCard);
                                                                if (tv != null) {
                                                                    tv.setText(R.string.heart_rate);
                                                                }
                                                                EditCardActivity.this.addArray(i, "heart_rate");
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                            } else {
                                                break;
                                            }
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String[] strArr = this.cardArray;
        if (strArr == null) {
            IIX0o.XOxIOxOx("cardArray");
            strArr = null;
        }
        XO2.put(XoI0Ixx0.f24475x0xO0oo, TextUtils.join(",", strArr));
        finish();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }
}
