package com.sma.smartv3.ui.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.bq;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestCommonMethod;
import com.sma.smartv3.network.UploadOtaRecord;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nBaseFirmwareUpgradeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFirmwareUpgradeActivity.kt\ncom/sma/smartv3/ui/device/BaseFirmwareUpgradeActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,173:1\n27#2,2:174\n173#3,12:176\n194#3:197\n234#4,8:188\n254#4:196\n*S KotlinDebug\n*F\n+ 1 BaseFirmwareUpgradeActivity.kt\ncom/sma/smartv3/ui/device/BaseFirmwareUpgradeActivity\n*L\n126#1:174,2\n155#1:176,12\n155#1:197\n155#1:188,8\n155#1:196\n*E\n"})
@SuppressLint({"Registered"})
/* loaded from: classes12.dex */
public abstract class BaseFirmwareUpgradeActivity extends BaseActivity {
    private boolean isAutoUpdate;
    private boolean mStarted;

    @OXOo.oOoXoXO
    private TextView tvTopTip;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvLatest$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvLatest$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_latest);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCurrent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvCurrent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_current);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvStep$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_step);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO progressButton$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ProgressButton>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$progressButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ProgressButton invoke() {
            return (ProgressButton) BaseFirmwareUpgradeActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO devInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$devInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BaseFirmwareUpgradeActivity.this.findViewById(R.id.ll_dev_info);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAlreadyOta$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvAlreadyOta$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_already_ota);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSpeed$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvSpeed$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_speed);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_info);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BaseFirmwareUpgradeActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private String mCurrentVersion = bq.e;

    @OXOo.OOXIXo
    private String mTargetVersion = bq.e;

    public static /* synthetic */ void uploadDownloadInfo$default(BaseFirmwareUpgradeActivity baseFirmwareUpgradeActivity, String str, String str2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            baseFirmwareUpgradeActivity.uploadDownloadInfo(str, str2, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadDownloadInfo");
    }

    public static /* synthetic */ void uploadOtaRecord$default(BaseFirmwareUpgradeActivity baseFirmwareUpgradeActivity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = "1";
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = baseFirmwareUpgradeActivity.mCurrentVersion;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = baseFirmwareUpgradeActivity.mTargetVersion;
            }
            baseFirmwareUpgradeActivity.uploadOtaRecord(str, str6, str7, str8, str5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadOtaRecord");
    }

    @OXOo.OOXIXo
    public final LinearLayout getDevInfo() {
        Object value = this.devInfo$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (LinearLayout) value;
    }

    @OXOo.OOXIXo
    public final String getMCurrentVersion() {
        return this.mCurrentVersion;
    }

    public final boolean getMStarted() {
        return this.mStarted;
    }

    @OXOo.OOXIXo
    public final String getMTargetVersion() {
        return this.mTargetVersion;
    }

    @OXOo.OOXIXo
    public final ProgressButton getProgressButton() {
        Object value = this.progressButton$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (ProgressButton) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvAlreadyOta() {
        Object value = this.tvAlreadyOta$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvCurrent() {
        Object value = this.tvCurrent$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvInfo() {
        Object value = this.tvInfo$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvLatest() {
        Object value = this.tvLatest$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvSpeed() {
        Object value = this.tvSpeed$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvStep() {
        Object value = this.tvStep$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.OOXIXo
    public final TextView getTvTip() {
        Object value = this.tvTip$delegate.getValue();
        kotlin.jvm.internal.IIX0o.oO(value, "getValue(...)");
        return (TextView) value;
    }

    @OXOo.oOoXoXO
    public final TextView getTvTopTip() {
        return this.tvTopTip;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        String string;
        this.tvTopTip = (TextView) findViewById(R.id.tv_firmware_upgrade_top_tip);
        this.isAutoUpdate = getIntent().getBooleanExtra("isAutoUpdate", false);
        BleInitializer.f20700XO.xx0X0(true);
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.firmware_upgrade);
        ProgressButton.X0o0xo(getProgressButton(), R.string.upgrade, false, 2, null);
        TextView tvTip = getTvTip();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.o0xIoII() && !productManager.xIx() && !productManager.xxxI()) {
            string = getString(R.string.jl_firmware_upgrade_tip);
        } else {
            string = getString(R.string.jl_firmware_upgrade_support_dual_backup_tip);
        }
        tvTip.setText(string);
    }

    public final boolean isAutoUpdate() {
        return this.isAutoUpdate;
    }

    public boolean isNeedLaunch() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_firmware_upgrade;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mStarted) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onDestroy() {
        BleInitializer.f20700XO.xx0X0(false);
        BleCache bleCache = BleCache.INSTANCE;
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST2, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_REALTIME3, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.WEATHER_FORECAST3, null, 2, null);
        if (isNeedLaunch()) {
            BleConnector.INSTANCE.launch();
        }
        super.onDestroy();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }

    public final void setAutoUpdate(boolean z) {
        this.isAutoUpdate = z;
    }

    public final void setMCurrentVersion(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mCurrentVersion = str;
    }

    public final void setMStarted(boolean z) {
        this.mStarted = z;
        getProgressButton().setEnabled(!z);
        if (z) {
            disableOrientation();
        }
    }

    public final void setMTargetVersion(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.mTargetVersion = str;
    }

    public final void setTvTopTip(@OXOo.oOoXoXO TextView textView) {
        this.tvTopTip = textView;
    }

    public final void updateDeviceInfo(@OXOo.OOXIXo String firmwareVersion) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().remove(FirmwareVersion.class.getName());
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
        BleCache.putString$default(BleCache.INSTANCE, BleKey.FIRMWARE_VERSION, firmwareVersion, null, 4, null);
        RequestCommonMethod.INSTANCE.updateDeviceInfo(new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$updateDeviceInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
            }
        });
    }

    public final void uploadDownloadInfo(@OXOo.OOXIXo String url, @OXOo.OOXIXo String fileName, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
        kotlin.jvm.internal.IIX0o.x0xO0oo(fileName, "fileName");
        StatManager.f20200oIX0oI.I0Io(url, FileUtils.getLength(new File(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), fileName)), 0, i);
    }

    public final void uploadOtaRecord(@OXOo.OOXIXo String successFlag, @OXOo.oOoXoXO String str, @OXOo.OOXIXo String otaType, @OXOo.OOXIXo String currentVersion, @OXOo.OOXIXo String targetVersion) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(successFlag, "successFlag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(otaType, "otaType");
        kotlin.jvm.internal.IIX0o.x0xO0oo(currentVersion, "currentVersion");
        kotlin.jvm.internal.IIX0o.x0xO0oo(targetVersion, "targetVersion");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        hashMap.put(UploadOtaRecord.CURRENT_VERSION, currentVersion);
        hashMap.put(UploadOtaRecord.TARGET_VERSION, targetVersion);
        hashMap.put(UploadOtaRecord.OTA_TYPE, otaType);
        hashMap.put(UploadOtaRecord.SUCCESS_FLAG, successFlag);
        if (str == null) {
            str = "";
        }
        hashMap.put(UploadOtaRecord.REMARK, str);
        final xxxI.II0xO0<Object> iI0xO0 = new xxxI.II0xO0<Object>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$uploadOtaRecord$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Object obj) {
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UploadOtaRecord.URL);
        netWorkUtils.printParam(convertBaseUrl + UploadOtaRecord.URL, kotlin.collections.o0.xoIxX(hashMap, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + UploadOtaRecord.URL;
        final xxxI.II0xO0<Response<Object>> iI0xO02 = new xxxI.II0xO0<Response<Object>>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$uploadOtaRecord$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Object> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str2).addHeaders(headersMap).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Object.class), new ParsedRequestListener<Response<Object>>() { // from class: com.sma.smartv3.ui.device.BaseFirmwareUpgradeActivity$uploadOtaRecord$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Object> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                String str5;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", exception:");
                if (aNError != null) {
                    str5 = aNError.getLocalizedMessage();
                } else {
                    str5 = null;
                }
                sb.append(str5);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }
}
