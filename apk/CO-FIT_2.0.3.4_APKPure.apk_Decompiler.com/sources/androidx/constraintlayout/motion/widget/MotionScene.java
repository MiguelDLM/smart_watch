package androidx.constraintlayout.motion.widget;

import XIXIX.OOXIXo;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o0oIxXOx.XIxXXX0x0;
import org.apache.commons.text.oIX0oI;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    Transition mCurrentTransition = null;
    /* access modifiers changed from: private */
    public int mDefaultDuration = 400;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch = false;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    /* access modifiers changed from: private */
    public int mLayoutDuringTransition = 0;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    StateSet mStateSet = null;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i = -1;
        }
        if (i != -1) {
            return i;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        return i;
    }

    private int getIndex(Transition transition) {
        int access$300 = transition.mId;
        if (access$300 != -1) {
            for (int i = 0; i < this.mTransitionList.size(); i++) {
                if (this.mTransitionList.get(i).mId == access$300) {
                    return i;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    public static String getLine(Context context, int i, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) {
            return i;
        }
        return stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "MotionScene"
            android.content.res.Resources r2 = r10.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r11)
            int r3 = r2.getEventType()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4 = 0
        L_0x0011:
            r5 = 1
            if (r3 == r5) goto L_0x0180
            r6 = 2
            if (r3 == r6) goto L_0x0019
            goto L_0x0155
        L_0x0019:
            java.lang.String r3 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r7 = r3.hashCode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r8 = -1
            switch(r7) {
                case -1349929691: goto L_0x0087;
                case -1239391468: goto L_0x007c;
                case -687739768: goto L_0x0072;
                case 61998586: goto L_0x0067;
                case 269306229: goto L_0x005e;
                case 312750793: goto L_0x0054;
                case 327855227: goto L_0x004a;
                case 793277014: goto L_0x0042;
                case 1382829617: goto L_0x0038;
                case 1942574248: goto L_0x0027;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0025:
            goto L_0x0091
        L_0x0027:
            java.lang.String r5 = "include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 6
            goto L_0x0092
        L_0x0032:
            r10 = move-exception
            goto L_0x015b
        L_0x0035:
            r10 = move-exception
            goto L_0x016e
        L_0x0038:
            java.lang.String r5 = "StateSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 4
            goto L_0x0092
        L_0x0042:
            boolean r3 = r3.equals(r1)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 0
            goto L_0x0092
        L_0x004a:
            java.lang.String r5 = "OnSwipe"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 2
            goto L_0x0092
        L_0x0054:
            java.lang.String r5 = "OnClick"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 3
            goto L_0x0092
        L_0x005e:
            java.lang.String r6 = "Transition"
            boolean r3 = r3.equals(r6)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0067:
            java.lang.String r5 = "ViewTransition"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 9
            goto L_0x0092
        L_0x0072:
            java.lang.String r5 = "Include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 7
            goto L_0x0092
        L_0x007c:
            java.lang.String r5 = "KeyFrameSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 8
            goto L_0x0092
        L_0x0087:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 5
            goto L_0x0092
        L_0x0091:
            r5 = -1
        L_0x0092:
            switch(r5) {
                case 0: goto L_0x0152;
                case 1: goto L_0x0111;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00b8;
                case 6: goto L_0x00b3;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0097;
                default: goto L_0x0095;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0095:
            goto L_0x0155
        L_0x0097:
            androidx.constraintlayout.motion.widget.ViewTransition r3 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r5 = r9.mViewTransitionController     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00a3:
            androidx.constraintlayout.motion.widget.KeyFrames r3 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r4 == 0) goto L_0x0155
            java.util.ArrayList r5 = r4.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b3:
            r9.parseInclude((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b8:
            r9.parseConstraintSet(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00bd:
            androidx.constraintlayout.widget.StateSet r3 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r9.mStateSet = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00c6:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r3 = r3.isInEditMode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0155
            r4.addOnClick((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00d5:
            if (r4 != 0) goto L_0x0104
            android.content.res.Resources r3 = r10.getResources()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r3.getResourceEntryName(r11)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r5 = r2.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r7 = " OnSwipe ("
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ".xml:"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ")"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            android.util.Log.v(r1, r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0104:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.TouchResponse r3 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r5, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r4.mTouchResponse = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0111:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4.<init>(r9, r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            r9.mCurrentTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r4.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0138
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r5 = r9.mRtl     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.setRTL(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0138:
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0155
            int r3 = r4.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != r8) goto L_0x0147
            r9.mDefaultTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x014c
        L_0x0147:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x014c:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.remove(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0152:
            r9.parseMotionSceneTags(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0155:
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0011
        L_0x015b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
            goto L_0x0180
        L_0x016e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseConstraintSet(android.content.Context r18, org.xmlpull.v1.XmlPullParser r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            androidx.constraintlayout.widget.ConstraintSet r7 = new androidx.constraintlayout.widget.ConstraintSet
            r7.<init>()
            r8 = 0
            r7.setForceId(r8)
            int r9 = r19.getAttributeCount()
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x001a:
            if (r11 >= r9) goto L_0x00e5
            java.lang.String r14 = r2.getAttributeName(r11)
            java.lang.String r15 = r2.getAttributeValue(r11)
            r14.hashCode()
            int r16 = r14.hashCode()
            switch(r16) {
                case -1496482599: goto L_0x0051;
                case -1153153640: goto L_0x0046;
                case 3355: goto L_0x003b;
                case 973381616: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            r10 = -1
            goto L_0x005b
        L_0x0030:
            java.lang.String r10 = "stateLabels"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r10 = 3
            goto L_0x005b
        L_0x003b:
            java.lang.String r10 = "id"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            r10 = 2
            goto L_0x005b
        L_0x0046:
            java.lang.String r10 = "constraintRotate"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x004f
            goto L_0x002e
        L_0x004f:
            r10 = 1
            goto L_0x005b
        L_0x0051:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x005a
            goto L_0x002e
        L_0x005a:
            r10 = 0
        L_0x005b:
            switch(r10) {
                case 0: goto L_0x00de;
                case 1: goto L_0x007e;
                case 2: goto L_0x0065;
                case 3: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x00e2
        L_0x0060:
            r7.setStateLabels(r15)
            goto L_0x00e2
        L_0x0065:
            int r12 = r0.getId(r1, r15)
            java.util.HashMap<java.lang.String, java.lang.Integer> r10 = r0.mConstraintSetIdMap
            java.lang.String r14 = stripID(r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r12)
            r10.put(r14, r15)
            java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getName((android.content.Context) r1, (int) r12)
            r7.mIdString = r10
            goto L_0x00e2
        L_0x007e:
            int r10 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x0086 }
            r7.mRotate = r10     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x00e2
        L_0x0086:
            r15.hashCode()
            int r10 = r15.hashCode()
            switch(r10) {
                case -768416914: goto L_0x00c0;
                case 3317767: goto L_0x00b5;
                case 3387192: goto L_0x00aa;
                case 108511772: goto L_0x009f;
                case 1954540437: goto L_0x0093;
                default: goto L_0x0091;
            }
        L_0x0091:
            r10 = -1
            goto L_0x00cb
        L_0x0093:
            java.lang.String r10 = "x_right"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x009d
            goto L_0x0091
        L_0x009d:
            r10 = 4
            goto L_0x00cb
        L_0x009f:
            java.lang.String r10 = "right"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00a8
            goto L_0x0091
        L_0x00a8:
            r10 = 3
            goto L_0x00cb
        L_0x00aa:
            java.lang.String r10 = "none"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00b3
            goto L_0x0091
        L_0x00b3:
            r10 = 2
            goto L_0x00cb
        L_0x00b5:
            java.lang.String r10 = "left"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00be
            goto L_0x0091
        L_0x00be:
            r10 = 1
            goto L_0x00cb
        L_0x00c0:
            java.lang.String r10 = "x_left"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00ca
            goto L_0x0091
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            switch(r10) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00d8;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00cf;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            goto L_0x00e2
        L_0x00cf:
            r7.mRotate = r4
            goto L_0x00e2
        L_0x00d2:
            r7.mRotate = r6
            goto L_0x00e2
        L_0x00d5:
            r7.mRotate = r8
            goto L_0x00e2
        L_0x00d8:
            r7.mRotate = r5
            goto L_0x00e2
        L_0x00db:
            r7.mRotate = r3
            goto L_0x00e2
        L_0x00de:
            int r13 = r0.getId(r1, r15)
        L_0x00e2:
            int r11 = r11 + r6
            goto L_0x001a
        L_0x00e5:
            r10 = -1
            if (r12 == r10) goto L_0x0100
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            int r3 = r3.mDebugPath
            if (r3 == 0) goto L_0x00f1
            r7.setValidateOnParse(r6)
        L_0x00f1:
            r7.load((android.content.Context) r1, (org.xmlpull.v1.XmlPullParser) r2)
            if (r13 == r10) goto L_0x00fb
            android.util.SparseIntArray r1 = r0.mDeriveMap
            r1.put(r12, r13)
        L_0x00fb:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r1 = r0.mConstraintSetMap
            r1.put(r12, r7)
        L_0x0100:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i2 = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i2;
                if (i2 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
        constraintSet.derivedState = constraintSet.mIdString;
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(i2, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i2));
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback((ConstraintLayout) motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                Iterator it2 = next.mOnClicks.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.mOnClicks.size() > 0) {
                Iterator it4 = next2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.mOnClicks.size() > 0) {
                Iterator it6 = next3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.mOnClicks.size() > 0) {
                Iterator it8 = next4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i, motionController);
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0 && ((transition = this.mCurrentTransition) != next || !transition.isTransitionFlag(2))) {
                if (i == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                } else if (i == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        RectF limitBoundsTo;
        float f3;
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        if (i2 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i);
        RectF rectF = new RectF();
        float f6 = 0.0f;
        Transition transition = null;
        for (Transition next : transitionsWithState) {
            if (!next.mDisable && next.mTouchResponse != null) {
                next.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = next.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if ((touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && ((limitBoundsTo = next.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF)) == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float dot = next.mTouchResponse.dot(f4, f5);
                    if (next.mTouchResponse.mIsRotateMode && motionEvent != null) {
                        float x = motionEvent.getX() - next.mTouchResponse.mRotateCenterX;
                        float y = motionEvent.getY() - next.mTouchResponse.mRotateCenterY;
                        dot = ((float) (Math.atan2((double) (f5 + y), (double) (f4 + x)) - Math.atan2((double) x, (double) y))) * 10.0f;
                    }
                    if (next.mConstraintSetEnd == i2) {
                        f3 = -1.0f;
                    } else {
                        f3 = 1.1f;
                    }
                    float f7 = dot * f3;
                    if (f7 > f6) {
                        transition = next;
                        f6 = f7;
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z) {
        this.mDisableAutoTransition = z;
    }

    public void enableViewTransition(int i, boolean z) {
        this.mViewTransitionController.enableViewTransition(i, z);
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public int getAutoCompleteMode() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getAutoCompleteMode();
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            if (str.equals(context.getResources().getResourceName(keyAt))) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int access$1500 = this.mCurrentTransition.mDefaultInterpolator;
        if (access$1500 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (access$1500 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f) {
                    return (float) interpolator.get((double) f);
                }
            };
        } else if (access$1500 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (access$1500 == 1) {
                return new AccelerateInterpolator();
            }
            if (access$1500 == 2) {
                return new DecelerateInterpolator();
            }
            if (access$1500 == 4) {
                return new BounceInterpolator();
            }
            if (access$1500 == 5) {
                return new OvershootInterpolator();
            }
            if (access$1500 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            Iterator<Integer> it2 = keyFrames.getKeys().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Integer next = it2.next();
                    if (i2 == next.intValue()) {
                        Iterator<Key> it3 = keyFrames.getKeyFramesForView(next.intValue()).iterator();
                        while (it3.hasNext()) {
                            Key next2 = it3.next();
                            if (next2.mFramePosition == i3 && next2.mType == i) {
                                return next2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it = transition2.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator it2 = transition.mKeyFramesList.iterator();
        while (it2.hasNext()) {
            ((KeyFrames) it2.next()).addFrames(motionController);
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintSet valueAt = this.mConstraintSetMap.valueAt(i2);
            int keyAt = this.mConstraintSetMap.keyAt(i2);
            if (valueAt.matchesLabels(strArr)) {
                valueAt.getStateLabels();
                iArr[i] = keyAt;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    public float getProgressDirection(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f, f2);
    }

    public int getSpringBoundary() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringBoundary();
    }

    public float getSpringDamping() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringDamping();
    }

    public float getSpringMass() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringMass();
    }

    public float getSpringStiffiness() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStiffness();
    }

    public float getSpringStopThreshold() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i) {
                return next;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mConstraintSetStart == i) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int i) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().mFramePosition == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i) {
        return this.mViewTransitionController.isViewTransitionEnabled(i);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry next : this.mConstraintSetIdMap.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null && num.intValue() == i) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void processScrollMove(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollMove(f, f2);
        }
    }

    public void processScrollUp(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollUp(f, f2);
        }
    }

    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo == null || limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                        return;
                    }
                    this.mLastTouchDown = null;
                    this.mIgnoreTouch = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((((double) rawX) != OOXIXo.f29376XO || ((double) rawY) != OOXIXo.f29376XO) && (motionEvent2 = this.mLastTouchDown) != null) {
                    Transition bestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z = true;
                        }
                        this.mMotionOutsideRegion = z;
                        this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.mIgnoreTouch) {
            Transition transition = this.mCurrentTransition;
            if (!(transition == null || transition.mTouchResponse == null || this.mMotionOutsideRegion)) {
                this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
                motionTracker.recycle();
                this.mVelocityTracker = null;
                int i2 = motionLayout.mCurrentState;
                if (i2 != -1) {
                    autoTransition(motionLayout, i2);
                }
            }
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        int i = 0;
        while (i < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            } else {
                readConstraintChain(keyAt, motionLayout);
                i++;
            }
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i, constraintSet);
    }

    public void setDuration(int i) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
                while (it2.hasNext()) {
                    if (it2.next().mFramePosition == i && obj != null) {
                        Float f = (Float) obj;
                    }
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransition(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.mStateSet
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.stateGetConstraintID(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.mStateSet
            int r2 = r2.stateGetConstraintID(r8, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r8
            goto L_0x001a
        L_0x0018:
            r0 = r7
            goto L_0x0016
        L_0x001a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.mCurrentTransition
            if (r3 == 0) goto L_0x002d
            int r3 = r3.mConstraintSetEnd
            if (r3 != r8) goto L_0x002d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.mCurrentTransition
            int r3 = r3.mConstraintSetStart
            if (r3 != r7) goto L_0x002d
            return
        L_0x002d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0033:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r2) goto L_0x004b
            int r5 = r4.mConstraintSetStart
            if (r5 == r0) goto L_0x0057
        L_0x004b:
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0033
            int r5 = r4.mConstraintSetStart
            if (r5 != r7) goto L_0x0033
        L_0x0057:
            r6.mCurrentTransition = r4
            if (r4 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r4.mTouchResponse
            if (r7 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r7.mTouchResponse
            boolean r8 = r6.mRtl
            r7.setRTL(r8)
        L_0x006c:
            return
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mAbstractTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0075:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0075
            r7 = r4
            goto L_0x0075
        L_0x0089:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            int unused = r8.mConstraintSetStart = r0
            int unused = r8.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x009b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.mTransitionList
            r7.add(r8)
        L_0x009b:
            r6.mCurrentTransition = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setupTouch();
        }
    }

    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.mMotionLayout && motionLayout.mScene == this) {
            return true;
        }
        return false;
    }

    public void viewTransition(int i, View... viewArr) {
        this.mViewTransitionController.viewTransition(i, viewArr);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        /* access modifiers changed from: private */
        public int mAutoTransition = 0;
        /* access modifiers changed from: private */
        public int mConstraintSetEnd = -1;
        /* access modifiers changed from: private */
        public int mConstraintSetStart = -1;
        /* access modifiers changed from: private */
        public int mDefaultInterpolator = 0;
        /* access modifiers changed from: private */
        public int mDefaultInterpolatorID = -1;
        /* access modifiers changed from: private */
        public String mDefaultInterpolatorString = null;
        /* access modifiers changed from: private */
        public boolean mDisable = false;
        /* access modifiers changed from: private */
        public int mDuration = 400;
        /* access modifiers changed from: private */
        public int mId = -1;
        /* access modifiers changed from: private */
        public boolean mIsAbstract = false;
        /* access modifiers changed from: private */
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        private int mLayoutDuringTransition = 0;
        /* access modifiers changed from: private */
        public final MotionScene mMotionScene;
        /* access modifiers changed from: private */
        public ArrayList<TransitionOnClick> mOnClicks = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mPathMotionArc = -1;
        /* access modifiers changed from: private */
        public float mStagger = 0.0f;
        /* access modifiers changed from: private */
        public TouchResponse mTouchResponse = null;
        private int mTransitionFlags = 0;

        public Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if (XIxXXX0x0.f20806xoXoI.equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if (XIxXXX0x0.f20806xoXoI.equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i2 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i3 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i3;
                    if (i3 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i, int i2) {
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (it.hasNext()) {
                TransitionOnClick next = it.next();
                if (next.mTargetId == i) {
                    next.mMode = i2;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i, i2));
        }

        public String debugString(Context context) {
            String str;
            if (this.mConstraintSetStart == -1) {
                str = "null";
            } else {
                str = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return str + " -> null";
            }
            return str + oIX0oI.f22028oxoX + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i) {
            if ((i & this.mTransitionFlags) != 0) {
                return true;
            }
            return false;
        }

        public void removeOnClick(int i) {
            TransitionOnClick transitionOnClick;
            Iterator<TransitionOnClick> it = this.mOnClicks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    transitionOnClick = null;
                    break;
                }
                transitionOnClick = it.next();
                if (transitionOnClick.mTargetId == i) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i) {
            this.mAutoTransition = i;
        }

        public void setDuration(int i) {
            this.mDuration = Math.max(i, 8);
        }

        public void setEnabled(boolean z) {
            this.mDisable = !z;
        }

        public void setInterpolatorInfo(int i, String str, int i2) {
            this.mDefaultInterpolator = i;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i2;
        }

        public void setLayoutDuringTransition(int i) {
            this.mLayoutDuringTransition = i;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            TouchResponse touchResponse;
            if (onSwipe == null) {
                touchResponse = null;
            } else {
                touchResponse = new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
            }
            this.mTouchResponse = touchResponse;
        }

        public void setOnTouchUp(int i) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i);
            }
        }

        public void setPathMotionArc(int i) {
            this.mPathMotionArc = i;
        }

        public void setStagger(float f) {
            this.mStagger = f;
        }

        public void setTransitionFlag(int i) {
            this.mTransitionFlags = i;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                int i2 = this.mTargetId;
                View view = motionLayout;
                if (i2 != -1) {
                    view = motionLayout.findViewById(i2);
                }
                if (view == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                    return;
                }
                int access$100 = transition.mConstraintSetStart;
                int access$000 = transition.mConstraintSetEnd;
                if (access$100 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i3 = this.mMode;
                boolean z5 = false;
                if ((i3 & 1) == 0 || i != access$100) {
                    z = false;
                } else {
                    z = true;
                }
                if ((i3 & 256) == 0 || i != access$100) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                boolean z6 = z | z2;
                if ((i3 & 1) == 0 || i != access$100) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                boolean z7 = z3 | z6;
                if ((i3 & 16) == 0 || i != access$000) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                boolean z8 = z7 | z4;
                if ((i3 & 4096) != 0 && i == access$000) {
                    z5 = true;
                }
                if (z8 || z5) {
                    view.setOnClickListener(this);
                }
            }

            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int access$000 = transition2.mConstraintSetEnd;
                int access$100 = this.mTransition.mConstraintSetStart;
                if (access$100 != -1) {
                    int i = motionLayout.mCurrentState;
                    if (i == access$100 || i == access$000) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.mCurrentState != access$000) {
                    return true;
                } else {
                    return false;
                }
            }

            public void onClick(View view) {
                boolean z;
                boolean z2;
                MotionLayout access$700 = this.mTransition.mMotionScene.mMotionLayout;
                if (access$700.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = access$700.getCurrentState();
                        if (currentState == -1) {
                            access$700.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        int unused = transition.mConstraintSetStart = currentState;
                        int unused2 = transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        access$700.setTransition(transition);
                        access$700.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i = this.mMode;
                    boolean z3 = false;
                    if ((i & 1) == 0 && (i & 256) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if ((i & 16) == 0 && (i & 4096) == 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z || !z2) {
                        z3 = z;
                    } else {
                        Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            access$700.setTransition(transition4);
                        }
                        if (access$700.getCurrentState() != access$700.getEndState() && access$700.getProgress() <= 0.5f) {
                            z3 = z;
                            z2 = false;
                        }
                    }
                    if (!isTransitionViable(transition2, access$700)) {
                        return;
                    }
                    if (z3 && (this.mMode & 1) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.transitionToEnd();
                    } else if (z2 && (this.mMode & 16) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.transitionToStart();
                    } else if (z3 && (this.mMode & 256) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.setProgress(1.0f);
                    } else if (z2 && (this.mMode & 4096) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.setProgress(0.0f);
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i = this.mTargetId;
                if (i != -1) {
                    View findViewById = motionLayout.findViewById(i);
                    if (findViewById == null) {
                        Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public TransitionOnClick(Transition transition, int i, int i2) {
                this.mTransition = transition;
                this.mTargetId = i;
                this.mMode = i2;
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    public ConstraintSet getConstraintSet(int i, int i2, int i3) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3)) == -1)) {
            i = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i) != null) {
            return this.mConstraintSetMap.get(i);
        }
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    /* access modifiers changed from: private */
    public int parseInclude(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e);
            return -1;
        } catch (IOException e2) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e2);
            return -1;
        }
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i2 = R.id.motion_base;
        sparseArray.put(i2, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i2));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }
}
