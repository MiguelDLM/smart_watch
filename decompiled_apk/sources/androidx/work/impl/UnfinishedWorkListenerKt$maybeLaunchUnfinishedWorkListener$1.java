package androidx.work.impl;

import Oox.Oxx0xo;
import androidx.work.Logger;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;

@IXIxx0.oxoX(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 extends SuspendLambda implements Oxx0xo<kotlinx.coroutines.flow.XO<? super Boolean>, Throwable, Long, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    public UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(kotlin.coroutines.I0Io<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1> i0Io) {
        super(4, i0Io);
    }

    @Override // Oox.Oxx0xo
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.XO<? super Boolean> xo2, Throwable th, Long l, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return invoke(xo2, th, l.longValue(), i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        long j;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            Throwable th = (Throwable) this.L$0;
            long j2 = this.J$0;
            Logger logger = Logger.get();
            str = UnfinishedWorkListenerKt.TAG;
            logger.error(str, "Cannot check for unfinished work", th);
            j = UnfinishedWorkListenerKt.MAX_DELAY_MS;
            long min = Math.min(j2 * 30000, j);
            this.label = 1;
            if (DelayKt.II0xO0(min, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return IXIxx0.oIX0oI.oIX0oI(true);
    }

    public final Object invoke(kotlinx.coroutines.flow.XO<? super Boolean> xo2, Throwable th, long j, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(i0Io);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.L$0 = th;
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.J$0 = j;
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
