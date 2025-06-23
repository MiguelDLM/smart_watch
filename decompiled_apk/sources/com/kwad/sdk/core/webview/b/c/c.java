package com.kwad.sdk.core.webview.b.c;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.baidu.mobads.sdk.internal.an;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.bf;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class c {
    private static final List<String> aFP;

    static {
        ArrayList arrayList = new ArrayList();
        aFP = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add(NanoHTTPD.MIME_HTML);
        arrayList.add(bf.B);
        arrayList.add(bf.Z);
        arrayList.add(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
        arrayList.add("video/mp4");
        arrayList.add(MimeTypes.AUDIO_MPEG);
        arrayList.add(an.d);
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean fh(String str) {
        return aFP.contains(str);
    }
}
