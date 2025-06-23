package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.interfaces.record.IRecordOp;
import com.jieli.jl_rcsp.interfaces.record.OnRecordStateCallback;
import com.jieli.jl_rcsp.model.RecordParam;
import com.jieli.jl_rcsp.model.RecordState;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.data.DataHasResponseCmd;
import com.jieli.jl_rcsp.model.command.speech.StartSpeechCmd;
import com.jieli.jl_rcsp.model.command.speech.StopSpeechCmd;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.model.parameter.StartSpeechParam;
import com.jieli.jl_rcsp.model.parameter.StopSpeechParam;
import com.jieli.jl_rcsp.model.response.StopSpeechResponse;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.RecordStateCallbackHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class RecordOpImpl implements IRecordOp {
    public final RcspOpImpl b;
    public final RecordState c;
    public final RecordStateCallbackHelper d;
    public final OnRcspCallback i;

    /* renamed from: a, reason: collision with root package name */
    public final String f17896a = RecordOpImpl.class.getSimpleName();
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public final RcspCommandCallback<CommandBase> h = new RcspCommandCallback<CommandBase>() { // from class: com.jieli.jl_rcsp.impl.RecordOpImpl.3
        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            if (baseError != null) {
                RecordOpImpl.this.a(bluetoothDevice, baseError.getSubCode(), baseError.getMessage());
            }
        }
    };

    public RecordOpImpl(RcspOpImpl rcspOpImpl) {
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.RecordOpImpl.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                boolean z;
                boolean z2;
                if (commandBase == null) {
                    return;
                }
                int id = commandBase.getId();
                if (id != 4) {
                    if (id == 5 && RecordOpImpl.this.a()) {
                        StopSpeechCmd stopSpeechCmd = (StopSpeechCmd) commandBase;
                        StopSpeechParam stopSpeechParam = (StopSpeechParam) stopSpeechCmd.getParam();
                        if (stopSpeechParam == null) {
                            return;
                        }
                        boolean z3 = true;
                        if (!stopSpeechParam.isPlayTTS() && !RecordOpImpl.this.g) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!stopSpeechParam.isSyncIatText() && !RecordOpImpl.this.e) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!stopSpeechParam.isSyncNlpText() && !RecordOpImpl.this.f) {
                            z3 = false;
                        }
                        RecordOpImpl.this.a(bluetoothDevice, stopSpeechParam.getReason(), z2, z3, z);
                        stopSpeechCmd.setParam(new StopSpeechCmd.ReplyParam(z2, z3, z));
                        stopSpeechCmd.setStatus(0);
                        RecordOpImpl.this.b.sendCommandResponse(bluetoothDevice, stopSpeechCmd, RecordOpImpl.this.h);
                        return;
                    }
                    return;
                }
                if (!RecordOpImpl.this.a()) {
                    StartSpeechCmd startSpeechCmd = (StartSpeechCmd) commandBase;
                    StartSpeechParam startSpeechParam = (StartSpeechParam) startSpeechCmd.getParam();
                    if (startSpeechParam != null) {
                        RecordOpImpl.this.a(bluetoothDevice, new RecordParam(startSpeechParam.getType(), startSpeechParam.getFreq(), startSpeechParam.getWay()));
                        startSpeechCmd.setParam(null);
                        startSpeechCmd.setStatus(0);
                        RecordOpImpl.this.b.sendCommandResponse(bluetoothDevice, startSpeechCmd, RecordOpImpl.this.h);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                DataParam dataParam;
                if (commandBase != null) {
                    boolean z = true;
                    if (commandBase.getId() == 1) {
                        if (commandBase.getType() != 2) {
                            z = false;
                        }
                        if (z) {
                            dataParam = (DataParam) ((DataHasResponseCmd) commandBase).getParam();
                        } else {
                            dataParam = (DataParam) ((DataCmd) commandBase).getParam();
                        }
                        if (dataParam != null && dataParam.getXmOpCode() == 4) {
                            RecordOpImpl.this.a(bluetoothDevice, dataParam.getData());
                            if (z) {
                                ((DataHasResponseCmd) commandBase).setParam(null);
                                commandBase.setStatus(0);
                                RecordOpImpl.this.b.sendCommandResponse(bluetoothDevice, commandBase, RecordOpImpl.this.h);
                            }
                        }
                    }
                }
            }
        };
        this.i = onRcspCallback;
        if (rcspOpImpl != null) {
            this.b = rcspOpImpl;
            this.c = new RecordState();
            this.d = new RecordStateCallbackHelper();
            rcspOpImpl.registerOnRcspCallback(onRcspCallback);
            return;
        }
        throw new NullPointerException("RcspOpImpl can not be null.");
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void addOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback) {
        this.d.addOnRecordStateCallback(onRecordStateCallback);
    }

    public BluetoothDevice getConnectedDevice() {
        return this.b.getConnectedDevice();
    }

    public RcspOpImpl getRcspOp() {
        return this.b;
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public RecordState getRecordState() {
        return this.c;
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void release() {
        stopRecord(this.b.getConnectedDevice(), 1, false, false, false, null);
        this.b.unregisterOnRcspCallback(this.i);
        this.d.release();
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void removeOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback) {
        this.d.removeOnRecordStateCallback(onRecordStateCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void setSupportPlayTTS(boolean z) {
        this.g = z;
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void setSupportSyncIatText(boolean z) {
        this.e = z;
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void setSupportSyncNlpText(boolean z) {
        this.f = z;
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void startRecord(final BluetoothDevice bluetoothDevice, RecordParam recordParam, final OnOperationCallback<Boolean> onOperationCallback) {
        if (recordParam == null) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4097, "startRecord : RecordParam is null."));
            }
        } else if (a()) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(12291, "startRecord : Recording"));
            }
        } else {
            a(bluetoothDevice, recordParam);
            this.b.sendRcspCommand(bluetoothDevice, new StartSpeechCmd(new StartSpeechParam(CHexConver.intToByte(recordParam.getVoiceType()), CHexConver.intToByte(recordParam.getSampleRate()), CHexConver.intToByte(recordParam.getVadWay()))), new BooleanRcspActionCallback("startRecord", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.RecordOpImpl.1
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    OnOperationCallback onOperationCallback2 = onOperationCallback;
                    if (onOperationCallback2 != null) {
                        onOperationCallback2.onFailed(baseError);
                    }
                    RecordOpImpl.this.a(bluetoothDevice, baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    OnOperationCallback onOperationCallback2 = onOperationCallback;
                    if (onOperationCallback2 != null) {
                        onOperationCallback2.onSuccess(bool);
                    }
                }
            }));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.record.IRecordOp
    public void stopRecord(BluetoothDevice bluetoothDevice, final int i, boolean z, boolean z2, boolean z3, final OnOperationCallback<Boolean> onOperationCallback) {
        if (!a()) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4097, "Recording is not started."));
                return;
            }
            return;
        }
        this.e = z;
        this.f = z2;
        this.g = z3;
        StopSpeechParam stopSpeechParam = new StopSpeechParam();
        stopSpeechParam.setReason(CHexConver.intToByte(i));
        stopSpeechParam.setSyncIatText(z);
        stopSpeechParam.setSyncNlpText(z2);
        stopSpeechParam.setPlayTTS(z3);
        this.b.sendRcspCommand(bluetoothDevice, new StopSpeechCmd(stopSpeechParam), new RcspCommandCallback<StopSpeechCmd>() { // from class: com.jieli.jl_rcsp.impl.RecordOpImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
                RecordOpImpl.this.a(bluetoothDevice2, baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, StopSpeechCmd stopSpeechCmd) {
                StopSpeechResponse stopSpeechResponse = (StopSpeechResponse) stopSpeechCmd.getResponse();
                if (stopSpeechResponse != null && stopSpeechCmd.getStatus() == 0) {
                    RecordOpImpl.this.a(bluetoothDevice2, i, stopSpeechResponse.isSyncIatText() || RecordOpImpl.this.e, stopSpeechResponse.isSyncNlpText() || RecordOpImpl.this.f, stopSpeechResponse.isPlayTTS() || RecordOpImpl.this.g);
                } else {
                    onErrCode(bluetoothDevice2, RcspErrorCode.buildJsonError(stopSpeechCmd.getId(), 12292, stopSpeechCmd.getStatus(), null));
                }
            }
        });
    }

    public final boolean a() {
        return this.c.getState() != 0;
    }

    public final void a(BluetoothDevice bluetoothDevice, RecordParam recordParam) {
        if (recordParam != null && !a()) {
            this.c.setState(1).setRecordParam(recordParam).setVoiceData(new byte[0]);
            this.d.onStateChange(bluetoothDevice, this.c);
            return;
        }
        JL_Log.w(this.f17896a, "cbRecordStart", "RecordParam is null or state error. " + this.c.getState());
    }

    public final void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && a()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                if (this.c.getVoiceData() != null && this.c.getVoiceData().length > 0) {
                    byteArrayOutputStream.write(this.c.getVoiceData());
                }
                byteArrayOutputStream.write(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.c.setState(2).setVoiceDataBlock(bArr).setVoiceData(byteArrayOutputStream.toByteArray());
            this.d.onStateChange(bluetoothDevice, this.c);
            return;
        }
        JL_Log.w(this.f17896a, "cbRecordWorking", "data is null or state error. " + this.c.getState());
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, boolean z, boolean z2, boolean z3) {
        if (!a()) {
            JL_Log.w(this.f17896a, "cbRecordStop", "state error. " + this.c.getState() + ", reason = " + i);
            return;
        }
        this.c.setState(0).setVoiceDataBlock(new byte[0]).setSyncIatText(z).setSyncNlpText(z2).setPlayTTS(z3).setReason(i);
        this.d.onStateChange(bluetoothDevice, this.c);
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, String str) {
        if (!a()) {
            JL_Log.w(this.f17896a, "cbRecordError", "state error. " + this.c.getState() + ", code = " + i + ", explain = " + str);
            return;
        }
        this.c.setState(0).setVoiceDataBlock(new byte[0]).setVoiceData(new byte[0]).setReason(i).setMessage(str);
        this.d.onStateChange(bluetoothDevice, this.c);
    }
}
