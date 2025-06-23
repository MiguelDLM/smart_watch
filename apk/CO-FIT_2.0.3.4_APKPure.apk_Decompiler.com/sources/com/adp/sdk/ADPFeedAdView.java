package com.adp.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adp.sdk.listener.b;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.hms.ads.nativead.NativeAd;
import com.octopus.ad.NativeAdResponse;
import com.qq.e.ads.nativ.NativeExpressADView;
import xXoOI00O.oIX0oI;

public class ADPFeedAdView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private oIX0oI f657a;
    private NativeAdResponse b;
    private Context c;
    private NativeExpressADView d;
    private TTNativeExpressAd e;
    private FrameLayout f = null;
    private View g;
    private NativeAd h;
    private b i;
    private boolean j = false;

    public ADPFeedAdView(Context context, View view) {
        super(context);
        this.g = view;
        this.f = (FrameLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adp_feed_view, this, true);
    }

    private void a(Context context, View view) {
        this.c = context;
        FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adp_feed_view, this, true);
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }

    public View b(NativeAd nativeAd, ViewGroup viewGroup) {
        View a2;
        if (this.h == null || (a2 = a(nativeAd, viewGroup)) == null) {
            return null;
        }
        return a2;
    }

    public void destroy() {
        NativeExpressADView nativeExpressADView = this.d;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
        TTNativeExpressAd tTNativeExpressAd = this.e;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        NativeAdResponse nativeAdResponse = this.b;
        if (nativeAdResponse != null) {
            nativeAdResponse.destroy();
        }
        NativeAd nativeAd = this.h;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    public View getHuaWeiAdView() {
        return b(this.h, this.f);
    }

    public void render() {
        View huaWeiAdView;
        NativeExpressADView nativeExpressADView = this.d;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
        TTNativeExpressAd tTNativeExpressAd = this.e;
        if (tTNativeExpressAd != null && !this.j) {
            tTNativeExpressAd.render();
            this.j = true;
        }
        if (this.g != null) {
            this.f.removeAllViews();
            this.f.addView(this.g);
        }
        NativeAdResponse nativeAdResponse = this.b;
        if (nativeAdResponse != null) {
            nativeAdResponse.OxxIIOOXO(this, this.f657a);
        }
        if (this.h != null && (huaWeiAdView = getHuaWeiAdView()) != null) {
            this.f.removeAllViews();
            this.f.addView(huaWeiAdView);
        }
    }

    public void setNativeHuaweiAd(NativeAd nativeAd) {
        this.h = nativeAd;
    }

    public void setView(View view) {
        this.f.removeAllViews();
        this.f.addView(view);
    }

    public View a(NativeAd nativeAd, ViewGroup viewGroup) {
        int creativeType = nativeAd.getCreativeType();
        if (creativeType == 2 || creativeType == 102) {
            return i.b(nativeAd, viewGroup, this.i, this);
        }
        if (creativeType == 3 || creativeType == 6) {
            return i.c(nativeAd, viewGroup, this.i, this);
        }
        if (creativeType == 103 || creativeType == 106) {
            return i.a(nativeAd, viewGroup, this.i, this);
        }
        if (creativeType == 7 || creativeType == 107) {
            return i.d(nativeAd, viewGroup, this.i, this);
        }
        if (creativeType == 8 || creativeType == 108) {
            return i.e(nativeAd, viewGroup, this.i, this);
        }
        return null;
    }

    public ADPFeedAdView(Context context, NativeExpressADView nativeExpressADView) {
        super(context);
        this.d = nativeExpressADView;
        a(context, (View) nativeExpressADView);
    }

    public ADPFeedAdView(Context context, oIX0oI oix0oi, NativeAdResponse nativeAdResponse) {
        super(context);
        this.b = nativeAdResponse;
        this.c = context;
        this.f657a = oix0oi;
        this.f = (FrameLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adp_feed_view, this, true);
    }

    public ADPFeedAdView(Context context, TTNativeExpressAd tTNativeExpressAd) {
        super(context);
        this.e = tTNativeExpressAd;
        this.f = (FrameLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adp_feed_view, this, true);
    }

    public ADPFeedAdView(Context context, NativeAd nativeAd, b bVar) {
        super(context);
        this.h = nativeAd;
        this.f = (FrameLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adp_feed_view, this, true);
        this.i = bVar;
    }
}
