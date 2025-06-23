package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__MigrationKt$onErrorReturn$2<T> extends SuspendLambda implements Oox.IXxxXO<XO<? super T>, Throwable, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ T $fallback;
    final /* synthetic */ Oox.oOoXoXO<Throwable, Boolean> $predicate;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MigrationKt$onErrorReturn$2(Oox.oOoXoXO<? super Throwable, Boolean> oooxoxo, T t, kotlin.coroutines.I0Io<? super FlowKt__MigrationKt$onErrorReturn$2> i0Io) {
        super(3, i0Io);
        this.$predicate = oooxoxo;
        this.$fallback = t;
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
            XO xo2 = (XO) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (this.$predicate.invoke(th).booleanValue()) {
                T t = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (xo2.emit(t, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            } else {
                throw th;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.IXxxXO
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo Throwable th, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.$predicate, this.$fallback, i0Io);
        flowKt__MigrationKt$onErrorReturn$2.L$0 = xo2;
        flowKt__MigrationKt$onErrorReturn$2.L$1 = th;
        return flowKt__MigrationKt$onErrorReturn$2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
