package com.sma.smartv3.ui.order;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.order.fragment.DialOrderListFragment;
import com.sma.smartv3.ui.order.fragment.GameOrderListFragment;
import com.sma.smartv3.ui.order.fragment.IntegralOrderListFragment;
import com.sma.smartv3.ui.order.fragment.MemberOrderListFragment;
import com.sma.smartv3.ui.status.base.BaseDetailsFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import oIxOXo.oxoX;

@XX({"SMAP\nOrderDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrderDetailActivity.kt\ncom/sma/smartv3/ui/order/OrderDetailActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,86:1\n37#2,2:87\n*S KotlinDebug\n*F\n+ 1 OrderDetailActivity.kt\ncom/sma/smartv3/ui/order/OrderDetailActivity\n*L\n74#1:87,2\n*E\n"})
/* loaded from: classes11.dex */
public final class OrderDetailActivity extends BaseFragmentPagerActivity {

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.order.OrderDetailActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) OrderDetailActivity.this.findViewById(R.id.table);
        }
    });

    private final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OOXIXo
    public List<Fragment> initFragments() {
        BaseDetailsFragment integralOrderListFragment;
        ArrayList arrayList = new ArrayList();
        if (!ProductManager.f20544oIX0oI.Xo()) {
            arrayList.add(new DialOrderListFragment());
        }
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.I0()) {
            if (projectManager.oIIxXoo()) {
                integralOrderListFragment = new MemberOrderListFragment();
            } else {
                integralOrderListFragment = new IntegralOrderListFragment();
            }
            arrayList.add(integralOrderListFragment);
        }
        if (projectManager.IoXIXo()) {
            arrayList.add(new GameOrderListFragment());
        }
        return CollectionsKt___CollectionsKt.oOo0o(arrayList);
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String string;
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.user_order);
        getTable().setBackgroundColor(oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        ArrayList arrayList = new ArrayList();
        if (!ProductManager.f20544oIX0oI.Xo()) {
            String string2 = getString(R.string.dial_order);
            IIX0o.oO(string2, "getString(...)");
            arrayList.add(string2);
        }
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (!projectManager.I0()) {
            if (projectManager.oIIxXoo()) {
                string = getString(R.string.ai_package_order);
            } else {
                string = getString(R.string.integral_order);
            }
            IIX0o.ooOOo0oXI(string);
            arrayList.add(string);
        }
        if (projectManager.IoXIXo()) {
            String string3 = getString(R.string.game_order);
            IIX0o.oO(string3, "getString(...)");
            arrayList.add(string3);
        }
        getMFragmentPagerAdapter().setTitles((CharSequence[]) arrayList.toArray(new String[0]));
        if (arrayList.size() <= 1) {
            getTable().setVisibility(8);
        }
        getTable().setupWithViewPager(getMViewPager());
        getMViewPager().setCurrentItem(1);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_order_detail;
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
