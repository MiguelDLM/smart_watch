package com.realsil.sdk.dfu.t;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.Command;
import com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer;
import com.realsil.sdk.core.bluetooth.scanner.BrEdrScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice;
import com.realsil.sdk.core.bluetooth.scanner.ScannerCallback;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.j.c;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes11.dex */
public abstract class b extends com.realsil.sdk.dfu.j.b {
    public BrEdrScannerPresenter D;
    public volatile boolean E;
    public a F;
    public volatile byte[] G;
    public volatile boolean H;
    public Set<Short> I;
    public Map<Short, AckPacket> J;
    public SppTransportLayer K;

    /* loaded from: classes11.dex */
    public class a extends ScannerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.ScannerCallback
        public void onNewDevice(ExtendedBluetoothDevice extendedBluetoothDevice) {
            super.onNewDevice(extendedBluetoothDevice);
            if (!b.this.E) {
                if (b.this.DBG) {
                    ZLogger.d("is already stop the scan, do nothing");
                }
            } else {
                if (extendedBluetoothDevice == null) {
                    if (b.this.DBG) {
                        ZLogger.d("ignore, device == null");
                        return;
                    }
                    return;
                }
                b.this.a(extendedBluetoothDevice);
            }
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.ScannerCallback
        public void onScanStateChanged(int i) {
            super.onScanStateChanged(i);
            if (b.this.VDBG) {
                ZLogger.v("state= " + i);
            }
        }
    }

    public b(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.G = null;
        this.H = false;
    }

    public void a(ExtendedBluetoothDevice extendedBluetoothDevice) {
        BluetoothDevice device = extendedBluetoothDevice.getDevice();
        if (this.mProcessState == 515) {
            String str = this.mDeviceAddress;
            if (str == null || !str.equals(device.getAddress())) {
                return;
            }
            this.mOtaDeviceName = extendedBluetoothDevice.getName();
            this.mOtaDeviceAddress = device.getAddress();
            if (this.DBG) {
                ZLogger.d("find target device: name=" + this.mOtaDeviceName + " addr=" + BluetoothHelper.formatAddress(this.mOtaDeviceAddress, true));
            }
            o();
            synchronized (this.A) {
                this.B = true;
                this.A.notifyAll();
            }
            return;
        }
        ZLogger.v("ignore process state: " + this.mProcessState);
    }

    @Override // com.realsil.sdk.dfu.j.b
    public boolean b(ScannerParams scannerParams) {
        if (this.DBG) {
            ZLogger.v("start le scan");
        }
        this.E = true;
        BrEdrScannerPresenter brEdrScannerPresenter = this.D;
        if (brEdrScannerPresenter == null) {
            c(scannerParams);
        } else {
            brEdrScannerPresenter.setScannerParams(scannerParams);
        }
        return this.D.startScan();
    }

    public final void c(ScannerParams scannerParams) {
        if (this.F == null) {
            this.F = new a();
        }
        this.D = new BrEdrScannerPresenter(this.mContext, scannerParams, this.F);
    }

    public void d(int i) {
        synchronized (this.j) {
            try {
                if (i == 0) {
                    this.mWriteRetransFlag = false;
                } else {
                    this.mWriteRetransFlag = false;
                }
                this.mWriteRequestStatus = i;
                this.mWriteRequestCompleted = true;
                this.j.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.realsil.sdk.dfu.j.b, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        this.I = new HashSet();
        this.J = new HashMap();
        c((ScannerParams) null);
        this.initialized = true;
        ZLogger.v("initialize success");
    }

    @Override // com.realsil.sdk.dfu.j.b
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
            getDfuProgressInfo().initialize(this.mCurBinInputStream.getBinId(), this.mCurBinInputStream.getImageId(), this.mCurBinInputStream.getImageVersion(), this.mCurBinInputStream.remainSizeInBytes(), getDfuConfig().isThroughputEnabled());
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

    @Override // com.realsil.sdk.dfu.j.b
    public void l() throws LoadFileException {
        closeInputStream(this.mCurBinInputStream);
        List<BaseBinInputStream> loadImageFile = FirmwareLoaderX.loadImageFile(new LoadParams.Builder().preferredIcType(getDfuConfig().getPrimaryIcType()).fileLocation(getDfuConfig().getFileLocation()).setFilePath(this.m).setFileSuffix(getDfuConfig().getFileSuffix()).with(this.mContext).setWorkMode(this.mOtaWorkMode).setFileIndicator(this.n).vpId(getDfuConfig().getVpId()).setOtaDeviceInfo(getOtaDeviceInfo()).setIcCheckEnabled(getDfuConfig().isIcCheckEnabled()).setSectionSizeCheckEnabled(getDfuConfig().isSectionSizeCheckEnabled()).versionCheckEnabled(getDfuConfig().isVersionCheckEnabled(), getDfuConfig().getVersionCheckMode()).build());
        this.pendingImageInputStreams = loadImageFile;
        if (loadImageFile != null && loadImageFile.size() > 0) {
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
        ZLogger.d(this.DBG, "pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
        throw new LoadFileException("load image file error", 4097);
    }

    public ScannerParams m() {
        ScannerParams scannerParams = new ScannerParams(32);
        scannerParams.setScanPeriod(31000L);
        return scannerParams;
    }

    public byte[] n() throws DfuException {
        return b(getDfuConfig().getNotificationTimeout());
    }

    public boolean o() {
        this.E = false;
        BrEdrScannerPresenter brEdrScannerPresenter = this.D;
        if (brEdrScannerPresenter != null) {
            brEdrScannerPresenter.stopScan();
            return true;
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void onDestroy() {
        super.onDestroy();
        ZLogger.v(this.DBG, "onDestroy");
        this.E = false;
        BrEdrScannerPresenter brEdrScannerPresenter = this.D;
        if (brEdrScannerPresenter != null) {
            brEdrScannerPresenter.onDestroy();
        }
    }

    public void c(int i) {
        this.t = i > 16 ? (i / 16) * 16 : 16;
        ZLogger.d("> mBufferCheckMtuSize=" + this.t);
    }

    public byte[] b(long j) throws DfuException {
        this.mErrorState = 0;
        this.H = true;
        try {
            synchronized (this.p) {
                try {
                    if (this.mErrorState == 0 && this.G == null && this.mConnectionState == 515) {
                        this.H = false;
                        if (this.VDBG) {
                            ZLogger.v("wait for notification, wait for " + j + "ms");
                        }
                        this.p.wait(j);
                    }
                    if (this.mErrorState == 0 && !this.H) {
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
            return this.G;
        }
        throw new OtaException("Unable to receive notification", this.mErrorState);
    }

    public boolean a(c cVar) throws DfuException {
        ZLogger.v(this.DBG, cVar.toString());
        return a(cVar.b(), cVar.a());
    }

    public boolean a(short s, byte[] bArr) throws DfuException {
        return a(new Command.Builder().writeType(2).packet(s, bArr).build(), false);
    }

    public boolean a(short s, byte[] bArr, boolean z) throws DfuException {
        return a(new Command.Builder().writeType(2).packet(s, bArr).build(), z);
    }

    public boolean a(short s, byte[] bArr, int i) throws DfuException {
        if (bArr != null && bArr.length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        return a(new Command.Builder().writeType(2).packet(s, bArr).build(), false);
    }

    public boolean a(Command command, boolean z) throws DfuException {
        boolean z2 = false;
        if (this.mAborted && !z) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
        this.G = null;
        this.mWriteRetransFlag = true;
        this.mWriteRequestCompleted = false;
        boolean a2 = a(command);
        if (a2) {
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
            if (this.VDBG) {
                ZLogger.v(String.format("errorCode=0x%04X,reqComp=%b, connState=0x%04X, retransFlag=%b", 0, Boolean.valueOf(this.mWriteRequestCompleted), Integer.valueOf(this.mConnectionState), Boolean.valueOf(this.mWriteRetransFlag)));
            }
            if (this.mErrorState == 0) {
                if (!this.mWriteRequestCompleted) {
                    ZLogger.d(this.DBG, "send command but no callback");
                    this.mErrorState = 261;
                } else if (this.mWriteRequestStatus != 0) {
                    ZLogger.w(String.format("write failed, mWriteRequestStatus=0x%02X", Integer.valueOf(this.mWriteRequestStatus)));
                    this.mErrorState = 267;
                }
            }
            z2 = a2;
        } else {
            ZLogger.w("write spp data error");
            this.mErrorState = 267;
        }
        if (this.mErrorState == 0) {
            return z2;
        }
        throw new OtaException("Error while send command", this.mErrorState);
    }

    public final boolean a(Command command) {
        SppTransportLayer sppTransportLayer = this.K;
        if (sppTransportLayer == null) {
            ZLogger.w("mTransportLayer == null");
            return false;
        }
        return sppTransportLayer.sendCommand(command);
    }
}
