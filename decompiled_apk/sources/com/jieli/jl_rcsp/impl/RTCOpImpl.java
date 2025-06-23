package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.login.widget.ToolTipPopup;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.alarm.IRTCOp;
import com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.AlarmExpandCmd;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AuditionParam;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes8.dex */
public class RTCOpImpl implements IRTCOp {
    public static final int WAY_NOTIFY = 1;
    public static final int WAY_REPLY = 0;
    public static final String f = "RTCOpImpl";
    public static final int g = 6000;
    public static final int h = 41216;

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f17887a;
    public final DataTransferOpImpl b;
    public OnOperationCallback<Boolean> c;
    public final Handler d = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.impl.OOXIXo
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean a2;
            a2 = RTCOpImpl.this.a(message);
            return a2;
        }
    });
    public final OnDataTransferListener e;

    /* loaded from: classes8.dex */
    public static class BigRTCData {

        /* renamed from: a, reason: collision with root package name */
        public int f17890a;
        public int b;
        public byte[] c;

        public BigRTCData(byte[] bArr) {
            a(bArr);
        }

        public void a(byte[] bArr) {
            int byteToInt = CHexConver.byteToInt(bArr[0]);
            this.f17890a = byteToInt;
            if (byteToInt == 0) {
                this.b = CHexConver.byteToInt(bArr[1]);
                int min = Math.min(CHexConver.bytesToInt(bArr, 2, 2), bArr.length - 4);
                byte[] bArr2 = new byte[min];
                this.c = bArr2;
                System.arraycopy(bArr, 4, bArr2, 0, min);
            }
        }

        public String toString() {
            int length;
            StringBuilder sb = new StringBuilder();
            sb.append("BigRTCData{version=");
            sb.append(this.f17890a);
            sb.append(", way=");
            sb.append(this.b);
            sb.append(", len=");
            byte[] bArr = this.c;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb.append(length);
            sb.append(", payload=");
            sb.append(CHexConver.byte2HexStr(this.c));
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    public class ReadAlarmRcspCallback implements RcspCommandCallback<CommandBase> {

        /* renamed from: a, reason: collision with root package name */
        public final OnOperationCallback<Boolean> f17891a;

        public ReadAlarmRcspCallback(OnOperationCallback<Boolean> onOperationCallback) {
            this.f17891a = onOperationCallback;
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
            if (commandBase.getStatus() != 0) {
                if (commandBase.getStatus() == 8) {
                    JL_Log.w(RTCOpImpl.f, "STATUS_RESPONSE_DATA_OVER_LIMIT", "start .... MSG_WAIT_ALARM_DATA >> ");
                    RTCOpImpl.this.c = this.f17891a;
                    RTCOpImpl.this.d.removeMessages(RTCOpImpl.h);
                    RTCOpImpl.this.d.sendEmptyMessageDelayed(RTCOpImpl.h, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                    return;
                }
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(commandBase.getId(), 12292, commandBase.getStatus(), null));
                return;
            }
            OnOperationCallback<Boolean> onOperationCallback = this.f17891a;
            if (onOperationCallback != null) {
                onOperationCallback.onSuccess(Boolean.TRUE);
            }
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            OnOperationCallback<Boolean> onOperationCallback = this.f17891a;
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
            }
        }
    }

    public RTCOpImpl(RcspOpImpl rcspOpImpl) {
        OnDataTransferListener onDataTransferListener = new OnDataTransferListener() { // from class: com.jieli.jl_rcsp.impl.RTCOpImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onError(BluetoothDevice bluetoothDevice, BaseError baseError) {
            }

            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onReceiveData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (i == 2) {
                    BigRTCData bigRTCData = new BigRTCData(bArr);
                    if (RTCOpImpl.this.b() && bigRTCData.b == 0) {
                        if (RTCOpImpl.this.c != null) {
                            RTCOpImpl.this.c.onSuccess(Boolean.TRUE);
                            RTCOpImpl.this.c = null;
                        }
                        RTCOpImpl.this.d.removeMessages(RTCOpImpl.h);
                    }
                }
            }
        };
        this.e = onDataTransferListener;
        if (rcspOpImpl != null) {
            this.f17887a = rcspOpImpl;
            DataTransferOpImpl instance = DataTransferOpImpl.instance(rcspOpImpl);
            this.b = instance;
            instance.addListener(onDataTransferListener);
            return;
        }
        throw new NullPointerException("WatchOpImpl can not be null.");
    }

    public static void parseRTCBigData(RcspOpImpl rcspOpImpl, RcspEventListenerManager rcspEventListenerManager, byte[] bArr) {
        if (rcspOpImpl == null) {
            return;
        }
        BigRTCData bigRTCData = new BigRTCData(bArr);
        if (bigRTCData.f17890a == 0) {
            a(rcspOpImpl, rcspEventListenerManager, bigRTCData.c);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void addOrModifyAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback) {
        if (alarmBean == null) {
            BaseError baseError = new BaseError(4097, "AlarmBean is null.");
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetAlarmCmd(AlarmBean.toAttrbean(alarmBean, false)), new BooleanRcspActionCallback("addOrModifyAlarm", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void auditionAlarmBell(BluetoothDevice bluetoothDevice, AuditionParam auditionParam, OnOperationCallback<Boolean> onOperationCallback) {
        if (auditionParam == null) {
            BaseError baseError = new BaseError(4097, "AlarmExpandCmd.BellArg is null.");
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildAuditionAlarmBellCmd(auditionParam.getType(), auditionParam.getDev(), auditionParam.getCluster()), new BooleanRcspActionCallback("auditionAlarmBell", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void deleteAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback) {
        if (alarmBean == null) {
            BaseError baseError = new BaseError(4097, "AlarmBean is null.");
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildDelAlarmCmd(AlarmBean.toAttrbean(alarmBean, true)), new BooleanRcspActionCallback("deleteAlarm", onOperationCallback));
    }

    public void destroy() {
        this.d.removeCallbacksAndMessages(null);
        this.b.removeListener(this.e);
    }

    public BluetoothDevice getConnectedDevice() {
        return this.f17887a.getConnectedDevice();
    }

    public RcspOpImpl getRcspOp() {
        return this.f17887a;
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmBellArgs(BluetoothDevice bluetoothDevice, byte b, OnOperationCallback<List<AlarmExpandCmd.BellArg>> onOperationCallback) {
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildReadBellArgsCmd(b), new CustomRcspActionCallback("readAlarmBellArgs", onOperationCallback, new IHandleResult<List<AlarmExpandCmd.BellArg>, AlarmExpandCmd>() { // from class: com.jieli.jl_rcsp.impl.RTCOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, AlarmExpandCmd alarmExpandCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public List<AlarmExpandCmd.BellArg> handleResult(BluetoothDevice bluetoothDevice2, AlarmExpandCmd alarmExpandCmd) {
                AlarmExpandCmd.Response response = (AlarmExpandCmd.Response) alarmExpandCmd.getResponse();
                if (response != null && (response instanceof AlarmExpandCmd.ReadRtcBellArgsResponse)) {
                    return ((AlarmExpandCmd.ReadRtcBellArgsResponse) response).getBellArg();
                }
                return null;
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmDefaultBellList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        if (b()) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4352, "Reading alarm data is in progress."));
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetDefaultAlarmBellsCmd(), new ReadAlarmRcspCallback(onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        if (b()) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4352, "Reading alarm data is in progress."));
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetAlarmCmd(), new ReadAlarmRcspCallback(onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void setAlarmBellArg(BluetoothDevice bluetoothDevice, AlarmExpandCmd.BellArg bellArg, OnOperationCallback<Boolean> onOperationCallback) {
        if (bellArg == null) {
            BaseError baseError = new BaseError(4097, "AlarmExpandCmd.BellArg is null.");
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
                return;
            }
            return;
        }
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetBellArgsCmd(bellArg), new BooleanRcspActionCallback("setAlarmBellArg", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void stopAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildStopAlarmCmd(), new BooleanRcspActionCallback("stopAlarmBell", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void stopPlayAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildStopAuditionAlarmBellCmd(), new BooleanRcspActionCallback("stopPlayAlarmBell", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void syncTime(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17887a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncTimeCmd(Calendar.getInstance()), new BooleanRcspActionCallback("syncTime", onOperationCallback));
    }

    public final boolean b() {
        return this.d.hasMessages(h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 41216) {
            return true;
        }
        JL_Log.w(f, "MSG_WAIT_ALARM_DATA", "");
        OnOperationCallback<Boolean> onOperationCallback = this.c;
        if (onOperationCallback == null) {
            return true;
        }
        onOperationCallback.onFailed(new BaseError(12290, "The device replies to the alarm clock data timeout."));
        this.c = null;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.jieli.jl_rcsp.impl.RcspOpImpl r24, com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager r25, byte[] r26) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.impl.RTCOpImpl.a(com.jieli.jl_rcsp.impl.RcspOpImpl, com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager, byte[]):void");
    }

    public static int a(List<LtvBean> list) {
        for (LtvBean ltvBean : list) {
            if (ltvBean.getType() == 4) {
                return ltvBean.getData()[0] & 7;
            }
        }
        return 0;
    }
}
