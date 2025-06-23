package com.huawei.hms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;

@GlobalApi
/* loaded from: classes10.dex */
public class AppDownloadButton extends com.huawei.openalliance.ad.views.AppDownloadButton implements IAppDownloadButton, AppDownloadButton.e, AppDownloadButton.f {
    private OnDownloadStatusChangedListener C;
    private OnNonWifiDownloadListener S;

    /* renamed from: com.huawei.hms.ads.AppDownloadButton$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADFAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @GlobalApi
    /* loaded from: classes10.dex */
    public interface OnDownloadStatusChangedListener {
        void onStatusChanged(AppDownloadStatus appDownloadStatus);

        void onUserCancel(String str, String str2);
    }

    @GlobalApi
    /* loaded from: classes10.dex */
    public interface OnNonWifiDownloadListener {
        boolean onNonWifiDownload(long j);
    }

    /* loaded from: classes10.dex */
    public class a extends com.huawei.openalliance.ad.views.a {
        private a.C0672a F;
        private AppDownloadButtonStyle S;

        public a(Context context, AppDownloadButtonStyle appDownloadButtonStyle) {
            super(context);
            this.F = new a.C0672a();
            this.S = appDownloadButtonStyle;
            Code(this.V, appDownloadButtonStyle.normalStyle);
            Code(this.I, this.S.processingStyle);
            Code(this.Z, this.S.installingStyle);
        }

        @Override // com.huawei.openalliance.ad.views.a
        public a.C0672a Code(Context context, com.huawei.openalliance.ad.download.app.k kVar) {
            AppDownloadButtonStyle.Style style = this.S.getStyle(context, AppDownloadButton.this.I(kVar));
            AppDownloadButtonStyle appDownloadButtonStyle = this.S;
            if (style == appDownloadButtonStyle.processingStyle) {
                return this.I;
            }
            if (style == appDownloadButtonStyle.installingStyle) {
                return this.Z;
            }
            if (style == appDownloadButtonStyle.normalStyle) {
                return this.V;
            }
            Code(this.F, style);
            return this.F;
        }

        private void Code(a.C0672a c0672a, AppDownloadButtonStyle.Style style) {
            c0672a.Code(style.getBackground());
            c0672a.Code(style.getTextColor());
            c0672a.V(style.getTextSize());
            c0672a.Code(style.getTypeface());
        }
    }

    @GlobalApi
    public AppDownloadButton(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadStatus I(com.huawei.openalliance.ad.download.app.k kVar) {
        if (kVar == null) {
            return AppDownloadStatus.DOWNLOAD;
        }
        switch (AnonymousClass1.Code[kVar.ordinal()]) {
            case 1:
                return AppDownloadStatus.WAITING;
            case 2:
                return AppDownloadStatus.DOWNLOADING;
            case 3:
                return AppDownloadStatus.PAUSE;
            case 4:
                return AppDownloadStatus.RESUME;
            case 5:
                return AppDownloadStatus.DOWNLOADED;
            case 6:
                return AppDownloadStatus.DOWNLOADFAILED;
            case 7:
                return AppDownloadStatus.INSTALLING;
            case 8:
                return AppDownloadStatus.INSTALL;
            case 9:
                return AppDownloadStatus.INSTALLED;
            default:
                return AppDownloadStatus.DOWNLOAD;
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.kc, com.huawei.hms.ads.IAppDownloadButton
    public void cancel() {
        super.cancel();
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void continueDownload() {
        super.continueDownload();
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public AppDownloadStatus refreshAppStatus() {
        return I(super.I());
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setAllowedNonWifiNetwork(boolean z) {
        super.setAllowedNonWifiNetwork(z);
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle) {
        if (appDownloadButtonStyle != null) {
            super.setAppDownloadButtonStyle(new a(getContext(), appDownloadButtonStyle));
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnDownloadStatusChangedListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        if (onDownloadStatusChangedListener != null) {
            this.C = onDownloadStatusChangedListener;
            super.setOnDownloadStatusChangedListener(this);
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnNonWifiDownloadListener(OnNonWifiDownloadListener onNonWifiDownloadListener) {
        if (onNonWifiDownloadListener != null) {
            this.S = onNonWifiDownloadListener;
            super.setOnNonWifiDownloadListener(this);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setShowPermissionDialog(boolean z) {
        super.setShowPermissionDialog(z);
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
    public void Code(com.huawei.openalliance.ad.download.app.k kVar) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.C;
        if (onDownloadStatusChangedListener != null) {
            onDownloadStatusChangedListener.onStatusChanged(I(kVar));
        }
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.C;
        if (onDownloadStatusChangedListener == null || appInfo == null) {
            return;
        }
        onDownloadStatusChangedListener.onUserCancel(appInfo.Code(), appInfo.e());
    }

    @GlobalApi
    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.f
    public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j) {
        OnNonWifiDownloadListener onNonWifiDownloadListener = this.S;
        if (onNonWifiDownloadListener != null) {
            return onNonWifiDownloadListener.onNonWifiDownload(j);
        }
        return false;
    }

    @GlobalApi
    public AppDownloadButton(Context context, Boolean bool) {
        super(context, bool);
    }
}
