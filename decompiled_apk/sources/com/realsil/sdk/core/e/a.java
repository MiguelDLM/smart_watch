package com.realsil.sdk.core.e;

import androidx.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class a {
    public static boolean a(UUID uuid, UUID uuid2, @Nullable UUID uuid3) {
        if (uuid3 == null) {
            return Objects.equals(uuid, uuid2);
        }
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long leastSignificantBits2 = uuid2.getLeastSignificantBits();
        long leastSignificantBits3 = uuid3.getLeastSignificantBits();
        if ((leastSignificantBits & leastSignificantBits3) == (leastSignificantBits2 & leastSignificantBits3)) {
            long mostSignificantBits = uuid.getMostSignificantBits();
            long mostSignificantBits2 = uuid2.getMostSignificantBits();
            long mostSignificantBits3 = uuid3.getMostSignificantBits();
            if ((mostSignificantBits & mostSignificantBits3) == (mostSignificantBits2 & mostSignificantBits3)) {
                return true;
            }
        }
        return false;
    }
}
