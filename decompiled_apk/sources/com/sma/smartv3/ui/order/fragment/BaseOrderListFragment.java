package com.sma.smartv3.ui.order.fragment;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AccountOrderData;
import com.sma.smartv3.model.OrderContentData;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBaseOrderListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseOrderListFragment.kt\ncom/sma/smartv3/ui/order/fragment/BaseOrderListFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,166:1\n90#2:167\n*S KotlinDebug\n*F\n+ 1 BaseOrderListFragment.kt\ncom/sma/smartv3/ui/order/fragment/BaseOrderListFragment\n*L\n138#1:167\n*E\n"})
/* loaded from: classes11.dex */
public class BaseOrderListFragment extends BaseRecyclerRecordsFragment<OrderContentData> {
    private boolean isNeedPayDialog;

    @oOoXoXO
    private XoI0Ixx0 mConfirmPopup;

    @oOoXoXO
    private XoI0Ixx0 mDeletePopup;

    @OOXIXo
    private final List<OrderContentData> mList;

    @OOXIXo
    private final TimePeriod mTimePeriod = TimePeriod.DAY;

    @OOXIXo
    private String orderNum;

    @OOXIXo
    private String orderType;
    private int pageNum;

    public BaseOrderListFragment() {
        setInitUpdate(false);
        this.pageNum = 1;
        this.orderType = "";
        this.orderNum = "";
        this.mList = new ArrayList();
    }

    public final void deleteOrder(@OOXIXo String orderId) {
        IIX0o.x0xO0oo(orderId, "orderId");
        OrderManager.f20130oIX0oI.I0Io(orderId, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.BaseOrderListFragment$deleteOrder$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                ToastUtils.showLong(z ? R.string.success_save : R.string.fail);
            }
        });
    }

    public final void deleteRecord(int i) {
        if (!this.mList.isEmpty() && this.mList.size() > i + 1) {
            this.mList.remove(i);
        }
    }

    @oOoXoXO
    public final XoI0Ixx0 getMDeletePopup() {
        return this.mDeletePopup;
    }

    @OOXIXo
    public final List<OrderContentData> getMList() {
        return this.mList;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }

    public void getOrderList() {
    }

    public final void getOrderStatus() {
        OrderManager.f20130oIX0oI.IXxxXO(this.orderNum, this.orderType, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.order.fragment.BaseOrderListFragment$getOrderStatus$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                if (z) {
                    BaseOrderListFragment.this.setPageNum(1);
                    BaseOrderListFragment.this.getOrderList();
                } else {
                    ToastUtils.showLong(R.string.pay_confirm_error);
                }
            }
        });
    }

    @OOXIXo
    public final String getOrderType() {
        return this.orderType;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @OOXIXo
    public final List<OrderContentData> initList() {
        List arrayList;
        List<OrderContentData> content;
        List o0Xo0XII;
        this.mList.clear();
        List<OrderContentData> list = this.mList;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String str = com.sma.smartv3.util.XoI0Ixx0.f24440oI + this.orderType;
        AccountOrderData accountOrderData = (AccountOrderData) new Gson().fromJson(XO2.getString(str + '_' + AccountOrderData.class.getName()), AccountOrderData.class);
        if (accountOrderData != null && (content = accountOrderData.getContent()) != null && (o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(content)) != null) {
            arrayList = o0Xo0XII;
        } else {
            arrayList = new ArrayList<>();
        }
        list.addAll(arrayList);
        return this.mList;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        initList();
        getOrderList();
        super.initView();
    }

    public final boolean isNeedPayDialog() {
        return this.isNeedPayDialog;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_order_dial;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OOXIXo List<OrderContentData> data) {
        IIX0o.x0xO0oo(data, "data");
        getDslAdapter().clearAllItems();
        onInitBaseLayoutAfter();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        setAdapter();
    }

    @XO0.XO(tag = x0xO0oo.f24583O0)
    public final void onOrderPayStatusChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        this.isNeedPayDialog = false;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onOrderPayStatusChange");
        getOrderList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyDataChanged();
        if (this.isNeedPayDialog) {
            this.pageNum = 1;
            this.isNeedPayDialog = false;
            getOrderList();
        }
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OOXIXo
    public List<OrderContentData> onTimePeriodChange(@OOXIXo Calendar calendar, int i, @OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        LogUtils.d("onTimePeriodChange");
        return initList();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public int recyclerViewId() {
        return R.id.recycler_view;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseRecyclerRecordsFragment
    public int refreshLayoutId() {
        return 0;
    }

    public void setAdapter() {
    }

    public final void setMDeletePopup(@oOoXoXO XoI0Ixx0 xoI0Ixx0) {
        this.mDeletePopup = xoI0Ixx0;
    }

    public final void setNeedPayDialog(boolean z) {
        this.isNeedPayDialog = z;
    }

    public final void setOrderType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderType = str;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final void showConfirm(@OOXIXo String ordernum) {
        IIX0o.x0xO0oo(ordernum, "ordernum");
        this.orderNum = ordernum;
        if (this.mConfirmPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.IoOoX(R.string.guide_warm_title);
            xoI0Ixx0.xI(Integer.valueOf(R.string.pay_completed_tip));
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.yes_payment_go, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.order.fragment.BaseOrderListFragment$showConfirm$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OOXIXo
                public final Boolean invoke() {
                    String str;
                    String str2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("OrderList orderType = ");
                    sb.append(BaseOrderListFragment.this.getOrderType());
                    sb.append(" orderNum = ");
                    str = BaseOrderListFragment.this.orderNum;
                    sb.append(str);
                    LogUtils.d(sb.toString());
                    BaseOrderListFragment.this.setNeedPayDialog(true);
                    BaseOrderListFragment baseOrderListFragment = BaseOrderListFragment.this;
                    OrderManager orderManager = OrderManager.f20130oIX0oI;
                    str2 = baseOrderListFragment.orderNum;
                    String Oo2 = OrderManager.Oo(orderManager, str2, BaseOrderListFragment.this.getOrderType(), null, 4, null);
                    Bundle bundle = new Bundle();
                    bundle.putString("mArg0", Oo2);
                    bundle.putInt("mArg1", 2);
                    bundle.putParcelable("mArg2", null);
                    bundle.putSerializable("mArg3", null);
                    Intent intent = new Intent(baseOrderListFragment.getActivity(), (Class<?>) GoogleWebViewActivity.class);
                    intent.putExtras(bundle);
                    baseOrderListFragment.startActivity(intent);
                    return Boolean.TRUE;
                }
            });
            this.mConfirmPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mConfirmPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }
}
