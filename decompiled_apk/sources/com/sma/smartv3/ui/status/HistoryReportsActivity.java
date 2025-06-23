package com.sma.smartv3.ui.status;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.HealthyReport;
import com.sma.smartv3.util.HeathReportsUtils;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nHistoryReportsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HistoryReportsActivity.kt\ncom/sma/smartv3/ui/status/HistoryReportsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n1855#2,2:134\n*S KotlinDebug\n*F\n+ 1 HistoryReportsActivity.kt\ncom/sma/smartv3/ui/status/HistoryReportsActivity\n*L\n83#1:134,2\n*E\n"})
/* loaded from: classes12.dex */
public final class HistoryReportsActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    private final X0IIOO mEmptyImg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$mEmptyImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HistoryReportsActivity.this.findViewById(R.id.iv_reports_generation);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mEmptyTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$mEmptyTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HistoryReportsActivity.this.findViewById(R.id.tv_reports_generation);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HistoryReportsActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final void findData(List<HealthyReport> list) {
        for (final HealthyReport healthyReport : list) {
            DslAdapterExKt.oO(getDslAdapter(), R.layout.item_heath_reports_list, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$findData$1$1
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
                    final HealthyReport healthyReport2 = HealthyReport.this;
                    final HistoryReportsActivity historyReportsActivity = this;
                    dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$findData$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list2) {
                            IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                            ImageView img = itemHolder.img(R.id.item_heath_iv);
                            IIX0o.x0XOIxOo(img, "null cannot be cast to non-null type android.widget.ImageView");
                            if (HealthyReport.this.getMAbnormalNumber() == 0) {
                                Glide.with((FragmentActivity) historyReportsActivity).load(Integer.valueOf(R.drawable.ic_right_message)).into(img);
                                TextView tv = itemHolder.tv(R.id.item_heath_title);
                                if (tv != null) {
                                    tv.setText(historyReportsActivity.getString(R.string.normal_indicators));
                                }
                                TextView tv2 = itemHolder.tv(R.id.item_heath_time);
                                if (tv2 == null) {
                                    return;
                                }
                                tv2.setText(HealthyReport.this.getMLocalTime());
                                return;
                            }
                            Glide.with((FragmentActivity) historyReportsActivity).load(Integer.valueOf(R.drawable.ic_exception_message)).into(img);
                            TextView tv3 = itemHolder.tv(R.id.item_heath_title);
                            if (tv3 != null) {
                                tv3.setText(historyReportsActivity.getString(R.string.abnormal_hint, Integer.valueOf(HealthyReport.this.getMAbnormalNumber())));
                            }
                            TextView tv4 = itemHolder.tv(R.id.item_heath_time);
                            if (tv4 == null) {
                                return;
                            }
                            tv4.setText(HealthyReport.this.getMLocalTime());
                        }
                    });
                    dslItem.setItemTag(HealthyReport.this.getMLocalTime());
                    final HistoryReportsActivity historyReportsActivity2 = this;
                    final HealthyReport healthyReport3 = HealthyReport.this;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$findData$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                            invoke2(view);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo View it) {
                            IIX0o.x0xO0oo(it, "it");
                            HistoryReportsActivity historyReportsActivity3 = HistoryReportsActivity.this;
                            String valueOf = String.valueOf(healthyReport3.getMId());
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", valueOf);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(historyReportsActivity3, (Class<?>) HeathReportsResultActivity.class);
                            intent.putExtras(bundle);
                            historyReportsActivity3.startActivity(intent);
                        }
                    });
                }
            });
        }
        getDslAdapter().notifyDataSetChanged();
    }

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMEmptyImg() {
        return (View) this.mEmptyImg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMEmptyTv() {
        return (View) this.mEmptyTv$delegate.getValue();
    }

    private final void showList(final List<HealthyReport> list) {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$showList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DslViewHolder dslViewHolder = HistoryReportsActivity.this.getDslViewHolder();
                final HistoryReportsActivity historyReportsActivity = HistoryReportsActivity.this;
                final List<HealthyReport> list2 = list;
                dslViewHolder.postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity$showList$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        final HistoryReportsActivity historyReportsActivity2 = HistoryReportsActivity.this;
                        final List<HealthyReport> list3 = list2;
                        historyReportsActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HistoryReportsActivity.showList.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                View mEmptyImg;
                                View mEmptyTv;
                                View mEmptyImg2;
                                View mEmptyTv2;
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                List<HealthyReport> list4 = list3;
                                if (list4 != null && !list4.isEmpty()) {
                                    historyReportsActivity2.getRecyclerView().setVisibility(0);
                                    mEmptyImg2 = historyReportsActivity2.getMEmptyImg();
                                    mEmptyImg2.setVisibility(8);
                                    mEmptyTv2 = historyReportsActivity2.getMEmptyTv();
                                    mEmptyTv2.setVisibility(8);
                                    historyReportsActivity2.findData(list3);
                                    return;
                                }
                                historyReportsActivity2.getRecyclerView().setVisibility(8);
                                mEmptyImg = historyReportsActivity2.getMEmptyImg();
                                mEmptyImg.setVisibility(0);
                                mEmptyTv = historyReportsActivity2.getMEmptyTv();
                                mEmptyTv.setVisibility(0);
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
        getAbhTitleCenter().setText(getString(R.string.history_record));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_heath_reports_list;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        showList(HeathReportsUtils.f24217oIX0oI.IIXOooo());
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
