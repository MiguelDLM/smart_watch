package com.realsil.sdk.dfu.q;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.utils.DfuUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class f extends b {
    public f(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
    }

    public final boolean H() throws DfuException {
        d(this.mOtaDeviceAddress);
        t();
        if (!this.otaEnvironmentPrepared) {
            J();
        } else {
            k();
        }
        if (this.mCurBinInputStream == null) {
            b(4097);
            return false;
        }
        return true;
    }

    public final boolean I() {
        BaseBinInputStream baseBinInputStream;
        notifyStateChanged(514);
        this.mOtaDeviceAddress = this.mDeviceAddress;
        this.otaModeEnabled = true;
        boolean z = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode != 4097 && errCode != 265) {
                    E();
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
            }
            if (!H() || !L()) {
                return false;
            }
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.d("no pendding image file to upload.");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                if (!this.o) {
                    notifyStateChanged(523);
                } else {
                    y();
                    x();
                    notifyStateChanged(258);
                }
                z = true;
            } else {
                ZLogger.v("has pendding image file to upload");
                if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                    this.mOtaDeviceAddress = this.mDeviceAddress;
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    this.otaEnvironmentPrepared = false;
                    y();
                    x();
                    i();
                } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    this.otaEnvironmentPrepared = false;
                    y();
                    b((byte) 1);
                    i();
                }
            }
            sleepInner(1000L);
            if (z) {
                return z;
            }
        }
        a(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void J() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        K();
        A();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public final boolean K() throws DfuException {
        if (!this.mAborted) {
            ZLogger.d(String.format(Locale.US, "<< OPCODE_DFU_DEVICE_INFO (0x%02X)", (byte) 13));
            a(this.X, new byte[]{13}, false);
            if (this.DBG) {
                ZLogger.d("... waiting OPCODE_DFU_DEVICE_INFO response");
            }
            byte[] q = q();
            if (q[2] == 1) {
                getOtaDeviceInfo().parseX0000(q, 3);
                return true;
            }
            ZLogger.e("Get dev info failed");
            throw new OtaException("get remote dev info failed", 270);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final boolean L() throws DfuException {
        if (!w()) {
            return false;
        }
        if (getOtaDeviceInfo().icType <= 3) {
            if (getDfuConfig().isConParamUpdateLatencyEnabled()) {
                sleepInner(getDfuConfig().getLatencyTimeout() * 1000);
            }
            this.r = D();
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
                this.r = z();
            }
            if (this.DBG) {
                ZLogger.v("mRemoteOtaFunctionInfo=" + this.r);
            }
        }
        getDfuProgressInfo().start();
        g(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
            ZLogger.d(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (this.mImageUpdateOffset == 0) {
            F();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.d("Last send reach the bottom");
        } else if (getOtaDeviceInfo().icType <= 3) {
            j(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                b(this.H, this.Y, this.mCurBinInputStream);
            } else {
                c(this.H, this.Y, this.mCurBinInputStream);
            }
        } else if (getOtaDeviceInfo().icType != 4 && getOtaDeviceInfo().icType != 6 && getOtaDeviceInfo().icType != 7 && getOtaDeviceInfo().icType != 8 && getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 10 && getOtaDeviceInfo().icType != 11 && getOtaDeviceInfo().icType != 12) {
            h(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                a(this.H, this.Y, this.mCurBinInputStream);
            } else {
                d(this.H, this.Y, this.mCurBinInputStream);
            }
        } else {
            h(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                a(this.H, this.Y, this.mCurBinInputStream);
            } else {
                d(this.H, this.Y, this.mCurBinInputStream);
            }
        }
        this.C[getDfuProgressInfo().getCurrentFileIndex()] = this.mCurBinInputStream.getImageId();
        getDfuProgressInfo().sendOver();
        i(getDfuProgressInfo().getCurImageId());
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
                ZLogger.e("Something error in OTA process, errorCode: " + a2 + "mProcessState" + this.mProcessState);
                a(a2, true);
                return false;
            }
        }
        if (z) {
            try {
                y();
                x();
                notifyStateChanged(258);
            } catch (DfuException e) {
                b(e.getErrCode());
            }
        } else {
            if (E()) {
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
                a(baseBinInputStream);
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
        c();
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                a(baseBinInputStream);
                if (this.DBG) {
                    ZLogger.v(getDfuProgressInfo().toString());
                }
                startSpeedControl();
                try {
                    int read = baseBinInputStream.read(bArr, i);
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        if (this.DBG) {
                            ZLogger.v("reach the end of the file, only read some");
                        }
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
                    a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i2, false);
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
            notifyStateChanged(516);
            int a2 = a(str, getDfuConfig().getRetransConnectTimes());
            if (a2 == 0) {
                return;
            }
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
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXG0000SNoTemp");
            ZLogger.d("ProcessorXG0000SNoTemp running.");
            innerCheck = innerCheck();
        } catch (Exception e) {
            ZLogger.w(e.toString());
            b(0);
        }
        if (innerCheck != 0) {
            b(innerCheck);
            return;
        }
        I();
        closeInputStream(this.mCurBinInputStream);
        if (this.DBG) {
            ZLogger.d("GattDfuTaskX0000 stopped");
        }
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    public final void j(int i) throws DfuException {
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
        if (this.DBG) {
            ZLogger.v(getDfuProgressInfo().toString());
        }
    }

    @Override // com.realsil.sdk.dfu.j.b
    public void k() {
        int maxFileCount = getDfuProgressInfo().getMaxFileCount();
        int nextFileIndex = getDfuProgressInfo().getNextFileIndex();
        if (nextFileIndex < 0 || nextFileIndex >= maxFileCount) {
            ZLogger.d("invalid FileIndex: " + nextFileIndex + ", reset to 0");
            nextFileIndex = 0;
        }
        getDfuProgressInfo().setCurrentFileIndex(nextFileIndex);
        Iterator<BaseBinInputStream> it = this.pendingImageInputStreams.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BaseBinInputStream next = it.next();
            if (DfuUtils.binarySearch(this.C, next.getImageId()) >= 0) {
                ZLogger.d(String.format("ignore 0x%04X, alreay ota", Integer.valueOf(next.getImageId())));
            } else if (next.getImageId() == getOtaDeviceInfo().getNoTempImageId()) {
                ZLogger.d(String.format("find NoTempImageId: 0x%04X", Integer.valueOf(next.getImageId())));
                this.mCurBinInputStream = next;
                break;
            }
        }
        BaseBinInputStream baseBinInputStream = this.mCurBinInputStream;
        if (baseBinInputStream != null) {
            if (this.DBG) {
                ZLogger.v(String.format("mCurBinInputStream's binId=0x%04X", Integer.valueOf(baseBinInputStream.getBinId())));
            }
            getDfuProgressInfo().initialize(this.mCurBinInputStream.getBinId(), this.mCurBinInputStream.getImageId(), this.mCurBinInputStream.getImageVersion(), this.mCurBinInputStream.remainSizeInBytes(), getDfuConfig().isThroughputEnabled());
        } else {
            ZLogger.v(this.VDBG, "mCurBinInputStream == null");
        }
        this.mNextBinInputStream = null;
        this.mNextBinIndex = -1;
    }

    @Override // com.realsil.sdk.dfu.j.b
    public void l() throws LoadFileException {
        closeInputStream(this.mCurBinInputStream);
        List<BaseBinInputStream> loadImageFile = FirmwareLoaderX.loadImageFile(new LoadParams.Builder().preferredIcType(getDfuConfig().getPrimaryIcType()).fileLocation(getDfuConfig().getFileLocation()).setFilePath(this.m).setFileSuffix(getDfuConfig().getFileSuffix()).with(this.mContext).setFileIndicator(this.n).vpId(getDfuConfig().getVpId()).setWorkMode(getDfuConfig().getOtaWorkMode()).setOtaDeviceInfo(getOtaDeviceInfo()).setIcCheckEnabled(getDfuConfig().isIcCheckEnabled()).setSectionSizeCheckEnabled(getDfuConfig().isSectionSizeCheckEnabled()).versionCheckEnabled(getDfuConfig().isVersionCheckEnabled(), getDfuConfig().getVersionCheckMode()).build());
        this.pendingImageInputStreams = new ArrayList();
        if (loadImageFile != null && loadImageFile.size() > 0) {
            Iterator<BaseBinInputStream> it = loadImageFile.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseBinInputStream next = it.next();
                if (this.VDBG) {
                    ZLogger.d(String.format("0x%04X, 0x%04X", Integer.valueOf(next.getImageId()), Integer.valueOf(getOtaDeviceInfo().getNoTempImageId())));
                }
                if (next.getImageId() == getOtaDeviceInfo().getNoTempImageId()) {
                    this.pendingImageInputStreams.add(next);
                    break;
                }
            }
        }
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list != null && list.size() > 0) {
            if (getDfuProgressInfo().getNextFileIndex() == 0) {
                this.C = new int[this.pendingImageInputStreams.size()];
            }
            getDfuProgressInfo().setMaxFileCount(this.pendingImageInputStreams.size());
            if (this.DBG) {
                ZLogger.v(getDfuProgressInfo().toString());
            }
            k();
            this.imageFileLoaded = true;
            return;
        }
        ZLogger.w("pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
        throw new LoadFileException("no available file to update", 4097);
    }

    public final void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
        ZLogger.v("uploadFirmwareImageForBeeUpdate");
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
}
