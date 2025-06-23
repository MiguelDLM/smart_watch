package com.baidu.navisdk.ugc.utils;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.ugc.f;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static com.baidu.navisdk.ugc.e f8336a;
    public static com.baidu.navisdk.ugc.f b;

    @OOXIXo
    public static final f c = new f();

    private f() {
    }

    public final void a(@OOXIXo com.baidu.navisdk.ugc.e eVar) {
        IIX0o.x0xO0oo(eVar, "<set-?>");
        f8336a = eVar;
    }

    @OOXIXo
    public final com.baidu.navisdk.model.datastruct.g b() {
        com.baidu.navisdk.ugc.e eVar = f8336a;
        if (eVar == null) {
            IIX0o.XOxIOxOx("ugcLocationProxyImpl");
        }
        return eVar.b();
    }

    public final void a(@OOXIXo com.baidu.navisdk.ugc.f fVar) {
        IIX0o.x0xO0oo(fVar, "<set-?>");
        b = fVar;
    }

    @OOXIXo
    public final com.baidu.navisdk.model.datastruct.g a() {
        com.baidu.navisdk.ugc.e eVar = f8336a;
        if (eVar == null) {
            IIX0o.XOxIOxOx("ugcLocationProxyImpl");
        }
        return eVar.a();
    }

    public final void a(@OOXIXo String path, @OOXIXo ImageView imageView, boolean z) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(imageView, "imageView");
        com.baidu.navisdk.ugc.f fVar = b;
        if (fVar == null) {
            IIX0o.XOxIOxOx("ugcScreenShot");
        }
        fVar.a(path, imageView, z);
    }

    public final void a(@OOXIXo ArrayList<View> needCaptureViews, int i, @OOXIXo f.a callback) {
        IIX0o.x0xO0oo(needCaptureViews, "needCaptureViews");
        IIX0o.x0xO0oo(callback, "callback");
        com.baidu.navisdk.ugc.f fVar = b;
        if (fVar == null) {
            IIX0o.XOxIOxOx("ugcScreenShot");
        }
        fVar.a(needCaptureViews, i, callback);
    }
}
