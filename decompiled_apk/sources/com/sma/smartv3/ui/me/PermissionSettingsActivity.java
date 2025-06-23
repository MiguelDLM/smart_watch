package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.RomUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.util.permission.PermissionHelper;

@kotlin.jvm.internal.XX({"SMAP\nPermissionSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionSettingsActivity.kt\ncom/sma/smartv3/ui/me/PermissionSettingsActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n87#2,7:162\n94#2,3:170\n70#2,7:173\n97#2:180\n1#3:169\n*S KotlinDebug\n*F\n+ 1 PermissionSettingsActivity.kt\ncom/sma/smartv3/ui/me/PermissionSettingsActivity\n*L\n76#1:162,7\n76#1:170,3\n76#1:173,7\n76#1:180\n76#1:169\n*E\n"})
/* loaded from: classes11.dex */
public final class PermissionSettingsActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PermissionSettingsActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNotificationState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvNotificationState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_notificationState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLocationState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvLocationState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_locationState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvContactState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvContactState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_contactState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvPhoneState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvPhoneState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_phoneState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSmsState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvSmsState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_smsState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvStoreState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvStoreState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_storeState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvBatteryState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvBatteryState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_batteryState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvActivityState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvActivityState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_activityState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLocationPermissionsText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$tvLocationPermissionsText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) PermissionSettingsActivity.this.findViewById(R.id.tv_location_permissions_text);
        }
    });

    private final TextView getTvActivityState() {
        return (TextView) this.tvActivityState$delegate.getValue();
    }

    private final TextView getTvBatteryState() {
        return (TextView) this.tvBatteryState$delegate.getValue();
    }

    private final TextView getTvContactState() {
        return (TextView) this.tvContactState$delegate.getValue();
    }

    private final TextView getTvLocationPermissionsText() {
        return (TextView) this.tvLocationPermissionsText$delegate.getValue();
    }

    private final TextView getTvLocationState() {
        return (TextView) this.tvLocationState$delegate.getValue();
    }

    private final TextView getTvNotificationState() {
        return (TextView) this.tvNotificationState$delegate.getValue();
    }

    private final TextView getTvPhoneState() {
        return (TextView) this.tvPhoneState$delegate.getValue();
    }

    private final TextView getTvSmsState() {
        return (TextView) this.tvSmsState$delegate.getValue();
    }

    private final TextView getTvStoreState() {
        return (TextView) this.tvStoreState$delegate.getValue();
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.permission_settings);
        TextView tvNotificationState = getTvNotificationState();
        boolean X0o0xo2 = MyNotificationListenerService.f20319OxI.X0o0xo(this);
        int i12 = R.string.permission_state_off;
        if (X0o0xo2) {
            i = R.string.permission_state_on;
        } else {
            i = R.string.permission_state_off;
        }
        tvNotificationState.setText(i);
        TextView tvLocationState = getTvLocationState();
        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
        if (permissionHelper.OxI(this)) {
            i2 = R.string.permission_state_on;
        } else {
            i2 = R.string.permission_state_off;
        }
        tvLocationState.setText(i2);
        TextView tvContactState = getTvContactState();
        if (permissionHelper.IIXOooo(this)) {
            i3 = R.string.permission_state_on;
        } else {
            i3 = R.string.permission_state_off;
        }
        tvContactState.setText(i3);
        TextView tvPhoneState = getTvPhoneState();
        if (permissionHelper.O0xOxO(this)) {
            i4 = R.string.permission_state_on;
        } else {
            i4 = R.string.permission_state_off;
        }
        tvPhoneState.setText(i4);
        TextView tvSmsState = getTvSmsState();
        if (permissionHelper.XI0IXoo(this)) {
            i5 = R.string.permission_state_on;
        } else {
            i5 = R.string.permission_state_off;
        }
        tvSmsState.setText(i5);
        TextView tvStoreState = getTvStoreState();
        if (permissionHelper.xoXoI(this)) {
            i6 = R.string.permission_state_on;
        } else {
            i6 = R.string.permission_state_off;
        }
        tvStoreState.setText(i6);
        TextView tvBatteryState = getTvBatteryState();
        if (permissionHelper.o00(this)) {
            i7 = R.string.permission_state_on;
        } else {
            i7 = R.string.permission_state_off;
        }
        tvBatteryState.setText(i7);
        TextView tvActivityState = getTvActivityState();
        if (permissionHelper.Oo(this)) {
            i12 = R.string.permission_state_on;
        }
        tvActivityState.setText(i12);
        getTvLocationPermissionsText().setText(getString(R.string.location_permissions_tip, AppUtils.getAppName(), AppUtils.getAppName()));
        View findViewById = findViewById(R.id.ll_adjust_media_volume_permissions);
        if (RomUtils.isXiaomi()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        findViewById.setVisibility(i8);
        View findViewById2 = findViewById(R.id.ll_activity_permissions);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OOOI() && Build.VERSION.SDK_INT >= 29) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        findViewById2.setVisibility(i9);
        View findViewById3 = findViewById(R.id.ll_store_permissions);
        if (Build.VERSION.SDK_INT >= 33) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        findViewById3.setVisibility(i10);
        View findViewById4 = findViewById(R.id.ll_permissions_tip_all);
        if (!projectManager.OO()) {
            i11 = 8;
        }
        findViewById4.setVisibility(i11);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_permission_settings;
    }

    public final void onItemClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        switch (view.getId()) {
            case R.id.ll_activity_permissions /* 2131365850 */:
                PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper.Oo(this)) {
                    permissionHelper.oIX0oI(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$8
                        public final void invoke(boolean z) {
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_adjust_media_volume_permissions /* 2131365852 */:
                PermissionHelper.f24522oIX0oI.XIxXXX0x0(this);
                return;
            case R.id.ll_background_permissions /* 2131365859 */:
                PermissionHelper.f24522oIX0oI.I0Io(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$7
                    public final void invoke(boolean z) {
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }
                });
                return;
            case R.id.ll_battery_permissions /* 2131365861 */:
                PermissionHelper permissionHelper2 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper2.o00(this)) {
                    permissionHelper2.II0XooXoX(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$6
                        public final void invoke(boolean z) {
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_contacts_permissions /* 2131365876 */:
                PermissionHelper permissionHelper3 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper3.IIXOooo(this)) {
                    permissionHelper3.XO(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$2
                        public final void invoke(boolean z) {
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_location_permissions /* 2131365913 */:
                PermissionHelper permissionHelper4 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper4.OxI(this)) {
                    PermissionHelper.xoIox(permissionHelper4, this, false, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$1
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24592OO0x0xX, null, 2, null);
                        }
                    }, 2, null);
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_notification_permissions /* 2131365924 */:
                MyNotificationListenerService.f20319OxI.II0XooXoX(this);
                return;
            case R.id.ll_permissions_tip /* 2131365928 */:
                String str = "https://api.iot-solution.net/web/guide/dist/?phoneName=" + RomUtils.getRomInfo().getName() + "&lang=" + ProjectManager.f19822oIX0oI.o00(this);
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", str);
                bundle.putInt("mArg1", 0);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(this, (Class<?>) WebViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                return;
            case R.id.ll_phone_permissions /* 2131365931 */:
                PermissionHelper permissionHelper5 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper5.O0xOxO(this)) {
                    permissionHelper5.ooOOo0oXI(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$3
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Activity mContext;
                            if (z) {
                                BleInitializer bleInitializer = BleInitializer.f20700XO;
                                mContext = PermissionSettingsActivity.this.getMContext();
                                bleInitializer.XIXIxO(mContext);
                            }
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_sms_permissions /* 2131365954 */:
                PermissionHelper permissionHelper6 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper6.XI0IXoo(this)) {
                    permissionHelper6.oO(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$4
                        public final void invoke(boolean z) {
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            case R.id.ll_store_permissions /* 2131365956 */:
                PermissionHelper permissionHelper7 = PermissionHelper.f24522oIX0oI;
                if (!permissionHelper7.xoXoI(this)) {
                    permissionHelper7.Oxx0IOOO(this, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.PermissionSettingsActivity$onItemClick$5
                        public final void invoke(boolean z) {
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }
                    });
                    return;
                } else {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initView();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
