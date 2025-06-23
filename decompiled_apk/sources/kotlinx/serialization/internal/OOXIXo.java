package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class OOXIXo extends xoO0xx0<Byte, byte[], xoIox> implements kotlinx.serialization.Oxx0IOOO<byte[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OOXIXo f30654I0Io = new OOXIXo();

    public OOXIXo() {
        super(xx.oOoXoXO.xxX(kotlin.jvm.internal.x0XOIxOo.f29360oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public byte[] xoXoI() {
        return new byte[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public xoIox x0xO0oo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return new xoIox(bArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo byte[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeByteElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo xoIox builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeByteElement(oIX0oI(), i));
    }
}
