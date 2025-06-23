package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
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
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.network.NetWorkUtils;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.io.File;

@kotlin.jvm.internal.XX({"SMAP\nUiRepairRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UiRepairRActivity.kt\ncom/sma/smartv3/ui/device/UiRepairRActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,154:1\n18#2,2:155\n15#2:157\n27#2,2:158\n*S KotlinDebug\n*F\n+ 1 UiRepairRActivity.kt\ncom/sma/smartv3/ui/device/UiRepairRActivity\n*L\n84#1:155,2\n84#1:157\n147#1:158,2\n*E\n"})
/* loaded from: classes12.dex */
public final class UiRepairRActivity extends BaseFirmwareRepairActivity {

    @OXOo.OOXIXo
    private final DfuConfig mDfuConfig;

    @OXOo.OOXIXo
    private final ExtraPackageData mUiData;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.device.UiRepairRActivity$mDfuHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final GattDfuAdapter invoke() {
            Activity mContext;
            mContext = UiRepairRActivity.this.getMContext();
            return GattDfuAdapter.getInstance(mContext);
        }
    });

    @OXOo.OOXIXo
    private final oIX0oI mDfuCallback = new oIX0oI();

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends DfuAdapter.DfuHelperCallback {
        public oIX0oI() {
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onError(int i, int i2) {
            LogUtils.e("FirmwareUpgradeRActivity onError: type=" + i + ", code" + i2);
            UiRepairRActivity.this.setMStarted(false);
            UiRepairRActivity.this.getTvTip().setText(com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo());
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(int i, @OXOo.oOoXoXO Throughput throughput) {
            LogUtils.d("onProcessStateChanged " + i);
            if (i == 258) {
                ToastUtils.showLong(R.string.repair_successful);
                UiRepairRActivity.this.finish();
            }
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            UiRepairRActivity.this.getDfuProgress().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(int i) {
            LogUtils.d("onStateChanged " + i);
            if (i != 258) {
                if (i == 4097) {
                    UiRepairRActivity.this.setMStarted(false);
                    UiRepairRActivity.this.getTvTip().setText(com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo());
                    return;
                }
                return;
            }
            UiRepairRActivity.this.setMStarted(true);
            UiRepairRActivity.this.getTvTip().setText(R.string.downloading);
            UiRepairRActivity.this.downloadLanguagePage();
        }
    }

    public UiRepairRActivity() {
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(BleCache.INSTANCE.getMDfuAddress());
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        this.mDfuConfig = dfuConfig;
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(ExtraPackageData.class.getName()), (Class<Object>) ExtraPackageData.class);
        this.mUiData = (ExtraPackageData) (fromJson == null ? ExtraPackageData.class.newInstance() : fromJson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadLanguagePage() {
        NetWorkUtils.INSTANCE.download(this.mUiData.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mUiData.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.UiRepairRActivity$downloadLanguagePage$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                UiRepairRActivity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                UiRepairRActivity.this.upgrade();
            }
        });
    }

    private final GattDfuAdapter getMDfuHelper() {
        return (GattDfuAdapter) this.mDfuHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UiRepairRActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.getMStarted()) {
            this$0.upgrade();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        setMStarted(true);
        LogUtils.d("upgrade");
        getTvTip().setText(R.string.starting);
        DfuConfig dfuConfig = this.mDfuConfig;
        dfuConfig.setOtaWorkMode(16);
        dfuConfig.setFilePath(new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI), this.mUiData.getFileName()).getAbsolutePath());
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.startOtaProcess(dfuConfig);
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.closeConnection(true);
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        setMStarted(false);
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.ui_repair);
        getTvName().setText(this.mUiData.getVersion());
        getTvSize().setText(ConvertUtils.byte2FitMemorySize(this.mUiData.getFileSize()));
        getTvTip().setText(R.string.preparing);
        getTvTip().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.O0o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UiRepairRActivity.initView$lambda$1(UiRepairRActivity.this, view);
            }
        });
        getMDfuHelper().initialize(this.mDfuCallback);
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
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().remove(ExtraPackageData.class.getName());
        GattDfuAdapter mDfuHelper = getMDfuHelper();
        if (mDfuHelper != null) {
            mDfuHelper.abort();
            mDfuHelper.close();
        }
        super.onDestroy();
    }
}
