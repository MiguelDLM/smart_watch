package kotlinx.serialization.modules;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.serialization.Oxx0xo;

/* loaded from: classes6.dex */
public abstract class X0o0xo {
    public /* synthetic */ X0o0xo(IIXOooo iIXOooo) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlinx.serialization.Oxx0IOOO oxoX(X0o0xo x0o0xo, kotlin.reflect.oxoX oxox, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                list = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            return x0o0xo.I0Io(oxox, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    @kotlinx.serialization.oxoX
    @oOoXoXO
    public abstract <T> kotlinx.serialization.Oxx0IOOO<T> I0Io(@OOXIXo kotlin.reflect.oxoX<T> oxox, @OOXIXo List<? extends kotlinx.serialization.Oxx0IOOO<?>> list);

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of overload with default parameter", replaceWith = @XX(expression = "getContextual(kclass)", imports = {}))
    @kotlinx.serialization.oxoX
    public final /* synthetic */ kotlinx.serialization.Oxx0IOOO II0xO0(kotlin.reflect.oxoX kclass) {
        IIX0o.x0xO0oo(kclass, "kclass");
        return I0Io(kclass, CollectionsKt__CollectionsKt.ooXIXxIX());
    }

    @kotlinx.serialization.oxoX
    @oOoXoXO
    public abstract <T> kotlinx.serialization.I0Io<T> X0o0xo(@OOXIXo kotlin.reflect.oxoX<? super T> oxox, @oOoXoXO String str);

    @kotlinx.serialization.oxoX
    @oOoXoXO
    public abstract <T> Oxx0xo<T> XO(@OOXIXo kotlin.reflect.oxoX<? super T> oxox, @OOXIXo T t);

    @kotlinx.serialization.oxoX
    public abstract void oIX0oI(@OOXIXo SerializersModuleCollector serializersModuleCollector);

    public X0o0xo() {
    }
}
