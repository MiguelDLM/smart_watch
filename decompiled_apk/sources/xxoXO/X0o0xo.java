package xxoXO;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import skin.support.appcompat.R;

/* loaded from: classes6.dex */
public class X0o0xo extends I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final ProgressBar f35537I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public Bitmap f35541oxoX;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f35539X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public int f35540XO = 0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f35538Oxx0IOOO = 0;

    public X0o0xo(ProgressBar progressBar) {
        this.f35537I0Io = progressBar;
        oIxOXo.oxoX.f31821II0XooXoX = progressBar.isInEditMode();
    }

    public final int I0Io(int i) {
        return I0Io.II0xO0(i);
    }

    public final Drawable Oxx0IOOO(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable XO2 = XO(animationDrawable.getFrame(i), true);
                XO2.setLevel(10000);
                animationDrawable2.addFrame(XO2, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    public void X0o0xo(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f35537I0Io.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatProgressBar, i, 0);
        this.f35539X0o0xo = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatProgressBar_android_indeterminateDrawable, 0);
        this.f35540XO = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatProgressBar_android_progressDrawable, 0);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT > 21) {
            TypedArray obtainStyledAttributes2 = this.f35537I0Io.getContext().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.indeterminateTint}, i, 0);
            this.f35538Oxx0IOOO = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        oIX0oI();
    }

    public final Drawable XO(Drawable drawable, boolean z) {
        boolean z2;
        if (oX0O.XO.II0XooXoX(drawable)) {
            Drawable II0xO02 = oX0O.XO.II0xO0(drawable);
            if (II0xO02 != null) {
                oX0O.XO.OOXIXo(drawable, XO(II0xO02, z));
            }
        } else if (oX0O.XO.Oxx0IOOO(drawable)) {
            Drawable oIX0oI2 = oX0O.XO.oIX0oI(drawable);
            if (oIX0oI2 != null) {
                oX0O.XO.xoIox(drawable, XO(oIX0oI2, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    Drawable drawable2 = layerDrawable.getDrawable(i);
                    if (id != 16908301 && id != 16908303) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    drawableArr[i] = XO(drawable2, z2);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f35541oxoX == null) {
                    this.f35541oxoX = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(oxoX());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                if (z) {
                    return new ClipDrawable(shapeDrawable, 3, 1);
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }

    @Override // xxoXO.I0Io
    public void oIX0oI() {
        int II0xO02 = I0Io.II0xO0(this.f35539X0o0xo);
        this.f35539X0o0xo = II0xO02;
        if (II0xO02 != 0) {
            Drawable oIX0oI2 = oIxOXo.II0XooXoX.oIX0oI(this.f35537I0Io.getContext(), this.f35539X0o0xo);
            oIX0oI2.setBounds(this.f35537I0Io.getIndeterminateDrawable().getBounds());
            this.f35537I0Io.setIndeterminateDrawable(Oxx0IOOO(oIX0oI2));
        }
        int I0Io2 = I0Io(this.f35540XO);
        this.f35540XO = I0Io2;
        if (I0Io2 != 0) {
            this.f35537I0Io.setProgressDrawable(XO(oIxOXo.II0XooXoX.oIX0oI(this.f35537I0Io.getContext(), this.f35540XO), false));
        }
        if (Build.VERSION.SDK_INT > 21) {
            int II0xO03 = I0Io.II0xO0(this.f35538Oxx0IOOO);
            this.f35538Oxx0IOOO = II0xO03;
            if (II0xO03 != 0) {
                ProgressBar progressBar = this.f35537I0Io;
                progressBar.setIndeterminateTintList(oIxOXo.oxoX.X0o0xo(progressBar.getContext(), this.f35538Oxx0IOOO));
            }
        }
    }

    public final Shape oxoX() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }
}
