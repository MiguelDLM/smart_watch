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
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.Map;
import java.util.UUID;
import oOoIIO0.IXxxXO;
import oOoIIO0.Oxx0xo;
import oOoIIO0.x0xO0oo;

/* loaded from: classes11.dex */
public class Oxx0IOOO extends CustomRewardVideoAdapter {

    /* renamed from: I0Io, reason: collision with root package name */
    public IXxxXO f3669I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3671oIX0oI = getClass().getSimpleName();

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3670II0xO0 = "";

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3673XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements Oxx0xo {
            public oIX0oI() {
            }

            @Override // oOoIIO0.Oxx0xo
            public void I0Io() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdComplete");
                if (Oxx0IOOO.this.mImpressionListener != null) {
                    Oxx0IOOO.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void II0xO0(int i) {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdFailedToLoad:" + i);
                if (Oxx0IOOO.this.mLoadListener != null) {
                    Oxx0IOOO.this.mLoadListener.onAdLoadError(String.valueOf(i), "onRewardVideoAdFailedToLoad errorCode：" + i);
                }
                if (Oxx0IOOO.this.mBiddingListener != null) {
                    Oxx0IOOO.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void Oxx0IOOO() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdLoaded");
                if (Oxx0IOOO.this.mLoadListener != null) {
                    Oxx0IOOO.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (Oxx0IOOO.this.mBiddingListener != null) {
                    Oxx0IOOO.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(Oxx0IOOO.this.f3669I0Io.getPrice(), UUID.randomUUID().toString(), new xxIXOIIO(Oxx0IOOO.this.f3669I0Io), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void X0o0xo(x0xO0oo x0xo0oo) {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewarded");
                if (Oxx0IOOO.this.mImpressionListener != null) {
                    Oxx0IOOO.this.mImpressionListener.onReward();
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void XO() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdShown");
                if (Oxx0IOOO.this.mImpressionListener != null) {
                    Oxx0IOOO.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void oIX0oI() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdClicked");
                if (Oxx0IOOO.this.mImpressionListener != null) {
                    Oxx0IOOO.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // oOoIIO0.Oxx0xo
            public void onRewardVideoCached() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoCached");
            }

            @Override // oOoIIO0.Oxx0xo
            public void oxoX() {
                Log.i(Oxx0IOOO.this.f3671oIX0oI, "onRewardVideoAdClosed");
                if (Oxx0IOOO.this.mImpressionListener != null) {
                    Oxx0IOOO.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }
        }

        public II0xO0(Context context) {
            this.f3673XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO oxx0IOOO = Oxx0IOOO.this;
            oxx0IOOO.f3669I0Io = new IXxxXO(this.f3673XO, oxx0IOOO.f3670II0xO0, new oIX0oI());
            Oxx0IOOO.this.f3669I0Io.XO(true);
            Oxx0IOOO.this.f3669I0Io.loadAd();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements MediationInitCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f3676oIX0oI;

        public oIX0oI(Context context) {
            this.f3676oIX0oI = context;
        }

        public void II0xO0() {
            Oxx0IOOO.this.xxX(this.f3676oIX0oI);
        }

        public void oIX0oI(String str) {
            if (Oxx0IOOO.this.mLoadListener != null) {
                Oxx0IOOO.this.mLoadListener.onAdLoadError("80000", str);
            }
            if (Oxx0IOOO.this.mBiddingListener != null) {
                Oxx0IOOO.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
            }
        }
    }

    public void IIXOooo() {
        IXxxXO iXxxXO = this.f3669I0Io;
        if (iXxxXO != null) {
            iXxxXO.destroy();
            this.f3669I0Io = null;
        }
    }

    public boolean O0xOxO() {
        IXxxXO iXxxXO = this.f3669I0Io;
        if (iXxxXO != null && iXxxXO.isLoaded()) {
            return true;
        }
        return false;
    }

    public String OxI() {
        return X0xxXX0.II0xO0.X0o0xo().Oxx0IOOO();
    }

    public void X0IIOO(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Log.i(this.f3671oIX0oI, "onAd loadCustomNetworkAd");
        if (map.containsKey("slot_id")) {
            this.f3670II0xO0 = (String) map.get("slot_id");
        }
        if (TextUtils.isEmpty(this.f3670II0xO0)) {
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

    public void XI0IXoo(Activity activity) {
        IXxxXO iXxxXO;
        if (activity != null && (iXxxXO = this.f3669I0Io) != null && iXxxXO.isLoaded()) {
            this.f3669I0Io.show(activity);
        }
    }

    public boolean XIxXXX0x0(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        Log.i(this.f3671oIX0oI, "onAd startBiddingRequest");
        X0IIOO(context, map, map2);
        return true;
    }

    public String o00() {
        return this.f3670II0xO0;
    }

    public String xoXoI() {
        return X0xxXX0.II0xO0.X0o0xo().XO();
    }

    public final void xxX(Context context) {
        postOnMainThread(new II0xO0(context));
    }
}
