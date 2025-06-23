package com.google.android.gms.maps;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    /* loaded from: classes9.dex */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(@NonNull Context context) {
        int initialize;
        synchronized (MapsInitializer.class) {
            initialize = initialize(context, null, null);
        }
        return initialize;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|12|13|14|15|16|(8:18|(1:(1:21))|22|23|(1:25)|26|27|(1:29))|34|22|23|(0)|26|27|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        android.util.Log.e(com.google.android.gms.maps.MapsInitializer.zza, "Failed to retrieve renderer type or log initialization.", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[Catch: all -> 0x0024, RemoteException -> 0x0054, TryCatch #3 {RemoteException -> 0x0054, blocks: (B:23:0x0049, B:25:0x004f, B:26:0x0056), top: B:22:0x0049, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x001e, B:12:0x0026, B:14:0x002a, B:16:0x0039, B:18:0x003e, B:23:0x0049, B:25:0x004f, B:26:0x0056, B:27:0x0065, B:29:0x0078, B:33:0x005e, B:37:0x0080, B:38:0x0085, B:41:0x0087), top: B:3:0x0003, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int initialize(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.Nullable com.google.android.gms.maps.MapsInitializer.Renderer r6, @androidx.annotation.Nullable com.google.android.gms.maps.OnMapsSdkInitializedCallback r7) {
        /*
            java.lang.Class<com.google.android.gms.maps.MapsInitializer> r0 = com.google.android.gms.maps.MapsInitializer.class
            monitor-enter(r0)
            java.lang.String r1 = "Context is null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = com.google.android.gms.maps.MapsInitializer.zza     // Catch: java.lang.Throwable -> L24
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "preferredRenderer: "
            java.lang.String r2 = r3.concat(r2)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L24
            boolean r1 = com.google.android.gms.maps.MapsInitializer.zzb     // Catch: java.lang.Throwable -> L24
            r2 = 0
            if (r1 == 0) goto L26
            if (r7 == 0) goto L7d
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = com.google.android.gms.maps.MapsInitializer.zzc     // Catch: java.lang.Throwable -> L24
            r7.onMapsSdkInitialized(r5)     // Catch: java.lang.Throwable -> L24
            goto L7d
        L24:
            r5 = move-exception
            goto L8b
        L26:
            com.google.android.gms.maps.internal.zzf r1 = com.google.android.gms.maps.internal.zzcc.zza(r5, r6)     // Catch: java.lang.Throwable -> L24 com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L86
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r3 = r1.zze()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L7f
            com.google.android.gms.maps.CameraUpdateFactory.zza(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L7f
            com.google.android.gms.internal.maps.zzi r3 = r1.zzj()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L7f
            com.google.android.gms.maps.model.BitmapDescriptorFactory.zza(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L7f
            r3 = 1
            com.google.android.gms.maps.MapsInitializer.zzb = r3     // Catch: java.lang.Throwable -> L24
            r4 = 2
            if (r6 == 0) goto L46
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L49
            if (r6 == r3) goto L48
        L46:
            r3 = 0
            goto L49
        L48:
            r3 = 2
        L49:
            int r6 = r1.zzd()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L54
            if (r6 != r4) goto L56
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.Renderer.LATEST     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L54
            com.google.android.gms.maps.MapsInitializer.zzc = r6     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L54
            goto L56
        L54:
            r5 = move-exception
            goto L5e
        L56:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L54
            r1.zzl(r5, r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L54
            goto L65
        L5e:
            java.lang.String r6 = com.google.android.gms.maps.MapsInitializer.zza     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "Failed to retrieve renderer type or log initialization."
            android.util.Log.e(r6, r1, r5)     // Catch: java.lang.Throwable -> L24
        L65:
            java.lang.String r5 = com.google.android.gms.maps.MapsInitializer.zza     // Catch: java.lang.Throwable -> L24
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.zzc     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "loadedRenderer: "
            java.lang.String r6 = r1.concat(r6)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r5, r6)     // Catch: java.lang.Throwable -> L24
            if (r7 == 0) goto L7d
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = com.google.android.gms.maps.MapsInitializer.zzc     // Catch: java.lang.Throwable -> L24
            r7.onMapsSdkInitialized(r5)     // Catch: java.lang.Throwable -> L24
        L7d:
            monitor-exit(r0)
            return r2
        L7f:
            r5 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r6 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch: java.lang.Throwable -> L24
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L24
            throw r6     // Catch: java.lang.Throwable -> L24
        L86:
            r5 = move-exception
            int r5 = r5.errorCode     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r5
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapsInitializer.initialize(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer, com.google.android.gms.maps.OnMapsSdkInitializedCallback):int");
    }
}
