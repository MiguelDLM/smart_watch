package com.baidu.navisdk.module.brule.matchpage;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.behavrules.condition.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class d implements o {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, n> f7050a = new HashMap();

    @Override // com.baidu.navisdk.behavrules.condition.o
    public void a(n nVar) {
        this.f7050a.put(nVar.e(), nVar);
    }

    @Override // com.baidu.navisdk.behavrules.condition.o
    public com.baidu.navisdk.behavrules.d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("&");
        for (String str2 : split) {
            arrayList.addAll(Arrays.asList(str2.split("\\|")));
        }
        for (String str3 : split) {
            boolean z = false;
            for (String str4 : str3.split("\\|")) {
                n nVar = this.f7050a.get(str4);
                if (nVar != null && nVar.a(arrayList) == com.baidu.navisdk.behavrules.d.SUCCESS) {
                    z = true;
                }
            }
            if (!z) {
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }
}
