package kotlin;

@oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public final class o00 implements Comparable<o00> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29386OxxIIOOXO = 255;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f29388IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f29389Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final int f29390Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f29391XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29387oI0IIXIo = new oIX0oI(null);

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final o00 f29385IIXOooo = OxI.oIX0oI();

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public o00(int i, int i2, int i3) {
        this.f29391XO = i;
        this.f29389Oo = i2;
        this.f29388IXxxXO = i3;
        this.f29390Oxx0xo = OOXIXo(i, i2, i3);
    }

    @Override // java.lang.Comparable
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public int compareTo(@OXOo.OOXIXo o00 other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        return this.f29390Oxx0xo - other.f29390Oxx0xo;
    }

    public final boolean II0XooXoX(int i, int i2) {
        int i3 = this.f29391XO;
        if (i3 <= i && (i3 != i || this.f29389Oo < i2)) {
            return false;
        }
        return true;
    }

    public final int OOXIXo(int i, int i2, int i3) {
        if (new X0.oOoXoXO(0, 255).xxIXOIIO(i) && new X0.oOoXoXO(0, 255).xxIXOIIO(i2) && new X0.oOoXoXO(0, 255).xxIXOIIO(i3)) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public final int Oxx0IOOO() {
        return this.f29388IXxxXO;
    }

    public final int XO() {
        return this.f29389Oo;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        o00 o00Var;
        if (this == obj) {
            return true;
        }
        if (obj instanceof o00) {
            o00Var = (o00) obj;
        } else {
            o00Var = null;
        }
        if (o00Var != null && this.f29390Oxx0xo == o00Var.f29390Oxx0xo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f29390Oxx0xo;
    }

    public final int oxoX() {
        return this.f29391XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f29391XO);
        sb.append('.');
        sb.append(this.f29389Oo);
        sb.append('.');
        sb.append(this.f29388IXxxXO);
        return sb.toString();
    }

    public final boolean xoIox(int i, int i2, int i3) {
        int i4;
        int i5 = this.f29391XO;
        if (i5 <= i && (i5 != i || ((i4 = this.f29389Oo) <= i2 && (i4 != i2 || this.f29388IXxxXO < i3)))) {
            return false;
        }
        return true;
    }

    public o00(int i, int i2) {
        this(i, i2, 0);
    }
}
