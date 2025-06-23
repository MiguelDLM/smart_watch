package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class ooXIXxIX extends xoO0xx0<Float, float[], IIX0o> implements kotlinx.serialization.Oxx0IOOO<float[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ooXIXxIX f30740I0Io = new ooXIXxIX();

    public ooXIXxIX() {
        super(xx.oOoXoXO.IIX0o(kotlin.jvm.internal.O0xOxO.f29290oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public float[] xoXoI() {
        return new float[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public IIX0o x0xO0oo(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return new IIX0o(fArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo float[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeFloatElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo IIX0o builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeFloatElement(oIX0oI(), i));
    }
}
