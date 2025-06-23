package androidx.constraintlayout.core.state;

/* loaded from: classes.dex */
public interface CoreMotionScene {
    String getConstraintSet(int i);

    String getConstraintSet(String str);

    String getTransition(String str);

    void setConstraintSetContent(String str, String str2);

    void setDebugName(String str);

    void setTransitionContent(String str, String str2);
}
