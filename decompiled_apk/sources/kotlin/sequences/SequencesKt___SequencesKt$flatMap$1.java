package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

/* JADX INFO: Add missing generic type declarations: [R] */
/* loaded from: classes6.dex */
public /* synthetic */ class SequencesKt___SequencesKt$flatMap$1<R> extends FunctionReferenceImpl implements Oox.oOoXoXO<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    public SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // Oox.oOoXoXO
    @OXOo.OOXIXo
    public final Iterator<R> invoke(@OXOo.OOXIXo Iterable<? extends R> p0) {
        IIX0o.x0xO0oo(p0, "p0");
        return p0.iterator();
    }
}
