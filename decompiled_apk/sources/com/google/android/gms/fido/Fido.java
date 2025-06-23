package com.google.android.gms.fido;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.Fido2ApiClient;
import com.google.android.gms.fido.fido2.Fido2PrivilegedApiClient;
import com.google.android.gms.fido.u2f.U2fApiClient;
import com.google.android.gms.internal.fido.zzaa;
import com.google.android.gms.internal.fido.zzab;

/* loaded from: classes9.dex */
public class Fido {

    @NonNull
    public static final String FIDO2_KEY_CREDENTIAL_EXTRA = "FIDO2_CREDENTIAL_EXTRA";

    @NonNull
    @Deprecated
    public static final String FIDO2_KEY_ERROR_EXTRA = "FIDO2_ERROR_EXTRA";

    @NonNull
    @Deprecated
    public static final String FIDO2_KEY_RESPONSE_EXTRA = "FIDO2_RESPONSE_EXTRA";

    @NonNull
    public static final String KEY_RESPONSE_EXTRA = "RESPONSE_EXTRA";

    @NonNull
    public static final Api.ClientKey zza;

    @NonNull
    public static final Api zzb;
    public static final zzaa zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzb = new Api("Fido.U2F_ZERO_PARTY_API", new zzab(), clientKey);
        zzc = new zzaa();
    }

    private Fido() {
    }

    @NonNull
    public static Fido2ApiClient getFido2ApiClient(@NonNull Activity activity) {
        return new Fido2ApiClient(activity);
    }

    @NonNull
    public static Fido2PrivilegedApiClient getFido2PrivilegedApiClient(@NonNull Activity activity) {
        return new Fido2PrivilegedApiClient(activity);
    }

    @NonNull
    public static U2fApiClient getU2fApiClient(@NonNull Activity activity) {
        return new U2fApiClient(activity);
    }

    @NonNull
    public static Fido2ApiClient getFido2ApiClient(@NonNull Context context) {
        return new Fido2ApiClient(context);
    }

    @NonNull
    public static Fido2PrivilegedApiClient getFido2PrivilegedApiClient(@NonNull Context context) {
        return new Fido2PrivilegedApiClient(context);
    }

    @NonNull
    public static U2fApiClient getU2fApiClient(@NonNull Context context) {
        return new U2fApiClient(context);
    }
}
