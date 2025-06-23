package no.nordicsemi.android.dfu.internal.manifest;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class Manifest {
    private FileInfo application;
    private FileInfo bootloader;

    @SerializedName("bootloader_application")
    private FileInfo bootloaderApplication;
    private FileInfo softdevice;

    @SerializedName("softdevice_application")
    private FileInfo softdeviceApplication;

    @SerializedName("softdevice_bootloader")
    private SoftDeviceBootloaderFileInfo softdeviceBootloader;

    @SerializedName("softdevice_bootloader_application")
    private FileInfo softdeviceBootloaderApplication;

    public FileInfo getApplicationInfo() {
        FileInfo fileInfo = this.application;
        if (fileInfo != null) {
            return fileInfo;
        }
        FileInfo fileInfo2 = this.softdeviceApplication;
        if (fileInfo2 != null) {
            return fileInfo2;
        }
        FileInfo fileInfo3 = this.bootloaderApplication;
        if (fileInfo3 != null) {
            return fileInfo3;
        }
        return this.softdeviceBootloaderApplication;
    }

    public FileInfo getBootloaderInfo() {
        return this.bootloader;
    }

    public SoftDeviceBootloaderFileInfo getSoftdeviceBootloaderInfo() {
        return this.softdeviceBootloader;
    }

    public FileInfo getSoftdeviceInfo() {
        return this.softdevice;
    }

    public boolean isSecureDfuRequired() {
        if (this.bootloaderApplication == null && this.softdeviceApplication == null && this.softdeviceBootloaderApplication == null) {
            return false;
        }
        return true;
    }
}
