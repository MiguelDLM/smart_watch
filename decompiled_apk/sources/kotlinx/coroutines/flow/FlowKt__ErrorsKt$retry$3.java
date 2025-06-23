package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__ErrorsKt$retry$3<T> extends SuspendLambda implements Oox.Oxx0xo<XO<? super T>, Throwable, Long, kotlin.coroutines.I0Io<? super Boolean>, Object> {
    final /* synthetic */ Oox.x0xO0oo<Throwable, kotlin.coroutines.I0Io<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long j, Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super FlowKt__ErrorsKt$retry$3> i0Io) {
        super(4, i0Io);
        this.$retries = j;
        this.$predicate = x0xo0oo;
    }

    @Override // Oox.Oxx0xo
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return invoke((XO) obj, th, l.longValue(), i0Io);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L31
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            kotlin.I0oOoX.x0XOIxOo(r8)
            java.lang.Object r8 = r7.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.J$0
            long r5 = r7.$retries
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3a
            Oox.x0xO0oo<java.lang.Throwable, kotlin.coroutines.I0Io<? super java.lang.Boolean>, java.lang.Object> r1 = r7.$predicate
            r7.label = r2
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L31
            return r0
        L31:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L3a
            goto L3b
        L3a:
            r2 = 0
        L3b:
            java.lang.Boolean r8 = IXIxx0.oIX0oI.oIX0oI(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo Throwable th, long j, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, i0Io);
        flowKt__ErrorsKt$retry$3.L$0 = th;
        flowKt__ErrorsKt$retry$3.J$0 = j;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
