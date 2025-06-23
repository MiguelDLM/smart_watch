package com.sma.smartv3.ui.device.dialpay.fragment;

import Oox.Oxx0xo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragmentKt;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.WatchFaceManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import com.sma.smartv3.model.WatchFaceBanner;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.ui.device.dial.DialPickerPopup;
import com.sma.smartv3.ui.device.dialpay.DialMoveActivity;
import com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity;
import com.sma.smartv3.ui.device.dialpay.item.BannerItem;
import com.sma.smartv3.ui.device.dialpay.item.DialClassItem;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.ProgressButtonV2;
import com.sma.smartv3.view.SquareImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPayOnlineWatchFaceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayOnlineWatchFaceFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayOnlineWatchFaceFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n50#2,3:213\n53#2:219\n55#2,2:221\n1549#3:216\n1620#3,2:217\n1622#3:220\n*S KotlinDebug\n*F\n+ 1 PayOnlineWatchFaceFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayOnlineWatchFaceFragment\n*L\n63#1:213,3\n63#1:219\n63#1:221,2\n63#1:216\n63#1:217,2\n63#1:220\n*E\n"})
/* loaded from: classes12.dex */
public final class PayOnlineWatchFaceFragment extends BaseDSLRecyclerFragment {

    @OXOo.oOoXoXO
    private DialPickerPopup dialPickerPopup;

    @OXOo.OOXIXo
    private List<WatchFaceBanner> mBannerList;

    @OXOo.oOoXoXO
    private List<OnlineWatchFaceV2> mWatchFaceList;

    @OXOo.OOXIXo
    private final String TAG = "PayOnlineWatchFaceFragment";

    @OXOo.OOXIXo
    private final X0IIOO emptyView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$emptyView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PayOnlineWatchFaceFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.empty_view);
        }
    });

    public PayOnlineWatchFaceFragment() {
        Collection ooXIXxIX2;
        try {
            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24424XX0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), WatchFaceBanner.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.mBannerList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findData(List<OnlineWatchFaceV2> list) {
        Boolean bool;
        boolean z;
        DslAdapterExKt.x0xO0oo(getDslAdapter(), new BannerItem(this.mBannerList), new Oox.oOoXoXO<BannerItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BannerItem bannerItem) {
                invoke2(bannerItem);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BannerItem dslItem) {
                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                dslItem.setItemSpanCount(-1);
            }
        });
        DslAdapterExKt.x0xO0oo(getDslAdapter(), new DialClassItem(list), new Oox.oOoXoXO<DialClassItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$2
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DialClassItem dialClassItem) {
                invoke2(dialClassItem);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DialClassItem dslItem) {
                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                dslItem.setItemSpanCount(-1);
            }
        });
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " listSize = " + list.size());
        for (final OnlineWatchFaceV2 onlineWatchFaceV2 : list) {
            WatchFaceCategoryV2[] watchFaceList = onlineWatchFaceV2.getWatchFaceList();
            if (watchFaceList != null) {
                if (watchFaceList.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                bool = Boolean.valueOf(!z);
            } else {
                bool = null;
            }
            IIX0o.ooOOo0oXI(bool);
            if (bool.booleanValue()) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.layout_online_watchface_category_head, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$3
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
                        dslItem.setItemIsGroupHead(true);
                        dslItem.setItemIsHover(false);
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(OnlineWatchFaceV2.this.getTypeName()));
                        final OnlineWatchFaceV2 onlineWatchFaceV22 = OnlineWatchFaceV2.this;
                        dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$3.1
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
                                TextView tv = itemHolder.tv(R.id.tv_name);
                                if (tv != null) {
                                    tv.setText(OnlineWatchFaceV2.this.getTypeName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.watchface_more_tv);
                                if (tv2 == null) {
                                    return;
                                }
                                tv2.setVisibility(4);
                            }
                        });
                        dslItem.setItemTag(OnlineWatchFaceV2.this.getTypeName());
                        final OnlineWatchFaceV2 onlineWatchFaceV23 = OnlineWatchFaceV2.this;
                        final PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = this;
                        dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$3.2
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
                                Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24485xXOx + '_' + WatchFaceCategoryV2[].class.getName(), new Gson().toJson(ArraysKt___ArraysKt.XOXXox0(OnlineWatchFaceV2.this.getWatchFaceList()).toArray(new WatchFaceCategoryV2[0])));
                                int parseInt = Integer.parseInt(OnlineWatchFaceV2.this.getTypeId());
                                String typeName = OnlineWatchFaceV2.this.getTypeName();
                                PayOnlineWatchFaceFragment payOnlineWatchFaceFragment2 = payOnlineWatchFaceFragment;
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", typeName);
                                bundle.putInt("mArg1", parseInt);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", null);
                                Intent intent = new Intent(payOnlineWatchFaceFragment2.getActivity(), (Class<?>) DialMoveActivity.class);
                                intent.putExtras(bundle);
                                payOnlineWatchFaceFragment2.startActivity(intent);
                            }
                        });
                    }
                });
            }
            for (final WatchFaceCategoryV2 watchFaceCategoryV2 : ArraysKt___ArraysKt.X0ooIIO(onlineWatchFaceV2.getWatchFaceList(), 6)) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_dial_f3_v2, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$4
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
                        dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(OnlineWatchFaceV2.this.getTypeName()));
                        final WatchFaceCategoryV2 watchFaceCategoryV22 = watchFaceCategoryV2;
                        final PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = this;
                        dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                IIX0o.x0xO0oo(payloads, "payloads");
                                View v = itemHolder.v(R.id.pb);
                                IIX0o.ooOOo0oXI(v);
                                ProgressButtonV2 progressButtonV2 = (ProgressButtonV2) v;
                                View v2 = itemHolder.v(R.id.iv);
                                IIX0o.ooOOo0oXI(v2);
                                SquareImageView squareImageView = (SquareImageView) v2;
                                View v3 = itemHolder.v(R.id.item_dial_new_ll);
                                if (v3 != null) {
                                    v3.setVisibility((WatchFaceCategoryV2.this.getNewFlag() && ProjectManager.f19822oIX0oI.IxIX0I()) ? 0 : 8);
                                }
                                Glide.with(payOnlineWatchFaceFragment.requireContext()).load(WatchFaceCategoryV2.this.getPreviewUrl()).into(squareImageView);
                                com.sma.smartv3.ui.device.dialpay.oIX0oI.XO(progressButtonV2, WatchFaceCategoryV2.this.getDollar(), WatchFaceCategoryV2.this.getAmount(), WatchFaceCategoryV2.this.getDollarDis(), WatchFaceCategoryV2.this.getAmountDis(), WatchFaceCategoryV2.this.getLimitFreeFlag(), WatchFaceCategoryV2.this.getMemberAttr(), WatchFaceCategoryV2.this.getPayStatus());
                            }
                        });
                        final PayOnlineWatchFaceFragment payOnlineWatchFaceFragment2 = this;
                        final WatchFaceCategoryV2 watchFaceCategoryV23 = watchFaceCategoryV2;
                        dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$findData$4.2
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
                                PayOnlineWatchFaceFragment payOnlineWatchFaceFragment3 = PayOnlineWatchFaceFragment.this;
                                String previewUrl = watchFaceCategoryV23.getPreviewUrl();
                                int id = watchFaceCategoryV23.getId();
                                WatchFaceCategoryV2 watchFaceCategoryV24 = watchFaceCategoryV23;
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", previewUrl);
                                bundle.putInt("mArg1", id);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", watchFaceCategoryV24);
                                Intent intent = new Intent(payOnlineWatchFaceFragment3.getActivity(), (Class<?>) WatchFaceDialPayDetailActivity.class);
                                intent.putExtras(bundle);
                                payOnlineWatchFaceFragment3.startActivity(intent);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getEmptyView() {
        return (TextView) this.emptyView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$initData$1
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
                DslViewHolder dslViewHolder = PayOnlineWatchFaceFragment.this.getDslViewHolder();
                final PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = PayOnlineWatchFaceFragment.this;
                dslViewHolder.postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$initData$1.1
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
                        final PayOnlineWatchFaceFragment payOnlineWatchFaceFragment2 = PayOnlineWatchFaceFragment.this;
                        payOnlineWatchFaceFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.initData.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
                            
                                r7 = r1.mWatchFaceList;
                             */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke2(@OXOo.OOXIXo com.angcyo.dsladapter.DslAdapter r7) {
                                /*
                                    r6 = this;
                                    java.lang.String r0 = "$this$renderAdapter"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                                    r0 = 2
                                    r1 = 0
                                    r2 = 0
                                    com.angcyo.dsladapter.DslAdapter.setAdapterStatus$default(r7, r1, r2, r0, r2)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    java.util.List r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                    r0 = 8
                                    if (r7 == 0) goto Lbb
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    java.util.List r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                    if (r7 == 0) goto L25
                                    int r7 = r7.size()
                                    if (r7 != 0) goto L25
                                    goto Lbb
                                L25:
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    java.util.List r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                    r3 = 1
                                    if (r7 == 0) goto L68
                                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                                    java.util.ArrayList r4 = new java.util.ArrayList
                                    r5 = 10
                                    int r5 = kotlin.collections.OxxIIOOXO.xo0x(r7, r5)
                                    r4.<init>(r5)
                                    java.util.Iterator r7 = r7.iterator()
                                L3f:
                                    boolean r5 = r7.hasNext()
                                    if (r5 == 0) goto L68
                                    java.lang.Object r5 = r7.next()
                                    com.sma.smartv3.model.OnlineWatchFaceV2 r5 = (com.sma.smartv3.model.OnlineWatchFaceV2) r5
                                    com.sma.smartv3.model.WatchFaceCategoryV2[] r5 = r5.getWatchFaceList()
                                    if (r5 == 0) goto L57
                                    int r5 = r5.length
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                    goto L58
                                L57:
                                    r5 = r2
                                L58:
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r5)
                                    int r5 = r5.intValue()
                                    if (r5 <= 0) goto L62
                                    r3 = 0
                                L62:
                                    kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                                    r4.add(r5)
                                    goto L3f
                                L68:
                                    if (r3 == 0) goto L7d
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                    r7.setVisibility(r0)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    android.widget.TextView r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getEmptyView(r7)
                                    r7.setVisibility(r1)
                                    goto L9b
                                L7d:
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                    r7.setVisibility(r1)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    android.widget.TextView r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getEmptyView(r7)
                                    r7.setVisibility(r0)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    java.util.List r0 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$findData(r7, r0)
                                L9b:
                                    OI0.oIX0oI r7 = OI0.oIX0oI.f1507oIX0oI
                                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                    r0.<init>()
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r1 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    java.lang.String r1 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getTAG$p(r1)
                                    r0.append(r1)
                                    java.lang.String r1 = " isEmptyData = "
                                    r0.append(r1)
                                    r0.append(r3)
                                    java.lang.String r0 = r0.toString()
                                    r7.oIX0oI(r0)
                                    goto Lcd
                                Lbb:
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                    r7.setVisibility(r0)
                                    com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.this
                                    android.widget.TextView r7 = com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment.access$getEmptyView(r7)
                                    r7.setVisibility(r1)
                                Lcd:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$initData$1.AnonymousClass1.C09601.invoke2(com.angcyo.dsladapter.DslAdapter):void");
                            }
                        });
                    }
                });
            }
        });
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    @OXOo.OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        setAdapterStatus(new AdapterStatusItem());
        return getAdapterStatus();
    }

    public final void getWatchFaceList() {
        WatchFaceManager.I0Io(WatchFaceManager.f20245oIX0oI, false, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$getWatchFaceList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                Collection ooXIXxIX2;
                if (z) {
                    PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = PayOnlineWatchFaceFragment.this;
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24362IIxOXoOo0)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), OnlineWatchFaceV2.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    payOnlineWatchFaceFragment.mWatchFaceList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                }
                PayOnlineWatchFaceFragment.this.initData();
            }
        }, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_online_watchface_2;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24667xx0X0)
    public final void onChangedData(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        getDslAdapter().clearAllItems();
        getWatchFaceList();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getMActivity(), 3);
        getRecyclerView().setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(BaseDSLRecyclerFragmentKt.II0xO0(gridLayoutManager, getDslAdapter()));
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$onInitBaseLayoutAfter$2
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
            }
        });
        getWatchFaceList();
        WatchFaceManager.f20245oIX0oI.XO(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment$onInitBaseLayoutAfter$3
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                Collection ooXIXxIX2;
                PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = PayOnlineWatchFaceFragment.this;
                try {
                    JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24424XX0)).getAsJsonArray();
                    IIX0o.ooOOo0oXI(asJsonArray);
                    ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        ooXIXxIX2.add(new Gson().fromJson(it.next(), WatchFaceBanner.class));
                    }
                } catch (Exception unused) {
                    ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                payOnlineWatchFaceFragment.mBannerList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                PayOnlineWatchFaceFragment.this.getDslAdapter().notifyItemChanged(0);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyDataChanged();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.recycler_view;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }
}
