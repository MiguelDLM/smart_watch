package androidx.work.impl;

import android.content.Context;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.PackageManagerHelper;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2", f = "UnfinishedWorkListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 extends SuspendLambda implements Oox.x0xO0oo<Boolean, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Context $appContext;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(Context context, kotlin.coroutines.I0Io<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2> i0Io) {
        super(2, i0Io);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(Object obj, kotlin.coroutines.I0Io<?> i0Io) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(this.$appContext, i0Io);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2.Z$0 = ((Boolean) obj).booleanValue();
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke(bool.booleanValue(), i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            PackageManagerHelper.setComponentEnabled(this.$appContext, RescheduleReceiver.class, this.Z$0);
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2) create(Boolean.valueOf(z), i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
