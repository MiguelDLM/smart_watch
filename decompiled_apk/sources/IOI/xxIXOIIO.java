package IOI;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.DateTimeFormatException;

@kotlin.jvm.internal.XX({"SMAP\nDateTimePeriod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimePeriod.kt\nkotlinx/datetime/DateTimePeriod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,461:1\n1#2:462\n*E\n"})
@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.II0xO0.class)
/* loaded from: classes6.dex */
public abstract class xxIXOIIO {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public static final int I0Io(long j, int i, char c) {
            if (j >= com.garmin.fit.O0Xx.f12378xXxxox0I && j <= 2147483647L) {
                return (int) j;
            }
            II0xO0("Value " + j + " does not fit into an Int, which is required for component '" + c + '\'', i);
            throw new KotlinNothingValueException();
        }

        public static final Void II0xO0(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        @OXOo.OOXIXo
        public final xxIXOIIO oIX0oI(@OXOo.OOXIXo String text) {
            int i;
            int i2;
            char charAt;
            int i3;
            char charAt2;
            kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
            int i4 = 0;
            int i5 = 0;
            char c = 0;
            int i6 = 1;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i5 < text.length()) {
                if (c == 0) {
                    int i15 = i5 + 1;
                    if (i15 >= text.length() && (text.charAt(i5) == '+' || text.charAt(i5) == '-')) {
                        II0xO0("Unexpected end of string; 'P' designator is required", i5);
                        throw new KotlinNothingValueException();
                    }
                    char charAt3 = text.charAt(i5);
                    if (charAt3 == '+' || charAt3 == '-') {
                        if (text.charAt(i5) == '-') {
                            i6 = -1;
                        }
                        if (text.charAt(i15) == 'P') {
                            i5 += 2;
                        } else {
                            II0xO0("Expected 'P', got '" + text.charAt(i15) + '\'', i15);
                            throw new KotlinNothingValueException();
                        }
                    } else if (charAt3 == 'P') {
                        i5 = i15;
                    } else {
                        II0xO0("Expected '+', '-', 'P', got '" + text.charAt(i5) + '\'', i5);
                        throw new KotlinNothingValueException();
                    }
                    i4 = 0;
                    c = 1;
                } else {
                    char charAt4 = text.charAt(i5);
                    if (charAt4 == '+' || charAt4 == '-') {
                        if (text.charAt(i5) == '-') {
                            i = i6 * (-1);
                        } else {
                            i = i6;
                        }
                        i2 = i5 + 1;
                        if (i2 >= text.length() || '0' > (charAt = text.charAt(i2)) || charAt >= ':') {
                            II0xO0("A number expected after '" + text.charAt(i2) + '\'', i2);
                            throw new KotlinNothingValueException();
                        }
                    } else if (('0' > charAt4 || charAt4 >= ':') && charAt4 == 'T') {
                        if (c < 6) {
                            i5++;
                            i4 = 0;
                            c = 6;
                        } else {
                            II0xO0("Only one 'T' designator is allowed", i5);
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        i2 = i5;
                        i = i6;
                    }
                    long j = 0;
                    int i16 = i6;
                    while (true) {
                        if (i2 < text.length()) {
                            char charAt5 = text.charAt(i2);
                            i3 = i7;
                            if ('0' > charAt5 || charAt5 >= ':') {
                                break;
                            }
                            try {
                                j = OOOox.Oxx0IOOO.II0xO0(OOOox.Oxx0IOOO.oxoX(j, 10L), text.charAt(i2) - '0');
                                i2++;
                                i7 = i3;
                            } catch (ArithmeticException unused) {
                                II0xO0("The number is too large", i5);
                                throw new KotlinNothingValueException();
                            }
                        } else {
                            i3 = i7;
                            break;
                        }
                    }
                    long j2 = j * i;
                    if (i2 != text.length()) {
                        char upperCase = Character.toUpperCase(text.charAt(i2));
                        int i17 = i8;
                        int i18 = i9;
                        if (upperCase == 'Y') {
                            if (c < 2) {
                                i9 = I0Io(j2, i5, 'Y');
                                i7 = i3;
                                i8 = i17;
                                c = 2;
                            } else {
                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                        } else if (upperCase == 'M') {
                            if (c >= 6) {
                                if (c < '\b') {
                                    i13 = I0Io(j2, i5, 'M');
                                    i7 = i3;
                                    i8 = i17;
                                    i9 = i18;
                                    c = '\b';
                                } else {
                                    II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                }
                            } else if (c < 3) {
                                i10 = I0Io(j2, i5, 'M');
                                i7 = i3;
                                i8 = i17;
                                i9 = i18;
                                c = 3;
                            } else {
                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                        } else if (upperCase == 'W') {
                            if (c < 4) {
                                i8 = I0Io(j2, i5, 'W');
                                i7 = i3;
                                i9 = i18;
                                c = 4;
                            } else {
                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                        } else if (upperCase == 'D') {
                            if (c < 5) {
                                i7 = I0Io(j2, i5, 'D');
                                i8 = i17;
                                i9 = i18;
                                c = 5;
                            } else {
                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                        } else if (upperCase == 'H') {
                            if (c < 7 && c >= 6) {
                                i12 = I0Io(j2, i5, 'H');
                                i7 = i3;
                                i8 = i17;
                                i9 = i18;
                                c = 7;
                            } else {
                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                throw new KotlinNothingValueException();
                            }
                        } else {
                            if (upperCase == 'S') {
                                if (c < '\t' && c >= 6) {
                                    i14 = I0Io(j2, i5, 'S');
                                } else {
                                    II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                }
                            } else if (upperCase == '.' || upperCase == ',') {
                                int i19 = i2 + 1;
                                if (i19 < text.length()) {
                                    i2 = i19;
                                    while (i2 < text.length() && '0' <= (charAt2 = text.charAt(i2)) && charAt2 < ':') {
                                        i2++;
                                    }
                                    int i20 = i2 - i19;
                                    if (i20 <= 9) {
                                        StringBuilder sb = new StringBuilder();
                                        String substring = text.substring(i19, i2);
                                        kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
                                        sb.append(substring);
                                        sb.append(kotlin.text.OxI.xOOxI("0", 9 - i20));
                                        int parseInt = Integer.parseInt(sb.toString(), kotlin.text.II0xO0.oIX0oI(10)) * i;
                                        if (text.charAt(i2) == 'S') {
                                            if (c < '\t' && c >= 6) {
                                                i14 = I0Io(j2, i5, 'S');
                                                i11 = parseInt;
                                            } else {
                                                II0xO0("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            }
                                        } else {
                                            II0xO0("Expected the 'S' designator after a fraction", i2);
                                            throw new KotlinNothingValueException();
                                        }
                                    } else {
                                        II0xO0("Only the nanosecond fractions of a second are supported", i19);
                                        throw new KotlinNothingValueException();
                                    }
                                } else {
                                    II0xO0("Expected designator 'S' after " + text.charAt(i2), i19);
                                    throw new KotlinNothingValueException();
                                }
                            } else {
                                II0xO0("Expected a designator after the numerical value", i2);
                                throw new KotlinNothingValueException();
                            }
                            i7 = i3;
                            i8 = i17;
                            i9 = i18;
                            c = '\t';
                        }
                        i5 = i2 + 1;
                        i6 = i16;
                        i4 = 0;
                    } else {
                        II0xO0("Expected a designator after the numerical value", i2);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (c != 0) {
                if (c != 6) {
                    long j3 = i7 + (i8 * 7);
                    if (com.garmin.fit.O0Xx.f12378xXxxox0I <= j3 && j3 <= 2147483647L) {
                        return OOXIXo.oIX0oI(i9, i10, (int) j3, i12, i13, i14, i11);
                    }
                    II0xO0("The total number of days under 'D' and 'W' designators should fit into an Int", i4);
                    throw new KotlinNothingValueException();
                }
                II0xO0("Unexpected end of input; at least one time component is required after 'T'", i5);
                throw new KotlinNothingValueException();
            }
            II0xO0("Unexpected end of input; 'P' designator is required", i5);
            throw new KotlinNothingValueException();
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<xxIXOIIO> serializer() {
            return kotlinx.datetime.serializers.II0xO0.f30518oIX0oI;
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ xxIXOIIO(kotlin.jvm.internal.IIXOooo iIXOooo) {
        this();
    }

    public int I0Io() {
        return (int) (xxIXOIIO() / OOOox.oIX0oI.f1743OOXIXo);
    }

    public abstract int II0XooXoX();

    public abstract int II0xO0();

    public int Oxx0IOOO() {
        return (int) ((xxIXOIIO() % OOOox.oIX0oI.f1750xoIox) / 1000000000);
    }

    public final int X0o0xo() {
        return II0XooXoX() % 12;
    }

    public int XO() {
        return (int) (xxIXOIIO() % 1000000000);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xxIXOIIO)) {
            return false;
        }
        xxIXOIIO xxixoiio = (xxIXOIIO) obj;
        if (II0XooXoX() == xxixoiio.II0XooXoX() && II0xO0() == xxixoiio.II0xO0() && xxIXOIIO() == xxixoiio.xxIXOIIO()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((II0XooXoX() * 31) + II0xO0()) * 31) + androidx.collection.oIX0oI.oIX0oI(xxIXOIIO());
    }

    public final boolean oIX0oI() {
        if (II0XooXoX() <= 0 && II0xO0() <= 0 && xxIXOIIO() <= 0 && ((II0XooXoX() | II0xO0()) != 0 || xxIXOIIO() != 0)) {
            return true;
        }
        return false;
    }

    public int oxoX() {
        return (int) ((xxIXOIIO() % OOOox.oIX0oI.f1743OOXIXo) / OOOox.oIX0oI.f1750xoIox);
    }

    @OXOo.OOXIXo
    public String toString() {
        int i;
        Object obj;
        StringBuilder sb = new StringBuilder();
        if (oIX0oI()) {
            sb.append('-');
            i = -1;
        } else {
            i = 1;
        }
        sb.append('P');
        if (xoIox() != 0) {
            sb.append(xoIox() * i);
            sb.append('Y');
        }
        if (X0o0xo() != 0) {
            sb.append(X0o0xo() * i);
            sb.append('M');
        }
        if (II0xO0() != 0) {
            sb.append(II0xO0() * i);
            sb.append('D');
        }
        int I0Io2 = I0Io();
        String str = "";
        String str2 = ExifInterface.GPS_DIRECTION_TRUE;
        if (I0Io2 != 0) {
            sb.append(ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(I0Io() * i);
            sb.append('H');
            str2 = "";
        }
        if (oxoX() != 0) {
            sb.append(str2);
            sb.append(oxoX() * i);
            sb.append('M');
        } else {
            str = str2;
        }
        if ((Oxx0IOOO() | XO()) != 0) {
            sb.append(str);
            if (Oxx0IOOO() != 0) {
                obj = Integer.valueOf(Oxx0IOOO() * i);
            } else if (XO() * i < 0) {
                obj = "-0";
            } else {
                obj = "0";
            }
            sb.append(obj);
            if (XO() != 0) {
                sb.append('.');
                sb.append(StringsKt__StringsKt.I0OO(String.valueOf(Math.abs(XO())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public final int xoIox() {
        return II0XooXoX() / 12;
    }

    public abstract long xxIXOIIO();

    public xxIXOIIO() {
    }
}
