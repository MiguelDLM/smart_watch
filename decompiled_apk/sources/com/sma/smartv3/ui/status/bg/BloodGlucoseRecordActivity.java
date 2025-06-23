package com.sma.smartv3.ui.status.bg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import XO0.XO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.BGEMRecordSet;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;
import oIxOXo.oxoX;

@XX({"SMAP\nBloodGlucoseRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucoseRecordActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseRecordActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n18#2,2:114\n15#2:116\n69#3,3:117\n72#3,5:121\n1#4:120\n*S KotlinDebug\n*F\n+ 1 BloodGlucoseRecordActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseRecordActivity\n*L\n60#1:114,2\n60#1:116\n111#1:117,3\n111#1:121,5\n111#1:120\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodGlucoseRecordActivity extends BaseDSLRecyclerActivity {

    @OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BloodGlucoseRecordActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OOXIXo
    private final BloodGlucose2Dao mBloodGlucose2Dao = MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao();

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BloodGlucose2> loadData() {
        long endDate;
        long millis;
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(BGEMRecordSet.class.getName()), (Class<Object>) BGEMRecordSet.class);
        if (fromJson == null) {
            fromJson = BGEMRecordSet.class.newInstance();
        }
        BGEMRecordSet bGEMRecordSet = (BGEMRecordSet) fromJson;
        long startDate = bGEMRecordSet.getStartDate();
        if (bGEMRecordSet.getEndDate() == 0) {
            Calendar calendar = Calendar.getInstance();
            IIX0o.oO(calendar, "getInstance(...)");
            endDate = xoIox.OxxIIOOXO(calendar);
            millis = TimeUnit.DAYS.toMillis(1L);
        } else {
            endDate = bGEMRecordSet.getEndDate();
            millis = TimeUnit.DAYS.toMillis(1L);
        }
        long j = endDate + millis;
        if (bGEMRecordSet.getCalendar() == 1) {
            return this.mBloodGlucose2Dao.getList(startDate, j);
        }
        return this.mBloodGlucose2Dao.getListDESC(startDate, j);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    @OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.measurement_logs);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_blood_glucose_record_set);
        getAbhTitleRight().setImageTintList(oxoX.X0o0xo(this, R.color.text_color));
        showData(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_blood_glucose_record;
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) BloodGlucoseRecordSetActivity.class));
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    @XO(tag = x0xO0oo.f24625o0oIxOo)
    public final void showData(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity$showData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo DslAdapter renderAdapter) {
                List loadData;
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                loadData = BloodGlucoseRecordActivity.this.loadData();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : loadData) {
                    String format = xoIox.xoIxX().format(Long.valueOf(((BloodGlucose2) obj).getMTime()));
                    Object obj2 = linkedHashMap.get(format);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(format, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                for (final Map.Entry entry : linkedHashMap.entrySet()) {
                    DslAdapterExKt.oO(BloodGlucoseRecordActivity.this.getDslAdapter(), R.layout.blood_glucose_measure_history_group_item, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity$showData$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                            invoke2(dslAdapterItem);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo DslAdapterItem dslItem) {
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemSwipeMenuEnable(false);
                            dslItem.setItemIsGroupHead(false);
                            dslItem.setItemIsHover(false);
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(entry.getKey()));
                            final Map.Entry<String, List<BloodGlucose2>> entry2 = entry;
                            dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity.showData.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // Oox.Oxx0xo
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list) {
                                    IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                    IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                    IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                    TextView tv = itemHolder.tv(R.id.tv_date);
                                    if (tv != null) {
                                        tv.setText(entry2.getKey());
                                    }
                                }
                            });
                            dslItem.setItemTag(entry.getKey());
                        }
                    });
                    for (final BloodGlucose2 bloodGlucose2 : (List) entry.getValue()) {
                        DslAdapterExKt.oO(BloodGlucoseRecordActivity.this.getDslAdapter(), R.layout.blood_glucose_measure_history_item, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity$showData$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                invoke2(dslAdapterItem);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo DslAdapterItem dslItem) {
                                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(entry.getKey()));
                                dslItem.setItemSwipeMenuFlag(4);
                                final BloodGlucose2 bloodGlucose22 = bloodGlucose2;
                                dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseRecordActivity.showData.1.3.1
                                    {
                                        super(4);
                                    }

                                    @Override // Oox.Oxx0xo
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list) {
                                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                        IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                        TextView tv = itemHolder.tv(R.id.tv_time);
                                        if (tv != null) {
                                            tv.setText(xoIox.O0Xx(false, 1, null).format(Long.valueOf(BloodGlucose2.this.getMTime())));
                                        }
                                        TextView tv2 = itemHolder.tv(R.id.tv_value);
                                        if (tv2 == null) {
                                            return;
                                        }
                                        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                                        String format2 = String.format("%.1f - %.1f", Arrays.copyOf(new Object[]{Double.valueOf(BloodGlucose2.this.getMLowerBound()), Double.valueOf(BloodGlucose2.this.getMUpperBound())}, 2));
                                        IIX0o.oO(format2, "format(...)");
                                        tv2.setText(format2);
                                    }
                                });
                            }
                        });
                    }
                }
            }
        });
    }
}
