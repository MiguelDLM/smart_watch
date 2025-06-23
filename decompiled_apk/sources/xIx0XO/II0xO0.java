package xIx0XO;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f34333IIXOooo = 5000;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f34334IXxxXO = "Timeout on enable_notify";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f34335OOXIXo = "Error on connection state change";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f34336Oo = "Timeout on discovery service";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f34337Oxx0xo = "Timeout on mtu request";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f34338OxxIIOOXO = 10000;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f34339oI0IIXIo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final String f34340oO = "Error on mtu request";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f34341oOoXoXO = "Error on discovering services";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f34342ooOOo0oXI = "Error on writing characteristic";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f34343x0XOIxOo = "Error on writing descriptor";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f34344x0xO0oo = "Timeout on connect";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final UUID f34345xoIox = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f34346xoXoI = 5000;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f34348II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public BluetoothAdapter f34349II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Timer f34350Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public xIx0XO.oIX0oI f34351X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public BluetoothManager f34353oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Context f34354oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public BluetoothGatt f34347I0Io = null;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f34352XO = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final BluetoothGattCallback f34355xxIXOIIO = new C1151II0xO0();

    /* loaded from: classes13.dex */
    public class I0Io extends TimerTask {
        public I0Io() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            II0xO0.this.f34350Oxx0IOOO = null;
            Log.i("sss", "timeout");
            II0xO0.this.f34351X0o0xo.II0xO0(II0xO0.this.f34348II0XooXoX);
        }
    }

    /* renamed from: xIx0XO.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1151II0xO0 extends BluetoothGattCallback {
        public C1151II0xO0() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            II0xO0.this.f34351X0o0xo.oIX0oI(bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                II0xO0.this.f34351X0o0xo.X0o0xo(bluetoothGattCharacteristic);
            } else {
                II0xO0.this.f34351X0o0xo.oxoX(II0xO0.f34342ooOOo0oXI, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0 && i2 == 2) {
                II0xO0.this.f34352XO = true;
                II0xO0.this.x0XOIxOo();
                II0xO0.this.f34351X0o0xo.XO();
                II0xO0.this.ooOOo0oXI(10000, II0xO0.f34336Oo);
                bluetoothGatt.discoverServices();
                return;
            }
            if (i2 == 0) {
                II0xO0.this.x0XOIxOo();
                II0xO0.this.f34351X0o0xo.I0Io();
                bluetoothGatt.close();
            } else if (i != 0) {
                II0xO0.this.f34351X0o0xo.oxoX(II0xO0.f34335OOXIXo, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            byte[] value;
            if (i == 0) {
                if (bluetoothGattDescriptor != null && II0xO0.f34345xoIox.equals(bluetoothGattDescriptor.getUuid()) && (value = bluetoothGattDescriptor.getValue()) != null && value.length == 2 && value[1] == 0 && value[0] == 1) {
                    II0xO0.this.x0XOIxOo();
                    II0xO0.this.f34351X0o0xo.xxIXOIIO();
                    return;
                }
                return;
            }
            II0xO0.this.f34351X0o0xo.oxoX(II0xO0.f34343x0XOIxOo, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            II0xO0.this.x0XOIxOo();
            II0xO0.this.f34351X0o0xo.Oxx0IOOO(i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            II0xO0.this.x0XOIxOo();
            if (i == 0) {
                II0xO0.this.f34351X0o0xo.II0XooXoX(bluetoothGatt);
            } else {
                II0xO0.this.f34351X0o0xo.oxoX(II0xO0.f34341oOoXoXO, i);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f34347I0Io != null) {
                II0xO0.this.f34347I0Io.close();
            }
        }
    }

    public II0xO0(Context context, xIx0XO.oIX0oI oix0oi) {
        this.f34351X0o0xo = oix0oi;
        this.f34354oxoX = context;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.f34353oIX0oI = bluetoothManager;
        this.f34349II0xO0 = bluetoothManager.getAdapter();
    }

    public void OOXIXo() {
        BluetoothGatt bluetoothGatt;
        if (this.f34349II0xO0 != null && (bluetoothGatt = this.f34347I0Io) != null) {
            bluetoothGatt.disconnect();
            new Handler(Looper.getMainLooper()).postDelayed(new oIX0oI(), 5000L);
        }
    }

    public boolean oO(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        BluetoothGatt bluetoothGatt = this.f34347I0Io;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return false;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGattCharacteristic.setWriteType(i);
        if ((bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            return false;
        }
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public boolean oOoXoXO(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        ooOOo0oXI(5000, f34334IXxxXO);
        BluetoothGatt bluetoothGatt = this.f34347I0Io;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 16) == 0) {
            return false;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f34345xoIox);
        if (descriptor == null) {
            return false;
        }
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(2);
        boolean writeDescriptor = this.f34347I0Io.writeDescriptor(descriptor);
        characteristic.setWriteType(writeType);
        return writeDescriptor;
    }

    public final void ooOOo0oXI(int i, String str) {
        this.f34348II0XooXoX = str;
        this.f34350Oxx0IOOO = null;
        Timer timer = new Timer();
        this.f34350Oxx0IOOO = timer;
        timer.schedule(new I0Io(), i);
    }

    public final void x0XOIxOo() {
        Timer timer = this.f34350Oxx0IOOO;
        if (timer != null) {
            timer.cancel();
            this.f34350Oxx0IOOO = null;
        }
    }

    public void xoIox(BluetoothDevice bluetoothDevice, boolean z, int i) {
        if (bluetoothDevice == null) {
            return;
        }
        ooOOo0oXI(i, f34344x0xO0oo);
        this.f34347I0Io = bluetoothDevice.connectGatt(this.f34354oxoX, z, this.f34355xxIXOIIO);
    }

    public boolean xxIXOIIO(int i) {
        if (i < 23) {
            i = 23;
        }
        if (i > 517) {
            i = 517;
        }
        BluetoothGatt bluetoothGatt = this.f34347I0Io;
        if (bluetoothGatt == null) {
            return false;
        }
        ooOOo0oXI(5000, f34337Oxx0xo);
        return bluetoothGatt.requestMtu(i);
    }
}
