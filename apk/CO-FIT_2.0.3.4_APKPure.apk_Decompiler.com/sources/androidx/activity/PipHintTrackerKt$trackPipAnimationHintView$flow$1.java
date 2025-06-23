package androidx.activity;

import IXIxx0.oxoX;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.graphics.Rect;
import android.view.View;
import com.kuaishou.weapon.p0.t;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;

@oxoX(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super Rect>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, I0Io<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> i0Io) {
        super(2, i0Io);
        this.$view = view;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(IXxxXO iXxxXO, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i3 != i7 || i2 != i6 || i4 != i8) {
            IIX0o.oO(view, t.c);
            iXxxXO.x0xO0oo(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(IXxxXO iXxxXO, View view) {
        iXxxXO.x0xO0oo(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, i0Io);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            IXxxXO iXxxXO = (IXxxXO) this.L$0;
            final oI0IIXIo oi0iixio = new oI0IIXIo(iXxxXO);
            final OxxIIOOXO oxxIIOOXO = new OxxIIOOXO(iXxxXO, this.$view);
            final PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(iXxxXO, this.$view, oxxIIOOXO, oi0iixio);
            if (this.$view.isAttachedToWindow()) {
                iXxxXO.x0xO0oo(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(oxxIIOOXO);
                this.$view.addOnLayoutChangeListener(oi0iixio);
            }
            this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            final View view = this.$view;
            AnonymousClass1 r5 = new oIX0oI<oXIO0o0XI>() {
                public final void invoke() {
                    view.getViewTreeObserver().removeOnScrollChangedListener(oxxIIOOXO);
                    view.removeOnLayoutChangeListener(oi0iixio);
                    view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, r5, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(IXxxXO<? super Rect> iXxxXO, I0Io<? super oXIO0o0XI> i0Io) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
