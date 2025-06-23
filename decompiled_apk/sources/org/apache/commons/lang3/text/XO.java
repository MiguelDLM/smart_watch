package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.xXOx;

@Deprecated
/* loaded from: classes6.dex */
public class XO implements ListIterator<String>, Cloneable {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final XO f32793O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public static final XO f32794OxI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public oxoX f32795IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f32796IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f32797Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public oxoX f32798Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oxoX f32799OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public char[] f32800XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f32801o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oxoX f32802oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f32803xoXoI;

    static {
        XO xo2 = new XO();
        f32794OxI = xo2;
        xo2.IIX0o(oxoX.oxoX());
        xo2.Xx000oIo(oxoX.X0o0xo());
        xo2.IoOoX(oxoX.II0XooXoX());
        xo2.X00IoxXI(oxoX.oO());
        xo2.xI(false);
        xo2.oo0xXOI0I(false);
        XO xo3 = new XO();
        f32793O0xOxO = xo3;
        xo3.IIX0o(oxoX.x0XOIxOo());
        xo3.Xx000oIo(oxoX.X0o0xo());
        xo3.IoOoX(oxoX.II0XooXoX());
        xo3.X00IoxXI(oxoX.oO());
        xo3.xI(false);
        xo3.oo0xXOI0I(false);
    }

    public XO() {
        this.f32798Oxx0xo = oxoX.oOoXoXO();
        this.f32802oI0IIXIo = oxoX.II0XooXoX();
        this.f32799OxxIIOOXO = oxoX.II0XooXoX();
        this.f32795IIXOooo = oxoX.II0XooXoX();
        this.f32803xoXoI = false;
        this.f32801o00 = true;
        this.f32800XO = null;
    }

    public static XO II0XooXoX(char[] cArr) {
        XO X0o0xo2 = X0o0xo();
        X0o0xo2.xxX(cArr);
        return X0o0xo2;
    }

    public static XO Oxx0IOOO(String str) {
        XO X0o0xo2 = X0o0xo();
        X0o0xo2.XIxXXX0x0(str);
        return X0o0xo2;
    }

    public static XO X0o0xo() {
        return (XO) f32794OxI.clone();
    }

    public static XO XO() {
        return X0o0xo();
    }

    public static XO oO(String str) {
        XO ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.XIxXXX0x0(str);
        return ooOOo0oXI2;
    }

    public static XO ooOOo0oXI() {
        return (XO) f32793O0xOxO.clone();
    }

    public static XO x0XOIxOo() {
        return ooOOo0oXI();
    }

    public static XO x0xO0oo(char[] cArr) {
        XO ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.xxX(cArr);
        return ooOOo0oXI2;
    }

    public final void I0Io() {
        if (this.f32797Oo == null) {
            char[] cArr = this.f32800XO;
            if (cArr == null) {
                this.f32797Oo = (String[]) xII(null, 0, 0).toArray(org.apache.commons.lang3.oxoX.f32758OxxIIOOXO);
            } else {
                this.f32797Oo = (String[]) xII(cArr, 0, cArr.length).toArray(org.apache.commons.lang3.oxoX.f32758OxxIIOOXO);
            }
        }
    }

    public final void II0xO0(List<String> list, String str) {
        if (xXOx.XIXIX(str)) {
            if (OxxIIOOXO()) {
                return;
            }
            if (oI0IIXIo()) {
                str = null;
            }
        }
        list.add(str);
    }

    public XO IIX0o(oxoX oxox) {
        if (oxox == null) {
            this.f32798Oxx0xo = oxoX.II0XooXoX();
        } else {
            this.f32798Oxx0xo = oxox;
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
        return this.f32797Oo.length;
    }

    public List<String> IXxxXO() {
        I0Io();
        ArrayList arrayList = new ArrayList(this.f32797Oo.length);
        arrayList.addAll(Arrays.asList(this.f32797Oo));
        return arrayList;
    }

    public XO IoOoX(oxoX oxox) {
        if (oxox != null) {
            this.f32799OxxIIOOXO = oxox;
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

    public oxoX OOXIXo() {
        return this.f32799OxxIIOOXO;
    }

    public String[] Oo() {
        I0Io();
        return (String[]) this.f32797Oo.clone();
    }

    public String OxI() {
        if (hasPrevious()) {
            String[] strArr = this.f32797Oo;
            int i = this.f32796IXxxXO - 1;
            this.f32796IXxxXO = i;
            return strArr[i];
        }
        return null;
    }

    public oxoX Oxx0xo() {
        return this.f32795IIXOooo;
    }

    public boolean OxxIIOOXO() {
        return this.f32801o00;
    }

    public XO X00IoxXI(oxoX oxox) {
        if (oxox != null) {
            this.f32795IIXOooo = oxox;
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

    public XO XI0IXoo() {
        this.f32796IXxxXO = 0;
        this.f32797Oo = null;
        return this;
    }

    public XO XIxXXX0x0(String str) {
        XI0IXoo();
        if (str != null) {
            this.f32800XO = str.toCharArray();
        } else {
            this.f32800XO = null;
        }
        return this;
    }

    public XO Xx000oIo(oxoX oxox) {
        if (oxox != null) {
            this.f32802oI0IIXIo = oxox;
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
        if (this.f32796IXxxXO < this.f32797Oo.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        I0Io();
        if (this.f32796IXxxXO > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f32796IXxxXO;
    }

    public String nextToken() {
        if (hasNext()) {
            String[] strArr = this.f32797Oo;
            int i = this.f32796IXxxXO;
            this.f32796IXxxXO = i + 1;
            return strArr[i];
        }
        return null;
    }

    @Override // java.util.ListIterator
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.f32797Oo;
            int i = this.f32796IXxxXO - 1;
            this.f32796IXxxXO = i;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public boolean oI0IIXIo() {
        return this.f32803xoXoI;
    }

    @Override // java.util.ListIterator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public XO oOXoIIIo(char c) {
        return Xx000oIo(oxoX.oIX0oI(c));
    }

    public oxoX oOoXoXO() {
        return this.f32802oI0IIXIo;
    }

    public XO oo(char c) {
        return IoOoX(oxoX.oIX0oI(c));
    }

    public XO oo0xXOI0I(boolean z) {
        this.f32801o00 = z;
        return this;
    }

    public XO ooXIXxIX(String str) {
        return IIX0o(oxoX.ooOOo0oXI(str));
    }

    public Object oxoX() throws CloneNotSupportedException {
        XO xo2 = (XO) super.clone();
        char[] cArr = xo2.f32800XO;
        if (cArr != null) {
            xo2.f32800XO = (char[]) cArr.clone();
        }
        xo2.XI0IXoo();
        return xo2;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f32796IXxxXO - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public String toString() {
        if (this.f32797Oo == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + IXxxXO();
    }

    public XO xI(boolean z) {
        this.f32803xoXoI = z;
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

    public XO xXxxox0I(char c) {
        return IIX0o(oxoX.oIX0oI(c));
    }

    public oxoX xoIox() {
        return this.f32798Oxx0xo;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (hasNext()) {
            String[] strArr = this.f32797Oo;
            int i = this.f32796IXxxXO;
            this.f32796IXxxXO = i + 1;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public String xxIXOIIO() {
        char[] cArr = this.f32800XO;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public XO xxX(char[] cArr) {
        XI0IXoo();
        this.f32800XO = org.apache.commons.lang3.oxoX.oOXoIIIo(cArr);
        return this;
    }

    public XO(String str) {
        this.f32798Oxx0xo = oxoX.oOoXoXO();
        this.f32802oI0IIXIo = oxoX.II0XooXoX();
        this.f32799OxxIIOOXO = oxoX.II0XooXoX();
        this.f32795IIXOooo = oxoX.II0XooXoX();
        this.f32803xoXoI = false;
        this.f32801o00 = true;
        if (str != null) {
            this.f32800XO = str.toCharArray();
        } else {
            this.f32800XO = null;
        }
    }

    public XO(String str, char c) {
        this(str);
        xXxxox0I(c);
    }

    public XO(String str, String str2) {
        this(str);
        ooXIXxIX(str2);
    }

    public XO(String str, oxoX oxox) {
        this(str);
        IIX0o(oxox);
    }

    public XO(String str, char c, char c2) {
        this(str, c);
        oOXoIIIo(c2);
    }

    public XO(String str, oxoX oxox, oxoX oxox2) {
        this(str, oxox);
        Xx000oIo(oxox2);
    }

    public XO(char[] cArr) {
        this.f32798Oxx0xo = oxoX.oOoXoXO();
        this.f32802oI0IIXIo = oxoX.II0XooXoX();
        this.f32799OxxIIOOXO = oxoX.II0XooXoX();
        this.f32795IIXOooo = oxoX.II0XooXoX();
        this.f32803xoXoI = false;
        this.f32801o00 = true;
        this.f32800XO = org.apache.commons.lang3.oxoX.oOXoIIIo(cArr);
    }

    public XO(char[] cArr, char c) {
        this(cArr);
        xXxxox0I(c);
    }

    public XO(char[] cArr, String str) {
        this(cArr);
        ooXIXxIX(str);
    }

    public XO(char[] cArr, oxoX oxox) {
        this(cArr);
        IIX0o(oxox);
    }

    public XO(char[] cArr, char c, char c2) {
        this(cArr, c);
        oOXoIIIo(c2);
    }

    public XO(char[] cArr, oxoX oxox, oxoX oxox2) {
        this(cArr, oxox);
        Xx000oIo(oxox2);
    }
}
