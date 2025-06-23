package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.internal.O0X;
import kotlinx.serialization.internal.XX0xXo;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@XX({"SMAP\nSerializersCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt\n+ 2 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,75:1\n79#2:76\n*S KotlinDebug\n*F\n+ 1 SerializersCache.kt\nkotlinx/serialization/SerializersCacheKt\n*L\n53#1:76\n*E\n"})
/* loaded from: classes6.dex */
public final class SerializersCacheKt {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final O0X<? extends Object> f30562oIX0oI = kotlinx.serialization.internal.oO.oIX0oI(new Oox.oOoXoXO<kotlin.reflect.oxoX<?>, Oxx0IOOO<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE$1
        @Override // Oox.oOoXoXO
        @OXOo.oOoXoXO
        public final Oxx0IOOO<? extends Object> invoke(@OXOo.OOXIXo kotlin.reflect.oxoX<?> it) {
            IIX0o.x0xO0oo(it, "it");
            return OxxIIOOXO.oO(it);
        }
    });

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final O0X<Object> f30561II0xO0 = kotlinx.serialization.internal.oO.oIX0oI(new Oox.oOoXoXO<kotlin.reflect.oxoX<?>, Oxx0IOOO<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1
        @Override // Oox.oOoXoXO
        @OXOo.oOoXoXO
        public final Oxx0IOOO<Object> invoke(@OXOo.OOXIXo kotlin.reflect.oxoX<?> it) {
            Oxx0IOOO<Object> IIXOooo2;
            IIX0o.x0xO0oo(it, "it");
            Oxx0IOOO oO2 = OxxIIOOXO.oO(it);
            if (oO2 == null || (IIXOooo2 = xx.oOoXoXO.IIXOooo(oO2)) == null) {
                return null;
            }
            return IIXOooo2;
        }
    });

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XX0xXo<? extends Object> f30560I0Io = kotlinx.serialization.internal.oO.II0xO0(new Oox.x0xO0oo<kotlin.reflect.oxoX<Object>, List<? extends kotlin.reflect.Oxx0xo>, Oxx0IOOO<? extends Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1
        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Oxx0IOOO<? extends Object> invoke(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> clazz, @OXOo.OOXIXo final List<? extends kotlin.reflect.Oxx0xo> types) {
            IIX0o.x0xO0oo(clazz, "clazz");
            IIX0o.x0xO0oo(types, "types");
            List<Oxx0IOOO<Object>> Oxx0xo2 = OxxIIOOXO.Oxx0xo(SerializersModuleBuildersKt.oIX0oI(), types, true);
            IIX0o.ooOOo0oXI(Oxx0xo2);
            return OxxIIOOXO.oxoX(clazz, Oxx0xo2, new Oox.oIX0oI<kotlin.reflect.Oxx0IOOO>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                @OXOo.oOoXoXO
                public final kotlin.reflect.Oxx0IOOO invoke() {
                    return types.get(0).IXxxXO();
                }
            });
        }
    });

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XX0xXo<Object> f30563oxoX = kotlinx.serialization.internal.oO.II0xO0(new Oox.x0xO0oo<kotlin.reflect.oxoX<Object>, List<? extends kotlin.reflect.Oxx0xo>, Oxx0IOOO<Object>>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1
        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Oxx0IOOO<Object> invoke(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> clazz, @OXOo.OOXIXo final List<? extends kotlin.reflect.Oxx0xo> types) {
            Oxx0IOOO<Object> IIXOooo2;
            IIX0o.x0xO0oo(clazz, "clazz");
            IIX0o.x0xO0oo(types, "types");
            List<Oxx0IOOO<Object>> Oxx0xo2 = OxxIIOOXO.Oxx0xo(SerializersModuleBuildersKt.oIX0oI(), types, true);
            IIX0o.ooOOo0oXI(Oxx0xo2);
            Oxx0IOOO<? extends Object> oxoX2 = OxxIIOOXO.oxoX(clazz, Oxx0xo2, new Oox.oIX0oI<kotlin.reflect.Oxx0IOOO>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                @OXOo.oOoXoXO
                public final kotlin.reflect.Oxx0IOOO invoke() {
                    return types.get(0).IXxxXO();
                }
            });
            if (oxoX2 == null || (IIXOooo2 = xx.oOoXoXO.IIXOooo(oxoX2)) == null) {
                return null;
            }
            return IIXOooo2;
        }
    });

    public static /* synthetic */ void I0Io() {
    }

    @OXOo.OOXIXo
    public static final Object II0xO0(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> clazz, @OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> types, boolean z) {
        IIX0o.x0xO0oo(clazz, "clazz");
        IIX0o.x0xO0oo(types, "types");
        if (!z) {
            return f30560I0Io.oIX0oI(clazz, types);
        }
        return f30563oxoX.oIX0oI(clazz, types);
    }

    public static /* synthetic */ void X0o0xo() {
    }

    public static /* synthetic */ void XO() {
    }

    @OXOo.oOoXoXO
    public static final Oxx0IOOO<Object> oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> clazz, boolean z) {
        IIX0o.x0xO0oo(clazz, "clazz");
        if (!z) {
            Oxx0IOOO<? extends Object> oIX0oI2 = f30562oIX0oI.oIX0oI(clazz);
            if (oIX0oI2 == null) {
                return null;
            }
            return oIX0oI2;
        }
        return f30561II0xO0.oIX0oI(clazz);
    }

    public static /* synthetic */ void oxoX() {
    }
}
