package com.microsoft.cognitiveservices.speech.util;

/* loaded from: classes11.dex */
public class JsonValue implements AutoCloseable {
    private int item;
    private SafeHandle parserHandle;

    public JsonValue(int i, SafeHandle safeHandle) {
        this.item = i;
        this.parserHandle = safeHandle;
    }

    public static JsonValue Parse(String str) {
        return JsonValueJNI.createParser(str);
    }

    public boolean asBoolean() {
        return JsonValueJNI.asBoolean(this.parserHandle, this.item);
    }

    public float asFloat() {
        return JsonValueJNI.asFloat(this.parserHandle, this.item);
    }

    public long asInt() {
        return JsonValueJNI.asInt(this.parserHandle, this.item);
    }

    public String asJson() {
        return JsonValueJNI.asJson(this.parserHandle, this.item);
    }

    public String asString() {
        return JsonValueJNI.asString(this.parserHandle, this.item);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        SafeHandle safeHandle = this.parserHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.parserHandle = null;
        }
    }

    public int count() {
        return JsonValueJNI.count(this.parserHandle, this.item);
    }

    public JsonValue get(int i) {
        return JsonValueJNI.getValue(this.parserHandle, this.item, i, null);
    }

    public String getName(int i) {
        return JsonValueJNI.getName(this.parserHandle, this.item, i, null);
    }

    public boolean hasValue(int i) {
        return JsonValueJNI.hasValue(this.parserHandle, this.item, i, null);
    }

    public JsonValue get(String str) {
        return JsonValueJNI.getValue(this.parserHandle, this.item, 0, str);
    }

    public boolean hasValue(String str) {
        return JsonValueJNI.hasValue(this.parserHandle, this.item, 0, str);
    }
}
