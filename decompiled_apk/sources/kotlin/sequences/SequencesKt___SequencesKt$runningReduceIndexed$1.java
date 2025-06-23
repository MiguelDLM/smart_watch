package kotlin.sequences;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Iterator;
import kotlin.I0oOoX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [S] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2395, 2399}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes6.dex */
public final class SequencesKt___SequencesKt$runningReduceIndexed$1<S> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super S>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.IXxxXO<Integer, S, T, S> $operation;
    final /* synthetic */ ooOOo0oXI<T> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(ooOOo0oXI<? extends T> ooooo0oxi, Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> iXxxXO, kotlin.coroutines.I0Io<? super SequencesKt___SequencesKt$runningReduceIndexed$1> i0Io) {
        super(2, i0Io);
        this.$this_runningReduceIndexed = ooooo0oxi;
        this.$operation = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, i0Io);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        oO oOVar;
        Iterator it;
        Object next;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i3 = this.I$0;
                    Object obj2 = this.L$2;
                    it = (Iterator) this.L$1;
                    oOVar = (oO) this.L$0;
                    I0oOoX.x0XOIxOo(obj);
                    i2 = i3;
                    next = obj2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                next = this.L$2;
                it = (Iterator) this.L$1;
                oOVar = (oO) this.L$0;
                I0oOoX.x0XOIxOo(obj);
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            oOVar = (oO) this.L$0;
            it = this.$this_runningReduceIndexed.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.L$0 = oOVar;
                this.L$1 = it;
                this.L$2 = next;
                this.label = 1;
                if (oOVar.II0xO0(next, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        while (it.hasNext()) {
            Oox.IXxxXO<Integer, S, T, S> iXxxXO = this.$operation;
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            Object invoke = iXxxXO.invoke(IXIxx0.oIX0oI.XO(i2), next, it.next());
            this.L$0 = oOVar;
            this.L$1 = it;
            this.L$2 = invoke;
            this.I$0 = i4;
            this.label = 2;
            if (oOVar.II0xO0(invoke, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
            next = invoke;
            i2 = i4;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super S> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
