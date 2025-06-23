package androidx.core.app;

import android.content.Intent;
import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@OXOo.OOXIXo Consumer<Intent> consumer);

    void removeOnNewIntentListener(@OXOo.OOXIXo Consumer<Intent> consumer);
}
