package kotlin.sequences;

import java.util.List;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class SequencesKt__SequencesKt$shuffled$1<T> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ ooOOo0oXI<T> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$shuffled$1(ooOOo0oXI<? extends T> ooooo0oxi, Random random, kotlin.coroutines.I0Io<? super SequencesKt__SequencesKt$shuffled$1> i0Io) {
        super(2, i0Io);
        this.$this_shuffled = ooooo0oxi;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, i0Io);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        List ox0I2;
        oO oOVar;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ox0I2 = (List) this.L$1;
                oO oOVar2 = (oO) this.L$0;
                I0oOoX.x0XOIxOo(obj);
                oOVar = oOVar2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            oO oOVar3 = (oO) this.L$0;
            ox0I2 = SequencesKt___SequencesKt.ox0I(this.$this_shuffled);
            oOVar = oOVar3;
        }
        while (!ox0I2.isEmpty()) {
            int nextInt = this.$random.nextInt(ox0I2.size());
            Object xx0X02 = kotlin.collections.OxI.xx0X0(ox0I2);
            if (nextInt < ox0I2.size()) {
                xx0X02 = ox0I2.set(nextInt, xx0X02);
            }
            this.L$0 = oOVar;
            this.L$1 = ox0I2;
            this.label = 1;
            if (oOVar.II0xO0(xx0X02, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super T> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
