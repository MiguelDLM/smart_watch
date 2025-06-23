package oOoXoXO;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class oIX0oI extends Paint {
    public oIX0oI() {
    }

    public oIX0oI(int i) {
        super(i);
    }

    public oIX0oI(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public oIX0oI(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }
}
