package com.realsil.sdk.dfu.r;

import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.Locale;

/* loaded from: classes11.dex */
public class g extends f {
    public g(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
    }

    public final int K() {
        if (this.P == null) {
            ZLogger.w("OTA SERVICE not found:" + this.O.toString());
            return 262;
        }
        if (this.Q == null) {
            ZLogger.w("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + j.f19600a.toString());
            return 263;
        }
        return 0;
    }

    public final boolean L() throws DfuException {
        if (this.otaModeEnabled) {
            if (TextUtils.isEmpty(this.mOtaDeviceAddress)) {
                n();
            }
            d(this.mOtaDeviceAddress);
            if (!this.otaEnvironmentPrepared) {
                N();
            } else {
                k();
            }
            if (this.mCurBinInputStream == null) {
                b(4097);
                return false;
            }
        } else {
            e(this.mOtaDeviceAddress);
            int K = K();
            if (K == 0) {
                if (!this.otaEnvironmentPrepared) {
                    N();
                } else {
                    k();
                }
                if (this.mCurBinInputStream == null) {
                    b(4097);
                    return false;
                }
                if (!a(j.e)) {
                    b(280);
                    return false;
                }
                n();
                d(this.mOtaDeviceAddress);
            } else {
                throw new OtaException("load ota service failed", K);
            }
        }
        t();
        this.otaModeEnabled = true;
        return true;
    }

    public final boolean M() {
        int O;
        boolean z = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode != 4097 && errCode != 265) {
                    if (H() && this.mOtaWorkMode == 0) {
                        waitUntilDisconnected();
                    }
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
            }
            if (!L()) {
                return false;
            }
            y();
            int A = A();
            if (A == 2) {
                O = h();
                if (O == 1) {
                    ZLogger.d("validate faild during copy, switch to push flow");
                    O = O();
                }
            } else if (A == 1) {
                O = P();
                if (O == 1) {
                    ZLogger.d("validate faild during skip, switch to push flow");
                    O = O();
                }
            } else if (A == 3) {
                O = P();
                if (O == 1) {
                    ZLogger.d("validate faild during skip, switch to copy flow");
                    O = h();
                    if (O == 1) {
                        ZLogger.d("validate faild during copy, switch to push flow");
                        O = O();
                    }
                }
            } else {
                O = O();
            }
            if (O == 0) {
                return false;
            }
            if (O == 3) {
                z = true;
            }
            sleepInner(1000L);
            if (z) {
                return z;
            }
        }
        a(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void N() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(16, 2);
        D();
        E();
        C();
        F();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public int O() throws DfuException {
        if (!Q()) {
            return 0;
        }
        this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
        if (getDfuProgressInfo().isLastImageFile()) {
            ZLogger.d("no pendding image file to upload.");
            a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
            return 3;
        }
        ZLogger.d(this.DBG, "has pendding image file to upload");
        if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
            a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            this.mOtaDeviceAddress = this.mDeviceAddress;
            this.otaModeEnabled = false;
            this.mBytesSentBuffer = 0;
            x();
            i();
            return 2;
        }
        if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
            BaseBinInputStream baseBinInputStream = this.mNextBinInputStream;
            if (baseBinInputStream != null) {
                if (a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                    a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    this.mOtaDeviceAddress = null;
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    b((byte) 1);
                    i();
                    return 2;
                }
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                return 2;
            }
            a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            return 2;
        }
        a(getDfuProgressInfo().getCurImageId(), (byte) 0);
        return 2;
    }

    public int P() throws DfuException {
        if (!a()) {
            b(DfuException.ERROR_DFU_ABORTED);
            return 0;
        }
        notifyStateChanged(521);
        ZLogger.d(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.mOtaWorkMode), Integer.valueOf(getOtaDeviceInfo().icType)));
        ZLogger.v(getDfuProgressInfo().toString());
        getDfuProgressInfo().start();
        h(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
        }
        ZLogger.v(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        if (this.mImageUpdateOffset == 0) {
            I();
        }
        if (this.mImageUpdateOffset >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.v(this.VDBG, "Last send reach the bottom");
        } else {
            i(getDfuProgressInfo().getCurImageId());
        }
        getDfuProgressInfo().sendOver();
        notifyProcessChanged();
        this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
        if (getDfuProgressInfo().isLastImageFile()) {
            ZLogger.d("no pendding image file to upload.");
            a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
            return 3;
        }
        ZLogger.d(this.DBG, "has pendding image file to upload");
        if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
            a(getDfuProgressInfo().getCurImageId(), (byte) 1);
            this.mOtaDeviceAddress = this.mDeviceAddress;
            this.otaModeEnabled = false;
            this.mBytesSentBuffer = 0;
            x();
            i();
        } else if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
            BaseBinInputStream baseBinInputStream = this.mNextBinInputStream;
            if (baseBinInputStream != null) {
                if (a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                    ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                    a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    this.mOtaDeviceAddress = null;
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    b((byte) 1);
                    i();
                } else {
                    a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                }
            } else {
                a(getDfuProgressInfo().getCurImageId(), (byte) 0);
            }
        } else {
            a(getDfuProgressInfo().getCurImageId(), (byte) 0);
        }
        return 2;
    }

    public final boolean Q() throws DfuException {
        if (!w()) {
            return false;
        }
        G();
        J();
        getDfuProgressInfo().start();
        h(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
            ZLogger.d(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (this.mImageUpdateOffset == 0) {
            I();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.v("Last send reach the bottom");
        } else {
            i(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                b(this.H, this.Y, this.mCurBinInputStream);
            } else {
                a(this.H, this.Y, this.mCurBinInputStream);
            }
        }
        getDfuProgressInfo().sendOver();
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
                ZLogger.w(String.format("Something error in OTA process, errorCode: 0x%04X, mProcessState=0x%04X", Integer.valueOf(a2), Integer.valueOf(this.mProcessState)));
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
            if (H()) {
                waitUntilDisconnected();
            }
            a(274, false);
        }
        return true;
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
                    a(o());
                    if (!this.mAborted) {
                        int a3 = a(str, getDfuConfig().getRetransConnectTimes());
                        if (a3 == 0) {
                            return;
                        }
                        if (a3 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", a3);
                        }
                        throw new OtaException("connectRemoteDevice failed", a3);
                    }
                    throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
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
            setName("ProcessorXG0010N");
            ZLogger.d("ProcessorXG0010N running.");
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
        this.otaModeEnabled = false;
        if (M()) {
            if (!this.o) {
                notifyStateChanged(523);
            } else {
                x();
                notifyStateChanged(258);
            }
        }
        closeInputStream(this.mCurBinInputStream);
        ZLogger.d(this.DBG, "ProcessorXG0010N stopped");
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public int h() throws DfuException {
        BaseBinInputStream baseBinInputStream;
        notifyStateChanged(521);
        getDfuProgressInfo().start();
        if (this.DBG) {
            ZLogger.v("processCopyProcedure ...");
            ZLogger.v(getDfuProgressInfo().toString());
        }
        try {
            f(getDfuProgressInfo().getCurImageId());
            getDfuProgressInfo().sendOver();
            notifyProcessChanged();
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.v(this.VDBG, "no pendding image file to upload");
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                return 3;
            }
            ZLogger.d(this.DBG, "has pendding image file to upload");
            if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                this.mOtaDeviceAddress = this.mDeviceAddress;
                this.otaModeEnabled = false;
                this.mBytesSentBuffer = 0;
                x();
                i();
            } else if (getOtaDeviceInfo().getUpdateMechanism() == 3 && (baseBinInputStream = this.mNextBinInputStream) != null && a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                this.mOtaDeviceAddress = null;
                this.otaModeEnabled = true;
                this.mBytesSentBuffer = 0;
                b((byte) 1);
                i();
            }
            return super.h();
        } catch (DfuException unused) {
            return 1;
        }
    }
}
