package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import xIXoO0Xx.II0XooXoX;
import xIXoO0Xx.X0o0xo;

@kotlin.jvm.internal.XX({"SMAP\nTagged.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedEncoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class oxIIX0o<Tag> implements xIXoO0Xx.II0XooXoX, xIXoO0Xx.X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<Tag> f30741oIX0oI = new ArrayList<>();

    private final boolean oIX0oI(kotlinx.serialization.descriptors.XO xo2, int i) {
        OxxIIOOXO(Oxx0xo(xo2, i));
        return true;
    }

    public void I0Io(Tag tag, byte b) {
        oO(tag, Byte.valueOf(b));
    }

    @OXOo.OOXIXo
    public xIXoO0Xx.II0XooXoX II0XooXoX(Tag tag, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO inlineDescriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(inlineDescriptor, "inlineDescriptor");
        OxxIIOOXO(tag);
        return this;
    }

    public void II0xO0(Tag tag, boolean z) {
        oO(tag, Boolean.valueOf(z));
    }

    @OXOo.oOoXoXO
    public final Tag IXxxXO() {
        return (Tag) CollectionsKt___CollectionsKt.xX0ox(this.f30741oIX0oI);
    }

    public void OOXIXo(Tag tag) {
    }

    public final Tag Oo() {
        return (Tag) CollectionsKt___CollectionsKt.O0O0Io00X(this.f30741oIX0oI);
    }

    public void Oxx0IOOO(Tag tag, float f) {
        oO(tag, Float.valueOf(f));
    }

    public abstract Tag Oxx0xo(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    public final void OxxIIOOXO(Tag tag) {
        this.f30741oIX0oI.add(tag);
    }

    public void X0o0xo(Tag tag, double d) {
        oO(tag, Double.valueOf(d));
    }

    public void XO(Tag tag, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        oO(tag, Integer.valueOf(i));
    }

    @Override // xIXoO0Xx.II0XooXoX
    @OXOo.OOXIXo
    public xIXoO0Xx.X0o0xo beginCollection(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        return II0XooXoX.oIX0oI.oIX0oI(this, xo2, i);
    }

    @Override // xIXoO0Xx.II0XooXoX
    @OXOo.OOXIXo
    public xIXoO0Xx.X0o0xo beginStructure(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeBoolean(boolean z) {
        II0xO0(oI0IIXIo(), z);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeBooleanElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        II0xO0(Oxx0xo(descriptor, i), z);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeByte(byte b) {
        I0Io(oI0IIXIo(), b);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeByteElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        I0Io(Oxx0xo(descriptor, i), b);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeChar(char c) {
        oxoX(oI0IIXIo(), c);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeCharElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, char c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        oxoX(Oxx0xo(descriptor, i), c);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeDouble(double d) {
        X0o0xo(oI0IIXIo(), d);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeDoubleElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, double d) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        X0o0xo(Oxx0xo(descriptor, i), d);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeEnum(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        XO(oI0IIXIo(), enumDescriptor, i);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeFloat(float f) {
        Oxx0IOOO(oI0IIXIo(), f);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeFloatElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        Oxx0IOOO(Oxx0xo(descriptor, i), f);
    }

    @Override // xIXoO0Xx.II0XooXoX
    @OXOo.OOXIXo
    public xIXoO0Xx.II0XooXoX encodeInline(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return II0XooXoX(oI0IIXIo(), descriptor);
    }

    @Override // xIXoO0Xx.X0o0xo
    @OXOo.OOXIXo
    public final xIXoO0Xx.II0XooXoX encodeInlineElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return II0XooXoX(Oxx0xo(descriptor, i), descriptor.X0o0xo(i));
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeInt(int i) {
        xxIXOIIO(oI0IIXIo(), i);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeIntElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        xxIXOIIO(Oxx0xo(descriptor, i), i2);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeLong(long j) {
        xoIox(oI0IIXIo(), j);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeLongElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        xoIox(Oxx0xo(descriptor, i), j);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeNotNullMark() {
        OOXIXo(Oo());
    }

    @Override // xIXoO0Xx.II0XooXoX
    public void encodeNull() {
        oOoXoXO(oI0IIXIo());
    }

    @Override // xIXoO0Xx.X0o0xo
    public <T> void encodeNullableSerializableElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OXOo.OOXIXo kotlinx.serialization.Oxx0xo<? super T> serializer, @OXOo.oOoXoXO T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(serializer, "serializer");
        if (oIX0oI(descriptor, i)) {
            encodeNullableSerializableValue(serializer, t);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    @kotlinx.serialization.oxoX
    public <T> void encodeNullableSerializableValue(@OXOo.OOXIXo kotlinx.serialization.Oxx0xo<? super T> oxx0xo, @OXOo.oOoXoXO T t) {
        II0XooXoX.oIX0oI.I0Io(this, oxx0xo, t);
    }

    @Override // xIXoO0Xx.X0o0xo
    public <T> void encodeSerializableElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OXOo.OOXIXo kotlinx.serialization.Oxx0xo<? super T> serializer, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(serializer, "serializer");
        if (oIX0oI(descriptor, i)) {
            encodeSerializableValue(serializer, t);
        }
    }

    @Override // xIXoO0Xx.II0XooXoX
    public <T> void encodeSerializableValue(@OXOo.OOXIXo kotlinx.serialization.Oxx0xo<? super T> oxx0xo, T t) {
        II0XooXoX.oIX0oI.oxoX(this, oxx0xo, t);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeShort(short s) {
        ooOOo0oXI(oI0IIXIo(), s);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeShortElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        ooOOo0oXI(Oxx0xo(descriptor, i), s);
    }

    @Override // xIXoO0Xx.II0XooXoX
    public final void encodeString(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        x0XOIxOo(oI0IIXIo(), value);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void encodeStringElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        x0XOIxOo(Oxx0xo(descriptor, i), value);
    }

    @Override // xIXoO0Xx.X0o0xo
    public final void endStructure(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        if (!this.f30741oIX0oI.isEmpty()) {
            oI0IIXIo();
        }
        x0xO0oo(descriptor);
    }

    @Override // xIXoO0Xx.II0XooXoX, xIXoO0Xx.X0o0xo
    @OXOo.OOXIXo
    public kotlinx.serialization.modules.X0o0xo getSerializersModule() {
        return SerializersModuleBuildersKt.oIX0oI();
    }

    public final Tag oI0IIXIo() {
        if (!this.f30741oIX0oI.isEmpty()) {
            ArrayList<Tag> arrayList = this.f30741oIX0oI;
            return arrayList.remove(CollectionsKt__CollectionsKt.oo0xXOI0I(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    public void oO(Tag tag, @OXOo.OOXIXo Object value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        throw new SerializationException("Non-serializable " + kotlin.jvm.internal.IO.oxoX(value.getClass()) + " is not supported by " + kotlin.jvm.internal.IO.oxoX(getClass()) + " encoder");
    }

    public void oOoXoXO(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    public void ooOOo0oXI(Tag tag, short s) {
        oO(tag, Short.valueOf(s));
    }

    public void oxoX(Tag tag, char c) {
        oO(tag, Character.valueOf(c));
    }

    @Override // xIXoO0Xx.X0o0xo
    @kotlinx.serialization.oxoX
    public boolean shouldEncodeElementDefault(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i) {
        return X0o0xo.oIX0oI.oIX0oI(this, xo2, i);
    }

    public void x0XOIxOo(Tag tag, @OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        oO(tag, value);
    }

    public void x0xO0oo(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
    }

    public void xoIox(Tag tag, long j) {
        oO(tag, Long.valueOf(j));
    }

    public void xxIXOIIO(Tag tag, int i) {
        oO(tag, Integer.valueOf(i));
    }
}
