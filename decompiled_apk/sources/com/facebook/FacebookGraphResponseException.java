package com.facebook;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class FacebookGraphResponseException extends FacebookException {

    @OXOo.oOoXoXO
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(@OXOo.oOoXoXO GraphResponse graphResponse, @OXOo.oOoXoXO String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    @OXOo.oOoXoXO
    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    @OXOo.OOXIXo
    public String toString() {
        FacebookRequestError error;
        GraphResponse graphResponse = this.graphResponse;
        if (graphResponse == null) {
            error = null;
        } else {
            error = graphResponse.getError();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        IIX0o.oO(sb, "StringBuilder().append(\"{FacebookGraphResponseException: \")");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (error != null) {
            sb.append("httpResponseCode: ");
            sb.append(error.getRequestStatusCode());
            sb.append(", facebookErrorCode: ");
            sb.append(error.getErrorCode());
            sb.append(", facebookErrorType: ");
            sb.append(error.getErrorType());
            sb.append(", message: ");
            sb.append(error.getErrorMessage());
            sb.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "errorStringBuilder.toString()");
        return sb2;
    }
}
