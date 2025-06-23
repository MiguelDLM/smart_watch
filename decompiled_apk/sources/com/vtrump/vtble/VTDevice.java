package com.vtrump.vtble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class VTDevice {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f27371IXxxXO = "VTDevice";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static int f27372Oxx0xo = 100;

    /* renamed from: I0Io, reason: collision with root package name */
    public BluetoothDevice f27373I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f27375II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f27378Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f27379X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f27380XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f27381oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public VTDeviceStatus f27385oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList<oIX0oI> f27386x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public byte[] f27388xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public X0IIOO f27389xxIXOIIO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final int f27383oOoXoXO = 100;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final int f27384ooOOo0oXI = 101;

    /* renamed from: oO, reason: collision with root package name */
    public int f27382oO = 0;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public xoXoI f27387x0xO0oo = xoXoI.OOXIxO0();

    /* renamed from: Oo, reason: collision with root package name */
    public Handler f27377Oo = new I0Io();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f27376OOXIXo = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public byte[] f27374II0XooXoX = null;

    /* loaded from: classes13.dex */
    public class I0Io extends Handler {
        public I0Io() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 100) {
                oIX0oI oix0oi = (oIX0oI) message.obj;
                if (oix0oi == null) {
                    Oxx0xo.II0xO0(VTDevice.f27371IXxxXO, "write value: characteristicValue is null");
                    return;
                }
                byte[] bArr = oix0oi.f27395oxoX;
                Oxx0xo.oIX0oI(VTDevice.f27371IXxxXO, "write value: " + xxX.Oxx0xo(bArr) + ",characteristicValue:" + oix0oi.toString());
                VTDevice vTDevice = VTDevice.this;
                vTDevice.f27387x0xO0oo.XXXI(vTDevice, oix0oi.f27394oIX0oI, oix0oi.f27392II0xO0, bArr, oix0oi.f27391I0Io);
                return;
            }
            if (i != 101) {
                return;
            }
            if (VTDevice.this.f27386x0XOIxOo != null && VTDevice.this.f27386x0XOIxOo.size() > 0) {
                if (VTDevice.this.f27382oO < VTDevice.this.f27386x0XOIxOo.size()) {
                    oIX0oI oix0oi2 = (oIX0oI) VTDevice.this.f27386x0XOIxOo.get(VTDevice.this.f27382oO);
                    byte[] bArr2 = oix0oi2.f27395oxoX;
                    Oxx0xo.oIX0oI(VTDevice.f27371IXxxXO, "write value--queue: " + xxX.Oxx0xo(bArr2) + ",characteristicValueQueue:" + oix0oi2.toString());
                    VTDevice vTDevice2 = VTDevice.this;
                    vTDevice2.f27387x0xO0oo.XXXI(vTDevice2, oix0oi2.f27394oIX0oI, oix0oi2.f27392II0xO0, bArr2, oix0oi2.f27391I0Io);
                }
                if (VTDevice.this.f27382oO < VTDevice.this.f27386x0XOIxOo.size() - 1) {
                    VTDevice.this.f27377Oo.sendEmptyMessageDelayed(101, VTDevice.f27372Oxx0xo);
                    VTDevice.II0XooXoX(VTDevice.this);
                    return;
                } else {
                    VTDevice.this.f27386x0XOIxOo.clear();
                    VTDevice.this.f27382oO = 0;
                }
            }
            removeMessages(101);
        }
    }

    /* loaded from: classes13.dex */
    public static abstract class II0xO0 {
        public void oIX0oI(int i) {
        }
    }

    /* loaded from: classes13.dex */
    public enum VTDeviceStatus {
        STATUS_DISCOVERED,
        STATUS_CONNECTED,
        STATUS_SERVICE_DISCOVERED,
        STATUS_PAIRED,
        STATUS_DISCONNECTED
    }

    /* loaded from: classes13.dex */
    public class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public boolean f27391I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f27392II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f27394oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public byte[] f27395oxoX;

        public oIX0oI(String str, String str2, byte[] bArr, boolean z) {
            this.f27394oIX0oI = str;
            this.f27392II0xO0 = str2;
            this.f27391I0Io = z;
            this.f27395oxoX = bArr;
        }

        public String toString() {
            return "CharacteristicValue{writeSID='" + this.f27394oIX0oI + "', writeCid='" + this.f27392II0xO0 + "', writeResponse=" + this.f27391I0Io + ", writeValue=" + xxX.Oxx0xo(this.f27395oxoX) + '}';
        }
    }

    public VTDevice(BluetoothDevice bluetoothDevice, Context context) {
        this.f27373I0Io = bluetoothDevice;
        this.f27379X0o0xo = bluetoothDevice.getName();
        this.f27381oIX0oI = context;
    }

    public static /* synthetic */ int II0XooXoX(VTDevice vTDevice) {
        int i = vTDevice.f27382oO;
        vTDevice.f27382oO = i + 1;
        return i;
    }

    public void IIX0o(BluetoothDevice bluetoothDevice) {
        this.f27373I0Io = bluetoothDevice;
    }

    public byte[] IIXOooo() {
        return this.f27374II0XooXoX;
    }

    public void IO() {
        xoXoI OOXIxO02 = xoXoI.OOXIxO0();
        OOXIxO02.XXoOx0(this);
        OOXIxO02.IoXIXo(this);
    }

    public String IXxxXO() {
        return this.f27380XO;
    }

    public void IoOoX(byte[] bArr) {
        this.f27388xoIox = bArr;
    }

    public void O0xOxO() {
        X0IIOO(IXxxXO.f27254xxIXOIIO, IXxxXO.f27247xoIox);
    }

    public void OOXIXo() {
        try {
            Thread.sleep(f27372Oxx0xo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BluetoothDevice Oo() {
        return this.f27373I0Io;
    }

    public boolean OxI(VTDevice vTDevice) {
        BluetoothDevice bluetoothDevice;
        BluetoothDevice bluetoothDevice2;
        if (vTDevice == null || (bluetoothDevice = vTDevice.f27373I0Io) == null || (bluetoothDevice2 = this.f27373I0Io) == null) {
            return false;
        }
        return bluetoothDevice.equals(bluetoothDevice2);
    }

    public X0IIOO Oxx0xo() {
        return this.f27389xxIXOIIO;
    }

    public byte[] OxxIIOOXO() {
        return this.f27388xoIox;
    }

    public void X00IoxXI(VTDeviceStatus vTDeviceStatus) {
        this.f27385oxoX = vTDeviceStatus;
    }

    public void X0IIOO(String str, String str2) {
        xoXoI OOXIxO02 = xoXoI.OOXIxO0();
        OOXIXo();
        OOXIxO02.oxIIX0o(this, str, str2);
    }

    public void X0o0xo(String str, String str2, boolean z) {
        xoXoI OOXIxO02 = xoXoI.OOXIxO0();
        OOXIXo();
        OOXIxO02.oOoIIO0(this, str, str2, z);
    }

    public void XI0IXoo() {
        xoXoI.OOXIxO0().o0oIxOo(this);
    }

    public void XIxXXX0x0() {
        this.f27375II0xO0 = null;
    }

    public boolean XOxIOxOx(String str, String str2, byte[] bArr, boolean z, int i) {
        oIX0oI oix0oi = new oIX0oI(str, str2, bArr, z);
        if (this.f27377Oo.hasMessages(100) || this.f27377Oo.hasMessages(101)) {
            return true;
        }
        Message message = new Message();
        message.what = 100;
        message.obj = oix0oi;
        this.f27377Oo.sendMessageDelayed(message, i);
        return true;
    }

    public void Xx000oIo(boolean z) {
        this.f27376OOXIXo = z;
    }

    public void XxX0x0xxx(boolean z) {
        X0o0xo(IXxxXO.f27254xxIXOIIO, IXxxXO.f27247xoIox, z);
    }

    public boolean o00() {
        return this.f27376OOXIXo;
    }

    public String oI0IIXIo() {
        return this.f27379X0o0xo;
    }

    public void oO() {
        xoXoI.OOXIxO0().I0oOoX(this);
    }

    public void oOXoIIIo(byte[] bArr) {
        this.f27374II0XooXoX = bArr;
    }

    public void oOoXoXO(String str, String str2, byte[] bArr) {
        Oxx0xo.oIX0oI(f27371IXxxXO, "dataChangedNotify: " + xxX.IIXOooo(bArr));
    }

    public void oo(String str) {
        this.f27379X0o0xo = str;
    }

    public void oo0xXOI0I(X0IIOO x0iioo) {
        this.f27389xxIXOIIO = x0iioo;
    }

    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        if (str.equals(IXxxXO.f27173OOXIXo) && str2.equals(IXxxXO.f27236x0xO0oo)) {
            xI(xxX.IXxxXO(xxX.Oxx0xo(bArr)));
            Log.d(f27371IXxxXO, "firmware version: " + IXxxXO());
        }
    }

    public void ooXIXxIX(II0xO0 iI0xO0) {
        this.f27375II0xO0 = iI0xO0;
    }

    public void oxoX(int i) {
        Log.d(f27371IXxxXO, "onRssiChanged, rssi: " + i);
        this.f27375II0xO0.oIX0oI(i);
    }

    public void x0XOIxOo(String str, String str2) {
        Log.d(f27371IXxxXO, "dataWriteNotify: ");
    }

    public boolean x0o(String str, String str2, byte[] bArr, boolean z) {
        oIX0oI oix0oi = new oIX0oI(str, str2, bArr, z);
        if (this.f27386x0XOIxOo == null) {
            this.f27386x0XOIxOo = new ArrayList<>();
        }
        if (this.f27377Oo.hasMessages(100)) {
            this.f27377Oo.removeMessages(100);
        }
        this.f27386x0XOIxOo.add(oix0oi);
        if (this.f27377Oo.hasMessages(101)) {
            return true;
        }
        Message message = new Message();
        message.what = 101;
        this.f27377Oo.sendMessageDelayed(message, f27372Oxx0xo);
        return true;
    }

    public String x0xO0oo() {
        return this.f27378Oxx0IOOO;
    }

    public void xI(String str) {
        this.f27380XO = str;
    }

    public boolean xII(String str, String str2, byte[] bArr, boolean z) {
        oIX0oI oix0oi = new oIX0oI(str, str2, bArr, z);
        if (this.f27377Oo.hasMessages(100) || this.f27377Oo.hasMessages(101)) {
            return true;
        }
        Message message = new Message();
        message.what = 100;
        message.obj = oix0oi;
        this.f27377Oo.sendMessageDelayed(message, f27372Oxx0xo);
        return true;
    }

    public void xXxxox0I(String str) {
        this.f27378Oxx0IOOO = str;
    }

    public void xoIox() {
        xoXoI.OOXIxO0().XOxIOxOx(this);
    }

    public VTDeviceStatus xoXoI() {
        return this.f27385oxoX;
    }

    public void xxIXOIIO() {
        X0IIOO(IXxxXO.f27173OOXIXo, IXxxXO.f27236x0xO0oo);
    }

    public void xxX() {
        xoXoI.OOXIxO0().x0OIX00oO(this);
    }

    public VTDevice(Context context) {
        this.f27381oIX0oI = context;
    }
}
