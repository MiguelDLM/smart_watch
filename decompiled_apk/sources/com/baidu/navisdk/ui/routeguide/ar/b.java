package com.baidu.navisdk.ui.routeguide.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.navisdk.ui.routeguide.model.a0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8453a;
    private final com.baidu.navisdk.comapi.geolocate.b b;
    private final com.baidu.navisdk.comapi.routeguide.g c;
    private final C0416b d;

    @OOXIXo
    private final com.baidu.navisdk.module.ar.e e;

    /* loaded from: classes8.dex */
    public static final class a implements com.baidu.navisdk.comapi.geolocate.b {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(@oOoXoXO com.baidu.navisdk.model.datastruct.g gVar) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(@oOoXoXO com.baidu.navisdk.model.datastruct.g gVar, @oOoXoXO com.baidu.navisdk.model.datastruct.g gVar2) {
            if (gVar != null) {
                b.this.a().a(gVar.b, gVar.f6926a, gVar.c * 3.6f);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.ar.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0416b extends com.baidu.navisdk.module.ar.msg.a {
        @Override // com.baidu.navisdk.module.ar.msg.a
        public void a(@OOXIXo Message msg) {
            IIX0o.x0xO0oo(msg, "msg");
            Object obj = msg.obj;
            if (obj != null) {
                TTSPlayerControl.playTTS((String) obj, 0);
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.2", String.valueOf(msg.arg1));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends com.baidu.navisdk.ui.routeguide.ar.c {
        public c() {
        }

        @Override // com.baidu.navisdk.comapi.routeguide.g
        public void H(@oOoXoXO Message message) {
        }

        @Override // com.baidu.navisdk.comapi.routeguide.g
        public void a0(@oOoXoXO Message message) {
            Integer num;
            if (message != null) {
                num = Integer.valueOf(message.what);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 4388) {
                d();
            } else if (num != null && num.intValue() == 4389) {
                c();
            }
        }

        public final void c() {
            b.this.a().a(new boolean[0]);
        }

        public final void d() {
            RGLineItem[] itemArray = BNRouteGuider.getInstance().getLaneInfo(new RGLaneInfoModel());
            boolean[] zArr = new boolean[itemArray.length];
            IIX0o.oO(itemArray, "itemArray");
            int length = itemArray.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                zArr[i2] = itemArray[i].bVailable;
                i++;
                i2++;
            }
            b.this.a().a(zArr);
        }

        @Override // com.baidu.navisdk.comapi.routeguide.g
        public void v(@oOoXoXO Message message) {
            Object obj;
            if (message != null) {
                obj = message.obj;
            } else {
                obj = null;
            }
            if (obj != null) {
                Bundle bundle = (Bundle) obj;
                int i = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind);
                int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
                a0 I = a0.I();
                IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
                b.this.a().a(i, i2, I.c());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }
    }

    public b(@OOXIXo com.baidu.navisdk.module.ar.e mArManager) {
        IIX0o.x0xO0oo(mArManager, "mArManager");
        this.e = mArManager;
        this.b = new a();
        this.c = new c();
        this.d = new C0416b();
    }

    @OOXIXo
    public final com.baidu.navisdk.module.ar.e a() {
        return this.e;
    }

    public final void b() {
        if (this.f8453a) {
            return;
        }
        BNRouteGuider.getInstance().addRGInfoListeners(this.c);
        com.baidu.navisdk.util.logic.c.k().a(this.b);
        this.e.a().a(this.d);
        this.f8453a = true;
    }

    public final void c() {
        if (!this.f8453a) {
            return;
        }
        this.f8453a = false;
        BNRouteGuider.getInstance().removeRGInfoListeners(this.c);
        com.baidu.navisdk.util.logic.c.k().b(this.b);
        this.e.a().b(this.d);
    }
}
