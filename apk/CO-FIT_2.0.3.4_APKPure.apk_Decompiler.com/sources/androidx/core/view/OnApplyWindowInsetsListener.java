package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface OnApplyWindowInsetsListener {
    @NonNull
    WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat);
}
