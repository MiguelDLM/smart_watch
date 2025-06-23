package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

@Deprecated
/* loaded from: classes9.dex */
public interface GoogleSignInApi {

    @NonNull
    public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

    @NonNull
    Intent getSignInIntent(@NonNull GoogleApiClient googleApiClient);

    @Nullable
    GoogleSignInResult getSignInResultFromIntent(@NonNull Intent intent);

    @NonNull
    PendingResult<Status> revokeAccess(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<Status> signOut(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    OptionalPendingResult<GoogleSignInResult> silentSignIn(@NonNull GoogleApiClient googleApiClient);
}
