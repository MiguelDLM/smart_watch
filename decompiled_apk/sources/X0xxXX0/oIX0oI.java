package X0xxXX0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import java.util.Map;
import java.util.UUID;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class oIX0oI extends CustomBannerAdapter {

    /* renamed from: I0Io, reason: collision with root package name */
    public oOoIIO0.X0o0xo f3685I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public FrameLayout f3688oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3687oIX0oI = getClass().getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3686II0xO0 = "";

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3690XO;

        /* renamed from: X0xxXX0.oIX0oI$II0xO0$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0054oIX0oI implements oOoIIO0.XO {
            public C0054oIX0oI() {
            }

            @Override // oOoIIO0.XO
            public void onAdClicked() {
                Log.i(oIX0oI.this.f3687oIX0oI, "onAdClicked");
                if (oIX0oI.this.mImpressionEventListener != null) {
                    oIX0oI.this.mImpressionEventListener.onBannerAdClicked();
                }
            }

            @Override // oOoIIO0.XO
            public void onAdClosed() {
                Log.i(oIX0oI.this.f3687oIX0oI, "onAdClosed");
                if (oIX0oI.this.f3688oxoX != null && oIX0oI.this.f3688oxoX.getChildCount() > 0) {
                    oIX0oI.this.f3688oxoX.removeAllViews();
                }
            }

            @Override // oOoIIO0.XO
            public void onAdFailedToLoad(int i) {
                Log.i(oIX0oI.this.f3687oIX0oI, "onAdFailedToLoad:" + i);
                if (oIX0oI.this.mLoadListener != null) {
                    oIX0oI.this.mLoadListener.onAdLoadError(String.valueOf(i), "onAdFailedToLoad errorCode：" + i);
                }
                if (oIX0oI.this.mBiddingListener != null) {
                    oIX0oI.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.XO
            public void onAdLoaded() {
                Log.i(oIX0oI.this.f3687oIX0oI, "onAdLoaded:");
            }

            @Override // oOoIIO0.XO
            public void onAdShown() {
                Log.i(oIX0oI.this.f3687oIX0oI, "onAdShown");
                if (oIX0oI.this.mImpressionEventListener != null) {
                    oIX0oI.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // oOoIIO0.XO
            public void onRenderSuccess(View view) {
                Log.i(oIX0oI.this.f3687oIX0oI, "onRenderSuccess");
                II0xO0 iI0xO0 = II0xO0.this;
                oIX0oI.this.OxI(iI0xO0.f3690XO, view);
                if (oIX0oI.this.mLoadListener != null) {
                    oIX0oI.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (oIX0oI.this.mBiddingListener != null) {
                    oIX0oI.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(oIX0oI.this.f3685I0Io.OOXIXo(), UUID.randomUUID().toString(), new xxIXOIIO(oIX0oI.this.f3685I0Io), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }
        }

        public II0xO0(Context context) {
            this.f3690XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3690XO == null) {
                return;
            }
            oIX0oI.this.f3688oxoX = new FrameLayout(this.f3690XO);
            oIX0oI oix0oi = oIX0oI.this;
            oix0oi.f3685I0Io = new oOoIIO0.X0o0xo(this.f3690XO, oix0oi.f3686II0xO0, new C0054oIX0oI());
            oIX0oI.this.f3685I0Io.IXxxXO(true);
            oIX0oI.this.f3685I0Io.Oo();
        }
    }

    /* renamed from: X0xxXX0.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0055oIX0oI implements MediationInitCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f3693oIX0oI;

        public C0055oIX0oI(Context context) {
            this.f3693oIX0oI = context;
        }

        public void II0xO0() {
            oIX0oI.this.X0IIOO(this.f3693oIX0oI);
        }

        public void oIX0oI(String str) {
            if (oIX0oI.this.mLoadListener != null) {
                oIX0oI.this.mLoadListener.onAdLoadError("80000", str);
            }
            if (oIX0oI.this.mBiddingListener != null) {
                oIX0oI.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
            }
        }
    }

    public String IIXOooo() {
        return X0xxXX0.II0xO0.X0o0xo().Oxx0IOOO();
    }

    public void IXxxXO() {
        oOoIIO0.X0o0xo x0o0xo = this.f3685I0Io;
        if (x0o0xo != null) {
            x0o0xo.destroy();
            this.f3685I0Io = null;
        }
    }

    public boolean O0xOxO(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        Log.i(this.f3687oIX0oI, "onAd startBiddingRequest");
        o00(context, map, map2);
        return true;
    }

    public void OxI(Context context, View view) {
        FrameLayout frameLayout;
        if (view != null && (frameLayout = this.f3688oxoX) != null) {
            frameLayout.removeAllViews();
            int Oxx0xo2 = I0oOoX.Oxx0xo(context);
            this.f3688oxoX.addView(view, new LinearLayout.LayoutParams(Oxx0xo2, (int) (Oxx0xo2 / 6.4f)));
        }
    }

    public View Oxx0xo() {
        return this.f3688oxoX;
    }

    public String OxxIIOOXO() {
        return this.f3686II0xO0;
    }

    public final void X0IIOO(Context context) {
        postOnMainThread(new II0xO0(context));
    }

    public void o00(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Log.i(this.f3687oIX0oI, "onAd loadCustomNetworkAd");
        if (map.containsKey("slot_id")) {
            this.f3686II0xO0 = (String) map.get("slot_id");
        }
        if (TextUtils.isEmpty(this.f3686II0xO0)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("80000", "SlotId is empty!");
            }
            if (this.mBiddingListener != null) {
                this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("SlotId is empty!"), (BaseAd) null);
                return;
            }
            return;
        }
        X0xxXX0.II0xO0.X0o0xo().II0XooXoX(context, map, new C0055oIX0oI(context));
    }

    public String oI0IIXIo() {
        return X0xxXX0.II0xO0.X0o0xo().XO();
    }

    public boolean xoXoI() {
        oOoIIO0.X0o0xo x0o0xo = this.f3685I0Io;
        if (x0o0xo != null && x0o0xo.x0XOIxOo()) {
            return true;
        }
        return false;
    }
}
