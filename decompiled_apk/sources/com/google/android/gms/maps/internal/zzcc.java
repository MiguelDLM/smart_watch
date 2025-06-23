package com.google.android.gms.maps.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Objects;

/* loaded from: classes9.dex */
public final class zzcc {
    private static final String zza = "zzcc";

    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzb;
    private static zzf zzc;

    public static zzf zza(Context context, @Nullable MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context);
        Log.d(zza, "preferredRenderer: ".concat(String.valueOf(renderer)));
        zzf zzfVar = zzc;
        if (zzfVar == null) {
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
            if (isGooglePlayServicesAvailable == 0) {
                zzf zzd = zzd(context, renderer);
                zzc = zzd;
                try {
                    if (zzd.zzd() == 2) {
                        try {
                            zzc.zzm(ObjectWrapper.wrap(zzc(context, renderer)));
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        } catch (UnsatisfiedLinkError unused) {
                            Log.w(zza, "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                            zzb = null;
                            zzc = zzd(context, MapsInitializer.Renderer.LEGACY);
                        }
                    }
                    try {
                        zzf zzfVar2 = zzc;
                        Context zzc2 = zzc(context, renderer);
                        Objects.requireNonNull(zzc2);
                        zzfVar2.zzk(ObjectWrapper.wrap(zzc2.getResources()), 19000000);
                        return zzc;
                    } catch (RemoteException e2) {
                        throw new RuntimeRemoteException(e2);
                    }
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                }
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        return zzfVar;
    }

    private static Context zzb(Exception exc, Context context) {
        Log.e(zza, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:5|6)|(6:8|(1:10)|13|14|15|16)|27|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r5 != 1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        r0 = "com.google.android.gms.maps_core_dynamite";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r0.equals("com.google.android.gms.maps_dynamite") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r4 = zzb(r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        android.util.Log.d(com.google.android.gms.maps.internal.zzcc.zza, "Attempting to load maps_dynamite again.");
        r4 = com.google.android.gms.dynamite.DynamiteModule.load(r4, com.google.android.gms.dynamite.DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        r4 = zzb(r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0022, code lost:
    
        if (r5 != com.google.android.gms.maps.MapsInitializer.Renderer.LEGACY) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.Context zzc(android.content.Context r4, @androidx.annotation.Nullable com.google.android.gms.maps.MapsInitializer.Renderer r5) {
        /*
            java.lang.String r0 = "com.google.android.gms.maps_legacy_dynamite"
            java.lang.String r1 = "com.google.android.gms.maps_core_dynamite"
            java.lang.String r2 = "com.google.android.gms.maps_dynamite"
            android.content.Context r3 = com.google.android.gms.maps.internal.zzcc.zzb
            if (r3 != 0) goto L55
            java.lang.String r3 = "com.google.android.gms.maps.internal.UseLegacyRendererAsDefault"
            java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L1f
            if (r5 == 0) goto L1d
            int r5 = r5.ordinal()
            if (r5 == 0) goto L24
            r0 = 1
            if (r5 == r0) goto L1b
            goto L1d
        L1b:
            r0 = r1
            goto L24
        L1d:
            r0 = r2
            goto L24
        L1f:
            com.google.android.gms.maps.MapsInitializer$Renderer r3 = com.google.android.gms.maps.MapsInitializer.Renderer.LEGACY
            if (r5 != r3) goto L1b
        L24:
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r5 = com.google.android.gms.dynamite.DynamiteModule.PREFER_REMOTE     // Catch: java.lang.Exception -> L2f
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.load(r4, r5, r0)     // Catch: java.lang.Exception -> L2f
            android.content.Context r4 = r5.getModuleContext()     // Catch: java.lang.Exception -> L2f
            goto L52
        L2f:
            r5 = move-exception
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4e
            java.lang.String r5 = com.google.android.gms.maps.internal.zzcc.zza     // Catch: java.lang.Exception -> L48
            java.lang.String r0 = "Attempting to load maps_dynamite again."
            android.util.Log.d(r5, r0)     // Catch: java.lang.Exception -> L48
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r5 = com.google.android.gms.dynamite.DynamiteModule.PREFER_REMOTE     // Catch: java.lang.Exception -> L48
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.load(r4, r5, r2)     // Catch: java.lang.Exception -> L48
            android.content.Context r4 = r5.getModuleContext()     // Catch: java.lang.Exception -> L48
            goto L52
        L48:
            r5 = move-exception
            android.content.Context r4 = zzb(r5, r4)
            goto L52
        L4e:
            android.content.Context r4 = zzb(r5, r4)
        L52:
            com.google.android.gms.maps.internal.zzcc.zzb = r4
            return r4
        L55:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzcc.zzc(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer):android.content.Context");
    }

    private static zzf zzd(Context context, @Nullable MapsInitializer.Renderer renderer) {
        Log.i(zza, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) zze(((ClassLoader) Preconditions.checkNotNull(zzc(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (queryLocalInterface instanceof zzf) {
                return (zzf) queryLocalInterface;
            }
            return new zze(iBinder);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e);
        }
    }

    private static Object zze(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(cls.getName()), e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(cls.getName()), e2);
        }
    }
}
