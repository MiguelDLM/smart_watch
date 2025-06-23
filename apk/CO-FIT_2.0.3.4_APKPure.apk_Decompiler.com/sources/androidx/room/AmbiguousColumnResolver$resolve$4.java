package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.room.AmbiguousColumnResolver;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

public final class AmbiguousColumnResolver$resolve$4 extends Lambda implements oOoXoXO<List<? extends AmbiguousColumnResolver.Match>, oXIO0o0XI> {
    final /* synthetic */ Ref.ObjectRef<AmbiguousColumnResolver.Solution> $bestSolution;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmbiguousColumnResolver$resolve$4(Ref.ObjectRef<AmbiguousColumnResolver.Solution> objectRef) {
        super(1);
        this.$bestSolution = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<AmbiguousColumnResolver.Match>) (List) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(@OOXIXo List<AmbiguousColumnResolver.Match> list) {
        IIX0o.x0xO0oo(list, "it");
        T build = AmbiguousColumnResolver.Solution.Companion.build(list);
        if (build.compareTo((AmbiguousColumnResolver.Solution) this.$bestSolution.element) < 0) {
            this.$bestSolution.element = build;
        }
    }
}
