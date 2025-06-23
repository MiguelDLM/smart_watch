package com.google.android.gms.fido;

import com.google.android.gms.common.Feature;

/* loaded from: classes9.dex */
public final class zza {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature zzj;
    public static final Feature zzk;
    public static final Feature zzl;
    public static final Feature zzm;
    public static final Feature zzn;
    public static final Feature zzo;
    public static final Feature zzp;
    public static final Feature zzq;
    public static final Feature zzr;
    public static final Feature zzs;
    public static final Feature[] zzt;

    static {
        Feature feature = new Feature("cancel_target_direct_transfer", 1L);
        zza = feature;
        Feature feature2 = new Feature("delete_credential", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("delete_device_public_key", 1L);
        zzc = feature3;
        Feature feature4 = new Feature("get_or_generate_device_public_key", 1L);
        zzd = feature4;
        Feature feature5 = new Feature("get_passkeys", 1L);
        zze = feature5;
        Feature feature6 = new Feature("update_passkey", 1L);
        zzf = feature6;
        Feature feature7 = new Feature("is_user_verifying_platform_authenticator_available_for_credential", 1L);
        zzg = feature7;
        Feature feature8 = new Feature("is_user_verifying_platform_authenticator_available", 1L);
        zzh = feature8;
        Feature feature9 = new Feature("privileged_api_list_credentials", 2L);
        zzi = feature9;
        Feature feature10 = new Feature("start_target_direct_transfer", 1L);
        zzj = feature10;
        Feature feature11 = new Feature("zero_party_api_register", 3L);
        zzk = feature11;
        Feature feature12 = new Feature("zero_party_api_sign", 3L);
        zzl = feature12;
        Feature feature13 = new Feature("zero_party_api_list_discoverable_credentials", 2L);
        zzm = feature13;
        Feature feature14 = new Feature("zero_party_api_authenticate_passkey", 1L);
        zzn = feature14;
        Feature feature15 = new Feature("zero_party_api_register_passkey", 1L);
        zzo = feature15;
        Feature feature16 = new Feature("zero_party_api_get_hybrid_client_registration_pending_intent", 1L);
        zzp = feature16;
        Feature feature17 = new Feature("zero_party_api_get_hybrid_client_sign_pending_intent", 1L);
        zzq = feature17;
        Feature feature18 = new Feature("get_browser_hybrid_client_sign_pending_intent", 1L);
        zzr = feature18;
        Feature feature19 = new Feature("get_browser_hybrid_client_registration_pending_intent", 1L);
        zzs = feature19;
        zzt = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11, feature12, feature13, feature14, feature15, feature16, feature17, feature18, feature19};
    }
}
