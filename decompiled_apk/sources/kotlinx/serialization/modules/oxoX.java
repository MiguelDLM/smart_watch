package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.modules.oIX0oI;

@XX({"SMAP\nSerializersModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersModule.kt\nkotlinx/serialization/modules/SerialModuleImpl\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,234:1\n215#2,2:235\n215#2:237\n215#2:238\n216#2:240\n216#2:241\n215#2,2:242\n215#2,2:244\n79#3:239\n*S KotlinDebug\n*F\n+ 1 SerializersModule.kt\nkotlinx/serialization/modules/SerialModuleImpl\n*L\n175#1:235,2\n185#1:237\n186#1:238\n186#1:240\n185#1:241\n195#1:242,2\n199#1:244,2\n190#1:239\n*E\n"})
/* loaded from: classes6.dex */
public final class oxoX extends X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oOoXoXO<?, Oxx0xo<?>>> f30792I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    @XO0OX.XO
    public final Map<kotlin.reflect.oxoX<?>, Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>>> f30793II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oOoXoXO<String, kotlinx.serialization.I0Io<?>>> f30794X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oIX0oI> f30795oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, Map<String, kotlinx.serialization.Oxx0IOOO<?>>> f30796oxoX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public oxoX(@OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends oIX0oI> class2ContextualFactory, @OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends Map<kotlin.reflect.oxoX<?>, ? extends kotlinx.serialization.Oxx0IOOO<?>>> polyBase2Serializers, @OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends oOoXoXO<?, ? extends Oxx0xo<?>>> polyBase2DefaultSerializerProvider, @OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends Map<String, ? extends kotlinx.serialization.Oxx0IOOO<?>>> polyBase2NamedSerializers, @OOXIXo Map<kotlin.reflect.oxoX<?>, ? extends oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<?>>> polyBase2DefaultDeserializerProvider) {
        super(null);
        IIX0o.x0xO0oo(class2ContextualFactory, "class2ContextualFactory");
        IIX0o.x0xO0oo(polyBase2Serializers, "polyBase2Serializers");
        IIX0o.x0xO0oo(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        IIX0o.x0xO0oo(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        IIX0o.x0xO0oo(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f30795oIX0oI = class2ContextualFactory;
        this.f30793II0xO0 = polyBase2Serializers;
        this.f30792I0Io = polyBase2DefaultSerializerProvider;
        this.f30796oxoX = polyBase2NamedSerializers;
        this.f30794X0o0xo = polyBase2DefaultDeserializerProvider;
    }

    @Override // kotlinx.serialization.modules.X0o0xo
    @OXOo.oOoXoXO
    public <T> kotlinx.serialization.Oxx0IOOO<T> I0Io(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> typeArgumentsSerializers) {
        kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO;
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(typeArgumentsSerializers, "typeArgumentsSerializers");
        oIX0oI oix0oi = this.f30795oIX0oI.get(kClass);
        if (oix0oi != null) {
            oxx0IOOO = oix0oi.oIX0oI(typeArgumentsSerializers);
        } else {
            oxx0IOOO = null;
        }
        if (!(oxx0IOOO instanceof kotlinx.serialization.Oxx0IOOO)) {
            return null;
        }
        return (kotlinx.serialization.Oxx0IOOO<T>) oxx0IOOO;
    }

    @Override // kotlinx.serialization.modules.X0o0xo
    @OXOo.oOoXoXO
    public <T> kotlinx.serialization.I0Io<T> X0o0xo(@OOXIXo kotlin.reflect.oxoX<? super T> baseClass, @OXOo.oOoXoXO String str) {
        kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO;
        oOoXoXO<String, kotlinx.serialization.I0Io<?>> oooxoxo;
        IIX0o.x0xO0oo(baseClass, "baseClass");
        Map<String, kotlinx.serialization.Oxx0IOOO<?>> map = this.f30796oxoX.get(baseClass);
        if (map != null) {
            oxx0IOOO = map.get(str);
        } else {
            oxx0IOOO = null;
        }
        if (!(oxx0IOOO instanceof kotlinx.serialization.Oxx0IOOO)) {
            oxx0IOOO = null;
        }
        if (oxx0IOOO != null) {
            return oxx0IOOO;
        }
        oOoXoXO<String, kotlinx.serialization.I0Io<?>> oooxoxo2 = this.f30794X0o0xo.get(baseClass);
        if (XoX.XI0IXoo(oooxoxo2, 1)) {
            oooxoxo = oooxoxo2;
        } else {
            oooxoxo = null;
        }
        if (oooxoxo == null) {
            return null;
        }
        return (kotlinx.serialization.I0Io) oooxoxo.invoke(str);
    }

    @Override // kotlinx.serialization.modules.X0o0xo
    @OXOo.oOoXoXO
    public <T> Oxx0xo<T> XO(@OOXIXo kotlin.reflect.oxoX<? super T> baseClass, @OOXIXo T value) {
        kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO;
        oOoXoXO<?, Oxx0xo<?>> oooxoxo;
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(value, "value");
        if (!baseClass.Oxx0xo(value)) {
            return null;
        }
        Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> map = this.f30793II0xO0.get(baseClass);
        if (map != null) {
            oxx0IOOO = map.get(IO.oxoX(value.getClass()));
        } else {
            oxx0IOOO = null;
        }
        if (!(oxx0IOOO instanceof Oxx0xo)) {
            oxx0IOOO = null;
        }
        if (oxx0IOOO != null) {
            return oxx0IOOO;
        }
        oOoXoXO<?, Oxx0xo<?>> oooxoxo2 = this.f30792I0Io.get(baseClass);
        if (XoX.XI0IXoo(oooxoxo2, 1)) {
            oooxoxo = oooxoxo2;
        } else {
            oooxoxo = null;
        }
        if (oooxoxo == null) {
            return null;
        }
        return (Oxx0xo) oooxoxo.invoke(value);
    }

    @Override // kotlinx.serialization.modules.X0o0xo
    public void oIX0oI(@OOXIXo SerializersModuleCollector collector) {
        IIX0o.x0xO0oo(collector, "collector");
        for (Map.Entry<kotlin.reflect.oxoX<?>, oIX0oI> entry : this.f30795oIX0oI.entrySet()) {
            kotlin.reflect.oxoX<?> key = entry.getKey();
            oIX0oI value = entry.getValue();
            if (value instanceof oIX0oI.C1117oIX0oI) {
                IIX0o.x0XOIxOo(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                kotlinx.serialization.Oxx0IOOO<?> II0xO02 = ((oIX0oI.C1117oIX0oI) value).II0xO0();
                IIX0o.x0XOIxOo(II0xO02, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.oxoX(key, II0xO02);
            } else if (value instanceof oIX0oI.II0xO0) {
                collector.X0o0xo(key, ((oIX0oI.II0xO0) value).II0xO0());
            }
        }
        for (Map.Entry<kotlin.reflect.oxoX<?>, Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>>> entry2 : this.f30793II0xO0.entrySet()) {
            kotlin.reflect.oxoX<?> key2 = entry2.getKey();
            for (Map.Entry<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> entry3 : entry2.getValue().entrySet()) {
                kotlin.reflect.oxoX<?> key3 = entry3.getKey();
                kotlinx.serialization.Oxx0IOOO<?> value2 = entry3.getValue();
                IIX0o.x0XOIxOo(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                IIX0o.x0XOIxOo(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                IIX0o.x0XOIxOo(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.I0Io(key2, key3, value2);
            }
        }
        for (Map.Entry<kotlin.reflect.oxoX<?>, oOoXoXO<?, Oxx0xo<?>>> entry4 : this.f30792I0Io.entrySet()) {
            kotlin.reflect.oxoX<?> key4 = entry4.getKey();
            oOoXoXO<?, Oxx0xo<?>> value3 = entry4.getValue();
            IIX0o.x0XOIxOo(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            IIX0o.x0XOIxOo(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.oIX0oI(key4, (oOoXoXO) XoX.Oo(value3, 1));
        }
        for (Map.Entry<kotlin.reflect.oxoX<?>, oOoXoXO<String, kotlinx.serialization.I0Io<?>>> entry5 : this.f30794X0o0xo.entrySet()) {
            kotlin.reflect.oxoX<?> key5 = entry5.getKey();
            oOoXoXO<String, kotlinx.serialization.I0Io<?>> value4 = entry5.getValue();
            IIX0o.x0XOIxOo(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            IIX0o.x0XOIxOo(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.II0xO0(key5, (oOoXoXO) XoX.Oo(value4, 1));
        }
    }
}
