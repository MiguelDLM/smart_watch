package com.kwad.sdk.core.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class b {
    public WebView OA;
    public ViewGroup Ph;
    public com.kwad.sdk.widget.e aEW;

    @Nullable
    public ag aEX;
    public boolean aEY = true;
    public boolean aEZ = true;
    private List<AdTemplate> aFa = null;
    private AdResultData mAdResultData;

    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> Hw() {
        List<AdTemplate> list = this.aFa;
        if (list != null && list.size() > 0) {
            return this.aFa;
        }
        return this.mAdResultData.getAdTemplateList();
    }

    public final boolean Hx() {
        if (Hw() != null && Hw().size() != 0) {
            return false;
        }
        return true;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate de(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        for (AdTemplate adTemplate : Hw()) {
            if (bh.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.ec(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aFa;
        if (list != null && list.size() > 0) {
            return this.aFa.get(0);
        }
        return com.kwad.sdk.core.response.b.c.n(this.mAdResultData);
    }

    public final AdResultData hl() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aFa != null) {
            AdResultData adResultData2 = new AdResultData();
            adResultData2.setAdTemplateList(this.aFa);
            return adResultData2;
        }
        return null;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aFa = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aFa = arrayList;
    }
}
