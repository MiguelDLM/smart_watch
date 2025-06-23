package androidx.collection;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.jvm.internal.Lambda;

public final class ObjectList$toString$1 extends Lambda implements oOoXoXO<E, CharSequence> {
    final /* synthetic */ ObjectList<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectList$toString$1(ObjectList<E> objectList) {
        super(1);
        this.this$0 = objectList;
    }

    @OOXIXo
    public final CharSequence invoke(E e) {
        if (e == this.this$0) {
            return "(this)";
        }
        return String.valueOf(e);
    }
}
