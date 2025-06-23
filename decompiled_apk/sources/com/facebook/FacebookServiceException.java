package com.facebook;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FacebookServiceException extends FacebookException {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;

    @OXOo.OOXIXo
    private final FacebookRequestError requestError;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacebookServiceException(@OXOo.OOXIXo FacebookRequestError requestError, @OXOo.oOoXoXO String str) {
        super(str);
        IIX0o.x0xO0oo(requestError, "requestError");
        this.requestError = requestError;
    }

    @OXOo.OOXIXo
    public final FacebookRequestError getRequestError() {
        return this.requestError;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    @OXOo.OOXIXo
    public String toString() {
        String str = "{FacebookServiceException: httpResponseCode: " + this.requestError.getRequestStatusCode() + ", facebookErrorCode: " + this.requestError.getErrorCode() + ", facebookErrorType: " + this.requestError.getErrorType() + ", message: " + this.requestError.getErrorMessage() + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str, "StringBuilder()\n        .append(\"{FacebookServiceException: \")\n        .append(\"httpResponseCode: \")\n        .append(requestError.requestStatusCode)\n        .append(\", facebookErrorCode: \")\n        .append(requestError.errorCode)\n        .append(\", facebookErrorType: \")\n        .append(requestError.errorType)\n        .append(\", message: \")\n        .append(requestError.errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }
}
