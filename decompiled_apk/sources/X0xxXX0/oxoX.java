package X0xxXX0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.octopus.ad.NativeAdResponse;
import java.util.Map;
import java.util.UUID;
import oOoIIO0.oOoXoXO;
import oOoIIO0.ooOOo0oXI;

/* loaded from: classes11.dex */
public class oxoX extends CustomNativeAdapter {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f3694I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3695II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public X0o0xo f3696X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public XO f3697XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f3698oIX0oI = getClass().getSimpleName();

    /* renamed from: oxoX, reason: collision with root package name */
    public oOoXoXO f3699oxoX;

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f3701XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements ooOOo0oXI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ boolean f3703oIX0oI;

            public oIX0oI(boolean z) {
                this.f3703oIX0oI = z;
            }

            @Override // oOoIIO0.ooOOo0oXI
            public void onAdFailed(int i) {
                Log.d(oxoX.this.f3698oIX0oI, "onAdFailed:" + i);
                if (oxoX.this.mLoadListener != null) {
                    oxoX.this.mLoadListener.onAdLoadError(String.valueOf(i), "onAdFailed errorCode：" + i);
                }
                if (oxoX.this.mBiddingListener != null) {
                    oxoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // oOoIIO0.ooOOo0oXI
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                Log.d(oxoX.this.f3698oIX0oI, "onAdLoaded");
                if (oxoX.this.mLoadListener != null && nativeAdResponse != null) {
                    if (this.f3703oIX0oI) {
                        oxoX.this.f3697XO = new XO(II0xO0.this.f3701XO, nativeAdResponse);
                        oxoX.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{oxoX.this.f3697XO});
                    } else {
                        oxoX.this.f3696X0o0xo = new X0o0xo(II0xO0.this.f3701XO, nativeAdResponse);
                        oxoX.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{oxoX.this.f3696X0o0xo});
                    }
                }
                if (oxoX.this.mBiddingListener != null && nativeAdResponse != null) {
                    double OOXIXo2 = oxoX.this.f3699oxoX.OOXIXo();
                    ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB_CENT;
                    String uuid = UUID.randomUUID().toString();
                    xxIXOIIO xxixoiio = new xxIXOIIO(oxoX.this.f3699oxoX);
                    if (this.f3703oIX0oI) {
                        oxoX.this.f3697XO = new XO(II0xO0.this.f3701XO, nativeAdResponse);
                        oxoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(OOXIXo2, uuid, xxixoiio, currency), oxoX.this.f3697XO);
                    } else {
                        oxoX.this.f3696X0o0xo = new X0o0xo(II0xO0.this.f3701XO, nativeAdResponse);
                        oxoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(OOXIXo2, uuid, xxixoiio, currency), oxoX.this.f3696X0o0xo);
                    }
                }
            }
        }

        public II0xO0(Context context) {
            this.f3701XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals = TextUtils.equals("1", oxoX.this.f3694I0Io);
            oxoX oxox = oxoX.this;
            oxox.f3699oxoX = new oOoXoXO(this.f3701XO, oxox.f3695II0xO0, new oIX0oI(equals));
            oxoX.this.f3699oxoX.Oo(true);
            oxoX.this.f3699oxoX.x0xO0oo();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements MediationInitCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f3705oIX0oI;

        public oIX0oI(Context context) {
            this.f3705oIX0oI = context;
        }

        public void II0xO0() {
            oxoX.this.o00(this.f3705oIX0oI);
        }

        public void oIX0oI(String str) {
            if (oxoX.this.mLoadListener != null) {
                oxoX.this.mLoadListener.onAdLoadError("80000", str);
            }
            if (oxoX.this.mBiddingListener != null) {
                oxoX.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
            }
        }
    }

    public void IIXOooo(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Log.i(this.f3698oIX0oI, "onAd loadCustomNetworkAd");
        if (map.containsKey("slot_id")) {
            this.f3695II0xO0 = (String) map.get("slot_id");
        }
        if (TextUtils.isEmpty(this.f3695II0xO0)) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdLoadError("80000", "SlotId is empty!");
            }
            if (this.mBiddingListener != null) {
                this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("SlotId is empty!"), (BaseAd) null);
                return;
            }
            return;
        }
        this.f3694I0Io = "0";
        if (map.containsKey("is_unified")) {
            this.f3694I0Io = (String) map.get("is_unified");
        }
        X0xxXX0.II0xO0.X0o0xo().II0XooXoX(context, map, new oIX0oI(context));
    }

    public void IXxxXO() {
        oOoXoXO oooxoxo = this.f3699oxoX;
        if (oooxoxo != null) {
            oooxoxo.destroy();
        }
    }

    public String Oxx0xo() {
        return X0xxXX0.II0xO0.X0o0xo().XO();
    }

    public String OxxIIOOXO() {
        return X0xxXX0.II0xO0.X0o0xo().Oxx0IOOO();
    }

    public final void o00(Context context) {
        postOnMainThread(new II0xO0(context));
    }

    public String oI0IIXIo() {
        return this.f3695II0xO0;
    }

    public boolean xoXoI(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        Log.i(this.f3698oIX0oI, "onAd startBiddingRequest");
        IIXOooo(context, map, map2);
        return true;
    }
}
