package xIx;

import Xo.I0Io;
import android.content.Context;
import com.tanx.exposer.AdMonitorInitResult;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.oIX0oI;
import java.util.List;

/* loaded from: classes13.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public Context f34301I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public oXO0oOx0.II0xO0 f34302II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public II0xO0 f34303oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public volatile boolean f34304oxoX;

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static volatile I0Io f34305oIX0oI = new I0Io(0);
    }

    public /* synthetic */ I0Io(byte b) {
        this();
    }

    public static I0Io I0Io() {
        return oIX0oI.f34305oIX0oI;
    }

    public oXO0oOx0.II0xO0 II0XooXoX() {
        return this.f34302II0xO0;
    }

    public AdMonitorCommitResult II0xO0(List<String> list, oxoX oxox) {
        return oIX0oI.C1083oIX0oI.f26505oIX0oI.oIX0oI(AdMonitorType.EXPOSE, list, oxox);
    }

    public AdMonitorCommitResult Oxx0IOOO(List<String> list, oxoX oxox) {
        return oIX0oI.C1083oIX0oI.f26505oIX0oI.oIX0oI(AdMonitorType.CLICK, list, oxox);
    }

    public Context X0o0xo() {
        return this.f34301I0Io;
    }

    public AdMonitorCommitResult XO(List<String> list, oxoX oxox) {
        return oIX0oI.C1083oIX0oI.f26505oIX0oI.oIX0oI(AdMonitorType.INTERACT_DEDUPLICATION, list, oxox);
    }

    public AdMonitorInitResult oIX0oI(Context context, II0xO0 iI0xO0) {
        try {
            if (iI0xO0 == null) {
                XOxoX.oIX0oI.oxoX("adMonitorInitError", "params is null");
                return AdMonitorInitResult.PARAMS_ERROR;
            }
            this.f34301I0Io = context.getApplicationContext();
            this.f34303oIX0oI = iI0xO0;
            this.f34302II0xO0 = new oXO0oOx0.II0xO0();
            XoOxI0ox.II0xO0.I0Io().oxoX(iI0xO0.xoIox());
            I0Io.X0o0xo.f4155oIX0oI.I0Io(context, this);
            this.f34304oxoX = true;
            return AdMonitorInitResult.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            XOxoX.oIX0oI.oxoX("adMonitorInitError", e.getMessage());
            return AdMonitorInitResult.INTERNAL_ERROR;
        }
    }

    public void oxoX(oXO0oOx0.oIX0oI oix0oi) {
        oXO0oOx0.II0xO0 iI0xO0 = this.f34302II0xO0;
        if (iI0xO0 != null) {
            iI0xO0.II0xO0(oix0oi);
        }
    }

    public II0xO0 xxIXOIIO() {
        return this.f34303oIX0oI;
    }

    public I0Io() {
    }
}
