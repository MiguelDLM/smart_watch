package com.google.android.gms.fitness;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;

@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzj implements Api.ApiOptions.HasGoogleSignInAccountOptions {

    @Nullable
    private final GoogleSignInAccount zza;

    public zzj(Context context, GoogleSignInAccount googleSignInAccount) {
        if ("<<default account>>".equals(googleSignInAccount.getEmail()) && PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
            googleSignInAccount = null;
        }
        this.zza = googleSignInAccount;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzj) && Objects.equal(((zzj) obj).zza, this.zza)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zza;
    }

    public final int hashCode() {
        GoogleSignInAccount googleSignInAccount = this.zza;
        if (googleSignInAccount != null) {
            return googleSignInAccount.hashCode();
        }
        return 0;
    }
}
