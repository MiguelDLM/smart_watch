package androidx.work;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Tracer {
    void beginAsyncSection(@OOXIXo String str, int i);

    void beginSection(@OOXIXo String str);

    void endAsyncSection(@OOXIXo String str, int i);

    void endSection();

    boolean isEnabled();
}
