package com.szabh.androiddfu.goodix;

import OOIXx0x.I0Io;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.goodix.ble.gr.libdfu.EasyDfu;
import com.goodix.ble.libcomx.transceiver.IFrameSender;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.UUID;

/* loaded from: classes13.dex */
public class DfuConnection {

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f26425Oo = 247;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f26427oOoXoXO = "GoodixDfu";

    /* renamed from: I0Io, reason: collision with root package name */
    public BluetoothDevice f26431I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public BluetoothGattCharacteristic f26433II0xO0;

    /* renamed from: XO, reason: collision with root package name */
    public Context f26437XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public BluetoothGattCharacteristic f26438oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public xIx0XO.II0xO0 f26439oxoX;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final UUID f26428ooOOo0oXI = UUID.fromString("a6ed0401-d344-460a-8075-b9e8ec90d71b");

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final UUID f26429x0XOIxOo = UUID.fromString("a6ed0402-d344-460a-8075-b9e8ec90d71b");

    /* renamed from: oO, reason: collision with root package name */
    public static final UUID f26426oO = UUID.fromString("a6ed0403-d344-460a-8075-b9e8ec90d71b");

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final UUID f26430x0xO0oo = UUID.fromString("a6ed0404-d344-460a-8075-b9e8ec90d71b");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public EasyDfu f26436X0o0xo = new EasyDfu();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public MutableLiveData<ConnState> f26435Oxx0IOOO = new MutableLiveData<>();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public MutableLiveData<String> f26432II0XooXoX = new MutableLiveData<>();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Handler f26441xxIXOIIO = new Handler();

    /* renamed from: xoIox, reason: collision with root package name */
    public IFrameSender f26440xoIox = new oIX0oI();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public xIx0XO.oIX0oI f26434OOXIXo = new II0xO0();

    /* loaded from: classes13.dex */
    public enum ConnState {
        CONNECTING,
        CONNECTED,
        INIT,
        READY,
        DISCONNECTING,
        DISCONNECTED
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements xIx0XO.oIX0oI {

        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DfuConnection.this.f26439oxoX.xxIXOIIO(247);
            }
        }

        public II0xO0() {
        }

        @Override // xIx0XO.oIX0oI
        public void I0Io() {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleDisconnected() called");
            DfuConnection.this.f26435Oxx0IOOO.postValue(ConnState.DISCONNECTED);
        }

        @Override // xIx0XO.oIX0oI
        public void II0XooXoX(BluetoothGatt bluetoothGatt) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleServicesDiscovered() called with: gatt = [" + bluetoothGatt + "]");
            BluetoothGattService service = bluetoothGatt.getService(DfuConnection.f26428ooOOo0oXI);
            if (service != null) {
                DfuConnection.this.f26438oIX0oI = service.getCharacteristic(DfuConnection.f26429x0XOIxOo);
                DfuConnection.this.f26433II0xO0 = service.getCharacteristic(DfuConnection.f26426oO);
            }
            if (DfuConnection.this.f26438oIX0oI != null && DfuConnection.this.f26433II0xO0 != null) {
                DfuConnection.this.f26439oxoX.oOoXoXO(DfuConnection.this.f26438oIX0oI);
                DfuConnection.this.f26435Oxx0IOOO.postValue(ConnState.INIT);
            } else {
                DfuConnection.this.f26432II0XooXoX.postValue("Device Not Support");
                DfuConnection.this.IXxxXO();
            }
        }

        @Override // xIx0XO.oIX0oI
        public void II0xO0(String str) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleTimeOut() called with: type = [" + str + "]");
            DfuConnection.this.f26432II0XooXoX.postValue("onBleTimeOut() called with: type = [" + str + "]");
        }

        @Override // xIx0XO.oIX0oI
        public void Oxx0IOOO(int i) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleMtuChanged() called with: mtu = [" + i + "]");
            DfuConnection.this.f26436X0o0xo.setMaxSegmentSize(i + (-3));
            DfuConnection.this.f26435Oxx0IOOO.postValue(ConnState.READY);
        }

        @Override // xIx0XO.oIX0oI
        public void X0o0xo(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleCharacteristicWriteComplete() called with: characteristic = [" + bluetoothGattCharacteristic.getUuid() + "]" + I0Io.XO(bluetoothGattCharacteristic.getValue()));
            DfuConnection.this.f26436X0o0xo.onSentPduSegment();
        }

        @Override // xIx0XO.oIX0oI
        public void XO() {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleConnected() called");
            DfuConnection.this.f26435Oxx0IOOO.postValue(ConnState.CONNECTED);
        }

        @Override // xIx0XO.oIX0oI
        public void oIX0oI(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleCharacteristicNotify() called with: characteristic = [" + bluetoothGattCharacteristic.getUuid() + "]" + I0Io.XO(bluetoothGattCharacteristic.getValue()));
            if (bluetoothGattCharacteristic.equals(DfuConnection.this.f26438oIX0oI)) {
                DfuConnection.this.f26436X0o0xo.onRcvPduSegment(bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // xIx0XO.oIX0oI
        public void oxoX(String str, int i) {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleError() called with: message = [" + str + "], errorCode = [" + i + "]");
            DfuConnection.this.f26432II0XooXoX.postValue(str);
        }

        @Override // xIx0XO.oIX0oI
        public void xxIXOIIO() {
            Log.d(DfuConnection.f26427oOoXoXO, "onBleNotifyEnable() called");
            DfuConnection.this.f26441xxIXOIIO.postDelayed(new oIX0oI(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements IFrameSender {
        public oIX0oI() {
        }

        @Override // com.goodix.ble.libcomx.transceiver.IFrameSender
        public boolean sendFrame(byte[] bArr) {
            if (DfuConnection.this.f26435Oxx0IOOO.getValue() == ConnState.READY) {
                Log.v(DfuConnection.f26427oOoXoXO, "sendFrame()" + I0Io.XO(bArr));
                DfuConnection.this.f26433II0xO0.setValue(bArr);
                DfuConnection.this.f26439oxoX.oO(DfuConnection.this.f26433II0xO0, bArr, DfuConnection.this.f26433II0xO0.getWriteType());
                return true;
            }
            return false;
        }
    }

    public DfuConnection(Context context) {
        this.f26437XO = context;
        this.f26439oxoX = new xIx0XO.II0xO0(context, this.f26434OOXIXo);
        this.f26436X0o0xo.setPduSender(this.f26440xoIox);
    }

    public void IXxxXO() {
        if (this.f26431I0Io == null) {
            return;
        }
        this.f26435Oxx0IOOO.postValue(ConnState.DISCONNECTING);
        this.f26439oxoX.OOXIXo();
    }

    public void Oo() {
        if (this.f26431I0Io == null) {
            return;
        }
        this.f26435Oxx0IOOO.postValue(ConnState.CONNECTING);
        this.f26439oxoX.xoIox(this.f26431I0Io, false, 30000);
    }

    public void Oxx0xo(BluetoothDevice bluetoothDevice) {
        this.f26431I0Io = bluetoothDevice;
    }

    public EasyDfu oO() {
        return this.f26436X0o0xo;
    }

    public LiveData<ConnState> ooOOo0oXI() {
        return this.f26435Oxx0IOOO;
    }

    public BluetoothDevice x0XOIxOo() {
        return this.f26431I0Io;
    }

    public LiveData<String> x0xO0oo() {
        return this.f26432II0XooXoX;
    }

    public DfuConnection(Context context, BluetoothDevice bluetoothDevice) {
        this.f26437XO = context;
        this.f26439oxoX = new xIx0XO.II0xO0(context, this.f26434OOXIXo);
        this.f26431I0Io = bluetoothDevice;
        this.f26436X0o0xo.setPduSender(this.f26440xoIox);
    }
}
