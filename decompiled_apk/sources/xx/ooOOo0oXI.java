package xx;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.X0o0xo;
import kotlinx.serialization.descriptors.XO;
import xIXoO0Xx.II0XooXoX;

/* loaded from: classes6.dex */
public final class ooOOo0oXI implements Oxx0IOOO<Long> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final ooOOo0oXI f35198oIX0oI = new ooOOo0oXI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final XO f35197II0xO0 = SerialDescriptorsKt.oIX0oI("kotlinx.serialization.LongAsStringSerializer", X0o0xo.xxIXOIIO.f30595oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((Number) obj).longValue());
    }

    public void Oxx0IOOO(@OOXIXo II0XooXoX encoder, long j) {
        IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeString(String.valueOf(j));
    }

    @Override // kotlinx.serialization.I0Io
    @OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Long oxoX(@OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return Long.valueOf(Long.parseLong(decoder.decodeString()));
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OOXIXo
    public XO oIX0oI() {
        return f35197II0xO0;
    }
}
