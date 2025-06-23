package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import xIXoO0Xx.XO;
import xIXoO0Xx.oxoX;

@kotlin.jvm.internal.XX({"SMAP\nTagged.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
@kotlinx.serialization.XO
/* loaded from: classes6.dex */
public abstract class TaggedDecoder<Tag> implements xIXoO0Xx.XO, xIXoO0Xx.oxoX {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f30685X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ArrayList<Tag> f30686oxoX = new ArrayList<>();

    public boolean I0Io(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) x0xO0oo2).booleanValue();
    }

    public float II0XooXoX(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) x0xO0oo2).floatValue();
    }

    public <T> T II0xO0(@OXOo.OOXIXo kotlinx.serialization.I0Io<? extends T> deserializer, @OXOo.oOoXoXO T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }

    public final <E> E IIXOooo(Tag tag, Oox.oIX0oI<? extends E> oix0oi) {
        OxxIIOOXO(tag);
        E invoke = oix0oi.invoke();
        if (!this.f30685X0o0xo) {
            oI0IIXIo();
        }
        this.f30685X0o0xo = false;
        return invoke;
    }

    @OXOo.oOoXoXO
    public final Tag IXxxXO() {
        return (Tag) CollectionsKt___CollectionsKt.xX0ox(this.f30686oxoX);
    }

    public long OOXIXo(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) x0xO0oo2).longValue();
    }

    public final Tag Oo() {
        return (Tag) CollectionsKt___CollectionsKt.O0O0Io00X(this.f30686oxoX);
    }

    public int Oxx0IOOO(Tag tag, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) x0xO0oo2).intValue();
    }

    public abstract Tag Oxx0xo(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2, int i);

    public final void OxxIIOOXO(Tag tag) {
        this.f30686oxoX.add(tag);
    }

    public char X0o0xo(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) x0xO0oo2).charValue();
    }

    public double XO(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) x0xO0oo2).doubleValue();
    }

    @Override // xIXoO0Xx.XO
    @OXOo.OOXIXo
    public xIXoO0Xx.oxoX beginStructure(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return this;
    }

    @Override // xIXoO0Xx.XO
    public final boolean decodeBoolean() {
        return I0Io(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final boolean decodeBooleanElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return I0Io(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    public final byte decodeByte() {
        return oxoX(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final byte decodeByteElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return oxoX(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    public final char decodeChar() {
        return X0o0xo(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final char decodeCharElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return X0o0xo(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.oxoX
    public int decodeCollectionSize(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO xo2) {
        return oxoX.II0xO0.oIX0oI(this, xo2);
    }

    @Override // xIXoO0Xx.XO
    public final double decodeDouble() {
        return XO(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final double decodeDoubleElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return XO(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    public final int decodeEnum(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO enumDescriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumDescriptor, "enumDescriptor");
        return Oxx0IOOO(oI0IIXIo(), enumDescriptor);
    }

    @Override // xIXoO0Xx.XO
    public final float decodeFloat() {
        return II0XooXoX(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final float decodeFloatElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return II0XooXoX(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    @OXOo.OOXIXo
    public xIXoO0Xx.XO decodeInline(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return xxIXOIIO(oI0IIXIo(), descriptor);
    }

    @Override // xIXoO0Xx.oxoX
    @OXOo.OOXIXo
    public final xIXoO0Xx.XO decodeInlineElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return xxIXOIIO(Oxx0xo(descriptor, i), descriptor.X0o0xo(i));
    }

    @Override // xIXoO0Xx.XO
    public final int decodeInt() {
        return xoIox(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final int decodeIntElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return xoIox(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    public final long decodeLong() {
        return OOXIXo(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final long decodeLongElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return OOXIXo(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    public boolean decodeNotNullMark() {
        Tag IXxxXO2 = IXxxXO();
        if (IXxxXO2 == null) {
            return false;
        }
        return oOoXoXO(IXxxXO2);
    }

    @Override // xIXoO0Xx.XO
    @OXOo.oOoXoXO
    public final Void decodeNull() {
        return null;
    }

    @Override // xIXoO0Xx.oxoX
    @OXOo.oOoXoXO
    public final <T> T decodeNullableSerializableElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OXOo.OOXIXo final kotlinx.serialization.I0Io<? extends T> deserializer, @OXOo.oOoXoXO final T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) IIXOooo(Oxx0xo(descriptor, i), new Oox.oIX0oI<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1
            final /* synthetic */ TaggedDecoder<Tag> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // Oox.oIX0oI
            @OXOo.oOoXoXO
            public final T invoke() {
                TaggedDecoder<Tag> taggedDecoder = this.this$0;
                kotlinx.serialization.I0Io<T> i0Io = deserializer;
                T t2 = t;
                if (!i0Io.oIX0oI().I0Io() && !taggedDecoder.decodeNotNullMark()) {
                    return (T) taggedDecoder.decodeNull();
                }
                return (T) taggedDecoder.II0xO0(i0Io, t2);
            }
        });
    }

    @Override // xIXoO0Xx.XO
    @kotlinx.serialization.oxoX
    @OXOo.oOoXoXO
    public <T> T decodeNullableSerializableValue(@OXOo.OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io) {
        return (T) XO.oIX0oI.oIX0oI(this, i0Io);
    }

    @Override // xIXoO0Xx.oxoX
    @kotlinx.serialization.oxoX
    public boolean decodeSequentially() {
        return oxoX.II0xO0.I0Io(this);
    }

    @Override // xIXoO0Xx.oxoX
    public final <T> T decodeSerializableElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i, @OXOo.OOXIXo final kotlinx.serialization.I0Io<? extends T> deserializer, @OXOo.oOoXoXO final T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        kotlin.jvm.internal.IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) IIXOooo(Oxx0xo(descriptor, i), new Oox.oIX0oI<T>(this) { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            final /* synthetic */ TaggedDecoder<Tag> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // Oox.oIX0oI
            public final T invoke() {
                return (T) this.this$0.II0xO0(deserializer, t);
            }
        });
    }

    @Override // xIXoO0Xx.XO
    public <T> T decodeSerializableValue(@OXOo.OOXIXo kotlinx.serialization.I0Io<? extends T> i0Io) {
        return (T) XO.oIX0oI.II0xO0(this, i0Io);
    }

    @Override // xIXoO0Xx.XO
    public final short decodeShort() {
        return x0XOIxOo(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    public final short decodeShortElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return x0XOIxOo(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.XO
    @OXOo.OOXIXo
    public final String decodeString() {
        return oO(oI0IIXIo());
    }

    @Override // xIXoO0Xx.oxoX
    @OXOo.OOXIXo
    public final String decodeStringElement(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        return oO(Oxx0xo(descriptor, i));
    }

    @Override // xIXoO0Xx.oxoX
    public void endStructure(@OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
    }

    @Override // xIXoO0Xx.XO, xIXoO0Xx.oxoX
    @OXOo.OOXIXo
    public kotlinx.serialization.modules.X0o0xo getSerializersModule() {
        return SerializersModuleBuildersKt.oIX0oI();
    }

    public final Tag oI0IIXIo() {
        ArrayList<Tag> arrayList = this.f30686oxoX;
        Tag remove = arrayList.remove(CollectionsKt__CollectionsKt.oo0xXOI0I(arrayList));
        this.f30685X0o0xo = true;
        return remove;
    }

    public final void oIX0oI(@OXOo.OOXIXo TaggedDecoder<Tag> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        other.f30686oxoX.addAll(this.f30686oxoX);
    }

    @OXOo.OOXIXo
    public String oO(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.String");
        return (String) x0xO0oo2;
    }

    public boolean oOoXoXO(Tag tag) {
        return true;
    }

    @OXOo.oOoXoXO
    public Void ooOOo0oXI(Tag tag) {
        return null;
    }

    public byte oxoX(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) x0xO0oo2).byteValue();
    }

    public short x0XOIxOo(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) x0xO0oo2).shortValue();
    }

    @OXOo.OOXIXo
    public Object x0xO0oo(Tag tag) {
        throw new SerializationException(kotlin.jvm.internal.IO.oxoX(getClass()) + " can't retrieve untyped values");
    }

    public int xoIox(Tag tag) {
        Object x0xO0oo2 = x0xO0oo(tag);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xO0oo2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) x0xO0oo2).intValue();
    }

    @OXOo.OOXIXo
    public xIXoO0Xx.XO xxIXOIIO(Tag tag, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO inlineDescriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(inlineDescriptor, "inlineDescriptor");
        OxxIIOOXO(tag);
        return this;
    }
}
