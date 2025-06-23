package com.realsil.sdk.dfu.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.usb.GlobalUsbGatt;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.Locale;

/* loaded from: classes11.dex */
public abstract class f extends c implements o {
    public GlobalUsbGatt A;
    public UsbGatt B;
    public volatile byte[] C;
    public volatile boolean D;
    public volatile boolean E;
    public volatile boolean F;
    public Handler G;
    public Runnable H;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if (fVar.mConnectionState == 513) {
                fVar.m();
            }
        }
    }

    public f(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new Handler(Looper.getMainLooper());
        this.H = new a();
    }

    public final void a(UsbGatt usbGatt, boolean z) {
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean abort() {
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacks(this.H);
        }
        return super.abort();
    }

    public void b(UsbGatt usbGatt) {
        int i = this.mConnectionState;
        if (i != 0 && i != 1280) {
            if (usbGatt != null) {
                setConnectionState(1024);
                usbGatt.disconnect();
                waitUntilDisconnected();
                return;
            } else {
                ZLogger.d(this.DBG, "gatt == null");
                setConnectionState(0);
                return;
            }
        }
        ZLogger.d(this.DBG, "already disconnect");
    }

    public void c(int i) {
        int i2 = 16;
        if (i - 3 > 16) {
            i2 = (i / 16) * 16;
        }
        this.t = i2;
        ZLogger.d("> mBufferCheckMtuSize=" + this.t);
    }

    public void d(int i) {
        sleepInner(1000L);
        ZLogger.d(String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i)));
        UsbGatt usbGatt = this.B;
        if (usbGatt != null) {
            b(usbGatt);
            a(this.B, getDfuConfig().isErrorActionEnabled(2));
            a(this.B);
        }
    }

    @Override // com.realsil.sdk.dfu.w.c, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        this.A = GlobalUsbGatt.getInstance();
    }

    public boolean m() {
        String str;
        if (this.B == null) {
            ZLogger.w("mUsbGatt == null");
            this.mErrorState = 258;
            notifyConnectionLock();
            return false;
        }
        if (this.mAborted) {
            ZLogger.w("task already aborted, ignore");
            return false;
        }
        ZLogger.d(this.DBG, "Attempting to start service discovery...");
        boolean discoverServices = this.B.discoverServices();
        boolean z = this.DBG;
        StringBuilder sb = new StringBuilder();
        sb.append("discoverServices ");
        if (discoverServices) {
            str = "succeed";
        } else {
            str = "failed";
        }
        sb.append(str);
        ZLogger.d(z, sb.toString());
        if (!discoverServices) {
            this.mErrorState = 258;
            notifyConnectionLock();
        }
        return discoverServices;
    }

    public void n() {
        setConnectionState(513);
        if (this.G != null) {
            ZLogger.d("delay to discover service for : 1600");
            this.G.postDelayed(this.H, 1600L);
        } else {
            m();
        }
    }

    public void a(UsbGatt usbGatt) {
        if (usbGatt != null) {
            UsbDevice device = usbGatt.getDevice();
            ZLogger.d(this.DBG, "close gatt connection: " + device.getDeviceName());
            GlobalUsbGatt globalUsbGatt = this.A;
            if (globalUsbGatt != null) {
                globalUsbGatt.closeGatt(device.getDeviceName());
            } else {
                usbGatt.close();
            }
        }
        setConnectionState(1280);
    }

    @TargetApi(23)
    public boolean a(UsbGatt usbGatt, int i) {
        this.mErrorState = 0;
        this.F = false;
        ZLogger.d(this.DBG, "requestMtu: " + i);
        if (!usbGatt.requestMtu(i)) {
            ZLogger.w("requestMtu failed");
            return false;
        }
        try {
            synchronized (this.p) {
                try {
                    if (!this.F && this.mErrorState == 0) {
                        if (this.VDBG) {
                            ZLogger.v("wait mtu request callback for 15000ms");
                        }
                        this.p.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (InterruptedException e) {
            ZLogger.w("requestMtu: Sleeping interrupted, e = " + e);
        }
        if (this.F || this.mErrorState != 0) {
            return true;
        }
        ZLogger.d(this.DBG, "requestMtu No CallBack");
        return false;
    }

    public boolean a(UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, boolean z) throws DfuException {
        return a(this.B, usbGattCharacteristic, bArr, z);
    }

    public final boolean a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, boolean z) throws DfuException {
        return a(usbGatt, usbGattCharacteristic, bArr, bArr != null ? bArr.length : -1, z);
    }

    public boolean a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, int i, boolean z) throws DfuException {
        if (!z && this.mAborted) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
        if (bArr != null && i >= 0) {
            this.C = null;
            this.mWriteRetransFlag = true;
            boolean z2 = false;
            int i2 = 0;
            while (this.mWriteRetransFlag) {
                this.mWriteRequestCompleted = false;
                if (i2 > 0) {
                    ZLogger.d(this.DBG, "re-send command just wait a while");
                    sleepInner(1000L);
                    if (!z && this.mAborted) {
                        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
                    }
                }
                z2 = a(usbGatt, usbGattCharacteristic, bArr, i);
                if (z2) {
                    synchronized (this.j) {
                        try {
                            if (!this.mWriteRequestCompleted && this.mConnectionState == 515) {
                                this.j.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                            }
                        } catch (InterruptedException e) {
                            ZLogger.w("mWriteLock Sleeping interrupted,e:" + e);
                            if (this.mErrorState == 0) {
                                this.mErrorState = 259;
                            }
                        }
                    }
                    if (this.mErrorState == 0 && !this.mWriteRequestCompleted) {
                        ZLogger.w("send command but no callback");
                        this.mErrorState = 261;
                    }
                } else {
                    ZLogger.w("writePacket failed");
                    this.mErrorState = 267;
                    z2 = false;
                }
                if (this.mErrorState != 0 || i2 <= 3) {
                    i2++;
                } else {
                    ZLogger.w("send command reach max try time");
                    this.mErrorState = 268;
                }
                if (this.mErrorState != 0) {
                    throw new OtaException("Error while send command", this.mErrorState);
                }
            }
            return z2;
        }
        ZLogger.w("value == null || size < 0");
        return false;
    }

    public final boolean a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, int i) {
        if (usbGatt == null) {
            ZLogger.w("gatt == null");
            return false;
        }
        if (usbGattCharacteristic == null) {
            ZLogger.w("characteristic == null");
            return false;
        }
        if (bArr.length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "[TX] WRITE_TYPE_0x%02X, %s << (%d)%s", Integer.valueOf(usbGattCharacteristic.getWriteType()), usbGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
        }
        usbGattCharacteristic.setValue(bArr);
        return usbGatt.writeCharacteristic(usbGattCharacteristic);
    }

    public byte[] a(UsbGattCharacteristic usbGattCharacteristic) throws DfuException {
        return a(this.B, usbGattCharacteristic);
    }

    public byte[] a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic) throws DfuException {
        if (this.mAborted) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
        if (usbGatt == null) {
            ZLogger.w("gatt == null");
            return null;
        }
        this.mErrorState = 0;
        this.mReadRxData = null;
        this.mReadRequestCompleted = false;
        if (usbGatt.readCharacteristic(usbGattCharacteristic)) {
            synchronized (this.mReadLock) {
                try {
                    if (this.mErrorState == 0 && !this.mReadRequestCompleted && this.mConnectionState == 515) {
                        this.mReadLock.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                    }
                } catch (InterruptedException e) {
                    ZLogger.w("sleeping interrupted:" + e);
                    this.mErrorState = 259;
                }
            }
            if (this.mErrorState == 0 && !this.mReadRequestCompleted) {
                ZLogger.w("read value but no callback");
                this.mErrorState = 261;
            }
        } else {
            ZLogger.w("readCharacteristic failed");
            this.mErrorState = 279;
        }
        if (this.mErrorState == 0) {
            return this.mReadRxData;
        }
        throw new OtaException("Error while send command", this.mErrorState);
    }
}
