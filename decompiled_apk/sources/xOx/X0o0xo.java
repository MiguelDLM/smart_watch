package xOx;

import java.util.Arrays;

/* loaded from: classes6.dex */
public abstract class X0o0xo implements Oxx0IOOO {

    /* loaded from: classes6.dex */
    public static final class I0Io extends X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final char f34488oIX0oI;

        public I0Io(char c) {
            this.f34488oIX0oI = c;
        }

        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            if (this.f34488oIX0oI == cArr[i]) {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f34488oIX0oI == charSequence.charAt(i)) {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            return 1;
        }

        public String toString() {
            return super.toString() + "['" + this.f34488oIX0oI + "']";
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends X0o0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String f34489II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final char[] f34490oIX0oI;

        public II0xO0(char... cArr) {
            this.f34489II0xO0 = String.valueOf(cArr);
            this.f34490oIX0oI = (char[]) cArr.clone();
        }

        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            int size = size();
            if (i + size > i3) {
                return 0;
            }
            int i4 = 0;
            while (i4 < size) {
                if (this.f34490oIX0oI[i4] != cArr[i]) {
                    return 0;
                }
                i4++;
                i++;
            }
            return size;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            int size = size();
            if (i + size > i3) {
                return 0;
            }
            int i4 = 0;
            while (i4 < size) {
                if (this.f34490oIX0oI[i4] != charSequence.charAt(i)) {
                    return 0;
                }
                i4++;
                i++;
            }
            return size;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            return this.f34490oIX0oI.length;
        }

        public String toString() {
            return super.toString() + "[\"" + this.f34489II0xO0 + "\"]";
        }
    }

    /* renamed from: xOx.X0o0xo$X0o0xo, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1161X0o0xo extends X0o0xo {
        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class XO extends X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final int f34491oIX0oI = 32;

        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            if (cArr[i] <= ' ') {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.charAt(i) <= ' ') {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            return 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Oxx0IOOO[] f34492oIX0oI;

        public oIX0oI(Oxx0IOOO... oxx0IOOOArr) {
            this.f34492oIX0oI = (Oxx0IOOO[]) oxx0IOOOArr.clone();
        }

        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            int i4 = 0;
            for (Oxx0IOOO oxx0IOOO : this.f34492oIX0oI) {
                if (oxx0IOOO != null) {
                    int I0Io2 = oxx0IOOO.I0Io(cArr, i, i2, i3);
                    if (I0Io2 == 0) {
                        return 0;
                    }
                    i4 += I0Io2;
                    i += I0Io2;
                }
            }
            return i4;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = 0;
            for (Oxx0IOOO oxx0IOOO : this.f34492oIX0oI) {
                if (oxx0IOOO != null) {
                    int oxoX2 = oxx0IOOO.oxoX(charSequence, i, i2, i3);
                    if (oxoX2 == 0) {
                        return 0;
                    }
                    i4 += oxoX2;
                    i += oxoX2;
                }
            }
            return i4;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            int i = 0;
            for (Oxx0IOOO oxx0IOOO : this.f34492oIX0oI) {
                if (oxx0IOOO != null) {
                    i += oxx0IOOO.size();
                }
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final char[] f34493oIX0oI;

        public oxoX(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.f34493oIX0oI = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // xOx.Oxx0IOOO
        public int I0Io(char[] cArr, int i, int i2, int i3) {
            if (Arrays.binarySearch(this.f34493oIX0oI, cArr[i]) >= 0) {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int oxoX(CharSequence charSequence, int i, int i2, int i3) {
            if (Arrays.binarySearch(this.f34493oIX0oI, charSequence.charAt(i)) >= 0) {
                return 1;
            }
            return 0;
        }

        @Override // xOx.X0o0xo, xOx.Oxx0IOOO
        public int size() {
            return 1;
        }

        public String toString() {
            return super.toString() + Arrays.toString(this.f34493oIX0oI);
        }
    }

    @Override // xOx.Oxx0IOOO
    public /* synthetic */ int II0xO0(CharSequence charSequence, int i) {
        return xOx.XO.II0xO0(this, charSequence, i);
    }

    @Override // xOx.Oxx0IOOO
    public /* synthetic */ Oxx0IOOO X0o0xo(Oxx0IOOO oxx0IOOO) {
        return xOx.XO.oIX0oI(this, oxx0IOOO);
    }

    @Override // xOx.Oxx0IOOO
    public /* synthetic */ int oIX0oI(char[] cArr, int i) {
        return xOx.XO.oxoX(this, cArr, i);
    }

    @Override // xOx.Oxx0IOOO
    public /* synthetic */ int oxoX(CharSequence charSequence, int i, int i2, int i3) {
        return xOx.XO.I0Io(this, charSequence, i, i2, i3);
    }

    @Override // xOx.Oxx0IOOO
    public /* synthetic */ int size() {
        return xOx.XO.X0o0xo(this);
    }
}
