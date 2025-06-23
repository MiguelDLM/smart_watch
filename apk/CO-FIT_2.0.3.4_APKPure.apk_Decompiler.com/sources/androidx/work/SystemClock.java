package androidx.work;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemClock implements Clock {
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
