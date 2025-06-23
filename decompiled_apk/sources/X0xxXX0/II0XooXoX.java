package X0xxXX0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;
import java.util.UUID;
import oOoIIO0.OxxIIOOXO;
import oOoIIO0.oI0IIXIo;

/* loaded from: classes11.dex */
public class II0XooXoX extends CustomSplashAdapter {

    /* renamed from: I0Io, reason: collision with root package name */
    public oI0IIXIo f3650I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3652oIX0oI = getClass().getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3651II0xO0 = "";

    /* loaded from: classes11.dex */
    public class oIX0oI implements MediationInitCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f3657oIX0oI;

        public oIX0oI(Context context) {
            this.f3657oIX0oI = context;
        }

        public void II0xO0() {
            II0XooXoX.this.X0IIOO(this.f3657oIX0oI);
        }

        public void oIX0oI(String str) {
            if (II0XooXoX.this.mLoadListener != null) {
                II0XooXoX.this.mLoadListener.onAdLoadError("80000", str);
            }
            if (II0XooXoX.this.mBiddingListener != null) {
                II0XooXoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
            }
        }
    }

    public String IIXOooo() {
        return X0xxXX0.II0xO0.X0o0xo().Oxx0IOOO();
    }

    public boolean O0xOxO(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        Log.i(this.f3652oIX0oI, "onAd startBiddingRequest");
        o00(context, map, map2);
        return true;
    }

    public void OxI(Activity activity, ViewGroup viewGroup) {
        oI0IIXIo oi0iixio = this.f3650I0Io;
        if (oi0iixio != null && oi0iixio.x0XOIxOo() && viewGroup != null) {
            this.f3650I0Io.IIXOooo(viewGroup);
        }
    }

    public void Oxx0xo() {
        oI0IIXIo oi0iixio = this.f3650I0Io;
        if (oi0iixio != null) {
            oi0iixio.destroy();
        }
    }

    public String OxxIIOOXO() {
        return this.f3651II0xO0;
    }

    public final void X0IIOO(Context context) {
        postOnMainThread(new II0xO0(context));
    }

    public void o00(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Log.i(this.f3652oIX0oI, "onAd loadCustomNetworkAd");
        if (map.containsKey("slot_id")) {
            this.f3651II0xO0 = (String) map.get("slot_id");
        }
        if (TextUtils.isEmpty(this.f3651II0xO0)) {
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

    public String oI0IIXIo() {
        return X0xxXX0.II0xO0.X0o0xo().XO();
    }

    public boolean xoXoI() {
        oI0IIXIo oi0iixio = this.f3650I0Io;
        if (oi0iixio != null && oi0iixio.x0XOIxOo()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3654XO;

        public II0xO0(Context context) {
            this.f3654XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX iI0XooXoX = II0XooXoX.this;
            iI0XooXoX.f3650I0Io = new oI0IIXIo(this.f3654XO, iI0XooXoX.f3651II0xO0, new oIX0oI());
            II0XooXoX.this.f3650I0Io.Oo(true);
        }

        /* loaded from: classes11.dex */
        public class oIX0oI implements OxxIIOOXO {
            public oIX0oI() {
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdCacheLoaded() {
                Log.i(II0XooXoX.this.f3652oIX0oI, "onAdCacheLoaded");
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdClicked() {
                Log.i(II0XooXoX.this.f3652oIX0oI, IAdInterListener.AdCommandType.AD_CLICK);
                if (II0XooXoX.this.mImpressionListener != null) {
                    II0XooXoX.this.mImpressionListener.onSplashAdClicked();
                }
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdClosed() {
                Log.i(II0XooXoX.this.f3652oIX0oI, "onAdClosed");
                II0XooXoX.this.mDismissType = 0;
                if (II0XooXoX.this.mImpressionListener != null) {
                    II0XooXoX.this.mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdFailedToLoad(int i) {
                Log.i(II0XooXoX.this.f3652oIX0oI, "onAdFailedToLoad:" + i);
                if (II0XooXoX.this.mLoadListener != null) {
                    II0XooXoX.this.mLoadListener.onAdLoadError(String.valueOf(i), "onAdFailedToLoad errorCode：" + i);
                }
                if (II0XooXoX.this.mBiddingListener != null) {
                    II0XooXoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdLoaded() {
                Log.i(II0XooXoX.this.f3652oIX0oI, "onAdLoaded");
                if (II0XooXoX.this.mLoadListener != null) {
                    II0XooXoX.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (II0XooXoX.this.mBiddingListener != null) {
                    II0XooXoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(II0XooXoX.this.f3650I0Io.OOXIXo(), UUID.randomUUID().toString(), new xxIXOIIO(II0XooXoX.this.f3650I0Io), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdShown() {
                Log.i(II0XooXoX.this.f3652oIX0oI, "onAdShown");
                if (II0XooXoX.this.mImpressionListener != null) {
                    II0XooXoX.this.mImpressionListener.onSplashAdShow();
                }
            }

            @Override // oOoIIO0.OxxIIOOXO
            public void onAdTick(long j) {
            }
        }
    }
}
