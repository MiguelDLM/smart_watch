package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.hms.ads.template.downloadbuttonstyle.d;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.c;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ch extends c.b {
    private String A;
    private a E;
    private Context u;
    private WeakReference<Context> v;
    private WeakReference<PPSNativeView> w;
    private AdContentData x;
    private com.huawei.openalliance.ad.inter.data.l y;
    private IPPSUiEngineCallback z;

    /* loaded from: classes10.dex */
    public static class a implements AppDownloadListener {
        private final WeakReference<ch> Code;

        public a(ch chVar) {
            this.Code = new WeakReference<>(chVar);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.download.app.k kVar, com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            ch chVar = this.Code.get();
            if (chVar == null) {
                return;
            }
            chVar.Code("onAppOpen", (String) null);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, int i) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
        }
    }

    public ch(Context context, PPSNativeView pPSNativeView, com.huawei.openalliance.ad.inter.data.l lVar) {
        this.u = context.getApplicationContext();
        this.v = new WeakReference<>(context);
        this.w = new WeakReference<>(pPSNativeView);
        this.y = lVar;
        this.x = lVar != null ? lVar.n() : null;
        if (lVar == null || lVar.y() == null) {
            return;
        }
        this.E = new a(this);
        com.huawei.openalliance.ad.download.a.Code().V(this.E);
    }

    private com.huawei.hms.ads.template.downloadbuttonstyle.a Code(int i, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        fb.Code("NativeProxy", "btnStyle: %s", Integer.valueOf(i));
        return 1 == i ? new d(this.u, appDownloadButton) : 2 == i ? new com.huawei.hms.ads.template.downloadbuttonstyle.c(this.u, appDownloadButton) : 3 == i ? new com.huawei.hms.ads.template.downloadbuttonstyle.e(this.u, appDownloadButton, remoteButtonStyleAttr) : new com.huawei.hms.ads.template.downloadbuttonstyle.b(this.u, appDownloadButton);
    }

    private boolean F() {
        return g.Code() != null && Integer.parseInt(g.Code()) >= 30468100;
    }

    private RemoteButtonStyleAttr I(Bundle bundle) {
        try {
            RemoteButtonStyleAttr remoteButtonStyleAttr = (RemoteButtonStyleAttr) com.huawei.openalliance.ad.utils.aa.V(bundle.getString(bn.a.V), RemoteButtonStyleAttr.class, new Class[0]);
            if (remoteButtonStyleAttr != null) {
                IBinder binder = bundle.getBinder(bn.a.I);
                if (binder != null) {
                    remoteButtonStyleAttr.Code((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder));
                }
                IBinder binder2 = bundle.getBinder(bn.a.Z);
                if (binder2 != null) {
                    remoteButtonStyleAttr.V((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder2));
                }
                IBinder binder3 = bundle.getBinder(bn.a.B);
                if (binder3 != null) {
                    remoteButtonStyleAttr.I((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder3));
                }
                IBinder binder4 = bundle.getBinder(bn.a.C);
                if (binder4 != null) {
                    remoteButtonStyleAttr.Z((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder4));
                }
                IBinder binder5 = bundle.getBinder(bn.a.D);
                if (binder5 != null) {
                    remoteButtonStyleAttr.B((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder5));
                }
                IBinder binder6 = bundle.getBinder(bn.a.L);
                if (binder6 != null) {
                    remoteButtonStyleAttr.F((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder6));
                }
                IBinder binder7 = bundle.getBinder(bn.a.f17376a);
                if (binder7 != null) {
                    remoteButtonStyleAttr.D((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder7));
                }
                IBinder binder8 = bundle.getBinder(bn.a.b);
                if (binder8 != null) {
                    remoteButtonStyleAttr.L((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder8));
                }
                IBinder binder9 = bundle.getBinder(bn.a.S);
                if (binder9 != null) {
                    remoteButtonStyleAttr.C((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder9));
                }
                IBinder binder10 = bundle.getBinder(bn.a.F);
                if (binder10 != null) {
                    remoteButtonStyleAttr.S((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder10));
                }
                remoteButtonStyleAttr.V(bundle.getString(bn.a.d));
                remoteButtonStyleAttr.I(bundle.getString(bn.a.e));
                remoteButtonStyleAttr.C(bundle.getString(bn.a.f));
                remoteButtonStyleAttr.I(bundle.getBoolean(bn.a.c, false));
                remoteButtonStyleAttr.Z(bundle.getString(bn.a.g));
                remoteButtonStyleAttr.B(bundle.getString(bn.a.h));
            }
            return remoteButtonStyleAttr;
        } catch (Throwable th) {
            fb.I("NativeProxy", "getAttrs err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    private void Z(Bundle bundle) {
        AdContentData adContentData = this.x;
        if (adContentData == null) {
            fb.V("NativeProxy", "contentRecord is null");
            return;
        }
        if (bundle != null) {
            try {
                if (adContentData.D() != null && this.x.D().equals(this.A)) {
                    fb.V("NativeProxy", "Duplicate escalation videoTime event for %s", this.x.D());
                    return;
                }
                this.x.B(bundle.getLong(bn.f.G));
                jc.V(this.u, this.x, com.huawei.openalliance.ad.constant.ai.h);
                this.A = this.x.D();
            } catch (Throwable th) {
                fb.I("NativeProxy", "reportPlayTime err: %s", th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean B() {
        try {
            Boolean bool = (Boolean) com.huawei.openalliance.ad.utils.ba.Code(new Callable<Boolean>() { // from class: com.huawei.hms.ads.ch.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    if (ch.this.x == null) {
                        return Boolean.FALSE;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("apiVer", ch.this.x.aF());
                        jSONObject.put("content_id", ch.this.x.a());
                        jSONObject.put("templateId", ch.this.x.aE());
                        jSONObject.put("slotid", ch.this.x.L());
                    } catch (Throwable th) {
                        fb.V("NativeProxy", "construct json err: %s", th.getClass().getSimpleName());
                    }
                    return Boolean.valueOf(Boolean.TRUE.toString().equals(com.huawei.openalliance.ad.ipc.b.Code(ch.this.u).Code(com.huawei.openalliance.ad.constant.s.y, jSONObject.toString(), String.class).getData()));
                }
            }, Boolean.FALSE);
            boolean booleanValue = bool.booleanValue();
            fb.Code("NativeProxy", "result = %s", bool);
            return booleanValue;
        } catch (Throwable th) {
            fb.V("NativeProxy", "downloadVideos err: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void C() {
        com.huawei.openalliance.ad.download.a.Code().I(this.E);
    }

    private RemoteButtonStyleAttr V(Bundle bundle) {
        if (new ef(bundle).i(bn.a.Code) != 3) {
            return null;
        }
        return I(bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public String I() {
        AdContentData adContentData = this.x;
        if (adContentData != null) {
            return adContentData.D();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean Z() {
        return this.y.ah();
    }

    private String Code(boolean z, String str, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (remoteButtonStyleAttr == null) {
            return str;
        }
        if (z) {
            return remoteButtonStyleAttr.v();
        }
        int l_ = this.y.l_();
        return ((l_ == 1 || l_ == 3) && !TextUtils.isEmpty(remoteButtonStyleAttr.v())) ? remoteButtonStyleAttr.v() : str;
    }

    private void I(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        fb.V("NativeProxy", "update btn style");
        RemoteButtonStyleAttr V = V(bundle);
        if (V == null) {
            fb.I("NativeProxy", "attr null");
        } else {
            Code(iObjectWrapper, 3, V);
        }
    }

    private com.huawei.openalliance.ad.views.AppDownloadButton V(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (!(view instanceof com.huawei.openalliance.ad.views.AppDownloadButton)) {
            return null;
        }
        com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
        if (this.w.get() == null) {
            return null;
        }
        return appDownloadButton;
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code() {
        PPSNativeView pPSNativeView = this.w.get();
        if (pPSNativeView != null) {
            pPSNativeView.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V() {
    }

    private void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
        String str;
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        fb.V("NativeProxy", "update btn text");
        RemoteButtonStyleAttr V = V(bundle);
        if (V == null) {
            str = "attr null";
        } else {
            com.huawei.openalliance.ad.views.AppDownloadButton V2 = V(iObjectWrapper);
            if (V2 != null) {
                Code(V, V2);
                return;
            }
            str = "btn null";
        }
        fb.I("NativeProxy", str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(int i) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.y;
        if (lVar == null || lVar.y() == null) {
            return;
        }
        if (i == 0) {
            fb.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: DESC");
            Context context = this.v.get();
            if (context == null) {
                fb.V("NativeProxy", "jump context is null.");
                return;
            }
            PPSNativeView pPSNativeView = this.w.get();
            if (pPSNativeView == null || pPSNativeView.getClickInfo() == null) {
                this.y.V(context);
                return;
            } else {
                fb.Code("NativeProxy", pPSNativeView.getClickInfo().toString());
                this.y.Code(context, pPSNativeView.getClickInfo());
                return;
            }
        }
        if (i == 1) {
            fb.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: Privacy");
            this.y.y().Code(this.u);
        } else {
            if (i != 2) {
                return;
            }
            fb.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: Permission");
            if (!TextUtils.isEmpty(this.y.y().t())) {
                this.y.y().V(this.u);
                return;
            }
            PPSNativeView pPSNativeView2 = this.w.get();
            if (pPSNativeView2 != null) {
                com.huawei.openalliance.ad.download.app.j.Code(pPSNativeView2.getContext(), this.y.y());
            }
        }
    }

    private void Code(int i, String str, VideoInfo videoInfo) {
        if (videoInfo != null) {
            videoInfo.I(Boolean.TRUE.toString());
            videoInfo.Code(i);
            videoInfo.Code(str);
        }
    }

    private void V(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        appDownloadButton.setOnDownloadStatusChangedListener(new AppDownloadButton.e() { // from class: com.huawei.hms.ads.ch.3
            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
            public void Code(com.huawei.openalliance.ad.download.app.k kVar) {
                fb.Code("NativeProxy", "onStatusChanged: %s", kVar);
                if (kVar == null) {
                    kVar = com.huawei.openalliance.ad.download.app.k.DOWNLOAD;
                }
                ch.this.Code("onStatusChanged", kVar.name());
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
            public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
                ch.this.Code("onUserCancel", (String) null);
            }
        });
    }

    public void Code(long j) {
        fb.Code("NativeProxy", "updateStartShowTime: %s", Long.valueOf(j));
        com.huawei.openalliance.ad.inter.data.l lVar = this.y;
        if (lVar != null) {
            lVar.Code(j);
        }
        AdContentData adContentData = this.x;
        if (adContentData == null) {
            return;
        }
        adContentData.Z(j);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(String str, long j, long j2, int i, int i2) {
        jc.Code(this.u, this.x, com.huawei.openalliance.ad.constant.ai.f, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(long j, long j2) {
        cy.Code(this.u, this.x, j, j2);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals(com.huawei.openalliance.ad.constant.ai.h)) {
            Z(bundle);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(Bundle bundle) {
    }

    private void Code(Bundle bundle, PPSNativeView pPSNativeView, int i, String str) {
        if (this.y.av() == null || this.y.av().intValue() != 3) {
            return;
        }
        try {
            if (fb.Code()) {
                fb.Code("NativeProxy", "video_info: %s, preview_image_info: %s, video_alias %s", bundle.getString(com.huawei.openalliance.ad.constant.bb.aO), bundle.getString(com.huawei.openalliance.ad.constant.bb.aP), bundle.getString(com.huawei.openalliance.ad.constant.bb.aQ));
            }
            com.huawei.openalliance.ad.beans.metadata.VideoInfo videoInfo = (com.huawei.openalliance.ad.beans.metadata.VideoInfo) com.huawei.openalliance.ad.utils.aa.V(bundle.getString(com.huawei.openalliance.ad.constant.bb.aO), com.huawei.openalliance.ad.beans.metadata.VideoInfo.class, new Class[0]);
            if (videoInfo != null) {
                VideoInfo videoInfo2 = new VideoInfo(videoInfo);
                videoInfo2.Code(i);
                videoInfo2.I(Boolean.TRUE.toString());
                videoInfo2.Code(str);
                pPSNativeView.setVideoInfo(videoInfo2);
            }
            ImageInfo imageInfo = (ImageInfo) com.huawei.openalliance.ad.utils.aa.V(bundle.getString(com.huawei.openalliance.ad.constant.bb.aP), ImageInfo.class, new Class[0]);
            if (imageInfo != null) {
                com.huawei.openalliance.ad.inter.data.ImageInfo imageInfo2 = new com.huawei.openalliance.ad.inter.data.ImageInfo(imageInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageInfo2);
                pPSNativeView.setImageInfos(arrayList);
            }
            pPSNativeView.setVideoAlias(bundle.getString(com.huawei.openalliance.ad.constant.bb.aQ));
        } catch (Throwable th) {
            fb.I("NativeProxy", "resetMetaDataAndProgress ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.w.get();
            if (view == null || pPSNativeView == null) {
                return;
            }
            pPSNativeView.showFeedback(view);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, int i) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.w.get();
            if (pPSNativeView != null) {
                pPSNativeView.Code(view, i, true);
            }
        }
    }

    private void Code(IObjectWrapper iObjectWrapper, int i, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        com.huawei.openalliance.ad.views.AppDownloadButton V = V(iObjectWrapper);
        if (V == null) {
            fb.I("NativeProxy", "btn null");
        } else {
            fb.V("NativeProxy", "update btn style start");
            new com.huawei.hms.ads.template.downloadbuttonstyle.e(this.u, V, remoteButtonStyleAttr).Code(this.u);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.w.get();
            int i = bundle.getInt(bn.c.Code);
            String string = bundle.getString("click_info");
            boolean z = bundle.getBoolean(bn.f.u, true);
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.aa.V(string, MaterialClickInfo.class, new Class[0]);
            int i2 = bundle.getInt(com.huawei.openalliance.ad.constant.bb.q);
            String string2 = bundle.getString(com.huawei.openalliance.ad.constant.bb.r, "n");
            Code(i2, string2, this.y.C());
            if (pPSNativeView != null) {
                Code(bundle, pPSNativeView, i2, string2);
                pPSNativeView.setMaterialClickInfo(materialClickInfo);
                pPSNativeView.Code(view, i, z);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str) {
        Code(iObjectWrapper, str, 0, (RemoteButtonStyleAttr) null);
    }

    private void Code(IObjectWrapper iObjectWrapper, String str, int i, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof com.huawei.openalliance.ad.views.AppDownloadButton) {
                fb.V("NativeProxy", "registerDownloadBtn");
                final com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
                final PPSNativeView pPSNativeView = this.w.get();
                com.huawei.hms.ads.template.downloadbuttonstyle.a Code = Code(i, appDownloadButton, remoteButtonStyleAttr);
                boolean F = F();
                if (pPSNativeView != null) {
                    if (!Code(F, remoteButtonStyleAttr != null && remoteButtonStyleAttr.w())) {
                        if (this.y.l_() == 0) {
                            view.setVisibility(8);
                            return;
                        }
                        fb.Code("NativeProxy", "show btn");
                        appDownloadButton.Code(new View.OnClickListener() { // from class: com.huawei.hms.ads.ch.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                PPSNativeView pPSNativeView2 = pPSNativeView;
                                if (pPSNativeView2 != null) {
                                    pPSNativeView2.Code((View) appDownloadButton, 1, true);
                                }
                            }
                        });
                        Code.Code(Code(F, str, remoteButtonStyleAttr));
                        appDownloadButton.I();
                        return;
                    }
                    if (pPSNativeView.Code((kc) appDownloadButton)) {
                        fb.Code("NativeProxy", "register succ");
                        Code(F, remoteButtonStyleAttr, appDownloadButton, str);
                        Code(appDownloadButton);
                        appDownloadButton.setNeedAppendProgress(true);
                        Code.Code(this.u);
                        appDownloadButton.I();
                    } else {
                        view.setVisibility(8);
                    }
                    V(appDownloadButton);
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        int i = bundle.getInt(bn.a.Code);
        if (3 == i) {
            RemoteButtonStyleAttr I = I(bundle);
            if (I != null) {
                Code(iObjectWrapper, str, i, I);
                return;
            }
            i = 2;
        }
        Code(iObjectWrapper, str, i, (RemoteButtonStyleAttr) null);
    }

    private void Code(RemoteButtonStyleAttr remoteButtonStyleAttr, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        if (remoteButtonStyleAttr == null) {
            fb.I("NativeProxy", "reset err, attr is null");
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.r())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.r());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.s())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.s());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.t())) {
            appDownloadButton.setRemoteBfDlBtnTxt(remoteButtonStyleAttr.t());
        }
        if (TextUtils.isEmpty(remoteButtonStyleAttr.u())) {
            return;
        }
        appDownloadButton.setRemoteAfDlBtnText(remoteButtonStyleAttr.u());
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
        this.z = iPPSUiEngineCallback;
    }

    private void Code(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo;
        MetaData i_ = this.y.i_();
        if (i_ == null || i_.e() == null || (appInfo = appDownloadButton.getAppInfo()) == null) {
            return;
        }
        ApkInfo e = i_.e();
        e.i(appInfo.l());
        e.j(appInfo.m());
    }

    public void Code(String str) {
        fb.Code("NativeProxy", "updateContent: %s", str);
        com.huawei.openalliance.ad.inter.data.l lVar = this.y;
        if (lVar != null) {
            lVar.B(str);
        }
        AdContentData adContentData = this.x;
        if (adContentData == null) {
            return;
        }
        adContentData.I(str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, int i) {
        PPSNativeView pPSNativeView = this.w.get();
        if (!com.huawei.openalliance.ad.constant.ai.e.equals(str)) {
            if (pPSNativeView != null) {
                pPSNativeView.Code(Integer.valueOf(i), false);
                return;
            }
            return;
        }
        jb.a aVar = new jb.a();
        aVar.V(Integer.valueOf(i));
        String Code = com.huawei.openalliance.ad.utils.bc.Code((fw) pPSNativeView);
        com.huawei.openalliance.ad.inter.data.l lVar = this.y;
        if (lVar != null) {
            fb.Code("NativeProxy", "slotId: %s, contentId: %s, slot pos: %s", lVar.o(), this.y.a(), Code);
        }
        if (!com.huawei.openalliance.ad.utils.ay.Code(Code)) {
            aVar.B(Code);
        }
        if (pPSNativeView != null) {
            aVar.I(com.huawei.openalliance.ad.utils.b.Code(pPSNativeView));
        }
        jc.Code(this.u, this.x, aVar.Code(), com.huawei.openalliance.ad.constant.ai.e);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x003e. Please report as an issue. */
    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, long j, long j2, int i, int i2) {
        Context context;
        AdContentData adContentData;
        Long valueOf;
        Long valueOf2;
        Integer valueOf3;
        Integer valueOf4;
        String str2;
        Context context2;
        AdContentData adContentData2;
        Integer num;
        Integer num2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1891923166:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.C)) {
                    c = 0;
                    break;
                }
                break;
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.B)) {
                    c = 1;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.Z)) {
                    c = 2;
                    break;
                }
                break;
            case 1540819073:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.S)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                context = this.u;
                adContentData = this.x;
                valueOf = Long.valueOf(j);
                valueOf2 = Long.valueOf(j2);
                valueOf3 = Integer.valueOf(i);
                valueOf4 = Integer.valueOf(i2);
                str2 = com.huawei.openalliance.ad.constant.ai.C;
                jc.Code(context, adContentData, str2, valueOf, valueOf2, valueOf3, valueOf4);
                return;
            case 1:
                context2 = this.u;
                adContentData2 = this.x;
                num = null;
                num2 = null;
                str3 = com.huawei.openalliance.ad.constant.ai.B;
                jc.Code(context2, adContentData2, str3, (Long) null, (Long) null, num, num2);
                return;
            case 2:
                context = this.u;
                adContentData = this.x;
                valueOf = Long.valueOf(j);
                valueOf2 = Long.valueOf(j2);
                valueOf3 = Integer.valueOf(i);
                valueOf4 = Integer.valueOf(i2);
                str2 = com.huawei.openalliance.ad.constant.ai.Z;
                jc.Code(context, adContentData, str2, valueOf, valueOf2, valueOf3, valueOf4);
                return;
            case 3:
                context2 = this.u;
                adContentData2 = this.x;
                num = null;
                num2 = null;
                str3 = com.huawei.openalliance.ad.constant.ai.S;
                jc.Code(context2, adContentData2, str3, (Long) null, (Long) null, num, num2);
                return;
            default:
                return;
        }
    }

    public void Code(String str, Bundle bundle) {
        if (this.z == null) {
            fb.I("NativeProxy", "on call back, call back is null");
            return;
        }
        fb.V("NativeProxy", "onCallback, method: %s", str);
        try {
            this.z.onCallResult(str, bundle);
        } catch (Throwable th) {
            fb.I("NativeProxy", "onCallback ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fb.V("NativeProxy", "callMethod: %s", str);
        str.hashCode();
        if (str.equals("update_btn_txt")) {
            V(iObjectWrapper, bundle);
        } else if (str.equals("update_btn_style")) {
            I(iObjectWrapper, bundle);
        } else {
            fb.V("NativeProxy", "call method fall to default.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("app_status_method", str);
        if (str2 != null) {
            bundle.putString("app_status", str2);
        }
        Code("notifyAppStatus", bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(boolean z) {
        jc.Code(this.u, this.x, z);
    }

    private void Code(boolean z, RemoteButtonStyleAttr remoteButtonStyleAttr, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, String str) {
        int l_ = this.y.l_();
        if (remoteButtonStyleAttr == null) {
            if (l_ == 2 || l_ == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
            return;
        }
        if (z) {
            Code(remoteButtonStyleAttr, appDownloadButton);
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.r())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.r());
        }
        if (l_ != 8 && !TextUtils.isEmpty(remoteButtonStyleAttr.s())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.s());
        } else {
            if (l_ == 2 || l_ == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
        }
    }

    private boolean Code(boolean z, boolean z2) {
        if (z) {
            return z2;
        }
        int l_ = this.y.l_();
        return l_ == 2 || l_ == 5 || l_ == 4 || l_ == 8 || (l_ == 3 && this.y.y() != null);
    }
}
