package androidx.lifecycle;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.sync.oIX0oI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;
import kotlinx.coroutines.xoIox;

public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {
    final /* synthetic */ xII $$this$coroutineScope;
    final /* synthetic */ x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> $block;
    final /* synthetic */ Lifecycle.Event $cancelWorkEvent;
    final /* synthetic */ oO<oXIO0o0XI> $cont;
    final /* synthetic */ Ref.ObjectRef<kotlinx.coroutines.oXIO0o0XI> $launchedJob;
    final /* synthetic */ oIX0oI $mutex;
    final /* synthetic */ Lifecycle.Event $startWorkEvent;

    @oxoX(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {171, 110}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    @XX({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,165:1\n107#2,10:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1\n*L\n109#1:166,10\n*E\n"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
        Object L$0;
        Object L$1;
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            return new AnonymousClass1(oix0oi, x0xo0oo, i0Io);
        }

        @oOoXoXO
        public final Object invokeSuspend(@OOXIXo Object obj) {
            Throwable th;
            oIX0oI oix0oi;
            oIX0oI oix0oi2;
            x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> x0xo0oo;
            Object oOoXoXO2 = II0xO0.oOoXoXO();
            int i = this.label;
            if (i == 0) {
                I0oOoX.x0XOIxOo(obj);
                oix0oi2 = oix0oi;
                x0xo0oo = x0xo0oo;
                this.L$0 = oix0oi2;
                this.L$1 = x0xo0oo;
                this.label = 1;
                if (oix0oi2.II0XooXoX((Object) null, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            } else if (i == 1) {
                x0xo0oo = (x0xO0oo) this.L$1;
                I0oOoX.x0XOIxOo(obj);
                oix0oi2 = (oIX0oI) this.L$0;
            } else if (i == 2) {
                oix0oi = (oIX0oI) this.L$0;
                try {
                    I0oOoX.x0XOIxOo(obj);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                    oix0oi.xxIXOIIO((Object) null);
                    return oxio0o0xi;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(x0xo0oo, (I0Io<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1>) null);
                this.L$0 = oix0oi2;
                this.L$1 = null;
                this.label = 2;
                if (x0o.Oxx0IOOO(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
                oix0oi = oix0oi2;
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f19155oIX0oI;
                oix0oi.xxIXOIIO((Object) null);
                return oxio0o0xi2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                oix0oi = oix0oi2;
                th = th4;
                oix0oi.xxIXOIIO((Object) null);
                throw th;
            }
        }

        @oOoXoXO
        public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, Ref.ObjectRef<kotlinx.coroutines.oXIO0o0XI> objectRef, xII xii, Lifecycle.Event event2, oO<? super oXIO0o0XI> oOVar, oIX0oI oix0oi, x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        this.$startWorkEvent = event;
        this.$launchedJob = objectRef;
        this.$$this$coroutineScope = xii;
        this.$cancelWorkEvent = event2;
        this.$cont = oOVar;
        this.$mutex = oix0oi;
        this.$block = x0xo0oo;
    }

    public final void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (event == this.$startWorkEvent) {
            Ref.ObjectRef<kotlinx.coroutines.oXIO0o0XI> objectRef = this.$launchedJob;
            xII xii = this.$$this$coroutineScope;
            final oIX0oI oix0oi = this.$mutex;
            final x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> x0xo0oo = this.$block;
            objectRef.element = xoIox.XO(xii, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((I0Io<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        if (event == this.$cancelWorkEvent) {
            kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) this.$launchedJob.element;
            if (oxio0o0xi != null) {
                oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, (CancellationException) null, 1, (Object) null);
            }
            this.$launchedJob.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            oO<kotlin.oXIO0o0XI> oOVar = this.$cont;
            Result.oIX0oI oix0oi2 = Result.Companion;
            oOVar.resumeWith(Result.m42constructorimpl(kotlin.oXIO0o0XI.f19155oIX0oI));
        }
    }
}
