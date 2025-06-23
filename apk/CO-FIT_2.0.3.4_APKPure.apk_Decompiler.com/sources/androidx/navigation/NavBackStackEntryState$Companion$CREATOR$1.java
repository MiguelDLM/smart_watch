package androidx.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;

public final class NavBackStackEntryState$Companion$CREATOR$1 implements Parcelable.Creator<NavBackStackEntryState> {
    public NavBackStackEntryState createFromParcel(Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "inParcel");
        return new NavBackStackEntryState(parcel);
    }

    public NavBackStackEntryState[] newArray(int i) {
        return new NavBackStackEntryState[i];
    }
}
