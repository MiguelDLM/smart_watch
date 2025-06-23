package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.at;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes10.dex */
public interface g extends d, Serializable {

    /* loaded from: classes10.dex */
    public static class a {
        public static g Code(String str) {
            Serializable V = at.V(str);
            if (V instanceof AdContentData) {
                return new l((AdContentData) V);
            }
            return null;
        }

        public static String Code(g gVar) {
            if (gVar instanceof l) {
                return at.Code(((l) gVar).Code);
            }
            return null;
        }
    }

    List<ImageInfo> B();

    VideoInfo C();

    ImageInfo Z();

    boolean d_();

    List<FeedbackInfo> e_();

    List<String> m();

    List<String> p();
}
