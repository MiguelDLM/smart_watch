package com.baidu.navisdk.module.brule.matchpage;

import com.baidu.navisdk.behavrules.condition.n;
import java.util.List;

/* loaded from: classes7.dex */
public class e {

    /* loaded from: classes7.dex */
    public static class b implements n {
        private b() {
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public com.baidu.navisdk.behavrules.d a(List<String> list) {
            if (com.baidu.navisdk.module.vehiclemanager.b.i().e()) {
                return com.baidu.navisdk.behavrules.d.SUCCESS;
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public String e() {
            return "car";
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements n {
        private c() {
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public com.baidu.navisdk.behavrules.d a(List<String> list) {
            if (com.baidu.navisdk.module.vehiclemanager.b.i().d()) {
                return com.baidu.navisdk.behavrules.d.SUCCESS;
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public String e() {
            return "motor";
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements n {
        private d() {
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public com.baidu.navisdk.behavrules.d a(List<String> list) {
            if (com.baidu.navisdk.module.vehiclemanager.b.i().g()) {
                return com.baidu.navisdk.behavrules.d.SUCCESS;
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public String e() {
            return "newEng";
        }
    }

    /* renamed from: com.baidu.navisdk.module.brule.matchpage.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0229e implements n {
        private C0229e() {
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public com.baidu.navisdk.behavrules.d a(List<String> list) {
            if (com.baidu.navisdk.module.vehiclemanager.b.i().h()) {
                return com.baidu.navisdk.behavrules.d.SUCCESS;
            }
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }

        @Override // com.baidu.navisdk.behavrules.condition.n
        public String e() {
            return "truck";
        }
    }

    public static n a() {
        return new b();
    }

    public static n b() {
        return new c();
    }

    public static n c() {
        return new d();
    }

    public static n d() {
        return new C0229e();
    }
}
