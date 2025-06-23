package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfu;
import com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback;
import com.google.gson.Gson;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.network.NetWorkUtils;
import com.szabh.androiddfu.goodix.DfuConnection;
import com.szabh.smable3.component.BleCache;
import java.io.File;
import java.io.FileInputStream;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairGQActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairGQActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairGQActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,120:1\n15#2:121\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairGQActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairGQActivity\n*L\n31#1:121\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairGQActivity extends BaseFirmwareRepairActivity implements Observer<Object>, FastDfuProgressCallback {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDevice$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BluetoothDevice>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairGQActivity$mDevice$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BluetoothDevice invoke() {
            return BluetoothAdapter.getDefaultAdapter().getRemoteDevice(BleCache.INSTANCE.getMDfuAddress());
        }
    });

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatest = (FirmwareVersion) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21775oIX0oI;

        static {
            int[] iArr = new int[DfuConnection.ConnState.values().length];
            try {
                iArr[DfuConnection.ConnState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DfuConnection.ConnState.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f21775oIX0oI = iArr;
        }
    }

    private final BluetoothDevice getMDevice() {
        return (BluetoothDevice) this.mDevice$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void upgrade() {
        LogUtils.d("start upgrade");
        setMStarted(true);
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.oxXx0IX
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareRepairGQActivity.upgrade$lambda$0(FirmwareRepairGQActivity.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upgrade$lambda$0(FirmwareRepairGQActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("start OTA");
        File file = new File(com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI));
        FirmwareVersion firmwareVersion = this$0.mLatest;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(firmwareVersion);
        FileInputStream fileInputStream = new FileInputStream(new File(file, firmwareVersion.getFileName()));
        FastDfu fastDfu = new FastDfu();
        fastDfu.setListener(this$0);
        fastDfu.startDfu(this$0, this$0.getMDevice(), fileInputStream);
        fileInputStream.close();
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.BaseFirmwareRepairActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (this.mLatest == null) {
            ToastUtils.showLong(R.string.not_found_repair_version);
            finish();
        } else {
            setMStarted(true);
            getTvName().setText(this.mLatest.getFileName());
            getTvSize().setText(ConvertUtils.byte2FitMemorySize(this.mLatest.getFileSize()));
            NetWorkUtils.INSTANCE.download(this.mLatest.getFileUrl(), com.sma.smartv3.initializer.IXxxXO.ooOOo0oXI(X00IoxXI.oIX0oI.f3233oIX0oI), this.mLatest.getFileName(), new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairGQActivity$initView$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                    FirmwareRepairGQActivity.this.setMStarted(false);
                }

                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                public void handleProgress(int i) {
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str) {
                    FirmwareRepairGQActivity.this.upgrade();
                }
            });
        }
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@OXOo.OOXIXo Object connState) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(connState, "connState");
        if (connState instanceof DfuConnection.ConnState) {
            int i = oIX0oI.f21775oIX0oI[((DfuConnection.ConnState) connState).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    LogUtils.d("DfuConnection.ConnState " + connState);
                    return;
                }
                LogUtils.d("DfuConnection.ConnState.READY");
                return;
            }
            setMStarted(false);
            getTvTip().setText(R.string.firmware_upgrading_failed);
        }
    }

    @Override // com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback
    public void onDfuComplete() {
        ToastUtils.showLong(R.string.repair_successful);
        finish();
    }

    @Override // com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback
    public void onDfuErase(int i) {
        getTvTip().setText(R.string.cache_cleaning);
    }

    @Override // com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback
    public void onDfuError(int i, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Error error) {
        setMStarted(false);
        getTvTip().setText(R.string.firmware_upgrading_failed);
    }

    @Override // com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback
    public void onDfuProgress(int i) {
        getTvTip().setText(R.string.firmware_repair_repairing_tip);
        getDfuProgress().setProgress(i / 100.0f);
    }

    @Override // com.goodix.ble.gr.toolbox.app.libfastdfu.FastDfuProgressCallback
    public void onDfuStart() {
        getTvTip().setText(R.string.starting);
    }
}
