package com.alimm.tanx.core.view.player.cache.videocache.headers;

import java.util.HashMap;
import java.util.Map;

public class EmptyHeadersInjector implements HeaderInjector {
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
