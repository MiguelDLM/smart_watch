package oXIoO;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.octopus.ad.utils.a.e;
import java.util.Objects;

/* loaded from: classes11.dex */
public class x0xO0oo implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32141oIX0oI;

    public x0xO0oo(Context context) {
        this.f32141oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return oXxOI0oIx.XO.oIX0oI("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32141oIX0oI != null && i0Io != null) {
            try {
                Cursor query = this.f32141oIX0oI.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                try {
                    Objects.requireNonNull(query);
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("value"));
                    if (string != null && string.length() != 0) {
                        oXxOI0oIx.X0o0xo.oIX0oI("OAID query success: " + string);
                        i0Io.a(string);
                        query.close();
                        return;
                    }
                    throw new e("OAID query failed");
                } finally {
                }
            } catch (Exception e) {
                oXxOI0oIx.X0o0xo.oIX0oI(e);
                i0Io.a(e);
            }
        }
    }
}
