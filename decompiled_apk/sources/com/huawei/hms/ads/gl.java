package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;

/* loaded from: classes10.dex */
public class gl {
    private static final String Code = "AdSessionAgentFactory";

    public static hg Code(Context context, AdContentData adContentData, gf gfVar, boolean z) {
        ha Code2;
        if (adContentData == null || context == null) {
            return new go();
        }
        if (z && (gfVar == null || gfVar.getOpenMeasureView() == null)) {
            fb.V(Code, "MeasureView is null");
            return new go();
        }
        if (!gk.Code()) {
            return new go();
        }
        fb.Code(Code, "AdSessionAgent is avalible");
        gk gkVar = new gk();
        List<Om> aj = adContentData.aj();
        if (aj == null) {
            fb.V(Code, "Oms is null");
            return gkVar;
        }
        if (adContentData.t() != null || (adContentData.u() != null && "video/mp4".equals(adContentData.u().Code()))) {
            fb.V(Code, "Video adsession");
            hd hdVar = hd.VIDEO;
            hi hiVar = hi.VIEWABLE;
            hj hjVar = hj.NATIVE;
            Code2 = ha.Code(hdVar, hiVar, hjVar, hjVar, false);
        } else {
            Code2 = ha.Code(hd.NATIVE_DISPLAY, hi.VIEWABLE, hj.NATIVE, hj.NONE, false);
        }
        if (Code2 == null) {
            return gkVar;
        }
        fb.V(Code, "init adSessionAgent");
        gkVar.Code(context, aj, Code2);
        if (z) {
            gkVar.Code(gfVar.getOpenMeasureView());
        }
        return gkVar;
    }
}
