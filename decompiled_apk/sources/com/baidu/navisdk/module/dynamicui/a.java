package com.baidu.navisdk.module.dynamicui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.app.Activity;
import android.content.Context;
import com.baidu.baidumaps.mystique.MystiqueEngine;
import com.baidu.baidumaps.mystique.base.MystiqueCallback;
import com.baidu.baidumaps.mystique.base.log.MystiqueLogCallback;
import com.baidu.baidumaps.mystique.event.IClickHandler;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.dynamicui.dialog.c f7151a;
    private com.baidu.navisdk.module.dynamicui.bubble.c b;
    private boolean c;
    private a.InterfaceC0201a d;

    @OOXIXo
    public static final b f = new b(null);

    @OOXIXo
    private static final X0IIOO e = XIxXXX0x0.I0Io(LazyThreadSafetyMode.SYNCHRONIZED, C0240a.f7152a);

    /* renamed from: com.baidu.navisdk.module.dynamicui.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0240a extends Lambda implements oIX0oI<a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0240a f7152a = new C0240a();

        public C0240a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a(null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        @OOXIXo
        public final a a() {
            X0IIOO x0iioo = a.e;
            b bVar = a.f;
            return (a) x0iioo.getValue();
        }

        public /* synthetic */ b(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements IClickHandler {
        public c(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements IClickHandler {
        public d(a aVar, String str, String str2, String str3, com.baidu.navisdk.module.dynamicui.i.a aVar2) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements IClickHandler {
        public e(a aVar, String str, String str2) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements IClickHandler {
        public f(a aVar, String str, String str2, String str3, com.baidu.navisdk.module.dynamicui.i.a aVar2) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements MystiqueLogCallback {
        public g(String str, String str2) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements a.InterfaceC0201a {
        public h() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(@oOoXoXO Object obj) {
            if (obj instanceof com.baidu.navisdk.skyeye.event.f) {
                a.this.c = true;
                return;
            }
            if (obj instanceof com.baidu.navisdk.skyeye.event.g) {
                if (((com.baidu.navisdk.skyeye.event.g) obj).f8004a == 256) {
                    a.this.c = true;
                }
            } else if (obj instanceof com.baidu.navisdk.skyeye.event.b) {
                a.this.c = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements MystiqueCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f7154a;

        public i(a aVar, Activity activity, com.baidu.navisdk.module.dynamicui.bubble.b bVar) {
            this.f7154a = activity;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j implements MystiqueCallback {
        public j(a aVar, Context context, com.baidu.navisdk.module.dynamicui.dialog.b bVar) {
        }
    }

    private a() {
        this.d = new h();
    }

    private final void b(MystiqueEngine mystiqueEngine, String str, String str2) {
        if (mystiqueEngine == null) {
            return;
        }
        mystiqueEngine.registerClickHandler("close", new e(this, str, str2));
        for (Map.Entry<String, com.baidu.navisdk.module.dynamicui.i.a> entry : com.baidu.navisdk.module.dynamicui.b.b().a().entrySet()) {
            String key = entry.getKey();
            mystiqueEngine.registerClickHandler(key, new f(this, str, str2, key, entry.getValue()));
        }
    }

    private final void f() {
        com.baidu.navisdk.framework.message.a.a().a(this.d, com.baidu.navisdk.framework.message.bean.e.class, com.baidu.navisdk.skyeye.event.f.class, com.baidu.navisdk.skyeye.event.g.class, com.baidu.navisdk.skyeye.event.b.class);
    }

    public final boolean c() {
        com.baidu.navisdk.module.dynamicui.dialog.c cVar = this.f7151a;
        if (cVar != null) {
            return cVar.isShowing();
        }
        return false;
    }

    public final boolean d() {
        if (!c() && !b()) {
            return false;
        }
        return true;
    }

    public final boolean a(@OOXIXo Context context, @OOXIXo com.baidu.navisdk.module.dynamicui.dialog.b bVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
        if (gVar.d()) {
            gVar.e("DynamicUICreator", "showDialog, context = " + context + " model = " + bVar);
        }
        String a2 = com.baidu.navisdk.module.dynamicui.d.b().a(bVar.b(), bVar.c());
        MystiqueEngine with = MystiqueEngine.with(context);
        try {
            b(with, bVar.b(), bVar.c());
            f();
            with.inflate(new JSONObject(a2), -1, -1, new j(this, context, bVar), a(bVar.b(), bVar.c()));
            return true;
        } catch (JSONException e2) {
            com.baidu.navisdk.util.common.g.DYNA_DATA.c("DynamicUICreator", "show fail ,e = " + e2);
            return true;
        }
    }

    public /* synthetic */ a(IIXOooo iIXOooo) {
        this();
    }

    public final boolean b() {
        com.baidu.navisdk.module.dynamicui.bubble.c cVar = this.b;
        if (cVar == null) {
            return false;
        }
        cVar.a();
        throw null;
    }

    public final boolean a(@OOXIXo Activity activity, @OOXIXo com.baidu.navisdk.module.dynamicui.bubble.b bVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
        if (gVar.d()) {
            gVar.e("DynamicUICreator", "showBubble, context = " + activity + " model = " + bVar);
        }
        if (!bVar.a().a()) {
            return false;
        }
        String a2 = com.baidu.navisdk.module.dynamicui.d.b().a(bVar.b(), bVar.c());
        MystiqueEngine with = MystiqueEngine.with(activity);
        try {
            a(with, bVar.b(), bVar.c());
            f();
            with.inflate(new JSONObject(a2), ScreenUtil.getInstance().getWidthPixels(), a(), new i(this, activity, bVar), a(bVar.b(), bVar.c()));
            return true;
        } catch (JSONException e2) {
            com.baidu.navisdk.util.common.g.DYNA_DATA.c("DynamicUICreator", "show fail ,e = " + e2);
            e2.printStackTrace();
            return true;
        }
    }

    private final MystiqueLogCallback a(String str, String str2) {
        return new g(str, str2);
    }

    private final void a(MystiqueEngine mystiqueEngine, String str, String str2) {
        if (mystiqueEngine == null) {
            return;
        }
        mystiqueEngine.registerClickHandler("close", new c(this));
        for (Map.Entry<String, com.baidu.navisdk.module.dynamicui.i.a> entry : com.baidu.navisdk.module.dynamicui.b.b().a().entrySet()) {
            String key = entry.getKey();
            mystiqueEngine.registerClickHandler(key, new d(this, str, str2, key, entry.getValue()));
        }
    }

    public final int a() {
        return ScreenUtil.getInstance().getAbsoluteHeight() - ScreenUtil.getInstance().getStatusBarHeightFullScreen(com.baidu.navisdk.framework.a.c().b());
    }
}
