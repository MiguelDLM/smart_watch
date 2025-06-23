package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class jf {
    private static final String Code = "TemplateActionProcessor";
    private static jf I;
    private static final byte[] V = new byte[0];
    private String B = null;
    private String C = null;
    private WeakReference<Context> S;
    private Context Z;

    private jf(Context context) {
        this.Z = context.getApplicationContext();
    }

    public static jf Code(Context context) {
        return V(context);
    }

    private static jf V(Context context) {
        jf jfVar;
        synchronized (V) {
            try {
                if (I == null) {
                    I = new jf(context);
                }
                if (context instanceof Activity) {
                    I.S = new WeakReference<>(context);
                }
                jfVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jfVar;
    }

    public void I(AdContentData adContentData, Bundle bundle) {
        int i = -1;
        try {
            i = bundle.getInt(bn.f.m);
            if (!bundle.getBoolean(bn.f.v, true)) {
                com.huawei.openalliance.ad.uriaction.q.Code(this.Z, adContentData, new HashMap(0)).Code();
            }
        } catch (Throwable th) {
            fb.V(Code, "get errCode err: %s", th.getClass().getSimpleName());
        }
        Code(adContentData, i);
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        jb.a aVar = new jb.a();
        aVar.Code((Long) null).Code((Integer) null).V((Integer) 14).I(com.huawei.openalliance.ad.utils.b.Code(context)).Code(str).B(String.format("%s,%s", 0, 0));
        jc.Code(this.Z, adContentData, aVar.Code());
    }

    public void V(AdContentData adContentData) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            if (adContentData != null || HiAd.getInstance(this.Z).getExtensionActionListener() == null) {
                return;
            }
            HiAd.getInstance(this.Z).getExtensionActionListener().V(null);
            return;
        }
        String str = this.B;
        if (str == null || !str.equals(adContentData.aa())) {
            fb.V(Code, "onDismiss");
            this.B = adContentData.aa();
            HiAd.getInstance(this.Z).getExtensionActionListener().V(adContentData.aa());
        }
    }

    public void Code(AdContentData adContentData) {
        fb.V(Code, "onPrepare");
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.aa());
    }

    public void V(AdContentData adContentData, Bundle bundle) {
        try {
            fb.V(Code, "onClose");
            jc.Code(this.Z, adContentData, bundle.getInt(bn.f.e), bundle.getInt(bn.f.f), com.huawei.openalliance.ad.constant.ai.f17372a);
            V(adContentData);
        } catch (Throwable th) {
            fb.I(Code, "onClose err: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(AdContentData adContentData, int i) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        String str = this.C;
        if (str == null || !str.equals(adContentData.aa())) {
            fb.V(Code, "onFail");
            this.C = adContentData.aa();
            HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.aa(), i);
        }
    }

    public boolean V(Context context, AdContentData adContentData, Bundle bundle, String str) {
        fb.V(Code, "onEasterEggClick");
        return Code(context, adContentData, bundle, str, com.huawei.openalliance.ad.constant.s.c);
    }

    public void Code(AdContentData adContentData, Bundle bundle) {
        Context context;
        try {
            fb.V(Code, "onEnd");
            Long valueOf = Long.valueOf(bundle.getLong(bn.f.g));
            Long valueOf2 = Long.valueOf(bundle.getLong("endTime"));
            Integer valueOf3 = Integer.valueOf(bundle.getInt(bn.f.i));
            Integer valueOf4 = Integer.valueOf(bundle.getInt(bn.f.j));
            if (bundle.getBoolean(bn.f.w, false)) {
                HashMap hashMap = new HashMap();
                hashMap.put(com.huawei.openalliance.ad.constant.bb.r, bundle.getString(com.huawei.openalliance.ad.constant.bb.r));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.q, String.valueOf(bundle.getInt(com.huawei.openalliance.ad.constant.bb.q)));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.p, String.valueOf(10));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.aP, bundle.getString(com.huawei.openalliance.ad.constant.bb.aP));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.m, bundle.getString(com.huawei.openalliance.ad.constant.bb.m));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.s, bundle.getString(com.huawei.openalliance.ad.constant.bb.s));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.aO, bundle.getString(com.huawei.openalliance.ad.constant.bb.aO));
                VideoInfo videoInfo = (VideoInfo) com.huawei.openalliance.ad.utils.aa.V(bundle.getString(com.huawei.openalliance.ad.constant.bb.aO), VideoInfo.class, new Class[0]);
                if (videoInfo != null) {
                    videoInfo.I(Boolean.TRUE.toString());
                    videoInfo.Code(bundle.getInt(com.huawei.openalliance.ad.constant.bb.q));
                    videoInfo.Code(bundle.getString(com.huawei.openalliance.ad.constant.bb.r));
                }
                ImageInfo imageInfo = (ImageInfo) com.huawei.openalliance.ad.utils.aa.V(bundle.getString(com.huawei.openalliance.ad.constant.bb.aP), ImageInfo.class, new Class[0]);
                if (imageInfo != null) {
                    com.huawei.openalliance.ad.inter.data.ImageInfo imageInfo2 = new com.huawei.openalliance.ad.inter.data.ImageInfo(imageInfo);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(imageInfo2);
                    hashMap.put(com.huawei.openalliance.ad.constant.bb.aP, com.huawei.openalliance.ad.utils.aa.Code(arrayList));
                }
                hashMap.put(com.huawei.openalliance.ad.constant.bb.aO, com.huawei.openalliance.ad.utils.aa.Code(videoInfo));
                hashMap.put(com.huawei.openalliance.ad.constant.bb.aQ, bundle.getString(com.huawei.openalliance.ad.constant.bb.aQ));
                Context context2 = this.Z;
                WeakReference<Context> weakReference = this.S;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    context2 = context;
                }
                com.huawei.openalliance.ad.uriaction.q.Code(context2, adContentData, hashMap).Code();
            }
            jc.Code(this.Z, adContentData, com.huawei.openalliance.ad.constant.ai.L, valueOf, valueOf2, valueOf3, valueOf4);
            V(adContentData);
        } catch (Throwable th) {
            fb.I(Code, "onEnd err: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(AdContentData adContentData, String str) {
        fb.V(Code, "onShow");
        jb.a aVar = new jb.a();
        aVar.I(str);
        aVar.B(com.huawei.openalliance.ad.constant.x.dt);
        jc.Code(this.Z, adContentData, aVar.Code(), com.huawei.openalliance.ad.constant.ai.b);
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().I(adContentData.aa());
    }

    public boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str) {
        fb.V(Code, "onClick");
        return Code(context, adContentData, bundle, str, com.huawei.openalliance.ad.constant.s.B);
    }

    private boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str, String str2) {
        try {
            int i = bundle.getInt(bn.f.e);
            int i2 = bundle.getInt(bn.f.f);
            int i3 = bundle.getInt(bn.f.k);
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.aa.V(bundle.getString("click_info"), MaterialClickInfo.class, new Class[0]);
            com.huawei.openalliance.ad.uriaction.p Code2 = com.huawei.openalliance.ad.uriaction.q.Code(context, adContentData, new HashMap(0));
            if (materialClickInfo != null) {
                materialClickInfo.V(str2);
            }
            if (Code2.Code()) {
                if (str2.equals(com.huawei.openalliance.ad.constant.s.B)) {
                    Code(context, adContentData, (materialClickInfo == null || !com.huawei.openalliance.ad.utils.ay.L(materialClickInfo.I())) ? null : materialClickInfo.I());
                }
                jc.Code(this.Z, adContentData, i, i2, Code2.I(), i3, materialClickInfo, str, (int[]) null);
                if (HiAd.getInstance(this.Z).getExtensionActionListener() != null) {
                    HiAd.getInstance(this.Z).getExtensionActionListener().Z(adContentData.aa());
                }
                return true;
            }
        } catch (Throwable th) {
            fb.I(Code, "deal with click err: %s", th.getClass().getSimpleName());
        }
        return false;
    }
}
