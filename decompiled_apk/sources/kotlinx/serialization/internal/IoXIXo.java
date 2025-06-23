package kotlinx.serialization.internal;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class IoXIXo extends xoO0xx0<kotlin.OX00O0xII, kotlin.xX0IIXIx0, O0IxXx> implements kotlinx.serialization.Oxx0IOOO<kotlin.xX0IIXIx0> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IoXIXo f30634I0Io = new IoXIXo();

    public IoXIXo() {
        super(xx.oOoXoXO.X0IIOO(kotlin.OX00O0xII.f29065Oo));
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ void X0IIOO(xIXoO0Xx.X0o0xo x0o0xo, kotlin.xX0IIXIx0 xx0iixix0, int i) {
        xXxxox0I(x0o0xo, xx0iixix0.oI0IIXIo(), i);
    }

    public int XI0IXoo(@OXOo.OOXIXo short[] collectionSize) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collectionSize, "$this$collectionSize");
        return kotlin.xX0IIXIx0.ooOOo0oXI(collectionSize);
    }

    @OXOo.OOXIXo
    public short[] XIxXXX0x0() {
        return kotlin.xX0IIXIx0.oxoX(0);
    }

    @OXOo.OOXIXo
    public O0IxXx XxX0x0xxx(@OXOo.OOXIXo short[] toBuilder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(toBuilder, "$this$toBuilder");
        return new O0IxXx(toBuilder, null);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ Object x0xO0oo(Object obj) {
        return XxX0x0xxx(((kotlin.xX0IIXIx0) obj).oI0IIXIo());
    }

    public void xXxxox0I(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo short[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(oIX0oI(), i2).encodeShort(kotlin.xX0IIXIx0.OOXIXo(content, i2));
        }
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ int xoIox(Object obj) {
        return XI0IXoo(((kotlin.xX0IIXIx0) obj).oI0IIXIo());
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ kotlin.xX0IIXIx0 xoXoI() {
        return kotlin.xX0IIXIx0.II0xO0(XIxXXX0x0());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo O0IxXx builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(kotlin.OX00O0xII.oOoXoXO(decoder.decodeInlineElement(oIX0oI(), i).decodeShort()));
    }
}
