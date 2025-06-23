package com.alimm.tanx.core.bridge;

import java.util.AbstractMap;

public interface JsHandler {
    void handler(AbstractMap<String, Object> abstractMap, Callback callback);
}
