package kotlinx.datetime.serializers;

import IOI.x0XOIxOo;
import java.time.DayOfWeek;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.internal.EnumSerializer;

/* loaded from: classes6.dex */
public final class I0Io implements kotlinx.serialization.Oxx0IOOO<DayOfWeek> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final EnumSerializer<DayOfWeek> f30513II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f30514oIX0oI = new I0Io();

    static {
        DayOfWeek[] values;
        values = DayOfWeek.values();
        f30513II0xO0 = new EnumSerializer<>("Month", values);
    }

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, x0XOIxOo.oIX0oI(obj));
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo DayOfWeek value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        f30513II0xO0.II0xO0(encoder, value);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public DayOfWeek oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return x0XOIxOo.oIX0oI(f30513II0xO0.oxoX(decoder));
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30513II0xO0.oIX0oI();
    }
}
