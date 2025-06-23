package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.interfaces.IBluetoothPair;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.tool.BtPairEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.sma.smartv3.initializer.IXxxXO;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class BluetoothPair implements IBluetoothPair {
    private static final int MSG_PAIR_TASK_TIMEOUT = 1014;
    private static final String TAG = "BluetoothPair";
    private final BluetoothAdapter btAdapter;
    private BluetoothOption mBluetoothOption;
    private BluetoothPairReceiver mBluetoothPairReceiver;
    private final Context mContext;
    private PairBtDeviceThread mPairBtDeviceThread;
    private volatile BluetoothDevice mPairingDevice;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.impl.OOXIXo
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = BluetoothPair.this.lambda$new$0(message);
            return lambda$new$0;
        }
    });
    private final BtPairEventCbManager mBtPairEventCbManager = new BtPairEventCbManager();

    /* loaded from: classes10.dex */
    public class BluetoothPairReceiver extends BroadcastReceiver {
        private BluetoothPairReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            boolean z;
            BluetoothDevice bluetoothDevice;
            if (intent != null) {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    action.hashCode();
                    if (!action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED") && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null && ConnectUtil.isHasConnectPermission(context)) {
                            int bondState = bluetoothDevice.getBondState();
                            JL_Log.i(BluetoothPair.TAG, "ACTION_BOND_STATE_CHANGED", "device : " + BluetoothUtil.printBtDeviceInfo(context, bluetoothDevice) + ", bound : " + bondState);
                            if (bondState == 10 || bondState == 12) {
                                BluetoothPair.this.stopPairTimeout(bluetoothDevice);
                                BluetoothPair.this.wakeupPairTaskThread(bluetoothDevice);
                            }
                            BluetoothPair.this.mBtPairEventCbManager.onBtDeviceBond(bluetoothDevice, bondState);
                            return;
                        }
                        return;
                    }
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra != -1) {
                        if (intExtra == 10) {
                            BluetoothPair.this.stopPairTaskThread();
                            BluetoothPair bluetoothPair = BluetoothPair.this;
                            bluetoothPair.onError(bluetoothPair.mPairingDevice, ErrorInfo.buildError(2));
                            BluetoothPair bluetoothPair2 = BluetoothPair.this;
                            bluetoothPair2.stopPairTimeout(bluetoothPair2.mPairingDevice);
                        }
                        if (intExtra == 12) {
                            z = true;
                        } else {
                            z = false;
                        }
                        BluetoothPair.this.mBtPairEventCbManager.onAdapterStatus(z, BluetoothUtil.hasBle(BluetoothPair.this.mContext));
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class PairBtDeviceThread extends Thread {
        private boolean isThreadRunning;
        private boolean isWaiting;
        private boolean isWaitingForResult;
        private BluetoothDevice mPairTaskDevice;
        private final LinkedBlockingQueue<PairTask> mPairTaskQueue;
        private final String tag;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean addPairTask(com.jieli.bluetooth_connect.impl.BluetoothPair.PairTask r5) {
            /*
                r4 = this;
                r0 = 0
                if (r5 == 0) goto Le
                java.util.concurrent.LinkedBlockingQueue<com.jieli.bluetooth_connect.impl.BluetoothPair$PairTask> r1 = r4.mPairTaskQueue     // Catch: java.lang.InterruptedException -> La
                r1.put(r5)     // Catch: java.lang.InterruptedException -> La
                r5 = 1
                goto Lf
            La:
                r5 = move-exception
                r5.printStackTrace()
            Le:
                r5 = 0
            Lf:
                if (r5 == 0) goto L31
                boolean r1 = r4.isWaiting
                if (r1 == 0) goto L31
                boolean r1 = r4.isWaitingForResult
                if (r1 != 0) goto L31
                r4.isWaiting = r0
                java.util.concurrent.LinkedBlockingQueue<com.jieli.bluetooth_connect.impl.BluetoothPair$PairTask> r0 = r4.mPairTaskQueue
                monitor-enter(r0)
                java.lang.String r1 = r4.tag     // Catch: java.lang.Throwable -> L2e
                java.lang.String r2 = "addPairTask"
                java.lang.String r3 = "notify"
                com.jieli.bluetooth_connect.util.JL_Log.i(r1, r2, r3)     // Catch: java.lang.Throwable -> L2e
                java.util.concurrent.LinkedBlockingQueue<com.jieli.bluetooth_connect.impl.BluetoothPair$PairTask> r1 = r4.mPairTaskQueue     // Catch: java.lang.Throwable -> L2e
                r1.notify()     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                goto L31
            L2e:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                throw r5
            L31:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.impl.BluetoothPair.PairBtDeviceThread.addPairTask(com.jieli.bluetooth_connect.impl.BluetoothPair$PairTask):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopThread() {
            JL_Log.i(this.tag, "stopThread", "");
            this.isThreadRunning = false;
            this.mPairTaskDevice = null;
            wakeUp(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wakeUp(BluetoothDevice device) {
            if (device == null || BluetoothUtil.deviceEquals(this.mPairTaskDevice, device)) {
                synchronized (this.mPairTaskQueue) {
                    try {
                        if (this.isWaitingForResult) {
                            if (this.isWaiting) {
                                this.mPairTaskQueue.notifyAll();
                            } else {
                                this.mPairTaskQueue.notify();
                            }
                        } else if (this.isWaiting) {
                            this.mPairTaskQueue.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean unPair;
            String address;
            JL_Log.i(BluetoothPair.TAG, this.tag, "start..");
            this.isThreadRunning = true;
            synchronized (this.mPairTaskQueue) {
                while (this.isThreadRunning) {
                    this.isWaitingForResult = false;
                    this.mPairTaskDevice = null;
                    if (this.mPairTaskQueue.isEmpty()) {
                        this.isWaiting = true;
                        JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTaskQueue is empty, wait ...");
                        try {
                            this.mPairTaskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTaskQueue is not empty, notify ...");
                    } else {
                        this.isWaiting = false;
                        PairTask peek = this.mPairTaskQueue.peek();
                        if (peek != null) {
                            this.mPairTaskDevice = peek.getDevice();
                            if (peek.getOp() == 0) {
                                unPair = BluetoothPair.this.pair(this.mPairTaskDevice, peek.getPairWay());
                            } else {
                                unPair = BluetoothPair.this.unPair(this.mPairTaskDevice);
                            }
                            JL_Log.i(BluetoothPair.TAG, this.tag, "task : " + peek + " execute : " + unPair);
                            if (!unPair) {
                                BluetoothPair bluetoothPair = BluetoothPair.this;
                                BluetoothDevice bluetoothDevice = this.mPairTaskDevice;
                                if (bluetoothDevice == null) {
                                    address = "";
                                } else {
                                    address = bluetoothDevice.getAddress();
                                }
                                bluetoothPair.onError(bluetoothDevice, ErrorInfo.buildError(3, 0, address));
                            } else {
                                this.isWaitingForResult = true;
                                JL_Log.i(BluetoothPair.TAG, this.tag, "wait for system callback");
                                try {
                                    this.mPairTaskQueue.wait(30000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                                JL_Log.i(BluetoothPair.TAG, this.tag, "system callback, notify and poll ...");
                            }
                        } else {
                            JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTask is null,  poll...");
                        }
                        this.mPairTaskQueue.poll();
                    }
                }
            }
            this.mPairTaskQueue.clear();
            BluetoothPair.this.mPairBtDeviceThread = null;
            JL_Log.i(BluetoothPair.TAG, this.tag, "exit..");
        }

        private PairBtDeviceThread() {
            super("PairBtDeviceThread");
            this.tag = PairBtDeviceThread.class.getSimpleName();
            this.mPairTaskQueue = new LinkedBlockingQueue<>();
        }
    }

    /* loaded from: classes10.dex */
    public static class PairTask {
        private static final int OP_CANCEL_PAIR = 1;
        private static final int OP_PAIR = 0;
        private final BluetoothDevice mDevice;
        private final int mOp;
        private int pairWay = 0;

        public PairTask(int op, BluetoothDevice device) {
            this.mOp = op;
            this.mDevice = device;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        public int getOp() {
            return this.mOp;
        }

        public int getPairWay() {
            return this.pairWay;
        }

        public PairTask setPairWay(int pairWay) {
            this.pairWay = pairWay;
            return this;
        }

        public String toString() {
            return "PairTask{mOp=" + this.mOp + ", mDevice=" + this.mDevice + ", pairWay=" + this.pairWay + '}';
        }
    }

    public BluetoothPair(Context context, OnBtDevicePairListener listener) {
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        android.bluetooth.BluetoothManager bluetoothManager = (android.bluetooth.BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.btAdapter = bluetoothManager.getAdapter();
        } else {
            this.btAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        addListener(listener);
        registerReceiver();
        startPairTaskThread();
    }

    private boolean addPairTask(PairTask task) {
        if (task != null) {
            startPairTaskThread();
            return this.mPairBtDeviceThread.addPairTask(task);
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private int getDeviceBoundWay(BluetoothDevice device) {
        int i;
        BluetoothAdapter bluetoothAdapter;
        int isLeAudioSupported;
        int i2 = 0;
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            BluetoothOption bluetoothOption = this.mBluetoothOption;
            if (bluetoothOption != null && bluetoothOption.isSupportCTKD() && device.getType() == 3 && (i = Build.VERSION.SDK_INT) >= 23) {
                if (i >= 33 && (bluetoothAdapter = this.btAdapter) != null) {
                    isLeAudioSupported = bluetoothAdapter.isLeAudioSupported();
                    if (isLeAudioSupported == 10) {
                        i2 = 1;
                    }
                }
                i2 ^= 1;
            }
            JL_Log.d(TAG, "getDeviceBoundWay", "pairWay : " + i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        BluetoothDevice bluetoothDevice;
        if (message.what == 1014 && (bluetoothDevice = (BluetoothDevice) message.obj) != null) {
            wakeupPairTaskThread(bluetoothDevice);
            onError(bluetoothDevice, ErrorInfo.buildError(4, 0, bluetoothDevice.getAddress()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(BluetoothDevice device, ErrorInfo error) {
        this.mBtPairEventCbManager.onPairError(device, error);
    }

    private void registerReceiver() {
        if (this.mBluetoothPairReceiver == null) {
            this.mBluetoothPairReceiver = new BluetoothPairReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothPairReceiver, intentFilter);
        }
    }

    private void setPairingDevice(BluetoothDevice pairingDevice) {
        this.mPairingDevice = pairingDevice;
    }

    private void startPairTaskThread() {
        if (this.mPairBtDeviceThread == null) {
            PairBtDeviceThread pairBtDeviceThread = new PairBtDeviceThread();
            this.mPairBtDeviceThread = pairBtDeviceThread;
            pairBtDeviceThread.start();
        }
    }

    private void startPairTimeOut(BluetoothDevice device) {
        if (device == null) {
            onError(null, ErrorInfo.buildError(1));
        } else {
            if (this.mHandler.hasMessages(1014)) {
                onError(device, ErrorInfo.buildError(5));
                return;
            }
            Message obtainMessage = this.mHandler.obtainMessage(1014, device);
            setPairingDevice(device);
            this.mHandler.sendMessageDelayed(obtainMessage, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPairTaskThread() {
        PairBtDeviceThread pairBtDeviceThread = this.mPairBtDeviceThread;
        if (pairBtDeviceThread != null) {
            pairBtDeviceThread.stopThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPairTimeout(BluetoothDevice device) {
        if (this.mHandler.hasMessages(1014) && BluetoothUtil.deviceEquals(device, this.mPairingDevice)) {
            this.mHandler.removeMessages(1014);
            setPairingDevice(null);
        }
    }

    private void unregisterReceiver() {
        BluetoothPairReceiver bluetoothPairReceiver = this.mBluetoothPairReceiver;
        if (bluetoothPairReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothPairReceiver);
            this.mBluetoothPairReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeupPairTaskThread(BluetoothDevice device) {
        PairBtDeviceThread pairBtDeviceThread = this.mPairBtDeviceThread;
        if (pairBtDeviceThread != null) {
            pairBtDeviceThread.wakeUp(device);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        unregisterReceiver();
        stopPairTaskThread();
        this.mBtPairEventCbManager.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public List<BluetoothDevice> getPairedDevices() {
        return BluetoothUtil.getPairedDevices(this.mContext);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean isPaired(BluetoothDevice device) {
        if (!ConnectUtil.isHasConnectPermission(this.mContext) || device == null || 12 != device.getBondState()) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean isPairing(BluetoothDevice device) {
        if (!ConnectUtil.isHasConnectPermission(this.mContext) || device == null || 11 != device.getBondState()) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean pair(BluetoothDevice device) {
        if (device != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            return pair(device, getDeviceBoundWay(device));
        }
        JL_Log.w(TAG, IXxxXO.f20858XOxIOxOx, "device is null");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption option) {
        this.mBluetoothOption = option;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice device) {
        return tryToPair(device, getDeviceBoundWay(device));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToUnPair(BluetoothDevice device) {
        if (device == null) {
            return false;
        }
        return addPairTask(new PairTask(1, device));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean unPair(BluetoothDevice device) {
        if (device == null) {
            JL_Log.e(TAG, "unPair", "device is null.");
            return false;
        }
        boolean removeBond = BluetoothUtil.removeBond(this.mContext, device);
        JL_Log.w(TAG, "unPair", "removeBond : " + removeBond);
        if (removeBond) {
            startPairTimeOut(device);
        }
        return removeBond;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtDevicePairListener listener) {
        this.mBtPairEventCbManager.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtDevicePairListener listener) {
        this.mBtPairEventCbManager.removeListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice device, @IntRange(from = 0, to = 2) int pairWay) {
        if (device == null) {
            return false;
        }
        return addPairTask(new PairTask(0, device).setPairWay(pairWay));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean pair(BluetoothDevice device, @IntRange(from = 0, to = 2) int pairWay) {
        boolean z;
        if (device == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, IXxxXO.f20858XOxIOxOx, "device is null");
            return false;
        }
        if (pairWay < 0 || pairWay > 2) {
            pairWay = 0;
        }
        if (pairWay == 0) {
            z = BluetoothUtil.createBond(this.mContext, device);
            JL_Log.d(TAG, IXxxXO.f20858XOxIOxOx, "createBond ---> " + z);
        } else {
            boolean createBond = BluetoothUtil.createBond(this.mContext, device, pairWay);
            String str = TAG;
            JL_Log.d(str, IXxxXO.f20858XOxIOxOx, "createBond pairWay = " + pairWay + ", result : " + createBond);
            if (createBond) {
                z = createBond;
            } else {
                z = BluetoothUtil.createBond(this.mContext, device);
                JL_Log.i(str, IXxxXO.f20858XOxIOxOx, "Failed to pair with way, so createBond result : " + z);
            }
        }
        if (!z) {
            return false;
        }
        startPairTimeOut(device);
        return true;
    }
}
