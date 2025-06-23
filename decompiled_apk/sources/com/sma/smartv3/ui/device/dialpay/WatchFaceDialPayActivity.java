package com.sma.smartv3.ui.device.dialpay;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0.XO;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.OnlineWatchFaceKt;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.ui.device.dial.DialCustomizeFragment;
import com.sma.smartv3.ui.device.dialpay.fragment.PayAIGCFragment;
import com.sma.smartv3.ui.device.dialpay.fragment.PayDialRecordingFragment;
import com.sma.smartv3.ui.device.dialpay.fragment.PayOnlineWatchFaceFragment;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWatchFaceDialPayActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceDialPayActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,180:1\n93#2,2:181\n90#2:183\n*S KotlinDebug\n*F\n+ 1 WatchFaceDialPayActivity.kt\ncom/sma/smartv3/ui/device/dialpay/WatchFaceDialPayActivity\n*L\n121#1:181,2\n121#1:183\n*E\n"})
/* loaded from: classes12.dex */
public final class WatchFaceDialPayActivity extends BaseFragmentPagerActivity {
    private PayAIGCFragment aigcFragment;
    private DialCustomizeFragment customizeFragment;
    private PayDialRecordingFragment dialRecordingFragment;
    private boolean isShowAiKeyPop;
    private final boolean isShowCustom;
    private PayOnlineWatchFaceFragment onlineFragment;

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) WatchFaceDialPayActivity.this.findViewById(R.id.table);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WatchFaceDialPayActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    public WatchFaceDialPayActivity() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(WatchFaceDialPayActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showAILackingTip();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        this.onlineFragment = new PayOnlineWatchFaceFragment();
        this.customizeFragment = new DialCustomizeFragment();
        this.aigcFragment = new PayAIGCFragment();
        this.dialRecordingFragment = new PayDialRecordingFragment();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OOXIXo
    public List<Fragment> initFragments() {
        LogUtils.d("initFragments type = " + getMArg1());
        Object obj = null;
        if (this.isShowCustom) {
            ArrayList arrayList = new ArrayList();
            PayOnlineWatchFaceFragment payOnlineWatchFaceFragment = this.onlineFragment;
            if (payOnlineWatchFaceFragment == null) {
                IIX0o.XOxIOxOx("onlineFragment");
                payOnlineWatchFaceFragment = null;
            }
            arrayList.add(payOnlineWatchFaceFragment);
            if (ProductManager.f20544oIX0oI.xoX()) {
                PayAIGCFragment payAIGCFragment = this.aigcFragment;
                if (payAIGCFragment == null) {
                    IIX0o.XOxIOxOx("aigcFragment");
                    payAIGCFragment = null;
                }
                arrayList.add(payAIGCFragment);
            }
            DialCustomizeFragment dialCustomizeFragment = this.customizeFragment;
            if (dialCustomizeFragment == null) {
                IIX0o.XOxIOxOx("customizeFragment");
                dialCustomizeFragment = null;
            }
            arrayList.add(dialCustomizeFragment);
            PayDialRecordingFragment payDialRecordingFragment = this.dialRecordingFragment;
            if (payDialRecordingFragment == null) {
                IIX0o.XOxIOxOx("dialRecordingFragment");
            } else {
                obj = payDialRecordingFragment;
            }
            arrayList.add(obj);
            return arrayList;
        }
        PayOnlineWatchFaceFragment payOnlineWatchFaceFragment2 = this.onlineFragment;
        if (payOnlineWatchFaceFragment2 == null) {
            IIX0o.XOxIOxOx("onlineFragment");
        } else {
            obj = payOnlineWatchFaceFragment2;
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.dialpay.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                WatchFaceDialPayActivity.initView$lambda$0(WatchFaceDialPayActivity.this);
            }
        }, 1800L);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_status_info;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (BleInitializer.f20700XO.xX0IIXIx0()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            super.onBackPressed();
        }
    }

    @XO(tag = x0xO0oo.f24643oxIIX0o)
    public final void onChangedIndex(int i) {
        if (getMViewPager().getChildCount() > i && getMViewPager().getCurrentItem() != i) {
            getMViewPager().setCurrentItem(i);
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
        if (BleInitializer.f20700XO.xX0IIXIx0()) {
            ToastUtils.showLong(R.string.syncing);
        } else {
            finish();
        }
    }

    public final void showAILackingTip() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.XooIO0oo0() && projectManager.oIIxXoo() && projectManager.OOOI() && projectManager.xOoOIoI()) {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            long j = xo0.XO().getLong(XoI0Ixx0.f24447oOoIIO0, 0L);
            SPUtils XO2 = xo0.XO();
            Object fromJson = new Gson().fromJson(XO2.getString(x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
            if (fromJson == null) {
                fromJson = UserMember.class.newInstance();
            }
            UserMember userMember = (UserMember) fromJson;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("WatchFaceDialPayActivity showAILackingTip  mIsShowTime = " + j + " mUserMember = " + userMember);
            if (userMember.getLatestDateTime() > 0) {
                OrderManager orderManager = OrderManager.f20130oIX0oI;
                if (OrderManager.X0o0xo(orderManager, userMember.getLatestDateTime(), 0, 2, null) && orderManager.XO(j, 1)) {
                    xo0.XO().put(XoI0Ixx0.f24447oOoIIO0, System.currentTimeMillis());
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                    xoI0Ixx0.IoOoX(R.string.tip);
                    xoI0Ixx0.xI(Integer.valueOf(R.string.ai_benefits_about_expire));
                    xoI0Ixx0.oo0xXOI0I(1);
                    com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayActivity$showAILackingTip$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OOXIXo
                        public final Boolean invoke() {
                            WatchFaceDialPayActivity watchFaceDialPayActivity = WatchFaceDialPayActivity.this;
                            OrderManager orderManager2 = OrderManager.f20130oIX0oI;
                            String IIX0o2 = OrderManager.IIX0o(orderManager2, null, orderManager2.XIxXXX0x0(), 1, null);
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", IIX0o2);
                            bundle.putInt("mArg1", 2);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(watchFaceDialPayActivity, (Class<?>) GoogleWebViewActivity.class);
                            intent.putExtras(bundle);
                            watchFaceDialPayActivity.startActivity(intent);
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                }
            }
        }
    }
}
