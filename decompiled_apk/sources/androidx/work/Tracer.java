package androidx.work;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface Tracer {
    void beginAsyncSection(@OXOo.OOXIXo String str, int i);

    void beginSection(@OXOo.OOXIXo String str);

    void endAsyncSection(@OXOo.OOXIXo String str, int i);

    void endSection();

    boolean isEnabled();
}
