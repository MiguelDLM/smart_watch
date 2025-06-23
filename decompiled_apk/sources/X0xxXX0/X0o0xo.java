package X0xxXX0;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.octopus.ad.NativeAdResponse;

/* loaded from: classes11.dex */
public class X0o0xo extends CustomNativeAd {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f3677I0Io = X0o0xo.class.getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public NativeAdResponse f3678II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f3679oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements xXoOI00O.oIX0oI {
        public oIX0oI() {
        }

        @Override // xXoOI00O.oIX0oI
        public void onADExposed() {
            Log.i(X0o0xo.f3677I0Io, "onADExposed");
            X0o0xo.this.notifyAdImpression();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdClick() {
            Log.i(X0o0xo.f3677I0Io, IAdInterListener.AdCommandType.AD_CLICK);
            X0o0xo.this.notifyAdClicked();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdClose() {
            Log.i(X0o0xo.f3677I0Io, "onAdClose");
            X0o0xo.this.notifyAdDislikeClick();
        }

        @Override // xXoOI00O.oIX0oI
        public void onAdRenderFailed(int i) {
            Log.i(X0o0xo.f3677I0Io, "onAdRenderFailed");
        }
    }

    public X0o0xo(Context context, NativeAdResponse nativeAdResponse) {
        this.f3679oIX0oI = context.getApplicationContext();
        this.f3678II0xO0 = nativeAdResponse;
    }

    public Bitmap I0Io() {
        NativeAdResponse nativeAdResponse = this.f3678II0xO0;
        if (nativeAdResponse != null) {
            return nativeAdResponse.X0o0xo(this.f3679oIX0oI);
        }
        return null;
    }

    public void II0xO0() {
        this.f3679oIX0oI = null;
        this.f3678II0xO0 = null;
    }

    public boolean X0o0xo() {
        return true;
    }

    public void XO(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null) {
            return;
        }
        this.f3678II0xO0.OxxIIOOXO((ViewGroup) view, new oIX0oI());
    }

    public View oxoX(Object... objArr) {
        return null;
    }

    public void clear(View view) {
    }
}
