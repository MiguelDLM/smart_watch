package androidx.lifecycle;

import OXOo.OOXIXo;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SavedStateHandlesVM extends ViewModel {
    @OOXIXo
    private final Map<String, SavedStateHandle> handles = new LinkedHashMap();

    @OOXIXo
    public final Map<String, SavedStateHandle> getHandles() {
        return this.handles;
    }
}
