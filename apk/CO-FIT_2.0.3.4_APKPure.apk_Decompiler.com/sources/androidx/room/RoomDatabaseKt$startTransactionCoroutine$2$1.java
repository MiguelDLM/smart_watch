package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.xII;

public final class RoomDatabaseKt$startTransactionCoroutine$2$1 implements Runnable {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ oO<R> $continuation;
    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
    final /* synthetic */ x0xO0oo<xII, I0Io<? super R>, Object> $transactionBlock;

    @IXIxx0.oxoX(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            AnonymousClass1 r0 = new AnonymousClass1(roomDatabase, oOVar, x0xo0oo, i0Io);
            r0.L$0 = obj;
            return r0;
        }

        @oOoXoXO
        public final Object invokeSuspend(@OOXIXo Object obj) {
            I0Io i0Io;
            Object oOoXoXO2 = II0xO0.oOoXoXO();
            int i = this.label;
            if (i == 0) {
                I0oOoX.x0XOIxOo(obj);
                CoroutineContext.oIX0oI oix0oi = ((xII) this.L$0).getCoroutineContext().get(oxoX.f18959Oxx0IOOO);
                IIX0o.ooOOo0oXI(oix0oi);
                CoroutineContext access$createTransactionContext = RoomDatabaseKt.createTransactionContext(roomDatabase, (oxoX) oix0oi);
                oO<R> oOVar = oOVar;
                Result.oIX0oI oix0oi2 = Result.Companion;
                x0xO0oo<xII, I0Io<? super R>, Object> x0xo0oo = x0xo0oo;
                this.L$0 = oOVar;
                this.label = 1;
                obj = II0XooXoX.II0XooXoX(access$createTransactionContext, x0xo0oo, this);
                if (obj == oOoXoXO2) {
                    return oOoXoXO2;
                }
                i0Io = oOVar;
            } else if (i == 1) {
                i0Io = (I0Io) this.L$0;
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i0Io.resumeWith(Result.m42constructorimpl(obj));
            return oXIO0o0XI.f19155oIX0oI;
        }

        @oOoXoXO
        public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    public RoomDatabaseKt$startTransactionCoroutine$2$1(CoroutineContext coroutineContext, oO<? super R> oOVar, RoomDatabase roomDatabase, x0xO0oo<? super xII, ? super I0Io<? super R>, ? extends Object> x0xo0oo) {
        this.$context = coroutineContext;
        this.$continuation = oOVar;
        this.$this_startTransactionCoroutine = roomDatabase;
        this.$transactionBlock = x0xo0oo;
    }

    public final void run() {
        try {
            CoroutineContext minusKey = this.$context.minusKey(oxoX.f18959Oxx0IOOO);
            final RoomDatabase roomDatabase = this.$this_startTransactionCoroutine;
            final oO<R> oOVar = this.$continuation;
            final x0xO0oo<xII, I0Io<? super R>, Object> x0xo0oo = this.$transactionBlock;
            II0XooXoX.XO(minusKey, new AnonymousClass1((I0Io<? super AnonymousClass1>) null));
        } catch (Throwable th) {
            this.$continuation.oIX0oI(th);
        }
    }
}
