package oI;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.octopus.ad.AdActivity;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.AdWebView;
import com.octopus.ad.internal.view.f;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class I0Io implements AdActivity.I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public f f31311I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public AdWebView f31312II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Activity f31313oIX0oI;

    public I0Io(Activity activity) {
        this.f31313oIX0oI = activity;
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void a() {
        if (AdViewImpl.getMRAIDFullscreenContainer() != null && AdViewImpl.getMRAIDFullscreenImplementation() != null) {
            I0oOoX.O0xOxO(AdViewImpl.getMRAIDFullscreenContainer());
            this.f31313oIX0oI.setContentView(AdViewImpl.getMRAIDFullscreenContainer());
            if (AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0) instanceof AdWebView) {
                this.f31312II0xO0 = (AdWebView) AdViewImpl.getMRAIDFullscreenContainer().getChildAt(0);
            }
            if (this.f31312II0xO0.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f31312II0xO0.getContext()).setBaseContext(this.f31313oIX0oI);
            }
            f mRAIDFullscreenImplementation = AdViewImpl.getMRAIDFullscreenImplementation();
            this.f31311I0Io = mRAIDFullscreenImplementation;
            mRAIDFullscreenImplementation.XO(this.f31313oIX0oI);
            if (AdViewImpl.getMRAIDFullscreenListener() != null) {
                AdViewImpl.getMRAIDFullscreenListener().a();
                return;
            }
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Launched MRAID Fullscreen activity with invalid properties");
        this.f31313oIX0oI.finish();
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void e() {
        f fVar = this.f31311I0Io;
        if (fVar != null) {
            fVar.XO(null);
            this.f31311I0Io.I0Io();
        }
        this.f31311I0Io = null;
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public WebView h() {
        return this.f31312II0xO0;
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void b() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void c() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void d() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void f() {
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void g() {
    }
}
