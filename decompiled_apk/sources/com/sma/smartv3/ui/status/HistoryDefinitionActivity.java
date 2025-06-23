package com.sma.smartv3.ui.status;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nHistoryDefinitionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HistoryDefinitionActivity.kt\ncom/sma/smartv3/ui/status/HistoryDefinitionActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,170:1\n37#2,2:171\n*S KotlinDebug\n*F\n+ 1 HistoryDefinitionActivity.kt\ncom/sma/smartv3/ui/status/HistoryDefinitionActivity\n*L\n79#1:171,2\n*E\n"})
/* loaded from: classes12.dex */
public final class HistoryDefinitionActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HistoryDefinitionActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final void findData() {
        String string = Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24475x0xO0oo);
        IIX0o.ooOOo0oXI(string);
        if (string.length() == 0) {
            string = ProductManager.f20544oIX0oI.OIOoIIOIx();
        }
        String str = string;
        IIX0o.ooOOo0oXI(str);
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(str, new String[]{","}, false, 0, 6, null);
        for (final String str2 : (String[]) XXoO0oX2.toArray(new String[0])) {
            DslAdapterExKt.oO(getDslAdapter(), R.layout.item_heath_definition_list, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity$findData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    dslItem.setItemIsHover(false);
                    final String str3 = str2;
                    final HistoryDefinitionActivity historyDefinitionActivity = this;
                    dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity$findData$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                            Activity mContext;
                            Activity mContext2;
                            Activity mContext3;
                            Activity mContext4;
                            Activity mContext5;
                            Activity mContext6;
                            IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                            TextView tv = itemHolder.tv(R.id.item_definition_title);
                            TextView tv2 = itemHolder.tv(R.id.item_definition_tip);
                            CircleThumbSegmentedBarView circleThumbSegmentedBarView = (CircleThumbSegmentedBarView) itemHolder.v(R.id.sbv);
                            String str4 = str3;
                            int hashCode = str4.hashCode();
                            Integer valueOf = Integer.valueOf(SupportMenu.CATEGORY_MASK);
                            Double valueOf2 = Double.valueOf(100.0d);
                            Double valueOf3 = Double.valueOf(XIXIX.OOXIXo.f3760XO);
                            switch (hashCode) {
                                case -1276242363:
                                    if (str4.equals(ProductManager.oXoxo0x)) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.pressure));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_pressure));
                                        }
                                        HistoryDefinitionActivity historyDefinitionActivity2 = historyDefinitionActivity;
                                        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(valueOf3, Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(75.0d), valueOf2);
                                        mContext = historyDefinitionActivity.getMContext();
                                        String[] stringArray = mContext.getResources().getStringArray(R.array.level_range_4_2_bmi);
                                        IIX0o.oO(stringArray, "getStringArray(...)");
                                        mContext2 = historyDefinitionActivity.getMContext();
                                        int[] intArray = mContext2.getResources().getIntArray(R.array.level_color_4_2);
                                        IIX0o.oO(intArray, "getIntArray(...)");
                                        historyDefinitionActivity2.setBmi(circleThumbSegmentedBarView, 20.0f, X00IoxXI2, stringArray, intArray);
                                        return;
                                    }
                                    break;
                                case -791592328:
                                    if (str4.equals("weight")) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.weight));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_weight));
                                        }
                                        HistoryDefinitionActivity historyDefinitionActivity3 = historyDefinitionActivity;
                                        List X00IoxXI3 = CollectionsKt__CollectionsKt.X00IoxXI(valueOf3, Double.valueOf(18.4d), Double.valueOf(24.9d), Double.valueOf(29.9d), Double.valueOf(39.9d));
                                        String string2 = historyDefinitionActivity.getString(R.string.thin);
                                        IIX0o.oO(string2, "getString(...)");
                                        String string3 = historyDefinitionActivity.getString(R.string.normal);
                                        IIX0o.oO(string3, "getString(...)");
                                        String string4 = historyDefinitionActivity.getString(R.string.too_heavy);
                                        IIX0o.oO(string4, "getString(...)");
                                        String string5 = historyDefinitionActivity.getString(R.string.class_1_obesity);
                                        IIX0o.oO(string5, "getString(...)");
                                        String[] strArr = {string2, string3, string4, string5};
                                        mContext3 = historyDefinitionActivity.getMContext();
                                        historyDefinitionActivity3.setBmi(circleThumbSegmentedBarView, 20.0f, X00IoxXI3, strArr, ArraysKt___ArraysKt.xoXI0X(new Integer[]{-16776961, -16711936, Integer.valueOf(mContext3.getResources().getColor(R.color.bg_level_color_prediabetes)), valueOf}));
                                        return;
                                    }
                                    break;
                                case -240915579:
                                    if (str4.equals(ProductManager.IO0xO)) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.blood_oxygen));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_oxy));
                                        }
                                        HistoryDefinitionActivity historyDefinitionActivity4 = historyDefinitionActivity;
                                        List X00IoxXI4 = CollectionsKt__CollectionsKt.X00IoxXI(valueOf3, Double.valueOf(92.0d), valueOf2);
                                        String string6 = historyDefinitionActivity.getString(R.string.lightness_low);
                                        IIX0o.oO(string6, "getString(...)");
                                        String string7 = historyDefinitionActivity.getString(R.string.bg_normal);
                                        IIX0o.oO(string7, "getString(...)");
                                        historyDefinitionActivity4.setBmi(circleThumbSegmentedBarView, 95.0f, X00IoxXI4, new String[]{string6, string7}, ArraysKt___ArraysKt.xoXI0X(new Integer[]{-16776961, -16711936}));
                                        if (circleThumbSegmentedBarView != null) {
                                            circleThumbSegmentedBarView.setSegmentSideRule(0);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                case 109522647:
                                    if (str4.equals("sleep")) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.sleep));
                                        }
                                        LibExKt.oxxXoxO(circleThumbSegmentedBarView, true);
                                        if (tv2 == null) {
                                            return;
                                        }
                                        tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_sleep));
                                        return;
                                    }
                                    break;
                                case 560044778:
                                    if (str4.equals(ProductManager.xxI0XIO)) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.blood_glucose));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_bp));
                                        }
                                        LibExKt.oxxXoxO(circleThumbSegmentedBarView, true);
                                        return;
                                    }
                                    break;
                                case 1467734697:
                                    if (str4.equals(ProductManager.X0OXIOxX)) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.blood_glucose));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_bg));
                                        }
                                        HistoryDefinitionActivity historyDefinitionActivity5 = historyDefinitionActivity;
                                        List X00IoxXI5 = CollectionsKt__CollectionsKt.X00IoxXI(valueOf3, Double.valueOf(6.1d), Double.valueOf(6.9d), Double.valueOf(10.0d));
                                        String string8 = historyDefinitionActivity.getString(R.string.bg_normal);
                                        IIX0o.oO(string8, "getString(...)");
                                        String string9 = historyDefinitionActivity.getString(R.string.bg_prediabetes);
                                        IIX0o.oO(string9, "getString(...)");
                                        String string10 = historyDefinitionActivity.getString(R.string.bg_diabetes);
                                        IIX0o.oO(string10, "getString(...)");
                                        String[] strArr2 = {string8, string9, string10};
                                        mContext4 = historyDefinitionActivity.getMContext();
                                        Integer valueOf4 = Integer.valueOf(mContext4.getResources().getColor(R.color.bg_level_color_normal));
                                        mContext5 = historyDefinitionActivity.getMContext();
                                        Integer valueOf5 = Integer.valueOf(mContext5.getResources().getColor(R.color.bg_level_color_prediabetes));
                                        mContext6 = historyDefinitionActivity.getMContext();
                                        historyDefinitionActivity5.setBmi(circleThumbSegmentedBarView, 3.0f, X00IoxXI5, strArr2, ArraysKt___ArraysKt.xoXI0X(new Integer[]{valueOf4, valueOf5, Integer.valueOf(mContext6.getResources().getColor(R.color.bg_level_color_diabetes))}));
                                        return;
                                    }
                                    break;
                                case 1930449209:
                                    if (str4.equals("heart_rate")) {
                                        if (tv != null) {
                                            tv.setText(historyDefinitionActivity.getString(R.string.heart_rate));
                                        }
                                        if (tv2 != null) {
                                            tv2.setText(historyDefinitionActivity.getString(R.string.health_definition_hr));
                                        }
                                        HistoryDefinitionActivity historyDefinitionActivity6 = historyDefinitionActivity;
                                        List X00IoxXI6 = CollectionsKt__CollectionsKt.X00IoxXI(valueOf3, Double.valueOf(60.0d), valueOf2, Double.valueOf(180.0d));
                                        String string11 = historyDefinitionActivity.getString(R.string.lightness_low);
                                        IIX0o.oO(string11, "getString(...)");
                                        String string12 = historyDefinitionActivity.getString(R.string.lightness_middle);
                                        IIX0o.oO(string12, "getString(...)");
                                        String string13 = historyDefinitionActivity.getString(R.string.lightness_high);
                                        IIX0o.oO(string13, "getString(...)");
                                        historyDefinitionActivity6.setBmi(circleThumbSegmentedBarView, 80.0f, X00IoxXI6, new String[]{string11, string12, string13}, ArraysKt___ArraysKt.xoXI0X(new Integer[]{-16776961, -16711936, valueOf}));
                                        return;
                                    }
                                    break;
                            }
                            if (tv != null) {
                                tv.setText(historyDefinitionActivity.getString(R.string.sleep));
                            }
                            LibExKt.oxxXoxO(circleThumbSegmentedBarView, true);
                        }
                    });
                    dslItem.setItemTag(str2);
                }
            });
        }
        getDslAdapter().notifyDataSetChanged();
    }

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBmi(SegmentedBarView segmentedBarView, float f, List<Double> list, String[] strArr, int[] iArr) {
        IIX0o.ooOOo0oXI(segmentedBarView);
        WeightMeasureDataKt.setBarView(segmentedBarView, f, list, strArr, iArr, true);
        LibExKt.x0OIX00oO(segmentedBarView, true);
    }

    private final void showList() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity$showList$1
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
                DslViewHolder dslViewHolder = HistoryDefinitionActivity.this.getDslViewHolder();
                final HistoryDefinitionActivity historyDefinitionActivity = HistoryDefinitionActivity.this;
                dslViewHolder.postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity$showList$1.1
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
                        final HistoryDefinitionActivity historyDefinitionActivity2 = HistoryDefinitionActivity.this;
                        historyDefinitionActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryDefinitionActivity.showList.1.1.1
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
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                HistoryDefinitionActivity.this.findData();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getAbhTitleCenter().setText(getString(R.string.health_definition_title));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_heath_reports_list;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        showList();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
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
