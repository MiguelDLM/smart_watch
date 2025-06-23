package androidx.work.impl.foreground;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface ForegroundProcessor {
    void startForeground(@NonNull String workSpecId, @NonNull ForegroundInfo foregroundInfo);
}
