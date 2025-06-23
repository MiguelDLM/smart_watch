package com.baidu.navisdk.adapter.impl.locallimit.car;

import com.baidu.navisdk.adapter.impl.locallimit.d;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends d {
    public b() {
        super("NavCarLocalLimitModel");
    }

    @Override // com.baidu.navisdk.adapter.impl.locallimit.d
    public void a(int i, List<l> list) {
        if (i != 0 && i != 1) {
            if (i == 2 || i == 3) {
                list.add(new i("vehicle_type", Integer.toString(1)));
                list.add(new i("car_type", "0"));
                return;
            }
            return;
        }
        list.add(new i("vehicle_type", Integer.toString(1)));
    }
}
