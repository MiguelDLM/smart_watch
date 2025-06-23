package com.adp.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;

/* loaded from: classes.dex */
public class i {

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.listener.b f4716a;
        final /* synthetic */ ADPFeedAdView b;

        public a(com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
            this.f4716a = bVar;
            this.b = aDPFeedAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.adp.sdk.listener.b bVar = this.f4716a;
            if (bVar != null) {
                bVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends VideoOperator.VideoLifecycleListener {
        @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
        public void onVideoEnd() {
        }

        @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
        public void onVideoPlay() {
        }

        @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
        public void onVideoStart() {
        }
    }

    /* loaded from: classes.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.listener.b f4717a;
        final /* synthetic */ ADPFeedAdView b;

        public c(com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
            this.f4717a = bVar;
            this.b = aDPFeedAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.adp.sdk.listener.b bVar = this.f4717a;
            if (bVar != null) {
                bVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.listener.b f4718a;
        final /* synthetic */ ADPFeedAdView b;

        public d(com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
            this.f4718a = bVar;
            this.b = aDPFeedAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.adp.sdk.listener.b bVar = this.f4718a;
            if (bVar != null) {
                bVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NativeAd f4719a;
        final /* synthetic */ Context b;

        public e(NativeAd nativeAd, Context context) {
            this.f4719a = nativeAd;
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4719a.getAppInfo().showPermissionPage(this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class f implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NativeAd f4720a;
        final /* synthetic */ Context b;

        public f(NativeAd nativeAd, Context context) {
            this.f4720a = nativeAd;
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4720a.getAppInfo().showPrivacyPolicy(this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NativeAd f4721a;
        final /* synthetic */ Context b;

        public g(NativeAd nativeAd, Context context) {
            this.f4721a = nativeAd;
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4721a.showAppDetailPage(this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.listener.b f4722a;
        final /* synthetic */ ADPFeedAdView b;

        public h(com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
            this.f4722a = bVar;
            this.b = aDPFeedAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.adp.sdk.listener.b bVar = this.f4722a;
            if (bVar != null) {
                bVar.a(this.b);
            }
        }
    }

    /* renamed from: com.adp.sdk.i$i, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ViewOnClickListenerC0093i implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.adp.sdk.listener.b f4723a;
        final /* synthetic */ ADPFeedAdView b;

        public ViewOnClickListenerC0093i(com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
            this.f4723a = bVar;
            this.b = aDPFeedAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.adp.sdk.listener.b bVar = this.f4723a;
            if (bVar != null) {
                bVar.a(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j extends AppDownloadButtonStyle {
        public j(Context context) {
            super(context);
            this.normalStyle.setTextColor(context.getResources().getColor(R.color.white));
            this.normalStyle.setBackground(context.getResources().getDrawable(R.drawable.adp_huawei_native_button_rounded_corners_shape));
            this.processingStyle.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    public static void a(Context context, View view, NativeAd nativeAd) {
        TextView textView = (TextView) view.findViewById(R.id.adp_huawei_ad_app_developer);
        TextView textView2 = (TextView) view.findViewById(R.id.adp_huawei_ad_app_version);
        textView.setText(nativeAd.getAppInfo().getDeveloperName());
        textView2.setText(context.getResources().getString(R.string.adp_huawei_app_version) + ":" + nativeAd.getAppInfo().getVersionName());
        TextView textView3 = (TextView) view.findViewById(R.id.adp_huawei_ad_privacy);
        TextView textView4 = (TextView) view.findViewById(R.id.adp_huawei_ad_permission);
        TextView textView5 = (TextView) view.findViewById(R.id.adp_huawei_ad_detail);
        textView4.setOnClickListener(new e(nativeAd, context));
        textView3.setOnClickListener(new f(nativeAd, context));
        textView5.setOnClickListener(new g(nativeAd, context));
    }

    public static View b(NativeAd nativeAd, ViewGroup viewGroup, com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
        int i;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adp_huawei_native_image_only_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) inflate.findViewById(R.id.adp_huawei_native_image_only_view);
        nativeView.setMediaView((MediaView) inflate.findViewById(R.id.adp_huawei_ad_media));
        nativeView.setCallToActionView(inflate.findViewById(R.id.adp_huawei_ad_call_to_action));
        inflate.findViewById(R.id.ads_huawei_close).setOnClickListener(new ViewOnClickListenerC0093i(bVar, aDPFeedAdView));
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        View callToActionView = nativeView.getCallToActionView();
        if (nativeAd.getCallToAction() != null) {
            i = 0;
        } else {
            i = 4;
        }
        callToActionView.setVisibility(i);
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View c(NativeAd nativeAd, ViewGroup viewGroup, com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
        int i;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adp_huawei_native_common_medium_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) inflate.findViewById(R.id.adp_huawei_native_medium_view);
        nativeView.setTitleView(inflate.findViewById(R.id.adp_huawei_ad_title));
        nativeView.setMediaView((MediaView) inflate.findViewById(R.id.adp_huawei_ad_media));
        nativeView.setAdSourceView(inflate.findViewById(R.id.adp_huawei_ad_source));
        nativeView.setCallToActionView(inflate.findViewById(R.id.adp_huawei_ad_call_to_action));
        inflate.findViewById(R.id.ads_huawei_close).setOnClickListener(new a(bVar, aDPFeedAdView));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        View adSourceView = nativeView.getAdSourceView();
        int i2 = 4;
        if (nativeAd.getAdSource() != null) {
            i = 0;
        } else {
            i = 4;
        }
        adSourceView.setVisibility(i);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        View callToActionView = nativeView.getCallToActionView();
        if (nativeAd.getCallToAction() != null) {
            i2 = 0;
        }
        callToActionView.setVisibility(i2);
        VideoOperator videoOperator = nativeAd.getVideoOperator();
        if (videoOperator.hasVideo()) {
            videoOperator.setVideoLifecycleListener(new b());
        }
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View d(NativeAd nativeAd, ViewGroup viewGroup, com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
        int i;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adp_huawei_native_small_image_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) inflate.findViewById(R.id.adp_huawei_native_small_view);
        nativeView.setTitleView(inflate.findViewById(R.id.adp_huawei_ad_title));
        nativeView.setMediaView((MediaView) inflate.findViewById(R.id.adp_huawei_ad_media));
        nativeView.setAdSourceView(inflate.findViewById(R.id.adp_huawei_ad_source));
        nativeView.setCallToActionView(inflate.findViewById(R.id.adp_huawei_ad_call_to_action));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        inflate.findViewById(R.id.ads_huawei_close).setOnClickListener(new c(bVar, aDPFeedAdView));
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        View adSourceView = nativeView.getAdSourceView();
        int i2 = 4;
        int i3 = 0;
        if (nativeAd.getAdSource() != null) {
            i = 0;
        } else {
            i = 4;
        }
        adSourceView.setVisibility(i);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        View callToActionView = nativeView.getCallToActionView();
        if (nativeAd.getCallToAction() != null) {
            i2 = 0;
        }
        callToActionView.setVisibility(i2);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.adp_huawei_ad_app_detail_layout);
        if (nativeAd.getInteractionType() != 2) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        if (nativeAd.getInteractionType() == 2) {
            a(viewGroup.getContext(), inflate, nativeAd);
        }
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View e(NativeAd nativeAd, ViewGroup viewGroup, com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
        int i;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adp_huawei_native_three_images_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) inflate.findViewById(R.id.adp_huawei_native_three_images);
        nativeView.setTitleView(inflate.findViewById(R.id.adp_huawei_ad_title));
        nativeView.setAdSourceView(inflate.findViewById(R.id.adp_huawei_ad_source));
        nativeView.setCallToActionView(inflate.findViewById(R.id.adp_huawei_ad_call_to_action));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.adp_huawei_image_view_1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.adp_huawei_image_view_2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.adp_huawei_image_view_3);
        inflate.findViewById(R.id.ads_huawei_close).setOnClickListener(new d(bVar, aDPFeedAdView));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        View adSourceView = nativeView.getAdSourceView();
        int i2 = 4;
        int i3 = 0;
        if (nativeAd.getAdSource() != null) {
            i = 0;
        } else {
            i = 4;
        }
        adSourceView.setVisibility(i);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        View callToActionView = nativeView.getCallToActionView();
        if (nativeAd.getCallToAction() != null) {
            i2 = 0;
        }
        callToActionView.setVisibility(i2);
        if (nativeAd.getImages() != null && nativeAd.getImages().size() >= 3) {
            imageView.setImageDrawable(nativeAd.getImages().get(0).getDrawable());
            imageView2.setImageDrawable(nativeAd.getImages().get(1).getDrawable());
            imageView3.setImageDrawable(nativeAd.getImages().get(2).getDrawable());
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.adp_huawei_ad_app_detail_layout);
        if (nativeAd.getInteractionType() != 2) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        if (nativeAd.getInteractionType() == 2) {
            a(viewGroup.getContext(), inflate, nativeAd);
        }
        nativeView.setNativeAd(nativeAd);
        return nativeView;
    }

    public static View a(NativeAd nativeAd, ViewGroup viewGroup, com.adp.sdk.listener.b bVar, ADPFeedAdView aDPFeedAdView) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adp_huawei_native_ad_with_app_download_btn_template, (ViewGroup) null);
        NativeView nativeView = (NativeView) inflate.findViewById(R.id.adp_huawei_native_app_download_button_view);
        nativeView.setTitleView(inflate.findViewById(R.id.adp_huawei_ad_title));
        nativeView.setMediaView((MediaView) inflate.findViewById(R.id.adp_huawei_ad_media));
        nativeView.setAdSourceView(inflate.findViewById(R.id.adp_huawei_ad_source));
        nativeView.setCallToActionView(inflate.findViewById(R.id.adp_huawei_ad_call_to_action));
        inflate.findViewById(R.id.ads_huawei_close).setOnClickListener(new h(bVar, aDPFeedAdView));
        ((TextView) nativeView.getTitleView()).setText(nativeAd.getTitle());
        nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(nativeAd.getAdSource());
        }
        nativeView.getAdSourceView().setVisibility(nativeAd.getAdSource() != null ? 0 : 4);
        if (nativeAd.getCallToAction() != null) {
            ((Button) nativeView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        ((LinearLayout) inflate.findViewById(R.id.adp_huawei_ad_app_detail_layout)).setVisibility(nativeAd.getInteractionType() == 2 ? 0 : 8);
        if (nativeAd.getInteractionType() == 2) {
            a(viewGroup.getContext(), inflate, nativeAd);
        }
        nativeView.setNativeAd(nativeAd);
        AppDownloadButton appDownloadButton = (AppDownloadButton) nativeView.findViewById(R.id.adp_huawei_app_download_btn);
        appDownloadButton.setAppDownloadButtonStyle(new j(viewGroup.getContext()));
        if (nativeView.register(appDownloadButton)) {
            appDownloadButton.setVisibility(0);
            appDownloadButton.refreshAppStatus();
            nativeView.getCallToActionView().setVisibility(8);
        } else {
            appDownloadButton.setVisibility(8);
            nativeView.getCallToActionView().setVisibility(0);
        }
        return nativeView;
    }
}
