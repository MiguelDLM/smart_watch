package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzgo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.Class(creator = "ValueCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes9.dex */
public final class Value extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Value> CREATOR = new zzal();

    @SafeParcelable.Field(getter = "getFormat", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "isSet", id = 2)
    private boolean zzb;

    @SafeParcelable.Field(getter = "getValue", id = 3)
    private float zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getStringValue", id = 4)
    private String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getMapValue", id = 5, type = "android.os.Bundle")
    private Map zze;

    @Nullable
    @SafeParcelable.Field(getter = "getIntArrayValue", id = 6)
    private int[] zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getFloatArrayValue", id = 7)
    private float[] zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getBlob", id = 8)
    private byte[] zzh;

    @SafeParcelable.Constructor
    public Value(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) float f, @Nullable @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) Bundle bundle, @Nullable @SafeParcelable.Param(id = 6) int[] iArr, @Nullable @SafeParcelable.Param(id = 7) float[] fArr, @Nullable @SafeParcelable.Param(id = 8) byte[] bArr) {
        ArrayMap arrayMap;
        this.zza = i;
        this.zzb = z;
        this.zzc = f;
        this.zzd = str;
        if (bundle == null) {
            arrayMap = null;
        } else {
            bundle.setClassLoader((ClassLoader) Preconditions.checkNotNull(MapValue.class.getClassLoader()));
            arrayMap = new ArrayMap(bundle.size());
            for (String str2 : bundle.keySet()) {
                arrayMap.put(str2, (MapValue) Preconditions.checkNotNull((MapValue) bundle.getParcelable(str2)));
            }
        }
        this.zze = arrayMap;
        this.zzf = iArr;
        this.zzg = fArr;
        this.zzh = bArr;
    }

    @NonNull
    public String asActivity() {
        return zzgo.zzb(asInt());
    }

    public float asFloat() {
        boolean z;
        if (this.zza == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in float format");
        return this.zzc;
    }

    public int asInt() {
        boolean z = true;
        if (this.zza != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.zzc);
    }

    @NonNull
    public String asString() {
        boolean z;
        if (this.zza == 3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in string format");
        String str = this.zzd;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Deprecated
    public void clearKey(@NonNull String str) {
        boolean z;
        if (this.zza == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        Map map = this.zze;
        if (map != null) {
            map.remove(str);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        int i = this.zza;
        if (i == value.zza && this.zzb == value.zzb) {
            if (i != 1) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (this.zzc == value.zzc) {
                                        return true;
                                    }
                                    return false;
                                }
                                return Arrays.equals(this.zzh, value.zzh);
                            }
                            return Arrays.equals(this.zzg, value.zzg);
                        }
                        return Arrays.equals(this.zzf, value.zzf);
                    }
                    return Objects.equal(this.zze, value.zze);
                }
                return Objects.equal(this.zzd, value.zzd);
            }
            if (asInt() == value.asInt()) {
                return true;
            }
        }
        return false;
    }

    public int getFormat() {
        return this.zza;
    }

    @Nullable
    public Float getKeyValue(@NonNull String str) {
        boolean z;
        if (this.zza == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in float map format");
        Map map = this.zze;
        if (map != null && map.containsKey(str)) {
            return Float.valueOf(((MapValue) this.zze.get(str)).zza());
        }
        return null;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }

    public boolean isSet() {
        return this.zzb;
    }

    @Deprecated
    public void setActivity(@NonNull String str) {
        setInt(zzgo.zza(str));
    }

    @Deprecated
    public void setFloat(float f) {
        boolean z;
        if (this.zza == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        this.zzc = f;
    }

    @Deprecated
    public void setInt(int i) {
        boolean z;
        if (this.zza == 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        this.zzc = Float.intBitsToFloat(i);
    }

    @Deprecated
    public void setKeyValue(@NonNull String str, float f) {
        boolean z;
        if (this.zza == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        if (this.zze == null) {
            this.zze = new HashMap();
        }
        this.zze.put(str, MapValue.zzb(f));
    }

    @Deprecated
    public void setString(@NonNull String str) {
        boolean z;
        if (this.zza == 3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        this.zzd = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[ORIG_RETURN, RETURN] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            boolean r0 = r3.zzb
            if (r0 != 0) goto L7
            java.lang.String r0 = "unset"
            return r0
        L7:
            int r0 = r3.zza
            switch(r0) {
                case 1: goto L46;
                case 2: goto L3f;
                case 3: goto L38;
                case 4: goto L2a;
                case 5: goto L23;
                case 6: goto L1c;
                case 7: goto Lf;
                default: goto Lc;
            }
        Lc:
            java.lang.String r0 = "unknown"
            return r0
        Lf:
            byte[] r0 = r3.zzh
            if (r0 == 0) goto L3c
            int r1 = r0.length
            r2 = 0
            java.lang.String r0 = com.google.android.gms.common.util.HexDumpUtils.dump(r0, r2, r1, r2)
            if (r0 == 0) goto L3c
            return r0
        L1c:
            float[] r0 = r3.zzg
            java.lang.String r0 = java.util.Arrays.toString(r0)
            return r0
        L23:
            int[] r0 = r3.zzf
            java.lang.String r0 = java.util.Arrays.toString(r0)
            return r0
        L2a:
            java.util.Map r0 = r3.zze
            if (r0 == 0) goto L3c
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L38:
            java.lang.String r0 = r3.zzd
            if (r0 != 0) goto L3e
        L3c:
            java.lang.String r0 = ""
        L3e:
            return r0
        L3f:
            float r0 = r3.zzc
            java.lang.String r0 = java.lang.Float.toString(r0)
            return r0
        L46:
            int r0 = r3.asInt()
            java.lang.String r0 = java.lang.Integer.toString(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.Value.toString():java.lang.String");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        Bundle bundle;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getFormat());
        SafeParcelWriter.writeBoolean(parcel, 2, isSet());
        SafeParcelWriter.writeFloat(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        Map map = this.zze;
        if (map == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(map.size());
            for (Map.Entry entry : this.zze.entrySet()) {
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            bundle = bundle2;
        }
        SafeParcelWriter.writeBundle(parcel, 5, bundle, false);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeFloatArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zzc;
    }

    @ShowFirstParty
    @Deprecated
    public final void zzb(@NonNull Map map) {
        boolean z;
        if (this.zza == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Attempting to set a float map value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzb = true;
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), MapValue.zzb(((Float) entry.getValue()).floatValue()));
        }
        this.zze = hashMap;
    }
}
