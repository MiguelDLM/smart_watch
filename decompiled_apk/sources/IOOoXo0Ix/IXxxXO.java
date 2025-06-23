package IOOoXo0Ix;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* loaded from: classes13.dex */
public class IXxxXO implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f561oIX0oI;

    public IXxxXO(Context context) {
        this.f561oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return xo.xoIox.oI0IIXIo("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f561oIX0oI != null && xo2 != null) {
            try {
                Cursor query = this.f561oIX0oI.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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
