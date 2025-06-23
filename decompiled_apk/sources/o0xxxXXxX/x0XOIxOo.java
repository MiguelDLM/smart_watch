package o0xxxXXxX;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class x0XOIxOo<T extends Entry> extends oO<T> implements IIxOXoOo0.Oxx0IOOO<T> {

    /* renamed from: IIX0o, reason: collision with root package name */
    public boolean f31296IIX0o;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f31297XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f31298XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f31299xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public Drawable f31300xxX;

    public x0XOIxOo(List<T> list, String str) {
        super(list, str);
        this.f31297XIxXXX0x0 = Color.rgb(140, 234, 255);
        this.f31298XxX0x0xxx = 85;
        this.f31299xXxxox0I = 2.5f;
        this.f31296IIX0o = false;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public int I0oOIX() {
        return this.f31298XxX0x0xxx;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public float IoOoo() {
        return this.f31299xXxxox0I;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public boolean OIOoIIOIx() {
        return this.f31296IIX0o;
    }

    public void OOIXx0x(int i) {
        this.f31297XIxXXX0x0 = i;
        this.f31300xxX = null;
    }

    public void OXXoIoXI(x0XOIxOo x0xoixoo) {
        super.o0oxo0oI(x0xoixoo);
        x0xoixoo.f31296IIX0o = this.f31296IIX0o;
        x0xoixoo.f31298XxX0x0xxx = this.f31298XxX0x0xxx;
        x0xoixoo.f31297XIxXXX0x0 = this.f31297XIxXXX0x0;
        x0xoixoo.f31300xxX = this.f31300xxX;
        x0xoixoo.f31299xXxxox0I = this.f31299xXxxox0I;
    }

    public void XooIO0oo0(int i) {
        this.f31298XxX0x0xxx = i;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public int XxX0x0xxx() {
        return this.f31297XIxXXX0x0;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public void oI(boolean z) {
        this.f31296IIX0o = z;
    }

    public void oXxx000(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.f31299xXxxox0I = XIXIX.OOXIXo.X0o0xo(f);
    }

    @TargetApi(18)
    public void xIx0XO(Drawable drawable) {
        this.f31300xxX = drawable;
    }

    @Override // IIxOXoOo0.Oxx0IOOO
    public Drawable xxIXOIIO() {
        return this.f31300xxX;
    }
}
