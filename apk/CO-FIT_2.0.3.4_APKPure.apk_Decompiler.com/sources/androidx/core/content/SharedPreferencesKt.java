package androidx.core.content;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.oXIO0o0XI;

public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@OOXIXo SharedPreferences sharedPreferences, boolean z, @OOXIXo oOoXoXO<? super SharedPreferences.Editor, oXIO0o0XI> oooxoxo) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        oooxoxo.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        oooxoxo.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
