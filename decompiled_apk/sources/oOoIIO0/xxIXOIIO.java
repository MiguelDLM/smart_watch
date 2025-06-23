package oOoIIO0;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import oOoIIO0.I0Io;

/* loaded from: classes11.dex */
public final class xxIXOIIO implements II0xO0, Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public final InterstitialAdViewImpl f32068XO;

    @RequiresPermission(g.f18396a)
    public xxIXOIIO(Context context, String str, xoIox xoiox) {
        InterstitialAdViewImpl interstitialAdViewImpl = new InterstitialAdViewImpl(context, false, false);
        this.f32068XO = interstitialAdViewImpl;
        interstitialAdViewImpl.setAdSlotId(str);
        interstitialAdViewImpl.setInterstitialAdListener(xoiox);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f32068XO;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f32068XO;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.II0xO0(i);
    }

    public void IIXOooo(Activity activity) {
        this.f32068XO.I0xX0(activity);
    }

    @RequiresPermission(g.f18396a)
    public void IXxxXO(I0Io i0Io) {
        this.f32068XO.oXIO0o0XI(i0Io.XO());
    }

    public int OOXIXo() {
        return this.f32068XO.getPrice();
    }

    @RequiresPermission(g.f18396a)
    public void Oo() {
        this.f32068XO.oXIO0o0XI(new I0Io.II0xO0().X0o0xo().XO());
    }

    public void Oxx0xo(boolean z) {
        this.f32068XO.setOpensNativeBrowser(z);
    }

    public void OxxIIOOXO(String str) {
        this.f32068XO.setRequestId(str);
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        this.f32068XO.cancel();
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        oIX0oI();
        cancel();
    }

    public void oI0IIXIo(String str) {
        this.f32068XO.setChannel(str);
    }

    @Override // oOoIIO0.II0xO0
    public void oIX0oI() {
        this.f32068XO.oIX0oI();
    }

    public boolean oO() {
        return this.f32068XO.XI0oooXX();
    }

    public String oOoXoXO() {
        return this.f32068XO.getRequestId();
    }

    public String ooOOo0oXI() {
        return this.f32068XO.getTagId();
    }

    public String oxoX() {
        return this.f32068XO.getAdSlotId();
    }

    public boolean x0XOIxOo() {
        return this.f32068XO.ox();
    }

    public boolean x0xO0oo() {
        if (x0XOIxOo() && this.f32068XO.I0()) {
            return true;
        }
        return false;
    }

    @Override // oOoIIO0.II0xO0
    public void I0Io() {
    }

    @Override // oOoIIO0.II0xO0
    public void Oxx0IOOO() {
    }

    @Override // oOoIIO0.II0xO0
    public void X0o0xo() {
    }

    @Override // oOoIIO0.II0xO0
    public void XO() {
    }

    @Override // oOoIIO0.II0xO0
    public void xoIox() {
    }

    @Override // oOoIIO0.II0xO0
    public void xxIXOIIO() {
    }
}
