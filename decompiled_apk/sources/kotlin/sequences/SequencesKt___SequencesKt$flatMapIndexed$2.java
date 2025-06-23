package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

/* JADX INFO: Add missing generic type declarations: [R] */
/* loaded from: classes6.dex */
public /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$2<R> extends FunctionReferenceImpl implements Oox.oOoXoXO<ooOOo0oXI<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$2 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$2();

    public SequencesKt___SequencesKt$flatMapIndexed$2() {
        super(1, ooOOo0oXI.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // Oox.oOoXoXO
    @OXOo.OOXIXo
    public final Iterator<R> invoke(@OXOo.OOXIXo ooOOo0oXI<? extends R> p0) {
        IIX0o.x0xO0oo(p0, "p0");
        return p0.iterator();
    }
}
