package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.DataInfo;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.tool.DataHandler;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class DataHandler implements IDataHandler {
    private static final String e = "DataHandler";

    /* renamed from: a, reason: collision with root package name */
    private final BluetoothOTAManager f17739a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private WorkThread c;
    private DataHandlerThread d;

    /* loaded from: classes10.dex */
    public class DataHandlerThread extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f17740a;
        private volatile boolean b;
        private ArrayList<BasePacket> c;
        private final LinkedBlockingQueue<DataInfo> d;
        private final List<DataInfo> e;
        private final List<DataInfo> f;
        private TimerThread g;

        public DataHandlerThread() {
            super("DataHandlerThread");
            this.d = new LinkedBlockingQueue<>();
            this.e = Collections.synchronizedList(new ArrayList());
            this.f = Collections.synchronizedList(new ArrayList());
        }

        private void c() {
            a();
            DataInfo d = d();
            if (d == null) {
                if (this.f.size() > 0) {
                    a(500);
                    return;
                } else if (this.e.size() > 0) {
                    a(500);
                    return;
                } else {
                    e();
                    return;
                }
            }
            e(d);
        }

        private void d(DataInfo dataInfo) {
            final BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return;
            }
            if (basePacket.getHasResponse() == 1) {
                this.f.remove(dataInfo);
            } else {
                this.e.remove(dataInfo);
            }
            final CommandCallback callback = dataInfo.getCallback();
            DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.oO
                @Override // java.lang.Runnable
                public final void run() {
                    DataHandler.DataHandlerThread.this.a(basePacket, callback);
                }
            });
        }

        private void e() {
            TimerThread timerThread = this.g;
            if (timerThread == null || !timerThread.b) {
                return;
            }
            JL_Log.i(DataHandler.e, "-stopTimer- >>> ");
            this.g.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (this.b) {
                synchronized (this.d) {
                    try {
                        if (this.b) {
                            JL_Log.i(DataHandler.e, "wakeUpThread:: notifyAll");
                            this.d.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.d) {
                while (this.f17740a) {
                    if (this.d.isEmpty()) {
                        this.b = true;
                        c();
                        JL_Log.d(DataHandler.e, "DataHandlerThread is waiting...");
                        try {
                            this.d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.b = false;
                        c(this.d.poll());
                        c();
                    }
                }
            }
            JL_Log.e(DataHandler.e, "-DataHandlerThread- exit...");
            this.e.clear();
            this.f.clear();
            this.d.clear();
            this.f17740a = false;
            e();
            DataHandler.this.d = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.f17740a = true;
            super.start();
            JL_Log.i(DataHandler.e, "DataHandlerThread start....");
        }

        public void stopThread() {
            JL_Log.w(DataHandler.e, "-stopThread-");
            this.f17740a = false;
            f();
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            JL_Log.d(DataHandler.e, "-tryToAddRecvData-  ret : " + a(dataInfo) + ",isWaiting = " + this.b);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            JL_Log.d(DataHandler.e, "-tryToAddSendData-  ret : " + a(dataInfo) + ",isWaiting = " + this.b);
        }

        private int b(BluetoothDevice bluetoothDevice) {
            return DataHandler.this.f17739a.getReceiveMtu(bluetoothDevice);
        }

        private void a(int i) {
            TimerThread timerThread = this.g;
            if (timerThread != null) {
                if (timerThread.b) {
                    return;
                }
                this.g.b = true;
            } else {
                TimerThread timerThread2 = new TimerThread(i, new ThreadStateListener() { // from class: com.jieli.jl_bt_ota.tool.DataHandler.DataHandlerThread.1
                    @Override // com.jieli.jl_bt_ota.tool.DataHandler.ThreadStateListener
                    public void onFinish(long j) {
                        if (DataHandlerThread.this.g != null && DataHandlerThread.this.g.getId() == j) {
                            DataHandlerThread.this.g = null;
                        }
                    }

                    @Override // com.jieli.jl_bt_ota.tool.DataHandler.ThreadStateListener
                    public void onStart(long j) {
                    }
                });
                this.g = timerThread2;
                timerThread2.start();
            }
        }

        private ArrayList<DataInfo> b() {
            if (this.f.size() <= 0) {
                return null;
            }
            ArrayList<DataInfo> arrayList = new ArrayList<>();
            for (DataInfo dataInfo : this.f) {
                if (dataInfo.isSend()) {
                    arrayList.add(dataInfo);
                }
            }
            return arrayList;
        }

        private void e(DataInfo dataInfo) {
            byte[] packSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
            if (packSendBasePacket == null) {
                JL_Log.i(DataHandler.e, "send data :: pack data error.");
                d(dataInfo);
                return;
            }
            int a2 = a(dataInfo.getDevice());
            JL_Log.i(DataHandler.e, "send data : [" + CHexConver.byte2HexStr(packSendBasePacket) + "], sendMtu = " + a2);
            if (packSendBasePacket.length > a2 + 8) {
                JL_Log.e(DataHandler.e, "send data over communication mtu [" + a2 + "] limit.");
                d(dataInfo);
                return;
            }
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                if (DataHandler.this.f17739a != null) {
                    z = DataHandler.this.f17739a.sendDataToDevice(DataHandler.this.f17739a.getConnectedDevice(), packSendBasePacket);
                }
                if (z) {
                    break;
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            JL_Log.i(DataHandler.e, "send ret : " + z);
            if (!z) {
                d(dataInfo);
                return;
            }
            if (dataInfo.getBasePacket().getHasResponse() == 1) {
                dataInfo.setSend(true);
                dataInfo.setSendTime(Calendar.getInstance().getTimeInMillis());
            } else {
                final CommandCallback callback = dataInfo.getCallback();
                if (callback != null) {
                    DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.ooOOo0oXI
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommandCallback.this.onCommandResponse(null);
                        }
                    });
                }
                this.e.remove(dataInfo);
            }
        }

        private DataInfo d() {
            int i = 0;
            if (this.e.size() > 0) {
                while (i < this.e.size()) {
                    DataInfo dataInfo = this.e.get(i);
                    if (!dataInfo.isSend()) {
                        return dataInfo;
                    }
                    i++;
                }
            } else if (this.f.size() > 0) {
                while (i < this.f.size()) {
                    DataInfo dataInfo2 = this.f.get(i);
                    if (!dataInfo2.isSend()) {
                        return dataInfo2;
                    }
                    i++;
                }
            }
            return null;
        }

        private int a(BluetoothDevice bluetoothDevice) {
            return DataHandler.this.f17739a.getCommunicationMtu(bluetoothDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BasePacket basePacket, CommandCallback commandCallback) {
            BaseError buildError = OTAError.buildError(12290);
            buildError.setOpCode(basePacket.getOpCode());
            if (commandCallback != null) {
                commandCallback.onErrCode(buildError);
            }
            DataHandler.this.f17739a.errorEventCallback(buildError);
        }

        private void b(DataInfo dataInfo) {
            final CommandCallback callback = dataInfo.getCallback();
            DataHandler.this.f17739a.removeCacheCommand(dataInfo.getDevice(), dataInfo.getBasePacket());
            DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.x0XOIxOo
                @Override // java.lang.Runnable
                public final void run() {
                    DataHandler.DataHandlerThread.this.a(callback);
                }
            });
        }

        private void c(DataInfo dataInfo) {
            if (dataInfo != null) {
                if (dataInfo.getType() == 1) {
                    ArrayList<BasePacket> findPacketData = ParseHelper.findPacketData(dataInfo.getDevice(), b(dataInfo.getDevice()), dataInfo.getRecvData());
                    if (findPacketData != null) {
                        ArrayList<BasePacket> arrayList = this.c;
                        if (arrayList != null && arrayList.size() != 0) {
                            this.c.addAll(findPacketData);
                        } else {
                            this.c = findPacketData;
                        }
                        Iterator<BasePacket> it = findPacketData.iterator();
                        while (it.hasNext()) {
                            JL_Log.d(DataHandler.e, "-handlerQueue- opCode : " + it.next().getOpCode());
                        }
                        f();
                        return;
                    }
                    JL_Log.e(DataHandler.e, "-handlerQueue- findPacketData not found. ");
                    return;
                }
                if (dataInfo.getBasePacket() != null) {
                    if (dataInfo.getBasePacket().getHasResponse() == 1) {
                        if (this.f.size() < 30) {
                            this.f.add(dataInfo);
                            return;
                        } else {
                            JL_Log.i(DataHandler.e, "-handlerQueue- haveResponseDataList is busy. ");
                            DataHandler.this.f17739a.errorEventCallback(OTAError.buildError(12291));
                            return;
                        }
                    }
                    if (this.e.size() < 60) {
                        this.e.add(dataInfo);
                    } else {
                        JL_Log.i(DataHandler.e, "-handlerQueue- noResponseDataList is busy. ");
                        DataHandler.this.f17739a.errorEventCallback(OTAError.buildError(12291));
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean a(com.jieli.jl_bt_ota.model.DataInfo r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L11
                java.util.concurrent.LinkedBlockingQueue<com.jieli.jl_bt_ota.model.DataInfo> r0 = r4.d     // Catch: java.lang.InterruptedException -> Ld
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> Ld
                r2 = 3
                boolean r5 = r0.offer(r5, r2, r1)     // Catch: java.lang.InterruptedException -> Ld
                goto L12
            Ld:
                r5 = move-exception
                r5.printStackTrace()
            L11:
                r5 = 0
            L12:
                if (r5 == 0) goto L17
                r4.f()
            L17:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.tool.DataHandler.DataHandlerThread.a(com.jieli.jl_bt_ota.model.DataInfo):boolean");
        }

        private void a() {
            ArrayList<BasePacket> arrayList = new ArrayList<>();
            ArrayList<BasePacket> arrayList2 = this.c;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it = new ArrayList(this.c).iterator();
                while (it.hasNext()) {
                    BasePacket basePacket = (BasePacket) it.next();
                    byte[] packSendBasePacket = ParseHelper.packSendBasePacket(basePacket);
                    if (packSendBasePacket != null) {
                        if (DataHandler.this.f17739a != null) {
                            DataHandler.this.f17739a.receiveDataFromDevice(DataHandler.this.f17739a.getConnectedDevice(), packSendBasePacket);
                        }
                        if (basePacket.getType() == 1) {
                            arrayList3.add(basePacket);
                        } else {
                            arrayList.add(basePacket);
                        }
                    } else {
                        arrayList4.add(basePacket);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    this.c.removeAll(arrayList3);
                }
                if (arrayList4.size() > 0) {
                    this.c.removeAll(arrayList4);
                }
                a(arrayList);
                return;
            }
            a((ArrayList<BasePacket>) null);
        }

        private void a(ArrayList<BasePacket> arrayList) {
            ArrayList<DataInfo> arrayList2;
            String str;
            ArrayList<DataInfo> arrayList3;
            if (this.f.size() > 0) {
                ArrayList<DataInfo> b = b();
                StringBuilder sb = new StringBuilder();
                sb.append("-checkHaveResponseList- waitList size : ");
                sb.append(b == null ? 0 : b.size());
                JL_Log.w(DataHandler.e, sb.toString());
                if (b == null || b.size() <= 0) {
                    return;
                }
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                String str2 = ", data : ";
                if (arrayList == null || arrayList.size() <= 0) {
                    arrayList2 = b;
                    str = ", data : ";
                } else {
                    Iterator<BasePacket> it = arrayList.iterator();
                    while (it.hasNext()) {
                        final BasePacket next = it.next();
                        JL_Log.w(DataHandler.e, "-checkHaveResponseList- opCode : " + next.getOpCode() + ", sn : " + next.getOpCodeSn());
                        Iterator<DataInfo> it2 = b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            final DataInfo next2 = it2.next();
                            final BasePacket basePacket = next2.getBasePacket();
                            if (basePacket != null) {
                                JL_Log.w(DataHandler.e, "-checkHaveResponseList- packet opCode : " + basePacket.getOpCode() + ", packet sn : " + basePacket.getOpCodeSn());
                            }
                            if (basePacket != null && basePacket.getOpCode() == next.getOpCode() && basePacket.getOpCodeSn() == next.getOpCodeSn()) {
                                JL_Log.w(DataHandler.e, "-checkHaveResponseList- callback");
                                final CommandCallback callback = next2.getCallback();
                                DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.oOoXoXO
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DataHandler.DataHandlerThread.this.a(callback, next, next2, basePacket);
                                    }
                                });
                                arrayList4.add(next);
                                arrayList5.add(next2);
                                str2 = str2;
                                b = b;
                                break;
                            }
                            BasePacket basePacket2 = next;
                            ArrayList<DataInfo> arrayList6 = b;
                            String str3 = str2;
                            if (next2.getTimeoutMs() < 500) {
                                next2.setTimeoutMs(500);
                            }
                            if (timeInMillis - next2.getSendTime() > next2.getTimeoutMs()) {
                                int reSendCount = next2.getReSendCount();
                                JL_Log.e(DataHandler.e, "wait for response timeout !!! reSend count : " + reSendCount + str3 + next2);
                                if (reSendCount >= 3) {
                                    JL_Log.e(DataHandler.e, "retry count over time, callbackTimeOutError.");
                                    b(next2);
                                    arrayList4.add(basePacket2);
                                    arrayList5.add(next2);
                                } else {
                                    next2.setReSendCount(reSendCount + 1);
                                    next2.setSend(false);
                                }
                            }
                            str2 = str3;
                            next = basePacket2;
                            b = arrayList6;
                        }
                    }
                    arrayList2 = b;
                    str = str2;
                    if (arrayList4.size() > 0 && this.c != null) {
                        arrayList.removeAll(arrayList4);
                        this.c.removeAll(arrayList4);
                    }
                    if (arrayList.size() > 0 && this.c != null) {
                        JL_Log.e(DataHandler.e, "-checkHaveResponseList- remove unused response.");
                        this.c.removeAll(arrayList);
                    }
                    if (arrayList5.size() > 0) {
                        this.f.removeAll(arrayList5);
                        arrayList5.clear();
                        arrayList3 = b();
                        if (arrayList3 != null || arrayList3.size() <= 0) {
                            return;
                        }
                        Iterator<DataInfo> it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            DataInfo next3 = it3.next();
                            if (next3.getTimeoutMs() < 500) {
                                next3.setTimeoutMs(500);
                            }
                            if (timeInMillis - next3.getSendTime() > next3.getTimeoutMs()) {
                                int reSendCount2 = next3.getReSendCount();
                                JL_Log.e(DataHandler.e, "wait for response timeout 222222 !!! reSend count : " + reSendCount2 + str + next3);
                                if (reSendCount2 >= 3) {
                                    JL_Log.e(DataHandler.e, "retry count over time 222222, callbackTimeOutError.");
                                    b(next3);
                                    arrayList5.add(next3);
                                } else {
                                    next3.setReSendCount(reSendCount2 + 1);
                                    next3.setSend(false);
                                }
                            }
                        }
                        if (arrayList5.size() > 0) {
                            this.f.removeAll(arrayList5);
                            return;
                        }
                        return;
                    }
                }
                arrayList3 = arrayList2;
                if (arrayList3 != null) {
                    return;
                } else {
                    return;
                }
            }
            if (arrayList == null || arrayList.size() <= 0 || this.c == null) {
                return;
            }
            JL_Log.e(DataHandler.e, "-checkHaveResponseList- 22222 remove unused response.");
            this.c.removeAll(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(CommandCallback commandCallback, BasePacket basePacket, DataInfo dataInfo, BasePacket basePacket2) {
            if (commandCallback != null) {
                CommandBase convert2Command = ParseHelper.convert2Command(basePacket, DataHandler.this.f17739a.getCacheCommand(dataInfo.getDevice(), basePacket));
                if (convert2Command == null) {
                    commandCallback.onErrCode(OTAError.buildError(12293));
                } else {
                    commandCallback.onCommandResponse(convert2Command);
                }
            }
            DataHandler.this.f17739a.removeCacheCommand(dataInfo.getDevice(), basePacket2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(CommandCallback commandCallback) {
            BaseError buildError = OTAError.buildError(ErrorCode.SUB_ERR_SEND_TIMEOUT);
            if (commandCallback != null) {
                commandCallback.onErrCode(buildError);
            }
            DataHandler.this.f17739a.errorEventCallback(buildError);
        }
    }

    /* loaded from: classes10.dex */
    public interface ThreadStateListener {
        void onFinish(long j);

        void onStart(long j);
    }

    /* loaded from: classes10.dex */
    public class TimerThread extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private final long f17742a;
        private volatile boolean b;
        private final ThreadStateListener c;

        public TimerThread(long j, ThreadStateListener threadStateListener) {
            super("TimerThread");
            this.f17742a = j;
            this.c = threadStateListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                try {
                    Thread.sleep(this.f17742a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (DataHandler.this.d == null) {
                    break;
                } else {
                    DataHandler.this.d.f();
                }
            }
            this.b = false;
            JL_Log.w(DataHandler.e, "TimerThread is end....name : " + getName());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onFinish(getId());
            }
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.b = true;
            super.start();
            JL_Log.w(DataHandler.e, "TimerThread is start....name : " + getName());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onStart(getId());
            }
        }

        public synchronized void a() {
            this.b = false;
        }
    }

    /* loaded from: classes10.dex */
    public class WorkThread extends HandlerThread implements Handler.Callback {
        private static final int c = 1;
        private static final int d = 2;

        /* renamed from: a, reason: collision with root package name */
        private Handler f17743a;

        public WorkThread(String str) {
            super(str, 10);
        }

        public Handler getWorkHandler() {
            if (this.f17743a == null) {
                this.f17743a = new Handler(getLooper(), this);
            }
            return this.f17743a;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    DataInfo dataInfo = (DataInfo) message.obj;
                    if (DataHandler.this.d != null && dataInfo != null) {
                        DataHandler.this.d.tryToAddRecvData(dataInfo);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            DataInfo dataInfo2 = (DataInfo) message.obj;
            if (DataHandler.this.d != null) {
                DataHandler.this.d.tryToAddSendData(dataInfo2);
                return false;
            }
            return false;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            this.f17743a = new Handler(getLooper(), this);
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            if (this.f17743a == null) {
                this.f17743a = new Handler(getLooper(), this);
            }
            Message obtainMessage = this.f17743a.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = dataInfo;
            this.f17743a.sendMessage(obtainMessage);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            if (this.f17743a == null) {
                this.f17743a = new Handler(getLooper(), this);
            }
            Message obtainMessage = this.f17743a.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = dataInfo;
            this.f17743a.sendMessage(obtainMessage);
        }
    }

    public DataHandler(BluetoothOTAManager bluetoothOTAManager) {
        this.f17739a = bluetoothOTAManager;
        a();
    }

    private void d() {
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.quitSafely();
            this.c = null;
        }
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addRecvData(DataInfo dataInfo) {
        if (this.c == null) {
            a();
        }
        this.c.tryToAddRecvData(dataInfo);
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addSendData(DataInfo dataInfo) {
        if (this.c == null) {
            a();
        }
        this.c.tryToAddSendData(dataInfo);
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void release() {
        JL_Log.e(e, "-release-");
        c();
    }

    private void b() {
        if (this.c == null) {
            this.c = new WorkThread("Work_Thread");
        }
        this.c.start();
    }

    private void c() {
        DataHandlerThread dataHandlerThread = this.d;
        if (dataHandlerThread != null) {
            dataHandlerThread.stopThread();
        }
        d();
    }

    private void a() {
        if (this.d == null) {
            DataHandlerThread dataHandlerThread = new DataHandlerThread();
            this.d = dataHandlerThread;
            dataHandlerThread.start();
            b();
        }
    }
}
