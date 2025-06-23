package x0;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import o0IXXIx.II0XooXoX;

/* loaded from: classes11.dex */
public class XOxIOxOx extends TouchDelegate {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f33709II0XooXoX = 4;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f33710Oxx0IOOO = 2;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f33711XO = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f33712xxIXOIIO = 8;

    /* renamed from: I0Io, reason: collision with root package name */
    public Rect f33713I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Rect f33714II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f33715X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public View f33716oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f33717oxoX;

    public XOxIOxOx(Rect rect, View view) {
        super(rect, view);
        this.f33714II0xO0 = rect;
        this.f33715X0o0xo = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.f33713I0Io = rect2;
        int i = this.f33715X0o0xo;
        rect2.inset(-i, -i);
        this.f33716oIX0oI = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked != 5 && actionMasked != 6) {
                        z = false;
                    }
                } else {
                    z = this.f33717oxoX;
                    this.f33717oxoX = false;
                }
            }
            boolean z3 = this.f33717oxoX;
            if (z3) {
                z2 = this.f33713I0Io.contains(x, y);
            }
            z = z3;
        } else {
            II0XooXoX.I0Io("OctopusAd", "TouchDelegate mBounds = " + this.f33714II0xO0 + ",x = " + x + ",y = " + y);
            this.f33717oxoX = this.f33714II0xO0.contains(x, y);
            StringBuilder sb = new StringBuilder();
            sb.append("TouchDelegate onTouchEvent mDelegateTargeted = ");
            sb.append(this.f33717oxoX);
            II0XooXoX.I0Io("OctopusAd", sb.toString());
            z = this.f33717oxoX;
        }
        if (!z) {
            return false;
        }
        View view = this.f33716oIX0oI;
        if (z2) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.f33715X0o0xo * 2);
            motionEvent.setLocation(f, f);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
