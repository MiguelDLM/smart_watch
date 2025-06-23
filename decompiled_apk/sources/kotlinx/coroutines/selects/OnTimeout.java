package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;

@XX({"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
/* loaded from: classes6.dex */
public final class OnTimeout {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final long f30391oIX0oI;

    @XX({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ OnTimeout f30392Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ xoIox f30393XO;

        public oIX0oI(xoIox xoiox, OnTimeout onTimeout) {
            this.f30393XO = xoiox;
            this.f30392Oo = onTimeout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f30393XO.xxIXOIIO(this.f30392Oo, oXIO0o0XI.f29392oIX0oI);
        }
    }

    public OnTimeout(long j) {
        this.f30391oIX0oI = j;
    }

    public static /* synthetic */ void I0Io() {
    }

    @OXOo.OOXIXo
    public final I0Io II0xO0() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.INSTANCE;
        IIX0o.x0XOIxOo(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new oxoX(this, (IXxxXO) XoX.Oo(onTimeout$selectClause$1, 3), null, 4, null);
    }

    public final void oxoX(xoIox<?> xoiox, Object obj) {
        if (this.f30391oIX0oI <= 0) {
            xoiox.XO(oXIO0o0XI.f29392oIX0oI);
            return;
        }
        oIX0oI oix0oi = new oIX0oI(xoiox, this);
        IIX0o.x0XOIxOo(xoiox, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        CoroutineContext context = xoiox.getContext();
        xoiox.Oxx0IOOO(DelayKt.oxoX(context).Oxx0xo(this.f30391oIX0oI, oix0oi, context));
    }
}
