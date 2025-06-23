package androidx.core.content;

import OXOo.OOXIXo;
import androidx.core.util.Consumer;

public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@OOXIXo Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@OOXIXo Consumer<Integer> consumer);
}
