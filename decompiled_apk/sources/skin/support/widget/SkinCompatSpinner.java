package skin.support.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatSpinner;
import oIxOXo.II0XooXoX;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatSpinner extends AppCompatSpinner implements Oxx0IOOO {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {R.attr.spinnerMode};
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "SkinCompatSpinner";
    private oIX0oI mBackgroundTintHelper;
    private int mPopupBackgroundResId;

    public SkinCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyPopupBackground() {
        int II0xO02 = I0Io.II0xO0(this.mPopupBackgroundResId);
        this.mPopupBackgroundResId = II0xO02;
        if (II0xO02 != 0) {
            setPopupBackgroundDrawable(II0XooXoX.oIX0oI(getContext(), this.mPopupBackgroundResId));
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        applyPopupBackground();
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i) {
        super.setPopupBackgroundResource(i);
        this.mPopupBackgroundResId = i;
        applyPopupBackground();
    }

    public SkinCompatSpinner(Context context, int i) {
        this(context, null, skin.support.appcompat.R.attr.spinnerStyle, i);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, skin.support.appcompat.R.attr.spinnerStyle);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SkinCompatSpinner(android.content.Context r5, android.util.AttributeSet r6, int r7, int r8, android.content.res.Resources.Theme r9) {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7, r8, r9)
            r9 = 0
            r4.mPopupBackgroundResId = r9
            int[] r0 = skin.support.appcompat.R.styleable.Spinner
            android.content.res.TypedArray r0 = r5.obtainStyledAttributes(r6, r0, r7, r9)
            android.content.Context r1 = r4.getPopupContext()
            if (r1 == 0) goto L57
            r1 = -1
            if (r8 != r1) goto L3f
            r1 = 0
            int[] r2 = skin.support.widget.SkinCompatSpinner.ATTRS_ANDROID_SPINNERMODE     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            android.content.res.TypedArray r1 = r5.obtainStyledAttributes(r6, r2, r7, r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            boolean r5 = r1.hasValue(r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r5 == 0) goto L2b
            int r8 = r1.getInt(r9, r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            goto L2b
        L27:
            r5 = move-exception
            goto L39
        L29:
            r5 = move-exception
            goto L2f
        L2b:
            r1.recycle()
            goto L3f
        L2f:
            java.lang.String r2 = skin.support.widget.SkinCompatSpinner.TAG     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "Could not read android:spinnerMode"
            android.util.Log.i(r2, r3, r5)     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L3f
            goto L2b
        L39:
            if (r1 == 0) goto L3e
            r1.recycle()
        L3e:
            throw r5
        L3f:
            r5 = 1
            if (r8 != r5) goto L57
            android.content.Context r5 = r4.getPopupContext()
            int[] r8 = skin.support.appcompat.R.styleable.Spinner
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r8, r7, r9)
            int r8 = skin.support.appcompat.R.styleable.Spinner_android_popupBackground
            int r8 = r5.getResourceId(r8, r9)
            r4.mPopupBackgroundResId = r8
            r5.recycle()
        L57:
            r0.recycle()
            xxoXO.oIX0oI r5 = new xxoXO.oIX0oI
            r5.<init>(r4)
            r4.mBackgroundTintHelper = r5
            r5.I0Io(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.widget.SkinCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
