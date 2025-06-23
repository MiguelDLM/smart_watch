package androidx.core.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

public final class MultiWindowModeChangedInfo {
    private final boolean isInMultiWindowMode;
    @RequiresApi(26)
    @oOoXoXO
    private Configuration newConfiguration;

    public MultiWindowModeChangedInfo(boolean z) {
        this.isInMultiWindowMode = z;
    }

    @RequiresApi(26)
    @OOXIXo
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?");
    }

    public final boolean isInMultiWindowMode() {
        return this.isInMultiWindowMode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public MultiWindowModeChangedInfo(boolean z, @OOXIXo Configuration configuration) {
        this(z);
        IIX0o.x0xO0oo(configuration, "newConfig");
        this.newConfiguration = configuration;
    }
}
