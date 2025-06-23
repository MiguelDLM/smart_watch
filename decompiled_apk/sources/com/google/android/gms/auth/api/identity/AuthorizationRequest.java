package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AuthorizationRequestCreator")
/* loaded from: classes9.dex */
public class AuthorizationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new zbd();

    @SafeParcelable.Field(getter = "getRequestedScopes", id = 1)
    private final List zba;

    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 2)
    private final String zbb;

    @SafeParcelable.Field(getter = "isOfflineAccessRequested", id = 3)
    private final boolean zbc;

    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private final boolean zbd;

    @Nullable
    @SafeParcelable.Field(getter = "getAccount", id = 5)
    private final Account zbe;

    @Nullable
    @SafeParcelable.Field(getter = "getHostedDomain", id = 6)
    private final String zbf;

    @Nullable
    @SafeParcelable.Field(getter = "getSessionId", id = 7)
    private final String zbg;

    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 8)
    private final boolean zbh;

    @Nullable
    @SafeParcelable.Field(getter = "getResourceParameters", id = 9)
    private final Bundle zbi;

    /* loaded from: classes9.dex */
    public static final class Builder {
        private List zba;

        @Nullable
        private String zbb;
        private boolean zbc;
        private boolean zbd;

        @Nullable
        private Account zbe;

        @Nullable
        private String zbf;

        @Nullable
        private String zbg;
        private boolean zbh;

        @Nullable
        private Bundle zbi;

        private final String zbc(String str) {
            Preconditions.checkNotNull(str);
            String str2 = this.zbb;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.checkArgument(z, "two different server client ids provided");
            return str;
        }

        @NonNull
        public Builder addResourceParameter(@NonNull ResourceParameter resourceParameter, @NonNull String str) {
            Preconditions.checkNotNull(resourceParameter, "Resource parameter cannot be null");
            Preconditions.checkNotNull(str, "Resource parameter value cannot be null");
            if (this.zbi == null) {
                this.zbi = new Bundle();
            }
            this.zbi.putString(resourceParameter.zba, str);
            return this;
        }

        @NonNull
        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh, this.zbi);
        }

        @NonNull
        public Builder filterByHostedDomain(@NonNull String str) {
            this.zbf = Preconditions.checkNotEmpty(str);
            return this;
        }

        @NonNull
        public Builder requestOfflineAccess(@NonNull String str) {
            requestOfflineAccess(str, false);
            return this;
        }

        @NonNull
        public Builder setAccount(@NonNull Account account) {
            this.zbe = (Account) Preconditions.checkNotNull(account);
            return this;
        }

        @NonNull
        public Builder setRequestedScopes(@NonNull List<Scope> list) {
            boolean z = false;
            if (list != null && !list.isEmpty()) {
                z = true;
            }
            Preconditions.checkArgument(z, "requestedScopes cannot be null or empty");
            this.zba = list;
            return this;
        }

        @NonNull
        @ShowFirstParty
        public final Builder zba(@NonNull String str) {
            zbc(str);
            this.zbb = str;
            this.zbd = true;
            return this;
        }

        @NonNull
        public final Builder zbb(@NonNull String str) {
            this.zbg = str;
            return this;
        }

        @NonNull
        public Builder requestOfflineAccess(@NonNull String str, boolean z) {
            zbc(str);
            this.zbb = str;
            this.zbc = true;
            this.zbh = z;
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public enum ResourceParameter {
        ACCOUNT_SELECTION_TOKEN("account_selection_token"),
        ACCOUNT_SELECTION_STATE("account_selection_state");

        final String zba;

        ResourceParameter(String str) {
            this.zba = str;
        }
    }

    @SafeParcelable.Constructor
    public AuthorizationRequest(@SafeParcelable.Param(id = 1) List list, @Nullable @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2, @Nullable @SafeParcelable.Param(id = 5) Account account, @Nullable @SafeParcelable.Param(id = 6) String str2, @Nullable @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) boolean z3, @Nullable @SafeParcelable.Param(id = 9) Bundle bundle) {
        boolean z4 = false;
        if (list != null && !list.isEmpty()) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "requestedScopes cannot be null or empty");
        this.zba = list;
        this.zbb = str;
        this.zbc = z;
        this.zbd = z2;
        this.zbe = account;
        this.zbf = str2;
        this.zbg = str3;
        this.zbh = z3;
        this.zbi = bundle;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder zba(@NonNull AuthorizationRequest authorizationRequest) {
        ResourceParameter resourceParameter;
        Preconditions.checkNotNull(authorizationRequest);
        Builder builder = builder();
        builder.setRequestedScopes(authorizationRequest.getRequestedScopes());
        Bundle resourceParameters = authorizationRequest.getResourceParameters();
        if (resourceParameters != null) {
            for (String str : resourceParameters.keySet()) {
                String string = resourceParameters.getString(str);
                ResourceParameter[] values = ResourceParameter.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        resourceParameter = values[i];
                        if (resourceParameter.zba.equals(str)) {
                            break;
                        }
                        i++;
                    } else {
                        resourceParameter = null;
                        break;
                    }
                }
                if (string != null && resourceParameter != null) {
                    builder.addResourceParameter(resourceParameter, string);
                }
            }
        }
        boolean isForceCodeForRefreshToken = authorizationRequest.isForceCodeForRefreshToken();
        String str2 = authorizationRequest.zbg;
        String hostedDomain = authorizationRequest.getHostedDomain();
        Account account = authorizationRequest.getAccount();
        String serverClientId = authorizationRequest.getServerClientId();
        if (str2 != null) {
            builder.zbb(str2);
        }
        if (hostedDomain != null) {
            builder.filterByHostedDomain(hostedDomain);
        }
        if (account != null) {
            builder.setAccount(account);
        }
        if (authorizationRequest.zbd && serverClientId != null) {
            builder.zba(serverClientId);
        }
        if (authorizationRequest.isOfflineAccessRequested() && serverClientId != null) {
            builder.requestOfflineAccess(serverClientId, isForceCodeForRefreshToken);
        }
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        if (this.zba.size() == authorizationRequest.zba.size() && this.zba.containsAll(authorizationRequest.zba)) {
            Bundle bundle = authorizationRequest.zbi;
            Bundle bundle2 = this.zbi;
            if (bundle2 == null) {
                if (bundle == null) {
                    bundle = null;
                }
                return false;
            }
            if (bundle2 == null || bundle != null) {
                if (bundle2 != null) {
                    if (bundle2.size() != bundle.size()) {
                        return false;
                    }
                    for (String str : this.zbi.keySet()) {
                        if (!Objects.equal(this.zbi.getString(str), bundle.getString(str))) {
                            return false;
                        }
                    }
                }
                if (this.zbc == authorizationRequest.zbc && this.zbh == authorizationRequest.zbh && this.zbd == authorizationRequest.zbd && Objects.equal(this.zbb, authorizationRequest.zbb) && Objects.equal(this.zbe, authorizationRequest.zbe) && Objects.equal(this.zbf, authorizationRequest.zbf) && Objects.equal(this.zbg, authorizationRequest.zbg)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Nullable
    public Account getAccount() {
        return this.zbe;
    }

    @Nullable
    public String getHostedDomain() {
        return this.zbf;
    }

    @NonNull
    public List<Scope> getRequestedScopes() {
        return this.zba;
    }

    @Nullable
    public String getResourceParameter(@NonNull ResourceParameter resourceParameter) {
        Bundle bundle = this.zbi;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(resourceParameter.zba);
    }

    @Nullable
    public Bundle getResourceParameters() {
        return this.zbi;
    }

    @Nullable
    public String getServerClientId() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, Boolean.valueOf(this.zbc), Boolean.valueOf(this.zbh), Boolean.valueOf(this.zbd), this.zbe, this.zbf, this.zbg, this.zbi);
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zbh;
    }

    public boolean isOfflineAccessRequested() {
        return this.zbc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getRequestedScopes(), false);
        SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, isOfflineAccessRequested());
        SafeParcelWriter.writeBoolean(parcel, 4, this.zbd);
        SafeParcelWriter.writeParcelable(parcel, 5, getAccount(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getHostedDomain(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zbg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, isForceCodeForRefreshToken());
        SafeParcelWriter.writeBundle(parcel, 9, getResourceParameters(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
