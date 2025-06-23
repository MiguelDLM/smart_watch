package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class d {
    public static long dE(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dI(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dF(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return "";
        }
        return dI(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dG(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return "";
        }
        return dI(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean dH(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null || !e.dK(adTemplate)) {
            return false;
        }
        return dI(adTemplate).slideClick;
    }

    @NonNull
    private static AdStyleInfo dI(@NonNull AdTemplate adTemplate) {
        return e.dS(adTemplate).adStyleInfo;
    }

    public static List<String> dJ(@NonNull AdTemplate adTemplate) {
        AdStyleInfo dI = dI(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = dI.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
