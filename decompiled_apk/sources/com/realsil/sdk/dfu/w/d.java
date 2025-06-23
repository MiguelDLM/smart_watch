package com.realsil.sdk.dfu.w;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Build;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.usb.GlobalUsbGatt;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCallback;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.core.usb.UsbGattImpl;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.q.g;
import com.realsil.sdk.dfu.q.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class d extends f {
    public UsbGattCharacteristic I;
    public UsbGattCharacteristic J;
    public UsbGattCharacteristic K;
    public UsbGattCharacteristic L;
    public UsbGattCharacteristic M;
    public UsbGattCharacteristic N;
    public List<UsbGattCharacteristic> O;
    public UUID P;
    public UUID Q;
    public UsbGattCharacteristic R;
    public UsbGattCharacteristic S;
    public final UsbGattCallback T;

    /* loaded from: classes11.dex */
    public class a extends UsbGattCallback {
        public a() {
        }

        public final synchronized void a(byte[] bArr) {
            byte b;
            boolean z = true;
            synchronized (this) {
                if (bArr != null) {
                    try {
                        if (bArr.length >= 2) {
                            int i = bArr[0] & 255;
                            int i2 = bArr[1] & 255;
                            if (d.this.VDBG) {
                                ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                            }
                            if (i == 16) {
                                if (i2 == 7) {
                                    synchronized (d.this.p) {
                                        ZLogger.d("ignore connection parameters notification");
                                        d.this.C = bArr;
                                        d.this.E = true;
                                        d.this.p.notifyAll();
                                    }
                                } else if (i2 != 8) {
                                    synchronized (d.this.p) {
                                        d.this.C = bArr;
                                        d.this.E = true;
                                        d.this.p.notifyAll();
                                    }
                                } else {
                                    if (bArr.length >= 3) {
                                        b = bArr[2];
                                    } else {
                                        b = 0;
                                    }
                                    ZLogger.d("remote state changed, busyMode=" + ((int) b));
                                    synchronized (d.this.v) {
                                        d dVar = d.this;
                                        if (b != 1) {
                                            z = false;
                                        }
                                        dVar.u = z;
                                        d.this.v.notifyAll();
                                    }
                                }
                            }
                            return;
                        }
                    } finally {
                    }
                }
                ZLogger.w("notification data invalid");
            }
        }

        public void onCharacteristicChanged(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic) {
            a(usbGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, int i) {
            if (i == 0) {
                d.this.mReadRxData = usbGattCharacteristic.getValue();
            } else if (i == 257) {
                d.this.mErrorState = 1157;
                ZLogger.w(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(d.this.mErrorState)));
            } else {
                d.this.mErrorState = i | 1024;
                ZLogger.w(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(d.this.mErrorState)));
            }
            d.this.notifyReadLock();
        }

        public void onCharacteristicWrite(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, int i) {
            byte[] value = usbGattCharacteristic.getValue();
            if (i == 0) {
                d.this.mWriteRetransFlag = false;
                if (d.this.P != null && d.this.P.equals(usbGattCharacteristic.getUuid())) {
                    if (value != null) {
                        d.this.getDfuProgressInfo().addBytesSent(value.length);
                        d.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                }
            } else if (i != 257 && i != 143) {
                d.this.mErrorState = i | 1024;
                ZLogger.w(String.format("Characteristic write error: 0x%04X", Integer.valueOf(d.this.mErrorState)));
            } else if (d.this.P != null && d.this.P.equals(usbGattCharacteristic.getUuid())) {
                if (i == 143) {
                    d.this.mWriteRetransFlag = false;
                    if (value != null) {
                        d.this.getDfuProgressInfo().addBytesSent(value.length);
                        d.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                } else {
                    d.this.mWriteRetransFlag = true;
                    ZLogger.d(d.this.DBG, "write image packet error, status=" + i + ", please retry.");
                }
            }
            d.this.g();
        }

        public void onConnectionStateChange(UsbGatt usbGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    d dVar = d.this;
                    if (dVar.mAborted) {
                        ZLogger.w("task already aborted, ignore");
                        return;
                    } else {
                        if (dVar.mConnectionState == 256) {
                            dVar.n();
                            return;
                        }
                        ZLogger.v("ignore connected state");
                    }
                } else if (i2 == 0) {
                    if (d.this.mProcessState == 521) {
                        d.this.mErrorState = i | 2048;
                        ZLogger.d(d.this.DBG, "disconnect in OTA process, mErrorState: " + d.this.mErrorState);
                        d.this.g();
                    }
                    d.this.setConnectionState(0);
                }
            } else {
                if (i2 == 0) {
                    d.this.setConnectionState(0);
                }
                d.this.mErrorState = i | 2048;
            }
            d.this.notifyConnectionLock();
        }

        public void onMtuChanged(UsbGatt usbGatt, int i, int i2) {
            if (i2 == 0) {
                ZLogger.v(d.this.VDBG, "mtu=" + i);
                if (d.this.getDfuConfig().isMtuUpdateEnabled()) {
                    d dVar = d.this;
                    dVar.MAX_PACKET_SIZE = i;
                    if (dVar.DBG) {
                        ZLogger.d("onMtuChanged MAX_PACKET_SIZE: " + d.this.MAX_PACKET_SIZE);
                    }
                }
            }
            d.this.F = true;
            d.this.e();
        }

        public void onServicesDiscovered(UsbGatt usbGatt, int i) {
            d dVar = d.this;
            if (dVar.mAborted) {
                ZLogger.w("task already aborted, ignore");
                return;
            }
            if (i == 0) {
                try {
                    dVar.P = UUID.fromString(dVar.getDfuConfig().getDfuDataUuid());
                    d dVar2 = d.this;
                    dVar2.Q = UUID.fromString(dVar2.getDfuConfig().getDfuControlPointUuid());
                } catch (Exception e) {
                    ZLogger.w(e.toString());
                }
                d.this.e(usbGatt);
                d.this.d(usbGatt);
                d.this.c(usbGatt);
                d.this.setConnectionState(515);
            } else {
                dVar.mErrorState = i | 2048;
            }
            d.this.notifyConnectionLock();
        }
    }

    public d(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.P = g.b;
        this.Q = g.c;
        this.T = new a();
    }

    public final int A() throws DfuException {
        byte[] b;
        byte b2;
        if (this.R == null) {
            ZLogger.w("no mControlPointCharacteristic found");
            return 0;
        }
        ZLogger.d("<< OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION(0x09)");
        a(this.R, new byte[]{9}, false);
        try {
            ZLogger.d(this.DBG, "Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification");
            b = b(1600L);
            b2 = b[2];
        } catch (DfuException unused) {
            ZLogger.w("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification failed, just think remote is normal function.");
            this.mErrorState = 0;
        }
        if (b2 == 1) {
            ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
            return 1;
        }
        ZLogger.w("reportOtaFunctionVersion failed, status: " + ((int) b2));
        return 0;
    }

    public final boolean B() {
        try {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a(this.R, new byte[]{5}, true);
        } catch (DfuException e) {
            ZLogger.d(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public final void C() throws DfuException {
        ZLogger.v("<< OPCODE_DFU_START_DFU(0x01)");
        byte[] bArr = new byte[16];
        System.arraycopy(this.mCurBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
        byte[] bArr2 = new byte[17];
        bArr2[0] = 1;
        if (getOtaDeviceInfo().isAesEncryptEnabled()) {
            System.arraycopy(this.l.aesEncrypt(bArr, 0, 16), 0, bArr2, 1, 16);
        } else {
            System.arraycopy(bArr, 0, bArr2, 1, 16);
        }
        a(this.R, bArr2, false);
        ZLogger.v(this.DBG, "... Reading OPCODE_DFU_START_DFU(0x01) notification");
        byte b = v()[2];
        if (b == 1) {
            return;
        }
        ZLogger.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public final boolean D() throws DfuException {
        if (!a()) {
            a(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        }
        if (getOtaDeviceInfo().isAesEncryptEnabled() && !b()) {
            b(4113);
            return false;
        }
        notifyStateChanged(521);
        ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        if (this.DBG) {
            ZLogger.v(getDfuProgressInfo().toString());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            a(this.B, 256);
        }
        if (getOtaDeviceInfo().icType <= 3) {
            if (this.mOtaWorkMode == 16 && getDfuConfig().isConParamUpdateLatencyEnabled()) {
                sleepInner(getDfuConfig().getLatencyTimeout() * 1000);
            }
            this.r = A();
            ZLogger.v(this.DBG, "mRemoteOtaFunctionInfo=" + this.r);
            if (this.r == 1) {
                y();
            }
        } else {
            ZLogger.d("isBufferCheckEnabled=" + getOtaDeviceInfo().isBufferCheckEnabled());
            if (!getOtaDeviceInfo().isBufferCheckEnabled()) {
                this.r = 0;
            } else {
                this.r = z();
            }
            ZLogger.v(this.DBG, "mRemoteOtaFunctionInfo=" + this.r);
        }
        getDfuProgressInfo().start();
        f(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
            ZLogger.d(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (this.mImageUpdateOffset == 0) {
            C();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.d("Last send reach the bottom");
        } else if (getOtaDeviceInfo().icType <= 3) {
            h(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                a(this.B, this.S, this.mCurBinInputStream);
            } else {
                c(this.B, this.S, this.mCurBinInputStream);
            }
        } else if (getOtaDeviceInfo().icType != 4 && getOtaDeviceInfo().icType != 6 && getOtaDeviceInfo().icType != 7 && getOtaDeviceInfo().icType != 8 && getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 11 && getOtaDeviceInfo().icType != 12) {
            g(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                b(this.B, this.S, this.mCurBinInputStream);
            } else {
                d(this.B, this.S, this.mCurBinInputStream);
            }
        } else {
            g(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                b(this.B, this.S, this.mCurBinInputStream);
            } else {
                d(this.B, this.S, this.mCurBinInputStream);
            }
        }
        getDfuProgressInfo().sendOver();
        i(getDfuProgressInfo().getCurImageId());
        return true;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean activeImage(boolean z) {
        if (!super.activeImage(z)) {
            return false;
        }
        if (this.mConnectionState != 515) {
            ZLogger.d(this.DBG, "start to re-connect the RCU which going to active image, current state is: " + this.mConnectionState);
            int a2 = a(this.mOtaDeviceAddress, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                ZLogger.e("Something error in OTA process, errorCode: " + a2 + "mProcessState" + this.mProcessState);
                a(a2, true);
                return false;
            }
        }
        if (z) {
            try {
                o();
                notifyStateChanged(258);
            } catch (DfuException e) {
                ZLogger.w(e.toString());
                b(e.getErrCode());
            }
        } else {
            if (B() && !r()) {
                waitUntilDisconnected();
            }
            a(274, false);
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXU0000");
            ZLogger.i("ProcessorXU0000 running.");
            innerCheck = innerCheck();
        } catch (Exception e) {
            ZLogger.w(e.toString());
            b(0);
        }
        if (innerCheck != 0) {
            b(innerCheck);
            return;
        }
        s();
        closeInputStream(this.mCurBinInputStream);
        ZLogger.d(this.DBG, "GattDfuTaskX0000 stopped");
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    @Override // com.realsil.sdk.dfu.w.f, com.realsil.sdk.dfu.w.c, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        try {
            this.P = UUID.fromString(getDfuConfig().getDfuDataUuid());
            this.Q = UUID.fromString(getDfuConfig().getDfuControlPointUuid());
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
        this.initialized = true;
    }

    public final void o() throws DfuException {
        a(new byte[]{4});
    }

    public final int p() {
        if (this.R == null) {
            ZLogger.w("not found DFU_CONTROL_POINT_UUID : " + this.Q.toString());
            return 263;
        }
        ZLogger.v(this.DBG, "find DFU_CONTROL_POINT_UUID: " + this.Q.toString());
        if (this.S == null) {
            ZLogger.w("not found DFU_DATA_UUID :" + this.P.toString());
            return 263;
        }
        ZLogger.v(this.DBG, "find DFU_DATA_UUID: " + this.P.toString());
        return 0;
    }

    public final boolean q() throws DfuException {
        c(this.mOtaDeviceAddress);
        p();
        if (!this.otaEnvironmentPrepared) {
            t();
        } else {
            k();
        }
        if (this.mCurBinInputStream == null) {
            b(4097);
            return false;
        }
        return true;
    }

    public boolean r() {
        if (this.mOtaWorkMode == 16) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        boolean z;
        BaseBinInputStream baseBinInputStream;
        boolean z2;
        notifyStateChanged(514);
        this.mOtaDeviceAddress = this.mDeviceAddress;
        if (this.mOtaWorkMode != 0) {
            z = true;
        } else {
            z = false;
        }
        this.otaModeEnabled = z;
        boolean z3 = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode != 4097 && errCode != 265) {
                    B();
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
            }
            if (!q() || !D()) {
                return false;
            }
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.d("no pendding image file to upload.");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                if (!this.o) {
                    notifyStateChanged(523);
                } else {
                    o();
                    notifyStateChanged(258);
                }
                z3 = true;
            } else {
                ZLogger.d("has pendding image file to upload");
                if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                    this.mOtaDeviceAddress = this.mDeviceAddress;
                    if (this.mOtaWorkMode != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.otaModeEnabled = z2;
                    this.mBytesSentBuffer = 0;
                    o();
                    i();
                } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.i("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    a((byte) 1);
                    i();
                }
            }
            sleepInner(1000L);
            if (z3) {
                return z3;
            }
        }
        a(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void t() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        w();
        if (getOtaDeviceInfo().icType == 5 || getOtaDeviceInfo().icType == 9 || getOtaDeviceInfo().icType == 4 || getOtaDeviceInfo().icType == 6 || getOtaDeviceInfo().icType == 7 || getOtaDeviceInfo().icType == 8 || getOtaDeviceInfo().icType == 11 || getOtaDeviceInfo().icType == 12) {
            x();
        }
        u();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public final void u() throws DfuException {
        int i;
        short s;
        int i2;
        short s2;
        if (getOtaDeviceInfo().specVersion == 0) {
            if (this.L != null) {
                ZLogger.v("read patch version");
                byte[] a2 = a(this.L);
                if (a2 != null) {
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(a2);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        if (getOtaDeviceInfo().icType <= 3) {
                            s2 = wrap.getShort(0);
                        } else {
                            if (getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 12) {
                                s2 = wrap.getShort(0);
                            }
                            i2 = wrap.getInt(0);
                            getOtaDeviceInfo().setPatchVersion(i2);
                        }
                        i2 = s2 & OX00O0xII.f29066Oxx0xo;
                        getOtaDeviceInfo().setPatchVersion(i2);
                    } catch (Exception e) {
                        ZLogger.e(e.toString());
                    }
                }
            }
            if (this.K != null) {
                ZLogger.v("read app version");
                byte[] a3 = a(this.K);
                if (a3 != null) {
                    try {
                        ByteBuffer wrap2 = ByteBuffer.wrap(a3);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        if (getOtaDeviceInfo().icType <= 3) {
                            s = wrap2.getShort(0);
                        } else {
                            if (getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 12) {
                                s = wrap2.getShort(0);
                            }
                            i = wrap2.getInt(0);
                            getOtaDeviceInfo().setAppVersion(i);
                        }
                        i = s & OX00O0xII.f29066Oxx0xo;
                        getOtaDeviceInfo().setAppVersion(i);
                    } catch (Exception e2) {
                        ZLogger.e(e2.toString());
                    }
                }
            }
            if (this.M != null) {
                ZLogger.v("read patch extension version");
                byte[] a4 = a(this.M);
                if (a4 != null) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(a4);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    getOtaDeviceInfo().setPatchExtensionVersion(wrap3.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    return;
                }
                return;
            }
            return;
        }
        List<UsbGattCharacteristic> list = this.O;
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            for (UsbGattCharacteristic usbGattCharacteristic : this.O) {
                if (this.DBG) {
                    ZLogger.v("read image version : " + usbGattCharacteristic.getUuid().toString());
                } else {
                    ZLogger.v("read image version");
                }
                byte[] a5 = a(usbGattCharacteristic);
                if (a5 != null) {
                    if (bArr == null) {
                        bArr = a5;
                    } else {
                        byte[] bArr2 = new byte[bArr.length + a5.length];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        System.arraycopy(a5, 0, bArr2, bArr.length, a5.length);
                        bArr = bArr2;
                    }
                }
            }
            getOtaDeviceInfo().setImageVersionValues(bArr);
            return;
        }
        getOtaDeviceInfo().setImageVersionValues(null);
        ZLogger.d(this.DBG, "no ImageVersionCharacteristics to read");
    }

    public final byte[] v() throws DfuException {
        return b(getDfuConfig().getNotificationTimeout());
    }

    public final boolean w() throws DfuException {
        if (this.N == null) {
            return false;
        }
        ZLogger.v(this.DBG, "start to read remote dev info");
        byte[] a2 = a(this.N);
        if (a2 != null) {
            getOtaDeviceInfo().parseX0000(a2);
            a(getOtaDeviceInfo().maxBufferchecksize);
            return true;
        }
        ZLogger.e("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public final boolean x() throws DfuException {
        if (this.J == null) {
            return false;
        }
        ZLogger.v(this.DBG, "start to read remote dev Mac Addr info");
        byte[] a2 = a(this.J);
        if (a2 != null && a2.length >= 6) {
            byte[] bArr = new byte[6];
            System.arraycopy(a2, 0, bArr, 0, 6);
            getOtaDeviceInfo().setDeviceMac(bArr);
            return true;
        }
        ZLogger.e("Get remote dev Mac Addr info failed, do nothing.");
        throw new OtaException("remote dev Mac Addr info error", 277);
    }

    public final void y() throws DfuException {
        ZLogger.d("<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        a(this.R, new byte[]{10}, false);
        ZLogger.d(this.DBG, "... Reading OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE notification");
        byte[] v = v();
        byte b = v[2];
        if (b == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(v);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = wrap.getInt(3);
            ZLogger.v(String.format(Locale.US, "maxBufferCheckSize=(0x%04X, %d)", Integer.valueOf(i), Integer.valueOf(i)));
            a(i);
            return;
        }
        ZLogger.w("Get remote buffer size info failed, status: " + ((int) b));
        throw new OtaException("Get remote buffer size info failed", b | 512);
    }

    public final int z() throws DfuException {
        if (this.R == null) {
            ZLogger.w("no mControlPointCharacteristic found");
            return 0;
        }
        ZLogger.d("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a(this.R, new byte[]{9}, false);
        try {
            ZLogger.d(this.DBG, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            byte[] b = b(1600L);
            if (b[2] == 1) {
                ByteBuffer wrap = ByteBuffer.wrap(b);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
                int i2 = ((short) (wrap.get(5) & 255)) | (((short) (wrap.get(6) & 255)) << 8);
                ZLogger.v(this.DBG, "maxBufferSize=" + i + ", bufferCheckMtuSize=" + i2);
                a(i);
                c(i2);
                return 1;
            }
        } catch (DfuException unused) {
            ZLogger.w("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
            this.mErrorState = 0;
        }
        return 0;
    }

    public final void d(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
        ZLogger.d(this.DBG, "uploadFirmwareImageForBeeUpdate");
        c();
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                startSpeedControl();
                if (this.DBG) {
                    ZLogger.v(getDfuProgressInfo().toString());
                }
                try {
                    if (this.mImageUpdateOffset == 0) {
                        int i2 = this.MAX_PACKET_SIZE;
                        byte[] bArr2 = new byte[i2];
                        baseBinInputStream.read(bArr2, i2 - 12);
                        System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                        read = this.MAX_PACKET_SIZE;
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        ZLogger.v("reach the end of the file, only read some");
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    int i3 = read;
                    if (i3 <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.i("image file has already been send over");
                            return;
                        }
                        ZLogger.e("Error while reading file with size: " + i3);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i4 = i3; i4 > 0; i4 -= 16) {
                            if (i4 >= 16) {
                                int i5 = i3 - i4;
                                System.arraycopy(this.l.aesEncrypt(bArr, i5, 16), 0, bArr, i5, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    a(usbGatt, usbGattCharacteristic, bArr, i3, false);
                    j();
                    blockSpeedControl();
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void e(UsbGatt usbGatt) {
        UUID uuid = h.b;
        UsbGattCharacteristic characteristic = usbGatt.getCharacteristic(uuid);
        this.J = characteristic;
        if (characteristic == null) {
            ZLogger.d("OTA_MAC_ADDR_CHARACTERISTIC_UUID not found:" + uuid);
        } else if (this.DBG) {
            ZLogger.d("find OTA_MAC_ADDR_CHARACTERISTIC_UUID = " + uuid);
        }
        UUID uuid2 = h.c;
        UsbGattCharacteristic characteristic2 = usbGatt.getCharacteristic(uuid2);
        this.L = characteristic2;
        if (characteristic2 == null) {
            ZLogger.d("OTA_READ_PATCH_CHARACTERISTIC_UUID not found:" + uuid2);
        } else if (this.DBG) {
            ZLogger.d("find OTA_PATCH_VERSION_CHARACTERISTIC_UUID: " + uuid2.toString());
        }
        UUID uuid3 = h.d;
        UsbGattCharacteristic characteristic3 = usbGatt.getCharacteristic(uuid3);
        this.K = characteristic3;
        if (characteristic3 == null) {
            ZLogger.w("OTA_READ_APP_CHARACTERISTIC_UUID not found: " + uuid3);
        } else if (this.DBG) {
            ZLogger.d("find OTA_APP_VERSION_CHARACTERISTIC_UUID: " + uuid3.toString());
        }
        UUID uuid4 = h.e;
        UsbGattCharacteristic characteristic4 = usbGatt.getCharacteristic(uuid4);
        this.M = characteristic4;
        if (characteristic4 == null) {
            ZLogger.w("OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID not found:" + uuid4);
        } else if (this.DBG) {
            ZLogger.d("find OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID: " + uuid4.toString());
        }
        UUID uuid5 = h.g;
        UsbGattCharacteristic characteristic5 = usbGatt.getCharacteristic(uuid5);
        this.N = characteristic5;
        if (characteristic5 == null) {
            ZLogger.w("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found:" + uuid5);
        } else if (this.DBG) {
            ZLogger.d("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID: " + uuid5);
        }
        this.O = new ArrayList();
        for (int i = 65504; i < 65519; i++) {
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            UsbGattCharacteristic characteristic6 = usbGatt.getCharacteristic(fromShortValue);
            if (characteristic6 == null) {
                ZLogger.w(this.DBG, "not found image version characteristic:" + fromShortValue.toString());
                return;
            }
            ZLogger.d(this.DBG, "find image version characteristic: " + fromShortValue.toString());
            this.O.add(characteristic6);
        }
    }

    public final void f(int i) throws DfuException {
        int i2;
        ZLogger.d(this.DBG, "<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        a(this.R, new byte[]{6, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
        ZLogger.d(this.DBG, "... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
        byte[] v = v();
        int length = v != null ? v.length : 0;
        if ((length > 2 ? v[2] : (byte) -2) == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(v);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (length >= 11) {
                i2 = wrap.getShort(3) & OX00O0xII.f29066Oxx0xo;
                this.mImageUpdateOffset = wrap.getInt(7);
            } else if (length >= 9) {
                i2 = wrap.getShort(3) & OX00O0xII.f29066Oxx0xo;
                this.mImageUpdateOffset = wrap.getInt(5);
            } else {
                this.mImageUpdateOffset = 0;
                i2 = 0;
            }
            ZLogger.v(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
            return;
        }
        ZLogger.w(String.format("0x%02X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public final void g(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            this.mImageUpdateOffset = 12;
            ZLogger.d(this.DBG, String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.mImageUpdateOffset)));
        } else {
            ZLogger.d(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        a(i, this.mImageUpdateOffset);
        int bytesSent = getDfuProgressInfo().getBytesSent();
        int i3 = this.mImageUpdateOffset;
        if (bytesSent == i3 || i3 == -1) {
            return;
        }
        ZLogger.d("mBytesSent != mImageUpdateOffset, reload image bin file");
        this.imageFileLoaded = false;
        l();
        alignmentSendBytes(this.mImageUpdateOffset, false);
    }

    public final void h(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            a(i, 12);
        } else {
            a(i, i2);
        }
        if (getDfuProgressInfo().getBytesSent() != this.mImageUpdateOffset) {
            ZLogger.d("mBytesSent != mImageUpdateOffset, reload image bin file");
            this.imageFileLoaded = false;
            l();
            alignmentSendBytes(this.mImageUpdateOffset, false);
        }
        ZLogger.v(getDfuProgressInfo().toString());
    }

    public final void i(int i) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_VALIDATE_FW_IMAGE (0x03)");
        a(this.R, new byte[]{3, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
        ZLogger.d(this.DBG, "... waiting DFU_VALIDATE_FW_IMAGE response");
        byte b = v()[2];
        if (b == 1) {
            return;
        }
        if (b == 5) {
            ZLogger.e(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b)));
            throw new OtaException("Validate FW failed", 517);
        }
        ZLogger.e(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b)));
        throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public final void c(String str) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(516);
            int a2 = a(str, getDfuConfig().getRetransConnectTimes());
            if (a2 == 0) {
                return;
            }
            if (a2 == 4128) {
                throw new OtaException("aborted, connectRemoteDevice failed", a2);
            }
            throw new OtaException("connectRemoteDevice failed", a2);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x005c, code lost:
    
        if (r3 != (getDfuProgressInfo().getBytesSent() + r9)) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[Catch: IOException -> 0x0218, TryCatch #0 {IOException -> 0x0218, blocks: (B:68:0x004e, B:70:0x0053, B:10:0x006b, B:12:0x006f, B:14:0x0084, B:15:0x008b, B:16:0x00be, B:18:0x00db, B:65:0x009c, B:66:0x00ac, B:9:0x005e), top: B:67:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00db A[Catch: IOException -> 0x0218, TRY_LEAVE, TryCatch #0 {IOException -> 0x0218, blocks: (B:68:0x004e, B:70:0x0053, B:10:0x006b, B:12:0x006f, B:14:0x0084, B:15:0x008b, B:16:0x00be, B:18:0x00db, B:65:0x009c, B:66:0x00ac, B:9:0x005e), top: B:67:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009a  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.realsil.sdk.core.usb.UsbGatt r19, com.realsil.sdk.core.usb.UsbGattCharacteristic r20, com.realsil.sdk.dfu.image.stream.BaseBinInputStream r21) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.w.d.b(com.realsil.sdk.core.usb.UsbGatt, com.realsil.sdk.core.usb.UsbGattCharacteristic, com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    public final int a(String str, int i) {
        int i2 = 0;
        while (a()) {
            int b = b(str);
            if (b == 0) {
                return 0;
            }
            if ((b & (-2049)) != 133) {
                b(this.B);
            } else {
                ZLogger.w("connect fail with GATT_ERROR, do not need disconnect");
            }
            a(this.B);
            sleepInner(1600L);
            i2++;
            ZLogger.d(this.DBG, "tryConnectTime=" + i2);
            if (i2 > i) {
                return b;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void c(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        ZLogger.d(this.DBG, "uploadFirmwareImage");
        c();
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                if (this.mOtaWorkMode != 17) {
                    a(baseBinInputStream);
                }
                ZLogger.v(this.DBG, getDfuProgressInfo().toString());
                startSpeedControl();
                try {
                    int read = baseBinInputStream.read(bArr, i);
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        ZLogger.v(this.DBG, "reach the end of the file, only read some");
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    int i2 = read;
                    if (i2 <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.i("image file has already been send over");
                            return;
                        }
                        ZLogger.e("Error while reading file with size: " + i2);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i3 = i2; i3 > 0; i3 -= 16) {
                            if (i3 >= 16) {
                                int i4 = i2 - i3;
                                System.arraycopy(this.l.aesEncrypt(bArr, i4, 16), 0, bArr, i4, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    a(usbGatt, usbGattCharacteristic, bArr, i2, false);
                    j();
                    blockSpeedControl();
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void a(byte b) throws DfuException {
        a(new byte[]{4, b});
    }

    public final void a(byte[] bArr) throws DfuException {
        notifyStateChanged(DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET);
        boolean z = this.mAborted;
        int i = DfuException.ERROR_DFU_ABORTED;
        if (!z) {
            boolean z2 = false;
            try {
                ZLogger.d("<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
                z2 = a(this.R, bArr, false);
            } catch (DfuException e) {
                if (e.getErrCode() != 4128) {
                    if (!getDfuConfig().isWaitActiveCmdAckEnabled()) {
                        ZLogger.d("active cmd has no response, ignore");
                        z2 = true;
                    } else {
                        ZLogger.w("active cmd has no response, notify error");
                        i = e.getErrCode();
                    }
                }
            }
            i = 0;
            if (z2) {
                ZLogger.d("image active success");
                d(this.mErrorState);
                closeInputStream(this.mCurBinInputStream);
                return;
            }
            throw new OtaException(i);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int i;
        ZLogger.d(this.DBG, String.format(Locale.US, "updateImageWithCheckBufferForBee1, packetSize=%d, mCurrentMaxBufferSize=%d", Integer.valueOf(this.MAX_PACKET_SIZE), Integer.valueOf(this.s)));
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i2 = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[this.s];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                if (this.mOtaWorkMode != 17) {
                    a(baseBinInputStream);
                }
                ZLogger.v(this.DBG, getDfuProgressInfo().toString());
                try {
                    int read = baseBinInputStream.read(bArr2);
                    if (getDfuProgressInfo().getRemainSizeInBytes() < read) {
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                        ZLogger.i(this.DBG, "Reach the bottom of the image,  checkImageBufferSize: " + read);
                    }
                    int i3 = read;
                    byte[] bArr3 = new byte[this.s];
                    int i4 = 0;
                    while (true) {
                        int i5 = 0;
                        while (i5 < i3) {
                            int min = Math.min(i2, i3 - i5);
                            System.arraycopy(bArr2, i5, bArr, 0, min);
                            if (getOtaDeviceInfo().isAesEncryptEnabled() && min >= 16) {
                                System.arraycopy(this.l.aesEncrypt(bArr, 0, 16), 0, bArr, 0, 16);
                            } else if (min <= 0) {
                                ZLogger.e("Error while reading file with bufferSize= " + min);
                                throw new OtaException("Error while reading file", 257);
                            }
                            System.arraycopy(bArr, 0, bArr3, i5, min);
                            a(usbGatt, usbGattCharacteristic, bArr, min, false);
                            j();
                            i5 += min;
                            bArr3 = bArr3;
                        }
                        byte[] bArr4 = bArr3;
                        ZLogger.v(this.VDBG, "pos: " + i5 + ", checkImageBufferSize: " + i3);
                        boolean e = e(com.realsil.sdk.dfu.a.a.a(bArr2, 0, i3));
                        if (e) {
                            i = i4;
                        } else {
                            getDfuProgressInfo().addBytesSent(0 - i3);
                            i = i4 + 1;
                            ZLogger.d("check failed, retransBufferCheckTimes: " + i);
                        }
                        a(e);
                        if (i >= 3) {
                            ZLogger.w("Error while buffer check, reach max try times: " + i + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                            throw new OtaException("Error while buffer check", 275);
                        }
                        if (e) {
                            break;
                        }
                        i4 = i;
                        bArr3 = bArr4;
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final boolean e(int i) throws DfuException {
        ZLogger.d(String.format("<< OPCODE_DFU_CHECK_CURRENT_BUFFER(0x0B) , crc=0x%04X", Integer.valueOf(i)));
        a(this.R, new byte[]{11}, false);
        ZLogger.d(this.DBG, "... waiting CHECK_CURRENT_BUFFER response");
        byte[] v = v();
        byte b = v[2];
        if (b == 1) {
            int i2 = ((v[4] << 8) & 65280) | (v[3] & 255);
            if (i2 == i) {
                return true;
            }
            ZLogger.w("CRC check error, local: " + i + ", remote : " + i2);
        } else {
            ZLogger.w("check current buffer failed, status: " + ((int) b));
        }
        return false;
    }

    public final int d(UsbGatt usbGatt) {
        UsbGattCharacteristic characteristic = usbGatt.getCharacteristic(this.Q);
        this.R = characteristic;
        if (characteristic == null) {
            ZLogger.w("not found DFU_CONTROL_POINT_UUID: " + this.Q.toString());
            return 263;
        }
        ZLogger.d(this.DBG, "find DFU_CONTROL_POINT_UUID: " + this.Q.toString());
        this.R.setWriteType(2);
        UsbGattCharacteristic characteristic2 = usbGatt.getCharacteristic(this.P);
        this.S = characteristic2;
        if (characteristic2 == null) {
            ZLogger.w("not found DFU_DATA_UUID: " + this.P.toString());
            return 263;
        }
        ZLogger.d(this.DBG, "find DFU_DATA_UUID: " + this.P.toString());
        this.S.setWriteType(1);
        return 0;
    }

    public final int c(UsbGatt usbGatt) {
        ZLogger.d(this.DBG, "find DEVICE_INFORMATION_SERVICE: " + com.realsil.sdk.dfu.l.g.f19557a.toString());
        UUID uuid = com.realsil.sdk.dfu.l.g.e;
        UsbGattCharacteristic characteristic = usbGatt.getCharacteristic(uuid);
        this.I = characteristic;
        if (characteristic == null) {
            ZLogger.w("DIS_PNP_ID_CHARACTERISTIC not found:" + uuid);
            return 263;
        }
        ZLogger.d(this.DBG, "find DIS_PNP_ID_CHARACTERISTIC: " + uuid.toString());
        return 0;
    }

    public final boolean b(byte[] bArr, int i) throws DfuException {
        if (bArr == null) {
            ZLogger.w("buffer == null");
            return false;
        }
        if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Integer.valueOf(i), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
        }
        short a2 = a(bArr, i);
        ZLogger.d(this.DBG, "<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        a(this.R, new byte[]{10, (byte) (i & 255), (byte) (i >> 8), (byte) (a2 & 255), (byte) ((a2 >> 8) & 255)}, false);
        ZLogger.d(this.DBG, "... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        byte[] v = v();
        byte b = v[2];
        ByteBuffer wrap = ByteBuffer.wrap(v);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.mImageUpdateOffset = wrap.getInt(3);
        ZLogger.d(this.DBG, String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        if (b == 1) {
            return true;
        }
        if (b == 5 || b == 6 || b == 7) {
            return false;
        }
        if (b != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b | 512);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void a(int i, boolean z) {
        if (this.mAborted) {
            i = DfuException.ERROR_DFU_ABORTED;
        }
        if (i != 4128) {
            notifyStateChanged(260, true);
        }
        ZLogger.v(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i), Boolean.valueOf(z)));
        if (z) {
            B();
        }
        closeInputStream(this.mCurBinInputStream);
        if (getDfuConfig().isErrorActionEnabled(1)) {
            d(i);
        }
        DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
        if (dfuThreadCallback != null) {
            dfuThreadCallback.onError(i);
        }
        this.mAborted = true;
    }

    public final void a(boolean z) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        a(this.R, new byte[]{12, !z ? 1 : 0}, false);
    }

    public final void a(int i, int i2) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        a(this.R, new byte[]{2, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, false);
    }

    public final byte[] b(long j) throws DfuException {
        this.mErrorState = 0;
        this.E = true;
        try {
            synchronized (this.p) {
                try {
                    if (this.mErrorState == 0 && this.C == null && this.mConnectionState == 515) {
                        this.E = false;
                        ZLogger.v(this.DBG, "wait for notification, wait for " + j + "ms");
                        this.p.wait(j);
                    }
                    if (this.mErrorState == 0 && !this.E) {
                        ZLogger.w("wait for notification, but not come");
                        this.mErrorState = DfuException.ERROR_NOTIFICATION_NO_RESPONSE;
                    }
                } finally {
                }
            }
        } catch (InterruptedException e) {
            ZLogger.w("readNotificationResponse interrupted, " + e.toString());
            this.mErrorState = 259;
        }
        if (this.mErrorState == 0) {
            return this.C;
        }
        throw new OtaException("Unable to receive notification", this.mErrorState);
    }

    public boolean a(BaseBinInputStream baseBinInputStream, int i, int i2) {
        ZLogger.v(this.DBG, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(baseBinInputStream.remainSizeInBytes()), Integer.valueOf(i), Integer.valueOf(i2)));
        return baseBinInputStream.remainSizeInBytes() + i > i2;
    }

    public final int b(String str) {
        setConnectionState(256);
        this.mErrorState = 0;
        this.isConnectedCallbackCome = false;
        ZLogger.d(this.DBG, "Connecting to device..." + BluetoothHelper.formatAddress(str, true));
        UsbDevice a2 = a(str);
        UsbGatt usbGatt = null;
        if (a2 == null) {
            ZLogger.w("device is null");
            this.B = null;
            return 256;
        }
        GlobalUsbGatt globalUsbGatt = this.A;
        if (globalUsbGatt != null) {
            globalUsbGatt.unRegisterCallback(str, this.T);
            if (this.A.connect(a2, this.mContext, this.T)) {
                usbGatt = this.A.getBluetoothGatt(str);
                this.B = usbGatt;
                try {
                    synchronized (this.mConnectionLock) {
                        try {
                            if (!this.isConnectedCallbackCome && this.mErrorState == 0) {
                                ZLogger.d(this.DBG, "wait for connect gatt for " + getDfuConfig().getConnectionTimeout() + " ms");
                                this.mConnectionLock.wait(getDfuConfig().getConnectionTimeout());
                            }
                        } finally {
                        }
                    }
                } catch (InterruptedException e) {
                    ZLogger.w("Sleeping interrupted : " + e.toString());
                    this.mErrorState = 259;
                }
            } else {
                this.mErrorState = 256;
            }
        } else {
            usbGatt = UsbGattImpl.connectGatt(a2, this.mContext, this.T);
            this.B = usbGatt;
            try {
                synchronized (this.mConnectionLock) {
                    try {
                        if (!this.isConnectedCallbackCome && this.mErrorState == 0) {
                            ZLogger.d(this.DBG, "wait for connect gatt for " + getDfuConfig().getConnectionTimeout() + " ms");
                            this.mConnectionLock.wait(getDfuConfig().getConnectionTimeout());
                        }
                    } finally {
                    }
                }
            } catch (InterruptedException e2) {
                ZLogger.w("sleeping interrupted:" + e2);
                this.mErrorState = 259;
            }
        }
        if (this.mErrorState == 0) {
            if (!this.isConnectedCallbackCome) {
                ZLogger.w("wait for connect, but can not connect with no callback");
                this.mErrorState = 260;
            } else if (usbGatt == null || this.mConnectionState != 515) {
                ZLogger.w("connect with some error, please check. mConnectionState=" + this.mConnectionState);
                this.mErrorState = 264;
            }
        }
        if (this.mErrorState == 0) {
            ZLogger.v(this.DBG, "connected the device which going to upgrade");
        }
        return this.mErrorState;
    }
}
