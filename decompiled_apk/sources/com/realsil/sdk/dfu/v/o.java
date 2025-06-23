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
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes11.dex */
public class o extends m {
    public o(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
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
        byte[] a2 = a((short) 1547);
        if (a2 != null && a2.length > 0) {
            getOtaDeviceInfo().setRwsUpdateFlag(a2[0] & 1);
        } else {
            getOtaDeviceInfo().setRwsUpdateFlag(0);
        }
    }

    public boolean H() {
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
            int J = J();
            if (J == 0) {
                return false;
            }
            if (J == 2) {
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
        this.mOtaDeviceInfo = new OtaDeviceInfo(17, 2);
        C();
        if (getOtaDeviceInfo().isRwsEnabled()) {
            if (getOtaDeviceInfo().specVersion >= 6) {
                if (this.M && getOtaDeviceInfo().getBudRole() != this.L) {
                    throw new OtaException("role swap failed", 283);
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

    public final int J() throws DfuException {
        if (!K()) {
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
            return 2;
        }
        ZLogger.d("has pendding image file to upload");
        a(getDfuProgressInfo().getCurImageId(), (byte) 0);
        return 1;
    }

    public final boolean K() throws DfuException {
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return false;
        }
        if (getOtaDeviceInfo().isAesEncryptEnabled() && !b()) {
            b(4113);
            return false;
        }
        notifyStateChanged(521);
        ZLogger.d(this.DBG, String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        ZLogger.v(this.DBG, getDfuProgressInfo().toString());
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
        i(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
        }
        ZLogger.v(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        if (this.mImageUpdateOffset == 0) {
            a((byte) 1);
        }
        if (this.mImageUpdateOffset >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.d(this.DBG, "Last send reach the bottom");
        } else {
            k(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                d(this.mCurBinInputStream);
            } else {
                c(this.mCurBinInputStream);
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

    public final void c(BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
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
                        getDfuProgressInfo().addImageSizeInBytes(12);
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

    /* JADX WARN: Code restructure failed: missing block: B:74:0x004c, code lost:
    
        if (r13 != getDfuProgressInfo().getBytesSent()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b A[Catch: IOException -> 0x01f9, TryCatch #0 {IOException -> 0x01f9, blocks: (B:71:0x003f, B:73:0x0044, B:10:0x0077, B:12:0x007b, B:13:0x00c4, B:15:0x00e1, B:16:0x00ff, B:18:0x0102, B:68:0x00a2, B:69:0x00b2, B:9:0x004e), top: B:70:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e1 A[Catch: IOException -> 0x01f9, TryCatch #0 {IOException -> 0x01f9, blocks: (B:71:0x003f, B:73:0x0044, B:10:0x0077, B:12:0x007b, B:13:0x00c4, B:15:0x00e1, B:16:0x00ff, B:18:0x0102, B:68:0x00a2, B:69:0x00b2, B:9:0x004e), top: B:70:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0102 A[Catch: IOException -> 0x01f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f9, blocks: (B:71:0x003f, B:73:0x0044, B:10:0x0077, B:12:0x007b, B:13:0x00c4, B:15:0x00e1, B:16:0x00ff, B:18:0x0102, B:68:0x00a2, B:69:0x00b2, B:9:0x004e), top: B:70:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.realsil.sdk.dfu.image.stream.BaseBinInputStream r17) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.o.d(com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXS0011ForceTemp");
            ZLogger.d("ProcessorXS0011ForceTemp is running.");
            innerCheck = innerCheck();
        } catch (Exception e) {
            ZLogger.w(e.toString());
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
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
        ZLogger.d("ProcessorXS0011ForceTemp stopped.");
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
