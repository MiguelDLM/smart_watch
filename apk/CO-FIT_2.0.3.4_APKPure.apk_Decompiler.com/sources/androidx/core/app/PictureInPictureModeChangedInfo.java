package androidx.core.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

public final class PictureInPictureModeChangedInfo {
    private final boolean isInPictureInPictureMode;
    @RequiresApi(26)
    @oOoXoXO
    private Configuration newConfiguration;

    public PictureInPictureModeChangedInfo(boolean z) {
        this.isInPictureInPictureMode = z;
    }

    @RequiresApi(26)
    @OOXIXo
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?");
    }

    public final boolean isInPictureInPictureMode() {
        return this.isInPictureInPictureMode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public PictureInPictureModeChangedInfo(boolean z, @OOXIXo Configuration configuration) {
        this(z);
        IIX0o.x0xO0oo(configuration, "newConfig");
        this.newConfiguration = configuration;
    }
}
