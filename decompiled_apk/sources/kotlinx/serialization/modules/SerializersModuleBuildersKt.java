package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSerializersModuleBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n1#1,270:1\n31#1,3:271\n*S KotlinDebug\n*F\n+ 1 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n15#1:271,3\n*E\n"})
/* loaded from: classes6.dex */
public final class SerializersModuleBuildersKt {
    public static final /* synthetic */ <T> void I0Io(XO xo2, kotlinx.serialization.Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(serializer, "serializer");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        xo2.oxoX(IO.oxoX(Object.class), serializer);
    }

    @OOXIXo
    public static final X0o0xo II0xO0(@OOXIXo oOoXoXO<? super XO, oXIO0o0XI> builderAction) {
        IIX0o.x0xO0oo(builderAction, "builderAction");
        XO xo2 = new XO();
        builderAction.invoke(xo2);
        return xo2.Oxx0IOOO();
    }

    public static final /* synthetic */ <T> X0o0xo Oxx0IOOO(kotlinx.serialization.Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(serializer, "serializer");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return XO(IO.oxoX(Object.class), serializer);
    }

    public static /* synthetic */ void X0o0xo(XO xo2, kotlin.reflect.oxoX baseClass, kotlinx.serialization.Oxx0IOOO oxx0IOOO, oOoXoXO builderAction, int i, Object obj) {
        if ((i & 2) != 0) {
            oxx0IOOO = null;
        }
        if ((i & 4) != 0) {
            builderAction = new oOoXoXO<II0xO0<Object>, oXIO0o0XI>() { // from class: kotlinx.serialization.modules.SerializersModuleBuildersKt$polymorphic$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo II0xO0<Object> iI0xO0) {
                    IIX0o.x0xO0oo(iI0xO0, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(II0xO0<Object> iI0xO0) {
                    invoke2(iI0xO0);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(builderAction, "builderAction");
        II0xO0 iI0xO0 = new II0xO0(baseClass, oxx0IOOO);
        builderAction.invoke(iI0xO0);
        iI0xO0.oIX0oI(xo2);
    }

    @OOXIXo
    public static final <T> X0o0xo XO(@OOXIXo kotlin.reflect.oxoX<T> kClass, @OOXIXo kotlinx.serialization.Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(kClass, "kClass");
        IIX0o.x0xO0oo(serializer, "serializer");
        XO xo2 = new XO();
        xo2.oxoX(kClass, serializer);
        return xo2.Oxx0IOOO();
    }

    @OOXIXo
    public static final X0o0xo oIX0oI() {
        return Oxx0IOOO.oIX0oI();
    }

    public static final <Base> void oxoX(@OOXIXo XO xo2, @OOXIXo kotlin.reflect.oxoX<Base> baseClass, @OXOo.oOoXoXO kotlinx.serialization.Oxx0IOOO<Base> oxx0IOOO, @OOXIXo oOoXoXO<? super II0xO0<? super Base>, oXIO0o0XI> builderAction) {
        IIX0o.x0xO0oo(xo2, "<this>");
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(builderAction, "builderAction");
        II0xO0 iI0xO0 = new II0xO0(baseClass, oxx0IOOO);
        builderAction.invoke(iI0xO0);
        iI0xO0.oIX0oI(xo2);
    }
}
