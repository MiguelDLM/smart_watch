package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_kv.jad_kx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes10.dex */
public class jad_vi<Data, ResourceType, Transcode> {
    public final Pools.Pool<List<Throwable>> jad_an;
    public final List<? extends jad_kx<Data, ResourceType, Transcode>> jad_bo;
    public final String jad_cp;

    public jad_vi(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<jad_kx<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.jad_an = pool;
        this.jad_bo = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(list);
        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed LoadPath{");
        jad_an.append(cls.getSimpleName());
        jad_an.append("->");
        jad_an.append(cls2.getSimpleName());
        jad_an.append("->");
        jad_an.append(cls3.getSimpleName());
        jad_an.append(ooOOo0oXI.f33074oOoXoXO);
        this.jad_cp = jad_an.toString();
    }

    public jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_it.jad_er<Data> jad_erVar, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, int i, int i2, jad_kx.jad_an<ResourceType> jad_anVar) {
        List<Throwable> list = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_an.acquire());
        try {
            int size = this.jad_bo.size();
            jad_xk<Transcode> jad_xkVar = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    jad_xkVar = this.jad_bo.get(i3).jad_an(jad_erVar, i, i2, jad_jwVar, jad_anVar);
                } catch (jad_sf e) {
                    list.add(e);
                }
                if (jad_xkVar != null) {
                    break;
                }
            }
            if (jad_xkVar != null) {
                return jad_xkVar;
            }
            throw new jad_sf(this.jad_cp, new ArrayList(list));
        } finally {
            this.jad_an.release(list);
        }
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("LoadPath{decodePaths=");
        jad_an.append(Arrays.toString(this.jad_bo.toArray()));
        jad_an.append('}');
        return jad_an.toString();
    }
}
