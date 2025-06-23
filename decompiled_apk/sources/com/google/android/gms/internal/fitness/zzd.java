package com.google.android.gms.internal.fitness;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@ShowFirstParty
@NotThreadSafe
/* loaded from: classes9.dex */
public final class zzd {
    public static int zza(@Nullable Object obj, List list) {
        if (obj == null) {
            return -1;
        }
        int indexOf = list.indexOf(obj);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(obj);
        return list.size() - 1;
    }
}
