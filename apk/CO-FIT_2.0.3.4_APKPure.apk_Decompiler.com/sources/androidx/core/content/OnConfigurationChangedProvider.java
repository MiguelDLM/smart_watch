package androidx.core.content;

import OXOo.OOXIXo;
import android.content.res.Configuration;
import androidx.core.util.Consumer;

public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(@OOXIXo Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(@OOXIXo Consumer<Configuration> consumer);
}
