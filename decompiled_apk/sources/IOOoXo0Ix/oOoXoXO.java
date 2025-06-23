package IOOoXo0Ix;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tanx.onlyid.api.OAIDException;

/* loaded from: classes13.dex */
public class oOoXoXO implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f593oIX0oI;

    public oOoXoXO(Context context) {
        this.f593oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean II0xO0() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f593oIX0oI != null && xo2 != null) {
            if (!II0xO0()) {
                xo.xxIXOIIO.II0xO0("Only supports Android 10.0 and above for Nubia");
                xo2.oaidError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
                return;
            }
            try {
                ContentProviderClient acquireContentProviderClient = this.f593oIX0oI.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                if (acquireContentProviderClient == null) {
                    return;
                }
                String str = null;
                Bundle call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.release();
                } else {
                    acquireContentProviderClient.release();
                }
                if (call != null) {
                    if (call.getInt("code", -1) == 0) {
                        str = call.getString("id");
                    }
                    if (str != null && str.length() != 0) {
                        xo.xxIXOIIO.II0xO0("OAID query success: " + str);
                        xo2.oaidSucc(str);
                        return;
                    }
                    throw new OAIDException("OAID query failed: " + call.getString("message"));
                }
                throw new OAIDException("OAID query failed: bundle is null");
            } catch (Exception e) {
                xo.xxIXOIIO.II0xO0(e);
                xo2.oaidError(e);
            }
        }
    }
}
