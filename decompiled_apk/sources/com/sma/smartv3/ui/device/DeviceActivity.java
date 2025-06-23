package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.PFMedium;
import java.util.List;

/* loaded from: classes12.dex */
public final class DeviceActivity extends BaseFragmentPagerActivity {
    public DeviceFragment deviceFragment;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.device.DeviceActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) DeviceActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.DeviceActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) DeviceActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.DeviceActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) DeviceActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    public static /* synthetic */ void onUnbind$default(DeviceActivity deviceActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        deviceActivity.onUnbind(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUnbind$lambda$0(DeviceActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.finish();
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final DeviceFragment getDeviceFragment() {
        DeviceFragment deviceFragment = this.deviceFragment;
        if (deviceFragment != null) {
            return deviceFragment;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("deviceFragment");
        return null;
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(com.sma.smartv3.util.XoI0Ixx0.f24406X00IoxXI, true);
        setDeviceFragment(new DeviceFragment());
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        return kotlin.collections.oI0IIXIo.OOXIXo(getDeviceFragment());
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTable().setVisibility(8);
        getAbhTitleCenter().setText(R.string.bottom_device);
        getAbhTitleRight().setVisibility(8);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_status_info;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24614XX)
    public final void onUnbind(boolean z) {
        LogUtils.d("onUnbind");
        if (ProjectManager.f19822oIX0oI.oXX0IoI()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xXxxox0I
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceActivity.onUnbind$lambda$0(DeviceActivity.this);
                }
            }, 100L);
        }
    }

    public final void setDeviceFragment(@OXOo.OOXIXo DeviceFragment deviceFragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(deviceFragment, "<set-?>");
        this.deviceFragment = deviceFragment;
    }
}
