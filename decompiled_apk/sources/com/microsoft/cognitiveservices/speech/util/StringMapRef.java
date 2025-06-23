package com.microsoft.cognitiveservices.speech.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class StringMapRef {
    private Map<String, String> stringMap = new HashMap();

    public Map<String, String> getValue() {
        return this.stringMap;
    }

    public void setValue(String str, String str2) {
        this.stringMap.put(str, str2);
    }
}
