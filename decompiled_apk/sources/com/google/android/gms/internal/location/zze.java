package com.google.android.gms.internal.location;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import org.checkerframework.dataflow.qual.Pure;

@XX({"SMAP\nClientIdentity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientIdentity.kt\ncom/google/android/gms/libs/identity/ClientIdentity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,598:1\n335#1:600\n339#1:601\n1#2:599\n1747#3,3:602\n12271#4,2:605\n12474#4,2:607\n13309#4,2:609\n*S KotlinDebug\n*F\n+ 1 ClientIdentity.kt\ncom/google/android/gms/libs/identity/ClientIdentity\n*L\n255#1:600\n264#1:601\n278#1:602,3\n284#1:605,2\n292#1:607,2\n301#1:609,2\n*E\n"})
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({2, 5})
/* loaded from: classes9.dex */
public final class zze extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zzb;

    @OOXIXo
    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String zzc;

    @oOoXoXO
    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    private final String zzd;

    @oOoXoXO
    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    private final String zze;

    @OOXIXo
    @SafeParcelable.Field(getter = "getClientFeatures", id = 8)
    private final List zzf;

    @oOoXoXO
    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    private final zze zzg;

    @OOXIXo
    public static final zzd zza = new zzd(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    static {
        Process.myUid();
        Process.myPid();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "only for Parcelable.Creator")
    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i, @OOXIXo @SafeParcelable.Param(id = 3) String packageName, @SafeParcelable.Param(id = 4) @oOoXoXO String str, @SafeParcelable.Param(id = 6) @oOoXoXO String str2, @SafeParcelable.Param(id = 8) @oOoXoXO List list, @SafeParcelable.Param(id = 7) @oOoXoXO zze zzeVar) {
        IIX0o.x0xO0oo(packageName, "packageName");
        if (zzeVar != null && zzeVar.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = i;
        this.zzc = packageName;
        this.zzd = str;
        if (str2 == null) {
            if (zzeVar != null) {
                str2 = zzeVar.zze;
            } else {
                str2 = null;
            }
        }
        this.zze = str2;
        if (list == null) {
            list = zzeVar != null ? zzeVar.zzf : null;
            if (list == null) {
                list = zzex.zzi();
                IIX0o.oO(list, "of(...)");
            }
        }
        IIX0o.x0xO0oo(list, "<this>");
        zzex zzj = zzex.zzj(list);
        IIX0o.oO(zzj, "copyOf(...)");
        this.zzf = zzj;
        this.zzg = zzeVar;
    }

    public final boolean equals(@oOoXoXO Object obj) {
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (this.zzb == zzeVar.zzb && IIX0o.Oxx0IOOO(this.zzc, zzeVar.zzc) && IIX0o.Oxx0IOOO(this.zzd, zzeVar.zzd) && IIX0o.Oxx0IOOO(this.zze, zzeVar.zze) && IIX0o.Oxx0IOOO(this.zzg, zzeVar.zzg) && IIX0o.Oxx0IOOO(this.zzf, zzeVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    @OOXIXo
    public final String toString() {
        int i;
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        int i2 = 0;
        if (str != null) {
            i = str.length();
        } else {
            i = 0;
        }
        StringBuilder sb = new StringBuilder(length + i);
        sb.append(this.zzb);
        sb.append("/");
        sb.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb.append("[");
            if (OxI.IOOoXo0Ix(str2, this.zzc, false, 2, null)) {
                String str3 = this.zzc;
                sb.append((CharSequence) str2, str3.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        if (this.zze != null) {
            sb.append("/");
            String str4 = this.zze;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            sb.append(Integer.toHexString(i2));
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        int i2 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, i2);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeString(dest, 4, this.zzd, false);
        SafeParcelWriter.writeString(dest, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(dest, 7, this.zzg, i, false);
        SafeParcelWriter.writeTypedList(dest, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return this.zzg != null;
    }
}
