package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f, float f2, float f3, float f4);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
