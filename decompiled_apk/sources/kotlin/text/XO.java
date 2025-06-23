package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class XO implements kotlin.sequences.ooOOo0oXI<X0.oOoXoXO> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f29567I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f29568II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CharSequence f29569oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<CharSequence, Integer, Pair<Integer, Integer>> f29570oxoX;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<X0.oOoXoXO>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f29571IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29572Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        @OXOo.oOoXoXO
        public X0.oOoXoXO f29573Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public int f29575XO = -1;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public int f29576oI0IIXIo;

        public oIX0oI() {
            int xI2 = X0.IIXOooo.xI(XO.this.f29568II0xO0, 0, XO.this.f29569oIX0oI.length());
            this.f29572Oo = xI2;
            this.f29571IXxxXO = xI2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f29574OxxIIOOXO.f29567I0Io) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void oIX0oI() {
            /*
                r6 = this;
                int r0 = r6.f29571IXxxXO
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f29575XO = r1
                r0 = 0
                r6.f29573Oxx0xo = r0
                goto L9e
            Lc:
                kotlin.text.XO r0 = kotlin.text.XO.this
                int r0 = kotlin.text.XO.oxoX(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f29576oI0IIXIo
                int r0 = r0 + r3
                r6.f29576oI0IIXIo = r0
                kotlin.text.XO r4 = kotlin.text.XO.this
                int r4 = kotlin.text.XO.oxoX(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f29571IXxxXO
                kotlin.text.XO r4 = kotlin.text.XO.this
                java.lang.CharSequence r4 = kotlin.text.XO.I0Io(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                X0.oOoXoXO r0 = new X0.oOoXoXO
                int r1 = r6.f29572Oo
                kotlin.text.XO r4 = kotlin.text.XO.this
                java.lang.CharSequence r4 = kotlin.text.XO.I0Io(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.IXX(r4)
                r0.<init>(r1, r4)
                r6.f29573Oxx0xo = r0
                r6.f29571IXxxXO = r2
                goto L9c
            L47:
                kotlin.text.XO r0 = kotlin.text.XO.this
                Oox.x0xO0oo r0 = kotlin.text.XO.II0xO0(r0)
                kotlin.text.XO r4 = kotlin.text.XO.this
                java.lang.CharSequence r4 = kotlin.text.XO.I0Io(r4)
                int r5 = r6.f29571IXxxXO
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                X0.oOoXoXO r0 = new X0.oOoXoXO
                int r1 = r6.f29572Oo
                kotlin.text.XO r4 = kotlin.text.XO.this
                java.lang.CharSequence r4 = kotlin.text.XO.I0Io(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.IXX(r4)
                r0.<init>(r1, r4)
                r6.f29573Oxx0xo = r0
                r6.f29571IXxxXO = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f29572Oo
                X0.oOoXoXO r4 = X0.IIXOooo.X00xOoXI(r4, r2)
                r6.f29573Oxx0xo = r4
                int r2 = r2 + r0
                r6.f29572Oo = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f29571IXxxXO = r2
            L9c:
                r6.f29575XO = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.XO.oIX0oI.oIX0oI():void");
        }

        @Override // java.util.Iterator
        @OXOo.OOXIXo
        /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
        public X0.oOoXoXO next() {
            if (this.f29575XO == -1) {
                oIX0oI();
            }
            if (this.f29575XO != 0) {
                X0.oOoXoXO oooxoxo = this.f29573Oxx0xo;
                IIX0o.x0XOIxOo(oooxoxo, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f29573Oxx0xo = null;
                this.f29575XO = -1;
                return oooxoxo;
            }
            throw new NoSuchElementException();
        }

        public final int II0xO0() {
            return this.f29576oI0IIXIo;
        }

        public final void OOXIXo(@OXOo.oOoXoXO X0.oOoXoXO oooxoxo) {
            this.f29573Oxx0xo = oooxoxo;
        }

        public final int Oxx0IOOO() {
            return this.f29575XO;
        }

        @OXOo.oOoXoXO
        public final X0.oOoXoXO X0o0xo() {
            return this.f29573Oxx0xo;
        }

        public final int XO() {
            return this.f29571IXxxXO;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29575XO == -1) {
                oIX0oI();
            }
            if (this.f29575XO == 1) {
                return true;
            }
            return false;
        }

        public final void oOoXoXO(int i) {
            this.f29571IXxxXO = i;
        }

        public final void ooOOo0oXI(int i) {
            this.f29575XO = i;
        }

        public final int oxoX() {
            return this.f29572Oo;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void xoIox(int i) {
            this.f29572Oo = i;
        }

        public final void xxIXOIIO(int i) {
            this.f29576oI0IIXIo = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XO(@OXOo.OOXIXo CharSequence input, int i, int i2, @OXOo.OOXIXo Oox.x0xO0oo<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(getNextMatch, "getNextMatch");
        this.f29569oIX0oI = input;
        this.f29568II0xO0 = i;
        this.f29567I0Io = i2;
        this.f29570oxoX = getNextMatch;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<X0.oOoXoXO> iterator() {
        return new oIX0oI();
    }
}
