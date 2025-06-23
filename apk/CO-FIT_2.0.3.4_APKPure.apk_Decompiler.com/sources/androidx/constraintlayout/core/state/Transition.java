package androidx.constraintlayout.core.state;

import XIXIX.OOXIXo;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.CookieSpecs;
import com.octopus.ad.widget.ScrollClickView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    private int mAutoTransition = 0;
    private TypedBundle mBundle = new TypedBundle();
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDuration = 400;
    private Easing mEasing = null;
    private HashMap<Integer, HashMap<String, KeyPosition>> mKeyPositions = new HashMap<>();
    private OnSwipe mOnSwipe = null;
    int mParentEndHeight;
    int mParentEndWidth;
    int mParentInterpolateHeight;
    int mParentInterpolatedWidth;
    int mParentStartHeight;
    int mParentStartWidth;
    private float mStagger = 0.0f;
    private HashMap<String, WidgetState> mState = new HashMap<>();
    final CorePixelDp mToPixel;
    boolean mWrap;

    public static class KeyPosition {
        int mFrame;
        String mTarget;
        int mType;
        float mX;
        float mY;

        public KeyPosition(String str, int i, int i2, float f, float f2) {
            this.mTarget = str;
            this.mFrame = i;
            this.mType = i2;
            this.mX = f;
            this.mY = f2;
        }
    }

    public static class OnSwipe {
        public static final int ANCHOR_SIDE_BOTTOM = 3;
        public static final int ANCHOR_SIDE_END = 6;
        public static final int ANCHOR_SIDE_LEFT = 1;
        public static final int ANCHOR_SIDE_MIDDLE = 4;
        public static final int ANCHOR_SIDE_RIGHT = 2;
        public static final int ANCHOR_SIDE_START = 5;
        public static final int ANCHOR_SIDE_TOP = 0;
        public static final String[] BOUNDARY = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        public static final int BOUNDARY_BOUNCE_BOTH = 3;
        public static final int BOUNDARY_BOUNCE_END = 2;
        public static final int BOUNDARY_BOUNCE_START = 1;
        public static final int BOUNDARY_OVERSHOOT = 0;
        public static final String[] DIRECTIONS = {"up", ScrollClickView.f4731IIX0o, "left", "right", "start", "end", "clockwise", "anticlockwise"};
        public static final int DRAG_ANTICLOCKWISE = 7;
        public static final int DRAG_CLOCKWISE = 6;
        public static final int DRAG_DOWN = 1;
        public static final int DRAG_END = 5;
        public static final int DRAG_LEFT = 2;
        public static final int DRAG_RIGHT = 3;
        public static final int DRAG_START = 4;
        public static final int DRAG_UP = 0;
        public static final String[] MODE = {"velocity", "spring"};
        public static final int MODE_CONTINUOUS_VELOCITY = 0;
        public static final int MODE_SPRING = 1;
        public static final int ON_UP_AUTOCOMPLETE = 0;
        public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
        public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
        public static final int ON_UP_DECELERATE = 4;
        public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
        public static final int ON_UP_NEVER_COMPLETE_TO_END = 7;
        public static final int ON_UP_NEVER_COMPLETE_TO_START = 6;
        public static final int ON_UP_STOP = 3;
        public static final String[] SIDES = {"top", "left", "right", "bottom", "middle", "start", "end"};
        private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
        private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        public static final String[] TOUCH_UP = {"autocomplete", "toStart", "toEnd", "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};
        String mAnchorId;
        private int mAnchorSide;
        private int mAutoCompleteMode = 0;
        private float mDestination = 0.0f;
        private int mDragDirection = 0;
        private float mDragScale = 1.0f;
        private float mDragThreshold = 10.0f;
        private boolean mDragVertical = true;
        private StopEngine mEngine;
        String mLimitBoundsTo;
        private float mMaxAcceleration = 1.2f;
        private float mMaxVelocity = 4.0f;
        private int mOnTouchUp = 0;
        private String mRotationCenterId;
        private int mSpringBoundary = 0;
        private float mSpringDamping = 10.0f;
        private float mSpringMass = 1.0f;
        private float mSpringStiffness = 400.0f;
        private float mSpringStopThreshold = 0.01f;
        private long mStart;

        public void config(float f, float f2, long j, float f3) {
            SpringStopEngine springStopEngine;
            StopLogicEngine stopLogicEngine;
            StopLogicEngine.Decelerate decelerate;
            this.mStart = j;
            float abs = Math.abs(f2);
            float f4 = this.mMaxVelocity;
            if (abs > f4) {
                f2 = Math.signum(f2) * f4;
            }
            float f5 = f2;
            float destinationPosition = getDestinationPosition(f, f5, f3);
            this.mDestination = destinationPosition;
            if (destinationPosition == f) {
                this.mEngine = null;
            } else if (this.mOnTouchUp == 4 && this.mAutoCompleteMode == 0) {
                StopEngine stopEngine = this.mEngine;
                if (stopEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) stopEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    this.mEngine = decelerate;
                }
                decelerate.config(f, this.mDestination, f5);
            } else if (this.mAutoCompleteMode == 0) {
                StopEngine stopEngine2 = this.mEngine;
                if (stopEngine2 instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) stopEngine2;
                } else {
                    stopLogicEngine = new StopLogicEngine();
                    this.mEngine = stopLogicEngine;
                }
                stopLogicEngine.config(f, this.mDestination, f5, f3, this.mMaxAcceleration, this.mMaxVelocity);
            } else {
                StopEngine stopEngine3 = this.mEngine;
                if (stopEngine3 instanceof SpringStopEngine) {
                    springStopEngine = (SpringStopEngine) stopEngine3;
                } else {
                    springStopEngine = new SpringStopEngine();
                    this.mEngine = springStopEngine;
                }
                springStopEngine.springConfig(f, this.mDestination, f5, this.mSpringMass, this.mSpringStiffness, this.mSpringDamping, this.mSpringStopThreshold, this.mSpringBoundary);
            }
        }

        public float getDestinationPosition(float f, float f2, float f3) {
            float abs = (((Math.abs(f2) * 0.5f) * f2) / this.mMaxAcceleration) + f;
            switch (this.mOnTouchUp) {
                case 1:
                    if (f >= 1.0f) {
                        return 1.0f;
                    }
                    return 0.0f;
                case 2:
                    if (f <= 0.0f) {
                        return 0.0f;
                    }
                    return 1.0f;
                case 3:
                    return Float.NaN;
                case 4:
                    return Math.max(0.0f, Math.min(1.0f, abs));
                case 5:
                    if (abs > 0.2f && abs < 0.8f) {
                        return abs;
                    }
                    if (abs > 0.5f) {
                        return 1.0f;
                    }
                    return 0.0f;
                case 6:
                    return 1.0f;
                case 7:
                    return 0.0f;
                default:
                    if (((double) abs) > 0.5d) {
                        return 1.0f;
                    }
                    return 0.0f;
            }
        }

        public float[] getDirection() {
            return TOUCH_DIRECTION[this.mDragDirection];
        }

        public float getScale() {
            return this.mDragScale;
        }

        public float[] getSide() {
            return TOUCH_SIDES[this.mAnchorSide];
        }

        public float getTouchUpProgress(long j) {
            float interpolation = this.mEngine.getInterpolation(((float) (j - this.mStart)) * 1.0E-9f);
            if (this.mEngine.isStopped()) {
                return this.mDestination;
            }
            return interpolation;
        }

        public boolean isNotDone(float f) {
            StopEngine stopEngine;
            if (this.mOnTouchUp == 3 || (stopEngine = this.mEngine) == null || stopEngine.isStopped()) {
                return false;
            }
            return true;
        }

        public void printInfo() {
            if (this.mAutoCompleteMode == 0) {
                PrintStream printStream = System.out;
                printStream.println("velocity = " + this.mEngine.getVelocity());
                printStream.println("mMaxAcceleration = " + this.mMaxAcceleration);
                printStream.println("mMaxVelocity = " + this.mMaxVelocity);
                return;
            }
            PrintStream printStream2 = System.out;
            printStream2.println("mSpringMass          = " + this.mSpringMass);
            printStream2.println("mSpringStiffness     = " + this.mSpringStiffness);
            printStream2.println("mSpringDamping       = " + this.mSpringDamping);
            printStream2.println("mSpringStopThreshold = " + this.mSpringStopThreshold);
            printStream2.println("mSpringBoundary      = " + this.mSpringBoundary);
        }

        public void setAnchorId(String str) {
            this.mAnchorId = str;
        }

        public void setAnchorSide(int i) {
            this.mAnchorSide = i;
        }

        public void setAutoCompleteMode(int i) {
            this.mAutoCompleteMode = i;
        }

        public void setDragDirection(int i) {
            boolean z;
            this.mDragDirection = i;
            if (i < 2) {
                z = true;
            } else {
                z = false;
            }
            this.mDragVertical = z;
        }

        public void setDragScale(float f) {
            if (!Float.isNaN(f)) {
                this.mDragScale = f;
            }
        }

        public void setDragThreshold(float f) {
            if (!Float.isNaN(f)) {
                this.mDragThreshold = f;
            }
        }

        public void setLimitBoundsTo(String str) {
            this.mLimitBoundsTo = str;
        }

        public void setMaxAcceleration(float f) {
            if (!Float.isNaN(f)) {
                this.mMaxAcceleration = f;
            }
        }

        public void setMaxVelocity(float f) {
            if (!Float.isNaN(f)) {
                this.mMaxVelocity = f;
            }
        }

        public void setOnTouchUp(int i) {
            this.mOnTouchUp = i;
        }

        public void setRotationCenterId(String str) {
            this.mRotationCenterId = str;
        }

        public void setSpringBoundary(int i) {
            this.mSpringBoundary = i;
        }

        public void setSpringDamping(float f) {
            if (!Float.isNaN(f)) {
                this.mSpringDamping = f;
            }
        }

        public void setSpringMass(float f) {
            if (!Float.isNaN(f)) {
                this.mSpringMass = f;
            }
        }

        public void setSpringStiffness(float f) {
            if (!Float.isNaN(f)) {
                this.mSpringStiffness = f;
            }
        }

        public void setSpringStopThreshold(float f) {
            if (!Float.isNaN(f)) {
                this.mSpringStopThreshold = f;
            }
        }
    }

    public Transition(@NonNull CorePixelDp corePixelDp) {
        this.mToPixel = corePixelDp;
    }

    private void calculateParentDimensions(float f) {
        int i = this.mParentStartWidth;
        this.mParentInterpolatedWidth = (int) (((float) i) + 0.5f + (((float) (this.mParentEndWidth - i)) * f));
        int i2 = this.mParentStartHeight;
        this.mParentInterpolateHeight = (int) (((float) i2) + 0.5f + (((float) (this.mParentEndHeight - i2)) * f));
    }

    public static Interpolator getInterpolator(int i, String str) {
        switch (i) {
            case -1:
                return new oIX0oI(str);
            case 0:
                return new II0xO0();
            case 1:
                return new I0Io();
            case 2:
                return new oxoX();
            case 3:
                return new X0o0xo();
            case 4:
                return new II0XooXoX();
            case 5:
                return new Oxx0IOOO();
            case 6:
                return new XO();
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str) {
        return this.mState.get(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$0(String str, float f) {
        return (float) Easing.getInterpolator(str).get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$1(float f) {
        return (float) Easing.getInterpolator(CookieSpecs.STANDARD).get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$2(float f) {
        return (float) Easing.getInterpolator("accelerate").get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$3(float f) {
        return (float) Easing.getInterpolator("decelerate").get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$4(float f) {
        return (float) Easing.getInterpolator("linear").get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$5(float f) {
        return (float) Easing.getInterpolator("anticipate").get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$6(float f) {
        return (float) Easing.getInterpolator("overshoot").get((double) f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getInterpolator$7(float f) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get((double) f);
    }

    public void addCustomColor(int i, String str, String str2, int i2) {
        getWidgetState(str, (ConstraintWidget) null, i).getFrame(i).addCustomColor(str2, i2);
    }

    public void addCustomFloat(int i, String str, String str2, float f) {
        getWidgetState(str, (ConstraintWidget) null, i).getFrame(i).addCustomFloat(str2, f);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
    }

    public void calcStagger() {
        boolean z;
        float f;
        float f2;
        float f3 = this.mStagger;
        if (f3 != 0.0f) {
            if (((double) f3) < OOXIXo.f29376XO) {
                z = true;
            } else {
                z = false;
            }
            float abs = Math.abs(f3);
            Iterator<String> it = this.mState.keySet().iterator();
            do {
                f = Float.MAX_VALUE;
                f2 = -3.4028235E38f;
                if (it.hasNext()) {
                } else {
                    for (String str : this.mState.keySet()) {
                        Motion motion = this.mState.get(str).mMotionControl;
                        float finalX = motion.getFinalX() + motion.getFinalY();
                        f = Math.min(f, finalX);
                        f2 = Math.max(f2, finalX);
                    }
                    for (String str2 : this.mState.keySet()) {
                        Motion motion2 = this.mState.get(str2).mMotionControl;
                        float finalX2 = motion2.getFinalX() + motion2.getFinalY();
                        float f4 = f2 - f;
                        float f5 = abs - (((finalX2 - f) * abs) / f4);
                        if (z) {
                            f5 = abs - (((f2 - finalX2) / f4) * abs);
                        }
                        motion2.setStaggerScale(1.0f / (1.0f - abs));
                        motion2.setStaggerOffset(f5);
                    }
                    return;
                }
            } while (Float.isNaN(this.mState.get(it.next()).mMotionControl.getMotionStagger()));
            for (String str3 : this.mState.keySet()) {
                float motionStagger = this.mState.get(str3).mMotionControl.getMotionStagger();
                if (!Float.isNaN(motionStagger)) {
                    f = Math.min(f, motionStagger);
                    f2 = Math.max(f2, motionStagger);
                }
            }
            for (String str4 : this.mState.keySet()) {
                Motion motion3 = this.mState.get(str4).mMotionControl;
                float motionStagger2 = motion3.getMotionStagger();
                if (!Float.isNaN(motionStagger2)) {
                    float f6 = 1.0f / (1.0f - abs);
                    float f7 = f2 - f;
                    float f8 = abs - (((motionStagger2 - f) * abs) / f7);
                    if (z) {
                        f8 = abs - (((f2 - motionStagger2) / f7) * abs);
                    }
                    motion3.setStaggerScale(f6);
                    motion3.setStaggerOffset(f8);
                }
            }
        }
    }

    public void clear() {
        this.mState.clear();
    }

    public boolean contains(String str) {
        return this.mState.containsKey(str);
    }

    public OnSwipe createOnSwipe() {
        OnSwipe onSwipe = new OnSwipe();
        this.mOnSwipe = onSwipe;
        return onSwipe;
    }

    public float dragToProgress(float f, int i, int i2, float f2, float f3) {
        WidgetState widgetState;
        float f4;
        float scale;
        float abs;
        Iterator<WidgetState> it = this.mState.values().iterator();
        if (it.hasNext()) {
            widgetState = it.next();
        } else {
            widgetState = null;
        }
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null && widgetState != null) {
            String str = onSwipe.mAnchorId;
            if (str == null) {
                float[] direction = onSwipe.getDirection();
                int i3 = widgetState.mParentHeight;
                float f5 = (float) i3;
                float f6 = (float) i3;
                float f7 = direction[0];
                if (f7 != 0.0f) {
                    f4 = (f2 * Math.abs(f7)) / f5;
                } else {
                    f4 = (f3 * Math.abs(direction[1])) / f6;
                }
                scale = this.mOnSwipe.getScale();
            } else {
                WidgetState widgetState2 = this.mState.get(str);
                float[] direction2 = this.mOnSwipe.getDirection();
                float[] side = this.mOnSwipe.getSide();
                float[] fArr = new float[2];
                widgetState2.interpolate(i, i2, f, this);
                widgetState2.mMotionControl.getDpDt(f, side[0], side[1], fArr);
                float f8 = direction2[0];
                if (f8 != 0.0f) {
                    abs = (f2 * Math.abs(f8)) / fArr[0];
                } else {
                    abs = (f3 * Math.abs(direction2[1])) / fArr[1];
                }
                scale = this.mOnSwipe.getScale();
            }
            return f4 * scale;
        } else if (widgetState != null) {
            return (-f3) / ((float) widgetState.mParentHeight);
        } else {
            return 1.0f;
        }
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i2));
            if (!(hashMap == null || (keyPosition = (KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                fArr[i] = keyPosition.mX;
                fArr2[i] = keyPosition.mY;
                fArr3[i] = (float) keyPosition.mFrame;
                i++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i <= 100) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i >= 0) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mEnd;
    }

    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mInterpolated;
    }

    public int getInterpolatedHeight() {
        return this.mParentInterpolateHeight;
    }

    public int getInterpolatedWidth() {
        return this.mParentInterpolatedWidth;
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.mState.get(str).mMotionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, (ConstraintWidget) null, 0).mMotionControl;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i = 0;
        for (int i2 = 0; i2 <= 100; i2++) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i2));
            if (!(hashMap == null || ((KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                i++;
            }
        }
        return i;
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.mState.get(str).mMotionControl.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mStart;
    }

    public float getTouchUpProgress(long j) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            return onSwipe.getTouchUpProgress(j);
        }
        return 0.0f;
    }

    public boolean hasOnSwipe() {
        if (this.mOnSwipe != null) {
            return true;
        }
        return false;
    }

    public boolean hasPositionKeyframes() {
        if (this.mKeyPositions.size() > 0) {
            return true;
        }
        return false;
    }

    public void interpolate(int i, int i2, float f) {
        if (this.mWrap) {
            calculateParentDimensions(f);
        }
        Easing easing = this.mEasing;
        if (easing != null) {
            f = (float) easing.get((double) f);
        }
        for (String str : this.mState.keySet()) {
            this.mState.get(str).interpolate(i, i2, f, this);
        }
    }

    public boolean isEmpty() {
        return this.mState.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFirstDownAccepted(float f, float f2) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe == null) {
            return false;
        }
        String str = onSwipe.mLimitBoundsTo;
        if (str == null) {
            return true;
        }
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame frame = widgetState.getFrame(2);
        if (f < ((float) frame.left) || f >= ((float) frame.right) || f2 < ((float) frame.top) || f2 >= ((float) frame.bottom)) {
            return false;
        }
        return true;
    }

    public boolean isTouchNotDone(float f) {
        return this.mOnSwipe.isNotDone(f);
    }

    public void resetProperties() {
        this.mOnSwipe = null;
        this.mBundle.clear();
    }

    public void setTouchUp(float f, long j, float f2, float f3) {
        float f4;
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            float[] fArr = new float[2];
            float[] direction = this.mOnSwipe.getDirection();
            float[] side = this.mOnSwipe.getSide();
            float f5 = f;
            this.mState.get(onSwipe.mAnchorId).mMotionControl.getDpDt(f, side[0], side[1], fArr);
            if (((double) Math.abs((direction[0] * fArr[0]) + (direction[1] * fArr[1]))) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            if (direction[0] != 0.0f) {
                f4 = f2 / fArr[0];
            } else {
                f4 = f3 / fArr[1];
            }
            this.mOnSwipe.config(f, f4 * this.mOnSwipe.getScale(), j, ((float) this.mDuration) * 0.001f);
        }
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.mBundle);
        typedBundle.applyDelta((TypedValues) this);
    }

    public boolean setValue(int i, int i2) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        boolean z;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = true;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z = true;
        } else {
            z = false;
        }
        this.mWrap = z;
        if (dimensionBehaviourArr[1] != dimensionBehaviour2) {
            z2 = false;
        }
        this.mWrap = z | z2;
        if (i == 0) {
            int width = constraintWidgetContainer.getWidth();
            this.mParentStartWidth = width;
            this.mParentInterpolatedWidth = width;
            int height = constraintWidgetContainer.getHeight();
            this.mParentStartHeight = height;
            this.mParentInterpolateHeight = height;
        } else {
            this.mParentEndWidth = constraintWidgetContainer.getWidth();
            this.mParentEndHeight = constraintWidgetContainer.getHeight();
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = children.get(i2);
            WidgetState widgetState = getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, i);
            widgetStateArr[i2] = widgetState;
            widgetState.update(constraintWidget, i);
            String pathRelativeId = widgetState.getPathRelativeId();
            if (pathRelativeId != null) {
                widgetState.setPathRelative(getWidgetState(pathRelativeId, (ConstraintWidget) null, i));
            }
        }
        calcStagger();
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyAttribute(typedBundle, customVariableArr);
    }

    public void addKeyPosition(String str, int i, int i2, float f, float f2) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(510, 2);
        typedBundle.add(100, i);
        typedBundle.add(506, f);
        typedBundle.add(507, f2);
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i, i2, f, f2);
        HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.mKeyPositions.put(Integer.valueOf(i), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    public WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.mBundle.applyDelta((TypedValues) widgetState.mMotionControl);
            widgetState.mMotionWidgetStart.updateMotion(widgetState.mMotionControl);
            this.mState.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i);
            }
        }
        return widgetState;
    }

    public boolean setValue(int i, boolean z) {
        return false;
    }

    public static class WidgetState {
        WidgetFrame mEnd = new WidgetFrame();
        WidgetFrame mInterpolated = new WidgetFrame();
        KeyCache mKeyCache = new KeyCache();
        Motion mMotionControl;
        MotionWidget mMotionWidgetEnd = new MotionWidget(this.mEnd);
        MotionWidget mMotionWidgetInterpolated = new MotionWidget(this.mInterpolated);
        MotionWidget mMotionWidgetStart = new MotionWidget(this.mStart);
        boolean mNeedSetup = true;
        int mParentHeight = -1;
        int mParentWidth = -1;
        WidgetFrame mStart = new WidgetFrame();

        public WidgetState() {
            Motion motion = new Motion(this.mMotionWidgetStart);
            this.mMotionControl = motion;
            motion.setStart(this.mMotionWidgetStart);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
        }

        public WidgetFrame getFrame(int i) {
            if (i == 0) {
                return this.mStart;
            }
            if (i == 1) {
                return this.mEnd;
            }
            return this.mInterpolated;
        }

        public String getPathRelativeId() {
            return this.mMotionControl.getAnimateRelativeTo();
        }

        public void interpolate(int i, int i2, float f, Transition transition) {
            this.mParentHeight = i2;
            this.mParentWidth = i;
            if (this.mNeedSetup) {
                this.mMotionControl.setup(i, i2, 1.0f, System.nanoTime());
                this.mNeedSetup = false;
            }
            WidgetFrame.interpolate(i, i2, this.mInterpolated, this.mStart, this.mEnd, transition, f);
            this.mInterpolated.interpolatedPos = f;
            this.mMotionControl.interpolate(this.mMotionWidgetInterpolated, f, System.nanoTime(), this.mKeyCache);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta((TypedValues) motionKeyAttributes);
            this.mMotionControl.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta((TypedValues) motionKeyCycle);
            this.mMotionControl.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta((TypedValues) motionKeyPosition);
            this.mMotionControl.addKey(motionKeyPosition);
        }

        public void setPathRelative(WidgetState widgetState) {
            this.mMotionControl.setupRelative(widgetState.mMotionControl);
        }

        public void update(ConstraintWidget constraintWidget, int i) {
            if (i == 0) {
                this.mStart.update(constraintWidget);
                MotionWidget motionWidget = this.mMotionWidgetStart;
                motionWidget.updateMotion(motionWidget);
                this.mMotionControl.setStart(this.mMotionWidgetStart);
                this.mNeedSetup = true;
            } else if (i == 1) {
                this.mEnd.update(constraintWidget);
                this.mMotionControl.setEnd(this.mMotionWidgetEnd);
                this.mNeedSetup = true;
            }
            this.mParentWidth = -1;
        }

        public void setKeyAttribute(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta((TypedValues) motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i = 0; i < customVariableArr.length; i++) {
                    motionKeyAttributes.mCustom.put(customVariableArr[i].getName(), customVariableArr[i]);
                }
            }
            this.mMotionControl.addKey(motionKeyAttributes);
        }
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 1).mEnd;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 2).mInterpolated;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 0).mStart;
    }

    public boolean setValue(int i, float f) {
        if (i != 706) {
            return false;
        }
        this.mStagger = f;
        return false;
    }

    public boolean setValue(int i, String str) {
        if (i != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }
}
