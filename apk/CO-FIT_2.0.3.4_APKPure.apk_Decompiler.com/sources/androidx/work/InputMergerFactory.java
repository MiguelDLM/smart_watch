package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

public abstract class InputMergerFactory {
    @oOoXoXO
    public abstract InputMerger createInputMerger(@OOXIXo String str);

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "className");
        InputMerger createInputMerger = createInputMerger(str);
        if (createInputMerger == null) {
            return InputMergerKt.fromClassName(str);
        }
        return createInputMerger;
    }
}
