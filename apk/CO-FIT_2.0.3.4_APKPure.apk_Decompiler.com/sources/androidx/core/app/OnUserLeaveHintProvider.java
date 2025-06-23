package androidx.core.app;

import OXOo.OOXIXo;

public interface OnUserLeaveHintProvider {
    void addOnUserLeaveHintListener(@OOXIXo Runnable runnable);

    void removeOnUserLeaveHintListener(@OOXIXo Runnable runnable);
}
