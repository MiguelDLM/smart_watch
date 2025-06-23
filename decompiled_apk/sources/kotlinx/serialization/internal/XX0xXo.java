package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes6.dex */
public interface XX0xXo<T> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object oIX0oI(XX0xXo xX0xXo, kotlin.reflect.oxoX oxox, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    list = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                return xX0xXo.oIX0oI(oxox, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
        }
    }

    @OXOo.OOXIXo
    Object oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> oxox, @OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> list);
}
