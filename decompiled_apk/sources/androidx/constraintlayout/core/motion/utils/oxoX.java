package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class oxoX {
    static {
        String str = TypedValues.MotionScene.NAME;
    }

    public static int II0xO0(int i) {
        if (i != 600) {
            if (i != 601) {
                return -1;
            }
            return 1;
        }
        return 2;
    }

    public static int oIX0oI(String str) {
        str.hashCode();
        if (!str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            if (!str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION)) {
                return -1;
            }
            return 601;
        }
        return 600;
    }
}
