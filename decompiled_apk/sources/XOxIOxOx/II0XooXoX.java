package XOxIOxOx;

import XOxIOxOx.II0XooXoX;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.text.TextUtils;
import com.bestmafen.baseble.scanner.BleDevice;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleScanner18.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleScanner18.kt\ncom/bestmafen/baseble/scanner/BleScanner18\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
/* loaded from: classes8.dex */
public final class II0XooXoX extends XOxIOxOx.II0xO0 {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3952ooOOo0oXI = new oIX0oI(null);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f3953x0XOIxOo = "BleScanner18";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public BluetoothAdapter.LeScanCallback f3954oOoXoXO;

    /* loaded from: classes8.dex */
    public static final class II0xO0 implements BluetoothAdapter.LeScanCallback {
        public II0xO0() {
        }

        public static final void II0xO0(II0XooXoX this$0, BleDevice bleDevice) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(bleDevice, "$bleDevice");
            oxoX I0Io2 = this$0.I0Io();
            if (I0Io2 != null) {
                I0Io2.II0xO0(bleDevice);
            }
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(@OXOo.oOoXoXO BluetoothDevice bluetoothDevice, int i, @OXOo.oOoXoXO byte[] bArr) {
            if (!II0XooXoX.this.xxIXOIIO() || bluetoothDevice == null) {
                return;
            }
            String name = bluetoothDevice.getName();
            String address = bluetoothDevice.getAddress();
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(address)) {
                IIX0o.ooOOo0oXI(name);
                int type = bluetoothDevice.getType();
                String address2 = bluetoothDevice.getAddress();
                IIX0o.oO(address2, "getAddress(...)");
                final BleDevice bleDevice = new BleDevice(bluetoothDevice, i, bArr, name, type, address2);
                if (II0XooXoX.this.XO() != null) {
                    X0o0xo XO2 = II0XooXoX.this.XO();
                    IIX0o.ooOOo0oXI(XO2);
                    if (!XO2.oIX0oI(bleDevice)) {
                        return;
                    }
                }
                OI0.oIX0oI.f1507oIX0oI.oxoX("BleScanner18 onDeviceFound -> " + bleDevice);
                Handler X0o0xo2 = II0XooXoX.this.X0o0xo();
                final II0XooXoX iI0XooXoX = II0XooXoX.this;
                X0o0xo2.post(new Runnable() { // from class: XOxIOxOx.xxIXOIIO
                    @Override // java.lang.Runnable
                    public final void run() {
                        II0XooXoX.II0xO0.II0xO0(II0XooXoX.this, bleDevice);
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final void o00(II0XooXoX this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oxoX I0Io2 = this$0.I0Io();
        if (I0Io2 != null) {
            I0Io2.oIX0oI(this$0.xxIXOIIO());
        }
    }

    public static final void xoXoI(II0XooXoX this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oxoX I0Io2 = this$0.I0Io();
        if (I0Io2 != null) {
            I0Io2.I0Io();
        }
    }

    @Override // XOxIOxOx.II0xO0
    public void II0xO0() {
        super.II0xO0();
        this.f3954oOoXoXO = null;
    }

    @Override // XOxIOxOx.II0xO0
    public synchronized void oOoXoXO(boolean z) {
        if (I0Io() != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleScanner18 scan " + z + " -> isScanning=" + xxIXOIIO());
            if (xxIXOIIO() == z) {
                return;
            }
            if (z) {
                if (!oxoX().isEnabled()) {
                    X0o0xo().post(new Runnable() { // from class: XOxIOxOx.XO
                        @Override // java.lang.Runnable
                        public final void run() {
                            II0XooXoX.xoXoI(II0XooXoX.this);
                        }
                    });
                    return;
                } else {
                    oxoX().startLeScan(II0XooXoX(), this.f3954oOoXoXO);
                    oI0IIXIo();
                }
            } else {
                oxoX().stopLeScan(this.f3954oOoXoXO);
                OOXIXo();
            }
            Oxx0xo(z);
            X0o0xo().post(new Runnable() { // from class: XOxIOxOx.Oxx0IOOO
                @Override // java.lang.Runnable
                public final void run() {
                    II0XooXoX.o00(II0XooXoX.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("BleScanCallback cannot be null");
    }

    public /* synthetic */ II0XooXoX(UUID[] uuidArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : uuidArr);
    }

    public II0XooXoX(@OXOo.oOoXoXO UUID[] uuidArr) {
        super(uuidArr, null, 2, null);
        this.f3954oOoXoXO = new II0xO0();
    }
}
