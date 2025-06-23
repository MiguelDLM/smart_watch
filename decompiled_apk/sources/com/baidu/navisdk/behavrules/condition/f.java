package com.baidu.navisdk.behavrules.condition;

/* loaded from: classes7.dex */
public abstract class f extends a implements m {
    private boolean c;

    public f(com.baidu.navisdk.behavrules.scene.c cVar) {
        super(cVar);
        this.c = false;
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void b() {
        if (!this.c) {
            return;
        }
        p();
        this.c = false;
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void c() {
        if (this.c) {
            return;
        }
        o();
        this.c = true;
    }

    public abstract void o();

    public abstract void p();
}
