package com.realsil.sdk.dfu.p;

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
public final class d extends c {
    public d(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
    }

    public final int H() {
        if (this.P == null) {
            ZLogger.w("OTA SERVICE not found:" + this.O.toString());
            return 262;
        }
        if (this.Q == null) {
            ZLogger.w("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + f.f19589a.toString());
            return 263;
        }
        return 0;
    }

    public final boolean I() throws DfuException {
        if (this.otaModeEnabled) {
            if (TextUtils.isEmpty(this.mOtaDeviceAddress)) {
                a(true);
            }
            e(this.mOtaDeviceAddress);
            if (!this.otaEnvironmentPrepared) {
                K();
            } else {
                k();
            }
            if (this.mCurBinInputStream == null) {
                b(4097);
                return false;
            }
        } else {
            d(this.mOtaDeviceAddress);
            int H = H();
            if (H == 0) {
                if (!this.otaEnvironmentPrepared) {
                    K();
                } else {
                    k();
                }
                if (this.mCurBinInputStream == null) {
                    b(4097);
                    return false;
                }
                if (!a(f.d)) {
                    b(280);
                    return false;
                }
                a(true);
                e(this.mOtaDeviceAddress);
            } else {
                throw new OtaException("load ota service failed", H);
            }
        }
        t();
        this.otaModeEnabled = true;
        return true;
    }

    public final boolean J() {
        boolean z = false;
        while (a()) {
            try {
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode != 4097 && errCode != 265) {
                    if (F() && this.mOtaWorkMode == 0) {
                        waitUntilDisconnected();
                    }
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
            }
            if (!I() || !L()) {
                return false;
            }
            this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
            if (getDfuProgressInfo().isLastImageFile()) {
                ZLogger.d("no pendding image file to upload.");
                a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                if (!this.o) {
                    notifyStateChanged(523);
                } else {
                    x();
                    notifyStateChanged(258);
                }
                z = true;
            } else {
                ZLogger.d("has pendding image file to upload");
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
            }
            sleepInner(1000L);
            if (z) {
                return z;
            }
        }
        a(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void K() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(21, 2);
        A();
        B();
        z();
        C();
        if (this.DBG) {
            ZLogger.d(getOtaDeviceInfo().toString());
        }
        l();
        this.otaEnvironmentPrepared = true;
        ZLogger.d("Ota Environment prepared.");
    }

    public final boolean L() throws DfuException {
        if (!w()) {
            return false;
        }
        E();
        M();
        getDfuProgressInfo().start();
        f(getDfuProgressInfo().getCurImageId());
        if (!getDfuConfig().isBreakpointResumeEnabled()) {
            this.mImageUpdateOffset = 0;
            ZLogger.d(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.mImageUpdateOffset)));
        }
        D();
        if (this.mImageUpdateOffset == 0) {
            G();
        }
        if (this.mImageUpdateOffset - 12 >= getDfuProgressInfo().getImageSizeInBytes()) {
            ZLogger.v(this.VDBG, "Last send reach the bottom");
        } else {
            g(getDfuProgressInfo().getCurImageId());
            if (this.r == 1) {
                b(this.H, this.Y, this.mCurBinInputStream);
            } else {
                a(this.H, this.Y, this.mCurBinInputStream);
            }
        }
        getDfuProgressInfo().sendOver();
        return true;
    }

    public final void M() throws DfuException {
        a((byte) 7);
    }

    @Override // com.realsil.sdk.dfu.p.c, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public /* bridge */ /* synthetic */ boolean activeImage(boolean z) {
        return super.activeImage(z);
    }

    public final void e(String str) throws DfuException {
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

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXG0010N");
            ZLogger.d("ProcessorXG0015N running.");
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
        J();
        closeInputStream(this.mCurBinInputStream);
        ZLogger.d(this.DBG, "ProcessorXG0010N stopped");
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
        }
    }
}
