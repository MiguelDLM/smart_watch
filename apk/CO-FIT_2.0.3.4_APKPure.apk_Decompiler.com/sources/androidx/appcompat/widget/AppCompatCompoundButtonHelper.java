package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    @NonNull
    private final CompoundButton mView;

    public AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|(2:6|7)|9|10|(1:14)|15|(1:17)|18|(1:20)|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.mView
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R.styleable.CompoundButton
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.mView
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.getWrappedTypeArray()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x003b
            int r10 = r0.getResourceId(r10, r8)     // Catch:{ all -> 0x0039 }
            if (r10 == 0) goto L_0x003b
            android.widget.CompoundButton r11 = r9.mView     // Catch:{ NotFoundException -> 0x003b }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003b }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch:{ NotFoundException -> 0x003b }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003b }
            goto L_0x0056
        L_0x0039:
            r10 = move-exception
            goto L_0x0082
        L_0x003b:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x0056
            int r10 = r0.getResourceId(r10, r8)     // Catch:{ all -> 0x0039 }
            if (r10 == 0) goto L_0x0056
            android.widget.CompoundButton r11 = r9.mView     // Catch:{ all -> 0x0039 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch:{ all -> 0x0039 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0039 }
        L_0x0056:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x0067
            android.widget.CompoundButton r11 = r9.mView     // Catch:{ all -> 0x0039 }
            android.content.res.ColorStateList r10 = r0.getColorStateList(r10)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r11, r10)     // Catch:{ all -> 0x0039 }
        L_0x0067:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x007e
            android.widget.CompoundButton r11 = r9.mView     // Catch:{ all -> 0x0039 }
            r1 = -1
            int r10 = r0.getInt(r10, r1)     // Catch:{ all -> 0x0039 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r10, r1)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r11, r10)     // Catch:{ all -> 0x0039 }
        L_0x007e:
            r0.recycle()
            return
        L_0x0082:
            r0.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
