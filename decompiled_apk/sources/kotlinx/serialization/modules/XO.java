package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.collections.I0oOoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.modules.SerializersModuleCollector;
import kotlinx.serialization.modules.oIX0oI;

@XX({"SMAP\nSerializersModuleBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuilder\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,270:1\n372#2,7:271\n372#2,7:278\n1#3:285\n*S KotlinDebug\n*F\n+ 1 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuilder\n*L\n195#1:271,7\n197#1:278,7\n*E\n"})
/* loaded from: classes6.dex */
public final class XO implements SerializersModuleCollector {

    /* renamed from: oIX0oI */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oIX0oI> f30788oIX0oI = new HashMap();

    /* renamed from: II0xO0 */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>>> f30786II0xO0 = new HashMap();

    /* renamed from: I0Io */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oOoXoXO<?, Oxx0xo<?>>> f30785I0Io = new HashMap();

    /* renamed from: oxoX */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, Map<String, kotlinx.serialization.Oxx0IOOO<?>>> f30789oxoX = new HashMap();

    /* renamed from: X0o0xo */
    @OOXIXo
    public final Map<kotlin.reflect.oxoX<?>, oOoXoXO<String, kotlinx.serialization.I0Io<?>>> f30787X0o0xo = new HashMap();

    @o0
    public XO() {
    }

    public static /* synthetic */ void oOoXoXO(XO xo2, kotlin.reflect.oxoX oxox, kotlin.reflect.oxoX oxox2, kotlinx.serialization.Oxx0IOOO oxx0IOOO, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        xo2.OOXIXo(oxox, oxox2, oxx0IOOO, z);
    }

    public static /* synthetic */ void x0XOIxOo(XO xo2, kotlin.reflect.oxoX oxox, oIX0oI oix0oi, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        xo2.ooOOo0oXI(oxox, oix0oi, z);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void I0Io(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo kotlin.reflect.oxoX<Sub> actualClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<Sub> actualSerializer) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(actualClass, "actualClass");
        IIX0o.x0xO0oo(actualSerializer, "actualSerializer");
        oOoXoXO(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    public final void II0XooXoX(@OOXIXo X0o0xo module) {
        IIX0o.x0xO0oo(module, "module");
        module.oIX0oI(this);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void II0xO0(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultDeserializerProvider) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(defaultDeserializerProvider, "defaultDeserializerProvider");
        xxIXOIIO(baseClass, defaultDeserializerProvider, false);
    }

    @xxIXOIIO(name = "registerPolymorphicSerializer")
    public final <Base, Sub extends Base> void OOXIXo(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo kotlin.reflect.oxoX<Sub> concreteClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<Sub> concreteSerializer, boolean z) {
        Object obj;
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(concreteClass, "concreteClass");
        IIX0o.x0xO0oo(concreteSerializer, "concreteSerializer");
        String xxIXOIIO2 = concreteSerializer.oIX0oI().xxIXOIIO();
        Map<kotlin.reflect.oxoX<?>, Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>>> map = this.f30786II0xO0;
        Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(baseClass, map2);
        }
        Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> map3 = map2;
        kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO = map3.get(concreteClass);
        Map<kotlin.reflect.oxoX<?>, Map<String, kotlinx.serialization.Oxx0IOOO<?>>> map4 = this.f30789oxoX;
        Map<String, kotlinx.serialization.Oxx0IOOO<?>> map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(baseClass, map5);
        }
        Map<String, kotlinx.serialization.Oxx0IOOO<?>> map6 = map5;
        if (z) {
            if (oxx0IOOO != null) {
                map6.remove(oxx0IOOO.oIX0oI().xxIXOIIO());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(xxIXOIIO2, concreteSerializer);
            return;
        }
        if (oxx0IOOO != null) {
            if (IIX0o.Oxx0IOOO(oxx0IOOO, concreteSerializer)) {
                map6.remove(oxx0IOOO.oIX0oI().xxIXOIIO());
            } else {
                throw new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            }
        }
        kotlinx.serialization.Oxx0IOOO<?> oxx0IOOO2 = map6.get(xxIXOIIO2);
        if (oxx0IOOO2 != null) {
            Map<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<?>> map7 = this.f30786II0xO0.get(baseClass);
            IIX0o.ooOOo0oXI(map7);
            Iterator it = I0oOoX.XIXIxO(map7).iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((Map.Entry) obj).getValue() == oxx0IOOO2) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + xxIXOIIO2 + "': '" + concreteClass + "' and '" + ((Map.Entry) obj) + '\'');
        }
        map3.put(concreteClass, concreteSerializer);
        map6.put(xxIXOIIO2, concreteSerializer);
    }

    @OOXIXo
    @o0
    public final X0o0xo Oxx0IOOO() {
        return new oxoX(this.f30788oIX0oI, this.f30786II0xO0, this.f30785I0Io, this.f30789oxoX, this.f30787X0o0xo);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void X0o0xo(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo oOoXoXO<? super List<? extends kotlinx.serialization.Oxx0IOOO<?>>, ? extends kotlinx.serialization.Oxx0IOOO<?>> provider) {
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(provider, "provider");
        x0XOIxOo(this, kClass, new oIX0oI.II0xO0(provider), false, 4, null);
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
        xoIox(baseClass, defaultSerializerProvider, false);
    }

    @xxIXOIIO(name = "registerSerializer")
    public final <T> void ooOOo0oXI(@OOXIXo kotlin.reflect.oxoX<T> forClass, @OOXIXo oIX0oI provider, boolean z) {
        oIX0oI oix0oi;
        IIX0o.x0xO0oo(forClass, "forClass");
        IIX0o.x0xO0oo(provider, "provider");
        if (!z && (oix0oi = this.f30788oIX0oI.get(forClass)) != null && !IIX0o.Oxx0IOOO(oix0oi, provider)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        this.f30788oIX0oI.put(forClass, provider);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void oxoX(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(serializer, "serializer");
        x0XOIxOo(this, kClass, new oIX0oI.C1117oIX0oI(serializer), false, 4, null);
    }

    @xxIXOIIO(name = "registerDefaultPolymorphicSerializer")
    public final <Base> void xoIox(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo oOoXoXO<? super Base, ? extends Oxx0xo<? super Base>> defaultSerializerProvider, boolean z) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(defaultSerializerProvider, "defaultSerializerProvider");
        oOoXoXO<?, Oxx0xo<?>> oooxoxo = this.f30785I0Io.get(baseClass);
        if (oooxoxo != null && !IIX0o.Oxx0IOOO(oooxoxo, defaultSerializerProvider) && !z) {
            throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + oooxoxo);
        }
        this.f30785I0Io.put(baseClass, defaultSerializerProvider);
    }

    @xxIXOIIO(name = "registerDefaultPolymorphicDeserializer")
    public final <Base> void xxIXOIIO(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OOXIXo oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultDeserializerProvider, boolean z) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(defaultDeserializerProvider, "defaultDeserializerProvider");
        oOoXoXO<String, kotlinx.serialization.I0Io<?>> oooxoxo = this.f30787X0o0xo.get(baseClass);
        if (oooxoxo != null && !IIX0o.Oxx0IOOO(oooxoxo, defaultDeserializerProvider) && !z) {
            throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + oooxoxo);
        }
        this.f30787X0o0xo.put(baseClass, defaultDeserializerProvider);
    }
}
