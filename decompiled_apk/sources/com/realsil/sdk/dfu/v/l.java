package com.realsil.sdk.dfu.v;

import android.content.Context;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes11.dex */
public class l extends m {
    public QcConfig O;
    public int P;

    public l(Context context, DfuConfig dfuConfig, QcConfig qcConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.P = 0;
        this.O = qcConfig;
    }

    public final boolean F() throws DfuException {
        d(this.mOtaDeviceAddress);
        if (!this.otaEnvironmentPrepared) {
            I();
        } else {
            k();
        }
        if (this.mCurBinInputStream == null) {
            b(4097);
            return false;
        }
        return true;
    }

    public final void G() throws DfuException {
        ZLogger.d(this.DBG, String.format("<< CMD_OTA_GET_OTHER_INFO (0x%04X)", (short) 1547));
        byte[] b = b((short) 1547, (byte[]) null);
        if (b != null && b.length > 0) {
            getOtaDeviceInfo().setRwsUpdateFlag(b[0] & 1);
        } else {
            getOtaDeviceInfo().setRwsUpdateFlag(0);
        }
    }

    public boolean H() {
        int J;
        boolean z = true;
        boolean z2 = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode == 4097) {
                    a(errCode, false);
                } else if (errCode == 287) {
                    a(errCode, false);
                } else {
                    D();
                    b(errCode);
                }
            }
            if (!F()) {
                return false;
            }
            if (z) {
                if (!p()) {
                    ZLogger.d("no need to update");
                    return true;
                }
                z = false;
            }
            q();
            int u = u();
            if (u == 2) {
                J = h();
                if (J == 1) {
                    ZLogger.d("validate faild during copy, switch to push flow");
                    J = J();
                }
            } else if (u == 1) {
                J = K();
                if (J == 1) {
                    ZLogger.d("validate faild during skip, switch to push flow");
                    J = J();
                }
            } else if (u == 3) {
                J = K();
                if (J == 1) {
                    ZLogger.d("validate faild during skip, switch to copy flow");
                    J = h();
                    if (J == 1) {
                        ZLogger.d("validate faild during copy, switch to push flow");
                        J = J();
                    }
                }
            } else {
                J = J();
            }
            if (J == 0) {
                return false;
            }
            if (J == 3) {
                if (getOtaDeviceInfo().isBankEnabled() && getOtaDeviceInfo().specVersion >= 5) {
                    x();
                }
                z2 = true;
            }
            sleepInner(1000L);
            if (z2) {
                return z2;
            }
        }
        b(DfuException.ERROR_DFU_ABORTED);
        return false;
    }

    public final void I() throws DfuException {
        this.otaEnvironmentPrepared = false;
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return;
        }
        notifyStateChanged(517);
        sleepInner(1500L);
        QcConfig qcConfig = this.O;
        if (qcConfig != null) {
            try {
                a((short) 1554, new byte[]{(byte) (qcConfig.getIndicator() & 255)});
            } catch (Exception unused) {
                ZLogger.v("CMD_OTA_TEST error, ignore");
            }
        }
        this.mOtaDeviceInfo = new OtaDeviceInfo(17, 2);
        C();
        if (getOtaDeviceInfo().isRwsEnabled()) {
            if (getOtaDeviceInfo().specVersion >= 6) {
                if (this.M && getOtaDeviceInfo().getBudRole() != this.L) {
                    ZLogger.v(this.VDBG, String.format("hfpState = 0x%02X", Integer.valueOf(BluetoothProfileManager.getInstance().getConnectionState(1, b(this.mDeviceAddress)))));
                    throw new OtaException(String.format("role swap failed, bud role(%d) din't change, target is %d", Integer.valueOf(getOtaDeviceInfo().getBudRole()), Integer.valueOf(this.L)), 283);
                }
            } else {
                G();
                if (getOtaDeviceInfo().getRwsUpdateFlag() != 0) {
                    throw new OtaException("rws state not ready", 282);
                }
            }
        }
        z();
        if (getOtaDeviceInfo().isBankEnabled() && getOtaDeviceInfo().specVersion >= 5) {
            B();
        }
        if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
            A();
        }
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public int J() throws DfuException {
        if (!L()) {
            return 0;
        }
        this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
        if (getDfuProgressInfo().isLastImageFile()) {
            ZLogger.d("no pendding image file to upload.");
            if (getOtaDeviceInfo().specVersion >= 3) {
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            } else {
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            }
            getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
            return 3;
        }
        ZLogger.d("has pendding image file to upload");
        if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
            if (getOtaDeviceInfo().specVersion >= 3) {
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            } else {
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            }
            this.mOtaDeviceAddress = this.mDeviceAddress;
            this.otaModeEnabled = true;
            this.mBytesSentBuffer = 0;
            a(true);
            getDfuProgressInfo().getActiveImageSize();
            a(30000L);
            return 2;
        }
        if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
            BaseBinInputStream baseBinInputStream = this.mNextBinInputStream;
            if (baseBinInputStream != null) {
                if (a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    if (getOtaDeviceInfo().specVersion >= 3) {
                        a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    } else {
                        a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                    }
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    a((byte) 1, true);
                    getDfuProgressInfo().getActiveImageSize();
                    a(30000L);
                    return 2;
                }
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                return 2;
            }
            if (getOtaDeviceInfo().specVersion >= 3) {
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                return 2;
            }
            a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            return 2;
        }
        a(getDfuProgressInfo().getCurImageId(), (byte) 0);
        return 2;
    }

    public int K() throws DfuException {
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return 0;
        }
        notifyStateChanged(521);
        ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        ZLogger.v(getDfuProgressInfo().toString());
        getDfuProgressInfo().start();
        i(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
        }
        ZLogger.v(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        if (this.mImageUpdateOffset == 0) {
            E();
        }
        if (this.mImageUpdateOffset >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.v(this.VDBG, "Last send reach the bottom");
        } else {
            k(getDfuProgressInfo().getCurImageId());
        }
        getDfuProgressInfo().sendOver();
        notifyProcessChanged();
        this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
        if (getDfuProgressInfo().isLastImageFile()) {
            ZLogger.d("no pendding image file to upload,");
            try {
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                return 3;
            } catch (DfuException unused) {
                getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                return 1;
            }
        }
        ZLogger.d("has pendding image file to upload");
        if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
            try {
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                this.mOtaDeviceAddress = this.mDeviceAddress;
                this.otaModeEnabled = true;
                this.mBytesSentBuffer = 0;
                a(true);
                getDfuProgressInfo().getActiveImageSize();
                a(30000L);
            } catch (DfuException unused2) {
                getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                return 1;
            }
        } else if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
            BaseBinInputStream baseBinInputStream = this.mNextBinInputStream;
            if (baseBinInputStream != null) {
                if (a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    try {
                        a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                        ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                        this.otaModeEnabled = true;
                        this.mBytesSentBuffer = 0;
                        a((byte) 1, true);
                        getDfuProgressInfo().getActiveImageSize();
                        a(30000L);
                    } catch (DfuException unused3) {
                        getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                        return 1;
                    }
                } else {
                    try {
                        a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                    } catch (DfuException unused4) {
                        getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                        return 1;
                    }
                }
            } else {
                try {
                    a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                } catch (DfuException unused5) {
                    getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                    return 1;
                }
            }
        } else {
            try {
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            } catch (DfuException unused6) {
                getDfuProgressInfo().setNextFileIndex(getDfuProgressInfo().getLastFileIndex());
                return 1;
            }
        }
        return 2;
    }

    public final boolean L() throws DfuException {
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return false;
        }
        if (getOtaDeviceInfo().isAesEncryptEnabled() && !b()) {
            b(4113);
            return false;
        }
        notifyStateChanged(521);
        if (this.DBG) {
            ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        }
        ZLogger.v(getDfuProgressInfo().toString());
        i(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled() && this.mImageUpdateOffset != 0) {
            if ((getOtaDeviceInfo().icType == 4 || getOtaDeviceInfo().icType == 6 || getOtaDeviceInfo().icType == 8) && getOtaDeviceInfo().specVersion <= 4) {
                ZLogger.d("clear soc data");
                D();
            }
            this.mImageUpdateOffset = 0;
        }
        ZLogger.v(this.DBG, "isBufferCheckEnabled=" + getOtaDeviceInfo().isBufferCheckEnabled());
        if (!getOtaDeviceInfo().isBufferCheckEnabled()) {
            this.r = 0;
        } else if (t()) {
            this.r = 1;
        } else {
            this.r = 0;
        }
        ZLogger.v(this.DBG, "mRemoteOtaFunctionInfo=" + this.r);
        getDfuProgressInfo().start();
        if (this.mImageUpdateOffset == 0) {
            E();
        }
        if (this.mImageUpdateOffset >= getDfuProgressInfo().getImageSizeInBytes()) {
            boolean z = this.DBG;
            if (z) {
                ZLogger.d(z, "Last send reach the bottom");
            }
        } else {
            k(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                c(this.mCurBinInputStream);
            } else {
                d(this.mCurBinInputStream);
            }
        }
        getDfuProgressInfo().sendOver();
        return true;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void alignmentSendBytes(int i, boolean z) {
        if (i != 0) {
            try {
                int max = Math.max(i - 12, 0);
                byte[] bArr = new byte[getDfuProgressInfo().getImageSizeInBytes()];
                if (z) {
                    this.mCurBinInputStream.read(bArr, max);
                } else {
                    this.mCurBinInputStream.read(bArr, 0, max);
                }
            } catch (IOException e) {
                ZLogger.e(e.toString());
                return;
            }
        }
        getDfuProgressInfo().setBytesSent(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0055, code lost:
    
        if (r13 != getDfuProgressInfo().getBytesSent()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0082 A[Catch: IOException -> 0x020b, TryCatch #0 {IOException -> 0x020b, blocks: (B:70:0x0048, B:72:0x004d, B:10:0x007e, B:12:0x0082, B:13:0x00cb, B:15:0x00e8, B:16:0x0106, B:18:0x0109, B:67:0x00a9, B:68:0x00b9, B:9:0x0057), top: B:69:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e8 A[Catch: IOException -> 0x020b, TryCatch #0 {IOException -> 0x020b, blocks: (B:70:0x0048, B:72:0x004d, B:10:0x007e, B:12:0x0082, B:13:0x00cb, B:15:0x00e8, B:16:0x0106, B:18:0x0109, B:67:0x00a9, B:68:0x00b9, B:9:0x0057), top: B:69:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0109 A[Catch: IOException -> 0x020b, TRY_LEAVE, TryCatch #0 {IOException -> 0x020b, blocks: (B:70:0x0048, B:72:0x004d, B:10:0x007e, B:12:0x0082, B:13:0x00cb, B:15:0x00e8, B:16:0x0106, B:18:0x0109, B:67:0x00a9, B:68:0x00b9, B:9:0x0057), top: B:69:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.realsil.sdk.dfu.image.stream.BaseBinInputStream r18) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.l.c(com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    public final void d(BaseBinInputStream baseBinInputStream) throws DfuException {
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
                ZLogger.v(getDfuProgressInfo().toString());
                try {
                    if (getDfuProgressInfo().getBytesSent() == 0) {
                        int i2 = this.MAX_PACKET_SIZE;
                        byte[] bArr2 = new byte[i2];
                        baseBinInputStream.read(bArr2, i2 - 12);
                        System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                        read = this.MAX_PACKET_SIZE;
                        getDfuProgressInfo().setBytesSent(0);
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        ZLogger.v(this.DBG, "reach the end of the file, only read some");
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    if (read <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.i("image file has already been send over");
                            return;
                        }
                        ZLogger.e("Error while reading file with size: " + read);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i3 = read; i3 > 0; i3 -= 16) {
                            if (i3 >= 16) {
                                int i4 = read - i3;
                                System.arraycopy(this.l.aesEncrypt(bArr, i4, 16), 0, bArr, i4, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    if (a((short) 1539, bArr, read)) {
                        getDfuProgressInfo().addBytesSent(read);
                        notifyProcessChanged();
                    }
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

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXS0011");
            ZLogger.d("ProcessorXS0011 running.");
            innerCheck = innerCheck();
        } catch (DfuException e) {
            ZLogger.w(e.toString());
            b(e.getErrCode());
        } catch (Exception e2) {
            ZLogger.w(e2.toString());
            b(0);
        }
        if (innerCheck != 0) {
            b(innerCheck);
            return;
        }
        notifyStateChanged(514);
        this.mOtaDeviceAddress = this.mDeviceAddress;
        this.otaModeEnabled = true;
        this.mBytesSentBuffer = 0;
        this.M = false;
        if (H()) {
            if (getOtaDeviceInfo().isRwsEnabled()) {
                y();
                ZLogger.d("start to upload secondary bud ...");
                this.otaModeEnabled = true;
                this.otaEnvironmentPrepared = false;
                this.mBytesSentBuffer = 0;
                if (H()) {
                    if (!this.o) {
                        notifyStateChanged(523);
                    } else {
                        a(true);
                        if (getDfuConfig().isCompleteActionEnabled(1)) {
                            BluetoothProfileManager.getInstance().disconnectA2dpSource(this.z.getRemoteDevice(this.mOtaDeviceAddress));
                            BluetoothProfileManager.getInstance().disconnectHfp(this.mOtaDeviceAddress);
                        }
                        notifyStateChanged(258);
                    }
                }
            } else if (!this.o) {
                notifyStateChanged(523);
            } else {
                a(true);
                if (getDfuConfig().isCompleteActionEnabled(1)) {
                    BluetoothProfileManager.getInstance().disconnectA2dpSource(this.z.getRemoteDevice(this.mOtaDeviceAddress));
                    BluetoothProfileManager.getInstance().disconnectHfp(this.mOtaDeviceAddress);
                }
                notifyStateChanged(258);
            }
        }
        closeInputStream(this.mCurBinInputStream);
        ZLogger.d(this.DBG, "DfuThread stopped");
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    @Override // com.realsil.sdk.dfu.t.b, com.realsil.sdk.dfu.j.b
    public void k() {
        int maxFileCount = getDfuProgressInfo().getMaxFileCount();
        int nextFileIndex = getDfuProgressInfo().getNextFileIndex();
        if (nextFileIndex < 0 || nextFileIndex >= maxFileCount) {
            ZLogger.v("invalid FileIndex: " + nextFileIndex + ", reset to 0");
            nextFileIndex = 0;
        }
        getDfuProgressInfo().setCurrentFileIndex(nextFileIndex);
        BaseBinInputStream baseBinInputStream = this.pendingImageInputStreams.get(nextFileIndex);
        this.mCurBinInputStream = baseBinInputStream;
        if (baseBinInputStream != null) {
            if (this.DBG) {
                ZLogger.v(String.format("mCurBinInputStream's binId=0x%04X", Integer.valueOf(baseBinInputStream.getBinId())));
            }
            getDfuProgressInfo().initialize(this.mCurBinInputStream.getBinId(), this.mCurBinInputStream.getImageId(), this.mCurBinInputStream.getImageVersion(), this.mCurBinInputStream.remainSizeInBytes() + 12, getDfuConfig().isThroughputEnabled());
        } else {
            ZLogger.v(this.VDBG, "mCurBinInputStream == null");
        }
        int i = nextFileIndex + 1;
        if (i < maxFileCount) {
            this.mNextBinInputStream = this.pendingImageInputStreams.get(i);
            this.mNextBinIndex = i;
        } else {
            this.mNextBinInputStream = null;
            this.mNextBinIndex = -1;
        }
    }
}
