package com.realsil.sdk.dfu.model;

import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.dfu.image.wrapper.BinImageWrapper;
import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;

/* loaded from: classes11.dex */
public final class DeviceInfoWrapper {

    /* renamed from: a, reason: collision with root package name */
    public DeviceInfo f19578a;

    public DeviceInfoWrapper(DeviceInfo deviceInfo) {
        this.f19578a = deviceInfo;
    }

    public final int a(int i, int i2) {
        return i;
    }

    public final int b(int i, int i2) {
        return (i2 >> (i * 2)) & 3;
    }

    public String formatAppImageVersionOld() {
        return new BinImageWrapper.Builder().setOtaVersion(this.f19578a.specVersion).icType(this.f19578a.icType).binId(768).imageVersion(this.f19578a.getAppVersion(), 2).build().getFormattedVersion();
    }

    public String formatPatchExtImageVersionOld() {
        return new BinImageWrapper.Builder().setOtaVersion(this.f19578a.specVersion).icType(this.f19578a.icType).binId(-1).imageVersion(this.f19578a.getAppVersion(), 2).build().getFormattedVersion();
    }

    public String formatPatchImageVersionOld() {
        return new BinImageWrapper.Builder().setOtaVersion(this.f19578a.specVersion).icType(this.f19578a.icType).binId(512).imageVersion(this.f19578a.getAppVersion(), 2).build().getFormattedVersion();
    }

    public SocImageWrapper getAncImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(10, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT);
            } else {
                int a3 = a(10, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(10, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getAppConfigImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(10134);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(9, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(10134);
            } else {
                int a3 = a(9, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(9, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getAppImageWrapper() {
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a).setImageId(ErrorCode.MSP_ERROR_USER_CANCELLED).setImageVersion(this.f19578a.getAppVersion());
        return builder.build();
    }

    public SocImageWrapper getAppUiParameterVersion() {
        return getAppConfigImageWrapper();
    }

    public SocImageWrapper getDspAppImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(7, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE);
            } else {
                int a3 = a(7, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(7, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getDspAppVersion() {
        return getDspAppImageWrapper();
    }

    public SocImageWrapper getDspConfigImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(10135);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(8, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(10135);
            } else {
                int a3 = a(8, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(8, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getDspPatchImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_INVALID_OPERATION);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(6, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_INVALID_OPERATION);
            } else {
                int a3 = a(6, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(6, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getDspPatchVersion() {
        return getDspPatchImageWrapper();
    }

    public SocImageWrapper getDspUiParameterVersion() {
        return getDspConfigImageWrapper();
    }

    public SocImageWrapper getEx1ImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_BUSY_GRMBUILDING);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(11, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_BUSY_GRMBUILDING);
            } else {
                int a3 = a(11, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(11, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getEx2ImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_BUSY_LEXUPDATING);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int a2 = a(12, deviceInfo.imageVersionIndicator);
            imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a2);
            builder.setBitNumber(a2);
        } else if (i == 17) {
            if (deviceInfo.specVersion >= 6) {
                imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_BUSY_LEXUPDATING);
            } else {
                int a3 = a(12, deviceInfo.imageVersionIndicator);
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a3);
                builder.setBitNumber(a3);
            }
        } else {
            int i2 = deviceInfo.specVersion;
            if (i2 != 0 && i2 == 1) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(12, deviceInfo.imageVersionIndicator));
            } else {
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getImageWrapper(int i) {
        switch (i) {
            case ErrorCode.MSP_ERROR_INVALID_OPERATION /* 10132 */:
                return getDspPatchImageWrapper();
            case ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE /* 10133 */:
                return getDspAppVersion();
            case 10134:
                return getAppConfigImageWrapper();
            case 10135:
                return getDspConfigImageWrapper();
            case ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT /* 10136 */:
                return getAncImageWrapper();
            case ErrorCode.MSP_ERROR_BUSY_GRMBUILDING /* 10137 */:
                return getEx1ImageWrapper();
            case ErrorCode.MSP_ERROR_BUSY_LEXUPDATING /* 10138 */:
                return getEx2ImageWrapper();
            default:
                return null;
        }
    }

    public SocImageWrapper getOtaHeaderImageWrapper() {
        ImageVersionInfo activeImageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_CONFIG_INITIALIZE);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int i2 = deviceInfo.icType;
            if (i2 != 4 && i2 != 6 && i2 != 7 && i2 != 8 && i2 != 10) {
                if (i2 == 5 || i2 == 9 || i2 == 12) {
                    activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
                }
                activeImageVersionInfo = null;
            } else {
                activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
            }
        } else if (i == 17) {
            int i3 = deviceInfo.icType;
            if (i3 != 4 && i3 != 6 && i3 != 7 && i3 != 8 && i3 != 10) {
                if (i3 == 5 || i3 == 9 || i3 == 12) {
                    activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
                }
                activeImageVersionInfo = null;
            } else if (deviceInfo.specVersion >= 6) {
                activeImageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_CONFIG_INITIALIZE);
            } else {
                activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
            }
        } else {
            int i4 = deviceInfo.specVersion;
            if (i4 != 0 && i4 == 1) {
                int i5 = deviceInfo.icType;
                if (i5 != 4 && i5 != 6 && i5 != 7 && i5 != 8 && i5 != 10) {
                    if (i5 == 5 || i5 == 9 || i5 == 12) {
                        activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
                    }
                } else {
                    activeImageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(2, deviceInfo.imageVersionIndicator));
                }
            }
            activeImageVersionInfo = null;
        }
        if (activeImageVersionInfo != null) {
            builder.setImageVersion(activeImageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getRomPatchImageWrapper() {
        ImageVersionInfo imageVersionInfo;
        SocImageWrapper.Builder builder = new SocImageWrapper.Builder();
        builder.setDeviceInfo(this.f19578a);
        builder.setImageId(ErrorCode.MSP_ERROR_CODING_LIB_NOT_LOAD);
        DeviceInfo deviceInfo = this.f19578a;
        int i = deviceInfo.protocolType;
        if (i == 16) {
            int i2 = deviceInfo.icType;
            if (i2 <= 3) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(0, deviceInfo.imageVersionIndicator));
            } else if (i2 != 5 && i2 != 9 && i2 != 12) {
                if (i2 == 4 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 10) {
                    imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
                }
                imageVersionInfo = null;
            } else {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
            }
        } else if (i == 17) {
            int i3 = deviceInfo.icType;
            if (i3 <= 3) {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(0, deviceInfo.imageVersionIndicator));
            } else if (i3 != 5 && i3 != 9 && i3 != 12) {
                if (i3 == 4 || i3 == 6 || i3 == 7 || i3 == 8 || i3 == 10) {
                    if (deviceInfo.specVersion >= 6) {
                        imageVersionInfo = deviceInfo.getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_CODING_LIB_NOT_LOAD);
                    } else {
                        imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
                    }
                }
                imageVersionInfo = null;
            } else {
                imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
            }
        } else {
            int i4 = deviceInfo.specVersion;
            if (i4 == 0) {
                imageVersionInfo = new ImageVersionInfo(0, b(0, this.f19578a.imageVersionIndicator), this.f19578a.getOldPatchVersion(), 0);
            } else if (i4 == 1) {
                int i5 = deviceInfo.icType;
                if (i5 <= 3) {
                    imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(0, deviceInfo.imageVersionIndicator));
                } else if (i5 != 5 && i5 != 9 && i5 != 12) {
                    if (i5 == 4 || i5 == 6 || i5 == 7 || i5 == 8 || i5 == 10) {
                        imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
                    }
                    imageVersionInfo = null;
                } else {
                    imageVersionInfo = this.f19578a.getActiveImageVersionInfo(a(4, deviceInfo.imageVersionIndicator));
                }
            } else {
                if (i4 == 2) {
                    imageVersionInfo = new ImageVersionInfo(0, b(0, this.f19578a.imageVersionIndicator), this.f19578a.getOldPatchVersion(), 0);
                }
                imageVersionInfo = null;
            }
        }
        if (imageVersionInfo != null) {
            builder.setImageVersion(imageVersionInfo.getVersion());
        }
        return builder.build();
    }

    public SocImageWrapper getSocAppImageWrapper() {
        return getAppImageWrapper();
    }

    public boolean isAppDataSupportedOld() {
        return this.f19578a.appDataSupportedOld;
    }

    public boolean isOldImageVersionPolicySupported() {
        if (this.f19578a.getProtocolType() == 0 && this.f19578a.specVersion == 0) {
            return true;
        }
        return false;
    }
}
