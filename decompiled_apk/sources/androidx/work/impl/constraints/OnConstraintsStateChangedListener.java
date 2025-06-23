package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import androidx.work.impl.model.WorkSpec;

/* loaded from: classes.dex */
public interface OnConstraintsStateChangedListener {
    void onConstraintsStateChanged(@OOXIXo WorkSpec workSpec, @OOXIXo ConstraintsState constraintsState);
}
