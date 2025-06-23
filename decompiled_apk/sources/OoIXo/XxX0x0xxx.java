package OoIXo;

import androidx.exifinterface.media.ExifInterface;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class XxX0x0xxx extends OI0 implements o00, oI0X0.II0XooXoX {

    /* renamed from: oO, reason: collision with root package name */
    public static final II0xO0 f2313oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2314oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XxX0x0xxx.class);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static String[] f2315ooOOo0oXI = {DateFormatUtils.DD, DateFormatUtils.MIN, "yy", "hh", "ss", "m/", "/d"};

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final II0xO0 f2316x0XOIxOo;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f2317II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Format f2318OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f2319Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f2320X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f2321XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f2322xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f2323xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    static {
        f2316x0XOIxOo = new II0xO0();
        f2313oO = new II0xO0();
    }

    public XxX0x0xxx(String str, int i) {
        super(xII.f2515xI);
        this.f2317II0XooXoX = str;
        this.f2319Oxx0IOOO = i;
        this.f2320X0o0xo = true;
    }

    public final boolean I0X0x0oIo() {
        return this.f2323xxIXOIIO;
    }

    @Override // OoIXo.o00
    public int OxI() {
        return this.f2319Oxx0IOOO;
    }

    public final NumberFormat X00IoxXI() {
        Format format = this.f2318OOXIXo;
        if (format != null && (format instanceof NumberFormat)) {
            return (NumberFormat) format;
        }
        try {
            this.f2318OOXIXo = new DecimalFormat(Xo0(Xo0(Xo0(Xo0(Xo0(this.f2317II0XooXoX, "E+", ExifInterface.LONGITUDE_EAST), "_)", ""), "_", ""), "[Red]", ""), "\\", ""));
        } catch (IllegalArgumentException unused) {
            this.f2318OOXIXo = new DecimalFormat("#.###");
        }
        return (NumberFormat) this.f2318OOXIXo;
    }

    public int XX0() {
        return this.f2319Oxx0IOOO;
    }

    public final String Xo0(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        while (indexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(indexOf + str2.length()));
            str = stringBuffer.toString();
            indexOf = str.indexOf(str2);
        }
        return str;
    }

    public final void XoI0Ixx0(String str) {
        this.f2317II0XooXoX = str;
    }

    @Override // oI0X0.II0XooXoX
    public String XxX0x0xxx() {
        return this.f2317II0XooXoX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof XxX0x0xxx)) {
            return false;
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) obj;
        if (this.f2320X0o0xo && xxX0x0xxx.f2320X0o0xo) {
            if (this.f2323xxIXOIIO != xxX0x0xxx.f2323xxIXOIIO || this.f2322xoIox != xxX0x0xxx.f2322xoIox) {
                return false;
            }
            return this.f2317II0XooXoX.equals(xxX0x0xxx.f2317II0XooXoX);
        }
        return this.f2317II0XooXoX.equals(xxX0x0xxx.f2317II0XooXoX);
    }

    public int hashCode() {
        return this.f2317II0XooXoX.hashCode();
    }

    @Override // OoIXo.o00
    public void initialize(int i) {
        this.f2319Oxx0IOOO = i;
        this.f2320X0o0xo = true;
    }

    @Override // OoIXo.o00
    public boolean isInitialized() {
        return this.f2320X0o0xo;
    }

    public final boolean oX() {
        return this.f2322xoIox;
    }

    public final DateFormat x0o() {
        int i;
        int i2;
        int i3;
        char c;
        char c2;
        int indexOf;
        Format format = this.f2318OOXIXo;
        if (format != null && (format instanceof DateFormat)) {
            return (DateFormat) format;
        }
        String str = this.f2317II0XooXoX;
        int indexOf2 = str.indexOf("AM/PM");
        while (true) {
            if (indexOf2 == -1) {
                break;
            }
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf2));
            stringBuffer.append('a');
            stringBuffer.append(str.substring(indexOf2 + 5));
            str = stringBuffer.toString();
            indexOf2 = str.indexOf("AM/PM");
        }
        int indexOf3 = str.indexOf("ss.0");
        while (indexOf3 != -1) {
            StringBuffer stringBuffer2 = new StringBuffer(str.substring(0, indexOf3));
            stringBuffer2.append("ss.SSS");
            int i4 = indexOf3 + 4;
            while (i4 < str.length() && str.charAt(i4) == '0') {
                i4++;
            }
            stringBuffer2.append(str.substring(i4));
            str = stringBuffer2.toString();
            indexOf3 = str.indexOf("ss.0");
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (str.charAt(i5) != '\\') {
                stringBuffer3.append(str.charAt(i5));
            }
        }
        String stringBuffer4 = stringBuffer3.toString();
        if (stringBuffer4.charAt(0) == '[' && (indexOf = stringBuffer4.indexOf(93)) != -1) {
            stringBuffer4 = stringBuffer4.substring(indexOf + 1);
        }
        char[] charArray = Xo0(stringBuffer4, ";@", "").toCharArray();
        for (i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'm') {
                if (i > 0 && ((c2 = charArray[i - 1]) == 'm' || c2 == 'M')) {
                    charArray[i] = c2;
                } else {
                    int i6 = i - 1;
                    int i7 = i6;
                    while (true) {
                        if (i7 > 0) {
                            if (charArray[i7] == 'h') {
                                i2 = i - i7;
                                break;
                            }
                            i7--;
                        } else {
                            i2 = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    int i8 = i + 1;
                    int i9 = i8;
                    while (true) {
                        if (i9 >= charArray.length) {
                            break;
                        }
                        if (charArray[i9] == 'h') {
                            i2 = Math.min(i2, i9 - i);
                            break;
                        }
                        i9++;
                    }
                    int i10 = i6;
                    while (true) {
                        if (i10 <= 0) {
                            break;
                        }
                        if (charArray[i10] == 'H') {
                            i2 = i - i10;
                            break;
                        }
                        i10--;
                    }
                    int i11 = i8;
                    while (true) {
                        if (i11 >= charArray.length) {
                            break;
                        }
                        if (charArray[i11] == 'H') {
                            i2 = Math.min(i2, i11 - i);
                            break;
                        }
                        i11++;
                    }
                    int i12 = i6;
                    while (true) {
                        if (i12 <= 0) {
                            break;
                        }
                        if (charArray[i12] == 's') {
                            i2 = Math.min(i2, i - i12);
                            break;
                        }
                        i12--;
                    }
                    int i13 = i8;
                    while (true) {
                        if (i13 >= charArray.length) {
                            break;
                        }
                        if (charArray[i13] == 's') {
                            i2 = Math.min(i2, i13 - i);
                            break;
                        }
                        i13++;
                    }
                    int i14 = i6;
                    while (true) {
                        if (i14 > 0) {
                            if (charArray[i14] == 'd') {
                                i3 = i - i14;
                                break;
                            }
                            i14--;
                        } else {
                            i3 = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    int i15 = i8;
                    while (true) {
                        if (i15 >= charArray.length) {
                            break;
                        }
                        if (charArray[i15] == 'd') {
                            i3 = Math.min(i3, i15 - i);
                            break;
                        }
                        i15++;
                    }
                    while (true) {
                        if (i6 <= 0) {
                            break;
                        }
                        if (charArray[i6] == 'y') {
                            i3 = Math.min(i3, i - i6);
                            break;
                        }
                        i6--;
                    }
                    while (true) {
                        if (i8 >= charArray.length) {
                            break;
                        }
                        if (charArray[i8] == 'y') {
                            i3 = Math.min(i3, i8 - i);
                            break;
                        }
                        i8++;
                    }
                    if (i3 < i2) {
                        charArray[i] = Character.toUpperCase(charArray[i]);
                    } else if (i3 == i2 && i3 != Integer.MAX_VALUE && ((c = charArray[i - i3]) == 'y' || c == 'd')) {
                        charArray[i] = Character.toUpperCase(charArray[i]);
                    }
                }
            }
        }
        try {
            this.f2318OOXIXo = new SimpleDateFormat(new String(charArray));
        } catch (IllegalArgumentException unused) {
            this.f2318OOXIXo = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
        }
        return (DateFormat) this.f2318OOXIXo;
    }

    @Override // OoIXo.o00
    public boolean xII() {
        return false;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f2317II0XooXoX.length() * 2) + 5];
        this.f2321XO = bArr;
        oo0xXOI0I.XO(this.f2319Oxx0IOOO, bArr, 0);
        oo0xXOI0I.XO(this.f2317II0XooXoX.length(), this.f2321XO, 2);
        byte[] bArr2 = this.f2321XO;
        bArr2[4] = 1;
        IO.X0o0xo(this.f2317II0XooXoX, bArr2, 5);
        return this.f2321XO;
    }

    public XxX0x0xxx() {
        super(xII.f2515xI);
        this.f2320X0o0xo = false;
    }

    public XxX0x0xxx(XxX0x0xxx xxX0x0xxx) {
        super(xII.f2515xI);
        this.f2320X0o0xo = false;
        this.f2317II0XooXoX = xxX0x0xxx.f2317II0XooXoX;
        this.f2323xxIXOIIO = xxX0x0xxx.f2323xxIXOIIO;
        this.f2322xoIox = xxX0x0xxx.f2322xoIox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XxX0x0xxx(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, II0xO0 iI0xO0) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int i = 0;
        this.f2319Oxx0IOOO = oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f2320X0o0xo = true;
        if (iI0xO0 == f2316x0XOIxOo) {
            int I0Io3 = oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
            if (I0Io2[4] == 0) {
                this.f2317II0XooXoX = IO.oxoX(I0Io2, I0Io3, 5, o0xOxO);
            } else {
                this.f2317II0XooXoX = IO.Oxx0IOOO(I0Io2, I0Io3, 5);
            }
        } else {
            int i2 = I0Io2[2];
            byte[] bArr = new byte[i2];
            System.arraycopy(I0Io2, 3, bArr, 0, i2);
            this.f2317II0XooXoX = new String(bArr);
        }
        this.f2323xxIXOIIO = false;
        this.f2322xoIox = false;
        while (true) {
            String[] strArr = f2315ooOOo0oXI;
            if (i >= strArr.length) {
                break;
            }
            String str = strArr[i];
            if (this.f2317II0XooXoX.indexOf(str) != -1 || this.f2317II0XooXoX.indexOf(str.toUpperCase()) != -1) {
                break;
            } else {
                i++;
            }
        }
        this.f2323xxIXOIIO = true;
        if (this.f2323xxIXOIIO) {
            return;
        }
        if (this.f2317II0XooXoX.indexOf(35) == -1 && this.f2317II0XooXoX.indexOf(48) == -1) {
            return;
        }
        this.f2322xoIox = true;
    }
}
