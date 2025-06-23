package androidx.activity;

import OXOo.OOXIXo;
import androidx.lifecycle.LifecycleOwner;

public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @OOXIXo
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
