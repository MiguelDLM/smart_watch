package com.jieli.jl_rcsp.tool.datahandles;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class DataHandlerModify implements DataHandler {
    public final IBluetoothProxy c;
    public final BasePacketParse d;
    public final HandlerThread f;
    public final Handler g;
    public final Handler h;

    /* renamed from: a, reason: collision with root package name */
    public final String f18163a = DataHandlerModify.class.getSimpleName();
    public final DeviceStatusManager b = DeviceStatusManager.getInstance();
    public final DataInfoCache e = new DataInfoCache();

    /* loaded from: classes10.dex */
    public class TimeOutCheck implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final DataInfo f18164a;

        public TimeOutCheck(DataInfo dataInfo) {
            this.f18164a = dataInfo;
            dataInfo.setSendTime(System.currentTimeMillis());
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePacket basePacket;
            DataInfo dataInfo = this.f18164a;
            if (dataInfo == null || (basePacket = dataInfo.getBasePacket()) == null) {
                return;
            }
            BluetoothDevice device = this.f18164a.getDevice();
            int opCode = basePacket.getOpCode();
            int opCodeSn = basePacket.getOpCodeSn();
            int reSendCount = this.f18164a.getReSendCount();
            JL_Log.w(DataHandlerModify.this.f18163a, "TimeOutCheck", RcspUtil.formatString("Waiting for reply command timeout.\ndevice : %s, op : %d(0x%X), sn : %d, reSendCount : %d.", device, Integer.valueOf(opCode), Integer.valueOf(opCode), Integer.valueOf(opCodeSn), Integer.valueOf(reSendCount)));
            if (reSendCount < 3) {
                this.f18164a.setReSendCount(reSendCount + 1);
                DataHandlerModify.this.e.remove(this.f18164a);
                DataHandlerModify.this.addSendData(this.f18164a);
            } else {
                DataHandlerModify.this.e.remove(this.f18164a);
                CommandHelper.getInstance().removeCommandBase(device, basePacket);
                DataHandlerModify.this.a(this.f18164a, new BaseError(12290));
            }
        }
    }

    public DataHandlerModify(IBluetoothProxy iBluetoothProxy) {
        HandlerThread handlerThread = new HandlerThread("DataHandlerModify");
        this.f = handlerThread;
        this.h = new Handler(Looper.getMainLooper());
        if (iBluetoothProxy != null) {
            this.c = iBluetoothProxy;
            this.d = new BasePacketParse();
            handlerThread.start();
            this.g = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.tool.datahandles.II0xO0
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return DataHandlerModify.a(message);
                }
            });
            return;
        }
        throw new NullPointerException("IBluetoothProxy can not be null.");
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addRecvData(final DataInfo dataInfo) {
        this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerModify.this.a(dataInfo);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addSendData(final DataInfo dataInfo) {
        dataInfo.setSendTime(a());
        this.g.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerModify.this.b(dataInfo);
            }
        });
    }

    public final boolean c(DataInfo dataInfo) {
        byte[] packSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
        if (packSendBasePacket == null) {
            JL_Log.i(this.f18163a, "sendData", "Packing data failed.");
            return false;
        }
        int a2 = a(dataInfo.getDevice());
        if (packSendBasePacket.length > a2) {
            JL_Log.e(this.f18163a, "sendData", "The length of the sent data exceeds the limit[" + a2 + "].");
            return false;
        }
        boolean z = false;
        for (int i = 0; i < 3 && !(z = this.c.sendDataToDevice(dataInfo.getDevice(), packSendBasePacket)); i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JL_Log.d(this.f18163a, "sendData", RcspUtil.formatString("result : %s, data : [%s]", Boolean.valueOf(z), CHexConver.byte2HexStr(packSendBasePacket)));
        return z;
    }

    public final int d(DataInfo dataInfo) {
        if (dataInfo == null) {
            return Integer.MAX_VALUE;
        }
        return dataInfo.getBasePacket().getOpCode() | (dataInfo.getBasePacket().getOpCodeSn() << 16);
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void release() {
        JL_Log.i(this.f18163a, "release", "=====>>>");
        this.g.removeCallbacksAndMessages(null);
        this.d.release();
        CommandHelper.getInstance().release();
        if (!this.e.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                DataInfo dataInfo = (DataInfo) it.next();
                RcspCommandCallback rcspCmdCallback = dataInfo.getRcspCmdCallback();
                if (rcspCmdCallback != null) {
                    rcspCmdCallback.onErrCode(dataInfo.getDevice(), new BaseError(8192));
                }
            }
        }
        this.f.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DataInfo dataInfo) {
        if (!c(dataInfo)) {
            a(dataInfo, new BaseError(12288));
            return;
        }
        if (dataInfo.getBasePacket().getHasResponse() == 1) {
            this.e.add(dataInfo);
            Handler handler = this.g;
            handler.sendMessageDelayed(handler.obtainMessage(d(dataInfo), new TimeOutCheck(dataInfo)), dataInfo.getTimeoutMs());
            return;
        }
        BasePacket basePacket = dataInfo.getBasePacket();
        int opCodeSn = basePacket.getOpCodeSn();
        basePacket.setOpCodeSn(256);
        CommandBase convert2Command = ParseHelper.convert2Command(dataInfo.getDevice(), basePacket);
        if (convert2Command != null) {
            convert2Command.setOpCodeSn(opCodeSn);
        }
        a(dataInfo, convert2Command);
    }

    public static /* synthetic */ boolean a(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DataInfo dataInfo) {
        ArrayList<BasePacket> findPacketData = this.d.findPacketData(b(dataInfo.getDevice()), dataInfo.getRecvData());
        if (findPacketData != null && !findPacketData.isEmpty()) {
            Iterator<BasePacket> it = findPacketData.iterator();
            while (it.hasNext()) {
                BasePacket next = it.next();
                if (next.getType() == 1) {
                    this.c.receiveDataFromDevice(dataInfo.getDevice(), next);
                } else {
                    DataInfo dataInfo2 = this.e.getDataInfo(next);
                    if (dataInfo2 == null) {
                        JL_Log.w(this.f18163a, "addRecvData", "No cached command found. " + next);
                    } else {
                        CommandBase convert2Command = ParseHelper.convert2Command(dataInfo2.getDevice(), next);
                        if (convert2Command == null) {
                            a(dataInfo2, new BaseError(12289));
                        } else {
                            this.c.receiveDataFromDevice(dataInfo.getDevice(), next);
                        }
                        this.e.remove(dataInfo2);
                        this.g.removeMessages(d(dataInfo2));
                        a(dataInfo2, convert2Command);
                        CommandHelper.getInstance().removeCommandBase(dataInfo2.getDevice(), next);
                    }
                }
            }
            return;
        }
        JL_Log.w(this.f18163a, "addRecvData", "Not found command.");
    }

    public final int b(BluetoothDevice bluetoothDevice) {
        return this.b.getMaxReceiveMtu(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DataInfo dataInfo, BaseError baseError) {
        JL_Log.w(this.f18163a, "callError", "device : " + dataInfo.getDevice() + ", " + baseError);
        dataInfo.getRcspCmdCallback().onErrCode(dataInfo.getDevice(), baseError);
        this.c.callbackErrorEvent(baseError);
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final int a(BluetoothDevice bluetoothDevice) {
        return this.b.getMaxCommunicationMtu(bluetoothDevice);
    }

    public final void a(final DataInfo dataInfo, final BaseError baseError) {
        if (dataInfo == null || dataInfo.getRcspCmdCallback() == null || baseError == null) {
            return;
        }
        if (dataInfo.getBasePacket() != null) {
            baseError.setOpCode(dataInfo.getBasePacket().getOpCode());
        }
        this.h.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerModify.this.b(dataInfo, baseError);
            }
        });
    }

    public final void a(final DataInfo dataInfo, final CommandBase commandBase) {
        if (dataInfo == null || dataInfo.getRcspCmdCallback() == null || commandBase == null) {
            return;
        }
        final RcspCommandCallback rcspCmdCallback = dataInfo.getRcspCmdCallback();
        this.h.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerModify.a(RcspCommandCallback.this, dataInfo, commandBase);
            }
        });
    }

    public static /* synthetic */ void a(RcspCommandCallback rcspCommandCallback, DataInfo dataInfo, CommandBase commandBase) {
        if (rcspCommandCallback != null) {
            rcspCommandCallback.onCommandResponse(dataInfo.getDevice(), commandBase);
        }
    }
}
