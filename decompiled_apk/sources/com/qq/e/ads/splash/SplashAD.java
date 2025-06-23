package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {
    private volatile ViewGroup g;
    private volatile SplashADListener h;
    private volatile ADRewardListener i;
    private volatile LoadAdParams j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile int n;
    private volatile byte[] o;
    private volatile ServerSideVerificationOptions p;
    private int q;

    /* loaded from: classes11.dex */
    public class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l = (Long) aDEvent.getParam(Long.class);
                if (l != null) {
                    SplashAD.this.h.onADTick(l.longValue());
                    return;
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.h.onADLoaded(l2.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.h.onADPresent();
                    return;
                case 103:
                    SplashAD.this.h.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.i.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.h.onADClicked();
                    return;
                case 106:
                    SplashAD.this.h.onADDismissed();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public String getAdNetWorkName() {
        T t = this.f19399a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.k = true;
                return;
            }
            T t = this.f19399a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.f19399a;
        if (t == 0) {
            this.n = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f19399a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.f19399a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.k = false;
        this.h = splashADListener;
        this.q = i;
        a(context, str);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.f19399a;
        if (t == 0) {
            this.m = z;
            this.g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        if (this.h != null) {
            this.h.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f19399a;
        if (t == 0) {
            this.o = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.k = false;
        this.h = splashADListener;
        this.q = i;
        a(context, str, str2);
    }

    private void a(boolean z) {
        if (a()) {
            if (!b()) {
                this.m = z;
                this.l = true;
                return;
            }
            T t = this.f19399a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.f19399a;
        if (t == 0) {
            this.g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.j != null) {
            nspvi.setLoadAdParams(this.j);
        }
        if (this.n != 0) {
            nspvi.setDeveloperLogo(this.n);
        }
        if (this.o != null) {
            nspvi.setDeveloperLogo(this.o);
        }
        nspvi.setFetchDelay(this.q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.p);
        if (this.g != null) {
            if (this.m) {
                a(this.g, true);
            } else {
                a(this.g, false);
            }
        }
        if (this.k) {
            nspvi.preload();
            this.k = false;
        }
        if (this.l) {
            if (this.m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.l = false;
        }
    }
}
