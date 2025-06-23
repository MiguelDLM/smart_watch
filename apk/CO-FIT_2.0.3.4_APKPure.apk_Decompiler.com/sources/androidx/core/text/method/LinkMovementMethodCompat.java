package androidx.core.text.method;

import android.text.method.LinkMovementMethod;
import androidx.annotation.NonNull;

public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    @NonNull
    public static LinkMovementMethodCompat getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethodCompat();
        }
        return sInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        if (r0 <= r2.getLineRight(r1)) goto L_0x0057;
     */
    @androidx.annotation.OptIn(markerClass = {androidx.core.os.BuildCompat.PrereleaseSdkCheck.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.Nullable android.widget.TextView r5, @androidx.annotation.Nullable android.text.Spannable r6, @androidx.annotation.Nullable android.view.MotionEvent r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.os.BuildCompat.isAtLeastV()
            if (r0 != 0) goto L_0x0057
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == r1) goto L_0x000f
            if (r0 != 0) goto L_0x0057
        L_0x000f:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            int r2 = r5.getTotalPaddingLeft()
            int r0 = r0 - r2
            int r2 = r5.getTotalPaddingTop()
            int r1 = r1 - r2
            int r2 = r5.getScrollX()
            int r0 = r0 + r2
            int r2 = r5.getScrollY()
            int r1 = r1 + r2
            android.text.Layout r2 = r5.getLayout()
            if (r1 < 0) goto L_0x004f
            int r3 = r2.getHeight()
            if (r1 <= r3) goto L_0x003a
            goto L_0x004f
        L_0x003a:
            int r1 = r2.getLineForVertical(r1)
            float r0 = (float) r0
            float r3 = r2.getLineLeft(r1)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x004f
            float r1 = r2.getLineRight(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0057
        L_0x004f:
            android.text.Selection.removeSelection(r6)
            boolean r5 = android.text.method.Touch.onTouchEvent(r5, r6, r7)
            return r5
        L_0x0057:
            boolean r5 = super.onTouchEvent(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.method.LinkMovementMethodCompat.onTouchEvent(android.widget.TextView, android.text.Spannable, android.view.MotionEvent):boolean");
    }
}
