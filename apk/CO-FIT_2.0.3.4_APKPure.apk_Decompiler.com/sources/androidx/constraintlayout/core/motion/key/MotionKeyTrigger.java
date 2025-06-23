package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class MotionKeyTrigger extends MotionKey {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final int TYPE_CROSS = 312;
    public static final int TYPE_NEGATIVE_CROSS = 310;
    public static final int TYPE_POSITIVE_CROSS = 309;
    public static final int TYPE_POST_LAYOUT = 304;
    public static final int TYPE_TRIGGER_COLLISION_ID = 307;
    public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
    public static final int TYPE_TRIGGER_ID = 308;
    public static final int TYPE_TRIGGER_RECEIVER = 311;
    public static final int TYPE_TRIGGER_SLACK = 305;
    public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
    public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
    public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    FloatRect mCollisionRect;
    private String mCross = null;
    private int mCurveFit = -1;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    FloatRect mTargetRect;
    private int mTriggerCollisionId;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    int mViewTransitionOnCross;
    int mViewTransitionOnNegativeCross;
    int mViewTransitionOnPositiveCross;

    public MotionKeyTrigger() {
        int i = MotionKey.UNSET;
        this.mTriggerReceiver = i;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = i;
        this.mViewTransitionOnPositiveCross = i;
        this.mViewTransitionOnCross = i;
        this.mCollisionRect = new FloatRect();
        this.mTargetRect = new FloatRect();
        this.mType = 5;
        this.mCustom = new HashMap<>();
    }

    private void fireCustom(String str, MotionWidget motionWidget) {
        boolean z;
        CustomVariable customVariable;
        if (str.length() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.mCustom.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z || lowerCase.matches(str)) && (customVariable = this.mCustom.get(next)) != null) {
                customVariable.applyToWidget(motionWidget);
            }
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void conditionallyFire(float f, MotionWidget motionWidget) {
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getId(java.lang.String r3) {
        /*
            r2 = this;
            r3.hashCode()
            r0 = -1
            int r1 = r3.hashCode()
            switch(r1) {
                case -1594793529: goto L_0x0085;
                case -966421266: goto L_0x0079;
                case -786670827: goto L_0x006e;
                case -648752941: goto L_0x0063;
                case -638126837: goto L_0x0058;
                case -76025313: goto L_0x004d;
                case -9754574: goto L_0x0041;
                case 364489912: goto L_0x0036;
                case 1301930599: goto L_0x0028;
                case 1401391082: goto L_0x001b;
                case 1535404999: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            r3 = -1
            goto L_0x0090
        L_0x000e:
            java.lang.String r1 = "triggerReceiver"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0017
            goto L_0x000b
        L_0x0017:
            r3 = 10
            goto L_0x0090
        L_0x001b:
            java.lang.String r1 = "postLayout"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0024
            goto L_0x000b
        L_0x0024:
            r3 = 9
            goto L_0x0090
        L_0x0028:
            java.lang.String r1 = "viewTransitionOnCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0032
            goto L_0x000b
        L_0x0032:
            r3 = 8
            goto L_0x0090
        L_0x0036:
            java.lang.String r1 = "triggerSlack"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003f
            goto L_0x000b
        L_0x003f:
            r3 = 7
            goto L_0x0090
        L_0x0041:
            java.lang.String r1 = "viewTransitionOnNegativeCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x004b
            goto L_0x000b
        L_0x004b:
            r3 = 6
            goto L_0x0090
        L_0x004d:
            java.lang.String r1 = "triggerCollisionView"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0056
            goto L_0x000b
        L_0x0056:
            r3 = 5
            goto L_0x0090
        L_0x0058:
            java.lang.String r1 = "negativeCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0061
            goto L_0x000b
        L_0x0061:
            r3 = 4
            goto L_0x0090
        L_0x0063:
            java.lang.String r1 = "triggerID"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x006c
            goto L_0x000b
        L_0x006c:
            r3 = 3
            goto L_0x0090
        L_0x006e:
            java.lang.String r1 = "triggerCollisionId"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0077
            goto L_0x000b
        L_0x0077:
            r3 = 2
            goto L_0x0090
        L_0x0079:
            java.lang.String r1 = "viewTransitionOnPositiveCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0083
            goto L_0x000b
        L_0x0083:
            r3 = 1
            goto L_0x0090
        L_0x0085:
            java.lang.String r1 = "positiveCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x008f
            goto L_0x000b
        L_0x008f:
            r3 = 0
        L_0x0090:
            switch(r3) {
                case 0: goto L_0x00b2;
                case 1: goto L_0x00af;
                case 2: goto L_0x00ac;
                case 3: goto L_0x00a9;
                case 4: goto L_0x00a6;
                case 5: goto L_0x00a3;
                case 6: goto L_0x00a0;
                case 7: goto L_0x009d;
                case 8: goto L_0x009a;
                case 9: goto L_0x0097;
                case 10: goto L_0x0094;
                default: goto L_0x0093;
            }
        L_0x0093:
            return r0
        L_0x0094:
            r3 = 311(0x137, float:4.36E-43)
            return r3
        L_0x0097:
            r3 = 304(0x130, float:4.26E-43)
            return r3
        L_0x009a:
            r3 = 301(0x12d, float:4.22E-43)
            return r3
        L_0x009d:
            r3 = 305(0x131, float:4.27E-43)
            return r3
        L_0x00a0:
            r3 = 303(0x12f, float:4.25E-43)
            return r3
        L_0x00a3:
            r3 = 306(0x132, float:4.29E-43)
            return r3
        L_0x00a6:
            r3 = 310(0x136, float:4.34E-43)
            return r3
        L_0x00a9:
            r3 = 308(0x134, float:4.32E-43)
            return r3
        L_0x00ac:
            r3 = 307(0x133, float:4.3E-43)
            return r3
        L_0x00af:
            r3 = 302(0x12e, float:4.23E-43)
            return r3
        L_0x00b2:
            r3 = 309(0x135, float:4.33E-43)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTrigger.getId(java.lang.String):int");
    }

    public boolean setValue(int i, int i2) {
        if (i == 307) {
            this.mTriggerCollisionId = i2;
            return true;
        } else if (i == 308) {
            this.mTriggerID = toInt(Integer.valueOf(i2));
            return true;
        } else if (i != 311) {
            switch (i) {
                case 301:
                    this.mViewTransitionOnCross = i2;
                    return true;
                case 302:
                    this.mViewTransitionOnPositiveCross = i2;
                    return true;
                case 303:
                    this.mViewTransitionOnNegativeCross = i2;
                    return true;
                default:
                    return super.setValue(i, i2);
            }
        } else {
            this.mTriggerReceiver = i2;
            return true;
        }
    }

    public MotionKey clone() {
        return new MotionKeyTrigger().copy((MotionKey) this);
    }

    public MotionKeyTrigger copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.mCurveFit = motionKeyTrigger.mCurveFit;
        this.mCross = motionKeyTrigger.mCross;
        this.mTriggerReceiver = motionKeyTrigger.mTriggerReceiver;
        this.mNegativeCross = motionKeyTrigger.mNegativeCross;
        this.mPositiveCross = motionKeyTrigger.mPositiveCross;
        this.mTriggerID = motionKeyTrigger.mTriggerID;
        this.mTriggerCollisionId = motionKeyTrigger.mTriggerCollisionId;
        this.mTriggerSlack = motionKeyTrigger.mTriggerSlack;
        this.mFireCrossReset = motionKeyTrigger.mFireCrossReset;
        this.mFireNegativeReset = motionKeyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = motionKeyTrigger.mFirePositiveReset;
        this.mFireThreshold = motionKeyTrigger.mFireThreshold;
        this.mFireLastPos = motionKeyTrigger.mFireLastPos;
        this.mPostLayout = motionKeyTrigger.mPostLayout;
        this.mCollisionRect = motionKeyTrigger.mCollisionRect;
        this.mTargetRect = motionKeyTrigger.mTargetRect;
        return this;
    }

    public boolean setValue(int i, float f) {
        if (i != 305) {
            return super.setValue(i, f);
        }
        this.mTriggerSlack = f;
        return true;
    }

    public boolean setValue(int i, String str) {
        if (i == 309) {
            this.mPositiveCross = str;
            return true;
        } else if (i == 310) {
            this.mNegativeCross = str;
            return true;
        } else if (i != 312) {
            return super.setValue(i, str);
        } else {
            this.mCross = str;
            return true;
        }
    }

    public boolean setValue(int i, boolean z) {
        if (i != 304) {
            return super.setValue(i, z);
        }
        this.mPostLayout = z;
        return true;
    }
}
