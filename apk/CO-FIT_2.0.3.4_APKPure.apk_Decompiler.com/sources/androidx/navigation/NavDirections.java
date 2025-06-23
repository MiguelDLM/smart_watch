package androidx.navigation;

import OXOo.OOXIXo;
import android.os.Bundle;
import androidx.annotation.IdRes;

public interface NavDirections {
    @IdRes
    int getActionId();

    @OOXIXo
    Bundle getArguments();
}
