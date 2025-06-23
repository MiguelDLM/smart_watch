package com.baidu.navisdk.b4nav.service.load;

import com.baidu.navisdk.b4nav.a;
import com.baidu.navisdk.b4nav.b;
import com.baidu.navisdk.b4nav.c;
import com.baidu.navisdk.b4nav.framework.service.CoreService;

/* loaded from: classes7.dex */
public class LoadDataService extends CoreService {
    protected b l;
    protected a m;

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        this.l = ((c) this.i).q();
        this.m = (a) ((c) this.i).a(a.class);
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        this.l = null;
        this.m = null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        this.l.d();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.service.CoreService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "LoadDataService";
    }
}
