package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlinx.serialization.Oxx0xo;

@XX({"SMAP\nPolymorphicModuleBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolymorphicModuleBuilder.kt\nkotlinx/serialization/modules/PolymorphicModuleBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,119:1\n1855#2:120\n1856#2:122\n79#3:121\n*S KotlinDebug\n*F\n+ 1 PolymorphicModuleBuilder.kt\nkotlinx/serialization/modules/PolymorphicModuleBuilder\n*L\n88#1:120\n88#1:122\n92#1:121\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0<Base> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final List<Pair<kotlin.reflect.oxoX<? extends Base>, kotlinx.serialization.Oxx0IOOO<? extends Base>>> f30778I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public final kotlinx.serialization.Oxx0IOOO<Base> f30779II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> f30780X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final kotlin.reflect.oxoX<Base> f30781oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Base, ? extends Oxx0xo<? super Base>> f30782oxoX;

    @o0
    public II0xO0(@OOXIXo kotlin.reflect.oxoX<Base> baseClass, @oOoXoXO kotlinx.serialization.Oxx0IOOO<Base> oxx0IOOO) {
        IIX0o.x0xO0oo(baseClass, "baseClass");
        this.f30781oIX0oI = baseClass;
        this.f30779II0xO0 = oxx0IOOO;
        this.f30778I0Io = new ArrayList();
    }

    public final void I0Io(@OOXIXo Oox.oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultDeserializerProvider) {
        IIX0o.x0xO0oo(defaultDeserializerProvider, "defaultDeserializerProvider");
        if (this.f30780X0o0xo == null) {
            this.f30780X0o0xo = defaultDeserializerProvider;
            return;
        }
        throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.f30781oIX0oI + ": " + this.f30780X0o0xo).toString());
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: defaultDeserializer", replaceWith = @kotlin.XX(expression = "defaultDeserializer(defaultSerializerProvider)", imports = {}))
    public final void II0xO0(@OOXIXo Oox.oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> defaultSerializerProvider) {
        IIX0o.x0xO0oo(defaultSerializerProvider, "defaultSerializerProvider");
        I0Io(defaultSerializerProvider);
    }

    @o0
    public final void oIX0oI(@OOXIXo XO builder) {
        IIX0o.x0xO0oo(builder, "builder");
        kotlinx.serialization.Oxx0IOOO<Base> oxx0IOOO = this.f30779II0xO0;
        if (oxx0IOOO != null) {
            kotlin.reflect.oxoX<Base> oxox = this.f30781oIX0oI;
            XO.oOoXoXO(builder, oxox, oxox, oxx0IOOO, false, 8, null);
        }
        Iterator<T> it = this.f30778I0Io.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            kotlin.reflect.oxoX oxox2 = (kotlin.reflect.oxoX) pair.component1();
            kotlinx.serialization.Oxx0IOOO oxx0IOOO2 = (kotlinx.serialization.Oxx0IOOO) pair.component2();
            kotlin.reflect.oxoX<Base> oxox3 = this.f30781oIX0oI;
            IIX0o.x0XOIxOo(oxox2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            IIX0o.x0XOIxOo(oxx0IOOO2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            XO.oOoXoXO(builder, oxox3, oxox2, oxx0IOOO2, false, 8, null);
        }
        Oox.oOoXoXO<? super Base, ? extends Oxx0xo<? super Base>> oooxoxo = this.f30782oxoX;
        if (oooxoxo != null) {
            builder.xoIox(this.f30781oIX0oI, oooxoxo, false);
        }
        Oox.oOoXoXO<? super String, ? extends kotlinx.serialization.I0Io<? extends Base>> oooxoxo2 = this.f30780X0o0xo;
        if (oooxoxo2 != null) {
            builder.xxIXOIIO(this.f30781oIX0oI, oooxoxo2, false);
        }
    }

    public final <T extends Base> void oxoX(@OOXIXo kotlin.reflect.oxoX<T> subclass, @OOXIXo kotlinx.serialization.Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(subclass, "subclass");
        IIX0o.x0xO0oo(serializer, "serializer");
        this.f30778I0Io.add(Xo0.oIX0oI(subclass, serializer));
    }

    public /* synthetic */ II0xO0(kotlin.reflect.oxoX oxox, kotlinx.serialization.Oxx0IOOO oxx0IOOO, int i, IIXOooo iIXOooo) {
        this(oxox, (i & 2) != 0 ? null : oxx0IOOO);
    }
}
