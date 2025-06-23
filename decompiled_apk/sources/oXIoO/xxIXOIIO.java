package oXIoO;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.octopus.ad.utils.a.e;
import java.util.Objects;

/* loaded from: classes11.dex */
public class xxIXOIIO implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32144oIX0oI;

    public xxIXOIIO(Context context) {
        this.f32144oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32144oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
            return false;
        }
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32144oIX0oI != null && i0Io != null) {
            try {
                Cursor query = this.f32144oIX0oI.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
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
