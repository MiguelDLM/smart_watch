package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(@NonNull TransitionValues transitionValues);

    @Nullable
    @SuppressLint({"NullableCollection"})
    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2);
}
