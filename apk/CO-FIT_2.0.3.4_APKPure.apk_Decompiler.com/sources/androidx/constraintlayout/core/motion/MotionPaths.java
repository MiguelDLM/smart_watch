package androidx.constraintlayout.core.motion;

import XIXIX.OOXIXo;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {RequestParameters.POSITION, "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    String mAnimateRelativeTo = null;
    HashMap<String, CustomVariable> mCustomAttributes = new HashMap<>();
    int mDrawPath = 0;
    float mHeight;
    public String mId;
    Easing mKeyFrameEasing;
    int mMode = 0;
    int mPathMotionArc = -1;
    float mPathRotate = Float.NaN;
    float mPosition;
    float mProgress = Float.NaN;
    float mRelativeAngle = Float.NaN;
    Motion mRelativeToController = null;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    float mTime;
    float mWidth;
    float mX;
    float mY;

    public MotionPaths() {
    }

    private boolean diff(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            if (Float.isNaN(f) != Float.isNaN(f2)) {
                return true;
            }
            return false;
        } else if (Math.abs(f - f2) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    private static float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public void applyParameters(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.mMotion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.mMotion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.mPropertySet.mProgress;
        WidgetFrame widgetFrame = motionWidget.mWidgetFrame;
        if (!(widgetFrame == null || (constraintWidget = widgetFrame.widget) == null)) {
            this.mRelativeAngle = constraintWidget.mCircleConstraintAngle;
        }
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomAttributes.put(next, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos((double) this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean z2;
        boolean diff = diff(this.mX, motionPaths.mX);
        boolean diff2 = diff(this.mY, motionPaths.mY);
        boolean z3 = false;
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z4 = zArr[1];
        if (diff || diff2 || z) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[1] = z4 | z2;
        boolean z5 = zArr[2];
        if (diff || diff2 || z) {
            z3 = true;
        }
        zArr[2] = z5 | z3;
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = (double) fArr[i2];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mWidth;
        float f2 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f = this.mX;
        float f2 = this.mY;
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = (double) f6;
            double d3 = (double) f;
            double d4 = (double) f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - ((double) (f3 / 2.0f)));
            f2 = (float) ((((double) f7) - (d3 * Math.cos(d4))) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f = this.mX;
        float f2 = this.mY;
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = (double) f6;
            double d3 = (double) f;
            double d4 = (double) f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - ((double) (f3 / 2.0f)));
            f2 = (float) ((((double) f7) - (d3 * Math.cos(d4))) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = (double) customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i2 < numberOfInterpolatedValues) {
            dArr[i] = (double) fArr[i2];
            i2++;
            i++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mX;
        float f2 = this.mY;
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            double d = (double) f;
            double d2 = (double) f2;
            f2 = (float) ((((double) this.mRelativeToController.getCenterY()) - (d * Math.cos(d2))) - ((double) (f4 / 2.0f)));
            f = (float) ((((double) centerX) + (Math.sin(d2) * d)) - ((double) (f3 / 2.0f)));
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = f2 + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = f2 + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        int i4 = i + 6;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i4] = f + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mCustomAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f5 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f5;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f5;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f5;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f6 = motionPaths4.mWidth;
        float f7 = motionPaths3.mWidth;
        float f8 = motionPaths4.mHeight;
        float f9 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f10 = motionPaths3.mX;
        float f11 = motionPaths3.mY;
        float f12 = motionPaths4.mX + (f6 / 2.0f);
        float f13 = f12 - ((f7 / 2.0f) + f10);
        float f14 = (motionPaths4.mY + (f8 / 2.0f)) - (f11 + (f9 / 2.0f));
        float f15 = (f6 - f7) * f;
        float f16 = f15 / 2.0f;
        this.mX = (float) ((int) ((f10 + (f13 * f5)) - f16));
        float f17 = (f8 - f9) * f2;
        float f18 = f17 / 2.0f;
        this.mY = (float) ((int) ((f11 + (f14 * f5)) - f18));
        this.mWidth = (float) ((int) (f7 + f15));
        this.mHeight = (float) ((int) (f9 + f17));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentX)) {
            f3 = f5;
        } else {
            f3 = motionKeyPosition3.mPercentX;
        }
        float f19 = 0.0f;
        if (Float.isNaN(motionKeyPosition3.mAltPercentY)) {
            f4 = 0.0f;
        } else {
            f4 = motionKeyPosition3.mAltPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            f5 = motionKeyPosition3.mPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mAltPercentX)) {
            f19 = motionKeyPosition3.mAltPercentX;
        }
        this.mMode = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.mX = (float) ((int) (((motionPaths5.mX + (f3 * f13)) + (f19 * f14)) - f16));
        this.mY = (float) ((int) (((motionPaths5.mY + (f13 * f4)) + (f14 * f5)) - f18));
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f4 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f4;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f4;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f4;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f5 = motionPaths4.mWidth - motionPaths3.mWidth;
        float f6 = motionPaths4.mHeight - motionPaths3.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(motionKeyPosition2.mPercentX)) {
            f4 = motionKeyPosition2.mPercentX;
        }
        float f7 = motionPaths3.mX;
        float f8 = motionPaths3.mWidth;
        float f9 = motionPaths3.mY;
        float f10 = motionPaths3.mHeight;
        float f11 = motionPaths4.mX + (motionPaths4.mWidth / 2.0f);
        float f12 = f11 - ((f8 / 2.0f) + f7);
        float f13 = (motionPaths4.mY + (motionPaths4.mHeight / 2.0f)) - ((f10 / 2.0f) + f9);
        float f14 = f12 * f4;
        float f15 = f5 * f;
        float f16 = f15 / 2.0f;
        this.mX = (float) ((int) ((f7 + f14) - f16));
        float f17 = f4 * f13;
        float f18 = f6 * f2;
        float f19 = f18 / 2.0f;
        this.mY = (float) ((int) ((f9 + f17) - f19));
        this.mWidth = (float) ((int) (f8 + f15));
        this.mHeight = (float) ((int) (f10 + f18));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentY)) {
            f3 = 0.0f;
        } else {
            f3 = motionKeyPosition3.mPercentY;
        }
        float f20 = (-f13) * f3;
        float f21 = f12 * f3;
        this.mMode = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.mX = ((float) ((int) ((motionPaths5.mX + f14) - f16))) + f20;
        this.mY = ((float) ((int) ((motionPaths5.mY + f17) - f19))) + f21;
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7 = ((float) motionKeyPosition.mFramePosition) / 100.0f;
        this.mTime = f7;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        if (Float.isNaN(motionKeyPosition.mPercentWidth)) {
            f = f7;
        } else {
            f = motionKeyPosition.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition.mPercentHeight)) {
            f2 = f7;
        } else {
            f2 = motionKeyPosition.mPercentHeight;
        }
        float f8 = motionPaths2.mWidth;
        float f9 = motionPaths.mWidth;
        float f10 = motionPaths2.mHeight;
        float f11 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (float) ((int) (f9 + ((f8 - f9) * f)));
        this.mHeight = (float) ((int) (f11 + ((f10 - f11) * f2)));
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f3 = f7;
            } else {
                f3 = motionKeyPosition.mPercentX;
            }
            float f12 = motionPaths2.mX;
            float f13 = motionPaths.mX;
            this.mX = (f3 * (f12 - f13)) + f13;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f7 = motionKeyPosition.mPercentY;
            }
            float f14 = motionPaths2.mY;
            float f15 = motionPaths.mY;
            this.mY = (f7 * (f14 - f15)) + f15;
        } else if (i3 != 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f6 = f7;
            } else {
                f6 = motionKeyPosition.mPercentX;
            }
            float f16 = motionPaths2.mX;
            float f17 = motionPaths.mX;
            this.mX = (f6 * (f16 - f17)) + f17;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f7 = motionKeyPosition.mPercentY;
            }
            float f18 = motionPaths2.mY;
            float f19 = motionPaths.mY;
            this.mY = (f7 * (f18 - f19)) + f19;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f20 = motionPaths2.mX;
                float f21 = motionPaths.mX;
                f4 = ((f20 - f21) * f7) + f21;
            } else {
                f4 = Math.min(f2, f) * motionKeyPosition.mPercentX;
            }
            this.mX = f4;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f22 = motionPaths2.mY;
                float f23 = motionPaths.mY;
                f5 = (f7 * (f22 - f23)) + f23;
            } else {
                f5 = motionKeyPosition.mPercentY;
            }
            this.mY = f5;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f3 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f3;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f3;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f3;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f4 = motionPaths4.mWidth;
        float f5 = motionPaths3.mWidth;
        float f6 = motionPaths4.mHeight;
        float f7 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f8 = motionPaths3.mX;
        float f9 = motionPaths3.mY;
        float f10 = motionPaths4.mX + (f4 / 2.0f);
        float f11 = motionPaths4.mY + (f6 / 2.0f);
        float f12 = (f4 - f5) * f;
        this.mX = (float) ((int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f3)) - (f12 / 2.0f)));
        float f13 = (f6 - f7) * f2;
        this.mY = (float) ((int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f3)) - (f13 / 2.0f)));
        this.mWidth = (float) ((int) (f5 + f12));
        this.mHeight = (float) ((int) (f7 + f13));
        this.mMode = 2;
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (!Float.isNaN(motionKeyPosition3.mPercentX)) {
            this.mX = (float) ((int) (motionKeyPosition3.mPercentX * ((float) (i - ((int) this.mWidth)))));
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            this.mY = (float) ((int) (motionKeyPosition3.mPercentY * ((float) (i2 - ((int) this.mHeight)))));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.mX = f;
        this.mY = f2;
        this.mWidth = f3;
        this.mHeight = f4;
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f7 = (float) dArr[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    public void setView(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        float f3;
        MotionWidget motionWidget2 = motionWidget;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f4 = this.mX;
        float f5 = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        if (iArr2.length != 0 && this.mTempValue.length <= iArr2[iArr2.length - 1]) {
            int i = iArr2[iArr2.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            double[] dArr5 = this.mTempValue;
            int i3 = iArr2[i2];
            dArr5[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr4[i2];
        }
        float f8 = Float.NaN;
        int i4 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr6 = this.mTempValue;
            if (i4 >= dArr6.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr6[i4]);
            double d = OOXIXo.f29376XO;
            if (!isNaN || !(dArr3 == null || dArr3[i4] == OOXIXo.f29376XO)) {
                if (dArr3 != null) {
                    d = dArr3[i4];
                }
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d = this.mTempValue[i4] + d;
                }
                f3 = f8;
                float f13 = (float) d;
                float f14 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i4 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i4 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i4 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i4 == 5) {
                    f8 = f13;
                }
                i4++;
                double[] dArr7 = dArr2;
            } else {
                f3 = f8;
            }
            f8 = f3;
            i4++;
            double[] dArr72 = dArr2;
        }
        float f15 = f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter((double) f, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = (double) f4;
            double d3 = (double) f5;
            double sin = ((double) f16) + (Math.sin(d3) * d2);
            f2 = f7;
            float f20 = (float) (sin - ((double) (f6 / 2.0f)));
            float cos = (float) ((((double) f17) - (Math.cos(d3) * d2)) - ((double) (f7 / 2.0f)));
            double d4 = (double) f9;
            double d5 = (double) f10;
            float sin2 = (float) (((double) f18) + (Math.sin(d3) * d4) + (Math.cos(d3) * d2 * d5));
            float f21 = f20;
            float cos2 = (float) ((((double) f19) - (d4 * Math.cos(d3))) + (d2 * Math.sin(d3) * d5));
            double[] dArr8 = dArr2;
            if (dArr8.length >= 2) {
                dArr8[0] = (double) sin2;
                dArr8[1] = (double) cos2;
            }
            if (!Float.isNaN(f15)) {
                motionWidget2.setRotationZ((float) (((double) f15) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f4 = f21;
            f5 = cos;
        } else {
            float f22 = f15;
            f2 = f7;
            if (!Float.isNaN(f22)) {
                motionWidget2.setRotationZ(((float) (((double) f22) + Math.toDegrees(Math.atan2((double) (f10 + (f12 / 2.0f)), (double) (f9 + (f11 / 2.0f)))))) + 0.0f);
            }
        }
        float f23 = f4 + 0.5f;
        float f24 = f5 + 0.5f;
        motionWidget2.layout((int) f23, (int) f24, (int) (f23 + f6), (int) (f24 + f2));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (double) (((this.mX + (this.mWidth / 2.0f)) - motionPaths.mX) - (motionPaths.mWidth / 2.0f));
        double d2 = (double) (((this.mY + (this.mHeight / 2.0f)) - motionPaths.mY) - (motionPaths.mHeight / 2.0f));
        this.mRelativeToController = motion;
        this.mX = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians((double) this.mRelativeAngle);
        }
    }

    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        if (motionPaths.mAnimateRelativeTo != null) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        int[] iArr2 = iArr;
        float f2 = this.mX;
        float f3 = this.mY;
        float f4 = this.mWidth;
        float f5 = this.mHeight;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f10 = (float) dArr[i];
            float f11 = (float) dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f2 = f10;
                f6 = f11;
            } else if (i2 == 2) {
                f3 = f10;
                f8 = f11;
            } else if (i2 == 3) {
                f4 = f10;
                f7 = f11;
            } else if (i2 == 4) {
                f5 = f10;
                f9 = f11;
            }
        }
        float f12 = 2.0f;
        float f13 = (f7 / 2.0f) + f6;
        float f14 = (f9 / 2.0f) + f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f15 = fArr3[0];
            float f16 = fArr3[1];
            float f17 = fArr4[0];
            double d2 = (double) f2;
            float f18 = fArr4[1];
            double d3 = (double) f3;
            f = f4;
            double d4 = (double) f6;
            double d5 = (double) f8;
            float sin = (float) (((double) f17) + (Math.sin(d3) * d4) + (Math.cos(d3) * d5));
            f14 = (float) ((((double) f18) - (d4 * Math.cos(d3))) + (Math.sin(d3) * d5));
            f13 = sin;
            f2 = (float) ((((double) f15) + (Math.sin(d3) * d2)) - ((double) (f4 / 2.0f)));
            f3 = (float) ((((double) f16) - (d2 * Math.cos(d3))) - ((double) (f5 / 2.0f)));
            f12 = 2.0f;
        } else {
            f = f4;
        }
        fArr[0] = f2 + (f / f12) + 0.0f;
        fArr[1] = f3 + (f5 / f12) + 0.0f;
        fArr2[0] = f13;
        fArr2[1] = f14;
    }
}
