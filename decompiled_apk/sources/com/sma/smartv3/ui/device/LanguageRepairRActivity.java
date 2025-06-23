package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
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

@kotlin.jvm.internal.XX({"SMAP\nLanguageRepairRActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageRepairRActivity.kt\ncom/sma/smartv3/ui/device/LanguageRepairRActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,155:1\n18#2,2:156\n15#2:158\n27#2,2:159\n*S KotlinDebug\n*F\n+ 1 LanguageRepairRActivity.kt\ncom/sma/smartv3/ui/device/LanguageRepairRActivity\n*L\n85#1:156,2\n85#1:158\n148#1:159,2\n*E\n"})
/* loaded from: classes12.dex */
public final class LanguageRepairRActivity extends BaseFirmwareRepairActivity {

    @OXOo.OOXIXo
    private final DfuConfig mDfuConfig;

    @OXOo.OOXIXo
    private final ExtraPackageData mLanguageData;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDfuHelper$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<GattDfuAdapter>() { // from class: com.sma.smartv3.ui.device.LanguageRepairRActivity$mDfuHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final GattDfuAdapter invoke() {
            Activity mContext;
            mContext = LanguageRepairRActivity.this.getMContext();
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
            LanguageRepairRActivity.this.setMStarted(false);
            LanguageRepairRActivity.this.getTvTip().setText(com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo());
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProcessStateChanged(int i, @OXOo.oOoXoXO Throughput throughput) {
            LogUtils.d("onProcessStateChanged " + i + TokenParser.SP + LanguageRepairRActivity.this.mLanguageData.getType());
            if (i == 258) {
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24413XI0IXoo, LanguageRepairRActivity.this.mLanguageData.getType());
                LanguageRepairRActivity.this.finish();
            }
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onProgressChanged(@OXOo.OOXIXo DfuProgressInfo progressInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(progressInfo, "progressInfo");
            LanguageRepairRActivity.this.getDfuProgress().setProgress(progressInfo.getProgress() / 100.0f);
        }

        @Override // com.realsil.sdk.dfu.utils.DfuAdapter.DfuHelperCallback
        public void onStateChanged(int i) {
            LogUtils.d("onStateChanged " + i);
            if (i != 258) {
                if (i == 4097) {
                    LanguageRepairRActivity.this.setMStarted(false);
                    LanguageRepairRActivity.this.getTvTip().setText(com.sma.smartv3.util.oO.f24511oIX0oI.X0o0xo());
                    return;
                }
                return;
            }
            LanguageRepairRActivity.this.setMStarted(true);
            LanguageRepairRActivity.this.getTvTip().setText(R.string.downloading);
            LanguageRepairRActivity.this.downloadLanguagePage();
        }
    }

    public LanguageRepairRActivity() {
        DfuConfig dfuConfig = new DfuConfig();
        dfuConfig.setAddress(BleCache.INSTANCE.getMDfuAddress());
        dfuConfig.setAutomaticActiveEnabled(true);
        dfuConfig.setFileLocation(0);
        this.mDfuConfig = dfuConfig;
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(ExtraPackageData.class.getName()), (Class<Object>) ExtraPackageData.class);
        this.mLanguageData = (ExtraPackageData) (fromJson == null ? ExtraPackageData.class.newInstance() : fromJson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadLanguagePage() {
        NetWorkUtils.INSTANCE.download(this.mLanguageData.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLanguageData.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.LanguageRepairRActivity$downloadLanguagePage$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                LanguageRepairRActivity.this.setMStarted(false);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                LanguageRepairRActivity.this.upgrade();
            }
        });
    }

    private final GattDfuAdapter getMDfuHelper() {
        return (GattDfuAdapter) this.mDfuHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LanguageRepairRActivity this$0, View view) {
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
        dfuConfig.setFilePath(new File(com.sma.smartv3.initializer.IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLanguageData.getFileName()).getAbsolutePath());
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
        ((TextView) findViewById(R.id.abh_title_center)).setText(getMArg1());
        getTvName().setText(getMArg0());
        getTvSize().setText(ConvertUtils.byte2FitMemorySize(this.mLanguageData.getFileSize()));
        getTvTip().setText(R.string.preparing);
        getTvTip().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.I0xX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageRepairRActivity.initView$lambda$1(LanguageRepairRActivity.this, view);
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
