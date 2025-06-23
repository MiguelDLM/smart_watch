package oXIoO;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.octopus.ad.utils.a.e;

/* loaded from: classes11.dex */
public class OOXIXo implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32121oIX0oI;

    public OOXIXo(Context context) {
        this.f32121oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32121oIX0oI != null && i0Io != null) {
            if (!a()) {
                oXxOI0oIx.X0o0xo.oIX0oI("Only supports Android 10.0 and above for Nubia");
                i0Io.a(new e("Only supports Android 10.0 and above for Nubia"));
                return;
            }
            try {
                ContentProviderClient acquireContentProviderClient = this.f32121oIX0oI.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
                        oXxOI0oIx.X0o0xo.oIX0oI("OAID query success: " + str);
                        i0Io.a(str);
                        return;
                    }
                    throw new e("OAID query failed: " + call.getString("message"));
                }
                throw new e("OAID query failed: bundle is null");
            } catch (Exception e) {
                oXxOI0oIx.X0o0xo.oIX0oI(e);
                i0Io.a(e);
            }
        }
    }
}
