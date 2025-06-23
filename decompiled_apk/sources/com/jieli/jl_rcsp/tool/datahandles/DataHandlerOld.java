package com.jieli.jl_rcsp.tool.datahandles;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.openalliance.ad.constant.bn;
import com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

@Deprecated
/* loaded from: classes10.dex */
public class DataHandlerOld implements DataHandler {
    public static final String g = "jl_rcsp";

    /* renamed from: a, reason: collision with root package name */
    public final IBluetoothProxy f18165a;
    public final Handler b;
    public WorkThread c;
    public DataHandlerThread d;
    public volatile byte[] e;
    public volatile int f = 0;

    /* loaded from: classes10.dex */
    public class DataHandlerThread extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f18166a;
        public volatile boolean b;
        public final List<DataInfo> c;
        public final LinkedBlockingQueue<DataInfo> d;
        public final List<DataInfo> e;
        public final List<DataInfo> f;
        public TimerThread g;

        public DataHandlerThread() {
            super("DataHandlerThread");
            this.c = Collections.synchronizedList(new ArrayList());
            this.d = new LinkedBlockingQueue<>();
            this.e = Collections.synchronizedList(new ArrayList());
            this.f = Collections.synchronizedList(new ArrayList());
        }

        public final DataInfo c(DataInfo dataInfo) {
            BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return null;
            }
            Iterator it = new ArrayList(this.f).iterator();
            while (it.hasNext()) {
                DataInfo dataInfo2 = (DataInfo) it.next();
                BasePacket basePacket2 = dataInfo2.getBasePacket();
                if (basePacket2 != null && basePacket.getOpCode() == basePacket2.getOpCode() && basePacket.getOpCodeSn() == basePacket2.getOpCodeSn() && RcspUtil.deviceEquals(dataInfo.getDevice(), dataInfo2.getDevice())) {
                    return dataInfo2;
                }
            }
            return null;
        }

        public final void d() {
            b();
            DataInfo e = e();
            if (e == null) {
                if (this.f.isEmpty() && this.e.isEmpty()) {
                    f();
                    return;
                } else {
                    a(500);
                    return;
                }
            }
            f(e);
        }

        public final void e(DataInfo dataInfo) {
            BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return;
            }
            if (basePacket.getHasResponse() == 1) {
                this.f.remove(dataInfo);
            } else {
                this.e.remove(dataInfo);
            }
            DataHandlerOld.this.a(dataInfo, new BaseError(12288).setOpCode(basePacket.getOpCode()));
        }

        public final void f() {
            TimerThread timerThread = this.g;
            if (timerThread == null || !timerThread.b) {
                return;
            }
            JL_Log.i("jl_rcsp", "stopTimer", "");
            this.g.a();
        }

        public final void g() {
            if (this.b) {
                synchronized (this.d) {
                    this.d.notify();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.d) {
                while (this.f18166a) {
                    if (this.d.isEmpty()) {
                        this.b = true;
                        d();
                        try {
                            this.d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.b = false;
                        d(this.d.poll());
                        d();
                    }
                }
            }
            this.e.clear();
            this.f.clear();
            this.d.clear();
            this.f18166a = false;
            f();
            DataHandlerOld.this.d = null;
            JL_Log.e("jl_rcsp", "DataHandlerThread", "exit");
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.f18166a = true;
            super.start();
            JL_Log.i("jl_rcsp", "DataHandlerThread", "start");
        }

        public void stopThread() {
            JL_Log.w("jl_rcsp", "DataHandlerThread", "stopThread");
            this.f18166a = false;
            g();
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            JL_Log.d("jl_rcsp", "tryToAddRecvData", a(dataInfo) + ", isWaiting : " + this.b);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            JL_Log.d("jl_rcsp", "tryToAddSendData", a(dataInfo) + ", isWaiting : " + this.b);
        }

        public final void b() {
            if (!this.c.isEmpty()) {
                JL_Log.d("jl_rcsp", "checkResponseListModify", "start --> size = " + this.c.size());
                ArrayList<DataInfo> arrayList = new ArrayList(this.c);
                this.c.clear();
                for (DataInfo dataInfo : arrayList) {
                    BasePacket basePacket = dataInfo.getBasePacket();
                    JL_Log.d("jl_rcsp", "checkResponseListModify", "Receive command --> " + dataInfo);
                    if (basePacket != null) {
                        if (basePacket.getType() == 1) {
                            DataHandlerOld.this.f18165a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                        } else {
                            DataInfo c = c(dataInfo);
                            JL_Log.i("jl_rcsp", "checkResponseListModify", "Cache Command --> size = " + this.f.size() + "\t" + c);
                            if (c == null) {
                                JL_Log.w("jl_rcsp", "checkResponseListModify", "No cached command found.");
                            } else {
                                this.f.remove(c);
                                CommandBase convert2Command = ParseHelper.convert2Command(c.getDevice(), basePacket);
                                if (convert2Command != null) {
                                    DataHandlerOld.this.f18165a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                                    DataHandlerOld.this.a(c, convert2Command);
                                } else {
                                    BaseError baseError = new BaseError(12289);
                                    baseError.setOpCode(basePacket.getOpCode());
                                    DataHandlerOld.this.a(c, baseError);
                                }
                                CommandHelper.getInstance().removeCommandBase(c.getDevice(), basePacket);
                            }
                        }
                    }
                }
            }
            if (!this.f.isEmpty()) {
                Iterator it = new ArrayList(this.f).iterator();
                while (it.hasNext()) {
                    DataInfo dataInfo2 = (DataInfo) it.next();
                    if (dataInfo2.isSend()) {
                        long currentTimeMillis = System.currentTimeMillis() - dataInfo2.getSendTime();
                        if (dataInfo2.getTimeoutMs() < 500) {
                            dataInfo2.setTimeoutMs(500);
                        }
                        if (currentTimeMillis >= dataInfo2.getTimeoutMs()) {
                            if (dataInfo2.getReSendCount() > 3) {
                                JL_Log.e("jl_rcsp", "checkResponseListModify", "Command timeout --> " + dataInfo2);
                                b(dataInfo2);
                                this.f.remove(dataInfo2);
                            } else {
                                dataInfo2.setReSendCount(dataInfo2.getReSendCount() + 1);
                                dataInfo2.setSend(false);
                            }
                        }
                    }
                }
            }
            JL_Log.d("jl_rcsp", "checkResponseListModify", "end --> size = " + this.c.size());
        }

        public final void a(int i) {
            TimerThread timerThread = this.g;
            if (timerThread != null) {
                if (timerThread.b) {
                    return;
                }
                this.g.b = true;
            } else {
                TimerThread timerThread2 = new TimerThread(i, new ThreadStateListener() { // from class: com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld.DataHandlerThread.1
                    @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                    public void onFinish(long j) {
                        if (DataHandlerThread.this.g != null && DataHandlerThread.this.g.getId() == j) {
                            DataHandlerThread.this.g = null;
                        }
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                    public void onStart(long j) {
                    }
                });
                this.g = timerThread2;
                timerThread2.start();
            }
        }

        public final void f(DataInfo dataInfo) {
            if (dataInfo == null) {
                return;
            }
            byte[] packSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
            if (packSendBasePacket == null) {
                JL_Log.i("jl_rcsp", "sendData", "pack data error.");
                e(dataInfo);
                return;
            }
            JL_Log.v("jl_rcsp", "sendData", "[" + CHexConver.byte2HexStr(packSendBasePacket) + "]");
            if (packSendBasePacket.length > DataHandlerOld.b(dataInfo.getDevice()) + 8) {
                JL_Log.e("jl_rcsp", "sendData", "Data over communication mtu [" + DataHandlerOld.b(dataInfo.getDevice()) + "] limit.");
                e(dataInfo);
                return;
            }
            boolean z = false;
            for (int i = 0; i < 3 && !(z = DataHandlerOld.this.f18165a.sendDataToDevice(dataInfo.getDevice(), packSendBasePacket)); i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            JL_Log.i("jl_rcsp", "sendData", "" + z);
            if (!z) {
                e(dataInfo);
            } else if (dataInfo.getBasePacket().getHasResponse() != 1) {
                DataHandlerOld.this.a(dataInfo, ParseHelper.convert2Command(dataInfo.getDevice(), dataInfo.getBasePacket()));
                this.e.remove(dataInfo);
            } else {
                dataInfo.setSend(true);
                dataInfo.setSendTime(Calendar.getInstance().getTimeInMillis());
            }
        }

        public final DataInfo e() {
            int i = 0;
            if (!this.e.isEmpty()) {
                while (i < this.e.size()) {
                    DataInfo dataInfo = this.e.get(i);
                    if (!dataInfo.isSend()) {
                        return dataInfo;
                    }
                    i++;
                }
            } else if (!this.f.isEmpty()) {
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

        public final ArrayList<DataInfo> c() {
            if (this.f.isEmpty()) {
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

        public final void d(DataInfo dataInfo) {
            if (dataInfo != null) {
                if (dataInfo.getType() == 1) {
                    ArrayList<BasePacket> findPacketData = DataHandlerOld.this.findPacketData(dataInfo.getDevice(), dataInfo.getRecvData());
                    if (findPacketData != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<BasePacket> it = findPacketData.iterator();
                        while (it.hasNext()) {
                            BasePacket next = it.next();
                            JL_Log.d("jl_rcsp", "handlerQueue", "opCode : " + next.getOpCode());
                            arrayList.add(new DataInfo().setType(1).setDevice(dataInfo.getDevice()).setBasePacket(next));
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        this.c.addAll(arrayList);
                        g();
                        return;
                    }
                    JL_Log.e("jl_rcsp", "handlerQueue", "findPacketData not found. ");
                    return;
                }
                if (dataInfo.getBasePacket() != null) {
                    if (dataInfo.getBasePacket().getHasResponse() == 1) {
                        if (this.f.size() < 30) {
                            this.f.add(dataInfo);
                            return;
                        } else {
                            JL_Log.i("jl_rcsp", "handlerQueue", "haveResponseDataList is busy. ");
                            DataHandlerOld.this.f18165a.callbackErrorEvent(new BaseError(12291));
                            return;
                        }
                    }
                    if (this.e.size() < 60) {
                        this.e.add(dataInfo);
                    } else {
                        JL_Log.i("jl_rcsp", "handlerQueue", "noResponseDataList is busy. ");
                        DataHandlerOld.this.f18165a.callbackErrorEvent(new BaseError(12291));
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(com.jieli.jl_rcsp.model.DataInfo r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L11
                java.util.concurrent.LinkedBlockingQueue<com.jieli.jl_rcsp.model.DataInfo> r0 = r4.d     // Catch: java.lang.InterruptedException -> Ld
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
                r4.g()
            L17:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld.DataHandlerThread.a(com.jieli.jl_rcsp.model.DataInfo):boolean");
        }

        @Deprecated
        public final void a() {
            ArrayList<DataInfo> arrayList = new ArrayList<>();
            if (!this.c.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = new ArrayList(this.c).iterator();
                while (it.hasNext()) {
                    DataInfo dataInfo = (DataInfo) it.next();
                    BasePacket basePacket = dataInfo.getBasePacket();
                    if (basePacket != null) {
                        DataHandlerOld.this.f18165a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                        if (basePacket.getType() == 1) {
                            arrayList2.add(dataInfo);
                        } else {
                            arrayList.add(dataInfo);
                        }
                    } else {
                        arrayList3.add(dataInfo);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    this.c.removeAll(arrayList2);
                }
                if (!arrayList3.isEmpty()) {
                    this.c.removeAll(arrayList3);
                }
                a(arrayList);
                return;
            }
            a((ArrayList<DataInfo>) null);
        }

        @Deprecated
        public final void a(ArrayList<DataInfo> arrayList) {
            ArrayList<DataInfo> arrayList2;
            ArrayList<DataInfo> arrayList3;
            Iterator<DataInfo> it;
            if (!this.f.isEmpty()) {
                ArrayList<DataInfo> c = c();
                StringBuilder sb = new StringBuilder();
                sb.append("waitList size : ");
                sb.append(c == null ? 0 : c.size());
                JL_Log.i("jl_rcsp", "checkHaveResponseList", sb.toString());
                if (c == null || c.isEmpty()) {
                    return;
                }
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                long a2 = DataHandlerOld.this.a();
                if (arrayList == null || arrayList.isEmpty()) {
                    arrayList2 = c;
                } else {
                    Iterator<DataInfo> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DataInfo next = it2.next();
                        final BasePacket basePacket = next.getBasePacket();
                        if (basePacket != null) {
                            JL_Log.d("jl_rcsp", "checkHaveResponseList", "opCode : " + basePacket.getOpCode() + ", sn : " + basePacket.getOpCodeSn() + ", device : " + next.getDevice());
                            Iterator<DataInfo> it3 = c.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    final DataInfo next2 = it3.next();
                                    final BasePacket basePacket2 = next2.getBasePacket();
                                    ArrayList<DataInfo> arrayList6 = c;
                                    if (basePacket2 != null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        it = it3;
                                        sb2.append("packet opCode : ");
                                        sb2.append(basePacket2.getOpCode());
                                        sb2.append(", packet sn : ");
                                        sb2.append(basePacket2.getOpCodeSn());
                                        JL_Log.i("jl_rcsp", "checkHaveResponseList", sb2.toString());
                                    } else {
                                        it = it3;
                                    }
                                    if (basePacket2 != null && basePacket2.getOpCode() == basePacket.getOpCode() && basePacket2.getOpCodeSn() == basePacket.getOpCodeSn() && RcspUtil.deviceEquals(next2.getDevice(), next.getDevice())) {
                                        JL_Log.w("jl_rcsp", "checkHaveResponseList", bn.f.L);
                                        DataHandlerOld.this.b.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.II0XooXoX
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                DataHandlerOld.DataHandlerThread.this.a(next2, basePacket, basePacket2);
                                            }
                                        });
                                        arrayList4.add(next);
                                        arrayList5.add(next2);
                                        c = arrayList6;
                                        break;
                                    }
                                    if (next2.getTimeoutMs() < 500) {
                                        next2.setTimeoutMs(500);
                                    }
                                    Iterator<DataInfo> it4 = it2;
                                    if (a2 - next2.getSendTime() > next2.getTimeoutMs()) {
                                        int reSendCount = next2.getReSendCount();
                                        JL_Log.e("jl_rcsp", "checkHaveResponseList", "wait for response timeout !!! reSend count : " + reSendCount + ", data : " + next2);
                                        if (reSendCount >= 3) {
                                            JL_Log.e("jl_rcsp", "checkHaveResponseList", "retry count over time, callbackTimeOutError.");
                                            b(next2);
                                            arrayList4.add(next);
                                            arrayList5.add(next2);
                                        } else {
                                            next2.setReSendCount(reSendCount + 1);
                                            next2.setSend(false);
                                        }
                                    }
                                    it2 = it4;
                                    c = arrayList6;
                                    it3 = it;
                                }
                            }
                        }
                    }
                    arrayList2 = c;
                    if (!arrayList4.isEmpty()) {
                        arrayList.removeAll(arrayList4);
                        this.c.removeAll(arrayList4);
                    }
                    if (!arrayList.isEmpty()) {
                        JL_Log.e("jl_rcsp", "checkHaveResponseList", "remove unused response.");
                        this.c.removeAll(arrayList);
                    }
                    if (!arrayList5.isEmpty()) {
                        this.f.removeAll(arrayList5);
                        arrayList5.clear();
                        arrayList3 = c();
                        if (arrayList3 != null || arrayList3.isEmpty()) {
                            return;
                        }
                        Iterator<DataInfo> it5 = arrayList3.iterator();
                        while (it5.hasNext()) {
                            DataInfo next3 = it5.next();
                            if (next3.getTimeoutMs() < 500) {
                                next3.setTimeoutMs(500);
                            }
                            if (a2 - next3.getSendTime() > next3.getTimeoutMs()) {
                                int reSendCount2 = next3.getReSendCount();
                                JL_Log.e("jl_rcsp", "checkHaveResponseList", "wait for response timeout 222222 !!! reSend count : " + reSendCount2 + ", data : " + next3);
                                if (reSendCount2 >= 3) {
                                    JL_Log.e("jl_rcsp", "checkHaveResponseList", "retry count over time 222222, callbackTimeOutError.");
                                    b(next3);
                                    arrayList5.add(next3);
                                } else {
                                    next3.setReSendCount(reSendCount2 + 1);
                                    next3.setSend(false);
                                }
                            }
                        }
                        if (arrayList5.isEmpty()) {
                            return;
                        }
                        this.f.removeAll(arrayList5);
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
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            JL_Log.e("jl_rcsp", "checkHaveResponseList", "22222 remove unused response.");
            this.c.removeAll(arrayList);
        }

        public final void b(DataInfo dataInfo) {
            CommandHelper.getInstance().removeCommandBase(dataInfo.getDevice(), dataInfo.getBasePacket());
            BaseError baseError = new BaseError(12290);
            if (dataInfo.getBasePacket() != null) {
                baseError.setOpCode(dataInfo.getBasePacket().getOpCode());
            }
            DataHandlerOld.this.a(dataInfo, baseError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DataInfo dataInfo, BasePacket basePacket, BasePacket basePacket2) {
            CommandBase convert2Command = ParseHelper.convert2Command(dataInfo.getDevice(), basePacket);
            if (convert2Command != null) {
                DataHandlerOld.this.a(dataInfo, convert2Command);
            } else {
                BaseError baseError = new BaseError(12289);
                baseError.setOpCode(basePacket.getOpCode());
                DataHandlerOld.this.a(dataInfo, baseError);
            }
            CommandHelper.getInstance().removeCommandBase(dataInfo.getDevice(), basePacket2);
        }
    }

    /* loaded from: classes10.dex */
    public class TimerThread extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final long f18168a;
        public volatile boolean b;
        public final ThreadStateListener c;

        public TimerThread(long j, ThreadStateListener threadStateListener) {
            super("TimerThread");
            this.f18168a = j;
            this.c = threadStateListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                try {
                    Thread.sleep(this.f18168a);
                    if (DataHandlerOld.this.d == null) {
                        break;
                    } else {
                        DataHandlerOld.this.d.g();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.b = false;
            JL_Log.w("jl_rcsp", "TimerThread", "end. thread id : " + getId());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onFinish(getId());
            }
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.b = true;
            super.start();
            JL_Log.w("jl_rcsp", "TimerThread", "start. thread id : " + getId());
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
        public static final int c = 1;
        public static final int d = 2;

        /* renamed from: a, reason: collision with root package name */
        public Handler f18169a;

        public WorkThread(String str) {
            super(str, 10);
        }

        public Handler getWorkHandler() {
            if (this.f18169a == null) {
                this.f18169a = new Handler(getLooper(), this);
            }
            return this.f18169a;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    DataInfo dataInfo = (DataInfo) message.obj;
                    if (DataHandlerOld.this.d != null && dataInfo != null) {
                        DataHandlerOld.this.d.tryToAddRecvData(dataInfo);
                    }
                }
            } else {
                DataInfo dataInfo2 = (DataInfo) message.obj;
                if (DataHandlerOld.this.d != null) {
                    DataHandlerOld.this.d.tryToAddSendData(dataInfo2);
                }
            }
            return false;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            this.f18169a = new Handler(getLooper(), this);
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            if (this.f18169a == null) {
                this.f18169a = new Handler(getLooper(), this);
            }
            Message obtainMessage = this.f18169a.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = dataInfo;
            this.f18169a.sendMessage(obtainMessage);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            if (this.f18169a == null) {
                this.f18169a = new Handler(getLooper(), this);
            }
            Message obtainMessage = this.f18169a.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = dataInfo;
            this.f18169a.sendMessage(obtainMessage);
        }
    }

    public DataHandlerOld(IBluetoothProxy iBluetoothProxy) {
        if (iBluetoothProxy != null) {
            this.f18165a = iBluetoothProxy;
            this.b = new Handler(Looper.getMainLooper());
            b();
            return;
        }
        throw new NullPointerException("IBluetoothProxy can not be null.");
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addRecvData(DataInfo dataInfo) {
        if (this.c == null) {
            b();
        }
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.tryToAddRecvData(dataInfo);
        }
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addSendData(DataInfo dataInfo) {
        if (this.c == null) {
            b();
        }
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.tryToAddSendData(dataInfo);
        }
    }

    public final void e() {
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.quitSafely();
            this.c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b7, code lost:
    
        r14 = r14 + 4;
        r9 = new byte[r14];
        java.lang.System.arraycopy(r7, r10, r9, 0, r14);
        r9 = a(r17, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
    
        if (r9 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c6, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
    
        if (r11 != r6) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.jieli.jl_rcsp.model.base.BasePacket> findPacketData(android.bluetooth.BluetoothDevice r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld.findPacketData(android.bluetooth.BluetoothDevice, byte[]):java.util.ArrayList");
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void release() {
        JL_Log.i("jl_rcsp", "release", "=====>>>");
        CommandHelper.getInstance().release();
        d();
    }

    public final void b() {
        if (this.d == null) {
            DataHandlerThread dataHandlerThread = new DataHandlerThread();
            this.d = dataHandlerThread;
            dataHandlerThread.start();
            c();
        }
    }

    public final void c() {
        if (this.c == null) {
            this.c = new WorkThread("Work_Thread");
        }
        this.c.start();
    }

    public final void d() {
        DataHandlerThread dataHandlerThread = this.d;
        if (dataHandlerThread != null) {
            dataHandlerThread.stopThread();
        }
        e();
    }

    public static int c(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxReceiveMtu(bluetoothDevice);
    }

    public static int b(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxCommunicationMtu(bluetoothDevice);
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return;
        }
        this.e = new byte[i2];
        System.arraycopy(bArr, i, this.e, 0, i2);
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DataInfo dataInfo, BaseError baseError) {
        if (dataInfo.getRcspCmdCallback() != null) {
            dataInfo.getRcspCmdCallback().onErrCode(dataInfo.getDevice(), baseError);
        }
        this.f18165a.callbackErrorEvent(baseError);
    }

    public static BasePacket a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return null;
        }
        byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr[0]);
        int byteToInt = CHexConver.byteToInt(bArr[1]);
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 2, bArr2, 0, 2);
        int bytesToInt = CHexConver.bytesToInt(bArr2[0], bArr2[1]);
        BasePacket basePacket = new BasePacket();
        int i = 7;
        int byteToInt2 = CHexConver.byteToInt(booleanArrayBig[7]);
        int byteToInt3 = CHexConver.byteToInt(booleanArrayBig[6]);
        basePacket.setType(byteToInt2);
        basePacket.setHasResponse(byteToInt3);
        basePacket.setOpCode(byteToInt);
        basePacket.setParamLen(bytesToInt);
        if (bytesToInt <= 0) {
            return basePacket;
        }
        if (byteToInt2 == 0) {
            byte[] bArr3 = new byte[1];
            System.arraycopy(bArr, 4, bArr3, 0, 1);
            basePacket.setStatus(CHexConver.byteToInt(bArr3[0]));
            byte[] bArr4 = new byte[1];
            System.arraycopy(bArr, 5, bArr4, 0, 1);
            basePacket.setOpCodeSn(CHexConver.byteToInt(bArr4[0]));
            if (byteToInt == 1) {
                byte[] bArr5 = new byte[1];
                System.arraycopy(bArr, 6, bArr5, 0, 1);
                basePacket.setXmOpCode(CHexConver.byteToInt(bArr5[0]));
            }
            i = 6;
        } else {
            byte[] bArr6 = new byte[1];
            System.arraycopy(bArr, 4, bArr6, 0, 1);
            basePacket.setOpCodeSn(CHexConver.byteToInt(bArr6[0]));
            if (byteToInt == 1) {
                byte[] bArr7 = new byte[1];
                System.arraycopy(bArr, 5, bArr7, 0, 1);
                basePacket.setXmOpCode(CHexConver.byteToInt(bArr7[0]));
                i = 6;
            } else {
                i = 5;
            }
        }
        int i2 = bytesToInt - (i - 4);
        byte[] bArr8 = new byte[i2];
        System.arraycopy(bArr, i, bArr8, 0, i2);
        basePacket.setParamData(bArr8);
        JL_Log.d("jl_rcsp", "parsePacketData", RcspUtil.formatString("packet type : %d, opCode : %d, sn :%d, device : %s", Integer.valueOf(basePacket.getType()), Integer.valueOf(basePacket.getOpCode()), Integer.valueOf(basePacket.getOpCodeSn()), bluetoothDevice));
        return basePacket;
    }

    public static /* synthetic */ void b(DataInfo dataInfo, CommandBase commandBase) {
        if (dataInfo.getRcspCmdCallback() != null) {
            dataInfo.getRcspCmdCallback().onCommandResponse(dataInfo.getDevice(), commandBase);
        }
    }

    public final long a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public final void a(final DataInfo dataInfo, final BaseError baseError) {
        if (dataInfo == null || baseError == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.XO
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerOld.this.b(dataInfo, baseError);
            }
        });
    }

    public final void a(final DataInfo dataInfo, final CommandBase commandBase) {
        if (dataInfo == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.Oxx0IOOO
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerOld.b(DataInfo.this, commandBase);
            }
        });
    }
}
