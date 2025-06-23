package com.bestmafen.baseble.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nByteArrayExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteArrayExt.kt\ncom/bestmafen/baseble/data/ByteArrayExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,124:1\n1#2:125\n13384#3,3:126\n*S KotlinDebug\n*F\n+ 1 ByteArrayExt.kt\ncom/bestmafen/baseble/data/ByteArrayExtKt\n*L\n103#1:126,3\n*E\n"})
/* loaded from: classes8.dex */
public final class ByteArrayExtKt {
    @OOXIXo
    public static final byte[] append(@oOoXoXO byte[] bArr, @oOoXoXO byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return new byte[0];
        }
        if (bArr == null) {
            IIX0o.ooOOo0oXI(bArr2);
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        return ooOOo0oXI.IXX(bArr, bArr2);
    }

    @OOXIXo
    public static final byte[] byteArrayOfBoolean(boolean z) {
        return new byte[]{z ? (byte) 1 : (byte) 0};
    }

    @OOXIXo
    public static final byte[] byteArrayOfInt16(int i, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        byte[] bArr = new byte[2];
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            bArr[0] = (byte) ((i >> 8) & 255);
            bArr[1] = (byte) (i & 255);
        } else {
            bArr[1] = (byte) ((i >> 8) & 255);
            bArr[0] = (byte) (i & 255);
        }
        return bArr;
    }

    @OOXIXo
    public static final byte[] byteArrayOfInt24(int i, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        byte[] bArr = new byte[3];
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            bArr[0] = (byte) ((i >> 16) & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
            bArr[2] = (byte) (i & 255);
        } else {
            bArr[2] = (byte) ((i >> 16) & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
            bArr[0] = (byte) (i & 255);
        }
        return bArr;
    }

    @OOXIXo
    public static final byte[] byteArrayOfInt32(int i, @OOXIXo ByteOrder order) {
        IIX0o.x0xO0oo(order, "order");
        byte[] bArr = new byte[4];
        if (IIX0o.Oxx0IOOO(order, ByteOrder.BIG_ENDIAN)) {
            bArr[0] = (byte) ((i >> 24) & 255);
            bArr[1] = (byte) ((i >> 16) & 255);
            bArr[2] = (byte) ((i >> 8) & 255);
            bArr[3] = (byte) (i & 255);
        } else {
            bArr[0] = (byte) (i & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
            bArr[2] = (byte) ((i >> 16) & 255);
            bArr[3] = (byte) ((i >> 24) & 255);
        }
        return bArr;
    }

    @OOXIXo
    public static final byte[] byteArrayOfInt8(int i) {
        return new byte[]{(byte) i};
    }

    public static final int getInt(@OOXIXo byte[] bArr, int i, int i2, @OOXIXo ByteOrder byteOrder) {
        byte b;
        int i3;
        int i4;
        byte b2;
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(byteOrder, "byteOrder");
        if (i2 >= 1 && i2 <= 4) {
            if (i + i2 > bArr.length) {
                return 0;
            }
            if (IIX0o.Oxx0IOOO(byteOrder, ByteOrder.BIG_ENDIAN)) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return 0;
                            }
                            i3 = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
                            b2 = bArr[i + 3];
                        } else {
                            i3 = ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
                            b2 = bArr[i + 2];
                        }
                    } else {
                        i3 = (bArr[i] & 255) << 8;
                        b2 = bArr[i + 1];
                    }
                    i4 = b2 & 255;
                    return i3 | i4;
                }
                b = bArr[i];
                return b & 255;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return 0;
                        }
                        i3 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
                        i4 = (bArr[i + 3] & 255) << 24;
                    } else {
                        i3 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
                        i4 = (bArr[i + 2] & 255) << 16;
                    }
                } else {
                    i3 = bArr[i] & 255;
                    i4 = (bArr[i + 1] & 255) << 8;
                }
                return i3 | i4;
            }
            b = bArr[i];
            return b & 255;
        }
        throw new IllegalArgumentException("length must be in [1, 4]");
    }

    public static /* synthetic */ int getInt$default(byte[] bArr, int i, int i2, ByteOrder BIG_ENDIAN, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
            IIX0o.oO(BIG_ENDIAN, "BIG_ENDIAN");
        }
        return getInt(bArr, i, i2, BIG_ENDIAN);
    }

    @OOXIXo
    public static final String getMHexString(@oOoXoXO byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        return ArraysKt___ArraysKt.XoXoOo(bArr, ", ", null, null, 0, null, new Oox.oOoXoXO<Byte, CharSequence>() { // from class: com.bestmafen.baseble.data.ByteArrayExtKt$mHexString$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }

            @OOXIXo
            public final CharSequence invoke(byte b) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("0x%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                IIX0o.oO(format, "format(...)");
                return format;
            }
        }, 30, null);
    }

    @OOXIXo
    public static final List<byte[]> splitWith0(@oOoXoXO byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            int i4 = 0;
            while (i2 < length) {
                byte b = bArr[i2];
                int i5 = i3 + 1;
                if (i3 >= i) {
                    if (b == 0) {
                        if (z) {
                            arrayList.add(ooOOo0oXI.xxOXOOoIX(bArr, i4, i3));
                            z = false;
                        }
                    } else {
                        if (!z) {
                            z = true;
                            i4 = i3;
                        }
                        if (i3 == ArraysKt___ArraysKt.xxXIIXIxx(bArr) && z) {
                            arrayList.add(ooOOo0oXI.xxOXOOoIX(bArr, i4, i5));
                        }
                    }
                }
                i2++;
                i3 = i5;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List splitWith0$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return splitWith0(bArr, i);
    }
}
