package com.baidu.navisdk.b4nav.func.idss;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.jni.nativeif.JNIIdssControl;

/* loaded from: classes7.dex */
public class IdssFunc extends CoreFunc<Object> {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.b4nav.service.rpmsg.b {
        public c() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public int a(int i) {
            return 1;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.b4nav.service.rpmsg.b {
        public d() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public int a(int i) {
            return 1;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.b4nav.service.rpmsg.b {
        public e() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public int a(int i) {
            return 1;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.b4nav.service.rpmsg.b {
        public f() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public int a(int i) {
            return 1;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.b
        public String a() {
            return ((Func) IdssFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1000, new a());
        a(1013, new b());
        a(4001, new c());
        a(1002, new d());
        a(1014, new e());
        a(4007, new f());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        this.k.j();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "IdssFunc";
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        if (com.baidu.navisdk.module.init.a.a()) {
            JNIIdssControl.getInstance().unRegisterCallback(0);
        }
    }
}
