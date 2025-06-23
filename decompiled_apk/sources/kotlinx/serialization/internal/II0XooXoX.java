package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class II0XooXoX extends xoO0xx0<Boolean, boolean[], Oxx0IOOO> implements kotlinx.serialization.Oxx0IOOO<boolean[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0XooXoX f30625I0Io = new II0XooXoX();

    public II0XooXoX() {
        super(xx.oOoXoXO.XIxXXX0x0(kotlin.jvm.internal.oOoXoXO.f29340oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public boolean[] xoXoI() {
        return new boolean[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public Oxx0IOOO x0xO0oo(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return new Oxx0IOOO(zArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo boolean[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeBooleanElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo Oxx0IOOO builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeBooleanElement(oIX0oI(), i));
    }
}
