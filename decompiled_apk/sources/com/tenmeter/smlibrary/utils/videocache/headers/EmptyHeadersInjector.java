package com.tenmeter.smlibrary.utils.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.tenmeter.smlibrary.utils.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
