package com.google.android.gms.auth.account;

import android.accounts.Account;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
/* loaded from: classes9.dex */
public interface WorkAccountApi {

    @Deprecated
    /* loaded from: classes9.dex */
    public interface AddAccountResult extends Result {
        @NonNull
        Account getAccount();
    }

    @NonNull
    @Deprecated
    PendingResult<AddAccountResult> addWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    @Deprecated
    PendingResult<Result> removeWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull Account account);

    @Deprecated
    void setWorkAuthenticatorEnabled(@NonNull GoogleApiClient googleApiClient, boolean z);

    @NonNull
    @Deprecated
    PendingResult<Result> setWorkAuthenticatorEnabledWithResult(@NonNull GoogleApiClient googleApiClient, boolean z);
}
