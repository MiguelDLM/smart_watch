package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface OnReceiveContentViewBehavior {
    @Nullable
    ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat contentInfoCompat);
}
