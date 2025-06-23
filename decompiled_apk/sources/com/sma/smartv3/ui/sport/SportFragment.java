package com.sma.smartv3.ui.sport;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerFragment;
import com.blankj.utilcode.util.LogUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CustomConfigInfo;
import com.sma.smartv3.model.DeviceConfigInfo;
import com.sma.smartv3.ui.sport.coach.AiCoachFragment;
import com.sma.smartv3.ui.sport.course.ClimbingV2Fragment;
import com.sma.smartv3.ui.sport.course.CourseFragment;
import com.sma.smartv3.ui.sport.course.CyclingV2Fragment;
import com.sma.smartv3.ui.sport.course.IndoorV2Fragment;
import com.sma.smartv3.ui.sport.course.OutdoorV2Fragment;
import com.sma.smartv3.ui.sport.course.SwimV2Fragment;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSportFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportFragment.kt\ncom/sma/smartv3/ui/sport/SportFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,206:1\n15#2:207\n15#2:210\n37#3,2:208\n*S KotlinDebug\n*F\n+ 1 SportFragment.kt\ncom/sma/smartv3/ui/sport/SportFragment\n*L\n63#1:207\n185#1:210\n129#1:208,2\n*E\n"})
/* loaded from: classes12.dex */
public class SportFragment extends BaseFragmentPagerFragment {

    @OXOo.oOoXoXO
    private LocationManager locationManager;

    @OXOo.oOoXoXO
    private DeviceConfigInfo mDeviceConfigInfo;

    @OXOo.oOoXoXO
    private OOXIXo.oxoX proxy;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.SportFragment$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            View mView;
            mView = SportFragment.this.getMView();
            return (TabLayout) mView.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private oIX0oI listener = new oIX0oI();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements LocationListener {
        public oIX0oI() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@OXOo.OOXIXo Location location) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
            OOXIXo.oxoX oxox = SportFragment.this.proxy;
            if (oxox != null) {
                oxox.OOXIXo(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@OXOo.OOXIXo String provider) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(provider, "provider");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@OXOo.OOXIXo String provider) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(provider, "provider");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(@OXOo.oOoXoXO String str, int i, @OXOo.oOoXoXO Bundle bundle) {
        }
    }

    private final boolean getIsSupCourse() {
        String str;
        CustomConfigInfo customConfig;
        CustomConfigInfo customConfig2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("getIsSupCourse");
            DeviceConfigInfo deviceConfigInfo = this.mDeviceConfigInfo;
            String str2 = null;
            if (deviceConfigInfo != null && (customConfig2 = deviceConfigInfo.getCustomConfig()) != null) {
                str = customConfig2.getSupCourse();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(TokenParser.SP);
            LogUtils.d(sb.toString());
            DeviceConfigInfo deviceConfigInfo2 = this.mDeviceConfigInfo;
            if (deviceConfigInfo2 != null && (customConfig = deviceConfigInfo2.getCustomConfig()) != null) {
                str2 = customConfig.getSupCourse();
            }
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(str2, "1");
        } catch (Exception unused) {
            return false;
        }
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @OXOo.OOXIXo
    public String[] getTiTle() {
        String string;
        ArrayList arrayList = new ArrayList();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.xI0oxI00()) {
            arrayList.add(getString(R.string.abh_ai_coach));
        }
        arrayList.add(getString(R.string.workout9));
        arrayList.add(getString(R.string.workout8));
        arrayList.add(getString(R.string.workout10));
        if (ProductManager.f20544oIX0oI.xxxI()) {
            string = getString(R.string.workout11);
        } else {
            string = getString(R.string.workout13);
        }
        arrayList.add(string);
        if (projectManager.o0IXXIx() && getIsSupCourse()) {
            arrayList.add(getString(R.string.sport_fitness));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        this.mDeviceConfigInfo = (DeviceConfigInfo) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(DeviceConfigInfo.class.getName()), DeviceConfigInfo.class);
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        ActivityResultCaller climbingFragment;
        ActivityResultCaller climbingV2Fragment;
        ArrayList arrayList = new ArrayList();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.xI0oxI00()) {
            arrayList.add(new AiCoachFragment());
        }
        arrayList.add(new OutdoorV2Fragment());
        arrayList.add(new IndoorV2Fragment());
        arrayList.add(new CyclingV2Fragment());
        if (projectManager.o0IXXIx() && getIsSupCourse()) {
            if (ProductManager.f20544oIX0oI.xxxI()) {
                climbingV2Fragment = new SwimV2Fragment();
            } else {
                climbingV2Fragment = new ClimbingV2Fragment();
            }
            arrayList.add(climbingV2Fragment);
            arrayList.add(new CourseFragment());
        } else {
            if (ProductManager.f20544oIX0oI.xxxI()) {
                climbingFragment = new SwimFragment();
            } else {
                climbingFragment = new ClimbingFragment();
            }
            arrayList.add(climbingFragment);
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getContext(), R.color.view_page_tablayout_bg));
        TabLayout table = getTable();
        if (ProjectManager.f19822oIX0oI.xI0oxI00()) {
            i = 2;
        } else {
            i = 1;
        }
        table.setTabMode(i);
        getMFragmentPagerAdapter().setTitles(getTiTle());
        getTable().setupWithViewPager(getMViewPager());
        Object systemService = getMActivity().getSystemService("location");
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
        try {
            if (UtilsKt.oo()) {
                this.proxy = OOXIXo.oxoX.xxIXOIIO(requireContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int layoutId() {
        return R.layout.fragment_sport;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24572IO)
    @SuppressLint({"CommitTransaction"})
    public final void onBindStateChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        this.mDeviceConfigInfo = (DeviceConfigInfo) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(DeviceConfigInfo.class.getName()), DeviceConfigInfo.class);
        int count = getMFragmentPagerAdapter().getCount();
        for (int i = 0; i < count; i++) {
            provideFragmentManager().beginTransaction().remove(getMFragmentPagerAdapter().getItem(i)).commitNowAllowingStateLoss();
        }
        initView();
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OOXIXo.oxoX oxox = this.proxy;
        if (oxox != null) {
            oxox.oO();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this.listener);
        }
        LogUtils.d("stop removeUpdates listener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(getMActivity(), g.g) == 0) {
            try {
                LocationManager locationManager = this.locationManager;
                if (locationManager != null) {
                    locationManager.requestLocationUpdates("gps", ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, 1.0f, this.listener);
                }
                OOXIXo.oxoX oxox = this.proxy;
                if (oxox != null) {
                    oxox.ooOOo0oXI();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtils.d("start requestLocationUpdates listener");
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24635oX)
    public final void onThemeChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("SportFragment THEME_CHANGE");
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getContext(), R.color.view_page_tablayout_bg));
    }
}
