package com.realsil.sdk.dfu.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.wrapper.BinImageWrapper;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes11.dex */
public class DfuUtils {
    public static int IMAGE_VERSION_FORMAT;
    public static final int IMAGE_VERSION_FORMAT_AUTO = 0;

    public static int binarySearch(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length - 1;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = (i2 + length) >>> 1;
                int i4 = iArr[i3];
                if (i4 < i) {
                    i2 = i3 + 1;
                } else if (i4 > i) {
                    length = i3 - 1;
                } else {
                    return i3;
                }
            }
            return ~i2;
        }
        return -1;
    }

    public static String convertVersion2Str(int i, int i2) {
        return convertVersion2Str(0, i, i2);
    }

    public static String formatBatteryLevel(int i) {
        return String.format(Locale.US, "%d%%", Integer.valueOf(i));
    }

    public static String formatImageVersionWithBinId(int i, int i2, int i3, int i4) {
        return new BinImageWrapper.Builder().setOtaVersion(i3).icType(i).binId(i2).imageVersion(i4, 2).build().getFormattedVersion();
    }

    public static String formatImageVersionWithBitNumber(int i, int i2, int i3, int i4) {
        return new BinImageWrapper.Builder().setOtaVersion(i3).imageVersion(i4).icType(i).bitNumber(i2).imageVersion(i4, 1).build().getFormattedVersion();
    }

    public static String formatLinkKey(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                if ((b & 255) <= 15) {
                    sb.append("0" + Integer.toHexString(bArr[i] & 255).toUpperCase());
                } else {
                    sb.append(Integer.toHexString(b & 255).toUpperCase());
                }
                if (i < length - 1) {
                    sb.append(":");
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static String formatManufacturerAddr(String str) {
        char[] charArray = str.toCharArray();
        char[] cArr = new char[17];
        int i = 0;
        int i2 = 0;
        while (i < 17) {
            int i3 = i + 1;
            if (i3 % 3 == 0) {
                cArr[i] = ':';
            } else {
                cArr[i] = charArray[i2];
                i2++;
            }
            i = i3;
        }
        return String.valueOf(cArr);
    }

    public static String genNonceHexString(int i) {
        int i2 = i * 2;
        if (i2 <= 0) {
            return "";
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("0123456789ABCDEF".charAt(random.nextInt(16)));
        }
        return sb.toString();
    }

    public static String getAssetsFileName(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            if (lastIndexOf != 0) {
                str.substring(0, lastIndexOf + 1);
            }
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static int getBatteryLevel(int i) {
        if (i >= 80) {
            return 5;
        }
        if (i >= 60) {
            return 4;
        }
        if (i >= 40) {
            return 3;
        }
        if (i >= 20) {
            return 2;
        }
        return i >= 1 ? 1 : 0;
    }

    public static int getControlSpeed(int i) {
        switch (i) {
            case 1:
                return 3000;
            case 2:
                return DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            case 3:
                return 2000;
            case 4:
                return 1500;
            case 5:
                return 1000;
            case 6:
                return 500;
            default:
                return -1;
        }
    }

    public static int getImageVersionFormatWithBitNumber(int i, int i2) {
        if (i <= 3) {
            return 7;
        }
        if (i != 5 && i != 9 && i != 12) {
            switch (i2) {
                case 0:
                case 1:
                case 9:
                    break;
                case 2:
                default:
                    return 1;
                case 3:
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                case 7:
                    return 515;
                case 8:
                    return 514;
            }
        } else if (i2 != 2) {
            return 3;
        }
        return 2;
    }

    public static int getSocImageVersionFormatWithBitNumber(int i, boolean z, int i2, int i3) {
        if (i2 <= 3) {
            return 7;
        }
        if (i2 != 5 && i2 != 9 && i2 != 12) {
            switch (i3) {
                case 0:
                case 1:
                case 9:
                    break;
                case 2:
                default:
                    return 1;
                case 3:
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                case 7:
                    return 515;
                case 8:
                    return 514;
            }
        } else if (i3 != 2) {
            return 3;
        }
        return 2;
    }

    public static boolean isAssetsFileExist(Context context, String str) {
        String[] list;
        AssetManager assets = context.getResources().getAssets();
        if (assets == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        String str2 = "";
        if (lastIndexOf != -1) {
            if (lastIndexOf != 0) {
                str2 = str.substring(0, lastIndexOf);
            }
            str = str.substring(lastIndexOf + 1);
        }
        try {
            list = assets.list(str2);
        } catch (IOException e) {
            ZLogger.w(e.toString());
        }
        if (list != null && list.length > 0) {
            for (String str3 : list) {
                if (str.equals(str3)) {
                    ZLogger.v("\t =" + str3);
                    return true;
                }
                ZLogger.v("\t =" + str3);
            }
            ZLogger.v(String.format("not find asset file: <%s>/<%s>", str2, str));
            return false;
        }
        ZLogger.d(String.format("no asset file found: <%s>/<%s>", str2, str));
        return false;
    }

    public static String convertVersion2Str(int i, int i2, int i3) {
        if (i <= 0) {
            return String.valueOf(i2);
        }
        if (i3 == 1) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i2 & 255), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf((i2 >> 16) & 255), Integer.valueOf((i2 >> 24) & 255));
        }
        if (i3 == 2) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i2 >> 24) & 255), Integer.valueOf((i2 >> 16) & 255), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255));
        }
        if (i3 == 3) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i2 & 15), Integer.valueOf((i2 >> 4) & 255), Integer.valueOf((i2 >> 12) & 32767), Integer.valueOf((i2 >> 27) & 31));
        }
        if (i3 == 5) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i2 & 15), Integer.valueOf((i2 >> 4) & 255), Integer.valueOf((i2 >> 12) & 511), Integer.valueOf((i2 >> 21) & 2047));
        }
        if (i3 == 515) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i2 >> 24) & 255), Integer.valueOf((i2 >> 16) & 255), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255));
        }
        if (i3 == 4) {
            return String.valueOf(i2);
        }
        if (i3 == 7) {
            return String.valueOf(i2);
        }
        if (i3 == 514) {
            return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255), Integer.valueOf((i2 >> 24) & 255), Integer.valueOf((i2 >> 16) & 255));
        }
        return String.valueOf(i2);
    }
}
