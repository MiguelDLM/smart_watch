package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.descriptors.II0XooXoX;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.IIxOXoOo0;
import kotlinx.serialization.internal.O00XxXI;

@oxoX
/* loaded from: classes6.dex */
public final class ContextualSerializer<T> implements Oxx0IOOO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<Oxx0IOOO<?>> f30547I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oxx0IOOO<T> f30548II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.oxoX<T> f30549oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlinx.serialization.descriptors.XO f30550oxoX;

    public ContextualSerializer(@OXOo.OOXIXo kotlin.reflect.oxoX<T> serializableClass, @OXOo.oOoXoXO Oxx0IOOO<T> oxx0IOOO, @OXOo.OOXIXo Oxx0IOOO<?>[] typeArgumentsSerializers) {
        IIX0o.x0xO0oo(serializableClass, "serializableClass");
        IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
        this.f30549oIX0oI = serializableClass;
        this.f30548II0xO0 = oxx0IOOO;
        this.f30547I0Io = kotlin.collections.ooOOo0oXI.oI0IIXIo(typeArgumentsSerializers);
        this.f30550oxoX = kotlinx.serialization.descriptors.II0xO0.X0o0xo(SerialDescriptorsKt.X0o0xo("kotlinx.serialization.ContextualSerializer", II0XooXoX.oIX0oI.f30568oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>(this) { // from class: kotlinx.serialization.ContextualSerializer$descriptor$1
            final /* synthetic */ ContextualSerializer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                invoke2(oix0oi);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor) {
                Oxx0IOOO oxx0IOOO2;
                kotlinx.serialization.descriptors.XO oIX0oI2;
                IIX0o.x0xO0oo(buildSerialDescriptor, "$this$buildSerialDescriptor");
                oxx0IOOO2 = this.this$0.f30548II0xO0;
                List<Annotation> annotations = (oxx0IOOO2 == null || (oIX0oI2 = oxx0IOOO2.oIX0oI()) == null) ? null : oIX0oI2.getAnnotations();
                if (annotations == null) {
                    annotations = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                buildSerialDescriptor.oOoXoXO(annotations);
            }
        }), serializableClass);
    }

    @Override // kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        encoder.encodeSerializableValue(Oxx0IOOO(encoder.getSerializersModule()), value);
    }

    public final Oxx0IOOO<T> Oxx0IOOO(kotlinx.serialization.modules.X0o0xo x0o0xo) {
        Oxx0IOOO<T> I0Io2 = x0o0xo.I0Io(this.f30549oIX0oI, this.f30547I0Io);
        if (I0Io2 == null && (I0Io2 = this.f30548II0xO0) == null) {
            O00XxXI.xoIox(this.f30549oIX0oI);
            throw new KotlinNothingValueException();
        }
        return I0Io2;
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30550oxoX;
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return (T) decoder.decodeSerializableValue(Oxx0IOOO(decoder.getSerializersModule()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContextualSerializer(@OXOo.OOXIXo kotlin.reflect.oxoX<T> serializableClass) {
        this(serializableClass, null, IIxOXoOo0.f30629oIX0oI);
        IIX0o.x0xO0oo(serializableClass, "serializableClass");
    }
}
