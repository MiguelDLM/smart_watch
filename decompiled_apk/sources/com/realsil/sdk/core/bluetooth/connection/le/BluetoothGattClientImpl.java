package com.realsil.sdk.core.bluetooth.connection.le;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public abstract class BluetoothGattClientImpl extends BluetoothGattClient {
    public static final /* synthetic */ int o = 0;
    public ThreadPoolExecutor h;
    public boolean i = true;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public final Runnable m = new Runnable() { // from class: com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl.1
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0223, code lost:
        
            r10.f19488a.i = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0228, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 553
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl.AnonymousClass1.run():void");
        }
    };
    public final BluetoothGattCallback n = new BluetoothGattCallback() { // from class: com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothGattClientImpl.this.processCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            BluetoothGattClientImpl.this.getClass();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            BluetoothGattClientImpl.this.getClass();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            bluetoothGatt.getDevice();
            if (i == 0) {
                if (i2 == 2) {
                    BluetoothGattClientImpl bluetoothGattClientImpl = BluetoothGattClientImpl.this;
                    int i3 = BluetoothGattClientImpl.o;
                    if (bluetoothGattClientImpl.DBG) {
                        ZLogger.d("Connected to GATT server.");
                    }
                    BluetoothGattClientImpl bluetoothGattClientImpl2 = BluetoothGattClientImpl.this;
                    bluetoothGattClientImpl2.mBluetoothGatt = bluetoothGatt;
                    bluetoothGattClientImpl2.j = true;
                    BluetoothGattClientImpl.this.i = false;
                    BluetoothGattClientImpl bluetoothGattClientImpl3 = BluetoothGattClientImpl.this;
                    ZLogger.v(bluetoothGattClientImpl3.VDBG, String.format("connectionEstablishProcessing=%b, connectionEstablished=%b", Boolean.valueOf(bluetoothGattClientImpl3.i), Boolean.valueOf(BluetoothGattClientImpl.this.j)));
                    BluetoothGattClientImpl.this.notifyConnLock();
                    return;
                }
                if (i2 == 0) {
                    BluetoothGattClientImpl bluetoothGattClientImpl4 = BluetoothGattClientImpl.this;
                    int i4 = BluetoothGattClientImpl.o;
                    if (bluetoothGattClientImpl4.DBG) {
                        ZLogger.w("Disconnected from GATT server.");
                    }
                    BluetoothGattClientImpl bluetoothGattClientImpl5 = BluetoothGattClientImpl.this;
                    if (bluetoothGattClientImpl5.j || bluetoothGattClientImpl5.i) {
                        ZLogger.v(String.format("connectionEstablishProcessing=%b, connectionEstablished=%b", Boolean.valueOf(bluetoothGattClientImpl5.i), Boolean.valueOf(BluetoothGattClientImpl.this.j)));
                        BluetoothGattClientImpl.this.j = false;
                        BluetoothGattClientImpl.this.i = false;
                        BluetoothGattClientImpl.this.closeGatt();
                    }
                    BluetoothGattClientImpl bluetoothGattClientImpl6 = BluetoothGattClientImpl.this;
                    ZLogger.v(bluetoothGattClientImpl6.VDBG, String.format("connectionEstablishProcessing=%b, connectionEstablished=%b", Boolean.valueOf(bluetoothGattClientImpl6.i), Boolean.valueOf(BluetoothGattClientImpl.this.j)));
                    BluetoothGattClientImpl.this.updateConnectionState(0);
                    return;
                }
                return;
            }
            BluetoothGattClientImpl bluetoothGattClientImpl7 = BluetoothGattClientImpl.this;
            int i5 = BluetoothGattClientImpl.o;
            if (bluetoothGattClientImpl7.DBG) {
                ZLogger.w("status " + i + " newState: " + i2);
            }
            BluetoothGattClientImpl bluetoothGattClientImpl8 = BluetoothGattClientImpl.this;
            if (bluetoothGattClientImpl8.j || bluetoothGattClientImpl8.i) {
                ZLogger.v(String.format("connectionEstablishProcessing=%b, connectionEstablished=%b", Boolean.valueOf(bluetoothGattClientImpl8.i), Boolean.valueOf(BluetoothGattClientImpl.this.j)));
                BluetoothGattClientImpl.this.j = false;
                BluetoothGattClientImpl.this.i = false;
                BluetoothGattClientImpl.this.closeGatt();
            }
            BluetoothGattClientImpl bluetoothGattClientImpl9 = BluetoothGattClientImpl.this;
            ZLogger.v(bluetoothGattClientImpl9.VDBG, String.format("connectionEstablishProcessing=%b, connectionEstablished=%b", Boolean.valueOf(bluetoothGattClientImpl9.i), Boolean.valueOf(BluetoothGattClientImpl.this.j)));
            BluetoothGattClientImpl.this.updateConnectionState(0);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            bluetoothGatt.getDevice();
            BluetoothGattClientImpl.this.processDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            BluetoothGattClientImpl.this.l = true;
            BluetoothGattClientImpl.this.notifyConnLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BluetoothGattClientImpl bluetoothGattClientImpl = BluetoothGattClientImpl.this;
                int i2 = BluetoothGattClientImpl.o;
                if (bluetoothGattClientImpl.DBG) {
                    ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
                }
                BluetoothGattClientImpl.this.k = true;
                if (!BluetoothGattClientImpl.this.processServices(bluetoothGatt)) {
                    BluetoothGattClientImpl.this.disconnect();
                }
                BluetoothGattClientImpl.this.notifyConnLock();
                return;
            }
            BluetoothGattClientImpl bluetoothGattClientImpl2 = BluetoothGattClientImpl.this;
            int i3 = BluetoothGattClientImpl.o;
            if (bluetoothGattClientImpl2.DBG) {
                ZLogger.w("onServicesDiscovered failed: " + i);
            }
            BluetoothGattClientImpl.this.k = false;
            BluetoothGattClientImpl.this.notifyConnLock();
            BluetoothGattClientImpl.this.disconnect();
        }
    };

    public BluetoothGattClientImpl(Context context, BluetoothGattClientCallback bluetoothGattClientCallback) {
        this.mContext = context;
        this.mCallback = bluetoothGattClientCallback;
        b();
    }

    public void close() {
        if (this.DBG) {
            ZLogger.d("close()");
        }
        closeGatt();
        ThreadPoolExecutor threadPoolExecutor = this.h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public void closeGatt() {
        if (this.DBG) {
            ZLogger.d("closeGatt()");
        }
        disconnect();
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClient
    public boolean connect(GattConnParams gattConnParams) {
        if (!super.connect(gattConnParams)) {
            return false;
        }
        if (this.i) {
            ZLogger.d(this.DBG, "there ia already a connection is processing, wait to close");
            notifyConnLock();
        }
        if (this.DBG) {
            ZLogger.d(gattConnParams.toString());
        }
        this.mGattConnParams = gattConnParams;
        String address = gattConnParams.getAddress();
        this.mDeviceAddress = address;
        this.mDevice = a(address);
        this.h.execute(this.m);
        return true;
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClient, com.realsil.sdk.core.bluetooth.connection.BluetoothClient
    public void destroy() {
        super.destroy();
        closeGatt();
        ThreadPoolExecutor threadPoolExecutor = this.h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClient
    public void disconnect() {
        super.disconnect();
        this.mGlobalGatt.disconnectGatt(this.mDeviceAddress);
        this.h.remove(this.m);
    }

    public boolean enableCccd() {
        ZLogger.v("enable notification");
        return true;
    }

    public int getConnectState() {
        return getConnectionState();
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClient
    public void processBondStateChanged(BluetoothDevice bluetoothDevice, int i) {
        BluetoothDevice bluetoothDevice2 = this.mDevice;
        if (bluetoothDevice2 != null && bluetoothDevice2.equals(bluetoothDevice)) {
            this.mBondState = i;
            switch (i) {
                case 10:
                    ZLogger.v(this.VDBG, "BOND_NONE");
                    if (this.f19486a == 5) {
                        notifyConnLock();
                        return;
                    }
                    return;
                case 11:
                    ZLogger.v(this.VDBG, "BOND_BONDING");
                    return;
                case 12:
                    ZLogger.v(this.VDBG, "BOND_BONDED");
                    if (this.f19486a == 5) {
                        notifyConnLock();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        ZLogger.v(this.VDBG, "bonded device not match with current device");
    }

    public void processCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void processDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public boolean processServices(BluetoothGatt bluetoothGatt) {
        return true;
    }

    public final void b() {
        a();
        this.h = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.AbortPolicy());
        updateConnectionState(0);
    }
}
