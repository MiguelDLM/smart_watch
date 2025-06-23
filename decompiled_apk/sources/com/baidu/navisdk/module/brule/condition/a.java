package com.baidu.navisdk.module.brule.condition;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.condition.h;
import com.baidu.navisdk.behavrules.condition.j;
import com.baidu.navisdk.behavrules.condition.k;
import com.baidu.navisdk.behavrules.scene.c;

/* loaded from: classes7.dex */
public class a implements k {
    @Override // com.baidu.navisdk.behavrules.condition.k
    public j a(String str, c cVar) {
        if (TextUtils.equals(str, "0")) {
            str = "common_type";
        }
        if (TextUtils.equals(str, "1")) {
            str = "click_type";
        }
        return new h(cVar, str);
    }
}
