package com.sma.smartv3.ui.order;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import XO0.XO;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslLoadMoreItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AccountIntegralData;
import com.sma.smartv3.model.AccountPoints;
import com.sma.smartv3.model.IntegralContentData;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import oIxOXo.oxoX;

@XX({"SMAP\nPointsDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsDetailActivity.kt\ncom/sma/smartv3/ui/order/PointsDetailActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n93#2,2:185\n90#2:187\n1855#3,2:188\n87#4,7:190\n94#4,3:198\n70#4,7:201\n97#4:208\n1#5:197\n*S KotlinDebug\n*F\n+ 1 PointsDetailActivity.kt\ncom/sma/smartv3/ui/order/PointsDetailActivity\n*L\n97#1:185,2\n97#1:187\n147#1:188,2\n70#1:190,7\n70#1:198,3\n70#1:201,7\n70#1:208\n70#1:197\n*E\n"})
/* loaded from: classes11.dex */
public final class PointsDetailActivity extends BaseDSLRecyclerActivity {

    @OOXIXo
    private final String TAG = "PointsDetail";
    private int pageNum = 1;

    @OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PointsDetailActivity.this.findViewById(R.id.root_view);
        }
    });

    @OOXIXo
    private final X0IIOO layoutBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$layoutBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PointsDetailActivity.this.findViewById(R.id.points_recharge_bg_layout);
        }
    });

    @OOXIXo
    private final X0IIOO tvPoints$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$tvPoints$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PointsDetailActivity.this.findViewById(R.id.tv_points);
        }
    });

    @OOXIXo
    private final X0IIOO btnRecharge$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$btnRecharge$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) PointsDetailActivity.this.findViewById(R.id.btn_recharge);
        }
    });

    @OOXIXo
    private final X0IIOO titleBg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$titleBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PointsDetailActivity.this.findViewById(R.id.order_points_detail_title_bg);
        }
    });

    private final Button getBtnRecharge() {
        return (Button) this.btnRecharge$delegate.getValue();
    }

    private final View getLayoutBg() {
        return (View) this.layoutBg$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final View getTitleBg() {
        return (View) this.titleBg$delegate.getValue();
    }

    private final TextView getTvPoints() {
        return (TextView) this.tvPoints$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PointsDetailActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", IIX0o2);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0, (Class<?>) GoogleWebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showData(DslAdapter dslAdapter, AccountIntegralData accountIntegralData) {
        if (accountIntegralData.getContent() == null) {
            LogUtils.e("integralData.content == null");
            return;
        }
        LogUtils.d("integralData.content == " + accountIntegralData.getContent().size());
        for (final IntegralContentData integralContentData : accountIntegralData.getContent()) {
            DslAdapterExKt.oO(dslAdapter, R.layout.item_points_detail, new oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$showData$1$1
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
                    final IntegralContentData integralContentData2 = IntegralContentData.this;
                    dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$showData$1$1.1
                        {
                            super(4);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OOXIXo DslViewHolder holder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list) {
                            int I0Io2;
                            IIX0o.x0xO0oo(holder, "holder");
                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                            TextView tv = holder.tv(R.id.tv_name);
                            if (tv != null) {
                                tv.setText(IntegralContentData.this.getRecordItem());
                            }
                            TextView tv2 = holder.tv(R.id.tv_date);
                            if (tv2 != null) {
                                tv2.setText(IntegralContentData.this.getCreatedAt());
                            }
                            TextView tv3 = holder.tv(R.id.tv_points_change);
                            if (tv3 != null) {
                                IntegralContentData integralContentData3 = IntegralContentData.this;
                                tv3.setText(integralContentData3.getPointsChange());
                                if (integralContentData3.getChangeFlag() == 0) {
                                    I0Io2 = oxoX.I0Io(tv3.getContext(), R.color.order_text_orange);
                                } else {
                                    I0Io2 = oxoX.I0Io(tv3.getContext(), R.color.line_color);
                                }
                                tv3.setTextColor(I0Io2);
                            }
                            View v = holder.v(R.id.item_points_detail_layout);
                            if (v != null) {
                                v.setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(v.getContext(), R.color.points_three_bg_color)));
                            }
                        }
                    });
                }
            });
        }
    }

    private final void showPoints() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(x0xO0oo.f24568IIX0 + '_' + AccountPoints.class.getName()), (Class<Object>) AccountPoints.class);
        if (fromJson == null) {
            fromJson = AccountPoints.class.newInstance();
        }
        getTvPoints().setText(TextConvertKt.oOXoIIIo(((AccountPoints) fromJson).getPoints(), false, 2, null));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        BarUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.root_view));
        setNavBarColor(this, oxoX.I0Io(this, R.color.points_bg_color));
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.points_detail);
        getBtnRecharge().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.order.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointsDetailActivity.initView$lambda$0(PointsDetailActivity.this, view);
            }
        });
        showPoints();
        getTitleBg().setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(this, R.color.points_three_bg_color)));
        getBtnRecharge().setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(this, R.color.order_points_detail_btn_bg)));
        getLayoutBg().setBackgroundTintList(ColorStateList.valueOf(oxoX.I0Io(this, R.color.points_bg_color)));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_order_points_detail;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        OrderManager.f20130oIX0oI.II0XooXoX(this.pageNum, new oOoXoXO<AccountIntegralData, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$onInitBaseLayoutAfter$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AccountIntegralData accountIntegralData) {
                invoke2(accountIntegralData);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO AccountIntegralData accountIntegralData) {
                PointsDetailActivity.this.renderRecyclerAdapter();
            }
        });
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @XO(tag = x0xO0oo.f24568IIX0)
    public final void onUserPointsChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onUserPointsChange");
        showPoints();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv_points_detail;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void renderRecyclerAdapter() {
        renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$renderRecyclerAdapter$1
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
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                renderAdapter.getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sport_empty_v2));
                SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                AccountIntegralData accountIntegralData = (AccountIntegralData) new Gson().fromJson(XO2.getString(XoI0Ixx0.f24366IXO + '_' + AccountIntegralData.class.getName()), AccountIntegralData.class);
                if (accountIntegralData != null && !accountIntegralData.getContent().isEmpty()) {
                    PointsDetailActivity.this.showData(renderAdapter, accountIntegralData);
                    renderAdapter.setLoadMoreEnable(true);
                } else {
                    DslAdapter.setAdapterStatus$default(PointsDetailActivity.this.getDslAdapter(), 1, null, 2, null);
                }
                DslLoadMoreItem dslLoadMoreItem = renderAdapter.getDslLoadMoreItem();
                final PointsDetailActivity pointsDetailActivity = PointsDetailActivity.this;
                dslLoadMoreItem.setOnLoadMore(new oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$renderRecyclerAdapter$1.1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder) {
                        invoke2(dslViewHolder);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo DslViewHolder it) {
                        IIX0o.x0xO0oo(it, "it");
                        final PointsDetailActivity pointsDetailActivity2 = PointsDetailActivity.this;
                        pointsDetailActivity2.renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity.renderRecyclerAdapter.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo final DslAdapter renderAdapter2) {
                                int i;
                                int i2;
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                PointsDetailActivity pointsDetailActivity3 = PointsDetailActivity.this;
                                i = pointsDetailActivity3.pageNum;
                                pointsDetailActivity3.pageNum = i + 1;
                                OrderManager orderManager = OrderManager.f20130oIX0oI;
                                i2 = PointsDetailActivity.this.pageNum;
                                final PointsDetailActivity pointsDetailActivity4 = PointsDetailActivity.this;
                                orderManager.II0XooXoX(i2, new oOoXoXO<AccountIntegralData, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity.renderRecyclerAdapter.1.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AccountIntegralData accountIntegralData2) {
                                        invoke2(accountIntegralData2);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.oOoXoXO AccountIntegralData accountIntegralData2) {
                                        if (accountIntegralData2 != null && accountIntegralData2.getContent() != null && !accountIntegralData2.getContent().isEmpty()) {
                                            PointsDetailActivity.this.showData(renderAdapter2, accountIntegralData2);
                                            DslAdapter.setLoadMore$default(renderAdapter2, 0, null, false, 6, null);
                                        } else {
                                            DslAdapter.setLoadMore$default(renderAdapter2, 2, null, false, 6, null);
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                DslAdapter.render$default(renderAdapter, false, null, new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.PointsDetailActivity$renderRecyclerAdapter$1.2
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                        invoke2(dslAdapter);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo DslAdapter render) {
                        IIX0o.x0xO0oo(render, "$this$render");
                        DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                    }
                }, 3, null);
            }
        });
    }
}
