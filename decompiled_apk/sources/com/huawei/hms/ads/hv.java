package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.views.PPSBannerView;
import com.sma.smartv3.network.Api;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class hv extends fu<kf> implements il<kf> {
    private int B;
    private com.huawei.openalliance.ad.inter.i C;
    private RequestOptions D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Location L;
    private Context S;

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.r f17293a;
    private Integer b;
    private Integer c;
    private Integer d;
    private boolean e = false;
    private String f;

    /* loaded from: classes10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.e {
        private final WeakReference<hv> Code;

        public a(hv hvVar) {
            this.Code = new WeakReference<>(hvVar);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.e
        public void Code(final List<String> list) {
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.a.1
                @Override // java.lang.Runnable
                public void run() {
                    hv hvVar = (hv) a.this.Code.get();
                    if (hvVar == null) {
                        fb.I("BannerPresenter", "onInValidContentIdsGot presenter is null");
                    } else {
                        fb.V("BannerPresenter", "loadAd onInValidContentIdsGot");
                        hvVar.I().Code(list);
                    }
                }
            });
        }
    }

    public hv(Context context, kf kfVar) {
        Code((hv) kfVar);
        this.S = context != null ? context.getApplicationContext() : context;
    }

    private SourceParam Code(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        ed Code = ed.Code(this.S);
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        sourceParam.Code(Code == null ? 52428800 : Code.q());
        return sourceParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.F;
        if (gVar == null) {
            fb.I("BannerPresenter", "downLoadBitmap nativeAd is null");
            Code(com.huawei.openalliance.ad.constant.ah.y);
            return;
        }
        List<ImageInfo> B = gVar.B();
        if (com.huawei.openalliance.ad.utils.ad.Code(B)) {
            fb.I("BannerPresenter", "downLoadBitmap imageInfo is null");
            Code(com.huawei.openalliance.ad.constant.ah.y);
            return;
        }
        final ImageInfo imageInfo = B.get(0);
        Code(this.F);
        SourceParam Code = Code(imageInfo);
        Code.Code(this.Code);
        com.huawei.openalliance.ad.utils.z.Code(this.S, Code, this.F.a(), this.F.o(), new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.hv.4
            @Override // com.huawei.openalliance.ad.utils.an
            public void Code() {
                fb.I("BannerPresenter", "loadImage onFail");
                hv.this.Code(com.huawei.openalliance.ad.constant.ah.y);
            }

            @Override // com.huawei.openalliance.ad.utils.an
            public void Code(String str, final Drawable drawable) {
                if (TextUtils.equals(str, imageInfo.Z())) {
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hv.this.I().Code(drawable, hv.this.F);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.huawei.openalliance.ad.inter.data.g gVar;
        final long parseLong;
        if (this.B == 1 || (gVar = this.F) == null) {
            return;
        }
        String ax = gVar instanceof com.huawei.openalliance.ad.inter.data.l ? ((com.huawei.openalliance.ad.inter.data.l) gVar).ax() : null;
        fb.V("BannerPresenter", "setBannerRefresh: %s", ax);
        if (TextUtils.isEmpty(ax)) {
            return;
        }
        if ("N".equalsIgnoreCase(ax)) {
            parseLong = 0;
        } else if (Api.Y.equalsIgnoreCase(ax)) {
            parseLong = ed.Code(this.S).o();
        } else {
            try {
                parseLong = Long.parseLong(ax);
            } catch (NumberFormatException e) {
                fb.I("BannerPresenter", "parseIntOrDefault exception: " + e.getClass().getSimpleName());
                return;
            }
        }
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.3
            @Override // java.lang.Runnable
            public void run() {
                hv.this.I().Code(parseLong);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Context context, final ImageView imageView, final Drawable drawable) {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.hv.7
            @Override // java.lang.Runnable
            public void run() {
                final Drawable Code = com.huawei.openalliance.ad.utils.x.Code(context, drawable, 5.0f, 8.0f);
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setBackground(Code);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.il
    public boolean S() {
        return com.huawei.openalliance.ad.utils.w.Code(this.S);
    }

    @Override // com.huawei.hms.ads.il
    public void I(Integer num) {
        this.d = num;
    }

    @Override // com.huawei.hms.ads.il
    public void V(Integer num) {
        this.c = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.openalliance.ad.inter.data.g Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<com.huawei.openalliance.ad.inter.data.g> it2 = it.next().getValue().iterator();
            if (it2.hasNext()) {
                return it2.next();
            }
        }
        return null;
    }

    @Override // com.huawei.hms.ads.il
    public void V(String str) {
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.5
            @Override // java.lang.Runnable
            public void run() {
                hv.this.I().Code(i);
                if (i == 499) {
                    hv.this.I().B();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.il
    public void Code(final Context context, final ImageView imageView, Drawable drawable) {
        if (this.e) {
            try {
                if (drawable instanceof BitmapDrawable) {
                    imageView.setBackground(com.huawei.openalliance.ad.utils.x.Code(context, drawable, 5.0f, 8.0f));
                } else if (drawable instanceof ds) {
                    ((ds) drawable).Code(new ds.a() { // from class: com.huawei.hms.ads.hv.6
                        @Override // com.huawei.hms.ads.ds.a
                        public void Code(Bitmap bitmap) {
                            hv.this.V(context, imageView, new BitmapDrawable(context.getResources(), bitmap));
                        }
                    });
                }
            } catch (Throwable th) {
                fb.I("BannerPresenter", "set banner background encounter exception: " + th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.il
    public void Code(Location location) {
        this.L = location;
    }

    @Override // com.huawei.hms.ads.il
    public void Code(RequestOptions requestOptions) {
        this.D = requestOptions;
    }

    private void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.e = gVar.d_();
    }

    @Override // com.huawei.hms.ads.il
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.F = lVar;
        this.Code = lVar != null ? lVar.n() : null;
    }

    @Override // com.huawei.hms.ads.il
    public void Code(com.huawei.openalliance.ad.inter.data.r rVar) {
        this.f17293a = rVar;
    }

    @Override // com.huawei.hms.ads.il
    public void Code(Integer num) {
        this.b = num;
    }

    @Override // com.huawei.hms.ads.il
    public void Code(String str, int i, List<String> list, int i2) {
        if (str == null || str.isEmpty()) {
            fb.I("BannerPresenter", "adId is null or empty when load ad");
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.1
                @Override // java.lang.Runnable
                public void run() {
                    hv.this.I().Code(702);
                }
            });
            return;
        }
        fb.Code("BannerPresenter", "loadAd ,adId:%s", str);
        this.B = i2;
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(this.S, new String[]{str}, i, list);
        this.C = mVar;
        if (mVar instanceof com.huawei.openalliance.ad.inter.m) {
            mVar.Code(this.L);
            ((com.huawei.openalliance.ad.inter.m) this.C).Z(Integer.valueOf(this.B));
        }
        this.C.Code(c.Code(this.D));
        this.C.Code(this.b);
        com.huawei.openalliance.ad.inter.data.b bannerSize = (I() == null || !(I() instanceof PPSBannerView)) ? null : ((PPSBannerView) I()).getBannerSize();
        if (bannerSize != null) {
            this.C.V(Integer.valueOf(bannerSize.I()));
            this.C.I(Integer.valueOf(bannerSize.Z()));
        } else {
            this.C.V(this.c);
            this.C.I(this.d);
        }
        String str2 = this.f;
        if (str2 != null) {
            this.C.Z(str2);
        }
        com.huawei.openalliance.ad.inter.data.r rVar = this.f17293a;
        if (rVar != null) {
            this.C.Code(rVar.Code());
            this.C.Code(this.f17293a.V());
            this.C.V(this.f17293a.I());
            this.C.I(this.f17293a.Z());
        }
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.n() { // from class: com.huawei.hms.ads.hv.2
            @Override // com.huawei.openalliance.ad.inter.listeners.n
            public void Code(final int i3) {
                fb.Code("BannerPresenter", "loadAd onAdFailed");
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.hv.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hv.this.I().Code(i3);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.n
            public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
                fb.Code("BannerPresenter", "loadAd onAdsLoaded");
                hv hvVar = hv.this;
                hvVar.F = hvVar.Code(map);
                com.huawei.openalliance.ad.utils.h.V(new Runnable() { // from class: com.huawei.hms.ads.hv.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hv.this.D();
                    }
                });
                hv.this.F();
            }
        });
        this.C.Code(new a(this));
        this.C.Code(com.huawei.openalliance.ad.utils.n.I(this.S), null, false);
    }

    @Override // com.huawei.hms.ads.il
    public void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j) {
        if (gVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            AdContentData n = ((com.huawei.openalliance.ad.inter.data.l) gVar).n();
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(str);
            analysisEventReport.Code(n);
            analysisEventReport.Code(j);
            if (n != null) {
                analysisEventReport.D(n.aE());
                analysisEventReport.L(n.L());
                analysisEventReport.F(n.a());
                analysisEventReport.I(n.aF());
            }
            com.huawei.openalliance.ad.ipc.g.V(this.S).Code("rptAdInvalidEvt", com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
        }
    }

    @Override // com.huawei.hms.ads.il
    public boolean Code(com.huawei.openalliance.ad.inter.data.b bVar, float f) {
        if (!(I() instanceof PPSBannerView)) {
            return false;
        }
        PPSBannerView pPSBannerView = (PPSBannerView) I();
        Context applicationContext = pPSBannerView.getContext().getApplicationContext();
        int width = pPSBannerView.getWidth();
        int height = pPSBannerView.getHeight();
        if (fb.Code()) {
            fb.Code("BannerPresenter", "banner view width: %s, height: %s", Integer.valueOf(width), Integer.valueOf(height));
        }
        DisplayMetrics C = d.C(this.S);
        if (width > C.widthPixels || height > C.heightPixels) {
            fb.I("BannerPresenter", "Ad view is off screen");
            return false;
        }
        int Code = bVar.Code();
        int V = bVar.V();
        float f2 = Code - width;
        float f3 = Code;
        float f4 = V - height;
        float f5 = V;
        boolean z = f2 / f3 < f && f4 / f5 < f;
        if (!z) {
            float a2 = d.a(applicationContext);
            if (a2 > 0.0f) {
                fb.I("BannerPresenter", "Not enough space to show ad. Needs %s×%s dp, but only has %s×%s dp", Integer.valueOf(Math.round(f3 / a2)), Integer.valueOf(Math.round(f5 / a2)), Integer.valueOf(Math.round(width / a2)), Integer.valueOf(Math.round(height / a2)));
            }
        }
        return z;
    }
}
