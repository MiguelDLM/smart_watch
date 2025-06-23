package androidx.media2.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.media2.session.SessionToken;
import org.apache.commons.text.ooOOo0oXI;

final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {
    ComponentName mComponentName;
    Bundle mExtras;
    IBinder mISession;
    String mPackageName;
    String mServiceName;
    int mType;
    int mUid;

    public SessionTokenImplBase(@NonNull ComponentName componentName, int i, int i2) {
        if (componentName != null) {
            this.mComponentName = componentName;
            this.mPackageName = componentName.getPackageName();
            this.mServiceName = componentName.getClassName();
            this.mUid = i;
            this.mType = i2;
            this.mISession = null;
            this.mExtras = null;
            return;
        }
        throw new NullPointerException("serviceComponent shouldn't be null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        if (this.mUid != sessionTokenImplBase.mUid || !TextUtils.equals(this.mPackageName, sessionTokenImplBase.mPackageName) || !TextUtils.equals(this.mServiceName, sessionTokenImplBase.mServiceName) || this.mType != sessionTokenImplBase.mType || !ObjectsCompat.equals(this.mISession, sessionTokenImplBase.mISession)) {
            return false;
        }
        return true;
    }

    public Object getBinder() {
        return this.mISession;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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
        return this.mServiceName;
    }

    public int getType() {
        return this.mType;
    }

    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mType), Integer.valueOf(this.mUid), this.mPackageName, this.mServiceName);
    }

    public boolean isLegacySession() {
        return false;
    }

    public String toString() {
        return "SessionToken {pkg=" + this.mPackageName + " type=" + this.mType + " service=" + this.mServiceName + " IMediaSession=" + this.mISession + " extras=" + this.mExtras + ooOOo0oXI.f22054oOoXoXO;
    }

    public SessionTokenImplBase(int i, int i2, String str, IMediaSession iMediaSession, Bundle bundle) {
        this.mUid = i;
        this.mType = i2;
        this.mPackageName = str;
        this.mServiceName = null;
        this.mComponentName = null;
        this.mISession = iMediaSession.asBinder();
        this.mExtras = bundle;
    }

    public SessionTokenImplBase() {
    }
}
