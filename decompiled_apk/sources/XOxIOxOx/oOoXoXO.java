package XOxIOxOx;

import XOxIOxOx.oOoXoXO;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bestmafen.baseble.scanner.BleDevice;
import com.bestmafen.baseble.scanner.ScanMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleScanner21.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleScanner21.kt\ncom/bestmafen/baseble/scanner/BleScanner21\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,108:1\n13309#2,2:109\n*S KotlinDebug\n*F\n+ 1 BleScanner21.kt\ncom/bestmafen/baseble/scanner/BleScanner21\n*L\n62#1:109,2\n*E\n"})
@RequiresApi(21)
/* loaded from: classes8.dex */
public final class oOoXoXO extends XOxIOxOx.II0xO0 {

    /* renamed from: oO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3972oO = new oIX0oI(null);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f3973x0xO0oo = "BleScanner21";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<ScanFilter> f3974oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ScanSettings.Builder f3975ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public ScanCallback f3976x0XOIxOo;

    /* loaded from: classes8.dex */
    public static final class I0Io extends ScanCallback {
        public I0Io() {
        }

        public static final void II0xO0(oOoXoXO this$0, BleDevice bleDevice) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(bleDevice, "$bleDevice");
            oxoX I0Io2 = this$0.I0Io();
            if (I0Io2 != null) {
                I0Io2.II0xO0(bleDevice);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, @OXOo.oOoXoXO ScanResult scanResult) {
            BluetoothDevice device;
            byte[] bArr;
            if (!oOoXoXO.this.xxIXOIIO() || scanResult == null || (device = scanResult.getDevice()) == null) {
                return;
            }
            String II0xO02 = x0XOIxOo.II0xO0(scanResult);
            String address = device.getAddress();
            if (!TextUtils.isEmpty(II0xO02) && !TextUtils.isEmpty(address)) {
                int rssi = scanResult.getRssi();
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord != null) {
                    bArr = scanRecord.getBytes();
                } else {
                    bArr = null;
                }
                byte[] bArr2 = bArr;
                IIX0o.ooOOo0oXI(II0xO02);
                int type = device.getType();
                String address2 = device.getAddress();
                IIX0o.oO(address2, "getAddress(...)");
                final BleDevice bleDevice = new BleDevice(device, rssi, bArr2, II0xO02, type, address2);
                OI0.oIX0oI.f1507oIX0oI.oxoX("BleScanner21 onScanResult -> " + bleDevice);
                if (oOoXoXO.this.XO() != null) {
                    X0o0xo XO2 = oOoXoXO.this.XO();
                    IIX0o.ooOOo0oXI(XO2);
                    if (!XO2.oIX0oI(bleDevice)) {
                        return;
                    }
                }
                Handler X0o0xo2 = oOoXoXO.this.X0o0xo();
                final oOoXoXO oooxoxo = oOoXoXO.this;
                X0o0xo2.post(new Runnable() { // from class: XOxIOxOx.ooOOo0oXI
                    @Override // java.lang.Runnable
                    public final void run() {
                        oOoXoXO.I0Io.II0xO0(oOoXoXO.this, bleDevice);
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f3978oIX0oI;

        static {
            int[] iArr = new int[ScanMode.values().length];
            try {
                iArr[ScanMode.LOW_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScanMode.BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScanMode.LOW_LATENCY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3978oIX0oI = iArr;
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
    public oOoXoXO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static final void OxI(oOoXoXO this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oxoX I0Io2 = this$0.I0Io();
        if (I0Io2 != null) {
            I0Io2.oIX0oI(this$0.xxIXOIIO());
        }
    }

    public static final void o00(oOoXoXO this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oxoX I0Io2 = this$0.I0Io();
        if (I0Io2 != null) {
            I0Io2.I0Io();
        }
    }

    @Override // XOxIOxOx.II0xO0
    public void II0xO0() {
        super.II0xO0();
        this.f3976x0XOIxOo = null;
    }

    @Override // XOxIOxOx.II0xO0
    public synchronized void oOoXoXO(boolean z) {
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleScanner21 scan " + z + " -> isScanning=" + xxIXOIIO() + " , scanMode=" + xoXoI().getScanMode());
            if (xxIXOIIO() == z) {
                return;
            }
            BluetoothLeScanner bluetoothLeScanner = oxoX().getBluetoothLeScanner();
            if (z) {
                if (oxoX().isEnabled() && bluetoothLeScanner != null) {
                    try {
                        bluetoothLeScanner.startScan(this.f3974oOoXoXO, xoXoI(), this.f3976x0XOIxOo);
                        oI0IIXIo();
                        Oxx0xo(z);
                        X0o0xo().post(new Runnable() { // from class: XOxIOxOx.OOXIXo
                            @Override // java.lang.Runnable
                            public final void run() {
                                oOoXoXO.OxI(oOoXoXO.this);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                X0o0xo().post(new Runnable() { // from class: XOxIOxOx.xoIox
                    @Override // java.lang.Runnable
                    public final void run() {
                        oOoXoXO.o00(oOoXoXO.this);
                    }
                });
                return;
            }
            if (bluetoothLeScanner != null) {
                try {
                    bluetoothLeScanner.stopScan(this.f3976x0XOIxOo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            OOXIXo();
            Oxx0xo(z);
            X0o0xo().post(new Runnable() { // from class: XOxIOxOx.OOXIXo
                @Override // java.lang.Runnable
                public final void run() {
                    oOoXoXO.OxI(oOoXoXO.this);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    public final ScanSettings xoXoI() {
        ScanSettings.Builder builder = this.f3975ooOOo0oXI;
        int i = II0xO0.f3978oIX0oI[Oxx0IOOO().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    builder.setScanMode(2);
                }
            } else {
                builder.setScanMode(1);
            }
        } else {
            builder.setScanMode(0);
        }
        return builder.build();
    }

    public /* synthetic */ oOoXoXO(UUID[] uuidArr, ScanMode scanMode, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : uuidArr, (i & 2) != 0 ? ScanMode.BALANCED : scanMode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oOoXoXO(@OXOo.oOoXoXO UUID[] uuidArr, @OXOo.OOXIXo ScanMode scanMode) {
        super(uuidArr, scanMode);
        IIX0o.x0xO0oo(scanMode, "scanMode");
        this.f3975ooOOo0oXI = new ScanSettings.Builder();
        this.f3976x0XOIxOo = new I0Io();
        if (II0XooXoX() != null) {
            this.f3974oOoXoXO = new ArrayList();
            for (UUID uuid : II0XooXoX()) {
                List<ScanFilter> list = this.f3974oOoXoXO;
                if (list != null) {
                    ScanFilter build = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(uuid)).build();
                    IIX0o.oO(build, "build(...)");
                    list.add(build);
                }
            }
        }
    }
}
