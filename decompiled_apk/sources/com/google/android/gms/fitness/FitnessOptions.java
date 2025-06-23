package com.google.android.gms.fitness;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes9.dex */
public final class FitnessOptions implements GoogleSignInOptionsExtension {
    public static final int ACCESS_READ = 0;
    public static final int ACCESS_WRITE = 1;
    private final Set zza;

    /* loaded from: classes9.dex */
    public static final class Builder {
        private final Set zza = new HashSet();

        private Builder() {
        }

        @NonNull
        public Builder accessActivitySessions(int i) {
            if (i != 0) {
                if (i == 1) {
                    this.zza.add(new Scope("https://www.googleapis.com/auth/fitness.activity.write"));
                } else {
                    throw new IllegalArgumentException("valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
                }
            } else {
                this.zza.add(new Scope("https://www.googleapis.com/auth/fitness.activity.read"));
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
        @androidx.annotation.NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.gms.fitness.FitnessOptions.Builder accessSleepSessions(int r4) {
            /*
                r3 = this;
                r0 = 1
                if (r4 == 0) goto L6
                if (r4 != r0) goto L8
                r4 = 1
            L6:
                r1 = 1
                goto L9
            L8:
                r1 = 0
            L9:
                java.lang.String r2 = "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE"
                com.google.android.gms.common.internal.Preconditions.checkArgument(r1, r2)
                if (r4 != 0) goto L1d
                java.util.Set r4 = r3.zza
                com.google.android.gms.common.api.Scope r0 = new com.google.android.gms.common.api.Scope
                java.lang.String r1 = "https://www.googleapis.com/auth/fitness.sleep.read"
                r0.<init>(r1)
                r4.add(r0)
                goto L2b
            L1d:
                if (r4 != r0) goto L2b
                java.util.Set r4 = r3.zza
                com.google.android.gms.common.api.Scope r0 = new com.google.android.gms.common.api.Scope
                java.lang.String r1 = "https://www.googleapis.com/auth/fitness.sleep.write"
                r0.<init>(r1)
                r4.add(r0)
            L2b:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.FitnessOptions.Builder.accessSleepSessions(int):com.google.android.gms.fitness.FitnessOptions$Builder");
        }

        @NonNull
        public Builder addDataType(@NonNull DataType dataType) {
            addDataType(dataType, 0);
            return this;
        }

        @NonNull
        public FitnessOptions build() {
            return new FitnessOptions(this, null);
        }

        public /* synthetic */ Builder(zzh zzhVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        @androidx.annotation.NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.gms.fitness.FitnessOptions.Builder addDataType(@androidx.annotation.NonNull com.google.android.gms.fitness.data.DataType r4, int r5) {
            /*
                r3 = this;
                r0 = 1
                if (r5 == 0) goto L6
                if (r5 != r0) goto L8
                r5 = 1
            L6:
                r1 = 1
                goto L9
            L8:
                r1 = 0
            L9:
                java.lang.String r2 = "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE"
                com.google.android.gms.common.internal.Preconditions.checkArgument(r1, r2)
                java.lang.String r1 = r4.zza()
                java.lang.String r4 = r4.zzb()
                if (r5 != 0) goto L25
                if (r1 == 0) goto L33
                java.util.Set r4 = r3.zza
                com.google.android.gms.common.api.Scope r5 = new com.google.android.gms.common.api.Scope
                r5.<init>(r1)
                r4.add(r5)
                goto L33
            L25:
                if (r5 != r0) goto L33
                if (r4 == 0) goto L33
                java.util.Set r5 = r3.zza
                com.google.android.gms.common.api.Scope r0 = new com.google.android.gms.common.api.Scope
                r0.<init>(r4)
                r5.add(r0)
            L33:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.FitnessOptions.Builder.addDataType(com.google.android.gms.fitness.data.DataType, int):com.google.android.gms.fitness.FitnessOptions$Builder");
        }
    }

    public /* synthetic */ FitnessOptions(Builder builder, zzi zziVar) {
        this.zza = builder.zza;
    }

    @NonNull
    public static Builder builder() {
        return new Builder(null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessOptions)) {
            return false;
        }
        return this.zza.equals(((FitnessOptions) obj).zza);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    public int getExtensionType() {
        return 3;
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    @NonNull
    public List<Scope> getImpliedScopes() {
        return new ArrayList(this.zza);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
    @NonNull
    public Bundle toBundle() {
        return new Bundle();
    }
}
