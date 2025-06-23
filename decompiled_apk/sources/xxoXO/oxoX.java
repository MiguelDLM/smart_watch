package xxoXO;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import skin.support.R;

/* loaded from: classes6.dex */
public class oxoX extends I0Io {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f35546Oxx0IOOO = "oxoX";

    /* renamed from: I0Io, reason: collision with root package name */
    public final ImageView f35547I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f35550oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f35548X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public int f35549XO = 0;

    public oxoX(ImageView imageView) {
        this.f35547I0Io = imageView;
        oIxOXo.oxoX.f31821II0XooXoX = imageView.isInEditMode();
    }

    public void I0Io(AttributeSet attributeSet, int i) {
        TypedArray typedArray = null;
        try {
            typedArray = this.f35547I0Io.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatImageView, i, 0);
            this.f35550oxoX = typedArray.getResourceId(R.styleable.SkinCompatImageView_android_src, 0);
            this.f35548X0o0xo = typedArray.getResourceId(R.styleable.SkinCompatImageView_srcCompat, 0);
            int resourceId = typedArray.getResourceId(R.styleable.SkinCompatImageView_tint, 0);
            this.f35549XO = resourceId;
            if (resourceId == 0) {
                this.f35549XO = typedArray.getResourceId(R.styleable.SkinCompatImageView_android_tint, 0);
            }
            typedArray.recycle();
            oIX0oI();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    @Override // xxoXO.I0Io
    public void oIX0oI() {
        Drawable oIX0oI2;
        int II0xO02 = I0Io.II0xO0(this.f35548X0o0xo);
        this.f35548X0o0xo = II0xO02;
        if (II0xO02 != 0) {
            Drawable oIX0oI3 = oIxOXo.II0XooXoX.oIX0oI(this.f35547I0Io.getContext(), this.f35548X0o0xo);
            if (oIX0oI3 != null) {
                this.f35547I0Io.setImageDrawable(oIX0oI3);
            }
        } else {
            int II0xO03 = I0Io.II0xO0(this.f35550oxoX);
            this.f35550oxoX = II0xO03;
            if (II0xO03 != 0 && (oIX0oI2 = oIxOXo.II0XooXoX.oIX0oI(this.f35547I0Io.getContext(), this.f35550oxoX)) != null) {
                this.f35547I0Io.setImageDrawable(oIX0oI2);
            }
        }
        int II0xO04 = I0Io.II0xO0(this.f35549XO);
        this.f35549XO = II0xO04;
        if (II0xO04 != 0) {
            ImageViewCompat.setImageTintList(this.f35547I0Io, oIxOXo.oxoX.X0o0xo(this.f35547I0Io.getContext(), this.f35549XO));
        }
    }

    public void oxoX(int i) {
        this.f35550oxoX = i;
        this.f35548X0o0xo = 0;
        oIX0oI();
    }
}
