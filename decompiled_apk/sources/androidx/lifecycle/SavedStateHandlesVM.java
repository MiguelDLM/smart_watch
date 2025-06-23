package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class SavedStateHandlesVM extends ViewModel {

    @OXOo.OOXIXo
    private final Map<String, SavedStateHandle> handles = new LinkedHashMap();

    @OXOo.OOXIXo
    public final Map<String, SavedStateHandle> getHandles() {
        return this.handles;
    }
}
