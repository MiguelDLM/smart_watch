package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class IXxxXO extends xoO0xx0<Character, char[], x0xO0oo> implements kotlinx.serialization.Oxx0IOOO<char[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IXxxXO f30633I0Io = new IXxxXO();

    public IXxxXO() {
        super(xx.oOoXoXO.XxX0x0xxx(kotlin.jvm.internal.x0xO0oo.f29369oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public char[] xoXoI() {
        return new char[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public x0xO0oo x0xO0oo(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return new x0xO0oo(cArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo char[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeCharElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo x0xO0oo builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeCharElement(oIX0oI(), i));
    }
}
