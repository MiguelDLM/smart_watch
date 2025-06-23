package com.jieli.jl_rcsp.watch;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.interfaces.watch.IWatchManager;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.NotificationMsg;
import com.jieli.jl_rcsp.model.WatchConfigure;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.GetDevConfigureCmd;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.command.external_flash.GetExternalFlashMsgCmd;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.SyncMessageTask;
import com.jieli.jl_rcsp.tool.WatchCallbackManager;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public abstract class WatchBase implements IWatchManager {
    public static final int c = 0;
    public static final byte[] d = {31, 0, 31, 0, Byte.MAX_VALUE, 0, 2, 0, 3, 2, 1, 3, 2, 2, 0, 2, -2, 31, 2, -1, -1};

    /* renamed from: a, reason: collision with root package name */
    public SyncMessageTask f18231a;
    public final OnRcspCallback b;
    protected volatile boolean isOTAResource;
    protected final RcspOpImpl mRcspOp;
    protected final WatchCallbackManager mWatchCallbackManager;
    protected String TAG = getClass().getSimpleName();
    protected final DeviceStatusManager mStatusManager = DeviceStatusManager.getInstance();
    protected boolean isSysException = false;

    /* loaded from: classes10.dex */
    public static class ExternalFlashIOCtrlBooleanResult extends ExternalFlashIOCtrlHandleResult<Boolean> {
        public ExternalFlashIOCtrlBooleanResult() {
            super();
        }

        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public Boolean handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class ExternalFlashIOCtrlHandleResult<T> implements IHandleResult<T, ExternalFlashIOCtrlCmd> {
        public ExternalFlashIOCtrlHandleResult() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public int hasResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
            if (externalFlashIOCtrlCmd == null) {
                return 1;
            }
            if (externalFlashIOCtrlCmd.getStatus() != 0) {
                return externalFlashIOCtrlCmd.getStatus();
            }
            if (externalFlashIOCtrlCmd.getResponse() == 0) {
                return 1;
            }
            return ((ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()).getResult();
        }
    }

    /* loaded from: classes10.dex */
    public static class HandleRcspCallback<T, C extends CommandBase> implements RcspCommandCallback<C> {
        protected final OnWatchOpCallback<T> callback;
        protected final String funcName;
        protected final IHandleResult<T, C> handler;

        public HandleRcspCallback(String str, OnWatchOpCallback<T> onWatchOpCallback, IHandleResult<T, C> iHandleResult) {
            this.funcName = str;
            this.handler = iHandleResult;
            this.callback = onWatchOpCallback;
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, C c) {
            int hasResult;
            if (c == null) {
                return;
            }
            IHandleResult<T, C> iHandleResult = this.handler;
            if (iHandleResult == null) {
                hasResult = 0;
            } else {
                hasResult = iHandleResult.hasResult(bluetoothDevice, c);
            }
            T t = null;
            if (c.getStatus() == 0 && hasResult == 0) {
                IHandleResult<T, C> iHandleResult2 = this.handler;
                if (iHandleResult2 != null) {
                    t = iHandleResult2.handleResult(bluetoothDevice, c);
                }
                OnWatchOpCallback<T> onWatchOpCallback = this.callback;
                if (onWatchOpCallback != null) {
                    onWatchOpCallback.onSuccess(t);
                    return;
                }
                return;
            }
            if (c.getStatus() != 0) {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12292, c.getStatus(), null));
            } else {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12293, hasResult, null));
            }
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            JL_Log.w("HandleRcspCallback", this.funcName, RcspUtil.formatString("onErrCode ---> %s", baseError));
            OnWatchOpCallback<T> onWatchOpCallback = this.callback;
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(baseError.getSubCode(), baseError.getMessage()));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class RcspBooleanResult implements IHandleResult<Boolean, CommandBase> {
        public RcspBooleanResult() {
        }

        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public int hasResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public Boolean handleResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
            return Boolean.TRUE;
        }
    }

    public WatchBase(RcspOpImpl rcspOpImpl, WatchCallbackManager watchCallbackManager) {
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.watch.WatchBase.12
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
                if (i != 1) {
                    WatchBase.this.isOTAResource = false;
                    WatchBase watchBase = WatchBase.this;
                    watchBase.isSysException = false;
                    watchBase.a();
                }
            }
        };
        this.b = onRcspCallback;
        this.mRcspOp = rcspOpImpl;
        this.mWatchCallbackManager = watchCallbackManager;
        rcspOpImpl.registerOnRcspCallback(onRcspCallback);
    }

    public static void queryExtFlashMsgForDevice(RcspOpImpl rcspOpImpl, OnOperationCallback<ExternalFlashMsgResponse> onOperationCallback) {
        if (rcspOpImpl == null) {
            return;
        }
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildGetExternalFlashMsgCmd(), new CustomRcspActionCallback("queryExtFlashMsgForDevice", onOperationCallback, new IHandleResult<ExternalFlashMsgResponse, GetExternalFlashMsgCmd>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.10
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, GetExternalFlashMsgCmd getExternalFlashMsgCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public ExternalFlashMsgResponse handleResult(BluetoothDevice bluetoothDevice, GetExternalFlashMsgCmd getExternalFlashMsgCmd) {
                if (getExternalFlashMsgCmd == null || getExternalFlashMsgCmd.getStatus() != 0) {
                    return null;
                }
                return (ExternalFlashMsgResponse) getExternalFlashMsgCmd.getResponse();
            }
        }));
    }

    public <T> void callbackError(OnWatchOpCallback<T> onWatchOpCallback, int i) {
        callbackError(onWatchOpCallback, i, FatUtil.getFatFsErrorCodeMsg(i));
    }

    public void createFileStart(String str, int i, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashInsertNewFileStartCmd(str, i), new HandleRcspCallback("createFileStart", onWatchOpCallback, new ExternalFlashIOCtrlBooleanResult()));
    }

    public void deleteFileStart(String str, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashDeleteFileStartCmd(str), new HandleRcspCallback("deleteFileStart", onWatchOpCallback, new ExternalFlashIOCtrlBooleanResult()));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void destroy() {
        this.mRcspOp.unregisterOnRcspCallback(this.b);
        a();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void enableCustomWatchBg(final String str, OnWatchOpCallback<FatFile> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashEnableCustomWatchCmd(str), new HandleRcspCallback("enableCustomWatchBg", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<FatFile>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public FatFile handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                return WatchBase.this.getWatchFileByPath(str);
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public OnWatchCallback getCallback() {
        return this.mWatchCallbackManager;
    }

    public BluetoothDevice getConnectedDevice() {
        return this.mRcspOp.getTargetDevice();
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getCurrentWatchInfo(OnWatchOpCallback<FatFile> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashGetCurrentWatchMsgCmd(), new HandleRcspCallback("getCurrentWatchInfo", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<FatFile>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public FatFile handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                if (externalFlashIOCtrlResponse == null) {
                    return null;
                }
                return WatchBase.this.getWatchFileByPath(externalFlashIOCtrlResponse.getFilePath());
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getCustomWatchBgInfo(String str, OnWatchOpCallback<String> onWatchOpCallback) {
        if (str == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(4097, "fat file path is null."));
                return;
            }
            return;
        }
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashGetCustomBgInfoCmd(str), new HandleRcspCallback("getCustomWatchBgInfo", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<String>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public String handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                if (externalFlashIOCtrlResponse == null) {
                    return null;
                }
                return externalFlashIOCtrlResponse.getFilePath();
            }
        }));
    }

    public ExternalFlashMsgResponse getExternalFlashMsg(BluetoothDevice bluetoothDevice) {
        return this.mStatusManager.getExtFlashMsg(bluetoothDevice);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jieli.jl_rcsp.model.WatchConfigure getWatchConfigure(android.bluetooth.BluetoothDevice r3) {
        /*
            r2 = this;
            com.jieli.jl_rcsp.tool.DeviceStatusManager r0 = r2.mStatusManager
            com.jieli.jl_rcsp.model.device.DeviceConfiguration r3 = r0.getDeviceConfigure(r3)
            if (r3 == 0) goto L28
            int r0 = r3.getType()
            if (r0 != 0) goto L28
            boolean r0 = r3 instanceof com.jieli.jl_rcsp.model.WatchConfigure
            if (r0 == 0) goto L15
            com.jieli.jl_rcsp.model.WatchConfigure r3 = (com.jieli.jl_rcsp.model.WatchConfigure) r3
            goto L29
        L15:
            com.jieli.jl_rcsp.model.WatchConfigure r0 = new com.jieli.jl_rcsp.model.WatchConfigure     // Catch: java.lang.RuntimeException -> L24
            int r1 = r3.getVersion()     // Catch: java.lang.RuntimeException -> L24
            byte[] r3 = r3.getData()     // Catch: java.lang.RuntimeException -> L24
            r0.<init>(r1, r3)     // Catch: java.lang.RuntimeException -> L24
            r3 = r0
            goto L29
        L24:
            r3 = move-exception
            r3.printStackTrace()
        L28:
            r3 = 0
        L29:
            if (r3 != 0) goto L33
            com.jieli.jl_rcsp.model.WatchConfigure r3 = new com.jieli.jl_rcsp.model.WatchConfigure
            byte[] r0 = com.jieli.jl_rcsp.watch.WatchBase.d
            r1 = 0
            r3.<init>(r1, r0)
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.watch.WatchBase.getWatchConfigure(android.bluetooth.BluetoothDevice):com.jieli.jl_rcsp.model.WatchConfigure");
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void getWatchMessage(String str, OnWatchOpCallback<String> onWatchOpCallback) {
        if (str == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(4097, "fat file path is null."));
                return;
            }
            return;
        }
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashGetWatchVersionCmd(str), new HandleRcspCallback("getWatchMessage", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<String>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public String handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse();
                if (externalFlashIOCtrlResponse == null) {
                    return null;
                }
                return externalFlashIOCtrlResponse.getVersion();
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public boolean isOTAResource() {
        return this.isOTAResource;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public boolean isSysException() {
        return this.isSysException;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void jumpToUpdateResource(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        RcspOpImpl rcspOpImpl = this.mRcspOp;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildExternalFlashUpdateResourceCmd(z), new HandleRcspCallback("jumpToUpdateResource", onWatchOpCallback, new ExternalFlashIOCtrlBooleanResult()));
    }

    public <T> void onCallbackError(OnWatchOpCallback<T> onWatchOpCallback, int i) {
        if (onWatchOpCallback != null) {
            onWatchOpCallback.onFailed(new BaseError(i, WatchError.getErrorDesc(i)));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void pushMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (!this.mRcspOp.isRcspInit()) {
            callbackError(onWatchOpCallback, 8192);
            return;
        }
        b();
        this.f18231a.putNotification(new SyncMessageTask.SyncTask(0, notificationMsg, onWatchOpCallback));
    }

    public void queryExtFlashMsg(OnOperationCallback<ExternalFlashMsgResponse> onOperationCallback) {
        queryExtFlashMsgForDevice(this.mRcspOp, onOperationCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void registerOnWatchCallback(OnWatchCallback onWatchCallback) {
        this.mWatchCallbackManager.registerWatchCallback(onWatchCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void removeMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (!this.mRcspOp.isRcspInit()) {
            callbackError(onWatchOpCallback, 8192);
            return;
        }
        b();
        this.f18231a.putNotification(new SyncMessageTask.SyncTask(1, notificationMsg, onWatchOpCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void requestDeviceConfigure(final OnWatchOpCallback<WatchConfigure> onWatchOpCallback) {
        final BluetoothDevice connectedDevice = getConnectedDevice();
        if (this.mStatusManager.getDeviceConfigure(connectedDevice) == null) {
            this.mRcspOp.sendRcspCommand(connectedDevice, CommandBuilder.buildGetDevConfigureCmd(), new CustomRcspActionCallback("requestDeviceConfigure", new OnOperationCallback<GetDevConfigureCmd.Response>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.8
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    JL_Log.w(WatchBase.this.TAG, "requestDeviceConfigure", "onFailed. " + baseError);
                    OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                    if (onWatchOpCallback2 != null) {
                        onWatchOpCallback2.onFailed(baseError);
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(GetDevConfigureCmd.Response response) {
                    JL_Log.i(WatchBase.this.TAG, "requestDeviceConfigure", "onSuccess. " + response);
                    WatchBase.this.mStatusManager.updateDeviceConfigure(connectedDevice, response.getDeviceConfiguration());
                    OnWatchOpCallback onWatchOpCallback2 = onWatchOpCallback;
                    if (onWatchOpCallback2 != null) {
                        onWatchOpCallback2.onSuccess(WatchBase.this.getWatchConfigure(connectedDevice));
                    }
                }
            }, new IHandleResult<GetDevConfigureCmd.Response, GetDevConfigureCmd>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.9
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, GetDevConfigureCmd getDevConfigureCmd) {
                    return 0;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public GetDevConfigureCmd.Response handleResult(BluetoothDevice bluetoothDevice, GetDevConfigureCmd getDevConfigureCmd) {
                    if (getDevConfigureCmd == null || getDevConfigureCmd.getStatus() != 0) {
                        return null;
                    }
                    return (GetDevConfigureCmd.Response) getDevConfigureCmd.getResponse();
                }
            }));
        } else if (onWatchOpCallback != null) {
            onWatchOpCallback.onSuccess(getWatchConfigure(connectedDevice));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void requestDevicePower(OnWatchOpCallback<Boolean> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildGetPublicSysInfoCmd(1), new HandleRcspCallback("requestDevicePower", onWatchOpCallback, new RcspBooleanResult()));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public void sendWriteProtectFlag(final boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashWriteProtectCmd(z), new HandleRcspCallback("sendWriteProtectFlag", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<Boolean>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                JL_Log.i(WatchBase.this.TAG, "sendWriteProtectFlag", "send OK, writeFlag = " + z);
                WatchBase.this.setSysException(z ^ true);
                WatchBase.this.mWatchCallbackManager.onExternalFlashWriteFlag(bluetoothDevice, z);
                return Boolean.TRUE;
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void setCurrentWatchInfo(final String str, OnWatchOpCallback<FatFile> onWatchOpCallback) {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashSetWatchCmd(str), new HandleRcspCallback("setCurrentWatchInfo", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<FatFile>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public FatFile handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                FatFile watchFileByPath = WatchBase.this.getWatchFileByPath(str);
                if (watchFileByPath != null) {
                    WatchBase.this.mWatchCallbackManager.onCurrentWatchInfo(bluetoothDevice, watchFileByPath.getPath());
                }
                return watchFileByPath;
            }
        }));
    }

    public void setOTAResource(boolean z) {
        this.isOTAResource = z;
    }

    public void setSysException(boolean z) {
        this.isSysException = z;
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void syncWeatherInfo(PushInfoDataToDeviceCmd.Weather weather, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        if (weather == null) {
            if (onWatchOpCallback != null) {
                onWatchOpCallback.onFailed(new BaseError(4097, "Weather is null."));
            }
        } else {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new PushInfoDataToDeviceCmd(new PushInfoDataToDeviceCmd.Param(weather)), new HandleRcspCallback("syncWeatherInfo", onWatchOpCallback, new RcspBooleanResult()));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void unregisterOnWatchCallback(OnWatchCallback onWatchCallback) {
        this.mWatchCallbackManager.unregisterWatchCallback(onWatchCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchOp
    public void writeResourceOTAFlag(final boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback) {
        RcspOpImpl rcspOpImpl = this.mRcspOp;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildExternalFlashOTAResourceCmd(z), new HandleRcspCallback("writeResourceOTAFlag", onWatchOpCallback, new ExternalFlashIOCtrlHandleResult<Boolean>() { // from class: com.jieli.jl_rcsp.watch.WatchBase.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
                WatchBase.this.setOTAResource(!z);
                return Boolean.TRUE;
            }
        }));
    }

    public final void b() {
        if (this.f18231a == null) {
            SyncMessageTask syncMessageTask = new SyncMessageTask(this.mRcspOp, new ThreadStateListener() { // from class: com.jieli.jl_rcsp.watch.WatchBase.11
                @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                public void onFinish(long j) {
                    if (WatchBase.this.f18231a != null && WatchBase.this.f18231a.getId() == j) {
                        WatchBase.this.f18231a = null;
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                public void onStart(long j) {
                }
            });
            this.f18231a = syncMessageTask;
            syncMessageTask.start();
        }
    }

    public <T> void callbackError(OnWatchOpCallback<T> onWatchOpCallback, int i, String str) {
        if (onWatchOpCallback != null) {
            onWatchOpCallback.onFailed(new BaseError(i, str));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.IWatchManager
    public RcspOpImpl getRcspOp() {
        return this.mRcspOp;
    }

    public final void a() {
        SyncMessageTask syncMessageTask = this.f18231a;
        if (syncMessageTask != null) {
            syncMessageTask.exit();
        }
    }
}
