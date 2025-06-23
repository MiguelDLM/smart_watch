package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import com.facebook.login.widget.ToolTipPopup;
import com.jieli.bluetooth_connect.impl.BluetoothBle;
import com.jieli.bluetooth_connect.interfaces.listener.OnThreadStateListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnWriteDataCallback;
import com.jieli.bluetooth_connect.util.CHexConverter;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class SendBleDataThread extends Thread {
    private static final String TAG = "SendBleDataThread";
    private volatile boolean isDataSend;
    private volatile boolean isThreadWaiting;
    private volatile boolean isWaitingForCallback;
    private final BluetoothBle mBleManager;
    private BleSendTask mCurrentTask;
    private final OnThreadStateListener mListener;
    private final LinkedBlockingQueue<BleSendTask> mQueue;
    private volatile int retryNum;

    /* loaded from: classes10.dex */
    public static class BleSendTask {
        private UUID characteristicUUID;
        private byte[] data;
        private OnWriteDataCallback mCallback;
        private BluetoothDevice mDevice;
        private UUID serviceUUID;
        private int status = -1;

        public BleSendTask(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback) {
            setDevice(device).setServiceUUID(serviceUUID).setCharacteristicUUID(characteristicUUID).setData(data).setCallback(callback);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BleSendTask)) {
                return false;
            }
            BleSendTask bleSendTask = (BleSendTask) obj;
            BluetoothDevice bluetoothDevice = this.mDevice;
            if (bluetoothDevice == null || this.serviceUUID == null || this.characteristicUUID == null || !bluetoothDevice.equals(bleSendTask.getDevice()) || !this.serviceUUID.equals(bleSendTask.getServiceUUID()) || !this.characteristicUUID.equals(bleSendTask.getCharacteristicUUID())) {
                return false;
            }
            return true;
        }

        public OnWriteDataCallback getCallback() {
            return this.mCallback;
        }

        public UUID getCharacteristicUUID() {
            return this.characteristicUUID;
        }

        public byte[] getData() {
            return this.data;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        public UUID getServiceUUID() {
            return this.serviceUUID;
        }

        public int getStatus() {
            return this.status;
        }

        public int hashCode() {
            BluetoothDevice bluetoothDevice = this.mDevice;
            if (bluetoothDevice != null && this.serviceUUID != null && this.characteristicUUID != null) {
                return bluetoothDevice.hashCode() + this.serviceUUID.hashCode() + this.characteristicUUID.hashCode();
            }
            return super.hashCode();
        }

        public BleSendTask setCallback(OnWriteDataCallback callback) {
            this.mCallback = callback;
            return this;
        }

        public BleSendTask setCharacteristicUUID(UUID characteristicUUID) {
            this.characteristicUUID = characteristicUUID;
            return this;
        }

        public BleSendTask setData(byte[] data) {
            this.data = data;
            return this;
        }

        public BleSendTask setDevice(BluetoothDevice device) {
            this.mDevice = device;
            return this;
        }

        public BleSendTask setServiceUUID(UUID serviceUUID) {
            this.serviceUUID = serviceUUID;
            return this;
        }

        public BleSendTask setStatus(int status) {
            this.status = status;
            return this;
        }

        @NonNull
        public String toString() {
            return "BleSendTask{mDevice=" + this.mDevice + ", serviceUUID=" + this.serviceUUID + ", characteristicUUID=" + this.characteristicUUID + ", data=" + Arrays.toString(this.data) + ", status=" + this.status + ", mCallback=" + this.mCallback + '}';
        }
    }

    public SendBleDataThread(BluetoothBle manager, OnThreadStateListener listener) {
        super(TAG);
        this.mQueue = new LinkedBlockingQueue<>();
        this.isDataSend = false;
        this.isThreadWaiting = false;
        this.isWaitingForCallback = false;
        this.retryNum = 0;
        this.mBleManager = manager;
        this.mListener = listener;
    }

    private boolean addSendData(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback) {
        boolean z;
        if (!this.isDataSend) {
            return false;
        }
        try {
            this.mQueue.put(new BleSendTask(device, serviceUUID, characteristicUUID, data, callback));
            z = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            z = false;
        }
        if (z && this.isThreadWaiting && !this.isWaitingForCallback) {
            this.isThreadWaiting = false;
            synchronized (this.mQueue) {
                this.mQueue.notify();
            }
        }
        return z;
    }

    private void callbackResult(BleSendTask task, boolean result) {
        if (task != null && task.getCallback() != null) {
            task.getCallback().onBleResult(task.getDevice(), task.getServiceUUID(), task.getCharacteristicUUID(), result, task.getData());
        } else {
            JL_Log.i(TAG, "callbackResult", "getCallback is null.");
        }
    }

    public boolean addSendTask(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback) {
        BluetoothBle bluetoothBle = this.mBleManager;
        if (bluetoothBle != null && device != null && bluetoothBle.isConnectedBleDevice(device) && serviceUUID != null && characteristicUUID != null && data != null && data.length != 0) {
            int bleMtu = this.mBleManager.getBleMtu(device);
            JL_Log.d(TAG, "addSendTask", "ble mtu = " + bleMtu);
            if (bleMtu <= 0) {
                return false;
            }
            int length = data.length;
            int i = 0;
            while (i < length) {
                int min = Math.min(length - i, bleMtu);
                byte[] bArr = new byte[min];
                System.arraycopy(data, i, bArr, 0, min);
                if (!addSendData(device, serviceUUID, characteristicUUID, bArr, callback)) {
                    JL_Log.e(TAG, "addSendTask", "loss data...., data = " + CHexConverter.byte2HexStr(bArr));
                    return false;
                }
                i += min;
            }
            return true;
        }
        JL_Log.d(TAG, "addSendTask", "param is error.");
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str = TAG;
        JL_Log.d(str, str, "send ble data thread is started.");
        OnThreadStateListener onThreadStateListener = this.mListener;
        if (onThreadStateListener != null) {
            onThreadStateListener.onStart(getId(), getName());
        }
        if (this.mBleManager != null) {
            synchronized (this.mQueue) {
                while (this.isDataSend) {
                    this.mCurrentTask = null;
                    this.isThreadWaiting = false;
                    this.isWaitingForCallback = false;
                    if (this.mQueue.isEmpty()) {
                        this.isThreadWaiting = true;
                        String str2 = TAG;
                        JL_Log.d(str2, str2, "queue is empty, so waiting for data");
                        try {
                            this.mQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        BleSendTask peek = this.mQueue.peek();
                        this.mCurrentTask = peek;
                        if (peek != null) {
                            this.isWaitingForCallback = this.mBleManager.writeDataByBleSync(peek.mDevice, this.mCurrentTask.getServiceUUID(), this.mCurrentTask.getCharacteristicUUID(), this.mCurrentTask.getData());
                            if (this.isWaitingForCallback) {
                                try {
                                    this.mQueue.wait(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            } else {
                                this.mCurrentTask.setStatus(-1);
                            }
                            String str3 = TAG;
                            JL_Log.d(str3, str3, "data send ret :" + this.mCurrentTask.getStatus());
                            if (this.mCurrentTask.getStatus() != 0) {
                                this.retryNum++;
                                if (this.retryNum >= 3) {
                                    callbackResult(this.mCurrentTask, false);
                                } else if (this.mCurrentTask.getStatus() != -1) {
                                    this.mCurrentTask.setStatus(-1);
                                    try {
                                        Thread.sleep(10L);
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } else {
                                callbackResult(this.mCurrentTask, true);
                            }
                        }
                        this.retryNum = 0;
                        this.mQueue.poll();
                    }
                }
            }
            this.isWaitingForCallback = false;
            this.isThreadWaiting = false;
            this.mQueue.clear();
            OnThreadStateListener onThreadStateListener2 = this.mListener;
            if (onThreadStateListener2 != null) {
                onThreadStateListener2.onEnd(getId(), getName());
            }
            String str4 = TAG;
            JL_Log.d(str4, str4, "send ble data thread exit.");
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.isDataSend = true;
        super.start();
    }

    public synchronized void stopThread() {
        this.isDataSend = false;
        wakeupSendThread(null);
    }

    public void wakeupSendThread(BleSendTask sendTask) {
        BleSendTask bleSendTask;
        if (sendTask == null || ((bleSendTask = this.mCurrentTask) != null && bleSendTask.equals(sendTask))) {
            if (sendTask != null) {
                sendTask.setCallback(this.mCurrentTask.getCallback());
                this.mCurrentTask = sendTask;
            }
            synchronized (this.mQueue) {
                try {
                    if (this.isThreadWaiting) {
                        if (this.isWaitingForCallback) {
                            this.mQueue.notifyAll();
                        } else {
                            this.mQueue.notify();
                        }
                    } else if (this.isWaitingForCallback) {
                        this.mQueue.notify();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
