package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.data.IDataTransferOp;
import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;
import com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataTransferCmd;
import com.jieli.jl_rcsp.model.data.DataParams;
import com.jieli.jl_rcsp.model.data.ReadDataCache;
import com.jieli.jl_rcsp.model.data.ReadParams;
import com.jieli.jl_rcsp.model.data.SendDataCache;
import com.jieli.jl_rcsp.model.data.SendParams;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class DataTransferOpImpl implements IDataTransferOp {
    public static int WAITING_FOR_DATA_TIMEOUT = 20000;
    public static final String h = "DataTransferOpImpl";
    public static volatile DataTransferOpImpl i = null;
    public static final int j = 5237;

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f17836a;
    public final DeviceStatusManager b;
    public final CallbackManager c;
    public volatile SendDataCache d;
    public volatile ReadDataCache e;
    public final Handler f;
    public final OnRcspCallback g;

    /* loaded from: classes8.dex */
    public static class CallbackManager extends BaseCallbackManager<OnDataTransferListener> implements OnDataTransferListener {
        public CallbackManager(Handler handler) {
            super(handler);
        }

        @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
        public void onError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.II0xO0
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnDataTransferListener) obj).onError(bluetoothDevice, baseError);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
        public void onReceiveData(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.I0Io
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnDataTransferListener) obj).onReceiveData(bluetoothDevice, i, bArr);
                }
            });
        }
    }

    public DataTransferOpImpl(RcspOpImpl rcspOpImpl) {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.impl.oIX0oI
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = DataTransferOpImpl.this.a(message);
                return a2;
            }
        });
        this.f = handler;
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.7
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i2) {
                if (i2 != 1) {
                    BaseError baseError = new BaseError(8192, "Device is not connected.");
                    DataTransferOpImpl.this.a(baseError);
                    DataTransferOpImpl.this.a(bluetoothDevice, baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (commandBase != null && commandBase.getId() == 48) {
                    DataTransferCmd dataTransferCmd = (DataTransferCmd) commandBase;
                    JL_Log.d(DataTransferOpImpl.h, "onRcspCommand", "" + dataTransferCmd);
                    if (dataTransferCmd.getParam() instanceof DataTransferCmd.SendDataParam) {
                        DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.SendDataParam) dataTransferCmd.getParam());
                    } else if (dataTransferCmd.getParam() instanceof DataTransferCmd.ReadDataParam) {
                        DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.DataTransferParam) dataTransferCmd.getParam());
                    } else if (dataTransferCmd.getParam() instanceof DataTransferCmd.DataTransferParam) {
                        DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.DataTransferParam) dataTransferCmd.getParam());
                    }
                }
            }
        };
        this.g = onRcspCallback;
        if (rcspOpImpl != null) {
            this.f17836a = rcspOpImpl;
            this.b = DeviceStatusManager.getInstance();
            this.c = new CallbackManager(handler);
            rcspOpImpl.registerOnRcspCallback(onRcspCallback);
            return;
        }
        throw new NullPointerException("RcspOpImpl can not be null.");
    }

    public static DataTransferOpImpl instance(RcspOpImpl rcspOpImpl) {
        if (i == null) {
            synchronized (DataTransferOpImpl.class) {
                try {
                    if (i == null) {
                        i = new DataTransferOpImpl(rcspOpImpl);
                    }
                } finally {
                }
            }
        }
        return i;
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void addListener(OnDataTransferListener onDataTransferListener) {
        this.c.registerCallback(onDataTransferListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void cancelDataTransfer(OnOperationCallback<Boolean> onOperationCallback) {
        if (onOperationCallback != null) {
            onOperationCallback.onSuccess(Boolean.FALSE);
        }
    }

    public void destroy() {
        this.f.removeMessages(j);
        this.f.removeCallbacksAndMessages(null);
        this.f17836a.unregisterOnRcspCallback(this.g);
        a(new BaseError(4098, "Cancel send data task."));
        this.c.release();
        i = null;
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public boolean isDataTransfer() {
        return this.b.isDataTransfer(b());
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void readLargeData(DataParams dataParams, final OnDataEventCallback onDataEventCallback) {
        if (dataParams == null) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4097, "ReadParams can not be null."));
            }
        } else if (!isDataTransfer() && !d() && !c()) {
            DataTransferCmd.ReadDataParam readDataParam = new DataTransferCmd.ReadDataParam(dataParams.getDataType(), dataParams.getVersion(), dataParams.getSendLimit(), dataParams.getReceiveLimit());
            final BluetoothDevice connectedDevice = this.f17836a.getConnectedDevice();
            a(readDataParam, new OnOperationCallback<DataTransferCmd.ReadDataResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    OnDataEventCallback onDataEventCallback2 = onDataEventCallback;
                    if (onDataEventCallback2 != null) {
                        onDataEventCallback2.onError(baseError);
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(DataTransferCmd.ReadDataResponse readDataResponse) {
                    if (readDataResponse.getResult() == 0) {
                        int maxReceiveMtu = DeviceStatusManager.getInstance().getMaxReceiveMtu(DataTransferOpImpl.this.f17836a.getConnectedDevice());
                        if (readDataResponse.getSendDataLimit() >= maxReceiveMtu) {
                            onFailed(new BaseError(4097, RcspUtil.formatString("Data sending limit exceeded the protocol MTU[%d] range.", Integer.valueOf(maxReceiveMtu))));
                            return;
                        }
                        DataTransferOpImpl.this.e = new ReadDataCache(new ReadParams(readDataResponse.getType(), readDataResponse.getVersion(), readDataResponse.getSendDataLimit(), readDataResponse.getReceiveDataLimit(), readDataResponse.getDataLen(), readDataResponse.getCrc()));
                        DataTransferOpImpl.this.e.setCallback(onDataEventCallback);
                        DataTransferOpImpl.this.b.updateDataTransfer(DataTransferOpImpl.this.b(), true);
                        if (DataTransferOpImpl.this.e.getCallback() != null) {
                            DataTransferOpImpl.this.e.getCallback().onBegin(0);
                        }
                        DataTransferOpImpl.this.f.sendMessageDelayed(DataTransferOpImpl.this.f.obtainMessage(DataTransferOpImpl.j, connectedDevice), DataTransferOpImpl.WAITING_FOR_DATA_TIMEOUT);
                        return;
                    }
                    onFailed(RcspErrorCode.buildJsonError(48, 12293, readDataResponse.getResult(), null));
                }
            });
        } else if (onDataEventCallback != null) {
            onDataEventCallback.onError(new BaseError(4352, "Data task is in progress."));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void removeListener(OnDataTransferListener onDataTransferListener) {
        this.c.unregisterCallback(onDataTransferListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void sendLargeData(SendParams sendParams, OnDataEventCallback onDataEventCallback) {
        if (sendParams == null) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4097, "SendDataParam can not be null."));
            }
        } else if (!isDataTransfer() && !d()) {
            this.d = new SendDataCache(sendParams, onDataEventCallback);
            this.b.updateDataTransfer(b(), true);
            a(new DataTransferCmd.SendDataParam(sendParams.getDataType(), sendParams.getVersion(), sendParams.getDataLen(), sendParams.getDataCrc(), sendParams.getSendLimit(), sendParams.getReceiveLimit()), new OnOperationCallback<DataTransferCmd.SendDataResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.1
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    DataTransferOpImpl.this.a(baseError);
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(DataTransferCmd.SendDataResponse sendDataResponse) {
                    if (sendDataResponse.getResult() != 0) {
                        onFailed(RcspErrorCode.buildJsonError(48, 12293, sendDataResponse.getResult(), null));
                        return;
                    }
                    if (DataTransferOpImpl.this.isDataTransfer() && DataTransferOpImpl.this.d()) {
                        int maxReceiveMtu = DeviceStatusManager.getInstance().getMaxReceiveMtu(DataTransferOpImpl.this.f17836a.getConnectedDevice());
                        if (sendDataResponse.getReceiveDataLimit() < maxReceiveMtu) {
                            DataTransferOpImpl.this.d.setSendLimit(sendDataResponse.getSendDataLimit());
                            DataTransferOpImpl.this.d.setReceiveLimit(sendDataResponse.getReceiveDataLimit());
                            DataTransferOpImpl.this.d.setOffset(0);
                            DataTransferOpImpl.this.d.setSeq(-1);
                            if (DataTransferOpImpl.this.d.getCallback() != null) {
                                DataTransferOpImpl.this.d.getCallback().onBegin(1);
                            }
                            DataTransferOpImpl dataTransferOpImpl = DataTransferOpImpl.this;
                            dataTransferOpImpl.a(dataTransferOpImpl.d);
                            return;
                        }
                        onFailed(new BaseError(4097, RcspUtil.formatString("Data Receiving limit exceeded the protocol MTU[%d] range.", Integer.valueOf(maxReceiveMtu))));
                    }
                }
            });
        } else if (onDataEventCallback != null) {
            onDataEventCallback.onError(new BaseError(4352, WatchError.getErrorDesc(4352)));
        }
    }

    public final boolean c() {
        return this.e != null;
    }

    public final boolean d() {
        return this.d != null;
    }

    public final BluetoothDevice b() {
        return this.f17836a.getConnectedDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message == null) {
            return false;
        }
        if (5237 != message.what) {
            return true;
        }
        Object obj = message.obj;
        if (!(obj instanceof BluetoothDevice)) {
            return true;
        }
        a((BluetoothDevice) obj, new BaseError(12290, "Waiting for data timeout."));
        return true;
    }

    public final void a(BaseError baseError) {
        if (baseError != null && d()) {
            OnDataEventCallback callback = this.d.getCallback();
            this.d.release();
            this.d = null;
            this.b.updateDataTransfer(b(), false);
            JL_Log.w(h, "onSendError", "device : " + b() + ", " + baseError);
            if (callback != null) {
                callback.onError(baseError);
            }
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, BaseError baseError) {
        if (baseError != null && c()) {
            OnDataEventCallback callback = this.e.getCallback();
            this.f.removeMessages(j);
            this.e.release();
            this.e = null;
            this.b.updateDataTransfer(b(), false);
            JL_Log.w(h, "onReadError", "device : " + bluetoothDevice + ", " + baseError);
            if (callback != null) {
                callback.onError(baseError);
            }
            this.c.onError(bluetoothDevice, baseError);
        }
    }

    public final void a(SendDataCache sendDataCache) {
        if (sendDataCache == null || !isDataTransfer()) {
            return;
        }
        int receiveLimit = sendDataCache.getReceiveLimit();
        boolean z = sendDataCache.getOffset() + receiveLimit >= sendDataCache.getDataLen();
        int min = Math.min(sendDataCache.getDataLen() - sendDataCache.getOffset(), receiveLimit);
        byte[] bArr = new byte[min];
        System.arraycopy(sendDataCache.getData(), sendDataCache.getOffset(), bArr, 0, min);
        short CRC16 = CryptoUtil.CRC16(bArr, (short) 0);
        sendDataCache.setSeq(sendDataCache.getSeq() + 1);
        DataTransferCmd.DataTransferParam dataTransferParam = new DataTransferCmd.DataTransferParam(sendDataCache.getDataType(), z, sendDataCache.getSeq(), CRC16, sendDataCache.getOffset(), bArr);
        sendDataCache.setOffset(sendDataCache.getOffset() + min);
        a(dataTransferParam, new OnOperationCallback<DataTransferCmd.DataTransferResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.3
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                DataTransferOpImpl.this.a(baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(DataTransferCmd.DataTransferResponse dataTransferResponse) {
                String str;
                if (dataTransferResponse.getResult() != 0) {
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (dataTransferResponse.getMessage() != null && dataTransferResponse.getMessage().length > 0) {
                        str = new String(dataTransferResponse.getMessage());
                        onFailed(RcspErrorCode.buildJsonError(48, 12293, dataTransferResponse.getResult(), str));
                        return;
                    }
                    str = "";
                    onFailed(RcspErrorCode.buildJsonError(48, 12293, dataTransferResponse.getResult(), str));
                    return;
                }
                if (DataTransferOpImpl.this.isDataTransfer() && DataTransferOpImpl.this.d()) {
                    if (dataTransferResponse.isEnd()) {
                        OnDataEventCallback callback = DataTransferOpImpl.this.d.getCallback();
                        int dataType = DataTransferOpImpl.this.d.getDataType();
                        byte[] data = DataTransferOpImpl.this.d.getData();
                        DataTransferOpImpl.this.d.release();
                        DataTransferOpImpl.this.d = null;
                        DataTransferOpImpl.this.b.updateDataTransfer(DataTransferOpImpl.this.b(), false);
                        if (callback != null) {
                            callback.onProgress(100.0f);
                            callback.onStop(dataType, data);
                            return;
                        }
                        return;
                    }
                    if (DataTransferOpImpl.this.d.getDataLen() > 0) {
                        float offset = (DataTransferOpImpl.this.d.getOffset() * 100.0f) / DataTransferOpImpl.this.d.getDataLen();
                        if (DataTransferOpImpl.this.d.getCallback() != null) {
                            DataTransferOpImpl.this.d.getCallback().onProgress(offset);
                        }
                    }
                    DataTransferOpImpl dataTransferOpImpl = DataTransferOpImpl.this;
                    dataTransferOpImpl.a(dataTransferOpImpl.d);
                }
            }
        });
    }

    public final void a(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd, DataTransferCmd.SendDataParam sendDataParam) {
        if (dataTransferCmd == null || sendDataParam == null) {
            return;
        }
        if (c()) {
            dataTransferCmd.setParam(null);
            dataTransferCmd.setStatus(3);
            this.f17836a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
            return;
        }
        String str = h;
        JL_Log.d(str, "handleDataParam", "" + sendDataParam);
        DataTransferCmd.SendDataResponse sendDataResponse = new DataTransferCmd.SendDataResponse(sendDataParam.getWay(), sendDataParam.getType(), sendDataParam.getVersion(), 0, sendDataParam.getSendDataLimit(), sendDataParam.getReceiveDataLimit());
        JL_Log.d(str, "handleDataParam", sendDataResponse + "\n data = " + CHexConver.byte2HexStr(sendDataResponse.getParamData()));
        dataTransferCmd.setParam(new DataTransferCmd.CustomReplyParam(sendDataResponse.getParamData()));
        dataTransferCmd.setStatus(0);
        this.f17836a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
        this.e = new ReadDataCache(new ReadParams(sendDataParam.getType(), sendDataParam.getVersion(), sendDataParam.getSendDataLimit(), sendDataParam.getReceiveDataLimit(), sendDataParam.getDataLen(), sendDataParam.getCrc()));
        this.b.updateDataTransfer(b(), true);
        Handler handler = this.f;
        handler.sendMessageDelayed(handler.obtainMessage(j, bluetoothDevice), WAITING_FOR_DATA_TIMEOUT);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0136, code lost:
    
        if (r10 != r23.e.getCrc()) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.bluetooth.BluetoothDevice r24, com.jieli.jl_rcsp.model.command.data.DataTransferCmd r25, com.jieli.jl_rcsp.model.command.data.DataTransferCmd.DataTransferParam r26) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.impl.DataTransferOpImpl.a(android.bluetooth.BluetoothDevice, com.jieli.jl_rcsp.model.command.data.DataTransferCmd, com.jieli.jl_rcsp.model.command.data.DataTransferCmd$DataTransferParam):void");
    }

    public final void a(DataTransferCmd.SendDataParam sendDataParam, OnOperationCallback<DataTransferCmd.SendDataResponse> onOperationCallback) {
        if (sendDataParam != null) {
            this.f17836a.sendRcspCommand(b(), new DataTransferCmd(sendDataParam), new CustomRcspActionCallback("sendDataParam", onOperationCallback, new IHandleResult<DataTransferCmd.SendDataResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.4
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.SendDataResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.SendDataResponse)) {
                        return (DataTransferCmd.SendDataResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "SendDataParam can not be null."));
        }
    }

    public final void a(DataTransferCmd.ReadDataParam readDataParam, OnOperationCallback<DataTransferCmd.ReadDataResponse> onOperationCallback) {
        if (readDataParam != null) {
            this.f17836a.sendRcspCommand(b(), new DataTransferCmd(readDataParam), new CustomRcspActionCallback("readDataParam", onOperationCallback, new IHandleResult<DataTransferCmd.ReadDataResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.5
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.ReadDataResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.ReadDataResponse)) {
                        return (DataTransferCmd.ReadDataResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "ReadDataParam can not be null."));
        }
    }

    public final void a(DataTransferCmd.DataTransferParam dataTransferParam, OnOperationCallback<DataTransferCmd.DataTransferResponse> onOperationCallback) {
        if (dataTransferParam != null) {
            this.f17836a.sendRcspCommand(b(), new DataTransferCmd(dataTransferParam), new CustomRcspActionCallback("sendDataBlock", onOperationCallback, new IHandleResult<DataTransferCmd.DataTransferResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.6
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.DataTransferResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.DataTransferResponse)) {
                        return (DataTransferCmd.DataTransferResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "DataTransferParam can not be null."));
        }
    }

    public final void a(int i2, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17836a.sendRcspCommand(b(), new DataTransferCmd(new DataTransferCmd.CancelTransferParam(i2)), new BooleanRcspActionCallback("cancelTransfer", onOperationCallback));
    }

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "Successful.";
            case 1:
                return "CRC error.";
            case 2:
                return "Sequence error.";
            case 3:
                return "Data type is not supported.";
            case 4:
                return "Transfer way is not supported.";
            case 5:
                return "Data length is out of bounds.";
            case 6:
                return "Read/write Data Exception.";
            case 7:
                return "Missing parameter configuration.";
            default:
                return "";
        }
    }
}
