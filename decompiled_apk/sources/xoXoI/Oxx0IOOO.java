package xoXoI;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Oxx0IOOO extends xoIox<Float> {
    public Oxx0IOOO() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float X0o0xo(II0xO0<Float> iI0xO0) {
        T t = this.f35180I0Io;
        if (t != 0) {
            return (Float) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // xoXoI.xoIox
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Float oIX0oI(II0xO0<Float> iI0xO0) {
        return Float.valueOf(IIXOooo.xxIXOIIO.OOXIXo(iI0xO0.Oxx0IOOO().floatValue(), iI0xO0.II0xO0().floatValue(), iI0xO0.I0Io()) + X0o0xo(iI0xO0).floatValue());
    }

    public Oxx0IOOO(@NonNull Float f) {
        super(f);
    }
}
