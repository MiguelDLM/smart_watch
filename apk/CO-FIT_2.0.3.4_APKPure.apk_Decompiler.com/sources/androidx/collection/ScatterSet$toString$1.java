package androidx.collection;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;

public final class ScatterSet$toString$1 extends Lambda implements oOoXoXO<E, CharSequence> {
    final /* synthetic */ ScatterSet<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScatterSet$toString$1(ScatterSet<E> scatterSet) {
        super(1);
        this.this$0 = scatterSet;
    }

    @OOXIXo
    public final CharSequence invoke(E e) {
        if (e == this.this$0) {
            return "(this)";
        }
        return String.valueOf(e);
    }
}
