package X0O0I0;

import com.sma.smartv3.view.WheelView.WheelView;

/* loaded from: classes12.dex */
public final class oxoX implements Runnable {

    /* renamed from: XO, reason: collision with root package name */
    public WheelView f3250XO;

    public oxoX(WheelView loopview) {
        this.f3250XO = loopview;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f3250XO;
        wheelView.f25417oI0IIXIo.onItemSelected(wheelView.getSelectedItem());
    }
}
