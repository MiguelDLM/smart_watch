package com.sma.smartv3.ui.device.dialpay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.WatchFaceManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.ui.device.dial.DialRecordingFragment;
import com.sma.smartv3.ui.device.dialpay.DialMoveActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPayDialRecordingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayDialRecordingFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayDialRecordingFragment\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n37#2,2:211\n37#2,2:234\n86#3,2:213\n86#3,2:236\n99#4,7:215\n106#4,3:223\n79#4,7:226\n109#4:233\n99#4,7:238\n106#4,3:246\n79#4,7:249\n109#4:256\n1#5:222\n1#5:245\n*S KotlinDebug\n*F\n+ 1 PayDialRecordingFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayDialRecordingFragment\n*L\n75#1:211,2\n79#1:234,2\n75#1:213,2\n79#1:236,2\n76#1:215,7\n76#1:223,3\n76#1:226,7\n76#1:233\n80#1:238,7\n80#1:246,3\n80#1:249,7\n80#1:256\n76#1:222\n80#1:245\n*E\n"})
/* loaded from: classes12.dex */
public final class PayDialRecordingFragment extends DialRecordingFragment {

    @OXOo.OOXIXo
    private final X0IIOO mHistoryRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mHistoryRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.purchase_history_rl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mHistoryLinearLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mHistoryLinearLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.purchase_history_ll);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mHistoryOnlineMore$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mHistoryOnlineMore$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.dial_purchase_history_more);
        }
    });

    @OXOo.OOXIXo
    private List<WatchFaceCategoryV2> mWatchFaceAllList = new ArrayList();

    @OXOo.OOXIXo
    private List<WatchFaceCategoryV2> mWatchFaceList = new ArrayList();

    @OXOo.OOXIXo
    private final X0IIOO mVipFreeRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mVipFreeRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.free_limited_time_rl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mVipFreeLinearLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mVipFreeLinearLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.free_limited_time_history_ll);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mVipFreeOnlineMore$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$mVipFreeOnlineMore$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = PayDialRecordingFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.free_limited_time_history_more);
        }
    });

    @OXOo.OOXIXo
    private List<WatchFaceCategoryV2> mVipFreeWatchFaceAllList = new ArrayList();

    @OXOo.OOXIXo
    private List<WatchFaceCategoryV2> mVipFreeWatchFaceList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getMHistoryLinearLayout() {
        return (LinearLayout) this.mHistoryLinearLayout$delegate.getValue();
    }

    private final PFMedium getMHistoryOnlineMore() {
        return (PFMedium) this.mHistoryOnlineMore$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMHistoryRecyclerView() {
        return (RecyclerView) this.mHistoryRecyclerView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getMVipFreeLinearLayout() {
        return (LinearLayout) this.mVipFreeLinearLayout$delegate.getValue();
    }

    private final PFMedium getMVipFreeOnlineMore() {
        return (PFMedium) this.mVipFreeOnlineMore$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMVipFreeRecyclerView() {
        return (RecyclerView) this.mVipFreeRecyclerView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PayDialRecordingFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24485xXOx + '_' + WatchFaceCategoryV2[].class.getName(), new Gson().toJson(CollectionsKt___CollectionsKt.OOoOoO0o(this$0.mWatchFaceAllList).toArray(new WatchFaceCategoryV2[0])));
        String string = this$0.getString(R.string.pay_synchronous_title);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", string);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) DialMoveActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PayDialRecordingFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24485xXOx + '_' + WatchFaceCategoryV2[].class.getName(), new Gson().toJson(CollectionsKt___CollectionsKt.OOoOoO0o(this$0.mVipFreeWatchFaceAllList).toArray(new WatchFaceCategoryV2[0])));
        String string = this$0.getString(R.string.free_limited_time_history_title);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", string);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) DialMoveActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    private final void recordingPayOnlineRecycler() {
    }

    private final void recordingPurchaseHistory() {
        getMHistoryRecyclerView().setLayoutManager(new GridLayoutManager(requireActivity(), getMRecyclerSpanCount()));
        WatchFaceManager.f20245oIX0oI.oOoXoXO(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$recordingPurchaseHistory$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                List list;
                List list2;
                List list3;
                LinearLayout mHistoryLinearLayout;
                List list4;
                List list5;
                RecyclerView mHistoryRecyclerView;
                List list6;
                List list7;
                List list8;
                List list9;
                List list10;
                List list11;
                Collection ooXIXxIX2;
                if (z) {
                    PayDialRecordingFragment payDialRecordingFragment = PayDialRecordingFragment.this;
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24351I0)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), WatchFaceCategoryV2.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    payDialRecordingFragment.mWatchFaceAllList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                }
                list = PayDialRecordingFragment.this.mWatchFaceAllList;
                if (list.size() > 3) {
                    list6 = PayDialRecordingFragment.this.mWatchFaceList;
                    list7 = PayDialRecordingFragment.this.mWatchFaceAllList;
                    list6.add(list7.get(0));
                    list8 = PayDialRecordingFragment.this.mWatchFaceList;
                    list9 = PayDialRecordingFragment.this.mWatchFaceAllList;
                    list8.add(list9.get(1));
                    list10 = PayDialRecordingFragment.this.mWatchFaceList;
                    list11 = PayDialRecordingFragment.this.mWatchFaceAllList;
                    list10.add(list11.get(2));
                } else {
                    list2 = PayDialRecordingFragment.this.mWatchFaceList;
                    list3 = PayDialRecordingFragment.this.mWatchFaceAllList;
                    list2.addAll(list3);
                }
                mHistoryLinearLayout = PayDialRecordingFragment.this.getMHistoryLinearLayout();
                list4 = PayDialRecordingFragment.this.mWatchFaceList;
                mHistoryLinearLayout.setVisibility(list4.size() <= 0 ? 8 : 0);
                Context context = PayDialRecordingFragment.this.getContext();
                list5 = PayDialRecordingFragment.this.mWatchFaceList;
                PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1 payDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1 = new PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1(PayDialRecordingFragment.this, context, list5);
                mHistoryRecyclerView = PayDialRecordingFragment.this.getMHistoryRecyclerView();
                mHistoryRecyclerView.setAdapter(payDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1);
                payDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1.notifyDataSetChanged();
            }
        });
    }

    private final void recordingVIPFree() {
        getMVipFreeRecyclerView().setLayoutManager(new GridLayoutManager(requireActivity(), getMRecyclerSpanCount()));
        WatchFaceManager.f20245oIX0oI.oxoX(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment$recordingVIPFree$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                List list;
                List list2;
                List list3;
                LinearLayout mVipFreeLinearLayout;
                List list4;
                List list5;
                RecyclerView mVipFreeRecyclerView;
                List list6;
                List list7;
                List list8;
                List list9;
                List list10;
                List list11;
                Collection ooXIXxIX2;
                if (z) {
                    PayDialRecordingFragment payDialRecordingFragment = PayDialRecordingFragment.this;
                    try {
                        JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24460ooOx)).getAsJsonArray();
                        IIX0o.ooOOo0oXI(asJsonArray);
                        ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            ooXIXxIX2.add(new Gson().fromJson(it.next(), WatchFaceCategoryV2.class));
                        }
                    } catch (Exception unused) {
                        ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    payDialRecordingFragment.mVipFreeWatchFaceAllList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                }
                list = PayDialRecordingFragment.this.mVipFreeWatchFaceAllList;
                if (list.size() > 3) {
                    list6 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                    list7 = PayDialRecordingFragment.this.mVipFreeWatchFaceAllList;
                    list6.add(list7.get(0));
                    list8 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                    list9 = PayDialRecordingFragment.this.mVipFreeWatchFaceAllList;
                    list8.add(list9.get(1));
                    list10 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                    list11 = PayDialRecordingFragment.this.mVipFreeWatchFaceAllList;
                    list10.add(list11.get(2));
                } else {
                    list2 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                    list3 = PayDialRecordingFragment.this.mVipFreeWatchFaceAllList;
                    list2.addAll(list3);
                }
                mVipFreeLinearLayout = PayDialRecordingFragment.this.getMVipFreeLinearLayout();
                list4 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                mVipFreeLinearLayout.setVisibility(list4.size() > 0 ? 0 : 8);
                List XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(0);
                XOxIOxOx2.set(0, Integer.valueOf(Xo0.f24349oIX0oI.II0xO0().getInt("syncId", 0)));
                Context context = PayDialRecordingFragment.this.getContext();
                list5 = PayDialRecordingFragment.this.mVipFreeWatchFaceList;
                PayDialRecordingFragment$recordingVIPFree$1$mAdapter$1 payDialRecordingFragment$recordingVIPFree$1$mAdapter$1 = new PayDialRecordingFragment$recordingVIPFree$1$mAdapter$1(PayDialRecordingFragment.this, XOxIOxOx2, context, list5);
                mVipFreeRecyclerView = PayDialRecordingFragment.this.getMVipFreeRecyclerView();
                mVipFreeRecyclerView.setAdapter(payDialRecordingFragment$recordingVIPFree$1$mAdapter$1);
                payDialRecordingFragment$recordingVIPFree$1$mAdapter$1.notifyDataSetChanged();
            }
        });
    }

    @Override // com.sma.smartv3.ui.device.dial.DialRecordingFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        recordingVIPFree();
        recordingPurchaseHistory();
        recordingPayOnlineRecycler();
        getMHistoryOnlineMore().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.xxIXOIIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayDialRecordingFragment.initView$lambda$0(PayDialRecordingFragment.this, view);
            }
        });
        getMVipFreeOnlineMore().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.xoIox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayDialRecordingFragment.initView$lambda$1(PayDialRecordingFragment.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.ui.device.dial.DialRecordingFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_dial_recording_pay;
    }

    @Override // com.sma.smartv3.ui.device.dial.DialRecordingFragment
    public void notifyData() {
        super.notifyData();
        recordingPayOnlineRecycler();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24667xx0X0)
    public final void onChangedData(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        recordingPurchaseHistory();
        recordingVIPFree();
    }
}
