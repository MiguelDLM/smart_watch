package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class XOxIOxOx extends xoO0xx0<Integer, int[], x0o> implements kotlinx.serialization.Oxx0IOOO<int[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XOxIOxOx f30704I0Io = new XOxIOxOx();

    public XOxIOxOx() {
        super(xx.oOoXoXO.ooXIXxIX(kotlin.jvm.internal.XxX0x0xxx.f29326oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public int[] xoXoI() {
        return new int[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public x0o x0xO0oo(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return new x0o(iArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo int[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeIntElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo x0o builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeIntElement(oIX0oI(), i));
    }
}
