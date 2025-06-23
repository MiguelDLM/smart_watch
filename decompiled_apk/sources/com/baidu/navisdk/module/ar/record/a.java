package com.baidu.navisdk.module.ar.record;

import OXOo.OOXIXo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private b f6992a;
    private boolean b;

    @OOXIXo
    private com.baidu.navisdk.module.ar.d c;

    public a(@OOXIXo com.baidu.navisdk.module.ar.d mContext) {
        IIX0o.x0xO0oo(mContext, "mContext");
        this.c = mContext;
    }

    public final void a() {
        File externalFilesDir;
        if (this.b || (externalFilesDir = this.c.a().getExternalFilesDir("ArVideo")) == null) {
            return;
        }
        File file = new File(externalFilesDir.getPath() + File.separator + "VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4");
        a(file);
        b bVar = new b(file.getPath());
        this.f6992a = bVar;
        bVar.a(this.c.f(), this.c.e(), this.c.b());
        this.b = true;
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            b bVar = this.f6992a;
            if (bVar == null) {
                IIX0o.XOxIOxOx("mMediaMuxer");
            }
            bVar.a();
        }
    }

    public final void a(@OOXIXo byte[] data, int i, int i2, int i3) {
        IIX0o.x0xO0oo(data, "data");
        if (!this.b || this.f6992a == null) {
            return;
        }
        System.arraycopy(data, 0, new byte[data.length], 0, data.length);
        b bVar = this.f6992a;
        if (bVar == null) {
            IIX0o.XOxIOxOx("mMediaMuxer");
        }
        bVar.a(data, i, i2, i3);
    }

    private final void a(File file) {
        if (file == null || file.getParentFile().exists()) {
            return;
        }
        file.getParentFile().mkdirs();
    }
}
