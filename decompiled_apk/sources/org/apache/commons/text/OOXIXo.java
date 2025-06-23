package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@Deprecated
/* loaded from: classes6.dex */
public class OOXIXo implements ListIterator<String>, Cloneable {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final OOXIXo f33013O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public static final OOXIXo f33014OxI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public xxIXOIIO f33015IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33016IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f33017Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public xxIXOIIO f33018Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xxIXOIIO f33019OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public char[] f33020XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f33021o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xxIXOIIO f33022oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f33023xoXoI;

    static {
        OOXIXo oOXIXo = new OOXIXo();
        f33014OxI = oOXIXo;
        oOXIXo.IIX0o(xxIXOIIO.oxoX());
        oOXIXo.Xx000oIo(xxIXOIIO.X0o0xo());
        oOXIXo.IoOoX(xxIXOIIO.II0XooXoX());
        oOXIXo.X00IoxXI(xxIXOIIO.oO());
        oOXIXo.xI(false);
        oOXIXo.oo0xXOI0I(false);
        OOXIXo oOXIXo2 = new OOXIXo();
        f33013O0xOxO = oOXIXo2;
        oOXIXo2.IIX0o(xxIXOIIO.x0XOIxOo());
        oOXIXo2.Xx000oIo(xxIXOIIO.X0o0xo());
        oOXIXo2.IoOoX(xxIXOIIO.II0XooXoX());
        oOXIXo2.X00IoxXI(xxIXOIIO.oO());
        oOXIXo2.xI(false);
        oOXIXo2.oo0xXOI0I(false);
    }

    public OOXIXo() {
        this.f33018Oxx0xo = xxIXOIIO.oOoXoXO();
        this.f33022oI0IIXIo = xxIXOIIO.II0XooXoX();
        this.f33019OxxIIOOXO = xxIXOIIO.II0XooXoX();
        this.f33015IIXOooo = xxIXOIIO.II0XooXoX();
        this.f33023xoXoI = false;
        this.f33021o00 = true;
        this.f33020XO = null;
    }

    public static OOXIXo II0XooXoX(char[] cArr) {
        OOXIXo X0o0xo2 = X0o0xo();
        X0o0xo2.xxX(cArr);
        return X0o0xo2;
    }

    public static OOXIXo Oxx0IOOO(String str) {
        OOXIXo X0o0xo2 = X0o0xo();
        X0o0xo2.XIxXXX0x0(str);
        return X0o0xo2;
    }

    public static OOXIXo X0o0xo() {
        return (OOXIXo) f33014OxI.clone();
    }

    public static OOXIXo XO() {
        return X0o0xo();
    }

    public static OOXIXo oO(String str) {
        OOXIXo ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.XIxXXX0x0(str);
        return ooOOo0oXI2;
    }

    public static OOXIXo ooOOo0oXI() {
        return (OOXIXo) f33013O0xOxO.clone();
    }

    public static OOXIXo x0XOIxOo() {
        return ooOOo0oXI();
    }

    public static OOXIXo x0xO0oo(char[] cArr) {
        OOXIXo ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.xxX(cArr);
        return ooOOo0oXI2;
    }

    public final void I0Io() {
        if (this.f33017Oo == null) {
            char[] cArr = this.f33020XO;
            if (cArr == null) {
                List<String> xII2 = xII(null, 0, 0);
                this.f33017Oo = (String[]) xII2.toArray(new String[xII2.size()]);
            } else {
                List<String> xII3 = xII(cArr, 0, cArr.length);
                this.f33017Oo = (String[]) xII3.toArray(new String[xII3.size()]);
            }
        }
    }

    public final void II0xO0(List<String> list, String str) {
        if (str == null || str.length() == 0) {
            if (OxxIIOOXO()) {
                return;
            }
            if (oI0IIXIo()) {
                str = null;
            }
        }
        list.add(str);
    }

    public OOXIXo IIX0o(xxIXOIIO xxixoiio) {
        if (xxixoiio == null) {
            this.f33018Oxx0xo = xxIXOIIO.II0XooXoX();
        } else {
            this.f33018Oxx0xo = xxixoiio;
        }
        return this;
    }

    public final boolean IIXOooo(char[] cArr, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            if (i6 >= i2 || cArr[i6] != cArr[i3 + i5]) {
                return false;
            }
        }
        return true;
    }

    public int IO() {
        I0Io();
        return this.f33017Oo.length;
    }

    public List<String> IXxxXO() {
        I0Io();
        ArrayList arrayList = new ArrayList(this.f33017Oo.length);
        Collections.addAll(arrayList, this.f33017Oo);
        return arrayList;
    }

    public OOXIXo IoOoX(xxIXOIIO xxixoiio) {
        if (xxixoiio != null) {
            this.f33019OxxIIOOXO = xxixoiio;
        }
        return this;
    }

    public final int O0xOxO(char[] cArr, int i, int i2, StrBuilder strBuilder, List<String> list) {
        while (i < i2) {
            int max = Math.max(OOXIXo().Oxx0IOOO(cArr, i, i, i2), Oxx0xo().Oxx0IOOO(cArr, i, i, i2));
            if (max == 0 || xoIox().Oxx0IOOO(cArr, i, i, i2) > 0 || oOoXoXO().Oxx0IOOO(cArr, i, i, i2) > 0) {
                break;
            }
            i += max;
        }
        if (i >= i2) {
            II0xO0(list, "");
            return -1;
        }
        int Oxx0IOOO2 = xoIox().Oxx0IOOO(cArr, i, i, i2);
        if (Oxx0IOOO2 > 0) {
            II0xO0(list, "");
            return i + Oxx0IOOO2;
        }
        int Oxx0IOOO3 = oOoXoXO().Oxx0IOOO(cArr, i, i, i2);
        if (Oxx0IOOO3 > 0) {
            return X0IIOO(cArr, i + Oxx0IOOO3, i2, strBuilder, list, i, Oxx0IOOO3);
        }
        return X0IIOO(cArr, i, i2, strBuilder, list, 0, 0);
    }

    public xxIXOIIO OOXIXo() {
        return this.f33019OxxIIOOXO;
    }

    public String[] Oo() {
        I0Io();
        return (String[]) this.f33017Oo.clone();
    }

    public String OxI() {
        if (hasPrevious()) {
            String[] strArr = this.f33017Oo;
            int i = this.f33016IXxxXO - 1;
            this.f33016IXxxXO = i;
            return strArr[i];
        }
        return null;
    }

    public xxIXOIIO Oxx0xo() {
        return this.f33015IIXOooo;
    }

    public boolean OxxIIOOXO() {
        return this.f33021o00;
    }

    public OOXIXo X00IoxXI(xxIXOIIO xxixoiio) {
        if (xxixoiio != null) {
            this.f33015IIXOooo = xxixoiio;
        }
        return this;
    }

    public final int X0IIOO(char[] cArr, int i, int i2, StrBuilder strBuilder, List<String> list, int i3, int i4) {
        boolean z;
        strBuilder.clear();
        if (i4 > 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        int i5 = i;
        int i6 = 0;
        while (i5 < i2) {
            if (z2) {
                int i7 = i6;
                int i8 = i5;
                if (IIXOooo(cArr, i5, i2, i3, i4)) {
                    int i9 = i8 + i4;
                    if (IIXOooo(cArr, i9, i2, i3, i4)) {
                        strBuilder.append(cArr, i8, i4);
                        i5 = i8 + (i4 * 2);
                        i6 = strBuilder.size();
                    } else {
                        i6 = i7;
                        i5 = i9;
                        z2 = false;
                    }
                } else {
                    i5 = i8 + 1;
                    strBuilder.append(cArr[i8]);
                    i6 = strBuilder.size();
                }
            } else {
                int i10 = i6;
                int i11 = i5;
                int Oxx0IOOO2 = xoIox().Oxx0IOOO(cArr, i11, i, i2);
                if (Oxx0IOOO2 > 0) {
                    II0xO0(list, strBuilder.substring(0, i10));
                    return i11 + Oxx0IOOO2;
                }
                if (i4 > 0 && IIXOooo(cArr, i11, i2, i3, i4)) {
                    i5 = i11 + i4;
                    i6 = i10;
                    z2 = true;
                } else {
                    int Oxx0IOOO3 = OOXIXo().Oxx0IOOO(cArr, i11, i, i2);
                    if (Oxx0IOOO3 <= 0) {
                        Oxx0IOOO3 = Oxx0xo().Oxx0IOOO(cArr, i11, i, i2);
                        if (Oxx0IOOO3 > 0) {
                            strBuilder.append(cArr, i11, Oxx0IOOO3);
                        } else {
                            i5 = i11 + 1;
                            strBuilder.append(cArr[i11]);
                            i6 = strBuilder.size();
                        }
                    }
                    i5 = i11 + Oxx0IOOO3;
                    i6 = i10;
                }
            }
        }
        II0xO0(list, strBuilder.substring(0, i6));
        return -1;
    }

    public OOXIXo XI0IXoo() {
        this.f33016IXxxXO = 0;
        this.f33017Oo = null;
        return this;
    }

    public OOXIXo XIxXXX0x0(String str) {
        XI0IXoo();
        if (str != null) {
            this.f33020XO = str.toCharArray();
        } else {
            this.f33020XO = null;
        }
        return this;
    }

    public OOXIXo Xx000oIo(xxIXOIIO xxixoiio) {
        if (xxixoiio != null) {
            this.f33022oI0IIXIo = xxixoiio;
        }
        return this;
    }

    @Override // java.util.ListIterator
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public Object clone() {
        try {
            return oxoX();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        I0Io();
        if (this.f33016IXxxXO < this.f33017Oo.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        I0Io();
        if (this.f33016IXxxXO > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f33016IXxxXO;
    }

    public String nextToken() {
        if (hasNext()) {
            String[] strArr = this.f33017Oo;
            int i = this.f33016IXxxXO;
            this.f33016IXxxXO = i + 1;
            return strArr[i];
        }
        return null;
    }

    @Override // java.util.ListIterator
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.f33017Oo;
            int i = this.f33016IXxxXO - 1;
            this.f33016IXxxXO = i;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public boolean oI0IIXIo() {
        return this.f33023xoXoI;
    }

    @Override // java.util.ListIterator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public OOXIXo oOXoIIIo(char c) {
        return Xx000oIo(xxIXOIIO.oIX0oI(c));
    }

    public xxIXOIIO oOoXoXO() {
        return this.f33022oI0IIXIo;
    }

    public OOXIXo oo(char c) {
        return IoOoX(xxIXOIIO.oIX0oI(c));
    }

    public OOXIXo oo0xXOI0I(boolean z) {
        this.f33021o00 = z;
        return this;
    }

    public OOXIXo ooXIXxIX(String str) {
        return IIX0o(xxIXOIIO.ooOOo0oXI(str));
    }

    public Object oxoX() throws CloneNotSupportedException {
        OOXIXo oOXIXo = (OOXIXo) super.clone();
        char[] cArr = oOXIXo.f33020XO;
        if (cArr != null) {
            oOXIXo.f33020XO = (char[]) cArr.clone();
        }
        oOXIXo.XI0IXoo();
        return oOXIXo;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f33016IXxxXO - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public String toString() {
        if (this.f33017Oo == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + IXxxXO();
    }

    public OOXIXo xI(boolean z) {
        this.f33023xoXoI = z;
        return this;
    }

    public List<String> xII(char[] cArr, int i, int i2) {
        if (cArr != null && i2 != 0) {
            StrBuilder strBuilder = new StrBuilder();
            ArrayList arrayList = new ArrayList();
            int i3 = i;
            while (i3 >= 0 && i3 < i2) {
                i3 = O0xOxO(cArr, i3, i2, strBuilder, arrayList);
                if (i3 >= i2) {
                    II0xO0(arrayList, "");
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public OOXIXo xXxxox0I(char c) {
        return IIX0o(xxIXOIIO.oIX0oI(c));
    }

    public xxIXOIIO xoIox() {
        return this.f33018Oxx0xo;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (hasNext()) {
            String[] strArr = this.f33017Oo;
            int i = this.f33016IXxxXO;
            this.f33016IXxxXO = i + 1;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public String xxIXOIIO() {
        char[] cArr = this.f33020XO;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public OOXIXo xxX(char[] cArr) {
        XI0IXoo();
        if (cArr != null) {
            this.f33020XO = (char[]) cArr.clone();
        } else {
            this.f33020XO = null;
        }
        return this;
    }

    public OOXIXo(String str) {
        this.f33018Oxx0xo = xxIXOIIO.oOoXoXO();
        this.f33022oI0IIXIo = xxIXOIIO.II0XooXoX();
        this.f33019OxxIIOOXO = xxIXOIIO.II0XooXoX();
        this.f33015IIXOooo = xxIXOIIO.II0XooXoX();
        this.f33023xoXoI = false;
        this.f33021o00 = true;
        if (str != null) {
            this.f33020XO = str.toCharArray();
        } else {
            this.f33020XO = null;
        }
    }

    public OOXIXo(String str, char c) {
        this(str);
        xXxxox0I(c);
    }

    public OOXIXo(String str, String str2) {
        this(str);
        ooXIXxIX(str2);
    }

    public OOXIXo(String str, xxIXOIIO xxixoiio) {
        this(str);
        IIX0o(xxixoiio);
    }

    public OOXIXo(String str, char c, char c2) {
        this(str, c);
        oOXoIIIo(c2);
    }

    public OOXIXo(String str, xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2) {
        this(str, xxixoiio);
        Xx000oIo(xxixoiio2);
    }

    public OOXIXo(char[] cArr) {
        this.f33018Oxx0xo = xxIXOIIO.oOoXoXO();
        this.f33022oI0IIXIo = xxIXOIIO.II0XooXoX();
        this.f33019OxxIIOOXO = xxIXOIIO.II0XooXoX();
        this.f33015IIXOooo = xxIXOIIO.II0XooXoX();
        this.f33023xoXoI = false;
        this.f33021o00 = true;
        if (cArr == null) {
            this.f33020XO = null;
        } else {
            this.f33020XO = (char[]) cArr.clone();
        }
    }

    public OOXIXo(char[] cArr, char c) {
        this(cArr);
        xXxxox0I(c);
    }

    public OOXIXo(char[] cArr, String str) {
        this(cArr);
        ooXIXxIX(str);
    }

    public OOXIXo(char[] cArr, xxIXOIIO xxixoiio) {
        this(cArr);
        IIX0o(xxixoiio);
    }

    public OOXIXo(char[] cArr, char c, char c2) {
        this(cArr, c);
        oOXoIIIo(c2);
    }

    public OOXIXo(char[] cArr, xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2) {
        this(cArr, xxixoiio);
        Xx000oIo(xxixoiio2);
    }
}
