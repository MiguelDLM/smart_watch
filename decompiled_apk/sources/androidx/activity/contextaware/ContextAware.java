package androidx.activity.contextaware;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;

/* loaded from: classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener);

    @oOoXoXO
    Context peekAvailableContext();

    void removeOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener);
}
