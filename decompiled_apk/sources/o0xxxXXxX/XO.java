package o0xxxXXxX;

import android.graphics.drawable.Drawable;

/* loaded from: classes9.dex */
public abstract class XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Drawable f31282IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Object f31283Oo;

    /* renamed from: XO, reason: collision with root package name */
    public float f31284XO;

    public XO() {
        this.f31284XO = 0.0f;
        this.f31283Oo = null;
        this.f31282IXxxXO = null;
    }

    public float I0Io() {
        return this.f31284XO;
    }

    public Drawable II0xO0() {
        return this.f31282IXxxXO;
    }

    public void X0o0xo(Drawable drawable) {
        this.f31282IXxxXO = drawable;
    }

    public void XO(float f) {
        this.f31284XO = f;
    }

    public Object oIX0oI() {
        return this.f31283Oo;
    }

    public void oxoX(Object obj) {
        this.f31283Oo = obj;
    }

    public XO(float f) {
        this.f31283Oo = null;
        this.f31282IXxxXO = null;
        this.f31284XO = f;
    }

    public XO(float f, Object obj) {
        this(f);
        this.f31283Oo = obj;
    }

    public XO(float f, Drawable drawable) {
        this(f);
        this.f31282IXxxXO = drawable;
    }

    public XO(float f, Drawable drawable, Object obj) {
        this(f);
        this.f31282IXxxXO = drawable;
        this.f31283Oo = obj;
    }
}
