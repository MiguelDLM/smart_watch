package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;

public interface FragmentResultListener {
    void onFragmentResult(@NonNull String str, @NonNull Bundle bundle);
}
