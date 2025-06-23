package IOI;

import kotlinx.datetime.DateTimeFormatException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.oIX0oI.class)
/* loaded from: classes6.dex */
public final class II0XooXoX extends xxIXOIIO {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f471II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f472oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final II0XooXoX oIX0oI(@OXOo.OOXIXo String text) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
            xxIXOIIO oIX0oI2 = xxIXOIIO.Companion.oIX0oI(text);
            if (oIX0oI2 instanceof II0XooXoX) {
                return (II0XooXoX) oIX0oI2;
            }
            throw new DateTimeFormatException("Period " + oIX0oI2 + " (parsed from string " + text + ") is not date-based");
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<II0XooXoX> serializer() {
            return kotlinx.datetime.serializers.oIX0oI.f30540oIX0oI;
        }

        public oIX0oI() {
        }
    }

    public II0XooXoX(int i, int i2) {
        super(null);
        this.f472oIX0oI = i;
        this.f471II0xO0 = i2;
    }

    @Override // IOI.xxIXOIIO
    public int I0Io() {
        return 0;
    }

    @Override // IOI.xxIXOIIO
    public int II0XooXoX() {
        return this.f472oIX0oI;
    }

    @Override // IOI.xxIXOIIO
    public int II0xO0() {
        return this.f471II0xO0;
    }

    @Override // IOI.xxIXOIIO
    public int Oxx0IOOO() {
        return 0;
    }

    @Override // IOI.xxIXOIIO
    public int XO() {
        return 0;
    }

    @Override // IOI.xxIXOIIO
    public int oxoX() {
        return 0;
    }

    @Override // IOI.xxIXOIIO
    public long xxIXOIIO() {
        return 0L;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public II0XooXoX(int r1, int r2, int r3) {
        /*
            r0 = this;
            int r1 = IOI.OOXIXo.I0Io(r1, r2)
            r0.<init>(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: IOI.II0XooXoX.<init>(int, int, int):void");
    }

    public /* synthetic */ II0XooXoX(int i, int i2, int i3, int i4, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
