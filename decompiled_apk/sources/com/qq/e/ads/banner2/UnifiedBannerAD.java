package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {
    private UnifiedBannerADListener g;
    private AtomicInteger h;
    private int i;
    private LoadAdParams j;
    private UnifiedBannerView k;
    private final ADListenerAdapter l;
    private volatile ServerSideVerificationOptions m;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.k, (Activity) context, str, str2, str3, this.l);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedBannerADListener unifiedBannerADListener = this.g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void c(int i) {
        this.i = i;
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
    }

    public void destroy() {
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f19399a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.h.incrementAndGet();
                return;
            }
            T t = this.f19399a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.l.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.m = serverSideVerificationOptions;
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        int i = this.i;
        this.i = i;
        T t = this.f19399a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
        LoadAdParams loadAdParams = this.j;
        this.j = loadAdParams;
        T t2 = this.f19399a;
        if (t2 != 0) {
            ((UBVI) t2).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.m);
        while (this.h.getAndDecrement() > 0) {
            loadAD();
        }
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.h = new AtomicInteger(0);
        this.i = 30;
        this.j = null;
        this.g = unifiedBannerADListener;
        this.k = unifiedBannerView;
        this.l = new ADListenerAdapter(unifiedBannerADListener);
    }
}
