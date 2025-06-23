package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import oIxOXo.II0XooXoX;
import oIxOXo.oxoX;
import skin.support.appcompat.R;
import xxoXO.I0Io;
import xxoXO.Oxx0IOOO;
import xxoXO.oIX0oI;

/* loaded from: classes6.dex */
public class SkinCompatToolbar extends Toolbar implements Oxx0IOOO {
    private oIX0oI mBackgroundTintHelper;
    private int mNavigationIconResId;
    private int mSubtitleTextColorResId;
    private int mTitleTextColorResId;

    public SkinCompatToolbar(Context context) {
        this(context, null);
    }

    private void applyNavigationIcon() {
        int II0xO02 = I0Io.II0xO0(this.mNavigationIconResId);
        this.mNavigationIconResId = II0xO02;
        if (II0xO02 != 0) {
            setNavigationIcon(II0XooXoX.oIX0oI(getContext(), this.mNavigationIconResId));
        }
    }

    private void applySubtitleTextColor() {
        int II0xO02 = I0Io.II0xO0(this.mSubtitleTextColorResId);
        this.mSubtitleTextColorResId = II0xO02;
        if (II0xO02 != 0) {
            setSubtitleTextColor(oxoX.I0Io(getContext(), this.mSubtitleTextColorResId));
        }
    }

    private void applyTitleTextColor() {
        int II0xO02 = I0Io.II0xO0(this.mTitleTextColorResId);
        this.mTitleTextColorResId = II0xO02;
        if (II0xO02 != 0) {
            setTitleTextColor(oxoX.I0Io(getContext(), this.mTitleTextColorResId));
        }
    }

    @Override // xxoXO.Oxx0IOOO
    public void applySkin() {
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oIX0oI();
        }
        applyTitleTextColor();
        applySubtitleTextColor();
        applyNavigationIcon();
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        oIX0oI oix0oi = this.mBackgroundTintHelper;
        if (oix0oi != null) {
            oix0oi.oxoX(i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@DrawableRes int i) {
        super.setNavigationIcon(i);
        this.mNavigationIconResId = i;
        applyNavigationIcon();
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleTextColorResId = 0;
        this.mSubtitleTextColorResId = 0;
        this.mNavigationIconResId = 0;
        oIX0oI oix0oi = new oIX0oI(this);
        this.mBackgroundTintHelper = oix0oi;
        oix0oi.I0Io(attributeSet, i);
        int[] iArr = R.styleable.Toolbar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.mNavigationIconResId = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_navigationIcon, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.styleable.SkinTextAppearance);
            this.mTitleTextColorResId = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
        }
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId2, R.styleable.SkinTextAppearance);
            this.mSubtitleTextColorResId = obtainStyledAttributes3.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes3.recycle();
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        int i2 = R.styleable.Toolbar_titleTextColor;
        if (obtainStyledAttributes4.hasValue(i2)) {
            this.mTitleTextColorResId = obtainStyledAttributes4.getResourceId(i2, 0);
        }
        int i3 = R.styleable.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes4.hasValue(i3)) {
            this.mSubtitleTextColorResId = obtainStyledAttributes4.getResourceId(i3, 0);
        }
        obtainStyledAttributes4.recycle();
        applyTitleTextColor();
        applySubtitleTextColor();
        applyNavigationIcon();
    }
}
