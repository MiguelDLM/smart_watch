package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public class x0XOIxOo implements ListIterator<String>, Cloneable {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final x0XOIxOo f33091O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public static final x0XOIxOo f33092OxI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public xOx.Oxx0IOOO f33093IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f33094IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f33095Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public xOx.Oxx0IOOO f33096Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xOx.Oxx0IOOO f33097OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public char[] f33098XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f33099o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xOx.Oxx0IOOO f33100oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f33101xoXoI;

    static {
        x0XOIxOo x0xoixoo = new x0XOIxOo();
        f33092OxI = x0xoixoo;
        xOx.II0XooXoX iI0XooXoX = xOx.II0XooXoX.f34478I0Io;
        x0xoixoo.IIX0o(iI0XooXoX.X0o0xo());
        x0xoixoo.Xx000oIo(iI0XooXoX.XO());
        x0xoixoo.IoOoX(iI0XooXoX.Oxx0IOOO());
        x0xoixoo.X00IoxXI(iI0XooXoX.oO());
        x0xoixoo.xI(false);
        x0xoixoo.oo0xXOI0I(false);
        x0XOIxOo x0xoixoo2 = new x0XOIxOo();
        f33091O0xOxO = x0xoixoo2;
        x0xoixoo2.IIX0o(iI0XooXoX.x0XOIxOo());
        x0xoixoo2.Xx000oIo(iI0XooXoX.XO());
        x0xoixoo2.IoOoX(iI0XooXoX.Oxx0IOOO());
        x0xoixoo2.X00IoxXI(iI0XooXoX.oO());
        x0xoixoo2.xI(false);
        x0xoixoo2.oo0xXOI0I(false);
    }

    public x0XOIxOo() {
        xOx.II0XooXoX iI0XooXoX = xOx.II0XooXoX.f34478I0Io;
        this.f33096Oxx0xo = iI0XooXoX.OOXIXo();
        this.f33100oI0IIXIo = iI0XooXoX.Oxx0IOOO();
        this.f33097OxxIIOOXO = iI0XooXoX.Oxx0IOOO();
        this.f33093IIXOooo = iI0XooXoX.Oxx0IOOO();
        this.f33101xoXoI = false;
        this.f33099o00 = true;
        this.f33098XO = null;
    }

    public static x0XOIxOo II0XooXoX(char[] cArr) {
        x0XOIxOo X0o0xo2 = X0o0xo();
        X0o0xo2.xxX(cArr);
        return X0o0xo2;
    }

    public static x0XOIxOo Oxx0IOOO(String str) {
        x0XOIxOo X0o0xo2 = X0o0xo();
        X0o0xo2.XIxXXX0x0(str);
        return X0o0xo2;
    }

    public static x0XOIxOo X0o0xo() {
        return (x0XOIxOo) f33092OxI.clone();
    }

    public static x0XOIxOo XO() {
        return X0o0xo();
    }

    public static x0XOIxOo oO(String str) {
        x0XOIxOo ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.XIxXXX0x0(str);
        return ooOOo0oXI2;
    }

    public static x0XOIxOo ooOOo0oXI() {
        return (x0XOIxOo) f33091O0xOxO.clone();
    }

    public static x0XOIxOo x0XOIxOo() {
        return ooOOo0oXI();
    }

    public static x0XOIxOo x0xO0oo(char[] cArr) {
        x0XOIxOo ooOOo0oXI2 = ooOOo0oXI();
        ooOOo0oXI2.xxX(cArr);
        return ooOOo0oXI2;
    }

    public final void I0Io() {
        if (this.f33095Oo == null) {
            char[] cArr = this.f33098XO;
            if (cArr == null) {
                List<String> xII2 = xII(null, 0, 0);
                this.f33095Oo = (String[]) xII2.toArray(new String[xII2.size()]);
            } else {
                List<String> xII3 = xII(cArr, 0, cArr.length);
                this.f33095Oo = (String[]) xII3.toArray(new String[xII3.size()]);
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

    public x0XOIxOo IIX0o(xOx.Oxx0IOOO oxx0IOOO) {
        if (oxx0IOOO == null) {
            this.f33096Oxx0xo = xOx.II0XooXoX.f34478I0Io.Oxx0IOOO();
        } else {
            this.f33096Oxx0xo = oxx0IOOO;
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
        return this.f33095Oo.length;
    }

    public List<String> IXxxXO() {
        I0Io();
        ArrayList arrayList = new ArrayList(this.f33095Oo.length);
        Collections.addAll(arrayList, this.f33095Oo);
        return arrayList;
    }

    public x0XOIxOo IoOoX(xOx.Oxx0IOOO oxx0IOOO) {
        if (oxx0IOOO != null) {
            this.f33097OxxIIOOXO = oxx0IOOO;
        }
        return this;
    }

    public final int O0xOxO(char[] cArr, int i, int i2, TextStringBuilder textStringBuilder, List<String> list) {
        while (i < i2) {
            int max = Math.max(OOXIXo().I0Io(cArr, i, i, i2), Oxx0xo().I0Io(cArr, i, i, i2));
            if (max == 0 || xoIox().I0Io(cArr, i, i, i2) > 0 || oOoXoXO().I0Io(cArr, i, i, i2) > 0) {
                break;
            }
            i += max;
        }
        if (i >= i2) {
            II0xO0(list, "");
            return -1;
        }
        int I0Io2 = xoIox().I0Io(cArr, i, i, i2);
        if (I0Io2 > 0) {
            II0xO0(list, "");
            return i + I0Io2;
        }
        int I0Io3 = oOoXoXO().I0Io(cArr, i, i, i2);
        if (I0Io3 > 0) {
            return X0IIOO(cArr, i + I0Io3, i2, textStringBuilder, list, i, I0Io3);
        }
        return X0IIOO(cArr, i, i2, textStringBuilder, list, 0, 0);
    }

    public xOx.Oxx0IOOO OOXIXo() {
        return this.f33097OxxIIOOXO;
    }

    public String[] Oo() {
        I0Io();
        return (String[]) this.f33095Oo.clone();
    }

    public String OxI() {
        if (hasPrevious()) {
            String[] strArr = this.f33095Oo;
            int i = this.f33094IXxxXO - 1;
            this.f33094IXxxXO = i;
            return strArr[i];
        }
        return null;
    }

    public xOx.Oxx0IOOO Oxx0xo() {
        return this.f33093IIXOooo;
    }

    public boolean OxxIIOOXO() {
        return this.f33099o00;
    }

    public x0XOIxOo X00IoxXI(xOx.Oxx0IOOO oxx0IOOO) {
        if (oxx0IOOO != null) {
            this.f33093IIXOooo = oxx0IOOO;
        }
        return this;
    }

    public final int X0IIOO(char[] cArr, int i, int i2, TextStringBuilder textStringBuilder, List<String> list, int i3, int i4) {
        boolean z;
        textStringBuilder.clear();
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
                        textStringBuilder.append(cArr, i8, i4);
                        i5 = i8 + (i4 * 2);
                        i6 = textStringBuilder.size();
                    } else {
                        i6 = i7;
                        i5 = i9;
                        z2 = false;
                    }
                } else {
                    i5 = i8 + 1;
                    textStringBuilder.append(cArr[i8]);
                    i6 = textStringBuilder.size();
                }
            } else {
                int i10 = i6;
                int i11 = i5;
                int I0Io2 = xoIox().I0Io(cArr, i11, i, i2);
                if (I0Io2 > 0) {
                    II0xO0(list, textStringBuilder.substring(0, i10));
                    return i11 + I0Io2;
                }
                if (i4 > 0 && IIXOooo(cArr, i11, i2, i3, i4)) {
                    i5 = i11 + i4;
                    i6 = i10;
                    z2 = true;
                } else {
                    int I0Io3 = OOXIXo().I0Io(cArr, i11, i, i2);
                    if (I0Io3 <= 0) {
                        I0Io3 = Oxx0xo().I0Io(cArr, i11, i, i2);
                        if (I0Io3 > 0) {
                            textStringBuilder.append(cArr, i11, I0Io3);
                        } else {
                            i5 = i11 + 1;
                            textStringBuilder.append(cArr[i11]);
                            i6 = textStringBuilder.size();
                        }
                    }
                    i5 = i11 + I0Io3;
                    i6 = i10;
                }
            }
        }
        II0xO0(list, textStringBuilder.substring(0, i6));
        return -1;
    }

    public x0XOIxOo XI0IXoo() {
        this.f33094IXxxXO = 0;
        this.f33095Oo = null;
        return this;
    }

    public x0XOIxOo XIxXXX0x0(String str) {
        XI0IXoo();
        if (str != null) {
            this.f33098XO = str.toCharArray();
        } else {
            this.f33098XO = null;
        }
        return this;
    }

    public x0XOIxOo Xx000oIo(xOx.Oxx0IOOO oxx0IOOO) {
        if (oxx0IOOO != null) {
            this.f33100oI0IIXIo = oxx0IOOO;
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
        if (this.f33094IXxxXO < this.f33095Oo.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        I0Io();
        if (this.f33094IXxxXO > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f33094IXxxXO;
    }

    public String nextToken() {
        if (hasNext()) {
            String[] strArr = this.f33095Oo;
            int i = this.f33094IXxxXO;
            this.f33094IXxxXO = i + 1;
            return strArr[i];
        }
        return null;
    }

    @Override // java.util.ListIterator
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.f33095Oo;
            int i = this.f33094IXxxXO - 1;
            this.f33094IXxxXO = i;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public boolean oI0IIXIo() {
        return this.f33101xoXoI;
    }

    @Override // java.util.ListIterator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public x0XOIxOo oOXoIIIo(char c) {
        return Xx000oIo(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public xOx.Oxx0IOOO oOoXoXO() {
        return this.f33100oI0IIXIo;
    }

    public x0XOIxOo oo(char c) {
        return IoOoX(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public x0XOIxOo oo0xXOI0I(boolean z) {
        this.f33099o00 = z;
        return this;
    }

    public x0XOIxOo ooXIXxIX(String str) {
        return IIX0o(xOx.II0XooXoX.f34478I0Io.oOoXoXO(str));
    }

    public Object oxoX() throws CloneNotSupportedException {
        x0XOIxOo x0xoixoo = (x0XOIxOo) super.clone();
        char[] cArr = x0xoixoo.f33098XO;
        if (cArr != null) {
            x0xoixoo.f33098XO = (char[]) cArr.clone();
        }
        x0xoixoo.XI0IXoo();
        return x0xoixoo;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f33094IXxxXO - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public String toString() {
        if (this.f33095Oo == null) {
            return "StringTokenizer[not tokenized yet]";
        }
        return "StringTokenizer" + IXxxXO();
    }

    public x0XOIxOo xI(boolean z) {
        this.f33101xoXoI = z;
        return this;
    }

    public List<String> xII(char[] cArr, int i, int i2) {
        if (cArr != null && i2 != 0) {
            TextStringBuilder textStringBuilder = new TextStringBuilder();
            ArrayList arrayList = new ArrayList();
            int i3 = i;
            while (i3 >= 0 && i3 < i2) {
                i3 = O0xOxO(cArr, i3, i2, textStringBuilder, arrayList);
                if (i3 >= i2) {
                    II0xO0(arrayList, "");
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public x0XOIxOo xXxxox0I(char c) {
        return IIX0o(xOx.II0XooXoX.f34478I0Io.II0xO0(c));
    }

    public xOx.Oxx0IOOO xoIox() {
        return this.f33096Oxx0xo;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (hasNext()) {
            String[] strArr = this.f33095Oo;
            int i = this.f33094IXxxXO;
            this.f33094IXxxXO = i + 1;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public String xxIXOIIO() {
        char[] cArr = this.f33098XO;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public x0XOIxOo xxX(char[] cArr) {
        XI0IXoo();
        if (cArr != null) {
            this.f33098XO = (char[]) cArr.clone();
        } else {
            this.f33098XO = null;
        }
        return this;
    }

    public x0XOIxOo(String str) {
        xOx.II0XooXoX iI0XooXoX = xOx.II0XooXoX.f34478I0Io;
        this.f33096Oxx0xo = iI0XooXoX.OOXIXo();
        this.f33100oI0IIXIo = iI0XooXoX.Oxx0IOOO();
        this.f33097OxxIIOOXO = iI0XooXoX.Oxx0IOOO();
        this.f33093IIXOooo = iI0XooXoX.Oxx0IOOO();
        this.f33101xoXoI = false;
        this.f33099o00 = true;
        if (str != null) {
            this.f33098XO = str.toCharArray();
        } else {
            this.f33098XO = null;
        }
    }

    public x0XOIxOo(String str, char c) {
        this(str);
        xXxxox0I(c);
    }

    public x0XOIxOo(String str, String str2) {
        this(str);
        ooXIXxIX(str2);
    }

    public x0XOIxOo(String str, xOx.Oxx0IOOO oxx0IOOO) {
        this(str);
        IIX0o(oxx0IOOO);
    }

    public x0XOIxOo(String str, char c, char c2) {
        this(str, c);
        oOXoIIIo(c2);
    }

    public x0XOIxOo(String str, xOx.Oxx0IOOO oxx0IOOO, xOx.Oxx0IOOO oxx0IOOO2) {
        this(str, oxx0IOOO);
        Xx000oIo(oxx0IOOO2);
    }

    public x0XOIxOo(char[] cArr) {
        xOx.II0XooXoX iI0XooXoX = xOx.II0XooXoX.f34478I0Io;
        this.f33096Oxx0xo = iI0XooXoX.OOXIXo();
        this.f33100oI0IIXIo = iI0XooXoX.Oxx0IOOO();
        this.f33097OxxIIOOXO = iI0XooXoX.Oxx0IOOO();
        this.f33093IIXOooo = iI0XooXoX.Oxx0IOOO();
        this.f33101xoXoI = false;
        this.f33099o00 = true;
        if (cArr == null) {
            this.f33098XO = null;
        } else {
            this.f33098XO = (char[]) cArr.clone();
        }
    }

    public x0XOIxOo(char[] cArr, char c) {
        this(cArr);
        xXxxox0I(c);
    }

    public x0XOIxOo(char[] cArr, String str) {
        this(cArr);
        ooXIXxIX(str);
    }

    public x0XOIxOo(char[] cArr, xOx.Oxx0IOOO oxx0IOOO) {
        this(cArr);
        IIX0o(oxx0IOOO);
    }

    public x0XOIxOo(char[] cArr, char c, char c2) {
        this(cArr, c);
        oOXoIIIo(c2);
    }

    public x0XOIxOo(char[] cArr, xOx.Oxx0IOOO oxx0IOOO, xOx.Oxx0IOOO oxx0IOOO2) {
        this(cArr, oxx0IOOO);
        Xx000oIo(oxx0IOOO2);
    }
}
