package X0O0I0;

import com.sma.smartv3.view.WheelView.WheelView;
import java.util.TimerTask;

/* loaded from: classes12.dex */
public final class oIX0oI extends TimerTask {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public WheelView f3247IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f3248Oo;

    /* renamed from: XO, reason: collision with root package name */
    public float f3249XO = 2.1474836E9f;

    public oIX0oI(WheelView loopview, float velocityY) {
        this.f3247IXxxXO = loopview;
        this.f3248Oo = velocityY;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f3249XO == 2.1474836E9f) {
            if (Math.abs(this.f3248Oo) > 2000.0f) {
                if (this.f3248Oo > 0.0f) {
                    this.f3249XO = 2000.0f;
                } else {
                    this.f3249XO = -2000.0f;
                }
            } else {
                this.f3249XO = this.f3248Oo;
            }
        }
        if (Math.abs(this.f3249XO) >= 0.0f && Math.abs(this.f3249XO) <= 20.0f) {
            this.f3247IXxxXO.oIX0oI();
            this.f3247IXxxXO.f25396IXxxXO.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f3249XO * 10.0f) / 1000.0f);
        WheelView wheelView = this.f3247IXxxXO;
        int i2 = wheelView.f25419oo - i;
        wheelView.f25419oo = i2;
        if (!wheelView.f25421ooXIXxIX) {
            float f = wheelView.f25393IIX0o * wheelView.f25408XIxXXX0x0;
            int i3 = wheelView.f25398IoOoX;
            if (i2 <= ((int) ((-i3) * f))) {
                this.f3249XO = 40.0f;
                wheelView.f25419oo = (int) ((-i3) * f);
            } else {
                int size = wheelView.f25399O0xOxO.size() - 1;
                WheelView wheelView2 = this.f3247IXxxXO;
                if (i2 >= ((int) ((size - wheelView2.f25398IoOoX) * f))) {
                    wheelView2.f25419oo = (int) (((wheelView2.f25399O0xOxO.size() - 1) - this.f3247IXxxXO.f25398IoOoX) * f);
                    this.f3249XO = -40.0f;
                }
            }
        }
        float f2 = this.f3249XO;
        if (f2 < 0.0f) {
            this.f3249XO = f2 + 20.0f;
        } else {
            this.f3249XO = f2 - 20.0f;
        }
        this.f3247IXxxXO.f25396IXxxXO.sendEmptyMessage(1000);
    }
}
