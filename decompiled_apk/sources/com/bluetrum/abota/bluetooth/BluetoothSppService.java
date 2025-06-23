package com.bluetrum.abota.bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import com.bluetrum.abota.time.Timber;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes8.dex */
public class BluetoothSppService {
    private static final UUID BLUETOOTH_SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_WRITE = 3;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_NONE = 0;
    private static final String TAG = "BluetoothSppService";
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private final Handler mHandler;
    private int mState = 0;
    private int mNewState = 0;

    /* loaded from: classes8.dex */
    public class ConnectThread extends Thread {
        private final BluetoothDevice mmDevice;
        private final BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice bluetoothDevice) {
            BluetoothSocket bluetoothSocket;
            this.mmDevice = bluetoothDevice;
            try {
                bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothSppService.BLUETOOTH_SPP_UUID);
            } catch (IOException e) {
                Timber.tag(BluetoothSppService.TAG).e(e, "create() failed", new Object[0]);
                bluetoothSocket = null;
            }
            this.mmSocket = bluetoothSocket;
            BluetoothSppService.this.mState = 1;
            BluetoothSppService.this.notifyState();
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e) {
                Timber.tag(BluetoothSppService.TAG).e(e, "close() of connect socket failed", new Object[0]);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Timber.tag(BluetoothSppService.TAG).i("BEGIN mConnectThread", new Object[0]);
            try {
                try {
                    this.mmSocket.connect();
                    synchronized (BluetoothSppService.this) {
                        BluetoothSppService.this.mConnectThread = null;
                    }
                    BluetoothSppService.this.connected(this.mmSocket, this.mmDevice);
                } catch (IOException unused) {
                    this.mmSocket.close();
                    BluetoothSppService.this.connectionFailed();
                }
            } catch (IOException e) {
                Timber.tag(BluetoothSppService.TAG).e(e, "unable to close() socket during connection failure", new Object[0]);
                BluetoothSppService.this.connectionFailed();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        private final BluetoothSocket mmSocket;

        public ConnectedThread(BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            Timber.tag(BluetoothSppService.TAG).d("create ConnectedThread", new Object[0]);
            this.mmSocket = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                e = e;
                inputStream = null;
            }
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                Timber.tag(BluetoothSppService.TAG).e(e, "temp sockets not created", new Object[0]);
                this.mmInStream = inputStream;
                this.mmOutStream = outputStream;
                BluetoothSppService.this.mState = 2;
                BluetoothSppService.this.notifyState();
            }
            this.mmInStream = inputStream;
            this.mmOutStream = outputStream;
            BluetoothSppService.this.mState = 2;
            BluetoothSppService.this.notifyState();
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e) {
                Timber.tag(BluetoothSppService.TAG).e(e, "close() of connect socket failed", new Object[0]);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Timber.tag(BluetoothSppService.TAG).i("BEGIN mConnectedThread", new Object[0]);
            byte[] bArr = new byte[1024];
            while (BluetoothSppService.this.mState == 2) {
                try {
                    BluetoothSppService.this.mHandler.obtainMessage(2, Arrays.copyOf(bArr, this.mmInStream.read(bArr))).sendToTarget();
                } catch (IOException e) {
                    Timber.tag(BluetoothSppService.TAG).e(e, "disconnected", new Object[0]);
                    BluetoothSppService.this.connectionLost();
                    return;
                }
            }
        }

        public void write(byte[] bArr) {
            try {
                this.mmOutStream.write(bArr);
                BluetoothSppService.this.mHandler.obtainMessage(3, -1, -1, bArr).sendToTarget();
            } catch (IOException e) {
                Timber.tag(BluetoothSppService.TAG).e(e, "Exception during write", new Object[0]);
            }
        }
    }

    public BluetoothSppService(Handler handler) {
        this.mHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionFailed() {
        this.mState = 0;
        notifyState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionLost() {
        this.mState = 0;
        notifyState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyState() {
        int state = getState();
        this.mState = state;
        if (state != this.mNewState) {
            Timber.tag(TAG).d("notifyState() %d -> %d", Integer.valueOf(this.mNewState), Integer.valueOf(this.mState));
            int i = this.mState;
            this.mNewState = i;
            this.mHandler.obtainMessage(1, i, -1).sendToTarget();
        }
    }

    public synchronized void connect(BluetoothDevice bluetoothDevice) {
        ConnectThread connectThread;
        try {
            Timber.tag(TAG).d("connect to: %s", bluetoothDevice);
            if (this.mState == 1 && (connectThread = this.mConnectThread) != null) {
                connectThread.cancel();
                this.mConnectThread = null;
            }
            ConnectedThread connectedThread = this.mConnectedThread;
            if (connectedThread != null) {
                connectedThread.cancel();
                this.mConnectedThread = null;
            }
            ConnectThread connectThread2 = new ConnectThread(bluetoothDevice);
            this.mConnectThread = connectThread2;
            connectThread2.start();
            notifyState();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        try {
            Timber.tag(TAG).d(x.bl, new Object[0]);
            ConnectThread connectThread = this.mConnectThread;
            if (connectThread != null) {
                connectThread.cancel();
                this.mConnectThread = null;
            }
            ConnectedThread connectedThread = this.mConnectedThread;
            if (connectedThread != null) {
                connectedThread.cancel();
                this.mConnectedThread = null;
            }
            ConnectedThread connectedThread2 = new ConnectedThread(bluetoothSocket);
            this.mConnectedThread = connectedThread2;
            connectedThread2.start();
            notifyState();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getState() {
        return this.mState;
    }

    public synchronized void stop() {
        try {
            Timber.tag(TAG).d("stop", new Object[0]);
            ConnectThread connectThread = this.mConnectThread;
            if (connectThread != null) {
                connectThread.cancel();
                this.mConnectThread = null;
            }
            ConnectedThread connectedThread = this.mConnectedThread;
            if (connectedThread != null) {
                connectedThread.cancel();
                this.mConnectedThread = null;
            }
            this.mState = 0;
            notifyState();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void write(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.mState != 2) {
                    return;
                }
                this.mConnectedThread.write(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
