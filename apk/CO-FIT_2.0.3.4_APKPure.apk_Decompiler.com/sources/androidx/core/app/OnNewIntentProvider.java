package androidx.core.app;

import OXOo.OOXIXo;
import android.content.Intent;
import androidx.core.util.Consumer;

public interface OnNewIntentProvider {
    void addOnNewIntentListener(@OOXIXo Consumer<Intent> consumer);

    void removeOnNewIntentListener(@OOXIXo Consumer<Intent> consumer);
}
