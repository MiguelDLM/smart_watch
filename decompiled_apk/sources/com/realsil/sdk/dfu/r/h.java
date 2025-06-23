package com.realsil.sdk.dfu.r;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.SpecScanRecord;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes11.dex */
public class h extends f {
    public h(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
    }

    public final boolean K() throws DfuException {
        d(this.mOtaDeviceAddress);
        t();
        if (!this.otaEnvironmentPrepared) {
            M();
        } else {
            k();
        }
        if (this.mCurBinInputStream == null) {
            b(4097);
            return false;
        }
        return true;
    }

    public final boolean L() {
        while (a()) {
            try {
                if (!K() || !N()) {
                    return false;
                }
                this.mBytesSentBuffer += getDfuProgressInfo().getBytesSent();
                if (getDfuProgressInfo().isLastImageFile()) {
                    ZLogger.d("no pendding image file to upload.");
                    a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    getDfuProgressInfo().setActiveImageSize(this.mBytesSentBuffer);
                    return true;
                }
                ZLogger.d(this.DBG, "has pendding image file to upload");
                if (getOtaDeviceInfo().getUpdateMechanism() == 1) {
                    a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    this.mOtaDeviceAddress = this.mDeviceAddress;
                    this.otaModeEnabled = true;
                    this.mBytesSentBuffer = 0;
                    x();
                    i();
                } else if (getOtaDeviceInfo().getUpdateMechanism() == 3) {
                    BaseBinInputStream baseBinInputStream = this.mNextBinInputStream;
                    if (baseBinInputStream != null) {
                        if (a(baseBinInputStream, this.mBytesSentBuffer, getOtaDeviceInfo().otaTempBufferSize * 4096)) {
                            a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                            ZLogger.d("make device to enter the ota advertiser mode, and let the app continue update image");
                            this.otaModeEnabled = true;
                            this.mBytesSentBuffer = 0;
                            b((byte) 1);
                            i();
                        } else {
                            a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                        }
                    } else {
                        a(getDfuProgressInfo().getCurImageId(), (byte) 1);
                    }
                } else {
                    a(getDfuProgressInfo().getCurImageId(), (byte) 0);
                }
                sleepInner(1000L);
            } catch (DfuException e) {
                ZLogger.w(DfuConstants.parseOtaState(this.mProcessState) + ", " + e.toString());
                int errCode = e.getErrCode();
                if (errCode == 4128) {
                    a(errCode, true);
                } else if (errCode != 4097 && errCode != 265) {
                    H();
                    a(errCode, false);
                } else {
                    a(errCode, false);
                }
                return false;
            }
        }
        a(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void M() throws DfuException {
        this.otaEnvironmentPrepared = false;
        notifyStateChanged(517);
        sleepInner(1500L);
        this.mOtaDeviceInfo = new OtaDeviceInfo(16, 2);
        D();
        if (getOtaDeviceInfo().isRwsEnabled() && getOtaDeviceInfo().getRwsUpdateFlag() != 0) {
            throw new OtaException("rws state not ready", 282);
        }
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

    public final boolean N() throws DfuException {
        if (!w()) {
            return false;
        }
        y();
        G();
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
            ZLogger.d("Last send reach the bottom");
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

    @Override // com.realsil.sdk.dfu.l.d
    public void a(ExtendedBluetoothDevice extendedBluetoothDevice) {
        boolean a2;
        BluetoothDevice device = extendedBluetoothDevice.getDevice();
        SpecScanRecord parseFromBytes = SpecScanRecord.parseFromBytes(extendedBluetoothDevice.getScanRecord());
        if (this.mProcessState == 515) {
            String str = this.mDeviceAddress;
            if (str != null && str.equals(device.getAddress())) {
                a2 = true;
            } else {
                a2 = false;
            }
        } else if (this.mProcessState == 527) {
            a2 = a(parseFromBytes);
        } else {
            ZLogger.d(this.VDBG, "ignore process state: " + this.mProcessState);
            return;
        }
        if (a2) {
            this.mOtaDeviceName = extendedBluetoothDevice.getName();
            this.mOtaDeviceAddress = device.getAddress();
            ZLogger.d(this.DBG, "find target device: name=" + this.mOtaDeviceName + " addr=" + this.mOtaDeviceAddress);
            s();
            synchronized (this.A) {
                this.B = true;
                this.A.notifyAll();
            }
        }
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
                ZLogger.e(String.format("Something error in OTA process, errorCode: 0x%04X, mProcessState=0x%04X", Integer.valueOf(a2), Integer.valueOf(this.mProcessState)));
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
            H();
            a(274, false);
        }
        return true;
    }

    public void d(ScannerParams scannerParams) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(527);
            this.mErrorState = 0;
            this.B = false;
            b(scannerParams);
            try {
                synchronized (this.A) {
                    try {
                        if (this.mErrorState == 0 && !this.B) {
                            this.A.wait(31000L);
                        }
                    } finally {
                    }
                }
            } catch (InterruptedException e) {
                ZLogger.w("findRemoteDevice interrupted, e = " + e.toString());
                this.mErrorState = 259;
            }
            if (this.mErrorState == 0 && !this.B) {
                ZLogger.w("didn't find the secondary bud device");
                this.mErrorState = 265;
            }
            if (this.mErrorState != 0) {
                throw new OtaException("Error while scan remote device", this.mErrorState);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void executeOtaProcedure() {
        int innerCheck;
        try {
            setName("ProcessorXG0010S");
            ZLogger.d("ProcessorXG0010S running.");
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
        if (L()) {
            if (getOtaDeviceInfo().isRwsEnabled()) {
                x();
                notifyStateChanged(DfuConstants.PROGRESS_HAND_OVER_PROCESSING);
                ZLogger.d("wait master to handover ...");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new CompatScanFilter.Builder().setManufacturerData(getDfuConfig().getManufacturerId(), getOtaDeviceInfo().getRwsBdAddr()).build());
                ScannerParams o = o();
                o.setScanFilters(arrayList);
                d(o);
                ZLogger.d("start to upload secondary bud ...");
                this.otaModeEnabled = true;
                this.otaEnvironmentPrepared = false;
                this.mBytesSentBuffer = 0;
                if (L()) {
                    if (!this.o) {
                        notifyStateChanged(523);
                    } else {
                        x();
                        notifyStateChanged(258);
                    }
                }
            } else if (!this.o) {
                notifyStateChanged(523);
            } else {
                x();
                notifyStateChanged(258);
            }
        }
        closeInputStream(this.mCurBinInputStream);
        ZLogger.d(this.DBG, "ProcessorXG0010S stopped");
        onDestroy();
        if (this.mProcessState == 525) {
            notifyStateChanged(259);
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
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }
}
