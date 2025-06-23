package X0O0I0;

import com.sma.smartv3.view.WheelView.WheelView;
import java.util.TimerTask;

/* loaded from: classes12.dex */
public final class X0o0xo extends TimerTask {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f3243IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final WheelView f3245Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3246XO = Integer.MAX_VALUE;

    /* renamed from: Oo, reason: collision with root package name */
    public int f3244Oo = 0;

    public X0o0xo(WheelView loopview, int offset) {
        this.f3245Oxx0xo = loopview;
        this.f3243IXxxXO = offset;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f3246XO == Integer.MAX_VALUE) {
            this.f3246XO = this.f3243IXxxXO;
        }
        int i = this.f3246XO;
        int i2 = (int) (i * 0.1f);
        this.f3244Oo = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f3244Oo = -1;
            } else {
                this.f3244Oo = 1;
            }
        }
        if (Math.abs(i) <= 0) {
            this.f3245Oxx0xo.oIX0oI();
            this.f3245Oxx0xo.f25396IXxxXO.sendEmptyMessage(3000);
        } else {
            WheelView wheelView = this.f3245Oxx0xo;
            wheelView.f25419oo += this.f3244Oo;
            wheelView.f25396IXxxXO.sendEmptyMessage(1000);
            this.f3246XO -= this.f3244Oo;
        }
    }
}
