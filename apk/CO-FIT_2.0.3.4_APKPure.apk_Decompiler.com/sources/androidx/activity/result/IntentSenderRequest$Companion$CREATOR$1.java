package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;

public final class IntentSenderRequest$Companion$CREATOR$1 implements Parcelable.Creator<IntentSenderRequest> {
    public IntentSenderRequest createFromParcel(Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "inParcel");
        return new IntentSenderRequest(parcel);
    }

    public IntentSenderRequest[] newArray(int i) {
        return new IntentSenderRequest[i];
    }
}
