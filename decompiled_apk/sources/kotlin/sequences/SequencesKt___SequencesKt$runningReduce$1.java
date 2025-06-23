package kotlin.sequences;

import java.util.Iterator;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [S] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2366, 2369}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class SequencesKt___SequencesKt$runningReduce$1<S> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super S>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.x0xO0oo<S, T, S> $operation;
    final /* synthetic */ ooOOo0oXI<T> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduce$1(ooOOo0oXI<? extends T> ooooo0oxi, Oox.x0xO0oo<? super S, ? super T, ? extends S> x0xo0oo, kotlin.coroutines.I0Io<? super SequencesKt___SequencesKt$runningReduce$1> i0Io) {
        super(2, i0Io);
        this.$this_runningReduce = ooooo0oxi;
        this.$operation = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, i0Io);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        oO oOVar;
        Object next;
        Iterator it;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.L$2;
            it = (Iterator) this.L$1;
            oOVar = (oO) this.L$0;
            I0oOoX.x0XOIxOo(obj);
        } else {
            I0oOoX.x0XOIxOo(obj);
            oOVar = (oO) this.L$0;
            Iterator it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = oOVar;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (oOVar.II0xO0(next, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
                it = it2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        while (it.hasNext()) {
            next = this.$operation.invoke(next, it.next());
            this.L$0 = oOVar;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (oOVar.II0xO0(next, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super S> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
