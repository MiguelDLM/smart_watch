package kotlin.sequences;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2336, 2341}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "L$0", "L$1", "I$0"})
/* loaded from: classes6.dex */
public final class SequencesKt___SequencesKt$runningFoldIndexed$1<R> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ Oox.IXxxXO<Integer, R, T, R> $operation;
    final /* synthetic */ ooOOo0oXI<T> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r, ooOOo0oXI<? extends T> ooooo0oxi, Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> iXxxXO, kotlin.coroutines.I0Io<? super SequencesKt___SequencesKt$runningFoldIndexed$1> i0Io) {
        super(2, i0Io);
        this.$initial = r;
        this.$this_runningFoldIndexed = ooooo0oxi;
        this.$operation = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, i0Io);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r8.I$0
            java.lang.Object r3 = r8.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r8.L$1
            java.lang.Object r5 = r8.L$0
            kotlin.sequences.oO r5 = (kotlin.sequences.oO) r5
            kotlin.I0oOoX.x0XOIxOo(r9)
            r9 = r4
            r4 = r1
            goto L4f
        L20:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L28:
            java.lang.Object r1 = r8.L$0
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L45
        L30:
            kotlin.I0oOoX.x0XOIxOo(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlin.sequences.oO r1 = (kotlin.sequences.oO) r1
            R r9 = r8.$initial
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r1.II0xO0(r9, r8)
            if (r9 != r0) goto L45
            return r0
        L45:
            R r9 = r8.$initial
            kotlin.sequences.ooOOo0oXI<T> r3 = r8.$this_runningFoldIndexed
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r1
        L4f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L7e
            java.lang.Object r1 = r3.next()
            Oox.IXxxXO<java.lang.Integer, R, T, R> r6 = r8.$operation
            int r7 = r4 + 1
            if (r4 >= 0) goto L62
            kotlin.collections.CollectionsKt__CollectionsKt.XoX()
        L62:
            java.lang.Integer r4 = IXIxx0.oIX0oI.XO(r4)
            java.lang.Object r4 = r6.invoke(r4, r9, r1)
            r8.L$0 = r5
            r8.L$1 = r4
            r8.L$2 = r3
            r8.I$0 = r7
            r8.label = r2
            java.lang.Object r9 = r5.II0xO0(r4, r8)
            if (r9 != r0) goto L7b
            return r0
        L7b:
            r9 = r4
            r4 = r7
            goto L4f
        L7e:
            kotlin.oXIO0o0XI r9 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super R> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
