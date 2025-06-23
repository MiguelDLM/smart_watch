package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.fw;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class fu<V extends fw> implements fv<V> {
    private static final String V = "BasePresenter";
    private String B;
    protected AdContentData Code;
    private V I;
    private Map<String, Boolean> Z = new HashMap();

    private boolean V(String str) {
        return this.Z.containsKey(str) && this.Z.get(str).booleanValue();
    }

    public String B() {
        return com.huawei.openalliance.ad.utils.bc.Code(I());
    }

    public String C() {
        V v = this.I;
        if (v instanceof View) {
            return jp.Code((View) v);
        }
        return null;
    }

    public void Code(long j) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    @Override // com.huawei.hms.ads.fv
    public V I() {
        return this.I;
    }

    public void Z() {
        Map<String, Boolean> map = this.Z;
        if (map == null) {
            return;
        }
        map.clear();
    }

    public void Code(Context context, long j) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            fb.V(V, "contentRecord is null");
            return;
        }
        if (adContentData.D() != null && this.Code.D().equals(this.B)) {
            fb.V(V, "Duplicate escalation videoTime event for %s", this.Code.D());
            return;
        }
        this.Code.B(j);
        jc.V(context, this.Code, com.huawei.openalliance.ad.constant.ai.h);
        this.B = this.Code.D();
    }

    public void Code(Context context, long j, long j2) {
        String str;
        if (j >= j2) {
            str = "complete";
            if (V("complete")) {
                return;
            }
        } else {
            long j3 = j2 / 4;
            if (j > 3 * j3) {
                str = com.huawei.openalliance.ad.constant.cu.Z;
                if (V(com.huawei.openalliance.ad.constant.cu.Z)) {
                    return;
                }
            } else if (j > j2 / 2) {
                str = com.huawei.openalliance.ad.constant.cu.I;
                if (V(com.huawei.openalliance.ad.constant.cu.I)) {
                    return;
                }
            } else if (j > j3) {
                str = com.huawei.openalliance.ad.constant.cu.V;
                if (V(com.huawei.openalliance.ad.constant.cu.V)) {
                    return;
                }
            } else {
                if (j <= 0) {
                    return;
                }
                str = "start";
                if (V("start")) {
                    return;
                }
            }
        }
        jc.I(context, this.Code, str);
        this.Z.put(str, Boolean.TRUE);
    }

    @Override // com.huawei.hms.ads.fv
    public void Code(V v) {
        this.I = v;
    }

    public void Code(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.I(str);
        Z();
    }
}
