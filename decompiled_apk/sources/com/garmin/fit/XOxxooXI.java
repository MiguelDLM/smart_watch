package com.garmin.fit;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes9.dex */
public abstract class XOxxooXI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f13923II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList<Object> f13924oIX0oI = new ArrayList<>();

    public XOxxooXI() {
    }

    public Short I0(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return Short.valueOf(((Number) O0IxXx2).shortValue());
    }

    public Long I0X0x0oIo(int i, int i2) {
        return Xo0(i, xI0oxI00(i2));
    }

    public Long[] I0oOIX(xxOoXO xxooxo) {
        Long[] lArr = new Long[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            lArr[i] = Xo0(i, xxooxo);
        }
        return lArr;
    }

    public Integer I0oOoX(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return Integer.valueOf(((Number) O0IxXx2).intValue());
    }

    public void I0xX0(Object obj, String str) {
        Oxx(0, obj, IoIOOxIIo(str));
    }

    public BigInteger II0XooXoX() {
        return oOoXoXO(0, null);
    }

    public String IIX0(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        int OoO2 = OoO(xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        if (!f13923II0xO0 && Fit.f11214oXxOI0oIx.get(Integer.valueOf(OoO2)).equals(O0IxXx2)) {
            return null;
        }
        return O0IxXx2.toString();
    }

    public Double[] IIX0o(int i) {
        return ooXIXxIX(xI0oxI00(i));
    }

    public Byte IIXOooo(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return Byte.valueOf(((Number) O0IxXx2).byteValue());
    }

    public Short IIxOXoOo0(int i, String str) {
        return I0(i, IoIOOxIIo(str));
    }

    public Float[] IO() {
        return x0o(null);
    }

    public final Object IO0XoXxO(Integer num, Object obj) {
        HashMap<Integer, Object> hashMap = Fit.f11190XOxxooXI;
        if (hashMap.get(num) != null) {
            HashMap<Integer, Object> hashMap2 = Fit.f11181XI;
            if (hashMap2.get(num) != null) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(hashMap.get(num).toString());
                    BigDecimal bigDecimal2 = new BigDecimal(hashMap2.get(num).toString());
                    BigDecimal bigDecimal3 = new BigDecimal(obj.toString());
                    if (bigDecimal3.compareTo(bigDecimal) >= 0 && bigDecimal3.compareTo(bigDecimal2) <= 0) {
                        return obj;
                    }
                    return Fit.f11214oXxOI0oIx.get(num);
                } catch (NumberFormatException unused) {
                    return Fit.f11214oXxOI0oIx.get(num);
                }
            }
        }
        return obj;
    }

    public void IOoo(int i, Object obj, int i2) {
        xxOoXO xxooxo;
        if (i2 != 65535) {
            xxooxo = xI0oxI00(i2);
            if (xxooxo == null) {
                throw new FitRuntimeException("com.garmin.fit.Field.setValue(): " + i2 + " is not a valid subfield index of " + getName() + FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        } else {
            xxooxo = null;
        }
        Oxx(i, obj, xxooxo);
    }

    public Object IXO(int i) {
        return O0IxXx(i, null);
    }

    public Byte IXxxXO() {
        return IIXOooo(0, null);
    }

    public Integer Io(int i) {
        return I0oOoX(i, null);
    }

    public abstract xxOoXO IoIOOxIIo(String str);

    public Float IoOoX(int i) {
        return X00IoxXI(i, null);
    }

    public String IoOoo(String str) {
        return xoIxX(IoIOOxIIo(str));
    }

    public boolean IoXIXo() {
        return x0OxxIOxX(null);
    }

    public Object Ioxxx(int i) {
        return o0xxxXXxX(i, null);
    }

    public Object Ix00oIoI(int i, String str) {
        return O0IxXx(i, IoIOOxIIo(str));
    }

    public final String IxIX0I(xxOoXO xxooxo) {
        if (xxooxo == null) {
            return OIOoIIOIx();
        }
        return xxooxo.f15701X0o0xo;
    }

    public String[] O0(xxOoXO xxooxo) {
        String[] strArr = new String[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            strArr[i] = IIX0(i, xxooxo);
        }
        return strArr;
    }

    public abstract double O00XxXI();

    public Object O0IxXx(int i, xxOoXO xxooxo) {
        double d;
        double d2;
        if (i >= this.f13924oIX0oI.size()) {
            return null;
        }
        if (xxooxo == null) {
            d = O00XxXI();
            d2 = OO0x0xX();
        } else {
            d = xxooxo.f15698I0Io;
            d2 = xxooxo.f15704oxoX;
        }
        int OoO2 = OoO(xxooxo);
        Object obj = this.f13924oIX0oI.get(i);
        if (obj instanceof Number) {
            HashMap<Integer, Object> hashMap = Fit.f11214oXxOI0oIx;
            if (hashMap.get(Integer.valueOf(OoO2)).equals(obj)) {
                return hashMap.get(Integer.valueOf(OoO2));
            }
            if (d != 1.0d || d2 != XIXIX.OOXIXo.f3760XO) {
                return Double.valueOf((((Number) obj).doubleValue() / d) - d2);
            }
            return obj;
        }
        return obj;
    }

    public String O0X(int i, String str) {
        return IIX0(i, IoIOOxIIo(str));
    }

    public Long[] O0Xx(int i) {
        return I0oOIX(xI0oxI00(i));
    }

    public Byte[] O0xOxO(String str) {
        return OxI(IoIOOxIIo(str));
    }

    public Integer OI0() {
        return I0oOoX(0, null);
    }

    public abstract String OIOoIIOIx();

    public String OO(int i) {
        return xoIxX(xI0oxI00(i));
    }

    public abstract double OO0x0xX();

    public BigInteger OOXIXo(int i, String str) {
        return oOoXoXO(i, IoIOOxIIo(str));
    }

    public Short OOXIxO0(int i, int i2) {
        return I0(i, xI0oxI00(i2));
    }

    public void OX(OutputStream outputStream) {
        Iterator<Object> it = this.f13924oIX0oI.iterator();
        while (it.hasNext()) {
            o0IXXIx(outputStream, it.next());
        }
    }

    public Short[] OX00O0xII(xxOoXO xxooxo) {
        Short[] shArr = new Short[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            shArr[i] = I0(i, xxooxo);
        }
        return shArr;
    }

    public Long Oo(int i, int i2, boolean z) {
        int i3 = i;
        long j = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i5 + 1;
            Object o0xxxXXxX2 = o0xxxXXxX(i5, null);
            if (o0xxxXXxX2 == null || !(o0xxxXXxX2 instanceof Number)) {
                return null;
            }
            long longValue = ((Number) o0xxxXXxX2).longValue() >> i3;
            int[] iArr = Fit.f11152IoXIXo;
            int i7 = (iArr[oxIIX0o() & 31] * 8) - i3;
            i3 -= iArr[oxIIX0o() & 31] * 8;
            if (i7 > 0) {
                int i8 = i2 - i4;
                if (i7 > i8) {
                    i7 = i8;
                }
                j |= (longValue & ((1 << i7) - 1)) << i4;
                i4 += i7;
                i5 = i6;
                i3 = 0;
            } else {
                i5 = i6;
            }
        }
        if (z) {
            long j2 = 1 << (i2 - 1);
            if ((j & j2) != 0) {
                j = (-j2) + (j & (j2 - 1));
            }
        }
        return Long.valueOf(j);
    }

    public final int OoO(xxOoXO xxooxo) {
        if (xxooxo == null) {
            return oxIIX0o();
        }
        return xxooxo.f15699II0xO0;
    }

    public String[] Ox0O(int i) {
        return O0(xI0oxI00(i));
    }

    public Byte[] OxI(xxOoXO xxooxo) {
        Byte[] bArr = new Byte[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            bArr[i] = IIXOooo(i, xxooxo);
        }
        return bArr;
    }

    public void Oxx(int i, Object obj, xxOoXO xxooxo) {
        double d;
        double d2;
        while (i >= x0xO()) {
            Oxx0IOOO(new Object());
        }
        if (xxooxo == null) {
            d = O00XxXI();
            d2 = OO0x0xX();
        } else {
            d = xxooxo.f15698I0Io;
            d2 = xxooxo.f15704oxoX;
        }
        if (obj == null) {
            this.f13924oIX0oI.set(i, null);
            return;
        }
        if ((obj instanceof Number) && (d != 1.0d || d2 != XIXIX.OOXIXo.f3760XO)) {
            double doubleValue = (((Number) obj).doubleValue() + d2) * d;
            int oxIIX0o2 = oxIIX0o();
            if (oxIIX0o2 != 0) {
                if (oxIIX0o2 != 1) {
                    if (oxIIX0o2 != 2) {
                        if (oxIIX0o2 != 7) {
                            if (oxIIX0o2 != 10) {
                                if (oxIIX0o2 != 13) {
                                    if (oxIIX0o2 != 136) {
                                        if (oxIIX0o2 != 137) {
                                            if (oxIIX0o2 != 139) {
                                                if (oxIIX0o2 != 140) {
                                                    switch (oxIIX0o2) {
                                                        case 131:
                                                            break;
                                                        case 132:
                                                        case 133:
                                                            break;
                                                        case 134:
                                                            break;
                                                        default:
                                                            switch (oxIIX0o2) {
                                                                case 142:
                                                                    break;
                                                                case 143:
                                                                case 144:
                                                                    long round = Math.round(doubleValue);
                                                                    int i2 = Fit.f11152IoXIXo[oxIIX0o() & 31];
                                                                    byte[] bArr = new byte[i2];
                                                                    for (int i3 = 0; i3 < i2; i3++) {
                                                                        bArr[i3] = (byte) (round >>> (i3 * 8));
                                                                    }
                                                                    this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), new BigInteger(1, bArr)));
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                                }
                                                this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Long.valueOf(Math.round(doubleValue))));
                                                return;
                                            }
                                            this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Long.valueOf(Math.round(doubleValue))));
                                            return;
                                        }
                                        this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Double.valueOf(doubleValue)));
                                        return;
                                    }
                                    this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Double.valueOf(doubleValue)));
                                    return;
                                }
                                this.f13924oIX0oI.set(i, Long.valueOf(Math.round(doubleValue)));
                                return;
                            }
                        } else {
                            this.f13924oIX0oI.set(i, Double.valueOf(doubleValue).toString());
                            return;
                        }
                    }
                } else {
                    this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Long.valueOf(Math.round(doubleValue))));
                    return;
                }
            }
            this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), Long.valueOf(Math.round(doubleValue))));
            return;
        }
        X0o0xo(i, obj);
    }

    public void Oxx0IOOO(Object obj) {
        if ((obj instanceof Number) && oxIIX0o() == 7) {
            String IIX02 = IIX0(0, null);
            Number number = (Number) obj;
            if (IIX02 == null) {
                IIX02 = "";
            }
            Oxx(0, IIX02 + String.valueOf((char) number.intValue()), null);
            return;
        }
        this.f13924oIX0oI.add(obj);
    }

    public Byte Oxx0xo(int i) {
        return IIXOooo(i, null);
    }

    public Byte OxxIIOOXO(int i, String str) {
        return IIXOooo(i, IoIOOxIIo(str));
    }

    public Float X00IoxXI(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return new Float(((Number) O0IxXx2).doubleValue());
    }

    public Double X0IIOO() {
        return XxX0x0xxx(0, null);
    }

    public final void X0o0xo(int i, Object obj) {
        boolean z = obj instanceof String;
        if (z && obj.equals("")) {
            int oxIIX0o2 = oxIIX0o();
            if (oxIIX0o2 != 0 && oxIIX0o2 != 1 && oxIIX0o2 != 2) {
                if (oxIIX0o2 != 7) {
                    if (oxIIX0o2 != 10 && oxIIX0o2 != 13 && oxIIX0o2 != 136 && oxIIX0o2 != 137 && oxIIX0o2 != 139 && oxIIX0o2 != 140) {
                        switch (oxIIX0o2) {
                            case 131:
                            case 132:
                            case 133:
                            case 134:
                                break;
                            default:
                                switch (oxIIX0o2) {
                                    case 142:
                                    case 143:
                                    case 144:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    }
                } else {
                    this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), obj));
                    return;
                }
            }
            this.f13924oIX0oI.set(i, Fit.f11214oXxOI0oIx.get(Integer.valueOf(oxIIX0o())));
            return;
        }
        if (z) {
            if (((String) obj).getBytes(StandardCharsets.UTF_8).length <= 254) {
                this.f13924oIX0oI.set(i, obj);
                return;
            }
            throw new FitRuntimeException(String.format("Invalid string size. Byte count can not be greater than %d bytes.", 254));
        }
        this.f13924oIX0oI.set(i, IO0XoXxO(Integer.valueOf(oxIIX0o()), obj));
    }

    public boolean X0xII0I(int i) {
        int o0oIxOo2 = o0oIxOo(65534);
        if (i >= this.f13924oIX0oI.size()) {
            return false;
        }
        Object obj = this.f13924oIX0oI.get(i);
        if ((obj instanceof Number) && Fit.f11214oXxOI0oIx.get(Integer.valueOf(o0oIxOo2)).equals(obj)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void X0xxXX0(String str) {
        this.f13924oIX0oI.add(str);
    }

    public void XI(int i, Object obj) {
        Oxx(i, obj, null);
    }

    public Double XI0IXoo(int i) {
        return XxX0x0xxx(i, null);
    }

    public Short XI0oooXX(int i) {
        return I0(i, null);
    }

    public String XIXIX() {
        return IIX0(0, null);
    }

    public int XIXIxO(String str) {
        return OoO(IoIOOxIIo(str));
    }

    public Object XIo0oOXIx() {
        return o0xxxXXxX(0, null);
    }

    public Double XIxXXX0x0(int i, int i2) {
        return XxX0x0xxx(i, xI0oxI00(i2));
    }

    public void XO(Object obj) {
        if (obj == null) {
            this.f13924oIX0oI.add(null);
            return;
        }
        if (obj instanceof Double) {
            int oxIIX0o2 = oxIIX0o();
            if (oxIIX0o2 != 0) {
                if (oxIIX0o2 != 1) {
                    if (oxIIX0o2 != 2) {
                        if (oxIIX0o2 != 7) {
                            if (oxIIX0o2 != 10 && oxIIX0o2 != 13) {
                                if (oxIIX0o2 != 136) {
                                    if (oxIIX0o2 != 137) {
                                        if (oxIIX0o2 != 139) {
                                            if (oxIIX0o2 != 140) {
                                                switch (oxIIX0o2) {
                                                    case 131:
                                                        break;
                                                    case 132:
                                                    case 133:
                                                        break;
                                                    case 134:
                                                        break;
                                                    default:
                                                        return;
                                                }
                                            }
                                            this.f13924oIX0oI.add(Long.valueOf(Math.round(((Number) obj).doubleValue())));
                                            return;
                                        }
                                        this.f13924oIX0oI.add(Integer.valueOf((int) Math.round(((Number) obj).doubleValue())));
                                        return;
                                    }
                                    this.f13924oIX0oI.add(obj);
                                    return;
                                }
                                this.f13924oIX0oI.add(obj);
                                return;
                            }
                        } else {
                            this.f13924oIX0oI.add(obj.toString());
                            return;
                        }
                    }
                } else {
                    this.f13924oIX0oI.add(Byte.valueOf((byte) Math.round(((Number) obj).doubleValue())));
                    return;
                }
            }
            this.f13924oIX0oI.add(Short.valueOf((short) Math.round(((Number) obj).doubleValue())));
            return;
        }
        if ((obj instanceof String) && obj.equals("")) {
            int oxIIX0o3 = oxIIX0o();
            if (oxIIX0o3 != 0) {
                if (oxIIX0o3 != 1) {
                    if (oxIIX0o3 != 2) {
                        if (oxIIX0o3 != 7) {
                            if (oxIIX0o3 != 10) {
                                if (oxIIX0o3 != 13) {
                                    if (oxIIX0o3 != 136) {
                                        if (oxIIX0o3 != 137) {
                                            if (oxIIX0o3 != 139) {
                                                if (oxIIX0o3 != 140) {
                                                    switch (oxIIX0o3) {
                                                        case 131:
                                                            this.f13924oIX0oI.add(Fit.f11238xXOx);
                                                            return;
                                                        case 132:
                                                            this.f13924oIX0oI.add(Fit.f11195Xo0);
                                                            return;
                                                        case 133:
                                                            this.f13924oIX0oI.add(Fit.f11246xoxXI);
                                                            return;
                                                        case 134:
                                                            this.f13924oIX0oI.add(Fit.f11230x0xO);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                }
                                                this.f13924oIX0oI.add(Fit.f11236xOoOIoI);
                                                return;
                                            }
                                            this.f13924oIX0oI.add(Fit.f11213oXIO0o0XI);
                                            return;
                                        }
                                        this.f13924oIX0oI.add(Fit.f11183XI0oooXX);
                                        return;
                                    }
                                    this.f13924oIX0oI.add(Fit.f11193XX0xXo);
                                    return;
                                }
                                this.f13924oIX0oI.add(Fit.f11233xI0oxI00);
                                return;
                            }
                            this.f13924oIX0oI.add(Fit.f11168OX00O0xII);
                            return;
                        }
                        this.f13924oIX0oI.add(obj);
                        return;
                    }
                    this.f13924oIX0oI.add(Fit.f11224oxxXoxO);
                    return;
                }
                this.f13924oIX0oI.add(Fit.f11148Io);
                return;
            }
            this.f13924oIX0oI.add(Fit.f11234xII);
            return;
        }
        this.f13924oIX0oI.add(obj);
    }

    public Float[] XOxIOxOx(String str) {
        return x0o(IoIOOxIIo(str));
    }

    public void XOxxooXI(int i, Object obj) {
        while (i >= x0xO()) {
            Oxx0IOOO(new Object());
        }
        if (obj == null) {
            this.f13924oIX0oI.set(i, null);
            return;
        }
        if (obj instanceof Double) {
            int oxIIX0o2 = oxIIX0o();
            if (oxIIX0o2 != 0) {
                if (oxIIX0o2 != 1) {
                    if (oxIIX0o2 != 2) {
                        if (oxIIX0o2 != 7) {
                            if (oxIIX0o2 != 10 && oxIIX0o2 != 13) {
                                if (oxIIX0o2 != 136) {
                                    if (oxIIX0o2 != 137) {
                                        if (oxIIX0o2 != 139) {
                                            if (oxIIX0o2 != 140) {
                                                switch (oxIIX0o2) {
                                                    case 131:
                                                        break;
                                                    case 132:
                                                    case 133:
                                                        break;
                                                    case 134:
                                                        break;
                                                    default:
                                                        switch (oxIIX0o2) {
                                                            case 142:
                                                                break;
                                                            case 143:
                                                            case 144:
                                                                long round = Math.round(((Number) obj).doubleValue());
                                                                int i2 = Fit.f11152IoXIXo[oxIIX0o() & 31];
                                                                byte[] bArr = new byte[i2];
                                                                for (int i3 = 0; i3 < i2; i3++) {
                                                                    bArr[i3] = (byte) (round >>> (i3 * 8));
                                                                }
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                            }
                                            this.f13924oIX0oI.set(i, Long.valueOf(Math.round(((Number) obj).doubleValue())));
                                            return;
                                        }
                                        this.f13924oIX0oI.set(i, Integer.valueOf((int) Math.round(((Number) obj).doubleValue())));
                                        return;
                                    }
                                    this.f13924oIX0oI.set(i, obj);
                                    return;
                                }
                                this.f13924oIX0oI.set(i, obj);
                                return;
                            }
                        } else {
                            this.f13924oIX0oI.set(i, obj.toString());
                            return;
                        }
                    }
                } else {
                    this.f13924oIX0oI.set(i, Byte.valueOf((byte) Math.round(((Number) obj).doubleValue())));
                    return;
                }
            }
            this.f13924oIX0oI.set(i, Short.valueOf((short) Math.round(((Number) obj).doubleValue())));
            return;
        }
        X0o0xo(i, obj);
    }

    public Integer XX(int i, String str) {
        return I0oOoX(i, IoIOOxIIo(str));
    }

    public Long XX0(int i) {
        return Xo0(i, null);
    }

    public Object XX0xXo(int i, String str) {
        return o0xxxXXxX(i, IoIOOxIIo(str));
    }

    public void XXXI(Object obj, int i) {
        Oxx(0, obj, xI0oxI00(i));
    }

    public String XXoOx0(String str) {
        return IxIX0I(IoIOOxIIo(str));
    }

    public Long Xo0(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return Long.valueOf(((Number) O0IxXx2).longValue());
    }

    public Long[] XoI0Ixx0() {
        return I0oOIX(null);
    }

    public Integer[] XoX(int i) {
        return oxXx0IX(xI0oxI00(i));
    }

    public Float Xx000oIo(int i, String str) {
        return X00IoxXI(i, IoIOOxIIo(str));
    }

    public Double XxX0x0xxx(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return new Double(((Number) O0IxXx2).doubleValue());
    }

    public String getName() {
        return xoIxX(null);
    }

    public Integer o0(int i, int i2) {
        return I0oOoX(i, xI0oxI00(i2));
    }

    public Byte[] o00(int i) {
        return OxI(xI0oxI00(i));
    }

    public final void o0IXXIx(OutputStream outputStream, Object obj) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            if (obj == null) {
                int oxIIX0o2 = oxIIX0o();
                if (oxIIX0o2 != 0) {
                    if (oxIIX0o2 != 1) {
                        if (oxIIX0o2 != 2) {
                            if (oxIIX0o2 != 7) {
                                if (oxIIX0o2 != 10) {
                                    if (oxIIX0o2 != 13) {
                                        if (oxIIX0o2 != 136) {
                                            if (oxIIX0o2 != 137) {
                                                if (oxIIX0o2 != 139) {
                                                    if (oxIIX0o2 != 140) {
                                                        switch (oxIIX0o2) {
                                                            case 131:
                                                                dataOutputStream.writeShort(Fit.f11238xXOx.shortValue());
                                                                return;
                                                            case 132:
                                                                dataOutputStream.writeShort(Fit.f11195Xo0.intValue());
                                                                return;
                                                            case 133:
                                                                dataOutputStream.writeInt(Fit.f11246xoxXI.intValue());
                                                                return;
                                                            case 134:
                                                                dataOutputStream.writeInt((int) Fit.f11230x0xO.longValue());
                                                                return;
                                                            default:
                                                                switch (oxIIX0o2) {
                                                                    case 142:
                                                                        dataOutputStream.writeLong(Fit.f11185XIXIxO.longValue());
                                                                        return;
                                                                    case 143:
                                                                        dataOutputStream.writeLong(Fit.f11194XXoOx0.longValue());
                                                                        return;
                                                                    case 144:
                                                                        dataOutputStream.writeLong(Fit.f11204oI.longValue());
                                                                        return;
                                                                    default:
                                                                        return;
                                                                }
                                                        }
                                                    }
                                                    dataOutputStream.writeInt((int) Fit.f11236xOoOIoI.longValue());
                                                    return;
                                                }
                                                dataOutputStream.writeShort(Fit.f11213oXIO0o0XI.intValue());
                                                return;
                                            }
                                            dataOutputStream.writeDouble(Fit.f11183XI0oooXX.doubleValue());
                                            return;
                                        }
                                        dataOutputStream.writeFloat(Fit.f11193XX0xXo.floatValue());
                                        return;
                                    }
                                    dataOutputStream.writeByte(Fit.f11233xI0oxI00.shortValue());
                                    return;
                                }
                                dataOutputStream.writeByte(Fit.f11168OX00O0xII.shortValue());
                                return;
                            }
                            dataOutputStream.writeByte(0);
                            return;
                        }
                        dataOutputStream.writeByte(Fit.f11224oxxXoxO.shortValue());
                        return;
                    }
                    dataOutputStream.writeByte(Fit.f11148Io.byteValue());
                    return;
                }
                dataOutputStream.writeByte(Fit.f11234xII.shortValue());
                return;
            }
            int oxIIX0o3 = oxIIX0o();
            if (oxIIX0o3 != 0 && oxIIX0o3 != 1 && oxIIX0o3 != 2) {
                if (oxIIX0o3 != 7) {
                    if (oxIIX0o3 != 10 && oxIIX0o3 != 13) {
                        if (oxIIX0o3 != 136) {
                            if (oxIIX0o3 != 137) {
                                if (oxIIX0o3 != 139) {
                                    if (oxIIX0o3 != 140) {
                                        switch (oxIIX0o3) {
                                            case 131:
                                            case 132:
                                                break;
                                            case 133:
                                            case 134:
                                                break;
                                            default:
                                                switch (oxIIX0o3) {
                                                    case 142:
                                                    case 143:
                                                    case 144:
                                                        dataOutputStream.writeLong(((Number) obj).longValue());
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                    }
                                    dataOutputStream.writeInt((int) Math.round(((Number) obj).doubleValue()));
                                    return;
                                }
                                dataOutputStream.writeShort((int) Math.round(((Number) obj).doubleValue()));
                                return;
                            }
                            dataOutputStream.writeDouble(((Number) obj).doubleValue());
                            return;
                        }
                        dataOutputStream.writeFloat(((Number) obj).floatValue());
                        return;
                    }
                } else {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    outputStreamWriter.write(obj.toString());
                    outputStreamWriter.flush();
                    outputStream.write(0);
                    return;
                }
            }
            if (obj instanceof String) {
                System.err.printf("Field.write(): Field %s value should not be string value %s\n", oo0xXOI0I(), obj);
            }
            dataOutputStream.writeByte((int) Math.round(((Number) obj).doubleValue()));
        } catch (IOException unused) {
        }
    }

    public int o0oIxOo(int i) {
        return OoO(xI0oxI00(i));
    }

    public Object o0xxxXXxX(int i, xxOoXO xxooxo) {
        if (i >= this.f13924oIX0oI.size()) {
            return null;
        }
        return this.f13924oIX0oI.get(i);
    }

    public Object oI(int i, int i2) {
        return O0IxXx(i, xI0oxI00(i2));
    }

    public Byte oI0IIXIo(int i, int i2) {
        return IIXOooo(i, xI0oxI00(i2));
    }

    public void oIIxXoo(int i, Object obj, String str) {
        Oxx(i, obj, IoIOOxIIo(str));
    }

    public BigInteger[] oO(xxOoXO xxooxo) {
        BigInteger[] bigIntegerArr = new BigInteger[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            bigIntegerArr[i] = oOoXoXO(i, xxooxo);
        }
        return bigIntegerArr;
    }

    public Float oOXoIIIo(int i, int i2) {
        return X00IoxXI(i, xI0oxI00(i2));
    }

    public String oOo(int i, int i2) {
        return IIX0(i, xI0oxI00(i2));
    }

    public Object oOoIIO0() {
        return O0IxXx(0, null);
    }

    public BigInteger oOoXoXO(int i, xxOoXO xxooxo) {
        Object O0IxXx2 = O0IxXx(i, xxooxo);
        if (O0IxXx2 == null) {
            return null;
        }
        return (BigInteger) O0IxXx2;
    }

    public Long oX(int i, String str) {
        return Xo0(i, IoIOOxIIo(str));
    }

    public String oXIO0o0XI(int i) {
        return IIX0(i, null);
    }

    public void oXIoO(OutputStream outputStream, I0xX0 i0xX0) {
        int oIX0oI2 = i0xX0.oIX0oI() - xOOOX();
        OX(outputStream);
        while (oIX0oI2 > 0) {
            o0IXXIx(outputStream, null);
            oIX0oI2 -= Fit.f11152IoXIXo[oxIIX0o() & 31];
        }
    }

    public void oXX0IoI(Object obj) {
        Oxx(0, obj, null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x007e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[Catch: IOException -> 0x014b, LOOP:1: B:39:0x00b1->B:40:0x00b3, LOOP_END, TryCatch #1 {IOException -> 0x014b, blocks: (B:3:0x0001, B:6:0x0046, B:24:0x007e, B:25:0x0081, B:26:0x0085, B:27:0x0126, B:31:0x0132, B:36:0x0091, B:37:0x009b, B:38:0x00a5, B:40:0x00b3, B:43:0x00d1, B:44:0x00f4, B:45:0x00fd, B:46:0x0106, B:47:0x0112, B:48:0x011b, B:51:0x0141, B:53:0x0145), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean oXxOI0oIx(java.io.InputStream r14, int r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garmin.fit.XOxxooXI.oXxOI0oIx(java.io.InputStream, int):boolean");
    }

    public Float oo() {
        return X00IoxXI(0, null);
    }

    public abstract String oo0xXOI0I();

    public BigInteger[] ooOOo0oXI() {
        return oO(null);
    }

    public Short[] ooOx() {
        return OX00O0xII(null);
    }

    public Double[] ooXIXxIX(xxOoXO xxooxo) {
        Double[] dArr = new Double[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            dArr[i] = XxX0x0xxx(i, xxooxo);
        }
        return dArr;
    }

    public Short ox() {
        return I0(0, null);
    }

    public abstract int oxIIX0o();

    public Integer[] oxXx0IX(xxOoXO xxooxo) {
        Integer[] numArr = new Integer[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            numArr[i] = I0oOoX(i, xxooxo);
        }
        return numArr;
    }

    public Integer[] oxxXoxO() {
        return oxXx0IX(null);
    }

    public boolean x0() {
        return X0xII0I(0);
    }

    public String x0OIX00oO(int i) {
        return IxIX0I(xI0oxI00(i));
    }

    public boolean x0OxxIOxX(xxOoXO xxooxo) {
        int X0o0xo2;
        if (xxooxo == null) {
            X0o0xo2 = oxIIX0o();
        } else {
            X0o0xo2 = xxooxo.X0o0xo();
        }
        if (X0o0xo2 == 1 || X0o0xo2 == 131 || X0o0xo2 == 133 || X0o0xo2 == 142) {
            return true;
        }
        return false;
    }

    public BigInteger[] x0XOIxOo(int i) {
        return oO(xI0oxI00(i));
    }

    public Float[] x0o(xxOoXO xxooxo) {
        Float[] fArr = new Float[x0xO()];
        for (int i = 0; i < x0xO(); i++) {
            fArr[i] = X00IoxXI(i, xxooxo);
        }
        return fArr;
    }

    public int x0xO() {
        return this.f13924oIX0oI.size();
    }

    public BigInteger[] x0xO0oo(String str) {
        return oO(IoIOOxIIo(str));
    }

    public Double[] xI(String str) {
        return ooXIXxIX(IoIOOxIIo(str));
    }

    public abstract xxOoXO xI0oxI00(int i);

    public Float[] xII(int i) {
        return x0o(xI0oxI00(i));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0028. Please report as an issue. */
    public int xOOOX() {
        int oxIIX0o2 = oxIIX0o();
        if (oxIIX0o2 != 0 && oxIIX0o2 != 1 && oxIIX0o2 != 2) {
            int i = 0;
            if (oxIIX0o2 != 7) {
                if (oxIIX0o2 != 10 && oxIIX0o2 != 13 && oxIIX0o2 != 136 && oxIIX0o2 != 137 && oxIIX0o2 != 139 && oxIIX0o2 != 140) {
                    switch (oxIIX0o2) {
                        default:
                            switch (oxIIX0o2) {
                                case 142:
                                case 143:
                                case 144:
                                    break;
                                default:
                                    return 0;
                            }
                        case 131:
                        case 132:
                        case 133:
                        case 134:
                            return x0xO() * Fit.f11152IoXIXo[oxIIX0o() & 31];
                    }
                }
            } else {
                Iterator<Object> it = this.f13924oIX0oI.iterator();
                while (it.hasNext()) {
                    try {
                        i += it.next().toString().getBytes("UTF-8").length + 1;
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return i;
            }
        }
        return x0xO() * Fit.f11152IoXIXo[oxIIX0o() & 31];
    }

    public String[] xOoOIoI() {
        return O0(null);
    }

    public Short[] xX0IIXIx0(String str) {
        return OX00O0xII(IoIOOxIIo(str));
    }

    public Long xXOx() {
        return Xo0(0, null);
    }

    public boolean xXoOI00O(String str) {
        return x0OxxIOxX(IoIOOxIIo(str));
    }

    public Double[] xXxxox0I() {
        return ooXIXxIX(null);
    }

    public Integer[] xo0x(String str) {
        return oxXx0IX(IoIOOxIIo(str));
    }

    public BigInteger xoIox(int i, int i2) {
        return oOoXoXO(i, xI0oxI00(i2));
    }

    public final String xoIxX(xxOoXO xxooxo) {
        if (xxooxo == null) {
            return oo0xXOI0I();
        }
        return xxooxo.f15703oIX0oI;
    }

    public Short[] xoO0xx0(int i) {
        return OX00O0xII(xI0oxI00(i));
    }

    public Byte[] xoXoI() {
        return OxI(null);
    }

    public Long[] xoxXI(String str) {
        return I0oOIX(IoIOOxIIo(str));
    }

    public String[] xx0X0(String str) {
        return O0(IoIOOxIIo(str));
    }

    public Object xxIO(int i, int i2) {
        return o0xxxXXxX(i, xI0oxI00(i2));
    }

    public BigInteger xxIXOIIO(int i) {
        return oOoXoXO(i, null);
    }

    public boolean xxOXOOoIX(int i) {
        return x0OxxIOxX(xI0oxI00(i));
    }

    public Double xxX(int i, String str) {
        return XxX0x0xxx(i, IoIOOxIIo(str));
    }

    public XOxxooXI(XOxxooXI xOxxooXI) {
        if (xOxxooXI != null) {
            Iterator<Object> it = xOxxooXI.f13924oIX0oI.iterator();
            while (it.hasNext()) {
                this.f13924oIX0oI.add(it.next());
            }
        }
    }
}
