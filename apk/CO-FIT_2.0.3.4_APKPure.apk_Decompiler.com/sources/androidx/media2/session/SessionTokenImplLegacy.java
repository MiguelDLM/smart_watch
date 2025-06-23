package androidx.media2.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media2.session.SessionToken;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.versionedparcelable.VersionedParcelable;
import org.apache.commons.text.ooOOo0oXI;

final class SessionTokenImplLegacy extends CustomVersionedParcelable implements SessionToken.SessionTokenImpl {
    ComponentName mComponentName;
    Bundle mExtras;
    private MediaSessionCompat.Token mLegacyToken;
    Bundle mLegacyTokenBundle;
    String mPackageName;
    int mType;
    int mUid;

    public SessionTokenImplLegacy(MediaSessionCompat.Token token, String str, int i, Bundle bundle) {
        if (token == null) {
            throw new NullPointerException("token shouldn't be null");
        } else if (str == null) {
            throw new NullPointerException("packageName shouldn't be null");
        } else if (!TextUtils.isEmpty(str)) {
            this.mLegacyToken = token;
            this.mUid = i;
            this.mPackageName = str;
            this.mComponentName = null;
            this.mType = 100;
            this.mExtras = bundle;
        } else {
            throw new IllegalArgumentException("packageName shouldn't be empty");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplLegacy)) {
            return false;
        }
        SessionTokenImplLegacy sessionTokenImplLegacy = (SessionTokenImplLegacy) obj;
        int i = this.mType;
        if (i != sessionTokenImplLegacy.mType) {
            return false;
        }
        if (i == 100) {
            return ObjectsCompat.equals(this.mLegacyToken, sessionTokenImplLegacy.mLegacyToken);
        }
        if (i != 101) {
            return false;
        }
        return ObjectsCompat.equals(this.mComponentName, sessionTokenImplLegacy.mComponentName);
    }

    public Object getBinder() {
        return this.mLegacyToken;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @NonNull
    public String getPackageName() {
        return this.mPackageName;
    }

    @Nullable
    public String getServiceName() {
        ComponentName componentName = this.mComponentName;
        if (componentName == null) {
            return null;
        }
        return componentName.getClassName();
    }

    public int getType() {
        if (this.mType != 101) {
            return 0;
        }
        return 2;
    }

    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mType), this.mComponentName, this.mLegacyToken);
    }

    public boolean isLegacySession() {
        return true;
    }

    public void onPostParceling() {
        this.mLegacyToken = MediaSessionCompat.Token.fromBundle(this.mLegacyTokenBundle);
    }

    public void onPreParceling(boolean z) {
        MediaSessionCompat.Token token = this.mLegacyToken;
        if (token != null) {
            synchronized (token) {
                VersionedParcelable session2Token = this.mLegacyToken.getSession2Token();
                this.mLegacyToken.setSession2Token((VersionedParcelable) null);
                this.mLegacyTokenBundle = this.mLegacyToken.toBundle();
                this.mLegacyToken.setSession2Token(session2Token);
            }
            return;
        }
        this.mLegacyTokenBundle = null;
    }

    public String toString() {
        return "SessionToken {legacyToken=" + this.mLegacyToken + ooOOo0oXI.f22054oOoXoXO;
    }

    public SessionTokenImplLegacy(ComponentName componentName, int i) {
        if (componentName != null) {
            this.mLegacyToken = null;
            this.mUid = i;
            this.mType = 101;
            this.mPackageName = componentName.getPackageName();
            this.mComponentName = componentName;
            this.mExtras = null;
            return;
        }
        throw new NullPointerException("serviceComponent shouldn't be null");
    }

    public SessionTokenImplLegacy() {
    }
}
