package oOoIIO0;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.animation.TransitionDirection;
import com.octopus.ad.internal.animation.TransitionType;
import com.octopus.ad.internal.view.BannerAdViewImpl;
import oOoIIO0.I0Io;

/* loaded from: classes11.dex */
public final class X0o0xo implements II0xO0, Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public final BannerAdViewImpl f32031XO;

    @RequiresPermission(g.f18396a)
    public X0o0xo(Context context, String str, XO xo2) {
        BannerAdViewImpl bannerAdViewImpl = new BannerAdViewImpl(context);
        this.f32031XO = bannerAdViewImpl;
        bannerAdViewImpl.setBannerAdListener(xo2);
        bannerAdViewImpl.setAdSlotId(str);
        OxI(TransitionType.MOVEIN);
        xoXoI(TransitionDirection.LEFT);
        o00(600);
        oI0IIXIo(true);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl == null) {
            return;
        }
        bannerAdViewImpl.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl == null) {
            return;
        }
        bannerAdViewImpl.II0xO0(i);
    }

    public void IIXOooo(String str) {
        this.f32031XO.setRequestId(str);
    }

    public void IXxxXO(boolean z) {
        this.f32031XO.OoO(z);
    }

    public int OOXIXo() {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl == null) {
            return 0;
        }
        return bannerAdViewImpl.getPrice();
    }

    @RequiresPermission(g.f18396a)
    public void Oo() {
        this.f32031XO.oXIO0o0XI(new I0Io.II0xO0().X0o0xo().XO());
    }

    public void OxI(TransitionType transitionType) {
        this.f32031XO.setTransitionType(transitionType);
    }

    public void Oxx0xo(String str) {
        this.f32031XO.setAdSlotId(str);
    }

    public void OxxIIOOXO(String str) {
        this.f32031XO.setChannel(str);
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        oIX0oI();
        cancel();
    }

    public void o00(int i) {
        this.f32031XO.setTransitionDuration(i);
    }

    public void oI0IIXIo(boolean z) {
        this.f32031XO.setAutoRefresh(z);
    }

    @Override // oOoIIO0.II0xO0
    public void oIX0oI() {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.oIX0oI();
        }
    }

    public boolean oO() {
        return this.f32031XO.XI0oooXX();
    }

    public String oOoXoXO() {
        return this.f32031XO.getRequestId();
    }

    public String ooOOo0oXI() {
        BannerAdViewImpl bannerAdViewImpl = this.f32031XO;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getTagId();
    }

    public String oxoX() {
        return this.f32031XO.getAdSlotId();
    }

    public boolean x0XOIxOo() {
        return this.f32031XO.ox();
    }

    public boolean x0xO0oo() {
        if (x0XOIxOo() && this.f32031XO.I0()) {
            return true;
        }
        return false;
    }

    public void xoXoI(TransitionDirection transitionDirection) {
        this.f32031XO.setTransitionDirection(transitionDirection);
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
