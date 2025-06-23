package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class PropertyCollection implements AutoCloseable {
    private SafeHandle propertyHandle;

    public PropertyCollection(IntRef intRef) {
        this.propertyHandle = null;
        if (intRef != null) {
            this.propertyHandle = new SafeHandle(intRef.getValue(), SafeHandleType.PropertyCollection);
        }
    }

    private final native String getPropertyString(SafeHandle safeHandle, int i, String str, String str2);

    private final native long setPropertyString(SafeHandle safeHandle, int i, String str, String str2);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.propertyHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.propertyHandle = null;
        }
    }

    public String getProperty(PropertyId propertyId) {
        Contracts.throwIfNull(this.propertyHandle, "collection");
        return getPropertyString(this.propertyHandle, propertyId.getValue(), null, "");
    }

    public void setProperty(PropertyId propertyId, String str) {
        Contracts.throwIfNull(this.propertyHandle, "collection");
        Contracts.throwIfNull(str, "value");
        Contracts.throwIfFail(setPropertyString(this.propertyHandle, propertyId.getValue(), null, str));
    }

    public String getProperty(String str) {
        return getPropertyString(this.propertyHandle, -1, str, "");
    }

    public void setProperty(String str, String str2) {
        Contracts.throwIfNull(this.propertyHandle, "collection");
        Contracts.throwIfNullOrWhitespace(str, "name");
        Contracts.throwIfNull(str2, "value");
        Contracts.throwIfFail(setPropertyString(this.propertyHandle, -1, str, str2));
    }

    public String getProperty(String str, String str2) {
        Contracts.throwIfNull(this.propertyHandle, "collection");
        Contracts.throwIfNullOrWhitespace(str, "name");
        return getPropertyString(this.propertyHandle, -1, str, str2);
    }
}
