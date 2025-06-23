package androidx.constraintlayout.core.dsl;

/* loaded from: classes.dex */
public class OnSwipe {
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    private Mode mAutoCompleteMode;
    private Drag mDragDirection;
    private float mDragScale;
    private float mDragThreshold;
    private String mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private TouchUp mOnTouchUp;
    private String mRotationCenterId;
    private Boundary mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private String mTouchAnchorId;
    private Side mTouchAnchorSide;

    /* loaded from: classes.dex */
    public enum Boundary {
        OVERSHOOT,
        BOUNCE_START,
        BOUNCE_END,
        BOUNCE_BOTH
    }

    /* loaded from: classes.dex */
    public enum Drag {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        START,
        END,
        CLOCKWISE,
        ANTICLOCKWISE
    }

    /* loaded from: classes.dex */
    public enum Mode {
        VELOCITY,
        SPRING
    }

    /* loaded from: classes.dex */
    public enum Side {
        TOP,
        LEFT,
        RIGHT,
        BOTTOM,
        MIDDLE,
        START,
        END
    }

    /* loaded from: classes.dex */
    public enum TouchUp {
        AUTOCOMPLETE,
        TO_START,
        NEVER_COMPLETE_END,
        TO_END,
        STOP,
        DECELERATE,
        DECELERATE_COMPLETE,
        NEVER_COMPLETE_START
    }

    public OnSwipe() {
        this.mDragDirection = null;
        this.mTouchAnchorSide = null;
        this.mTouchAnchorId = null;
        this.mLimitBoundsTo = null;
        this.mOnTouchUp = null;
        this.mRotationCenterId = null;
        this.mMaxVelocity = Float.NaN;
        this.mMaxAcceleration = Float.NaN;
        this.mDragScale = Float.NaN;
        this.mDragThreshold = Float.NaN;
        this.mSpringDamping = Float.NaN;
        this.mSpringMass = Float.NaN;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = null;
        this.mAutoCompleteMode = null;
    }

    public Mode getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public Drag getDragDirection() {
        return this.mDragDirection;
    }

    public float getDragScale() {
        return this.mDragScale;
    }

    public float getDragThreshold() {
        return this.mDragThreshold;
    }

    public String getLimitBoundsTo() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public TouchUp getOnTouchUp() {
        return this.mOnTouchUp;
    }

    public String getRotationCenterId() {
        return this.mRotationCenterId;
    }

    public Boundary getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public String getTouchAnchorId() {
        return this.mTouchAnchorId;
    }

    public Side getTouchAnchorSide() {
        return this.mTouchAnchorSide;
    }

    public void setAutoCompleteMode(Mode mode) {
        this.mAutoCompleteMode = mode;
    }

    public OnSwipe setDragDirection(Drag drag) {
        this.mDragDirection = drag;
        return this;
    }

    public OnSwipe setDragScale(int i) {
        this.mDragScale = i;
        return this;
    }

    public OnSwipe setDragThreshold(int i) {
        this.mDragThreshold = i;
        return this;
    }

    public OnSwipe setLimitBoundsTo(String str) {
        this.mLimitBoundsTo = str;
        return this;
    }

    public OnSwipe setMaxAcceleration(int i) {
        this.mMaxAcceleration = i;
        return this;
    }

    public OnSwipe setMaxVelocity(int i) {
        this.mMaxVelocity = i;
        return this;
    }

    public OnSwipe setOnTouchUp(TouchUp touchUp) {
        this.mOnTouchUp = touchUp;
        return this;
    }

    public OnSwipe setRotateCenter(String str) {
        this.mRotationCenterId = str;
        return this;
    }

    public OnSwipe setSpringBoundary(Boundary boundary) {
        this.mSpringBoundary = boundary;
        return this;
    }

    public OnSwipe setSpringDamping(float f) {
        this.mSpringDamping = f;
        return this;
    }

    public OnSwipe setSpringMass(float f) {
        this.mSpringMass = f;
        return this;
    }

    public OnSwipe setSpringStiffness(float f) {
        this.mSpringStiffness = f;
        return this;
    }

    public OnSwipe setSpringStopThreshold(float f) {
        this.mSpringStopThreshold = f;
        return this;
    }

    public OnSwipe setTouchAnchorId(String str) {
        this.mTouchAnchorId = str;
        return this;
    }

    public OnSwipe setTouchAnchorSide(Side side) {
        this.mTouchAnchorSide = side;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnSwipe:{\n");
        if (this.mTouchAnchorId != null) {
            sb.append("anchor:'");
            sb.append(this.mTouchAnchorId);
            sb.append("',\n");
        }
        if (this.mDragDirection != null) {
            sb.append("direction:'");
            sb.append(this.mDragDirection.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.mTouchAnchorSide != null) {
            sb.append("side:'");
            sb.append(this.mTouchAnchorSide.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mDragScale)) {
            sb.append("scale:'");
            sb.append(this.mDragScale);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mDragThreshold)) {
            sb.append("threshold:'");
            sb.append(this.mDragThreshold);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mMaxVelocity)) {
            sb.append("maxVelocity:'");
            sb.append(this.mMaxVelocity);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mMaxAcceleration)) {
            sb.append("maxAccel:'");
            sb.append(this.mMaxAcceleration);
            sb.append("',\n");
        }
        if (this.mLimitBoundsTo != null) {
            sb.append("limitBounds:'");
            sb.append(this.mLimitBoundsTo);
            sb.append("',\n");
        }
        if (this.mAutoCompleteMode != null) {
            sb.append("mode:'");
            sb.append(this.mAutoCompleteMode.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.mOnTouchUp != null) {
            sb.append("touchUp:'");
            sb.append(this.mOnTouchUp.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mSpringMass)) {
            sb.append("springMass:'");
            sb.append(this.mSpringMass);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mSpringStiffness)) {
            sb.append("springStiffness:'");
            sb.append(this.mSpringStiffness);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mSpringDamping)) {
            sb.append("springDamping:'");
            sb.append(this.mSpringDamping);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.mSpringStopThreshold)) {
            sb.append("stopThreshold:'");
            sb.append(this.mSpringStopThreshold);
            sb.append("',\n");
        }
        if (this.mSpringBoundary != null) {
            sb.append("springBoundary:'");
            sb.append(this.mSpringBoundary);
            sb.append("',\n");
        }
        if (this.mRotationCenterId != null) {
            sb.append("around:'");
            sb.append(this.mRotationCenterId);
            sb.append("',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }

    public OnSwipe(String str, Side side, Drag drag) {
        this.mLimitBoundsTo = null;
        this.mOnTouchUp = null;
        this.mRotationCenterId = null;
        this.mMaxVelocity = Float.NaN;
        this.mMaxAcceleration = Float.NaN;
        this.mDragScale = Float.NaN;
        this.mDragThreshold = Float.NaN;
        this.mSpringDamping = Float.NaN;
        this.mSpringMass = Float.NaN;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = null;
        this.mAutoCompleteMode = null;
        this.mTouchAnchorId = str;
        this.mTouchAnchorSide = side;
        this.mDragDirection = drag;
    }
}
