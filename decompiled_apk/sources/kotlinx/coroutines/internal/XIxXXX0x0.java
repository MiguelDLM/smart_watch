package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.o0oIxOo;

@kotlin.jvm.internal.XX({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
/* loaded from: classes6.dex */
public final class XIxXXX0x0 {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final o0oIxOo f30278I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final boolean f30279II0xO0 = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XIxXXX0x0 f30280oIX0oI;

    static {
        XIxXXX0x0 xIxXXX0x0 = new XIxXXX0x0();
        f30280oIX0oI = xIxXXX0x0;
        o0.XO(xxX.f30325oIX0oI, true);
        f30278I0Io = xIxXXX0x0.oIX0oI();
    }

    public final o0oIxOo oIX0oI() {
        Object next;
        o0oIxOo XO2;
        try {
            List oox000IX2 = SequencesKt___SequencesKt.oox000IX(SequencesKt__SequencesKt.X0o0xo(ServiceLoader.load(XI0IXoo.class, XI0IXoo.class.getClassLoader()).iterator()));
            Iterator it = oox000IX2.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int oIX0oI2 = ((XI0IXoo) next).oIX0oI();
                    do {
                        Object next2 = it.next();
                        int oIX0oI3 = ((XI0IXoo) next2).oIX0oI();
                        if (oIX0oI2 < oIX0oI3) {
                            next = next2;
                            oIX0oI2 = oIX0oI3;
                        }
                    } while (it.hasNext());
                }
            }
            XI0IXoo xI0IXoo = (XI0IXoo) next;
            if (xI0IXoo != null && (XO2 = xxX.XO(xI0IXoo, oox000IX2)) != null) {
                return XO2;
            }
            return xxX.II0xO0(null, null, 3, null);
        } catch (Throwable th) {
            return xxX.II0xO0(th, null, 2, null);
        }
    }
}
