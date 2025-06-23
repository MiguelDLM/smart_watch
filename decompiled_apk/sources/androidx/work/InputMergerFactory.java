package androidx.work;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public abstract class InputMergerFactory {
    @OXOo.oOoXoXO
    public abstract InputMerger createInputMerger(@OXOo.OOXIXo String str);

    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@OXOo.OOXIXo String className) {
        IIX0o.x0xO0oo(className, "className");
        InputMerger createInputMerger = createInputMerger(className);
        if (createInputMerger == null) {
            return InputMergerKt.fromClassName(className);
        }
        return createInputMerger;
    }
}
