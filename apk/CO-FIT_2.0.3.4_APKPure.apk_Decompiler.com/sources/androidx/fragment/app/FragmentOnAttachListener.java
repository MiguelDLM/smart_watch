package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public interface FragmentOnAttachListener {
    @MainThread
    void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment);
}
