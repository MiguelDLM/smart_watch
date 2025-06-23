package kotlinx.datetime.serializers;

import IOI.oOoIIO0;
import java.time.Month;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.internal.EnumSerializer;

/* loaded from: classes6.dex */
public final class xxIXOIIO implements kotlinx.serialization.Oxx0IOOO<Month> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final EnumSerializer<Month> f30545II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xxIXOIIO f30546oIX0oI = new xxIXOIIO();

    static {
        Month[] values;
        values = Month.values();
        f30545II0xO0 = new EnumSerializer<>("Month", values);
    }

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, oOoIIO0.oIX0oI(obj));
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo Month value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        f30545II0xO0.II0xO0(encoder, value);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Month oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return oOoIIO0.oIX0oI(f30545II0xO0.oxoX(decoder));
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30545II0xO0.oIX0oI();
    }
}
