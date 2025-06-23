package com.jieli.bluetooth_connect.tool;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.impl.BluetoothManager;
import com.jieli.bluetooth_connect.interfaces.IBluetoothOperation;
import com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback;
import com.jieli.bluetooth_connect.interfaces.callback.OnHistoryRecordCallback;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes10.dex */
public class ReConnectHelper {
    private static final long DEFAULT_TASK_TIMEOUT = 50000;
    private static final long DELAY = 2000;
    private static final int FAIL_CONNECT_MAX = 2;
    private static final int MSG_RECONNECT = 39271;
    private static final int MSG_RECONNECT_TIMEOUT = 39270;
    private static final long RECONNECT_TIMEOUT = 52000;
    private static final long SCAN_LIMIT = 16000;
    private static final int STATE_CONNECTING = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SCANNING = 1;
    private static final String TAG = "ReConnectHelper";
    private static int sTaskID = 1;
    private final BluetoothEventCallback mBluetoothEventCallback;
    private final IBluetoothOperation mBtOp;
    private final Context mContext;
    private long startTime;
    private final List<ReconnectTask> mTaskList = new CopyOnWriteArrayList();
    private int taskState = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.bluetooth_connect.tool.I0oOIX
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean lambda$new$0;
            lambda$new$0 = ReConnectHelper.this.lambda$new$0(message);
            return lambda$new$0;
        }
    });

    /* loaded from: classes10.dex */
    public static class ReconnectTask {
        public static final int TASK_TYPE_DEVICE = 1;
        public static final int TASK_TYPE_HISTORY = 2;
        private String address;
        private OnHistoryRecordCallback callback;
        private int connectFailCount;
        private int connectWay;
        private int taskId;
        private int taskTimeout;
        private int taskType;

        public ReconnectTask(String address) {
            setAddress(address);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ReconnectTask reconnectTask = (ReconnectTask) o;
            if (this.taskType == reconnectTask.taskType && Objects.equals(this.address, reconnectTask.address)) {
                return true;
            }
            return false;
        }

        @NonNull
        public String getAddress() {
            return this.address;
        }

        public OnHistoryRecordCallback getCallback() {
            return this.callback;
        }

        public int getConnectFailCount() {
            return this.connectFailCount;
        }

        public int getConnectWay() {
            return this.connectWay;
        }

        public int getTaskId() {
            return this.taskId;
        }

        public int getTaskTimeout() {
            return this.taskTimeout;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public int hashCode() {
            return Objects.hash(this.address, Integer.valueOf(this.taskType));
        }

        public void setAddress(@NonNull String address) {
            this.address = address;
        }

        public void setCallback(OnHistoryRecordCallback callback) {
            this.callback = callback;
        }

        public void setConnectFailCount(int connectFailCount) {
            this.connectFailCount = connectFailCount;
        }

        public void setConnectWay(int connectWay) {
            this.connectWay = connectWay;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public void setTaskTimeout(int taskTimeout) {
            this.taskTimeout = taskTimeout;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        @NonNull
        public String toString() {
            return "ReconnectTask{taskId=" + this.taskId + ", address='" + this.address + "', connectWay=" + this.connectWay + ", taskType=" + this.taskType + ", taskTimeout=" + this.taskTimeout + ", connectFailCount=" + this.connectFailCount + '}';
        }
    }

    public ReConnectHelper(Context context, IBluetoothOperation operation) {
        BluetoothEventCallback bluetoothEventCallback = new BluetoothEventCallback() { // from class: com.jieli.bluetooth_connect.tool.ReConnectHelper.1
            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onAdapterStatus(boolean bEnabled, boolean bHasBle) {
                if (!ReConnectHelper.this.isReconnecting()) {
                    return;
                }
                if (bEnabled) {
                    ReConnectHelper.this.postReconnectTaskMsg(0L);
                } else {
                    ReConnectHelper.this.setTaskState(0);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onConnection(BluetoothDevice device, int status) {
                if (ReConnectHelper.this.isReconnecting()) {
                    boolean z = true;
                    if (status != 1) {
                        boolean isReconnectDev = ReConnectHelper.this.isReconnectDev(device);
                        JL_Log.i(ReConnectHelper.TAG, "onConnection", "device ： " + ReConnectHelper.this.printBtDeviceInfo(device) + ", status : " + status + ", isReconnectDevice = " + isReconnectDev);
                        if (isReconnectDev) {
                            ReConnectHelper.this.setTaskState(0);
                            ReConnectHelper reConnectHelper = ReConnectHelper.this;
                            String address = device.getAddress();
                            if (status != 2) {
                                z = false;
                            }
                            reConnectHelper.removeTask(address, z);
                        }
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscovery(BluetoothDevice device, BleScanMessage bleScanMessage) {
                ReconnectTask reconnectTask;
                if (device != null && bleScanMessage != null && ReConnectHelper.this.isReconnecting()) {
                    String address = device.getAddress();
                    JL_Log.d(ReConnectHelper.TAG, "onDiscovery", "device : " + ReConnectHelper.this.printBtDeviceInfo(device) + ", " + bleScanMessage);
                    if (bleScanMessage.isOTA()) {
                        reconnectTask = ReConnectHelper.this.findReconnectTask(bleScanMessage.getOtaBleAddress());
                        if (reconnectTask == null) {
                            reconnectTask = ReConnectHelper.this.findReconnectTask(address);
                        }
                        if (reconnectTask != null) {
                            if (reconnectTask.getConnectWay() != 0) {
                                reconnectTask.setConnectWay(0);
                            }
                            HistoryRecord historyRecord = ReConnectHelper.this.mBtOp.getHistoryRecord(address);
                            if (historyRecord != null && !device.getAddress().equals(historyRecord.getUpdateAddress())) {
                                historyRecord.setUpdateAddress(device.getAddress());
                                ((BluetoothManager) ReConnectHelper.this.mBtOp).getHistoryRecordHelper().updateHistoryRecord(historyRecord);
                            }
                        }
                        device = null;
                    } else {
                        ReconnectTask findReconnectTask = ReConnectHelper.this.findReconnectTask(address);
                        if (findReconnectTask != null) {
                            device = ReConnectHelper.this.findTargetDevice(device, bleScanMessage, findReconnectTask.getConnectWay());
                            reconnectTask = findReconnectTask;
                        } else {
                            reconnectTask = findReconnectTask;
                            device = null;
                        }
                    }
                    JL_Log.i(ReConnectHelper.TAG, "onDiscovery", "connectDev = " + ReConnectHelper.this.printBtDeviceInfo(device) + ", " + reconnectTask);
                    if (device != null) {
                        ReConnectHelper.this.connectBtDevice(device, reconnectTask);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscoveryStatus(boolean bBle, boolean bStart) {
                if (ReConnectHelper.this.isReconnecting()) {
                    JL_Log.i(ReConnectHelper.TAG, "onDiscoveryStatus", "Start ： " + bStart);
                    if (!bStart && ReConnectHelper.this.taskState <= 1) {
                        ReConnectHelper.this.setTaskState(0);
                        ReConnectHelper.this.postReconnectTaskMsg(2000L);
                    }
                }
            }
        };
        this.mBluetoothEventCallback = bluetoothEventCallback;
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        IBluetoothOperation iBluetoothOperation = (IBluetoothOperation) ConnectUtil.checkNotNull(operation);
        this.mBtOp = iBluetoothOperation;
        iBluetoothOperation.registerBluetoothCallback(bluetoothEventCallback);
    }

    private void addTask(ReconnectTask reconnectTask) {
        boolean z = false;
        r0 = 0;
        int i = 0;
        z = false;
        if (reconnectTask != null && !this.mTaskList.contains(reconnectTask)) {
            if (reconnectTask.getTaskType() == 1) {
                if (!this.mTaskList.isEmpty()) {
                    Iterator it = new ArrayList(this.mTaskList).iterator();
                    while (it.hasNext()) {
                        if (1 == ((ReconnectTask) it.next()).getTaskType()) {
                            i++;
                        }
                    }
                }
                this.mTaskList.add(i, reconnectTask);
                z = true;
            } else {
                z = this.mTaskList.add(reconnectTask);
            }
        }
        if (z) {
            reconnectTask.setTaskId(autoIncTaskId());
            if (reconnectTask.getTaskTimeout() == 0) {
                reconnectTask.setTaskTimeout(50000);
            }
            JL_Log.d(TAG, "addTask", "" + reconnectTask);
            this.mHandler.removeMessages(reconnectTask.getTaskId());
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(reconnectTask.getTaskId(), reconnectTask.getAddress()), (long) reconnectTask.getTaskTimeout());
            setStartTime(getCurrentTime());
            this.mHandler.removeMessages(MSG_RECONNECT_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_RECONNECT_TIMEOUT, RECONNECT_TIMEOUT);
            postReconnectTaskMsg(0L);
        }
    }

    private static int autoIncTaskId() {
        int i = sTaskID;
        int i2 = i + 1;
        sTaskID = i2;
        if (i2 >= 256) {
            sTaskID = 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectBtDevice(@NonNull BluetoothDevice device, @NonNull ReconnectTask task) {
        String str = TAG;
        JL_Log.d(str, "connectBtDevice", "Ready to connect device. " + device + ", " + task);
        setTaskState(2);
        stopScan();
        if (!this.mBtOp.connectBtDevice(device, task.getConnectWay())) {
            int connectFailCount = task.getConnectFailCount() + 1;
            setTaskState(0);
            JL_Log.w(str, "connectBtDevice", "Connect device failed. Failure count = " + connectFailCount + ", limit = 2");
            if (connectFailCount < 2) {
                task.setConnectFailCount(connectFailCount);
                postReconnectTaskMsg(2000L);
            } else {
                removeTask(task, false);
            }
        }
    }

    private void doReconnectEvent(@NonNull ReconnectTask task) {
        boolean startDeviceScan;
        boolean z;
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(TAG, "doReconnectEvent", "bluetooth is close.");
            return;
        }
        if (isTaskRunning()) {
            JL_Log.w(TAG, "doReconnectEvent", "task is running.");
            return;
        }
        int i = 2;
        if (task.getTaskType() == 2 && this.mBtOp.getConnectedDevice() != null && !this.mBtOp.getBluetoothOption().isUseMultiDevice()) {
            JL_Log.w(TAG, "doReconnectEvent", "single device manager ");
            stopReconnect();
            return;
        }
        BluetoothDevice findSysConnectedDevice = findSysConnectedDevice(task.address);
        String str = TAG;
        JL_Log.i(str, "doReconnectEvent", "device ： " + printBtDeviceInfo(findSysConnectedDevice) + ", reconnectTask = " + task);
        if (findSysConnectedDevice != null) {
            connectBtDevice(findSysConnectedDevice, task);
            return;
        }
        if (this.mBtOp.isScanning()) {
            if (this.mBtOp.getScanType() == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if ((task.getConnectWay() == 1 && this.mBtOp.getScanType() == 1) || (task.getConnectWay() == 0 && this.mBtOp.getScanType() == 0)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            JL_Log.i(str, "doReconnectEvent", "isScanOk : " + z);
            if (z) {
                return;
            }
            stopScan();
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long nowLeftTime = getNowLeftTime();
        String str2 = TAG;
        JL_Log.d(str2, "doReconnectEvent", "leftTime ： " + nowLeftTime + ", startTime : " + this.startTime);
        if (nowLeftTime >= 20000) {
            if (task.getConnectWay() == 1) {
                startDeviceScan = this.mBtOp.startDeviceScan(16000L);
                JL_Log.i(str2, "doReconnectEvent", "startDeviceScan ---> " + startDeviceScan);
            } else {
                startDeviceScan = this.mBtOp.startBLEScan(16000L);
                JL_Log.i(str2, "doReconnectEvent", "startBLEScan ---> " + startDeviceScan);
            }
        } else {
            if (task.getConnectWay() == 1) {
                i = 0;
            }
            startDeviceScan = this.mBtOp.startDeviceScan(i, nowLeftTime);
            JL_Log.i(str2, "doReconnectEvent", "startDeviceScan : " + startDeviceScan + ", way = " + i);
        }
        if (startDeviceScan) {
            setTaskState(1);
        } else {
            postReconnectTaskMsg(2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReconnectTask findReconnectTask(String address) {
        if (!BluetoothAdapter.checkBluetoothAddress(address) || this.mTaskList.isEmpty()) {
            return null;
        }
        Iterator it = new ArrayList(this.mTaskList).iterator();
        while (it.hasNext()) {
            ReconnectTask reconnectTask = (ReconnectTask) it.next();
            if (address.equals(reconnectTask.getAddress())) {
                return reconnectTask;
            }
        }
        return null;
    }

    private BluetoothDevice findSysConnectedDevice(String address) {
        List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.mContext);
        if (systemConnectedBtDeviceList != null) {
            for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
                if (bluetoothDevice.getAddress().equals(address)) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public BluetoothDevice findTargetDevice(@NonNull BluetoothDevice target, @NonNull BleScanMessage scanMessage, int connectWay) {
        HistoryRecord historyRecord;
        String mappedAddress;
        BluetoothDevice bluetoothDevice;
        String mappedAddress2;
        if (connectWay == 0) {
            if (ConnectUtil.isHasConnectPermission(this.mContext) && target.getType() == 1) {
                HistoryRecord historyRecord2 = this.mBtOp.getHistoryRecord(target.getAddress());
                if (historyRecord2 != null) {
                    if (historyRecord2.getConnectType() == 0) {
                        mappedAddress2 = historyRecord2.getAddress();
                    } else {
                        mappedAddress2 = historyRecord2.getMappedAddress();
                    }
                    bluetoothDevice = getRemoteDevice(mappedAddress2);
                } else {
                    bluetoothDevice = null;
                }
                if (bluetoothDevice != null && !BluetoothUtil.deviceEquals(target, bluetoothDevice)) {
                    return bluetoothDevice;
                }
                return target;
            }
            return target;
        }
        BluetoothDevice remoteDevice = getRemoteDevice(scanMessage.getEdrAddr());
        if (remoteDevice == null && (historyRecord = this.mBtOp.getHistoryRecord(target.getAddress())) != null) {
            if (historyRecord.getConnectType() == 1) {
                mappedAddress = historyRecord.getAddress();
            } else {
                mappedAddress = historyRecord.getMappedAddress();
            }
            remoteDevice = getRemoteDevice(mappedAddress);
        }
        if (remoteDevice != null) {
            return remoteDevice;
        }
        return target;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private long getNowLeftTime() {
        return RECONNECT_TIMEOUT - (getCurrentTime() - this.startTime);
    }

    private BluetoothDevice getRemoteDevice(String address) {
        return BluetoothUtil.getRemoteDevice(this.mContext, address);
    }

    private boolean isMatchAddress(String address, String address2) {
        if (!BluetoothAdapter.checkBluetoothAddress(address) || !BluetoothAdapter.checkBluetoothAddress(address2)) {
            return false;
        }
        HistoryRecord historyRecord = this.mBtOp.getHistoryRecord(address);
        if (historyRecord == null) {
            return address.equals(address2);
        }
        if (!address2.equals(historyRecord.getAddress()) && !address2.equals(historyRecord.getMappedAddress()) && !address2.equals(historyRecord.getUpdateAddress())) {
            return false;
        }
        return true;
    }

    private boolean isTaskRunning() {
        if (!this.mBtOp.isConnecting() && !this.mBtOp.isScanning() && this.taskState == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        switch (message.what) {
            case MSG_RECONNECT_TIMEOUT /* 39270 */:
                JL_Log.w(TAG, "MSG_RECONNECT_TIMEOUT", "");
                stopReconnect();
                return true;
            case MSG_RECONNECT /* 39271 */:
                JL_Log.i(TAG, "MSG_RECONNECT", "");
                startReconnectTask();
                return true;
            default:
                Object obj = message.obj;
                if (obj instanceof String) {
                    String str = (String) obj;
                    JL_Log.w(TAG, "TASK_TIMEOUT", "address ： " + str);
                    removeTask(str, false);
                    return true;
                }
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postReconnectTaskMsg(long delay) {
        this.mHandler.removeMessages(MSG_RECONNECT);
        if (delay > 0) {
            this.mHandler.sendEmptyMessageDelayed(MSG_RECONNECT, delay);
        } else {
            this.mHandler.sendEmptyMessage(MSG_RECONNECT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printBtDeviceInfo(BluetoothDevice device) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, device);
    }

    private void release() {
        setTaskState(0);
        setStartTime(0L);
        this.mHandler.removeMessages(MSG_RECONNECT_TIMEOUT);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTask(String address, boolean result) {
        ReconnectTask findReconnectTask = findReconnectTask(address);
        if (findReconnectTask != null) {
            removeTask(findReconnectTask, result);
        }
    }

    private void setStartTime(long time) {
        this.startTime = time;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskState(int taskState) {
        this.taskState = taskState;
    }

    private void startReconnectTask() {
        if (!this.mTaskList.isEmpty() && isReconnecting() && !isTaskRunning()) {
            ReconnectTask reconnectTask = this.mTaskList.get(0);
            long nowLeftTime = getNowLeftTime();
            JL_Log.i(TAG, "startReconnectTask", "left = " + nowLeftTime + ", start reconnect task.");
            doReconnectEvent(reconnectTask);
        }
    }

    private void stopScan() {
        if (!this.mBtOp.isScanning()) {
            return;
        }
        if (this.mBtOp.getScanType() == 0) {
            this.mBtOp.stopBLEScan();
        } else {
            this.mBtOp.stopDeviceScan();
        }
    }

    public void destroy() {
        stopReconnect();
        this.mBtOp.unregisterBluetoothCallback(this.mBluetoothEventCallback);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean isReconnectDev(BluetoothDevice device) {
        if (device == null || findReconnectTask(device.getAddress()) == null) {
            return false;
        }
        return true;
    }

    public boolean isReconnecting() {
        return this.mHandler.hasMessages(MSG_RECONNECT_TIMEOUT);
    }

    public void reconnectDevice(String address, int connectWay, OnHistoryRecordCallback callback) {
        reconnectDevice(address, connectWay, 0, callback);
    }

    public void reconnectHistory(@NonNull HistoryRecord record) {
        boolean z;
        String address;
        int connectType;
        int i = 0;
        if (record.getDevType() != 5 && record.getSdkFlag() != 8 && record.getSdkFlag() != 9) {
            z = false;
        } else {
            z = true;
        }
        if (record.getConnectType() == 1 && z) {
            address = record.getMappedAddress();
        } else {
            address = record.getAddress();
        }
        if (z) {
            connectType = 0;
        } else {
            connectType = record.getConnectType();
        }
        if (BluetoothAdapter.checkBluetoothAddress(record.getUpdateAddress()) && !record.getUpdateAddress().equals(address)) {
            address = record.getUpdateAddress();
        } else {
            i = connectType;
        }
        ReconnectTask reconnectTask = new ReconnectTask(address);
        reconnectTask.setConnectWay(i);
        reconnectTask.setTaskType(2);
        addTask(reconnectTask);
    }

    public void stopReconnect() {
        if (!this.mTaskList.isEmpty()) {
            Iterator it = new ArrayList(this.mTaskList).iterator();
            while (it.hasNext()) {
                ReconnectTask reconnectTask = (ReconnectTask) it.next();
                if (reconnectTask.getCallback() != null) {
                    reconnectTask.getCallback().onFailed(0, "Reconnect task is stop.");
                }
                this.mHandler.removeMessages(reconnectTask.getTaskId());
            }
            this.mTaskList.clear();
        }
        release();
    }

    public void reconnectDevice(String address, int connectWay, int timeout, OnHistoryRecordCallback callback) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            if (callback != null) {
                callback.onFailed(1, "Address is error.");
            }
        } else {
            ReconnectTask reconnectTask = new ReconnectTask(address);
            reconnectTask.setTaskType(1);
            reconnectTask.setConnectWay(connectWay);
            reconnectTask.setTaskTimeout(timeout);
            reconnectTask.setCallback(callback);
            addTask(reconnectTask);
        }
    }

    private void removeTask(@NonNull ReconnectTask task, boolean result) {
        boolean remove = this.mTaskList.remove(task);
        JL_Log.w(TAG, "removeTask", task + ", ret = " + remove + ", result = " + result);
        if (remove) {
            if (task.getCallback() != null) {
                if (result) {
                    task.getCallback().onSuccess(this.mBtOp.getHistoryRecord(task.getAddress()));
                } else {
                    task.getCallback().onFailed(9, ConnectUtil.formatString("Connect device[%s] timeout.", task.getAddress()));
                }
            }
            this.mHandler.removeMessages(task.getTaskId());
            if (!this.mTaskList.isEmpty()) {
                postReconnectTaskMsg(0L);
            } else {
                stopReconnect();
            }
        }
    }
}
