package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig dU;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.ad.interstitial.f.b ib;
    public KsInterstitialAd.AdInteractionListener ie;

    /* renamed from: io, reason: collision with root package name */
    public com.kwad.components.ad.interstitial.d f18436io;
    public com.kwad.components.ad.interstitial.g.d jL;
    public boolean jM;
    public boolean jN;
    public boolean jO;
    public a jP;
    public com.kwad.components.core.webview.tachikoma.e.e jR;

    @NonNull
    public KSFrameLayout jS;
    public d jT;
    public boolean jX;
    public boolean jY;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public List<a> jQ = new CopyOnWriteArrayList();
    private Handler fS = new Handler(Looper.getMainLooper());
    public volatile boolean jW = false;
    public int jZ = -1;
    public List<a.c> jV = new CopyOnWriteArrayList();
    public List<InterfaceC0745c> jU = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.e.c$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ View fo;
        final /* synthetic */ Context gq;

        public AnonymousClass3(Context context, View view) {
            this.gq = context;
            this.fo = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.ad.interstitial.e.c.3.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.gq.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.gq.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass3.this.fo.post(new az() { // from class: com.kwad.components.ad.interstitial.e.c.3.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            AnonymousClass3.this.fo.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: classes11.dex */
    public interface a {
        void b(long j, long j2);
    }

    /* loaded from: classes11.dex */
    public static class b {
        private final Context context;
        private int kj;
        private boolean kk;
        private int kl;
        private boolean km;
        private ac.a kn;
        public double ko;
        public boolean kp;

        public b(Context context) {
            this.context = context;
        }

        public final b A(int i) {
            this.kl = i;
            return this;
        }

        public final b a(ac.a aVar) {
            this.kn = aVar;
            return this;
        }

        public final int cV() {
            return this.kj;
        }

        public final boolean cW() {
            return this.kk;
        }

        public final boolean cX() {
            return this.km;
        }

        public final int cY() {
            return this.kl;
        }

        public final double cZ() {
            return this.ko;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ac.a getTouchCoords() {
            return this.kn;
        }

        public final b k(boolean z) {
            this.kk = z;
            return this;
        }

        public final b l(boolean z) {
            this.km = true;
            return this;
        }

        public final b m(boolean z) {
            this.kp = true;
            return this;
        }

        public final b z(int i) {
            this.kj = i;
            return this;
        }

        public final b c(double d) {
            this.ko = d;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0745c {
        void da();
    }

    /* loaded from: classes11.dex */
    public interface d {
        void db();
    }

    public final boolean J(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dS(adTemplate));
        }
        com.kwad.sdk.core.e.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void b(a.c cVar) {
        this.jV.remove(cVar);
    }

    public final void cR() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        if (!this.jO && (adInteractionListener = this.ie) != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void cS() {
        d dVar = this.jT;
        if (dVar != null) {
            dVar.db();
        }
    }

    public final void cT() {
        Iterator<InterfaceC0745c> it = this.jU.iterator();
        while (it.hasNext()) {
            it.next().da();
        }
    }

    public final boolean cU() {
        boolean z;
        com.kwad.components.ad.interstitial.g.d dVar = this.jL;
        if (dVar != null && dVar.getParent() != null) {
            z = false;
        } else {
            z = true;
        }
        com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.fS.removeCallbacksAndMessages(null);
        this.jV.clear();
        this.jU.clear();
        com.kwad.components.ad.interstitial.f.b bVar = this.ib;
        if (bVar != null) {
            bVar.ub();
        }
    }

    public final void a(a.c cVar) {
        if (this.jV.contains(cVar)) {
            return;
        }
        this.jV.add(cVar);
    }

    public final void b(b bVar) {
        com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
        bVar2.f(bVar.getTouchCoords());
        if (!bVar.cW() && !bVar.km) {
            bVar.A(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cK(bVar.cY()).f(bVar.getTouchCoords()).cY(aj.ML() ? 2 : 1).l(bVar.cZ()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            long a2 = a(aVar);
            int b2 = b(this.eN);
            bVar2.ao(a2);
            bVar2.cS(b2);
        }
        this.jM = true;
        if (this.jO) {
            return;
        }
        b(1L, bVar.kl);
    }

    public final void a(final b bVar) {
        com.kwad.components.ad.interstitial.report.a.dN().a(this.mAdTemplate, 1L, bVar.kl);
        boolean z = bVar.cV() == 1;
        if (com.kwad.components.ad.interstitial.b.b.cH() || z || bVar.cX() || bVar.kp) {
            com.kwad.components.core.e.d.a.a(new a.C0788a(bVar.getContext()).ar(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z).al(1).am(bVar.kl).v(this.eN.getCurrentPosition()).an(bVar.cV()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(bVar);
                    c cVar = c.this;
                    if (cVar.f18436io != null && com.kwad.components.ad.interstitial.d.b.k(cVar.mAdTemplate)) {
                        c cVar2 = c.this;
                        cVar2.a(false, -1, cVar2.eN);
                        c.this.fS.postDelayed(new az() { // from class: com.kwad.components.ad.interstitial.e.c.1.1
                            @Override // com.kwad.sdk.utils.az
                            public final void doTask() {
                                c.this.f18436io.dismiss();
                                c.this.cR();
                            }
                        }, 500L);
                    }
                }
            }));
        }
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.dN().a(this.mAdTemplate, 6L, i);
        final int i4 = 9;
        com.kwad.components.core.e.d.a.a(new a.C0788a(context).ar(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(2).al(6).am(i).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i5 = i4;
                int i6 = i;
                cVar.a(i5, i6, context, 6L, i6);
            }
        }));
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.remove(aVar);
    }

    public final void b(long j, long j2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Iterator<a> it = this.jQ.iterator();
        while (it.hasNext()) {
            it.next().b(j, j2);
        }
        a aVar = this.jP;
        if (aVar != null) {
            aVar.b(j, j2);
        }
        if (this.jO || (adInteractionListener = this.ie) == null) {
            return;
        }
        adInteractionListener.onAdClicked();
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jW) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jW = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cR(i).cK(i2).cY(aj.ML() ? 2 : 1).Ca(), (JSONObject) null);
        this.jM = true;
        if (this.jO) {
            return;
        }
        b(j, j2);
    }

    private static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
        }
        return -1;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.add(aVar);
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aV(adInfo) && !aj.ML();
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bs(adInfo).getUrl();
        if (bh.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    public final void a(boolean z, int i, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        com.kwad.components.ad.interstitial.report.a.dN().a(this.mAdTemplate, br.k(this.jS, true));
        if (aVar != null) {
            j = a(aVar);
            a2 = b(aVar);
        } else {
            j = i;
            a2 = a(j, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z ? 14 : 1, j, a2, this.f18436io.getTimerHelper().getTime(), null);
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int a(long j, @NonNull AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float M = ((float) com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dS(adTemplate))) / 1000.0f;
        if (M != 0.0f) {
            return Math.round((((float) j) / M) * 100.0f);
        }
        return -1;
    }
}
