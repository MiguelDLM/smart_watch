package com.huawei.hms.ads.nativead;

import android.view.View;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public interface INativeView {
    void destroy();

    View getAdSourceView();

    View getCallToActionView();

    ChoicesView getChoicesView();

    View getDescriptionView();

    View getIconView();

    View getImageView();

    View getMarketView();

    MediaView getMediaView();

    View getPriceView();

    View getRatingView();

    View getTitleView();

    void onViewUpdate();

    boolean register(AppDownloadButton appDownloadButton);

    void setAdSourceView(View view);

    void setCallToActionView(View view);

    void setChoicesView(ChoicesView choicesView);

    void setDescriptionView(View view);

    void setIconView(View view);

    void setImageView(View view);

    void setMarketView(View view);

    void setMediaView(MediaView mediaView);

    void setNativeAd(NativeAd nativeAd);

    void setPriceView(View view);

    void setRatingView(View view);

    void setTitleView(View view);

    void unregister(AppDownloadButton appDownloadButton);
}
