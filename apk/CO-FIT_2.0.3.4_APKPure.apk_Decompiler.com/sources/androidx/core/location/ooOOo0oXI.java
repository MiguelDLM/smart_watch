package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public final /* synthetic */ class ooOOo0oXI {
    public static void II0xO0(LocationListenerCompat locationListenerCompat, @NonNull List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i));
        }
    }

    public static void I0Io(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void oIX0oI(LocationListenerCompat locationListenerCompat, int i) {
    }

    public static void oxoX(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void X0o0xo(LocationListenerCompat locationListenerCompat, @NonNull String str, int i, @Nullable Bundle bundle) {
    }
}
