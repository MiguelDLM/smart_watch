package androidx.work.impl.constraints;

import androidx.annotation.MainThread;

public interface ConstraintListener<T> {
    @MainThread
    void onConstraintChanged(T t);
}
