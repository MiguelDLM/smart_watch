package kotlin.reflect;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XO0OX.xxIXOIIO(name = "KClasses")
@XX({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n+ 2 KClassesImpl.kt\nkotlin/reflect/KClassesImplKt\n*L\n1#1,48:1\n9#2:49\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n*L\n26#1:49\n*E\n"})
/* loaded from: classes6.dex */
public final class X0o0xo {
    /* JADX WARN: Multi-variable type inference failed */
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.II0XooXoX
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T II0xO0(@OXOo.OOXIXo oxoX<T> oxox, @OXOo.oOoXoXO Object obj) {
        IIX0o.x0xO0oo(oxox, "<this>");
        if (oxox.Oxx0xo(obj)) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
            return obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.II0XooXoX
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T oIX0oI(@OXOo.OOXIXo oxoX<T> oxox, @OXOo.oOoXoXO Object obj) {
        IIX0o.x0xO0oo(oxox, "<this>");
        if (oxox.Oxx0xo(obj)) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + oxox.II0XooXoX());
    }
}
