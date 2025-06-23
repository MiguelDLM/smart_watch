package com.sma.smartv3.ui.device.watchface;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import com.sma.smartv3.ui.device.dial.AIGCFragment;
import com.sma.smartv3.ui.device.dial.DialCustomizeFragment;
import com.sma.smartv3.ui.device.dial.DialRecordingFragment;
import com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WatchFaceActivity extends BaseFragmentPagerActivity {
    private AIGCFragment aigcFragment;
    private DialCustomizeFragment customizeFragment;
    private DialRecordingFragment dialRecordingFragment;
    private boolean isShowAiKeyPop;
    private final boolean isShowCustom;
    private OnlineWatchFaceFragment onlineFragment;

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) WatchFaceActivity.this.findViewById(R.id.table);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.watchface.WatchFaceActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WatchFaceActivity.this.findViewById(R.id.abh_title_center);
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
            if (IIX0o.Oxx0IOOO(charSequence, WatchFaceActivity.this.getString(R.string.aigc)) && !WatchFaceActivity.this.isShowAiKeyPop) {
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.oO0OX0() && !productManager.OOIXx0x() && TextUtils.isEmpty(productManager.I0Io())) {
                    UtilsKt.XOxIOxOx(WatchFaceActivity.this.getMContext());
                    WatchFaceActivity.this.isShowAiKeyPop = true;
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@oOoXoXO TabLayout.Tab tab) {
        }
    }

    public WatchFaceActivity() {
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

    private final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        this.onlineFragment = new OnlineWatchFaceFragment();
        this.customizeFragment = new DialCustomizeFragment();
        this.aigcFragment = new AIGCFragment();
        this.dialRecordingFragment = new DialRecordingFragment();
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OOXIXo
    public List<Fragment> initFragments() {
        LogUtils.d("initFragments type = " + getMArg1());
        Object obj = null;
        if (this.isShowCustom) {
            ArrayList arrayList = new ArrayList();
            OnlineWatchFaceFragment onlineWatchFaceFragment = this.onlineFragment;
            if (onlineWatchFaceFragment == null) {
                IIX0o.XOxIOxOx("onlineFragment");
                onlineWatchFaceFragment = null;
            }
            arrayList.add(onlineWatchFaceFragment);
            if (ProductManager.f20544oIX0oI.xoX()) {
                AIGCFragment aIGCFragment = this.aigcFragment;
                if (aIGCFragment == null) {
                    IIX0o.XOxIOxOx("aigcFragment");
                    aIGCFragment = null;
                }
                arrayList.add(aIGCFragment);
            }
            DialCustomizeFragment dialCustomizeFragment = this.customizeFragment;
            if (dialCustomizeFragment == null) {
                IIX0o.XOxIOxOx("customizeFragment");
                dialCustomizeFragment = null;
            }
            arrayList.add(dialCustomizeFragment);
            DialRecordingFragment dialRecordingFragment = this.dialRecordingFragment;
            if (dialRecordingFragment == null) {
                IIX0o.XOxIOxOx("dialRecordingFragment");
            } else {
                obj = dialRecordingFragment;
            }
            arrayList.add(obj);
            return arrayList;
        }
        OnlineWatchFaceFragment onlineWatchFaceFragment2 = this.onlineFragment;
        if (onlineWatchFaceFragment2 == null) {
            IIX0o.XOxIOxOx("onlineFragment");
        } else {
            obj = onlineWatchFaceFragment2;
        }
        return oI0IIXIo.OOXIXo(obj);
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String[] strArr;
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
        getAbhTitleCenter().setText(getString(OnlineWatchFaceKt.getWatchFaceCategoryName(this, getMArg1())));
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
        OnlineWatchFaceFragment onlineWatchFaceFragment = this.onlineFragment;
        if (onlineWatchFaceFragment == null) {
            IIX0o.XOxIOxOx("onlineFragment");
            onlineWatchFaceFragment = null;
        }
        if (!onlineWatchFaceFragment.isSync() && !BleInitializer.f20700XO.xX0IIXIx0()) {
            super.onBackPressed();
        } else {
            ToastUtils.showLong(R.string.syncing);
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
        OnlineWatchFaceFragment onlineWatchFaceFragment = this.onlineFragment;
        if (onlineWatchFaceFragment == null) {
            IIX0o.XOxIOxOx("onlineFragment");
            onlineWatchFaceFragment = null;
        }
        if (!onlineWatchFaceFragment.isSync() && !BleInitializer.f20700XO.xX0IIXIx0()) {
            finish();
        } else {
            ToastUtils.showLong(R.string.syncing);
        }
    }
}
