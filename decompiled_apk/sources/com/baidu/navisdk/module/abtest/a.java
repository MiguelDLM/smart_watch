package com.baidu.navisdk.module.abtest;

import com.baidu.navisdk.module.abtest.model.c;
import com.baidu.navisdk.module.abtest.model.d;
import com.baidu.navisdk.module.abtest.model.e;
import com.baidu.navisdk.module.abtest.model.f;
import com.baidu.navisdk.module.abtest.model.g;
import com.baidu.navisdk.module.abtest.model.h;
import com.baidu.navisdk.module.abtest.model.i;
import com.baidu.navisdk.module.abtest.model.j;
import com.baidu.navisdk.module.abtest.model.k;

/* loaded from: classes7.dex */
public class a {
    public static j a(int i, com.baidu.navisdk.module.statistics.abtest.a aVar) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 7) {
                            if (i != 9) {
                                if (i != 16) {
                                    if (i != 13) {
                                        if (i != 14) {
                                            return new c(i, aVar);
                                        }
                                        return new com.baidu.navisdk.module.abtest.model.a(aVar);
                                    }
                                    return new g(aVar);
                                }
                                return new h(aVar);
                            }
                            return new com.baidu.navisdk.module.abtest.model.b(aVar);
                        }
                        return new e(aVar);
                    }
                    return new d(aVar);
                }
                return new k(aVar);
            }
            return new i(aVar);
        }
        return new f(aVar);
    }
}
