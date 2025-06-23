package com.realsil.sdk.dfu.f;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.RtkDfu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19540a;
    public int b;
    public int c;
    public byte[] d;

    public a(int i, int i2, byte[] bArr) {
        this.f19540a = false;
        this.b = i;
        this.c = i2;
        this.d = bArr;
        this.f19540a = RtkDfu.VDBG;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0024. Please report as an issue. */
    public static boolean a(int i) {
        if (i != 27 && i != 32 && i != 34 && i != 254 && i != 29 && i != 30 && i != 1 && i != 2 && i != 3 && i != 4) {
            switch (i) {
                default:
                    switch (i) {
                        case 80:
                        case 81:
                        case 82:
                            break;
                        default:
                            return false;
                    }
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    return true;
            }
        }
        return true;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return String.format(Locale.US, "definedId:0x%04d, data: (%d) %s", Integer.valueOf(this.b), Integer.valueOf(this.c), DataConverter.bytes2Hex(this.d));
    }

    public byte[] a() {
        return this.d;
    }

    public static boolean a(byte[] bArr, int i, int i2, byte b) {
        while (i <= i2) {
            if ((bArr[i] & 255) != b) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static List<a> a(byte[] bArr) {
        int i;
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i4 = ((bArr[i2 + 1] << 8) & 65280) | (bArr[i2] & 255);
            int i5 = i2 + 2;
            i2 += 3;
            byte b = bArr[i5];
            if (!a(i4)) {
                int i6 = length - 1;
                if (!a(bArr, i2, i6, (byte) 0) && !a(bArr, i2, i6, (byte) -1)) {
                    ZLogger.v(RtkDfu.VDBG, String.format("undefined mp type: 0x%04X", Integer.valueOf(i4)));
                } else {
                    ZLogger.v(RtkDfu.VDBG, "no more data");
                }
            } else if (b != 0) {
                int i7 = i2 + b;
                if (i7 > length) {
                    ZLogger.d("invalid mp header length");
                    break;
                }
                try {
                    a aVar = new a(i4, b, Arrays.copyOfRange(bArr, i2, i7));
                    if (i4 == 1) {
                        i = i3 | 1;
                    } else if (i4 == 2) {
                        i = i3 | 2;
                    } else if (i4 == 3) {
                        i = i3 | 4;
                    } else {
                        if (i4 == 4) {
                            i = i3 | 8;
                        }
                        arrayList.add(aVar);
                        i2 = i7;
                    }
                    i3 = i;
                    arrayList.add(aVar);
                    i2 = i7;
                } catch (Exception e) {
                    ZLogger.w(e.toString());
                }
            }
        }
        if (i3 == 15) {
            return arrayList;
        }
        ZLogger.d(String.format("miss required type 0x%04X", Integer.valueOf(i3)));
        return null;
    }
}
