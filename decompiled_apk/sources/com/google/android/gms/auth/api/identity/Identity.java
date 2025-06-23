package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbaf;
import com.google.android.gms.internal.p000authapi.zbap;
import com.google.android.gms.internal.p000authapi.zbz;

/* loaded from: classes9.dex */
public final class Identity {
    private Identity() {
    }

    @NonNull
    public static AuthorizationClient getAuthorizationClient(@NonNull Activity activity) {
        return new zbz((Activity) Preconditions.checkNotNull(activity), new zbb(null).zbb());
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Activity activity) {
        return new zbaf((Activity) Preconditions.checkNotNull(activity), new zbh());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Activity activity) {
        return new zbap((Activity) Preconditions.checkNotNull(activity), new zbu());
    }

    @NonNull
    public static AuthorizationClient getAuthorizationClient(@NonNull Context context) {
        return new zbz((Context) Preconditions.checkNotNull(context), new zbb(null).zbb());
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Context context) {
        return new zbaf((Context) Preconditions.checkNotNull(context), new zbh());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Context context) {
        return new zbap((Context) Preconditions.checkNotNull(context), new zbu());
    }
}
