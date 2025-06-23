package com.aliyun.sls.android.producer;

import XI0IXoo.II0xO0;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Log {
    private final Map<String, String> content = new LinkedHashMap();
    private final Object lock = new Object();
    private long logTime = II0xO0.II0xO0();

    private String numberToString(Number number) {
        try {
            return JSONObject.numberToString(number);
        } catch (JSONException unused) {
            return "";
        }
    }

    public Map<String, String> getContent() {
        Map<String, String> map;
        synchronized (this.lock) {
            map = this.content;
        }
        return map;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void putContent(String str, String str2) {
        synchronized (this.lock) {
            this.content.put(str, str2);
        }
    }

    public void putContents(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            synchronized (this.lock) {
                this.content.putAll(new LinkedHashMap(map));
            }
        }
    }

    @Deprecated
    public void setLogTime(long j) {
        this.logTime = j;
    }

    public void putContent(String str, int i) {
        synchronized (this.lock) {
            this.content.put(str, String.valueOf(i));
        }
    }

    public void putContent(String str, long j) {
        synchronized (this.lock) {
            this.content.put(str, String.valueOf(j));
        }
    }

    public void putContent(String str, boolean z) {
        synchronized (this.lock) {
            this.content.put(str, String.valueOf(z));
        }
    }

    public void putContent(String str, float f) {
        synchronized (this.lock) {
            this.content.put(str, String.valueOf(f));
        }
    }

    public void putContent(String str, double d) {
        synchronized (this.lock) {
            this.content.put(str, String.valueOf(d));
        }
    }

    public void putContent(String str, JSONObject jSONObject) {
        synchronized (this.lock) {
            try {
                if (jSONObject != null) {
                    this.content.put(str, jSONObject.toString());
                } else {
                    this.content.put(str, "null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putContent(String str, JSONArray jSONArray) {
        synchronized (this.lock) {
            try {
                if (jSONArray != null) {
                    this.content.put(str, jSONArray.toString());
                } else {
                    this.content.put(str, "null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putContent(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            jSONObject2 = new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
            jSONObject2 = null;
        }
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                Object opt = jSONObject2.opt(next);
                if (opt != null && JSONObject.NULL != opt && !(opt instanceof Boolean)) {
                    if (opt instanceof JSONObject) {
                        linkedHashMap.put(next, ((JSONObject) opt).toString());
                    } else if (opt instanceof JSONArray) {
                        linkedHashMap.put(next, ((JSONArray) opt).toString());
                    } else if (opt instanceof Number) {
                        linkedHashMap.put(next, numberToString((Number) opt));
                    } else {
                        linkedHashMap.put(next, opt.toString());
                    }
                } else {
                    linkedHashMap.put(next, String.valueOf(opt));
                }
            }
        }
        putContents(linkedHashMap);
    }
}
