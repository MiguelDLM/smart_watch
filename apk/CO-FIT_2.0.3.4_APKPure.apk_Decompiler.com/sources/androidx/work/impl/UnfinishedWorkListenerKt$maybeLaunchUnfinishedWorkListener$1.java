package androidx.work.impl;

import IXIxx0.oIX0oI;
import IXIxx0.oxoX;
import Oox.Oxx0xo;
import androidx.work.Logger;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.XO;

@oxoX(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 extends SuspendLambda implements Oxx0xo<XO<? super Boolean>, Throwable, Long, I0Io<? super Boolean>, Object> {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    public UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(I0Io<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1> i0Io) {
        super(4, i0Io);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((XO<? super Boolean>) (XO) obj, (Throwable) obj2, ((Number) obj3).longValue(), (I0Io<? super Boolean>) (I0Io) obj4);
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            long j = this.J$0;
            Logger.get().error(UnfinishedWorkListenerKt.TAG, "Cannot check for unfinished work", (Throwable) this.L$0);
            long min = Math.min(j * ((long) 30000), UnfinishedWorkListenerKt.MAX_DELAY_MS);
            this.label = 1;
            if (DelayKt.II0xO0(min, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oIX0oI.oIX0oI(true);
    }

    public final Object invoke(XO<? super Boolean> xo2, Throwable th, long j, I0Io<? super Boolean> i0Io) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(i0Io);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.L$0 = th;
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.J$0 = j;
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
