package com.jieli.bluetooth_connect.data;

import XIXIX.OOXIXo;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes10.dex */
public class HistoryRecordDbHelper {
    private final BtConnectDatabase mBtConnectDatabase;
    private final Context mContext;
    private final HistoryRecordObserver mObserver;
    private final ExecutorService mThreadPool = Executors.newSingleThreadExecutor();

    public HistoryRecordDbHelper(Context context, BluetoothOption option, HistoryRecordObserver observer) {
        if (context != null) {
            this.mContext = context;
            this.mBtConnectDatabase = BtConnectDatabase.buildDatabase(context);
            this.mObserver = observer;
            syncSystemDeviceList(option);
            return;
        }
        throw new NullPointerException("Please call initDb method at first!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearAllHistoryRecord$4() {
        clearHistoryRecords(getHistoryRecordList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveHistoryRecord$0(BluetoothDevice bluetoothDevice, int i) {
        boolean z;
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            historyRecordByDevice = new HistoryRecord();
        } else if (bluetoothDevice.getAddress().equals(historyRecordByDevice.getUpdateAddress())) {
            return;
        }
        historyRecordByDevice.setName(bluetoothDevice.getName());
        historyRecordByDevice.setAddress(bluetoothDevice.getAddress());
        historyRecordByDevice.setDevType(bluetoothDevice.getType());
        historyRecordByDevice.setConnectType(i);
        historyRecordByDevice.setOnlineTime(System.currentTimeMillis());
        JL_Log.d("HistoryRecordDbHelper", "saveHistoryRecord", ConnectUtil.formatString("device : %s, connectWay : %d, isAddRecord = %s", BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice), Integer.valueOf(i), Boolean.valueOf(z)));
        if (z) {
            saveHistoryRecord(historyRecordByDevice);
        } else {
            updateHistoryRecord(historyRecordByDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDeviceIDs$1(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice == null) {
            return;
        }
        historyRecordByDevice.setVid(i);
        historyRecordByDevice.setUid(i2);
        historyRecordByDevice.setPid(i3);
        updateHistoryRecord(historyRecordByDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDeviceInfo$2(BluetoothDevice bluetoothDevice, int i, String str) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice == null) {
            return;
        }
        historyRecordByDevice.setSdkFlag(i);
        historyRecordByDevice.setMappedAddress(str);
        updateHistoryRecord(historyRecordByDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGpsInfo$3(BluetoothDevice bluetoothDevice, double d, double d2, int i, long j) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice != null) {
            if (d != OOXIXo.f3760XO || d2 != OOXIXo.f3760XO) {
                if (i != 0) {
                    if (i == 1) {
                        if (d != historyRecordByDevice.getRightDevLatitude() || d2 != historyRecordByDevice.getRightDevLongitude() || j > historyRecordByDevice.getRightDevUpdateTime()) {
                            historyRecordByDevice.updateRightDevGpsInfo(d, d2, j);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (d != historyRecordByDevice.getLeftDevLatitude() || d2 != historyRecordByDevice.getLeftDevLongitude() || j > historyRecordByDevice.getLeftDevUpdateTime()) {
                    historyRecordByDevice.updateLeftDevGpsInfo(d, d2, j);
                } else {
                    return;
                }
                updateHistoryRecord(historyRecordByDevice);
            }
        }
    }

    public void clearAllHistoryRecord() {
        if (this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: com.jieli.bluetooth_connect.data.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                HistoryRecordDbHelper.this.lambda$clearAllHistoryRecord$4();
            }
        });
    }

    public void clearHistoryRecords(List<HistoryRecord> historyRecords) {
        if (historyRecords == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().removeHistoryRecords(historyRecords);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onDelete(null);
        }
    }

    public void deleteHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().removeHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onDelete(historyRecord);
        }
    }

    public void destroy() {
        if (!this.mThreadPool.isShutdown()) {
            this.mThreadPool.shutdownNow();
        }
    }

    public HistoryRecord getHistoryRecordByDevice(BluetoothDevice device) {
        if (device == null) {
            return null;
        }
        return getHistoryRecordByMac(device.getAddress());
    }

    public HistoryRecord getHistoryRecordByMac(String address) {
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            return null;
        }
        return getHistoryRecordDao().getHistoryRecord(address);
    }

    public HistoryRecordDao getHistoryRecordDao() {
        return this.mBtConnectDatabase.historyRecordDao();
    }

    public List<HistoryRecord> getHistoryRecordList() {
        return getHistoryRecordDao().getHistoryRecordList();
    }

    public String getMappedAddress(String address) {
        HistoryRecord historyRecordByMac = getHistoryRecordByMac(address);
        if (historyRecordByMac == null) {
            return null;
        }
        if (address.equals(historyRecordByMac.getAddress())) {
            return historyRecordByMac.getMappedAddress();
        }
        return historyRecordByMac.getAddress();
    }

    public boolean isMatchDevice(String address, String address1) {
        if (BluetoothAdapter.checkBluetoothAddress(address) && BluetoothAdapter.checkBluetoothAddress(address1)) {
            boolean equals = address.equals(address1);
            if (!equals) {
                String mappedAddress = getMappedAddress(address);
                if (BluetoothAdapter.checkBluetoothAddress(mappedAddress)) {
                    equals = mappedAddress.equals(address1);
                }
                if (!equals) {
                    String mappedAddress2 = getMappedAddress(address1);
                    if (BluetoothAdapter.checkBluetoothAddress(mappedAddress2)) {
                        return mappedAddress2.equals(address);
                    }
                    return equals;
                }
                return equals;
            }
            return equals;
        }
        return false;
    }

    public void saveHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().addHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onInsert(historyRecord);
        }
    }

    public void syncSystemDeviceList(BluetoothOption option) {
        List<HistoryRecord> historyRecordList;
        if ((option != null && option.isNotAssociatedEDR()) || !BluetoothUtil.isBluetoothEnable() || (historyRecordList = getHistoryRecordList()) == null) {
            return;
        }
        List<BluetoothDevice> pairedDevices = BluetoothUtil.getPairedDevices(this.mContext);
        ArrayList arrayList = new ArrayList();
        for (HistoryRecord historyRecord : historyRecordList) {
            if (historyRecord.getConnectType() != 0 && historyRecord.getMappedAddress() != null) {
                if (pairedDevices != null) {
                    Iterator<BluetoothDevice> it = pairedDevices.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (isMatchDevice(historyRecord.getAddress(), it.next().getAddress())) {
                                historyRecord = null;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (historyRecord != null) {
                    arrayList.add(historyRecord);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            clearHistoryRecords(arrayList);
        }
    }

    public void updateDeviceIDs(final BluetoothDevice device, final int vid, final int uid, final int pid) {
        if (device != null && !this.mThreadPool.isShutdown()) {
            this.mThreadPool.submit(new Runnable() { // from class: com.jieli.bluetooth_connect.data.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    HistoryRecordDbHelper.this.lambda$updateDeviceIDs$1(device, vid, uid, pid);
                }
            });
        }
    }

    public void updateDeviceInfo(final BluetoothDevice device, final int sdkFlag, final String mappedAddress) {
        if (device != null && !this.mThreadPool.isShutdown()) {
            this.mThreadPool.submit(new Runnable() { // from class: com.jieli.bluetooth_connect.data.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    HistoryRecordDbHelper.this.lambda$updateDeviceInfo$2(device, sdkFlag, mappedAddress);
                }
            });
        }
    }

    public void updateGpsInfo(final BluetoothDevice device, final int devFlag, final double latitude, final double longitude, final long updateTime) {
        if (device != null && !this.mThreadPool.isShutdown()) {
            this.mThreadPool.submit(new Runnable() { // from class: com.jieli.bluetooth_connect.data.X0o0xo
                @Override // java.lang.Runnable
                public final void run() {
                    HistoryRecordDbHelper.this.lambda$updateGpsInfo$3(device, latitude, longitude, devFlag, updateTime);
                }
            });
        }
    }

    public void updateHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().updateHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onModify(historyRecord);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void saveHistoryRecord(final BluetoothDevice device, final int connectWay) {
        if (device == null || this.mThreadPool.isShutdown() || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: com.jieli.bluetooth_connect.data.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                HistoryRecordDbHelper.this.lambda$saveHistoryRecord$0(device, connectWay);
            }
        });
    }
}
