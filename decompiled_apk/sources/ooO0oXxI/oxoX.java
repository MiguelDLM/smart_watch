package ooO0oXxI;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import xXo.Oxx0IOOO;

/* loaded from: classes13.dex */
public class oxoX implements II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final XO f32305II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String[] f32306oIX0oI;

    public oxoX(String[] strArr, XO xo2) {
        this.f32306oIX0oI = strArr;
        this.f32305II0xO0 = xo2;
    }

    @Override // ooO0oXxI.II0xO0
    public <T extends Enum<T>> Map<T, Object> I0(Class<T> cls, T... tArr) {
        return IIX0o(new EnumMap(cls), tArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Float I0Io(int i, String str, String... strArr) {
        return (Float) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Float.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T I0X0x0oIo(Enum<?> r4, T t) {
        return (T) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r4, t.getClass(), t);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T I0oOIX(String str, T t) {
        return (T) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, t.getClass(), t);
    }

    @Override // ooO0oXxI.II0xO0
    public Date I0oOoX(String str) {
        return (Date) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Date.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger II0XooXoX(int i, String str, String... strArr) {
        return (BigInteger) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, BigInteger.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Map<Integer, String> II0xO0(Map<Integer, String> map, int... iArr) {
        int[] O02 = O0(iArr);
        for (int i = 0; i < O02.length; i++) {
            map.put(Integer.valueOf(O02[i]), getString(O02[i]));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public String IIX0(Enum<?> r3) {
        return this.f32305II0xO0.x0o(this.f32306oIX0oI, r3);
    }

    @Override // ooO0oXxI.II0xO0
    public <T extends Enum<T>> Map<T, Object> IIX0o(Map<T, Object> map, T... tArr) {
        for (Enum<?> r1 : xx0X0(tArr.getClass().getComponentType(), tArr)) {
            map.put(r1, this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r1, null, null));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar IIXOooo(Enum<?> r5) {
        return (Calendar) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Calendar.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Double IIxOXoOo0(String str, String str2, String... strArr) {
        return (Double) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Double.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Character IO(int i) {
        return (Character) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Character.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal IXxxXO(String str, String str2, String... strArr) {
        return (BigDecimal) this.f32305II0xO0.xI(this.f32306oIX0oI, str, BigDecimal.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal Io(int i, String str, String... strArr) {
        return (BigDecimal) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, BigDecimal.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T extends Enum<T>> Map<T, String> IoOoX(Class<T> cls, T... tArr) {
        return ox(new EnumMap(cls), tArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer IoOoo(String str) {
        return (Integer) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Integer.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T Ioxxx(int i, T t, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.IoOoX(this.f32306oIX0oI, i, t, oxx0IOOOArr);
    }

    public final int[] O0(int[] iArr) {
        if (iArr.length == 0) {
            iArr = new int[this.f32306oIX0oI.length];
            for (int i = 0; i < this.f32306oIX0oI.length; i++) {
                iArr[i] = i;
            }
        }
        return iArr;
    }

    @Override // ooO0oXxI.II0xO0
    public Map<String, Object> O00XxXI(String... strArr) {
        return Xx000oIo(new HashMap(strArr.length), strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar O0X(int i, String str, String... strArr) {
        return (Calendar) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Calendar.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar O0Xx(int i) {
        return (Calendar) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Calendar.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Date O0xOxO(Enum<?> r8, String str, String... strArr) {
        return (Date) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Date.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar OI0(String str) {
        return (Calendar) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Calendar.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal OO(Enum<?> r8, String str, String... strArr) {
        return (BigDecimal) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, BigDecimal.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar OO0x0xX(String str, String str2, String... strArr) {
        return (Calendar) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Calendar.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Map<Integer, Object> OOXIXo(int... iArr) {
        return XoX(new HashMap(iArr.length), iArr);
    }

    @Override // ooO0oXxI.II0xO0
    public String[] OOXIxO0() {
        return this.f32306oIX0oI;
    }

    @Override // ooO0oXxI.II0xO0
    public Map<String, String> OX00O0xII(Map<String, String> map, String... strArr) {
        for (String str : xI0oxI00(strArr)) {
            map.put(str, OxxIIOOXO(str));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public Calendar Oo(Enum<?> r8, String str, String... strArr) {
        return (Calendar) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Calendar.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean Ox0O(int i, String str, String str2) {
        return (Boolean) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Boolean.class, Boolean.FALSE, str, str2);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte OxI(Enum<?> r8, String str, String... strArr) {
        return (Byte) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Byte.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public X0o0xo Oxx0IOOO() {
        return this.f32305II0xO0;
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean Oxx0xo(Enum<?> r8, String str, String str2) {
        return (Boolean) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Boolean.class, Boolean.FALSE, str, str2);
    }

    @Override // ooO0oXxI.II0xO0
    public String OxxIIOOXO(String str) {
        return this.f32305II0xO0.XOxIOxOx(this.f32306oIX0oI, str);
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger X00IoxXI(String str) {
        return (BigInteger) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, BigInteger.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Short X0IIOO(String str, String str2, String... strArr) {
        return (Short) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Short.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Long X0o0xo(String str) {
        return (Long) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Long.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Short XI0IXoo(Enum<?> r8, String str, String... strArr) {
        return (Short) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Short.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T XI0oooXX(String str, T t, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.IO(this.f32306oIX0oI, str, t, oxx0IOOOArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Short XIXIX(int i, String str, String... strArr) {
        return (Short) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Short.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Map<String, String> XIo0oOXIx(String... strArr) {
        return OX00O0xII(new HashMap(strArr.length), strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T XIxXXX0x0(int i, T t) {
        return (T) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, t.getClass(), t);
    }

    @Override // ooO0oXxI.II0xO0
    public Double XO(Enum<?> r8, String str, String... strArr) {
        return (Double) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Double.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte XOxIOxOx(int i, String str, String... strArr) {
        return (Byte) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Byte.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte XX(String str) {
        return (Byte) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Byte.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger XX0(String str, String str2, String... strArr) {
        return (BigInteger) this.f32305II0xO0.xI(this.f32306oIX0oI, str, BigInteger.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer XX0xXo(String str, String str2, String... strArr) {
        return (Integer) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Integer.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger Xo0(int i) {
        return (BigInteger) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, BigInteger.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal XoI0Ixx0(int i) {
        return (BigDecimal) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, BigDecimal.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Map<Integer, Object> XoX(Map<Integer, Object> map, int... iArr) {
        int[] O02 = O0(iArr);
        for (int i = 0; i < O02.length; i++) {
            map.put(Integer.valueOf(O02[i]), this.f32305II0xO0.xxX(this.f32306oIX0oI, O02[i], null, null));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public Map<String, Object> Xx000oIo(Map<String, Object> map, String... strArr) {
        for (String str : xI0oxI00(strArr)) {
            map.put(str, this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, null, null));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger XxX0x0xxx(Enum<?> r8, String str, String... strArr) {
        return (BigInteger) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, BigInteger.class, null, str, strArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean getBoolean(int i) {
        return (Boolean) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Boolean.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Double getDouble(int i) {
        return (Double) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Double.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Float getFloat(int i) {
        return (Float) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Float.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer getInt(int i) {
        return (Integer) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Integer.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Long getLong(int i) {
        return (Long) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Long.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Short getShort(int i) {
        return (Short) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Short.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public String getString(int i) {
        return this.f32305II0xO0.xII(this.f32306oIX0oI, i);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f32306oIX0oI);
    }

    @Override // ooO0oXxI.II0xO0
    public Float o0(String str, String str2, String... strArr) {
        return (Float) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Float.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal o00(Enum<?> r5) {
        return (BigDecimal) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, BigDecimal.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte o0xxxXXxX(int i) {
        return (Byte) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Byte.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Map<Integer, String> oI0IIXIo(int... iArr) {
        return II0xO0(new HashMap(iArr.length), iArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Date oIX0oI(int i, String str, String... strArr) {
        return (Date) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Date.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Float oO(Enum<?> r5) {
        return (Float) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Float.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer oOXoIIIo(Enum<?> r8, String str, String... strArr) {
        return (Integer) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Integer.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public BigDecimal oOo(String str) {
        return (BigDecimal) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, BigDecimal.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte oOoXoXO(Enum<?> r5) {
        return (Byte) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Byte.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Long oX(int i, String str, String... strArr) {
        return (Long) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Long.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T oXIO0o0XI(int i, Class<T> cls) {
        return (T) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, cls, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Short oo(String str) {
        return (Short) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Short.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Double oo0xXOI0I(String str) {
        return (Double) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Double.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Float ooOOo0oXI(Enum<?> r8, String str, String... strArr) {
        return (Float) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Float.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Date ooOx(int i) {
        return (Date) this.f32305II0xO0.xxX(this.f32306oIX0oI, i, Date.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T ooXIXxIX(int i, Class<T> cls, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.oo(this.f32306oIX0oI, i, cls, oxx0IOOOArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T extends Enum<T>> Map<T, String> ox(Map<T, String> map, T... tArr) {
        for (T t : tArr) {
            map.put(t, IIX0(t));
        }
        return map;
    }

    @Override // ooO0oXxI.II0xO0
    public Date oxXx0IX(String str, String str2, String... strArr) {
        return (Date) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Date.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean oxoX(String str) {
        return (Boolean) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Boolean.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Long oxxXoxO(Enum<?> r8, String str, String... strArr) {
        return (Long) this.f32305II0xO0.IIX0o(this.f32306oIX0oI, r8, Long.class, null, str, strArr);
    }

    public String toString() {
        String[] strArr = this.f32306oIX0oI;
        if (strArr == null) {
            return "null";
        }
        if (strArr.length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f32306oIX0oI.length; i++) {
            if (sb.length() != 0) {
                sb.append(',');
                sb.append(TokenParser.SP);
            }
            sb.append(this.f32306oIX0oI[i]);
        }
        return sb.toString();
    }

    @Override // ooO0oXxI.II0xO0
    public Date x0XOIxOo(Enum<?> r5) {
        return (Date) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Date.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Float x0o(String str) {
        return (Float) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Float.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Short x0xO(Enum<?> r5) {
        return (Short) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Short.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Character x0xO0oo(String str) {
        return (Character) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, Character.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T xI(Enum<?> r3, T t, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.Xx000oIo(this.f32306oIX0oI, r3, t, oxx0IOOOArr);
    }

    public final String[] xI0oxI00(String[] strArr) {
        if (strArr.length == 0) {
            return this.f32305II0xO0.X0o0xo();
        }
        return strArr;
    }

    @Override // ooO0oXxI.II0xO0
    public Character xII(Enum<?> r5) {
        return (Character) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Character.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T xOOOX(Enum<?> r4, Class<T> cls) {
        return (T) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r4, cls, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer xOoOIoI(Enum<?> r5) {
        return (Integer) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Integer.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean xX0IIXIx0(Enum<?> r5) {
        return (Boolean) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Boolean.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T xXOx(String str, Class<T> cls) {
        return (T) this.f32305II0xO0.ooXIXxIX(this.f32306oIX0oI, str, cls, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Long xXxxox0I(Enum<?> r5) {
        return (Long) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Long.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public Byte xo0x(String str, String str2, String... strArr) {
        return (Byte) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Byte.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Long xoIox(String str, String str2, String... strArr) {
        return (Long) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Long.class, null, str2, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Boolean xoIxX(String str, String str2, String str3) {
        return (Boolean) this.f32305II0xO0.xI(this.f32306oIX0oI, str, Boolean.class, Boolean.FALSE, str2, str3);
    }

    @Override // ooO0oXxI.II0xO0
    public Double xoO0xx0(int i, String str, String... strArr) {
        return (Double) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Double.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public Integer xoXoI(int i, String str, String... strArr) {
        return (Integer) this.f32305II0xO0.XxX0x0xxx(this.f32306oIX0oI, i, Integer.class, null, str, strArr);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T xoxXI(String str, Class<T> cls, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.X00IoxXI(this.f32306oIX0oI, str, cls, oxx0IOOOArr);
    }

    public <T extends Enum<T>> T[] xx0X0(Class<T> cls, T... tArr) {
        if (tArr.length == 0) {
            return cls.getEnumConstants();
        }
        return tArr;
    }

    @Override // ooO0oXxI.II0xO0
    public Double xxIO(Enum<?> r5) {
        return (Double) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, Double.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public BigInteger xxIXOIIO(Enum<?> r5) {
        return (BigInteger) this.f32305II0xO0.xXxxox0I(this.f32306oIX0oI, r5, BigInteger.class, null);
    }

    @Override // ooO0oXxI.II0xO0
    public <T> T xxX(Enum<?> r3, Class<T> cls, Oxx0IOOO... oxx0IOOOArr) {
        return (T) this.f32305II0xO0.oOXoIIIo(this.f32306oIX0oI, r3, cls, oxx0IOOOArr);
    }
}
