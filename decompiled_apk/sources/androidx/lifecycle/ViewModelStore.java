package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class ViewModelStore {

    @OXOo.OOXIXo
    private final Map<String, ViewModel> map = new LinkedHashMap();

    public final void clear() {
        Iterator<ViewModel> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
    }

    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return this.map.get(key);
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(@OXOo.OOXIXo String key, @OXOo.OOXIXo ViewModel viewModel) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(viewModel, "viewModel");
        ViewModel put = this.map.put(key, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
