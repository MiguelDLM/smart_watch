package oOoIIO0;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import oOoIIO0.I0Io;

/* loaded from: classes11.dex */
public final class IXxxXO implements Oxx0IOOO, II0XooXoX {

    /* renamed from: XO, reason: collision with root package name */
    public final InterstitialAdViewImpl f32027XO;

    @RequiresPermission(g.f18396a)
    public IXxxXO(Context context, String str, Oxx0xo oxx0xo) {
        InterstitialAdViewImpl interstitialAdViewImpl = new InterstitialAdViewImpl(context, true, false);
        this.f32027XO = interstitialAdViewImpl;
        interstitialAdViewImpl.setAdSlotId(str);
        interstitialAdViewImpl.setRewardVideoAdListener(oxx0xo);
    }

    @Override // oOoIIO0.II0XooXoX
    public void I0Io(String str) {
        this.f32027XO.setAdSlotId(str);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f32027XO;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f32027XO;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.II0xO0(i);
    }

    public void OOXIXo(String str) {
        this.f32027XO.setUserId(str);
    }

    public void Oxx0IOOO(String str) {
        this.f32027XO.setChannel(str);
    }

    public boolean X0o0xo() {
        if (isLoaded() && this.f32027XO.I0()) {
            return true;
        }
        return false;
    }

    public void XO(boolean z) {
        this.f32027XO.OoO(z);
    }

    @Override // oOoIIO0.II0XooXoX
    public void destroy() {
        this.f32027XO.destroy();
    }

    @Override // oOoIIO0.II0XooXoX
    public int getPrice() {
        return this.f32027XO.getPrice();
    }

    @Override // oOoIIO0.II0XooXoX
    public boolean isLoaded() {
        return this.f32027XO.ox();
    }

    @Override // oOoIIO0.II0XooXoX
    @RequiresPermission(g.f18396a)
    public void loadAd() {
        this.f32027XO.oXIO0o0XI(new I0Io.II0xO0().X0o0xo().XO());
    }

    @Override // oOoIIO0.II0XooXoX
    public String oIX0oI() {
        return this.f32027XO.getTagId();
    }

    public String oxoX() {
        return this.f32027XO.getRequestId();
    }

    @Override // oOoIIO0.II0XooXoX
    public void pause() {
        this.f32027XO.IIX0o();
    }

    @Override // oOoIIO0.II0XooXoX
    public void resume() {
        this.f32027XO.ooXIXxIX();
    }

    @Override // oOoIIO0.II0XooXoX
    public void show(Activity activity) {
        if (isLoaded()) {
            this.f32027XO.I0xX0(activity);
        }
    }

    public void xoIox(String str) {
        this.f32027XO.setRequestId(str);
    }

    public void xxIXOIIO(String str) {
        this.f32027XO.setExtraData(str);
    }
}
