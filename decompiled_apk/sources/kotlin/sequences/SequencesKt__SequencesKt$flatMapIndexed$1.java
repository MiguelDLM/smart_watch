package kotlin.sequences;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Iterator;
import kotlin.I0oOoX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", MapBundleKey.MapObjKey.OBJ_SL_INDEX}, s = {"L$0", "I$0"})
/* loaded from: classes6.dex */
public final class SequencesKt__SequencesKt$flatMapIndexed$1<R> extends RestrictedSuspendLambda implements Oox.x0xO0oo<oO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.oOoXoXO<C, Iterator<R>> $iterator;
    final /* synthetic */ ooOOo0oXI<T> $source;
    final /* synthetic */ Oox.x0xO0oo<Integer, T, C> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$flatMapIndexed$1(ooOOo0oXI<? extends T> ooooo0oxi, Oox.x0xO0oo<? super Integer, ? super T, ? extends C> x0xo0oo, Oox.oOoXoXO<? super C, ? extends Iterator<? extends R>> oooxoxo, kotlin.coroutines.I0Io<? super SequencesKt__SequencesKt$flatMapIndexed$1> i0Io) {
        super(2, i0Io);
        this.$source = ooooo0oxi;
        this.$transform = x0xo0oo;
        this.$iterator = oooxoxo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, i0Io);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        oO oOVar;
        Iterator it;
        int i;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.I$0;
                it = (Iterator) this.L$1;
                oOVar = (oO) this.L$0;
                I0oOoX.x0XOIxOo(obj);
                i = i3;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            oOVar = (oO) this.L$0;
            it = this.$source.iterator();
            i = 0;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Oox.x0xO0oo<Integer, T, C> x0xo0oo = this.$transform;
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            Iterator<R> invoke = this.$iterator.invoke(x0xo0oo.invoke(IXIxx0.oIX0oI.XO(i), next));
            this.L$0 = oOVar;
            this.L$1 = it;
            this.I$0 = i4;
            this.label = 1;
            if (oOVar.X0o0xo(invoke, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
            i = i4;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo oO<? super R> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
