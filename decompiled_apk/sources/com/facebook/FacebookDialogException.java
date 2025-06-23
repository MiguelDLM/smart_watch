package com.facebook;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FacebookDialogException extends FacebookException {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private final int errorCode;

    @OXOo.oOoXoXO
    private final String failingUrl;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public FacebookDialogException(@OXOo.oOoXoXO String str, int i, @OXOo.oOoXoXO String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @OXOo.oOoXoXO
    public final String getFailingUrl() {
        return this.failingUrl;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    @OXOo.OOXIXo
    public String toString() {
        String str = "{FacebookDialogException: errorCode: " + this.errorCode + ", message: " + getMessage() + ", url: " + this.failingUrl + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str, "StringBuilder()\n        .append(\"{FacebookDialogException: \")\n        .append(\"errorCode: \")\n        .append(errorCode)\n        .append(\", message: \")\n        .append(message)\n        .append(\", url: \")\n        .append(failingUrl)\n        .append(\"}\")\n        .toString()");
        return str;
    }
}
