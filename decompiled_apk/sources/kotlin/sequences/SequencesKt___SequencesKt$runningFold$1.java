package kotlin.sequences;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2308, 2312}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class SequencesKt___SequencesKt$runningFold$1<R> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ Oox.x0xO0oo<R, T, R> $operation;
    final /* synthetic */ ooOOo0oXI<T> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFold$1(R r, ooOOo0oXI<? extends T> ooooo0oxi, Oox.x0xO0oo<? super R, ? super T, ? extends R> x0xo0oo, kotlin.coroutines.I0Io<? super SequencesKt___SequencesKt$runningFold$1> i0Io) {
        super(2, i0Io);
        this.$initial = r;
        this.$this_runningFold = ooooo0oxi;
        this.$operation = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, i0Io);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0052  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0068 -> B:6:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r6.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r6.L$1
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.oO r4 = (kotlin.sequences.oO) r4
            kotlin.I0oOoX.x0XOIxOo(r7)
        L1b:
            r7 = r3
            goto L4c
        L1d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L25:
            java.lang.Object r1 = r6.L$0
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L42
        L2d:
            kotlin.I0oOoX.x0XOIxOo(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            R r7 = r6.$initial
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.II0xO0(r7, r6)
            if (r7 != r0) goto L42
            return r0
        L42:
            R r7 = r6.$initial
            kotlin.sequences.ooOOo0oXI<T> r3 = r6.$this_runningFold
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
            r1 = r3
        L4c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r1.next()
            Oox.x0xO0oo<R, T, R> r5 = r6.$operation
            java.lang.Object r3 = r5.invoke(r7, r3)
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.II0xO0(r3, r6)
            if (r7 != r0) goto L1b
            return r0
        L6b:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super R> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
