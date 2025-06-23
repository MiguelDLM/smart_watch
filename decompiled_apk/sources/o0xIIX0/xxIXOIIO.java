package o0xIIX0;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int[] f31225I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f31226II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f31227oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int[] f31228oxoX;

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public final int f31229I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f31230II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f31231oIX0oI;

        public oIX0oI(int i, int i2, int i3) {
            this.f31231oIX0oI = i;
            this.f31230II0xO0 = i2;
            this.f31229I0Io = i3;
        }

        public int I0Io() {
            return this.f31231oIX0oI;
        }

        public int II0xO0() {
            return this.f31230II0xO0;
        }

        public int oIX0oI() {
            return this.f31229I0Io;
        }
    }

    public xxIXOIIO(String str, String str2) {
        this.f31227oIX0oI = str;
        this.f31226II0xO0 = str2;
        int length = str.length() + str2.length() + 2;
        this.f31225I0Io = new int[length];
        this.f31228oxoX = new int[length];
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r6[r5 - 1] < r6[r5 + 1]) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ac, code lost:
    
        if (r6[r7 + 1] <= r6[r7 - 1]) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0105, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o0xIIX0.xxIXOIIO.oIX0oI I0Io(int r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0xIIX0.xxIXOIIO.I0Io(int, int, int, int):o0xIIX0.xxIXOIIO$oIX0oI");
    }

    public final oIX0oI II0xO0(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (true) {
            int i6 = i5 - i2;
            if (i6 >= i4 || i5 >= i3 || this.f31227oIX0oI.charAt(i5) != this.f31226II0xO0.charAt(i6)) {
                break;
            }
            i5++;
        }
        return new oIX0oI(i, i5, i2);
    }

    public final void oIX0oI(int i, int i2, int i3, int i4, oxoX<Character> oxox) {
        oIX0oI I0Io2 = I0Io(i, i2, i3, i4);
        if (I0Io2 != null && ((I0Io2.I0Io() != i2 || I0Io2.oIX0oI() != i2 - i4) && (I0Io2.II0xO0() != i || I0Io2.oIX0oI() != i - i3))) {
            oIX0oI(i, I0Io2.I0Io(), i3, I0Io2.I0Io() - I0Io2.oIX0oI(), oxox);
            for (int I0Io3 = I0Io2.I0Io(); I0Io3 < I0Io2.II0xO0(); I0Io3++) {
                oxox.I0Io(new XO<>(Character.valueOf(this.f31227oIX0oI.charAt(I0Io3))));
            }
            oIX0oI(I0Io2.II0xO0(), i2, I0Io2.II0xO0() - I0Io2.oIX0oI(), i4, oxox);
            return;
        }
        int i5 = i;
        int i6 = i3;
        while (true) {
            if (i5 >= i2 && i6 >= i4) {
                return;
            }
            if (i5 < i2 && i6 < i4 && this.f31227oIX0oI.charAt(i5) == this.f31226II0xO0.charAt(i6)) {
                oxox.I0Io(new XO<>(Character.valueOf(this.f31227oIX0oI.charAt(i5))));
                i5++;
            } else if (i2 - i > i4 - i3) {
                oxox.oIX0oI(new II0xO0<>(Character.valueOf(this.f31227oIX0oI.charAt(i5))));
                i5++;
            } else {
                oxox.II0xO0(new X0o0xo<>(Character.valueOf(this.f31226II0xO0.charAt(i6))));
            }
            i6++;
        }
    }

    public oxoX<Character> oxoX() {
        oxoX<Character> oxox = new oxoX<>();
        oIX0oI(0, this.f31227oIX0oI.length(), 0, this.f31226II0xO0.length(), oxox);
        return oxox;
    }
}
