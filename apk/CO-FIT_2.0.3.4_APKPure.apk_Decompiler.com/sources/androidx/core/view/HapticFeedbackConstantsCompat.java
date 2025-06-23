package androidx.core.view;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    @VisibleForTesting
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    @VisibleForTesting
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        if (r6 != 17) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0044 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getFeedbackConstantOrFallback(int r6) {
        /*
            r0 = -1
            if (r6 != r0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            r3 = 4
            r4 = 0
            r5 = 6
            if (r1 >= r2) goto L_0x0016
            switch(r6) {
                case 21: goto L_0x0015;
                case 22: goto L_0x0013;
                case 23: goto L_0x0015;
                case 24: goto L_0x0013;
                case 25: goto L_0x0011;
                case 26: goto L_0x0015;
                case 27: goto L_0x0013;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0016
        L_0x0011:
            r6 = 0
            goto L_0x0016
        L_0x0013:
            r6 = 4
            goto L_0x0016
        L_0x0015:
            r6 = 6
        L_0x0016:
            r2 = 30
            if (r1 >= r2) goto L_0x002f
            r2 = 12
            if (r6 == r2) goto L_0x002d
            r2 = 13
            if (r6 == r2) goto L_0x002b
            r2 = 16
            if (r6 == r2) goto L_0x002d
            r2 = 17
            if (r6 == r2) goto L_0x0030
            goto L_0x002f
        L_0x002b:
            r4 = 6
            goto L_0x0030
        L_0x002d:
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = r6
        L_0x0030:
            r6 = 27
            if (r1 >= r6) goto L_0x003f
            r6 = 7
            if (r4 == r6) goto L_0x0040
            r6 = 8
            if (r4 == r6) goto L_0x0040
            r6 = 9
            if (r4 == r6) goto L_0x0040
        L_0x003f:
            r0 = r4
        L_0x0040:
            r6 = 23
            if (r1 >= r6) goto L_0x0046
            if (r0 == r5) goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(int):int");
    }
}
