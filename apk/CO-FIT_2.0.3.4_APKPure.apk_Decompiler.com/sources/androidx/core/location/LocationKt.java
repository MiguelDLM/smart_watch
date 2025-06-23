package androidx.core.location;

import OXOo.OOXIXo;
import android.location.Location;

public final class LocationKt {
    public static final double component1(@OOXIXo Location location) {
        return location.getLatitude();
    }

    public static final double component2(@OOXIXo Location location) {
        return location.getLongitude();
    }
}
