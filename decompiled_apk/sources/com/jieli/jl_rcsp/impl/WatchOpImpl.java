package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;
import com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.interfaces.watch.IWatchManager;
import com.jieli.jl_rcsp.interfaces.watch.IWatchOp;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.NotificationMsg;
import com.jieli.jl_rcsp.model.WatchConfigure;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.external_flash.ExtFlashIOCtrlNoResponseCmd;
import com.jieli.jl_rcsp.model.command.external_flash.GetExternalFlashMsgCmd;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import com.jieli.jl_rcsp.model.data.DataParams;
import com.jieli.jl_rcsp.model.data.SendParams;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.WatchCallbackManager;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.DataUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.watch.WatchBase;
import com.jieli.jl_rcsp.watch.fatfs.FatFsWatch;
import com.jieli.jl_rcsp.watch.rcsp.RcspWatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class WatchOpImpl extends RcspOpImpl implements IWatchOp {
    public static final int FUNC_FILE_BROWSE = 2;
    public static final int FUNC_RCSP = 0;
    public static final int FUNC_WATCH = 1;
    public static int[] WATCH_STORAGE_INDEX_LIST = {3, 6};
    public static final String g = "WatchOpImpl";

    /* renamed from: a, reason: collision with root package name */
    public final WatchCallbackManager f17904a;
    public final int b;
    public IWatchManager c;
    public final DataTransferOpImpl d;
    public final OnRcspCallback e;
    public final OnRcspEventListener f;

    /* loaded from: classes8.dex */
    public final class RcspProgressListener implements OnFatFileProgressListener {

        /* renamed from: a, reason: collision with root package name */
        public final OnFatFileProgressListener f17909a;

        public RcspProgressListener(OnFatFileProgressListener onFatFileProgressListener) {
            this.f17909a = onFatFileProgressListener;
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onProgress(float f) {
            OnFatFileProgressListener onFatFileProgressListener = this.f17909a;
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onProgress(f);
            }
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onStart(String str) {
            OnFatFileProgressListener onFatFileProgressListener = this.f17909a;
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStart(str);
            }
        }

        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
        public void onStop(int i) {
            if (WatchOpImpl.this.c instanceof RcspWatch) {
                if (i == 0) {
                    ((RcspWatch) WatchOpImpl.this.c).reLoadFolder(new OnWatchOpCallback<ArrayList<FatFile>>() { // from class: com.jieli.jl_rcsp.impl.WatchOpImpl.RcspProgressListener.1
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            if (RcspProgressListener.this.f17909a != null) {
                                RcspProgressListener.this.f17909a.onStop(baseError.getSubCode());
                            }
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(ArrayList<FatFile> arrayList) {
                            if (RcspProgressListener.this.f17909a != null) {
                                RcspProgressListener.this.f17909a.onStop(0);
                            }
                        }
                    });
                    JL_Log.w(WatchOpImpl.g, "RcspHandProgressListener", "reLoadFolder >>>> ");
                    return;
                } else {
                    OnFatFileProgressListener onFatFileProgressListener = this.f17909a;
                    if (onFatFileProgressListener != null) {
                        onFatFileProgressListener.onStop(i);
                        return;
                    }
                    return;
                }
            }
            OnFatFileProgressListener onFatFileProgressListener2 = this.f17909a;
            if (onFatFileProgressListener2 != null) {
                onFatFileProgressListener2.onStop(i);
            }
        }
    }

    public WatchOpImpl(int i) {
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.WatchOpImpl.3
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i2) {
                BluetoothDevice targetDevice = WatchOpImpl.this.getTargetDevice();
                JL_Log.w(WatchOpImpl.g, "onConnectStateChange", "device = " + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", connectedDevice = " + RcspUtil.printBtDeviceInfo(targetDevice) + ", status = " + i2);
                if (RcspUtil.deviceEquals(bluetoothDevice, targetDevice) && (i2 == 2 || i2 == 0)) {
                    WatchOpImpl.this.b();
                }
                WatchOpImpl.this.f17904a.onConnectStateChange(bluetoothDevice, i2);
                super.onConnectStateChange(bluetoothDevice, i2);
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
                WatchOpImpl.this.f17904a.onMandatoryUpgrade(bluetoothDevice);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                WatchOpImpl.this.f17904a.onRcspCommand(bluetoothDevice, commandBase);
                if (commandBase.getId() == 26 && (commandBase instanceof ExtFlashIOCtrlNoResponseCmd)) {
                    ExternalFlashIOCtrlParam externalFlashIOCtrlParam = (ExternalFlashIOCtrlParam) ((ExtFlashIOCtrlNoResponseCmd) commandBase).getParam();
                    if (externalFlashIOCtrlParam.getOp() == 3 && externalFlashIOCtrlParam.getWatchOp() == 2) {
                        WatchOpImpl.this.f17904a.onCurrentWatchInfo(bluetoothDevice, externalFlashIOCtrlParam.getFilePath());
                    }
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                WatchOpImpl.this.f17904a.onRcspDataCmd(bluetoothDevice, commandBase);
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspError(BluetoothDevice bluetoothDevice, BaseError baseError) {
                WatchOpImpl.this.f17904a.onRcspError(bluetoothDevice, baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspInit(BluetoothDevice bluetoothDevice, boolean z) {
                JL_Log.i(WatchOpImpl.g, "onRcspInit", "device = " + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", isInit = " + z);
                WatchOpImpl.this.f17904a.onRcspInit(bluetoothDevice, z);
                if (z) {
                    WatchOpImpl.this.b();
                    WatchOpImpl.this.a(bluetoothDevice);
                }
            }
        };
        this.e = onRcspCallback;
        this.f = new OnRcspEventListener() { // from class: com.jieli.jl_rcsp.impl.WatchOpImpl.4
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener
            public void onBatteryChange(BluetoothDevice bluetoothDevice, BatteryInfo batteryInfo) {
                WatchOpImpl.this.f17904a.onDevicePower(bluetoothDevice, batteryInfo);
            }
        };
        this.f17904a = new WatchCallbackManager();
        this.b = i;
        JL_Log.i(g, "init", RcspUtil.formatString("Lib name = %s(%d), func =  %d. clazz : %s", WatchConstant.getLibVersionName(), Integer.valueOf(WatchConstant.getLibVersionCode()), Integer.valueOf(i), this));
        if (i != 1) {
            if (i == 2 && !FileBrowseManager.getInstance().isInit()) {
                FileBrowseManager.getInstance().init(this);
            }
        } else {
            registerOnRcspCallback(onRcspCallback);
            if (!FileBrowseManager.getInstance().isInit()) {
                FileBrowseManager.getInstance().init(this);
            }
        }
        DataTransferOpImpl instance = DataTransferOpImpl.instance(this);
        this.d = instance;
        instance.addListener(new OnDataTransferListener() { // from class: com.jieli.jl_rcsp.impl.WatchOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onError(BluetoothDevice bluetoothDevice, BaseError baseError) {
                WatchOpImpl.this.f17904a.onBigDataError(bluetoothDevice, baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onReceiveData(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                WatchOpImpl.this.f17904a.onReceiveBigData(bluetoothDevice, i2, bArr);
                if (i2 == 2) {
                    WatchOpImpl watchOpImpl = WatchOpImpl.this;
                    RTCOpImpl.parseRTCBigData(watchOpImpl, watchOpImpl.mRcspEventListenerManager, bArr);
                } else if (i2 == 5) {
                    WatchOpImpl.this.a(bArr);
                }
            }
        });
    }

    public void cancelDataTransfer(OnOperationCallback<Boolean> onOperationCallback) {
        this.d.cancelDataTransfer(onOperationCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public boolean cancelTransfer() {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager == null) {
            return false;
        }
        return iWatchManager.cancelTransfer();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void createWatchFile(String str, boolean z, OnFatFileProgressListener onFatFileProgressListener) {
        if (!a(onFatFileProgressListener) || a("createWatchFile", onFatFileProgressListener)) {
            return;
        }
        this.c.createWatchFile(str, z, new RcspProgressListener(onFatFileProgressListener));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void deleteWatchFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!a(onFatFileProgressListener) || a("deleteWatchFile", onFatFileProgressListener)) {
            return;
        }
        this.c.deleteWatchFile(str, onFatFileProgressListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void enableCustomWatchBg(String str, OnWatchOpCallback<FatFile> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.enableCustomWatchBg(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public String getCurrentBrowsePath() {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager == null) {
            return null;
        }
        return iWatchManager.getCurrentBrowsePath();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getCurrentWatchInfo(OnWatchOpCallback<FatFile> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.getCurrentWatchInfo(onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getCustomWatchBgInfo(String str, OnWatchOpCallback<String> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.getCustomWatchBgInfo(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public WatchConfigure getWatchConfigure(BluetoothDevice bluetoothDevice) {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager == null) {
            return null;
        }
        return iWatchManager.getWatchConfigure(bluetoothDevice);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchFileSize(String str, OnWatchOpCallback<WatchFileContent> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.getWatchFileSize(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchMessage(String str, OnWatchOpCallback<String> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.getWatchMessage(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchSysLeftSize(OnWatchOpCallback<Long> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.getWatchSysLeftSize(onWatchOpCallback);
        }
    }

    public boolean isDataTransfer() {
        return this.d.isDataTransfer();
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public boolean isDeviceConnected(BluetoothDevice bluetoothDevice) {
        return RcspUtil.deviceEquals(bluetoothDevice, getConnectedDevice());
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public boolean isOTAResource() {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager != null && iWatchManager.isOTAResource()) {
            return true;
        }
        return false;
    }

    public boolean isWatchSystemOk() {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager != null && iWatchManager.isInit()) {
            return true;
        }
        return false;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void jumpToUpdateResource(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.jumpToUpdateResource(z, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void listWatchList(OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.listWatchList(onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void openWatchFile(String str, OnWatchOpCallback<byte[]> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            if (c()) {
                JL_Log.w(g, "openWatchFile", "The device is busy.");
                if (onWatchOpCallback != null) {
                    onWatchOpCallback.onFailed(new BaseError(12545, WatchError.getErrorDesc(12545)));
                    return;
                }
                return;
            }
            this.c.openWatchFile(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void pushMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.pushMessageInfo(notificationMsg, onWatchOpCallback);
        }
    }

    public void readLargeData(DataParams dataParams, OnDataEventCallback onDataEventCallback) {
        this.d.readLargeData(dataParams, onDataEventCallback);
    }

    @Override // com.jieli.jl_rcsp.impl.RcspOpImpl, com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void receiveDataFromDevice(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        super.receiveDataFromDevice(bluetoothDevice, basePacket);
        a(bluetoothDevice, basePacket);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void registerOnWatchCallback(OnWatchCallback onWatchCallback) {
        this.f17904a.registerWatchCallback(onWatchCallback);
        BluetoothDevice targetDevice = getTargetDevice();
        if (targetDevice != null) {
            DeviceInfo deviceInfo = this.mStatusManager.getDeviceInfo(targetDevice);
            ExternalFlashMsgResponse extFlashMsg = this.mStatusManager.getExtFlashMsg(targetDevice);
            if (deviceInfo != null) {
                if (deviceInfo.isMandatoryUpgrade()) {
                    onWatchCallback.onMandatoryUpgrade(targetDevice);
                    return;
                }
                if (extFlashMsg != null && extFlashMsg.getSysStatus() != 0) {
                    onWatchCallback.onWatchSystemException(targetDevice, extFlashMsg.getSysStatus());
                } else if (deviceInfo.getExpandMode() == 1) {
                    JL_Log.w(g, "registerOnWatchCallback", "onResourceUpdateUnfinished >>> ");
                    onWatchCallback.onResourceUpdateUnfinished(targetDevice);
                }
            }
        }
    }

    @Override // com.jieli.jl_rcsp.impl.RcspOpImpl, com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void release() {
        JL_Log.i(g, "release", "clazz : " + this);
        FileBrowseManager.getInstance().release();
        unregisterOnRcspCallback(this.e);
        super.release();
        b();
        this.d.destroy();
        this.f17904a.release();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void removeMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.removeMessageInfo(notificationMsg, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void replaceWatchFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!a(onFatFileProgressListener) || a("replaceWatchFile", onFatFileProgressListener)) {
            return;
        }
        this.c.replaceWatchFile(str, new RcspProgressListener(onFatFileProgressListener));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void requestDeviceConfigure(OnWatchOpCallback<WatchConfigure> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.requestDeviceConfigure(onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void requestDevicePower(OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.requestDevicePower(onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void restoreWatchSystem(OnFatFileProgressListener onFatFileProgressListener) {
        if (a(onFatFileProgressListener)) {
            this.c.restoreWatchSystem(onFatFileProgressListener);
        }
    }

    public void sendLargeData(SendParams sendParams, OnDataEventCallback onDataEventCallback) {
        this.d.sendLargeData(sendParams, onDataEventCallback);
    }

    public void sendRcspCommand(CommandBase commandBase, RcspCommandCallback rcspCommandCallback) {
        sendRcspCommand(getConnectedDevice(), commandBase, rcspCommandCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void setCurrentWatchInfo(String str, OnWatchOpCallback<FatFile> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.setCurrentWatchInfo(str, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void syncWeatherInfo(PushInfoDataToDeviceCmd.Weather weather, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.syncWeatherInfo(weather, onWatchOpCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void unregisterOnWatchCallback(OnWatchCallback onWatchCallback) {
        this.f17904a.unregisterWatchCallback(onWatchCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void updateWatchResource(String str, OnUpdateResourceCallback onUpdateResourceCallback) {
        IWatchManager iWatchManager = this.c;
        if (iWatchManager != null) {
            iWatchManager.updateWatchResource(str, onUpdateResourceCallback);
        } else if (onUpdateResourceCallback != null) {
            onUpdateResourceCallback.onError(WatchError.ERR_FAT_JNI_INIT, WatchError.getErrorDesc(WatchError.ERR_FAT_JNI_INIT));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void writeResourceOTAFlag(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (a(onWatchOpCallback)) {
            this.c.writeResourceOTAFlag(z, onWatchOpCallback);
        }
    }

    public final void b() {
        if (this.c != null) {
            unregisterOnRcspEventListener(this.f);
            this.c.destroy();
            this.c = null;
        }
    }

    public final boolean c() {
        DeviceInfo deviceInfo = getDeviceInfo();
        return deviceInfo != null && deviceInfo.getPhoneStatus() == 1;
    }

    public final void a(OnOperationCallback<ExternalFlashMsgResponse> onOperationCallback) {
        WatchBase.queryExtFlashMsgForDevice(this, onOperationCallback);
    }

    public final void a(final BluetoothDevice bluetoothDevice) {
        if (this.b != 1) {
            return;
        }
        DeviceInfo deviceInfo = this.mStatusManager.getDeviceInfo(bluetoothDevice);
        String str = g;
        JL_Log.d(str, "handleRcspInit", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", " + deviceInfo);
        if (deviceInfo != null) {
            if (deviceInfo.isSupportExternalFlashTransfer()) {
                ExternalFlashMsgResponse extFlashMsg = this.mStatusManager.getExtFlashMsg(bluetoothDevice);
                JL_Log.d(str, "handleRcspInit", "flashMsg = " + extFlashMsg);
                if (extFlashMsg == null) {
                    a(new OnOperationCallback<ExternalFlashMsgResponse>() { // from class: com.jieli.jl_rcsp.impl.WatchOpImpl.2
                        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                        public void onFailed(BaseError baseError) {
                            WatchOpImpl.this.f17904a.onWatchSystemInit(baseError.getSubCode());
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                        public void onSuccess(ExternalFlashMsgResponse externalFlashMsgResponse) {
                            if (WatchOpImpl.this.mStatusManager.getExtFlashMsg(bluetoothDevice) == null) {
                                WatchOpImpl.this.mStatusManager.updateExtFlashMsg(bluetoothDevice, externalFlashMsgResponse);
                            }
                            WatchOpImpl.this.a(bluetoothDevice);
                        }
                    });
                    return;
                }
                if (extFlashMsg.getSystem() == 0) {
                    this.c = new FatFsWatch(this, this.f17904a);
                } else {
                    this.c = new RcspWatch(this, this.f17904a);
                }
                this.c.init();
                JL_Log.w(str, "handleRcspInit", "init WatchManager....SysStatus = " + extFlashMsg.getSysStatus());
                registerOnRcspEventListener(this.f);
                return;
            }
            JL_Log.w(str, "handleRcspInit", "device does not support flash to transfer data.");
        }
    }

    public final void b(byte[] bArr) {
        List<LtvBean> parseLTVData2 = DataUtil.parseLTVData2(bArr);
        HashMap hashMap = new HashMap();
        for (LtvBean ltvBean : parseLTVData2) {
            byte[] data = ltvBean.getData();
            int type = ltvBean.getType();
            if (type == 0 || type == 1 || type == 2 || type == 3) {
                if (data[0] == 0) {
                    int length = data.length - 1;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(data, 1, bArr2, 0, length);
                    hashMap.put(Integer.valueOf(ltvBean.getType()), RcspUtil.parseLTVData(bArr2));
                }
            }
        }
        RcspEventListenerManager rcspEventListenerManager = this.mRcspEventListenerManager;
        if (rcspEventListenerManager != null) {
            rcspEventListenerManager.onPlatformInterfaceInfoChange(getConnectedDevice(), hashMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        final ExternalFlashMsgResponse externalFlashMsgResponse;
        int opCode = basePacket.getOpCode();
        boolean z = basePacket.getType() == 1;
        CommandBase convert2Command = ParseHelper.convert2Command(bluetoothDevice, basePacket);
        if (convert2Command == null) {
            BaseError baseError = new BaseError(12289, "Failed to parse RCSP data.");
            baseError.setOpCode(basePacket.getOpCode());
            this.f17904a.onRcspError(bluetoothDevice, baseError);
            return;
        }
        if (z || opCode != 214 || basePacket.getStatus() != 0 || (externalFlashMsgResponse = (ExternalFlashMsgResponse) ((GetExternalFlashMsgCmd) convert2Command).getResponse()) == null) {
            return;
        }
        JL_Log.i(g, "handleWatchCmd", "getDevExtFlashMsg ok, response : " + externalFlashMsgResponse);
        this.mStatusManager.updateExtFlashMsg(bluetoothDevice, externalFlashMsgResponse);
        this.f17904a.onExternalFlashMsg(bluetoothDevice, externalFlashMsgResponse);
        if (externalFlashMsgResponse.getSysStatus() != 0) {
            if (this.c == null) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.impl.Oxx0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        WatchOpImpl.this.a(bluetoothDevice, externalFlashMsgResponse);
                    }
                }, 100L);
            } else {
                this.f17904a.onWatchSystemException(bluetoothDevice, externalFlashMsgResponse.getSysStatus());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, ExternalFlashMsgResponse externalFlashMsgResponse) {
        this.f17904a.onWatchSystemException(bluetoothDevice, externalFlashMsgResponse.getSysStatus());
    }

    public final void a(byte[] bArr) {
        JL_Log.d(g, "parsePlatformInterfaceBigData", "data : " + CHexConver.byte2HexStr(bArr));
        if ((bArr[0] & 15) != 0 || bArr.length < 5) {
            return;
        }
        int bytesToInt = CHexConver.bytesToInt(bArr, 1, 4);
        if (bArr.length >= bytesToInt + 5) {
            byte[] bArr2 = new byte[bytesToInt];
            System.arraycopy(bArr, 5, bArr2, 0, bytesToInt);
            b(bArr2);
        }
    }

    public final boolean a(OnFatFileProgressListener onFatFileProgressListener) {
        if (this.c != null) {
            return true;
        }
        JL_Log.e(g, "checkWatchManagerIsInit", "Watch system has not been initialized.");
        if (onFatFileProgressListener == null) {
            return false;
        }
        onFatFileProgressListener.onStop(WatchError.ERR_FAT_JNI_INIT);
        return false;
    }

    public final boolean a(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!c()) {
            return false;
        }
        JL_Log.w(g, str, WatchError.getErrorDesc(12545));
        if (onFatFileProgressListener == null) {
            return true;
        }
        onFatFileProgressListener.onStop(12545);
        return true;
    }

    public final <T> boolean a(OnWatchOpCallback<T> onWatchOpCallback) {
        if (this.c != null) {
            return true;
        }
        if (onWatchOpCallback == null) {
            return false;
        }
        onWatchOpCallback.onFailed(new BaseError(WatchError.ERR_FAT_JNI_INIT, WatchError.getErrorDesc(WatchError.ERR_FAT_JNI_INIT)));
        return false;
    }
}
