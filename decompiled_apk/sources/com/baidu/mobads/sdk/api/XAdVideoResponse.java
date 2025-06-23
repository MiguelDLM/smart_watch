package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.api.NativeResponse;

/* loaded from: classes7.dex */
public class XAdVideoResponse implements PrerollVideoResponse {
    XAdNativeResponse adNativeResponse;

    /* renamed from: com.baidu.mobads.sdk.api.XAdVideoResponse$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.adNativeResponse = (XAdNativeResponse) nativeResponse;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getAdLogoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getAdLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getBaiduLogoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getBaiduLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getDesc() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getDesc();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getIconUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getIconUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getImageUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getImageUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getMaterialType() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[xAdNativeResponse.getMaterialType().ordinal()];
            if (i != 1) {
                if (i == 2 && this.adNativeResponse.getImageUrl().contains(".gif")) {
                    return "gif";
                }
            } else {
                return "video";
            }
        }
        return PrerollVideoResponse.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getTitle() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getTitle();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public String getVideoUrl() {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getVideoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void recordImpression(View view) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.recordImpression(view);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(View view, int i) {
        XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view, i);
        }
    }
}
