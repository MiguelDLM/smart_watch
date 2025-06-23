package androidx.core.content;

import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@OXOo.OOXIXo Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@OXOo.OOXIXo Consumer<Integer> consumer);
}
