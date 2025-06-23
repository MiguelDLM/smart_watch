package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: classes11.dex */
public final class e {
    public static boolean F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dS = dS(adTemplate);
        if (a.aE(dS) || a.cS(dS) || ea(adTemplate) != 3) {
            return false;
        }
        return true;
    }

    @Nullable
    private static g FR() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.uh();
        }
        return null;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (c(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j, int i) {
        AdTemplate a2 = a(list, j, i);
        if (a2 == null) {
            return false;
        }
        long ec = ec(a2);
        int dM = dM(a2);
        if (i > 0) {
            if (ec != j || dM != i) {
                return false;
            }
        } else if (ec != j) {
            return false;
        }
        return true;
    }

    public static boolean c(AdTemplate adTemplate, long j, int i) {
        long ec = ec(adTemplate);
        int dM = dM(adTemplate);
        if (i > 0) {
            if (ec != j || dM != i) {
                return false;
            }
        } else if (ec != j) {
            return false;
        }
        return true;
    }

    public static boolean dK(@NonNull AdTemplate adTemplate) {
        if (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) {
            return false;
        }
        return true;
    }

    public static long dL(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int dM(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int dN(AdTemplate adTemplate) {
        if (adTemplate != null) {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle != 0) {
                return sceneImpl.getAdStyle();
            }
            return dM(adTemplate);
        }
        return 0;
    }

    public static int dO(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long dP(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String dQ(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String dR(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo dS(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo;
        if (adTemplate.adInfoList.size() > 0) {
            adInfo = adTemplate.adInfoList.get(0);
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            com.kwad.sdk.core.e.c.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo dT(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String dU(@NonNull AdTemplate adTemplate) {
        if (dK(adTemplate)) {
            return a.K(dS(adTemplate));
        }
        return h.a(dT(adTemplate));
    }

    public static String dV(@NonNull AdTemplate adTemplate) {
        return dS(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String dW(@NonNull AdTemplate adTemplate) {
        String FV;
        g FR = FR();
        if (FR == null) {
            FV = "";
        } else {
            FV = FR.FV();
        }
        if (TextUtils.isEmpty(FV)) {
            return FV;
        }
        return a.X(dS(adTemplate));
    }

    public static String dX(@NonNull AdTemplate adTemplate) {
        if (dK(adTemplate)) {
            return a.cg(dS(adTemplate));
        }
        g FR = FR();
        if (FR == null) {
            return "";
        }
        return FR.FW();
    }

    public static long dY(@NonNull AdTemplate adTemplate) {
        if (dK(adTemplate)) {
            return a.aa(dS(adTemplate));
        }
        g FR = FR();
        if (FR == null) {
            return adTemplate.hashCode();
        }
        return FR.FX();
    }

    public static int dZ(@NonNull AdTemplate adTemplate) {
        g FR = FR();
        if (FR == null) {
            return 0;
        }
        return FR.FY();
    }

    public static int ea(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return dS(adTemplate).adBaseInfo.taskType;
    }

    public static String eb(@NonNull AdTemplate adTemplate) {
        if (dK(adTemplate)) {
            return a.cD(dS(adTemplate));
        }
        return h.c(dT(adTemplate));
    }

    public static long ec(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dS(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean ed(AdTemplate adTemplate) {
        if (dS(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow) {
            return true;
        }
        return false;
    }

    public static boolean ee(@NonNull AdTemplate adTemplate) {
        int l = l(adTemplate, true);
        if (l == 1 || l == 2) {
            return true;
        }
        return false;
    }

    public static boolean ef(@NonNull AdTemplate adTemplate) {
        int l = l(adTemplate, false);
        if (l != 1 && l != 2) {
            return false;
        }
        return true;
    }

    public static int eg(@NonNull AdTemplate adTemplate) {
        return dS(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean eh(@NonNull AdTemplate adTemplate) {
        AdInfo dS = dS(adTemplate);
        int dM = dM(adTemplate);
        if (dS.adStyleConfInfo.adPushDownloadJumpType == 0 && dM == 17 && a.aE(dS)) {
            return true;
        }
        return false;
    }

    public static int ei(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.zA();
            }
            return 800;
        }
        return adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static boolean k(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dS = dS(adTemplate);
        if (!a.aE(dS) || a.cS(dS) || z || ea(adTemplate) != 2) {
            return false;
        }
        return true;
    }

    public static int l(@NonNull AdTemplate adTemplate, boolean z) {
        int i;
        AdInfo dS = dS(adTemplate);
        if (dM(adTemplate) == 3) {
            if (z) {
                i = dS.adMatrixInfo.adDataV2.actionBarInfo.cardType;
            } else {
                i = dS.adMatrixInfo.adDataV2.endCardInfo.cardType;
            }
            if (i == 5) {
                return 1;
            }
            if (i == 6) {
                return 2;
            }
            return -1;
        }
        return dS.adBaseInfo.mABParams.playableStyle;
    }
}
