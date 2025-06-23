package com.baidu.navisdk.asr.query;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, c> f6558a = new HashMap();

    public c a(String str) {
        c cVar = this.f6558a.get(str);
        if (cVar != null) {
            return cVar;
        }
        if (TextUtils.equals(str, TtmlNode.COMBINE_ALL)) {
            return new c(MaterialSearchView.f18521Xx000oIo, MaterialSearchView.f18521Xx000oIo, MaterialSearchView.f18521Xx000oIo);
        }
        return new c(3, 2, 1);
    }

    public void a(String str, c cVar) {
        this.f6558a.put(str, cVar);
    }
}
