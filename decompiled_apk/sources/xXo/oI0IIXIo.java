package xXo;

import com.univocity.parsers.common.DataProcessingException;
import java.lang.Number;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Arrays;

/* loaded from: classes13.dex */
public abstract class oI0IIXIo<T extends Number> extends OxxIIOOXO<T> implements x0XOIxOo<DecimalFormat> {

    /* renamed from: I0Io, reason: collision with root package name */
    public DecimalFormat[] f34697I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final ParsePosition f34698X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Class<? extends Number> f34699XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public String[] f34700oxoX;

    public oI0IIXIo(T t, String str, String... strArr) {
        super(t, str);
        this.f34697I0Io = new DecimalFormat[0];
        this.f34700oxoX = new String[0];
        this.f34698X0o0xo = new ParsePosition(0);
        this.f34699XO = Number.class;
        com.univocity.parsers.common.I0Io.x0xO0oo("Numeric formats", strArr);
        this.f34700oxoX = (String[]) strArr.clone();
        this.f34697I0Io = new DecimalFormat[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.f34697I0Io[i] = new DecimalFormat(strArr[i]);
            oOoXoXO(this.f34697I0Io[i]);
        }
    }

    public void OOXIXo(String str, String... strArr) {
        DecimalFormat decimalFormat = new DecimalFormat(str);
        oOoXoXO(decimalFormat);
        x0OOI.oIX0oI.oxoX(decimalFormat, strArr);
        String[] strArr2 = this.f34700oxoX;
        this.f34700oxoX = (String[]) Arrays.copyOf(strArr2, strArr2.length + 1);
        DecimalFormat[] decimalFormatArr = this.f34697I0Io;
        DecimalFormat[] decimalFormatArr2 = (DecimalFormat[]) Arrays.copyOf(decimalFormatArr, decimalFormatArr.length + 1);
        this.f34697I0Io = decimalFormatArr2;
        this.f34700oxoX[r1.length - 1] = str;
        decimalFormatArr2[decimalFormatArr2.length - 1] = decimalFormat;
    }

    public void Oo(Class<? extends Number> cls) {
        this.f34699XO = cls;
    }

    public Class<? extends Number> oO() {
        return this.f34699XO;
    }

    public abstract void oOoXoXO(DecimalFormat decimalFormat);

    @Override // xXo.OxxIIOOXO
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public T X0o0xo(String str) {
        Class<? extends Number> cls;
        for (int i = 0; i < this.f34697I0Io.length; i++) {
            this.f34698X0o0xo.setIndex(0);
            T t = (T) this.f34697I0Io[i].parse(str, this.f34698X0o0xo);
            if (this.f34697I0Io.length == 1 || this.f34698X0o0xo.getIndex() == str.length()) {
                if (t != null && (cls = this.f34699XO) != Number.class) {
                    if (cls == Double.class) {
                        return Double.valueOf(t.doubleValue());
                    }
                    if (cls == Float.class) {
                        return Float.valueOf(t.floatValue());
                    }
                    if (cls == BigDecimal.class) {
                        if (t instanceof BigDecimal) {
                            return t;
                        }
                        return new BigDecimal(String.valueOf(t));
                    }
                    if (cls == BigInteger.class) {
                        if (t instanceof BigInteger) {
                            return t;
                        }
                        return BigInteger.valueOf(t.longValue());
                    }
                    if (cls == Long.class) {
                        return Long.valueOf(t.longValue());
                    }
                    if (cls == Integer.class) {
                        return Integer.valueOf(t.intValue());
                    }
                    if (cls == Short.class) {
                        return Short.valueOf(t.shortValue());
                    }
                    if (cls == Byte.class) {
                        return Byte.valueOf(t.byteValue());
                    }
                }
                return t;
            }
        }
        throw new DataProcessingException("Cannot parse '" + str + "' as a valid number. Supported formats are: " + Arrays.toString(this.f34700oxoX));
    }

    @Override // xXo.x0XOIxOo
    /* renamed from: x0XOIxOo, reason: merged with bridge method [inline-methods] */
    public DecimalFormat[] I0Io() {
        return this.f34697I0Io;
    }

    @Override // xXo.OxxIIOOXO, xXo.Oxx0IOOO
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(T t) {
        if (t == null) {
            return super.oIX0oI(null);
        }
        for (DecimalFormat decimalFormat : this.f34697I0Io) {
            try {
                return decimalFormat.format(t);
            } catch (Throwable unused) {
            }
        }
        throw new DataProcessingException("Cannot format '" + t + "'. No valid formatters were defined.");
    }

    public oI0IIXIo(T t, String str, DecimalFormat... decimalFormatArr) {
        super(t, str);
        this.f34697I0Io = new DecimalFormat[0];
        this.f34700oxoX = new String[0];
        this.f34698X0o0xo = new ParsePosition(0);
        this.f34699XO = Number.class;
        com.univocity.parsers.common.I0Io.x0xO0oo("Numeric formatters", decimalFormatArr);
        this.f34697I0Io = (DecimalFormat[]) decimalFormatArr.clone();
        this.f34700oxoX = new String[decimalFormatArr.length];
        for (int i = 0; i < decimalFormatArr.length; i++) {
            this.f34700oxoX[i] = decimalFormatArr[i].toPattern();
        }
    }

    public oI0IIXIo(T t, String str) {
        super(t, str);
        this.f34697I0Io = new DecimalFormat[0];
        this.f34700oxoX = new String[0];
        this.f34698X0o0xo = new ParsePosition(0);
        this.f34699XO = Number.class;
    }

    public oI0IIXIo(String... strArr) {
        this((Number) null, (String) null, strArr);
    }

    public oI0IIXIo(DecimalFormat... decimalFormatArr) {
        this((Number) null, (String) null, decimalFormatArr);
    }

    public oI0IIXIo() {
        this.f34697I0Io = new DecimalFormat[0];
        this.f34700oxoX = new String[0];
        this.f34698X0o0xo = new ParsePosition(0);
        this.f34699XO = Number.class;
    }
}
