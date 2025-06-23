package kotlinx.coroutines.selects;

import Oox.x0xO0oo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlinx.coroutines.selects.SelectImplementation;

@XX({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
@o0
/* loaded from: classes6.dex */
public class x0XOIxOo<R> extends SelectImplementation<R> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<SelectImplementation<R>.oIX0oI> f30429IIXOooo;

    public x0XOIxOo(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        super(coroutineContext);
        this.f30429IIXOooo = new ArrayList();
    }

    @o0
    public static /* synthetic */ <R> Object Xx000oIo(x0XOIxOo<R> x0xoixoo, kotlin.coroutines.I0Io<? super R> i0Io) {
        x0xoixoo.X00IoxXI();
        return super.o00(i0Io);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.II0xO0
    public <P, Q> void I0Io(@OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, P p, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        this.f30429IIXOooo.add(new SelectImplementation.oIX0oI(oxx0IOOO.oxoX(), oxx0IOOO.I0Io(), oxx0IOOO.II0xO0(), p, x0xo0oo, oxx0IOOO.oIX0oI()));
    }

    public final void X00IoxXI() {
        try {
            Collections.shuffle(this.f30429IIXOooo);
            Iterator<T> it = this.f30429IIXOooo.iterator();
            while (it.hasNext()) {
                SelectImplementation.ooXIXxIX(this, (SelectImplementation.oIX0oI) it.next(), false, 1, null);
            }
        } finally {
            this.f30429IIXOooo.clear();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    @o0
    @OXOo.oOoXoXO
    public Object o00(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return Xx000oIo(this, i0Io);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.II0xO0
    public <Q> void oIX0oI(@OXOo.OOXIXo X0o0xo<? extends Q> x0o0xo, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        this.f30429IIXOooo.add(new SelectImplementation.oIX0oI(x0o0xo.oxoX(), x0o0xo.I0Io(), x0o0xo.II0xO0(), null, x0xo0oo, x0o0xo.oIX0oI()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.II0xO0
    public void oxoX(@OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        this.f30429IIXOooo.add(new SelectImplementation.oIX0oI(i0Io.oxoX(), i0Io.I0Io(), i0Io.II0xO0(), SelectKt.oOoXoXO(), oooxoxo, i0Io.oIX0oI()));
    }
}
