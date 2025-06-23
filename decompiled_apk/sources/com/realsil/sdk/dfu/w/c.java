package com.realsil.sdk.dfu.w;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.text.TextUtils;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.BaseDfuTask;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class c extends BaseDfuTask {
    public UsbManager y;
    public int[] z;

    public c(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        initialize();
    }

    public UsbDevice a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UsbManager usbManager = this.y;
        if (usbManager == null) {
            ZLogger.w("mUsbManager == null");
            return null;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        if (deviceList != null && deviceList.size() > 0) {
            return deviceList.get(str);
        }
        ZLogger.d("no usb device exist");
        return null;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        this.mOtaDeviceInfo = new OtaDeviceInfo(this.h, 2);
        if (this.y == null) {
            UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
            this.y = usbManager;
            if (usbManager == null) {
                ZLogger.w("Unable to initialize mUsbManager.");
            }
        }
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public int innerCheck() {
        int innerCheck = super.innerCheck();
        if (innerCheck != 0) {
            return innerCheck;
        }
        if (TextUtils.isEmpty(this.mDeviceAddress)) {
            if (this.DBG) {
                ZLogger.w("invalid address: " + this.mDeviceAddress);
                return 4112;
            }
            ZLogger.w("invalid address: ");
            return 4112;
        }
        return 0;
    }

    public void j() {
        synchronized (this.v) {
            if (this.u) {
                ZLogger.d("Remote busy now, just wait!");
                try {
                    this.v.wait(60000L);
                } catch (InterruptedException e) {
                    ZLogger.w(e.toString());
                }
                ZLogger.v(this.DBG, "Remote idle now, just go!");
            }
        }
    }

    public void k() {
        int maxFileCount = getDfuProgressInfo().getMaxFileCount();
        int nextFileIndex = getDfuProgressInfo().getNextFileIndex();
        if (nextFileIndex < 0 || nextFileIndex >= maxFileCount) {
            ZLogger.d("invalid FileIndex: " + nextFileIndex + ", reset to 0");
            nextFileIndex = 0;
        }
        getDfuProgressInfo().setCurrentFileIndex(nextFileIndex);
        BaseBinInputStream baseBinInputStream = this.pendingImageInputStreams.get(nextFileIndex);
        this.mCurBinInputStream = baseBinInputStream;
        if (baseBinInputStream != null) {
            getDfuProgressInfo().initialize(this.mCurBinInputStream.getBinId(), this.mCurBinInputStream.getImageId(), this.mCurBinInputStream.getImageVersion(), this.mCurBinInputStream.remainSizeInBytes(), getDfuConfig().isThroughputEnabled());
        } else {
            ZLogger.w("mCurBinInputStream == null");
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

    public void l() throws DfuException {
        closeInputStream(this.mCurBinInputStream);
        List<BaseBinInputStream> loadImageFile = FirmwareLoaderX.loadImageFile(new LoadParams.Builder().preferredIcType(getDfuConfig().getPrimaryIcType()).fileLocation(getDfuConfig().getFileLocation()).setFilePath(this.m).setFileSuffix(getDfuConfig().getFileSuffix()).with(this.mContext).setFileIndicator(this.n).vpId(getDfuConfig().getVpId()).setOtaDeviceInfo(getOtaDeviceInfo()).setIcCheckEnabled(getDfuConfig().isIcCheckEnabled()).setSectionSizeCheckEnabled(getDfuConfig().isSectionSizeCheckEnabled()).versionCheckEnabled(getDfuConfig().isVersionCheckEnabled(), getDfuConfig().getVersionCheckMode()).build());
        this.pendingImageInputStreams = loadImageFile;
        if (loadImageFile != null && loadImageFile.size() > 0) {
            if (getDfuProgressInfo().getNextFileIndex() == 0) {
                this.z = new int[this.pendingImageInputStreams.size()];
            }
            getDfuProgressInfo().setMaxFileCount(this.pendingImageInputStreams.size());
            ZLogger.v(getDfuProgressInfo().toString());
            k();
            this.imageFileLoaded = true;
            return;
        }
        ZLogger.w("pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
        throw new OtaException("load image file error", 4097);
    }
}
