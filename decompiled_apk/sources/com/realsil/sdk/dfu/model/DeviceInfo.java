package com.realsil.sdk.dfu.model;

import androidx.core.view.ViewCompat;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.OX00O0xII;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public class DeviceInfo {
    public static final int AES_MODE_16_FIRST = 0;
    public static final int AES_MODE_16_N = 1;
    public static final int BANK_INDICATOR_0 = 0;
    public static final int BANK_INDICATOR_1 = 1;
    public static final int BANK_INDICATOR_F = 15;
    public static final int BUD_ROLE_PRIMARY = 1;
    public static final int BUD_ROLE_SECONDARY = 2;
    public static final int BUD_ROLE_SINGLE = 0;
    public static final int MECHANISM_ALL_IN_ONE = 2;
    public static final int MECHANISM_ALL_IN_ONE_WITH_BUFFER = 3;
    public static final int MECHANISM_DEFAULT = 1;
    public static final int MECHANISM_ONE_BY_ONE = 1;
    public static final int RWS_FLAG_HANDOVER_PROCESSING = 1;
    public static final int RWS_FLAG_PREPARED = 0;
    public static final int RWS_MODE_ENGAGED = 2;
    public static final int RWS_MODE_ENGAGEED = 2;
    public static final int RWS_MODE_ENGAGE_IDLE = 1;
    public static final int RWS_MODE_SINGLE = 0;
    public static final int UPDATE_INDICATOR_BANK_0 = 1;
    public static final int UPDATE_INDICATOR_BANK_1 = 2;
    public static final int UPDATE_INDICATOR_STANDALONE = 0;
    public static final int UPDATE_MULTI_AT_A_TIME = 1;
    public static final int UPDATE_ONE_BY_ONE = 0;
    public List<ImageVersionInfo> A;
    public List<ImageVersionInfo> B;
    public List<CharacteristicInfo> C;
    public int D;
    public byte E;
    public byte F;
    public byte[] G;
    public int H;
    public Map<Integer, String> I;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19577a;
    public int appData0;
    public int appData1;
    public int appData2;
    public int appData3;
    public boolean appDataSupportedOld;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public byte[] imageSectionSizeValues;
    public byte[] imageVersionValues;
    public byte[] inactiveImageVersionValues;
    public boolean j;
    public boolean l;
    public int mtu;
    public boolean n;
    public int protocolType;
    public int secureVersion;
    public byte[] t;
    public byte[] u;
    public int v;
    public int w;
    public int x;
    public boolean z;
    public int icType = 3;
    public int specVersion = 0;
    public int appFreeBank = 0;
    public int patchFreeBank = 0;
    public int mode = 2;
    public int k = 1;
    public int m = 0;
    public boolean leNormalModeSupported = true;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public boolean r = false;
    public boolean s = false;
    public int maxBufferchecksize = 256;
    public int otaTempBufferSize = 0;
    public int imageVersionIndicator = 0;
    public int y = 1;
    public int updateBankIndicator = 0;

    public final int a(int i, int i2) {
        return i;
    }

    public void appendActiveImageVersionBytes(byte[] bArr) {
        appendActiveImageVersionBytes(bArr, 0);
    }

    public void appendDebugCharacteristicInfo(int i, byte[] bArr) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(new CharacteristicInfo(i, bArr));
    }

    public void appendImageFeatureInfo(int i, String str) {
        if (this.I == null) {
            this.I = new HashMap();
        }
        this.I.put(Integer.valueOf(i), str);
    }

    public void appendImageSectionSizeBytes(byte[] bArr) {
        byte[] bArr2 = this.imageSectionSizeValues;
        if (bArr2 != null && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.imageSectionSizeValues.length, bArr.length);
            this.imageSectionSizeValues = bArr3;
        } else {
            this.imageSectionSizeValues = bArr;
        }
        d();
    }

    public void appendImageVersionBytes(byte[] bArr) {
        int i = this.protocolType;
        if (i != 20 && i != 21) {
            if (i == 16) {
                if (this.specVersion >= 4) {
                    if (bArr != null && bArr.length >= 1) {
                        if (bArr[0] == 0) {
                            appendActiveImageVersionBytes(bArr, 1);
                            return;
                        } else {
                            appendInactiveImageVersionBytes(bArr, 1);
                            return;
                        }
                    }
                    return;
                }
                appendActiveImageVersionBytes(bArr, 0);
                return;
            }
            if (i == 17 && this.specVersion >= 6) {
                if (bArr != null && bArr.length >= 1) {
                    if (bArr[0] == 0) {
                        appendActiveImageVersionBytes(bArr, 1);
                        return;
                    } else {
                        appendInactiveImageVersionBytes(bArr, 1);
                        return;
                    }
                }
                return;
            }
            appendActiveImageVersionBytes(bArr, 0);
            return;
        }
        if (bArr != null && bArr.length >= 1) {
            if (bArr[0] == 0) {
                appendActiveImageVersionBytes(bArr, 1);
            } else {
                appendInactiveImageVersionBytes(bArr, 1);
            }
        }
    }

    public void appendInactiveImageVersionBytes(byte[] bArr) {
        appendInactiveImageVersionBytes(bArr, 0);
    }

    public final void b(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            return;
        }
        int i2 = remaining - i;
        if (i2 >= 2) {
            this.icType = wrap.get(i) & 255;
            this.specVersion = (byte) (wrap.get(i + 1) & 15);
        }
        if (i2 >= 3) {
            byte b = wrap.get(i + 2);
            this.mode = b & 255;
            this.i = (b & 1) != 0;
            this.j = ((b & 2) >> 1) != 0;
            this.k = (b & 4) >> 2;
            this.m = (b & 8) >> 3;
        }
        if (i2 >= 6) {
            this.otaTempBufferSize = wrap.getShort(i + 4) & OX00O0xII.f29066Oxx0xo;
        }
        if (i2 >= 7) {
            int i3 = wrap.get(i + 6) & 255;
            if (i3 == 0) {
                this.z = false;
                this.updateBankIndicator = 0;
                this.imageVersionIndicator = 3;
            } else if (i3 == 1) {
                this.z = true;
                this.updateBankIndicator = 2;
                this.imageVersionIndicator = 1;
            } else if (i3 == 2) {
                this.z = true;
                this.updateBankIndicator = 1;
                this.imageVersionIndicator = 2;
            }
        }
        if (i2 >= 11) {
            this.H = wrap.getShort(i + 9) & OX00O0xII.f29066Oxx0xo;
        }
        if (this.imageVersionIndicator == 0) {
            this.z = false;
        } else {
            b();
        }
        a();
    }

    public final void c() {
        int i = this.specVersion;
        if (i == 0) {
            if (this.m == 1) {
                this.y = 2;
                return;
            } else {
                this.y = 1;
                return;
            }
        }
        if (i == 1) {
            if (this.m == 1) {
                if (this.otaTempBufferSize != 0) {
                    this.y = 3;
                    return;
                } else {
                    this.y = 2;
                    return;
                }
            }
            this.y = 1;
            return;
        }
        if (i == 2) {
            this.y = 1;
            return;
        }
        if (this.m == 1) {
            if (this.otaTempBufferSize != 0) {
                this.y = 3;
                return;
            } else {
                this.y = 2;
                return;
            }
        }
        this.y = 1;
    }

    public final void d() {
        int i = this.protocolType;
        if (i != 20 && i != 21) {
            if (i == 17 && this.specVersion >= 6) {
                f();
                return;
            } else if (i == 16 && this.specVersion >= 3) {
                f();
                return;
            } else {
                e();
                return;
            }
        }
        f();
    }

    public String dumpFeatures() {
        Map<Integer, String> map = this.I;
        if (map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : this.I.keySet()) {
                sb.append(String.format("--image:0x%04X, feature:%s", num, this.I.get(num)));
            }
            return sb.toString();
        }
        return "";
    }

    public final void e() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6 = 0;
        ZLogger.v(String.format("wrapperImageVersionWithBitNumber:indicator = 0x%08x, \nvalues = %s", Integer.valueOf(this.imageVersionIndicator), DataConverter.bytes2Hex(this.imageVersionValues)));
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < 16) {
            int i10 = (this.imageVersionIndicator >> (i7 * 2)) & 3;
            if (i10 == 0) {
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(i7, i10, -1, i6);
                ZLogger.v(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            } else {
                byte[] bArr = this.imageVersionValues;
                if (bArr != null && (i4 = i8 + 3) < bArr.length) {
                    if (this.protocolType == 17) {
                        if (this.specVersion >= 5) {
                            if (i7 == 2) {
                                i5 = ((bArr[i8] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 1] << 16) & 16711680) | ((bArr[i8 + 2] << 8) & 65280);
                                b = bArr[i4];
                            } else {
                                i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                                b = bArr[i8];
                            }
                        } else {
                            i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                            b = bArr[i8];
                        }
                    } else {
                        i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                        b = bArr[i8];
                    }
                    i = i5 | (b & 255);
                    i8 += 4;
                } else {
                    ZLogger.v("imageVersion loss, offset=" + i8);
                    i = 0;
                }
                byte[] bArr2 = this.imageSectionSizeValues;
                if (bArr2 != null && (i3 = i9 + 3) < bArr2.length) {
                    i2 = ((bArr2[i9 + 2] << 16) & 16711680) | ((-16777216) & (bArr2[i3] << 24)) | (65280 & (bArr2[i9 + 1] << 8)) | (bArr2[i9] & 255);
                    i9 += 4;
                } else {
                    ZLogger.v("sectionsize loss, offset=" + i9);
                    i2 = 0;
                }
                ImageVersionInfo imageVersionInfo2 = new ImageVersionInfo(i7, i10, i, i2);
                ZLogger.v(imageVersionInfo2.toString());
                arrayList.add(imageVersionInfo2);
            }
            i7++;
            i6 = 0;
        }
        this.A = arrayList;
        a();
    }

    public final void f() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b;
        ZLogger.v(String.format("wrapperImageVersionWithImageId, indicator = 0x%08x, \nvalues = %s", Integer.valueOf(this.imageVersionIndicator), DataConverter.bytes2Hex(this.imageVersionValues)));
        byte[] bArr = this.imageVersionValues;
        if (bArr != null && bArr.length > 0) {
            int i7 = bArr[0] & 255;
            ZLogger.v("imageNum=" + i7);
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int i8 = 1;
            for (int i9 = 0; i9 < i7; i9++) {
                byte[] bArr2 = this.imageVersionValues;
                if (bArr2 != null && (i5 = i8 + 5) < bArr2.length) {
                    int i10 = (bArr2[i8] & 255) | ((bArr2[i8 + 1] << 8) & 65280);
                    if (i10 == 10128) {
                        i6 = ((bArr2[i8 + 2] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr2[i8 + 3] << 16) & 16711680) | ((bArr2[i8 + 4] << 8) & 65280);
                        b = bArr2[i5];
                    } else {
                        i6 = ((bArr2[i5] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr2[i8 + 4] << 16) & 16711680) | ((bArr2[i8 + 3] << 8) & 65280);
                        b = bArr2[i8 + 2];
                    }
                    hashMap.put(Integer.valueOf(i10), Integer.valueOf(i6 | (b & 255)));
                } else {
                    ZLogger.v("ignore invalid imageVersionValues");
                }
                byte[] bArr3 = this.imageSectionSizeValues;
                if (bArr3 != null && (i4 = i8 + 5) < bArr3.length) {
                    hashMap2.put(Integer.valueOf(((bArr3[i8 + 1] << 8) & 65280) | (bArr3[i8] & 255)), Integer.valueOf((bArr3[i8 + 2] & 255) | ((bArr3[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | (16711680 & (bArr3[i8 + 4] << 16)) | ((bArr3[i8 + 3] << 8) & 65280)));
                } else {
                    ZLogger.v("ignore invalid imageSectionSizeValues");
                }
                i8 += 6;
            }
            for (Integer num : hashMap.keySet()) {
                int intValue = num.intValue();
                int i11 = this.updateBankIndicator;
                if (i11 == 1) {
                    i = 2;
                } else if (i11 == 2) {
                    i = 1;
                } else {
                    i = 3;
                }
                if (hashMap.containsKey(num) && hashMap.get(num) != null) {
                    i2 = ((Integer) hashMap.get(num)).intValue();
                } else {
                    i2 = 0;
                }
                if (hashMap2.containsKey(num) && hashMap2.get(num) != null) {
                    i3 = ((Integer) hashMap2.get(num)).intValue();
                } else {
                    i3 = 0;
                }
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(255, i, i2, i3, intValue);
                ZLogger.v(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            }
            this.A = arrayList;
            a();
            return;
        }
        ZLogger.v("imageVersionValues is empty");
        this.A = new ArrayList();
    }

    public final void g() {
        int i = this.protocolType;
        if (i != 20 && i != 21) {
            if (i == 17 && this.specVersion >= 6) {
                i();
                return;
            } else if (i == 16 && this.specVersion >= 3) {
                i();
                return;
            } else {
                h();
                return;
            }
        }
        i();
    }

    public int getActiveBank() {
        int i = this.updateBankIndicator;
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        return 15;
    }

    public ImageVersionInfo getActiveImageVersionInfo(int i) {
        List<ImageVersionInfo> list = this.A;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.A) {
                if (imageVersionInfo.getBitNumber() == i) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public ImageVersionInfo getActiveImageVersionInfoByImageId(int i) {
        List<ImageVersionInfo> list = this.A;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.A) {
                if (imageVersionInfo.getImageId() == i) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public int getAesEncryptMode() {
        return this.k;
    }

    public byte[] getAppConfigReleaseVer() {
        return this.G;
    }

    public SocImageWrapper getAppUiParameterVersion() {
        return new DeviceInfoWrapper(this).getAppConfigImageWrapper();
    }

    public int getAppVersion() {
        ImageVersionInfo activeImageVersionInfo;
        int i = this.protocolType;
        if (i == 16) {
            int i2 = this.icType;
            if (i2 > 3) {
                if (i2 != 5 && i2 != 9 && i2 != 12) {
                    if (i2 == 4 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 10) {
                        activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                    }
                } else {
                    activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                }
            }
            activeImageVersionInfo = null;
        } else if (i == 17) {
            int i3 = this.icType;
            if (i3 > 3) {
                if (i3 != 5 && i3 != 9 && i3 != 12) {
                    if (i3 == 4 || i3 == 6 || i3 == 7 || i3 == 8 || i3 == 10) {
                        if (this.specVersion >= 6) {
                            activeImageVersionInfo = getActiveImageVersionInfoByImageId(ErrorCode.MSP_ERROR_USER_CANCELLED);
                        } else {
                            activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                        }
                    }
                } else {
                    activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                }
            }
            activeImageVersionInfo = null;
        } else {
            int i4 = this.specVersion;
            if (i4 == 0) {
                return this.w;
            }
            if (i4 >= 1) {
                int i5 = this.icType;
                if (i5 <= 3) {
                    if (this.updateBankIndicator == 2) {
                        activeImageVersionInfo = getActiveImageVersionInfo(2);
                    } else {
                        activeImageVersionInfo = getActiveImageVersionInfo(1);
                    }
                } else if (i5 != 5 && i5 != 9 && i5 != 12) {
                    if (i5 == 4 || i5 == 6 || i5 == 7 || i5 == 8 || i5 == 10) {
                        activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                    }
                } else {
                    activeImageVersionInfo = getActiveImageVersionInfo(a(5, this.imageVersionIndicator));
                }
            }
            activeImageVersionInfo = null;
        }
        if (activeImageVersionInfo != null) {
            return activeImageVersionInfo.getVersion();
        }
        return 0;
    }

    public int getBatteryLevel() {
        return this.g;
    }

    public int getBudRole() {
        return this.o;
    }

    public List<CharacteristicInfo> getDebugCharacteristicInfos() {
        return this.C;
    }

    public byte[] getDeviceMac() {
        return this.u;
    }

    public SocImageWrapper getDspUiParameterVersion() {
        return new DeviceInfoWrapper(this).getDspConfigImageWrapper();
    }

    public List<ImageVersionInfo> getExistImageVersionInfos() {
        ArrayList arrayList = new ArrayList();
        List<ImageVersionInfo> list = this.A;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.A) {
                if (imageVersionInfo.getIndication() != 0) {
                    arrayList.add(imageVersionInfo);
                }
            }
        }
        return arrayList;
    }

    public List<ImageVersionInfo> getExistInactiveImageVersionInfos() {
        ArrayList arrayList = new ArrayList();
        List<ImageVersionInfo> list = this.B;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.B) {
                if (imageVersionInfo.getIndication() != 0) {
                    arrayList.add(imageVersionInfo);
                }
            }
        }
        return arrayList;
    }

    public List<SocImageWrapper> getExistInactiveSocImageWrappers() {
        return DeviceInfoParser.getExistInactiveSocImageWrappers(this, this.B);
    }

    public List<SocImageWrapper> getExistSocImageWrappers() {
        ArrayList arrayList = new ArrayList();
        List<ImageVersionInfo> list = this.A;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.A) {
                if (imageVersionInfo.getIndication() != 0) {
                    arrayList.add(new SocImageWrapper.Builder().setDeviceInfo(this).imageVersionInfo(imageVersionInfo).imageFeature(getImageFeature(imageVersionInfo.getImageId())).build());
                }
            }
        }
        return arrayList;
    }

    public byte getIcId() {
        return this.E;
    }

    public String getImageFeature(int i) {
        Map<Integer, String> map = this.I;
        if (map == null || map.size() <= 0 || !this.I.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return this.I.get(Integer.valueOf(i));
    }

    public Map<Integer, String> getImageFeatureMap() {
        return this.I;
    }

    public int getImageHeaderOffset() {
        return this.H;
    }

    public List<ImageVersionInfo> getImageVersionInfos() {
        return this.A;
    }

    public ImageVersionInfo getInActiveImageVersionInfo(int i) {
        List<ImageVersionInfo> list = this.B;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.B) {
                if (imageVersionInfo.getBitNumber() == i) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public ImageVersionInfo getInActiveImageVersionInfoByImageId(int i) {
        List<ImageVersionInfo> list = this.B;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.B) {
                if (imageVersionInfo.getImageId() == i) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public int getInactiveBank() {
        int i = this.updateBankIndicator;
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return 15;
    }

    public List<ImageVersionInfo> getInactiveImageVersionInfos() {
        return this.B;
    }

    public String getIpv() {
        return String.format("I%02XP%04XV%02XCID%02XPID%02X", Integer.valueOf(this.icType), Integer.valueOf(this.protocolType), Integer.valueOf(this.specVersion), Byte.valueOf(this.E), Byte.valueOf(this.F));
    }

    public int getNoTempImageId() {
        return this.D;
    }

    public int getOldPatchVersion() {
        return this.v;
    }

    public int getOtaHeaderImageVersion() {
        SocImageWrapper otaHeaderVersion = getOtaHeaderVersion();
        if (otaHeaderVersion != null) {
            return otaHeaderVersion.getImageVersion();
        }
        return 0;
    }

    public SocImageWrapper getOtaHeaderVersion() {
        return new DeviceInfoWrapper(this).getOtaHeaderImageWrapper();
    }

    public byte getPackageId() {
        return this.F;
    }

    public int getPatchExtensionVersion() {
        return this.x;
    }

    public int getPatchVersion() {
        return new DeviceInfoWrapper(this).getRomPatchImageWrapper().getImageVersion();
    }

    public int getPrimaryBat() {
        return this.g;
    }

    public int getProductId() {
        return this.d;
    }

    public int getProductVersion() {
        return this.e;
    }

    public int getProtocolType() {
        return this.protocolType;
    }

    public byte[] getRwsBdAddr() {
        return this.t;
    }

    public int getRwsMode() {
        return this.q;
    }

    public int getRwsUpdateFlag() {
        return this.p;
    }

    public int getSecondaryBat() {
        return this.h;
    }

    public int getUpdateBank() {
        int i = this.updateBankIndicator;
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return 15;
    }

    public int getUpdateImageFlag() {
        return this.m;
    }

    public int getUpdateMechanism() {
        return this.y;
    }

    public int getVendorId() {
        return this.c;
    }

    public int getVendorIdSource() {
        return this.b;
    }

    public final void h() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6 = 0;
        ZLogger.v(String.format("imageVersionIndicator = 0x%08x, \ninactiveImageVersionValues = %s", Integer.valueOf(this.imageVersionIndicator), DataConverter.bytes2Hex(this.inactiveImageVersionValues)));
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < 16) {
            int i10 = (this.imageVersionIndicator >> (i7 * 2)) & 3;
            if (i10 == 0) {
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(i7, i10, -1, i6);
                ZLogger.v(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            } else {
                byte[] bArr = this.inactiveImageVersionValues;
                if (bArr != null && (i4 = i8 + 3) < bArr.length) {
                    if (this.protocolType == 17) {
                        if (this.specVersion >= 5) {
                            if (i7 == 2) {
                                i5 = ((bArr[i8] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 1] << 16) & 16711680) | ((bArr[i8 + 2] << 8) & 65280);
                                b = bArr[i4];
                            } else {
                                i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                                b = bArr[i8];
                            }
                        } else {
                            i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                            b = bArr[i8];
                        }
                    } else {
                        i5 = ((bArr[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i8 + 2] << 16) & 16711680) | ((bArr[i8 + 1] << 8) & 65280);
                        b = bArr[i8];
                    }
                    i = i5 | (b & 255);
                    i8 += 4;
                } else {
                    ZLogger.v(true, "imageVersion loss, offset=" + i8);
                    i = 0;
                }
                byte[] bArr2 = this.imageSectionSizeValues;
                if (bArr2 != null && (i3 = i9 + 3) < bArr2.length) {
                    i2 = ((bArr2[i9 + 2] << 16) & 16711680) | ((-16777216) & (bArr2[i3] << 24)) | (65280 & (bArr2[i9 + 1] << 8)) | (bArr2[i9] & 255);
                    i9 += 4;
                } else {
                    ZLogger.v(true, "sectionsize loss, offset=" + i9);
                    i2 = 0;
                }
                ImageVersionInfo imageVersionInfo2 = new ImageVersionInfo(i7, i10, i, i2);
                ZLogger.v(imageVersionInfo2.toString());
                arrayList.add(imageVersionInfo2);
            }
            i7++;
            i6 = 0;
        }
        this.B = arrayList;
    }

    public final void i() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b;
        ZLogger.v(String.format("imageVersionIndicator = 0x%08x, \ninactiveImageVersionValues = %s", Integer.valueOf(this.imageVersionIndicator), DataConverter.bytes2Hex(this.inactiveImageVersionValues)));
        byte[] bArr = this.inactiveImageVersionValues;
        if (bArr != null && bArr.length > 0) {
            int i6 = bArr[0] & 255;
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int i7 = 1;
            for (int i8 = 0; i8 < i6; i8++) {
                byte[] bArr2 = this.inactiveImageVersionValues;
                if (bArr2 != null && (i4 = i7 + 5) < bArr2.length) {
                    int i9 = (bArr2[i7] & 255) | ((bArr2[i7 + 1] << 8) & 65280);
                    if (i9 == 10128) {
                        i5 = ((bArr2[i7 + 2] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr2[i7 + 3] << 16) & 16711680) | ((bArr2[i7 + 4] << 8) & 65280);
                        b = bArr2[i4];
                    } else {
                        i5 = ((bArr2[i4] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr2[i7 + 4] << 16) & 16711680) | ((bArr2[i7 + 3] << 8) & 65280);
                        b = bArr2[i7 + 2];
                    }
                    hashMap.put(Integer.valueOf(i9), Integer.valueOf(i5 | (b & 255)));
                }
                byte[] bArr3 = this.imageSectionSizeValues;
                if (bArr3 != null && (i7 * 4) + 3 < bArr3.length) {
                    hashMap2.put(Integer.valueOf(((bArr3[i7 + 1] << 8) & 65280) | (bArr3[i7] & 255)), Integer.valueOf((bArr3[i7 + 2] & 255) | ((bArr3[i7 + 5] << 24) & ViewCompat.MEASURED_STATE_MASK) | (16711680 & (bArr3[i7 + 4] << 16)) | ((bArr3[i7 + 3] << 8) & 65280)));
                }
                i7 += 6;
            }
            for (Integer num : hashMap.keySet()) {
                int intValue = num.intValue();
                int i10 = this.updateBankIndicator;
                if (i10 == 1) {
                    i = 2;
                } else if (i10 == 2) {
                    i = 1;
                } else {
                    i = 3;
                }
                if (hashMap.containsKey(num) && hashMap.get(num) != null) {
                    i2 = ((Integer) hashMap.get(num)).intValue();
                } else {
                    i2 = 0;
                }
                if (hashMap2.containsKey(num) && hashMap2.get(num) != null) {
                    i3 = ((Integer) hashMap2.get(num)).intValue();
                } else {
                    i3 = 0;
                }
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(255, i, i2, i3, intValue);
                ZLogger.v(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            }
            this.B = arrayList;
            return;
        }
        this.B = new ArrayList();
    }

    public boolean isAesEncryptEnabled() {
        return this.j;
    }

    public boolean isBankEnabled() {
        return this.z;
    }

    public boolean isBasSupported() {
        return this.f;
    }

    public boolean isBufferCheckEnabled() {
        return this.i;
    }

    public boolean isCopyImageEnabled() {
        return this.l;
    }

    public boolean isDebugInfoSupported() {
        List<CharacteristicInfo> list = this.C;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isDisSupported() {
        return this.f19577a;
    }

    public boolean isRwsEnabled() {
        return this.n;
    }

    public boolean isSeqOtaSupported() {
        return this.r;
    }

    public boolean isTestConfigSupported() {
        if (this.protocolType == 17 && this.specVersion >= 6) {
            return true;
        }
        return false;
    }

    public boolean isVpIdOtaSupported() {
        return this.s;
    }

    public void parseX0000(byte[] bArr) {
        parseX0000(bArr, 0);
    }

    public void parseX0010(byte[] bArr) {
        parseX0010(bArr, 0);
    }

    public void parseX0011(byte[] bArr) {
        parseX0011(bArr, 0);
    }

    public void parseX0012(byte[] bArr) {
        parseX0012(bArr, 0);
    }

    public void parseX0014(byte[] bArr) {
        a(bArr, 0);
    }

    public void parseX0015(byte[] bArr) {
        b(bArr, 0);
    }

    public void setActiveImageVersionValues(byte[] bArr) {
        this.imageVersionValues = bArr;
        d();
    }

    public void setAppConfigReleaseVer(byte[] bArr) {
        this.G = bArr;
    }

    public void setAppVersion(int i) {
        this.w = i;
    }

    public void setBatteryLevel(int i) {
        setBatteryLevel(i, 0);
    }

    public void setDeviceMac(byte[] bArr) {
        this.u = bArr;
    }

    public void setIcId(byte b) {
        this.E = b;
    }

    public void setImageHeaderOffset(int i) {
        this.H = i;
    }

    public void setImageSectionSizeValues(byte[] bArr) {
        this.imageSectionSizeValues = bArr;
        ZLogger.v(String.format("imageVersionIndicator = 0x%08x, \nimageSectionSizeValues=%s", Integer.valueOf(this.imageVersionIndicator), DataConverter.bytes2Hex(this.imageSectionSizeValues)));
        d();
    }

    public void setImageVersionValues(byte[] bArr) {
        int i = this.protocolType;
        if (i != 20 && i != 21) {
            if (i == 16) {
                if (this.specVersion >= 4) {
                    if (bArr != null && bArr.length >= 1) {
                        byte b = bArr[0];
                        int length = bArr.length - 1;
                        byte[] bArr2 = new byte[length];
                        System.arraycopy(bArr, 1, bArr2, 0, length);
                        if (b == 0) {
                            setActiveImageVersionValues(bArr2);
                            return;
                        } else {
                            setInactiveImageVersionValues(bArr2);
                            return;
                        }
                    }
                    setActiveImageVersionValues(null);
                    return;
                }
                setActiveImageVersionValues(bArr);
                return;
            }
            if (i == 17 && this.specVersion >= 6) {
                if (bArr != null && bArr.length >= 1) {
                    byte b2 = bArr[0];
                    int length2 = bArr.length - 1;
                    byte[] bArr3 = new byte[length2];
                    System.arraycopy(bArr, 1, bArr3, 0, length2);
                    if (b2 == 0) {
                        setActiveImageVersionValues(bArr3);
                        return;
                    } else {
                        setInactiveImageVersionValues(bArr3);
                        return;
                    }
                }
                setActiveImageVersionValues(null);
                return;
            }
            setActiveImageVersionValues(bArr);
            return;
        }
        if (bArr != null && bArr.length >= 1) {
            byte b3 = bArr[0];
            int length3 = bArr.length - 1;
            byte[] bArr4 = new byte[length3];
            System.arraycopy(bArr, 1, bArr4, 0, length3);
            if (b3 == 0) {
                setActiveImageVersionValues(bArr4);
                return;
            } else {
                setInactiveImageVersionValues(bArr4);
                return;
            }
        }
        setActiveImageVersionValues(null);
    }

    public void setInactiveImageVersionValues(byte[] bArr) {
        this.inactiveImageVersionValues = bArr;
        g();
    }

    public void setMode(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        this.mode = i;
        boolean z4 = false;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        if (((i & 2) >> 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.j = z2;
        this.k = (i & 4) >> 2;
        if (((i & 8) >> 3) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.l = z3;
        this.m = (i & 16) >> 4;
        if (((i & 32) >> 5) != 0) {
            z4 = true;
        }
        this.n = z4;
        c();
    }

    public void setNoTempImageId(int i) {
        this.D = i;
    }

    public void setPackageId(byte b) {
        this.F = b;
    }

    public void setPatchExtensionVersion(int i) {
        this.x = i;
    }

    public void setPatchVersion(int i) {
        this.v = i;
    }

    public void setPnpId(byte[] bArr) {
        if (bArr != null && bArr.length >= 7) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            this.f19577a = true;
            this.b = wrap.get() & 255;
            this.c = wrap.getShort();
            this.d = wrap.getShort();
            this.e = wrap.getShort();
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.US;
            sb.append(String.format(locale, "\tvendorIdSource=0x%02X(%d)\n", Integer.valueOf(this.b), Integer.valueOf(this.b)));
            sb.append(String.format(locale, "\tvendorId=0x%04X(%d)\n", Integer.valueOf(this.c), Integer.valueOf(this.c)));
            sb.append(String.format(locale, "\tproductId=0x%04X(%d)\n", Integer.valueOf(this.d), Integer.valueOf(this.d)));
            int i = this.d & 65535;
            this.d = i;
            sb.append(String.format(locale, "\tproductId=0x%04X(%d)\n", Integer.valueOf(i), Integer.valueOf(this.d)));
            sb.append(String.format(locale, "\tproductVersion=0x%04X(%d)\n", Integer.valueOf(this.e), Integer.valueOf(this.e)));
            ZLogger.v(sb.toString());
            return;
        }
        this.f19577a = false;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public void setPrimaryBat(int i) {
        this.g = i;
    }

    public void setProductId(int i) {
        this.d = i;
    }

    public void setProductVersion(int i) {
        this.e = i;
    }

    public void setProtocolType(int i) {
        this.protocolType = i;
    }

    public void setRwsBdAddr(byte[] bArr) {
        this.t = bArr;
    }

    public void setRwsMode(int i) {
        this.q = i;
    }

    public void setRwsUpdateFlag(int i) {
        this.p = i;
    }

    public void setSecondaryBat(int i) {
        this.h = i;
    }

    public void setVendorId(int i) {
        this.c = i;
    }

    public void setVendorIdSource(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo{");
        sb.append(String.format("\nIPV=%s", getIpv()));
        if (this.f19577a) {
            sb.append("\n\tDIS:");
            Locale locale = Locale.US;
            sb.append(String.format(locale, "\n\t\tVID=0x%04X(%d)", Integer.valueOf(this.c), Integer.valueOf(this.c)));
            sb.append(String.format(locale, "\n\t\tPID=0x%04X(%d)", Integer.valueOf(this.d), Integer.valueOf(this.d)));
            sb.append(String.format(locale, "\n\t\tvendorIdSource=0x%02X(%d)", Integer.valueOf(this.b), Integer.valueOf(this.b)));
            sb.append(String.format(locale, "\n\t\tproductVersion=0x%04X(%d)", Integer.valueOf(this.e), Integer.valueOf(this.e)));
        }
        if (this.f) {
            sb.append("\n\tBAS:");
            sb.append(String.format(Locale.US, "\npriBat=0x%02X(%d), secBat=0x%02X(%d)", Integer.valueOf(this.g), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.h)));
        }
        sb.append(String.format("\nmode=0x%02X\n", Integer.valueOf(this.mode)));
        sb.append(String.format("\tbufferCheckEnabled=%b\n", Boolean.valueOf(this.i)));
        if (this.i) {
            sb.append(String.format(Locale.US, "\t\tmaxBufferCheckSize=0x%04X(%d)\n", Integer.valueOf(this.maxBufferchecksize), Integer.valueOf(this.maxBufferchecksize)));
        }
        sb.append(String.format("\taesEncryptEnabled=%b", Boolean.valueOf(this.j)));
        if (this.j) {
            sb.append(String.format("\t\taesEncryptMode=0x%02X\n", Integer.valueOf(this.k)));
        }
        sb.append(String.format("\n\tcopyImageEnabled=%b\n", Boolean.valueOf(this.l)));
        sb.append(String.format("\tupdateImageFlag=0x%02X\n", Integer.valueOf(this.m)));
        sb.append(String.format("\trwsEnabled=%b, rwsMode=0x%02X, budRole: 0x%02X\n", Boolean.valueOf(this.n), Integer.valueOf(this.q), Integer.valueOf(this.o)));
        if (this.n) {
            sb.append(String.format("\t\trwsUpdateFlag:0x%02X, rwsBdAddr: %s\n", Integer.valueOf(this.p), BluetoothHelper.formatAddress(this.t, false, true)));
        }
        Locale locale2 = Locale.US;
        sb.append(String.format(locale2, "otaTempBufferSize=0x%04X(%d)\n", Integer.valueOf(this.otaTempBufferSize), Integer.valueOf(this.otaTempBufferSize)));
        sb.append(String.format("mUpdateMechanism=0x%02X\n", Integer.valueOf(this.y)));
        int i = this.protocolType;
        if (i == 0) {
            int i2 = this.specVersion;
            if (i2 == 0) {
                sb.append(String.format(locale2, "\tpatchVersion=0x%04X\n", Integer.valueOf(this.v)));
                sb.append(String.format(locale2, "\tpatchFreeBank=0x%02X\n", Integer.valueOf(this.patchFreeBank)));
                sb.append(String.format(locale2, "\tappVersion=0x%04X\n", Integer.valueOf(this.w)));
                sb.append(String.format("\tappFreeBank=0x%02X\n", Integer.valueOf(this.appFreeBank)));
                sb.append(String.format(locale2, "\tpatchExtensionVersion=%d\n", Integer.valueOf(this.x)));
                if (this.icType > 3) {
                    sb.append(String.format(locale2, "\tappData0=%d\n", Integer.valueOf(this.appData0)));
                    sb.append(String.format(locale2, "\tappData1=%d\n", Integer.valueOf(this.appData1)));
                    sb.append(String.format(locale2, "\tappData2=%d\n", Integer.valueOf(this.appData2)));
                    sb.append(String.format(locale2, "\tappData3=%d\n", Integer.valueOf(this.appData3)));
                }
            } else if (i2 == 1) {
                sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
                sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
                sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X\n", Integer.valueOf(this.updateBankIndicator)));
            } else if (i2 == 2) {
                sb.append(String.format(locale2, "\tnoTempImageId=0x%04X\n", Integer.valueOf(this.D)));
                sb.append(String.format(locale2, "\tpatchVersion=0x%04X\n", Integer.valueOf(this.v)));
            }
        } else if (i == 17) {
            sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
            sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
            sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.updateBankIndicator), Integer.valueOf(this.updateBankIndicator)));
            if (this.specVersion >= 6) {
                sb.append(String.format(locale2, "\tmtu=0x%04X\n", Integer.valueOf(this.mtu)));
            }
        } else if (i == 16) {
            sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
            sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
            sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.updateBankIndicator), Integer.valueOf(this.updateBankIndicator)));
            if (this.specVersion > 4) {
                sb.append(String.format(locale2, "\tmtu=0x%04X\n", Integer.valueOf(this.mtu)));
            }
        } else if (i == 20) {
            sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
            sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
            sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.updateBankIndicator), Integer.valueOf(this.updateBankIndicator)));
            sb.append(String.format(locale2, "\tmtu=0x%04X\n", Integer.valueOf(this.mtu)));
        } else if (i == 21) {
            sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
            sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
            sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.updateBankIndicator), Integer.valueOf(this.updateBankIndicator)));
            sb.append(String.format(locale2, "\tmtu=0x%04X\n", Integer.valueOf(this.mtu)));
            sb.append(String.format(locale2, "\timageHeaderOffset=0x%04X(%d)\n", Integer.valueOf(this.H), Integer.valueOf(this.H)));
        } else {
            sb.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.secureVersion), Integer.valueOf(this.secureVersion)));
            sb.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.imageVersionIndicator)));
            sb.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.updateBankIndicator), Integer.valueOf(this.updateBankIndicator)));
        }
        sb.append(String.format("bankEnabled=%b\n", Boolean.valueOf(this.z)));
        List<ImageVersionInfo> list = this.A;
        if (list != null && list.size() > 0) {
            sb.append("activeImages:\n");
            for (ImageVersionInfo imageVersionInfo : this.A) {
                sb.append("\t");
                sb.append(imageVersionInfo.toString());
                sb.append("\n");
            }
        }
        List<ImageVersionInfo> list2 = this.B;
        if (list2 != null && list2.size() > 0) {
            sb.append("inactiveImages:\n");
            for (ImageVersionInfo imageVersionInfo2 : this.B) {
                sb.append("\t");
                sb.append(imageVersionInfo2.toString());
                sb.append("\n");
            }
        }
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    public final void a(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            return;
        }
        int i2 = remaining - i;
        try {
            this.icType = wrap.get(i) & 255;
            this.specVersion = (byte) (wrap.get(i + 1) & 15);
            if (i2 >= 3) {
                byte b = wrap.get(i + 2);
                this.mode = b & 255;
                this.i = (b & 1) != 0;
                this.j = ((b & 2) >> 1) != 0;
                this.k = (b & 4) >> 2;
                this.m = (b & 8) >> 3;
                this.leNormalModeSupported = ((b & 16) >> 4) == 1;
                int i3 = (b & 96) >> 5;
                this.r = i3 == 1;
                this.s = i3 == 2;
            }
            if (i2 >= 4) {
                byte b2 = wrap.get(i + 3);
                int i4 = b2 & 3;
                this.q = i4;
                this.o = (b2 & 12) >> 2;
                this.n = i4 == 2;
            }
            if (i2 >= 6) {
                this.otaTempBufferSize = wrap.getShort(i + 4) & OX00O0xII.f29066Oxx0xo;
            }
            if (i2 >= 7) {
                int i5 = wrap.get(i + 6) & 255;
                if (i5 == 0) {
                    this.z = false;
                    this.updateBankIndicator = 0;
                    this.imageVersionIndicator = 3;
                } else if (i5 == 1) {
                    this.z = true;
                    this.updateBankIndicator = 2;
                    this.imageVersionIndicator = 1;
                } else if (i5 == 2) {
                    this.z = true;
                    this.updateBankIndicator = 1;
                    this.imageVersionIndicator = 2;
                }
            }
            if (i2 >= 8) {
                this.mtu = wrap.getShort(i + 7) & OX00O0xII.f29066Oxx0xo;
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
        if (this.imageVersionIndicator == 0) {
            this.z = false;
        } else {
            b();
        }
        a();
    }

    public void appendActiveImageVersionBytes(byte[] bArr, int i) {
        int length = bArr.length - i;
        byte[] bArr2 = this.imageVersionValues;
        if (bArr2 != null && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr2.length + length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i, bArr3, this.imageVersionValues.length, length);
            this.imageVersionValues = bArr3;
        } else {
            byte[] bArr4 = new byte[length];
            this.imageVersionValues = bArr4;
            System.arraycopy(bArr, i, bArr4, 0, length);
        }
        d();
    }

    public void appendInactiveImageVersionBytes(byte[] bArr, int i) {
        int length = bArr.length - i;
        byte[] bArr2 = this.inactiveImageVersionValues;
        if (bArr2 != null && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i, bArr3, this.inactiveImageVersionValues.length, bArr.length - i);
            this.inactiveImageVersionValues = bArr3;
        } else {
            byte[] bArr4 = new byte[length];
            this.inactiveImageVersionValues = bArr4;
            System.arraycopy(bArr, i, bArr4, 0, length);
        }
        g();
    }

    public void parseX0000(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            return;
        }
        int i2 = remaining - i;
        try {
            if (i2 <= 1) {
                this.icType = 3;
                this.specVersion = 0;
                this.appFreeBank = (byte) (wrap.get(i) & 15);
                byte b = (byte) ((wrap.get(i) & 240) >> 4);
                this.patchFreeBank = b;
                this.appDataSupportedOld = false;
                int i3 = this.appFreeBank;
                if (i3 == 15 && b == 15) {
                    this.z = false;
                    this.updateBankIndicator = 0;
                } else {
                    this.z = true;
                    if (i3 != 1 && b != 1) {
                        this.updateBankIndicator = 1;
                    }
                    this.updateBankIndicator = 2;
                }
                setMode(2);
                return;
            }
            this.icType = wrap.get(i) & 255;
            byte b2 = (byte) (wrap.get(i + 1) & 15);
            this.specVersion = b2;
            if (b2 == 0) {
                if (i2 >= 3) {
                    int i4 = i + 2;
                    this.appFreeBank = (byte) (wrap.get(i4) & 15);
                    this.patchFreeBank = (byte) ((wrap.get(i4) & 240) >> 4);
                }
                this.otaTempBufferSize = 0;
                if (i2 >= 4) {
                    setMode(wrap.get(i + 3));
                }
                if (i2 >= 6) {
                    this.maxBufferchecksize = (wrap.get(i + 5) << 8) | wrap.get(4);
                }
                if (i2 >= 14) {
                    this.appDataSupportedOld = true;
                    this.appData0 = (wrap.get(i + 7) << 8) | wrap.get(i + 6);
                    this.appData1 = (wrap.get(i + 9) << 8) | wrap.get(i + 8);
                    this.appData2 = (wrap.get(i + 11) << 8) | wrap.get(i + 10);
                    this.appData3 = wrap.get(i + 12) | (wrap.get(i + 13) << 8);
                }
                c();
                int i5 = this.appFreeBank;
                if (i5 == 15 && this.patchFreeBank == 15) {
                    this.z = false;
                    this.updateBankIndicator = 0;
                    return;
                }
                this.z = true;
                if (i5 != 1 && this.patchFreeBank != 1) {
                    this.updateBankIndicator = 1;
                    return;
                }
                this.updateBankIndicator = 2;
                return;
            }
            if (b2 == 1) {
                if (i2 >= 3) {
                    this.secureVersion = wrap.get(i + 2) & 255;
                }
                if (i2 >= 4) {
                    setMode(wrap.get(i + 3));
                }
                if (i2 >= 5) {
                    this.maxBufferchecksize = wrap.getShort(i + 4) & OX00O0xII.f29066Oxx0xo;
                }
                if (i2 >= 7) {
                    this.otaTempBufferSize = wrap.get(i + 6) & 255;
                }
                if (i2 >= 12) {
                    this.imageVersionIndicator = wrap.getInt(i + 8);
                }
                c();
                if (this.imageVersionIndicator == 0) {
                    this.z = false;
                    return;
                } else {
                    b();
                    return;
                }
            }
            if (b2 == 2) {
                if (i2 >= 3) {
                    this.secureVersion = wrap.get(i + 2) & 255;
                }
                if (i2 >= 4) {
                    setMode(wrap.get(i + 3));
                }
                if (i2 >= 5) {
                    this.maxBufferchecksize = wrap.getShort(i + 4) & OX00O0xII.f29066Oxx0xo;
                }
                if (i2 >= 7) {
                    this.D = wrap.getShort(i + 6);
                }
                if (i2 >= 8) {
                    this.v = wrap.getShort(i + 7) & OX00O0xII.f29066Oxx0xo;
                }
                c();
                if (this.imageVersionIndicator == 0) {
                    this.z = false;
                } else {
                    b();
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void parseX0010(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            return;
        }
        int i2 = remaining - i;
        try {
            this.icType = wrap.get(i) & 255;
            byte b = (byte) (wrap.get(i + 1) & 15);
            this.specVersion = b;
            if (b < 4) {
                if (i2 >= 3) {
                    this.secureVersion = wrap.get(i + 2) & 255;
                }
                if (i2 >= 4) {
                    byte b2 = wrap.get(i + 3);
                    this.mode = b2 & 255;
                    this.i = (b2 & 1) != 0;
                    this.j = ((b2 & 2) >> 1) != 0;
                    this.k = (b2 & 4) >> 2;
                    this.l = ((b2 & 8) >> 3) != 0;
                    this.m = (b2 & 16) >> 4;
                    this.n = ((b2 & 32) >> 5) != 0;
                    this.o = (b2 & 64) >> 6;
                    this.p = (b2 & 128) >> 7;
                }
                if (i2 >= 5) {
                    this.q = wrap.get(i + 4) & 1;
                }
                if (i2 >= 7) {
                    this.otaTempBufferSize = wrap.get(i + 6) & 255;
                }
                if (i2 >= 12) {
                    this.imageVersionIndicator = wrap.getInt(i + 8);
                }
            } else {
                if (i2 >= 3) {
                    byte b3 = wrap.get(i + 2);
                    this.mode = b3 & 255;
                    this.i = (b3 & 1) != 0;
                    this.j = ((b3 & 2) >> 1) != 0;
                    this.k = (b3 & 4) >> 2;
                    this.m = (b3 & 8) >> 3;
                    this.leNormalModeSupported = ((b3 & 16) >> 4) == 1;
                    int i3 = (b3 & 96) >> 5;
                    this.r = i3 == 1;
                    this.s = i3 == 2;
                }
                if (i2 >= 4) {
                    byte b4 = wrap.get(i + 3);
                    int i4 = b4 & 3;
                    this.q = i4;
                    this.o = (b4 & 12) >> 2;
                    this.n = i4 == 2;
                }
                if (i2 >= 5) {
                    this.otaTempBufferSize = wrap.get(i + 4) & 255;
                }
                if (i2 >= 6) {
                    int i5 = wrap.get(i + 5) & 255;
                    if (i5 == 0) {
                        this.z = false;
                        this.updateBankIndicator = 0;
                        this.imageVersionIndicator = 3;
                    } else if (i5 == 1) {
                        this.z = true;
                        this.updateBankIndicator = 2;
                        this.imageVersionIndicator = 1;
                    } else if (i5 == 2) {
                        this.z = true;
                        this.updateBankIndicator = 1;
                        this.imageVersionIndicator = 2;
                    }
                }
                if (i2 >= 7) {
                    this.mtu = wrap.getShort(i + 6) & OX00O0xII.f29066Oxx0xo;
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
        if (this.imageVersionIndicator == 0) {
            this.z = false;
        } else {
            b();
        }
        a();
    }

    public void parseX0011(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            ZLogger.v(String.format(Locale.US, "invalid offset:%d, len is %d", Integer.valueOf(i), Integer.valueOf(remaining)));
            return;
        }
        int i2 = remaining - i;
        if (i2 >= 1) {
            this.icType = wrap.get(i) & 255;
        }
        if (i2 >= 2) {
            this.specVersion = (byte) (wrap.get(i + 1) & 15);
        }
        if (this.specVersion <= 5) {
            if (i2 >= 3) {
                this.secureVersion = wrap.get(i + 2);
            }
            if (i2 >= 4) {
                byte b = wrap.get(i + 3);
                this.mode = b & 255;
                this.i = (b & 1) != 0;
                this.j = ((b & 2) >> 1) != 0;
                this.k = (b & 4) >> 2;
                this.l = ((b & 8) >> 3) != 0;
                this.m = (b & 16) >> 4;
                this.n = ((b & 32) >> 5) != 0;
                this.o = (b & 64) >> 6;
            }
            if (i2 >= 5) {
                this.q = wrap.get(4 + i) & 1;
            }
            if (i2 >= 7) {
                this.otaTempBufferSize = wrap.get(6 + i) & 255;
            }
            if (i2 >= 12) {
                this.imageVersionIndicator = wrap.getInt(i + 8);
            }
            if (this.imageVersionIndicator == 0) {
                this.z = false;
            } else {
                b();
            }
        } else {
            if (i2 >= 3) {
                byte b2 = wrap.get(i + 2);
                this.mode = b2 & 255;
                this.i = (b2 & 1) != 0;
                this.j = ((b2 & 2) >> 1) != 0;
                this.k = (b2 & 4) >> 2;
                this.m = (b2 & 8) >> 3;
                int i3 = (b2 & 48) >> 4;
                this.r = i3 == 1;
                this.s = i3 == 2;
            }
            if (i2 >= 4) {
                byte b3 = wrap.get(i + 3);
                int i4 = b3 & 3;
                this.q = i4;
                this.o = (b3 & 12) >> 2;
                this.n = i4 == 2;
            }
            if (i2 >= 5) {
                this.otaTempBufferSize = wrap.get(4 + i) & 255;
            }
            if (i2 >= 6) {
                int i5 = wrap.get(5 + i) & 255;
                if (i5 == 0) {
                    this.z = false;
                    this.updateBankIndicator = 0;
                    this.imageVersionIndicator = 3;
                } else if (i5 == 1) {
                    this.z = true;
                    this.updateBankIndicator = 2;
                    this.imageVersionIndicator = 1;
                } else if (i5 == 2) {
                    this.z = true;
                    this.updateBankIndicator = 1;
                    this.imageVersionIndicator = 2;
                }
            }
            if (i2 >= 7) {
                this.mtu = wrap.getShort(i + 6) & OX00O0xII.f29066Oxx0xo;
            }
        }
        a();
    }

    public void parseX0012(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int remaining = wrap.remaining();
        if (remaining <= i) {
            return;
        }
        int i2 = remaining - i;
        try {
            if (i2 <= 1) {
                this.icType = 3;
                this.specVersion = 0;
                this.appFreeBank = (byte) (wrap.get(i) & 15);
                byte b = (byte) ((wrap.get(i) & 240) >> 4);
                this.patchFreeBank = b;
                int i3 = this.appFreeBank;
                if (i3 == 15 && b == 15) {
                    this.z = false;
                    this.updateBankIndicator = 0;
                } else {
                    this.z = true;
                    if (i3 != 1 && b != 1) {
                        this.updateBankIndicator = 1;
                    }
                    this.updateBankIndicator = 2;
                }
                setMode(2);
                return;
            }
            this.icType = wrap.get(i) & 255;
            this.specVersion = (byte) (15 & wrap.get(i + 1));
            if (i2 >= 3) {
                this.secureVersion = wrap.get(i + 2) & 255;
            }
            if (i2 >= 4) {
                setMode(wrap.get(i + 3));
            }
            if (i2 >= 5) {
                this.maxBufferchecksize = wrap.getShort(i + 4) & OX00O0xII.f29066Oxx0xo;
            }
            if (i2 >= 7) {
                this.otaTempBufferSize = wrap.get(i + 6) & 255;
            }
            if (i2 >= 12) {
                this.imageVersionIndicator = wrap.getInt(i + 8);
            }
            c();
            if (this.imageVersionIndicator == 0) {
                this.z = false;
            } else {
                b();
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void setBatteryLevel(int i, int i2) {
        this.f = true;
        this.g = i;
        this.h = i2;
    }

    public final void b() {
        this.updateBankIndicator = 0;
        for (int i = 0; i < 16; i++) {
            int i2 = (this.imageVersionIndicator >> (i * 2)) & 3;
            if (i2 == 1) {
                if (this.updateBankIndicator == 0) {
                    this.updateBankIndicator = 2;
                }
            } else if (i2 == 2) {
                this.updateBankIndicator = 1;
            }
        }
        this.z = this.updateBankIndicator != 0;
        ZLogger.v(String.format("imageVersionIndicator = 0x%08x, bankEnabled=%b, updateBankIndicator=0x%02X", Integer.valueOf(this.imageVersionIndicator), Boolean.valueOf(this.z), Integer.valueOf(this.updateBankIndicator)));
    }

    public final void a() {
        if (this.z) {
            this.y = 2;
            return;
        }
        if (this.m == 1) {
            if (this.otaTempBufferSize != 0) {
                this.y = 3;
                return;
            } else {
                this.y = 2;
                return;
            }
        }
        this.y = 1;
    }
}
