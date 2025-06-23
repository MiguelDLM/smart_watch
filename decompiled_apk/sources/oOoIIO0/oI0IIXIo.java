package oOoIIO0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.view.BannerAdViewImpl;
import oOoIIO0.I0Io;

/* loaded from: classes11.dex */
public final class oI0IIXIo implements II0xO0, Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public final BannerAdViewImpl f32044XO;

    @RequiresPermission(g.f18396a)
    public oI0IIXIo(Context context, String str, ViewGroup viewGroup, OxxIIOOXO oxxIIOOXO) {
        BannerAdViewImpl bannerAdViewImpl = new BannerAdViewImpl(context, viewGroup, (View) null);
        this.f32044XO = bannerAdViewImpl;
        bannerAdViewImpl.setSplashAdListener(oxxIIOOXO);
        bannerAdViewImpl.setAdSlotId(str);
        bannerAdViewImpl.oXIO0o0XI(new I0Io.II0xO0().X0o0xo().XO());
    }

    @Override // oOoIIO0.II0xO0
    public void I0Io() {
        this.f32044XO.I0Io();
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl == null) {
            return;
        }
        bannerAdViewImpl.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl == null) {
            return;
        }
        bannerAdViewImpl.II0xO0(i);
    }

    public void IIXOooo(ViewGroup viewGroup) {
        this.f32044XO.IoXIXo(viewGroup);
    }

    public void IXxxXO(String str) {
        this.f32044XO.setAdSlotId(str);
    }

    public int OOXIXo() {
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl == null) {
            return 0;
        }
        return bannerAdViewImpl.getPrice();
    }

    public void Oo(boolean z) {
        this.f32044XO.OoO(z);
    }

    @Override // oOoIIO0.II0xO0
    public void Oxx0IOOO() {
        this.f32044XO.Oxx0IOOO();
    }

    public void Oxx0xo(String str) {
        this.f32044XO.setChannel(str);
    }

    public void OxxIIOOXO() {
        this.f32044XO.IoXIXo(null);
    }

    @Override // oOoIIO0.II0xO0
    public void X0o0xo() {
        this.f32044XO.X0o0xo();
    }

    @Override // oOoIIO0.II0xO0
    public void XO() {
        this.f32044XO.XO();
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        oIX0oI();
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        cancel();
    }

    public void oI0IIXIo(String str) {
        this.f32044XO.setRequestId(str);
    }

    @Override // oOoIIO0.II0xO0
    public void oIX0oI() {
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.oIX0oI();
        }
    }

    public boolean oO() {
        return this.f32044XO.XI0oooXX();
    }

    public String oOoXoXO() {
        return this.f32044XO.getRequestId();
    }

    public String ooOOo0oXI() {
        BannerAdViewImpl bannerAdViewImpl = this.f32044XO;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getTagId();
    }

    public String oxoX() {
        return this.f32044XO.getAdSlotId();
    }

    public boolean x0XOIxOo() {
        return this.f32044XO.ox();
    }

    public boolean x0xO0oo() {
        if (x0XOIxOo() && this.f32044XO.I0()) {
            return true;
        }
        return false;
    }

    @Override // oOoIIO0.II0xO0
    public void xoIox() {
        this.f32044XO.xoIox();
    }

    @Override // oOoIIO0.II0xO0
    public void xxIXOIIO() {
        this.f32044XO.xxIXOIIO();
    }

    @RequiresPermission(g.f18396a)
    public oI0IIXIo(Context context, String str, OxxIIOOXO oxxIIOOXO) {
        this(context, str, null, oxxIIOOXO);
    }
}
