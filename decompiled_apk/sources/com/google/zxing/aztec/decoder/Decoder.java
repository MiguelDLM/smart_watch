package com.google.zxing.aztec.decoder;

import OoOoXO0.xoXoI;
import XXO0.oIX0oI;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.util.xoIox;
import com.tenmeter.smlibrary.utils.FileUtils;
import com.vtrump.vtble.Oxx0IOOO;
import java.util.Arrays;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.text.ooOOo0oXI;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes10.dex */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", xoIox.f24717xXxxox0I, Oxx0IOOO.f27277xI, ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", Api.Y, "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", e.TAG, f.f6163a, "g", IAdInterListener.AdReqParam.HEIGHT, "i", "j", t.f18411a, "l", "m", "n", "o", "p", "q", "r", "s", "t", t.i, t.c, IAdInterListener.AdReqParam.WIDTH, "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", xXOx.f32950X0o0xo, "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", xXOx.f32950X0o0xo, "\r\n", ". ", ", ", ": ", "!", "\"", xoXoI.f2670oxoX, "$", "%", "&", "'", oIX0oI.I0Io.f4096II0xO0, oIX0oI.I0Io.f4095I0Io, "*", xoXoI.f2668X0o0xo, ",", HelpFormatter.DEFAULT_OPT_PREFIX, FileUtils.FILE_EXTENSION_SEPARATOR, "/", ":", x.aL, "<", "=", ">", LocationInfo.NA, "[", "]", "{", ooOOo0oXI.f33074oOoXoXO, "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", FileUtils.FILE_EXTENSION_SEPARATOR, "CTRL_UL", "CTRL_US"};

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = readByte(zArr, i << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        int i;
        GenericGF genericGF;
        boolean z;
        boolean z2;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i = 6;
        } else {
            i = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = GenericGF.AZTEC_DATA_10;
                i = 10;
            } else {
                genericGF = GenericGF.AZTEC_DATA_12;
                i = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length >= nbDatablocks) {
            int length2 = zArr.length % i;
            int[] iArr = new int[length];
            int i2 = 0;
            while (i2 < length) {
                iArr[i2] = readCode(zArr, length2, i);
                i2++;
                length2 += i;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i3 = 1 << i;
                int i4 = i3 - 1;
                int i5 = 0;
                for (int i6 = 0; i6 < nbDatablocks; i6++) {
                    int i7 = iArr[i6];
                    if (i7 != 0 && i7 != i4) {
                        if (i7 == 1 || i7 == i3 - 2) {
                            i5++;
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                boolean[] zArr2 = new boolean[(nbDatablocks * i) - i5];
                int i8 = 0;
                for (int i9 = 0; i9 < nbDatablocks; i9++) {
                    int i10 = iArr[i9];
                    if (i10 != 1 && i10 != i3 - 2) {
                        int i11 = i - 1;
                        while (i11 >= 0) {
                            int i12 = i8 + 1;
                            if (((1 << i11) & i10) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zArr2[i8] = z2;
                            i11--;
                            i8 = i12;
                        }
                    } else {
                        int i13 = (i8 + i) - 1;
                        if (i10 > 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Arrays.fill(zArr2, i8, i13, z);
                        i8 += i - 1;
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e) {
                throw FormatException.getFormatInstance(e);
            }
        }
        throw FormatException.getFormatInstance();
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        int i;
        int i2;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        if (isCompact) {
            i = 11;
        } else {
            i = 14;
        }
        int i3 = i + (nbLayers << 2);
        int[] iArr = new int[i3];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i4 = 2;
        if (isCompact) {
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i5] = i5;
            }
        } else {
            int i6 = i3 / 2;
            int i7 = ((i3 + 1) + (((i6 - 1) / 15) * 2)) / 2;
            for (int i8 = 0; i8 < i6; i8++) {
                iArr[(i6 - i8) - 1] = (i7 - r12) - 1;
                iArr[i6 + i8] = (i8 / 15) + i8 + i7 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < nbLayers) {
            int i11 = (nbLayers - i9) << i4;
            if (isCompact) {
                i2 = 9;
            } else {
                i2 = 12;
            }
            int i12 = i11 + i2;
            int i13 = i9 << 1;
            int i14 = (i3 - 1) - i13;
            int i15 = 0;
            while (i15 < i12) {
                int i16 = i15 << 1;
                int i17 = 0;
                while (i17 < i4) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i10 + i16 + i17] = bitMatrix.get(iArr[i18], iArr[i19]);
                    int i20 = iArr[i19];
                    int i21 = i14 - i17;
                    boolean z = isCompact;
                    zArr[(i12 * 2) + i10 + i16 + i17] = bitMatrix.get(i20, iArr[i21]);
                    int i22 = i14 - i15;
                    zArr[(i12 * 4) + i10 + i16 + i17] = bitMatrix.get(iArr[i21], iArr[i22]);
                    zArr[(i12 * 6) + i10 + i16 + i17] = bitMatrix.get(iArr[i22], iArr[i18]);
                    i17++;
                    nbLayers = nbLayers;
                    isCompact = z;
                    i4 = 2;
                }
                i15++;
                i4 = 2;
            }
            i10 += i12 << 3;
            i9++;
            i4 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return DIGIT_TABLE[i];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return PUNCT_TABLE[i];
                }
                return MIXED_TABLE[i];
            }
            return LOWER_TABLE[i];
        }
        return UPPER_TABLE[i];
    }

    private static String getEncodedData(boolean[] zArr) {
        int i;
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i2 = 0;
        while (i2 < length) {
            if (table == Table.BINARY) {
                if (length - i2 < 5) {
                    break;
                }
                int readCode = readCode(zArr, i2, 5);
                int i3 = i2 + 5;
                if (readCode == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    readCode = readCode(zArr, i3, 11) + 31;
                    i3 = i2 + 16;
                }
                int i4 = 0;
                while (true) {
                    if (i4 < readCode) {
                        if (length - i3 < 8) {
                            i2 = length;
                            break;
                        }
                        sb.append((char) readCode(zArr, i3, 8));
                        i3 += 8;
                        i4++;
                    } else {
                        i2 = i3;
                        break;
                    }
                }
                table = table2;
            } else {
                if (table == Table.DIGIT) {
                    i = 4;
                } else {
                    i = 5;
                }
                if (length - i2 < i) {
                    break;
                }
                int readCode2 = readCode(zArr, i2, i);
                i2 += i;
                String character = getCharacter(table, readCode2);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(character);
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c) {
        if (c != 'B') {
            if (c != 'D') {
                if (c != 'P') {
                    if (c != 'L') {
                        if (c != 'M') {
                            return Table.UPPER;
                        }
                        return Table.MIXED;
                    }
                    return Table.LOWER;
                }
                return Table.PUNCT;
            }
            return Table.DIGIT;
        }
        return Table.BINARY;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i) {
        int readCode;
        int length = zArr.length - i;
        if (length >= 8) {
            readCode = readCode(zArr, i, 8);
        } else {
            readCode = readCode(zArr, i, length) << (8 - length);
        }
        return (byte) readCode;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
