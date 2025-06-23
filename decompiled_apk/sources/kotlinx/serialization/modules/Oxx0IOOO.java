package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.modules.SerializersModuleCollector;
import kotlinx.serialization.modules.oIX0oI;

@XX({"SMAP\nSerializersModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersModule.kt\nkotlinx/serialization/modules/SerializersModuleKt\n+ 2 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n1#1,234:1\n31#2,3:235\n31#2,3:238\n*S KotlinDebug\n*F\n+ 1 SerializersModule.kt\nkotlinx/serialization/modules/SerializersModuleKt\n*L\n87#1:235,3\n99#1:238,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final X0o0xo f30783oIX0oI = new oxoX(o0.O0xOxO(), o0.O0xOxO(), o0.O0xOxO(), o0.O0xOxO(), o0.O0xOxO());

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements SerializersModuleCollector {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ XO f30784oIX0oI;

        public oIX0oI(XO xo2) {
            this.f30784oIX0oI = xo2;
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        public <Base, Sub extends Base> void I0Io(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo kotlin.reflect.oxoX<Sub> actualClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<Sub> actualSerializer) {
            IIX0o.x0xO0oo(baseClass, "baseClass");
            IIX0o.x0xO0oo(actualClass, "actualClass");
            IIX0o.x0xO0oo(actualSerializer, "actualSerializer");
            this.f30784oIX0oI.OOXIXo(baseClass, actualClass, actualSerializer, true);
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        public <Base> void II0xO0(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultDeserializerProvider) {
            IIX0o.x0xO0oo(baseClass, "baseClass");
            IIX0o.x0xO0oo(defaultDeserializerProvider, "defaultDeserializerProvider");
            this.f30784oIX0oI.xxIXOIIO(baseClass, defaultDeserializerProvider, true);
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        public <T> void X0o0xo(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo oOoXoXO<? super List<? extends kotlinx.serialization.Oxx0IOOO<?>>, ? extends kotlinx.serialization.Oxx0IOOO<?>> provider) {
            IIX0o.x0xO0oo(kClass, "kClass");
            IIX0o.x0xO0oo(provider, "provider");
            this.f30784oIX0oI.ooOOo0oXI(kClass, new oIX0oI.II0xO0(provider), true);
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @kotlin.XX(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
        public <Base> void XO(@OOXIXo kotlin.reflect.oxoX<Base> oxox, @OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> oooxoxo) {
            SerializersModuleCollector.DefaultImpls.II0xO0(this, oxox, oooxoxo);
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        public <Base> void oIX0oI(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo oOoXoXO<? super Base, ? extends Oxx0xo<? super Base>> defaultSerializerProvider) {
            IIX0o.x0xO0oo(baseClass, "baseClass");
            IIX0o.x0xO0oo(defaultSerializerProvider, "defaultSerializerProvider");
            this.f30784oIX0oI.xoIox(baseClass, defaultSerializerProvider, true);
        }

        @Override // kotlinx.serialization.modules.SerializersModuleCollector
        public <T> void oxoX(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<T> serializer) {
            IIX0o.x0xO0oo(kClass, "kClass");
            IIX0o.x0xO0oo(serializer, "serializer");
            this.f30784oIX0oI.ooOOo0oXI(kClass, new oIX0oI.C1117oIX0oI(serializer), true);
        }
    }

    @OOXIXo
    public static final X0o0xo I0Io(@OOXIXo X0o0xo x0o0xo, @OOXIXo X0o0xo other) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(other, "other");
        XO xo2 = new XO();
        xo2.II0XooXoX(x0o0xo);
        other.oIX0oI(new oIX0oI(xo2));
        return xo2.Oxx0IOOO();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'EmptySerializersModule()'", replaceWith = @kotlin.XX(expression = "EmptySerializersModule()", imports = {}))
    public static /* synthetic */ void II0xO0() {
    }

    @OOXIXo
    public static final X0o0xo oIX0oI() {
        return f30783oIX0oI;
    }

    @OOXIXo
    public static final X0o0xo oxoX(@OOXIXo X0o0xo x0o0xo, @OOXIXo X0o0xo other) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(other, "other");
        XO xo2 = new XO();
        xo2.II0XooXoX(x0o0xo);
        xo2.II0XooXoX(other);
        return xo2.Oxx0IOOO();
    }
}
