package IOOoXo0Ix;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* loaded from: classes13.dex */
public class xoIox implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f600oIX0oI;

    public xoIox(Context context) {
        this.f600oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f600oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
            return false;
        }
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f600oIX0oI != null && xo2 != null) {
            try {
                Cursor query = this.f600oIX0oI.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                try {
                    Objects.requireNonNull(query);
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("value"));
                    if (string != null && string.length() != 0) {
                        xo.xxIXOIIO.II0xO0("OAID query success: " + string);
                        xo2.oaidSucc(string);
                        query.close();
                        return;
                    }
                    throw new OAIDException("OAID query failed");
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception e) {
                xo.xxIXOIIO.II0xO0(e);
                xo2.oaidError(e);
            }
        }
    }
}
