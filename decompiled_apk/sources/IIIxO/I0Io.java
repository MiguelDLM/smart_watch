package IIIxO;

import OXOo.OOXIXo;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,643:1\n13384#2,3:644\n13384#2,3:647\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n580#1:644,3\n597#1:647,3\n*E\n"})
/* loaded from: classes6.dex */
public final class I0Io {

    /* renamed from: I0Io */
    @OOXIXo
    public static final byte[] f224I0Io;

    /* renamed from: II0xO0 */
    @OOXIXo
    public static final int[] f225II0xO0;

    /* renamed from: oIX0oI */
    @OOXIXo
    public static final byte[] f226oIX0oI;

    /* renamed from: oxoX */
    @OOXIXo
    public static final int[] f227oxoX;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f226oIX0oI = bArr;
        int[] iArr = new int[256];
        int i = 0;
        ooOOo0oXI.OxO(iArr, -1, 0, 0, 6, null);
        iArr[61] = -2;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            iArr[bArr[i2]] = i3;
            i2++;
            i3++;
        }
        f225II0xO0 = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f224I0Io = bArr2;
        int[] iArr2 = new int[256];
        ooOOo0oXI.OxO(iArr2, -1, 0, 0, 6, null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i4 = 0;
        while (i < length2) {
            iArr2[bArr2[i]] = i4;
            i++;
            i4++;
        }
        f227oxoX = iArr2;
    }

    @XO
    @oxxXoxO(version = "1.8")
    public static final boolean Oxx0IOOO(int i) {
        if (i >= 0) {
            int[] iArr = f225II0xO0;
            if (i < iArr.length && iArr[i] != -1) {
                return true;
            }
        }
        return false;
    }

    @XO
    public static /* synthetic */ void X0o0xo() {
    }

    @XO
    public static /* synthetic */ void XO() {
    }
}
