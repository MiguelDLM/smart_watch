package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdkWithMembers
/* loaded from: classes9.dex */
public class AuthApiStatusCodes extends CommonStatusCodes {

    @ShowFirstParty
    public static final int AUTH_API_ACCESS_FORBIDDEN = 3001;

    @ShowFirstParty
    public static final int AUTH_API_CLIENT_ERROR = 3002;

    @ShowFirstParty
    public static final int AUTH_API_INVALID_CREDENTIALS = 3000;

    @ShowFirstParty
    public static final int AUTH_API_SERVER_ERROR = 3003;

    @ShowFirstParty
    public static final int AUTH_APP_CERT_ERROR = 3006;

    @ShowFirstParty
    public static final int AUTH_TOKEN_ERROR = 3004;

    @ShowFirstParty
    public static final int AUTH_URL_RESOLUTION = 3005;

    private AuthApiStatusCodes() {
    }

    @NonNull
    public static String getStatusCodeString(int i) {
        switch (i) {
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case 3001:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case 3002:
                return "AUTH_API_CLIENT_ERROR";
            case 3003:
                return "AUTH_API_SERVER_ERROR";
            case 3004:
                return "AUTH_TOKEN_ERROR";
            case 3005:
                return "AUTH_URL_RESOLUTION";
            case 3006:
                return "AUTH_APP_CERT_ERROR";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
