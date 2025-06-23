package com.bluetrum.abota.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bluetrum.abota.time.Timber;
import com.bluetrum.fota.abota.ABOta;
import com.bluetrum.fota.utils.HexUtils;

/* loaded from: classes8.dex */
public final class SppManager implements BluetoothManager, ABOta.SendCallback {
    private static final int DELAY_SEND = 15;
    private static final String TAG = "SppManager";
    private BluetoothEventListener eventListener;
    private boolean isReady = false;
    private final Handler.Callback sppCallback = new Handler.Callback() { // from class: com.bluetrum.abota.bluetooth.oIX0oI
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = SppManager.this.lambda$new$0(message);
            return lambda$new$0;
        }
    };
    private final BluetoothDevice sppDevice;
    private BluetoothSppService sppService;

    public SppManager(@NonNull BluetoothDevice bluetoothDevice) {
        this.sppDevice = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    byte[] bArr = (byte[]) message.obj;
                    Timber.tag("SPP_WRITE").v(HexUtils.bytesToHex(bArr), new Object[0]);
                    BluetoothEventListener bluetoothEventListener = this.eventListener;
                    if (bluetoothEventListener != null) {
                        bluetoothEventListener.onSend(bArr);
                    }
                }
            } else {
                byte[] bArr2 = (byte[]) message.obj;
                Timber.tag("SPP_READ").v(HexUtils.bytesToHex(bArr2), new Object[0]);
                BluetoothEventListener bluetoothEventListener2 = this.eventListener;
                if (bluetoothEventListener2 != null) {
                    bluetoothEventListener2.onReceive(bArr2);
                }
            }
        } else {
            int i2 = message.arg1;
            if (i2 != 0) {
                if (i2 == 2) {
                    this.isReady = true;
                    BluetoothEventListener bluetoothEventListener3 = this.eventListener;
                    if (bluetoothEventListener3 != null) {
                        bluetoothEventListener3.onBluetoothReady();
                    }
                }
            } else {
                this.isReady = false;
                close();
            }
        }
        return true;
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void close() {
        BluetoothSppService bluetoothSppService = this.sppService;
        if (bluetoothSppService != null) {
            bluetoothSppService.stop();
            this.sppService = null;
        }
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public boolean isReady() {
        return this.isReady;
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void open() {
        BluetoothSppService bluetoothSppService = new BluetoothSppService(new Handler(this.sppCallback));
        this.sppService = bluetoothSppService;
        bluetoothSppService.connect(this.sppDevice);
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void send(byte[] bArr) {
        this.sppService.write(bArr);
    }

    @Override // com.bluetrum.fota.abota.ABOta.SendCallback
    public void sendData(byte[] bArr) {
        send(bArr);
        try {
            Thread.sleep(15L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void setEventListener(BluetoothEventListener bluetoothEventListener) {
        this.eventListener = bluetoothEventListener;
    }
}
