package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;

public final class ActivityResult$Companion$CREATOR$1 implements Parcelable.Creator<ActivityResult> {
    public ActivityResult createFromParcel(Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        return new ActivityResult(parcel);
    }

    public ActivityResult[] newArray(int i) {
        return new ActivityResult[i];
    }
}
