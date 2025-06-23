package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Set<oxoX> f33024I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f33025II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<Character> f33026X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f33027oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final oO f33028oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 implements org.apache.commons.text.II0xO0<Oxx0IOOO> {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public static final int f33029IIXOooo = 0;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public static final int f33030OxxIIOOXO = 1114111;

        /* renamed from: xoXoI, reason: collision with root package name */
        public static final int f33031xoXoI = 0;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public Set<oxoX> f33032IXxxXO;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public oO f33034Oxx0xo;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public List<Character> f33036oI0IIXIo;

        /* renamed from: XO, reason: collision with root package name */
        public int f33035XO = 0;

        /* renamed from: Oo, reason: collision with root package name */
        public int f33033Oo = f33030OxxIIOOXO;

        public II0xO0 I0Io(char... cArr) {
            this.f33036oI0IIXIo = new ArrayList();
            for (char c : cArr) {
                this.f33036oI0IIXIo.add(Character.valueOf(c));
            }
            return this;
        }

        public II0xO0 II0xO0(oxoX... oxoxArr) {
            if (org.apache.commons.lang3.oxoX.XOxxooXI(oxoxArr)) {
                this.f33032IXxxXO = null;
                return this;
            }
            Set<oxoX> set = this.f33032IXxxXO;
            if (set == null) {
                this.f33032IXxxXO = new HashSet();
            } else {
                set.clear();
            }
            Collections.addAll(this.f33032IXxxXO, oxoxArr);
            return this;
        }

        public II0xO0 X0o0xo(int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (i <= i2) {
                z = true;
            } else {
                z = false;
            }
            xoIxX.XI0IXoo(z, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            xoIxX.X0IIOO(z2, "Minimum code point %d is negative", i);
            if (i2 <= 1114111) {
                z3 = true;
            }
            xoIxX.X0IIOO(z3, "Value %d is larger than Character.MAX_CODE_POINT.", i2);
            this.f33035XO = i;
            this.f33033Oo = i2;
            return this;
        }

        public II0xO0 XO(char[]... cArr) {
            boolean z;
            boolean z2;
            this.f33036oI0IIXIo = new ArrayList();
            for (char[] cArr2 : cArr) {
                if (cArr2.length == 2) {
                    z = true;
                } else {
                    z = false;
                }
                xoIxX.XI0IXoo(z, "Each pair must contain minimum and maximum code point", new Object[0]);
                char c = cArr2[0];
                char c2 = cArr2[1];
                if (c <= c2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                xoIxX.XI0IXoo(z2, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(c), Integer.valueOf(c2));
                for (int i = c; i <= c2; i++) {
                    this.f33036oI0IIXIo.add(Character.valueOf((char) i));
                }
            }
            return this;
        }

        @Override // org.apache.commons.text.II0xO0
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Oxx0IOOO build() {
            return new Oxx0IOOO(this.f33035XO, this.f33033Oo, this.f33032IXxxXO, this.f33034Oxx0xo, this.f33036oI0IIXIo);
        }

        public II0xO0 oxoX(oO oOVar) {
            this.f33034Oxx0xo = oOVar;
            return this;
        }
    }

    public final int I0Io(int i, int i2) {
        oO oOVar = this.f33028oxoX;
        if (oOVar != null) {
            return oOVar.nextInt((i2 - i) + 1) + i;
        }
        return ThreadLocalRandom.current().nextInt(i, i2 + 1);
    }

    public String II0xO0(int i, int i2) {
        boolean z;
        boolean z2;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.X0IIOO(z, "Minimum length %d is smaller than zero.", i);
        if (i <= i2) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Maximum length %d is smaller than minimum length %d.", Integer.valueOf(i2), Integer.valueOf(i));
        return oIX0oI(I0Io(i, i2));
    }

    public String oIX0oI(int i) {
        boolean z;
        int I0Io2;
        if (i == 0) {
            return "";
        }
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        long j = i;
        xoIxX.X0IIOO(z, "Length %d is smaller than zero.", j);
        StringBuilder sb = new StringBuilder(i);
        do {
            List<Character> list = this.f33026X0o0xo;
            if (list != null && !list.isEmpty()) {
                I0Io2 = oxoX(this.f33026X0o0xo);
            } else {
                I0Io2 = I0Io(this.f33027oIX0oI, this.f33025II0xO0);
            }
            int type = Character.getType(I0Io2);
            if (type != 0 && type != 18 && type != 19) {
                Set<oxoX> set = this.f33024I0Io;
                if (set != null) {
                    Iterator<oxoX> it = set.iterator();
                    while (it.hasNext()) {
                        if (it.next().test(I0Io2)) {
                        }
                    }
                }
                sb.appendCodePoint(I0Io2);
                j--;
                break;
            }
        } while (j != 0);
        return sb.toString();
    }

    public final int oxoX(List<Character> list) {
        int size = list.size();
        oO oOVar = this.f33028oxoX;
        if (oOVar != null) {
            return String.valueOf(list.get(oOVar.nextInt(size))).codePointAt(0);
        }
        return String.valueOf(list.get(ThreadLocalRandom.current().nextInt(0, size))).codePointAt(0);
    }

    public Oxx0IOOO(int i, int i2, Set<oxoX> set, oO oOVar, List<Character> list) {
        this.f33027oIX0oI = i;
        this.f33025II0xO0 = i2;
        this.f33024I0Io = set;
        this.f33028oxoX = oOVar;
        this.f33026X0o0xo = list;
    }
}
