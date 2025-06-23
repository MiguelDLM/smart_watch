package X0O0I0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.sma.smartv3.view.WheelView.WheelView;

/* loaded from: classes12.dex */
public final class II0xO0 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: XO, reason: collision with root package name */
    public WheelView f3242XO;

    public II0xO0(WheelView loopview) {
        this.f3242XO = loopview;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.f3242XO.II0XooXoX(velocityY);
        return true;
    }
}
