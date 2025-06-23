package com.sma.smartv3.ui.device.dialpay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.OnlineWatchFaceKt;
import com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineMoveFragment;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DialMoveActivity extends BaseFragmentPagerActivity {
    private boolean isShowAiKeyPop;
    private final boolean isShowCustom;
    private PayOnlineMoveFragment onlineFragment;

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.dialpay.DialMoveActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) DialMoveActivity.this.findViewById(R.id.table);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dialpay.DialMoveActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) DialMoveActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TabLayout.OnTabSelectedListener {
        public oIX0oI() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@oOoXoXO TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@oOoXoXO TabLayout.Tab tab) {
            CharSequence charSequence;
            if (tab != null) {
                charSequence = tab.getText();
            } else {
                charSequence = null;
            }
            if (IIX0o.Oxx0IOOO(charSequence, DialMoveActivity.this.getString(R.string.aigc)) && !DialMoveActivity.this.isShowAiKeyPop) {
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.oO0OX0() && !productManager.OOIXx0x() && TextUtils.isEmpty(productManager.I0Io())) {
                    UtilsKt.XOxIOxOx(DialMoveActivity.this.getMContext());
                    DialMoveActivity.this.isShowAiKeyPop = true;
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@oOoXoXO TabLayout.Tab tab) {
        }
    }

    public DialMoveActivity() {
        boolean z;
        if (ProductManager.f20544oIX0oI.OOXIxO0() && getMArg1() == -1) {
            z = true;
        } else {
            z = false;
        }
        this.isShowCustom = z;
    }

    private final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        PayOnlineMoveFragment payOnlineMoveFragment = new PayOnlineMoveFragment();
        this.onlineFragment = payOnlineMoveFragment;
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", getMArg0());
        payOnlineMoveFragment.setArguments(bundle2);
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OOXIXo
    public List<Fragment> initFragments() {
        LogUtils.d("initFragments type = " + getMArg1());
        PayOnlineMoveFragment payOnlineMoveFragment = null;
        if (this.isShowCustom) {
            ArrayList arrayList = new ArrayList();
            PayOnlineMoveFragment payOnlineMoveFragment2 = this.onlineFragment;
            if (payOnlineMoveFragment2 == null) {
                IIX0o.XOxIOxOx("onlineFragment");
            } else {
                payOnlineMoveFragment = payOnlineMoveFragment2;
            }
            arrayList.add(payOnlineMoveFragment);
            return arrayList;
        }
        PayOnlineMoveFragment payOnlineMoveFragment3 = this.onlineFragment;
        if (payOnlineMoveFragment3 == null) {
            IIX0o.XOxIOxOx("onlineFragment");
        } else {
            payOnlineMoveFragment = payOnlineMoveFragment3;
        }
        return oI0IIXIo.OOXIXo(payOnlineMoveFragment);
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String mArg0;
        super.initView();
        BleInitializer bleInitializer = BleInitializer.f20700XO;
        bleInitializer.xx0X0(true);
        bleInitializer.IXO(false);
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getMFragmentPagerAdapter().setTitles(new String[]{getString(R.string.dial_online)});
        if (getMArg0() != null && ((mArg0 = getMArg0()) == null || mArg0.length() != 0)) {
            getAbhTitleCenter().setText(getMArg0());
        } else {
            getAbhTitleCenter().setText(getString(OnlineWatchFaceKt.getWatchFaceCategoryName(this, getMArg1())));
        }
        getTable().setupWithViewPager(getMViewPager());
        getTable().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_status_info_v2;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PayOnlineMoveFragment payOnlineMoveFragment = this.onlineFragment;
        if (payOnlineMoveFragment == null) {
            IIX0o.XOxIOxOx("onlineFragment");
            payOnlineMoveFragment = null;
        }
        if (payOnlineMoveFragment.isSync()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleInitializer bleInitializer = BleInitializer.f20700XO;
        bleInitializer.xx0X0(false);
        bleInitializer.IXO(false);
        super.onDestroy();
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        PayOnlineMoveFragment payOnlineMoveFragment = this.onlineFragment;
        if (payOnlineMoveFragment == null) {
            IIX0o.XOxIOxOx("onlineFragment");
            payOnlineMoveFragment = null;
        }
        if (payOnlineMoveFragment.isSync()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }
}
