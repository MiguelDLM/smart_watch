package kotlinx.serialization.internal;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class IxIX0I extends xoO0xx0<kotlin.xxIO, kotlin.XX0xXo, XXoOx0> implements kotlinx.serialization.Oxx0IOOO<kotlin.XX0xXo> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IxIX0I f30639I0Io = new IxIX0I();

    public IxIX0I() {
        super(xx.oOoXoXO.OxI(kotlin.xxIO.f29674Oo));
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ void X0IIOO(xIXoO0Xx.X0o0xo x0o0xo, kotlin.XX0xXo xX0xXo, int i) {
        xXxxox0I(x0o0xo, xX0xXo.oI0IIXIo(), i);
    }

    public int XI0IXoo(@OXOo.OOXIXo int[] collectionSize) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collectionSize, "$this$collectionSize");
        return kotlin.XX0xXo.ooOOo0oXI(collectionSize);
    }

    @OXOo.OOXIXo
    public int[] XIxXXX0x0() {
        return kotlin.XX0xXo.oxoX(0);
    }

    @OXOo.OOXIXo
    public XXoOx0 XxX0x0xxx(@OXOo.OOXIXo int[] toBuilder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(toBuilder, "$this$toBuilder");
        return new XXoOx0(toBuilder, null);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ Object x0xO0oo(Object obj) {
        return XxX0x0xxx(((kotlin.XX0xXo) obj).oI0IIXIo());
    }

    public void xXxxox0I(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo int[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(oIX0oI(), i2).encodeInt(kotlin.XX0xXo.OOXIXo(content, i2));
        }
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ int xoIox(Object obj) {
        return XI0IXoo(((kotlin.XX0xXo) obj).oI0IIXIo());
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ kotlin.XX0xXo xoXoI() {
        return kotlin.XX0xXo.II0xO0(XIxXXX0x0());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo XXoOx0 builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(kotlin.xxIO.oOoXoXO(decoder.decodeInlineElement(oIX0oI(), i).decodeInt()));
    }
}
