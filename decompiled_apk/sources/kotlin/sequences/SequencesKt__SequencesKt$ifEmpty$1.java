package kotlin.sequences;

import java.util.Iterator;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SequencesKt__SequencesKt$ifEmpty$1<T> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.oIX0oI<ooOOo0oXI<T>> $defaultValue;
    final /* synthetic */ ooOOo0oXI<T> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$ifEmpty$1(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oIX0oI<? extends ooOOo0oXI<? extends T>> oix0oi, kotlin.coroutines.I0Io<? super SequencesKt__SequencesKt$ifEmpty$1> i0Io) {
        super(2, i0Io);
        this.$this_ifEmpty = ooooo0oxi;
        this.$defaultValue = oix0oi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, i0Io);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            I0oOoX.x0XOIxOo(obj);
        } else {
            I0oOoX.x0XOIxOo(obj);
            oO oOVar = (oO) this.L$0;
            Iterator<? extends T> it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.label = 1;
                if (oOVar.X0o0xo(it, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            } else {
                ooOOo0oXI<T> invoke = this.$defaultValue.invoke();
                this.label = 2;
                if (oOVar.XO(invoke, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super T> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
