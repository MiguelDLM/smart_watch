package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import xII.II0XooXoX;
import xII.Oxx0IOOO;
import xII.X0o0xo;
import xII.XO;
import xII.oxoX;

/* loaded from: classes13.dex */
public final class BleMessenger extends xII.oIX0oI {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String LOG_HEADER = "BleMessenger";
    public static final int RETRY_MAX_TIMES = 3;

    @oOoXoXO
    private MessageTask mMessageTask;

    @oOoXoXO
    private BleMessengerCallback mMessengerCallback;

    @OOXIXo
    private final LinkedList<xII.II0xO0> mBleMessages = new LinkedList<>();

    @OOXIXo
    private final LinkedBlockingQueue<II0XooXoX> mWritePackets = new LinkedBlockingQueue<>();

    @OOXIXo
    private final Semaphore mPacketSemaphore = new Semaphore(1);

    @OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes13.dex */
    public final class MessageTask implements Runnable {
        private int mRetry;

        @OOXIXo
        private final xII.II0xO0 message;
        final /* synthetic */ BleMessenger this$0;

        public MessageTask(@OOXIXo BleMessenger bleMessenger, xII.II0xO0 message) {
            IIX0o.x0xO0oo(message, "message");
            this.this$0 = bleMessenger;
            this.message = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            BluetoothGattDescriptor notifyDescriptor;
            byte[] bArr;
            BleMessengerCallback mMessengerCallback;
            BluetoothGatt mBluetoothGatt = this.this$0.getMAbsBleConnector().getMBluetoothGatt();
            if (mBluetoothGatt == null) {
                return;
            }
            int i = this.mRetry;
            if (i == 3) {
                BleMessengerCallback mMessengerCallback2 = this.this$0.getMMessengerCallback();
                if (mMessengerCallback2 != null) {
                    mMessengerCallback2.onTimeout(this.message);
                }
                this.this$0.dequeueMessage();
                return;
            }
            this.mRetry = i + 1;
            if (!BleConnector.INSTANCE.getDisableStreamLog() || this.mRetry > 1) {
                OI0.oIX0oI.f1507oIX0oI.XO("MessageTask -> try(" + this.mRetry + "), " + this.message);
            }
            xII.II0xO0 iI0xO0 = this.message;
            if (iI0xO0 instanceof X0o0xo) {
                BluetoothGattCharacteristic characteristic = this.this$0.getMAbsBleConnector().getCharacteristic(((X0o0xo) this.message).XO(), ((X0o0xo) this.message).X0o0xo());
                if (characteristic != null) {
                    mBluetoothGatt.readCharacteristic(characteristic);
                    return;
                }
                return;
            }
            if (iI0xO0 instanceof II0XooXoX) {
                if (this.mRetry > 1 && (mMessengerCallback = this.this$0.getMMessengerCallback()) != null) {
                    mMessengerCallback.onRetry();
                }
                this.this$0.enqueueWritePackets((II0XooXoX) this.message);
                this.this$0.mHandler.postDelayed(this, this.this$0.getMAbsBleConnector().getMTimeout());
                return;
            }
            if (iI0xO0 instanceof oxoX) {
                BluetoothGattCharacteristic characteristic2 = this.this$0.getMAbsBleConnector().getCharacteristic(((oxoX) this.message).II0XooXoX(), ((oxoX) this.message).XO());
                if (characteristic2 != null && (notifyDescriptor = this.this$0.getMAbsBleConnector().getNotifyDescriptor(characteristic2)) != null) {
                    if (((oxoX) this.message).Oxx0IOOO()) {
                        bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    } else {
                        bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                    notifyDescriptor.setValue(bArr);
                    mBluetoothGatt.setCharacteristicNotification(characteristic2, ((oxoX) this.message).Oxx0IOOO());
                    mBluetoothGatt.writeDescriptor(notifyDescriptor);
                    return;
                }
                return;
            }
            if (iI0xO0 instanceof Oxx0IOOO) {
                mBluetoothGatt.requestMtu(((Oxx0IOOO) iI0xO0).oxoX());
            } else if (iI0xO0 instanceof XO) {
                BluetoothGatt mBluetoothGatt2 = this.this$0.getMAbsBleConnector().getMBluetoothGatt();
                if (mBluetoothGatt2 != null) {
                    mBluetoothGatt2.requestConnectionPriority(((XO) this.message).oxoX());
                }
                this.this$0.dequeueMessage();
            }
        }
    }

    public BleMessenger() {
        xoIXOxX.II0xO0.I0Io(false, false, null, "BleMessenger WritePacket", 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleMessenger.1
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                while (true) {
                    II0XooXoX iI0XooXoX = (II0XooXoX) BleMessenger.this.mWritePackets.take();
                    BluetoothGatt mBluetoothGatt = BleMessenger.this.getMAbsBleConnector().getMBluetoothGatt();
                    if (mBluetoothGatt != null) {
                        BleMessenger bleMessenger = BleMessenger.this;
                        BluetoothGattCharacteristic characteristic = bleMessenger.getMAbsBleConnector().getCharacteristic(iI0XooXoX.I0Io(), iI0XooXoX.oIX0oI());
                        if (characteristic != null) {
                            bleMessenger.mPacketSemaphore.acquire();
                            characteristic.setValue(iI0XooXoX.II0xO0());
                            if (!mBluetoothGatt.writeCharacteristic(characteristic)) {
                                OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger WritePacket failed -> " + ByteArrayExtKt.getMHexString(characteristic.getValue()));
                            }
                        }
                    }
                }
            }
        }, 23, null);
    }

    @Override // xII.oIX0oI
    public synchronized void dequeueMessage() {
        try {
            MessageTask messageTask = this.mMessageTask;
            if (messageTask != null) {
                this.mHandler.removeCallbacks(messageTask);
                this.mMessageTask = null;
            }
            if (!this.mBleMessages.isEmpty()) {
                xII.II0xO0 removeFirst = this.mBleMessages.removeFirst();
                IIX0o.oO(removeFirst, "removeFirst(...)");
                MessageTask messageTask2 = new MessageTask(this, removeFirst);
                this.mHandler.post(messageTask2);
                this.mMessageTask = messageTask2;
            } else {
                OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger dequeueMessage -> No message right now");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // xII.oIX0oI
    public synchronized void dequeueWritePacket() {
        try {
            if (!BleConnector.INSTANCE.getDisableStreamLog()) {
                OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger dequeueWritePacket");
            }
            if (this.mPacketSemaphore.availablePermits() == 0) {
                this.mPacketSemaphore.release();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // xII.oIX0oI
    public synchronized void enqueueMessage(@OOXIXo xII.II0xO0 message) {
        try {
            IIX0o.x0xO0oo(message, "message");
            if (!BleConnector.INSTANCE.getDisableStreamLog()) {
                OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger enqueueMessage -> " + message);
            }
            this.mBleMessages.addLast(message);
            if (this.mMessageTask == null) {
                dequeueMessage();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void enqueueWritePackets(@OOXIXo II0XooXoX message) {
        int length;
        int mPacketSize;
        try {
            IIX0o.x0xO0oo(message, "message");
            if (message.II0xO0().length % getMPacketSize() == 0) {
                length = message.II0xO0().length / getMPacketSize();
            } else {
                length = (message.II0xO0().length / getMPacketSize()) + 1;
            }
            if (length == 1) {
                if (!BleConnector.INSTANCE.getDisableStreamLog()) {
                    OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger enqueueWritePackets -> " + message);
                }
                this.mWritePackets.put(message);
            } else {
                for (int i = 0; i < length; i++) {
                    byte[] II0xO02 = message.II0xO0();
                    int mPacketSize2 = getMPacketSize() * i;
                    if (i == length - 1) {
                        mPacketSize = message.II0xO0().length;
                    } else {
                        mPacketSize = (i + 1) * getMPacketSize();
                    }
                    II0XooXoX iI0XooXoX = new II0XooXoX(message.I0Io(), message.oIX0oI(), ooOOo0oXI.xxOXOOoIX(II0xO02, mPacketSize2, mPacketSize));
                    if (!BleConnector.INSTANCE.getDisableStreamLog()) {
                        OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger enqueueWritePackets -> " + iI0XooXoX);
                    }
                    this.mWritePackets.put(iI0XooXoX);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @oOoXoXO
    public final BleMessengerCallback getMMessengerCallback() {
        return this.mMessengerCallback;
    }

    public final synchronized void replyMessage(@OOXIXo II0XooXoX message) {
        IIX0o.x0xO0oo(message, "message");
        OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger replyMessage -> " + message);
        enqueueWritePackets(message);
    }

    @Override // xII.oIX0oI
    public synchronized void reset() {
        try {
            OI0.oIX0oI.f1507oIX0oI.XO("BleMessenger -> reset");
            MessageTask messageTask = this.mMessageTask;
            if (messageTask != null) {
                this.mHandler.removeCallbacks(messageTask);
            }
            this.mMessageTask = null;
            this.mBleMessages.clear();
            this.mWritePackets.clear();
            if (this.mPacketSemaphore.availablePermits() == 0) {
                this.mPacketSemaphore.release();
            } else if (this.mPacketSemaphore.availablePermits() > 1) {
                Semaphore semaphore = this.mPacketSemaphore;
                semaphore.acquire(semaphore.availablePermits() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setMMessengerCallback(@oOoXoXO BleMessengerCallback bleMessengerCallback) {
        this.mMessengerCallback = bleMessengerCallback;
    }
}
