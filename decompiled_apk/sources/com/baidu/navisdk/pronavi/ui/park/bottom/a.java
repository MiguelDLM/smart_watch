package com.baidu.navisdk.pronavi.ui.park.bottom;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.navisdk.h;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.f;
import com.baidu.nplatform.comapi.MapItem;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.oxoX;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final a f7950a = new a();

    /* renamed from: com.baidu.navisdk.pronavi.ui.park.bottom.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0357a {

        /* renamed from: com.baidu.navisdk.pronavi.ui.park.bottom.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0358a {
            public static void a(@OOXIXo InterfaceC0357a interfaceC0357a, int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            }
        }

        void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th);

        void onStart();

        void onSuccess();
    }

    private a() {
    }

    public final void a(@oOoXoXO com.baidu.navisdk.module.park.a aVar, @oOoXoXO InterfaceC0357a interfaceC0357a) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSaveParkRequestService", "addUserParkRecord->data:" + aVar);
        }
        if (aVar == null) {
            return;
        }
        if (interfaceC0357a != null) {
            interfaceC0357a.onStart();
        }
        HashMap<String, String> a2 = a(aVar);
        if (gVar.d()) {
            gVar.e("BNSaveParkRequestService", "addUserParkRecord->params:" + a2);
        }
        String b2 = com.baidu.navisdk.util.http.b.d().b("AddParkRecord");
        if (gVar.d()) {
            gVar.e("BNSaveParkRequestService", "addUserParkRecord->url:" + b2);
        }
        com.baidu.navisdk.util.http.center.b.a().a(b2, a2, new b(interfaceC0357a), null);
    }

    /* loaded from: classes7.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0357a f7951a;

        public b(InterfaceC0357a interfaceC0357a) {
            this.f7951a = interfaceC0357a;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNSaveParkRequestService", "addUserParkRecord->onFailure ,statusCode = " + i + ", responseString = " + str + ", throwable = " + th);
            }
            InterfaceC0357a interfaceC0357a = this.f7951a;
            if (interfaceC0357a != null) {
                interfaceC0357a.a(i, str, th);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNSaveParkRequestService", "addUserParkRecord-> onSuccess! responseString = " + str);
            }
            a.f7950a.a(i, str, this.f7951a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, String str, InterfaceC0357a interfaceC0357a) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0357a != null) {
                interfaceC0357a.a(i, str, null);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("errno") == 0) {
                if (jSONObject.getBoolean("data")) {
                    if (interfaceC0357a != null) {
                        interfaceC0357a.onSuccess();
                    }
                } else if (interfaceC0357a != null) {
                    interfaceC0357a.a(i, str, null);
                }
            } else if (interfaceC0357a != null) {
                interfaceC0357a.a(i, str, null);
            }
        } catch (Exception e) {
            g gVar = g.PRO_NAV;
            if (gVar.c()) {
                e.printStackTrace();
                gVar.c("BNSaveParkRequestService", "handleAddParkRecordResponse-> exception! e = " + e);
            }
        }
    }

    private final HashMap<String, String> a(com.baidu.navisdk.module.park.a aVar) {
        HashMap<String, String> params = com.baidu.navisdk.util.http.a.a();
        if (aVar != null) {
            IIX0o.oO(params, "params");
            params.put("park_lng", String.valueOf(aVar.k()));
            params.put("park_lat", String.valueOf(aVar.i()));
            params.put("park_name", aVar.a());
            params.put("park_uid", aVar.b());
            params.put("park_lot", aVar.c());
            params.put("carport_uid", aVar.d());
            if (!TextUtils.isEmpty(aVar.h())) {
                params.put("floor", aVar.h());
            }
            if (!TextUtils.isEmpty(aVar.g())) {
                params.put("building_id", aVar.g());
            }
        }
        String carNo = h.a(false);
        if (!TextUtils.isEmpty(carNo)) {
            IIX0o.oO(carNo, "carNo");
            Charset charset = oxoX.f29581II0xO0;
            if (carNo != null) {
                byte[] bytes = carNo.getBytes(charset);
                IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 0);
                IIX0o.oO(params, "params");
                params.put("car_no", encodeToString);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        IIX0o.oO(params, "params");
        params.put("cuid", a0.e());
        params.put(TypedValues.TransitionType.S_FROM, MapItem.KEY_IS_MAP_ITEM);
        return params;
    }
}
