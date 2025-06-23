package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import androidx.work.impl.model.WorkSpec;

public interface OnConstraintsStateChangedListener {
    void onConstraintsStateChanged(@OOXIXo WorkSpec workSpec, @OOXIXo ConstraintsState constraintsState);
}
