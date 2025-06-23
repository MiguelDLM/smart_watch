package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class ConnectionMessage implements AutoCloseable {
    private byte[] binaryMessage = null;
    private SafeHandle messageHandle;
    private PropertyCollection properties;

    public ConnectionMessage(long j) {
        this.messageHandle = null;
        this.properties = null;
        Contracts.throwIfNull(j, "message is null");
        this.messageHandle = new SafeHandle(j, SafeHandleType.ConnectionMessage);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.messageHandle, intRef));
        this.properties = new PropertyCollection(intRef);
    }

    private final native byte[] getMessageData(SafeHandle safeHandle, IntRef intRef);

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.messageHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.messageHandle = null;
        }
        PropertyCollection propertyCollection = this.properties;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.properties = null;
        }
        this.binaryMessage = null;
    }

    public byte[] getBinaryMessage() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        if (this.binaryMessage == null) {
            IntRef intRef = new IntRef(0L);
            this.binaryMessage = getMessageData(this.messageHandle, intRef);
            Contracts.throwIfFail(intRef.getValue());
        }
        return this.binaryMessage;
    }

    public String getPath() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        return this.properties.getProperty("connection.message.path");
    }

    public PropertyCollection getProperties() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        return this.properties;
    }

    public String getTextMessage() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        return this.properties.getProperty("connection.message.text.message");
    }

    public boolean isBinaryMessage() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        return this.properties.getProperty("connection.message.type").equals("binary");
    }

    public boolean isTextMessage() {
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        return this.properties.getProperty("connection.message.type").equals("text");
    }

    public String toString() {
        StringBuilder sb;
        String str;
        Contracts.throwIfNull(this.messageHandle, "messageHandle is null");
        if (isTextMessage()) {
            sb = new StringBuilder();
            sb.append("Path: ");
            sb.append(getPath());
            sb.append(", Type: text, Message: ");
            str = getTextMessage();
        } else {
            if (!isBinaryMessage()) {
                return "";
            }
            sb = new StringBuilder();
            sb.append("Path: ");
            sb.append(getPath());
            sb.append(", Type: binary, Size: ");
            sb.append(getBinaryMessage() == null ? 0 : getBinaryMessage().length);
            str = " bytes";
        }
        sb.append(str);
        return sb.toString();
    }
}
