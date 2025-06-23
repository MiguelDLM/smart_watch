package com.google.android.gms.fido.u2f.api.messagebased;

import androidx.annotation.NonNull;
import com.google.android.gms.fido.u2f.api.messagebased.RequestType;

@Deprecated
/* loaded from: classes9.dex */
public enum ResponseType {
    REGISTER("u2f_register_response"),
    SIGN("u2f_sign_response");

    private final String zzb;

    ResponseType(String str) {
        this.zzb = str;
    }

    @NonNull
    public static ResponseType getResponseTypeForRequestType(@NonNull RequestType requestType) throws RequestType.UnsupportedRequestTypeException {
        if (requestType != null) {
            int ordinal = requestType.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    return SIGN;
                }
                throw new RequestType.UnsupportedRequestTypeException(requestType.toString());
            }
            return REGISTER;
        }
        throw new RequestType.UnsupportedRequestTypeException(null);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.zzb;
    }
}
