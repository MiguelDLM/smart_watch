package com.realsil.sdk.dfu.model;

import android.util.SparseIntArray;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.image.wrapper.BinImageWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public class BinInfo {
    public static final int STATUS_CONFIG_FILE_VERSION_LOW = 7;
    public static final int STATUS_FILE_INCOMPLETE = 5;
    public static final int STATUS_IC_TYPE_CONFLICT = 4;
    public static final int STATUS_MULTI_BUD_PACK_MISS = 3;
    public static final int STATUS_MULTI_PACK_NOT_SUPPORTED = 1;
    public static final int STATUS_MULTI_PACK_SUB_FILE_INVALID = 8;
    public static final int STATUS_NON_CONFIG_FILE_VERSION_LOW = 6;
    public static final int STATUS_OK = 4096;
    public static final int STATUS_SINGLE_NOT_SUPPORTED = 2;
    public String fileName;
    public long fileSize;
    public SparseIntArray forceCopyImages;
    public int icType;
    public boolean isPackFile;
    public boolean lowVersionExist;
    public String path;
    public List<BaseBinInputStream> subBinInputStreams;
    public List<SubFileInfo> subFileInfos;
    public List<SubFileInfo> subFileInfos1;
    public List<BaseBinInputStream> supportBinInputStreams;
    public List<SubFileInfo> supportSubFileInfos;
    public int version;
    public int fileType = 1;
    public int status = 4096;
    public boolean updateEnabled = true;
    public int bankIndicator = 0;
    public int updateBank = 15;

    public int getAppImageVersion(int i) {
        return getAppImageWrapper(i).getImageVersion();
    }

    public BinImageWrapper getAppImageWrapper(int i) {
        SubFileInfo subFileInfoByBitNumber;
        BaseBinInputStream binInputStream;
        BinImageWrapper.Builder builder = new BinImageWrapper.Builder();
        if (this.isPackFile) {
            int i2 = this.icType;
            if (i2 <= 3) {
                if (i != 0 && i != 15) {
                    subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 2);
                } else {
                    subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 1);
                }
            } else if (i2 != 5 && i2 != 9 && i2 != 12) {
                subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 5);
            } else {
                subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 5);
            }
            if (subFileInfoByBitNumber != null && (binInputStream = subFileInfoByBitNumber.getBinInputStream(this.icType)) != null) {
                builder.setOtaVersion(binInputStream.otaVersion);
                builder.bitNumber(subFileInfoByBitNumber.wrapperBitNumber());
                builder.icType(this.icType);
                builder.binId(binInputStream.getBinId());
                builder.imageVersion(subFileInfoByBitNumber.version, 1);
                builder.imageFeature(binInputStream.getImageFeature());
            }
        } else {
            BaseBinInputStream singleBinInputStream = getSingleBinInputStream();
            if (singleBinInputStream != null) {
                builder.setOtaVersion(singleBinInputStream.otaVersion);
                builder.icType(this.icType);
                builder.imageVersion(singleBinInputStream.getImageVersion());
                builder.binId(singleBinInputStream.getBinId());
                builder.imageFeature(singleBinInputStream.getImageFeature());
                int i3 = this.icType;
                if (i3 <= 3) {
                    if (i != 0 && i != 15) {
                        builder.bitNumber(2);
                        builder.imageVersion(singleBinInputStream.getImageVersion(), 1);
                    } else {
                        builder.bitNumber(1);
                        builder.imageVersion(singleBinInputStream.getImageVersion(), 1);
                    }
                } else if (i3 == 5 || i3 == 9 || i3 == 12) {
                    builder.bitNumber(5);
                    builder.imageVersion(singleBinInputStream.getImageVersion(), 1);
                }
            }
        }
        return builder.build();
    }

    public int getAppUiParameterVersion(int i) {
        if (!this.isPackFile) {
            BaseBinInputStream singleBinInputStream = getSingleBinInputStream();
            if (singleBinInputStream == null) {
                return 0;
            }
            return singleBinInputStream.getImageVersion();
        }
        SubFileInfo subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 9);
        if (subFileInfoByBitNumber == null) {
            return 0;
        }
        return subFileInfoByBitNumber.version;
    }

    public BaseBinInputStream getBinInputStreamByBinId(int i) {
        List<BaseBinInputStream> list = this.subBinInputStreams;
        if (list != null && list.size() > 0) {
            for (BaseBinInputStream baseBinInputStream : this.subBinInputStreams) {
                if (baseBinInputStream.getBinId() == i) {
                    return baseBinInputStream;
                }
            }
        }
        return null;
    }

    public BaseBinInputStream getBinInputStreamByImageId(int i) {
        List<BaseBinInputStream> list = this.subBinInputStreams;
        if (list != null && list.size() > 0) {
            for (BaseBinInputStream baseBinInputStream : this.subBinInputStreams) {
                if (baseBinInputStream.getImageId() == i) {
                    return baseBinInputStream;
                }
            }
        }
        return null;
    }

    public BaseBinInputStream getOtaHeaderImage(int i) {
        SubFileInfo subFileInfoByBitNumber;
        if (!this.isPackFile) {
            return getSingleBinInputStream();
        }
        int i2 = this.icType;
        if (i2 <= 3) {
            return null;
        }
        if (i2 != 5 && i2 != 9 && i2 != 12) {
            subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 2);
        } else {
            subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 2);
        }
        if (subFileInfoByBitNumber == null) {
            return null;
        }
        return subFileInfoByBitNumber.getBinInputStream(this.icType);
    }

    public int getOtaHeaderImageVersion(int i) {
        BaseBinInputStream otaHeaderImage = getOtaHeaderImage(i);
        if (otaHeaderImage != null) {
            int imageVersion = otaHeaderImage.getImageVersion();
            try {
                otaHeaderImage.close();
                return imageVersion;
            } catch (IOException e) {
                ZLogger.w(e.toString());
                return imageVersion;
            }
        }
        return 0;
    }

    public int getPatchImageVersion(int i) {
        SubFileInfo subFileInfoByBitNumber;
        if (!this.isPackFile) {
            BaseBinInputStream singleBinInputStream = getSingleBinInputStream();
            if (singleBinInputStream == null) {
                return 0;
            }
            return singleBinInputStream.getImageVersion();
        }
        int i2 = this.icType;
        if (i2 <= 3) {
            subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 0);
        } else if (i2 != 5 && i2 != 9 && i2 != 12) {
            subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 4);
        } else {
            subFileInfoByBitNumber = getSubFileInfoByBitNumber(i, 4);
        }
        if (subFileInfoByBitNumber == null) {
            return 0;
        }
        return subFileInfoByBitNumber.version;
    }

    public BaseBinInputStream getSingleBinInputStream() {
        List<BaseBinInputStream> list = this.subBinInputStreams;
        if (list != null && list.size() > 0) {
            return this.subBinInputStreams.get(0);
        }
        return null;
    }

    public SubFileInfo getSubFileInfoByBitNumber(int i, int i2) {
        if (i != 0 && i != 15) {
            List<SubFileInfo> list = this.subFileInfos1;
            if (list == null || list.size() <= 0) {
                return null;
            }
            for (SubFileInfo subFileInfo : this.subFileInfos1) {
                if (subFileInfo.bitNumber % 128 == i2) {
                    return subFileInfo;
                }
            }
        } else {
            List<SubFileInfo> list2 = this.subFileInfos;
            if (list2 != null && list2.size() > 0) {
                for (SubFileInfo subFileInfo2 : this.subFileInfos) {
                    if (subFileInfo2.bitNumber == i2) {
                        return subFileInfo2;
                    }
                }
            }
        }
        return null;
    }

    public List<SubFileInfo> getSubFileInfos(int i) {
        if (i == 1) {
            return this.subFileInfos1;
        }
        return this.subFileInfos;
    }

    public List<SubFileInfo> getSupportedFileInfos(int i) {
        ArrayList arrayList = new ArrayList();
        List<SubFileInfo> list = this.supportSubFileInfos;
        if (list != null && list.size() > 0) {
            if (i == 0) {
                for (SubFileInfo subFileInfo : this.supportSubFileInfos) {
                    if (subFileInfo.bitNumber <= 16) {
                        arrayList.add(subFileInfo);
                    }
                }
            } else {
                for (SubFileInfo subFileInfo2 : this.supportSubFileInfos) {
                    if (subFileInfo2.bitNumber > 16) {
                        arrayList.add(subFileInfo2);
                    }
                }
            }
        }
        return arrayList;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        sb.append("BinInfo{\n");
        sb.append(String.format("path=%s\n", this.path));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "fileName=%s, fileSize=%d\n", this.fileName, Long.valueOf(this.fileSize)));
        sb.append(String.format(locale, "fileType=0x%02X, isPackFile=%b, bankIndicator=0x%02X, updateBank=0x%02X\n", Integer.valueOf(this.fileType), Boolean.valueOf(this.isPackFile), Integer.valueOf(this.bankIndicator), Integer.valueOf(this.updateBank)));
        sb.append(String.format(locale, "icType=0x%02X, updateEnabled=%b, status=%d\n", Integer.valueOf(this.icType), Boolean.valueOf(this.updateEnabled), Integer.valueOf(this.status)));
        if (this.isPackFile) {
            List<SubFileInfo> list = this.subFileInfos;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb.append(String.format(locale, "subFileInfos.size=%d\n", Integer.valueOf(i3)));
            List<SubFileInfo> list2 = this.supportSubFileInfos;
            if (list2 != null) {
                i4 = list2.size();
            } else {
                i4 = 0;
            }
            sb.append(String.format(locale, "supportSubFileInfos.size=%d\n", Integer.valueOf(i4)));
        } else {
            List<BaseBinInputStream> list3 = this.subBinInputStreams;
            if (list3 != null) {
                i = list3.size();
            } else {
                i = 0;
            }
            sb.append(String.format(locale, "subBinInputStreams.size=%d\n", Integer.valueOf(i)));
            List<BaseBinInputStream> list4 = this.supportBinInputStreams;
            if (list4 != null) {
                i2 = list4.size();
            } else {
                i2 = 0;
            }
            sb.append(String.format(locale, "supportBinInputStreams.size=%d\n", Integer.valueOf(i2)));
            sb.append(String.format(locale, "version=%d\n", Integer.valueOf(this.version)));
        }
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }
}
