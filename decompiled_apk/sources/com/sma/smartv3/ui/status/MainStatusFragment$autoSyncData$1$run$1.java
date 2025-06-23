package com.sma.smartv3.ui.status;

import com.google.android.exoplayer2.ExoPlayer;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.status.MainStatusFragment$autoSyncData$1$run$1", f = "MainStatusFragment.kt", i = {}, l = {354}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class MainStatusFragment$autoSyncData$1$run$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;
    final /* synthetic */ MainStatusFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainStatusFragment$autoSyncData$1$run$1(MainStatusFragment mainStatusFragment, kotlin.coroutines.I0Io<? super MainStatusFragment$autoSyncData$1$run$1> i0Io) {
        super(2, i0Io);
        this.this$0 = mainStatusFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new MainStatusFragment$autoSyncData$1$run$1(this.this$0, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
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
            this.this$0.getRefreshLayout().setRefreshing(true);
            this.label = 1;
            if (DelayKt.II0xO0(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        this.this$0.getRefreshLayout().setRefreshing(false);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((MainStatusFragment$autoSyncData$1$run$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
