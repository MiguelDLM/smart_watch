package com.google.android.gms.fitness;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.fitness.zzap;
import com.google.android.gms.internal.fitness.zzea;
import com.google.android.gms.internal.fitness.zzeb;

@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzg {
    public static final zzea zzc = new zzea();
    public static final Api zza = zzap.zzf;
    public static final zzeb zzd = new zzeb();
    static final GoogleSignInAccount zzb = GoogleSignInAccount.fromAccountAndScopes(new Account("local_no_account", "com.google"), Fitness.SCOPE_ACTIVITY_READ, new Scope[0]);
}
