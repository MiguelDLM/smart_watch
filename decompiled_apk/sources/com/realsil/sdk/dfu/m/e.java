package com.realsil.sdk.dfu.m;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes11.dex */
public class e extends d {
    public e(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
    }

    public final int I() {
        if (this.P == null) {
            ZLogger.w("OTA SERVICE not found:" + this.O.toString());
            return 262;
        }
        if (this.Q == null) {
            ZLogger.w("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + g.f19574a.toString());
            return 263;
        }
        return 0;
    }

    public final boolean J() throws DfuException {
        if (this.mOtaWorkMode == 0) {
            if (this.otaModeEnabled) {
                if (TextUtils.isEmpty(this.mOtaDeviceAddress)) {
                    n();
                }
                d(this.mOtaDeviceAddress);
                if (!this.otaEnvironmentPrepared) {
                    L();
                } else {
                    k();
                }
                if (this.mCurBinInputStream == null) {
                    b(4097);
                    return false;
                }
            } else {
                e(this.mOtaDeviceAddress);
                int I = I();
                if (I == 0) {
                    if (!this.otaEnvironmentPrepared) {
                        L();
                    } else {
                        k();
                    }
                    if (this.mCurBinInputStream == null) {
                        b(4097);
                        return false;
                    }
                    if (!a(g.i)) {
                        b(280);
                        return false;
                    }
                    n();
                    d(this.mOtaDeviceAddress);
                } else {
                    throw new OtaException("load ota service failed", I);
                }
            }
            t();
            this.otaModeEnabled = true;
        } else {
            e(this.mOtaDeviceAddress);
            t();
            if (!this.otaEnvironmentPrepared) {
                L();
            } else {
                k();
            }
            if (this.mCurBinInputStream == null) {
                b(4097);
                return false;
            }
        }
        return true;
    }

    public final boolean K() {
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
                    F();
                    if (this.mOtaWorkMode == 0) {
                        waitUntilDisconnected();
                    }
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
            }
            if (!J() || !M()) {
                return false;
            }
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.d("no pendding image file to upload.");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                if (!this.o) {
                    notifyStateChanged(523);
                } else {
                    x();
                    notifyStateChanged(258);
                }
                z3 = true;
            } else {
                ZLogger.v("has pendding image file to upload");
                if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                    this.mOtaDeviceAddress = this.mDeviceAddress;
                    int i = this.mOtaWorkMode;
                    if (i != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.otaModeEnabled = z2;
                    this.mBytesSentBuffer = 0;
                    if (i == 18) {
                        this.otaEnvironmentPrepared = false;
                    }
                    x();
                    i();
                } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                    int i2 = this.mOtaWorkMode;
                    if (i2 == 0) {
                        this.mOtaDeviceAddress = null;
                    }
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    if (i2 == 18) {
                        this.otaEnvironmentPrepared = false;
                    }
                    b((byte) 1);
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

    public final void L() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        A();
        if (getOtaDeviceInfo().icType == 5 || getOtaDeviceInfo().icType == 9 || getOtaDeviceInfo().icType == 4 || getOtaDeviceInfo().icType == 6 || getOtaDeviceInfo().icType == 7 || getOtaDeviceInfo().icType == 8 || getOtaDeviceInfo().icType == 13 || getOtaDeviceInfo().icType == 10 || getOtaDeviceInfo().icType == 11 || getOtaDeviceInfo().icType == 12) {
            B();
        }
        z();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public final boolean M() throws DfuException {
        if (!w()) {
            return false;
        }
        if (getOtaDeviceInfo().specVersion >= 3) {
            y();
        }
        if (getOtaDeviceInfo().icType <= 3) {
            this.r = E();
            if (this.DBG) {
                ZLogger.v("mRemoteOtaFunctionInfo=" + this.r);
            }
            if (this.r == 1) {
                C();
            }
        } else {
            if (this.DBG) {
                ZLogger.d("isBufferCheckEnabled=" + getOtaDeviceInfo().isBufferCheckEnabled());
            }
            if (!getOtaDeviceInfo().isBufferCheckEnabled()) {
                this.r = 0;
            } else {
                this.r = D();
            }
            if (this.DBG) {
                ZLogger.v("mRemoteOtaFunctionInfo=" + this.r);
            }
        }
        if (this.mOtaWorkMode == 0) {
            H();
        }
        getDfuProgressInfo().start();
        if (getOtaDeviceInfo().specVersion == 2) {
            g(getDfuProgressInfo().getCurImageId());
        }
        h(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
            ZLogger.d(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (this.mImageUpdateOffset == 0) {
            G();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.d("Last send reach the bottom");
        } else if (getOtaDeviceInfo().icType <= 3) {
            if (this.mOtaWorkMode == 17) {
                l(getDfuProgressInfo().getCurImageId());
            } else {
                k(getDfuProgressInfo().getCurImageId());
            }
            if (this.r == 1) {
                b(this.H, this.Y, this.mCurBinInputStream);
            } else {
                c(this.H, this.Y, this.mCurBinInputStream);
            }
        } else if (getOtaDeviceInfo().icType != 4 && getOtaDeviceInfo().icType != 6 && getOtaDeviceInfo().icType != 7 && getOtaDeviceInfo().icType != 8 && getOtaDeviceInfo().icType != 13 && getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 10 && getOtaDeviceInfo().icType != 11 && getOtaDeviceInfo().icType != 12) {
            i(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                a(this.H, this.Y, this.mCurBinInputStream);
            } else {
                d(this.H, this.Y, this.mCurBinInputStream);
            }
        } else {
            i(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                a(this.H, this.Y, this.mCurBinInputStream);
            } else {
                d(this.H, this.Y, this.mCurBinInputStream);
            }
        }
        if (this.mOtaWorkMode == 18) {
            this.C[getDfuProgressInfo().getCurrentFileIndex()] = this.mCurBinInputStream.getImageId();
        }
        getDfuProgressInfo().sendOver();
        notifyProcessChanged();
        if (this.mOtaWorkMode == 17) {
            sleepInner(30L);
        }
        j(getDfuProgressInfo().getCurImageId());
        return true;
    }

    public final int a(String str, int i) {
        int i2 = 0;
        while (a()) {
            int c = c(str);
            if (c == 0) {
                return 0;
            }
            if ((c & (-2049)) != 133) {
                b(this.H);
            } else {
                ZLogger.w("connect fail with GATT_ERROR, do not need disconnect");
            }
            a(this.H);
            sleepInner(1600L);
            i2++;
            ZLogger.d(this.DBG, "tryConnectTime=" + i2);
            if (i2 > i) {
                return c;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean activeImage(boolean z) {
        if (!super.activeImage(z)) {
            return false;
        }
        if (this.mConnectionState != 515) {
            if (this.DBG) {
                ZLogger.d("start to re-connect the RCU which going to active image, current state is: " + this.mConnectionState);
            }
            int a2 = a(this.mOtaDeviceAddress, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                ZLogger.w("Something error in OTA process, errorCode: " + a2 + "mProcessState" + this.mProcessState);
                a(a2, true);
                return false;
            }
        }
        if (z) {
            try {
                x();
                notifyStateChanged(258);
            } catch (DfuException e) {
                ZLogger.w(e.toString());
                b(e.getErrCode());
            }
        } else {
            if (F()) {
                waitUntilDisconnected();
            }
            a(274, false);
        }
        return true;
    }

    public final void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int i;
        if (this.DBG) {
            ZLogger.d(String.format(Locale.US, "updateImageWithCheckBufferForBee1, packetSize=%d, mCurrentMaxBufferSize=%d", Integer.valueOf(this.MAX_PACKET_SIZE), Integer.valueOf(this.s)));
        }
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
                if (this.DBG) {
                    ZLogger.v(getDfuProgressInfo().toString());
                }
                try {
                    int read = baseBinInputStream.read(bArr2);
                    if (getDfuProgressInfo().getRemainSizeInBytes() < read) {
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                        if (this.DBG) {
                            ZLogger.d("Reach the bottom of the image,  checkImageBufferSize: " + read);
                        }
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
                            a(bluetoothGatt, bluetoothGattCharacteristic, bArr, min, false);
                            j();
                            i5 += min;
                            bArr3 = bArr3;
                        }
                        byte[] bArr4 = bArr3;
                        if (this.VDBG) {
                            ZLogger.v("pos: " + i5 + ", checkImageBufferSize: " + i3);
                        }
                        boolean f = f(com.realsil.sdk.dfu.a.a.a(bArr2, 0, i3));
                        if (!f) {
                            getDfuProgressInfo().addBytesSent(0 - i3);
                            i = i4 + 1;
                            ZLogger.w("check failed, retransBufferCheckTimes: " + i);
                        } else {
                            i = i4;
                        }
                        b(f);
                        if (i < 3) {
                            if (f) {
                                break;
                            }
                            i4 = i;
                            bArr3 = bArr4;
                        } else {
                            ZLogger.w("Error while buffer check, reach max try times: " + i + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                            throw new OtaException("Error while buffer check", 275);
                        }
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void c(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
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
                if (this.DBG) {
                    ZLogger.v(getDfuProgressInfo().toString());
                }
                startSpeedControl();
                try {
                    if (this.mOtaWorkMode == 17) {
                        int bytesSent = getDfuProgressInfo().getBytesSent();
                        if (bytesSent == 0) {
                            int i2 = this.MAX_PACKET_SIZE;
                            byte[] bArr2 = new byte[i2];
                            baseBinInputStream.read(bArr2, i2 - 12);
                            System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                            System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                            read = this.MAX_PACKET_SIZE;
                        } else if (bytesSent % 256 != 0 && (bytesSent % 256) % 240 == 0) {
                            read = baseBinInputStream.read(bArr, 16);
                        } else {
                            read = baseBinInputStream.readPacket(bArr);
                        }
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        if (this.DBG) {
                            ZLogger.v("reach the end of the file, only read some");
                        }
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
                    a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i3, false);
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

    public final void d(String str) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(520);
            int a2 = a(str, getDfuConfig().getRetransConnectTimes());
            if (a2 == 0) {
                return;
            }
            if (a2 == 4128) {
                throw new OtaException("aborted, connectRemoteDevice failed", a2);
            }
            throw new OtaException("connectOtaRemoteDevice failed", a2);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void e(String str) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(516);
            int a2 = a(str, getDfuConfig().getRetransConnectTimes());
            if (a2 != 0) {
                if (a2 != 4128) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new CompatScanFilter.Builder().setDeviceAddress(str).build());
                    ScannerParams o = o();
                    o.setScanFilters(arrayList);
                    o.setAddressFilter(str);
                    a(o);
                    int a3 = a(str, getDfuConfig().getRetransConnectTimes());
                    if (a3 == 0) {
                        return;
                    }
                    if (a3 == 4128) {
                        throw new OtaException("aborted, connectRemoteDevice failed", a3);
                    }
                    throw new OtaException("connectRemoteDevice failed", a3);
                }
                throw new OtaException("aborted, connectRemoteDevice failed", a2);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorX0012N");
            ZLogger.d("ProcessorX0012N running.");
            innerCheck = innerCheck();
        } catch (Exception e) {
            ZLogger.w(e.toString());
            b(0);
        }
        if (innerCheck != 0) {
            b(innerCheck);
            return;
        }
        K();
        closeInputStream(this.mCurBinInputStream);
        if (this.DBG) {
            ZLogger.d("GattDfuTaskX0000 stopped");
        }
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    public final void k(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            b(i, 12);
        } else {
            b(i, i2);
        }
        if (getDfuProgressInfo().getBytesSent() != this.mImageUpdateOffset) {
            ZLogger.d("mBytesSent != mImageUpdateOffset, reload image bin file");
            this.imageFileLoaded = false;
            l();
            alignmentSendBytes(this.mImageUpdateOffset, false);
        }
        if (this.DBG) {
            ZLogger.v(getDfuProgressInfo().toString());
        }
    }

    public final void l(int i) throws DfuException {
        b(i, this.mImageUpdateOffset);
        if (getDfuProgressInfo().getBytesSent() != this.mImageUpdateOffset) {
            ZLogger.d("mBytesSent != mImageUpdateOffset, reload image bin file");
            l();
            alignmentSendBytes(this.mImageUpdateOffset, false);
        }
        if (getDfuProgressInfo().getBytesSent() != 0) {
            getDfuProgressInfo().addBytesSent(12);
        }
        getDfuProgressInfo().addImageSizeInBytes(12);
        if (this.DBG) {
            ZLogger.d(getDfuProgressInfo().toString());
        }
    }

    public final void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
        ZLogger.v(this.DBG, "uploadFirmwareImageForBeeUpdate");
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
                    if (this.mOtaWorkMode == 17) {
                        int bytesSent = getDfuProgressInfo().getBytesSent();
                        if (bytesSent == 0) {
                            int i2 = this.MAX_PACKET_SIZE;
                            byte[] bArr2 = new byte[i2];
                            baseBinInputStream.read(bArr2, i2 - 12);
                            System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                            System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                            read = this.MAX_PACKET_SIZE;
                        } else if (bytesSent % 256 != 0 && (bytesSent % 256) % 240 == 0) {
                            read = baseBinInputStream.read(bArr, 16);
                        } else {
                            read = baseBinInputStream.readPacket(bArr);
                        }
                    } else if (this.mImageUpdateOffset == 0) {
                        int i3 = this.MAX_PACKET_SIZE;
                        byte[] bArr3 = new byte[i3];
                        baseBinInputStream.read(bArr3, i3 - 12);
                        System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                        System.arraycopy(bArr3, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                        read = this.MAX_PACKET_SIZE;
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        ZLogger.v("reach the end of the file, only read some");
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    int i4 = read;
                    if (i4 <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.i("image file has already been send over");
                            return;
                        }
                        ZLogger.e("Error while reading file with size: " + i4);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i5 = i4; i5 > 0; i5 -= 16) {
                            if (i5 >= 16) {
                                int i6 = i4 - i5;
                                System.arraycopy(this.l.aesEncrypt(bArr, i6, 16), 0, bArr, i6, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i4, false);
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
}
