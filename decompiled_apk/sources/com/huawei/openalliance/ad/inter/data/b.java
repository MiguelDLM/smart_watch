package com.huawei.openalliance.ad.inter.data;

import com.baidu.navisdk.util.common.ScreenUtil;
import com.huawei.openalliance.ad.constant.ah;

/* loaded from: classes10.dex */
public final class b {
    private int C;
    private int D;
    private int F;
    private int S;
    public static final b Code = new b(ScreenUtil.DEFAULT_WIDTH, 170);
    public static final b V = new b(ScreenUtil.DEFAULT_WIDTH, ah.s);
    public static final b B = new b(960, 150);

    public b(int i, int i2) {
        this.C = i;
        this.S = i2;
        this.F = i;
        this.D = i2;
    }

    public int Code() {
        return this.C;
    }

    public int I() {
        return this.F;
    }

    public int V() {
        return this.S;
    }

    public int Z() {
        return this.D;
    }

    public b(int i, int i2, int i3, int i4) {
        this.C = i;
        this.S = i2;
        this.F = i3;
        this.D = i4;
    }
}
