package com.alimm.tanx.core.view.player.cache.videocache.headers;

import java.util.Map;

public interface HeaderInjector {
    Map<String, String> addHeaders(String str);
}
