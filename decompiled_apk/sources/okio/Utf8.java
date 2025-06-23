package okio;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XO0OX.xxIXOIIO(name = "Utf8")
@XX({"SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n74#3:561\n68#3:562\n74#3:573\n68#3:594\n74#3:600\n68#3:642\n74#3:648\n68#3:703\n74#3:714\n68#3:735\n74#3:741\n68#3:783\n74#3:789\n74#3:845\n74#3:847\n74#3:849\n74#3:851\n74#3:853\n74#3:855\n74#3:857\n74#3:859\n74#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n"})
/* loaded from: classes6.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && i < 32) || (127 <= i && i < 160);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(@OXOo.OOXIXo byte[] bArr, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> yield) {
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(yield, "yield");
        int i3 = i + 1;
        if (i2 <= i3) {
            yield.invoke(65533);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            int i4 = (b2 ^ 3968) ^ (b << 6);
            if (i4 < 128) {
                yield.invoke(65533);
                return 2;
            }
            yield.invoke(Integer.valueOf(i4));
            return 2;
        }
        yield.invoke(65533);
        return 1;
    }

    public static final int process3Utf8Bytes(@OXOo.OOXIXo byte[] bArr, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> yield) {
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(yield, "yield");
        int i3 = i + 2;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i3];
            if ((b3 & 192) == 128) {
                int i5 = ((b3 ^ (-123008)) ^ (b2 << 6)) ^ (b << 12);
                if (i5 < 2048) {
                    yield.invoke(65533);
                    return 3;
                }
                if (55296 <= i5 && i5 < 57344) {
                    yield.invoke(65533);
                    return 3;
                }
                yield.invoke(Integer.valueOf(i5));
                return 3;
            }
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(65533);
        return 1;
    }

    public static final int process4Utf8Bytes(@OXOo.OOXIXo byte[] bArr, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> yield) {
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(yield, "yield");
        int i3 = i + 3;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            int i5 = i + 2;
            if (i2 <= i5 || (bArr[i5] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i + 2];
            if ((b3 & 192) == 128) {
                byte b4 = bArr[i3];
                if ((b4 & 192) == 128) {
                    int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
                    if (i6 > 1114111) {
                        yield.invoke(65533);
                        return 4;
                    }
                    if (55296 <= i6 && i6 < 57344) {
                        yield.invoke(65533);
                        return 4;
                    }
                    if (i6 < 65536) {
                        yield.invoke(65533);
                        return 4;
                    }
                    yield.invoke(Integer.valueOf(i6));
                    return 4;
                }
                yield.invoke(65533);
                return 3;
            }
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(65533);
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f1, code lost:
    
        if ((r11[r0] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0084, code lost:
    
        if ((r11[r0] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void processUtf16Chars(@OXOo.OOXIXo byte[] r11, int r12, int r13, @OXOo.OOXIXo Oox.oOoXoXO<? super java.lang.Character, kotlin.oXIO0o0XI> r14) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, Oox.oOoXoXO):void");
    }

    public static final void processUtf8Bytes(@OXOo.OOXIXo String str, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, oXIO0o0XI> yield) {
        int i3;
        char charAt;
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(yield, "yield");
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (IIX0o.oI0IIXIo(charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && IIX0o.oI0IIXIo(str.charAt(i), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (IIX0o.oI0IIXIo(charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 <= charAt2 && charAt2 < 57344) {
                    if (IIX0o.oI0IIXIo(charAt2, 56319) <= 0 && i2 > (i3 = i + 1) && 56320 <= (charAt = str.charAt(i3)) && charAt < 57344) {
                        int charAt3 = ((charAt2 << '\n') + str.charAt(i3)) - 56613888;
                        yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                        i += 2;
                    } else {
                        yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                } else {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                }
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ef, code lost:
    
        if ((r11[r0] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if ((r11[r0] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void processUtf8CodePoints(@OXOo.OOXIXo byte[] r11, int r12, int r13, @OXOo.OOXIXo Oox.oOoXoXO<? super java.lang.Integer, kotlin.oXIO0o0XI> r14) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, Oox.oOoXoXO):void");
    }

    @XO0OX.xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    @XO0OX.xoIox
    public static final long size(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    @XO0OX.xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    @XO0OX.xoIox
    public static final long size(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return size$default(str, i, 0, 2, null);
    }

    @XO0OX.xxIXOIIO(name = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE)
    @XO0OX.xoIox
    public static final long size(@OXOo.OOXIXo String str, int i, int i2) {
        int i3;
        IIX0o.x0xO0oo(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            long j = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    j++;
                } else {
                    if (charAt < 2048) {
                        i3 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 = 3;
                    } else {
                        int i4 = i + 1;
                        char charAt2 = i4 < i2 ? str.charAt(i4) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j++;
                            i = i4;
                        } else {
                            j += 4;
                            i += 2;
                        }
                    }
                    j += i3;
                }
                i++;
            }
            return j;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
    }
}
