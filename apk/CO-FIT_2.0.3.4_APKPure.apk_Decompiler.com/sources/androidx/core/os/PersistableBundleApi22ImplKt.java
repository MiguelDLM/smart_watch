package androidx.core.os;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
final class PersistableBundleApi22ImplKt {
    @OOXIXo
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @DoNotInline
    @x0XOIxOo
    public static final void putBoolean(@OOXIXo PersistableBundle persistableBundle, @oOoXoXO String str, boolean z) {
        persistableBundle.putBoolean(str, z);
    }

    @DoNotInline
    @x0XOIxOo
    public static final void putBooleanArray(@OOXIXo PersistableBundle persistableBundle, @oOoXoXO String str, @OOXIXo boolean[] zArr) {
        persistableBundle.putBooleanArray(str, zArr);
    }
}
