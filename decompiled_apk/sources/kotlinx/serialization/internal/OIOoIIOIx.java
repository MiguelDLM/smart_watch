package kotlinx.serialization.internal;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class OIOoIIOIx extends xoO0xx0<kotlin.x0xO, kotlin.OO0x0xX, XIXIxO> implements kotlinx.serialization.Oxx0IOOO<kotlin.OO0x0xX> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OIOoIIOIx f30650I0Io = new OIOoIIOIx();

    public OIOoIIOIx() {
        super(xx.oOoXoXO.o00(kotlin.x0xO.f29655Oo));
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ void X0IIOO(xIXoO0Xx.X0o0xo x0o0xo, kotlin.OO0x0xX oO0x0xX, int i) {
        xXxxox0I(x0o0xo, oO0x0xX.oI0IIXIo(), i);
    }

    public int XI0IXoo(@OXOo.OOXIXo byte[] collectionSize) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collectionSize, "$this$collectionSize");
        return kotlin.OO0x0xX.ooOOo0oXI(collectionSize);
    }

    @OXOo.OOXIXo
    public byte[] XIxXXX0x0() {
        return kotlin.OO0x0xX.oxoX(0);
    }

    @OXOo.OOXIXo
    public XIXIxO XxX0x0xxx(@OXOo.OOXIXo byte[] toBuilder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(toBuilder, "$this$toBuilder");
        return new XIXIxO(toBuilder, null);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ Object x0xO0oo(Object obj) {
        return XxX0x0xxx(((kotlin.OO0x0xX) obj).oI0IIXIo());
    }

    public void xXxxox0I(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo byte[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(oIX0oI(), i2).encodeByte(kotlin.OO0x0xX.OOXIXo(content, i2));
        }
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ int xoIox(Object obj) {
        return XI0IXoo(((kotlin.OO0x0xX) obj).oI0IIXIo());
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ kotlin.OO0x0xX xoXoI() {
        return kotlin.OO0x0xX.II0xO0(XIxXXX0x0());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo XIXIxO builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(kotlin.x0xO.oOoXoXO(decoder.decodeInlineElement(oIX0oI(), i).decodeByte()));
    }
}
