package com.sma.smartv3.ui.device.dial;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.OnlineWatchFaceKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public final class DialActivity extends BaseFragmentPagerActivity {
    private AIGCFragment aigcFragment;
    private DialCustomizeFragment customizeFragment;
    private DialRecordingFragment dialRecordingFragment;
    private boolean isShowAiKeyPop;
    private final boolean isShowCustom;
    private DialOnlineFragment onlineFragment;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.dial.DialActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) DialActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dial.DialActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) DialActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TabLayout.OnTabSelectedListener {
        public oIX0oI() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@OXOo.oOoXoXO TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@OXOo.oOoXoXO TabLayout.Tab tab) {
            CharSequence charSequence;
            if (tab != null) {
                charSequence = tab.getText();
            } else {
                charSequence = null;
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(charSequence, DialActivity.this.getString(R.string.aigc)) && !DialActivity.this.isShowAiKeyPop) {
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.oO0OX0() && !productManager.OOIXx0x() && TextUtils.isEmpty(productManager.I0Io())) {
                    UtilsKt.XOxIOxOx(DialActivity.this.getMContext());
                    DialActivity.this.isShowAiKeyPop = true;
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@OXOo.oOoXoXO TabLayout.Tab tab) {
        }
    }

    public DialActivity() {
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
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        this.onlineFragment = new DialOnlineFragment();
        this.customizeFragment = new DialCustomizeFragment();
        this.aigcFragment = new AIGCFragment();
        this.dialRecordingFragment = new DialRecordingFragment();
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        LogUtils.d("initFragments type = " + getMArg1());
        Object obj = null;
        if (this.isShowCustom) {
            ArrayList arrayList = new ArrayList();
            DialOnlineFragment dialOnlineFragment = this.onlineFragment;
            if (dialOnlineFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("onlineFragment");
                dialOnlineFragment = null;
            }
            arrayList.add(dialOnlineFragment);
            if (ProductManager.f20544oIX0oI.xoX()) {
                AIGCFragment aIGCFragment = this.aigcFragment;
                if (aIGCFragment == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("aigcFragment");
                    aIGCFragment = null;
                }
                arrayList.add(aIGCFragment);
            }
            DialCustomizeFragment dialCustomizeFragment = this.customizeFragment;
            if (dialCustomizeFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("customizeFragment");
                dialCustomizeFragment = null;
            }
            arrayList.add(dialCustomizeFragment);
            DialRecordingFragment dialRecordingFragment = this.dialRecordingFragment;
            if (dialRecordingFragment == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("dialRecordingFragment");
            } else {
                obj = dialRecordingFragment;
            }
            arrayList.add(obj);
            return arrayList;
        }
        DialOnlineFragment dialOnlineFragment2 = this.onlineFragment;
        if (dialOnlineFragment2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("onlineFragment");
        } else {
            obj = dialOnlineFragment2;
        }
        return kotlin.collections.oI0IIXIo.OOXIXo(obj);
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String[] strArr;
        String mArg0;
        super.initView();
        BleInitializer bleInitializer = BleInitializer.f20700XO;
        bleInitializer.xx0X0(true);
        int i = 0;
        bleInitializer.IXO(false);
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        BaseFragmentPagerAdapter mFragmentPagerAdapter = getMFragmentPagerAdapter();
        if (ProductManager.f20544oIX0oI.xoX()) {
            strArr = new String[]{getString(R.string.dial_online), getString(R.string.aigc), getString(R.string.dial_customize), getString(R.string.history_record)};
        } else {
            strArr = new String[]{getString(R.string.dial_online), getString(R.string.dial_customize), getString(R.string.history_record)};
        }
        mFragmentPagerAdapter.setTitles(strArr);
        if (getMArg0() != null && ((mArg0 = getMArg0()) == null || mArg0.length() != 0)) {
            getAbhTitleCenter().setText(getMArg0());
        } else {
            getAbhTitleCenter().setText(getString(OnlineWatchFaceKt.getWatchFaceCategoryName(this, getMArg1())));
        }
        getTable().setupWithViewPager(getMViewPager());
        TabLayout table = getTable();
        if (!this.isShowCustom) {
            i = 8;
        }
        table.setVisibility(i);
        getTable().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_status_info;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DialOnlineFragment dialOnlineFragment = this.onlineFragment;
        if (dialOnlineFragment == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("onlineFragment");
            dialOnlineFragment = null;
        }
        if (dialOnlineFragment.isSync()) {
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

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        DialOnlineFragment dialOnlineFragment = this.onlineFragment;
        if (dialOnlineFragment == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("onlineFragment");
            dialOnlineFragment = null;
        }
        if (dialOnlineFragment.isSync()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }
}
