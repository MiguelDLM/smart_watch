package androidx.core.app;

import OXOo.OOXIXo;
import androidx.core.util.Consumer;

public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(@OOXIXo Consumer<MultiWindowModeChangedInfo> consumer);

    void removeOnMultiWindowModeChangedListener(@OOXIXo Consumer<MultiWindowModeChangedInfo> consumer);
}
