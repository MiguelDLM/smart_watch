package androidx.core.content;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(@OXOo.OOXIXo Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(@OXOo.OOXIXo Consumer<Configuration> consumer);
}
