package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.CleanUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.g;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.androidthirdpartylogin.google.GoogleFit;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.SmaNotification;
import com.sma.smartv3.biz.ad.ADPAdManager;
import com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager;
import com.sma.smartv3.biz.fitness_site.strava.StravaManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.AppVersion;
import com.sma.smartv3.model.UpgradeFailedDeviceData;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.network.UserDelete;
import com.sma.smartv3.ui.device.FirmwareRepairSearchActivity;
import com.sma.smartv3.ui.fitness_site.FitbitAuthActivity;
import com.sma.smartv3.ui.fitness_site.StravaAuthActivity;
import com.sma.smartv3.ui.launcher.LauncherActivity;
import com.sma.smartv3.ui.login.ServerSelectActivity;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsActivity.kt\ncom/sma/smartv3/ui/me/SettingsActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,802:1\n19#2:803\n15#2:804\n19#2:805\n15#2:806\n19#2:807\n15#2:808\n19#2:827\n15#2:828\n11#2,2:829\n69#3,3:809\n72#3,5:813\n69#3,3:818\n72#3,5:822\n69#3,3:831\n72#3,5:835\n69#3,3:840\n72#3,5:844\n140#3,5:853\n145#3,5:859\n140#3,5:864\n145#3,5:870\n1#4:812\n1#4:821\n1#4:834\n1#4:843\n1#4:858\n1#4:869\n1549#5:849\n1620#5,3:850\n*S KotlinDebug\n*F\n+ 1 SettingsActivity.kt\ncom/sma/smartv3/ui/me/SettingsActivity\n*L\n104#1:803\n104#1:804\n138#1:805\n138#1:806\n141#1:807\n141#1:808\n652#1:827\n652#1:828\n653#1:829,2\n371#1:809,3\n371#1:813,5\n497#1:818,3\n497#1:822,5\n654#1:831,3\n654#1:835,5\n690#1:840,3\n690#1:844,5\n183#1:853,5\n183#1:859,5\n203#1:864,5\n203#1:870,5\n371#1:812\n497#1:821\n654#1:834\n690#1:843\n183#1:858\n203#1:869\n700#1:849\n700#1:850,3\n*E\n"})
/* loaded from: classes11.dex */
public class SettingsActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int REQUEST_ENABLE_FITBIT_SYNC = 515;
    public static final int REQUEST_ENABLE_STRAVA_SYNC = 514;
    public static final int REQUEST_PERMISSION_SERVER = 3;

    @OXOo.OOXIXo
    private AppUser appUser;

    @OXOo.OOXIXo
    private String downloadUrl;
    private boolean isGoogleFitSyncBoolean;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mCacheCleanPopup;
    private boolean mCleaning;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDataAutoSyncPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeleteUserPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mLogoutPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoO0xx0 mMapPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPermissionBackgroundPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPermissionPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mRepairPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoO0xx0 mUnitPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SettingsActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$tvUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SettingsActivity.this.findViewById(R.id.tv_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMap$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$tvMap$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SettingsActivity.this.findViewById(R.id.tv_map);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDataStorage$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$tvDataStorage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SettingsActivity.this.findViewById(R.id.tv_data_storage);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivRemind$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$ivRemind$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) SettingsActivity.this.findViewById(R.id.ivRemind);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkGoogleFit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkGoogleFit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_google_fit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkStrava$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkStrava$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_strava);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkDataAutoSync$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkDataAutoSync$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_data_auto_sync);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO stravaLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$stravaLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.stravaLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cacheSize$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$cacheSize$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SettingsActivity.this.findViewById(R.id.tv_cache_size);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llDeleteAccount$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llDeleteAccount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_delete_account);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llModifyPassword$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llModifyPassword$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_modify_password);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llAiKeySet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llAiKeySet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_aikey_set);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llUiRepair$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llUiRepair$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_ui_repair);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llFontRepair$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llFontRepair$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_font_repair);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llFirmwareRepair$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llFirmwareRepair$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_firmware_repair);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llGPSFirmwareRepair$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llGPSFirmwareRepair$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_gps_firmware_repair);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llAdmobPrivacyOptions$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llAdmobPrivacyOptions$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_admob_privacy_options);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llDataSavePlace$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llDataSavePlace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_data_save_place);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btSettingButton$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$btSettingButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) SettingsActivity.this.findViewById(R.id.bt_setting_button);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llGoogleFit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llGoogleFit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_google_fit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llGoogleFitAuth$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llGoogleFitAuth$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_google_fit_auth);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkNotificationBar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkNotificationBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_notification_bar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO notificationBarLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$notificationBarLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.notificationBarLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llHealthConnect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llHealthConnect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_health_connect);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llZewaFit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$llZewaFit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.ll_zewa_fit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkZewaFit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkZewaFit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_zewa_fit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkFitbit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkFitbit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) SettingsActivity.this.findViewById(R.id.check_fitbit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO fitbitLl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$fitbitLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SettingsActivity.this.findViewById(R.id.fitbitLl);
        }
    });

    /* loaded from: classes11.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SettingsActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.appUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.downloadUrl = "";
    }

    private final void checkUpgradeFailedDevice() {
        final List<BleDeviceInfo> list = UpgradeFailedDeviceData.INSTANCE.getList();
        LogUtils.d("checkUpgradeFailedDevice -> List : " + list);
        if (!list.isEmpty()) {
            List<BleDeviceInfo> list2 = list;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((BleDeviceInfo) it.next()).getMBleName());
            }
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, arrayList, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.check_firmware_upgrade_failed_tip);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$checkUpgradeFailedDevice$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    boolean z;
                    if (i == -1) {
                        z = false;
                    } else {
                        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(list.get(i).getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(list.get(i).getMPlatform(), BleDeviceInfo.PLATFORM_JL707) && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(list.get(i).getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
                            ToastUtils.showLong(R.string.stay_tuned);
                        } else {
                            com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(list.get(i)));
                            SettingsActivity settingsActivity = this;
                            settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) FirmwareRepairSearchActivity.class));
                        }
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            });
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xxoxoooix.OxxIIOOXO(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exit() {
        CleanUtils.cleanCustomDir(X00IoxXI.oIX0oI.II0xO0(X00IoxXI.oIX0oI.f3233oIX0oI, Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo(), null, 4, null).getPath());
        CleanUtils.cleanExternalCache();
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.XO().clear();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OI0()) {
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24614XX, Boolean.TRUE);
            MyDb.INSTANCE.getMDatabase().clearAllTables();
            xo0.I0Io().clear();
            xo0.II0xO0().clear();
            BleCache.INSTANCE.clear();
            LogUtils.getConfig().setLogSwitch(false);
        }
        if (projectManager.XOxxooXI()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getMContext().getPackageName(), "com.sma.smartv3.ui.launcher.KumiLauncherActivity"));
            getMContext().startActivity(intent);
        } else {
            Intent intent2 = new Intent(this, (Class<?>) LauncherActivity.class);
            intent2.setFlags(268468224);
            startActivity(intent2);
        }
    }

    private final Button getBtSettingButton() {
        return (Button) this.btSettingButton$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getCacheSize() {
        return (TextView) this.cacheSize$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getCheckDataAutoSync() {
        return (CheckBox) this.checkDataAutoSync$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getCheckFitbit() {
        return (CheckBox) this.checkFitbit$delegate.getValue();
    }

    private final CheckBox getCheckGoogleFit() {
        return (CheckBox) this.checkGoogleFit$delegate.getValue();
    }

    private final CheckBox getCheckNotificationBar() {
        return (CheckBox) this.checkNotificationBar$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getCheckStrava() {
        return (CheckBox) this.checkStrava$delegate.getValue();
    }

    private final CheckBox getCheckZewaFit() {
        return (CheckBox) this.checkZewaFit$delegate.getValue();
    }

    private final LinearLayout getFitbitLl() {
        return (LinearLayout) this.fitbitLl$delegate.getValue();
    }

    private final ImageView getIvRemind() {
        return (ImageView) this.ivRemind$delegate.getValue();
    }

    private final LinearLayout getLlAdmobPrivacyOptions() {
        return (LinearLayout) this.llAdmobPrivacyOptions$delegate.getValue();
    }

    private final LinearLayout getLlAiKeySet() {
        return (LinearLayout) this.llAiKeySet$delegate.getValue();
    }

    private final LinearLayout getLlDataSavePlace() {
        return (LinearLayout) this.llDataSavePlace$delegate.getValue();
    }

    private final LinearLayout getLlDeleteAccount() {
        return (LinearLayout) this.llDeleteAccount$delegate.getValue();
    }

    private final LinearLayout getLlFirmwareRepair() {
        return (LinearLayout) this.llFirmwareRepair$delegate.getValue();
    }

    private final LinearLayout getLlFontRepair() {
        return (LinearLayout) this.llFontRepair$delegate.getValue();
    }

    private final LinearLayout getLlGPSFirmwareRepair() {
        return (LinearLayout) this.llGPSFirmwareRepair$delegate.getValue();
    }

    private final LinearLayout getLlGoogleFit() {
        return (LinearLayout) this.llGoogleFit$delegate.getValue();
    }

    private final LinearLayout getLlGoogleFitAuth() {
        return (LinearLayout) this.llGoogleFitAuth$delegate.getValue();
    }

    private final LinearLayout getLlHealthConnect() {
        return (LinearLayout) this.llHealthConnect$delegate.getValue();
    }

    private final LinearLayout getLlModifyPassword() {
        return (LinearLayout) this.llModifyPassword$delegate.getValue();
    }

    private final LinearLayout getLlUiRepair() {
        return (LinearLayout) this.llUiRepair$delegate.getValue();
    }

    private final LinearLayout getLlZewaFit() {
        return (LinearLayout) this.llZewaFit$delegate.getValue();
    }

    private final LinearLayout getNotificationBarLl() {
        return (LinearLayout) this.notificationBarLl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final LinearLayout getStravaLl() {
        return (LinearLayout) this.stravaLl$delegate.getValue();
    }

    private final TextView getTvDataStorage() {
        return (TextView) this.tvDataStorage$delegate.getValue();
    }

    private final TextView getTvMap() {
        return (TextView) this.tvMap$delegate.getValue();
    }

    private final TextView getTvUnit() {
        return (TextView) this.tvUnit$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("checkGoogleFit setOnCheckedChangeListener " + z);
        if (this$0.isGoogleFitSyncBoolean) {
            this$0.isGoogleFitSyncBoolean = false;
            return;
        }
        if (z) {
            GoogleFit.f19698oIX0oI.xxIXOIIO(this$0);
        } else {
            GoogleFit.f19698oIX0oI.Oxx0xo(this$0);
        }
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(final SettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.getCheckStrava().isChecked()) {
            if (this$0.mLoadingPopup == null) {
                this$0.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(this$0.getMContext());
            }
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.IIXOooo();
            }
            StravaManager.INSTANCE.deauthorizeStrava(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$initView$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2;
                    CheckBox checkStrava;
                    i0X0x0oIo2 = SettingsActivity.this.mLoadingPopup;
                    if (i0X0x0oIo2 != null) {
                        i0X0x0oIo2.dismiss();
                    }
                    if (z) {
                        checkStrava = SettingsActivity.this.getCheckStrava();
                        checkStrava.setChecked(false);
                    }
                }
            });
            return;
        }
        if (ProjectManager.f19822oIX0oI.X0ooXIooI()) {
            StravaManager.INSTANCE.toStravaAppAuthorize(this$0);
        } else {
            this$0.startActivityForResult(new Intent(this$0, (Class<?>) StravaAuthActivity.class), 514);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(final SettingsActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.getCheckFitbit().isChecked()) {
            if (this$0.mLoadingPopup == null) {
                this$0.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(this$0.getMContext());
            }
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
            if (i0X0x0oIo != null) {
                i0X0x0oIo.IIXOooo();
            }
            FitbitManager.INSTANCE.deauthorizeFit(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$initView$3$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2;
                    CheckBox checkFitbit;
                    i0X0x0oIo2 = SettingsActivity.this.mLoadingPopup;
                    if (i0X0x0oIo2 != null) {
                        i0X0x0oIo2.dismiss();
                    }
                    if (z) {
                        checkFitbit = SettingsActivity.this.getCheckFitbit();
                        checkFitbit.setChecked(false);
                    }
                }
            });
            return;
        }
        this$0.startActivityForResult(new Intent(this$0, (Class<?>) FitbitAuthActivity.class), 515);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(final SettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("setOnCheckedChangeListener " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24492xoXoI, z);
        if (z) {
            if (this$0.mDataAutoSyncPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this$0, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.use_reminder);
                xoI0Ixx0.xI(Integer.valueOf(R.string.data_sync_reminder));
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$initView$4$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        CheckBox checkDataAutoSync;
                        checkDataAutoSync = SettingsActivity.this.getCheckDataAutoSync();
                        checkDataAutoSync.setChecked(false);
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$initView$4$1$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        return Boolean.TRUE;
                    }
                });
                this$0.mDataAutoSyncPopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this$0.mDataAutoSyncPopup;
            if (xoI0Ixx02 != null) {
                View rootView = this$0.getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(SettingsActivity this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("setOnCheckedChangeListener " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24371IoOoo, z);
        if (z) {
            if (ContextCompat.checkSelfPermission(this$0, g.g) == 0) {
                this$0.startSmaNotification();
                return;
            } else {
                this$0.requestLocationPermission();
                return;
            }
        }
        SmaNotification.f20192Oxx0IOOO.oIX0oI().xxIXOIIO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(CompoundButton compoundButton, boolean z) {
        LogUtils.d("checkZewaFit setOnCheckedChangeListener " + z);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24474x0xO, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(SettingsActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.checkUpgradeFailedDevice();
    }

    @RequiresApi(29)
    private final void permissionBackgroundLocationRemind() {
        if (this.mPermissionBackgroundPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.background_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$permissionBackgroundLocationRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    mContext = SettingsActivity.this.getMContext();
                    mContext.requestPermissions(new String[]{g.g, "android.permission.ACCESS_BACKGROUND_LOCATION"}, 3);
                    return Boolean.TRUE;
                }
            });
            this.mPermissionBackgroundPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mPermissionBackgroundPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    private final void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= 29) {
            permissionBackgroundLocationRemind();
            return;
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$requestLocationPermission$1

            /* loaded from: classes11.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f23461oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f23461oIX0oI = iArr;
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f23461oIX0oI[it.ordinal()];
                if (i == 1) {
                    SettingsActivity.this.startSmaNotification();
                } else if (i != 2) {
                    SettingsActivity.this.permissionRemind();
                }
            }
        }, 3, null);
    }

    private final void setDataStorage() {
        String string;
        getTvDataStorage().setText(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24407X0IIOO));
        CharSequence text = getTvDataStorage().getText();
        kotlin.jvm.internal.IIX0o.oO(text, "getText(...)");
        if (text.length() == 0) {
            TextView tvDataStorage = getTvDataStorage();
            String base_url = Api.INSTANCE.getBASE_URL();
            int hashCode = base_url.hashCode();
            if (hashCode != -1644804843) {
                if (hashCode != -167076722) {
                    if (hashCode == 1582655416 && base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23071I0Io)) {
                        string = getString(R.string.china_mainland);
                    }
                    string = "Test Server";
                } else {
                    if (base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23074oIX0oI)) {
                        string = getString(R.string.asia_pacific);
                    }
                    string = "Test Server";
                }
            } else {
                if (base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23072II0xO0)) {
                    string = getString(R.string.europe_and_america);
                }
                string = "Test Server";
            }
            tvDataStorage.setText(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupMap() {
        int i;
        TextView tvMap = getTvMap();
        if (com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO)) {
            i = R.string.baidu_map;
        } else {
            i = R.string.google_map;
        }
        tvMap.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupUnit(AppUser appUser) {
        int i;
        TextView tvUnit = getTvUnit();
        if (appUser.getUnit() == 0) {
            i = R.string.metric;
        } else {
            i = R.string.imperial;
        }
        tvUnit.setText(i);
    }

    public final void accessToThirdParties(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong("accessToThirdParties", new Object[0]);
    }

    public final void admobPrivacyOptions(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (ProjectManager.f19822oIX0oI.oXIO0o0XI()) {
            ADPAdManager.INSTANCE.showPrivacyOptionsForm(this);
        }
    }

    public final void aiKeySet(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) AiKeySetActivity.class));
    }

    public final void cacheClean(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mCleaning) {
            return;
        }
        if (this.mCacheCleanPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.cache_clean_confirm);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$cacheClean$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    SettingsActivity.this.mCleaning = false;
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new SettingsActivity$cacheClean$1$2(this));
            this.mCacheCleanPopup = xoI0Ixx0;
        }
        this.mCleaning = true;
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mCacheCleanPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void checkUpdate(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.downloadUrl.length() > 0) {
            oOXoIIIo.oIX0oI.xxX(this, this.downloadUrl);
        } else {
            ToastUtils.showLong(R.string.already_the_latest_version);
        }
    }

    public final void deleteAccount(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mDeleteUserPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.delete_user_confirm);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$deleteAccount$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    AppUser appUser;
                    final Activity mContext;
                    View rootView;
                    NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
                    appUser = SettingsActivity.this.appUser;
                    HashMap<String, String> userIdentityBody = RequestBodyKt.getUserIdentityBody(appUser);
                    final SettingsActivity settingsActivity = SettingsActivity.this;
                    final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$deleteAccount$1$1.1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            SettingsActivity.this.exit();
                        }
                    };
                    mContext = SettingsActivity.this.getMContext();
                    rootView = SettingsActivity.this.getRootView();
                    final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(mContext, rootView);
                    String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UserDelete.URL);
                    netWorkUtils.printParam(convertBaseUrl + UserDelete.URL, userIdentityBody);
                    NetWork netWork = NetWork.f19682oIX0oI;
                    String str = convertBaseUrl + UserDelete.URL;
                    final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$deleteAccount$1$1$invoke$$inlined$post$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                            NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                            Activity activity = mContext;
                            xxxI.II0xO0 iI0xO03 = iI0xO0;
                            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                            LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                            if (response == null) {
                                response = new Response<>();
                                response.setCode(-1000);
                            }
                            netWorkUtils2.responseWhenCheck(activity, response, iI0xO03);
                            if (i0X0x0oIo != null) {
                                i0X0x0oIo.dismiss();
                            }
                        }
                    };
                    AndroidNetworking.post(str).addBodyParameter((Map<String, String>) userIdentityBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$deleteAccount$1$1$invoke$$inlined$post$2
                        @Override // com.androidnetworking.interfaces.ParsedRequestListener
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void onResponse(@OXOo.OOXIXo Response<String> response) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                            xxxI.II0xO0.this.handleResponse(response);
                        }

                        @Override // com.androidnetworking.interfaces.ParsedRequestListener
                        public void onError(@OXOo.oOoXoXO ANError aNError) {
                            Integer num;
                            String str2;
                            String str3;
                            Response response;
                            StringBuilder sb = new StringBuilder();
                            sb.append("errorCode:");
                            Integer num2 = null;
                            if (aNError != null) {
                                num = Integer.valueOf(aNError.getErrorCode());
                            } else {
                                num = null;
                            }
                            sb.append(num);
                            sb.append(", errorBody:");
                            if (aNError != null) {
                                str2 = aNError.getErrorBody();
                            } else {
                                str2 = null;
                            }
                            sb.append(str2);
                            sb.append(", ");
                            if (aNError != null) {
                                str3 = aNError.getErrorDetail();
                            } else {
                                str3 = null;
                            }
                            sb.append(str3);
                            LogUtils.d(sb.toString());
                            if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                                num2 = Integer.valueOf(response.getCode());
                            } else if (aNError != null) {
                                num2 = Integer.valueOf(aNError.getErrorCode());
                            }
                            xxxI.II0xO0.this.handleError(String.valueOf(num2));
                        }
                    });
                    return Boolean.TRUE;
                }
            });
            this.mDeleteUserPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mDeleteUserPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void firmwareRepair(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.firmware_repair);
        xoI0Ixx0.xI(Integer.valueOf(R.string.firmware_repair_remind));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$firmwareRepair$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                UtilsKt.OI0(com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO(), new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$firmwareRepair$1$1.1
                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24620XoX, null, 2, null);
                    }
                });
                return Boolean.TRUE;
            }
        });
        this.mRepairPopup = xoI0Ixx0;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    public final void fontRepair(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.pair_confirm_title);
        xoI0Ixx0.xI(Integer.valueOf(R.string.firmware_repair_tip));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$fontRepair$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                Activity Oxx0IOOO2 = com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO();
                final SettingsActivity settingsActivity = this;
                UtilsKt.OI0(Oxx0IOOO2, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$fontRepair$1$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DeviceInfoChecker.OxI(DeviceInfoChecker.f19983oIX0oI, SettingsActivity.this, null, 2, null);
                    }
                });
                return Boolean.TRUE;
            }
        });
        this.mRepairPopup = xoI0Ixx0;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    public final void googleFitAuth(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) GoogleFitAuthActivity.class));
    }

    public final void googleFitClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
    }

    public final void googleHealthConnect(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.sma.smartv3.ui.main.HealthConnectActivity");
        startActivity(intent);
    }

    public final void gpsFirmwareRepair(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$gpsFirmwareRepair$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
                View rootView;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                SettingsActivity settingsActivity = SettingsActivity.this;
                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(SettingsActivity.this, 0, 2, null);
                final SettingsActivity settingsActivity2 = SettingsActivity.this;
                xoI0Ixx02.IoOoX(R.string.gps_firmware_repair);
                xoI0Ixx02.xI(Integer.valueOf(R.string.firmware_repair_remind));
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
                xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$gpsFirmwareRepair$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        Activity Oxx0IOOO2 = com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO();
                        final SettingsActivity settingsActivity3 = settingsActivity2;
                        UtilsKt.OI0(Oxx0IOOO2, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$gpsFirmwareRepair$1$1$1.1
                            {
                                super(0);
                            }

                            @Override // Oox.oIX0oI
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                                invoke2();
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DeviceInfoChecker.X0IIOO(DeviceInfoChecker.f19983oIX0oI, SettingsActivity.this, null, 2, null);
                            }
                        });
                        return Boolean.TRUE;
                    }
                });
                settingsActivity.mRepairPopup = xoI0Ixx02;
                xoI0Ixx0 = SettingsActivity.this.mRepairPopup;
                if (xoI0Ixx0 != null) {
                    rootView = SettingsActivity.this.getRootView();
                    kotlin.jvm.internal.IIX0o.oO(rootView, "access$getRootView(...)");
                    xoI0Ixx0.OxxIIOOXO(rootView);
                }
            }
        }, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
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
        int i11;
        int i12;
        int i13;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.settings);
        LinearLayout stravaLl = getStravaLl();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        int i14 = 0;
        if (projectManager.o0oxo0oI()) {
            i = 0;
        } else {
            i = 8;
        }
        stravaLl.setVisibility(i);
        LinearLayout fitbitLl = getFitbitLl();
        if (projectManager.O0IxXx()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        fitbitLl.setVisibility(i2);
        LinearLayout llHealthConnect = getLlHealthConnect();
        if (projectManager.x0OxxIOxX() && Build.VERSION.SDK_INT >= 26) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        llHealthConnect.setVisibility(i3);
        View findViewById = findViewById(R.id.tv_map_right_img);
        if (findViewById != null) {
            if (projectManager.oxOXxoXII()) {
                i13 = 0;
            } else {
                i13 = 8;
            }
            findViewById.setVisibility(i13);
        }
        setDataStorage();
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        setupUnit((AppUser) appUser);
        setupMap();
        SPUtils oIX0oI2 = xo0.oIX0oI();
        Object appVersion = new AppVersion(0, null, null, null, null, null, 0, 127, null);
        Object fromJson2 = new Gson().fromJson(oIX0oI2.getString(AppVersion.class.getName()), (Class<Object>) AppVersion.class);
        if (fromJson2 != null) {
            appVersion = fromJson2;
        }
        AppVersion appVersion2 = (AppVersion) appVersion;
        if (appVersion2.getFileUrl().length() > 0) {
            getIvRemind().setVisibility(0);
            this.downloadUrl = appVersion2.getFileUrl();
        } else {
            getIvRemind().setVisibility(8);
        }
        getCheckGoogleFit().setChecked(xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI));
        getCheckGoogleFit().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.me.IXoIo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingsActivity.initView$lambda$0(SettingsActivity.this, compoundButton, z);
            }
        });
        CheckBox checkStrava = getCheckStrava();
        StravaManager stravaManager = StravaManager.INSTANCE;
        checkStrava.setChecked(stravaManager.isEnabled());
        ViewParent parent = getCheckStrava().getParent();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.OXIOoo0X0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.initView$lambda$1(SettingsActivity.this, view);
            }
        });
        getCheckFitbit().setChecked(FitbitManager.INSTANCE.isEnabled());
        ViewParent parent2 = getCheckFitbit().getParent();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.x0oox0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.initView$lambda$2(SettingsActivity.this, view);
            }
        });
        getCheckDataAutoSync().setChecked(xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24492xoXoI));
        getCheckDataAutoSync().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.me.I00O
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingsActivity.initView$lambda$4(SettingsActivity.this, compoundButton, z);
            }
        });
        getCacheSize().setText(FileUtils.getSize(com.sma.smartv3.initializer.IXxxXO.X00IoxXI(X00IoxXI.oIX0oI.f3233oIX0oI)));
        boolean z = true;
        if (xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true) && this.appUser.getIdentity().length() > 0) {
            getLlDeleteAccount().setVisibility(0);
            getLlModifyPassword().setVisibility(0);
            LinearLayout llDataSavePlace = getLlDataSavePlace();
            if (projectManager.x0OIX00oO()) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            llDataSavePlace.setVisibility(i11);
            getLlGoogleFit().setVisibility(8);
            getBtSettingButton().setText(R.string.logout);
            LinearLayout llZewaFit = getLlZewaFit();
            if (projectManager.XO00XOO()) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            llZewaFit.setVisibility(i12);
        } else {
            getLlDeleteAccount().setVisibility(8);
            getLlModifyPassword().setVisibility(8);
            getLlDataSavePlace().setVisibility(8);
            getLlGoogleFit().setVisibility(8);
            LinearLayout llGoogleFitAuth = getLlGoogleFitAuth();
            if (llGoogleFitAuth != null) {
                llGoogleFitAuth.setVisibility(8);
            }
            getStravaLl().setVisibility(8);
            getBtSettingButton().setText(R.string.login);
            getLlZewaFit().setVisibility(8);
        }
        Button btSettingButton = getBtSettingButton();
        if (projectManager.OXXoIoXI()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        btSettingButton.setVisibility(i4);
        LinearLayout notificationBarLl = getNotificationBarLl();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.xx00oOoI()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        notificationBarLl.setVisibility(i5);
        if (Build.VERSION.SDK_INT >= 34) {
            CheckBox checkNotificationBar = getCheckNotificationBar();
            if (!xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24371IoOoo, true) || ContextCompat.checkSelfPermission(this, g.g) != 0) {
                z = false;
            }
            checkNotificationBar.setChecked(z);
        } else {
            getCheckNotificationBar().setChecked(xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24371IoOoo, true));
        }
        getCheckNotificationBar().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.me.oO0IXx
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                SettingsActivity.initView$lambda$5(SettingsActivity.this, compoundButton, z2);
            }
        });
        LinearLayout llAiKeySet = getLlAiKeySet();
        if (productManager.IIOIX()) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        llAiKeySet.setVisibility(i6);
        if (projectManager.Io()) {
            LinearLayout llFontRepair = getLlFontRepair();
            if (productManager.ooOx()) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            llFontRepair.setVisibility(i8);
            LinearLayout llUiRepair = getLlUiRepair();
            if (productManager.xx0X0() && productManager.oOoIIO0()) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            llUiRepair.setVisibility(i9);
            LinearLayout llFirmwareRepair = getLlFirmwareRepair();
            if (productManager.I0oOIX()) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            llFirmwareRepair.setVisibility(i10);
        } else {
            getLlFontRepair().setVisibility(8);
            getLlUiRepair().setVisibility(8);
            getLlFirmwareRepair().setVisibility(8);
        }
        LinearLayout llGPSFirmwareRepair = getLlGPSFirmwareRepair();
        if (productManager.Xxx0oXX()) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        llGPSFirmwareRepair.setVisibility(i7);
        LinearLayout llAdmobPrivacyOptions = getLlAdmobPrivacyOptions();
        if (!xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24369IoIOOxIIo, false)) {
            i14 = 8;
        }
        llAdmobPrivacyOptions.setVisibility(i14);
        getCheckZewaFit().setChecked(xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24474x0xO));
        getCheckZewaFit().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.me.ooO0oXxI
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                SettingsActivity.initView$lambda$6(compoundButton, z2);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.o0OO0
            @Override // java.lang.Runnable
            public final void run() {
                SettingsActivity.initView$lambda$7(SettingsActivity.this);
            }
        }, 500L);
        Intent intent = getIntent();
        kotlin.jvm.internal.IIX0o.oO(intent, "getIntent(...)");
        stravaManager.handleStravaAppIntent(this, intent, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$initView$8
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z2) {
                CheckBox checkStrava2;
                checkStrava2 = SettingsActivity.this.getCheckStrava();
                checkStrava2.setChecked(z2);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_settings;
    }

    public final void modifyPassword(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ProjectManager.f19822oIX0oI.xx0(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(TokenParser.SP);
        sb.append(i2);
        sb.append(TokenParser.SP);
        sb.append(intent);
        LogUtils.d(sb.toString());
        if (i != 514) {
            if (i != 515) {
                this.isGoogleFitSyncBoolean = true;
                getCheckGoogleFit().setChecked(GoogleFit.f19698oIX0oI.OOXIXo(this, i, i2));
                com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI, getCheckGoogleFit().isChecked());
                return;
            } else {
                if (i2 == -1) {
                    getCheckFitbit().setChecked(true);
                    return;
                }
                return;
            }
        }
        if (i2 == -1) {
            getCheckStrava().setChecked(true);
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true) && this.appUser.getIdentity().length() > 0) {
            if (ProductManager.f20544oIX0oI.I0oOIX() && xo0.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24419XO)) {
                return;
            }
            if (this.mLogoutPopup == null) {
                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.logout_confirm);
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$onBottomClick$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
                        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2;
                        View rootView;
                        if (!BleConnector.INSTANCE.isBound()) {
                            SettingsActivity.this.exit();
                        } else {
                            RequestCommonMethod requestCommonMethod = RequestCommonMethod.INSTANCE;
                            final SettingsActivity settingsActivity = SettingsActivity.this;
                            requestCommonMethod.updateDeviceInfo(new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$onBottomClick$1$1.1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                                    i0X0x0oIo3 = SettingsActivity.this.mLoadingPopup;
                                    if (i0X0x0oIo3 != null) {
                                        i0X0x0oIo3.dismiss();
                                    }
                                    SettingsActivity.this.exit();
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO String str) {
                                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                                    i0X0x0oIo3 = SettingsActivity.this.mLoadingPopup;
                                    if (i0X0x0oIo3 != null) {
                                        i0X0x0oIo3.dismiss();
                                    }
                                    SettingsActivity.this.exit();
                                }
                            });
                            i0X0x0oIo = SettingsActivity.this.mLoadingPopup;
                            if (i0X0x0oIo == null) {
                                SettingsActivity.this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(xoI0Ixx0.Oxx0IOOO());
                            }
                            i0X0x0oIo2 = SettingsActivity.this.mLoadingPopup;
                            if (i0X0x0oIo2 != null) {
                                rootView = SettingsActivity.this.getRootView();
                                kotlin.jvm.internal.IIX0o.oO(rootView, "access$getRootView(...)");
                                i0X0x0oIo2.OxxIIOOXO(rootView);
                            }
                        }
                        return Boolean.TRUE;
                    }
                });
                this.mLogoutPopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mLogoutPopup;
            if (xoI0Ixx02 != null) {
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        xo0.oxoX().put(AppUser.class.getName(), new Gson().toJson((AppUser) appUser));
        startActivity(new Intent(this, (Class<?>) ServerSelectActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@OXOo.OOXIXo Intent intent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        StravaManager.INSTANCE.handleStravaAppIntent(this, intent, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$onNewIntent$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(boolean z) {
                CheckBox checkStrava;
                checkStrava = SettingsActivity.this.getCheckStrava();
                checkStrava.setChecked(z);
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void permissionRemind() {
        if (this.mPermissionPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.permission_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$permissionRemind$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    PermissionUtils.launchAppDetailsSettings();
                    return Boolean.TRUE;
                }
            });
            this.mPermissionPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mPermissionPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void selectMap(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (ProjectManager.f19822oIX0oI.oxOXxoXII()) {
            if (this.mMapPopup == null) {
                com.sma.smartv3.pop.xoO0xx0 xoo0xx0 = new com.sma.smartv3.pop.xoO0xx0(getMContext(), R.array.maps);
                xoo0xx0.oo(true);
                xoo0xx0.oo0xXOI0I(R.string.map_select);
                xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$selectMap$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i) {
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, i == 1);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, null, 2, null);
                        SettingsActivity.this.setupMap();
                        return Boolean.TRUE;
                    }
                });
                this.mMapPopup = xoo0xx0;
            }
            com.sma.smartv3.pop.xoO0xx0 xoo0xx02 = this.mMapPopup;
            if (xoo0xx02 != null) {
                xoo0xx02.IoOoX(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO) ? 1 : 0);
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoo0xx02.OxxIIOOXO(rootView);
            }
        }
    }

    public final void selectUnit(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int i = 1;
        if (this.mUnitPopup == null) {
            com.sma.smartv3.pop.xoO0xx0 xoo0xx0 = new com.sma.smartv3.pop.xoO0xx0(getMContext(), R.array.units);
            xoo0xx0.oo(true);
            xoo0xx0.oo0xXOI0I(R.string.unit);
            xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$selectUnit$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    SPUtils XO2 = xo0.XO();
                    Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                    Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                    if (fromJson != null) {
                        appUser = fromJson;
                    }
                    SettingsActivity settingsActivity = SettingsActivity.this;
                    AppUser appUser2 = (AppUser) appUser;
                    appUser2.setUnit(i2 == 0 ? 0 : 1);
                    settingsActivity.setupUnit(appUser2);
                    settingsActivity.appUser = appUser2;
                    xo0.XO().put(AppUser.class.getName(), new Gson().toJson(appUser2));
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24578IoOoo, null, 2, null);
                    final SettingsActivity settingsActivity2 = SettingsActivity.this;
                    com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$selectUnit$1$1.2
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                            invoke2(bleConnector);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                            AppUser appUser3;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            BleConnector bleConnector = BleConnector.INSTANCE;
                            BleKey bleKey = BleKey.USER_PROFILE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            appUser3 = SettingsActivity.this.appUser;
                            BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, appUser3.getBleUserProfile(), false, false, 24, null);
                        }
                    }, 1, null);
                    ToastUtils.showLong(R.string.reboot_app_show_new_view);
                    return Boolean.TRUE;
                }
            });
            this.mUnitPopup = xoo0xx0;
        }
        com.sma.smartv3.pop.xoO0xx0 xoo0xx02 = this.mUnitPopup;
        if (xoo0xx02 != null) {
            if (this.appUser.getUnit() == 0) {
                i = 0;
            }
            xoo0xx02.IoOoX(i);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoo0xx02.OxxIIOOXO(rootView);
        }
    }

    public final void startSmaNotification() {
        SmaNotification.oIX0oI oix0oi = SmaNotification.f20192Oxx0IOOO;
        oix0oi.oIX0oI().II0XooXoX();
        oix0oi.oIX0oI().oOoXoXO(0, 0);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24629oIX0oI, null, 2, null);
    }

    public final void stravaClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
    }

    public final void uiRepair(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.ui_repair);
        xoI0Ixx0.xI(Integer.valueOf(R.string.ui_repair_remind));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$uiRepair$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                Activity Oxx0IOOO2 = com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO();
                final SettingsActivity settingsActivity = this;
                UtilsKt.OI0(Oxx0IOOO2, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.SettingsActivity$uiRepair$1$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DeviceInfoChecker.XIxXXX0x0(DeviceInfoChecker.f19983oIX0oI, SettingsActivity.this, null, 2, null);
                    }
                });
                return Boolean.TRUE;
            }
        });
        this.mRepairPopup = xoI0Ixx0;
        View rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    public final void zewaFitClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
    }
}
