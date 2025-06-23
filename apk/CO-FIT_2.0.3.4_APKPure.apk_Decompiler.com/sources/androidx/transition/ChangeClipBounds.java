package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

public class ChangeClipBounds extends Transition {
    static final Rect NULL_SENTINEL = new Rect();
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = {PROPNAME_CLIP};

    public static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Rect mEnd;
        private final Rect mStart;
        private final View mView;

        public Listener(View view, Rect rect, Rect rect2) {
            this.mView = view;
            this.mStart = rect;
            this.mEnd = rect2;
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
        }

        public void onTransitionPause(@NonNull Transition transition) {
            Rect clipBounds = this.mView.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.NULL_SENTINEL;
            }
            this.mView.setTag(R.id.transition_clip, clipBounds);
            this.mView.setClipBounds(this.mEnd);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            View view = this.mView;
            int i = R.id.transition_clip;
            this.mView.setClipBounds((Rect) view.getTag(i));
            this.mView.setTag(i, (Object) null);
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                this.mView.setClipBounds(this.mEnd);
            } else {
                this.mView.setClipBounds(this.mStart);
            }
        }

        public /* synthetic */ void onTransitionEnd(Transition transition, boolean z) {
            X0o0xo.oIX0oI(this, transition, z);
        }

        public /* synthetic */ void onTransitionStart(Transition transition, boolean z) {
            X0o0xo.II0xO0(this, transition, z);
        }
    }

    public ChangeClipBounds() {
    }

    private void captureValues(TransitionValues transitionValues, boolean z) {
        Rect rect;
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            Rect rect2 = null;
            if (z) {
                rect = (Rect) view.getTag(R.id.transition_clip);
            } else {
                rect = null;
            }
            if (rect == null) {
                rect = view.getClipBounds();
            }
            if (rect != NULL_SENTINEL) {
                rect2 = rect;
            }
            transitionValues.values.put(PROPNAME_CLIP, rect2);
            if (rect2 == null) {
                transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, false);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, true);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        Rect rect;
        Rect rect2;
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_CLIP) || !transitionValues2.values.containsKey(PROPNAME_CLIP)) {
            return null;
        }
        Rect rect3 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
        Rect rect4 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
        if (rect3 == null && rect4 == null) {
            return null;
        }
        if (rect3 == null) {
            rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
        } else {
            rect = rect3;
        }
        if (rect4 == null) {
            rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        } else {
            rect2 = rect4;
        }
        if (rect.equals(rect2)) {
            return null;
        }
        transitionValues2.view.setClipBounds(rect3);
        RectEvaluator rectEvaluator = new RectEvaluator(new Rect());
        ObjectAnimator ofObject = ObjectAnimator.ofObject(transitionValues2.view, ViewUtils.CLIP_BOUNDS, rectEvaluator, new Rect[]{rect, rect2});
        Listener listener = new Listener(transitionValues2.view, rect3, rect4);
        ofObject.addListener(listener);
        addListener(listener);
        return ofObject;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeClipBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
