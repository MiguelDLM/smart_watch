package com.baidu.navisdk.module.newguide.recommendvoice;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.voicesquare.interfaces.RequestCallback;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b implements com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<c> f7221a;
    private ArrayList<c> b;
    private boolean c;
    private int d;

    @OOXIXo
    public static final a f = new a(null);

    @OOXIXo
    private static final c e = new c("个性语音包", R.drawable.bn_ic_short_fun_guide_voice);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @OOXIXo
        public final c a() {
            return b.e;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.recommendvoice.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0249b {
    }

    /* loaded from: classes7.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private String f7222a;

        @oOoXoXO
        private String b;

        @DrawableRes
        private int c;
        private int d;

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(IIXOooo iIXOooo) {
                this();
            }
        }

        static {
            new a(null);
        }

        public c() {
        }

        public final int a() {
            return this.c;
        }

        @oOoXoXO
        public final String b() {
            return this.b;
        }

        @oOoXoXO
        public final String c() {
            return this.f7222a;
        }

        public final int d() {
            return this.d;
        }

        @OOXIXo
        public String toString() {
            return "PlayVoiceBean(name=" + this.f7222a + ", imageUrl=" + this.b + ", imageId=" + this.c + HexStringBuilder.COMMENT_END_CHAR;
        }

        public c(@oOoXoXO String str, int i) {
            this.f7222a = str;
            this.c = i;
            this.b = null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements RequestCallback {
        public d(b bVar) {
        }
    }

    private final void f() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("clearAllData");
        }
        ArrayList<c> arrayList = this.f7221a;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            arrayList.clear();
        }
        ArrayList<c> arrayList2 = this.b;
        if (arrayList2 != null) {
            IIX0o.ooOOo0oXI(arrayList2);
            arrayList2.clear();
        }
    }

    private final void g() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("generateShowTopicVoiceList");
        }
        this.d = 0;
        ArrayList<c> arrayList = this.f7221a;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<c> arrayList2 = this.f7221a;
                IIX0o.ooOOo0oXI(arrayList2);
                int size = arrayList2.size();
                ArrayList<c> arrayList3 = this.b;
                if (arrayList3 == null) {
                    this.b = new ArrayList<>((size / 2) + size);
                } else {
                    IIX0o.ooOOo0oXI(arrayList3);
                    arrayList3.clear();
                }
                if (size == 1) {
                    ArrayList<c> arrayList4 = this.b;
                    IIX0o.ooOOo0oXI(arrayList4);
                    ArrayList<c> arrayList5 = this.f7221a;
                    IIX0o.ooOOo0oXI(arrayList5);
                    arrayList4.add(arrayList5.get(0));
                    ArrayList<c> arrayList6 = this.b;
                    IIX0o.ooOOo0oXI(arrayList6);
                    arrayList6.add(e);
                    return;
                }
                ArrayList<c> arrayList7 = this.f7221a;
                IIX0o.ooOOo0oXI(arrayList7);
                Collections.shuffle(arrayList7);
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        try {
                            if (i % 2 == 0) {
                                ArrayList<c> arrayList8 = this.b;
                                IIX0o.ooOOo0oXI(arrayList8);
                                arrayList8.add(e);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    ArrayList<c> arrayList9 = this.b;
                    IIX0o.ooOOo0oXI(arrayList9);
                    ArrayList<c> arrayList10 = this.f7221a;
                    IIX0o.ooOOo0oXI(arrayList10);
                    arrayList9.add(arrayList10.get(i));
                }
                return;
            }
        }
        f();
    }

    private final void h() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RecommendVoicePlay", "isTopicLoading:" + this.c);
        }
        if (this.c) {
            return;
        }
        this.c = true;
        VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o == null) {
            return;
        }
        o.requestRecommend(new d(this));
    }

    public final void a(@OOXIXo InterfaceC0249b callback) {
        IIX0o.x0xO0oo(callback, "callback");
        h();
    }

    @oOoXoXO
    public final c b() {
        String str;
        int i = this.d;
        ArrayList<c> arrayList = this.b;
        IIX0o.ooOOo0oXI(arrayList);
        if (i >= arrayList.size()) {
            g();
            this.d = 0;
        }
        ArrayList<c> arrayList2 = this.b;
        IIX0o.ooOOo0oXI(arrayList2);
        c cVar = arrayList2.get(this.d);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("next：");
            sb.append(this.d);
            sb.append(", ");
            if (cVar != null) {
                str = cVar.c();
            } else {
                str = null;
            }
            sb.append(str);
            gVar.e(sb.toString());
        }
        this.d++;
        return cVar;
    }

    public final int c() {
        ArrayList<c> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final boolean d() {
        ArrayList<c> arrayList = this.b;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        this.d = 0;
        f();
    }

    public final boolean a() {
        ArrayList<c> arrayList = this.b;
        if (arrayList != null) {
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
