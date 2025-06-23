package kotlinx.serialization.modules;

import Oox.oOoXoXO;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0xo;

@kotlinx.serialization.oxoX
/* loaded from: classes6.dex */
public interface SerializersModuleCollector {

    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        @OOXIXo(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @XX(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
        public static <Base> void II0xO0(@OXOo.OOXIXo SerializersModuleCollector serializersModuleCollector, @OXOo.OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OXOo.OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultDeserializerProvider) {
            IIX0o.x0xO0oo(baseClass, "baseClass");
            IIX0o.x0xO0oo(defaultDeserializerProvider, "defaultDeserializerProvider");
            serializersModuleCollector.II0xO0(baseClass, defaultDeserializerProvider);
        }

        public static <T> void oIX0oI(@OXOo.OOXIXo SerializersModuleCollector serializersModuleCollector, @OXOo.OOXIXo kotlin.reflect.oxoX<T> kClass, @OXOo.OOXIXo final kotlinx.serialization.Oxx0IOOO<T> serializer) {
            IIX0o.x0xO0oo(kClass, "kClass");
            IIX0o.x0xO0oo(serializer, "serializer");
            serializersModuleCollector.X0o0xo(kClass, new oOoXoXO<List<? extends kotlinx.serialization.Oxx0IOOO<?>>, kotlinx.serialization.Oxx0IOOO<?>>() { // from class: kotlinx.serialization.modules.SerializersModuleCollector$contextual$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final kotlinx.serialization.Oxx0IOOO<?> invoke(@OXOo.OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> it) {
                    IIX0o.x0xO0oo(it, "it");
                    return serializer;
                }
            });
        }
    }

    <Base, Sub extends Base> void I0Io(@OXOo.OOXIXo kotlin.reflect.oxoX<Base> oxox, @OXOo.OOXIXo kotlin.reflect.oxoX<Sub> oxox2, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<Sub> oxx0IOOO);

    <Base> void II0xO0(@OXOo.OOXIXo kotlin.reflect.oxoX<Base> oxox, @OXOo.OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> oooxoxo);

    <T> void X0o0xo(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox, @OXOo.OOXIXo oOoXoXO<? super List<? extends kotlinx.serialization.Oxx0IOOO<?>>, ? extends kotlinx.serialization.Oxx0IOOO<?>> oooxoxo);

    @OOXIXo(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @XX(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
    <Base> void XO(@OXOo.OOXIXo kotlin.reflect.oxoX<Base> oxox, @OXOo.OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> oooxoxo);

    <Base> void oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Base> oxox, @OXOo.OOXIXo oOoXoXO<? super Base, ? extends Oxx0xo<? super Base>> oooxoxo);

    <T> void oxoX(@OXOo.OOXIXo kotlin.reflect.oxoX<T> oxox, @OXOo.OOXIXo kotlinx.serialization.Oxx0IOOO<T> oxx0IOOO);
}
