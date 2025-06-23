package androidx.core.app;

import OXOo.OOXIXo;
import androidx.core.util.Consumer;

public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(@OOXIXo Consumer<PictureInPictureModeChangedInfo> consumer);

    void removeOnPictureInPictureModeChangedListener(@OOXIXo Consumer<PictureInPictureModeChangedInfo> consumer);
}
