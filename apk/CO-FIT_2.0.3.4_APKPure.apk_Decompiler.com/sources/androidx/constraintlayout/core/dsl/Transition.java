package androidx.constraintlayout.core.dsl;

public class Transition {
    private final int DEFAULT_DURATION;
    private final float DEFAULT_STAGGER;
    final int UNSET;
    private String mConstraintSetEnd;
    private String mConstraintSetStart;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private int mDuration;
    private String mId;
    private KeyFrames mKeyFrames;
    private OnSwipe mOnSwipe;
    private float mStagger;

    public Transition(String str, String str2) {
        this.mOnSwipe = null;
        this.UNSET = -1;
        this.DEFAULT_DURATION = 400;
        this.DEFAULT_STAGGER = 0.0f;
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFrames = new KeyFrames();
        this.mId = "default";
        this.mConstraintSetStart = str;
        this.mConstraintSetEnd = str2;
    }

    public String getId() {
        return this.mId;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setFrom(String str) {
        this.mConstraintSetStart = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setKeyFrames(Keys keys) {
        this.mKeyFrames.add(keys);
    }

    public void setOnSwipe(OnSwipe onSwipe) {
        this.mOnSwipe = onSwipe;
    }

    public void setStagger(float f) {
        this.mStagger = f;
    }

    public void setTo(String str) {
        this.mConstraintSetEnd = str;
    }

    public String toJson() {
        return toString();
    }

    public String toString() {
        String str = this.mId + ":{\nfrom:'" + this.mConstraintSetStart + "',\nto:'" + this.mConstraintSetEnd + "',\n";
        if (this.mDuration != 400) {
            str = str + "duration:" + this.mDuration + ",\n";
        }
        if (this.mStagger != 0.0f) {
            str = str + "stagger:" + this.mStagger + ",\n";
        }
        if (this.mOnSwipe != null) {
            str = str + this.mOnSwipe.toString();
        }
        return (str + this.mKeyFrames.toString()) + "},\n";
    }

    public Transition(String str, String str2, String str3) {
        this.mOnSwipe = null;
        this.UNSET = -1;
        this.DEFAULT_DURATION = 400;
        this.DEFAULT_STAGGER = 0.0f;
        this.mId = null;
        this.mConstraintSetEnd = null;
        this.mConstraintSetStart = null;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFrames = new KeyFrames();
        this.mId = str;
        this.mConstraintSetStart = str2;
        this.mConstraintSetEnd = str3;
    }
}
