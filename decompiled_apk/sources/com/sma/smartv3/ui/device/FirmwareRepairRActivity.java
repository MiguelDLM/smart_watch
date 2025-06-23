package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.realsil.sdk.dfu.utils.GattDfuAdapter;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.FirmwareRepairRActivity;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.io.File;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairRActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,153:1\n15#2:154\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairRActivity\n*L\n37#1:154\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairRActivity extends BaseFirmwareRepairActivity {

    @OXOo.OOXIXo
    private final DfuConfig mDfuConfig;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairRActivity$mDfuHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final GattDfuAdapter invoke() {
            Activity mContext;
            mContext = FirmwareRepairRActivity.this.getMContext();
            return GattDfuAdapter.getInstance(mContext);
        }
    });

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware = (FirmwareVersion) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);

    @OXOo.OOXIXo
    private final oIX0oI mDfuCallback = new oIX0oI();

    @kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairRActivity$mDfuCallback$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,153:1\n27#2,2:154\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairRActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairRActivity$mDfuCallback$1\n*L\n65#1:154,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI extends DfuAdapter.DfuHelperCallback {
        public oIX0oI() {
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            LogUtils.e("FirmwareUpgradeRActivity onError: type=" + i + ", code" + i2);
            FirmwareRepairRActivity.this.setMStarted(false);
            FirmwareRepairRActivity.this.getTvTip().setText(R.string.firmware_upgrading_failed);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(int i, @OXOo.oOoXoXO Throughput throughput) {
            LogUtils.d("onProcessStateChanged " + i);
            if (i == 258) {
                ToastUtils.showLong(R.string.repair_successful);
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().remove(FirmwareVersion.class.getName());
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24613XOxIOxOx, null, 2, null);
                FirmwareRepairRActivity.this.finish();
            }
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            FirmwareRepairRActivity.this.getDfuProgress().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(int i) {
            LogUtils.d("onStateChanged " + i);
            if (i != 258) {
                if (i == 4097) {
                    FirmwareRepairRActivity.this.setMStarted(false);
                    FirmwareRepairRActivity.this.getTvTip().setText(R.string.firmware_upgrading_failed);
                    return;
                }
                return;
            }
            FirmwareRepairRActivity.this.setMStarted(true);
            FirmwareRepairRActivity.this.upgrade();
        }
    }

    public FirmwareRepairRActivity() {
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(BleCache.INSTANCE.getMDfuAddress());
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        this.mDfuConfig = dfuConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GattDfuAdapter getMDfuHelper() {
        return (GattDfuAdapter) this.mDfuHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        setMStarted(true);
        LogUtils.d("upgrade");
        getTvTip().setText(R.string.starting);
        DfuConfig dfuConfig = this.mDfuConfig;
        dfuConfig.setAddress(BleCache.INSTANCE.getMDfuAddress());
        dfuConfig.setOtaWorkMode(0);
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setVersionCheckEnabled(false);
        File oOoXoXO2 = com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI);
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
        dfuConfig.setFilePath(new File(oOoXoXO2, firmwareVersion.getFileName()).getAbsolutePath());
        dfuConfig.setFileLocation(0);
        getMDfuHelper().startOtaProcess(dfuConfig);
        getTvSize().setText(FileUtils.getSize(this.mDfuConfig.getFilePath()));
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.closeConnection(true);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String str;
        super.initView();
        setMStarted(true);
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.firmware_repair);
        TextView tvName = getTvName();
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        Integer num = null;
        if (firmwareVersion != null) {
            str = firmwareVersion.getFileName();
        } else {
            str = null;
        }
        tvName.setText(str);
        FirmwareVersion firmwareVersion2 = this.mLatestFirmware;
        if (firmwareVersion2 != null) {
            num = Integer.valueOf(firmwareVersion2.getFileSize());
        }
        if (num != null) {
            getTvSize().setText(ConvertUtils.byte2FitMemorySize(this.mLatestFirmware.getFileSize()));
        }
        getTvTip().setText(R.string.downloading);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        FirmwareVersion firmwareVersion3 = this.mLatestFirmware;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion3);
        netWorkUtils.download(firmwareVersion3.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatestFirmware.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairRActivity$initView$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                FirmwareRepairRActivity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str2) {
                GattDfuAdapter mDfuHelper;
                FirmwareRepairRActivity.oIX0oI oix0oi;
                mDfuHelper = FirmwareRepairRActivity.this.getMDfuHelper();
                oix0oi = FirmwareRepairRActivity.this.mDfuCallback;
                mDfuHelper.initialize(oix0oi);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setMStarted(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getMStarted()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.abort();
            mDfuHelper.close();
        }
        super.onDestroy();
    }
}
