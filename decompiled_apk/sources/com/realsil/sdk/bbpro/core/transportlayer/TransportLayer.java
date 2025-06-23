package com.realsil.sdk.bbpro.core.transportlayer;

import android.bluetooth.BluetoothDevice;
import com.realsil.sdk.bbpro.core.transportlayer.Command;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.base.BaseThread;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes11.dex */
public class TransportLayer {
    public static boolean D = true;
    public static boolean k = true;
    public volatile int b;
    public volatile int c;
    public CommandThread d;
    public AckThread e;
    public ThreadRx f;
    public List<TransportLayerCallback> g;
    public volatile Command h;
    public volatile boolean i;

    /* renamed from: a, reason: collision with root package name */
    public Object f19470a = new Object();
    public final Object j = new Object();

    /* loaded from: classes11.dex */
    public class AckThread extends BaseThread<Command> {
        public AckThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("AckThread");
            if (TransportLayer.k) {
                ZLogger.v("AckThread is running...");
            }
            while (!Thread.currentThread().isInterrupted() && !isCanceled()) {
                Command take = take();
                if (take != null) {
                    if (take.getPayload() == null) {
                        ZLogger.v("payload == null");
                    } else {
                        synchronized (TransportLayer.this.f19470a) {
                            take.setSn(TransportLayer.this.b);
                            TransportLayer.a(TransportLayer.this);
                        }
                        TransportLayer.this.sendCommandInner(take);
                    }
                }
            }
            if (TransportLayer.k) {
                ZLogger.v("TxThread stopped");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class CommandThread extends BaseThread<Command> {
        public CommandThread() {
        }

        public final boolean a(Command command) {
            boolean sendCommandInner;
            synchronized (TransportLayer.this.f19470a) {
                command.setSn(TransportLayer.this.b);
                TransportLayer.a(TransportLayer.this);
            }
            if (command.getWriteType() == 1) {
                return TransportLayer.this.sendCommandInner(command);
            }
            TransportLayer.this.i = false;
            int i = 0;
            boolean z = false;
            do {
                sendCommandInner = TransportLayer.this.sendCommandInner(command);
                if (!sendCommandInner) {
                    break;
                }
                synchronized (TransportLayer.this.j) {
                    if (!TransportLayer.this.i) {
                        try {
                            TransportLayer.this.j.wait(500L);
                        } catch (InterruptedException e) {
                            ZLogger.w(e.toString());
                        }
                        z = !TransportLayer.this.i;
                        sendCommandInner = TransportLayer.this.i;
                        if (!TransportLayer.this.i) {
                            ZLogger.v(TransportLayer.k, String.format(Locale.US, "ACK timeout for %d ms, times=%d", 500, Integer.valueOf(i)));
                        }
                    }
                }
                i++;
                if (i > command.getRetransCount()) {
                    break;
                }
            } while (z);
            return sendCommandInner;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("CommandThread");
            if (TransportLayer.k) {
                ZLogger.v("CommandThread is running...");
            }
            TransportLayer.this.h = null;
            while (!Thread.currentThread().isInterrupted() && !isCanceled()) {
                Command take = take();
                if (take != null) {
                    if (take.isCommandIdAvailable()) {
                        TransportLayer.this.h = take;
                    }
                    a(take);
                }
            }
            TransportLayer.this.h = null;
            if (TransportLayer.k) {
                ZLogger.v("TxThread stopped");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class ThreadRx extends BaseThread<byte[]> {
        public ThreadRx() {
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        public final synchronized void a(TransportLayerPacket transportLayerPacket) {
            boolean z;
            short opcode = transportLayerPacket.getOpcode();
            transportLayerPacket.getPayload();
            byte[] parameters = transportLayerPacket.getParameters();
            if (transportLayerPacket.getSeqNum() == TransportLayer.this.c) {
                z = true;
            } else {
                z = false;
            }
            TransportLayer.this.c = transportLayerPacket.getSeqNum();
            if (transportLayerPacket.isAckPkt()) {
                if (z) {
                    return;
                }
                AckPacket ackPacket = transportLayerPacket.toAckPacket();
                if (ackPacket != null) {
                    if (TransportLayer.D) {
                        ZLogger.v(String.format(Locale.US, "[0x%02X ACK->0x%04X] 0x%02X", Byte.valueOf(transportLayerPacket.getSeqNum()), Short.valueOf(ackPacket.getToAckId()), Byte.valueOf(ackPacket.getStatus())));
                    }
                    try {
                        if (TransportLayer.this.h != null) {
                            if (TransportLayer.this.h.getCommandId() == ackPacket.getToAckId()) {
                                TransportLayer.this.d();
                                TransportLayer.this.h = null;
                            } else {
                                ZLogger.v(TransportLayer.k, String.format("ignore ACK, expect is 0x%04X", Short.valueOf(TransportLayer.this.h.getCommandId())));
                            }
                        } else {
                            TransportLayer.this.d();
                        }
                        synchronized (TransportLayer.this.g) {
                            try {
                                ?? r0 = TransportLayer.this.g;
                                if (r0 != 0 && r0.size() > 0) {
                                    Iterator it = TransportLayer.this.g.iterator();
                                    while (it.hasNext()) {
                                        ((TransportLayerCallback) it.next()).onAckReceive(ackPacket);
                                    }
                                }
                            } finally {
                            }
                        }
                    } catch (Exception e) {
                        ZLogger.w(e.toString());
                    }
                } else {
                    ZLogger.d(String.format(Locale.US, "[0x%02X NA->0x%04X] %s", Byte.valueOf(transportLayerPacket.getSeqNum()), Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
                }
            }
            TransportLayer.this.sendAck(transportLayerPacket.getOpcode(), (byte) 0);
            if (TransportLayer.D) {
                ZLogger.v(String.format(Locale.US, "[0x%02X(%b) PACK->0x%04X] %s", Byte.valueOf(transportLayerPacket.getSeqNum()), Boolean.valueOf(z), Short.valueOf(opcode), DataConverter.bytes2Hex(parameters)));
            }
            if (!z) {
                try {
                    if (TransportLayer.this.h != null && TransportLayer.this.h.getEventId() == transportLayerPacket.getOpcode()) {
                        TransportLayer.this.d();
                        TransportLayer.this.h = null;
                    }
                    synchronized (TransportLayer.this.g) {
                        try {
                            ?? r1 = TransportLayer.this.g;
                            if (r1 != 0 && r1.size() > 0) {
                                Iterator it2 = TransportLayer.this.g.iterator();
                                while (it2.hasNext()) {
                                    ((TransportLayerCallback) it2.next()).onDataReceive(transportLayerPacket);
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Exception e2) {
                    ZLogger.w(e2.toString());
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (TransportLayer.D) {
                ZLogger.d("RxThread is running");
            }
            while (!Thread.currentThread().isInterrupted() && !isCanceled()) {
                byte[] take = take();
                if (take != null) {
                    int length = take.length;
                    int i = 0;
                    do {
                        int i2 = length - i;
                        if (i2 <= 0) {
                            break;
                        }
                        try {
                            byte[] bArr = new byte[i2];
                            System.arraycopy(take, i, bArr, 0, i2);
                            TransportLayerPacket builderPacket = TransportLayerPacket.builderPacket(bArr);
                            if (builderPacket == null) {
                                break;
                            }
                            a(builderPacket);
                            i += builderPacket.getPacketLength();
                        } catch (Exception e) {
                            ZLogger.w(e.toString());
                        }
                    } while (i < length);
                }
            }
            if (TransportLayer.D) {
                ZLogger.d("RxThread stopped");
            }
        }
    }

    public TransportLayer() {
        c();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public final void a(BluetoothDevice bluetoothDevice, boolean z, int i) {
        try {
            synchronized (this.g) {
                try {
                    ?? r1 = this.g;
                    if (r1 != 0 && r1.size() > 0) {
                        Iterator it = this.g.iterator();
                        while (it.hasNext()) {
                            ((TransportLayerCallback) it.next()).onConnectionStateChanged(bluetoothDevice, z, i);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public final void b() {
        this.c = 0;
        this.b = 1;
        f();
        e();
        ThreadRx threadRx = this.f;
        if (threadRx != null) {
            threadRx.cancel(true);
        }
        ThreadRx threadRx2 = new ThreadRx();
        this.f = threadRx2;
        threadRx2.start();
    }

    public final void c() {
        D = RtkCore.DEBUG;
        k = RtkCore.VDBG;
        this.g = new CopyOnWriteArrayList();
    }

    public final void d() {
        synchronized (this.j) {
            this.i = true;
            this.j.notifyAll();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void destroy() {
        if (k) {
            ZLogger.v("destory");
        }
        synchronized (this.g) {
            try {
                ?? r1 = this.g;
                if (r1 != 0) {
                    r1.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a();
    }

    public void disconnect() {
        if (k) {
            ZLogger.v(MqttServiceConstants.DISCONNECT_ACTION);
        }
        a();
    }

    public final void e() {
        AckThread ackThread = this.e;
        if (ackThread != null) {
            ackThread.cancel(true);
        }
        if (k) {
            ZLogger.v("startAckThread.");
        }
        AckThread ackThread2 = new AckThread();
        this.e = ackThread2;
        ackThread2.start();
    }

    public final void f() {
        CommandThread commandThread = this.d;
        if (commandThread != null) {
            commandThread.cancel(true);
        }
        if (k) {
            ZLogger.v("startTxSchedule.");
        }
        CommandThread commandThread2 = new CommandThread();
        this.d = commandThread2;
        commandThread2.start();
    }

    public boolean isConnected(BluetoothDevice bluetoothDevice) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void register(TransportLayerCallback transportLayerCallback) {
        synchronized (this.g) {
            try {
                if (this.g == null) {
                    this.g = new CopyOnWriteArrayList();
                }
                if (!this.g.contains(transportLayerCallback)) {
                    this.g.add(transportLayerCallback);
                }
                if (k) {
                    ZLogger.v("callback's size=" + this.g.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean sendAck(Command command) {
        if (command == null) {
            return false;
        }
        try {
            if (this.e == null) {
                e();
            }
            if (this.e == null) {
                return false;
            }
            if (k) {
                ZLogger.v(String.format(Locale.US, "<< writeType=%d, (%d)%s", Integer.valueOf(command.getWriteType()), Integer.valueOf(command.getPayloadLength()), DataConverter.bytes2Hex(command.getPayload())));
            }
            this.e.addQueue(command);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean sendCmd(byte[] bArr) {
        return sendCommand(new Command.Builder().writeType(2).payload(bArr).build());
    }

    public synchronized boolean sendCommand(Command command) {
        if (command == null) {
            return false;
        }
        try {
            if (this.d == null) {
                f();
            }
            if (this.d == null) {
                return false;
            }
            if (k) {
                ZLogger.v(String.format(Locale.US, "<< writeType=%d, (%d)%s", Integer.valueOf(command.getWriteType()), Integer.valueOf(command.getPayloadLength()), DataConverter.bytes2Hex(command.getPayload())));
            }
            this.d.addQueue(command);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean sendCommandInner(Command command) {
        return false;
    }

    public synchronized boolean sendData(byte[] bArr) {
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void unregister(TransportLayerCallback transportLayerCallback) {
        synchronized (this.g) {
            try {
                ?? r1 = this.g;
                if (r1 != 0) {
                    r1.remove(transportLayerCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sendCmd(short s, byte[] bArr) {
        return sendCommand(new Command.Builder().writeType(2).packet(s, bArr).build());
    }

    public static void a(TransportLayer transportLayer) {
        if (transportLayer.b != 255) {
            transportLayer.b++;
        } else {
            transportLayer.b = 1;
        }
    }

    public boolean sendAck(short s, byte b) {
        return sendAck(new Command.Builder().writeType(1).commandId(s).payload(AckPacket.encode(s, b)).build());
    }

    public boolean sendCommand(short s, short s2, byte[] bArr) {
        return sendCommand(new Command.Builder().writeType(2).packet(s, bArr).eventId(s2).build());
    }

    public final void a(byte[] bArr) {
        ThreadRx threadRx = this.f;
        if (threadRx == null || bArr == null) {
            return;
        }
        threadRx.addQueue(bArr);
    }

    public final void a() {
        if (this.f != null) {
            if (k) {
                ZLogger.v("clearRx");
            }
            this.f.clearQueue();
            this.f.cancel(true);
        }
        if (this.d != null) {
            if (k) {
                ZLogger.v("clearTx.");
            }
            this.d.clearQueue();
            d();
        }
        if (this.e != null) {
            if (k) {
                ZLogger.v("clearAck.");
            }
            this.e.clearQueue();
            d();
        }
    }
}
