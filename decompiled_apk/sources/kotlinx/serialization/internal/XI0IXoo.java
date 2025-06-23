package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class XI0IXoo extends xoO0xx0<Double, double[], X0IIOO> implements kotlinx.serialization.Oxx0IOOO<double[]> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XI0IXoo f30694I0Io = new XI0IXoo();

    public XI0IXoo() {
        super(xx.oOoXoXO.xXxxox0I(kotlin.jvm.internal.xoXoI.f29383oIX0oI));
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    /* renamed from: XI0IXoo, reason: merged with bridge method [inline-methods] */
    public int xoIox(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr.length;
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public double[] xoXoI() {
        return new double[0];
    }

    @Override // kotlinx.serialization.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] */
    public X0IIOO x0xO0oo(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return new X0IIOO(dArr);
    }

    @Override // kotlinx.serialization.internal.xoO0xx0
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public void X0IIOO(@OXOo.OOXIXo xIXoO0Xx.X0o0xo encoder, @OXOo.OOXIXo double[] content, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeDoubleElement(oIX0oI(), i2, content[i2]);
        }
    }

    @Override // kotlinx.serialization.internal.IIXOooo, kotlinx.serialization.internal.oIX0oI
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public void ooOOo0oXI(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, int i, @OXOo.OOXIXo X0IIOO builder, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        builder.X0o0xo(decoder.decodeDoubleElement(oIX0oI(), i));
    }
}
