package com.octopus.ad.internal;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import x0.x0o;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public class OOXIXo extends oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public x0OxxIOxX.II0xO0 f18609I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public I0Io f18610oxoX = new I0Io(xoIox.oIX0oI().x0xO0oo(), x0o.X0o0xo());

    @Override // com.octopus.ad.internal.oOoXoXO
    public void II0xO0() {
        x0OxxIOxX.II0xO0 iI0xO0 = this.f18609I0Io;
        if (iI0xO0 != null) {
            iI0xO0.cancel(true);
            this.f18609I0Io = null;
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a() {
        this.f18609I0Io = new x0OxxIOxX.II0xO0(new II0xO0.C1145II0xO0());
        I0Io();
        try {
            this.f18609I0Io.Oxx0IOOO(this);
            this.f18609I0Io.executeOnExecutor(o0IXXIx.xoIox.II0xO0().I0Io(), new Void[0]);
        } catch (IllegalStateException e) {
            Log.d("octopus", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public I0Io b() {
        return this.f18610oxoX;
    }

    @Override // com.octopus.ad.internal.oxoX
    public void oIX0oI(x0OxxIOxX.oIX0oI oix0oi) {
        Iterator<String> it = oix0oi.IO().iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Prefetch resource: " + next);
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a(int i) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18692Oxx0IOOO, "Failed to load prefetch request: " + i);
    }
}
