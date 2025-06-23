package com.kwad.sdk.commercial;

import OoOoXO0.xoXoI;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d {
    public static BusinessType aT(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return ca(e.dN(adTemplate));
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate aU(AdTemplate adTemplate) {
        String str;
        SceneImpl sceneImpl = adTemplate.mAdScene;
        AdMatrixInfo.MatrixTemplate matrixTemplate = null;
        if (sceneImpl == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.ce(adTemplate).adDataV2;
        int adStyle = sceneImpl.getAdStyle();
        if (adStyle != 2) {
            if (adStyle != 3) {
                if (adStyle != 4) {
                    if (adStyle != 13) {
                        str = "";
                    } else {
                        str = adDataV2.interstitialCardInfo.templateId;
                    }
                } else {
                    str = adDataV2.splashPlayCardTKInfo.templateId;
                }
            } else {
                str = adDataV2.fullScreenInfo.templateId;
            }
        } else {
            str = adDataV2.neoTKInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.b.b.cf(adTemplate).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdMatrixInfo.MatrixTemplate next = it.next();
            if (bh.isEquals(str, next.templateId)) {
                matrixTemplate = next;
                break;
            }
        }
        if (matrixTemplate == null) {
            matrixTemplate = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplate != null) {
            String str2 = matrixTemplate.templateId + xoXoI.f2670oxoX + matrixTemplate.templateVersionCode;
            JSONObject jSONObject = e.dS(adTemplate).adTkGreyConfig;
            if (jSONObject != null) {
                matrixTemplate.publishType = jSONObject.optInt(str2, 0);
            }
        }
        return matrixTemplate;
    }

    public static BusinessType ca(int i) {
        if (i == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i == 13) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i == 1) {
            return BusinessType.AD_FEED;
        }
        if (i == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    public static int cb(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }
}
