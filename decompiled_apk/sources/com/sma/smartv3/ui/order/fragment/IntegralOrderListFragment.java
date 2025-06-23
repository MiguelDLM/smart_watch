package com.sma.smartv3.ui.order.fragment;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslLoadMoreItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.SwipeMenuHelper;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AccountOrderData;
import com.sma.smartv3.model.OrderContentData;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nIntegralOrderListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegralOrderListFragment.kt\ncom/sma/smartv3/ui/order/fragment/IntegralOrderListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1855#2,2:149\n*S KotlinDebug\n*F\n+ 1 IntegralOrderListFragment.kt\ncom/sma/smartv3/ui/order/fragment/IntegralOrderListFragment\n*L\n109#1:149,2\n*E\n"})
/* loaded from: classes11.dex */
public final class IntegralOrderListFragment extends BaseOrderListFragment {

    @OOXIXo
    private String itemOrderNum;

    public IntegralOrderListFragment() {
        setOrderType("Points");
        this.itemOrderNum = "";
    }

    public final void findData(@OOXIXo final DslAdapter dslAdapter, @OOXIXo List<OrderContentData> mList) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(mList, "mList");
        LogUtils.d("findData " + getOrderType() + " mList = " + mList.size());
        for (final OrderContentData orderContentData : mList) {
            DslAdapterExKt.oO(dslAdapter, R.layout.item_order_integral, new oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$findData$1$1

                /* renamed from: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$findData$1$1$1, reason: invalid class name */
                /* loaded from: classes11.dex */
                public static final class AnonymousClass1 extends Lambda implements Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                    final /* synthetic */ OrderContentData $it;
                    final /* synthetic */ DslAdapterItem $this_dslItem;
                    final /* synthetic */ DslAdapter $this_findData;
                    final /* synthetic */ IntegralOrderListFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(IntegralOrderListFragment integralOrderListFragment, OrderContentData orderContentData, DslAdapterItem dslAdapterItem, DslAdapter dslAdapter) {
                        super(4);
                        this.this$0 = integralOrderListFragment;
                        this.$it = orderContentData;
                        this.$this_dslItem = dslAdapterItem;
                        this.$this_findData = dslAdapter;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$0(IntegralOrderListFragment this$0, OrderContentData it, int i, DslAdapterItem this_dslItem, DslViewHolder itemHolder, DslAdapter this_findData, View view) {
                        List<DslAdapterItem> dataItems;
                        IIX0o.x0xO0oo(this$0, "this$0");
                        IIX0o.x0xO0oo(it, "$it");
                        IIX0o.x0xO0oo(this_dslItem, "$this_dslItem");
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                        IIX0o.x0xO0oo(this_findData, "$this_findData");
                        this$0.setItemOrderNum(it.getOrderNum());
                        this$0.deleteRecord(i);
                        this$0.deleteOrder(this$0.getItemOrderNum());
                        SwipeMenuHelper swipeMenuHelper = this_dslItem.get_itemSwipeMenuHelper();
                        if (swipeMenuHelper != null) {
                            swipeMenuHelper.closeSwipeMenu(itemHolder);
                        }
                        DslAdapter itemDslAdapter = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter != null) {
                            DslAdapter.removeItem$default(itemDslAdapter, this_dslItem, false, 2, null);
                        }
                        DslAdapter itemDslAdapter2 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter2 != null && (dataItems = itemDslAdapter2.getDataItems()) != null && dataItems.size() == 0) {
                            DslAdapter.setAdapterStatus$default(this_findData, 1, null, 2, null);
                        }
                        DslAdapter itemDslAdapter3 = this_dslItem.getItemDslAdapter();
                        if (itemDslAdapter3 != null) {
                            DslAdapter.updateItemDepend$default(itemDslAdapter3, null, 1, null);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$2$lambda$1(DslViewHolder itemHolder, View view, MotionEvent motionEvent) {
                        IIX0o.x0xO0oo(itemHolder, "$itemHolder");
                        return itemHolder.itemView.onTouchEvent(motionEvent);
                    }

                    @Override // Oox.Oxx0xo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(@OOXIXo final DslViewHolder itemHolder, final int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list) {
                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                        IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                        this.this$0.initItem(itemHolder, this.$it, i);
                        final IntegralOrderListFragment integralOrderListFragment = this.this$0;
                        final OrderContentData orderContentData = this.$it;
                        final DslAdapterItem dslAdapterItem2 = this.$this_dslItem;
                        final DslAdapter dslAdapter = this.$this_findData;
                        itemHolder.click(R.id.bt_delete_record, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: INVOKE 
                              (r8v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder)
                              (wrap:int:SGET  A[WRAPPED] com.sma.smartv3.co_fit.R.id.bt_delete_record int)
                              (wrap:android.view.View$OnClickListener:0x0023: CONSTRUCTOR 
                              (r1v0 'integralOrderListFragment' com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment A[DONT_INLINE])
                              (r2v0 'orderContentData' com.sma.smartv3.model.OrderContentData A[DONT_INLINE])
                              (r9v0 'i' int A[DONT_INLINE])
                              (r4v0 'dslAdapterItem2' com.angcyo.dsladapter.DslAdapterItem A[DONT_INLINE])
                              (r8v0 'itemHolder' com.angcyo.dsladapter.DslViewHolder A[DONT_INLINE])
                              (r6v0 'dslAdapter' com.angcyo.dsladapter.DslAdapter A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment, com.sma.smartv3.model.OrderContentData, int, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.angcyo.dsladapter.DslAdapter):void (m), WRAPPED] call: com.sma.smartv3.ui.order.fragment.X0o0xo.<init>(com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment, com.sma.smartv3.model.OrderContentData, int, com.angcyo.dsladapter.DslAdapterItem, com.angcyo.dsladapter.DslViewHolder, com.angcyo.dsladapter.DslAdapter):void type: CONSTRUCTOR)
                             VIRTUAL call: com.angcyo.dsladapter.DslViewHolder.click(int, android.view.View$OnClickListener):void A[MD:(int, android.view.View$OnClickListener):void (m)] in method: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$findData$1$1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes11.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.order.fragment.X0o0xo, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "itemHolder"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
                            java.lang.String r0 = "<anonymous parameter 2>"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
                            java.lang.String r10 = "<anonymous parameter 3>"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r10)
                            com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment r10 = r7.this$0
                            com.sma.smartv3.model.OrderContentData r11 = r7.$it
                            r10.initItem(r8, r11, r9)
                            com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment r1 = r7.this$0
                            com.sma.smartv3.model.OrderContentData r2 = r7.$it
                            com.angcyo.dsladapter.DslAdapterItem r4 = r7.$this_dslItem
                            com.angcyo.dsladapter.DslAdapter r6 = r7.$this_findData
                            com.sma.smartv3.ui.order.fragment.X0o0xo r10 = new com.sma.smartv3.ui.order.fragment.X0o0xo
                            r0 = r10
                            r3 = r9
                            r5 = r8
                            r0.<init>(r1, r2, r3, r4, r5, r6)
                            r9 = 2131363391(0x7f0a063f, float:1.834659E38)
                            r8.click(r9, r10)
                            r9 = 2131365907(0x7f0a1013, float:1.8351693E38)
                            android.view.View r9 = r8.view(r9)
                            if (r9 == 0) goto L3d
                            com.sma.smartv3.ui.order.fragment.XO r10 = new com.sma.smartv3.ui.order.fragment.XO
                            r10.<init>(r8)
                            r9.setOnTouchListener(r10)
                        L3d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$findData$1$1.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                    }
                }

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
                public final void invoke2(@OOXIXo final DslAdapterItem dslItem) {
                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    dslItem.setItemSwipeMenuFlag(4);
                    dslItem.setItemBindOverride(new AnonymousClass1(IntegralOrderListFragment.this, orderContentData, dslItem, dslAdapter));
                    final OrderContentData orderContentData2 = orderContentData;
                    final IntegralOrderListFragment integralOrderListFragment = IntegralOrderListFragment.this;
                    dslItem.setItemClick(new oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$findData$1$1.2
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
                        public final void invoke2(@OOXIXo View view) {
                            IIX0o.x0xO0oo(view, "view");
                            if (!com.sma.smartv3.ui.device.dialpay.oIX0oI.oxoX(OrderContentData.this.getPayStatus())) {
                                integralOrderListFragment.showConfirm(OrderContentData.this.getOrderNum());
                            }
                            SwipeMenuHelper swipeMenuHelper = dslItem.get_itemSwipeMenuHelper();
                            if (swipeMenuHelper != null) {
                                SwipeMenuHelper.closeSwipeMenu$default(swipeMenuHelper, null, 1, null);
                            }
                        }
                    });
                }
            });
        }
    }

    @OOXIXo
    public final String getItemOrderNum() {
        return this.itemOrderNum;
    }

    @Override // com.sma.smartv3.ui.order.fragment.BaseOrderListFragment
    public void getOrderList() {
        OrderManager.f20130oIX0oI.xxIXOIIO(getOrderType(), getPageNum(), new oOoXoXO<AccountOrderData, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$getOrderList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AccountOrderData accountOrderData) {
                invoke2(accountOrderData);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO AccountOrderData accountOrderData) {
                if (accountOrderData != null) {
                    IntegralOrderListFragment.this.getMList().clear();
                    IntegralOrderListFragment.this.getMList().addAll(CollectionsKt___CollectionsKt.o0Xo0XII(accountOrderData.getContent()));
                }
                IntegralOrderListFragment.this.setAdapter();
            }
        });
    }

    public final void initItem(@OOXIXo DslViewHolder holder, @OOXIXo OrderContentData item, int i) {
        int I0Io2;
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(item, "item");
        TextView textView = (TextView) holder.v(R.id.order_integral_remark);
        TextView textView2 = (TextView) holder.v(R.id.order_integral_amount);
        TextView textView3 = (TextView) holder.v(R.id.order_integral_orderNum);
        TextView textView4 = (TextView) holder.v(R.id.order_integral_time);
        TextView textView5 = (TextView) holder.v(R.id.order_integral_orderNum_title);
        if (textView5 != null) {
            textView5.setText(getString(R.string.order_orderNum) + ':');
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView != null) {
            textView.setText(getString(R.string.order_pay_amount_name) + ": " + com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(item.getAmount(), null, 2, null));
        }
        if (textView2 != null) {
            textView2.setText(getString(R.string.recharge) + item.getSubject() + getString(R.string.points));
        }
        if (textView3 != null) {
            textView3.setText(item.getOrderNum());
        }
        if (textView4 != null) {
            textView4.setText(item.getCreatedAt());
        }
        if (textView != null) {
            textView.setTextColor(oIxOXo.oxoX.I0Io(getContext(), R.color.text_color));
        }
        TextView textView6 = (TextView) holder.v(R.id.order_integral_pay_status);
        if (textView6 != null) {
            if (com.sma.smartv3.ui.device.dialpay.oIX0oI.oxoX(item.getPayStatus())) {
                textView6.setText(getString(R.string.order_pay_status_payed));
                I0Io2 = oIxOXo.oxoX.I0Io(textView6.getContext(), R.color.text_color);
            } else {
                textView6.setText(getString(R.string.order_pay_status_created));
                I0Io2 = oIxOXo.oxoX.I0Io(textView6.getContext(), R.color.order_text_orange);
            }
            textView6.setTextColor(I0Io2);
        }
    }

    @Override // com.sma.smartv3.ui.order.fragment.BaseOrderListFragment
    public void setAdapter() {
        renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$setAdapter$1
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
                DslViewHolder dslViewHolder = IntegralOrderListFragment.this.getDslViewHolder();
                final IntegralOrderListFragment integralOrderListFragment = IntegralOrderListFragment.this;
                dslViewHolder.postDelay(500L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$setAdapter$1.1
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
                        final IntegralOrderListFragment integralOrderListFragment2 = IntegralOrderListFragment.this;
                        integralOrderListFragment2.renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment.setAdapter.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo DslAdapter renderAdapter2) {
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                if (IntegralOrderListFragment.this.getMList().isEmpty()) {
                                    DslAdapter.setAdapterStatus$default(IntegralOrderListFragment.this.getDslAdapter(), 1, null, 2, null);
                                    return;
                                }
                                renderAdapter2.clearAllItems();
                                IntegralOrderListFragment integralOrderListFragment3 = IntegralOrderListFragment.this;
                                integralOrderListFragment3.findData(renderAdapter2, integralOrderListFragment3.getMList());
                                renderAdapter2.setLoadMoreEnable(true);
                            }
                        });
                    }
                });
                DslLoadMoreItem dslLoadMoreItem = renderAdapter.getDslLoadMoreItem();
                final IntegralOrderListFragment integralOrderListFragment2 = IntegralOrderListFragment.this;
                dslLoadMoreItem.setOnLoadMore(new oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$setAdapter$1.2
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2) {
                        invoke2(dslViewHolder2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo DslViewHolder it) {
                        IIX0o.x0xO0oo(it, "it");
                        final IntegralOrderListFragment integralOrderListFragment3 = IntegralOrderListFragment.this;
                        integralOrderListFragment3.renderAdapter(new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment.setAdapter.1.2.1
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
                                IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                IntegralOrderListFragment integralOrderListFragment4 = IntegralOrderListFragment.this;
                                integralOrderListFragment4.setPageNum(integralOrderListFragment4.getPageNum() + 1);
                                OrderManager orderManager = OrderManager.f20130oIX0oI;
                                String orderType = IntegralOrderListFragment.this.getOrderType();
                                int pageNum = IntegralOrderListFragment.this.getPageNum();
                                final IntegralOrderListFragment integralOrderListFragment5 = IntegralOrderListFragment.this;
                                orderManager.xxIXOIIO(orderType, pageNum, new oOoXoXO<AccountOrderData, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment.setAdapter.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(AccountOrderData accountOrderData) {
                                        invoke2(accountOrderData);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.oOoXoXO AccountOrderData accountOrderData) {
                                        if (accountOrderData != null && accountOrderData.getContent() != null && !accountOrderData.getContent().isEmpty()) {
                                            IntegralOrderListFragment.this.findData(renderAdapter2, accountOrderData.getContent());
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
                DslAdapter.render$default(renderAdapter, false, null, new oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment$setAdapter$1.3
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
        SwipeMenuHelper.Companion.oIX0oI((RecyclerView) getDslViewHolder().v(recyclerViewId()));
    }

    public final void setItemOrderNum(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.itemOrderNum = str;
    }
}
