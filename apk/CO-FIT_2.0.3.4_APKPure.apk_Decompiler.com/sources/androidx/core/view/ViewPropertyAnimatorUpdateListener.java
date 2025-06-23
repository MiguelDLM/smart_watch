package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface ViewPropertyAnimatorUpdateListener {
    void onAnimationUpdate(@NonNull View view);
}
