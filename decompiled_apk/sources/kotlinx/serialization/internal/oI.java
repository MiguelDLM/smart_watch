package kotlinx.serialization.internal;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class oI extends xoO0xx0<kotlin.XI0oooXX, kotlin.OOXIxO0, IXO> implements kotlinx.serialization.Oxx0IOOO<kotlin.OOXIxO0> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oI f30727I0Io = new oI();

    public oI() {
        super(xx.oOoXoXO.O0xOxO(kotlin.XI0oooXX.f29073Oo));
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ void X0IIOO(xIXoO0Xx.X0o0xo x0o0xo, kotlin.OOXIxO0 oOXIxO0, int i) {
        xXxxox0I(x0o0xo, oOXIxO0.oI0IIXIo(), i);
    }

    public int XI0IXoo(@OXOo.OOXIXo long[] collectionSize) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collectionSize, "$this$collectionSize");
        return kotlin.OOXIxO0.ooOOo0oXI(collectionSize);
    }

    @OXOo.OOXIXo
    public long[] XIxXXX0x0() {
        return kotlin.OOXIxO0.oxoX(0);
    }

    @OXOo.OOXIXo
    public IXO XxX0x0xxx(@OXOo.OOXIXo long[] toBuilder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(toBuilder, "$this$toBuilder");
        return new IXO(toBuilder, null);
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ Object x0xO0oo(Object obj) {
        return XxX0x0xxx(((kotlin.OOXIxO0) obj).oI0IIXIo());
    }

    public void xXxxox0I(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo long[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(oIX0oI(), i2).encodeLong(kotlin.OOXIxO0.OOXIXo(content, i2));
        }
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    public /* bridge */ /* synthetic */ int xoIox(Object obj) {
        return XI0IXoo(((kotlin.OOXIxO0) obj).oI0IIXIo());
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    public /* bridge */ /* synthetic */ kotlin.OOXIxO0 xoXoI() {
        return kotlin.OOXIxO0.II0xO0(XIxXXX0x0());
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo IXO builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(kotlin.XI0oooXX.oOoXoXO(decoder.decodeInlineElement(oIX0oI(), i).decodeLong()));
    }
}
