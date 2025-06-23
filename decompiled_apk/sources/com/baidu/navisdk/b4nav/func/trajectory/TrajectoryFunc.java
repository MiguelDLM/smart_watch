package com.baidu.navisdk.b4nav.func.trajectory;

import com.baidu.navisdk.b4nav.c;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.framework.repository.a;
import com.baidu.navisdk.comapi.trajectory.j;

/* loaded from: classes7.dex */
public class TrajectoryFunc extends CoreFunc<a> {
    private j r() {
        int o = ((c) this.i).o();
        if (o != 1) {
            if (o != 2) {
                if (o != 3) {
                    return j.TRAJECTORY_FROM_ROUTE_CAR;
                }
                return j.TRAJECTORY_FROM_TRUCK_ROUTE;
            }
            return j.TRAJECTORY_FROM_MOTOR_ROUTE;
        }
        return j.TRAJECTORY_FROM_ROUTE_CAR;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        com.baidu.navisdk.comapi.trajectory.c.c().b().a(r());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        com.baidu.navisdk.comapi.trajectory.c.c().b().e().a(true);
        com.baidu.navisdk.comapi.trajectory.c.c().b().e().b(false);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "TrajectoryFunc";
    }
}
