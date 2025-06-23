package com.google.android.gms.internal.auth;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzdu {
    public static int zza(byte[] bArr, int i, zzdt zzdtVar) throws zzfb {
        int zzh = zzh(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 >= 0) {
            if (i2 <= bArr.length - zzh) {
                if (i2 == 0) {
                    zzdtVar.zzc = zzef.zzb;
                    return zzh;
                }
                zzdtVar.zzc = zzef.zzk(bArr, zzh, i2);
                return zzh + i2;
            }
            throw zzfb.zzf();
        }
        throw zzfb.zzc();
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzgi zzgiVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        Object zzd = zzgiVar.zzd();
        int zzl = zzl(zzd, zzgiVar, bArr, i, i2, i3, zzdtVar);
        zzgiVar.zze(zzd);
        zzdtVar.zzc = zzd;
        return zzl;
    }

    public static int zzd(zzgi zzgiVar, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        Object zzd = zzgiVar.zzd();
        int zzm = zzm(zzd, zzgiVar, bArr, i, i2, zzdtVar);
        zzgiVar.zze(zzd);
        zzdtVar.zzc = zzd;
        return zzm;
    }

    public static int zze(zzgi zzgiVar, int i, byte[] bArr, int i2, int i3, zzez zzezVar, zzdt zzdtVar) throws IOException {
        int zzd = zzd(zzgiVar, bArr, i2, i3, zzdtVar);
        zzezVar.add(zzdtVar.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            zzd = zzd(zzgiVar, bArr, zzh, i3, zzdtVar);
            zzezVar.add(zzdtVar.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i, zzez zzezVar, zzdt zzdtVar) throws IOException {
        zzew zzewVar = (zzew) zzezVar;
        int zzh = zzh(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzfb.zzf();
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzha zzhaVar, zzdt zzdtVar) throws zzfb {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                zzhaVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                                return i2 + 4;
                            }
                            throw zzfb.zza();
                        }
                        int i5 = (i & (-8)) | 4;
                        zzha zzd = zzha.zzd();
                        int i6 = 0;
                        while (true) {
                            if (i2 >= i3) {
                                break;
                            }
                            int zzh = zzh(bArr, i2, zzdtVar);
                            int i7 = zzdtVar.zza;
                            i6 = i7;
                            if (i7 != i5) {
                                int zzg = zzg(i6, bArr, zzh, i3, zzd, zzdtVar);
                                i6 = i7;
                                i2 = zzg;
                            } else {
                                i2 = zzh;
                                break;
                            }
                        }
                        if (i2 <= i3 && i6 == i5) {
                            zzhaVar.zzh(i, zzd);
                            return i2;
                        }
                        throw zzfb.zzd();
                    }
                    int zzh2 = zzh(bArr, i2, zzdtVar);
                    int i8 = zzdtVar.zza;
                    if (i8 >= 0) {
                        if (i8 <= bArr.length - zzh2) {
                            if (i8 == 0) {
                                zzhaVar.zzh(i, zzef.zzb);
                            } else {
                                zzhaVar.zzh(i, zzef.zzk(bArr, zzh2, i8));
                            }
                            return zzh2 + i8;
                        }
                        throw zzfb.zzf();
                    }
                    throw zzfb.zzc();
                }
                zzhaVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            }
            int zzk = zzk(bArr, i2, zzdtVar);
            zzhaVar.zzh(i, Long.valueOf(zzdtVar.zzb));
            return zzk;
        }
        throw zzfb.zza();
    }

    public static int zzh(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzdtVar.zza = b;
            return i2;
        }
        return zzi(b, bArr, i2, zzdtVar);
    }

    public static int zzi(int i, byte[] bArr, int i2, zzdt zzdtVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdtVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdtVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdtVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdtVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzdtVar.zza = i11;
                return i12;
            }
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int zzh = zzh(bArr, i2, zzdtVar);
        zzewVar.zze(zzdtVar.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        return zzh;
    }

    public static int zzk(byte[] bArr, int i, zzdt zzdtVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdtVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzdtVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzgi zzgiVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        int zzb = ((zzga) zzgiVar).zzb(obj, bArr, i, i2, i3, zzdtVar);
        zzdtVar.zzc = obj;
        return zzb;
    }

    public static int zzm(Object obj, zzgi zzgiVar, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzdtVar);
            i4 = zzdtVar.zza;
        }
        int i5 = i3;
        if (i4 >= 0 && i4 <= i2 - i5) {
            int i6 = i4 + i5;
            zzgiVar.zzg(obj, bArr, i5, i6, zzdtVar);
            zzdtVar.zzc = obj;
            return i6;
        }
        throw zzfb.zzf();
    }

    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
