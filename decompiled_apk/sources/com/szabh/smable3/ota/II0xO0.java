package com.szabh.smable3.ota;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.jl_bt_ota.interfaces.BtEventCallback;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener;
import com.jieli.watchtesttool.tool.bluetooth.BluetoothHelper;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.jieli.watchtesttool.util.JL_LogUtils;
import com.szabh.smable3.component.BleCache;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nJOTAManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JOTAManager.kt\ncom/szabh/smable3/ota/JOTAManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
/* loaded from: classes13.dex */
public final class II0xO0 extends com.szabh.smable3.ota.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f26451II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @oOoXoXO
    public String f26452OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @oOoXoXO
    public BluetoothHelper f26453Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final String f26454X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f26455XO;

    /* renamed from: xoIox, reason: collision with root package name */
    @oOoXoXO
    public OTAManager f26456xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final BtEventCallback f26457xxIXOIIO;

    /* loaded from: classes13.dex */
    public static final class I0Io implements IUpgradeCallback {
        public I0Io() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onCancelOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onCancelOTA");
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 7, null, XIXIX.OOXIXo.f3760XO, 6, null);
            II0xO0.this.oI0IIXIo();
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onError(@oOoXoXO BaseError baseError) {
            String str;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onError -> " + baseError);
            II0xO0 iI0xO0 = II0xO0.this;
            if (baseError != null) {
                str = baseError.getMessage();
            } else {
                str = null;
            }
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(iI0xO0, 7, String.valueOf(str), XIXIX.OOXIXo.f3760XO, 4, null);
            II0xO0.this.oI0IIXIo();
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onNeedReconnect(@oOoXoXO String str, boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onNeedReconnect : " + str + ", " + z);
            II0xO0.this.f26455XO = true;
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onProgress(int i, float f) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onProgress -> " + i + TokenParser.SP + f);
            if (i == 0) {
                com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 4, null, Math.round(f) / 100.0d, 2, null);
            } else {
                com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 5, null, Math.round(f) / 100.0d, 2, null);
            }
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStartOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onStartOTA");
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 3, null, XIXIX.OOXIXo.f3760XO, 6, null);
        }

        @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
        public void onStopOTA() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " onStopOTA upgrade ok");
            com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 6, null, XIXIX.OOXIXo.f3760XO, 6, null);
            II0xO0.this.f26455XO = false;
            II0xO0.this.oI0IIXIo();
        }
    }

    /* renamed from: com.szabh.smable3.ota.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C1082II0xO0 extends BtEventCallback {
        public C1082II0xO0() {
        }

        @Override // com.jieli.jl_bt_ota.interfaces.BtEventCallback, com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
        public void onConnection(@OOXIXo BluetoothDevice device, int i) {
            IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(II0xO0.this.f26454X0o0xo);
            sb.append(" ota onConnection -> mOtaStatus = ");
            sb.append(II0xO0.this.oxoX());
            sb.append(", ");
            sb.append(device);
            sb.append(" ,status = ");
            sb.append(i);
            sb.append(" ,isOTA = ");
            OTAManager oTAManager = II0xO0.this.f26456xoIox;
            IIX0o.ooOOo0oXI(oTAManager);
            sb.append(oTAManager.isOTA());
            oix0oi.oIX0oI(sb.toString());
            OTAManager oTAManager2 = II0xO0.this.f26456xoIox;
            IIX0o.ooOOo0oXI(oTAManager2);
            if (!oTAManager2.isOTA()) {
                if (i != 0) {
                    if (i == 1) {
                        II0xO0 iI0xO0 = II0xO0.this;
                        if (iI0xO0.IXxxXO(iI0xO0.oxoX())) {
                            II0xO0.this.xoXoI();
                            return;
                        }
                        return;
                    }
                    return;
                }
                oix0oi.oIX0oI(II0xO0.this.f26454X0o0xo + " ota onConnection -> device disconnected");
                if (II0xO0.this.oxoX() == 1) {
                    com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 2, "device disconnected", XIXIX.OOXIXo.f3760XO, 4, null);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public static final class oIX0oI extends BluetoothEventListener {
        public oIX0oI() {
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onAdapterStatus(boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " bt onAdapterStatus " + z);
            if (!z) {
                com.szabh.smable3.ota.oIX0oI.oOoXoXO(II0xO0.this, 7, "Bluethooth disable", XIXIX.OOXIXo.f3760XO, 4, null);
            }
        }

        @Override // com.jieli.watchtesttool.tool.bluetooth.BluetoothEventListener
        public void onConnection(@OOXIXo BluetoothDevice device, int i) {
            IIX0o.x0xO0oo(device, "device");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(II0xO0.this.f26454X0o0xo + " bt onConnection " + device + TokenParser.SP + i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public II0xO0(@OOXIXo Context context, @OOXIXo com.szabh.smable3.ota.I0Io callback) {
        super(context, callback);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        this.f26454X0o0xo = "JOTAManager";
        this.f26451II0XooXoX = new oIX0oI();
        this.f26457xxIXOIIO = new C1082II0xO0();
        JL_LogUtils.enableLog(I0Io());
    }

    public final boolean IIXOooo(int i) {
        return i == 2 || i == 7;
    }

    public final boolean IXxxXO(int i) {
        if (!IIXOooo(i) && i != 6) {
            return true;
        }
        return false;
    }

    public final void Oxx0xo(String str) {
        BluetoothDevice bluetoothDevice;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26454X0o0xo + " connectDevice: " + str);
        BluetoothHelper bluetoothHelper = this.f26453Oxx0IOOO;
        if (bluetoothHelper != null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                bluetoothDevice = defaultAdapter.getRemoteDevice(str);
            } else {
                bluetoothDevice = null;
            }
            bluetoothHelper.connectDevice(bluetoothDevice);
        }
    }

    public final void OxxIIOOXO() {
        BluetoothHelper bluetoothHelper = BluetoothHelper.getInstance(Utils.getApp());
        this.f26453Oxx0IOOO = bluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.addBluetoothEventListener(this.f26451II0XooXoX);
        }
        OTAManager oTAManager = new OTAManager(I0Io());
        this.f26456xoIox = oTAManager;
        oTAManager.registerBluetoothCallback(this.f26457xxIXOIIO);
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void X0o0xo() {
        oI0IIXIo();
    }

    public final void oI0IIXIo() {
        OTAManager oTAManager = this.f26456xoIox;
        if (oTAManager != null) {
            oTAManager.unregisterBluetoothCallback(this.f26457xxIXOIIO);
        }
        OTAManager oTAManager2 = this.f26456xoIox;
        if (oTAManager2 != null) {
            oTAManager2.release();
        }
        this.f26456xoIox = null;
        BluetoothHelper bluetoothHelper = this.f26453Oxx0IOOO;
        if (bluetoothHelper != null) {
            bluetoothHelper.removeBluetoothEventListener(this.f26451II0XooXoX);
        }
        BluetoothHelper bluetoothHelper2 = this.f26453Oxx0IOOO;
        if (bluetoothHelper2 != null) {
            bluetoothHelper2.destroy();
        }
        this.f26453Oxx0IOOO = null;
    }

    public final void xoXoI() {
        BluetoothOTAConfigure bluetoothOTAConfigure;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f26454X0o0xo + " startOtaProcess :: " + this.f26452OOXIXo);
        OTAManager oTAManager = this.f26456xoIox;
        if (oTAManager != null) {
            bluetoothOTAConfigure = oTAManager.getBluetoothOption();
        } else {
            bluetoothOTAConfigure = null;
        }
        if (bluetoothOTAConfigure != null) {
            bluetoothOTAConfigure.setFirmwareFilePath(this.f26452OOXIXo);
        }
        OTAManager oTAManager2 = this.f26456xoIox;
        if (oTAManager2 != null) {
            oTAManager2.startOTA(new I0Io());
        }
    }

    @Override // com.szabh.smable3.ota.oIX0oI
    public void xxIXOIIO(@OOXIXo String filePath, @oOoXoXO String str, boolean z) {
        String str2;
        IIX0o.x0xO0oo(filePath, "filePath");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f26454X0o0xo + " startOTA -> " + filePath + ", " + str + ", " + z);
        oI0IIXIo();
        OxxIIOOXO();
        this.f26452OOXIXo = filePath;
        if (TextUtils.isEmpty(str)) {
            str = BleCache.INSTANCE.getMBleAddress();
        }
        XO(str);
        if (!this.f26455XO && !z) {
            oix0oi.oIX0oI(this.f26454X0o0xo + " upgrade -> use bleAddress");
            Oxx0xo(II0xO0());
        } else {
            oix0oi.oIX0oI(this.f26454X0o0xo + " upgrade -> use dfuAddress");
            String II0xO02 = II0xO0();
            if (II0xO02 != null) {
                str2 = oIX0oI(II0xO02);
            } else {
                str2 = null;
            }
            Oxx0xo(str2);
        }
        com.szabh.smable3.ota.oIX0oI.oOoXoXO(this, 1, null, XIXIX.OOXIXo.f3760XO, 6, null);
    }
}
