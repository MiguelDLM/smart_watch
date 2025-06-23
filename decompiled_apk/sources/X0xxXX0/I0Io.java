package X0xxXX0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.Map;
import java.util.UUID;
import oOoIIO0.xoIox;

/* loaded from: classes11.dex */
public class I0Io extends CustomInterstitialAdapter {

    /* renamed from: I0Io, reason: collision with root package name */
    public oOoIIO0.xxIXOIIO f3642I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3644oIX0oI = getClass().getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3643II0xO0 = "";

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3646XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements xoIox {
            public oIX0oI() {
            }

            @Override // oOoIIO0.xoIox
            public void onAdCacheLoaded() {
                Log.i(I0Io.this.f3644oIX0oI, "onAdCacheLoaded");
            }

            @Override // oOoIIO0.xoIox
            public void onAdClicked() {
                Log.i(I0Io.this.f3644oIX0oI, "onAdClicked");
                if (I0Io.this.mImpressListener != null) {
                    I0Io.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // oOoIIO0.xoIox
            public void onAdClosed() {
                Log.i(I0Io.this.f3644oIX0oI, "onAdClosed");
                if (I0Io.this.mImpressListener != null) {
                    I0Io.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // oOoIIO0.xoIox
            public void onAdFailedToLoad(int i) {
                Log.i(I0Io.this.f3644oIX0oI, "onAdFailedToLoad");
                if (I0Io.this.mLoadListener != null) {
                    I0Io.this.mLoadListener.onAdLoadError(String.valueOf(i), "onAdFailedToLoad errorCode：" + i);
                }
                if (I0Io.this.mBiddingListener != null) {
                    I0Io.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.xoIox
            public void onAdLoaded() {
                Log.i(I0Io.this.f3644oIX0oI, "onAdLoaded");
                if (I0Io.this.mLoadListener != null) {
                    I0Io.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (I0Io.this.mBiddingListener != null) {
                    I0Io.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(I0Io.this.f3642I0Io.OOXIXo(), UUID.randomUUID().toString(), new xxIXOIIO(I0Io.this.f3642I0Io), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.xoIox
            public void onAdShown() {
                Log.i(I0Io.this.f3644oIX0oI, "onAdShown");
                if (I0Io.this.mImpressListener != null) {
                    I0Io.this.mImpressListener.onInterstitialAdShow();
                }
            }
        }

        public II0xO0(Context context) {
            this.f3646XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            I0Io i0Io = I0Io.this;
            i0Io.f3642I0Io = new oOoIIO0.xxIXOIIO(this.f3646XO, i0Io.f3643II0xO0, new oIX0oI());
            I0Io.this.f3642I0Io.Oxx0xo(true);
            I0Io.this.f3642I0Io.Oo();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements MediationInitCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f3649oIX0oI;

        public oIX0oI(Context context) {
            this.f3649oIX0oI = context;
        }

        public void II0xO0() {
            I0Io.this.O0xOxO(this.f3649oIX0oI);
        }

        public void oIX0oI(String str) {
            if (I0Io.this.mLoadListener != null) {
                I0Io.this.mLoadListener.onAdLoadError("80000", str);
            }
            if (I0Io.this.mBiddingListener != null) {
                I0Io.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
            }
        }
    }

    public boolean IIXOooo() {
        oOoIIO0.xxIXOIIO xxixoiio = this.f3642I0Io;
        if (xxixoiio != null && xxixoiio.x0XOIxOo()) {
            return true;
        }
        return false;
    }

    public void IXxxXO() {
        oOoIIO0.xxIXOIIO xxixoiio = this.f3642I0Io;
        if (xxixoiio != null) {
            xxixoiio.destroy();
            this.f3642I0Io = null;
        }
    }

    public final void O0xOxO(Context context) {
        postOnMainThread(new II0xO0(context));
    }

    public boolean OxI(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        Log.i(this.f3644oIX0oI, "onAd startBiddingRequest");
        xoXoI(context, map, map2);
        return true;
    }

    public String Oxx0xo() {
        return X0xxXX0.II0xO0.X0o0xo().XO();
    }

    public String OxxIIOOXO() {
        return X0xxXX0.II0xO0.X0o0xo().Oxx0IOOO();
    }

    public void o00(Activity activity) {
        oOoIIO0.xxIXOIIO xxixoiio;
        if (activity != null && (xxixoiio = this.f3642I0Io) != null && xxixoiio.x0XOIxOo()) {
            this.f3642I0Io.IIXOooo(activity);
        }
    }

    public String oI0IIXIo() {
        return this.f3643II0xO0;
    }

    public void xoXoI(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Log.i(this.f3644oIX0oI, "onAd loadCustomNetworkAd");
        if (map.containsKey("slot_id")) {
            this.f3643II0xO0 = (String) map.get("slot_id");
        }
        if (TextUtils.isEmpty(this.f3643II0xO0)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("80000", "SlotId is empty!");
            }
            if (this.mBiddingListener != null) {
                this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("SlotId is empty!"), (BaseAd) null);
                return;
            }
            return;
        }
        X0xxXX0.II0xO0.X0o0xo().II0XooXoX(context, map, new oIX0oI(context));
    }
}
